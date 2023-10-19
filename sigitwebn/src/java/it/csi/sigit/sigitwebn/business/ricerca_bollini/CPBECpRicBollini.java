package it.csi.sigit.sigitwebn.business.ricerca_bollini;

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

/*PROTECTED REGION ID(R-2095259463) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;

/*PROTECTED REGION END*/

public class CPBECpRicBollini {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoBollini, scope:USER_SESSION]
	public static final String APPDATA_ELENCOBOLLINI_CODE = "appDataelencoBollini";

	// ApplicationData: [ricercaBollini, scope:USER_SESSION]
	public static final String APPDATA_RICERCABOLLINI_CODE = "appDataricercaBollini";

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [aggiornaElencoBollini, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOBOLLINI_CODE = "appDataaggiornaElencoBollini";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoSiglaBollini, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLABOLLINI_CODE = "appDataelencoSiglaBollini";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicBollini";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaBollini definito in un ExecCommand del
	 * ContentPanel cpRicBollini
	 */
	public ExecResults ricercaBollini(

			it.csi.sigit.sigitwebn.dto.ricerca_bollini.CpRicBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCABOLLINI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCABOLLINI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-505868030) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				RicercaTransazione ricBollini = theModel.getAppDataricercaBollini();

				getValidationMgr().validazioneFormaleRicercaBollini(ricBollini);

				// Questo metodo effettua la ricerca e controlla che non ci siano troppi elementi
				//				getSigitMgr().cercaElencoBolliniCount(ricBollini);

				theModel.setAppDataaggiornaElencoBollini(true);

				// impostazione del result code 
				result.setResultCode(RICERCABOLLINI_OUTCOME_CODE__OK);

				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaBollini] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ripulisciCampiSelezionati definito in un ExecCommand del
	 * ContentPanel cpRicBollini
	 */
	public ExecResults ripulisciCampiSelezionati(

			it.csi.sigit.sigitwebn.dto.ricerca_bollini.CpRicBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RIPULISCICAMPISELEZIONATI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R435872833) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();

			RicercaTransazione ricCodici = new RicercaTransazione();

			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)) {
				// Non faccio niente 
			} else {

				// Imposto i dati (non saranno modificabili)
				ricCodici.setIdSiglaRea(ruoloUtLog.getSiglaRea());
				ricCodici.setNumeroRea(ConvertUtil.convertToUDTPositiveInteger(ruoloUtLog.getNumeroRea()));
				ricCodici.setCodiceFiscale(ruoloUtLog.getCodiceFiscale());
			}

			theModel.setAppDataricercaBollini(ricCodici);

			// impostazione del result code 
			result.setResultCode(RIPULISCICAMPISELEZIONATI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ripulisciCampiSelezionati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initRicercaBollini definito in un ExecCommand del
	 * ContentPanel cpRicBollini
	 */
	public ExecResults initRicercaBollini(

			it.csi.sigit.sigitwebn.dto.ricerca_bollini.CpRicBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITRICERCABOLLINI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1802174162) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			RicercaTransazione ricBollini = theModel.getAppDataricercaBollini();

			if (ricBollini == null) {
				ricBollini = new RicercaTransazione();
			}

			// Setto la sigla bollino old
			//ricBollini.setSiglaBollino(Constants.SIGLA_BOLLINO_RP); e' diventata una combo e non piu' un testo

			//setto la combo dela sigla bollini
			ArrayList<CodeDescription> elencoSiglaBollini = getServiziMgr().getListaSiglaProvincePiemonteManipolata();

			if (elencoSiglaBollini != null)
				theModel.setAppDataelencoSiglaBollini(elencoSiglaBollini);
			else {
				elencoSiglaBollini = new ArrayList<CodeDescription>();
			}

			//valorizzo la combo
			theModel.setAppDataelencoSiglaBollini(elencoSiglaBollini);

			theModel.setAppDataricercaBollini(ricBollini);

			/*
			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();
			
			RicercaTransazione ricBollini = theModel.getAppDataricercaBollini();
			
			if (ricBollini == null) {
				ricBollini = new RicercaTransazione();
			}
			
			// Imposto i dati (non saranno modificabili)
			ricBollini.setIdSiglaRea(ruoloUtLog.getSiglaRea());
			ricBollini.setNumeroRea(ruoloUtLog.getNumeroRea());
			ricBollini.setCodiceFiscale(ruoloUtLog.getCodiceFiscale());
			 */

			// impostazione del result code 
			result.setResultCode(INITRICERCABOLLINI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initRicercaBollini] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioniEnt definito in un ExecCommand del
	 * ContentPanel cpRicBollini
	 */
	public ExecResults gestisciAbilitazioniEnt(

			it.csi.sigit.sigitwebn.dto.ricerca_bollini.CpRicBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONIENT_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONIENT_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R265742851) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = gestisciAbilRuoloRef(theModel, GESTISCIABILITAZIONIENT_OUTCOME_CODE__ABILITA,
					GESTISCIABILITAZIONIENT_OUTCOME_CODE__DISABILITA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilitazioniEnt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaResetVis definito in un ExecCommand del
	 * ContentPanel cpRicBollini
	 */
	public ExecResults gestisciLogicaResetVis(

			it.csi.sigit.sigitwebn.dto.ricerca_bollini.CpRicBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1652871903) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataricercaBollini() == null) {

				// impostazione del result code 
				result.setResultCode(GESTISCILOGICARESETVIS_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICARESETVIS_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciLogicaResetVis] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioniRef definito in un ExecCommand del
	 * ContentPanel cpRicBollini
	 */
	public ExecResults gestisciAbilitazioniRef(

			it.csi.sigit.sigitwebn.dto.ricerca_bollini.CpRicBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONIREF_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONIREF_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1649034075) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = gestisciAbilRuoloRef(theModel, GESTISCIABILITAZIONIREF_OUTCOME_CODE__ABILITA,
					GESTISCIABILITAZIONIREF_OUTCOME_CODE__DISABILITA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilitazioniRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-633333157) ENABLED START*/
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

	private ServiziMgr serviziMgr;

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private ExecResults gestisciAbilRuoloRef(it.csi.sigit.sigitwebn.dto.ricerca_bollini.CpRicBolliniModel theModel,
			String codRetABILITA, String codRetDISABILITA) throws DbManagerException {

		ExecResults result = new ExecResults();
		// inserire qui la logica applicativa da eseguire:

		Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();

		RicercaTransazione ricCodici = theModel.getAppDataricercaBollini();

		if (ricCodici == null) {
			ricCodici = new RicercaTransazione();
		}

		if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
				|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)) {
			// impostazione del result code 
			result.setResultCode(codRetABILITA);
		} else {
			// Imposto i dati (non saranno modificabili)
			ricCodici.setIdSiglaRea(ruoloUtLog.getSiglaRea());
			ricCodici.setNumeroRea(ConvertUtil.convertToUDTPositiveInteger(ruoloUtLog.getNumeroRea()));
			ricCodici.setCodiceFiscale(ruoloUtLog.getCodiceFiscale());
			//ricCodici.setCodiceFiscale(theModel.getAppDatautenteLoggato().getCodiceFiscale());

			// impostazione del result code 
			result.setResultCode(codRetDISABILITA);
		}

		theModel.setAppDataricercaBollini(ricCodici);
		// modifica degli attributi del model (che verranno propagati allo strato
		// di presentation). si puo' agire anche direttamente sull'attributo "session".

		result.setModel(theModel);
		return result;

	}

	/*PROTECTED REGION END*/
}
