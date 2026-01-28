package it.csi.sigit.sigitwebn.business.gestisci_azioni;

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

/*PROTECTED REGION ID(R1560431310) ENABLED START*/
import java.io.File;

import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAccertamentoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTVerificaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.DocumentoAzioneDto;
/*PROTECTED REGION END*/

public class CPBECpAzione {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [azione, scope:USER_SESSION]
	public static final String APPDATA_AZIONE_CODE = "appDataazione";

	// ApplicationData: [elencoAzioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAZIONI_CODE = "appDataelencoAzioni";

	// ApplicationData: [idAzioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDAZIONESELEZIONATA_CODE = "appDataidAzioneSelezionata";

	// ApplicationData: [idTipoAzione, scope:USER_SESSION]
	public static final String APPDATA_IDTIPOAZIONE_CODE = "appDataidTipoAzione";

	// ApplicationData: [idVerificaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDVERIFICASELEZIONATA_CODE = "appDataidVerificaSelezionata";

	// ApplicationData: [idAccertamentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDACCERTAMENTOSELEZIONATO_CODE = "appDataidAccertamentoSelezionato";

	// ApplicationData: [idSanzioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDSANZIONESELEZIONATA_CODE = "appDataidSanzioneSelezionata";

	// ApplicationData: [idIspezioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDISPEZIONESELEZIONATO_CODE = "appDataidIspezioneSelezionato";

	// ApplicationData: [azioneCodImpianto, scope:USER_SESSION]
	public static final String APPDATA_AZIONECODIMPIANTO_CODE = "appDataazioneCodImpianto";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpAzione";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo uploadFile definito in un ExecCommand del
	 * ContentPanel cpAzione
	 */
	public ExecResults uploadFile(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpAzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String UPLOADFILE_OUTCOME_CODE__VERIFICA = //NOSONAR  Reason:EIAS
				"VERIFICA"; //NOSONAR  Reason:EIAS
		final String UPLOADFILE_OUTCOME_CODE__ACCERTAMENTO = //NOSONAR  Reason:EIAS
				"ACCERTAMENTO"; //NOSONAR  Reason:EIAS
		final String UPLOADFILE_OUTCOME_CODE__ISPEZIONE = //NOSONAR  Reason:EIAS
				"ISPEZIONE"; //NOSONAR  Reason:EIAS
		final String UPLOADFILE_OUTCOME_CODE__SANZIONE = //NOSONAR  Reason:EIAS
				"SANZIONE"; //NOSONAR  Reason:EIAS
		final String UPLOADFILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1917783568) ENABLED START*/
			log.debug("inizio upload file");
			try {
				if (GenericUtil.isNullOrEmpty(theModel.getAppDataazione().getDescrizione())) {
					//la descrizione e' obbligatoria
					ValidationManagerException ex = new ValidationManagerException();
					ex.addFieldRequired(APPDATA_AZIONE_CODE + ".descrizione");
					throw ex;
				} else {
					File file = theModel.getWidg_fuUpload();
					if (file != null) {
						log.debug("elaborazione file");

						String nomeFile = theModel.getWidg_fuUploadFileName();
						String contType = theModel.getWidg_fuUploadContentType();
						String mimeTypeFile = getSigitMgr().getMimeTypeFile(file);
						if (!getValidationMgr().checkMimeTypeDocumento(mimeTypeFile)) {
							throw new ValidationManagerException(new Message(Messages.S095));
						} else if (nomeFile.length() > Constants.MAX_NOME_FILE_LEN) {
							throw new ValidationManagerException(new Message(Messages.S160,
									ConvertUtil.convertToString(Constants.MAX_NOME_FILE_LEN)));

						}

						Integer maxMB = getDbMgr().cercaConfigValueNumerico(Constants.MAX_MB_DOC);
						Integer maxByte = GenericUtil.getByteToMb(maxMB);

						if (file.length() > maxByte) {
							throw new ValidationManagerException(
									new Message(Messages.S156, ConvertUtil.convertToString(maxMB)));
						}
						DocumentoAzioneDto docFilter = new DocumentoAzioneDto();
						docFilter.setContentType(ReplaceSpecialCharUtils.sanitize(contType));
						docFilter.setFile(file);
						docFilter.setNomeFile(ReplaceSpecialCharUtils.sanitize(nomeFile));

						String codImpianto = theModel.getAppDataazioneCodImpianto();
						if (codImpianto != null) {
							docFilter.setCodImpianto(codImpianto);
						}

						getSigitMgr().inserisciAzioneEDocumento(theModel.getAppDataidTipoAzione(),
								theModel.getAppDataazione(), docFilter, theModel.getAppDatautenteLoggato());

						//						result.getGlobalMessages().add("Documento importato correttamente");
						theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
								new Message(Messages.INFO_DOCUMENTO_IMPORTATO_CORRETTAMENTE, Message.INFO));

					} else {

						//						result.getGlobalMessages().add("Azione caricata correttamente");

						getSigitMgr().inserisciAzioneEDocumento(theModel.getAppDataidTipoAzione(),
								theModel.getAppDataazione(), null, theModel.getAppDatautenteLoggato());

						theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
								new Message(Messages.INFO_AZIONE_CORRETTA, Message.INFO));

					}

