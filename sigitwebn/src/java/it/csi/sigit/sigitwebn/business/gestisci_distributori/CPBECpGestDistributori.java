package it.csi.sigit.sigitwebn.business.gestisci_distributori;

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

/*PROTECTED REGION ID(R-125881789) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDatoDistribDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImportDistribDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportDistribFilter;

import java.io.File;

/*PROTECTED REGION END*/

public class CPBECpGestDistributori {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [dettaglioImportDistributori, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOIMPORTDISTRIBUTORI_CODE = "appDatadettaglioImportDistributori";

	// ApplicationData: [distributori, scope:USER_SESSION]
	public static final String APPDATA_DISTRIBUTORI_CODE = "appDatadistributori";

	// ApplicationData: [elencoErroriImport, scope:USER_SESSION]
	public static final String APPDATA_ELENCOERRORIIMPORT_CODE = "appDataelencoErroriImport";

	// ApplicationData: [elencoImportDistributori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOIMPORTDISTRIBUTORI_CODE = "appDataelencoImportDistributori";

	// ApplicationData: [idFileInviatoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDFILEINVIATOSELEZ_CODE = "appDataidFileInviatoSelez";

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [distributoreManuale, scope:USER_SESSION]
	public static final String APPDATA_DISTRIBUTOREMANUALE_CODE = "appDatadistributoreManuale";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestDistributori";

	public static final String MULTIPANEL_MPINVIATI = "mpInviati";
	public static final String MPI_MPINVIATI_FPINVIATI = CPNAME + "_" + MULTIPANEL_MPINVIATI + "_" + "fpInviati";

	public static final String MULTIPANEL_MPIMPORT = "mpImport";
	public static final String MPI_MPIMPORT_FPIMPORT = CPNAME + "_" + MULTIPANEL_MPIMPORT + "_" + "fpImport";

	public static final String MULTIPANEL_MPDETTAGLIO = "mpDettaglio";
	public static final String MPI_MPDETTAGLIO_FPDETTAGLIO = CPNAME + "_" + MULTIPANEL_MPDETTAGLIO + "_"
			+ "fpDettaglio";

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
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults cercaImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAIMPRESA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1600447879) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Distributore distributore = theModel.getAppDatadistributori();

				if (log.isDebugEnabled())
					GenericUtil.stampa(distributore, true, 2);

				getValidationMgr().verificaManutentore(distributore.getDistrCf(), distributore.getDistrIdSiglaRea(),
						distributore.getDistrNumeroRea(), ConstantsField.GESTISCI_DISTRIBUTORI_CF,
						ConstantsField.GESTISCI_DISTRIBUTORI_SIGLA_REA, ConstantsField.GESTISCI_DISTRIBUTORI_NUM_REA);

				PersonaGiuridica distributorePg = getSigitMgr().cercaPersonaGiuridica(distributore.getDistrCf(),
						distributore.getDistrIdSiglaRea(), distributore.getDistrNumeroRea(), false);

