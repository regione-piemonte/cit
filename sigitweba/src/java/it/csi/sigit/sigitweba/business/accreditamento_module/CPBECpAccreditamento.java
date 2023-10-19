package it.csi.sigit.sigitweba.business.accreditamento_module;

import java.util.*;

import it.csi.sigit.sigitweba.dto.*;
import it.csi.sigit.sigitweba.dto.common.*;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.*;

import org.apache.log4j.*;
import it.csi.sigit.sigitweba.util.*;
import it.csi.sigit.sigitweba.business.*;

/*PROTECTED REGION ID(R1988067545) ENABLED START*/
import org.springframework.dao.DataIntegrityViolationException;

import it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitRPfPgDelegaDto;
import it.csi.sigit.sigitweba.business.manager.DbMgr;
import it.csi.sigit.sigitweba.business.manager.ServiziMgr;
import it.csi.sigit.sigitweba.business.manager.ValidationMgr;
import it.csi.sigit.sigitweba.business.manager.util.DbManagerException;
import it.csi.sigit.sigitweba.business.manager.util.ManagerException;
import it.csi.sigit.sigitweba.business.manager.util.Message;
import it.csi.sigit.sigitweba.business.manager.util.ServiceException;
import it.csi.sigit.sigitweba.business.manager.util.ValidationManagerException;

import org.apache.commons.beanutils.PropertyUtils;

/*PROTECTED REGION END*/

public class CPBECpAccreditamento {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [personaFisica, scope:USER_SESSION]
	public static final String APPDATA_PERSONAFISICA_CODE = "appDatapersonaFisica";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [province, scope:USER_SESSION]
	public static final String APPDATA_PROVINCE_CODE = "appDataprovince";

	// ApplicationData: [comuni, scope:USER_SESSION]
	public static final String APPDATA_COMUNI_CODE = "appDatacomuni";

	// ApplicationData: [elencoIndirizziPF, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZIPF_CODE = "appDataelencoIndirizziPF";

	// ApplicationData: [listFormazioni, scope:USER_SESSION]
	public static final String APPDATA_LISTFORMAZIONI_CODE = "appDatalistFormazioni";

	// ApplicationData: [Formazione, scope:USER_SESSION]
	public static final String APPDATA_FORMAZIONE_CODE = "appDataFormazione";

	// ApplicationData: [elencoImprese, scope:USER_SESSION]
	public static final String APPDATA_ELENCOIMPRESE_CODE = "appDataelencoImprese";

	// ApplicationData: [personaGiuridica, scope:USER_SESSION]
	public static final String APPDATA_PERSONAGIURIDICA_CODE = "appDatapersonaGiuridica";

	// ApplicationData: [elencoSigleRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLEREA_CODE = "appDataelencoSigleRea";

	// ApplicationData: [impresaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IMPRESASELEZIONATA_CODE = "appDataimpresaSelezionata";

	// ApplicationData: [elencoIndirizziPG, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZIPG_CODE = "appDataelencoIndirizziPG";

	// ApplicationData: [ruoliImpresa, scope:USER_SESSION]
	public static final String APPDATA_RUOLIIMPRESA_CODE = "appDataruoliImpresa";

	// ApplicationData: [tipiDM, scope:USER_SESSION]
	public static final String APPDATA_TIPIDM_CODE = "appDatatipiDM";

	// ApplicationData: [elencoProvinceIT, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEIT_CODE = "appDataelencoProvinceIT";

	// ApplicationData: [elencoComuniPG, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIPG_CODE = "appDataelencoComuniPG";

	// ApplicationData: [isPrimoIngresso, scope:USER_SESSION]
	public static final String APPDATA_ISPRIMOINGRESSO_CODE = "appDataisPrimoIngresso";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpAccreditamento";

	public static final String MULTIPANEL_MPFORMAZIONE = "mpFormazione";
	public static final String MPI_MPFORMAZIONE_FPNUOVAFORMAZIONE = CPNAME + "_" + MULTIPANEL_MPFORMAZIONE + "_"
			+ "fpNuovaFormazione";

