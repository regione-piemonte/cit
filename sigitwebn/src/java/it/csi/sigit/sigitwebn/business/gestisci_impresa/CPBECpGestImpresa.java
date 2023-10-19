package it.csi.sigit.sigitwebn.business.gestisci_impresa;

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

/*PROTECTED REGION ID(R1419159242) ENABLED START*/
import it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.util.mail.ResultInvioMail;

/*PROTECTED REGION END*/

public class CPBECpGestImpresa {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [impresa, scope:USER_SESSION]
	public static final String APPDATA_IMPRESA_CODE = "appDataimpresa";

	// ApplicationData: [elencoIndirizziImp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZIIMP_CODE = "appDataelencoIndirizziImp";

	// ApplicationData: [elencoImprese, scope:USER_SESSION]
	public static final String APPDATA_ELENCOIMPRESE_CODE = "appDataelencoImprese";

	// ApplicationData: [elencoStatoImp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATOIMP_CODE = "appDataelencoStatoImp";

	// ApplicationData: [idImpresaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDIMPRESASELEZIONATA_CODE = "appDataidImpresaSelezionata";

	// ApplicationData: [ruoliImpresa, scope:USER_SESSION]
	public static final String APPDATA_RUOLIIMPRESA_CODE = "appDataruoliImpresa";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [ricercaImprese, scope:USER_SESSION]
	public static final String APPDATA_RICERCAIMPRESE_CODE = "appDataricercaImprese";

	// ApplicationData: [elencoDatiVisura, scope:USER_SESSION]
	public static final String APPDATA_ELENCODATIVISURA_CODE = "appDataelencoDatiVisura";

	// ApplicationData: [elencoIncarichiAttivi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINCARICHIATTIVI_CODE = "appDataelencoIncarichiAttivi";

	// ApplicationData: [numeroRapportiInviati, scope:USER_SESSION]
	public static final String APPDATA_NUMERORAPPORTIINVIATI_CODE = "appDatanumeroRapportiInviati";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestImpresa";

	public static final String MULTIPANEL_MPIMTROVATE = "mpImTrovate";
	public static final String MPI_MPIMTROVATE_FPIMPTROVATE = CPNAME + "_" + MULTIPANEL_MPIMTROVATE + "_"
			+ "fpImpTrovate";

	public static final String MULTIPANEL_MPIMPRESA = "mpImpresa";
	public static final String MPI_MPIMPRESA_FMDETTIMPRESA = CPNAME + "_" + MULTIPANEL_MPIMPRESA + "_"
			+ "fmDettImpresa";

	public static final String MULTIPANEL_MPVISURAIMPRESA = "mpVisuraImpresa";
	public static final String MPI_MPVISURAIMPRESA_FMVISURAIMPRESA = CPNAME + "_" + MULTIPANEL_MPVISURAIMPRESA + "_"
			+ "fmVisuraImpresa";

	public static final String MULTIPANEL_MPDATICAT = "mpDatiCat";
	public static final String MPI_MPDATICAT_FMDATICAT = CPNAME + "_" + MULTIPANEL_MPDATICAT + "_" + "fmDatiCat";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaImprese definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults cercaImprese(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAIMPRESE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAIMPRESE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R882163214) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				RicercaImprese ricImpresa = theModel.getAppDataricercaImprese();

				getValidationMgr().verificaRicercaImpresa(ricImpresa);

				ArrayList<PersonaGiuridica> impreseList = getSigitMgr().cercaImpreseByParam(ricImpresa);
				theModel.setAppDataelencoImprese(impreseList);

				gestioneMsgRicerca(theModel, result);

				// impostazione del result code 
				result.setResultCode(CERCAIMPRESE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaImprese] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisBot definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults gestVisBot(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-767240181) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<PersonaGiuridica> impreseList = theModel.getAppDataelencoImprese();

