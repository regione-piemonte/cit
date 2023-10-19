package it.csi.sigit.sigitwebn.business.gestisci_subentro;

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

/*PROTECTED REGION ID(R-986153923) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTComp4Dto;
/*PROTECTED REGION END*/

public class CPBECpGestSubentro {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [subentro, scope:USER_SESSION]
	public static final String APPDATA_SUBENTRO_CODE = "appDatasubentro";

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoProvincePiemonte, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTE_CODE = "appDataelencoProvincePiemonte";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoIndirizziSub, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZISUB_CODE = "appDataelencoIndirizziSub";

	// ApplicationData: [elencoTipoSubentro, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOSUBENTRO_CODE = "appDataelencoTipoSubentro";

	// ApplicationData: [impianto, scope:USER_SESSION]
	public static final String APPDATA_IMPIANTO_CODE = "appDataimpianto";

	// ApplicationData: [elencoApparecchiatureSub, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAPPARECCHIATURESUB_CODE = "appDataelencoApparecchiatureSub";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestSubentro";

	public static final String MULTIPANEL_MPTIPOSUBENTRO = "mpTipoSubentro";
	public static final String MPI_MPTIPOSUBENTRO_FPTIPOSUBENTRO = CPNAME + "_" + MULTIPANEL_MPTIPOSUBENTRO + "_"
			+ "fpTipoSubentro";

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
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults cercaInstallatore(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINSTALLATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINSTALLATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-107723944) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<CodeDescription> tipiSubentro = new ArrayList<CodeDescription>();

