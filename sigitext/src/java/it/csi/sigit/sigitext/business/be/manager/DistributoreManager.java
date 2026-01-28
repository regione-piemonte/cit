package it.csi.sigit.sigitext.business.be.manager;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import it.csi.csi.wrapper.UserException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ImportDistribFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribByIdPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLogDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitWrkConfigDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDatoDistribDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTImportDistribDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTLogDistribDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitWrkConfigDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.sigit.sigitext.business.util.DateUtil;
import it.csi.sigit.sigitext.business.util.InputStreamDataSource;
import it.csi.sigit.sigitext.business.util.Messages;
import it.csi.sigit.sigitext.business.util.ReplaceSpecialCharUtils;
import it.csi.sigit.sigitext.dto.sigitext.DocXml;
import it.csi.sigit.sigitext.dto.sigitext.UtenteJWT;
import it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import it.doqui.index.ecmengine.client.webservices.dto.Node;
import it.doqui.index.ecmengine.client.webservices.dto.OperationContext;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Content;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.SearchParams;
import it.doqui.index.ecmengine.mtom.dto.Attachment;
import it.doqui.index.ecmengine.mtom.dto.MtomNode;
import it.doqui.index.ecmengine.mtom.dto.MtomOperationContext;
import it.doqui.index.ecmengine.mtom.exception.MtomException;

