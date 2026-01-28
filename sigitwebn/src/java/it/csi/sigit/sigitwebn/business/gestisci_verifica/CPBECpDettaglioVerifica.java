package it.csi.sigit.sigitwebn.business.gestisci_verifica;

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

/*PROTECTED REGION ID(R-986698394) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.db.DbAzioneMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDatoDistribDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAzioneDto;

/*PROTECTED REGION END*/

public class CPBECpDettaglioVerifica {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [verifica, scope:USER_SESSION]
	public static final String APPDATA_VERIFICA_CODE = "appDataverifica";

	// ApplicationData: [idVerificaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDVERIFICASELEZIONATA_CODE = "appDataidVerificaSelezionata";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoTipiVerifica, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIVERIFICA_CODE = "appDataelencoTipiVerifica";

	// ApplicationData: [elencoAzioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAZIONI_CODE = "appDataelencoAzioni";

	// ApplicationData: [idTipoAzione, scope:USER_SESSION]
	public static final String APPDATA_IDTIPOAZIONE_CODE = "appDataidTipoAzione";

	// ApplicationData: [sveglia, scope:USER_SESSION]
	public static final String APPDATA_SVEGLIA_CODE = "appDatasveglia";

	// ApplicationData: [idAzioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDAZIONESELEZIONATA_CODE = "appDataidAzioneSelezionata";

	// ApplicationData: [idAccertamentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDACCERTAMENTOSELEZIONATO_CODE = "appDataidAccertamentoSelezionato";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [Ispezione2018, scope:USER_SESSION]
	public static final String APPDATA_ISPEZIONE2018_CODE = "appDataIspezione2018";

	// ApplicationData: [azioneCodImpianto, scope:USER_SESSION]
	public static final String APPDATA_AZIONECODIMPIANTO_CODE = "appDataazioneCodImpianto";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettaglioVerifica";

