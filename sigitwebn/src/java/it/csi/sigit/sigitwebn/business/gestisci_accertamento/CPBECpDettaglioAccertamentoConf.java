package it.csi.sigit.sigitwebn.business.gestisci_accertamento;

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

/*PROTECTED REGION ID(R538892403) ENABLED START*/

import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.dto.accertamento.RicercaImpiantoDaAssociare;

/*PROTECTED REGION END*/

public class CPBECpDettaglioAccertamentoConf {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [accertamento, scope:USER_SESSION]
	public static final String APPDATA_ACCERTAMENTO_CODE = "appDataaccertamento";

	// ApplicationData: [elencoTipoAnomalie, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOANOMALIE_CODE = "appDataelencoTipoAnomalie";

	// ApplicationData: [idAccertamentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDACCERTAMENTOSELEZIONATO_CODE = "appDataidAccertamentoSelezionato";

	// ApplicationData: [verifica, scope:USER_SESSION]
	public static final String APPDATA_VERIFICA_CODE = "appDataverifica";

	// ApplicationData: [elencoTipoConclusione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOCONCLUSIONE_CODE = "appDataelencoTipoConclusione";

	// ApplicationData: [elencoValidatori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOVALIDATORI_CODE = "appDataelencoValidatori";

	// ApplicationData: [ricercaImpiantoDaAssociareAccertamento, scope:USER_SESSION]
	public static final String APPDATA_RICERCAIMPIANTODAASSOCIAREACCERTAMENTO_CODE = "appDataricercaImpiantoDaAssociareAccertamento";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettaglioAccertamentoConf";

