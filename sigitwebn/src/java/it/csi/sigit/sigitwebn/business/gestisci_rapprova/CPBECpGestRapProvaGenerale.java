package it.csi.sigit.sigitwebn.business.gestisci_rapprova;

import java.util.*;

import it.csi.sigit.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.dto.accesso.*;
import it.csi.sigit.sigitwebn.dto.codici_impianto.*;
import it.csi.sigit.sigitwebn.dto.common.*;
import it.csi.sigit.sigitwebn.dto.impianto.*;
import it.csi.sigit.sigitwebn.dto.main.*;
import it.csi.sigit.sigitwebn.dto.bollini.*;
import it.csi.sigit.sigitwebn.dto.allegati.*;
import it.csi.sigit.sigitwebn.dto.subentro.*;
import it.csi.sigit.sigitwebn.dto.delega.*;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.*;
import it.csi.sigit.sigitwebn.dto.ispezioni.*;
import it.csi.sigit.sigitwebn.dto.distributori.*;
import it.csi.sigit.sigitwebn.dto.incarico.*;
import it.csi.sigit.sigitwebn.dto.impresa.*;
import it.csi.sigit.sigitwebn.dto.documentazione.*;
import it.csi.sigit.sigitwebn.dto.libretto.*;
import it.csi.sigit.sigitwebn.dto.ree.*;
import it.csi.sigit.sigitwebn.dto.verifica.*;
import it.csi.sigit.sigitwebn.dto.accertamento.*;
import it.csi.sigit.sigitwebn.dto.azioni.*;
import it.csi.sigit.sigitwebn.dto.sanzioni.*;
import it.csi.sigit.sigitwebn.dto.rappprova.*;
import it.csi.sigit.sigitwebn.dto.back_office.*;
import it.csi.sigit.sigitwebn.dto.userws.*;

import org.apache.log4j.*;
import it.csi.sigit.sigitwebn.util.*;
import it.csi.sigit.sigitwebn.business.*;

/*PROTECTED REGION ID(R-1853799983) ENABLED START*/
import java.math.BigDecimal;

import it.csi.custom.component.tree.base.TreeNode;
import it.csi.custom.component.tree.base.TreeNodeBase;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto;
/*PROTECTED REGION END*/

public class CPBECpGestRapProvaGenerale {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [rapProvaDatiGenerali, scope:USER_SESSION]
	public static final String APPDATA_RAPPROVADATIGENERALI_CODE = "appDatarapProvaDatiGenerali";

	// ApplicationData: [allegatoIsp, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATOISP_CODE = "appDataallegatoIsp";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [listaDatiExtra, scope:USER_SESSION]
	public static final String APPDATA_LISTADATIEXTRA_CODE = "appDatalistaDatiExtra";

	// ApplicationData: [rapProvaMenuTree, scope:USER_SESSION]
	public static final String APPDATA_RAPPROVAMENUTREE_CODE = "appDatarapProvaMenuTree";

