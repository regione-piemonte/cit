package it.csi.sigit.sigitwebn.business.acquisisci_codici_impianto;

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

/*PROTECTED REGION ID(R-806069363) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;

/*PROTECTED REGION END*/

public class CPBECpAcquisisciCodici {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [ricercaCodImpianto, scope:USER_SESSION]
	public static final String APPDATA_RICERCACODIMPIANTO_CODE = "appDataricercaCodImpianto";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [aggiornaElencoCodImpianto, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOCODIMPIANTO_CODE = "appDataaggiornaElencoCodImpianto";

	// ApplicationData: [acquisizioneCodiciImpianto, scope:USER_SESSION]
	public static final String APPDATA_ACQUISIZIONECODICIIMPIANTO_CODE = "appDataacquisizioneCodiciImpianto";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpAcquisisciCodici";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaInstallatore definito in un ExecCommand del
	 * ContentPanel cpAcquisisciCodici
	 */
	public ExecResults cercaInstallatore(

			it.csi.sigit.sigitwebn.dto.acquisisci_codici_impianto.CpAcquisisciCodiciModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINSTALLATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINSTALLATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1539801768) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				AcquisizioneCodici acquCodici = theModel.getAppDataacquisizioneCodiciImpianto();

				if (log.isDebugEnabled())
					GenericUtil.stampa(acquCodici, true, 2);

				getValidationMgr().verificaManutentore(acquCodici.getCodiceFiscale(), acquCodici.getIdSiglaRea(),
						acquCodici.getNumeroRea(), ConstantsField.ACQUISISCI_CODICE_CF,
						ConstantsField.ACQUISISCI_CODICE_SIGLA_REA, ConstantsField.ACQUISISCI_CODICE_NUM_REA);

				PersonaGiuridica installatore = getSigitMgr().cercaPersonaGiuridica(acquCodici.getCodiceFiscale(),
						acquCodici.getIdSiglaRea(), acquCodici.getNumeroRea());

				if (log.isDebugEnabled())
					GenericUtil.stampa(installatore, true, 3);

				if (installatore != null) {
					//mi e' stato chiesto di far vedere i dati dell'impresa ricercata
					//sia nel caso di ditta cessata che attiva
					acquCodici.setCodiceFiscale(ReplaceSpecialCharUtils.sanitize(installatore.getCodiceFiscale()));
					acquCodici.setIdSiglaRea(ReplaceSpecialCharUtils.sanitize(installatore.getSiglaRea()));
					acquCodici.setNumeroRea(installatore.getNumeroRea());
					acquCodici.setImpresa(ReplaceSpecialCharUtils.sanitize(installatore.getDenominazione()));

					acquCodici.setIdInstallatore(installatore.getIdPersonaGiuridica());

					if (log.isDebugEnabled())
						GenericUtil.stampa(acquCodici, true, 3);

					//adesso controllo la data di cessazione

					if (GenericUtil.isNullOrEmpty(installatore.getDataCessazione())) {
						// impostazione del result code
						result.setResultCode(CERCAINSTALLATORE_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors()
								.add(new Message(Messages.S014, installatore.getDataCessazione()).getText());

						// impostazione del result code
						result.setResultCode(CERCAINSTALLATORE_OUTCOME_CODE__KO);
					}

					/*if (GenericUtil.isNullOrEmpty(installatore
							.getDataCessazione())) {
					
						acquCodici.setCodiceFiscale(installatore
								.getCodiceFiscale());
						acquCodici.setIdSiglaRea(installatore.getSiglaRea());
						acquCodici.setNumeroRea(ConvertUtil
								.convertToUDTPositiveInteger(installatore
										.getNumeroRea()));
						acquCodici.setImpresa(installatore.getDenominazione());
					
						acquCodici.setIdInstallatore(installatore
								.getIdPersonaGiuridica());
					
						GenericUtil.stampa(acquCodici, false, 3);
					
					
						// impostazione del result code
						result.setResultCode(CERCAINSTALLATORE_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add(
								new Message(Messages.S014, installatore
										.getDataCessazione()).getText());
					
						// impostazione del result code
						result.setResultCode(CERCAINSTALLATORE_OUTCOME_CODE__KO);
					}*/

				} else {
					result.getGlobalErrors().add(Messages.ERROR_IMPRESA_NON_TROVATA);

					// impostazione del result code
					result.setResultCode(CERCAINSTALLATORE_OUTCOME_CODE__KO);
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
			log.error("[BackEndFacade::cercaInstallatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaInstallatore definito in un ExecCommand del
	 * ContentPanel cpAcquisisciCodici
	 */
	public ExecResults nuovaRicercaInstallatore(

			it.csi.sigit.sigitwebn.dto.acquisisci_codici_impianto.CpAcquisisciCodiciModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINSTALLATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAINSTALLATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1560449078) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// E' stato premuto "Nuova ricerca", pulisco l'id installatore 
			theModel.getAppDataacquisizioneCodiciImpianto().setIdInstallatore(null);

			// impostazione del result code 
			result.setResultCode(NUOVARICERCAINSTALLATORE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaInstallatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo pulisciRicercaCodici definito in un ExecCommand del
	 * ContentPanel cpAcquisisciCodici
	 */
	public ExecResults pulisciRicercaCodici(

			it.csi.sigit.sigitwebn.dto.acquisisci_codici_impianto.CpAcquisisciCodiciModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PULISCIRICERCACODICI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-846430089) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();

			AcquisizioneCodici acquCodici = new AcquisizioneCodici();

			acquCodici.setDataConsegna(DateUtil.getDataCorrenteFormat());
			acquCodici.setAcquisitiDa(ReplaceSpecialCharUtils.sanitize(theModel.getAppDatautenteLoggato().getCodiceFiscale()));

			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
				// non faccio niente 

			} else {
				// Imposto i dati (non saranno modificabili)
				acquCodici.setIdInstallatore(ruoloUtLog.getIdPersonaGiuridica());
				acquCodici.setIdSiglaRea(ReplaceSpecialCharUtils.sanitize(ruoloUtLog.getSiglaRea()));
				acquCodici.setNumeroRea(ConvertUtil.convertToUDTPositiveInteger(ruoloUtLog.getNumeroRea()));
				acquCodici.setCodiceFiscale(ReplaceSpecialCharUtils.sanitize(ruoloUtLog.getCodiceFiscale()));
				acquCodici.setImpresa(ReplaceSpecialCharUtils.sanitize(ruoloUtLog.getDenomDitta()));

			}

			theModel.setAppDataacquisizioneCodiciImpianto(acquCodici);

			// impostazione del result code 
			result.setResultCode(PULISCIRICERCACODICI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::pulisciRicercaCodici] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaInstallatoreAnn definito in un ExecCommand del
	 * ContentPanel cpAcquisisciCodici
	 */
	public ExecResults gestLogicaInstallatoreAnn(

			it.csi.sigit.sigitwebn.dto.acquisisci_codici_impianto.CpAcquisisciCodiciModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAINSTALLATOREANN_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAINSTALLATOREANN_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1239829695) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();

			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICAINSTALLATOREANN_OUTCOME_CODE__ABILITA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICAINSTALLATOREANN_OUTCOME_CODE__DISABILITA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaInstallatoreAnn] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo acquisisciCodiciImpianto definito in un ExecCommand del
	 * ContentPanel cpAcquisisciCodici
	 */
	public ExecResults acquisisciCodiciImpianto(

			it.csi.sigit.sigitwebn.dto.acquisisci_codici_impianto.CpAcquisisciCodiciModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ACQUISISCICODICIIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ACQUISISCICODICIIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R334042162) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				AcquisizioneCodici acquisizioneCodici = theModel.getAppDataacquisizioneCodiciImpianto();

				getValidationMgr().validazioneFormaleAcquisizioneCodici(acquisizioneCodici);

				// Adesso c'è l'assegnazione automatica dei bollini
				//				getDbMgr().salvaAcquisizioneCodiciTrans(acquisizioneCodici,
				//						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				theModel.setAppDataaggiornaElencoCodImpianto(true);

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.INFO_INSERIMENTO_CORRETTO, Message.INFO));

				// impostazione del result code 
				result.setResultCode(ACQUISISCICODICIIMPIANTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::acquisisciCodiciImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioni definito in un ExecCommand del
	 * ContentPanel cpAcquisisciCodici
	 */
	public ExecResults gestisciAbilitazioni(

			it.csi.sigit.sigitwebn.dto.acquisisci_codici_impianto.CpAcquisisciCodiciModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONI_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONI_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1609714070) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();

			if (log.isDebugEnabled())
				GenericUtil.stampa(ruoloUtLog, true, 2);

			AcquisizioneCodici acquCodici = theModel.getAppDataacquisizioneCodiciImpianto();

			if (acquCodici == null) {
				acquCodici = new AcquisizioneCodici();
			}

			acquCodici.setDataConsegna(DateUtil.getDataCorrenteFormat());
			acquCodici.setAcquisitiDa(theModel.getAppDatautenteLoggato().getCodiceFiscale());

			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIABILITAZIONI_OUTCOME_CODE__ABILITA);
			} else {
				// Imposto i dati (non saranno modificabili)

				if (GenericUtil.isNullOrEmpty(acquCodici.getIdInstallatore())) {
					acquCodici.setIdInstallatore(ruoloUtLog.getIdPersonaGiuridica());
					acquCodici.setIdSiglaRea(ruoloUtLog.getSiglaRea());
					acquCodici.setNumeroRea(ConvertUtil.convertToUDTPositiveInteger(ruoloUtLog.getNumeroRea()));
					acquCodici.setCodiceFiscale(ruoloUtLog.getCodiceFiscale());
					acquCodici.setImpresa(ruoloUtLog.getDenomDitta());
				}

				// impostazione del result code 
				result.setResultCode(GESTISCIABILITAZIONI_OUTCOME_CODE__DISABILITA);
			}

			theModel.setAppDataacquisizioneCodiciImpianto(acquCodici);

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
	 * Implementazione del metodo gestLogicaInstallatore definito in un ExecCommand del
	 * ContentPanel cpAcquisisciCodici
	 */
	public ExecResults gestLogicaInstallatore(

			it.csi.sigit.sigitwebn.dto.acquisisci_codici_impianto.CpAcquisisciCodiciModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAINSTALLATORE_OUTCOME_CODE__ABILITA_INSTALLATORE = //NOSONAR  Reason:EIAS
				"ABILITA_INSTALLATORE"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAINSTALLATORE_OUTCOME_CODE__DISABILITA_INSTALLATORE = //NOSONAR  Reason:EIAS
				"DISABILITA_INSTALLATORE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1764812856) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataacquisizioneCodiciImpianto() == null
					|| GenericUtil.isNullOrEmpty(theModel.getAppDataacquisizioneCodiciImpianto().getIdInstallatore())) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICAINSTALLATORE_OUTCOME_CODE__ABILITA_INSTALLATORE);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICAINSTALLATORE_OUTCOME_CODE__DISABILITA_INSTALLATORE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaInstallatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1842547513) ENABLED START*/
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

	/*PROTECTED REGION END*/
}