			try {
				Subentro subentro = theModel.getAppDatasubentro();

				if (log.isDebugEnabled())
					GenericUtil.stampa(subentro, true, 2);

				getValidationMgr().verificaManutentore(subentro.getRespImpCf(), subentro.getRespImpIdSiglaRea(),
						subentro.getRespImpNumeroRea(), ConstantsField.GESTISCI_SUBENTRO_RESP_IMP_CF,
						ConstantsField.GESTISCI_SUBENTRO_RESP_IMP_SIGLA_REA,
						ConstantsField.GESTISCI_SUBENTRO_RESP_IMP_NUM_REA);

				PersonaGiuridica installatore = getSigitMgr().cercaPersonaGiuridica(subentro.getRespImpCf(),
						subentro.getRespImpIdSiglaRea(), subentro.getRespImpNumeroRea());

				if (installatore != null) {
					subentro.setRespImpCf(installatore.getCodiceFiscale());
					subentro.setRespImpIdSiglaRea(installatore.getSiglaRea());
					subentro.setRespImpNumeroRea(installatore.getNumeroRea());
					subentro.setRespImpImpresa(installatore.getDenominazione());
					subentro.setRespImpId(installatore.getIdPersonaGiuridica());

					//					log.debug("STAMPO L'iD IMPRESA: " + subentro.getRespImpId());
					//
					//					if (installatore.getFlgInstallatore()) {
					//
					//						tipiSubentro.addAll(getDbMgr()
					//								.cercaListaRuoloByDescRuoloFunzionale(
					//										Constants.RUOLO_INSTALLATORE));
					//					}
					//
					//					if (installatore.getFlgManutentore()) {
					//
					//						tipiSubentro.addAll(getDbMgr()
					//								.cercaListaRuoloByDescRuoloFunzionale(
					//										Constants.RUOLO_MANUTENTORE));
					//
					//					}

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

			//theModel.setAppDataelencoTipoSubentro(tipiSubentro);

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
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults nuovaRicercaInstallatore(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINSTALLATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAINSTALLATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R774678918) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// E' stato premuto "Nuova ricerca", pulisco l'id installatore 
			theModel.getAppDatasubentro().setRespImpId(null);

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
	 * Implementazione del metodo loadComuniImp definito in un ExecCommand del
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults loadComuniImp(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNIIMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1909025501) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<CodeDescription> comuniLoc = new ArrayList<CodeDescription>();

			if (GenericUtil.isNotNullOrEmpty(theModel.getAppDatasubentro().getImpLocIdProvincia())) {
				comuniLoc = getServiziMgr()
						.getListaComuniByIstatProvincia(theModel.getAppDatasubentro().getImpLocIdProvincia());
			}

			//			ArrayList<CodeDescription> comuniLoc = recuperaComuni(theModel
			//					.getAppDatasubentro().getImpLocIdProvincia());

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
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults cercaIndirizzoImp(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINDIRIZZOIMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINDIRIZZOIMP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2046886702) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				Subentro subentro = theModel.getAppDatasubentro();

				getValidationMgr().verificaRicercaIndirizzoSubentro(subentro);

				theModel.setAppDataelencoIndirizziSub(
						getServiziMgr().getListaVieValide(subentro.getImpLocIndirizzo(), subentro.getImpLocIdComune()));
				//				setVisibilitaIndirizzoImpianto(theModel);

				subentro.setIsImpLocIndConfermato(true);

				// impostazione del result code 
				result.setResultCode(CERCAINDIRIZZOIMP_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				log.debug("##################### INTERCETTO L'eccezione");
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
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults nuovaRicercaIndirizzoImp(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINDIRIZZOIMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1365677732) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//theModel.getAppDatasubentro().setIsImpLocIndConfermato(false);

			theModel.getAppDatasubentro().setImpLocIdIndirizzo(null);
			theModel.getAppDatasubentro().setImpLocIndirizzoNoStrad(null);

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
	 * Implementazione del metodo verificaImpianto definito in un ExecCommand del
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults verificaImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1967787442) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Subentro subentro = theModel.getAppDatasubentro();

				getValidationMgr().verificaManutentore(subentro.getRespImpCf(), subentro.getRespImpIdSiglaRea(),
						subentro.getRespImpNumeroRea(), ConstantsField.GESTISCI_SUBENTRO_RESP_IMP_CF,
						ConstantsField.GESTISCI_SUBENTRO_RESP_IMP_SIGLA_REA,
						ConstantsField.GESTISCI_SUBENTRO_RESP_IMP_NUM_REA);

				if (GenericUtil.isNotNullOrEmpty(subentro.getImpLocIdIndirizzo())) {

					String descIndirizzoSitad = GenericUtil.getDescriptionByCod(subentro.getImpLocIdIndirizzo(),
							theModel.getAppDataelencoIndirizziSub());

					subentro.setImpLocIndirizzoSitad(descIndirizzoSitad);
				}

				String msgOK = getValidationMgr().verificaImpiantoSubentro(subentro,
						theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo());

				Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();

				ArrayList<CodeDescription> tipiSubentro = cercaComboTipiSubentro(ruolo, subentro);

				theModel.setAppDataelencoTipoSubentro(tipiSubentro);
				subentro.setIdTipoSubentro(null);
				subentro.setIdApparecchiature(null);

				if (msgOK != null) {
					result.getGlobalMessages().add(msgOK);
				}

				result.setResultCode(VERIFICAIMPIANTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaImpianto definito in un ExecCommand del
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults nuovaRicercaImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1192801589) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Subentro subentro = theModel.getAppDatasubentro();
			subentro.setIdTipoSubentro(null);
			subentro.setIdApparecchiature(null);

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
	 * Implementazione del metodo cercaApparecchiature definito in un ExecCommand del
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults cercaApparecchiature(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAAPPARECCHIATURE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAAPPARECCHIATURE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-447032853) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Subentro subentro = theModel.getAppDatasubentro();

			if (GenericUtil.isNotNullOrEmpty(subentro.getIdTipoSubentro())
					&& (subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_1
							|| subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_2
							|| subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_3
							|| subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_4)) {

				theModel.setAppDataelencoApparecchiatureSub(getSigitMgr().cercaElencoApparecchiatureSubentro(subentro));

				// impostazione del result code 
				result.setResultCode(CERCAAPPARECCHIATURE_OUTCOME_CODE__OK);
			} else {
				// impostazione del result code 
				result.setResultCode(CERCAAPPARECCHIATURE_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaApparecchiature] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo effettuaSubentro definito in un ExecCommand del
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults effettuaSubentro(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EFFETTUASUBENTRO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String EFFETTUASUBENTRO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String EFFETTUASUBENTRO_OUTCOME_CODE__IMPIANTO = //NOSONAR  Reason:EIAS
				"IMPIANTO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1651751146) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Subentro subentro = theModel.getAppDatasubentro();

				UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

				String descRuoloUtente = utenteLoggato.getRuolo().getDescRuolo();

				getValidationMgr().validazioneFormaleSubentro(subentro, descRuoloUtente);

				int idTipoSubentro = subentro.getIdTipoSubentro();

				log.debug("SONO PRIMA DEL verificaCodImpiantoPresente");
				if (getDbMgr().cercaImpiantoDtoById(subentro.getImpCodImpianto()) == null) {

					log.debug("Mappo il subentro in impianto");

					if (GenericUtil.isNotNullOrEmpty(subentro.getImpLocIdIndirizzo())) {

						String descIndirizzoSitad = GenericUtil.getDescriptionByCod(subentro.getImpLocIdIndirizzo(),
								theModel.getAppDataelencoIndirizziSub());

						subentro.setImpLocIndirizzoSitad(descIndirizzoSitad);
					}

					// Questo settaggio mi serve in caso l'utente quando si trova su impianti prema indietro!
					subentro.setIsSubentroImpianto(true);

					Impianto impianto = MapDto.mapToImpianto(subentro);

					log.debug("Setto la logica visualizzazione");

					impianto.setLogicaVisual(GenericUtil.getLogicaVisualizzazioneSubentro());

					//					impianto.getLogicaVisual().setIsBotInsModLibrettoVisibile(true);
					//					impianto.getLogicaVisual().setIsImpiantoIndConfermato(true);

					log.debug("setto l'impianto in sessione");
					theModel.setAppDataimpianto(impianto);

					log.debug("PASSO AD IMPIANTI");
					result.setResultCode(EFFETTUASUBENTRO_OUTCOME_CODE__IMPIANTO);

				} else {
					log.debug("STO FACENDO IL SUBENTRO");

					ArrayList<String> idApparecchiatureSel = subentro.getIdApparecchiature();

					log.debug("Stampo la idApparecchiatureSel: " + idApparecchiatureSel);

					if (idApparecchiatureSel != null && idApparecchiatureSel.size() > 0
							&& idApparecchiatureSel.contains(Constants.ID_TUTTE)) {
						// L'utente ha selezionato TUTTE LE APPARECCHIATURE
						// Quindi devo settare come id tutte le apparecchiature della combo

						ArrayList<CodeDescription> listApp = theModel.getAppDataelencoApparecchiatureSub();
						//listApp.remove(Constants.ID_TUTTE_APPARECCHIATURE);

						// Pulisco la lista
						idApparecchiatureSel.clear();
						for (CodeDescription codeDescription : listApp) {

							log.debug("codeDescription.getCode(): "
									+ codeDescription.getCode().equals(Constants.ID_TUTTE));
							if (!codeDescription.getCode().equals(Constants.ID_TUTTE))
								idApparecchiatureSel.add(codeDescription.getCode());
						}

						log.debug("SETTO la lista apparecchiature: " + idApparecchiatureSel);
						subentro.setIdApparecchiature(idApparecchiatureSel);
						theModel.setAppDatasubentro(subentro);

					}

					if (idTipoSubentro != Constants.ID_RUOLO_CARICATORE) {
						getValidationMgr().verificaAllegatiSysdateSubentro(subentro);
					}

					if (GenericUtil
							.checkValidRole(utenteLoggato,
									Arrays.asList(Constants.RUOLO_RESPONSABILE, Constants.RUOLO_RESPONSABILE_IMPRESA,
											Constants.RUOLO_PROPRIETARIO, Constants.RUOLO_PROPRIETARIO_IMPRESA),
									false, true)) {
						getValidationMgr().verificaContrattiSysdateSubentro(subentro.getImpCodImpianto());
					}

					String descTipoSubentro = GenericUtil.getDescriptionByCod(idTipoSubentro,
							theModel.getAppDataelencoTipoSubentro());

					getSigitMgr().effettuaSubentro(subentro, descRuoloUtente, descTipoSubentro,
							utenteLoggato.getCodiceFiscale());

					//					getDbMgr().effettuaSubentro(
					//							subentro,
					//							descRuoloUtente,
					//							theModel.getAppDatautenteLoggato()
					//									.getCodiceFiscale());

					theModel.getAppDatasubentro().setIdApparecchiature(null);
					theModel.getAppDatasubentro().setIdTipoSubentro(null);
					theModel.setAppDataelencoApparecchiatureSub(null);

					result.getGlobalMessages().add(Messages.INFO_SUBENTRO_CORRETTO);

					result.setResultCode(EFFETTUASUBENTRO_OUTCOME_CODE__OK);

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
			log.error("[BackEndFacade::effettuaSubentro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R104798038) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoSubentro(utente)) {
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
	 * Implementazione del metodo gestisciIngresso definito in un ExecCommand del
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults gestisciIngresso(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINGRESSO_OUTCOME_CODE__RICERCA = //NOSONAR  Reason:EIAS
				"RICERCA"; //NOSONAR  Reason:EIAS
		final String GESTISCIINGRESSO_OUTCOME_CODE__IMPIANTO = //NOSONAR  Reason:EIAS
				"IMPIANTO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1320095157) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("CONSTROLLO IL SUBENTRO (INIT): " + theModel.getAppDatasubentro());

			if (theModel.getAppDatasubentro() != null
					&& ConvertUtil.convertToBooleanAllways(theModel.getAppDatasubentro().getIsSubentroImpianto())) {
				// impostazione del result code 
				result.setResultCode(GESTISCIINGRESSO_OUTCOME_CODE__IMPIANTO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCIINGRESSO_OUTCOME_CODE__RICERCA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciIngresso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaImpRespEnt definito in un ExecCommand del
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults gestLogicaImpRespEnt(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAIMPRESPENT_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAIMPRESPENT_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1749357075) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = gestLogicaImpResp(theModel, GESTLOGICAIMPRESPENT_OUTCOME_CODE__ABILITA,
					GESTLOGICAIMPRESPENT_OUTCOME_CODE__DISABILITA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaImpRespEnt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaRicercaImpResp definito in un ExecCommand del
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults gestLogicaRicercaImpResp(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICARICERCAIMPRESP_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICARICERCAIMPRESP_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1929231447) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();

			if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICARICERCAIMPRESP_OUTCOME_CODE__VISUALIZZA);

				log.debug("VISUALIZZO IL BOTTONE RICERCA");
			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICARICERCAIMPRESP_OUTCOME_CODE__NASCONDI);

				log.debug("NASCONDO IL BOTTONE RICERCA");
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaRicercaImpResp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaResetVis definito in un ExecCommand del
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults gestisciLogicaResetVis(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1681674715) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDatasubentro() == null) {

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
	 * Implementazione del metodo gestLogicaImpRespRef definito in un ExecCommand del
	 * ContentPanel cpGestSubentro
	 */
	public ExecResults gestLogicaImpRespRef(

			it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAIMPRESPREF_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAIMPRESPREF_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-366065851) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = gestLogicaImpResp(theModel, GESTLOGICAIMPRESPREF_OUTCOME_CODE__ABILITA,
					GESTLOGICAIMPRESPREF_OUTCOME_CODE__DISABILITA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaImpRespRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1080371305) ENABLED START*/
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

	private ExecResults gestLogicaImpResp(it.csi.sigit.sigitwebn.dto.gestisci_subentro.CpGestSubentroModel theModel,
			String codAbilita, String codDisabilita) throws DbManagerException {
		ExecResults result = new ExecResults();

		Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();
		ArrayList<CodeDescription> tipiSubentro = new ArrayList<CodeDescription>();
		//CodeDescription cd = null;
		if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
				|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
			// impostazione del result code 
			result.setResultCode(codAbilita);
		} else {
			// impostazione del result code 
			result.setResultCode(codDisabilita);

			Subentro subentro = new Subentro();
			PersonaGiuridica personaGiuridica = null;
			PersonaFisica personaFisica = null;

			//tipiSubentro = cercaComboTipiSubentro(ruolo, null);

			if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_IMPRESA)) {

				personaGiuridica = getDbMgr().cercaPersonaGiuridicaById(ruolo.getIdPersonaGiuridica());
				//
				//				if (personaGiuridica.getFlgInstallatore()) {
				//
				//					tipiSubentro.addAll(getDbMgr()
				//							.cercaListaRuoloByDescRuoloFunzionale(
				//									Constants.RUOLO_INSTALLATORE));
				//				}
				//
				//				if (personaGiuridica.getFlgManutentore()) {
				//
				//					tipiSubentro.addAll(getDbMgr()
				//							.cercaListaRuoloByDescRuoloFunzionaleCodImpianto(
				//									Constants.RUOLO_MANUTENTORE, subentro.getImpCodImpianto()));
				//
				//				}
				//
			} else if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
					|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
					|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO)
					|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {

				//				tipiSubentro = getDbMgr().cercaListaRuoloByDescRuoloFunzionale(
				//						ruolo.getDescRuolo());

				if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
						|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO)) {
					personaFisica = getDbMgr().cercaPersonaFisicaByCF(ruolo.getCodiceFiscale());
				} else if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
						|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {
					personaGiuridica = getDbMgr().cercaPersonaGiuridicaById(ruolo.getIdPersonaGiuridica());
				}
			}

			if (personaGiuridica != null) {
				subentro.setRespImpId(personaGiuridica.getIdPersonaGiuridica());
				subentro.setRespImpIdSiglaRea(personaGiuridica.getSiglaRea());
				subentro.setRespImpNumeroRea(personaGiuridica.getNumeroRea());
				subentro.setRespImpCf(personaGiuridica.getCodiceFiscale());
				subentro.setRespImpImpresa(personaGiuridica.getDenominazione());
			} else if (personaFisica != null) {
				subentro.setRespImpId(personaFisica.getIdPersonaFisica());
				subentro.setRespImpCf(personaFisica.getCodiceFiscale());
				subentro.setRespImpImpresa(personaFisica.getDenominazione());
			}

			if (log.isDebugEnabled())
				GenericUtil.stampa(subentro, true, 3);

			theModel.setAppDatasubentro(subentro);

		}

		theModel.setAppDataelencoTipoSubentro(tipiSubentro);

		return result;
	}

	private ArrayList<CodeDescription> cercaComboTipiSubentro(Ruolo ruolo, Subentro subentro)
			throws ManagerException, DbManagerException {
		ArrayList<CodeDescription> tipiSubentro = new ArrayList<CodeDescription>();
		PersonaGiuridica personaGiuridica = null;
		String impCodImpianto = subentro.getImpCodImpianto();

		List<String> listTipiComponente = new ArrayList<String>();
		listTipiComponente.add("GT");
		listTipiComponente.add("GF");
		listTipiComponente.add("SC");
		listTipiComponente.add("CG");

		List<SigitTComp4Dto> comp4List = getDbMgr().cercaComp4ByImpiantoETipiComp(impCodImpianto, listTipiComponente);

		log.debug("cercaComboTipiSubentro");
		log.debug("ruolo.getDescRuolo(): " + ruolo.getDescRuolo());
		log.debug("codiceImpianto: " + impCodImpianto);

		if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
				|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {

			PersonaGiuridica impresa = getSigitMgr().cercaPersonaGiuridica(subentro.getRespImpCf(),
					subentro.getRespImpIdSiglaRea(), subentro.getRespImpNumeroRea(), true);

			log.debug("STAMPO L'iD IMPRESA: " + subentro.getRespImpId());

			if (impresa.getFlgDm37LetteraC()) {
				tipiSubentro.addAll(getDbMgr().cercaListaRuoloByDescRuoloFunzionaleCodImpianto(Constants.RUOLO_IMPRESA,
						impCodImpianto));
			}

			//if (comp4List == null || comp4List.size() == 0) {
			tipiSubentro.addAll(getDbMgr().cercaListaRuoloByDescRuoloFunzionale(Constants.RUOLO_CARICATORE));
			//}

		} else if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_IMPRESA)) {

			personaGiuridica = getDbMgr().cercaPersonaGiuridicaById(ruolo.getIdPersonaGiuridica());

			if (personaGiuridica.getFlgDm37LetteraC()) {
				tipiSubentro.addAll(getDbMgr().cercaListaRuoloByDescRuoloFunzionaleCodImpianto(Constants.RUOLO_IMPRESA,
						impCodImpianto));
			}

			//if (comp4List == null || comp4List.size() == 0) {
			tipiSubentro.addAll(getDbMgr().cercaListaRuoloByDescRuoloFunzionale(Constants.RUOLO_CARICATORE));
			//}

		} else if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
				|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
				|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO)
				|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {

			tipiSubentro = getDbMgr().cercaListaRuoloByDescRuoloFunzionale(ruolo.getDescRuolo());

			//			if (ruolo.getDescRuolo().equalsIgnoreCase(
			//					Constants.RUOLO_RESPONSABILE)) {
			//				personaFisica = getDbMgr().cercaPersonaFisicaByCF(
			//						ruolo.getCodiceFiscale());
			//			} else if (ruolo.getDescRuolo().equalsIgnoreCase(
			//					Constants.RUOLO_RESPONSABILE_IMPRESA)) {
			//				personaGiuridica = getDbMgr().cercaPersonaGiuridicaById(
			//						ruolo.getIdPersonaGiuridica());
			//			}
		}

		return tipiSubentro;
	}
	/*PROTECTED REGION END*/
}
