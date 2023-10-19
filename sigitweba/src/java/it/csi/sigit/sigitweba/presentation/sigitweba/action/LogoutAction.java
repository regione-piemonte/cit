package it.csi.sigit.sigitweba.presentation.sigitweba.action;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.csi.sigit.sigitweba.dto.*;

/**
 * LogoutAction Action Class.
 *
 * @author GuiGen
 */
public class LogoutAction extends BaseAction<BaseSessionAwareDTO> {

	public BaseSessionAwareDTO getModel() {
		throw new UnsupportedOperationException("Metodo getModel() intenzionalmente non implementato.");
	}

	public void setModel(BaseSessionAwareDTO modello) {
		throw new UnsupportedOperationException("Metodo setModel() intenzionalmente non implementato..");
	}

	/**
	 * azzera il valore di tutti i cookie dalla response, per una azione
	 * di logout pi&ugrave; sicura
	 */
	private void clearAllCookies() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				cookie.setValue("-");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}

	private String savedPortalCode;

	public void savePortalCode(String savedPortalCode) {
		this.savedPortalCode = savedPortalCode;
	}
	public String getSavedPortalCode() {
		return this.savedPortalCode;
	}

	public String getSsoLogoutUrl() {
		return (String) ActionContext.getContext().getApplication().get("logoutURL." + getSavedPortalCode());
	}

	public String getLocalLogoutUrl() {
		return (String) ActionContext.getContext().getApplication().get("localLogoutURL." + getSavedPortalCode());
	}

	/**
	 * nessuna classe model associata
	 */
	public Class modelClass() {
		return null;
	}

	/**
	 * Mostra la pagina di conferma del logout
	 * @return SSO_LOGOUT.
	 */
	public String confirmLogout() throws Exception {
		return "confirmLogout";
	}

	protected void dumpModel(boolean pre) {
		// metodo intenzionalmente vuoto
	}

	protected void doBeforeEventCommand() {
		// non sono previsti before/after event commands
	}

	protected void doAfterEventCommand() {
		// non sono previsti before/after event commands
	}

	protected ICommand initCommand(String moduleName, String panelName, String widgName, String eventName) {
		// metodo intenzionalmente vuoto
		return null;
	}

	/**
	 *
	 * @return SSO_LOGOUT.
	 */
	public String ssoLogout() throws Exception {
		LOG.debug("[LogoutAction::ssoLogout] START");
		invalidateLocalSession();
		LOG.debug("[LogoutAction::ssoLogout] END");
		return "SSO_LOGOUT";
	}

	/**
	 *
	 * @return LOCAL_LOGOUT.
	 */
	public String localLogout() throws Exception {
		LOG.debug("[LogoutAction::localLogout] START");
		invalidateLocalSession();
		LOG.debug("[LogoutAction::localLogout] END");
		return "LOCAL_LOGOUT";
	}

	/**
	 * Invalida la sessione corrente
	 */
	protected void invalidateLocalSession() {
		if (session instanceof org.apache.struts2.dispatcher.SessionMap) {
			// salvo il portal code dalla sessione
			savePortalCode(getPortalCode());

			try {
				((org.apache.struts2.dispatcher.SessionMap) session).invalidate();
			} catch (IllegalStateException e) { //NOSONAR  Reason:dubbia classificazione severity
				LOG.error("[LogoutAction::invalidateLocalSession] ERROR Invalidating Struts2 Session");
				// in caso di errore invalido almeno l'attributo di iride
				session.remove(
						it.csi.sigit.sigitweba.presentation.sigitweba.filter.IrideIdAdapterFilter.IRIDE_ID_SESSIONATTR);
			}
		}
		clearAllCookies();
	}

	/**
	 *	Metodo per la rimozione dalla sessione degli application data a scope
	 *  SAME_PAGE. 
	 */
	public void clearPageScopedAppData(String targetContentPanelName) {
		//NOP
	}

}
