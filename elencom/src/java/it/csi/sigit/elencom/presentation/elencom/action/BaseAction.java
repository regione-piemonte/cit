package it.csi.sigit.elencom.presentation.elencom.action;

import java.util.*;
import java.lang.reflect.Method;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

import org.apache.log4j.Logger;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import it.csi.sigit.elencom.util.*;
import it.csi.sigit.elencom.dto.*;
import it.csi.sigit.elencom.business.*;

import it.csi.sigit.elencom.presentation.elencom.security.*;

import it.csi.sigit.elencom.presentation.elencom.interceptor.FatClientOnly;
import it.csi.sigit.elencom.presentation.uiutils.*;
import flexjson.JSON;

/**
 * Base Action che contiene gli elementi comuni all'applicazione.
 * Tutte le altre Action dell'applicazione dovranno ereditare da questa
 * in modo da ottenere le parti comuni, e dovranno implementare in proprio
 * le funzionalit&agrave; specifiche della pagina.
 * <p/>
 * La classe eredita da {@link com.opensymphony.xwork2.ActionSupport} i
 * metodi di utilit&agrave; necessari ad eseguire le principali operazioni
 * (ad esempio conversione, validazione, ecc...) ed implementa l'interfaccia
 * {@link org.apache.struts2.interceptor.SessionAware}, che permette
 * alla Action di accedere alla sessione. 
 * 
 * @author GuiGen
 */