public class DistributoreManager {
	
	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE + ".DistributoreManager==>");
	
	private DbServiceImp dbServiceImp;	
	private ServiceManager serviceManager;
	private ValidationManager validationManager;

	public DbServiceImp getDbServiceImp() {
		return dbServiceImp;
	}

	public void setDbServiceImp(DbServiceImp dbServiceImp) {
		this.dbServiceImp = dbServiceImp;
	}

	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public ValidationManager getValidationManager() {
		return validationManager;
	}

	public void setValidationManager(ValidationManager validationManager) {
		this.validationManager = validationManager;
	}

	public BigDecimal getCitCombutyMaxRighe() throws SigitWrkConfigDaoException {
		return getDbServiceImp().getSigitWrkConfigDao().findByChiaveConfig("CIT_COMBUSTY_MAX_RIGHE").get(0).getValoreConfigNum();
	}
	
	public List<SigitTImportDistribByIdPersonaGiuridicaDto> getImportDitrib(Integer idPersonaGiuridica, String anno, String mese, String tipoCaricamento, String statoFile) throws SigitTImportDistribDaoException, SigitWrkConfigDaoException {

		return getDbServiceImp().getSigitTImportDistribDao().findByIdPersonaGiuridicaAndFiltri(idPersonaGiuridica, anno, mese, tipoCaricamento, statoFile, getCitCombutyMaxRighe());
	}
	
	public List<SigitTDatoDistribDto> getDatoDistribList(SigitTDatoDistribPk sigitTDatoDistribPk) throws SigitTDatoDistribDaoException{
		
		return getDbServiceImp().getSigitTDatoDistribDao().findDatiFornitoreByIdImportDistrib(sigitTDatoDistribPk);
	
	}
	
	public SigitTDatoDistribDto getDatoDistrib(SigitTDatoDistribPk sigitTDatoDistribPk) throws SigitTDatoDistribDaoException{
		
		List<SigitTDatoDistribDto> list = getDbServiceImp().getSigitTDatoDistribDao().findDatiFornitoreByIdImportDistrib(sigitTDatoDistribPk);
		
		return list.isEmpty() ? null : list.get(0);
	
	}
	
	public List<SigitTLogDistribDto> getLogDistribList(Integer fkImportDistrib) throws SigitTLogDistribDaoException{
		
		return getDbServiceImp().getSigitTLogDistribDao().findByFkImportDistrib(fkImportDistrib);
		
	}
	
	public SigitTImportDistribDto findByPrimaryKeyByIdImportDistrib(SigitTImportDistribPk pk) throws SigitTImportDistribDaoException {
		
		return getDbServiceImp().getSigitTImportDistribDao().findByPrimaryKey(pk);
		
	}
	
	public void updateColumnsAnnullaImport(SigitTImportDistribDto sigitTImportDistrib) throws SigitTImportDistribDaoException {
		
		getDbServiceImp().getSigitTImportDistribDao().updateColumnsAnnullaImport(sigitTImportDistrib);
		
	}
	
	public SigitTImportDistribPk InsertSigitTImportDistribDto(SigitTImportDistribDto sigitTImportDistribDto) {
		
		return getDbServiceImp().getSigitTImportDistribDao().insert(sigitTImportDistribDto);
		
	}
	
	public SigitTDatoDistribPk InsertSigitTDatoDistribDto(SigitTDatoDistribDto sigitTDatoDistribDto) {
		
		return getDbServiceImp().getSigitTDatoDistribDao().insert(sigitTDatoDistribDto);
	
	}

	@Transactional
	public void uploadXmlDistributoreJWT(String userCf, Integer idPersonaGiuridica, boolean sostituzione, Integer idImportDistrib,
			DocXml docXml, String jwt) throws Exception {

		logger.debug("[DistributoreManager::uploadXmlJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(jwt, Constants.ID_FUNZ_UPLOAD_XML_DISTRIBUTORE);
			if (utenteJWT != null) {
				if (!getServiceManager().isDistributoreAttivo(utenteJWT)) {
					throw new SigitextException("Utente non autorizzato all'utilizzo del servizio");
				}
				uploadXmlDistributore(userCf, idPersonaGiuridica, sostituzione, idImportDistrib, docXml);
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}
			getServiceManager().salvaAccesso(utenteJWT, Constants.ID_FUNZ_UPLOAD_XML_DISTRIBUTORE);

		} catch (SigitextException | SigitUserNotAuthorizedException e) {
			logger.error("Errore gestito", e);
			throw e;
		} catch (Exception e) {
			logger.error("Errore non gestito", e);
			throw e;
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DistributoreManager", "uploadXmlJWT()",
					"invocazione servizio [DistributoreManager]::[uploadXmlJWT]", "(valore input omesso)");
			logger.debug("[DistributoreManager::uploadXmlJWT] - END");
		}

	}

	@Transactional
	public ImportDistribFilter preUploadXmlDistributoreJWT(String userCf, Integer idPersonaGiuridica, boolean sostituzione, Integer idImportDistrib,
			DocXml docXml, String jwt) throws Exception {

		logger.debug("[DistributoreManager::uploadXmlJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		ImportDistribFilter dataFile = null;
		try {
			
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(jwt, Constants.ID_FUNZ_UPLOAD_XML_DISTRIBUTORE);
			if (utenteJWT != null) {
				if (!getServiceManager().isDistributoreAttivo(utenteJWT)) {
					throw new SigitextException("Utente non autorizzato all'utilizzo del servizio");
				}
				dataFile = preUploadXmlDistributore(userCf, idPersonaGiuridica, sostituzione, idImportDistrib, docXml);
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}
			getServiceManager().salvaAccesso(utenteJWT, Constants.ID_FUNZ_UPLOAD_XML_DISTRIBUTORE);

		} catch (SigitextException | SigitUserNotAuthorizedException e) {
			logger.error("Errore gestito", e);
			throw e;
		} catch (Exception e) {
			logger.error("Errore non gestito", e);
			throw e;
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DistributoreManager", "uploadXmlJWT()",
					"invocazione servizio [DistributoreManager]::[uploadXmlJWT]", "(valore input omesso)");
			logger.debug("[DistributoreManager::uploadXmlJWT] - END");
		}
		
		return dataFile;
	}

	public void postUploadXmlDistributoreJWT(Integer idImport, String uidIndex) throws SigitextException {

		logger.debug("[DistributoreManager::uploadXmlJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		ImportDistribFilter dataFile = null;
		try {
			
			postUploadXmlDistributore(idImport, uidIndex);

		} catch (SigitextException e) {
			logger.error("Errore gestito", e);
			throw e;
		} catch (Exception e) {
			logger.error("Errore non gestito", e);
			throw e;
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DistributoreManager", "uploadXmlJWT()",
					"invocazione servizio [DistributoreManager]::[uploadXmlJWT]", "(valore input omesso)");
			logger.debug("[DistributoreManager::uploadXmlJWT] - END");
		}

	}

	public void uploadXmlDistributoreJWT(String nomeFile, byte[] xml, String tokenJWT) throws Exception {

		logger.debug("[DistributoreManager::uploadXmlJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, Constants.ID_FUNZ_UPLOAD_XML_DISTRIBUTORE);
			if (utenteJWT != null) {
				if (!getServiceManager().isDistributoreAttivo(utenteJWT)) {
					throw new SigitextException("Utente non autorizzato all'utilizzo del servizio");
				}
				
				Integer idPersonaGiuridica = ConvertUtil.convertToInteger(utenteJWT.getIdPersonaGiuridica());
				SigitTPersonaGiuridicaDto personaGiuridica = getDbServiceImp().cercaPersonaGiuridicaById(ConvertUtil.convertToBigDecimal(utenteJWT.getIdPersonaGiuridica()));
				String userCf = utenteJWT.getCodiceFiscalePersonaFisica() != null ? utenteJWT.getCodiceFiscalePersonaFisica() : personaGiuridica.getCodiceFiscale();

				DocXml docXml = new DocXml();
				docXml.setNome_file(nomeFile);
				docXml.setFile(xml);
				logger.info("[DistributoreManager::uploadXmlJWT] - Stampo userCf: "+userCf);

				
				uploadXmlDistributore(userCf, idPersonaGiuridica, false, null, docXml);
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}
			getServiceManager().salvaAccesso(utenteJWT, Constants.ID_FUNZ_UPLOAD_XML_DISTRIBUTORE);

		} catch (SigitextException | SigitUserNotAuthorizedException e) {
			logger.error("Errore gestito", e);
			throw e;
		} catch (Exception e) {
			logger.error("Errore non gestito", e);
			throw e;
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DistributoreManager", "uploadXmlJWT()",
					"invocazione servizio [DistributoreManager]::[uploadXmlJWT]", "(valore input omesso)");
			logger.debug("[DistributoreManager::uploadXmlJWT] - END");
		}
	}

	private void uploadXmlDistributore(String userCf, Integer idPersonaGiuridica, boolean sostituzione, Integer idImportDistrib, DocXml docXml) 
			throws SigitextException {
		
		// Controllo nome file
		BigDecimal annoNomeFile = checkNomeFile(docXml);
		
		// Controllo dimensione file
		checkDimensioneFileDistrib(docXml.getFile());
			
		// Validazione XML
		//getValidationManager().validazioneXmlImportDistributore(docXml);
			
		// controllo caricamenti precedenti
		SigitTImportDistribPk pk = checkDocXmlDistributoreCaricato(idPersonaGiuridica, docXml);
		if (!sostituzione && pk != null) {
			logger.error("DistributoreManager::uploadXmlDistributore - Import gia' presente");
			throw new SigitextException("E' gia' presente a sistema un file con il medesimo nome, per il soggetto di interesse, in stato 'Inviato'. Rinominare il file e procedere al caricamento.");
		}

		// Inserimento record 
		Timestamp sysdate = new Timestamp(System.currentTimeMillis());
		SigitTImportDistribDto dto = new SigitTImportDistribDto();
		dto.setFkPersonaGiuridica(new BigDecimal(idPersonaGiuridica));
		dto.setFkStatoDistrib(1);
		dto.setDataInizioElab(sysdate);
		dto.setNomeFileImport(docXml.getNome_file());
		dto.setAnnoRiferimento(annoNomeFile);
		dto.setDataUltMod(sysdate);
		dto.setUtenteUltMod(userCf);
		dto.setUtenteCaricamento(userCf);
		
		SigitTImportDistribPk pkNew = getDbServiceImp().getSigitTImportDistribDao().insert(dto);
		
		// Inserimento file in index
		ImportDistribFilter dataFile = new ImportDistribFilter();
		dataFile.setAnnoRiferimento(annoNomeFile.intValue());
		dataFile.setNomeFile(docXml.getNome_file());
		dataFile.setDataInizio(DateUtil.getSqlDataCorrente());
		dataFile.setFile(docXml.getFile());
		
		dataFile.setContentType("application/xml");
		dataFile.setIdPersonaGiuridica(idPersonaGiuridica);
		if (sostituzione)
			dataFile.setIdImportSostituzione(idImportDistrib);
		
    	dataFile.setIdImport(pkNew.getIdImportDistrib());
    	dataFile.setNomeFileMod(pkNew.getIdImportDistrib() + Constants.INTERVAL_SEP_CHIAVI
    			+ ReplaceSpecialCharUtils.sanitize(dataFile.getNomeFile()));

    	String uidIndex = indexUploadDistributoreFile(dataFile.getNomeFileMod(), new byte[0]);
    	
		logger.info("[DistributoreManager::uploadXmlJWT] - Stampo uidIndex: "+uidIndex);
    	
    	dataFile.setUidIndex(uidIndex);
    	
    	uploadMtom(dataFile);
		
//		String fileNameIndex = pkNew.getIdImportDistrib().toString() + "_" + docXml.getNome_file();
//		Metadati metadati = new Metadati();
//		String cartella = Constants.INDEX_FOLDER_DISTRIBUTORI + "/" + annoNomeFile;
//		String uidIndex = getServiceManager().indexUploadFileNew(fileNameIndex, docXml.getFile(), metadati, cartella, true);
		
		// aggiornamento uidIndex 
		aggiornaUidIndexImportDistributore(pkNew, uidIndex);
		
		if (sostituzione) {
			if (idImportDistrib == null) {
                logger.error("DistributoreManager::uploadXmlDistributore - Import da sostituire assente.");
                throw new SigitextException("Attenzione. identificativo importa da sostituire assente.");				
			}
			SigitTImportDistribPk pkSostituito = new SigitTImportDistribPk(idImportDistrib);
			aggiornaImportDistributoreSostituito(idPersonaGiuridica, pkSostituito);
		}
		
	}

	private ImportDistribFilter preUploadXmlDistributore(String userCf, Integer idPersonaGiuridica, boolean sostituzione, Integer idImportDistrib, DocXml docXml) 
			throws SigitextException {
		
		// Controllo nome file
		BigDecimal annoNomeFile = checkNomeFile(docXml);
		
		// Controllo dimensione file
		//checkDimensioneFileDistrib(docXml.getFile());
			
		// Validazione XML
		//getValidationManager().validazioneXmlImportDistributore(docXml);
			
		// controllo caricamenti precedenti
		SigitTImportDistribPk pk = checkDocXmlDistributoreCaricato(idPersonaGiuridica, docXml);
		if (!sostituzione && pk != null) {
			logger.error("DistributoreManager::uploadXmlDistributore - Import gia' presente");
			throw new SigitextException("E' gia' presente a sistema un file con il medesimo nome, per il soggetto di interesse, in stato 'Inviato'. Rinominare il file e procedere al caricamento.");
		}

		// Inserimento record 
		Timestamp sysdate = new Timestamp(System.currentTimeMillis());
		SigitTImportDistribDto dto = new SigitTImportDistribDto();
		dto.setFkPersonaGiuridica(new BigDecimal(idPersonaGiuridica));
		dto.setFkStatoDistrib(1);
		dto.setDataInizioElab(sysdate);
		dto.setNomeFileImport(docXml.getNome_file());
		dto.setAnnoRiferimento(annoNomeFile);
		dto.setDataUltMod(sysdate);
		dto.setUtenteUltMod(userCf);
		dto.setUtenteCaricamento(userCf);
		
		SigitTImportDistribPk pkNew = getDbServiceImp().getSigitTImportDistribDao().insert(dto);
		
		// Inserimento file in index
		ImportDistribFilter dataFile = new ImportDistribFilter();
		dataFile.setAnnoRiferimento(annoNomeFile.intValue());
		dataFile.setNomeFile(docXml.getNome_file());
		dataFile.setDataInizio(DateUtil.getSqlDataCorrente());
		dataFile.setFile(docXml.getFile());
		
		dataFile.setContentType("application/xml");
		dataFile.setIdPersonaGiuridica(idPersonaGiuridica);
		if (sostituzione)
			dataFile.setIdImportSostituzione(idImportDistrib);
		
    	dataFile.setIdImport(pkNew.getIdImportDistrib());
    	dataFile.setNomeFileMod(pkNew.getIdImportDistrib() + Constants.INTERVAL_SEP_CHIAVI
    			+ ReplaceSpecialCharUtils.sanitize(dataFile.getNomeFile()));

    	String uidIndex = indexUploadDistributoreFile(dataFile.getNomeFileMod(), new byte[0]);
    	
		logger.info("[DistributoreManager::uploadXmlJWT] - Stampo uidIndex: "+uidIndex);
    	
    	dataFile.setUidIndex(uidIndex);
    	
    	return dataFile;
    	
	}

	private void postUploadXmlDistributore(Integer idImport, String uidIndex) throws SigitextException {

		// aggiornamento uidIndex 
		aggiornaUidIndexImportDistributore(new SigitTImportDistribPk(idImport), uidIndex);
		
//		if (sostituzione) {
//			if (idImportDistrib == null) {
//                logger.error("DistributoreManager::uploadXmlDistributore - Import da sostituire assente.");
//                throw new SigitextException("Attenzione. identificativo importa da sostituire assente.");				
//			}
//			SigitTImportDistribPk pkSostituito = new SigitTImportDistribPk(idImportDistrib);
//			aggiornaImportDistributoreSostituito(idPersonaGiuridica, pkSostituito);
//		}
		
	}

	private void uploadMtom(ImportDistribFilter dataFile) throws SigitextException {
		logger.debug("[DistributoreManager::mtomUploadFileGeneric] BEGIN");
		ByteArrayInputStream fis = null;
		try {
			MtomOperationContext moc = getServiceManager().mtomGetOperationContext();

			MtomNode node = new MtomNode(dataFile.getUidIndex(), Constants.INDEX_PREFIX_NAME);

			fis = new ByteArrayInputStream(dataFile.getFile());
			Attachment a = new Attachment();
			a.fileName = dataFile.getNomeFileMod();
			a.fileType = dataFile.getContentType();
			a.attachmentDataHandler = new DataHandler(new InputStreamDataSource(fis, dataFile.getContentType(), dataFile.getNomeFileMod()));

			logger.debug("Prima della chiusura dell'upload ");
			node = getServiceManager().getCxf().getEcmEngineMtomDelegateImpl().directUploadMethod(a, node, moc);

			logger.debug("Prima della chiusura del fis");

			fis.close();
			logger.debug("Dopo la chiusura del fis");
		} catch (MtomException e) {
			logger.error("Errore mtomUploadFileGeneric " + e.getMessage(), e);
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO, e);

		} catch (Exception e) {
			logger.error("Errore mtomUploadFileGeneric", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO, e);

		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					logger.error("Errore mtomUploadFileGeneric " + e.getMessage(), e);
				}
			}
		}
		logger.debug("[DistributoreManager::mtomUploadFileGeneric] END");
	}

	private String indexUploadDistributoreFile(String fileName, byte[] file) throws SigitextException {
		logger.debug("[DistributoreManager::indexUploadDistributoreFile] BEGIN");
		String uidFile = null;
		Node n = null;
		Content c = null;
		OperationContext oc = null;
		String annoCorrente = ConvertUtil.convertToString(DateUtil.getAnnoCorrente());
		try{
			
			
			oc = getServiceManager().indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
			logger.debug("------- OPERATION CONTEXT --- "+oc);
			

			Node nodeAnno = getServiceManager().indexSearchFolder(getQueryLuceneSearchDistrAnno(annoCorrente), oc); 

			logger.debug("Stampo il node anno: "+nodeAnno);
			
			//c = indexGetContentDistr(fileName, file);
			//Content content = indexGetContentFolder(null);
			c = getServiceManager().indexGetContentFolder(null);
			
			if (nodeAnno == null)
			{
				Node nodeApplicativo = getServiceManager().indexSearchFolder(getQueryLuceneSearchApplicativoDistr(), oc); 

				
				logger.debug("creo il node anno!!!!!!!!!!");
				nodeAnno = getServiceManager().indexCreateFolder(annoCorrente, c, nodeApplicativo, oc);
				
				logger.debug("Stampo il node anno appena creato: "+nodeAnno);

			}

			c = indexGetContentDistr(fileName, file);
			// Il file non esiste, faccio l'insert
			Node fileUpload = getServiceManager().getServiceIndex().getEcmengineDelegate().createContent(nodeAnno, c, oc);
			
			logger.debug("------- NODO TROVATO --- "+fileUpload);
			
			if (fileUpload != null)
			{
				uidFile = fileUpload.getUid();
				logger.debug("UID - PADRE DEI DISTRIBUTORI: "+uidFile);
			}
			
		}
		catch (Exception e) {
			
			logger.error("Errore index: ",e);
			
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO, e);
			
		}
		
		logger.debug("[DistributoreManager::indexUploadDistributoreFile] END");
		return uidFile;
	}

	private SearchParams getQueryLuceneSearchDistrAnno(String anno)	{
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);
		
		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT_DISTRIBUTORI);
		luceneQuery.append("/*");
		luceneQuery.append("\"");
		luceneQuery.append(" AND ");
		luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
		luceneQuery.append("name:\"");
		luceneQuery.append(anno+"\"");
		
		logger.debug("getQueryLuceneSearchDistrAnno: "+luceneQuery.toString());
		
		searchParams.setLuceneQuery(luceneQuery.toString());
		
		return searchParams;
	}

	private SearchParams getQueryLuceneSearchApplicativoDistr()	{
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);
		
		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT);
		luceneQuery.append("/*");
		luceneQuery.append("\"");
		luceneQuery.append(" AND ");
		luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
		luceneQuery.append("name:\"");
		luceneQuery.append(Constants.INDEX_FRUITORE_DISTRIBUTORE + "\"");
		
		logger.debug("getQueryLuceneSearchApplicativoDistr: "+luceneQuery.toString());
		
		searchParams.setLuceneQuery(luceneQuery.toString());
		
		return searchParams;
	}
	
	private Content indexGetContentDistr(String fileName, byte[] file) throws SigitextException {
		logger.debug("[ServiziMgr::indexGetContentDistr] BEGIN");
		Content c = getServiceManager().indexGetContent(fileName);
		c.setModelPrefixedName(Constants.INDEX_DISTRIBUTORI_PREFIX_MODEL);
		//c.setProperties(indexSetMetadati(metadati));
		c.setContent(file);
		logger.debug("[ServiziMgr::indexGetContentDistr] END");
		return c;
	}

	private void checkDimensioneFile(byte[] bytes) throws SigitextException {

		SigitWrkConfigDto wrkConfigDto = getDbServiceImp().cercaConfigValue(Constants.MAX_MB_DOC);
		
		BigDecimal max = wrkConfigDto.getValoreConfigNum();

		if (max != null && bytes.length / 1000000 > max.intValue()) {
			throw new SigitextException("Attenzione. Dimensione del documento non corretta. Ripetere il caricamento.");
		}
	}

	private void checkDimensioneFileDistrib(byte[] bytes) throws SigitextException {

        if (bytes == null || bytes.length == 0) {
            throw new SigitextException("Attenzione. Il file XML non puo' essere vuoto.");
        }

        BigDecimal max = new BigDecimal(Constants.MAX_MB_DOC_DISTRIBUTORE_EXT);

		if (max != null && bytes.length / 1000000 > max.intValue()) {
			throw new SigitextException("Attenzione. Dimensione del documento non corretta. Ripetere il caricamento.");
		}
	}

	private BigDecimal checkNomeFile(DocXml docXml) throws SigitextException {

		try {
            if (docXml.getNome_file() == null || docXml.getNome_file().isEmpty()) {
                throw new SigitextException("Attenzione. Il nome file non puo' essere vuoto.");
            }
            
            if (!docXml.getNome_file().toUpperCase().endsWith(".XML")) {
            	throw new SigitextException(Messages.S096.replaceFirst("##value##", Constants.ESTENSIONE_XML));
			}
			
			if (docXml.getNome_file().length() > Constants.MAX_NOME_FILE_LEN) {
				throw new SigitextException(Messages.S163.replaceFirst("##value##", ConvertUtil.convertToString(Constants.MAX_NOME_FILE_LEN)));
			}
			
			Integer annoCorrente = DateUtil.getAnnoCorrente();
			Integer annoNomeFile = Integer.valueOf(docXml.getNome_file().substring(0, docXml.getNome_file().indexOf("_")));
			if (annoNomeFile < 2000 || annoNomeFile > annoCorrente) {
				// nome file non valido
				throw new SigitextException(Messages.S097);
			}
			return new BigDecimal(annoNomeFile);
		} catch (NumberFormatException e) {
			logger.error("ServiceManager::checkNomeFile - Errore durante il controllo del formato nome file.");
			throw new SigitextException(Messages.S097);
		} catch (Exception e) {
			logger.error("ServiceManager::checkNomeFile - Errore durante il controllo del formato nome file.");
			throw new SigitextException(Messages.S097);
		} 
		
	}

	private SigitTImportDistribPk checkDocXmlDistributoreCaricato(Integer idPersonaGiuridica, DocXml docXml) throws SigitextException {
		
		try {
			SigitTImportDistribPk pk = null;
			List<SigitTImportDistribByIdPersonaGiuridicaDto> sigitTImportDistribDto = getDbServiceImp().getSigitTImportDistribDao().findByIdPersonaGiuridicaAndNomeFile(idPersonaGiuridica, docXml.getNome_file());

			if (sigitTImportDistribDto != null && !sigitTImportDistribDto.isEmpty()) {
				pk = new SigitTImportDistribPk();
				pk.setIdImportDistrib(sigitTImportDistribDto.get(0).getIdIdImportDistrib());
			}
			return pk;

		} catch (SigitTImportDistribDaoException e) {
			logger.error("ServiceManager::checkDocXmlDidtributoreCaricato - Errore durante la ricerca su db.", e);
			throw new SigitextException("Errore durante il controllo di presenza import caricati precedentemente.");
		}
		
	}

	private void aggiornaUidIndexImportDistributore(SigitTImportDistribPk pkNew, String uidIndex)
			throws SigitextException {
		try {
			getDbServiceImp().getSigitTImportDistribDao().updateUidIndex(pkNew, uidIndex);
		} catch (SigitTImportDistribDaoException e) {
			logger.error("ServiceManager::aggiornaUidIndexImportDistributore - Errore durante l'aggiornamento dell'uidIndex.", e);
			throw new SigitextException("Errore durante l'aggiornamento durante l'aggiornamento dell'uidIndex.");
		}
	}

	private void aggiornaImportDistributoreSostituito(Integer idPersonaGiuridica, SigitTImportDistribPk pk)
			throws SigitextException {
		try {
			Timestamp sysdate = new Timestamp(System.currentTimeMillis());
			SigitTImportDistribDto dto = new SigitTImportDistribDto();
			dto.setFkStatoDistrib(4);
			dto.setDataAnnullamento(sysdate);
			dto.setDataUltMod(sysdate);
			dto.setUtenteUltMod(idPersonaGiuridica.toString());
			
			getDbServiceImp().getSigitTImportDistribDao().updateColumnsAnnullaImport(dto);
		} catch (SigitTImportDistribDaoException e) {
			logger.error("ServiceManager::aggiornaImportDistributoreSostituito - Errore durante la sostituzione", e);
			throw new SigitextException("Errore durante l'aggiornamento dei dati dell'import distributore da sostituire.");
		}
	}

}