				if (distributorePg != null && distributorePg.getFlgDistributore()) {

					distributore.setDistrCf(ReplaceSpecialCharUtils.sanitize(distributorePg.getCodiceFiscale()));
					distributore.setDistrIdSiglaRea(ReplaceSpecialCharUtils.sanitize(distributorePg.getSiglaRea()));
					distributore.setDistrNumeroRea(distributorePg.getNumeroRea());
					distributore.setDistrImpresa(ReplaceSpecialCharUtils.sanitize(distributorePg.getDenominazione()));
					distributore.setDistrId(distributorePg.getIdPersonaGiuridica());

					distributore.setDistrEmail(ReplaceSpecialCharUtils.sanitize(distributorePg.getEmail()));

					log.debug("STAMPO IL DISTRIBUTORE TROVATO: " + distributore.getDistrId());

					// Devo recuperare l'elenco dei delegati

					ArrayList<DettaglioImportDistributori> listImport = getDbMgr()
							.cercaElencoImportByIdDistr(distributorePg.getIdPersonaGiuridica());

					theModel.setAppDataelencoImportDistributori(listImport);

					// impostazione del result code
					result.setResultCode(CERCAIMPRESA_OUTCOME_CODE__OK);

				} else if (distributorePg == null) {
					result.getGlobalErrors().add(Messages.I003);
					// impostazione del result code
					result.setResultCode(CERCAIMPRESA_OUTCOME_CODE__KO);
				} else {
					// E' stata trovata la ditta manon e' un distributore
					result.getGlobalErrors().add(Messages.S127);

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
	 * Implementazione del metodo gestVisBot definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults gestVisBot(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOT_OUTCOME_CODE__VISUALIZZA_CONSULTATORE = //NOSONAR  Reason:EIAS
				"VISUALIZZA_CONSULTATORE"; //NOSONAR  Reason:EIAS
		final String GESTVISBOT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1786717362) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			return gestAbilVisBotEntRef(theModel, GESTVISBOT_OUTCOME_CODE__VISUALIZZA,
					GESTVISBOT_OUTCOME_CODE__VISUALIZZA_CONSULTATORE, GESTVISBOT_OUTCOME_CODE__NASCONDI, result);

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBot] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaImpresa definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults nuovaRicercaImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R167323095) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// E' stato premuto "Nuova ricerca", pulisco l'id distributore 
			theModel.getAppDatadistributori().setDistrId(null);
			theModel.getAppDatadistributori().setDistrImpresa(null);

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
	 * Implementazione del metodo importaDistributori definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults importaDistributori(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String IMPORTADISTRIBUTORI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String IMPORTADISTRIBUTORI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-529471006) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Distributore distributore = theModel.getAppDatadistributori();
			distributore.setIdImportSostituzione(null);

			// impostazione del result code 
			result.setResultCode(IMPORTADISTRIBUTORI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::importaDistributori] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo sostituisciDistributori definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults sostituisciDistributori(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SOSTITUISCIDISTRIBUTORI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SOSTITUISCIDISTRIBUTORI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R366705921) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idImportSelezionato = theModel.getAppDataidFileInviatoSelez();
				log.debug(" DISTRIBUTORI ----> SOSTITUISCI IMPORT ------------> idImportSelezionato: "
						+ idImportSelezionato);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(idImportSelezionato);
				//se non è stato elaborato nell'ultimo anno viene lanciata un'eccezione
				ArrayList<DettaglioImportDistributori> listImport = theModel.getAppDataelencoImportDistributori();
				getValidationMgr().checkElaboratoUltimoAnno(idImportSelezionato, listImport,
						Messages.ERROR_SOSTITUZIONE_DATI_DISTRIBUTORE);
				Distributore distributore = theModel.getAppDatadistributori();
				distributore.setIdImportSostituzione(idImportSelezionato);

				// impostazione del result code 
				result.setResultCode(SOSTITUISCIDISTRIBUTORI_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::sostituisciDistributori] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo dettaglioImport definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults dettaglioImport(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DETTAGLIOIMPORT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DETTAGLIOIMPORT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R65186288) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idImportSelezionato = theModel.getAppDataidFileInviatoSelez();
				log.debug(
						" DISTRIBUTORI ----> ANNULLA IMPORT ------------> idImportSelezionato: " + idImportSelezionato);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(idImportSelezionato);

				ArrayList<DettaglioImportDistributori> listImport = theModel.getAppDataelencoImportDistributori();

				DettaglioImportDistributori dettaglioImport = null;

				for (DettaglioImportDistributori dettaglioImportTemp : listImport) {

					if (dettaglioImportTemp.getIdFileInviato().intValue() == idImportSelezionato.intValue()) {
						// Ho trovato il dettaglio
						dettaglioImport = dettaglioImportTemp;
					}
				}

				if (dettaglioImport != null) {
					theModel.setAppDatadettaglioImportDistributori(dettaglioImport);

					ArrayList<DettaglioErrore> listErrori = getSigitMgr()
							.cercaErroriImportDistributore(idImportSelezionato);

					theModel.setAppDataelencoErroriImport(listErrori);

					// impostazione del result code 
					result.setResultCode(DETTAGLIOIMPORT_OUTCOME_CODE__OK);
				} else {
					// Non dovrebbe mai succedere

					// impostazione del result code 
					result.setResultCode(DETTAGLIOIMPORT_OUTCOME_CODE__KO);
				}

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::dettaglioImport] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaImport definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults annullaImport(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLAIMPORT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLAIMPORT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1894299790) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idImportSelezionato = theModel.getAppDataidFileInviatoSelez();
				log.debug(
						" DISTRIBUTORI ----> ANNULLA IMPORT ------------> idImportSelezionato: " + idImportSelezionato);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(idImportSelezionato);
				//se non è stato elaborato nell'ultimo anno viene lanciata un'eccezione
				ArrayList<DettaglioImportDistributori> listImportTemp = theModel.getAppDataelencoImportDistributori();
				getValidationMgr().checkElaboratoUltimoAnno(idImportSelezionato, listImportTemp,
						Messages.ERROR_ANNULLAMENTO_DATI_DISTRIBUTORE);
				getSigitMgr().annullaImportDistributore(idImportSelezionato,
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				result.getGlobalMessages().add(Messages.INFO_ELIMINAZIONE_CORRETTA);

				Distributore distributore = theModel.getAppDatadistributori();

				ArrayList<DettaglioImportDistributori> listImport = getDbMgr()
						.cercaElencoImportByIdDistr(distributore.getDistrId());

				theModel.setAppDataelencoImportDistributori(listImport);

				// impostazione del result code 
				result.setResultCode(ANNULLAIMPORT_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaImport] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricevutaImport definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults ricevutaImport(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICEVUTAIMPORT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICEVUTAIMPORT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R375477646) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idImportSelezionato = theModel.getAppDataidFileInviatoSelez();
				log.debug(" DISTRIBUTORI ----> RICEVUTA IMPORT ------------> idImportSelezionato: "
						+ idImportSelezionato);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(idImportSelezionato);

				//rimetto in sessione l'idImportSelezionato per la action ShowRicevutaImportDistributore che chiama Modol
				theModel.getSession().put(Constants.SESSIONE_VAR_ID_IMPORT_DISTRIB, idImportSelezionato);

				// impostazione del result code 
				result.setResultCode(RICEVUTAIMPORT_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricevutaImport] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserimentoManuale definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults inserimentoManuale(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERIMENTOMANUALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERIMENTOMANUALE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1338937756) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDatadistributoreManuale(null);
			// impostazione del result code 
			result.setResultCode(INSERIMENTOMANUALE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserimentoManuale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo dettaglioCaricamentoManuale definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults dettaglioCaricamentoManuale(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DETTAGLIOCARICAMENTOMANUALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DETTAGLIOCARICAMENTOMANUALE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1843088020) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idFileInviatoSelez = theModel.getAppDataidFileInviatoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idFileInviatoSelez);

				SigitTImportDistribDto importDistrib = getDbMgr().cercaImportDistributore(idFileInviatoSelez);

				if (importDistrib.getFkStatoDistrib() != Constants.ID_STATO_IMP_DISTRIBUTORE_INVIATO) {
					throw new ValidationManagerException(new Message(Messages.ERROR_STATO_IMPORT_DISTRIBUTORE));
				}

				List<SigitTDatoDistribDto> distributori = getDbMgr()
						.cercaDatiDistributoreByIdImportDistributore(idFileInviatoSelez);

				if (distributori.size() > 1) {
					throw new ValidationManagerException(
							new Message(Messages.ERROR_PIU_DATI_ASS_DETT_CARICA_MANUALE_DISTRIBUTORE));
				}

				theModel.setAppDatadistributoreManuale(
						getSigitMgr().getDistributoreManFromSigitTDatoDistrib(distributori.get(0)));

				// impostazione del result code 
				result.setResultCode(DETTAGLIOCARICAMENTOMANUALE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::dettaglioCaricamentoManuale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo avviaImport definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults avviaImport(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AVVIAIMPORT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AVVIAIMPORT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1441732098) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Distributore distributore = theModel.getAppDatadistributori();

			log.debug("inizio import xml");
			List<File> fileList = theModel.getWidg_fuImport();
			if (fileList == null || fileList.isEmpty()) {
				result.getGlobalErrors().add("Selezionare almeno un file");
			} else {

				// BEPPE
				/*
				SigitTPreImportDto dtoPreImport = getSigitMgr()
						.inserisciPreImport(theModel.getAppDatautenteLoggato());
				
				 */

				log.debug("elaborazione file");
				int elaboratiConSuccesso = 0;
				String erroriFile = "";
				int totalFiles = fileList.size();
				log.debug("Numero file arrivati: " + totalFiles);

				List<String> nomiFile = theModel.getWidg_fuImportFileName();

				List<String> contTypes = theModel.getWidg_fuImportContentType();

				for (String cType : contTypes) {
					log.debug(cType);
				}

				int i = 0;
				String msg = "";
				for (File file : fileList) {

					String contType = contTypes.get(i);

					String nomeFile = nomiFile.get(i++);

					try {

						ImportDistribFilter dataFile = getValidationMgr().validazioneXmlImportDistributore(file,
								nomeFile);

						dataFile.setContentType(ReplaceSpecialCharUtils.sanitize(contType));
						dataFile.setIdPersonaGiuridica(distributore.getDistrId());

						if (GenericUtil.isNotNullOrEmpty(distributore.getIdImportSostituzione())) {
							dataFile.setIdImportSostituzione(distributore.getIdImportSostituzione());
						}

						msg += Messages.I012.replaceFirst("##value##", nomeFile) + "<br/>";

						getSigitMgr().inserisciDistributore(dataFile,
								theModel.getAppDatautenteLoggato().getCodiceFiscale());

						elaboratiConSuccesso++;

					} catch (ValidationManagerException vme) {
						erroriFile += vme.getMsg().getText() + "<br/>\n";
						log.error("Errore con il file " + nomeFile, vme);
					} catch (ManagerException me) {
						erroriFile += file.getName() + " : " + me.getMsg().getText() + "<br/>\n";
						log.error("Errore con il file " + nomeFile, me);
					}

				}
				if (elaboratiConSuccesso > 0) {
					msg += "Sono stati elaborati con successo " + elaboratiConSuccesso + " file.";

					msg += "\n<br/> Per i distributori schedulati nella notte, le notifiche verranno inviate alla mail del distributore: ";

					msg += GenericUtil.isNotNullOrEmpty(distributore.getDistrEmail())
							? distributore.getDistrEmail()
							: "nessuna mail impostata";
					result.getGlobalMessages().add(msg);

					ArrayList<DettaglioImportDistributori> listImport = getDbMgr()
							.cercaElencoImportByIdDistr(distributore.getDistrId());

					theModel.setAppDataelencoImportDistributori(listImport);

				} else
					result.getGlobalErrors().add("Nessun file e' stato elaborato con successo.");
				if (org.apache.commons.lang.StringUtils.isNotEmpty(erroriFile)) {
					result.getGlobalErrors().add(erroriFile);
				}

				// BEPPE
				/*
				//salvataggio pre_import
				dtoPreImport.setNFile(totalFiles);
				dtoPreImport.setMsg(erroriFile);
				getDbMgr().aggiornaPreImport(dtoPreImport);
				 */
			}
			result.setResultCode(AVVIAIMPORT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::avviaImport] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R459330704) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoDatiDistributore(utente)) {
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
	 * Implementazione del metodo gestVisAbilImportEnt definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults gestVisAbilImportEnt(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISABILIMPORTENT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISABILIMPORTENT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R653992119) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			return gestVisAbilImport(theModel, GESTVISABILIMPORTENT_OUTCOME_CODE__VISUALIZZA,
					GESTVISABILIMPORTENT_OUTCOME_CODE__NASCONDI, result);
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisAbilImportEnt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaImpresaEnt definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults gestLogicaImpresaEnt(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAIMPRESAENT_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAIMPRESAENT_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-451303176) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			GenericUtil.gestisciMessaggioSessione(theModel, result);

			result = gestLogicaDistributore(theModel, GESTLOGICAIMPRESAENT_OUTCOME_CODE__ABILITA,
					GESTLOGICAIMPRESAENT_OUTCOME_CODE__DISABILITA, result);

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
	 * Implementazione del metodo gestAbilVisBot definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults gestAbilVisBot(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTABILVISBOT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTABILVISBOT_OUTCOME_CODE__VISUALIZZA_CONSULTATORE = //NOSONAR  Reason:EIAS
				"VISUALIZZA_CONSULTATORE"; //NOSONAR  Reason:EIAS
		final String GESTABILVISBOT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1056153970) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			return gestAbilVisBotEntRef(theModel, GESTABILVISBOT_OUTCOME_CODE__VISUALIZZA,
					GESTABILVISBOT_OUTCOME_CODE__VISUALIZZA_CONSULTATORE, GESTABILVISBOT_OUTCOME_CODE__NASCONDI,
					result);

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAbilVisBot] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaResetVis definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults gestisciLogicaResetVis(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1384496021) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDatadistributori() == null) {
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
	 * Implementazione del metodo gestVisAbilImportRef definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults gestVisAbilImportRef(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISABILIMPORTREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISABILIMPORTREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2037283343) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			return gestVisAbilImport(theModel, GESTVISABILIMPORTREF_OUTCOME_CODE__VISUALIZZA,
					GESTVISABILIMPORTREF_OUTCOME_CODE__NASCONDI, result);

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisAbilImportRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaImpresaEntRef definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults gestLogicaImpresaEntRef(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAIMPRESAENTREF_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAIMPRESAENTREF_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1194199923) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = gestLogicaDistributore(theModel, GESTLOGICAIMPRESAENTREF_OUTCOME_CODE__ABILITA,
					GESTLOGICAIMPRESAENTREF_OUTCOME_CODE__DISABILITA, result);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaImpresaEntRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAbilVisBotRef definito in un ExecCommand del
	 * ContentPanel cpGestDistributori
	 */
	public ExecResults gestAbilVisBotRef(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTABILVISBOTREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTABILVISBOTREF_OUTCOME_CODE__VISUALIZZA_CONSULTATORE = //NOSONAR  Reason:EIAS
				"VISUALIZZA_CONSULTATORE"; //NOSONAR  Reason:EIAS
		final String GESTABILVISBOTREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1378570039) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			return gestAbilVisBotEntRef(theModel, GESTABILVISBOTREF_OUTCOME_CODE__VISUALIZZA,
					GESTABILVISBOTREF_OUTCOME_CODE__VISUALIZZA_CONSULTATORE, GESTABILVISBOTREF_OUTCOME_CODE__NASCONDI,
					result);
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAbilVisBotRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbDatiInviati
	 */
	public static void resetClearStatus_widg_tbDatiInviati(java.util.Map session) {
		session.put("cpGestDistributori_tbDatiInviati_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbElencoErrori
	 */
	public static void resetClearStatus_widg_tbElencoErrori(java.util.Map session) {
		session.put("cpGestDistributori_tbElencoErrori_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-2030233007) ENABLED START*/
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

	private ExecResults gestLogicaDistributore(
			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel, String codAbilita,
			String codDisabilita, ExecResults result) throws DbManagerException {

		Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();

		//CodeDescription cd = null;
		if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
				|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_CONSULTATORE)) {
			// impostazione del result code 
			result.setResultCode(codAbilita);
		} else {
			// impostazione del result code 
			result.setResultCode(codDisabilita);

			Distributore distributore = new Distributore();

			distributore.setDistrId(ruolo.getIdPersonaGiuridica());
			distributore.setDistrIdSiglaRea(ruolo.getSiglaRea());
			distributore.setDistrNumeroRea(ConvertUtil.convertToUDTPositiveInteger(ruolo.getNumeroRea()));
			distributore.setDistrCf(ruolo.getCodiceFiscale());
			distributore.setDistrImpresa(ruolo.getDenomDitta());

			PersonaGiuridica pg = getDbMgr().cercaPersonaGiuridicaById(ruolo.getIdPersonaGiuridica());

			distributore.setDistrEmail(pg.getEmail());

			if (log.isDebugEnabled())
				GenericUtil.stampa(distributore, true, 3);

			ArrayList<DettaglioImportDistributori> listImport = getDbMgr()
					.cercaElencoImportByIdDistr(distributore.getDistrId());

			theModel.setAppDatadistributori(distributore);

			theModel.setAppDataelencoImportDistributori(listImport);

		}

		return result;
	}

	private ExecResults gestAbilVisBotEntRef(
			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel,
			final String GESTABILVISBOT_OUTCOME_CODE__VISUALIZZA,
			final String GESTABILVISBOT_OUTCOME_CODE__VISUALIZZA_CONSULTATORE,
			final String GESTABILVISBOT_OUTCOME_CODE__NASCONDI, ExecResults result) {
		ArrayList<DettaglioImportDistributori> listImport = theModel.getAppDataelencoImportDistributori();

		if (listImport != null && listImport.size() > 0) {
			String descRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();
			// impostazione del result code 
			if (descRuolo.equals(Constants.RUOLO_CONSULTATORE)) {
				result.setResultCode(GESTABILVISBOT_OUTCOME_CODE__VISUALIZZA_CONSULTATORE);
			} else {
				result.setResultCode(GESTABILVISBOT_OUTCOME_CODE__VISUALIZZA);
			}
		} else {
			// impostazione del result code 
			result.setResultCode(GESTABILVISBOT_OUTCOME_CODE__NASCONDI);
		}

		// modifica degli attributi del model (che verranno propagati allo strato
		// di presentation). si puo' agire anche direttamente sull'attributo "session".

		result.setModel(theModel);
		return result;
	}

	private ExecResults gestVisAbilImport(
			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel theModel,
			final String GESTVISABILIMPORT_OUTCOME_CODE__VISUALIZZA,
			final String GESTVISABILIMPORT_OUTCOME_CODE__NASCONDI, ExecResults result) {
		String descRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();

		if (descRuolo.equals(Constants.RUOLO_CONSULTATORE)) {
			result.setResultCode(GESTVISABILIMPORT_OUTCOME_CODE__NASCONDI);
		} else {
			result.setResultCode(GESTVISABILIMPORT_OUTCOME_CODE__VISUALIZZA);
		}

		// modifica degli attributi del model (che verranno propagati allo strato
		// di presentation). si puo' agire anche direttamente sull'attributo "session".

		result.setModel(theModel);
		return result;
	}

	/*PROTECTED REGION END*/
}