public abstract class BaseAction<T extends BaseSessionAwareDTO> extends ActionSupport
		implements
			SessionAware,
			Preparable {

	/**  */
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".presentation");

	/** 
	 * Riferimento alla sessione corrente
	 */
	protected Map session;

	/** 
	 * Riferimento alla sessione corrente
	 */
	public void setSession(Map session) {
		this.session = session;
	}

	/** 
	 * Riferimento alla sessione corrente
	 */
	public Map getSession() {
		return this.session;
	}

	/**
	 * backActionName
	 */
	private String backActionName;

	/**
	 * backNamespace
	 */
	private String backNamespace;

	/**
	 * backActionName
	 */
	public void setBackActionName(String value) {
		this.backActionName = value;
	}

	/**
	 * backActionName
	 */
	public String getBackActionName() {
		return this.backActionName;
	}

	/**
	 * backNamespace
	 */
	public void setBackNamespace(String value) {
		this.backNamespace = value;
	}

	/**
	 * backNamespace
	 */
	public String getBackNamespace() {
		return this.backNamespace;
	}

	/**
	 * stack di navigazione utilizzato dal JumpBackCommand
	 */
	public void setAppDataNavigationQueue(java.util.LinkedList<java.lang.String> value) {
		getSession().put("appDataNavigationQueue", value);
	}

	/**
	 * stack di navigazione utilizzato dal JumpBackCommand
	 */
	public java.util.LinkedList<java.lang.String> getAppDataNavigationQueue() {
		return (java.util.LinkedList<java.lang.String>) (getSession().get("appDataNavigationQueue"));
	}

	/**
	 * nome del content panel corrente
	 */
	public void setCurrentContentPanel(java.lang.String value) {
		getSession().put("currentContentPanel", value);
	}

	/**
	 * nome del content panel corrente
	 */
	public java.lang.String getCurrentContentPanel() {
		return (java.lang.String) (getSession().get("currentContentPanel"));
	}

	/**
	 * metodo di preparazioen della action.
	 */
	public void prepare() throws CommandExecutionException {

		// NOP
	}

	////////////////////////////////////////////////////////////////////////
	//// costruzione/lettura strato model da passare allo strato di logica
	////////////////////////////////////////////////////////////////////////

	/**
	 * la classe del modello del content panel
	 */
	public abstract Class modelClass();

	/**
	 * il modello del content panel
	 */
	public abstract T getModel();

	/**
	 * il modello del content panel
	 */
	public abstract void setModel(T t);

	/**
	 * prepara il modello del content panel per passarlo alla business logic
	 */
	public T toModel() {
		return getModel();
	}

	/**
	 * incorpora nella action il modello del content panel ricevuto
	 * a fronte dell'esecuzione della business logic
	 */
	public void fromModel(T t) {
		setModel(t);
	}

	/**
	 * metodo di utilita' per effettuare introspection.
	 * @param pName nome della property
	 * @param cl classe in cui cercare
	 */
	protected java.lang.reflect.Method findReadMethod(String pName, Class cl) throws IntrospectionException {
		String name = (pName.startsWith("get") || pName.startsWith("set")
				? pName.substring(3)
				: pName.startsWith("is") ? pName.substring(2) : pName);
		BeanInfo bi = java.beans.Introspector.getBeanInfo(cl);
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		for (int i = 0; i < pds.length; i++) {
			PropertyDescriptor currPd = pds[i];
			if (currPd.getName().equalsIgnoreCase(name))
				return currPd.getReadMethod();
		}
		return null;
	}

	/**
	 * metodo di utilita' per effettuare introspection.
	 * @param pName nome della property
	 * @param cl classe in cui cercare
	 */
	protected java.lang.reflect.Method findWriteMethod(String pName, Class cl) throws IntrospectionException {
		String name = (pName.startsWith("get") || pName.startsWith("set")
				? pName.substring(3)
				: pName.startsWith("is") ? pName.substring(2) : pName);
		BeanInfo bi = java.beans.Introspector.getBeanInfo(cl);
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		for (int i = 0; i < pds.length; i++) {
			PropertyDescriptor currPd = pds[i];
			if (currPd.getName().equalsIgnoreCase(name))
				return currPd.getWriteMethod();
		}
		return null;
	}

	///////////////////////////////////
	/**
	 * Metodi per visibilita'/abilitazione dei Widget
	 */

	/**
	 * @return true se il widget deve essere reso visibile
	 * @param cpName nome del ContentPanel
	 * @param widgShortName nome del widget
	 */
	public boolean isWidgetVisible(String cpName, String widgShortName) {
		// lo stato di visibilita' del widget e' mantenuto in sessione, in una mappa a due
		// livelli:
		// - il primo livello contiene coppie <nome cp, mappa widget del cp>
		// - il secondo livello contiene coppie <[nome widget]_visible, true|false> 
		Map cpData = (Map) session.get(cpName);
		if (cpData != null) {
			Boolean visibleFlag = (Boolean) cpData.get(widgShortName + "_visible");
			if (visibleFlag != null) {
				return visibleFlag.booleanValue();
			} else {
				// se non ho trovato niente forzo a true
				return true;
			}
		} else {
			// se non ho trovato niente forzo a true
			return true;
		}

	}

	/**
	 * @return true se il widget deve essere disabilitato
	 * @param cpName nome del ContentPanel
	 * @param widgShortName nome del widget
	 */
	public boolean isWidgetDisabled(String cpName, String widgShortName) {
		// lo stato di abbilitazione del widget e' mantenuto in sessione, in una mappa a due
		// livelli:
		// - il primo livello contiene coppie <nome cp, mappa widget del cp>
		// - il secondo livello contiene coppie <[nome widget]_enabled, true|false>
		Map cpData = (Map) session.get(cpName);
		if (cpData != null) {
			Boolean enabledFlag = (Boolean) cpData.get(widgShortName + "_enabled");
			if (enabledFlag != null) {
				return !enabledFlag.booleanValue();
			} else {
				// se non ho trovato nulla forzo a true
				return false;
			}
		} else {
			// se non ho trovaot nulla forzo a true
			return false;
		}

	}

	///////////////////////////////////
	/**
	 * Metodi per visibilita'/abilitazione del menu
	 */

	static List<MenuStructure> menuMap = new ArrayList<MenuStructure>();
	static {

		MenuStructure mnuHomeMenu = new MenuStructure("mnuHome");

		menuMap.add(mnuHomeMenu);

	}

	/**
	 * Metodi per visibilita'/abilitazione dei MenuElemnt
	 */

	/**
	 * @return true se il menu deve essere reso visibile
	 * @param menuName il nome del menu
	 */
	public boolean isMenuVisible(String menuName) {
		// vlauto la visibilita' dell'elemento
		return isMenuElementVisible(menuName);
	}

	private static final String SESSION_MENU_VISIBILITY = "menuVisibilityMap";

	/**
	 * @return true se il MenuElement deve essere reso visibile
	 * @param menuName il nome del menu
	 */
	public boolean isMenuElementVisible(String menuName) {
		// i dati di visibilita' sono conservati in sessione in una mappa
		Map cpData = (Map) session.get(SESSION_MENU_VISIBILITY);
		if (cpData != null) {
			Boolean visibleFlag = (Boolean) cpData.get(menuName + "_visible");
			if (visibleFlag != null) {
				return visibleFlag.booleanValue();
			} else {
				// se non ho trovato nulla forzo a true
				return true;
			}
		} else {
			// se non ho trovato nulla forzo a true
			return true;
		}

	}

	/**
	 * @return true se almeno uno dei sottomenu del menu dato &egrave; vissibile, false altrimenti
	 * @param menuName il nome del menu
	 */
	public boolean isAtLeastOneSubMenuVisible(String menuName) {

		return true;

	}

	/**
	 * @return true se il menu deve essere reso abilitato
	 * @param menuName
	 */
	public boolean isMenuEnabled(String menuName) {

		// valuto lo stato di abilitazione dell'elemento
		return isMenuElementEnabled(menuName);

	}

	/**
	 * nome dell'attributo di sessione che contiene la mappa di abilitazione dei menu
	 */
	private static String SESSION_MENU_ONOFF = "menuOnOffMap";

	/**
	 * @return true se il menuElement deve essere disabilitato
	 * @param menuName
	 */
	public boolean isMenuElementEnabled(String menuName) {
		// le informazioni di abilitazione sono contenute in una mappa 
		// in sessione
		Map cpData = (Map) session.get(SESSION_MENU_ONOFF);
		if (cpData != null) {
			Boolean enabledFlag = (Boolean) cpData.get(menuName + "_enabled");
			if (enabledFlag != null) {
				return enabledFlag.booleanValue();
			} else {
				// se non trovo nulla forzo a true
				return true;
			}
		} else {
			// se non trovo nulla forzo a true
			return true;
		}

	}

	/**
	 * @return true se il menu deve essere reso attivo (ovvero &grave; stato cliccato)
	 * @param menuName
	 */
	public boolean isMenuActive(String menuName) {
		// il menu corrente e' mantenuto in sessione
		String menu = "menu_items_" + menuName;
		return menu.equals((String) session.get("active_menu"));
	}

	/**
	 * @return true se un sottomenu del menu dato (a qualunque livello) &egrave; attivo 
	 * (ovvero &grave; stato cliccato)
	 * @param menuName
	 */
	public boolean isSubMenuActive(String menuName) {
		for (MenuStructure menuStructure : menuMap) {
			if (menuName.equals(menuStructure.getMenuName())) {
				List<MenuStructure> mstr = menuStructure.getSubMenuFlattenList(menuStructure, menuName);
				for (MenuStructure subMenu : mstr) {
					if (isMenuActive(subMenu.getMenuName())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Gestione del reset della paginazione/sorting delle tabelle (Displaytag)
	 * @param tableName nome della tabella
	 * @return true se bisogna resettare paginazione/sorting, false altrimenti
	 */
	public boolean isTableClearStatus(String tableName) {
		String sessionValue = tableName + "_clearStatus";
		Boolean clearStatus = (Boolean) session.get(sessionValue);
		if (clearStatus == null) {
			clearStatus = true;
		}
		if (clearStatus) {
			// la proprieta' e' "usa e getta"
			session.put(sessionValue, Boolean.valueOf(false));
		}
		return clearStatus;
	}

	/**
	 * Restituisce lo stato del menu
	 * @return List<MenuStructure>
	 */
	protected List<MenuStructure> getMenuStatus() {

		List<MenuStructure> menus = new ArrayList<MenuStructure>();
		for (MenuStructure menuStructure : menuMap) {
			//***sul fatclient non ho bisogno dello stato attivo per cui lo imposto a false
			menus.add(new MenuStructure(menuStructure.getMenuName(), isMenuVisible(menuStructure.getMenuName()),
					isMenuEnabled(menuStructure.getMenuName()), false));

			for (String subMenu : menuStructure.getAllSubMenu()) {

				menus.add(new MenuStructure(subMenu, isMenuVisible(subMenu), isMenuEnabled(subMenu), false));

			}
		}
		return menus;
	}

	/**
	 * metodo astratto per il dump visivo del model (da riscrivere nelle action dei singoli
	 * ContentPanel
	 */
	abstract protected void dumpModel(boolean pre);

	/**
	 * deve essere ridefinito nelle action relative ai ContentPanel
	 */
	abstract protected void doBeforeEventCommand() throws CommandExecutionException;

	/**
	 * deve essere ridefinito nelle action relative ai ContentPanel
	 */
	abstract protected void doAfterEventCommand() throws CommandExecutionException;

	/**
	 * metodo astratto che deve essere sovrascritto nelle action dei singoli ContentPanel per
	 * l'inizializzazione dei vari comandi presenti nella schermata
	 * @param moduleName il nome del modulo in cui e' contenuto il widget a cui e' associato l'evento
	 * @param panelName il nome del pannello in cui e' contenuto il widget a cui e' associato l'evento
	 * @param widgName il nome del widget a cui e' associato l'evento
	 * @param eventName il nome dell'evento (es. CLICKED)
	 */
	abstract protected ICommand initCommand(String moduleName, String panelName, String widgName, String eventName);

	protected flexjson.JSONSerializer getJSONSerializer(boolean jtsAware) {
		flexjson.JSONSerializer serializer = null;
		serializer = new flexjson.JSONSerializer();
		return serializer;
	}

	/**
	 * Metodo generico per l'esecuzione della logica associata ad un evento
	 * @param widgName il nome del widget a cui e' associato l'evento
	 * @param eventName il nome dell'evento (es. CLICKED)
	 */
	protected String handleEventInternal(String moduleName, String panelName, String widgName, String eventName)
			throws CommandExecutionException {
		ICommand action = initCommand(moduleName, panelName, widgName, eventName);
		if (LOG.isDebugEnabled()) {
			LOG.debug("[" + getClass().getName() + "::handle" + widgName + "_" + eventName + "] dump model before");
			dumpModel(false);
		}

		// Before event commands...
		doBeforeEventCommand();
		// event commands
		String result = action.doCommand(this);
		// After event commands...
		doAfterEventCommand();

		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[" + getClass().getName() + "::handle" + widgName + "_" + eventName + "] dump model after");
				dumpModel(false);
				LOG.debug("[" + getClass().getName() + "::handle" + widgName + "_" + eventName + "] returning result ["
						+ result + "]");
			}

			return result;

		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[" + getClass().getName() + "::handle" + widgName + "_" + eventName + "] dump model after");
				dumpModel(false);
				LOG.debug("[" + getClass().getName() + "::handle" + widgName + "_" + eventName
						+ "] returning default result [SUCCESS]");
			}
			return SUCCESS;

		}
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset 'datasetCode' del widget 'widget'.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideDataInternal(String widgetOGNLName, String contextPrefix, boolean jtsData, boolean isTreeView)
			throws CommandExecutionException {

		// reperisce il dato da serializzare
		com.opensymphony.xwork2.ActionContext ctx = com.opensymphony.xwork2.ActionContext.getContext();
		Object dataToProvide = ctx.getValueStack().findValue(widgetOGNLName);

		// TODO !!! qui manca l'arrangeDataToProvide (serve solo per fatclient)
		// serializza
		flexjson.JSONSerializer serializer = getJSONSerializer(jtsData);
		String response = "";
		if (isTreeView) {
			response = serializer.exclude("*.class")
					.deepSerialize(((it.csi.custom.component.tree.base.TreeNodeBase) dataToProvide).getChildren());
		} else {
			response = serializer.exclude("*.class").deepSerialize(dataToProvide);
		}
		// imposta l'input stream di risposta
		java.io.ByteArrayInputStream bais;
		try {
			bais = new java.io.ByteArrayInputStream(response.getBytes("UTF-8"));
			dataProviderStream = bais;
			// risposta
			return "provideData";
		} catch (java.io.UnsupportedEncodingException e) {
			throw new CommandExecutionException("errore provide Data", e);
		}
	}

	/**
	 *	Metodo per la rimozione dalla sessione degli application data a scope
	 *  SAME_PAGE. Deve essere implementato in tutte le sottoclassi associate
	 *  ad un content panel. 
	 */
	public abstract void clearPageScopedAppData(String targetContentPanelName);

	/**
	 * Ripulisce gli eventuali errori di conversione se il metodo richiamato
	 * dichiarava @skipValidation 
	 */
	protected void clearConversionErrorsIfSkipValidation() {
		ActionContext ctx = ActionContext.getContext();
		String methodName = ctx.getActionInvocation().getProxy().getMethod();
		Method m;
		try {
			boolean skipValidation = true;
			m = this.getClass().getDeclaredMethod(methodName, new Class[]{});
			if (m != null) {
				skipValidation = m.isAnnotationPresent(SkipValidation.class);
			}
			if (skipValidation && !m.getName().equalsIgnoreCase("execute")) {
				removeFailedParamsFromRequest(ctx);
				clearErrorsAndMessages();
			}
		} catch (SecurityException e) {
			LOG.error("[BaseAction::clearConversionErrorsIfSkipValidation] Errore interno: " + e + ", ignoro");
		} catch (NoSuchMethodException e) {
			LOG.error("[BaseAction::clearConversionErrorsIfSkipValidation] Errore interno: " + e + ", ignoro");
		}
	}

	private void removeFailedParamsFromRequest(ActionContext ctx) {
		ctx.getContextMap();
		ctx.getContextMap().remove("original.property.override");
	}

	private it.csi.sigit.elencom.business.BackEndFacade backEnd = null;

	public void setSpringBackEnd(it.csi.sigit.elencom.business.BackEndFacade be) {
		backEnd = be;
	}

	public it.csi.sigit.elencom.business.BackEndFacade getSpringBackEnd() {
		return backEnd;
	}

	private it.csi.sigit.elencom.business.SecurityHelper securityHelper = null;

	public void setSpringSecurityHelper(it.csi.sigit.elencom.business.SecurityHelper sh) {
		securityHelper = sh;
	}

	public it.csi.sigit.elencom.business.SecurityHelper getSpringSecurityHelper() {
		return securityHelper;
	}

	protected java.io.InputStream dataProviderStream = null;

	public java.io.InputStream getDataProviderStream() {
		return dataProviderStream;
	}

}
