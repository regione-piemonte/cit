package it.csi.sigit.sigitwebn.business.acquista_bollini;

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

/*PROTECTED REGION ID(R1271406974) ENABLED START*/
import java.math.BigDecimal;

import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;

/*PROTECTED REGION END*/

public class CPBECpAcquistaBollini {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [acquistaBollini, scope:USER_SESSION]
	public static final String APPDATA_ACQUISTABOLLINI_CODE = "appDataacquistaBollini";

	// ApplicationData: [elencoAcquistaBolliniQuantita, scope:USER_SESSION]
	public static final String APPDATA_ELENCOACQUISTABOLLINIQUANTITA_CODE = "appDataelencoAcquistaBolliniQuantita";

	// ApplicationData: [transazioneApp, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONEAPP_CODE = "appDatatransazioneApp";

	// ApplicationData: [aggiornaElencoBollini, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOBOLLINI_CODE = "appDataaggiornaElencoBollini";

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpAcquistaBollini";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaImpresa definito in un ExecCommand del
	 * ContentPanel cpAcquistaBollini
	 */
	public ExecResults cercaImpresa(

			it.csi.sigit.sigitwebn.dto.acquista_bollini.CpAcquistaBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAIMPRESA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1884821410) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("DENTRO AQUISISCI BOLLINI --> cercaImpresa***********");
			try {

				AcquistoBollini acquisisciBollini = theModel.getAppDataacquistaBollini();
				//verifica se sono stati valorizzati dall'utente
				getValidationMgr().verificaManutentore(acquisisciBollini.getCodiceFiscaleImpresa(),
						acquisisciBollini.getIdSiglaRea(), acquisisciBollini.getNumeroRea(),
						ConstantsField.ACQUISTA_BOLLINI_CF, ConstantsField.ACQUISTA_BOLLINI_ID_SIGLA_REA,
						ConstantsField.ACQUISTA_BOLLINI_NUMERO_REA);

				PersonaGiuridica installatore = getSigitMgr().cercaPersonaGiuridica(
						acquisisciBollini.getCodiceFiscaleImpresa(), acquisisciBollini.getIdSiglaRea(),
						acquisisciBollini.getNumeroRea());

				if (installatore != null) {

					//mi e' stato chiesto di far vedere comunque i dati della ditta
					//sia se e' cessata sia se e' attiva

					acquisisciBollini.setCodiceFiscaleImpresa(ReplaceSpecialCharUtils.sanitize(installatore.getCodiceFiscale()));
					acquisisciBollini.setIdSiglaRea(ReplaceSpecialCharUtils.sanitize(installatore.getSiglaRea()));
					acquisisciBollini.setNumeroRea(installatore.getNumeroRea());
					acquisisciBollini.setDenominazioneImpresa(ReplaceSpecialCharUtils.sanitize(installatore.getDenominazione()));

					acquisisciBollini.setIdInstallatore(installatore.getIdPersonaGiuridica());

					//adesso controllo la data di cessazione
					if (GenericUtil.isNullOrEmpty(installatore.getDataCessazione())) {
						// impostazione del result code
						result.setResultCode(CERCAIMPRESA_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors()
								.add(new Message(Messages.S0100, installatore.getDataCessazione()).getText());

						// impostazione del result code
						result.setResultCode(CERCAIMPRESA_OUTCOME_CODE__KO);
					}

				} else {
					result.getGlobalErrors().add(Messages.ERROR_IMPRESA_NON_TROVATA);

					// impostazione del result code
					result.setResultCode(CERCAIMPRESA_OUTCOME_CODE__KO);
				}

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaImpresa definito in un ExecCommand del
	 * ContentPanel cpAcquistaBollini
	 */
	public ExecResults nuovaRicercaImpresa(

			it.csi.sigit.sigitwebn.dto.acquista_bollini.CpAcquistaBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAIMPRESA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1832330158) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// E' stato premuto "Nuova ricerca", pulisco l'id installatore 
			theModel.getAppDataacquistaBollini().setIdInstallatore(null);

			// impostazione del result code 
			result.setResultCode(NUOVARICERCAIMPRESA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo pulisciAcquistaBollini definito in un ExecCommand del
	 * ContentPanel cpAcquistaBollini
	 */
	public ExecResults pulisciAcquistaBollini(

			it.csi.sigit.sigitwebn.dto.acquista_bollini.CpAcquistaBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PULISCIACQUISTABOLLINI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PULISCIACQUISTABOLLINI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1644938598) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//devo cancellare anche tutti gli elementi che l'utente ha selezionato
			AcquistoBollini acquistoBoll = theModel.getAppDataacquistaBollini();

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();

			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {

				acquistoBoll.setIdSiglaRea("");
				acquistoBoll.setNumeroRea(null);
				acquistoBoll.setCodiceFiscaleImpresa("");
				acquistoBoll.setDenominazioneImpresa("");
				acquistoBoll.setIdInstallatore(null);

			}

			ArrayList<AcquistoBolliniQuantita> elenco = theModel.getAppDataelencoAcquistaBolliniQuantita();

			if (elenco != null && elenco.size() > 0) {
				ArrayList<AcquistoBolliniQuantita> elencoBollini = new ArrayList<AcquistoBolliniQuantita>();
				AcquistoBolliniQuantita acqBollQuan = null;
				for (AcquistoBolliniQuantita dto : elenco) {
					acqBollQuan = new AcquistoBolliniQuantita();
					acqBollQuan.setDataInizioAcquisto(ReplaceSpecialCharUtils.sanitize(dto.getDataInizioAcquisto()));
					acqBollQuan.setDescrizione(ReplaceSpecialCharUtils.sanitize(dto.getDescrizione()));
					acqBollQuan.setIdPotenza(dto.getIdPotenza());
					acqBollQuan.setIdPrezzo(dto.getIdPrezzo());
					acqBollQuan.setPrezzo(dto.getPrezzo());
					acqBollQuan.setQuantita(null);
					elencoBollini.add(acqBollQuan);
				}
				theModel.setAppDataelencoAcquistaBolliniQuantita(elencoBollini);
			}

			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
				// impostazione del result code 
				result.setResultCode(PULISCIACQUISTABOLLINI_OUTCOME_CODE__OK);
			} else {
				// impostazione del result code 
				result.setResultCode(PULISCIACQUISTABOLLINI_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::pulisciAcquistaBollini] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo acquistaBollini definito in un ExecCommand del
	 * ContentPanel cpAcquistaBollini
	 */
	public ExecResults acquistaBollini(

			it.csi.sigit.sigitwebn.dto.acquista_bollini.CpAcquistaBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ACQUISTABOLLINI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ACQUISTABOLLINI_OUTCOME_CODE__OK_PAGAMENTO = //NOSONAR  Reason:EIAS
				"OK_PAGAMENTO"; //NOSONAR  Reason:EIAS
		final String ACQUISTABOLLINI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R974047905) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				ArrayList<AcquistoBolliniQuantita> acquistoBollList = theModel
						.getAppDataelencoAcquistaBolliniQuantita();

				AcquistoBollini acquistoBoll = theModel.getAppDataacquistaBollini();

				//				log.debug("Stampo acquistoBollList: "
				//						+ acquistoBollList);

				//				if (acquistoBollList != null) {
				//					log.debug("NON e' nullo (size): "
				//							+ acquistoBollList.size());
				//					for (AcquistoBolliniQuantita acquistoBolliniQuantita : acquistoBollList) {
				//						GenericUtil.stampa(acquistoBolliniQuantita, false, 3);
				//					}
				//				} else {
				//					log.debug("E' NULLO");
				//				}

				getValidationMgr().validazioneFormaleAcquistoBollini(acquistoBollList, acquistoBoll);

				BigDecimal totAcquisto = calcolaTotale(acquistoBollList);

				TransazioneApp transazione = null;
				if (totAcquisto.doubleValue() > 0) {
					//transazione = getServiziMgr().initTransazione();

					transazione.setAmount(totAcquisto.doubleValue());
					transazione.setCcy(Constants.DESC_VALUTA_PAGAMENTO_EUR);
				}

				// Adesso c'è l'assegnazione automatica dei bollini
				//				getDbMgr().salvaTransazioneTrans(acquistoBoll, acquistoBollList, transazione,
				//						theModel.getAppDatautenteLoggato());

				theModel.setAppDatatransazioneApp(transazione);

				if (transazione != null) {
					// Vado nel pagamento
					// impostazione del result code 
					result.setResultCode(ACQUISTABOLLINI_OUTCOME_CODE__OK_PAGAMENTO);
				} else {
					theModel.setAppDataaggiornaElencoBollini(true);

					theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
							new Message(Messages.INFO_INSERIMENTO_CORRETTO, Message.INFO));

					// impostazione del result code 
					result.setResultCode(ACQUISTABOLLINI_OUTCOME_CODE__OK);
				}

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::acquistaBollini] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initAcquistaBollini definito in un ExecCommand del
	 * ContentPanel cpAcquistaBollini
	 */
	public ExecResults initAcquistaBollini(

			it.csi.sigit.sigitwebn.dto.acquista_bollini.CpAcquistaBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITACQUISTABOLLINI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R291441745) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//TransazioneApp transazione = getServiziMgr().initTransazione();
			//inizializzo l'oggetto in sessione
			AcquistoBollini acquistoBoll = theModel.getAppDataacquistaBollini();
			if (acquistoBoll == null) {
				acquistoBoll = new AcquistoBollini();
			}

			acquistoBoll.setCodiceFiscaleOp(theModel.getAppDatautenteLoggato().getCodiceFiscale());
			acquistoBoll.setDataAcquisto(DateUtil.getDataCorrenteFormat());
			//metto a video in codice bollino 'RP'che viene passato al db come parametro 
			//nel caso in cui viene passato l'oggetto AcquistoBollini
			acquistoBoll.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
			theModel.setAppDataacquistaBollini(acquistoBoll);

			ArrayList<AcquistoBolliniQuantita> acqBolliniQta = getSigitMgr().settaPrezziBollino(acquistoBoll);

			theModel.setAppDataelencoAcquistaBolliniQuantita(acqBolliniQta);

			// impostazione del result code 
			result.setResultCode(INITACQUISTABOLLINI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initAcquistaBollini] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cancellaQuantitaBollini definito in un ExecCommand del
	 * ContentPanel cpAcquistaBollini
	 */
	public ExecResults cancellaQuantitaBollini(

			it.csi.sigit.sigitwebn.dto.acquista_bollini.CpAcquistaBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CANCELLAQUANTITABOLLINI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1399016262) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();

			ArrayList<AcquistoBolliniQuantita> elenco = theModel.getAppDataelencoAcquistaBolliniQuantita();

			if (elenco != null && elenco.size() > 0) {
				ArrayList<AcquistoBolliniQuantita> elencoBollini = new ArrayList<AcquistoBolliniQuantita>();
				AcquistoBolliniQuantita acqBollQuan = null;
				for (AcquistoBolliniQuantita dto : elenco) {
					acqBollQuan = new AcquistoBolliniQuantita();
					acqBollQuan.setDataInizioAcquisto(dto.getDataInizioAcquisto());
					acqBollQuan.setDescrizione(dto.getDescrizione());
					acqBollQuan.setIdPotenza(dto.getIdPotenza());
					acqBollQuan.setIdPrezzo(dto.getIdPrezzo());
					acqBollQuan.setPrezzo(dto.getPrezzo());
					acqBollQuan.setQuantita(null);
					elencoBollini.add(acqBollQuan);
				}
				theModel.setAppDataelencoAcquistaBolliniQuantita(elencoBollini);
			}

			//nel caso di SUPER, VALIDATORE devo ripulire anche la maschera di ricerca
			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
				AcquistoBollini acquisisciBollini = ripulisciCampi(theModel.getAppDataacquistaBollini());
				theModel.setAppDataacquistaBollini(acquisisciBollini);
			}

