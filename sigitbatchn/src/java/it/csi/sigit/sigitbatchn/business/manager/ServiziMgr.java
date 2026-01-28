/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.manager;



import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.xml.PDConfigReader;
//import it.csi.modol.modolsrv.dto.Applicazione;
//import it.csi.modol.modolsrv.dto.Modulo;
//import it.csi.modol.modolsrv.dto.Utente;
//import it.csi.modol.modolsrv.dto.XmlModel;
//import it.csi.modol.modolsrv.dto.criteri.CriterioRicercaModulo;
//import it.csi.modol.modolsrv.dto.utility.RendererModalityExpert;
//import it.csi.modol.modolsrv.interfacecsi.ModolSrvITF;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.SigitTAllegatoDao;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDistribRicevutaByIdImportDistribDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.SigitTAllegatoDaoException;
import it.csi.sigit.sigitbatchn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitbatchn.business.manager.util.Message;
import it.csi.sigit.sigitbatchn.business.manager.util.Messages;
//import it.csi.sigit.sigitbatchn.business.manager.util.MyHandler;
import it.csi.sigit.sigitbatchn.business.manager.util.PartialXmlEventReader;
import it.csi.sigit.sigitbatchn.business.manager.util.ServiceException;
import it.csi.sigit.sigitbatchn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitbatchn.business.manager.util.index.Metadati;
import it.csi.sigit.sigitbatchn.business.util.Constants;


import it.csi.sigit.sigitbatchn.business.util.ConvertUtil;
import it.csi.sigit.sigitbatchn.business.util.DateUtil;
import it.csi.sigit.sigitbatchn.business.util.GenericUtil;
import it.csi.sigit.sigitbatchn.business.util.MapDto;
import it.csi.sigit.sigitbatchn.business.util.XmlValidationHandler;
import it.csi.sigit.sigitbatchn.business.util.XmlValidator;
import it.csi.sigit.sigitbatchn.business.util.XmlValidatorException;
import it.csi.sigit.sigitbatchn.business.util.mail.Mail;
import it.csi.sigit.sigitbatchn.business.util.mail.MailSender;
import it.csi.sigit.sigitwebn.xml.dataRicevutaAllegato.DescrizioneDocument;
import it.csi.sigit.sigitwebn.xml.dataRicevutaAllegato.FooterDocument;
import it.csi.sigit.sigitwebn.xml.dataRicevutaAllegato.InfoImpiantoDocument;
import it.csi.sigit.sigitwebn.xml.dataRicevutaAllegato.InfoRapportoDocument.InfoRapporto;
import it.csi.sigit.sigitwebn.xml.dataRicevutaAllegato.IntestazioneDocument;
import it.csi.sigit.sigitwebn.xml.dataRicevutaAllegato.InvioDocument;
import it.csi.sigit.sigitwebn.xml.dataRicevutaAllegato.InvioDocument.Invio;
import it.csi.sigit.sigitwebn.xml.dataRicevutaDistributore.DescrizioneImportDocument;
import it.csi.sigit.sigitwebn.xml.dataRicevutaDistributore.FooterImportDocument;
import it.csi.sigit.sigitwebn.xml.dataRicevutaDistributore.ImportDistribDocument;
import it.csi.sigit.sigitwebn.xml.dataRicevutaDistributore.ImportDistribDocument.ImportDistrib;
import it.csi.sigit.sigitwebn.xml.dataRicevutaDistributore.InfoImportDocument.InfoImport;
import it.csi.sigit.sigitwebn.xml.dataRicevutaDistributore.IntestazioneImportDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.UTENZEDISTComunicazione;
import it.csi.sigit.sigitbatchn.business.util.XMLValidationEventCollector;
import it.doqui.index.ecmengine.client.mtom.EcmEngineMtomDelegateImpl;
import it.doqui.index.ecmengine.client.webservices.dto.Node;
import it.doqui.index.ecmengine.client.webservices.dto.OperationContext;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Content;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Mimetype;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Property;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.NodeResponse;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.SearchParams;
//import it.doqui.index.ecmengine.dto.Node;
//import it.doqui.index.ecmengine.dto.OperationContext;
//import it.doqui.index.ecmengine.dto.engine.management.Content;
//import it.doqui.index.ecmengine.dto.engine.management.Mimetype;
//import it.doqui.index.ecmengine.dto.engine.management.Property;
//import it.doqui.index.ecmengine.dto.engine.search.NodeResponse;
//import it.doqui.index.ecmengine.dto.engine.search.ResultContent;
//import it.doqui.index.ecmengine.dto.engine.search.SearchParams;
//import it.doqui.index.ecmengine.dto.engine.search.SearchResponse;
import it.doqui.index.ecmengine.exception.InvalidParameterException;
//import it.doqui.index.ecmengine.interfacecsi.management.EcmEngineManagementInterface;
//import it.doqui.index.ecmengine.interfacecsi.search.EcmEngineSearchInterface;
import it.doqui.index.ecmengine.mtom.dto.Attachment;
import it.doqui.index.ecmengine.mtom.dto.MtomNode;
import it.doqui.index.ecmengine.mtom.dto.MtomOperationContext;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.namespace.QName;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.soap.util.mime.ByteArrayDataSource;
//import org.dom4j.Document;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;
import org.xml.sax.helpers.DefaultHandler;




public class ServiziMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business.manager");
	
	//private final String TOPE_RESOURCE = "/META-INF/pd_topesv_Topo.xml";
	private final String PROPERTIES_RESOURCE = "/META-INF/sigitbatchn.properties";
