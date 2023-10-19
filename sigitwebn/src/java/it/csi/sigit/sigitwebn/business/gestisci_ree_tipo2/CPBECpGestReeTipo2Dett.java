package it.csi.sigit.sigitwebn.business.gestisci_ree_tipo2;

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

/*PROTECTED REGION ID(R-2080838312) ENABLED START*/
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettTipo2Dto;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2Dett;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2DettCircuito;
/*PROTECTED REGION END*/

public class CPBECpGestReeTipo2Dett {

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

	// ApplicationData: [reeTipo2, scope:USER_SESSION]
	public static final String APPDATA_REETIPO2_CODE = "appDatareeTipo2";

	// ApplicationData: [reeTipo2Dett, scope:USER_SESSION]
	public static final String APPDATA_REETIPO2DETT_CODE = "appDatareeTipo2Dett";

	// ApplicationData: [progressivoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_PROGRESSIVOSELEZIONATO_CODE = "appDataprogressivoSelezionato";

	// ApplicationData: [moduloSelezionato, scope:USER_SESSION]
	public static final String APPDATA_MODULOSELEZIONATO_CODE = "appDatamoduloSelezionato";

	// ApplicationData: [elencoModuli, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMODULI_CODE = "appDataelencoModuli";

	// ApplicationData: [ricaricaPagina, scope:USER_SESSION]
	public static final String APPDATA_RICARICAPAGINA_CODE = "appDataricaricaPagina";

	// ApplicationData: [allegato, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATO_CODE = "appDataallegato";

	// ApplicationData: [elencoSiNo, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSINO_CODE = "appDataelencoSiNo";

	// ApplicationData: [elencoModalitaProva, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMODALITAPROVA_CODE = "appDataelencoModalitaProva";

	// ApplicationData: [reeTipo2DettCircuito, scope:USER_SESSION]
	public static final String APPDATA_REETIPO2DETTCIRCUITO_CODE = "appDatareeTipo2DettCircuito";

	// ApplicationData: [elencoReeTipo2DettCircuito, scope:USER_SESSION]
	public static final String APPDATA_ELENCOREETIPO2DETTCIRCUITO_CODE = "appDataelencoReeTipo2DettCircuito";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestReeTipo2Dett";

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
	 * ContentPanel cpGestReeTipo2Dett
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo2.CpGestReeTipo2DettModel theModel

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
			/*PROTECTED REGION ID(R944681546) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String ret = null;

			String clickedNodeId = theModel.getIdNodo();

			if (clickedNodeId.equals("F-tipo2")) {
				// impostazione del result code 
				ret = ONTREECLICK_OUTCOME_CODE__SEZIONE_ABCDF;
			} else if (clickedNodeId.startsWith(Constants.PREFIX_ID_NODO_TIPO_2_E)) {
				// impostazione del result code 
				ret = ONTREECLICK_OUTCOME_CODE__SEZIONE_E;

				// devo salvare il progressivo
				String progr = clickedNodeId.substring(Constants.PREFIX_ID_NODO_TIPO_2_E.length());
				theModel.setAppDataprogressivoSelezionato(ConvertUtil.convertToInteger(progr));

				log.debug("Il progressivo trovato e': " + progr);

				// Devo forzare il caricamento della pagina (perchè non c'è un cambio di CP)
				theModel.setAppDataricaricaPagina(true);

			} else {
				ret = ONTREECLICK_OUTCOME_CODE__KO;
			}

			// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. invia allegato)
			theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, ret);

			result.setResultCode(ret);

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
	 * Implementazione del metodo caricaCircuito definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo2Dett
	 */
	public ExecResults caricaCircuito(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo2.CpGestReeTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICACIRCUITO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1163687222) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioAllegato dettAll = theModel.getAppDataallegato();

			log.debug("theModel.getAppDatamoduloSelezionato(): " + theModel.getAppDatamoduloSelezionato());

			// Devo recuperare il modulo selezionato
			Tipo2DettCircuito circuito = recuperaModuloSelez(dettAll.getCodiceImpianto(), dettAll.getIdAllegato(),
					theModel.getAppDataprogressivoSelezionato(), theModel.getAppDatamoduloSelezionato());

			theModel.setAppDatareeTipo2DettCircuito(circuito);

			// impostazione del result code 
			result.setResultCode(CARICACIRCUITO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaCircuito] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaReeDett definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo2Dett
	 */
	public ExecResults salvaReeDett(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo2.CpGestReeTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAREEDETT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAREEDETT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1048531719) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Tipo2Dett tipo2Dett = theModel.getAppDatareeTipo2Dett();
				Tipo2DettCircuito tipo2DettCircuito = theModel.getAppDatareeTipo2DettCircuito();
				DettaglioAllegato dettaglioAllegato = theModel.getAppDataallegato();