			if (impreseList != null && impreseList.size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOT_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOT_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBot] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo dettaglioCIT definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults dettaglioCIT(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DETTAGLIOCIT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DETTAGLIOCIT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1994584882) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idImpSelez = theModel.getAppDataidImpresaSelezionata();

			try {
				getValidationMgr().checkSelezioneElemento(idImpSelez);

				PersonaGiuridica pg = getDbMgr().cercaPersonaGiuridicaById(idImpSelez);

				theModel.setAppDataimpresa(pg);

				ArrayList<CodeDescription> comuniLoc = recuperaComuni(pg.getIdProvinciaSelez());

				theModel.setAppDataelencoComuni(comuniLoc);

				if (GenericUtil.isNotNullOrEmpty(pg.getIdIndirizzoSel())) {

					ArrayList<CodeDescription> vie = new ArrayList<CodeDescription>();

					CodeDescription via = new CodeDescription();
					via.setCode(pg.getIdIndirizzoSel());
					via.setDescription(pg.getIndirizzo());

					vie.add(via);

					theModel.setAppDataelencoIndirizziImp(vie);

				} else {
					theModel.setAppDataelencoIndirizziImp(new ArrayList<CodeDescription>());
				}

				// impostazione del result code 
				result.setResultCode(DETTAGLIOCIT_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::dettaglioCIT] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestTipoIndirizzoImpresaInit definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults gestTipoIndirizzoImpresaInit(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTTIPOINDIRIZZOIMPRESAINIT_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTTIPOINDIRIZZOIMPRESAINIT_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-70439345) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (ConvertUtil.convertToBooleanAllways(theModel.getAppDataimpresa().getFlgIndirizzoEst())) {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOIMPRESAINIT_OUTCOME_CODE__ESTERO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOIMPRESAINIT_OUTCOME_CODE__NAZIONALE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestTipoIndirizzoImpresaInit] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciStatoPg definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults gestisciStatoPg(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCISTATOPG_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCISTATOPG_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-355657084) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			PersonaGiuridica pg = theModel.getAppDataimpresa();

			if (pg != null && pg.getIdStatoPg() != null
					&& pg.getIdStatoPg().intValue() != Constants.ID_STATO_IMPRESA_CESSATA
					&& pg.getIdStatoPg().intValue() != Constants.ID_STATO_IMPRESA_RADIATA) {
				// impostazione del result code 
				result.setResultCode(GESTISCISTATOPG_OUTCOME_CODE__ABILITA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCISTATOPG_OUTCOME_CODE__DISABILITA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciStatoPg] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioni definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults gestisciAbilitazioni(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONI_OUTCOME_CODE__REGISTRAZIONE = //NOSONAR  Reason:EIAS
				"REGISTRAZIONE"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONI_OUTCOME_CODE__VISUALIZZAZIONE = //NOSONAR  Reason:EIAS
				"VISUALIZZAZIONE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1620167879) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo()
					.equalsIgnoreCase(Constants.RUOLO_CONSULTATORE)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIABILITAZIONI_OUTCOME_CODE__VISUALIZZAZIONE);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCIABILITAZIONI_OUTCOME_CODE__REGISTRAZIONE);
			}

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
	 * Implementazione del metodo visura definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults visura(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISURA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISURA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-411684307) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idImpSelez = theModel.getAppDataidImpresaSelezionata();

