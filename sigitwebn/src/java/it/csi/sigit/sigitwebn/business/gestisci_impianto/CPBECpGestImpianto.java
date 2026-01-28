package it.csi.sigit.sigitwebn.business.gestisci_impianto;

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

/*PROTECTED REGION ID(R-1908348480) ENABLED START*/
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaAllegati;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportFilter;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.LibrettoDocument;

import java.io.File;
import java.io.FileReader;
/*PROTECTED REGION END*/

public class CPBECpGestImpianto {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [impianto, scope:USER_SESSION]
	public static final String APPDATA_IMPIANTO_CODE = "appDataimpianto";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoStatoImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATOIMPIANTO_CODE = "appDataelencoStatoImpianto";

	// ApplicationData: [elencoIndirizzi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZI_CODE = "appDataelencoIndirizzi";

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoComuniResp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIRESP_CODE = "appDataelencoComuniResp";

	// ApplicationData: [elencoIndirizziResp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZIRESP_CODE = "appDataelencoIndirizziResp";

	// ApplicationData: [elencoTitoli, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTITOLI_CODE = "appDataelencoTitoli";

	// ApplicationData: [responsabile, scope:USER_SESSION]
	public static final String APPDATA_RESPONSABILE_CODE = "appDataresponsabile";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [idResponsabileSelez, scope:USER_SESSION]
	public static final String APPDATA_IDRESPONSABILESELEZ_CODE = "appDataidResponsabileSelez";

	// ApplicationData: [elencoManutentori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMANUTENTORI_CODE = "appDataelencoManutentori";

	// ApplicationData: [elencoResponsabili, scope:USER_SESSION]
	public static final String APPDATA_ELENCORESPONSABILI_CODE = "appDataelencoResponsabili";

	// ApplicationData: [elencoResponsabiliTemp, scope:USER_SESSION]
	public static final String APPDATA_ELENCORESPONSABILITEMP_CODE = "appDataelencoResponsabiliTemp";

	// ApplicationData: [elencoProvincePiemonte, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTE_CODE = "appDataelencoProvincePiemonte";

	// ApplicationData: [paginaChiamanteImp, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEIMP_CODE = "appDatapaginaChiamanteImp";

	// ApplicationData: [isAbilitazioneDatiAllegato, scope:USER_SESSION]
	public static final String APPDATA_ISABILITAZIONEDATIALLEGATO_CODE = "appDataisAbilitazioneDatiAllegato";

	// ApplicationData: [aggiornaElencoImpianti, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOIMPIANTI_CODE = "appDataaggiornaElencoImpianti";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [provenienza, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZA_CODE = "appDataprovenienza";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [paginaChiamanteDocumenti, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDOCUMENTI_CODE = "appDatapaginaChiamanteDocumenti";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [elencoImpiantiGraffati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOIMPIANTIGRAFFATI_CODE = "appDataelencoImpiantiGraffati";

	// ApplicationData: [impiantoApprofondito, scope:USER_SESSION]
	public static final String APPDATA_IMPIANTOAPPROFONDITO_CODE = "appDataimpiantoApprofondito";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestImpianto";

	public static final String MULTIPANEL_MPINSTALLATOREOLD = "mpInstallatoreOLD";
	public static final String MPI_MPINSTALLATOREOLD_FPINSTALLATORE = CPNAME + "_" + MULTIPANEL_MPINSTALLATOREOLD + "_"
			+ "fpInstallatore";

	public static final String MULTIPANEL_MPIMPORTLIBRETTO = "mpImportLibretto";
	public static final String MPI_MPIMPORTLIBRETTO_FUNIMPORTLIBRETTO = CPNAME + "_" + MULTIPANEL_MPIMPORTLIBRETTO + "_"
			+ "FunImportLibretto";

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
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults cercaInstallatore(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINSTALLATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINSTALLATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1292847835) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Impianto impianto = theModel.getAppDataimpianto();

				if (log.isDebugEnabled())
					GenericUtil.stampa(impianto, true, 2);

				getValidationMgr().verificaManutentore(impianto.getInstCf(), impianto.getInstIdSiglaRea(),
						impianto.getInstNumeroRea(), ConstantsField.GESTISCI_IMPIANTO_INST_CF,
						ConstantsField.GESTISCI_IMPIANTO_INST_SIGLA_REA, ConstantsField.GESTISCI_IMPIANTO_INST_NUM_REA);

				PersonaGiuridica installatore = getSigitMgr().cercaPersonaGiuridica(impianto.getInstCf(),
						impianto.getInstIdSiglaRea(), impianto.getInstNumeroRea());