//	private final String MODOL_RESOURCE = "/META-INF/defpd_modolsrv.xml";
//	private final String MDP_RESOURCE = "/META-INF/defpd_mdpnew.xml";
	private final String INDEX_MNG_RESOURCE = "/META-INF/defpd_indexmngmt.xml";
	private final String INDEX_SRC_RESOURCE = "/META-INF/defpd_indexsearch.xml";
	
	/**
	 * Manager del DB
	 */
	protected DbMgr dbMgr;
	
	/**
	 * Server della mail
	 */
	//protected MailServer mailServer;
	
	/**
	 * Restituisce il manager del DB
	 * 
	 * @return Manager del DB
	 */
	public DbMgr getDbMgr() {
		return dbMgr;
	}

	/**
	 * Imposta i manager del DB
	 * 
	 * @param serviziMgr Manager del DB
	 */
	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}
	
	// Mtom
	private EcmEngineMtomDelegateImpl cxf;

	public EcmEngineMtomDelegateImpl getCxf() {
		return cxf;
	}

	public void setCxf(EcmEngineMtomDelegateImpl cxf) {
		this.cxf = cxf;
	}
		
	private IndexServiceImp serviceIndex;
	
	public IndexServiceImp getServiceIndex() {
		
		return serviceIndex;
	}

	public void setServiceIndex(IndexServiceImp serviceIndex) {
		this.serviceIndex = serviceIndex;
	}
	/*
	public ModolSrvITF getModol() {
		log.debug("[ServiziMgr::getModol] BEGIN");
		InputStream is = getClass().getResourceAsStream(MODOL_RESOURCE);
		if (is != null) {
			try {
				InfoPortaDelegata info = PDConfigReader.read(is);
				log.debug("[ServiziMgr::getModol] END");
				return (ModolSrvITF) PDProxy.newInstance(info);
			} 
			catch (Exception e) {
				log.error("[ServiziMgr::getModol] errore nella parsificazione della configurazione di MODOL:"+ e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione di MODOL");
			}
		} else{
			log.error("[ServiziMgr::getModol] configurazione di MODOL non trovata");
		}
		throw new IllegalArgumentException("configurazione di MODOL non trovata");
	}
	*/
	protected Properties getProperties() {
		log.debug("[ServiziMgr::getProperties] BEGIN");
		InputStream is = getClass().getResourceAsStream(PROPERTIES_RESOURCE);
		
		if (is != null) {
			try {
				 Properties properties = new Properties();
	             properties.load(is);
	              
				return properties;
			} 
			catch (Exception e) {
				log.error("[ServiziMgr::getProperties] errore nella parsificazione della configurazione delle PROPERTIES:"+ e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione delle PROPERTIES");
			}
		} else{
			log.error("[ServiziMgr::getProperties] configurazione delle PROPERTIES non trovata");
		}
		throw new IllegalArgumentException("configurazione delle PROPERTIES non trovata");
	}

	private MtomOperationContext mtomGetOperationContext() {
		log.debug("[ServiziMgr::mtomGetOperationContext] BEGIN");
		MtomOperationContext moc= new MtomOperationContext();
		moc.setUsername(Constants.INDEX_USERNAME_ADMIN);
		moc.setPassword(Constants.INDEX_PSW);
		moc.setRepository(Constants.INDEX_REPOSITORY);
		moc.setFruitore(Constants.INDEX_FRUITORE);
		moc.setNomeFisico(Constants.INDEX_UTENTE);
		log.debug("[ServiziMgr::mtomGetOperationContext] END");
		return moc;
	}

	public void test(){
		log.debug("ServiziMgr RAGGIUNTO CORRETTAMENTE");
	}
	/*
	public Modulo cercaModulo(Applicazione applicazione, String codiceModulo) throws ServiceException {
		log.debug("[ServiziMgr::cercaModulo] BEGIN");
		log.debug("CODICE MODOL: ["  + codiceModulo+"]");
		CriterioRicercaModulo criterio;
		try {
			criterio = new CriterioRicercaModulo();
			criterio.setCodiceModulo(codiceModulo);
			Modulo[] moduli = getModol().ricercaModuli(applicazione, null , criterio);
			if(moduli!=null && moduli.length>0)
			{
				return moduli[0];
			}
			else
			{
				log.error("Non ho trovato il modulo su MODOL");
				throw new ServiceException(null, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
			}
		}catch (Exception e) {
				log.error("Errore recupero modulo: ", e);
				throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}finally{
			log.debug("[ServiziMgr::cercaModulo] END");
		}
	}
	*/
	public ImportDistribDocument getRicevutaImportDistrib(Integer idImportDistrib) throws ServiceException {
		log.debug("[ServiziMgr::getRicevutaImportDistrib] BEGIN");
		
		try {
			
			//List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(impianto.getImpCodImpianto(), Constants.ID_STATO_LIBRETTO_BOZZA);
			
			IntestazioneImportDocument.IntestazioneImport intestazione = null;
			DescrizioneImportDocument.DescrizioneImport descrizione = null;
			InfoImport infoRapporto = null;
			FooterImportDocument.FooterImport footer = null;
			
			ImportDistribDocument result = ImportDistribDocument.Factory.newInstance();
			ImportDistrib invio = result.addNewImportDistrib();
			String codiceRea = null;
			String indirizzo = null;
			String provincia = null;
			
			// 1. Recupero l'import distributore
			SigitTImportDistribRicevutaByIdImportDistribDto importDistribDB = getDbMgr().cercaImportRicevutaByIdDistr(idImportDistrib);
			//SigitVRicercaAllegatiDto allegatoDB = dbMgr.cercaSigitVRicercaAllegatiByIdAllegato(idImportDistrib);


			if(importDistribDB != null) {

				//SigitRImpManutDto sigitRImpManut = getCommonDbMgr().getImpManutByPrimaryKey(rapporto.getFkImpManut());
							
				intestazione = invio.addNewIntestazioneImport();
				descrizione = invio.addNewDescrizioneImport();
				infoRapporto = invio.addNewInfoImport();
				footer = invio.addNewFooterImport();
				
				codiceRea = MapDto.getCodiceRea(importDistribDB.getPgSiglaRea(), ConvertUtil.convertToInteger(importDistribDB.getPgNumeroRea()));

				indirizzo = MapDto.getIndirizzoCompleto(importDistribDB.getPgComune(), importDistribDB.getPgIndirizzoSitad(), importDistribDB.getPgIndirizzoNonTrovato(), 
						importDistribDB.getPgCivico(), importDistribDB.getPgSiglaProv());

				descrizione.setRagioneSociale(importDistribDB.getPgDenominazione());
				descrizione.setIndirizzo(indirizzo);
				descrizione.setCodiceFiscale(importDistribDB.getPgCodiceFiscale());
				descrizione.setCodiceRea(codiceRea);					


				infoRapporto.setDataCaricamento(ConvertUtil.convertToString(importDistribDB.getIdDataInizioElab()));
				infoRapporto.setDataAcquisizione(ConvertUtil.convertToString(importDistribDB.getIdDataFineElab()));
				infoRapporto.setDataAnnullamento(ConvertUtil.convertToString(importDistribDB.getIdDataAnnullamento()));
				infoRapporto.setNomeFile(importDistribDB.getIdNomeFileImport());
				infoRapporto.setAnnoRiferimento(ConvertUtil.convertToString(importDistribDB.getIdAnnoRiferimento()));
				infoRapporto.setStatoAcquisizione(importDistribDB.getSdDesStatoDistrib());
				
				// Footer
				footer.setData(DateUtil.getDataCorrenteFormat());
				footer.setLuogo(provincia);
			}
			
			return result;
			
		}catch (Exception e) {
				log.error("Errore getRicevutaImportDistrib",e);
				throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}finally{
			log.debug("[ServiziMgr::getRicevutaImportDistrib] END");
		}
	}
	
//	public void sendMail(String destinatario, String oggetto, String testoHtml, String testoTxt)
//			throws ServiceException {
//		
//		ArrayList<String> destinatari = new ArrayList<String>();
//		destinatari.add(destinatario);
//		sendMail(destinatari, oggetto, testoHtml, testoTxt);
//
//	}
	
	public boolean sendMail(String emailDest, String oggetto, String testoHtml, String testoTxt)
			throws ServiceException {
		
		return sendMail(emailDest, oggetto, testoHtml, testoTxt, null);

	}
	
	public boolean sendMail(ArrayList<String> emailListDest, String oggetto, String testoHtml, String testoTxt)
			throws ServiceException {
		
		return sendMail(emailListDest, oggetto, testoHtml, testoTxt, null);
	}
	
	public boolean sendMail(ArrayList<String> emailListDest, String oggetto, String testoHtml, String testoTxt, Hashtable<String, ByteArrayOutputStream> attachmentList)
			throws ServiceException {
		
		// il metodo ritorna true anche se solo 1 � corretto
		boolean isCorrectRet = false;
	
		boolean isCorrect = false;
		for (String emailDest : emailListDest) {

			isCorrect = sendMail(emailDest, oggetto, testoHtml, testoTxt, attachmentList);
			
			if (!isCorrectRet)
			{
				isCorrectRet = isCorrect;
			}
			
		}

		return isCorrectRet;
	}
	
	public boolean sendMail(String emailDest, String oggetto, String testoHtml, String testoTxt, Hashtable<String, ByteArrayOutputStream> attachmentList)
			throws ServiceException {
		MailSender sender = new MailSender();
		Mail email = new Mail();
		boolean isCorrect = false;
		try {
			
			email.setHost(getProperties().getProperty(Constants.MAIL_HOST));
			email.setPort(getProperties().getProperty(Constants.MAIL_PORT));
			email.setIdEmail(getProperties().getProperty(Constants.MAIL_USER));
			email.setPassword(getProperties().getProperty(Constants.MAIL_PWD));

			email.setMittente(getDbMgr().cercaConfigValueCarattere(Constants.WEB_MAIL_IND_MITT));
	
			email.setOggetto(oggetto);
			email.setHtml(testoHtml);
			email.setTesto(testoTxt);
		
			email.setAttachmentList(attachmentList);
			
			email.setDestinatario(emailDest);
			try
			{
				sender.sendMail(email);
				isCorrect = true;
			}
			catch (Exception e) {
				log.debug("Si e' verificato un problema nell'invio della mail, molto probabilmente l'indirizzo non e' corretto: "+emailDest);
				log.debug("Invio la mail all'assistenza per informarla del problema");
				log.error(e);
				inviaMailAssistenzaEmailErrata(email);
			}
		} catch (Exception e) {
			log.error(e);
			throw new ServiceException(e, new Message(Messages.ERROR_INVIO_MAIL));
		}

		return isCorrect;
	}
	
	private void inviaMailAssistenzaEmailErrata(Mail email)
	{
		
		log.debug("[ServiziMgr::inviaMailAssistenzaEmailErrata] START");
		
		try {
			MailSender sender = new MailSender();

			// Devo modificare la mail originaria
			
			email.setOggetto("FALLITO invio mail: "+email.getOggetto());
			
			email.setHtml("La seguente mail non e' stata inviata per un problema nell'indirizzo mail: " + email.getDestinatario() + " </BR></BR>"+email.getHtml());
			email.setTesto("La seguente mail non e' stata inviata per un problema nell'indirizzo mail: " + email.getDestinatario() + "\n\n"+email.getHtml());
			
			String mailDest = getDbMgr().cercaConfigValueCarattere(Constants.BATCH_MAIL_IND_DEST);

			email.setDestinatario(mailDest);

			sender.sendMail(email);
		} 
		catch (DbManagerException e)
		{
			log.error("Errore recupero indirizzo email assistenza", e);
			// Se c'� un errore non faccio niente e vado avanti
			log.error(e);
		}
		catch (Exception e) {
			log.error("Errore invio email all'ASSISTENZA", e);
			// Se c'� un errore non faccio niente e vado avanti
			log.error(e);
		}
		
		log.debug("[ServiziMgr::inviaMailAssistenzaEmailErrata] END");

	}

	
	
	
	public String indexUploadFile(String fileName, byte[]file, Metadati metadati) throws ServiceException {
		log.debug("[ServiziMgr::indexUploadFile] BEGIN");
		String uidFile = null;
		Node n = null;
		Content c = null;
		Node nodoFile = null;
		OperationContext oc = null;
		try{
			
			oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
			log.debug("------- OPERATION CONTEXT --- "+oc);
			
			
			// Recupero il nodo del cod impianto
			n = new Node(indexGetFolder(metadati, oc));
			
			Node nodeCodImp = indexSearchFolder(getQueryLuceneSearchFile(fileName, metadati), oc);

			c = indexGetContent(metadati, fileName, file);
			log.debug("------- CONTENT --- "+c);

			if (nodeCodImp != null)
			{
				// Il file esiste già, faccio l'update
				getServiceIndex().getEcmengineDelegate().updateContentData(nodeCodImp, c, oc); 
				log.debug("------- UPDARE NODO --- "+nodoFile);
			}
			else
			{
				// Il file non esiste, faccio l'insert
				nodeCodImp = getServiceIndex().getEcmengineDelegate().createContent(n, c, oc);
				log.debug("------- NUOVO NODO --- "+nodoFile);
				
				if (nodeCodImp != null)
				{
					uidFile = nodeCodImp.getUid();
				}

			}
		}
		catch (Exception e) {
			
			log.error("Errore index: ",e);
			
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
			
		}
		
		log.debug("[ServiziMgr::indexUploadFile] END");
		return uidFile;
	}
	
	/*
	protected EcmEngineManagementInterface getIndexManagement() {
		log.debug("[ServiziMgr::getIndexManagement] START");
		InputStream is = getClass().getResourceAsStream(INDEX_MNG_RESOURCE);
		if (is != null) {
			try {
				InfoPortaDelegata info = PDConfigReader.read(is);
				return (EcmEngineManagementInterface) PDProxy.newInstance(info);
			} catch (Exception e) {
				log.error("[ServiziMgr::getIndexManagement] errore nella parsificazione della configurazione di INDEX MANAGEMENT:"+ e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione di INDEX MANAGEMENT");
			}
		} else {
			log	.error("[ServiziMgr::getIndexManagement] configurazione di INDEX MANAGEMENT non trovata");
		}
		throw new IllegalArgumentException(	"configurazione di INDEX MANAGEMENT non trovata");
	}
	*/
	
	protected OperationContext indexGetOperationContext(String user) {
		log.debug("[ServiziMgr::indexGetOperationContext] BEGIN");
		OperationContext ctx = new OperationContext();
		ctx.setUsername(user);
		ctx.setPassword(Constants.INDEX_PSW);
		ctx.setNomeFisico(Constants.INDEX_UTENTE);
		ctx.setFruitore(Constants.INDEX_FRUITORE);
		ctx.setRepository(Constants.INDEX_REPOSITORY);
		log.debug("[ServiziMgr::indexGetOperationContext] END");
		return ctx;
	}
	
	private String indexGetFolder(Metadati metadati, OperationContext op) throws ServiceException {
		log.debug("[ServiziMgr::indexGetFolder] BEGIN");
		try{
			
			Content content = indexGetContentFolder(null);
			
			
			Node nodeCodImp = indexSearchFolder(getQueryLuceneSearchCodImp(metadati), op);
			
			log.debug("Ho cercato il codice impianto: "+nodeCodImp);
			
			if (nodeCodImp == null)
			{
				log.debug("Non esiste il nodo codice impianto");
				
				Node nodeComune = indexSearchFolder(getQueryLuceneSearchComune(metadati), op);
				
				log.debug("Ho cercato il comune: "+nodeComune);
				
				if (nodeComune == null)
				{
					log.debug("Non esiste il nodo comune");
					
					Node nodeProvincia = indexSearchFolder(getQueryLuceneSearchProvincia(metadati), op); 
					
					log.debug("Ho cercato la provincia: "+nodeProvincia);
					
					if (nodeProvincia == null)
					{
						log.debug("Non esiste il nodo provincia");
						
						Node nodeApplicativo = indexSearchFolder(getQueryLuceneSearchApplicativo(), op); 

						log.debug("Ho cercato l'applicativo: "+nodeApplicativo);
						
						if (nodeApplicativo == null)
						{
							log.debug("Se non esiste neanche l'applicativo rilancio l'eccezione!!!");
							throw new ServiceException(new Message("Su INDEX non e' configurato l'applicativo"));
						}
						
						
						log.debug("creo il nodo provincia");
						
						nodeProvincia = indexCreateFolder(metadati.getCodIstatProvincia(), content, nodeApplicativo, op);
					}
					
					log.debug("creo il nodo comune");

					nodeComune = indexCreateFolder(metadati.getCodIstatComune(), content, nodeProvincia, op);

				}

				log.debug("creo il nodo codice impianto");

				nodeCodImp = indexCreateFolder(metadati.getCodiceImpianto(), content, nodeComune, op);
				
			}
			
			return nodeCodImp.getUid();
		}
		catch (ServiceException e) {
			throw e;
		}
		catch (Exception e) {
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally{
			log.debug("[ServiziMgr::indexGetFolder] END");
		}
	}
	
	private Content indexGetContentFolder(String folderName) {
		log.debug("[ServiziMgr::indexGetContentFolder] BEGIN");
		Content myFolder = new Content();
	    myFolder.setPrefixedName(Constants.INDEX_DEFAULT_PREFIX+folderName);
	    myFolder.setParentAssocTypePrefixedName(Constants.INDEX_PREFIX_CONTAINS);
	    myFolder.setModelPrefixedName(Constants.INDEX_PREFIX_MODEL);
	    myFolder.setTypePrefixedName(Constants.INDEX_PREFIX_FOLDER);
	    Property p = new Property();
		p.setPrefixedName(Constants.INDEX_PREFIX_NAME_SHORT);
		p.setDataType("text");
		p.setValues(new String [] {folderName });
		myFolder.setProperties(new Property[]{p});
		log.debug("[ServiziMgr::indexGetContentFolder] END");
	    return myFolder;
	}
	
	private SearchParams getQueryLuceneSearchFile(String nomeFile, Metadati metadati)
	{
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);

		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT);
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatProvincia());
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatComune());
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodiceImpianto());
		luceneQuery.append("/*");
		luceneQuery.append("\"");
		luceneQuery.append(" AND ");
		luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
		luceneQuery.append("name:\"");
		luceneQuery.append(nomeFile+"\"");
		
		log.debug("getQueryLuceneSearchFile: "+luceneQuery.toString());
		
		searchParams.setLuceneQuery(luceneQuery.toString());
		
		return searchParams;
	}
	
	private SearchParams getQueryLuceneSearchCodImp(Metadati metadati)
	{
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);
		
		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT);
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatProvincia());
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatComune());
		luceneQuery.append("/*");
		luceneQuery.append("\"");
		luceneQuery.append(" AND ");
		luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
		luceneQuery.append("name:\"");
		luceneQuery.append(metadati.getCodiceImpianto()+"\"");
		
		log.debug("getQueryLuceneSearchCodImp: "+luceneQuery.toString());
		
		searchParams.setLuceneQuery(luceneQuery.toString());
		
		return searchParams;
	}
	
	private SearchParams getQueryLuceneSearchComune(Metadati metadati)
	{
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);

		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT);
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatProvincia());
		luceneQuery.append("/*");
		luceneQuery.append("\"");
		luceneQuery.append(" AND ");
		luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
		luceneQuery.append("name:\"");
		luceneQuery.append(metadati.getCodIstatComune()+"\"");
		
		log.debug("getQueryLuceneSearchComune: "+luceneQuery.toString());
		
		searchParams.setLuceneQuery(luceneQuery.toString());
		
		return searchParams;
	}
	
	private SearchParams getQueryLuceneSearchProvincia(Metadati metadati)
	{
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
		luceneQuery.append(metadati.getCodIstatProvincia()+"\"");
		
		log.debug("getQueryLuceneSearchProvincia: "+luceneQuery.toString());
		
		searchParams.setLuceneQuery(luceneQuery.toString());
		
		return searchParams;
	}
	
	private SearchParams getQueryLuceneSearchApplicativo()
	{
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);
		
		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append("/app:company_home");
		luceneQuery.append("/*");
		luceneQuery.append("\"");
		luceneQuery.append(" AND ");
		luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
		luceneQuery.append("name:\"");
		luceneQuery.append(Constants.INDEX_FRUITORE + "\"");
		
		log.debug("getQueryLuceneSearchApplicativo: "+luceneQuery.toString());
		
		searchParams.setLuceneQuery(luceneQuery.toString());
		
		return searchParams;
	}
	
	public Node indexSearchFolder(SearchParams params, OperationContext op) throws ServiceException {
		log.debug("[ServiziMgr::indexSearchFolder] BEGIN");
		Node node = null;
		try{
			
			log.debug("Stampo la query lucene: "+params.getLuceneQuery());
			//GenericUtil.stampa(params, true, 3);
			
			NodeResponse nodeResponse = getServiceIndex().getEcmengineDelegate().luceneSearchNoMetadata(params, op);

			//GenericUtil.stampa(nodeResponse, true, 3);
			
			if (nodeResponse != null && nodeResponse.getNodeArray() != null && nodeResponse.getNodeArray().length > 0)
			{
				node = nodeResponse.getNodeArray()[0];
			}
			
			
		}
		catch(Exception e){
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		log.debug("[ServiziMgr::indexSearchFolder] END");
		return node;
	}
	
	
	protected Node indexCreateFolder(String folderName, Content content, Node nodeParent, OperationContext op) throws ServiceException {
		log.debug("[ServiziMgr::indexCreateFolder] BEGIN");
		Node folder = null;
		try{
			content.setPrefixedName(Constants.INDEX_DEFAULT_PREFIX+folderName);
			
			Property p = new Property();
			p.setPrefixedName(Constants.INDEX_PREFIX_NAME_SHORT);
			p.setDataType("text");
			p.setValues(new String [] {folderName });
			content.setProperties(new Property[]{p});
			
			
			folder = getServiceIndex().getEcmengineDelegate().createContent(nodeParent, content, op);
		}
		catch (Exception e) {
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		log.debug("[ServiziMgr::indexCreateFolder] END");
		return folder;
	}
	
	/*
	protected EcmEngineSearchInterface getIndexSearch() {
		log.debug("[ServiziMgr::getIndexSearch] BEGIN");
		InputStream is = getClass().getResourceAsStream(INDEX_SRC_RESOURCE);
		if (is != null) {
			try {
				InfoPortaDelegata info = PDConfigReader.read(is);
				log.debug("[ServiziMgr::getIndexSearch] END 1");
				return (EcmEngineSearchInterface) PDProxy.newInstance(info);
			} catch (Exception e) {
				log.error("[ServiziMgr::getIndexSearch] errore nella parsificazione della configurazione di INDEX SEARCH:"+ e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione di INDEX SEARCH");
			}
		} else {
			log	.error("[ServiziMgr::getIndexSearch] configurazione di INDEX SEARCH non trovata");
		}
		log.error("[ServiziMgr::getIndexSearch] END 2");
		throw new IllegalArgumentException(	"configurazione di INDEX SEARCH non trovata");
	}
	*/
	
	private Content indexGetContent(Metadati metadati, String fileName, byte[] file) throws ServiceException {
		log.debug("[ServiziMgr::indexGetContent] BEGIN");
		Content c = indexGetContent(fileName);
		c.setModelPrefixedName(Constants.INDEX_SIGIT_PREFIX_MODEL);
		c.setProperties(indexSetMetadati(metadati));
		c.setContent(file);
		log.debug("[ServiziMgr::indexGetContent] END");
		return c;
	}
	
	private Content indexGetContent(String fileName) throws ServiceException {
		log.debug("[ServiziMgr::indexGetContent] BEGIN");
		Content myFile = new Content();
		myFile.setContentPropertyPrefixedName(Constants.INDEX_PREFIX_NAME);
		myFile.setPrefixedName(Constants.INDEX_PREFIX+fileName);
		myFile.setParentAssocTypePrefixedName(Constants.INDEX_PREFIX_CONTAINS);
		myFile.setTypePrefixedName(Constants.INDEX_ALLEGATO_NAME);
		myFile.setMimeType(indexGetMimeType(fileName));
		myFile.setEncoding(Constants.INDEX_ENCODING);
		log.debug("[ServiziMgr::indexGetContent] END");
		return myFile;
	}
	
	private String indexGetMimeType(String fileName) throws ServiceException {
		log.debug("[ServiziMgr::indexGetMimeType] BEGIN");
		String estensione = StringUtils.substringAfterLast(fileName, ".");
	    Mimetype mt = new Mimetype();
		log.debug("[ServiziMgr::indexGetMimeType] Estensione " + estensione);
		mt.setFileExtension(estensione);
		Mimetype[] mime = null;
		try{
			mime = getServiceIndex().getEcmengineDelegate().getMimetype(mt);
		}
//		catch (InvalidParameterException e) {
//			throw new ServiceException(e, new Message());
//		}
		catch (RemoteException e) {
			throw new ServiceException(e, new Message());
		}
		log.debug("[ServiziMgr::indexGetMimeType] Mime Type " + mime[0].getMimetype());
		log.debug("[ServiziMgr::indexGetMimeType] END");
		return mime[0].getMimetype();
	}
	
	private Property[] indexSetMetadati(Metadati metadati) {
		log.debug("[ServiziMgr::indexSetMetadati] BEGIN");
		Property[] result = new Property[6];
		result[0] = new Property();
		result[0].setDataType(Constants.INDEX_TYPE_TEXT);
		result[0].setPrefixedName(Metadati.META_BOLLINO_VERDE);
		result[0].setValues(new String[]{metadati.getBollinoVerde()});
		
		result[1] = new Property();
		result[1].setDataType(Constants.INDEX_TYPE_TEXT);
		result[1].setPrefixedName(Metadati.META_COD_ISTAT_COMUNE);
		result[1].setValues(new String[]{metadati.getCodIstatComune()});
		
		result[2] = new Property();
		result[2].setDataType(Constants.INDEX_TYPE_TEXT);
		result[2].setPrefixedName(Metadati.META_COD_ISTAT_PROVINCIA);
		result[2].setValues(new String[]{metadati.getCodIstatProvincia()});
		
		result[3] = new Property();
		result[3].setDataType(Constants.INDEX_TYPE_TEXT);
		result[3].setPrefixedName(Metadati.META_CODICE_REA);
		result[3].setValues(new String[]{metadati.getCodiceRea()});
		
		result[4] = new Property();
		result[4].setDataType(Constants.INDEX_TYPE_TEXT);
		result[4].setPrefixedName(Metadati.META_DATA_RAPPORTO);
		result[4].setValues(new String[]{metadati.getDataRapporto()});
		
		result[5] = new Property();
		result[5].setDataType(Constants.INDEX_TYPE_TEXT);
		result[5].setPrefixedName(Metadati.META_ID_RAPPORTO);
		result[5].setValues(new String[]{metadati.getIdRapporto()});
		log.debug("[ServiziMgr::indexSetMetadati] END");
		return result;
	}
	
	
	/*
	public byte[] showModuloRicevutaAllegato(Applicazione app, Utente utente, XmlModel xmlModel) throws ServiceException {
		log.debug("[ServiziMgr::showModuloRicevutaAllegato] BEGIN");
		try
		{
			Modulo modulo = cercaModulo(app, Constants.CODICE_MODULO_MODOL_RICEVUTA_ALLEGATO);
			//Modulo modulo2 = cercaModulo(app, "ALLEGATO_G");
			
			log.debug("STAMPO IL MODULO TROVATO: "+modulo);
			
			if(modulo!=null)
			{
				//modulo.getModello().getRendererModality()[0].setSelezionataPerRendering(true);
				
				RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
				
				log.debug("########################################");
				log.debug("faccio la merge");
				log.debug("xmlModel: "+xmlModel.toString());
				log.debug("modulo: "+modulo);
				log.debug("########################################");

				return getModol().mergeModulo(app, utente, modulo, xmlModel).getDataContent();
			}
			
			return null;
		}
		catch (Exception e) {
			log.error("Errore nella generazione del modulo", e);
			throw new ServiceException(e, new Message());
		}finally{
			log.debug("[ServiziMgr::showModuloRicevutaAllegato] END");
		}
	}
	*/
	/*
	public byte[] showModuloRicevutaImportDistrib(Applicazione app, Utente utente, XmlModel xmlModel) throws ServiceException {
		log.debug("[ServiziMgr::showModuloRicevutaImportDistrib] BEGIN");
		try
		{
			Modulo modulo = cercaModulo(app, Constants.CODICE_MODULO_MODOL_RICEVUTA_IMPORT_DISTRIB);
			//Modulo modulo2 = cercaModulo(app, "ALLEGATO_G");
			
			log.debug("STAMPO IL MODULO TROVATO: "+modulo);
			
			if(modulo!=null)
			{
				//modulo.getModello().getRendererModality()[0].setSelezionataPerRendering(true);
				
				RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
				
				log.debug("########################################");
				log.debug("faccio la merge");
				log.debug("xmlModel: "+xmlModel.toString());
				log.debug("modulo: "+modulo);
				log.debug("########################################");

				return getModol().mergeModulo(app, utente, modulo, xmlModel).getDataContent();
			}
			
			return null;
		}
		catch (Exception e) {
			log.error("Errore nella generazione del modulo", e);
			throw new ServiceException(e, new Message());
		}finally{
			log.debug("[ServiziMgr::showModuloRicevutaImportDistrib] END");
		}
	}
	*/
	public InvioDocument getRicevutaAllegato(BigDecimal idAllegato) throws ServiceException {
		log.debug("[ServiziMgr::getRicevutaAllegato] BEGIN");
		
		
		try {
					
			
			//List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(impianto.getImpCodImpianto(), Constants.ID_STATO_LIBRETTO_BOZZA);
			
			IntestazioneDocument.Intestazione intestazione = null;
			DescrizioneDocument.Descrizione descrizione = null;
			InfoImpiantoDocument.InfoImpianto infoImpianto = null;
			InfoRapporto infoRapporto = null;
			FooterDocument.Footer footer = null;
			
			InvioDocument result = InvioDocument.Factory.newInstance();
			Invio invio = result.addNewInvio();
			String codiceRea = null;
			String indirizzo = null;
			String provincia = null;
			
			// 1. Recupero l'allegato
			SigitVRicercaAllegatiDto allegatoDB = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);


			if(allegatoDB != null) {

				//SigitRImpManutDto sigitRImpManut = getCommonDbMgr().getImpManutByPrimaryKey(rapporto.getFkImpManut());
							
				intestazione = invio.addNewIntestazione();
				descrizione = invio.addNewDescrizione();
				infoImpianto = invio.addNewInfoImpianto();
				infoRapporto = invio.addNewInfoRapporto();
				footer = invio.addNewFooter();
				
				codiceRea = MapDto.getCodiceRea(allegatoDB.getPgSiglaRea(), ConvertUtil.convertToInteger(allegatoDB.getPgNumeroRea()));
				
				//SigitTPersonaGiuridicaDto personaGiuridicaDto = getDbMgr().cercaSigitTPersonaGiuridicaByIdImpRuoloPfpg(allegatoDB.getFkImpRuoloPfpg());
				SigitTPersonaGiuridicaDto personaGiuridicaDto = getDbMgr().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(allegatoDB.getIdPersonaGiuridica()));

				if (ConvertUtil.convertToBooleanAllways(personaGiuridicaDto.getFlgIndirizzoEstero()))
				{
					indirizzo = MapDto.getIndirizzoEsteroCompleto(personaGiuridicaDto.getStatoEstero(), personaGiuridicaDto.getCittaEstero(), personaGiuridicaDto.getIndirizzoEstero(), personaGiuridicaDto.getCivico());
				}
				else
				{
					indirizzo = MapDto.getIndirizzoCompleto(personaGiuridicaDto.getComune(), personaGiuridicaDto.getIndirizzoSitad(), personaGiuridicaDto.getIndirizzoNonTrovato(), 
							personaGiuridicaDto.getCivico(), personaGiuridicaDto.getSiglaProv());
				}
				
				descrizione.setRagioneSociale(allegatoDB.getPgDenominazione());
				descrizione.setIndirizzo(indirizzo);
				descrizione.setCodiceFiscale(allegatoDB.getPgCodiceFiscale());
				descrizione.setCodiceRea(codiceRea);
				
				// InfoImpianto
				infoImpianto.setCodice(ConvertUtil.convertToString(allegatoDB.getCodiceImpianto()));
				
				
				String ubicazione = MapDto.getIndirizzoCompleto(allegatoDB.getComuneImpianto(), allegatoDB.getIndirizzoUnitaImmob(), null, allegatoDB.getCivicoUnitaImmob(), allegatoDB.getSiglaProvImpianto());

				infoImpianto.setUbicazione(ubicazione.toString());
				
				String descTipoDoc = allegatoDB.getDesTipoDocumento();
				
				infoRapporto.setTipoRapporto(descTipoDoc);
				infoRapporto.setDataControllo(ConvertUtil.convertToString(allegatoDB.getDataControllo()));
				
				infoRapporto.setElencoApp(allegatoDB.getElencoApparecchiature());

				if(GenericUtil.isNotNullOrEmpty(allegatoDB.getFkNumeroBollino()))
				{
					infoRapporto.setCodiceBollino(allegatoDB.getFkSiglaBollino() + "-" + allegatoDB.getFkNumeroBollino());
				}
				infoRapporto.setDataInvio(ConvertUtil.convertToString(allegatoDB.getDataInvio()));
				
				if (allegatoDB.getDataRespinta() != null)
				{
					infoRapporto.setDataRespinta(ConvertUtil.convertToString(allegatoDB.getDataRespinta()));	
				}
				
				if (GenericUtil.isNotNullOrEmpty(allegatoDB.getFkPgCat()))
				{
					SigitTPersonaGiuridicaDto personaGiuridicaCatDto = getDbMgr().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(allegatoDB.getFkPgCat()));
					infoRapporto.setDescCat(personaGiuridicaCatDto.getDenominazione());
				}
				
				// Footer
				footer.setData(DateUtil.getDataCorrenteFormat());
				footer.setLuogo(provincia);
			}
			
			return result;
			
		}catch (Exception e) {
				log.error("Errore getRicevutaAllegato",e);
				throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}finally{
			log.debug("[ServiziMgr::getRicevutaAllegato] END");
		}
	}
	/*
	public byte[] getFileImportDistribIndex(Applicazione app, Utente utente, XmlModel xmlModel) throws ServiceException {
		log.debug("[ServiziMgr::showModuloRicevutaAllegato] BEGIN");
		try
		{
			Modulo modulo = cercaModulo(app, Constants.CODICE_MODULO_MODOL_RICEVUTA_ALLEGATO);
			//Modulo modulo2 = cercaModulo(app, "ALLEGATO_G");
			
			log.debug("STAMPO IL MODULO TROVATO: "+modulo);
			
			if(modulo!=null)
			{
				//modulo.getModello().getRendererModality()[0].setSelezionataPerRendering(true);
				
				RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
				
				log.debug("########################################");
				log.debug("faccio la merge");
				log.debug("xmlModel: "+xmlModel.toString());
				log.debug("modulo: "+modulo);
				log.debug("########################################");

				return getModol().mergeModulo(app, utente, modulo, xmlModel).getDataContent();
			}
			
			return null;
		}
		catch (Exception e) {
			log.error("Errore nella generazione del modulo", e);
			throw new ServiceException(e, new Message());
		}finally{
			log.debug("[ServiziMgr::showModuloRicevutaAllegato] END");
		}
	}
	*/

	/*
	public byte[] mtomDownloadFile(String uidImportDistrib)throws ServiceException{
		log.debug("[ServiziMgr::mtomDownloadFile] BEGIN");
        byte[] result = null;
		try{
        	
        	log.debug("@@@@@@ CXF: "+cxf);
        	Attachment indeFile = cxf.downloadMethod(new MtomNode(uidImportDistrib, Constants.INDEX_PREFIX_NAME), mtomGetOperationContext());
        	
        	InputStream in = indeFile.attachmentDataHandler.getInputStream();

        	result = IOUtils.toByteArray(in);
        	in.close();
        	
        	return result;
			
        } catch(Exception e) {
        	log.error("Errore getRicevutaAllegato",e);
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
        } finally {
        	log.debug("[ServiziMgr::mtomDownloadFile] END");
        }
    }
	*/

	public UTENZEDISTComunicazione mtomDownloadFileOld(String uidImportDistrib) throws ServiceException {
		log.debug("[ServiziMgr::mtomDownloadFile] BEGIN");
		try{
			//log.debug("@@@@@@ CXF: "+cxf);

			// FUNZIONA
			UTENZEDISTComunicazione utenze = null;
			Attachment indeFile = cxf.downloadMethod(new MtomNode(uidImportDistrib, Constants.INDEX_PREFIX_NAME), mtomGetOperationContext());
			//return IOUtils.toByteArray(indeFile.attachmentDataHandler.getInputStream());

			log.debug("Prima della creazione dell'input stream");
			InputStream in = indeFile.attachmentDataHandler.getInputStream();

			//System.out.println("Scrivo il file - prima New4");
			//writeDataToFile(in);
			//System.out.println("Scrivo il file - dopo New4");

//			InputStream bufferedIn = new BufferedInputStream(in, 4096); 
//			bufferedIn.mark(0);
//			// Devo verificare se l'xml � coerente con l'xsd
			//validazioneXmlImportDistributore(bufferedIn);
//			bufferedIn.reset();
			
			final JAXBContext context = JAXBContext.newInstance(UTENZEDISTComunicazione.class);
			final Unmarshaller um = context.createUnmarshaller();
			
			//String schemasDir = "sigitbatchn-xmlbean-client.jar/";
			String schemasDir = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
			String distributoreSchema = schemasDir + "Import-Utenze-Distributori-1.0.0.xsd";
			
			
			// Copiato da:
			// http://blog.bdoughan.com/2010/12/jaxb-and-marshalunmarshal-schema.html
	        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
	        
	        //new InputStreamReader(GenericUtil.getFileInClassPath(distributoreSchema))
	        sf.newSchema(GenericUtil.getURLFileInClassPath(distributoreSchema));
			Schema schema = sf.newSchema(new File(distributoreSchema)); 
			um.setSchema(schema);
			um.setEventHandler(new XmlValidationHandler());
			
			//Reader reader = null;
			//InputStream ism = null;
			try {
				//reader = new BufferedReader(new FileReader("C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 3\\2015_esempio XML 1.0.0_3.1.xml"));
				//reader = new BufferedReader(new FileReader("C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 2\\2015_esempio XML 1.0.0_tc.1_BIG.xml"));
				//ism = new FileInputStream("/home/apps/jbcp09/dev-jboss43cp09-008/deploy/sigitbatchn/xml/test.xml");

				final QName qName = new QName("datiFornituraCliente");
				final XMLInputFactory xif = XMLInputFactory.newInstance();
				final XMLEventReader xmlEventReader = xif.createXMLEventReader(in);
				
				utenze =
						(UTENZEDISTComunicazione) um.unmarshal(new PartialXmlEventReader(xmlEventReader, qName));

				log.debug("Stampo il numero di forniture: "+utenze.getDatiFornituraCliente().size());

			} 
			catch(Exception e) {
				log.error("Errore nel rimappaggio del file",e);
				throw new ServiceException(e, new Message(Messages.ERROR_MAPPATURA_XML));
			} 
			finally {
				IOUtils.closeQuietly(in);
			}

			return utenze;

		} 
		catch(ServiceException e) {
			log.error("Errore ServiceException",e);
			throw e;
		}
//		catch(ValidationManagerException e) {
//			log.error("Errore ValidationManagerException",e);
//			throw new ServiceException(e, new Message(e.getMessage()));
//		}
		catch(Exception e) {
			log.error("Errore Exception",e);
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} finally {
			log.debug("[ServiziMgr::mtomDownloadFile] END");
		}
	}

	public UTENZEDISTComunicazione mtomDownloadFile(String uidImportDistrib) throws ServiceException {
		log.debug("[ServiziMgr::mtomDownloadFile] BEGIN");
		try{
			//log.debug("@@@@@@ CXF: "+cxf);

			// FUNZIONA
			UTENZEDISTComunicazione utenze = null;
			Attachment indeFile = cxf.downloadMethod(new MtomNode(uidImportDistrib, Constants.INDEX_PREFIX_NAME), mtomGetOperationContext());
			//return IOUtils.toByteArray(indeFile.attachmentDataHandler.getInputStream());

			log.debug("Prima della creazione dell'input stream");
			InputStream in = indeFile.attachmentDataHandler.getInputStream();

			final JAXBContext context = JAXBContext.newInstance(UTENZEDISTComunicazione.class);
			final Unmarshaller um = context.createUnmarshaller();

			//String schemasDir = "sigitbatchn-xmlbean-client.jar/";
			String schemasDir = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
			String distributoreSchema = schemasDir + "Import-Utenze-Distributori-2.0.2.xsd";

			// Copiato da:
			// http://blog.bdoughan.com/2010/12/jaxb-and-marshalunmarshal-schema.html
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 

			InputStream isSchema = GenericUtil.getFileInClassPath(distributoreSchema);

			// Creo un oggeto File che mi serve per conservare lo schema xsd 
			log.debug("Prima di createTempFile");
			final File tempFile = File.createTempFile("prova", "xsd");

			try 
			{
				log.debug("Prima di FileOutputStream");

				FileOutputStream out = new FileOutputStream(tempFile);
				log.debug("Prima di copy");
				
				log.debug("Stampo isSchema: "+isSchema);
				log.debug("Stampo out: "+out);
				IOUtils.copy(isSchema, out);
				log.debug("Dopo di copy");
			}
			catch (Exception e)
			{
				boolean isDelete = tempFile.delete();
				
				log.debug("Temp file deleted:" + isDelete);
				
				throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
			}

			Schema schema = sf.newSchema(tempFile); 
			um.setSchema(schema);
			ValidationEventCollector validationCollector = new XMLValidationEventCollector();
			um.setEventHandler(validationCollector);
			try {

				final QName qName = new QName("datiFornituraCliente");
				final XMLInputFactory xif = XMLInputFactory.newInstance();
				final XMLEventReader xmlEventReader = xif.createXMLEventReader(in);

				log.debug("PRIMA DELL'unmarshal");

				utenze =
						(UTENZEDISTComunicazione) um.unmarshal(new PartialXmlEventReader(xmlEventReader, qName));

				log.debug("validationCollector: "+validationCollector);
				log.debug("validationCollector.hasEvents(): "+validationCollector.hasEvents());

				if(validationCollector.hasEvents())
				{
					// Questa e' la collezione di errori riscontrati nella validazione
					for(ValidationEvent event:validationCollector.getEvents())
					{
						String msg = event.getMessage();
						log.error(msg);
					}

					throw new ServiceException(new Message(Messages.ERROR_MAPPATURA_XML));
				}

				log.debug("DOPO L'unmarshal");

				log.debug("Stampo il numero di forniture: "+utenze.getDatiFornituraCliente().size());

			} 
			catch(Exception e) {
				log.error("Errore nel rimappaggio del file",e);
				throw new ServiceException(e, new Message(Messages.ERROR_MAPPATURA_XML));
			} 
			finally {
				IOUtils.closeQuietly(in);
				boolean isDelete = tempFile.delete();
				
				log.debug("Temp file deleted:" + isDelete);
			}

			return utenze;

		} 
		catch(ServiceException e) {
			log.error("Errore ServiceException",e);
			throw e;
		}
		//		catch(ValidationManagerException e) {
		//			log.error("Errore ValidationManagerException",e);
		//			throw new ServiceException(e, new Message(e.getMessage()));
		//		}
		catch(Exception e) {
			log.error("Errore Exception",e);
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} finally {
			log.debug("[ServiziMgr::mtomDownloadFile] END");
		}
	}

	public File getFileXsd()
	{
		
		String schemasDir = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
		String distributoreSchema = schemasDir + "Import-Utenze-Distributori-1.0.0.xsd";
		
		String PREFIX = "Distributori";
	    String SUFFIX = ".xsd";
	    File tempFile = null;
	    try 
        {
		    tempFile = File.createTempFile(PREFIX, SUFFIX);
	        tempFile.deleteOnExit();
	        
        	FileOutputStream out;
			
				out = new FileOutputStream(tempFile);
			
            IOUtils.copy(GenericUtil.getFileInClassPath(distributoreSchema), out);
            
        }
        catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }

	    return tempFile;
        
	}
	
	// Questa classe e' da portare nel validationMgr
	public void validazioneXmlImportDistributore(InputStream in) throws ValidationManagerException
	{
		log.debug("[ServiziMgr::validazioneXmlImportDistributore] START");

		try
		{
			String schemasDir = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
			String distributoreSchema = schemasDir + "Import-Utenze-Distributori-1.0.0.xsd";


			InputStreamReader xmlSchemaReader = null;
//			InputStreamReader xmlReader = new InputStreamReader(in);


			log.debug("lettura xml dell'import distributori");

			log.debug("[SigitbatchMgr::validazioneXmlImportDistributore] - verifica struttura - prima");
			xmlSchemaReader = new InputStreamReader(GenericUtil.getFileInClassPath(distributoreSchema));
			XmlValidator.validate(in, xmlSchemaReader);
			log.debug("[SigitbatchMgr::validazioneXmlImportDistributore] - verifica struttura - dopo");

		}
		
		catch (XmlValidatorException e) {
			log.debug("errore validazione xml", e);
			throw new ValidationManagerException(new Message(Messages.ERROR_VALIDAZIONE_XML));
		} 

		finally
		{
			log.debug("[ServiziMgr::validazioneXmlImportDistributore] END");
		}

		// DA TOGLIERE
		//throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
	}
	
	/*
	public byte[] mtomDownloadFileNew(String uidImportDistrib)throws ServiceException{
		log.debug("[ServiziMgr::mtomDownloadFile] BEGIN");
        try{
//            StringBuilder luceneQuery = new StringBuilder();
//
//            luceneQuery.append("@sipra\\:idAllegato:\"");
//            luceneQuery.append(uidImportDistrib);
//            luceneQuery.append("\"");
//
//            SearchParams params = new SearchParams();
//            params.setLimit(0);
//            params.setLuceneQuery(luceneQuery.toString());
//
//            OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
//
//            SearchResponse response = getIndexSearch().luceneSearch(params, oc);
//            ResultContent[] results = response.getResultContentArray();
//
//            String uid = results[0].getUid();

        	
        	log.debug("@@@@@@ CXF: "+cxf);
        	Attachment indeFile = cxf.downloadMethod(new MtomNode(uidImportDistrib, Constants.INDEX_PREFIX_NAME), mtomGetOperationContext());
        	//return IOUtils.toByteArray(indeFile.attachmentDataHandler.getInputStream());
        	
        	System.out.println("Prima della creazione dell'input stream");
        	InputStream in = indeFile.attachmentDataHandler.getInputStream();
        	
        	// http://www.informit.com/articles/article.aspx?p=30609&seqNum=7
        	// http://dom4j.sourceforge.net/dom4j-1.6.1/guide.html
        	
//        	BufferedReader br = new BufferedReader(new InputStreamReader(in,
//        			"utf8"), 8192);
        	
//        	BufferedReader br = new BufferedReader(new InputStreamReader(in,
//        			"utf8"));
        	
        	System.out.println("Dopo la creazione dell'input stream");
        	
            SAXReader reader = new SAXReader();
            
            System.out.println("Ho creato il SAXReader");
            
            Document response = reader.read(in);
            
            System.out.println("Ho creato il Document");
            
            in.close();
            
            //connection.disconnect();
        	
            
            
            org.dom4j.Element root = response.getRootElement();

            int count = 0;
            // iterate through child elements of root
            for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                // do something
                
                count++;
            }
            System.out.println("STAMPO GLI element: "+count);
            
            // Use XPath to find the element we want
//            org.dom4j.Node node = response.selectSingleNode("/methodResponse/params/param/value/double");
//
//            String result = node.getStringValue();
//            System.out.println(result);

            
            return null;
			
        } catch(Exception e) {
        	log.error("Errore getRicevutaAllegato",e);
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
        } finally {
        	log.debug("[ServiziMgr::mtomDownloadFile] END");
        }
    }
	*/
	
	/*
	public byte[] mtomDownloadFileNew2(String uidImportDistrib)throws ServiceException{
		log.debug("[ServiziMgr::mtomDownloadFile] BEGIN");
        try{
//            StringBuilder luceneQuery = new StringBuilder();
//
//            luceneQuery.append("@sipra\\:idAllegato:\"");
//            luceneQuery.append(uidImportDistrib);
//            luceneQuery.append("\"");
//
//            SearchParams params = new SearchParams();
//            params.setLimit(0);
//            params.setLuceneQuery(luceneQuery.toString());
//
//            OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
//
//            SearchResponse response = getIndexSearch().luceneSearch(params, oc);
//            ResultContent[] results = response.getResultContentArray();
//
//            String uid = results[0].getUid();

        	
        	log.debug("@@@@@@ CXF: "+cxf);
        	Attachment indeFile = cxf.downloadMethod(new MtomNode(uidImportDistrib, Constants.INDEX_PREFIX_NAME), mtomGetOperationContext());
        	//return IOUtils.toByteArray(indeFile.attachmentDataHandler.getInputStream());
        	
        	System.out.println("Prima della creazione dell'input stream");
        	InputStream in = indeFile.attachmentDataHandler.getInputStream();
        	
        	System.out.println("Scrivo il file - prima");
        	writeDataToFile(in);
        	System.out.println("Scrivo il file - dopo");
        	
        	// http://www.informit.com/articles/article.aspx?p=30609&seqNum=7
        	// http://dom4j.sourceforge.net/dom4j-1.6.1/guide.html
        	
//        	BufferedReader br = new BufferedReader(new InputStreamReader(in,
//        			"utf8"), 8192);
        	
//        	BufferedReader br = new BufferedReader(new InputStreamReader(in,
//        			"utf8"));
        	
        	System.out.println("Dopo la creazione dell'input stream");
        	
            SAXReader reader = new SAXReader();
            
            System.out.println("Ho creato il SAXReader");
            
            Document response = reader.read("/home/apps/jbcp09/dev-jboss43cp09-008/deploy/sigitbatchn/xml/test.xml");
            
            System.out.println("Ho creato il Document");
            
            in.close();
            
            //connection.disconnect();
        	
            
            
            org.dom4j.Element root = response.getRootElement();

            int count = 0;
            // iterate through child elements of root
            for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                // do something
                
                count++;
            }
            System.out.println("STAMPO GLI element: "+count);
            
            // Use XPath to find the element we want
//            org.dom4j.Node node = response.selectSingleNode("/methodResponse/params/param/value/double");
//
//            String result = node.getStringValue();
//            System.out.println(result);

            
            return null;
			
        } catch(Exception e) {
        	log.error("Errore getRicevutaAllegato",e);
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
        } finally {
        	log.debug("[ServiziMgr::mtomDownloadFile] END");
        }
    }
    */
	
	/*
	public byte[] mtomDownloadFileNew3(String uidImportDistrib)throws ServiceException{
		log.debug("[ServiziMgr::mtomDownloadFileNew3] BEGIN");
        try{
       	log.debug("@@@@@@ CXF: "+cxf);
        	
       	// FUNZIONA
       	
       	Attachment indeFile = cxf.downloadMethod(new MtomNode(uidImportDistrib, Constants.INDEX_PREFIX_NAME), mtomGetOperationContext());
        	//return IOUtils.toByteArray(indeFile.attachmentDataHandler.getInputStream());
        	
        	System.out.println("Prima della creazione dell'input stream");
        	InputStream in = indeFile.attachmentDataHandler.getInputStream();
        	
        	System.out.println("Scrivo il file - prima");
        	writeDataToFile(in);
        	System.out.println("Scrivo il file - dopo");
        	
        	SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        	 
            DefaultHandler handler = new MyHandler();
     
            InputStream ism = new FileInputStream("/home/apps/jbcp09/dev-jboss43cp09-008/deploy/sigitbatchn/xml/test.xml");
            
            parser.parse(ism, handler);
            
        	
            
            return null;
			
        } catch(Exception e) {
        	log.error("Errore mtomDownloadFileNew3",e);
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
        } finally {
        	log.debug("[ServiziMgr::mtomDownloadFileNew3] END");
        }
    }
	*/
	
	/*
	public byte[] mtomDownloadFileNew4(String uidImportDistrib)throws ServiceException{
		log.debug("[ServiziMgr::mtomDownloadFileNew4] BEGIN");
        try{
       	log.debug("@@@@@@ CXF: "+cxf);
        	
       	// FUNZIONA
       	
       	Attachment indeFile = cxf.downloadMethod(new MtomNode(uidImportDistrib, Constants.INDEX_PREFIX_NAME), mtomGetOperationContext());
        	//return IOUtils.toByteArray(indeFile.attachmentDataHandler.getInputStream());
        	
        	System.out.println("Prima della creazione dell'input stream");
        	InputStream in = indeFile.attachmentDataHandler.getInputStream();
        	
        	System.out.println("Scrivo il file - prima New4");
        	//writeDataToFile(in);
        	System.out.println("Scrivo il file - dopo New4");
        	
        	
    			final JAXBContext context = JAXBContext.newInstance(UTENZEDISTComunicazione.class);
    		    final Unmarshaller um = context.createUnmarshaller();
    		    //Reader reader = null;
    		    InputStream ism = null;
    		    try {
    		        //reader = new BufferedReader(new FileReader("C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 3\\2015_esempio XML 1.0.0_3.1.xml"));
    		    	//reader = new BufferedReader(new FileReader("C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 2\\2015_esempio XML 1.0.0_tc.1_BIG.xml"));
    	            //ism = new FileInputStream("/home/apps/jbcp09/dev-jboss43cp09-008/deploy/sigitbatchn/xml/test.xml");

    		    	final QName qName = new QName("datiFornituraCliente");
    		        final XMLInputFactory xif = XMLInputFactory.newInstance();
    		        final XMLEventReader xmlEventReader = xif.createXMLEventReader(in);
    		        final UTENZEDISTComunicazione example =
    		                (UTENZEDISTComunicazione) um.unmarshal(new PartialXmlEventReader(xmlEventReader, qName));
    		        
    		        System.out.println("Stampo example: "+example.getDatiFornituraCliente().size());
    		        
    		        
    		    } finally {
    		        IOUtils.closeQuietly(in);
    		    }
    	        
    		
        	
            
            return null;
			
        } catch(Exception e) {
        	log.error("Errore mtomDownloadFileNew4",e);
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
        } finally {
        	log.debug("[ServiziMgr::mtomDownloadFileNew3] END");
        }
    }
	*/
	
	/*
	public byte[] mtomDownloadFileNewVTD(String uidImportDistrib)throws ServiceException{
		log.debug("[ServiziMgr::mtomDownloadFileNewVTD] BEGIN");
        try{
//            StringBuilder luceneQuery = new StringBuilder();
//
//            luceneQuery.append("@sipra\\:idAllegato:\"");
//            luceneQuery.append(uidImportDistrib);
//            luceneQuery.append("\"");
//
//            SearchParams params = new SearchParams();
//            params.setLimit(0);
//            params.setLuceneQuery(luceneQuery.toString());
//
//            OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
//
//            SearchResponse response = getIndexSearch().luceneSearch(params, oc);
//            ResultContent[] results = response.getResultContentArray();
//
//            String uid = results[0].getUid();

        	
        	log.debug("@@@@@@ CXF: "+cxf);
        	Attachment indeFile = cxf.downloadMethod(new MtomNode(uidImportDistrib, Constants.INDEX_PREFIX_NAME), mtomGetOperationContext());
        	//return IOUtils.toByteArray(indeFile.attachmentDataHandler.getInputStream());
        	
        	System.out.println("Prima della creazione dell'input stream");
        	InputStream in = indeFile.attachmentDataHandler.getInputStream();
        	
        	System.out.println("Scrivo il file - prima");
        	writeDataToFile(in);
        	System.out.println("Scrivo il file - dopo");
        	
        	System.out.println("Prima di prova 2");
        	prova2();
        	System.out.println("DOPO di prova 2");
        	
//        	File targetFile = new File("");
//        	OutputStream outStream = new FileOutputStream(targetFile);
//        	outStream.write(buffer);
//        	
//        	File targetFile = new File("src/main/resources/targetFile.tmp");
//        	����OutputStream outStream = new FileOutputStream(targetFile);
//        	����outStream.write(buffer);
        	
        	
        	
        	
        	System.out.println("CREO VTDGen");
    		VTDGen vg = new VTDGen();
    		
        	System.out.println("CREO VTDNav - prima");

        	
        	//VTDNav vn = vg.loadIndex(in);
        	
        	System.out.println("CREO VTDNav - dopo");
        	
        	
        	
        	
        	
//    		if (vg.parseFile("/home/apps/jbcp09/dev-jboss43cp09-008/deploy/sigitbatchn/xml/test.xml",true)){
//
//    			VTDNav vn = vg.getNav();
//    			
//    			System.out.println("VTDNav.FIRST_CHILD: "+VTDNav.FIRST_CHILD);
//    			System.out.println("STAMPO 1: "+vn.toElement(VTDNav.FIRST_CHILD));
//            	System.out.println("STAMPO 2: "+vn.toElement(VTDNav.FIRST_CHILD, "datiFornituraCliente"));
//            	System.out.println("STAMPO 3: "+vn.toElementNS(VTDNav.FIRST_CHILD,null, "datiFornituraCliente"));
//    			System.out.println("STAMPO 1.1: "+vn.toElement(VTDNav.FIRST_CHILD));
//
//    			
//    			System.out.println("vn.getAttrCount(): "+vn.getAttrCount());
//    			System.out.println("vn.datiFornituraCliente: "+vn.getAttrVal("datiFornituraCliente"));
//    			
//                if (vn.matchElement("UTENZEDIST_Comunicazione")){ // match blix
//                }
//                else
//                {
//                	System.out.println("Non e' presente UTENZEDIST_Comunicazione");
//                }
//
//            	
//            	//toElementNS is the namespace aware version of toElement which navigates the cursor
//    			if (vn.toElement(VTDNav.FIRST_CHILD)){
//    				int i= vn.getText(); // get the VTD record index
//    				
//    				System.out.println("vn.getText(): "+vn.getText());
//    				System.out.println("vn.toString(i): "+vn.toString(i));
//    				
//    				if (i!=-1){
//    					// convert i into string before printing, 
//    					// toNormalizedString(i) and toRawString(i) are two other options
//    					System.out.println("the text node value at "+i+" ==> "+vn.toString(i));
//    				}
//    			}
//            	
//    			
//    		}
			
			
            return null;
			
        } catch(Exception e) {
        	log.error("Errore mtomDownloadFileNewVTD",e);
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
        } finally {
        	log.debug("[ServiziMgr::mtomDownloadFileNewVTD] END");
        }
    }
	*/
	/*
	private void prova2()
	{
		VTDGen vg = new VTDGen();
        AutoPilot ap = new AutoPilot();
        int i;
        try {
			//ap.selectXPath("/UTENZEDIST_Comunicazione/datiFornituraCliente/datiCliente/pfPg/text()");
        	ap.selectXPath("/UTENZEDIST_Comunicazione/datiFornituraCliente");
		
	        if (vg.parseFile("/home/apps/jbcp09/dev-jboss43cp09-008/deploy/sigitbatchn/xml/test.xml", false))
	        {
	            VTDNav vn = vg.getNav();
	            ap.bind(vn);
	            //XPath eval returns one node at a time
	            
	            int count = 0;
	            while ((i = ap.evalXPath()) != -1)
	            {
	                //System.out.println(" text ==> " +vn.toString(i));
	            	count++;
	            }
	            ap.resetXPath();
	            
	            System.out.println("Stampo il count: "+count);
	        }
        } 
         catch (XPathParseException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        } catch (XPathEvalException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        } catch (NavException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
	}
	*/
	
	private void writeDataToFile(InputStream inputStream) { 
	    OutputStream os = null;
	    //InputStream inputStream = null;

	    try {

	        //inputStream = stub.getStream();
	        os = new FileOutputStream("/home/apps/jbcp09/dev-jboss43cp09-008/deploy/sigitbatchn/xml/test.xml");
	        int read = 0;
	        byte[] bytes = new byte[1024];

	        while ((read = inputStream.read(bytes)) != -1) {
	            os.write(bytes, 0, read);
	        }

	    } catch (Exception e) {

	    	log.error("Error while fetching data", e);

	    } finally {
	        if(inputStream != null) {
	            try {
	                inputStream.close();
	            } catch (IOException e) {
	            	log.error("Error while closing input stream", e);
	            }
	        }
	        if(os != null) {
	            try {
	                os.close();
	            } catch (IOException e) {
	            	log.error("Error while closing output stream", e);
	            }
	        }
	    }
	 }
}