	public static final String MULTIPANEL_MPGESTIONESVEGLIA = "mpGestioneSveglia";
	public static final String MPI_MPGESTIONESVEGLIA_FPGESTIONESVEGLIA = CPNAME + "_" + MULTIPANEL_MPGESTIONESVEGLIA
			+ "_" + "fpGestioneSveglia";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaDettaglioVerifica definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults salvaDettaglioVerifica(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVADETTAGLIOVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1828352692) ENABLED START*/
			try {
				//salvataggio del dato note
				getSigitMgr().salvaVerifica(theModel.getAppDataverifica(), theModel.getAppDatautenteLoggato());
				result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_CORRETTO);
				result.setResultCode(SALVADETTAGLIOVERIFICA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaDettaglioVerifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo downloadFile definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults downloadFile(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DOWNLOADFILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DOWNLOADFILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2069517967) ENABLED START*/

			//si recupera il documento in base a quanto scritto nell'idRiga
			log.debug("STAMPO LA RIGA SELEZIONATA: *" + theModel.getIdRiga() + "*");
			log.debug("STAMPO LA COLONNA SELEZIONATA: *" + theModel.getIdColonna() + "*");

			Integer idDocumento = ConvertUtil.convertToInteger(theModel.getIdRiga());
			SigitTDocAzioneDto documentoDb = getDbAzioneMgr().cercaDocAzioneById(idDocumento);

			Documento documentoInSessione = new Documento();
			documentoInSessione.setUidIndex(documentoDb.getUidIndex());
			documentoInSessione.setNomeDocOrig(documentoDb.getNomeDocOriginale());

			theModel.getSession().put(Constants.SESSIONE_VAR_DOCUMENTO_SELEZIONATO, documentoInSessione);

			// impostazione del result code 
			result.setResultCode(DOWNLOADFILE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::downloadFile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciAzione definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults inserisciAzione(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1696609506) ENABLED START*/
			theModel.setAppDataidTipoAzione(Constants.ID_TIPO_AZIONE_VERIFICA);
			theModel.setAppDataidAzioneSelezionata(null);
			result.setResultCode(INSERISCIAZIONE_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciAzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo impostaNuovaSveglia definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults impostaNuovaSveglia(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String IMPOSTANUOVASVEGLIA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1059099098) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDataidAzioneSelezionata(theModel.getAppDataidVerificaSelezionata());
			theModel.setAppDataidTipoAzione(Constants.ID_TIPO_AZIONE_VERIFICA);

			// impostazione del result code 
			result.setResultCode(IMPOSTANUOVASVEGLIA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::impostaNuovaSveglia] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo avviaAccertamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults avviaAccertamento(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AVVIAACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AVVIAACCERTAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R930056532) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDataidAccertamentoSelezionato(null);

			// impostazione del result code 
			result.setResultCode(AVVIAACCERTAMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::avviaAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaAccertamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults visualizzaAccertamento(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAACCERTAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R386046791) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDataidAccertamentoSelezionato(theModel.getAppDataverifica().getIdAccertamento());

			// impostazione del result code 
			result.setResultCode(VISUALIZZAACCERTAMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAperturaNuovaIspezione definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults preparaAperturaNuovaIspezione(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAAPERTURANUOVAISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAAPERTURANUOVAISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1860911087) ENABLED START*/
			//l'avvio dell'ispezione e' possibile solo se esiste l'impianto associato alla verifica
			//rimosso controllo! il codice impianto potra' essere associato all'ispezione in un secondo momento
			//				if (theModel.getAppDataverifica() == null
			//						|| GenericUtil.isNullOrEmpty(theModel.getAppDataverifica().getCodiceImpianto())) {
			//					throw new ValidationManagerException(new Message(Messages.ERRORE_AVVIO_ISPEZIONE_DA_VERIFICA));
			//				}

			//inizializzazione dell'ispezione a partire dalla verifica
			Ispezione2018 nuovaIspezione = new Ispezione2018();
			nuovaIspezione.setIdAccertamento(Constants.DATO_NON_DISPONIBILE_S);
			nuovaIspezione.setIdVerifica(ReplaceSpecialCharUtils.sanitize(theModel.getAppDataidVerificaSelezionata()));
			nuovaIspezione.setIdentificativoIspezione(null);
			nuovaIspezione.setCodiceImpianto(
					ReplaceSpecialCharUtils.sanitize(theModel.getAppDataverifica().getCodiceImpianto()));

			if (GenericUtil.isNotNullOrEmpty(theModel.getAppDataverifica().getCodiceImpianto())) {
				Impianto imp = getDbMgr().cercaImpiantoById(theModel.getAppDataverifica().getCodiceImpianto());
				nuovaIspezione.setCodIstatProv(GenericUtil
						.getCodIstatProvByCodIstatComune(ReplaceSpecialCharUtils.sanitize(imp.getImpLocIdComune())));

			} else if (GenericUtil.isNotNullOrEmpty(theModel.getAppDataverifica().getIdDatoDistributore())) {
				SigitTDatoDistribDto datoDistrib = getDbMgr().cercaDatoDistributore(
						ConvertUtil.convertToInteger(theModel.getAppDataverifica().getIdDatoDistributore()));

				nuovaIspezione.setLocalizzazioneDistributore("localizzazione : "
						+ getSigitMgr().getIndirizzoCompletoByIstatComuneIndirizzoCivico(datoDistrib.getIstatComune(),
								datoDistrib.getDug(), datoDistrib.getIndirizzo(), datoDistrib.getCivico()));

				nuovaIspezione.setDatoDistributoreAnnoRiferimentoDatiUtente(
						MapDto.getdatoDistributoreAnnoRiferimentoDatiUtente(datoDistrib));
			}
			nuovaIspezione.setIdDatoDistrib(
					ConvertUtil.convertToInteger(theModel.getAppDataverifica().getIdDatoDistributore()));
			nuovaIspezione.setLocalizzazioneImpianto(
					ReplaceSpecialCharUtils.sanitize(theModel.getAppDataverifica().getRisultatoImpianto()));
			nuovaIspezione.setDataCreazione(DateUtil.getDataCorrenteFormat());
			nuovaIspezione.setIdStatoIspezione(ConvertUtil.convertToString(Constants.ID_STATO_ISPEZIONE_BOZZA));
			nuovaIspezione.setDescrizioneStato(Constants.STATO_MODULO_BOZZA);

			theModel.setAppDataIspezione2018(nuovaIspezione);

			//			theModel.setAppDataProvenienzaDettaglioIspezione2018("VERIFICA");
			theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_VERIFICHE);

			result.setResultCode(PREPARAAPERTURANUOVAISPEZIONE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAperturaNuovaIspezione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAperturaDettaglioIspezione definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults preparaAperturaDettaglioIspezione(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAAPERTURADETTAGLIOISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R890054727) ENABLED START*/

			Ispezione2018 ispezioneEsistente = new Ispezione2018();
			ispezioneEsistente.setIdAccertamento(Constants.DATO_NON_DISPONIBILE_S);
			ispezioneEsistente
					.setIdVerifica(ReplaceSpecialCharUtils.sanitize(theModel.getAppDataidVerificaSelezionata()));
			ispezioneEsistente.setIdentificativoIspezione(
					ReplaceSpecialCharUtils.sanitize(theModel.getAppDataverifica().getIdIspezione()));
			ispezioneEsistente.setCodiceImpianto(
					ReplaceSpecialCharUtils.sanitize(theModel.getAppDataverifica().getCodiceImpianto()));

			if (GenericUtil.isNotNullOrEmpty(theModel.getAppDataverifica().getCodiceImpianto())) {
				Impianto imp = getDbMgr().cercaImpiantoById(theModel.getAppDataverifica().getCodiceImpianto());
				ispezioneEsistente.setCodIstatProv(GenericUtil
						.getCodIstatProvByCodIstatComune(ReplaceSpecialCharUtils.sanitize(imp.getImpLocIdComune())));
			} else if (GenericUtil.isNotNullOrEmpty(theModel.getAppDataverifica().getIdDatoDistributore())) {
				SigitTDatoDistribDto datoDistrib = getDbMgr().cercaDatoDistributore(
						ConvertUtil.convertToInteger(theModel.getAppDataverifica().getIdDatoDistributore()));

				ispezioneEsistente.setLocalizzazioneDistributore("localizzazione : "
						+ getSigitMgr().getIndirizzoCompletoByIstatComuneIndirizzoCivico(datoDistrib.getIstatComune(),
								datoDistrib.getDug(), datoDistrib.getIndirizzo(), datoDistrib.getCivico()));

				ispezioneEsistente.setDatoDistributoreAnnoRiferimentoDatiUtente(
						MapDto.getdatoDistributoreAnnoRiferimentoDatiUtente(datoDistrib));
			}
			ispezioneEsistente.setIdDatoDistrib(
					ConvertUtil.convertToInteger(theModel.getAppDataverifica().getIdDatoDistributore()));

			ispezioneEsistente.setLocalizzazioneImpianto(
					ReplaceSpecialCharUtils.sanitize(theModel.getAppDataverifica().getRisultatoImpianto()));

			theModel.setAppDataIspezione2018(ispezioneEsistente);

			//			theModel.setAppDataProvenienzaDettaglioIspezione2018("VERIFICA");
			theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_VERIFICHE);

			result.setResultCode(PREPARAAPERTURADETTAGLIOISPEZIONE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::preparaAperturaDettaglioIspezione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietro definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults gestisciIndietro(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRO_OUTCOME_CODE__RICERCA_VERIFICHE = //NOSONAR  Reason:EIAS
				"RICERCA_VERIFICHE"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__ELENCO_SVEGLIE = //NOSONAR  Reason:EIAS
				"ELENCO_SVEGLIE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1515431088) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String paginaChiamante = theModel.getAppDatapaginaChiamante();

			if (Constants.PAG_ELENCO_SVEGLIE.equals(paginaChiamante)) {
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__ELENCO_SVEGLIE);
			} else {
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__RICERCA_VERIFICHE);
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
	 * Implementazione del metodo impostaNuovaSvegliaOld definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults impostaNuovaSvegliaOld(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String IMPOSTANUOVASVEGLIAOLD_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2049388375) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDataidAzioneSelezionata(theModel.getAppDataidVerificaSelezionata());
			theModel.setAppDataidTipoAzione(Constants.ID_TIPO_AZIONE_VERIFICA);
			// impostazione del result code 
			result.setResultCode(IMPOSTANUOVASVEGLIAOLD_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::impostaNuovaSvegliaOld] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaSveglia definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults eliminaSveglia(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINASVEGLIA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ELIMINASVEGLIA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-855737689) ENABLED START*/
			//VENGONO SVUOTATI I CAMPI DATA SVEGLIA E NOTE
			try {
				Sveglia verifica = new Sveglia();
				verifica.setNoteSveglia(null);
				verifica.setDataSveglia(null);

				getSigitMgr().modificaSveglia(verifica, Constants.ID_TIPO_AZIONE_VERIFICA,
						theModel.getAppDataidVerificaSelezionata());

				// impostazione del result code 
				result.setResultCode(ELIMINASVEGLIA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
				result.setResultCode(ELIMINASVEGLIA_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaSveglia] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R875286285) ENABLED START*/
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
	 * Implementazione del metodo gestisciAbilitazione definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults gestisciAbilitazione(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R607530145) ENABLED START*/
			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			// impostazione del result code 
			// se il ruolo utente non appartiene a questo set, il form è in editing
			if (GenericUtil.checkValidRole(utente,
					Arrays.asList(Constants.RUOLO_SUPER, Constants.RUOLO_VALIDATORE, Constants.RUOLO_ISPETTORE), false,
					true)) {
				result.setResultCode(GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA);
			} else {
				result.setResultCode(GESTISCIABILITAZIONE_OUTCOME_CODE__DISABILITA);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilitazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAbilAvviaAccertamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults gestAbilAvviaAccertamento(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTABILAVVIAACCERTAMENTO_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTABILAVVIAACCERTAMENTO_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1532682135) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			// impostazione del result code 
			// se il ruolo utente non appartiene a questo set, il form è in editing
			if (GenericUtil.checkValidRole(utente, Arrays.asList(Constants.RUOLO_SUPER, Constants.RUOLO_VALIDATORE),
					false, true)) {
				result.setResultCode(GESTABILAVVIAACCERTAMENTO_OUTCOME_CODE__ABILITA);
			} else {
				result.setResultCode(GESTABILAVVIAACCERTAMENTO_OUTCOME_CODE__DISABILITA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAbilAvviaAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaDettaglioVerifica definito in un ExecCommand del
	 * ContentPanel cpDettaglioVerifica
	 */
	public ExecResults caricaDettaglioVerifica(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICADETTAGLIOVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICADETTAGLIOVERIFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-394905596) ENABLED START*/
			try {

				log.debug("##### caricaDettaglioVerifica: " + theModel.getAppDataidVerificaSelezionata());

				GenericUtil.gestisciMessaggioSessione(theModel, result);

				if (theModel.getAppDataelencoTipiVerifica() == null) {
					theModel.setAppDataelencoTipiVerifica(getSigitMgr().getElencoTipoVerifiche());
				}

				//VIENE CARICATA LA VERIFICA A PARTIRE DALL'ID
				Verifica verifica = getSigitMgr().getVerificaDaId(theModel.getAppDataidVerificaSelezionata(),
						ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoTipiVerifica()), true);
				theModel.setAppDataverifica(verifica);
				if (verifica.getCodiceImpianto() != null && !verifica.getCodiceImpianto().equals("")) {
					theModel.setAppDataazioneCodImpianto(verifica.getCodiceImpianto());
				}
				//viene ricercata la lista delle azioni collegate alla verifica
				Azione azioneFiltro = new Azione();
				azioneFiltro.setFkAzione(ConvertUtil.convertToInteger(verifica.getIdentificativo()));
				theModel.setAppDataelencoAzioni((ArrayList<Azione>) getSigitMgr()
						.cercaAzioniByFiltro(Constants.ID_TIPO_AZIONE_VERIFICA, azioneFiltro, true));
				result.setResultCode(CARICADETTAGLIOVERIFICA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaDettaglioVerifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbAzioni
	 */
	public static void resetClearStatus_widg_tbAzioni(java.util.Map session) {
		session.put("cpDettaglioVerifica_tbAzioni_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1182111368) ENABLED START*/
	private DbAzioneMgr dbAzioneMgr;

	public DbAzioneMgr getDbAzioneMgr() {
		return dbAzioneMgr;
	}

	public void setDbAzioneMgr(DbAzioneMgr dbAzioneMgr) {
		this.dbAzioneMgr = dbAzioneMgr;
	}

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

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
	/*PROTECTED REGION END*/
}