				if (installatore != null) {
					impianto.setInstCf(installatore.getCodiceFiscale());
					impianto.setInstIdSiglaRea(installatore.getSiglaRea());
					impianto.setInstNumeroRea(installatore.getNumeroRea());
					impianto.setInstImpresa(installatore.getDenominazione());
					impianto.setInstId(installatore.getIdPersonaGiuridica());

					log.debug("STAMPO L'iD INSTALLATORE TROVATO: " + impianto.getInstId());

					// impostazione del result code
					result.setResultCode(CERCAINSTALLATORE_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add(Messages.I003);

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
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults nuovaRicercaInstallatore(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINSTALLATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAINSTALLATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1522907299) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// E' stato premuto "Nuova ricerca", pulisco l'id installatore 
			theModel.getAppDataimpianto().setInstId(null);

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
	 * Implementazione del metodo preparaAperturaApprofondisciImpianto definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults preparaAperturaApprofondisciImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAAPERTURAAPPROFONDISCIIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAAPERTURAAPPROFONDISCIIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1716914104) ENABLED START*/
			Impianto imp = theModel.getAppDataimpianto();
			if (GenericUtil.isNotNullOrEmpty(imp)) {
				ArrayList<ElencoImpiantiGraffati> elencoImpiantiGraffatiList = getDbMgr()
						.getElencoImpiantiGraffatiByCodImpianto(imp.getImpCodImpianto());
				theModel.setAppDataelencoImpiantiGraffati(elencoImpiantiGraffatiList);
				theModel.setAppDataimpiantoApprofondito(imp);
				result.setResultCode(PREPARAAPERTURAAPPROFONDISCIIMPIANTO_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add("Errore nel recupero dell'impianto selezionato.");
				result.setResultCode(PREPARAAPERTURAAPPROFONDISCIIMPIANTO_OUTCOME_CODE__KO);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAperturaApprofondisciImpianto] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaCodImpMotiv definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestLogicaCodImpMotiv(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICACODIMPMOTIV_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICACODIMPMOTIV_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R355889524) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = theModel.getAppDataimpianto();

			log.debug("#### impianto.getImpIdStatoImp(): " + impianto.getImpIdStatoImp());
			log.debug("#### impianto.getImpIdStatoImpOld(): " + impianto.getImpIdStatoImpOld());

			if (GenericUtil.isNotNullOrEmpty(impianto.getImpIdStatoImp())
					&& ConvertUtil.convertToInteger(impianto.getImpIdStatoImp()).intValue() != ConvertUtil
							.convertToInteger(impianto.getImpIdStatoImpOld()).intValue()) {
				// Sono in inserimento o modifica
				log.debug("***ABILITA_MOTIVAZIONE***\n\n");

				// Pulisco i campi che eventualmente erano valorizzati
				impianto.setImpDataDismissione(null);
				impianto.setImpMotivazione(null);

				// impostazione del result code 
				result.setResultCode(GESTLOGICACODIMPMOTIV_OUTCOME_CODE__ABILITA);

			} else {

				// Pulisco i campi che eventualmente erano valorizzati
				impianto.setImpDataDismissione(impianto.getImpDataDismissioneOld());
				impianto.setImpMotivazione(impianto.getImpMotivazioneOld());

				if (GenericUtil.isNotNullOrEmpty(impianto.getImpId())) {
					log.debug("***DISABILITA_MOTIVAZIONE***\n\n");
					// impostazione del result code 
					result.setResultCode(GESTLOGICACODIMPMOTIV_OUTCOME_CODE__DISABILITA);
				} else {

					log.debug("***ABILITA_MOTIVAZIONE (primo accesso) ***\n\n");
					// impostazione del result code 
					result.setResultCode(GESTLOGICACODIMPMOTIV_OUTCOME_CODE__ABILITA);
				}

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaCodImpMotiv] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuniImp definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults loadComuniImp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNIIMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-502278618) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<CodeDescription> comuniLoc = recuperaComuni(theModel.getAppDataimpianto().getImpLocIdProvincia());

			theModel.setAppDataelencoComuni(comuniLoc);

			// impostazione del result code 
			result.setResultCode(LOADCOMUNIIMP_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadComuniImp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaIndirizzoImp definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults cercaIndirizzoImp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINDIRIZZOIMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINDIRIZZOIMP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-847508815) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Impianto impianto = theModel.getAppDataimpianto();

				getValidationMgr().verificaRicercaIndirizzoIdentificazioneImpianto(impianto);

				theModel.setAppDataelencoIndirizzi(getServiziMgr().getListaVieValide(
						ReplaceSpecialCharUtils.sanitize(impianto.getImpLocIndirizzo()),
						ReplaceSpecialCharUtils.sanitize(impianto.getImpLocIdComune())));
				//				setVisibilitaIndirizzoImpianto(theModel);

				impianto.getLogicaVisual().setIsImpiantoIndConfermato(true);

				// impostazione del result code 
				result.setResultCode(CERCAINDIRIZZOIMP_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				log.debug("\n\n\n##################### INTERCETTO L'eccezione");
				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato 
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaIndirizzoImp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaIndirizzoImp definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults nuovaRicercaIndirizzoImp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINDIRIZZOIMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-617449351) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = theModel.getAppDataimpianto();

			impianto.setImpLocIndirizzoSitad(null);
			impianto.setImpLocIdIndirizzo(null);
			impianto.setImpLocIndirizzo(null);
			impianto.setImpLocIndirizzoNoStrad(null);

			theModel.getAppDataimpianto().getLogicaVisual().setIsImpiantoIndConfermato(false);

			// impostazione del result code 
			result.setResultCode(NUOVARICERCAINDIRIZZOIMP_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaIndirizzoImp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaImpiano definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults salvaImpiano(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAIMPIANO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAIMPIANO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1118913889) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = theModel.getAppDataimpianto();
			boolean isInserimento = impianto.getImpId() == null;

			try {
				UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

				Ruolo ruoloUtente = utenteLoggato.getRuolo();

				if (isInserimento) {
					// SONO IN INSERIMENTO

					// Nel caso il ruolo sia ISPETTORE e non abbia inserito il codice impianto, si puo' proseguire, il codice impianto gli verra' assegnato d'ufficio.
					//					if (!(utenteLoggato.getRuolo().getDescRuolo().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)
					//							&& GenericUtil.isNullOrEmpty(impianto.getImpCodImpianto()))) {
					//
					//						// verifico il codice impianto
					//						getValidationMgr().verificaCodiceImpiantoIdentificazione(impianto);
					//
					//					}

					if (GenericUtil.isNotNullOrEmpty(impianto.getImpCodImpianto())) {

						// se l'utente indica il codice impianto lo verifico, altrimenti gliene viene assegnato uno di default
						getValidationMgr().verificaCodiceImpiantoIdentificazione(impianto.getImpCodImpianto());

					}

					getValidationMgr().validazioneFormaleSalvaImpianto(impianto, false, ruoloUtente.getDescRuolo());

				} else {
					// SONO IN MODIFICA
					// se siamo nel caso di modifica impianto (Caso B) verificare se vi e' stata una modifica anche dell'ubicazione dell'impianto, 
					// verificare la presenza di almeno un libretto in stato CONSOLIDATO. 
					// Se presente la modifica di questa informazione e' possibile solo per il profilo "VALIDATORE" e "SUPER"; 
					// per tutti gli altri profili tale modifica non puo' essere possibile: emettere quindi il messaggio S027

					getValidationMgr().validazioneFormaleSalvaImpianto(impianto, false, ruoloUtente.getDescRuolo(),
							ruoloUtente.getIdPersonaGiuridica());

					if (!(ruoloUtente.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
							|| ruoloUtente.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
							|| ruoloUtente.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_ISPETTORE))) {
						getValidationMgr().verificaModificaUbicazioneImpiantoIdentificazione(impianto);
					}

				}

				String descComune = GenericUtil.getDescriptionByCod(impianto.getImpLocIdComune(),
						theModel.getAppDataelencoComuni());

				String descProvincia = GenericUtil.getDescriptionByCod(impianto.getImpLocIdProvincia(),
						theModel.getAppDataelencoProvince());

				// Vuol dire che il comune/provincia non esiste più, quindi l'utente ne deve impostare un altro
				if (GenericUtil.isNullOrEmpty(descProvincia) || GenericUtil.isNullOrEmpty(descComune)) {
					log.debug("descProvincia: " + descProvincia);
					log.debug("descComune: " + descComune);
					log.debug("Rilancio l'eccezione!!!!!");
					throw new ValidationManagerException(new Message(Messages.ERROR_UPDATE_PROV_COM));
				}

				impianto.setImpLocDescComune(ReplaceSpecialCharUtils.sanitize(descComune));
				impianto.setImpLocDescProvincia(ReplaceSpecialCharUtils.sanitize(descProvincia));

				if (GenericUtil.isNotNullOrEmpty(impianto.getImpLocIdIndirizzo())) {
					String descIndirizzoSitad = GenericUtil.getDescriptionByCod(impianto.getImpLocIdIndirizzo(),
							theModel.getAppDataelencoIndirizzi());

					impianto.setImpLocIndirizzoSitad(ReplaceSpecialCharUtils.sanitize(descIndirizzoSitad));
				}

				getSigitMgr().aggiungiCoordinateAdImpianto(impianto);

				impianto = getDbMgr().salvaImpiantoTrans(impianto, ruoloUtente.getDescRuolo(), utenteLoggato);

				// Setto all'old il nuovo stato impianto, cosi' nel caso del salvaggio riesco a capire se e' stato modificato
				impianto.setImpIdStatoImpOld(ReplaceSpecialCharUtils.sanitize(impianto.getImpIdStatoImp()));
				impianto.setImpDataDismissioneOld(ReplaceSpecialCharUtils.sanitize(impianto.getImpDataDismissione()));
				impianto.setImpMotivazioneOld(ReplaceSpecialCharUtils.sanitize(impianto.getImpMotivazione()));

				if (isInserimento) {

					if (theModel.getAppDataimpianto().getLogicaVisual().getCaso().intValue() == Constants.COD_CASO_A) {
						// Siccome ho inserito passo dal CASO_A al CASO_B (modifica)
						theModel.getAppDataimpianto().getLogicaVisual().setCaso(Constants.COD_CASO_B);
					}

					//					impianto.getLogicaVisual().setIsBotVisLibrettoVisibile(
					//							GenericUtil.isNotNullOrEmpty(impianto
					//									.getLibDataRilascio()));
					//					impianto.getLogicaVisual().setIsBotInsModLibrettoVisibile(
					//							true);
					//					impianto.getLogicaVisual().setIsBotConsLibrettoVisibile(
					//							Constants.LABEL_SI.equalsIgnoreCase(impianto
					//									.getLibIsModifica()));
					//					impianto.getLogicaVisual().setIsBotElimLibrettoVisibile(
					//							Constants.LABEL_SI.equalsIgnoreCase(impianto
					//									.getLibIsModifica()));
					//
					//					impianto.getLogicaVisual().setIsBotRappControlloVisibile(
					//							Constants.LABEL_SI.equalsIgnoreCase(impianto
					//									.getLibIsModifica()));

					//impianto.setLibIsModifica(ConvertUtil.convertToString(false));

					theModel.setAppDataimpianto(impianto);

					result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_CORRETTO);

				} else {
					// SONO IN MODIFICA

					result.getGlobalMessages().add(Messages.INFO_MODIFICA_CORRETTA);

				}

				// impostazione del result code 
				result.setResultCode(SALVAIMPIANO_OUTCOME_CODE__OK);

				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaImpiano] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cessaProprietario definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults cessaProprietario(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CESSAPROPRIETARIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CESSAPROPRIETARIO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R364356158) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Impianto impianto = theModel.getAppDataimpianto();