	public static final String MULTIPANEL_MPCONCLUDIACC = "mpConcludiAcc";
	public static final String MPI_MPCONCLUDIACC_FPCONCLUDIACC = CPNAME + "_" + MULTIPANEL_MPCONCLUDIACC + "_"
			+ "fpConcludiAcc";
	public static final String MPI_MPCONCLUDIACC_FPASSOCIAACC = CPNAME + "_" + MULTIPANEL_MPCONCLUDIACC + "_"
			+ "fpAssociaAcc";
	public static final String MPI_MPCONCLUDIACC_FPASSOCIACODIMP = CPNAME + "_" + MULTIPANEL_MPCONCLUDIACC + "_"
			+ "fpAssociaCodImp";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaImpianto definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamentoConf
	 */
	public ExecResults cercaImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoConfModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-339098819) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				getSigitMgr().ricercaImpiantoPerAccertamento(theModel.getAppDataaccertamento(), true);
				// impostazione del result code 
				result.setResultCode(CERCAIMPIANTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
				result.setResultCode(CERCAIMPIANTO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaImpianto definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamentoConf
	 */
	public ExecResults nuovaRicercaImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoConfModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1268781375) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Accertamento accertamento = theModel.getAppDataaccertamento();
			if (accertamento != null) {
				accertamento.setCodiceImpianto(null);
				accertamento.setCodIstatProv(null);
				accertamento.setRisultatoImpianto(null);
			}
			// impostazione del result code 
			result.setResultCode(NUOVARICERCAIMPIANTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaConclusione definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamentoConf
	 */
	public ExecResults salvaConclusione(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoConfModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVACONCLUSIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVACONCLUSIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1756192597) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				//CONTROLLO SULLA PRESENZA DI OGGETTI COLLEGATI ALLA VERIFICA

				getValidationMgr().validazioneFormaleConcludiAccertamento(theModel.getAppDataaccertamento());

				getConnectorMgr().concludiAccertamentoTrans(theModel.getAppDataaccertamento(),
						theModel.getAppDatautenteLoggato());

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.MSG_AGGIORNAMENTO_CORRETTO, Message.INFO));

				result.setResultCode(SALVACONCLUSIONE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaConclusione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaAssociazione definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamentoConf
	 */
	public ExecResults salvaAssociazione(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoConfModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAASSOCIAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAASSOCIAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1709097053) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				getValidationMgr().validazioneFormaleAssociaAccertamento(theModel.getAppDataaccertamento());

				String infoEmail = getSigitMgr().associaAccertamento(
						theModel.getAppDataaccertamento().getIdentificativo(),
						theModel.getAppDataaccertamento().getIdValidatore(), theModel.getAppDatautenteLoggato());

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.MSG_AGGIORNAMENTO_CORRETTO + infoEmail, Message.INFO));

				result.setResultCode(SALVAASSOCIAZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaAssociazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaCodiceImpiantoDaAssociare definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamentoConf
	 */
	public ExecResults cercaCodiceImpiantoDaAssociare(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoConfModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCACODICEIMPIANTODAASSOCIARE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCACODICEIMPIANTODAASSOCIARE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-469103989) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				getValidationMgr().validazioneFormaleAssociaCodiceImpiantoAccertamento(
						theModel.getAppDataricercaImpiantoDaAssociareAccertamento());
				/*
				if (theModel.getAppDataricercaImpiantoDaAssociareAccertamento() == null || GenericUtil.isNullOrEmpty(
						theModel.getAppDataricercaImpiantoDaAssociareAccertamento().getCodiceImpianto())) {
					ValidationManagerException ex = new ValidationManagerException();
					ex.addFieldRequired(
							CPBECpDettaglioAccertamentoConf.APPDATA_RICERCAIMPIANTODAASSOCIAREACCERTAMENTO_CODE
									+ ".codiceImpianto");
					throw ex;
				}
				*/
				getSigitMgr()
						.ricercaImpiantoPerAccertamento(theModel.getAppDataricercaImpiantoDaAssociareAccertamento());

				log.debug("cercaCodiceImpiantoDaAssociare: stampo getAppDataricercaImpiantoDaAssociareAccertamento");
				if (log.isDebugEnabled())
					GenericUtil.stampa(theModel.getAppDataricercaImpiantoDaAssociareAccertamento(), true, 3);

				// impostazione del result code 
				result.setResultCode(CERCACODICEIMPIANTODAASSOCIARE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaCodiceImpiantoDaAssociare] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo resettaRicercaCodiceImpiantoDaAssociare definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamentoConf
	 */
	public ExecResults resettaRicercaCodiceImpiantoDaAssociare(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoConfModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RESETTARICERCACODICEIMPIANTODAASSOCIARE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-882838112) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//deve essere resettato l'appdata della ricerca dell'impianto
			theModel.setAppDataricercaImpiantoDaAssociareAccertamento(new RicercaImpiantoDaAssociare());

			result.setResultCode(RESETTARICERCACODICEIMPIANTODAASSOCIARE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::resettaRicercaCodiceImpiantoDaAssociare] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaAssociazioneCodImpianto definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamentoConf
	 */
	public ExecResults salvaAssociazioneCodImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoConfModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAASSOCIAZIONECODIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAASSOCIAZIONECODIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1199703490) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				RicercaImpiantoDaAssociare ricerca = theModel.getAppDataricercaImpiantoDaAssociareAccertamento();

				Accertamento accertamento = theModel.getAppDataaccertamento();

				if (log.isDebugEnabled()) {
					GenericUtil.stampa(theModel.getAppDataricercaImpiantoDaAssociareAccertamento(), true, 3);
					GenericUtil.stampa(ricerca, true, 3);
					GenericUtil.stampa(accertamento, true, 3);
				}

				getSigitMgr().associaImpiantoAdAccertamento(ricerca.getCodiceImpianto(), ricerca.getCodIstatProv(),
						accertamento.getIdentificativo(), theModel.getAppDatautenteLoggato());

				//impostazioni per il refresh della pagina
				//theModel.setAppDataaggiornaDati(Boolean.TRUE);

				//theModel.setAppDatamessaggioDinamico(null);

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.MSG_AGGIORNAMENTO_CORRETTO, Message.INFO));

				result.setResultCode(SALVAASSOCIAZIONECODIMPIANTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaAssociazioneCodImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamentoConf
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoConfModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1021704096) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isUtenteAbilitatoRicercaVerificheAccertamentiIspezioniSanzioni(utente)) {
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
	 * Implementazione del metodo gestisciConferma definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamentoConf
	 */
	public ExecResults gestisciConferma(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoConfModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICONFERMA_OUTCOME_CODE__CONCLUDI = //NOSONAR  Reason:EIAS
				"CONCLUDI"; //NOSONAR  Reason:EIAS
		final String GESTISCICONFERMA_OUTCOME_CODE__ASSOCIA = //NOSONAR  Reason:EIAS
				"ASSOCIA"; //NOSONAR  Reason:EIAS
		final String GESTISCICONFERMA_OUTCOME_CODE__ASSOCIA_IMP = //NOSONAR  Reason:EIAS
				"ASSOCIA_IMP"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1573824980) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Accertamento accertamento = theModel.getAppDataaccertamento();
			Integer idTipoConferma = accertamento.getIdTipoConferma();

			log.debug("idTipoConferma: " + idTipoConferma);

			if (idTipoConferma == Constants.ID_TIPO_CONFERMA_CONCLUDI) {
				if (theModel.getAppDataelencoTipoConclusione() == null) {
					theModel.setAppDataelencoTipoConclusione(getSigitMgr().getElencoTipoConclusioni());
				}
				// impostazione del result code 
				result.setResultCode(GESTISCICONFERMA_OUTCOME_CODE__CONCLUDI);
			} else if (idTipoConferma == Constants.ID_TIPO_CONFERMA_ASSOCIA) {

				theModel.setAppDataelencoValidatori(getSigitMgr().getElencoValidatoriIdPf(true));

				// impostazione del result code 
				result.setResultCode(GESTISCICONFERMA_OUTCOME_CODE__ASSOCIA);
			} else if (idTipoConferma == Constants.ID_TIPO_CONFERMA_ASSOCIA_IMP) {

				log.debug("Entro nell'associa impianto");
				theModel.setAppDataricercaImpiantoDaAssociareAccertamento(new RicercaImpiantoDaAssociare());

				// impostazione del result code 
				result.setResultCode(GESTISCICONFERMA_OUTCOME_CODE__ASSOCIA_IMP);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciConferma] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciCodImpianto definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamentoConf
	 */
	public ExecResults gestisciCodImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoConfModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICODIMPIANTO_OUTCOME_CODE__PRESENTE = //NOSONAR  Reason:EIAS
				"PRESENTE"; //NOSONAR  Reason:EIAS
		final String GESTISCICODIMPIANTO_OUTCOME_CODE__ASSENTE = //NOSONAR  Reason:EIAS
				"ASSENTE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2029476130) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (GenericUtil.isNullOrEmpty(theModel.getAppDataaccertamento().getCodiceImpianto())) {
				// impostazione del result code 
				result.setResultCode(GESTISCICODIMPIANTO_OUTCOME_CODE__ASSENTE);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCICODIMPIANTO_OUTCOME_CODE__PRESENTE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciCodImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R2068207451) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private ConnectorMgr connectorMgr;

	public ConnectorMgr getConnectorMgr() {
		return connectorMgr;
	}

	public void setConnectorMgr(ConnectorMgr connectorMgr) {
		this.connectorMgr = connectorMgr;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	public enum RicercaCampoAccertamentoEnum {
		RICERCA_IMPIANTO
	}

	/*PROTECTED REGION END*/
}
