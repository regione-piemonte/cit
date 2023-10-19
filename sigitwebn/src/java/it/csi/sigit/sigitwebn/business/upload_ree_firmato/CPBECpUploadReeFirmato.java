package it.csi.sigit.sigitwebn.business.upload_ree_firmato;

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

/*PROTECTED REGION ID(R-107485193) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import java.math.BigDecimal;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllegatoPk;
import java.io.File;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitwebn.dto.index.Metadati;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportFileSuper;
import java.sql.Timestamp;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import org.apache.commons.lang.StringUtils;
import java.nio.file.Files;
import java.nio.file.Path;
/*PROTECTED REGION END*/

public class CPBECpUploadReeFirmato {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [dettaglioElencoAllegati, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOELENCOALLEGATI_CODE = "appDatadettaglioElencoAllegati";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [paginaChiamanteAllegati, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEALLEGATI_CODE = "appDatapaginaChiamanteAllegati";

	// ApplicationData: [aggiornaElencoAllegati, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOALLEGATI_CODE = "appDataaggiornaElencoAllegati";

	// ApplicationData: [idAllegatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOSELEZIONATO_CODE = "appDataidAllegatoSelezionato";

	// ApplicationData: [idAllegatoImpiantoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOIMPIANTOSELEZIONATO_CODE = "appDataidAllegatoImpiantoSelezionato";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpUploadReeFirmato";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo uploadReeFirmato definito in un ExecCommand del
	 * ContentPanel cpUploadReeFirmato
	 */
	public ExecResults uploadReeFirmato(

			it.csi.sigit.sigitwebn.dto.upload_ree_firmato.CpUploadReeFirmatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String UPLOADREEFIRMATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String UPLOADREEFIRMATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1403235959) ENABLED START*/
			String contetType = theModel.getWidg_fupReeFirmatoContentType();
			String filename = theModel.getWidg_fupReeFirmatoFileName();
			SigitTImpiantoDto impianto = null;
			DettaglioAllegato dettaglioAllegato = null;
			File file = theModel.getWidg_fupReeFirmato();
			File unzippedFile = null;
			boolean proceed = false;
			String newName;
			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();
			Integer idAllegatoSelez = theModel.getAppDataidAllegatoImpiantoSelezionato();
			log.debug("id allegato selez: " + idAllegatoSelez);
			dettaglioAllegato = getDbMgr().getDettaglioAllegatoById(idAllegatoSelez);
			if (dettaglioAllegato != null) {
				impianto = getDbMgr().cercaImpiantoDtoById(dettaglioAllegato.getCodiceImpianto());
				SigitTAllegatoDto allegato = getDbMgr().getSigitTAllegatoDao()
						.findByPrimaryKey(new SigitTAllegatoPk(BigDecimal.valueOf(idAllegatoSelez)));
				if (impianto != null) {
					if (contetType.equals("application/pkcs7-mime") || contetType.equals("application/x-pkcs7-mime")) {
						log.debug("--------------unzip--------------");
						unzippedFile = getSigitMgr().estraiDocumento(dettaglioAllegato, allegato, file, impianto);
					}
					log.debug("---------------------" + (contetType.equals("application/pdf") || unzippedFile != null)
							+ "-----------------");
					if (contetType.equals("application/pdf") || unzippedFile != null) {
						if (allegato != null) {
							if (unzippedFile != null) {
								proceed = getSigitMgr().leggiPdfReeFirmato(unzippedFile, allegato);
								log.debug("--------------------- proceed unzipped " + proceed + "-----------------");
							} else {
								proceed = getSigitMgr().leggiPdfReeFirmato(file, allegato);
								log.debug("--------------------- proceed normale" + proceed + "-----------------");
							}
							if (proceed) {
								if (allegato.getUidIndexFirmato() != null) {
									getServiziMgr().indexDeleteContentByUid(allegato.getUidIndexFirmato());
								}
								Metadati metadati = createMetadatiReeFirmato(dettaglioAllegato, impianto);
								ImportFileSuper doc = new ImportFileSuper();
								doc.setContentType(ReplaceSpecialCharUtils.sanitize(contetType));
								doc.setFile(file);
								doc.setNomeFile(ReplaceSpecialCharUtils.sanitize(filename));
								String dataControllo = dettaglioAllegato.getDataControllo().replace("/", "_");
								if (contetType.equals("application/pkcs7-mime")
										|| contetType.equals("application/x-pkcs7-mime")) {
									newName = "REEFIRMA_" + dettaglioAllegato.getCodiceImpianto() + "_" + dataControllo
											+ "_" + dettaglioAllegato.getIdAllegato() + ".pdf.p7m";
								} else {
									newName = "REEFIRMA_" + dettaglioAllegato.getCodiceImpianto() + "_" + dataControllo
											+ "_" + dettaglioAllegato.getIdAllegato() + ".pdf";
								}
								String uidFirmato = getServiziMgr().caricaFileIndex(doc, Constants.INDEX_FOLDER_REE,
										newName, metadati);
								if (uidFirmato != null) {
									allegato.setUidIndexFirmato(ReplaceSpecialCharUtils.sanitize(uidFirmato));
									allegato.setNomeAllegatoFirmato(ReplaceSpecialCharUtils.sanitize(newName));
									allegato.setDataUltMod(new Timestamp(new Date().getTime()));
									allegato.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utenteLoggato.getCodiceFiscale()));
									getDbMgr().aggiornaAllegato(allegato);
									result.setResultCode(UPLOADREEFIRMATO_OUTCOME_CODE__OK);
								} else {
									result.getGlobalErrors().add("Errore nel caricamento del file.");
									result.setResultCode(UPLOADREEFIRMATO_OUTCOME_CODE__KO);
								}
							} else {
								result.getGlobalErrors().add("Allegato caricato non valido per il ree selezionato.");
								result.setResultCode(UPLOADREEFIRMATO_OUTCOME_CODE__KO);
							}
						} else {
							result.getGlobalErrors().add("Allegato non trovato.");
							result.setResultCode(UPLOADREEFIRMATO_OUTCOME_CODE__KO);
						}
					} else {
						result.getGlobalErrors().add("Formato file non valido. Caricare file .PDF o .P7M");
						result.setResultCode(UPLOADREEFIRMATO_OUTCOME_CODE__KO);
					}
				} else {
					result.getGlobalErrors().add("Errore nel recupero dell' impianto associato");
					result.setResultCode(UPLOADREEFIRMATO_OUTCOME_CODE__KO);
				}
			} else {
				result.getGlobalErrors().add("Errore nel recupero dell' allegato");
				result.setResultCode(UPLOADREEFIRMATO_OUTCOME_CODE__KO);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::uploadReeFirmato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestRitornoPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpUploadReeFirmato
	 */
	public ExecResults gestRitornoPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.upload_ree_firmato.CpUploadReeFirmatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTRITORNOPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALL_IMPIANTO = //NOSONAR  Reason:EIAS
				"ELENCO_ALL_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String GESTRITORNOPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_ALLEGATI = //NOSONAR  Reason:EIAS
				"RIS_RIC_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-63869314) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTRITORNOPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALL_IMPIANTO);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestRitornoPaginaChiamante] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpUploadReeFirmato
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.upload_ree_firmato.CpUploadReeFirmatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALL_IMPIANTO = //NOSONAR  Reason:EIAS
				"ELENCO_ALL_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_ALLEGATI = //NOSONAR  Reason:EIAS
				"RIS_RIC_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R472578310) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALL_IMPIANTO);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::tornaPaginaChiamante] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R561911837) ENABLED START*/
	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

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

	private Metadati createMetadatiReeFirmato(DettaglioAllegato allegato, SigitTImpiantoDto impianto)
			throws ManagerException {
		String codiceRea = getSigitMgr().getCodiceRea(allegato.getIdPersonaGiuridica());
		Metadati metadati = new Metadati();
		metadati.setCodiceImpianto(allegato.getCodiceImpianto());
		metadati.setIdAllegato(allegato.getIdAllegato());
		metadati.setCodIstatComune(impianto.getIstatComune());
		metadati.setCodIstatProvincia(StringUtils.substring(impianto.getIstatComune(), 0, 3));
		metadati.setDataRapporto(allegato.getDataControllo());
		metadati.setIdRapporto(allegato.getIdAllegato());
		metadati.setCodiceRea(codiceRea);

		return metadati;
	}

	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