			// impostazione del result code 
			result.setResultCode(CANCELLAQUANTITABOLLINI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cancellaQuantitaBollini] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioni definito in un ExecCommand del
	 * ContentPanel cpAcquistaBollini
	 */
	public ExecResults gestisciAbilitazioni(

			it.csi.sigit.sigitwebn.dto.acquista_bollini.CpAcquistaBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONI_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONI_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1318138885) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();

			//questo oggetto e' gia' stato inizializzato dal metodo precedente
			AcquistoBollini acquisisciBollini = theModel.getAppDataacquistaBollini();

			//adesso controllo che utente si e' loggato e in base all'utente lo dirotto nei due casi

			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIABILITAZIONI_OUTCOME_CODE__ABILITA);
			} else {
				// Imposto i dati (non saranno modificabili)

				if (GenericUtil.isNullOrEmpty(acquisisciBollini.getIdInstallatore())) {
					acquisisciBollini.setIdInstallatore(ruoloUtLog.getIdPersonaGiuridica());
					acquisisciBollini.setIdSiglaRea(ruoloUtLog.getSiglaRea());
					acquisisciBollini.setNumeroRea(ConvertUtil.convertToUDTPositiveInteger(ruoloUtLog.getNumeroRea()));
					acquisisciBollini.setCodiceFiscaleImpresa(ruoloUtLog.getCodiceFiscale());
					acquisisciBollini.setDenominazioneImpresa(ruoloUtLog.getDenomDitta());
				}

				// impostazione del result code 
				result.setResultCode(GESTISCIABILITAZIONI_OUTCOME_CODE__DISABILITA);
			}

			theModel.setAppDataacquistaBollini(acquisisciBollini);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilitazioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneProfiloInstallatore definito in un ExecCommand del
	 * ContentPanel cpAcquistaBollini
	 */
	public ExecResults gestioneProfiloInstallatore(

			it.csi.sigit.sigitwebn.dto.acquista_bollini.CpAcquistaBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEPROFILOINSTALLATORE_OUTCOME_CODE__ABILITA_INSTALLATORE = //NOSONAR  Reason:EIAS
				"ABILITA_INSTALLATORE"; //NOSONAR  Reason:EIAS
		final String GESTIONEPROFILOINSTALLATORE_OUTCOME_CODE__DISABILITA_INSTALLATORE = //NOSONAR  Reason:EIAS
				"DISABILITA_INSTALLATORE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-506618064) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();

			log.debug("FRAAAAAAAAAAAAAAAAAAAAAA ---> RUOLO " + ruoloUtLog.getDescRuolo());
			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
				log.debug("FRAAAAAAAAAAAAAAAAAAAAAA ---> VADO SOTTO ABILITA INSTALLATORE");
				// impostazione del result code 
				result.setResultCode(GESTIONEPROFILOINSTALLATORE_OUTCOME_CODE__ABILITA_INSTALLATORE);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTIONEPROFILOINSTALLATORE_OUTCOME_CODE__DISABILITA_INSTALLATORE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneProfiloInstallatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tQuantita
	 */
	public static void resetClearStatus_widg_tQuantita(java.util.Map session) {
		session.put("cpAcquistaBollini_tQuantita_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1613251920) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private ServiziMgr serviziMgr;

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private BigDecimal calcolaTotale(ArrayList<AcquistoBolliniQuantita> acquistoBollList) {
		BigDecimal totale = new BigDecimal(0);

		for (AcquistoBolliniQuantita acqBolliniQta : acquistoBollList) {

			if (GenericUtil.isNotNullOrEmpty(acqBolliniQta.getQuantita())) {
				Double totParziale = (acqBolliniQta.getPrezzo() * acqBolliniQta.getQuantita());
				totale = totale.add(new BigDecimal(totParziale));

			}

		}

		return totale;

	}

	private AcquistoBollini ripulisciCampi(AcquistoBollini bollini) {
		AcquistoBollini value = bollini;
		value.setCodiceFiscaleImpresa("");
		value.setDenominazioneImpresa("");
		value.setIdInstallatore(null);
		value.setIdSiglaRea("");
		value.setNumeroRea(null);
		return value;
	}

	/*PROTECTED REGION END*/
}
