package it.csi.sigit.sigitwebn.business.gestisci_incarico;

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

/*PROTECTED REGION ID(R-1440559361) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfPgDelegaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPgPgNominaDto;

/*PROTECTED REGION END*/

public class CPBECpGestIncarico {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [elencoCat, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCAT_CODE = "appDataelencoCat";

	// ApplicationData: [elencoIncaricatiAssociati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINCARICATIASSOCIATI_CODE = "appDataelencoIncaricatiAssociati";

	// ApplicationData: [idIncaricatoAssociatoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDINCARICATOASSOCIATOSELEZ_CODE = "appDataidIncaricatoAssociatoSelez";

	// ApplicationData: [incaricato, scope:USER_SESSION]
	public static final String APPDATA_INCARICATO_CODE = "appDataincaricato";

	// ApplicationData: [incarico, scope:USER_SESSION]
	public static final String APPDATA_INCARICO_CODE = "appDataincarico";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestIncarico";

	public static final String MULTIPANEL_MPINCARICATI = "mpIncaricati";
	public static final String MPI_MPINCARICATI_FPINCARICATI = CPNAME + "_" + MULTIPANEL_MPINCARICATI + "_"
			+ "fpIncaricati";

	public static final String MULTIPANEL_MPINSINCARICO = "mpInsIncarico";
	public static final String MPI_MPINSINCARICO_FPINSINCARICO = CPNAME + "_" + MULTIPANEL_MPINSINCARICO + "_"
			+ "fpInsIncarico";

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
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults cercaImpresa(
 
			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAIMPRESA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2108460995) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Incarico incarico = theModel.getAppDataincarico();

				if (log.isDebugEnabled())
					GenericUtil.stampa(incarico, true, 2);

				getValidationMgr().verificaManutentore(ReplaceSpecialCharUtils.sanitize(incarico.getImpCf()),
						ReplaceSpecialCharUtils.sanitize(incarico.getImpIdSiglaRea()),
						incarico.getImpNumeroRea(), ConstantsField.GESTISCI_INCARICO_IMP_CF,
						ConstantsField.GESTISCI_INCARICO_IMP_SIGLA_REA, ConstantsField.GESTISCI_INCARICO_IMP_NUM_REA);

				PersonaGiuridica installatore = getSigitMgr().cercaPersonaGiuridica(
						ReplaceSpecialCharUtils.sanitize(incarico.getImpCf()),
						ReplaceSpecialCharUtils.sanitize(incarico.getImpIdSiglaRea()), 
						incarico.getImpNumeroRea(), false);

				if (installatore != null) {
					incarico.setImpCf(ReplaceSpecialCharUtils.sanitize(installatore.getCodiceFiscale()));
					incarico.setImpIdSiglaRea(ReplaceSpecialCharUtils.sanitize(installatore.getSiglaRea()));
					incarico.setImpNumeroRea(installatore.getNumeroRea());
					incarico.setImpImpresa(ReplaceSpecialCharUtils.sanitize(installatore.getDenominazione()));
					incarico.setImpId(installatore.getIdPersonaGiuridica());

					log.debug("STAMPO L'IMPRESA TROVATA: " + incarico.getImpId());

					// Devo recuperare l'elenco dei delegati

					ArrayList<Incaricato> listDelegati = getDbMgr()
							.cercaPersonaGiuIncByIdPersGiu(installatore.getIdPersonaGiuridica());

					theModel.setAppDataelencoIncaricatiAssociati(listDelegati);

					// impostazione del result code
					result.setResultCode(CERCAIMPRESA_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add(Messages.I003);

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
	 * Implementazione del metodo gestVisBotCessa definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults gestVisBotCessa(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOTCESSA_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOTCESSA_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1567837571) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoIncaricatiAssociati() != null
					&& theModel.getAppDataelencoIncaricatiAssociati().size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSA_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSA_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBotCessa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaImpresa definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults nuovaRicercaImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1785885805) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// E' stato premuto "Nuova ricerca", pulisco l'id impresa 
			theModel.getAppDataincarico().setImpId(null);

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
	 * Implementazione del metodo gestInserisciIncarico definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults gestInserisciIncarico(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINSERISCIINCARICO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2071320458) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Incaricato incaricato = new Incaricato();

			incaricato.setDataIncaricoDal(DateUtil.getDataCorrenteFormat());

			// Carico la combo dei CTA
			theModel.setAppDataelencoCat(getSigitMgr().cercaElencoCatAttivi());

			theModel.setAppDataincaricato(incaricato);

			// impostazione del result code 

			// impostazione del result code 
			result.setResultCode(GESTINSERISCIINCARICO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestInserisciIncarico] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestCessaIncarico definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults gestCessaIncarico(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTCESSAINCARICO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTCESSAINCARICO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1125167062) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String chiaveDelegato = theModel.getAppDataidIncaricatoAssociatoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(chiaveDelegato);

				ArrayList<Incaricato> incaricatiList = theModel.getAppDataelencoIncaricatiAssociati();

				for (Incaricato incaricato : incaricatiList) {

					log.debug("STAMPO incaricato.getIdIncaricato(): " + incaricato.getIdIncaricato());
					log.debug("STAMPO chiaveIncaricato: " + chiaveDelegato);

					if (incaricato.getIdIncaricato().equalsIgnoreCase(chiaveDelegato)) {
						// Ho trovato il delegato selezionato

						if (log.isDebugEnabled())
							GenericUtil.stampa(incaricato, true, 3);

						getValidationMgr().validazioneFormaleCessaIncarico(incaricato);

						Message msg = new Message(Messages.C001);
						theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg.getText()));

					}
				}