					// impostazione del result code 
					result.setResultCode(tornaAPaginaChiamante(theModel, UPLOADFILE_OUTCOME_CODE__VERIFICA,
							UPLOADFILE_OUTCOME_CODE__ACCERTAMENTO, UPLOADFILE_OUTCOME_CODE__ISPEZIONE,
							UPLOADFILE_OUTCOME_CODE__SANZIONE));

				}

			} catch (ManagerException ex) {

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
	 * Implementazione del metodo gestisciIndietro definito in un ExecCommand del
	 * ContentPanel cpAzione
	 */
	public ExecResults gestisciIndietro(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpAzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRO_OUTCOME_CODE__VERIFICA = //NOSONAR  Reason:EIAS
				"VERIFICA"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__ACCERTAMENTO = //NOSONAR  Reason:EIAS
				"ACCERTAMENTO"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__ISPEZIONE = //NOSONAR  Reason:EIAS
				"ISPEZIONE"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__SANZIONE = //NOSONAR  Reason:EIAS
				"SANZIONE"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R228985416) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(tornaAPaginaChiamante(theModel, GESTISCIINDIETRO_OUTCOME_CODE__VERIFICA,
					GESTISCIINDIETRO_OUTCOME_CODE__ACCERTAMENTO, GESTISCIINDIETRO_OUTCOME_CODE__ISPEZIONE,
					GESTISCIINDIETRO_OUTCOME_CODE__SANZIONE));

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
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpAzione
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpAzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-411159387) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoInserimentoAzioneSvegliaIspezioneSanzione(utenteLoggato)) {
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
	 * Implementazione del metodo preparaFormAzione definito in un ExecCommand del
	 * ContentPanel cpAzione
	 */
	public ExecResults preparaFormAzione(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpAzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAFORMAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R767158606) ENABLED START*/
			Azione azione = null;
			if (theModel.getAppDataidAzioneSelezionata() == null) {
				//si tratta di una nuova azione
				azione = new Azione();
				UtenteLoggato utente = theModel.getAppDatautenteLoggato();
				azione.setDataAzione(DateUtil.getDataCorrenteFormat());
				azione.setCfUtenteAzione(utente.getCodiceFiscale());
				azione.setDenomUtenteAzione(utente.getDenominazione());
				azione.setDescrizioneUtente(
						ConvertUtil.getStringByConcat(" ", utente.getDenominazione(), utente.getCodiceFiscale()));

				Integer fkAzione = null;
				String descAzione = null;
				int tipoAzione = theModel.getAppDataidTipoAzione();
				switch (tipoAzione) {
					case Constants.ID_TIPO_AZIONE_VERIFICA :
						fkAzione = ConvertUtil.convertToInteger(theModel.getAppDataidVerificaSelezionata());
						descAzione = "verifica";
						break;
					case Constants.ID_TIPO_AZIONE_ACCERTAMENTO :
						fkAzione = ConvertUtil.convertToInteger(theModel.getAppDataidAccertamentoSelezionato());
						descAzione = "accertamento";
						break;
					case Constants.ID_TIPO_AZIONE_ISPEZIONE :
						fkAzione = theModel.getAppDataidIspezioneSelezionato();
						descAzione = "ispezione";
						break;
					case Constants.ID_TIPO_AZIONE_SANZIONE :
						fkAzione = theModel.getAppDataidSanzioneSelezionata();
						descAzione = "sanzione";
						break;
				}
				azione.setFkAzione(fkAzione);

				azione.setDescrizioneSu("codice " + descAzione + " " + azione.getFkAzione());
			} else {
				//vengono recuperati i dati dal db
				azione = getSigitMgr().cercaAzioneById(theModel.getAppDataidAzioneSelezionata());
			}
			theModel.setAppDataazione(azione);
			result.setResultCode(PREPARAFORMAZIONE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaFormAzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-406250074) ENABLED START*/
	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
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

	private String tornaAPaginaChiamante(it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpAzioneModel theModel,
			String backVerifica, String backAccertamento, String backIspezione, String backSanzione) {
		String risultato = null;

		if (theModel.getAppDataidTipoAzione() != null) {
			switch (theModel.getAppDataidTipoAzione()) {
				case Constants.ID_TIPO_AZIONE_VERIFICA :
					risultato = backVerifica;
					break;
				case Constants.ID_TIPO_AZIONE_ACCERTAMENTO :
					risultato = backAccertamento;
					break;
				case Constants.ID_TIPO_AZIONE_ISPEZIONE :
					risultato = backIspezione;
					break;
				case Constants.ID_TIPO_AZIONE_SANZIONE :
					risultato = backSanzione;
					break;
			}
		}

		return risultato;

	}

	/*PROTECTED REGION END*/
}
