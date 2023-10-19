package it.csi.sigit.sigitwebn.business.gestisci_ree_tipo4;

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

/*PROTECTED REGION ID(R1396480534) ENABLED START*/
import it.csi.custom.component.tree.base.TreeNode;

import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettTipo4Dto;

/*PROTECTED REGION END*/

public class CPBECpGestReeTipo4Dett {

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

	// ApplicationData: [reeMenuTree, scope:USER_SESSION]
	public static final String APPDATA_REEMENUTREE_CODE = "appDatareeMenuTree";

	// ApplicationData: [allegato, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATO_CODE = "appDataallegato";

	// ApplicationData: [progressivoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_PROGRESSIVOSELEZIONATO_CODE = "appDataprogressivoSelezionato";

	// ApplicationData: [ricaricaPagina, scope:USER_SESSION]
	public static final String APPDATA_RICARICAPAGINA_CODE = "appDataricaricaPagina";

	// ApplicationData: [reeTipo4, scope:USER_SESSION]
	public static final String APPDATA_REETIPO4_CODE = "appDatareeTipo4";

	// ApplicationData: [reeTipo4Dett, scope:USER_SESSION]
	public static final String APPDATA_REETIPO4DETT_CODE = "appDatareeTipo4Dett";

	// ApplicationData: [elencoFluido, scope:USER_SESSION]
	public static final String APPDATA_ELENCOFLUIDO_CODE = "appDataelencoFluido";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestReeTipo4Dett";

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
	 * ContentPanel cpGestReeTipo4Dett
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo4.CpGestReeTipo4DettModel theModel

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
			/*PROTECTED REGION ID(R967313800) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String ret = null;

			String clickedNodeId = theModel.getIdNodo();

			log.debug("Ho premuto theModel.getAppDatareeMenuTree(): " + theModel.getAppDatareeMenuTree());
			log.debug("Ho premuto clickedNodeId: " + clickedNodeId);

			// recupero il nodo corrispondente all'ID
			TreeNode clickedNode = theModel.getAppDatareeMenuTree().getChildren(clickedNodeId);

			log.debug("HO PREMUTO il NODO: CLICKED NODE: " + clickedNodeId + " ("
					+ (clickedNode != null ? clickedNode.getDescription() : "") + ")");

			if (clickedNodeId.equals("F-tipo4")) {
				// impostazione del result code 
				ret = ONTREECLICK_OUTCOME_CODE__SEZIONE_ABCDF;
			} else if (clickedNodeId.startsWith(Constants.PREFIX_ID_NODO_TIPO_4_E)) {
				// impostazione del result code 
				ret = ONTREECLICK_OUTCOME_CODE__SEZIONE_E;

				// devo salvare il progressivo
				String progr = clickedNodeId.substring(Constants.PREFIX_ID_NODO_TIPO_4_E.length());
				theModel.setAppDataprogressivoSelezionato(ConvertUtil.convertToInteger(progr));

				log.debug("Il progressivo trovato e': " + progr);

				// Devo forzare il caricamento della pagina (perchè non c'è un cambio di CP)
				theModel.setAppDataricaricaPagina(true);

			} else {
				ret = ONTREECLICK_OUTCOME_CODE__KO;
			}

			log.debug("Stampo il resultCod: " + ret);

			// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. invia allegato)
			theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, ret);

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
	 * Implementazione del metodo salvaReeDett definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo4Dett
	 */
	public ExecResults salvaReeDett(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo4.CpGestReeTipo4DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAREEDETT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAREEDETT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-346931845) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Tipo4Dett tipo4Dett = theModel.getAppDatareeTipo4Dett();
				//Tipo4DettModulo tipo4DettModulo = theModel.getAppDatareeTipo4DettModulo();

				// verifico che abbia compilato la scheda
				getValidationMgr().validazioneFormaleReeTipo4Dett(tipo4Dett);

				//getValidationMgr().validazioneFormaleReeTipo4DettModulo(tipo4DettModulo);

				getDbMgr().salvaReeTipo4Dett(tipo4Dett, theModel.getAppDatautenteLoggato().getCodiceFiscale());

				// recupero nuovamente i dati per aggiornare la lista da compilare
				List<SigitTDettTipo4Dto> tDettTipo4List = getDbMgr().getDettTipo4(
						ConvertUtil.convertToString(tipo4Dett.getCodImpianto()),
						theModel.getAppDataprogressivoSelezionato(),
						ConvertUtil.convertToString(tipo4Dett.getIdAllegato()));