				getValidationMgr().verificaCessaProprietario(impianto.getProprietario());

				getSigitMgr().cessaProprietario(impianto.getProprietario(), theModel.getAppDatautenteLoggato());

				result.getGlobalMessages().add(Messages.INFO_MODIFICA_CORRETTA);

				// Ripulisco il proprietario
				impianto.setProprietario(null);
				theModel.setAppDataimpianto(impianto);

				// impostazione del result code 
				result.setResultCode(CESSAPROPRIETARIO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				log.debug("\n\n\n##################### INTERCETTO L'eccezione");
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato 
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cessaProprietario] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciProprietario definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults inserisciProprietario(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIPROPRIETARIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIPROPRIETARIO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1241509618) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impiantoDB = getDbMgr()
					.cercaImpiantoById(ConvertUtil.convertToString(theModel.getAppDataimpianto().getImpId()));

			Responsabile responsabile = new Responsabile();
			responsabile.setFlgImpresa(false);
			responsabile.setFlgResponsabile(false);

			responsabile.setIdProvincia(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIdProvincia()));
			responsabile.setIdComune(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIdComune()));
			responsabile.setIdIndirizzo(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIdIndirizzo()));
			responsabile.setIndirizzoSitad(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIndirizzoSitad()));
			responsabile.setIndirizzoNoStrad(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIndirizzoNoStrad()));

			responsabile.setCivico(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocCivico()));

			settaComuneVieResponsabile(theModel, responsabile);

			theModel.setAppDataresponsabile(responsabile);

			//settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE);

			theModel.getAppDataimpianto().getLogicaVisual().setIsResponsabileIndConfermato(true);

			theModel.setAppDatapaginaChiamanteImp(Constants.PAG_GEST_IMPIANTI);

			// impostazione del result code 
			result.setResultCode(INSERISCIPROPRIETARIO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciProprietario] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciResponsabile definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults inserisciResponsabile(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIRESPONSABILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIRESPONSABILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1219318027) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//			ArrayList<RisultatoRicResponsabile> responsabiliList = theModel
			//					.getAppDataelencoResponsabili();
			//
			//			boolean isAmmessoInsert = true;
			//
			//			if (responsabiliList != null && responsabiliList.size() > 0) {
			//				for (RisultatoRicResponsabile risultatoRicResponsabile : responsabiliList) {
			//					if (GenericUtil.isNullOrEmpty(risultatoRicResponsabile
			//							.getDataRespAl())) {
			//						isAmmessoInsert = false;
			//
			//						break;
			//					}
			//				}
			//			}
			//
			//			if (isAmmessoInsert) {

			Impianto impiantoDB = getDbMgr()
					.cercaImpiantoById(ConvertUtil.convertToString(theModel.getAppDataimpianto().getImpId()));

			Responsabile responsabile = new Responsabile();
			responsabile.setFlgImpresa(false);
			responsabile.setFlgResponsabile(true);

			responsabile.setIdProvincia(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIdProvincia()));
			responsabile.setIdComune(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIdComune()));
			responsabile.setIdIndirizzo(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIdIndirizzo()));
			responsabile.setIndirizzoSitad(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIndirizzoSitad()));
			responsabile.setIndirizzoNoStrad(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIndirizzoNoStrad()));

			responsabile.setCivico(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocCivico()));

			settaComuneVieResponsabile(theModel, responsabile);

			theModel.setAppDataresponsabile(responsabile);

			settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE);

			theModel.getAppDataimpianto().getLogicaVisual().setIsResponsabileIndConfermato(true);

			theModel.setAppDatapaginaChiamanteImp(Constants.PAG_GEST_IMPIANTI);

			// impostazione del result code 
			result.setResultCode(INSERISCIRESPONSABILE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciResponsabile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo modificaResponsabile definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults modificaResponsabile(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String MODIFICARESPONSABILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String MODIFICARESPONSABILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R205276214) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idRespSelez = theModel.getAppDataidResponsabileSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idRespSelez);

				//				theModel.getAppDataimpianto()
				//						.getLogicaVisual()
				//						.setIdOperazioneResponsabile(
				//								Constants.COD_OP_MOD_RESPONSABILE);

				// Recupero il Responsabile dall'elenco 
				ArrayList<RisultatoRicResponsabile> responsabiliList = theModel.getAppDataelencoResponsabili();

				Responsabile responsabile = null;
				RisultatoRicResponsabile responsabileSelez = null;

				//				boolean isPersonaGiuridica = false;

				for (RisultatoRicResponsabile risultatoRicResponsabile : responsabiliList) {
					if (risultatoRicResponsabile.getIdImpResp().intValue() == ConvertUtil.convertToInteger(idRespSelez)
							.intValue()) {
						//responsabileSelez = risultatoRicResponsabile;
						//						isPersonaGiuridica = risultatoRicResponsabile
						//								.getIsImpresa().equalsIgnoreCase(
						//										Constants.LABEL_PG);

						responsabileSelez = risultatoRicResponsabile;
						responsabile = getSigitMgr().cercaResponsabileByRespSelez(responsabileSelez);

						if (!responsabile.getFlgIndirizzoEst()) {
							settaComuneVieResponsabile(theModel, responsabile);
						}

						theModel.getAppDataimpianto().getLogicaVisual().setIsResponsabileIndConfermato(true);

						if (responsabile.getFlgImpresa()) {

							settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE_IMPRESA);
						} else {
							settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE);
						}

						theModel.setAppDatapaginaChiamanteImp(Constants.PAG_GEST_IMPIANTI);

						// Setto il responsabile in sessione
						theModel.setAppDataresponsabile(responsabile);

						break;
					}
				}

				// impostazione del result code 
				result.setResultCode(MODIFICARESPONSABILE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::modificaResponsabile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo uploadFile definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults uploadFile(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String UPLOADFILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String UPLOADFILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R594608958) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Impianto impiantoInSessione = theModel.getAppDataimpianto();
			Integer idImpianto = impiantoInSessione.getImpId();
			String idImpiantoStr = ConvertUtil.convertToString(impiantoInSessione.getImpId());

			try {
				log.debug("inizio import xml");
				File file = theModel.getWidg_fuImpLib();
				if (file == null) {
					result.getGlobalErrors().add("Selezionare un file");
				} else {

					//				SigitTPreImportDto dtoPreImport = getSigitMgr()
					//						.inserisciPreImport(theModel.getAppDatautenteLoggato());
					//				
					// recupero la stringa in modo che posso salvarla sul DB
					String readFile = XmlBeanUtils.readFile(new FileReader(file));

					log.debug("elaborazione file");
					String nomeFile = theModel.getWidg_fuImpLibFileName();

					if (file == null || !nomeFile.toUpperCase().endsWith(".XML")) {

						throw new ValidationManagerException(new Message(Messages.S096, Constants.ESTENSIONE_XML));

					} else if (nomeFile.length() > Constants.MAX_NOME_FILE_LEN) {
						throw new ValidationManagerException(
								new Message(Messages.S160, ConvertUtil.convertToString(Constants.MAX_NOME_FILE_LEN)));
					}

					Integer idPersonaGiuridica = theModel.getAppDatautenteLoggato().getRuolo().getIdPersonaGiuridica();
					String codiceFiscale = theModel.getAppDatautenteLoggato().getCodiceFiscale();

					getServiziMgr().uploadXMLLibretto(idImpianto, XmlBeanUtils.readString(readFile), codiceFiscale,
							ConvertUtil.convertToString(idPersonaGiuridica));

					result.getGlobalMessages().add("Libretto importato correttamente");

					LogicaVisualizzazione logicaVis = impiantoInSessione.getLogicaVisual();

					Impianto impianto = getDbMgr().cercaImpiantoById(idImpiantoStr);

					impianto.setLogicaVisual(logicaVis);

					theModel.setAppDataimpianto(impianto);

					result.setResultCode(UPLOADFILE_OUTCOME_CODE__OK);
				}
			} catch (ServiceException ex) {
				result.setResultCode(UPLOADFILE_OUTCOME_CODE__KO);

				getDbMgr().deleteImportLibretto(idImpiantoStr);

				result.getGlobalErrors().add(ex.getMessage());
			} catch (ManagerException ex) {
				result.setResultCode(UPLOADFILE_OUTCOME_CODE__KO);

				getDbMgr().deleteImportLibretto(idImpiantoStr);

				Validator.gestisciEccezione(result, ex);
			}
			result.setModel(theModel);
			return result;

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::uploadFile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaLibretto definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults visualizzaLibretto(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZALIBRETTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZALIBRETTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-673516628) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpianto = ConvertUtil.convertToString(theModel.getAppDataimpianto().getImpId());

			// Setto in sessione le variabili che servono per creare il libretto
			theModel.getSession().put(Constants.SESSIONE_VAR_ID_IMPIANTO, idImpianto);

			// impostazione del result code 
			result.setResultCode(VISUALIZZALIBRETTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaLibretto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestRapportoControllo definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestRapportoControllo(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTRAPPORTOCONTROLLO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTRAPPORTOCONTROLLO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1456704233) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDatapaginaChiamanteImp(Constants.PAG_GEST_IMPIANTI);
			theModel.setAppDataisAbilitazioneDatiAllegato(false);
			log.debug("FRAAAAAAAAAAAAAA---> CODICE IMPIANTO: " + theModel.getAppDataimpianto().getImpCodImpianto());
			theModel.setAppDataidImpiantoSelez(theModel.getAppDataimpianto().getImpCodImpianto());

			// impostazione del result code 
			result.setResultCode(GESTRAPPORTOCONTROLLO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestRapportoControllo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestDocumentazione definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestDocumentazione(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTDOCUMENTAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTDOCUMENTAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R885445547) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Impianto impianto = theModel.getAppDataimpianto();

				theModel.setAppDataidImpiantoSelez(ReplaceSpecialCharUtils.sanitize(impianto.getImpCodImpianto()));

				IdentificativoImpianto identificativo = getSigitMgr()
						.cercaIdentificativoImpianto(ReplaceSpecialCharUtils.sanitize(impianto.getImpCodImpianto()));

				theModel.setAppDataidentificativoImpianto(identificativo);

				theModel.setAppDatapaginaChiamanteDocumenti(Constants.PAG_GEST_IMPIANTI);

				// impostazione del result code 
				result.setResultCode(GESTDOCUMENTAZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestDocumentazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLibrettoWeb definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestLibrettoWeb(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLIBRETTOWEB_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTLIBRETTOWEB_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1515035041) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Impianto impianto = theModel.getAppDataimpianto();

				theModel.setAppDataidImpiantoSelez(ReplaceSpecialCharUtils.sanitize(impianto.getImpCodImpianto()));

				IdentificativoImpianto identificativo = getSigitMgr()
						.cercaIdentificativoImpianto(impianto.getImpCodImpianto());

				theModel.setAppDataidentificativoImpianto(identificativo);

				theModel.setAppDatapaginaChiamante(Constants.PAG_GEST_IMPIANTI);

				// impostazione del result code 
				result.setResultCode(GESTLIBRETTOWEB_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLibrettoWeb] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAggLibretto definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestAggLibretto(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTAGGLIBRETTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTAGGLIBRETTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R708467716) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = theModel.getAppDataimpianto();

			theModel.setAppDataidImpiantoSelez(ReplaceSpecialCharUtils.sanitize(impianto.getImpCodImpianto()));

			IdentificativoImpianto identificativo = getSigitMgr()
					.cercaIdentificativoImpianto(impianto.getImpCodImpianto());

			theModel.setAppDataidentificativoImpianto(identificativo);

			theModel.setAppDatapaginaChiamante(Constants.PAG_GEST_IMPIANTI);

			// impostazione del result code 
			result.setResultCode(GESTAGGLIBRETTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAggLibretto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietro definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestisciIndietro(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRO_OUTCOME_CODE__RIC_IMPIANTO = //NOSONAR  Reason:EIAS
				"RIC_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO = //NOSONAR  Reason:EIAS
				"IMPIANTO"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__SUBENTRO = //NOSONAR  Reason:EIAS
				"SUBENTRO"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO_AVZ = //NOSONAR  Reason:EIAS
				"IMPIANTO_AVZ"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__GRAFFATURA = //NOSONAR  Reason:EIAS
				"GRAFFATURA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1149540074) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("torno indietro");
			if (theModel.getAppDataimpianto().getLogicaVisual() == null)
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO);
			else {
				Integer logica = theModel.getAppDataimpianto().getLogicaVisual().getCaso();

				String provenienza = theModel.getAppDataprovenienza();
				if (GenericUtil.isNotNullOrEmpty(provenienza)) {
					if (provenienza.equals(Constants.PAG_RIS_RIC_AVZ_IMPIANTI))
						result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO_AVZ);
					else if (provenienza.equals(Constants.PAG_RIC_IMPIANTI))
						result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__RIC_IMPIANTO);
					else if (provenienza.equals(Constants.PAG_ELEN_GRAFF))
						result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__GRAFFATURA);
					else
						result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO);
					theModel.setAppDataprovenienza(null);
				} else if (logica == Constants.COD_CASO_E) {
					// impostazione del result code 
					result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__SUBENTRO);
				} else if (logica == Constants.COD_CASO_F) {
					result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO_AVZ);
				} else {
					theModel.setAppDataaggiornaElencoImpianti(true);
					// impostazione del result code 
					result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO);
				}
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciIndietro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboInit definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestisciComboInit(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOINIT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1951252142) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("SONO IN IMPIANTO!!!!");

			ArrayList<CodeDescription> statoImpianto = theModel.getAppDataelencoStatoImpianto();

			if (log.isDebugEnabled())
				GenericUtil.stampa(statoImpianto, true, 2);

			if (statoImpianto == null) {
				statoImpianto = getDbMgr().cercaListaStatiImpianto();
				theModel.setAppDataelencoStatoImpianto(statoImpianto);
			}

			/*
			ArrayList<CodeDescription> titoliResp = theModel
					.getAppDataelencoTitoli();
			
			if (titoliResp == null) {
				titoliResp = getDbMgr().cercaListaRuoloByDescRuoloFunzionale(Constants.RUOLO_RESPONSABILE);
				theModel.setAppDataelencoTitoli(titoliResp);
			}
			 */

			//settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE);

			ArrayList<CodeDescription> comuniResp = new ArrayList<CodeDescription>();

			theModel.setAppDataelencoComuniResp(comuniResp);

			ArrayList<CodeDescription> indResp = new ArrayList<CodeDescription>();

			theModel.setAppDataelencoIndirizziResp(indResp);

			// impostazione del result code 
			result.setResultCode(GESTISCICOMBOINIT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			log.debug("ESCO DA IMPIANTO!!!!!");

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1789684877) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoImpianti(utente)) {
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
	 * Implementazione del metodo gestLogicaIngresso definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestLogicaIngresso(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAINGRESSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAINGRESSO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-472182049) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				/*
				 * TEST - inizio
				 */
				/*
				UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();
				
				log.debug("getIdPersonaFisica: "+utenteLoggato.getIdPersonaFisica());
				
				log.debug("getIdPersonaFisica.getRuolo: "+utenteLoggato.getRuolo());
				
				if (utenteLoggato.getRuolo() != null)
				{
					log.debug("getIdPersonaGiuridica: "+utenteLoggato.getRuolo().getIdPersonaGiuridica());
				}
				*/
				/*
				 * TEST - inizio
				 */

				Impianto impianto = theModel.getAppDataimpianto();
				if (impianto != null && GenericUtil.isNotNullOrEmpty(impianto.getImpId())) {

					ArrayList<RisultatoRicResponsabile> responsabiliList = getDbMgr()
							.cercaResponsabiliByIdImpianto(impianto.getImpId());

					theModel.setAppDataelencoResponsabili(responsabiliList);

					ArrayList<RisultatoRicManutentore> manutentoriList = getDbMgr()
							.cercaManutentoriByIdImpiantoNew(impianto.getImpId());

					log.debug("@@@PRIMA del settaggio manutentoriList (2): " + manutentoriList);

					theModel.setAppDataelencoManutentori(manutentoriList);

					// Nel caso in cui arrivo dall'inseirmento/modifica manutentore/proprietario
					Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);

					log.debug("Stampo il messaggio: " + msg);

					if (msg != null) {
						log.debug("messaggio in sessione: " + msg.getType() + ", " + msg.getText());
						if (msg.getType() == Message.ERROR)
							result.getGlobalErrors().add(msg.getText());
						else
							result.getGlobalMessages().add(msg.getText());

						theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);

						// Carico il proprietario eventualmente inserito
						impianto.setProprietario(
								getDbMgr().getProprietarioImpianto(ConvertUtil.convertToString(impianto.getImpId())));

					}

				} else if (impianto.getLogicaVisual() != null
						&& (impianto.getLogicaVisual().getCaso() == Constants.COD_CASO_E
								|| impianto.getLogicaVisual().getCaso() == Constants.COD_CASO_A)) {
					log.debug("pulizia elenchi");

					log.debug("@@@PRIMA del settaggio manutentoriList (3): " + null);

					theModel.setAppDataelencoResponsabili(null);
					theModel.setAppDataelencoManutentori(null);
				}

				// impostazione del result code 
				result.setResultCode(GESTLOGICAINGRESSO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			log.debug("****** " + result.getResultCode() + " ******");

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaIngresso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisualizzazione definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestisciVisualizzazione(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISUALIZZAZIONE_OUTCOME_CODE__REGISTRAZIONE = //NOSONAR  Reason:EIAS
				"REGISTRAZIONE"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISUALIZZAZIONE_OUTCOME_CODE__VISUALIZZAZIONE = //NOSONAR  Reason:EIAS
				"VISUALIZZAZIONE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1206682253) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer logica = theModel.getAppDataimpianto().getLogicaVisual().getCaso();
			if (logica == Constants.COD_CASO_A || logica == Constants.COD_CASO_B || logica == Constants.COD_CASO_E) {
				// Sono in inserimento o modifica o subentro

				log.debug("***REGISTRAZIONE***\n\n");

				// impostazione del result code 
				result.setResultCode(GESTISCIVISUALIZZAZIONE_OUTCOME_CODE__REGISTRAZIONE);
			} else {
				log.debug("***VISUALIZZAZIONE***\n\n");

				// impostazione del result code 
				result.setResultCode(GESTISCIVISUALIZZAZIONE_OUTCOME_CODE__VISUALIZZAZIONE);
			}
			log.debug("****** " + result.getResultCode() + " ******");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciVisualizzazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaInst definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestLogicaInst(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAINST_OUTCOME_CODE__ABILITA_INSTALLATORE = //NOSONAR  Reason:EIAS
				"ABILITA_INSTALLATORE"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAINST_OUTCOME_CODE__DISABILITA_INSTALLATORE = //NOSONAR  Reason:EIAS
				"DISABILITA_INSTALLATORE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-900644109) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();
			Impianto impianto = theModel.getAppDataimpianto();

			if (log.isDebugEnabled())
				GenericUtil.stampa(impianto, true, 3);

			LogicaVisualizzazione logica = impianto.getLogicaVisual();

			log.debug("gestLogicaInst - logica.getCaso(): " + logica.getCaso());
			log.debug("gestLogicaInst - logica.getDescRuolo(): " + utenteLoggato.getRuolo().getDescRuolo());
			log.debug("gestLogicaInst - impianto.getInstId(): " + impianto.getInstId());

			String descRuolo = utenteLoggato.getRuolo().getDescRuolo();

			if (logica.getCaso() == Constants.COD_CASO_A
					&& (descRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
							|| descRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER)
							|| descRuolo.equalsIgnoreCase(Constants.RUOLO_ISPETTORE))
					&& GenericUtil.isNullOrEmpty(impianto.getInstId())) {

				log.debug("***ABILITA_INSTALLATORE***\n\n");

				// Sono in inserimento e/o ho gia' ricercato l'installatore

				// impostazione del result code 
				//result.setResultCode(GESTLOGICAINST_OUTCOME_CODE__ABILITA_INSTALLATORE);

				// Non e' mai modificabile
				result.setResultCode(GESTLOGICAINST_OUTCOME_CODE__DISABILITA_INSTALLATORE);
			} else {
				log.debug("***DISABILITA_INSTALLATORE***\n\n");

				// Sono in visualizzazione o modifica
				// impostazione del result code 
				result.setResultCode(GESTLOGICAINST_OUTCOME_CODE__DISABILITA_INSTALLATORE);
			}
			log.debug("****** " + result.getResultCode() + " ******");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaInst] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaCodImp definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestLogicaCodImp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICACODIMP_OUTCOME_CODE__ABILITA_COD_IMP = //NOSONAR  Reason:EIAS
				"ABILITA_COD_IMP"; //NOSONAR  Reason:EIAS
		final String GESTLOGICACODIMP_OUTCOME_CODE__DISABILITA_COD_IMP = //NOSONAR  Reason:EIAS
				"DISABILITA_COD_IMP"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-922154107) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			LogicaVisualizzazione logica = theModel.getAppDataimpianto().getLogicaVisual();

			if (logica.getCaso() == Constants.COD_CASO_A) {
				// Sono in inserimento
				log.debug("***ABILITA_COD_IMP***\n\n");
				// impostazione del result code 
				result.setResultCode(GESTLOGICACODIMP_OUTCOME_CODE__ABILITA_COD_IMP);
			} else {
				log.debug("***DISABILITA_COD_IMP***\n\n");
				// impostazione del result code 
				result.setResultCode(GESTLOGICACODIMP_OUTCOME_CODE__DISABILITA_COD_IMP);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			log.debug("****** " + result.getResultCode() + " ******");

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaCodImp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAbilLogicaVarImp definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestAbilLogicaVarImp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTABILLOGICAVARIMP_OUTCOME_CODE__ABILITA_VAR_IMP = //NOSONAR  Reason:EIAS
				"ABILITA_VAR_IMP"; //NOSONAR  Reason:EIAS
		final String GESTABILLOGICAVARIMP_OUTCOME_CODE__DISABILITA_VAR_IMP = //NOSONAR  Reason:EIAS
				"DISABILITA_VAR_IMP"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R8744336) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = theModel.getAppDataimpianto();

			log.debug("gestisciLogicaImpPresenteInit STAMPO l'impianto.getImpId(): " + impianto.getImpId());

			if (GenericUtil.isNotNullOrEmpty(impianto.getImpId())) {
				// impostazione del result code 
				result.setResultCode(GESTABILLOGICAVARIMP_OUTCOME_CODE__DISABILITA_VAR_IMP);

			} else {
				// impostazione del result code 
				result.setResultCode(GESTABILLOGICAVARIMP_OUTCOME_CODE__ABILITA_VAR_IMP);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAbilLogicaVarImp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAbilLogicaImpLocIndirizzo definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestAbilLogicaImpLocIndirizzo(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTABILLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__ABILITA_IMP_IND_CERCATO = //NOSONAR  Reason:EIAS
				"ABILITA_IMP_IND_CERCATO"; //NOSONAR  Reason:EIAS
		final String GESTABILLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__ABILITA_IMP_IND_NON_CERCATO = //NOSONAR  Reason:EIAS
				"ABILITA_IMP_IND_NON_CERCATO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R205603433) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Boolean isImpiantoIndConfermato = theModel.getAppDataimpianto().getLogicaVisual()
					.getIsImpiantoIndConfermato();
			if (isImpiantoIndConfermato != null && isImpiantoIndConfermato) {

				// impostazione del result code 
				result.setResultCode(GESTABILLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__ABILITA_IMP_IND_CERCATO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTABILLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__ABILITA_IMP_IND_NON_CERCATO);
			}

			log.debug("****** " + result.getResultCode() + " ******");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAbilLogicaImpLocIndirizzo] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaSalvaImp definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestLogicaSalvaImp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICASALVAIMP_OUTCOME_CODE__VISUALIZZA_BOT_SALVA_IMP = //NOSONAR  Reason:EIAS
				"VISUALIZZA_BOT_SALVA_IMP"; //NOSONAR  Reason:EIAS
		final String GESTLOGICASALVAIMP_OUTCOME_CODE__NASCONDI_BOT_SALVA_IMP = //NOSONAR  Reason:EIAS
				"NASCONDI_BOT_SALVA_IMP"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-220361514) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = theModel.getAppDataimpianto();
			Integer logica = impianto.getLogicaVisual().getCaso();

			if (log.isDebugEnabled())
				GenericUtil.stampa(impianto, true, 3);

			/*
			if ((logica == Constants.COD_CASO_A || logica == Constants.COD_CASO_B || logica == Constants.COD_CASO_E)
					&& GenericUtil.isNotNullOrEmpty(impianto.getInstId())) {
			*/
			if (logica == Constants.COD_CASO_A || logica == Constants.COD_CASO_B || logica == Constants.COD_CASO_E) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICASALVAIMP_OUTCOME_CODE__VISUALIZZA_BOT_SALVA_IMP);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICASALVAIMP_OUTCOME_CODE__NASCONDI_BOT_SALVA_IMP);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			log.debug("****** " + result.getResultCode() + " ******");

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaSalvaImp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaImpPresenteInit definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestisciLogicaImpPresenteInit(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICAIMPPRESENTEINIT_OUTCOME_CODE__PRESENTE = //NOSONAR  Reason:EIAS
				"PRESENTE"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICAIMPPRESENTEINIT_OUTCOME_CODE__NON_PRESENTE = //NOSONAR  Reason:EIAS
				"NON_PRESENTE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1152931753) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = theModel.getAppDataimpianto();

			log.debug("gestisciLogicaImpPresenteInit STAMPO l'impianto.getImpId(): " + impianto.getImpId());

			if (GenericUtil.isNotNullOrEmpty(impianto.getImpId())) {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICAIMPPRESENTEINIT_OUTCOME_CODE__PRESENTE);

			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICAIMPPRESENTEINIT_OUTCOME_CODE__NON_PRESENTE);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			log.debug("****** " + result.getResultCode() + " ******");

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciLogicaImpPresenteInit] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaElenResponsabileInit definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestLogicaElenResponsabileInit(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAELENRESPONSABILEINIT_OUTCOME_CODE__VISUALIZZA_BOT_EL_RESP = //NOSONAR  Reason:EIAS
				"VISUALIZZA_BOT_EL_RESP"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAELENRESPONSABILEINIT_OUTCOME_CODE__NASCONDI_BOT_EL_RESP = //NOSONAR  Reason:EIAS
				"NASCONDI_BOT_EL_RESP"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-727676548) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoResponsabili() != null && theModel.getAppDataelencoResponsabili().size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICAELENRESPONSABILEINIT_OUTCOME_CODE__VISUALIZZA_BOT_EL_RESP);

			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICAELENRESPONSABILEINIT_OUTCOME_CODE__NASCONDI_BOT_EL_RESP);

			}
			log.debug("****** " + result.getResultCode() + " ******");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaElenResponsabileInit] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaImportLibrettoInit definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestLogicaImportLibrettoInit(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAIMPORTLIBRETTOINIT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAIMPORTLIBRETTOINIT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R765523149) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			/*
			// OLD
			if (theModel.getAppDataimpianto() != null
					&& GenericUtil.getStringValid(theModel.getAppDataimpianto().getLibIsModifica())
							.equalsIgnoreCase(Constants.LABEL_NO)
					&& GenericUtil.isNullOrEmpty(theModel.getAppDataimpianto().getLibDataRilascio())) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICAIMPORTLIBRETTOINIT_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICAIMPORTLIBRETTOINIT_OUTCOME_CODE__NASCONDI);
			}
			*/

			if (getSigitMgr().isLibrettoImportabile(theModel.getAppDataimpianto().getImpId())) {
				result.setResultCode(GESTLOGICAIMPORTLIBRETTOINIT_OUTCOME_CODE__VISUALIZZA);
			} else {
				result.setResultCode(GESTLOGICAIMPORTLIBRETTOINIT_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaImportLibrettoInit] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisLogicaImpLocIndirizzo definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestVisLogicaImpLocIndirizzo(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__VISUALIZZA_IMP_IND_CERCATO = //NOSONAR  Reason:EIAS
				"VISUALIZZA_IMP_IND_CERCATO"; //NOSONAR  Reason:EIAS
		final String GESTVISLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__VISUALIZZA_IMP_IND_NON_CERCATO = //NOSONAR  Reason:EIAS
				"VISUALIZZA_IMP_IND_NON_CERCATO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1088408805) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Boolean isImpiantoIndConfermato = theModel.getAppDataimpianto().getLogicaVisual()
					.getIsImpiantoIndConfermato();
			if (isImpiantoIndConfermato != null && isImpiantoIndConfermato) {

				Impianto impianto = theModel.getAppDataimpianto();
				if (GenericUtil.isNotNullOrEmpty(impianto.getImpLocIdIndirizzo())) {

					ArrayList<CodeDescription> vie = new ArrayList<CodeDescription>();

					CodeDescription via = new CodeDescription();
					via.setCode(impianto.getImpLocIdIndirizzo());
					via.setDescription(impianto.getImpLocIndirizzoSitad());

					vie.add(via);

					theModel.setAppDataelencoIndirizzi(vie);

				} else {
					theModel.setAppDataelencoIndirizzi(new ArrayList<CodeDescription>());
				}

				// impostazione del result code 
				result.setResultCode(GESTVISLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__VISUALIZZA_IMP_IND_CERCATO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__VISUALIZZA_IMP_IND_NON_CERCATO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			log.debug("****** " + result.getResultCode() + " ******");

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisLogicaImpLocIndirizzo] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboImpComuni definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestisciComboImpComuni(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOIMPCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-119794369) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			/*
			Impianto imp = theModel.getAppDataimpianto();
			
			ArrayList<CodeDescription> comuniLoc = new ArrayList<CodeDescription>();
			
			if (imp != null) {
			
				// Localizzazione COMUNE 
				String idProvSelLoc = imp.getImpLocIdProvincia();
				log.debug("STAMPO idProvSelLoc: " + idProvSelLoc);
			
				if (GenericUtil.isNotNullOrEmpty(idProvSelLoc)) {
					comuniLoc = (ArrayList<CodeDescription>) getServiziMgr()
							.getListaComuniByIstatProvincia(idProvSelLoc);
				}
			
			}
			 */
			ArrayList<CodeDescription> comuniLoc = recuperaComuni(theModel.getAppDataimpianto().getImpLocIdProvincia());

			theModel.setAppDataelencoComuni(comuniLoc);

			result.setResultCode(GESTISCICOMBOIMPCOMUNI_OUTCOME_CODE__OK);

			log.debug("****** " + result.getResultCode() + " ******");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboImpComuni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaBotVisLibrettoInit definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestLogicaBotVisLibrettoInit(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICABOTVISLIBRETTOINIT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICABOTVISLIBRETTOINIT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-950546919) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//			if (ConvertUtil.convertToBooleanAllways(theModel
			//					.getAppDataimpianto().getLogicaVisual()
			//					.getIsBotVisLibrettoVisibile())) 

			if (getSigitMgr().isPresenteLibretto(theModel.getAppDataimpianto().getImpCodImpianto())) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICABOTVISLIBRETTOINIT_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICABOTVISLIBRETTOINIT_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaBotVisLibrettoInit] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaGraffatura definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestisciLogicaGraffatura(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICAGRAFFATURA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICAGRAFFATURA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1015193202) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDataprovenienza() != null
					&& theModel.getAppDataprovenienza().equals(Constants.PAG_ELEN_GRAFF)) {
				result.setResultCode(GESTISCILOGICAGRAFFATURA_OUTCOME_CODE__OK);
			} else {
				result.setResultCode(GESTISCILOGICAGRAFFATURA_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciLogicaGraffatura] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaImpPresente definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestisciLogicaImpPresente(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICAIMPPRESENTE_OUTCOME_CODE__PRESENTE = //NOSONAR  Reason:EIAS
				"PRESENTE"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICAIMPPRESENTE_OUTCOME_CODE__NON_PRESENTE = //NOSONAR  Reason:EIAS
				"NON_PRESENTE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R967639385) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("Entro in gestisciLogicaImpPresente!!");

			Impianto impianto = theModel.getAppDataimpianto();

			if (log.isDebugEnabled())
				GenericUtil.stampa(impianto, true, 3);

			log.debug("######## VERIFICO gestisciLogicaImpPresente");
			log.debug("######## VERIFICO gestisciLogicaImpPresente");

			if (GenericUtil.isNotNullOrEmpty(impianto.getImpId())) {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICAIMPPRESENTE_OUTCOME_CODE__PRESENTE);

				log.debug("#### PRESENTE ####");

			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICAIMPPRESENTE_OUTCOME_CODE__NON_PRESENTE);

				log.debug("#### NON PRESENTE ####");

			}

			log.debug("****** " + result.getResultCode() + " ******");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciLogicaImpPresente] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaElenResponsabile definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestLogicaElenResponsabile(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAELENRESPONSABILE_OUTCOME_CODE__VISUALIZZA_BOT_EL_RESP = //NOSONAR  Reason:EIAS
				"VISUALIZZA_BOT_EL_RESP"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAELENRESPONSABILE_OUTCOME_CODE__NASCONDI_BOT_EL_RESP = //NOSONAR  Reason:EIAS
				"NASCONDI_BOT_EL_RESP"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1162155180) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoResponsabili() != null && theModel.getAppDataelencoResponsabili().size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICAELENRESPONSABILE_OUTCOME_CODE__VISUALIZZA_BOT_EL_RESP);

			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICAELENRESPONSABILE_OUTCOME_CODE__NASCONDI_BOT_EL_RESP);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			log.debug("****** " + result.getResultCode() + " ******");

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaElenResponsabile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaImportLibretto definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestLogicaImportLibretto(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAIMPORTLIBRETTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAIMPORTLIBRETTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1852190595) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (getSigitMgr().isLibrettoImportabile(theModel.getAppDataimpianto().getImpId())) {
				result.setResultCode(GESTLOGICAIMPORTLIBRETTO_OUTCOME_CODE__VISUALIZZA);
			} else {
				result.setResultCode(GESTLOGICAIMPORTLIBRETTO_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaImportLibretto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaBotInsModLibretto definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults gestLogicaBotInsModLibretto(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICABOTINSMODLIBRETTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICABOTINSMODLIBRETTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R793834253) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataimpianto() != null
					&& GenericUtil.isNotNullOrEmpty(theModel.getAppDataimpianto().getImpId())) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICABOTINSMODLIBRETTO_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICABOTINSMODLIBRETTO_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaBotInsModLibretto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo aggiornaDatiPagina definito in un ExecCommand del
	 * ContentPanel cpGestImpianto
	 */
	public ExecResults aggiornaDatiPagina(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1533417435) ENABLED START*/

			log.debug("ENTRO IN aggiornaDatiPagina");

			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);

			log.debug("Stampo il messaggio: " + msg);

			if (msg != null) {
				log.debug("messaggio in sessione: " + msg.getType() + ", " + msg.getText());
				if (msg.getType() == Message.ERROR)
					result.getGlobalErrors().add(msg.getText());
				else
					result.getGlobalMessages().add(msg.getText());

				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);

				//aggiornare impianto con i dati del libretto
				Impianto impiantoInSessione = theModel.getAppDataimpianto();
				if (impiantoInSessione != null && GenericUtil.isNotNullOrEmpty(impiantoInSessione.getImpId())) {

					String codImpianto = impiantoInSessione.getImpCodImpianto();
					if (codImpianto != null) {

						LogicaVisualizzazione logicaVis = impiantoInSessione.getLogicaVisual();

						log.debug("@@@@PRIMA@@@@");

						if (log.isDebugEnabled())
							GenericUtil.stampa(theModel.getAppDataelencoManutentori(), true, 3);

						Impianto impianto = getDbMgr().cercaImpiantoById(codImpianto);

						impianto.setLogicaVisual(logicaVis);

						theModel.setAppDataimpianto(impianto);

						log.debug("@@@@DOPO@@@@");

						if (log.isDebugEnabled())
							GenericUtil.stampa(theModel.getAppDataelencoManutentori(), true, 3);

						//						ArrayList<RisultatoRicManutentore> manutentoriList = getDbMgr()
						//								.cercaManutentoriByIdImpianto(
						//										impianto.getImpId());
						//						theModel.setAppDataelencoManutentori(manutentoriList);
					}
				}
			}

			// La riga successiva e' stata aggiunta a causa di un problema che non siamo riusciti a capire,
			// quindi comunque diamo l'ok
			result.setResultCode(AGGIORNADATIPAGINA_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::aggiornaDatiPagina] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbManutentori
	 */
	public static void resetClearStatus_widg_tbManutentori(java.util.Map session) {
		session.put("cpGestImpianto_tbManutentori_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbResponsabili
	 */
	public static void resetClearStatus_widg_tbResponsabili(java.util.Map session) {
		session.put("cpGestImpianto_tbResponsabili_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R727373620) ENABLED START*/
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

	private ArrayList<CodeDescription> recuperaComuni(String idProvSel) throws ServiceException {

		ArrayList<CodeDescription> comuniLoc = new ArrayList<CodeDescription>();

		if (GenericUtil.isNotNullOrEmpty(idProvSel)) {

			// Localizzazione COMUNE 
			log.debug("STAMPO idProvSelLoc: " + idProvSel);

			comuniLoc = (ArrayList<CodeDescription>) getServiziMgr().getListaComuniByIstatProvincia(idProvSel);

		}

		return comuniLoc;
	}

	private void settaComuneVieResponsabile(it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel,
			Responsabile responsabile) throws ServiceException {
		if (GenericUtil.isNotNullOrEmpty(responsabile.getIdIndirizzo())) {

			ArrayList<CodeDescription> vie = new ArrayList<CodeDescription>();

			CodeDescription via = new CodeDescription();
			via.setCode(ReplaceSpecialCharUtils.sanitize(responsabile.getIdIndirizzo()));
			via.setDescription(ReplaceSpecialCharUtils.sanitize(responsabile.getIndirizzoSitad()));

			vie.add(via);

			theModel.setAppDataelencoIndirizziResp(vie);

		} else {
			theModel.setAppDataelencoIndirizziResp(new ArrayList<CodeDescription>());
		}

		if (GenericUtil.isNotNullOrEmpty(responsabile.getIdProvincia())) {
			theModel.setAppDataelencoComuniResp(getServiziMgr()
					.getListaComuniByIstatProvincia(ReplaceSpecialCharUtils.sanitize(responsabile.getIdProvincia())));

		} else {
			theModel.setAppDataelencoComuniResp(new ArrayList<CodeDescription>());
		}
	}

	private void settaResponsabiliList(it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel)
			throws DbManagerException {

		ArrayList<RisultatoRicResponsabile> responsabiliList = getDbMgr()
				.cercaResponsabiliByIdImpianto(theModel.getAppDataimpianto().getImpId());

		theModel.setAppDataelencoResponsabili(responsabiliList);

	}
	private void settaListaRuoloResponsabile(it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel theModel,
			String descRuoloFunz) throws DbManagerException {
		ArrayList<CodeDescription> titoliResp = getDbMgr().cercaListaRuoloByDescRuoloFunzionale(descRuoloFunz);
		theModel.setAppDataelencoTitoli(titoliResp);
	}

	/*PROTECTED REGION END*/
}