	// ApplicationData: [progressivoSelezionatoRappProva, scope:USER_SESSION]
	public static final String APPDATA_PROGRESSIVOSELEZIONATORAPPPROVA_CODE = "appDataprogressivoSelezionatoRappProva";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestRapProvaGenerale";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onTreeClick definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaGenerale
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaGeneraleModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONTREECLICK_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__RP_DATI_GEN = //NOSONAR  Reason:EIAS
				"RP_DATI_GEN"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__RPGENGT = //NOSONAR  Reason:EIAS
				"RPGENGT"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__RPDETTGT = //NOSONAR  Reason:EIAS
				"RPDETTGT"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__RPGENGF = //NOSONAR  Reason:EIAS
				"RPGENGF"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__RPDETTGF = //NOSONAR  Reason:EIAS
				"RPDETTGF"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1721140099) ENABLED START*/

			String ret = null;

			String clickedNodeId = theModel.getIdNodo();

			log.debug("Ho premuto theModel.getAppDatarapProvaMenuTree(): " + theModel.getAppDatarapProvaMenuTree());
			log.debug("Ho premuto clickedNodeId: " + clickedNodeId);

			// recupero il nodo corrispondente all'ID
			TreeNode clickedNode = theModel.getAppDatarapProvaMenuTree().getChildren(clickedNodeId);

			log.debug("HO PREMUTO il NODO: CLICKED NODE: " + clickedNodeId + " ("
					+ (clickedNode != null ? clickedNode.getDescription() : "") + ")");

			DettaglioAllegato allegato = theModel.getAppDataallegatoIsp();

			String tipoComponente = null;
			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato()))
				tipoComponente = Constants.TIPO_COMPONENTE_GT;
			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(allegato.getIdTipoAllegato()))
				tipoComponente = Constants.TIPO_COMPONENTE_GF;

			if (clickedNodeId.equals("F-DatiGen")) {
				// impostazione del result code 
				ret = ONTREECLICK_OUTCOME_CODE__RP_DATI_GEN;
			} else if (clickedNodeId.equals("F-DatiRPGen")) {
				// impostazione del result code 
				if (Constants.TIPO_COMPONENTE_GT.equals(tipoComponente)) {
					ret = ONTREECLICK_OUTCOME_CODE__RPGENGT;
				} else {
					ret = ONTREECLICK_OUTCOME_CODE__RPGENGF;
				}

			} else if (clickedNodeId.startsWith(Constants.PREFIX_ID_NODO_RP_DET + tipoComponente)) {
				// impostazione del result code 
				if (Constants.TIPO_COMPONENTE_GT.equals(tipoComponente)) {
					ret = ONTREECLICK_OUTCOME_CODE__RPDETTGT;
				} else {
					ret = ONTREECLICK_OUTCOME_CODE__RPDETTGF;
				}

				// devo salvare il progressivo
				String progr = clickedNodeId
						.substring(getChiavePrefixProgr(Constants.PREFIX_ID_NODO_RP_DET, tipoComponente).length());

				log.debug("Il progressivo trovato e': " + progr);

				theModel.setAppDataprogressivoSelezionatoRappProva(ConvertUtil.convertToInteger(progr));

			} else {
				ret = ONTREECLICK_OUTCOME_CODE__KO;
			}

			log.debug("Stampo il resultCod - cpGestRapProvaGenerale: " + ret);

			result.setResultCode(ret);

			// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. invia allegato)
			theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, ret);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onTreeClick] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaGenerale
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaGeneraleModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__DETTAGLIO_ISPEZIONE = //NOSONAR  Reason:EIAS
				"DETTAGLIO_ISPEZIONE"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI = //NOSONAR  Reason:EIAS
				"RISULTATO_RICERCA_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-990278420) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (Constants.PAG_ELENCO_ALL_IMPIANTI.equals(theModel.getAppDatapaginaChiamante())) {
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI);
			} else {
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__DETTAGLIO_ISPEZIONE);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::tornaPaginaChiamante] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaGenerale
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaGeneraleModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-922224830) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isUtenteAbilitatoRapProva(utente)) {
				result.setResultCode(ISRUOLOABILITATO_OUTCOME_CODE__OK);
			} else {
				GenericUtil.redirectToNotAllowedPage();
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isRuoloAbilitato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaRapProvaGenerale definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaGenerale
	 */
	public ExecResults caricaRapProvaGenerale(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaGeneraleModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICARAPPROVAGENERALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-279709117) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();
			DettaglioAllegato allegato = theModel.getAppDataallegatoIsp();
			String idAllegato = null;
			boolean isAllegatoInInsert = false;

			log.debug("caricaReeTipo1 - idAllegato: " + idAllegato);

			String tipoComponente = null;
			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato())) {
				tipoComponente = Constants.TIPO_COMPONENTE_GT;
			}

			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(allegato.getIdTipoAllegato())) {
				tipoComponente = Constants.TIPO_COMPONENTE_GF;
			}

			if (GenericUtil.isNullOrEmpty(allegato.getIdAllegato())) {
				log.debug(" STOOOOOOOOOO INSERENDOOOOOOOOOOOOOO");
				//salvo sulla tabella SIGIT_T_ALLEGATO una parte di dati, quelli che arrivano dal client e il pdf

				BigDecimal idAllegatoNuovo = getSigitMgr().salvaRapProva(allegato, false, null, utenteLoggato);

				idAllegato = ConvertUtil.convertToString(idAllegatoNuovo);
				allegato.setIdAllegato(idAllegato);
				isAllegatoInInsert = true;
			} else {
				//poiche' l'allegato esiste gia' occorre recuperare tutti i suoi figli (ovvero tutte le relazioni tra allegato e componenti)
				allegato.setIdApparecchiatureFunz((ArrayList<String>) getSigitMgr().recuperaApparecchiatureDaAllegato(
						ConvertUtil.convertToInteger(allegato.getIdAllegato()), tipoComponente));
			}

			SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto unitaImmobiliareDto = getDbMgr()
					.cercaSigitTUnitaImmobiliareDecodByCodImpianto(allegato.getCodiceImpianto());

			RapProvaDatiGenerali datiGen = getSigitMgr().getRapProvaDatiGenerali(allegato, isAllegatoInInsert,
					tipoComponente, unitaImmobiliareDto);

			theModel.setAppDataidentificativoImpianto(
					getSigitMgr().caricaDatiImpiantoPerAllegati(allegato.getCodiceImpianto()));

			theModel.setAppDatarapProvaDatiGenerali(datiGen);

			ArrayList<DatiExtra> listDatiExtra = getSigitMgr().ricercaDatiExtra(allegato.getCodiceImpianto(),
					GenericUtil.isUtenteAbilModLibWeb(theModel.getAppDatautenteLoggato()));

			if (unitaImmobiliareDto != null) {
				DatiExtra primaRiga = new DatiExtra();
				primaRiga.setSezione(unitaImmobiliareDto.getUiSezione());
				primaRiga.setFoglio(unitaImmobiliareDto.getUiFoglio());
				primaRiga.setParticella(unitaImmobiliareDto.getUiParticella());
				primaRiga.setSubalterno(unitaImmobiliareDto.getUiSubalterno());
				primaRiga.setPod(unitaImmobiliareDto.getUiPodElettrico());
				primaRiga.setPdr(unitaImmobiliareDto.getUiPdrGas());

				//viene aggiunta l'ultima riga ai dati extra
				if (listDatiExtra == null) {
					listDatiExtra = new ArrayList<DatiExtra>();
				}

				listDatiExtra.add(0, primaRiga);
			}

			theModel.setAppDatalistaDatiExtra(listDatiExtra);

			// impostazione del result code 
			result.setResultCode(CARICARAPPROVAGENERALE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaRapProvaGenerale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaMenu definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaGenerale
	 */
	public ExecResults caricaMenu(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaGeneraleModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAMENU_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1540461656) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioAllegato allegato = theModel.getAppDataallegatoIsp();

			//theModel.getAppDatareeTipo1();

			if (log.isDebugEnabled())
				GenericUtil.stampa(allegato, true, 3);

			String tipoComponente = null;
			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato()))
				tipoComponente = Constants.TIPO_COMPONENTE_GT;
			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(allegato.getIdTipoAllegato()))
				tipoComponente = Constants.TIPO_COMPONENTE_GF;

			//			if (theModel.getAppDatarapProvaMenuTree() == null) {
			// creo il nodo root del tree
			TreeNode root = new TreeNodeBase("root", "root", false);

			String librettoNodeId = "R-" + tipoComponente;
			TreeNodeBase libNode = new TreeNodeBase(librettoNodeId, "RapProva " + tipoComponente, false);
			libNode.setOpened(true);
			root.getChildren().add(libNode);

			/////////////////////////////////////////////////////
			// RapProva GT

			// Aggiungo la sottoscheda (foglio)
			TreeNodeBase sottoSchedaNode = new TreeNodeBase("F-DatiGen", Constants.LABEL_SEZIONE_RP_DATI_GEN, true);
			root.getChildren(librettoNodeId).getChildren().add(sottoSchedaNode);

			// Aggiungo la sottoscheda (foglio)
			sottoSchedaNode = new TreeNodeBase("F-DatiRPGen", Constants.LABEL_SEZIONE_RP_GEN, true);
			root.getChildren(librettoNodeId).getChildren().add(sottoSchedaNode);

			// Devo ciclare per tutte le componenti selezionate
			List<String> idCompProgressiviList = allegato.getIdApparecchiatureFunz();
			for (String idCompProgressivo : idCompProgressiviList) {

				sottoSchedaNode = new TreeNodeBase(
						getChiavePrefixProgr(Constants.PREFIX_ID_NODO_RP_DET, tipoComponente) + idCompProgressivo,
						GenericUtil.getDescSezioneRPComp(tipoComponente, idCompProgressivo), true);

				root.getChildren(librettoNodeId).getChildren().add(sottoSchedaNode);
			}

			// aggiungo il tree al modello
			theModel.setAppDatarapProvaMenuTree(root);

			//			}

			// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. invia allegato)
			theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, Constants.LABEL_SEZIONE_RP_GEN);

			result.setResultCode(CARICAMENU_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaMenu] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciMsg definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaGenerale
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaGeneraleModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1657465756) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
			if (msg != null) {
				if (msg.getType() == Message.ERROR)
					result.getGlobalErrors().add(msg.getText());
				else
					result.getGlobalMessages().add(msg.getText());

				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
			}

			// impostazione del result code 
			result.setResultCode(GESTISCIMSG_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciMsg] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbLocalizzazioni
	 */
	public static void resetClearStatus_widg_tbLocalizzazioni(java.util.Map session) {
		session.put("cpGestRapProvaGenerale_tbLocalizzazioni_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-111937917) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private static String getChiavePrefixProgr(String prefixIdNodo, String tipoComponente) {
		return Constants.PREFIX_ID_NODO_RP_DET + tipoComponente + "-";
	}

	private ConnectorMgr connectorMgr;

	public ConnectorMgr getConnectorMgr() {
		return connectorMgr;
	}

	public void setConnectorMgr(ConnectorMgr connectorMgr) {
		this.connectorMgr = connectorMgr;
	}

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	/*PROTECTED REGION END*/
}