	public static final String MULTIPANEL_MPIMPRESA = "mpImpresa";
	public static final String MPI_MPIMPRESA_FMNUOVAIMPRESA = CPNAME + "_" + MULTIPANEL_MPIMPRESA + "_"
			+ "fmNuovaImpresa";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestTipoIndirizzo definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults gestTipoIndirizzo(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTTIPOINDIRIZZO_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTTIPOINDIRIZZO_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1685280091) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (ConvertUtil.convertToBooleanAllways(theModel.getAppDatapersonaFisica().getFlgIndirizzoEst())) {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZO_OUTCOME_CODE__ESTERO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZO_OUTCOME_CODE__NAZIONALE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestTipoIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestIndirizzoConf definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults gestIndirizzoConf(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINDIRIZZOCONF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTINDIRIZZOCONF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R135737155) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			PersonaFisica pf = theModel.getAppDatapersonaFisica();

			if (GenericUtil.isNonNullOrEmpty(pf.getIdIndirizzoSel())
					|| GenericUtil.isNonNullOrEmpty(pf.getIndirizzoNonTrovato())) {

				result.setResultCode(GESTINDIRIZZOCONF_OUTCOME_CODE__SI);

			} else {
				result.setResultCode(GESTINDIRIZZOCONF_OUTCOME_CODE__NO);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestIndirizzoConf] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuni definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults loadComuni(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R553006605) ENABLED START*/

			String idProvSel = theModel.getAppDatapersonaFisica().getIdProvinciaSelez();
			ArrayList<CodeDescription> comuni = new ArrayList<CodeDescription>();

			if (GenericUtil.isNonNullOrEmpty(idProvSel)) {
				comuni = (ArrayList<CodeDescription>) getServiziMgr().getComuniByIstatProvincia(idProvSel);
			}

			theModel.setAppDatacomuni(comuni);
			result.setResultCode(LOADCOMUNI_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadComuni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaIndirizzo definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults ricercaIndirizzo(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAINDIRIZZO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAINDIRIZZO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1250141387) ENABLED START*/
			result.setResultCode(RICERCAINDIRIZZO_OUTCOME_CODE__OK);

			try {
				PersonaFisica pf = theModel.getAppDatapersonaFisica();
				getValidationMgr().verificaRicercaIndirizzoPersonaFisica(pf);

				theModel.setAppDataelencoIndirizziPF(
						getServiziMgr().getListaVieValide(pf.getIndirizzo(), pf.getIdComuneSelez()));

				theModel.getAppDatapersonaFisica().setIndirizzo(null);
				theModel.getAppDatapersonaFisica().setIdIndirizzoSel(null);
				theModel.getAppDatapersonaFisica().setFlgEseguitaRicerca(true);
			} catch (ManagerException ex) {
				log.error("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaIndirizzo definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults nuovaRicercaIndirizzo(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINDIRIZZO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAINDIRIZZO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1429886932) ENABLED START*/

			theModel.getAppDatapersonaFisica().setIndirizzo(null);
			theModel.getAppDatapersonaFisica().setIdIndirizzoSel(null);
			theModel.getAppDatapersonaFisica().setIndirizzoNonTrovato(null);
			theModel.getAppDatapersonaFisica().setFlgEseguitaRicerca(false);

			result.setResultCode(NUOVARICERCAINDIRIZZO_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaMail definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults verificaMail(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAMAIL_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAMAIL_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1094150748) ENABLED START*/
			result.setResultCode(VERIFICAMAIL_OUTCOME_CODE__OK);

			String email = theModel.getAppDatapersonaFisica().getEmail();
			try {
				getValidationMgr().checkEmail(ConstantsField.ACCREDITAMENTO_PERSONA_F_EMAIL, email, getServiziMgr());

				result.getGlobalMessages().add(Messages.MSG_VERIFICA_EMAIL_OK.concat(email));

			} catch (ManagerException ex) {
				log.error("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaMail] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaAccreditamento definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults salvaAccreditamento(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAACCREDITAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAACCREDITAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-701954622) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			PersonaFisica persona = theModel.getAppDatapersonaFisica();
			try {
				getValidationMgr().validazioneFormaleAcceditamento(persona, result);

				String descComune = GenericUtil.getDescriptionByCode(persona.getIdComuneSelez(),
						theModel.getAppDatacomuni());
				String descProvincia = GenericUtil.getDescriptionByCode(persona.getIdProvinciaSelez(),
						theModel.getAppDataprovince());

				// Vuol dire che il comune/provincia non esiste piu', quindi l'utente ne deve impostare un altro
				if (!ConvertUtil.convertToBooleanAllways(persona.getFlgIndirizzoEst())
						&& (GenericUtil.isNullOrEmpty(descProvincia) || GenericUtil.isNullOrEmpty(descComune))) {
					log.debug("descProvincia: " + descProvincia);
					log.debug("descComune: " + descComune);
					log.debug("Rilancio l'eccezione!!!!!");
					throw new ValidationManagerException(new Message(Messages.ERROR_UPDATE_PROV_COM));
				}

				persona.setProvincia(descProvincia);
				persona.setComune(descComune);

				if (persona.getIdIndirizzoSel() != null)
					persona.setIndirizzo(GenericUtil.getDescriptionByCode(persona.getIdIndirizzoSel(),
							theModel.getAppDataelencoIndirizziPF()));

				getDbMgr().modificaPersonaFisica(persona, theModel.getAppDatacurrentUser().getCodFisc());

				result.getGlobalMessages().add(Messages.MSG_AGGIORNAMENTO_CORRETTO);

				// impostazione del result code 
				result.setResultCode(SALVAACCREDITAMENTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				ex.printStackTrace();

				//				System.out
				//						.println("\n\n\n##################### INTERCETTO L'eccezione");
				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaAccreditamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciFormazione definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults inserisciFormazione(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIFORMAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1265052753) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(INSERISCIFORMAZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciFormazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaFormazione definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults salvaFormazione(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAFORMAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAFORMAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R554492211) ENABLED START*/

			Formazione formazione = theModel.getAppDataFormazione();
			try {
				validationMgr.validazioneFormazione(formazione);
				//salvataggio formazione su DB
				formazione.setIdPersonaFisica(theModel.getAppDatapersonaFisica().getIdPersona());
				dbMgr.salvaFormazione(formazione);
				result.setResultCode(SALVAFORMAZIONE_OUTCOME_CODE__OK);
				result.getGlobalMessages().add(Messages.MSG_AGGIORNAMENTO_CORRETTO);

				//aggiornamento lista formazioni
				ArrayList<Formazione> formazioneList = dbMgr
						.cercaFormazioneByIdPersona(theModel.getAppDatapersonaFisica().getIdPersona());
				theModel.setAppDatalistFormazioni(formazioneList);
				//pulisci formazione da sessione
				theModel.setAppDataFormazione(null);
			} catch (ManagerException ex) {
				log.error("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			} catch (Exception ve) {
				if (ve instanceof DataIntegrityViolationException) {
					result.setResultCode(SALVAFORMAZIONE_OUTCOME_CODE__KO);
					log.debug("ERRORE: VIOLAZIONE INTEGRITA");
					result.getGlobalErrors().add(Messages.ERROR_INSERIMENTO_DATA_FORMAZIONE);
				}
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaFormazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaFormazione definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults annullaFormazione(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLAFORMAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLAFORMAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R956445071) ENABLED START*/

			result.setResultCode(ANNULLAFORMAZIONE_OUTCOME_CODE__OK);

			theModel.setAppDataFormazione(null);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaFormazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciImpresa definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults inserisciImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-557478496) ENABLED START*/

			theModel.setAppDatapersonaGiuridica(null);
			theModel.setAppDataimpresaSelezionata(null);
			result.setResultCode(INSERISCIIMPRESA_OUTCOME_CODE__OK);
			caricaComboImpresa(theModel);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo selezionaImpresa definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults selezionaImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SELEZIONAIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SELEZIONAIMPRESA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-155800611) ENABLED START*/
			result.setResultCode(SELEZIONAIMPRESA_OUTCOME_CODE__KO);

			String idPG = theModel.getAppDataimpresaSelezionata();
			if (idPG == null) {
				result.setResultCode(SELEZIONAIMPRESA_OUTCOME_CODE__KO);
				result.getGlobalErrors().add(Messages.ERROR_SELEZIONA_IMPRESA);
			} else {
				PersonaGiuridica personaG = null;
				ArrayList<PersonaGiuridica> imprese = theModel.getAppDataelencoImprese();
				for (PersonaGiuridica pg : imprese) {

					GenericUtil.stampa(pg, true, 3);

					if (pg.getIdPersonaGiuridica().equals(idPG)) {

						//personaG = pg;
						personaG = new PersonaGiuridica();
						PropertyUtils.copyProperties(personaG, pg);
					}
				}

				if (personaG.getDataFine() != null) {
					result.setResultCode(SELEZIONAIMPRESA_OUTCOME_CODE__KO);
					result.getGlobalErrors().add(Messages.ERROR_LEGAME_CESSATO);
				} else {
					if (Constants.FLAG_DELEGA.equals(personaG.getFlgDelega())) {
						result.setResultCode(SELEZIONAIMPRESA_OUTCOME_CODE__KO);
						result.getGlobalErrors().add(Messages.ERROR_LEGAME_DELEGA);
					}
					if (Constants.FLAG_ACCREDITAMENTO.equals(personaG.getFlgDelega())) {
						personaG.setFlgEseguitaRicerca(true);

						theModel.setAppDatapersonaGiuridica(personaG);
						caricaComboImpresa(theModel);
						result.setResultCode(SELEZIONAIMPRESA_OUTCOME_CODE__OK);
					}
				}

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::selezionaImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestTipoIndirizzoImpresaMod definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults gestTipoIndirizzoImpresaMod(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTTIPOINDIRIZZOIMPRESAMOD_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTTIPOINDIRIZZOIMPRESAMOD_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-890665626) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (ConvertUtil.convertToBooleanAllways(theModel.getAppDatapersonaGiuridica().getFlgIndirizzoEst())) {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOIMPRESAMOD_OUTCOME_CODE__ESTERO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOIMPRESAMOD_OUTCOME_CODE__NAZIONALE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestTipoIndirizzoImpresaMod] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestDataInizioAtt definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults gestDataInizioAtt(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTDATAINIZIOATT_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTDATAINIZIOATT_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-923042086) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			PersonaGiuridica pg = theModel.getAppDatapersonaGiuridica();

			if (pg.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_ATTIVA
					|| pg.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_CESSATA) {
				// impostazione del result code 
				result.setResultCode(GESTDATAINIZIOATT_OUTCOME_CODE__ABILITA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTDATAINIZIOATT_OUTCOME_CODE__DISABILITA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestDataInizioAtt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestDataCessazione definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults gestDataCessazione(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTDATACESSAZIONE_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTDATACESSAZIONE_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R766396705) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			PersonaGiuridica pg = theModel.getAppDatapersonaGiuridica();

			if (pg.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_ATTIVA) {
				// impostazione del result code 
				result.setResultCode(GESTDATACESSAZIONE_OUTCOME_CODE__ABILITA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTDATACESSAZIONE_OUTCOME_CODE__DISABILITA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestDataCessazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo apriConfermaCessazioneLegame definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults apriConfermaCessazioneLegame(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String APRICONFERMACESSAZIONELEGAME_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String APRICONFERMACESSAZIONELEGAME_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-935798636) ENABLED START*/

			result.setResultCode(APRICONFERMACESSAZIONELEGAME_OUTCOME_CODE__OK);

			String idPG = theModel.getAppDataimpresaSelezionata();
			if (idPG == null) {
				result.setResultCode(APRICONFERMACESSAZIONELEGAME_OUTCOME_CODE__KO);
				result.getGlobalErrors().add(Messages.ERROR_SELEZIONA_IMPRESA);
			} else {
				PersonaGiuridica personaG = null;
				for (PersonaGiuridica pg : theModel.getAppDataelencoImprese())
					if (idPG.equals(pg.getIdPersonaGiuridica()))
						personaG = pg;
				if (personaG.getDataFine() != null) {
					result.getGlobalErrors().add(Messages.ERROR_LEGAME_ATTIVO_DA_CESSARE);
					result.setResultCode(APRICONFERMACESSAZIONELEGAME_OUTCOME_CODE__KO);
				}
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::apriConfermaCessazioneLegame] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestTipoIndirizzoImpresa definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults gestTipoIndirizzoImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTTIPOINDIRIZZOIMPRESA_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTTIPOINDIRIZZOIMPRESA_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1691590640) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (ConvertUtil.convertToBooleanAllways(theModel.getAppDatapersonaGiuridica().getFlgIndirizzoEst())) {
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
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults gestIndirizzoConfImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINDIRIZZOCONFIMPRESA_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTINDIRIZZOCONFIMPRESA_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R759370024) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			PersonaGiuridica pg = theModel.getAppDatapersonaGiuridica();

			if (GenericUtil.isNonNullOrEmpty(pg.getIdIndirizzoSel())
					|| GenericUtil.isNonNullOrEmpty(pg.getIndirizzoNonTrovato())) {

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
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults loadComuniImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNIIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1782493982) ENABLED START*/

			result.setResultCode(LOADCOMUNIIMPRESA_OUTCOME_CODE__OK);

			PersonaGiuridica pg = theModel.getAppDatapersonaGiuridica();
			String idProvSel = pg.getIdProvinciaSelez();
			String idIndSel = pg.getIdIndirizzoSel();

			ArrayList<CodeDescription> comuni = new ArrayList<CodeDescription>();
			if (GenericUtil.isNonNullOrEmpty(idProvSel)) {
				comuni = (ArrayList<CodeDescription>) getServiziMgr().getComuniByIstatProvincia(idProvSel);
			}
			theModel.setAppDataelencoComuniPG(comuni);

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
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults cercaIndirizzoImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINDIRIZZOIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINDIRIZZOIMPRESA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1236437591) ENABLED START*/

			result.setResultCode(CERCAINDIRIZZOIMPRESA_OUTCOME_CODE__OK);

			try {
				PersonaGiuridica pg = theModel.getAppDatapersonaGiuridica();
				getValidationMgr().validazioneIndirizzoImpresa(pg);

				theModel.setAppDataelencoIndirizziPG(
						getServiziMgr().getListaVieValide(pg.getIndirizzo(), pg.getIdComuneSelez()));

				theModel.getAppDatapersonaGiuridica().setIndirizzo(null);
				theModel.getAppDatapersonaGiuridica().setIdIndirizzoSel(null);
				theModel.getAppDatapersonaGiuridica().setFlgEseguitaRicerca(true);

			} catch (ManagerException ex) {
				log.error("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}

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
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults nuovaRicercaIndImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINDIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R745413264) ENABLED START*/

			log.debug("Provincia: " + theModel.getAppDatapersonaGiuridica().getIdProvinciaSelez());
			theModel.getAppDatapersonaGiuridica().setIndirizzo(null);
			theModel.getAppDatapersonaGiuridica().setIdIndirizzoSel(null);
			theModel.getAppDatapersonaGiuridica().setFlgEseguitaRicerca(false);

			result.setResultCode(NUOVARICERCAINDIMPRESA_OUTCOME_CODE__OK);
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
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults verificaEmailImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAEMAILIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAEMAILIMPRESA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1883134538) ENABLED START*/
			result.setResultCode(VERIFICAEMAILIMPRESA_OUTCOME_CODE__OK);

			String email = theModel.getAppDatapersonaGiuridica().getEmail();
			try {
				getValidationMgr().checkEmail(ConstantsField.ACCREDITAMENTO_IMPRESA_F_EMAIL, email, getServiziMgr());
				result.getGlobalMessages().add(Messages.MSG_VERIFICA_EMAIL_OK.concat(email));

			} catch (ManagerException ex) {
				log.error("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}

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
	 * Implementazione del metodo salvaImpresaAssociata definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults salvaImpresaAssociata(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAIMPRESAASSOCIATA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAIMPRESAASSOCIATA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-960573664) ENABLED START*/

			try {
				PersonaGiuridica pg = theModel.getAppDatapersonaGiuridica();
				validationMgr.validazioneNuovaImpresa(pg);
				String idPF = theModel.getAppDatapersonaFisica().getIdPersona();
				String impresaSelezionata = theModel.getAppDataimpresaSelezionata();

				pg.setIdPersonaFisica(idPF);
				pg.setIdPersonaGiuridica(impresaSelezionata);
				pg.setFlgDelega(Constants.FLAG_ACCREDITAMENTO);
				if (pg.getDataInizio() == null)
					pg.setDataInizio(DateUtil.getString(DateUtil.getSqlDate()));

				if (!pg.getFlgIndirizzoEst()) {

					String descComune = GenericUtil.getDescriptionByCode(pg.getIdComuneSelez(),
							theModel.getAppDataelencoComuniPG());
					String descProvincia = GenericUtil.getDescriptionByCode(pg.getIdProvinciaSelez(),
							theModel.getAppDataelencoProvinceIT());

					// Vuol dire che il comune/provincia non esiste piu', quindi l'utente ne deve impostare un altro
					if (GenericUtil.isNullOrEmpty(descProvincia) || GenericUtil.isNullOrEmpty(descComune)) {
						log.debug("descProvincia: " + descProvincia);
						log.debug("descComune: " + descComune);
						log.debug("Rilancio l'eccezione!!!!!");
						throw new ValidationManagerException(new Message(Messages.ERROR_UPDATE_PROV_COM));
					}

					pg.setProvincia(descProvincia);
					pg.setComune(descComune);

					pg.setDescIndirizzoSel(pg.getIndirizzo());
					if (pg.getIdIndirizzoSel() != null)
						pg.setDescIndirizzoSel(GenericUtil.getDescriptionByCode(pg.getIdIndirizzoSel(),
								theModel.getAppDataelencoIndirizziPG()));
				}

				//email UPPER
				pg.setEmail(pg.getEmail().toUpperCase());

				if (GenericUtil.isNullOrEmpty(pg.getDataCessazione())) {
					pg.setIdStatoPg(Constants.ID_STATO_IMPRESA_ATTIVA);
				} else {
					pg.setIdStatoPg(Constants.ID_STATO_IMPRESA_CESSATA);
				}

				if (impresaSelezionata == null) {
					log.debug("Inserimenteo nuova impresa");
					List<PersonaGiuridica> listImp = null;

					listImp = dbMgr.cercaPersonaGiuridicaByCodiceReaCodiceFiscale(pg);

					if (listImp.isEmpty()) {
						dbMgr.insertAssociazionePfPg(pg, theModel.getAppDatacurrentUser().getCodFisc());
						caricaImpreseAssociate(theModel);
						result.setResultCode(SALVAIMPRESAASSOCIATA_OUTCOME_CODE__OK);
						result.getGlobalMessages().add(Messages.MSG_AGGIORNAMENTO_CORRETTO);
					} else {
						//controllare se sia stata flaggata/selezionata almeno una delle voci flg_installatore/flg_manutentore/flg_amministratore/flg_cat

						// Togliere questo controllo e lasciare il nuovo
						PersonaGiuridica personaGiuridica = listImp.get(0);
						//						if (personaGiuridica.getFlgAmministratore()
						//								|| personaGiuridica.getFlgInstallatore()
						//								|| personaGiuridica.getFlgManutentore()
						//								|| personaGiuridica.getFlgDistributore()
						//								|| personaGiuridica.getFlgCat()) {
						//							result.getGlobalErrors().add(
						//									Messages.ERROR_CODICE_REA_PRESENTE);
						//							result.setResultCode(SALVAIMPRESAASSOCIATA_OUTCOME_CODE__KO);
						//						} else {
						//
						log.debug("Stampo la persona giuridica: " + personaGiuridica.getIdPersonaGiuridica());

						// DEVO VERIFICARE CHE NON ABBIA COLLEGAMENTI VALIDI
						ArrayList<SigitRPfPgDelegaDto> assValid = getDbMgr()
								.cercaAssociazioneAPfPgValideByPg(personaGiuridica.getIdPersonaGiuridica());

						if (assValid != null && !assValid.isEmpty()) {
							result.getGlobalErrors().add(Messages.ERROR_CODICE_REA_PIVA_PRESENTE);
							result.setResultCode(SALVAIMPRESAASSOCIATA_OUTCOME_CODE__KO);
						} else {
							//eseguire update dei dati (vince l'informazione dichiarata dall'utente.
							pg.setIdPersonaGiuridica(personaGiuridica.getIdPersonaGiuridica());
							log.debug("persona giuridica: " + pg.getIdPersonaGiuridica());
							dbMgr.aggiungiLegameAPersonaGiuridica(pg, theModel.getAppDatacurrentUser().getCodFisc());
							caricaImpreseAssociate(theModel);

							result.setResultCode(SALVAIMPRESAASSOCIATA_OUTCOME_CODE__OK);
							result.getGlobalMessages().add(Messages.MSG_AGGIORNAMENTO_CORRETTO);
						}

						//}
					}
				} else {
					log.debug("Modifica dati impresa");
					dbMgr.modificaPersonaGiuridica(pg, theModel.getAppDatacurrentUser().getCodFisc());
					result.setResultCode(SALVAIMPRESAASSOCIATA_OUTCOME_CODE__OK);
					result.getGlobalMessages().add(Messages.MSG_AGGIORNAMENTO_CORRETTO);
					caricaImpreseAssociate(theModel);
				}

				if (SALVAIMPRESAASSOCIATA_OUTCOME_CODE__KO.equals(result.getResultCode())) {
					caricaComboImpresa(theModel);
				}
			} catch (ManagerException ex) {
				ex.printStackTrace();
				Validator.gestisciEccezione(result, ex);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaImpresaAssociata] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cessaLegame definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults cessaLegame(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CESSALEGAME_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CESSALEGAME_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-854618836) ENABLED START*/
			result.setResultCode(CESSALEGAME_OUTCOME_CODE__OK);

			String idPG = theModel.getAppDataimpresaSelezionata();
			if (idPG == null) {
				result.setResultCode(CESSALEGAME_OUTCOME_CODE__KO);
				result.getGlobalErrors().add(Messages.ERROR_SELEZIONA_IMPRESA);
			} else {
				PersonaGiuridica personaG = null;
				for (PersonaGiuridica pg : theModel.getAppDataelencoImprese())
					if (idPG.equals(pg.getIdPersonaGiuridica()))
						personaG = pg;
				dbMgr.cessaLegame(personaG, theModel.getAppDatacurrentUser().getCodFisc());
				caricaImpreseAssociate(theModel);
				result.getGlobalMessages().add(Messages.MSG_AGGIORNAMENTO_CORRETTO);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cessaLegame] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestTipoIndirizzoInit definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults gestTipoIndirizzoInit(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTTIPOINDIRIZZOINIT_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTTIPOINDIRIZZOINIT_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1011931819) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (ConvertUtil.convertToBooleanAllways(theModel.getAppDatapersonaFisica().getFlgIndirizzoEst())) {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOINIT_OUTCOME_CODE__ESTERO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOINIT_OUTCOME_CODE__NAZIONALE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestTipoIndirizzoInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeo definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2007547056) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			gestisciComboDtCatasto(theModel);
			result.setResultCode(GESTISCICOMBOGEO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboGeo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaComboIndirizzo definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults visualizzaComboIndirizzo(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZACOMBOINDIRIZZO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZACOMBOINDIRIZZO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1856150730) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("VISUALIZZA COMBO INDIRIZZO");
			// impostazione del result code 
			result.setResultCode(VISUALIZZACOMBOINDIRIZZO_OUTCOME_CODE__KO);

			ArrayList<CodeDescription> indirizzi = new ArrayList<CodeDescription>();

			PersonaFisica pf = theModel.getAppDatapersonaFisica();
			String idComuneSel = pf.getIdComuneSelez();
			String idIndSel = pf.getIdIndirizzoSel();

			log.debug("comune sel: " + idComuneSel);
			log.debug("ind sel: " + idIndSel);

			if (GenericUtil.isNonNullOrEmpty(idIndSel)) {
				
				// Modifica BEPPE, ottimizzazione combo vie, in caso ci sia l'ID creo una combo con solo quel valore
				CodeDescription indirizzo = new CodeDescription();
				indirizzo.setCode(idIndSel);
				indirizzo.setDescription(pf.getIndirizzo());
				indirizzi.add(indirizzo);
				
				/*
				ArrayList<CodeDescription> listaIndirizziSess = theModel.getAppDataelencoIndirizziPF();
				if (listaIndirizziSess != null && listaIndirizziSess.size() > 0) {
					indirizzi = listaIndirizziSess;
				} else {
					indirizzi = getServiziMgr().getListaVieValide(pf.getIndirizzo(), idComuneSel);
				}
				*/
				result.setResultCode(VISUALIZZACOMBOINDIRIZZO_OUTCOME_CODE__OK);
			}

			String indirizzoNonTrovato = pf.getIndirizzoNonTrovato();
			if (GenericUtil.isNonNullOrEmpty(indirizzoNonTrovato)) {
				result.setResultCode(VISUALIZZACOMBOINDIRIZZO_OUTCOME_CODE__OK);
			}

			theModel.setAppDataelencoIndirizziPF(indirizzi);
			if (GenericUtil.isNonNullOrEmpty(idIndSel) || GenericUtil.isNonNullOrEmpty(indirizzoNonTrovato)) {
				theModel.getAppDatapersonaFisica().setFlgEseguitaRicerca(true);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaComboIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaFormazione definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults caricaFormazione(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAFORMAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-145064075) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(CARICAFORMAZIONE_OUTCOME_CODE__OK);

			ArrayList<Formazione> formazioneList = dbMgr
					.cercaFormazioneByIdPersona(theModel.getAppDatapersonaFisica().getIdPersona());
			theModel.setAppDatalistFormazioni(formazioneList);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			resetClearStatus_widg_tbFormazione(theModel.getSession());
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaFormazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaImpreseAssociate definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults caricaImpreseAssociate(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAIMPRESEASSOCIATE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R427442018) ENABLED START*/
			String cfPF = theModel.getAppDatapersonaFisica().getCodiceFiscale();
			ArrayList<PersonaGiuridica> impreseAssociate = dbMgr.getImpreseAssociate(cfPF);
			theModel.setAppDataelencoImprese(impreseAssociate);

			resetClearStatus_widg_tbImprese(theModel.getSession());
			result.setResultCode(CARICAIMPRESEASSOCIATE_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaImpreseAssociate] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisBottoni definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults gestVisBottoni(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOTTONI_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOTTONI_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R555968294) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<PersonaGiuridica> impreseAssociate = theModel.getAppDataelencoImprese();

			if (impreseAssociate != null && impreseAssociate.size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTTONI_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTTONI_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBottoni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isPrimoAccesso definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults isPrimoAccesso(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISPRIMOACCESSO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISPRIMOACCESSO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-239253834) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("###### E' primo accesso: " + theModel.getAppDataisPrimoIngresso());

			if (ConvertUtil.convertToBooleanAllways(theModel.getAppDataisPrimoIngresso())) {
				theModel.setAppDataisPrimoIngresso(false);
				// impostazione del result code 
				result.setResultCode(ISPRIMOACCESSO_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISPRIMOACCESSO_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isPrimoAccesso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestTipoIndirizzoRef definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults gestTipoIndirizzoRef(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTTIPOINDIRIZZOREF_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTTIPOINDIRIZZOREF_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1657419446) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (ConvertUtil.convertToBooleanAllways(theModel.getAppDatapersonaFisica().getFlgIndirizzoEst())) {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOREF_OUTCOME_CODE__ESTERO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOREF_OUTCOME_CODE__NAZIONALE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestTipoIndirizzoRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeoRef definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults gestisciComboGeoRef(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEOREF_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-254171691) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			gestisciComboDtCatasto(theModel);
			result.setResultCode(GESTISCICOMBOGEOREF_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboGeoRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaComboIndirizzoRef definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults visualizzaComboIndirizzoRef(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZACOMBOINDIRIZZOREF_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZACOMBOINDIRIZZOREF_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-786458757) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("VISUALIZZA COMBO INDIRIZZO");
			// impostazione del result code 
			result.setResultCode(VISUALIZZACOMBOINDIRIZZOREF_OUTCOME_CODE__KO);

			ArrayList<CodeDescription> indirizzi = new ArrayList<CodeDescription>();

			PersonaFisica pf = theModel.getAppDatapersonaFisica();
			String idComuneSel = pf.getIdComuneSelez();
			String idIndSel = pf.getIdIndirizzoSel();

			log.debug("comune sel: " + idComuneSel);
			log.debug("ind sel: " + idIndSel);

			if (GenericUtil.isNonNullOrEmpty(idIndSel)) {
				
				// Modifica BEPPE, ottimizzazione combo vie, in caso ci sia l'ID creo una combo con solo quel valore
				CodeDescription indirizzo = new CodeDescription();
				indirizzo.setCode(idIndSel);
				indirizzo.setDescription(pf.getIndirizzo());
				indirizzi.add(indirizzo);
				
				/*
				ArrayList<CodeDescription> listaIndirizziSess = theModel.getAppDataelencoIndirizziPF();
				if (listaIndirizziSess != null && listaIndirizziSess.size() > 0) {
					indirizzi = listaIndirizziSess;
				} else {
					indirizzi = getServiziMgr().getListaVieValide(pf.getIndirizzo(), idComuneSel);
				}
				*/
				
				result.setResultCode(VISUALIZZACOMBOINDIRIZZOREF_OUTCOME_CODE__OK);
			}

			String indirizzoNonTrovato = pf.getIndirizzoNonTrovato();
			if (GenericUtil.isNonNullOrEmpty(indirizzoNonTrovato)) {
				result.setResultCode(VISUALIZZACOMBOINDIRIZZOREF_OUTCOME_CODE__OK);
			}

			theModel.setAppDataelencoIndirizziPF(indirizzi);
			if (GenericUtil.isNonNullOrEmpty(idIndSel) || GenericUtil.isNonNullOrEmpty(indirizzoNonTrovato)) {
				theModel.getAppDatapersonaFisica().setFlgEseguitaRicerca(true);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaComboIndirizzoRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaImpreseAssociateRef definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults caricaImpreseAssociateRef(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAIMPRESEASSOCIATEREF_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-321794589) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String cfPF = theModel.getAppDatapersonaFisica().getCodiceFiscale();
			ArrayList<PersonaGiuridica> impreseAssociate = dbMgr.getImpreseAssociate(cfPF);
			theModel.setAppDataelencoImprese(impreseAssociate);

			resetClearStatus_widg_tbImprese(theModel.getSession());
			result.setResultCode(CARICAIMPRESEASSOCIATEREF_OUTCOME_CODE__OK);
			result.setModel(theModel);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaImpreseAssociateRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisBottoniRef definito in un ExecCommand del
	 * ContentPanel cpAccreditamento
	 */
	public ExecResults gestVisBottoniRef(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOTTONIREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOTTONIREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1788632991) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<PersonaGiuridica> impreseAssociate = theModel.getAppDataelencoImprese();

			if (impreseAssociate != null && impreseAssociate.size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTTONIREF_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTTONIREF_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBottoniRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbFormazione
	 */
	public static void resetClearStatus_widg_tbFormazione(java.util.Map session) {
		session.put("cpAccreditamento_tbFormazione_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbImprese
	 */
	public static void resetClearStatus_widg_tbImprese(java.util.Map session) {
		session.put("cpAccreditamento_tbImprese_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R2038408379) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

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

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private void gestisciComboDtCatasto(CpAccreditamentoModel theModel) throws BEException {

		log.debug("[BackEndFacade::gestisciComboGeo] BEGIN");

		try {
			PersonaFisica cert = theModel.getAppDatapersonaFisica();

			ArrayList<CodeDescription> province = new ArrayList<CodeDescription>();
			ArrayList<CodeDescription> indirizzi = new ArrayList<CodeDescription>();

			province = (ArrayList<CodeDescription>) getServiziMgr().getProvinceItalia();
			theModel.setAppDataprovince(province);

			String idProvSel = cert.getIdProvinciaSelez();

			ArrayList<CodeDescription> comuni = new ArrayList<CodeDescription>();

			if (GenericUtil.isNonNullOrEmpty(idProvSel)) {
				comuni = (ArrayList<CodeDescription>) getServiziMgr().getComuniByIstatProvincia(idProvSel);
			}

			theModel.setAppDataelencoIndirizziPF(indirizzi);
			theModel.setAppDatacomuni(comuni);
		} catch (ServiceException e) {
			//throw new ManagerException(e, new Message(Messages.ERROR_SERVIZIO_NON_RAGGIUNGIBILE));
			throw new BEException("Errore in getComuni della provincia:" + e, e);

		} finally {
			log.debug("[BackEndFacade::gestisciComboGeo] END");

		}
	}

	private void caricaComboImpresa(CpAccreditamentoModel theModel) throws ServiceException, DbManagerException {

		ArrayList<CodeDescription> provinceItalia = null;

		if (theModel.getAppDataelencoSigleRea() == null || theModel.getAppDataelencoProvinceIT() == null) {
			provinceItalia = serviziMgr.getProvinceItalia();
		}
		if (theModel.getAppDataelencoSigleRea() == null) {
			theModel.setAppDataelencoSigleRea(provinceItalia);
		}

		if (theModel.getAppDataelencoProvinceIT() == null) {
			theModel.setAppDataelencoProvinceIT(provinceItalia);
		}

		if (theModel.getAppDatatipiDM() == null) {
			theModel.setAppDatatipiDM(dbMgr.getTipiDm());
		}
		if (theModel.getAppDataruoliImpresa() == null) {
			theModel.setAppDataruoliImpresa(dbMgr.getRuoliAccred());
		}

		PersonaGiuridica pg = theModel.getAppDatapersonaGiuridica();

		ArrayList<CodeDescription> indirizzi = new ArrayList<CodeDescription>();
		ArrayList<CodeDescription> comuni = new ArrayList<CodeDescription>();

		if (pg != null && !pg.getFlgIndirizzoEst()) {
			String idProvSel = pg.getIdProvinciaSelez();
			String idComuneSel = pg.getIdComuneSelez();

			log.debug("Comune selezionato: " + idComuneSel);
			if (GenericUtil.isNonNullOrEmpty(idProvSel)) {
				comuni = (ArrayList<CodeDescription>) getServiziMgr().getComuniByIstatProvincia(idProvSel);
			}

			if (GenericUtil.isNonNullOrEmpty(pg.getDescIndirizzoSel())) {
				
				// Modifica BEPPE, ottimizzazione combo vie, in caso ci sia l'ID creo una combo con solo quel valore
				CodeDescription indirizzo = new CodeDescription();
				if (GenericUtil.isNonNullOrEmpty(pg.getIdIndirizzoSel())) {
					indirizzo.setCode(pg.getIdIndirizzoSel());
				
				indirizzo.setDescription(pg.getDescIndirizzoSel());
				indirizzi.add(indirizzo);
				
				/*
				if (pg.getIdIndirizzoSel() != null) {
					log.debug("prendo indirizzi tope");
					indirizzi = getServiziMgr().getListaVieValide(pg.getIndirizzo(), idComuneSel);
				}
				*/
				}
			}
		}

		theModel.setAppDataelencoIndirizziPG(indirizzi);
		theModel.setAppDataelencoComuniPG(comuni);

	}

	/*
	private String setComboIndirizzoImpresa(CpAccreditamentoModel model) {
		String res = "OK";
		PersonaGiuridica pg = model.getAppDatapersonaGiuridica();
		if (pg != null) {
			if (pg.getIdIndirizzoSel() != null
					|| GenericUtil
							.isNonNullOrEmpty(pg.getIndirizzoNonTrovato())) {
				res = "KO";
				model.getAppDatapersonaGiuridica().setFlgEseguitaRicerca(true);
			}
		}
		return res;
	}
	 */

	/*PROTECTED REGION END*/
}
