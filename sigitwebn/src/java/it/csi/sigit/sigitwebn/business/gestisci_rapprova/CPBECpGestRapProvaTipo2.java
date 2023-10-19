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

/*PROTECTED REGION ID(R2048285456) ENABLED START*/
import it.csi.custom.component.tree.base.TreeNode;
import it.csi.custom.component.tree.base.TreeNodeBase;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
/*PROTECTED REGION END*/

public class CPBECpGestRapProvaTipo2 {

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

	// ApplicationData: [progressivoSelezionatoRappProva, scope:USER_SESSION]
	public static final String APPDATA_PROGRESSIVOSELEZIONATORAPPPROVA_CODE = "appDataprogressivoSelezionatoRappProva";

	// ApplicationData: [rapProvaMenuTree, scope:USER_SESSION]
	public static final String APPDATA_RAPPROVAMENUTREE_CODE = "appDatarapProvaMenuTree";

	// ApplicationData: [allegatoIsp, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATOISP_CODE = "appDataallegatoIsp";

	// ApplicationData: [ElencoBolliniRappProva, scope:USER_SESSION]
	public static final String APPDATA_ELENCOBOLLINIRAPPPROVA_CODE = "appDataElencoBolliniRappProva";

	// ApplicationData: [TipoGF, scope:USER_SESSION]
	public static final String APPDATA_TIPOGF_CODE = "appDataTipoGF";

	// ApplicationData: [Ispezione2018, scope:USER_SESSION]
	public static final String APPDATA_ISPEZIONE2018_CODE = "appDataIspezione2018";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestRapProvaTipo2";

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
	 * ContentPanel cpGestRapProvaTipo2
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2Model theModel

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
			/*PROTECTED REGION ID(R1386764802) ENABLED START*/

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
	 * Implementazione del metodo salvaRapProva definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo2
	 */
	public ExecResults salvaRapProva(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVARAPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVARAPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R11416493) ENABLED START*/
			TipoGF allegatoGF = theModel.getAppDataTipoGF();

			DettaglioAllegato dettaglioAllegato = theModel.getAppDataallegatoIsp();

			try {
				getValidationMgr().validazioneFormaleRappProvaGF(dettaglioAllegato, allegatoGF,
						dettaglioAllegato.getCodiceImpianto());

				getDbMgr().salvaRappProvaTipoGF(allegatoGF, dettaglioAllegato,
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);
 
				result.setResultCode(SALVARAPPROVA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaRapProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo2
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__DETTAGLIO_ISPEZIONE = //NOSONAR  Reason:EIAS
				"DETTAGLIO_ISPEZIONE"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI = //NOSONAR  Reason:EIAS
				"RISULTATO_RICERCA_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1896322381) ENABLED START*/

			if (Constants.ARRIVO_DA_IMPIANTO_ISP.equals(theModel.getAppDataallegatoIsp().getArrivoDa())) {
				Ispezione2018 ispezione = new Ispezione2018();
				ispezione.setIdentificativoIspezione(
						ConvertUtil.convertToString(theModel.getAppDataallegatoIsp().getIdIspezione2018()));

				theModel.setAppDataIspezione2018(ispezione);

				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__DETTAGLIO_ISPEZIONE);
			} else {
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI);
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
	 * ContentPanel cpGestRapProvaTipo2
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-983345117) ENABLED START*/
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
	 * Implementazione del metodo caricaRapProvaTipo2 definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo2
	 */
	public ExecResults caricaRapProvaTipo2(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICARAPPROVATIPO2_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-210909127) ENABLED START*/
			DettaglioAllegato allegato = theModel.getAppDataallegatoIsp();

			theModel.setAppDataElencoBolliniRappProva(getServiziMgr().getListaSiglaProvincePiemonteManipolata());

			GenericUtil.gestisciMessaggioSessione(theModel, result);

			TipoGF allegatoGF = getSigitMgr().getAllegatoRappProvaTipoGF(allegato.getIdAllegato(),
					allegato.getCodiceImpianto());

			theModel.setAppDataTipoGF(allegatoGF);

			result.setResultCode(CARICARAPPROVATIPO2_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaRapProvaTipo2] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaMenu definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo2
	 */
	public ExecResults caricaMenu(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAMENU_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1795460615) ENABLED START*/
			DettaglioAllegato allegato = theModel.getAppDataallegatoIsp();

			if (log.isDebugEnabled())
				GenericUtil.stampa(allegato, true, 3);

			String tipoComponente = null;
			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato()))
				tipoComponente = Constants.TIPO_COMPONENTE_GT;
			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(allegato.getIdTipoAllegato()))
				tipoComponente = Constants.TIPO_COMPONENTE_GF;

			if (theModel.getAppDatarapProvaMenuTree() == null) {
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

			}

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
	 * ContentPanel cpGestRapProvaTipo2
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1323090459) ENABLED START*/

			GenericUtil.gestisciMessaggioSessione(theModel, result);

			result.setResultCode(GESTISCIMSG_OUTCOME_CODE__OK);

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

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1265528674) ENABLED START*/
	private static String getChiavePrefixProgr(String prefixIdNodo, String tipoComponente) {
		return Constants.PREFIX_ID_NODO_RP_DET + tipoComponente + "-";
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private ServiziMgr serviziMgr;

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}
	/*PROTECTED REGION END*/
}