				// verifico che abbia compilato la scheda
				getValidationMgr().validazioneFormaleReeTipo2Dett(tipo2Dett);

				getValidationMgr().validazioneFormaleReeTipo2DettCircuito(tipo2DettCircuito,
						dettaglioAllegato.getDataControllo());

				getDbMgr().salvaReeTipo2Dett(tipo2Dett, tipo2DettCircuito,
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				// recupero nuovamente i dati per aggiornare la lista da compilare
				List<SigitTDettTipo2Dto> tDettTipo2List = getDbMgr().getDettTipo2(
						ConvertUtil.convertToString(tipo2Dett.getCodImpianto()),
						theModel.getAppDataprogressivoSelezionato(),
						ConvertUtil.convertToString(tipo2Dett.getIdAllegato()));

				tipo2Dett = MapDto.mapToTipo2Dett(tipo2Dett, tDettTipo2List);

				theModel.setAppDatareeTipo2Dett(tipo2Dett);

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
	 * ContentPanel cpGestReeTipo2Dett
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo2.CpGestReeTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALLEGATI_IMPIANTO = //NOSONAR  Reason:EIAS
				"ELENCO_ALLEGATI_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI = //NOSONAR  Reason:EIAS
				"RISULTATO_RICERCA_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2041318917) ENABLED START*/
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
	 * ContentPanel cpGestReeTipo2Dett
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo2.CpGestReeTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R483454171) ENABLED START*/
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
	 * Implementazione del metodo caricaReeTipo2Dett definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo2Dett
	 */
	public ExecResults caricaReeTipo2Dett(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo2.CpGestReeTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAREETIPO2DETT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-160978973) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			caricaDettaglio(theModel);

			//theModel.setAppDataelencoFluido(getSigitMgr().getListFluido());

			// impostazione del result code 
			result.setResultCode(CARICAREETIPO2DETT_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaReeTipo2Dett] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciRicaricaPagina definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo2Dett
	 */
	public ExecResults gestisciRicaricaPagina(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo2.CpGestReeTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIRICARICAPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1923387396) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

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
	 * ContentPanel cpGestReeTipo2Dett
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo2.CpGestReeTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R881007203) ENABLED START*/
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
	/*PROTECTED REGION ID(R1911491356) ENABLED START*/
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

	private Tipo2DettCircuito recuperaModuloSelez(String codImpianto, String idAllegato, Integer progressivo,
			String circuitoSelez) throws ManagerException {
		Tipo2DettCircuito circuito = getSigitMgr().caricaDatiReeTipo2DettCircuito(codImpianto, idAllegato, progressivo,
				circuitoSelez);

		return circuito;
	}

	private void caricaDettaglio(it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo2.CpGestReeTipo2DettModel theModel)
			throws Exception {

		try {
			DettaglioAllegato dettAll = theModel.getAppDataallegato();

			Tipo2Dett tipo2Dett = getSigitMgr().caricaDatiReeTipo2Dett(dettAll.getIdAllegato(),
					theModel.getAppDataprogressivoSelezionato());

			List<SigitTDettTipo2Dto> tDettTipo2List = getDbMgr().getDettTipo2(dettAll.getCodiceImpianto(),
					theModel.getAppDataprogressivoSelezionato(), dettAll.getIdAllegato());

			tipo2Dett = MapDto.mapToTipo2Dett(tipo2Dett, tDettTipo2List);

			theModel.setAppDatareeTipo2Dett(tipo2Dett);

			// Setto la combo dei moduli
			ArrayList<CodeDescription> circuitiList = MapDto.mapToCircuiti(tDettTipo2List);
			theModel.setAppDataelencoModuli(circuitiList);

			// Setto come default il primo modulo
			String circuitoDefault = circuitiList.get(0).getCode();

			theModel.setAppDatamoduloSelezionato(circuitoDefault);

			// Devo recuperare il circuito selezionato
			Tipo2DettCircuito circuito = recuperaModuloSelez(ConvertUtil.convertToString(tipo2Dett.getCodImpianto()),
					ConvertUtil.convertToString(tipo2Dett.getIdAllegato()),
					ConvertUtil.convertToInteger(tipo2Dett.getProgressivo()), circuitoDefault);
			theModel.setAppDatareeTipo2DettCircuito(circuito);
		} catch (Exception e) {
			throw e;
		}
	}

	/*PROTECTED REGION END*/
}