				result.setResultCode(GESTCESSAINCARICO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestCessaIncarico] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaIncaricato definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults salvaIncaricato(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAINCARICATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAINCARICATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1829834944) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Incarico incarico = theModel.getAppDataincarico();
				Incaricato incaricato = theModel.getAppDataincaricato();

				getValidationMgr().validazioneFormaleSalvaIncarico(incarico.getImpId(), incaricato.getIdIncaricato());

				// Posso proseguire

				getDbMgr().inserisciIncarico(incarico.getImpId(), incaricato.getIdIncaricato(),
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				ArrayList<Incaricato> listDelegati = getDbMgr().cercaPersonaGiuIncByIdPersGiu(incarico.getImpId());

				theModel.setAppDataelencoIncaricatiAssociati(listDelegati);

				result.getGlobalMessages().add(Messages.INFO_INCARICO_INSERITO_CORRETTAMENTE);

				getServiziMgr().sendMailInserisciIncaricoCAT(ConvertUtil.convertToInteger(incaricato.getIdIncaricato()),
						incarico.getImpId());
				// impostazione del result code 
				result.setResultCode(SALVAINCARICATO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaIncaricato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cessaIncarico definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults cessaIncarico(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CESSAINCARICO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CESSAINCARICO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2078187081) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String chiaveDelegato = theModel.getAppDataidIncaricatoAssociatoSelez();

			try {

				getDbMgr().cessaIncarico(chiaveDelegato, theModel.getAppDatautenteLoggato().getCodiceFiscale());

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.I011, Message.INFO));

				ArrayList<Incaricato> listIncaricato = getDbMgr()
						.cercaPersonaGiuIncByIdPersGiu(theModel.getAppDataincarico().getImpId());

				theModel.setAppDataelencoIncaricatiAssociati(listIncaricato);

				SigitRPgPgNominaDto dto = MapDto.getSigitRPgPgNomina(chiaveDelegato,
						theModel.getAppDatautenteLoggato().getCodiceFiscale());
				getServiziMgr().sendMailCessaIncaricoCAT(ConvertUtil.convertToInteger(dto.getIdPersonaGiuridicaCat()),
						ConvertUtil.convertToInteger(dto.getIdPersonaGiuridicaImpresa()));
				// impostazione del result code 
				result.setResultCode(CESSAINCARICO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

				log.debug("DEVO SETTARE L'ERRORE!!!!");
				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cessaIncarico] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisBotCessaConf definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults gestVisBotCessaConf(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOTCESSACONF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOTCESSACONF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R631923007) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoIncaricatiAssociati() != null
					&& theModel.getAppDataelencoIncaricatiAssociati().size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSACONF_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSACONF_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBotCessaConf] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R431007828) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoIncaricoCat(utente)) {
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
	 * Implementazione del metodo gestLogicaImpresaEnt definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults gestLogicaImpresaEnt(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAIMPRESAENT_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAIMPRESAENT_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-871236932) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = gestLogicaImpresa(theModel, GESTLOGICAIMPRESAENT_OUTCOME_CODE__ABILITA,
					GESTLOGICAIMPRESAENT_OUTCOME_CODE__DISABILITA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaImpresaEnt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisBot definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults gestVisBot(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R119151478) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			SigitRPfPgDelegaDto pfPgDelega = null;

			// Se l'utente l'oggato e' un CAT non puo' vedere i bottoni
			if (!ConvertUtil.convertToBooleanAllways(theModel.getAppDatautenteLoggato().getRuolo().getIsCat())) {
				pfPgDelega = getDbMgr().cercaSigitRPfPgDelegaAttByIdPersonaGiuridicaCFFisica(
						theModel.getAppDataincarico().getImpId(),
						theModel.getAppDatautenteLoggato().getCodiceFiscale());
			}

			log.debug("STAMPO la pfPgDelega: " + pfPgDelega);

			if (pfPgDelega != null && pfPgDelega.getFlgDelega().equalsIgnoreCase(Constants.FLAG_ACCREDITATO_A)) {
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
	 * Implementazione del metodo gestVisBotCessaEnt definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults gestVisBotCessaEnt(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOTCESSAENT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOTCESSAENT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1372477750) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoIncaricatiAssociati() != null
					&& theModel.getAppDataelencoIncaricatiAssociati().size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSAENT_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSAENT_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBotCessaEnt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaResetVis definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults gestisciLogicaResetVis(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1555082329) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("@@@ STAMPO theModel.getAppDataincarico(): " + theModel.getAppDataincarico());

			if (theModel.getAppDataincarico() == null) {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICARESETVIS_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICARESETVIS_OUTCOME_CODE__NO);
			}

			log.debug("@@@ STAMPO il result: " + result.getResultCode());

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
	 * Implementazione del metodo gestLogicaImpresaRef definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults gestLogicaImpresaRef(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAIMPRESAREF_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAIMPRESAREF_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R512054292) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = gestLogicaImpresa(theModel, GESTLOGICAIMPRESAREF_OUTCOME_CODE__ABILITA,
					GESTLOGICAIMPRESAREF_OUTCOME_CODE__DISABILITA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaImpresaRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisBotRef definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults gestVisBotRef(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOTREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOTREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1965192881) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			SigitRPfPgDelegaDto pfPgDelega = null;

			// Se l'utente l'oggato e' un CAT non puo' vedere i bottoni
			if (!ConvertUtil.convertToBooleanAllways(theModel.getAppDatautenteLoggato().getRuolo().getIsCat())) {
				pfPgDelega = getDbMgr().cercaSigitRPfPgDelegaAttByIdPersonaGiuridicaCFFisica(
						theModel.getAppDataincarico().getImpId(),
						theModel.getAppDatautenteLoggato().getCodiceFiscale());
			}

			log.debug("STAMPO la pfPgDelega: " + pfPgDelega);

			if (pfPgDelega != null && pfPgDelega.getFlgDelega().equalsIgnoreCase(Constants.FLAG_ACCREDITATO_A)) {
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
	 * Implementazione del metodo gestVisBotCessaRef definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults gestVisBotCessaRef(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOTCESSAREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOTCESSAREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R10813474) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("@@@@ STAMPO theModel.getAppDataelencoIncaricatiAssociati(): "
					+ theModel.getAppDataelencoIncaricatiAssociati());

			if (theModel.getAppDataelencoIncaricatiAssociati() != null
					&& theModel.getAppDataelencoIncaricatiAssociati().size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSAREF_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSAREF_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBotCessaRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneMessaggio definito in un ExecCommand del
	 * ContentPanel cpGestIncarico
	 */
	public ExecResults gestioneMessaggio(

			it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEMESSAGGIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R972581097) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);

			log.debug("stampo il messaggio di errore: " + msg);

			if (msg != null && msg.isInfoMessage()) {
				result.getGlobalMessages().add(msg.getText());
				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
				log.debug("STAMPO L'INFO: " + msg.getText());
			} else if (msg != null && msg.isErrorMessage()) {
				result.getGlobalErrors().add(msg.getText());
				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
				log.debug("STAMPO L'ERRORE: " + msg.getText());
			}

			// impostazione del result code 
			result.setResultCode(GESTIONEMESSAGGIO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneMessaggio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbIncaricatiAssociati
	 */
	public static void resetClearStatus_widg_tbIncaricatiAssociati(java.util.Map session) {
		session.put("cpGestIncarico_tbIncaricatiAssociati_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-535857771) ENABLED START*/
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

	private ExecResults gestLogicaImpresa(it.csi.sigit.sigitwebn.dto.gestisci_incarico.CpGestIncaricoModel theModel,
			String codAbilita, String codDisabilita) throws DbManagerException {
		ExecResults result = new ExecResults();

		Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();

		//CodeDescription cd = null;
		if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
				|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
			// impostazione del result code 
			result.setResultCode(codAbilita);
		} else {
			// impostazione del result code 
			result.setResultCode(codDisabilita);

			Incarico incarico = new Incarico();

			incarico.setImpId(ruolo.getIdPersonaGiuridica());
			incarico.setImpIdSiglaRea(ruolo.getSiglaRea());
			incarico.setImpNumeroRea(ConvertUtil.convertToUDTPositiveInteger(ruolo.getNumeroRea()));
			incarico.setImpCf(ruolo.getCodiceFiscale());
			incarico.setImpImpresa(ruolo.getDenomDitta());

			if (log.isDebugEnabled())
				GenericUtil.stampa(incarico, true, 3);

			ArrayList<Incaricato> listIncaricati = getDbMgr().cercaPersonaGiuIncByIdPersGiu(incarico.getImpId());

			theModel.setAppDataincarico(incarico);

			theModel.setAppDataelencoIncaricatiAssociati(listIncaricati);

		}

		return result;
	}
	/*PROTECTED REGION END*/
}
