package it.csi.sigit.sigitwebn.business.gestisci_ree_tipo3;

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

/*PROTECTED REGION ID(R-269626952) ENABLED START*/
import java.math.BigDecimal;
import it.csi.sigit.sigitwebn.util.*;
import it.csi.custom.component.tree.base.TreeNode;
import it.csi.custom.component.tree.base.TreeNodeBase;
import it.csi.sigit.sigitwebn.business.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTRappTipo3Dto;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;

/*PROTECTED REGION END*/

public class CPBECpGestReeTipo3 {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [reeMenuTree, scope:USER_SESSION]
	public static final String APPDATA_REEMENUTREE_CODE = "appDatareeMenuTree";

	// ApplicationData: [reeTipo3, scope:USER_SESSION]
	public static final String APPDATA_REETIPO3_CODE = "appDatareeTipo3";

	// ApplicationData: [progressivoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_PROGRESSIVOSELEZIONATO_CODE = "appDataprogressivoSelezionato";

	// ApplicationData: [allegato, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATO_CODE = "appDataallegato";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestReeTipo3";

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
	 * ContentPanel cpGestReeTipo3
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo3.CpGestReeTipo3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONTREECLICK_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SEZIONE_ABCDF = //NOSONAR  Reason:EIAS
				"SEZIONE_ABCDF"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SEZIONE_E = //NOSONAR  Reason:EIAS
				"SEZIONE_E"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-935747926) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String ret = null;

			String clickedNodeId = theModel.getIdNodo();

			// recupero il nodo corrispondente all'ID
			TreeNode clickedNode = theModel.getAppDatareeMenuTree().getChildren(clickedNodeId);

			log.debug("HO PREMUTO il NODO: CLICKED NODE: " + clickedNodeId + " ("
					+ (clickedNode != null ? clickedNode.getDescription() : "") + ")");

			if (clickedNodeId.equals("F-tipo3")) {
				// impostazione del result code 
				ret = ONTREECLICK_OUTCOME_CODE__SEZIONE_ABCDF;
			} else if (clickedNodeId.startsWith(Constants.PREFIX_ID_NODO_TIPO_3_E)) {
				// impostazione del result code 
				ret = ONTREECLICK_OUTCOME_CODE__SEZIONE_E;

				// devo salvare il progressivo
				String progr = clickedNodeId.substring(Constants.PREFIX_ID_NODO_TIPO_3_E.length());

				log.debug("Il progressivo trovato e': " + progr);

				theModel.setAppDataprogressivoSelezionato(ConvertUtil.convertToInteger(progr));

			} else {
				ret = ONTREECLICK_OUTCOME_CODE__KO;
			}

			// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. invia allegato)
			theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, ret);

			// impostazione del result code 
			result.setResultCode(ret);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	 * Implementazione del metodo salvaRee definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo3
	 */
	public ExecResults salvaRee(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo3.CpGestReeTipo3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAREE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAREE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-699248166) ENABLED START*/
			Tipo3 tipo3 = theModel.getAppDatareeTipo3();

			if (log.isDebugEnabled())
				GenericUtil.stampa(tipo3, true, 3);

			DettaglioAllegato dettaglioAllegato = theModel.getAppDataallegato();

			try {
				// verifico che abbia compilato la scheda
				getValidationMgr().validazioneFormaleReeTipo3(tipo3, dettaglioAllegato.getCodiceImpianto(),
						dettaglioAllegato.getDataControllo());

				getDbMgr().salvaReeTipo3(tipo3, dettaglioAllegato,
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

				// impostazione del result code 
				result.setResultCode(SALVAREE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaRee] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo3
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo3.CpGestReeTipo3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALLEGATI_IMPIANTO = //NOSONAR  Reason:EIAS
				"ELENCO_ALLEGATI_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI = //NOSONAR  Reason:EIAS
				"RISULTATO_RICERCA_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2133520987) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(GenericUtil.gestisciTreeReeIndietro(theModel.getAppDataallegato().getArrivoDa()));

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	 * ContentPanel cpGestReeTipo3
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo3.CpGestReeTipo3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1252703355) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoReeWEB(utente)) {
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
	 * Implementazione del metodo caricaReeTipo3 definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo3
	 */
	public ExecResults caricaReeTipo3(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo3.CpGestReeTipo3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAREETIPO3_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R100266595) ENABLED START*/
			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();
			DettaglioAllegato allegato = theModel.getAppDataallegato();
			String idAllegato = null;
			boolean isAllegatoInInsert = false;

			GenericUtil.gestisciMessaggioSessione(theModel, result);

			if (GenericUtil.isNullOrEmpty(allegato.getIdAllegato())) {

				BigDecimal idAllegatoNuovo = getSigitMgr().salvaAllegatoTrans(allegato, utenteLoggato);
				idAllegato = ConvertUtil.convertToString(idAllegatoNuovo);
				allegato.setIdAllegato(idAllegato);
				isAllegatoInInsert = true;
			}

			Tipo3 tipo3 = getSigitMgr().getAllegatoTipo3(allegato);

			theModel.setAppDatareeTipo3(tipo3);

			// impostazione del result code 
			result.setResultCode(CARICAREETIPO3_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaReeTipo3] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaMenuTipo3 definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo3
	 */
	public ExecResults caricaMenuTipo3(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo3.CpGestReeTipo3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAMENUTIPO3_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R826810472) ENABLED START*/
			DettaglioAllegato allegato = theModel.getAppDataallegato();

			if (log.isDebugEnabled())
				GenericUtil.stampa(allegato, true, 3);

			if (theModel.getAppDatareeMenuTree() == null) {
				TreeNode root = new TreeNodeBase("root", "root", false);

				String librettoNodeId = "R-tipo3";

				TreeNodeBase libNode = new TreeNodeBase(librettoNodeId, "REE Rapporto di Efficienza Energetica Tipo 3",
						false);
				libNode.setOpened(true);
				root.getChildren().add(libNode);

				// Aggiungo la sottoscheda (foglio)
				TreeNodeBase sottoSchedaNode = new TreeNodeBase("F-tipo3", Constants.LABEL_SEZIONE_ABCDF, true);
				root.getChildren(librettoNodeId).getChildren().add(sottoSchedaNode);

				List<String> idCompProgressiviList = allegato.getIdApparecchiatureFunz();

				for (String idCompProgressivo : idCompProgressiviList) {
					sottoSchedaNode = new TreeNodeBase(Constants.PREFIX_ID_NODO_TIPO_3_E + idCompProgressivo,
							GenericUtil.getDescSezioneEComp(Constants.TIPO_COMPONENTE_SC, idCompProgressivo), true);

					root.getChildren(librettoNodeId).getChildren().add(sottoSchedaNode);
				}

				// aggiungo il tree al modello
				theModel.setAppDatareeMenuTree(root);

				// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. invia allegato)
				theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, "SEZIONE_ABCDF");

			}

			// impostazione del result code 
			result.setResultCode(CARICAMENUTIPO3_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaMenuTipo3] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciMsg definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo3
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo3.CpGestReeTipo3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-999422269) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			GenericUtil.gestisciMessaggioSessione(theModel, result);

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

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1012839364) ENABLED START*/
	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

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

	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