				//tipo4Dett = MapDto.mapToTipo4Dett(tipo4Dett, tDettTipo4List);

				//theModel.setAppDatareeTipo4Dett(tipo4Dett);

				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

				// impostazione del result code 
				result.setResultCode(SALVAREEDETT_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaReeDett] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo4Dett
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo4.CpGestReeTipo4DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALLEGATI_IMPIANTO = //NOSONAR  Reason:EIAS
				"ELENCO_ALLEGATI_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI = //NOSONAR  Reason:EIAS
				"RISULTATO_RICERCA_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R195951751) ENABLED START*/
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
	 * ContentPanel cpGestReeTipo4Dett
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo4.CpGestReeTipo4DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-360551331) ENABLED START*/
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
	 * Implementazione del metodo caricaReeTipo4Dett definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo4Dett
	 */
	public ExecResults caricaReeTipo4Dett(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo4.CpGestReeTipo4DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAREETIPO4DETT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R105525539) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			caricaDettaglio(theModel);

			// BEPPE DEVO CARICARE Un'ALTRA COMBO
			// Setto al combo
			theModel.setAppDataelencoFluido(getSigitMgr().getListFluido());

			// impostazione del result code 
			result.setResultCode(CARICAREETIPO4DETT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaReeTipo4Dett] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciRicaricaPagina definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo4Dett
	 */
	public ExecResults gestisciRicaricaPagina(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo4.CpGestReeTipo4DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIRICARICAPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1947933178) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// BEPPE - FORSE E' DA TOGLIERE

			Boolean isRicarica = theModel.getAppDataricaricaPagina();

			if (ConvertUtil.convertToBooleanAllways(isRicarica)) {
				caricaDettaglio(theModel);

				theModel.setAppDataricaricaPagina(false);
			}

			// impostazione del result code 
			result.setResultCode(GESTISCIRICARICAPAGINA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciRicaricaPagina] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciMsg definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo4Dett
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo4.CpGestReeTipo4DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R903639457) ENABLED START*/
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
	/*PROTECTED REGION ID(R106053022) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
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

	/*
	private Tipo4DettModulo recuperaModuloSelez(String codImpianto, String idAllegato, Integer progressivo,
			String moduloSelez) throws ManagerException {
		Tipo4DettModulo modulo = getSigitMgr().caricaDatiReeTipo4DettModulo(codImpianto, idAllegato, progressivo,
				moduloSelez);
	
		return modulo;
	}
	*/
	private void caricaDettaglio(it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo4.CpGestReeTipo4DettModel theModel)
			throws Exception {
		try {
			DettaglioAllegato dettAll = theModel.getAppDataallegato();

			Tipo4Dett tipo4Dett = getSigitMgr().caricaDatiReeTipo4Dett(dettAll.getIdAllegato(),
					theModel.getAppDataprogressivoSelezionato());

			List<SigitTDettTipo4Dto> tDettTipo4List = getDbMgr().getDettTipo4(dettAll.getCodiceImpianto(),
					theModel.getAppDataprogressivoSelezionato(), dettAll.getIdAllegato());

			tipo4Dett = MapDto.mapToTipo4Dett(tipo4Dett, tDettTipo4List);

			theModel.setAppDatareeTipo4Dett(tipo4Dett);

			// Setto la combo dei moduli
			//			ArrayList<CodeDescription> moduliList = MapDto.mapToModuli(tDettTipo4List);
			//			theModel.setAppDataelencoModuli(moduliList);

			/*
			// Setto come defauol il primo modulo
			String moduloDefault = moduliList.get(0).getCode();
			
			theModel.setAppDatamoduloSelezionato(moduloDefault);
			
			// Devo recuperare il modulo selezionato
			Tipo4DettModulo modulo = recuperaModuloSelez(ConvertUtil.convertToString(tipo4Dett.getCodImpianto()),
					ConvertUtil.convertToString(tipo4Dett.getIdAllegato()),
					ConvertUtil.convertToInteger(tipo4Dett.getProgressivo()), moduloDefault);
			theModel.setAppDatareeTipo4DettModulo(modulo);
			*/
		} catch (Exception e) {
			throw e;
		}
	}

	/*PROTECTED REGION END*/
}
