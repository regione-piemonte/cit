package it.csi.sigit.sigitwebn.business.back_office;

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

/*PROTECTED REGION ID(R-1145200623) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;

/*PROTECTED REGION END*/

public class CPBECpGestSubentroMassivo {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [elencoImpreseAttuali, scope:USER_SESSION]
	public static final String APPDATA_ELENCOIMPRESEATTUALI_CODE = "appDataelencoImpreseAttuali";

	// ApplicationData: [elencoImpreseSubentro, scope:USER_SESSION]
	public static final String APPDATA_ELENCOIMPRESESUBENTRO_CODE = "appDataelencoImpreseSubentro";

	// ApplicationData: [impresaAttuale, scope:USER_SESSION]
	public static final String APPDATA_IMPRESAATTUALE_CODE = "appDataimpresaAttuale";

	// ApplicationData: [impresaSubentro, scope:USER_SESSION]
	public static final String APPDATA_IMPRESASUBENTRO_CODE = "appDataimpresaSubentro";

	// ApplicationData: [idTipoSubentro, scope:USER_SESSION]
	public static final String APPDATA_IDTIPOSUBENTRO_CODE = "appDataidTipoSubentro";

	// ApplicationData: [elencoRuolo, scope:USER_SESSION]
	public static final String APPDATA_ELENCORUOLO_CODE = "appDataelencoRuolo";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestSubentroMassivo";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaImpresaAttuale definito in un ExecCommand del
	 * ContentPanel cpGestSubentroMassivo
	 */
	public ExecResults cercaImpresaAttuale(

			it.csi.sigit.sigitwebn.dto.back_office.CpGestSubentroMassivoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAIMPRESAATTUALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAIMPRESAATTUALE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R993127815) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				getValidationMgr().verificaRicercaImpresaAttuale(theModel.getAppDataimpresaAttuale());

				theModel.setAppDataelencoImpreseAttuali(
						getSigitMgr().cercaPersonaGiuridica(theModel.getAppDataimpresaAttuale(), false));

				// impostazione del result code 
				result.setResultCode(CERCAIMPRESAATTUALE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaImpresaAttuale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaImpresaSubentro definito in un ExecCommand del
	 * ContentPanel cpGestSubentroMassivo
	 */
	public ExecResults cercaImpresaSubentro(

			it.csi.sigit.sigitwebn.dto.back_office.CpGestSubentroMassivoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAIMPRESASUBENTRO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAIMPRESASUBENTRO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-863230045) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				getValidationMgr().verificaRicercaImpresaSubentro(theModel.getAppDataimpresaSubentro());

				theModel.setAppDataelencoImpreseSubentro(
						getSigitMgr().cercaPersonaGiuridica(theModel.getAppDataimpresaSubentro(), true));

				// impostazione del result code 
				result.setResultCode(CERCAIMPRESASUBENTRO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaImpresaSubentro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eseguiSubentroMassivo definito in un ExecCommand del
	 * ContentPanel cpGestSubentroMassivo
	 */
	public ExecResults eseguiSubentroMassivo(

			it.csi.sigit.sigitwebn.dto.back_office.CpGestSubentroMassivoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ESEGUISUBENTROMASSIVO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ESEGUISUBENTROMASSIVO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-754435604) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				getValidationMgr().verificaSubentroMassivo(theModel.getAppDataimpresaAttuale().getIdPersonaGiuridica(),
						theModel.getAppDataimpresaSubentro().getIdPersonaGiuridica(),
						theModel.getAppDataidTipoSubentro());

				int numSubentri = getSigitMgr().effettuaSubentroMassivo(
						theModel.getAppDataimpresaAttuale().getIdPersonaGiuridica(),
						theModel.getAppDataimpresaSubentro().getIdPersonaGiuridica(),
						theModel.getAppDataidTipoSubentro(), theModel.getAppDatautenteLoggato().getCodiceFiscale());

				result.getGlobalMessages().add(Messages.INFO_SUBENTRO_CORRETTO + " su " + numSubentri + " impianti");

				// impostazione del result code 
				result.setResultCode(ESEGUISUBENTROMASSIVO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eseguiSubentroMassivo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestSubentroMassivo
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.back_office.CpGestSubentroMassivoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1396396290) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoBackOffice(utente)) {
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
	 * Implementazione del metodo inizializzaGestSubentro definito in un ExecCommand del
	 * ContentPanel cpGestSubentroMassivo
	 */
	public ExecResults inizializzaGestSubentro(

			it.csi.sigit.sigitwebn.dto.back_office.CpGestSubentroMassivoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZAGESTSUBENTRO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZAGESTSUBENTRO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1772833103) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDataelencoRuolo(GenericUtil.getComboTipoSubentro());

			theModel.setAppDataelencoImpreseAttuali(new ArrayList<IdDescription>());
			theModel.setAppDataelencoImpreseSubentro(new ArrayList<IdDescription>());

			// impostazione del result code 
			result.setResultCode(INIZIALIZZAGESTSUBENTRO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaGestSubentro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-625753923) ENABLED START*/
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

	/*PROTECTED REGION END*/
}