			try {
				getValidationMgr().checkSelezioneElemento(idImpSelez);

				PersonaGiuridica pg = getDbMgr().cercaPersonaGiuridicaById(idImpSelez);

				ArrayList<LabelValue> visura = getSigitMgr().visuraImpresaAaep(pg.getCodiceFiscale());

				if (visura != null) {
					theModel.setAppDataelencoDatiVisura(visura);

					// impostazione del result code 
					result.setResultCode(VISURA_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add(Messages.S144);
					// impostazione del result code 
					result.setResultCode(VISURA_OUTCOME_CODE__KO);
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
			log.error("[BackEndFacade::visura] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo datiCat definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults datiCat(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DATICAT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DATICAT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-402523901) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idImpSelez = theModel.getAppDataidImpresaSelezionata();

			try {
				getValidationMgr().checkSelezioneElemento(idImpSelez);

				ArrayList<PersonaGiuridica> impreseList = theModel.getAppDataelencoImprese();

				result.setResultCode(DATICAT_OUTCOME_CODE__OK);

				for (PersonaGiuridica personaGiuridica : impreseList) {
					if (personaGiuridica.getIdPersonaGiuridica().intValue() == idImpSelez.intValue()) {
						// Ho trovato l'impresa selezionata
						// devo verificare che sia un CAT
						if (!personaGiuridica.getFlgCat()) {
							result.getGlobalErrors().add(Messages.S159);
							// impostazione del result code 
							result.setResultCode(DATICAT_OUTCOME_CODE__KO);
						} else {
							// E' un CAT
							ArrayList<PersonaGiuridica> pgList = getSigitMgr()
									.cercaIncarichiCatAttivi(personaGiuridica.getIdPersonaGiuridica());

							theModel.setAppDataelencoIncarichiAttivi(pgList);

							theModel.setAppDatanumeroRapportiInviati(
									getDbMgr().cercaTotRapportiInviatiCat(personaGiuridica.getIdPersonaGiuridica()));
						}

						break;
					}
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
			log.error("[BackEndFacade::datiCat] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaMotivVariazione definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults gestLogicaMotivVariazione(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAMOTIVVARIAZIONE_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAMOTIVVARIAZIONE_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-408113006) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			PersonaGiuridica impianto = theModel.getAppDataimpresa();

			log.debug("#### impianto.getIdStatoPg(): " + impianto.getIdStatoPg());
			log.debug("#### impianto.getIdStatoPgOld(): " + impianto.getIdStatoPgOld());

			if (GenericUtil.isNotNullOrEmpty(impianto.getIdStatoPg())
					&& impianto.getIdStatoPg().intValue() != impianto.getIdStatoPgOld().intValue()) {
				// Sono in inserimento o modifica
				log.debug("***ABILITA_MOTIVAZIONE***\n\n");

				// Pulisco i campi che eventualmente erano valorizzati
				impianto.setDataVariazione(null);
				impianto.setMotivoVariazione(null);

				// impostazione del result code 
				result.setResultCode(GESTLOGICAMOTIVVARIAZIONE_OUTCOME_CODE__VISUALIZZA);

			} else {

				// Pulisco i campi che eventualmente erano valorizzati
				impianto.setDataVariazione(null);
				impianto.setMotivoVariazione(null);

				// impostazione del result code 
				result.setResultCode(GESTLOGICAMOTIVVARIAZIONE_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaMotivVariazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestTipoIndirizzoImpresa definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults gestTipoIndirizzoImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTTIPOINDIRIZZOIMPRESA_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTTIPOINDIRIZZOIMPRESA_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1246960383) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (ConvertUtil.convertToBooleanAllways(theModel.getAppDataimpresa().getFlgIndirizzoEst())) {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOIMPRESA_OUTCOME_CODE__ESTERO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOIMPRESA_OUTCOME_CODE__NAZIONALE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestTipoIndirizzoImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestIndirizzoConfImpresa definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults gestIndirizzoConfImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINDIRIZZOCONFIMPRESA_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTINDIRIZZOCONFIMPRESA_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-597046249) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			PersonaGiuridica pg = theModel.getAppDataimpresa();

			if (GenericUtil.isNotNullOrEmpty(pg.getIdIndirizzoSel())
					|| GenericUtil.isNotNullOrEmpty(pg.getIndirizzoNonTrovato())) {

				result.setResultCode(GESTINDIRIZZOCONFIMPRESA_OUTCOME_CODE__SI);

			} else {
				result.setResultCode(GESTINDIRIZZOCONFIMPRESA_OUTCOME_CODE__NO);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestIndirizzoConfImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuniImpresa definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults loadComuniImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNIIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1219111153) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(LOADCOMUNIIMPRESA_OUTCOME_CODE__OK);

			PersonaGiuridica pg = theModel.getAppDataimpresa();

			ArrayList<CodeDescription> comuniLoc = recuperaComuni(pg.getIdProvinciaSelez());

			/*
			theModel.setAppDataelencoComuni(comuniLoc);
			ArrayList<CodeDescription> comuni = new ArrayList<CodeDescription>();
			if (GenericUtil.isNotNullOrEmpty(idProvSel)) {
				comuni = (ArrayList<CodeDescription>) getServiziMgr()
						.getListaComuniByIstatProvincia(idProvSel);
			}
			 */
			theModel.setAppDataelencoComuni(comuniLoc);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadComuniImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaIndirizzoImpresa definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults cercaIndirizzoImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINDIRIZZOIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINDIRIZZOIMPRESA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1705035494) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(CERCAINDIRIZZOIMPRESA_OUTCOME_CODE__OK);

			try {
				PersonaGiuridica impresa = theModel.getAppDataimpresa();

				getValidationMgr().verificaRicercaIndirizzoImpresa(impresa);

				theModel.setAppDataelencoIndirizziImp(
						getServiziMgr().getListaVieValide(ReplaceSpecialCharUtils.sanitize(impresa.getIndirizzo())
								, ReplaceSpecialCharUtils.sanitize(impresa.getIdComuneSelez())));

				impresa.setIndirizzo(null);
				impresa.setIdIndirizzoSel(null);
				impresa.setFlgIndirizzoRicercato(true);

			} catch (ManagerException ex) {
				log.error("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaIndirizzoImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaIndImpresa definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults nuovaRicercaIndImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINDIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-896219841) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("Provincia: " + theModel.getAppDataimpresa().getIdProvinciaSelez());
			theModel.getAppDataimpresa().setIndirizzo(null);
			theModel.getAppDataimpresa().setIdIndirizzoSel(null);
			theModel.getAppDataimpresa().setIndirizzoNonTrovato(null);
			theModel.getAppDataimpresa().setFlgIndirizzoRicercato(false);

			result.setResultCode(NUOVARICERCAINDIMPRESA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaIndImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaEmailImpresa definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults verificaEmailImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAEMAILIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAEMAILIMPRESA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2011306823) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String email = theModel.getAppDataimpresa().getEmail();
			try {
				getValidationMgr().checkEmail(ConstantsField.GESTISCI_IMPRESA_EMAIL, email, getServiziMgr());

				ResultInvioMail resultInvioMail = getServiziMgr().sendMailVerifica(email);

				//StringBuffer msg = new StringBuffer();

				if (resultInvioMail != null) {

					/*
					// TEST
					if (resultInvioMail.getDestinatariOK() != null && !resultInvioMail.getDestinatariOK().isEmpty())
					{
						
						msg.append(new Message(Messages.INFO_INDIRIZZI_MAIL_OK, resultInvioMail.getFormatDestinatariOK()).getText());
						msg.append("\n"+new Message(Messages.INFO_INDIRIZZI_MAIL_KO, resultInvioMail.getFormatDestinatariOK()).getText());
						result.getGlobalMessages().add(msg.toString());
						
						
						
						result.getGlobalErrors().add(Messages.INFO_VERIFICA_EMAIL_OK);
					
						result.getGlobalErrors().add(new Message(Messages.INFO_INDIRIZZI_MAIL_KO, resultInvioMail.getFormatDestinatariOK()).getText());
					
					}
					 */

					if (resultInvioMail.getDestinatariOK() != null && !resultInvioMail.getDestinatariOK().isEmpty()) {
						result.getGlobalMessages().add(Messages.INFO_VERIFICA_EMAIL_OK);
						result.getGlobalMessages().add(
								new Message(Messages.INFO_INDIRIZZI_MAIL_OK, resultInvioMail.getFormatDestinatariOK())
										.getText());

					}

					if (resultInvioMail.getDestinatariKO() != null && !resultInvioMail.getDestinatariKO().isEmpty()) {
						result.getGlobalErrors().add(
								new Message(Messages.INFO_VERIFICA_EMAIL_KO, resultInvioMail.getFormatDestinatariKO())
										.getText());
					}

				}

				// impostazione del result code 
				result.setResultCode(VERIFICAEMAILIMPRESA_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				log.error("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaEmailImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo modificaImpresa definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults modificaImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String MODIFICAIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String MODIFICAIMPRESA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1257512062) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				PersonaGiuridica impresa = theModel.getAppDataimpresa();

				getValidationMgr().validazioneModificaImpresa(impresa);

				if (!impresa.getFlgIndirizzoEst()) {

					String descComune = GenericUtil.getDescriptionByCod(ReplaceSpecialCharUtils.sanitize(impresa.getIdComuneSelez()),
							theModel.getAppDataelencoComuni());
					String descProvincia = GenericUtil.getDescriptionByCod(ReplaceSpecialCharUtils.sanitize(impresa.getIdProvinciaSelez()),
							theModel.getAppDataelencoProvince());

					// Vuol dire che il comune/provincia non esiste più, quindi l'utente ne deve impostare un altro
					if (GenericUtil.isNullOrEmpty(descProvincia) || GenericUtil.isNullOrEmpty(descComune)) {
						log.debug("descProvincia: " + descProvincia);
						log.debug("descComune: " + descComune);
						log.debug("Rilancio l'eccezione!!!!!");
						throw new ValidationManagerException(new Message(Messages.ERROR_UPDATE_PROV_COM));
					}

					impresa.setProvincia(ReplaceSpecialCharUtils.sanitize(descProvincia));
					impresa.setComune(ReplaceSpecialCharUtils.sanitize(descComune));

					impresa.setDescIndirizzoSel(ReplaceSpecialCharUtils.sanitize(impresa.getIndirizzo()));

					if (impresa.getIdIndirizzoSel() != null)
						impresa.setDescIndirizzoSel(GenericUtil.getDescriptionByCod(
								ReplaceSpecialCharUtils.sanitize(impresa.getIdIndirizzoSel()),
								theModel.getAppDataelencoIndirizziImp()));
				}

				/*
				if (!impresa.getFlgIndirizzoEst()) {
					String descComune = GenericUtil.getDescriptionByCod(
							impresa.getIdComuneSelez(),
							theModel.getAppDataelencoComuniResp());
					String descProvincia = GenericUtil.getDescriptionByCod(
							impresa.getIdProvinciaSelez(),
							theModel.getAppDataelencoProvince());
					impresa.setDescComune(descComune);
					impresa.setDescProvincia(descProvincia);
				
					if (GenericUtil.isNotNullOrEmpty(impresa
							.getIdIndirizzo())) {
						String descIndirizzoSitad = GenericUtil
								.getDescriptionByCod(impresa
										.getIdIndirizzoSel(), theModel
										.getAppDataelencoIndirizziResp());
						impresa.setIndirizzoSitad(descIndirizzoSitad);
					}
				}
				 */

				getDbMgr().modificaPersonaGiuridica(impresa, theModel.getAppDatautenteLoggato().getCodiceFiscale());

				result.getGlobalMessages().add(Messages.INFO_MODIFICA_CORRETTA);

				// Recupero l'elenco delle imprese aggiornato
				ArrayList<PersonaGiuridica> impreseList = getSigitMgr()
						.cercaImpreseByParam(theModel.getAppDataricercaImprese());
				theModel.setAppDataelencoImprese(impreseList);

				// impostazione del result code 
				result.setResultCode(MODIFICAIMPRESA_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::modificaImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisBotRef definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults gestVisBotRef(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOTREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOTREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1294796954) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<PersonaGiuridica> impreseList = theModel.getAppDataelencoImprese();

			if (impreseList != null && impreseList.size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTREF_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTREF_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBotRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R987685161) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoDatiImpresa(utente)) {
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
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults gestisciIngresso(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINGRESSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2091985016) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<CodeDescription> provinceItalia = null;

			if (theModel.getAppDataelencoProvince() == null) {
				theModel.setAppDataelencoProvince(getServiziMgr().getListaProvincePrimaPiemonte());
			}

			if (theModel.getAppDataelencoSiglaRea() == null) {
				theModel.setAppDataelencoSiglaRea(getSigitMgr().getListaSigleRea());
			}

			//			if (theModel.getAppDatatipiDM() == null) {
			//				theModel.setAppDatatipiDM(getDbMgr().cercaListaTipiDm());
			//			}

			if (theModel.getAppDataruoliImpresa() == null) {
				theModel.setAppDataruoliImpresa(GenericUtil.getComboRuoliImpresa());
			}

			//			if (theModel.getAppDataruoliAccred() == null) {
			//				theModel.setAppDataruoliAccred(getDbMgr()
			//						.cercaListaRuoliAccred());
			//			}

			if (theModel.getAppDataelencoStatoImp() == null) {
				theModel.setAppDataelencoStatoImp(getDbMgr().cercaListaStatiPg());
			}

			// impostazione del result code 
			result.setResultCode(GESTISCIINGRESSO_OUTCOME_CODE__OK);

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
	 * Implementazione del metodo gestAbilCheckboxImpresaSoggDelegato definito in un ExecCommand del
	 * ContentPanel cpGestImpresa
	 */
	public ExecResults gestAbilCheckboxImpresaSoggDelegato(

			it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTABILCHECKBOXIMPRESASOGGDELEGATO_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTABILCHECKBOXIMPRESASOGGDELEGATO_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-824519147) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String descRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();

			if (descRuolo.equals(Constants.RUOLO_SUPER)) {
				result.setResultCode(GESTABILCHECKBOXIMPRESASOGGDELEGATO_OUTCOME_CODE__ABILITA);
			} else {
				result.setResultCode(GESTABILCHECKBOXIMPRESASOGGDELEGATO_OUTCOME_CODE__DISABILITA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAbilCheckboxImpresaSoggDelegato] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbImpTrovate
	 */
	public static void resetClearStatus_widg_tbImpTrovate(java.util.Map session) {
		session.put("cpGestImpresa_tbImpTrovate_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbVisuraImpresa
	 */
	public static void resetClearStatus_widg_tbVisuraImpresa(java.util.Map session) {
		session.put("cpGestImpresa_tbVisuraImpresa_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbIncTrovate
	 */
	public static void resetClearStatus_widg_tbIncTrovate(java.util.Map session) {
		session.put("cpGestImpresa_tbIncTrovate_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1929736292) ENABLED START*/
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

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
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

	private void gestioneMsgRicerca(CpGestImpresaModel theModel, ExecResults result) throws DbManagerException {
		Integer maxNumRighe = getDbMgr().cercaConfigValueNumerico(Constants.MAX_RIGHE_RIC_AVANZATA_IMPIANTI);
		log.debug("MAX num righe da visualizzare = " + maxNumRighe);

		ArrayList<PersonaGiuridica> impreseList = theModel.getAppDataelencoImprese();

		if (impreseList != null && impreseList.size() == maxNumRighe)
			result.getGlobalMessages()
					.add(Messages.MSG_RISULTATI_RICERCA.replaceFirst("##value##", maxNumRighe.toString()));
	}

	/*PROTECTED REGION END*/
}
