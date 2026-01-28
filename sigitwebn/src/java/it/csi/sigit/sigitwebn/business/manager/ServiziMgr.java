/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;

import it.doqui.index.ecmengine.client.webservices.dto.engine.security.EnvelopedContent;
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.ext.multipart.InputStreamDataSource;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

//import it.csi.catdig.system.AllegatoDocument;
//import it.csi.catdig.system.AllegatoDocument;
import it.csi.aaep.aaeporch.business.CSIException_Exception;
import it.csi.aaep.aaeporch.business.ImpresaINFOC;
import it.csi.aaep.aaeporch.business.Persona;
import it.csi.aaep.aaeporch.business.PersonaINFOC;
import it.csi.aaep.aaeporch.business.Sede;
import it.csi.aaep.aaeporch.business.SedeINFOC;
import it.csi.aaep.aaeporch.business.TipologiaFonte;
import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.csi.wrapper.CSIException;
import it.csi.sigit.sigitext.dto.sigitext.Documento;
import it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
//import it.csi.modolxp.modolxpsrv.dto.Applicazione;
//import it.csi.modolxp.modolxpsrv.dto.Modulo;
//import it.csi.modolxp.modolxpsrv.dto.ProcessFormRequest;
//import it.csi.modolxp.modolxpsrv.dto.ProcessFormResponse;
//import it.csi.modolxp.modolxpsrv.dto.Utente;
//import it.csi.modolxp.modolxpsrv.dto.XmlModel;
//import it.csi.modolxp.modolxpsrv.dto.criteri.CriterioRicercaModulo;
//import it.csi.modolxp.modolxpsrv.dto.utility.RendererModalityExpert;
//import it.csi.modolxp.modolxpsrv.exception.ModolsrvException;
//import it.csi.modolxp.modolxppdfgensrv.business.session.facade.ModolPdfGeneratorSrvFacade;
//import it.csi.modolxp.modolxppdfgensrv.dto.pdfa.PdfAInputRequest;
//import it.csi.modolxp.modolxppdfgensrv.dto.pdfstatic.PdfStaticInputRequest;
//import it.csi.modolxp.modolxpsrv.business.session.facade.ModolSrvFacade;
import it.csi.sigit.sigitext.interfacecsi.sigitext.SigitextSrv;
import it.csi.sigit.sigitwebn.business.BEException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDFluidoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllTxtDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAggiuntivaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImportDistribRicevutaByIdImportDistribDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTLibTxtDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTLibrettoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTTrattH2ODto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTTrattH2OPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicerca3ResponsabileDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4CgDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4GfDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4GtDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4ScDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportFileSuper;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.ws.service.svista.client.Comune;
import it.csi.sigit.sigitwebn.business.ws.service.svista.client.LimammEnteServiceLocator;
import it.csi.sigit.sigitwebn.business.ws.service.svista.client.LimammEnte_PortType;
import it.csi.sigit.sigitwebn.business.ws.service.svista.client.Provincia;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaFisica;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica;
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;
import it.csi.sigit.sigitwebn.dto.common.CodeDescription;
import it.csi.sigit.sigitwebn.dto.impianto.Impianto;
import it.csi.sigit.sigitwebn.dto.impresa.LabelValue;
import it.csi.sigit.sigitwebn.dto.index.DettaglioAllegatoIndex;
import it.csi.sigit.sigitwebn.dto.index.DettaglioDocumento;
import it.csi.sigit.sigitwebn.dto.index.DettaglioDocumentoIndex;
import it.csi.sigit.sigitwebn.dto.index.DettaglioDocumentoMultiplo;
import it.csi.sigit.sigitwebn.dto.index.Metadati;
import it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione;
import it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.JWTDto;
import it.csi.sigit.sigitwebn.util.JWTUtil;
import it.csi.sigit.sigitwebn.util.MapDto;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.XmlBeanUtils;
import it.csi.sigit.sigitwebn.util.mail.Allegato;
import it.csi.sigit.sigitwebn.util.mail.Mail;
import it.csi.sigit.sigitwebn.util.mail.MailSender;
import it.csi.sigit.sigitwebn.util.mail.ResultInvioMail;
import it.csi.sigit.sigitwebn.xml.allegato2.data.DatiIntestazioneDocument.DatiIntestazione;
import it.csi.sigit.sigitwebn.xml.allegato2.data.DatiModuloDocument.DatiModulo;
import it.csi.sigit.sigitwebn.xml.allegato2.data.RowAllegatoIIDocument.RowAllegatoII;
import it.csi.sigit.sigitwebn.xml.allegato2.data.RowFumiDocument.RowFumi;
import it.csi.sigit.sigitwebn.xml.allegato2.data.TrattamentoAcquaDocument.TrattamentoAcqua;
import it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII;
import it.csi.sigit.sigitwebn.xml.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV;
import it.csi.sigit.sigitwebn.xml.allegato5.data.RowAllegatoVDocument.RowAllegatoV;
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
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiPrecompilatiDocument.DatiPrecompilati;
import it.csi.sigit.sigitwebn.xml.libretto.data.MODDocument;
import it.csi.sigit.sigitwebn.xml.libretto.data.RichiestaDocument.Richiesta;
import it.csi.sitad.tope.exception.TopeNoDataExtractedException;
import it.csi.sitad.tpnm.entity.Via;
import it.csi.sitad.tpnm.interf.ToponomasticaInterface;
import it.csi.wso2.apiman.oauth2.helper.GenericWrapperFactoryBean;
import it.csi.wso2.apiman.oauth2.helper.OauthHelper;
import it.csi.wso2.apiman.oauth2.helper.TokenRetryManager;
import it.csi.wso2.apiman.oauth2.helper.WsProvider;
import it.csi.wso2.apiman.oauth2.helper.extra.axis1.Axis1Impl;
import it.doqui.index.ecmengine.client.webservices.dto.Node;
import it.doqui.index.ecmengine.client.webservices.dto.OperationContext;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Content;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.FileFormatInfo;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.FileInfo;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Mimetype;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Property;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.NodeResponse;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.ResultContent;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.SearchParams;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.SearchResponse;

//it.doqui.index.ecmengine.client.mtom.EcmEngineMtomDelegateImpl

//import it.doqui.index.ecmengine.interfacecsi.search.EcmEngineSearchInterface;



import it.doqui.index.ecmengine.mtom.dto.Attachment;
import it.doqui.index.ecmengine.mtom.dto.MtomNode;
import it.doqui.index.ecmengine.mtom.dto.MtomOperationContext;

//itext 5.5.0 - non si puo' usare
//import com.itextpdf.text.Document;
//import com.itextpdf.text.pdf.PdfContentByte;
//import com.itextpdf.text.pdf.PdfImportedPage;
//import com.itextpdf.text.pdf.PdfReader;
//import com.itextpdf.text.pdf.PdfWriter;



public class ServiziMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business.manager");
	
	private final String TOPE_RESOURCE = "/META-INF/pd_topesv_Topo.xml";
	private final String PROPERTIES_RESOURCE = "/META-INF/sigitwebn.properties";
	//private final String MODOL_RESOURCE = "/META-INF/defpd_modolsrv.xml";
	//private final String MODOL_PDF_RESOURCE = "/META-INF/defpd_modolpdfgeneratorsrv.xml";

	private final String SIGITEXT_RESOURCE = "/META-INF/defpd_sigitext.xml";
//	private final String MDP_RESOURCE = "/META-INF/defpd_mdpnew.xml";

	private String tokenOauthLoccsi;
	
	/**
	 * Manager del DB
	 */
	protected DbMgr dbMgr;
	
	private static OauthHelper oauthHelper = null;

	protected LimammEnte_PortType getSvista() {
		
		String limammURL = getProperties().getProperty(Constants.SVISTA_WSDL_URL);
		String oauthURL = getProperties().getProperty(Constants.APIMAN_TOKEN_URL);
		String consumerKey = getProperties().getProperty(Constants.APIMAN_TOKEN_CONSUMERKEY);
		String consumerSecret = getProperties().getProperty(Constants.APIMAN_TOKEN_CONSUMERSECRET);	
		int timeout = Constants.APIMAN_TIMEOUT;
		
//		String limammURL = SRV_URL;
//		String oauthURL = TOKEN_URL;
//		String consumerKey = CONSUMER_KEY;
//		String consumerSecret = CONSUMER_SECRET;
		
//		log.info("oauthURL: " + oauthURL);
//		log.info("consumerKey: " + consumerKey);
//		log.info("consumerSecret: " + consumerSecret);

		LimammEnte_PortType limAmmEnte = null;

		try {
			
			LimammEnteServiceLocator serviceLoc = new LimammEnteServiceLocator();
			serviceLoc.setlimammEnteEndpointAddress(limammURL);
			LimammEnte_PortType port = serviceLoc.getlimammEnte();

			TokenRetryManager trm = new TokenRetryManager();
			trm.setOauthHelper(getOauthHelper(oauthURL, consumerKey, consumerSecret, timeout));
			
			WsProvider wsp = new Axis1Impl();
			trm.setWsProvider(wsp);
			GenericWrapperFactoryBean gwfb = new GenericWrapperFactoryBean();
			gwfb.setEndPoint(limammURL);
			gwfb.setWrappedClass(LimammEnte_PortType.class.getCanonicalName());
			gwfb.setTokenRetryManager(trm);
			gwfb.setPort(port);
			
			limAmmEnte = (LimammEnte_PortType) gwfb.create();

		
		} catch (javax.xml.rpc.ServiceException | ClassNotFoundException e) {
			log.error("Errore SVISTA getSvita", e);
		}
		
		return limAmmEnte;
	}

	private static OauthHelper getOauthHelper(String oauthURL, String consumerKey, String consumerSecret, int timeout) {
		if (oauthHelper == null) {
			oauthHelper = new OauthHelper(
					oauthURL,
					consumerKey,
					consumerSecret, 
					timeout);
		}
		
		System.out.println("oauthHelper: "+oauthHelper.getToken());
		
		return oauthHelper;
	}

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

	protected SigitExtMgr sigitExtMgr;

	public SigitExtMgr getSigitExtMgr() {
		return sigitExtMgr;
	}

	public void setSigitExtMgr(SigitExtMgr sigitExtMgr) {
		this.sigitExtMgr = sigitExtMgr;
	}

	// Mtom
	private MtomServiceImp cxf;

	public MtomServiceImp getCxf() {

		return cxf;
	}

	public void setCxf(MtomServiceImp cxf) {
		this.cxf = cxf;
	}

	private IndexServiceImp serviceIndex;
	
	public IndexServiceImp getServiceIndex() {
		return serviceIndex;
	}

	public void setServiceIndex(IndexServiceImp serviceIndex) {
		this.serviceIndex = serviceIndex;
	}

	private ModolXPServiceImp serviceModolXP;
	
	public ModolXPServiceImp getServiceModolXP() {
		return serviceModolXP;
	}

	public void setServiceModolXP(ModolXPServiceImp serviceModolXP) {
		this.serviceModolXP = serviceModolXP;
	}
	
	private ModolXPPdfServiceImp serviceModolXPPdf;
	
	public ModolXPPdfServiceImp getServiceModolXPPdf() {
		return serviceModolXPPdf;
	}

	public void setServiceModolXPPdf(ModolXPPdfServiceImp serviceModolXPPdf) {
		this.serviceModolXPPdf = serviceModolXPPdf;
	}
	
	// SIGITEXT
	/*
	private it.csi.sigit.sigitext.stubs.SigitextSigitextService serviceSigitExt;

	public it.csi.sigit.sigitext.stubs.SigitextSigitextService getServiceSigitExt() {
		return serviceSigitExt;
	}

	public void setServiceSigitExt(it.csi.sigit.sigitext.stubs.SigitextSigitextService serviceAaep) {
		this.serviceSigitExt = serviceSigitExt;
	}
	*/
		
	// AAEP
	private AaepServiceImp serviceAaep;
	
	public AaepServiceImp getServiceAaep() {
		return serviceAaep;
	}

	public void setServiceAaep(AaepServiceImp serviceAaep) {
		this.serviceAaep = serviceAaep;
	}
	
	/*
	public ArrayList<LabelValue> cercaElencoRegioniTSTWS() throws ServiceException{
		log.debug("[ServiziMgr::cercaElencoRegioniTSTWS] BEGIN");
        
		ArrayList<LabelValue> labelValueList = null;
		try{
			it.csi.sigit.sigitext.stubs.SigitextSigitextServiceLocator prova =  new it.csi.sigit.sigitext.stubs.SigitextSigitextServiceLocator();

			System.out.println("getsigitextSigitextAddress: "+prova.getsigitextSigitextAddress());


			prova.setsigitextSigitextEndpointAddress("http://www.sistemapiemonte.it/sigitextApplSigitextWsfad/services/sigitextSigitext");

			it.csi.sigit.sigitext.stubs.SigitextSigitextSoapBindingStub binding = (it.csi.sigit.sigitext.stubs.SigitextSigitextSoapBindingStub) prova.getsigitextSigitext();

			System.out.println("getsigitextSigitextAddress: "+prova.getsigitextSigitextAddress());

			it.csi.sigit.sigitext.stubs.CodiceDescrizione[] value = null;
			value = binding.getTipo();

			System.out.println("Stampa value: "+value);

			GenericUtil.stampa(value, true, 3);


		}
        catch(Exception e){
        	log.error("Errore cercaElencoRegioniTSTWS",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			
//        	Message message = msgMgr.getMessage(MsgCodeEnum.G002);
//            message.replacePlaceholder(Constants.ERR_MTOM);
//            throw new ServiceException(e, message);
        }
        log.debug("[ServiziMgr::cercaElencoRegioniTSTWS] END");
    	return labelValueList;
    }
	*/
	
	public ArrayList<LabelValue> cercaImpresaAaep(String codFiscale) throws ServiceException{
		log.debug("[ServiziMgr::cercaImpresaAaep] BEGIN");
        
		ArrayList<LabelValue> labelValueList = null;
		try{
        	//javax/xml/ws/Service
//        	URL url = new URL("http://tst-applogic.reteunitaria.piemonte.it/aaeporch/OrchestratoreService?wsdl");
//        	setServiceAaep(new OrchestratoreImplService(url));
//        	
			//EcmEngineMtomDelegateImpl cip = new EcmEngineMtomDelegateImpl(arg0) 
			/*
			EcmEngineMtomDelegateImpl prova = getCxf();
			//EcmEngineWebServiceDelegate xx = new EcmEngineWebServiceDelegate();
			
			EcmEngineMtomDelegateImpl prova = new EcmEngineMtomDelegateImpl("");
			EcmEngine
			EcmEngineWebServiceDelegateServiceLocator ecmengineLocator = new EcmEngineWebServiceDelegateServiceLocator();
			EcmEngineWebServiceDelegate ecmengineDelegate = ecmengineLocator.getEcmEngineManagement(new URL(""));
			//ecmengineDelegate.g
			EcmEngineWebServiceDelegate cc = new 
        	*/
			
			it.csi.aaep.aaeporch.business.Utente utente = new it.csi.aaep.aaeporch.business.Utente();
        	utente.setCodiceFiscaleUtente(codFiscale);
        	ImpresaINFOC impresa = null;
        	try
        	{
        		impresa = (ImpresaINFOC)getServiceAaep().getEcmengineDelegate().getDettaglioImpresa(utente, Constants.CODICE_FONTE_AAEP, codFiscale);
        	}
        	catch (CSIException_Exception e)
        	{
        		
        		if (e.getMessage().contains(Constants.AAEP_COD_NESSUN_RISULTATO))
        		{
        			// Impresa non trovata su AAEP
        			return null;
        		}
        		else
        		{
        			throw e;
        		}
        		
        	}
        	
        	labelValueList = MapDto.mapDatiAnagraficiAaep(impresa);
        	
        	SedeINFOC sedeINFOC = null;
        	
    		labelValueList.add(MapDto.getLabelValue(" ", " "));
    		labelValueList.add(MapDto.getLabelValue("<b>ELENCO SEDI</b>", null));

        	for (Sede sede : impresa.getSedi()) {
    			
        		sedeINFOC = (SedeINFOC)getServiceAaep().getEcmengineDelegate().getDettaglioSede(utente, TipologiaFonte.INFOC, sede);
        		
        		MapDto.mapDatiSedeAaep(labelValueList, sedeINFOC);
    		}
        	
        	PersonaINFOC personaINFOC = null;
        	labelValueList.add(MapDto.getLabelValue(" ", " "));
    		labelValueList.add(MapDto.getLabelValue("<b>SOCI E TITOLARI DI CARICHE O QUALIFICHE</b>", null));
        	for (Persona persona : impresa.getListaPersone()) {
    			
        		personaINFOC = (PersonaINFOC)getServiceAaep().getEcmengineDelegate().getDettaglioPersonaInfoc(utente, persona);
        		
        		MapDto.mapDatiPersonaAaep(labelValueList, personaINFOC);
    		}
        	
    		labelValueList.add(MapDto.getLabelValue("<b>AGGIORNAMENTO DATI</b>", null));
    		labelValueList.add(MapDto.getLabelValue("Data aggiornamento INFOC", GenericUtil.getStringValid(impresa.getDataAggiornamento())));
        	
        	//GenericUtil.stampa(impresa, true, 3);
            
        }
        catch(Exception e){
        	log.error("Errore cercaImpresaAaep",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			
//        	Message message = msgMgr.getMessage(MsgCodeEnum.G002);
//            message.replacePlaceholder(Constants.ERR_MTOM);
//            throw new ServiceException(e, message);
        }
        log.debug("[ServiziMgr::aaepCercaImpresa] END");
    	return labelValueList;
    }
	
	protected ToponomasticaInterface getToponomastica() {
		log.debug("[ServiziMgr::getToponomastica] BEGIN");
		InputStream is = getClass().getResourceAsStream(TOPE_RESOURCE);
		if (is != null) {
			try {
				InfoPortaDelegata info = PDConfigReader.read(is);
				return (ToponomasticaInterface) PDProxy.newInstance(info);
			} 
			catch (Exception e) {
				log.error("[ServiziMgr::getToponomastica] errore nella parsificazione della configurazione di TOPE:"+ e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione di TOPE");
			}
		} else{
			log.error("[ServiziMgr::getToponomastica] configurazione di TOPE non trovata");
		}
		throw new IllegalArgumentException("configurazione di TOPE non trovata");
	}
	
	protected SigitextSrv getSigitExt() {
		log.debug("[ServiziMgr::getSigitExt] BEGIN");
		InputStream is = getClass().getResourceAsStream(SIGITEXT_RESOURCE);
		if(is != null){
			try{
				InfoPortaDelegata info = PDConfigReader.read(is);
				return(SigitextSrv) PDProxy.newInstance(info);
			}
			 catch (Exception e) {
				log.error("[ServiziMgr::getSigitExt] errore nella parsificazione della configurazione di SIGITEXT:"+ e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione di SIGITEXT");
			}
			 finally{
				 log.debug("[ServiziMgr::getSigitExt] END");
			 }
		} 
		else {
			log	.error("[ServiziMgr::getSigitExt] configurazione di SIGITEXT non trovata");
		}
		throw new IllegalArgumentException(	"configurazione di SIGITEXT non trovata");
	}

	
	/*
	protected IMdpCoreCsi getMDP() {
		log.debug("[ServiziMgr::getMDP] BEGIN");
		InputStream is = getClass().getResourceAsStream(MDP_RESOURCE);
		if (is != null) {
			try {
				InfoPortaDelegata info = PDConfigReader.read(is);
				return (it.csi.mdp.core.interfacecsi.IMdpCoreCsi) PDProxy.newInstance(info);
			} 
			catch (Exception e) {
				log.error("[ServiziMgr::getMDP] errore nella parsificazione della configurazione di MDP:"+ e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione di MDP");
			}
		} else{
			log.error("[ServiziMgr::getMDP] configurazione di MDP non trovata");
		}
		throw new IllegalArgumentException("configurazione di MDP non trovata");
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
	
	public void test(){
		log.debug("ServiziMgr RAGGIUNTO CORRETTAMENTE");
	}
	
	public ArrayList<CodeDescription> getListaProvince() throws ServiceException{
		log.debug("[ServiziMgr::getListaProvince] BEGIN");
		try{
			Provincia[] provRegione = getSvista().cercaTutteLeProvince();
			return MapDto.mapSiglaProvince(provRegione);
		}
		catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[ServiziMgr::getListaProvince] END");
		}
	}
	
	public ArrayList<CodeDescription> getListaProvinceDesc()throws ServiceException{
		log.debug("[ServiziMgr::getListaProvinceDesc] BEGIN");
		try{
			Provincia[] provRegione = getSvista().cercaTutteLeProvince();
			return MapDto.mapProvince(provRegione);
		}
		catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[ServiziMgr::getListaProvinceDesc] END");
		}
	}
	
	public ArrayList<CodeDescription> getListaProvincePrimaPiemonte() throws ServiceException {
		log.debug("[ServiziMgr::getListaProvincePrimaPiemonte] BEGIN");
		ArrayList<CodeDescription> listaProvincePrimaPiemonte = null;
		ArrayList<CodeDescription> listaProvince = null;
		Hashtable<String, CodeDescription> hashProvincePiemonte = null;
		try {
			
			listaProvince = getListaProvinceDesc();
			listaProvincePrimaPiemonte = getListaProvincePiemonte();
			// Si accodano le province non piemontesi
			hashProvincePiemonte = new Hashtable<String, CodeDescription>();
			for(CodeDescription codeDescription : listaProvincePrimaPiemonte) {
				hashProvincePiemonte.put(codeDescription.getCode(), codeDescription);
			}
			for(CodeDescription codeDescription : listaProvince) {
				if(hashProvincePiemonte.get(codeDescription.getCode()) == null) {
					listaProvincePrimaPiemonte.add(codeDescription);
				}
			}
		}
		catch(Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		log.debug("[ServiziMgr::getListaProvincePrimaPiemonte] END");
		return listaProvincePrimaPiemonte;
	}
	
	public ArrayList<CodeDescription> getListaProvincePiemonte()throws ServiceException{
		log.debug("[ServiziMgr::getSiglaProvincePiemonte] BEGIN");
		try{
			Provincia[] provRegione = getSvista().cercaProvincePerIdRegione(Constants.COD_ID_PIEMONTE);
			return MapDto.mapProvince(provRegione);
		}
		catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[ServiziMgr::getSiglaProvincePiemonte] END");
		}
	}
	
	public ArrayList<CodeDescription> getListaComuniByIstatProvincia(String istatProvincia) throws ServiceException {
		log.debug("[ServiziMgr::getListaComuniByIstatProvincia] BEGIN");
		try{
			Provincia provincia = getProvinciaDaCodiceIstatOrSigla(istatProvincia);
			return MapDto.mapComuni(getSvista().cercaComuniPerIdProvincia(provincia.getId()));
		}
		catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[ServiziMgr::getListaComuniByIstatProvincia] END");
		}
	}
	
	private Provincia getProvinciaBySigla(String siglaProvincia) throws ServiceException {
		
		log.info("getProvinciaBySigla - sigla=" + siglaProvincia);
		Provincia[] provRegione;
		try {
			provRegione = getSvista().cercaTutteLeProvince();
			for (Provincia provincia : provRegione) {
				if (provincia.getSigla() != null && !provincia.getSigla().isEmpty() 
						&& provincia.getSigla().equals(siglaProvincia))
					return provincia;
			}
		} catch (RemoteException e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		throw new ServiceException("getProvinciaBySigla - ERROR: Provincia non trovata");
	}

	public ArrayList<CodeDescription> getListaSiglaProvincePiemonte() throws ServiceException{
		log.debug("[ServiziMgr::getSiglaProvincePiemonte] BEGIN");
		try{
			Provincia[] provRegione = getSvista().cercaProvincePerIdRegione(Constants.COD_ID_PIEMONTE);
			return MapDto.mapSiglaProvince(provRegione);
		}
		catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[ServiziMgr::getSiglaProvincePiemonte] END");
		}
	}

	public ArrayList<CodeDescription> getListaIstatProvincePiemonte() throws ServiceException{
		log.debug("[ServiziMgr::getListaIstatProvincePiemonte] BEGIN");
		try{
			Provincia[] provRegione = getSvista().cercaProvincePerIdRegione(Constants.COD_ID_PIEMONTE);
			return MapDto.mapIstatProvince(provRegione);
		}
		catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[ServiziMgr::getListaIstatProvincePiemonte] END");
		}
	}
	
	public ArrayList<CodeDescription> getListaSiglaProvincePiemonteManipolata() throws ServiceException{
		log.debug("[ServiziMgr::getListaSiglaProvincePiemonteManipolata] BEGIN");
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		try{
			Provincia[] provRegione = getSvista().cercaProvincePerIdRegione(Constants.COD_ID_PIEMONTE);
			ArrayList<CodeDescription> elenco = MapDto.mapSiglaProvince(provRegione);
			//devo aggungere la dicitura RP al primo posto della lista
			//la riscorro e ci aggiungo il valore che manca
			CodeDescription cdRegionePiemonte = new CodeDescription();
			cdRegionePiemonte.setCode(Constants.SIGLA_BOLLINO_RP);
			cdRegionePiemonte.setDescription(Constants.SIGLA_BOLLINO_RP);
			result.add(cdRegionePiemonte);
			for(CodeDescription dto : elenco){
				result.add(dto);
			}
		}
		catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[ServiziMgr::getListaSiglaProvincePiemonteManipolata] END");
		}
		return result;
	}
	
	public Provincia getProvinciaById(long idProvincia) throws ServiceException {
		log.debug("[ServiziMgr::getProvinciaById] BEGIN");
		
		Provincia provincia = null;
		
		try{
			provincia = getSvista().cercaProvinciaPerIdProvincia(idProvincia);
		} catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[ServiziMgr::getProvinciaById] END");
		}
		return provincia;
	}

	public Provincia getProvinciaDaCodiceIstatOrSigla(String codiceIstatProv) throws ServiceException {
		log.debug("[ServiziMgr::getListaSiglaProvincePiemonteManipolata] BEGIN");
		
		Provincia provincia = null;
		
		try{
			provincia = getProvinciaByCodIstatOrSigla(codiceIstatProv);
		} catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[ServiziMgr::getListaSiglaProvincePiemonteManipolata] END");
		}
		return provincia;
	}
	
	private Provincia getProvinciaByCodIstatOrSigla(String codiceIstatProv) throws ServiceException {
		
		log.info("getProvinciaByCodIstatOrSigla - codice: " + codiceIstatProv);
		
		Provincia provincia = null;
		Provincia[] provRegione;
		try {
			if (codiceIstatProv.length() == 3) {
				// Ricerca per codice istat
				provincia = getSvista().cercaProvinciaPerCodiceIstat(codiceIstatProv);
				if (provincia != null) 
					return provincia;
						
			} else if (codiceIstatProv.length() == 2) {
				// ricerca per sigla
				provRegione = getSvista().cercaTutteLeProvince();
				for (Provincia provTmp : provRegione) {
					if (provTmp.getSigla() != null && !provTmp.getSigla().isEmpty() 
							&& provTmp.getSigla().equals(codiceIstatProv))
						return provTmp;
				}
			} else {
				throw new ServiceException("getProvinciaByCodIstatOrSigla - ERROR: codice istat o sigla (" + codiceIstatProv + ") non valide.");
			}
		} catch (RemoteException e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		throw new ServiceException("getProvinciaByCodIstatOrSigla - ERROR: codice istat o sigla (" + codiceIstatProv + ") non valide.");
	}

	public Comune getComuneDaCodiceIstat(String codiceIstatComune) throws ServiceException {
		log.debug("[ServiziMgr::getDescrizioneComuneDaCodiceIstat] BEGIN");
		
		Comune comune = null;
		
		try{
			comune = getSvista().cercaComunePerCodiceIstat(codiceIstatComune);
		} catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[ServiziMgr::getDescrizioneComuneDaCodiceIstat] END");
		}
		return comune;
	}
	
	public ArrayList<CodeDescription> getListaVieValide(String nomeVia, String codIstatComune) throws ServiceException {
		log.debug("[ServiziMgr::getListaVieValide] BEGIN");
		try {
			return topeGetViaByNome(nomeVia, codIstatComune, Constants.COD_STATO_VIA_VALIDA);
		}
		catch(Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally {
			log.debug("[ServiziMgr::getListaVieValide] END");
		}
	}
	
	private ArrayList<CodeDescription> topeGetViaByNome(String ilNomeDellaVia, String codIstat, String codStatoVia) throws ServiceException {
		log.debug("[ServiziMgr::topeGetViaByNome] BEGIN");
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		Via[] leVie = null; 
		try {
			log.debug("---> codIstat *" + codIstat+"*");
			log.debug("---> ilNomeDellaVia *" + ilNomeDellaVia+"*");
			//leVie = getToponomastica().cercaVieByNomeAndIstat(ilNomeDellaVia, new String[]{codIstat}, 4, false, "A",0);
			leVie = getToponomastica().cercaVieByNomeAndIstat(ilNomeDellaVia, new String[]{codIstat}, 4, false, codStatoVia, 0);
			if(leVie!=null){
				log.debug("---> Entro in for ");
				for (int i = 0; i < leVie.length; i++) {
					
					if (log.isDebugEnabled())
					{
						log.debug("####################################");
						log.debug("---> IDL2 via "+leVie[i].getIdL2());
						log.debug("---> Nome via "+leVie[i].getIndirizzo().getNomeVia());
						log.debug("---> Localita via "+leVie[i].getLocalita().getNome());
						
						
						log.debug("---> Localita oggetto "+leVie[i].getLocalita());
						log.debug("---> Localita.getComune() oggetto "+leVie[i].getLocalita().getComune());
						
						log.debug("---> Localita.getComune().getToponimo() oggetto "+leVie[i].getLocalita().getComune().getToponimo());
						
						log.debug("---> Stato via "+leVie[i].getStatoVia());
						log.debug("####################################");
					}
					
					result.add(MapDto.mapToCodeDescription(leVie[i]));
				}
			}
			else{
				log.debug("---> Non Entro in for ");
			}
		
			
		}catch (TopeNoDataExtractedException e) {
			log.info("TopeNoDataExtractedException - Nessun dato restituito");
			return result;
		}  
		catch (RemoteException | CSIException e) {
			e.printStackTrace();
			log.fatal("Si e' verificato un problema in getViaByNome");
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		log.debug("[ServiziMgr::topeGetViaByNome] END");
		return result;
	}
	
	public ResultInvioMail sendMailRespinta(SigitVRicercaAllegatiDto vAllegato, SigitTPersonaGiuridicaDto manutentore, ArrayList<SigitTPersonaFisicaDto> delegati, String emailResponsabile, PersonaGiuridica pg3Resp) throws ServiceException 
	{
		String oggetto = null;
		StringBuffer testoHtml = new StringBuffer();

		String ubicazione = MapDto.getIndirizzoCompleto(vAllegato.getComuneImpianto(), vAllegato.getIndirizzoUnitaImmob(), null, vAllegato.getCivicoUnitaImmob(), vAllegato.getSiglaProvImpianto());
		String codiceBollino = null;
		if(GenericUtil.isNotNullOrEmpty(vAllegato.getFkNumeroBollino()))
		{
			codiceBollino = vAllegato.getFkSiglaBollino() + "-" + vAllegato.getFkNumeroBollino();
		}
		
		oggetto = "CIT - respinta allegato impianto " + vAllegato.getCodiceImpianto();
		
		// Compongo la mail con formato HTML
		testoHtml.append("L'allegato dell'impianto in oggetto e' stato respinto.<BR/><BR/>");
		testoHtml.append("Descrizione impianto<BR/>");

		testoHtml.append("Codice impianto: " + vAllegato.getCodiceImpianto() + "<BR/>");

		testoHtml.append("Localizzazione: " + ubicazione + "<BR/><BR/>");
		testoHtml.append("Descrizione rapporto di controllo<BR/>");
		testoHtml.append("Data controllo: " + ConvertUtil.convertToString(vAllegato.getDataControllo()) + "<BR/>");
		if(GenericUtil.isNotNullOrEmpty(codiceBollino))
		{
			testoHtml.append("Codice bollino: " + codiceBollino + "<BR/>");
		}
		testoHtml.append("Data invio rapporto: " + ConvertUtil.convertToString(vAllegato.getDataInvio()) + "<BR/>");
		testoHtml.append("Data respinta rapporto: " + DateUtil.getDataCorrenteFormat() + "<BR/><BR/><BR/>");
		
		testoHtml.append("Regione Piemonte<BR/><BR/>");
		testoHtml.append("Per qualsiasi approfondimento consultare il portale Sistema Piemonte oppure utilizzare il seguente<BR/>");
		testoHtml.append("link http://www.sistemapiemonte.it/cms/pa/ambiente/servizi/816-catasto-impianti-termici");

		ArrayList<String> destinatariSingoli = new ArrayList<String>();
		if (GenericUtil.isNotNullOrEmpty(manutentore.getEmail()))
		{
			destinatariSingoli.add(manutentore.getEmail());
		}
		
		for (SigitTPersonaFisicaDto delegato : delegati) {
			if (GenericUtil.isNotNullOrEmpty(delegato.getEmail()))
			{
				destinatariSingoli.add(delegato.getEmail());
			}
		}
		
		
		if (GenericUtil.isNotNullOrEmpty(emailResponsabile))
		{
			destinatariSingoli.add(emailResponsabile);
		}
		
		if (pg3Resp != null && GenericUtil.isNotNullOrEmpty(pg3Resp.getEmail()))
		{
			destinatariSingoli.add(pg3Resp.getEmail());
		}
		
		ResultInvioMail resultInvioMail = null;
		
		if (destinatariSingoli != null && !destinatariSingoli.isEmpty())
		{
			resultInvioMail = sendMail(destinatariSingoli, null, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		}
		
		return resultInvioMail;
	}
	
	//public ResultInvioMail sendMailInviata(SigitVRicercaAllegatiDto vAllegato, SigitTPersonaGiuridicaDto manutentore, Responsabile responsabile, PersonaGiuridica terzoResponsabile, ArrayList<Allegato> elencoAllegati) throws ServiceException 
	public ResultInvioMail sendMailInviata(SigitTAllegatoDto vAllegato, SigitVTotImpiantoDto impiantoDto, SigitTPersonaGiuridicaDto manutentore, String emailResponsabile, PersonaGiuridica terzoResponsabile, ArrayList<Allegato> elencoAllegati) throws ServiceException 
	{
		String oggetto = null;
		StringBuffer testoHtml = new StringBuffer();

		String ubicazione = MapDto.getIndirizzoCompleto(impiantoDto.getDenominazioneComune(), impiantoDto.getIndirizzoSitad(), null, impiantoDto.getCivico(), impiantoDto.getSiglaProvincia());
		String codiceBollino = null;
		if(GenericUtil.isNotNullOrEmpty(vAllegato.getFkNumeroBollino()))
		{
			codiceBollino = vAllegato.getFkSiglaBollino() + "-" + vAllegato.getFkNumeroBollino();
		}
		
		oggetto = "CIT: avvenuta ricezione Rapporto Efficienza Energetica impianto " + impiantoDto.getCodiceImpianto();
		
		// Compongo la mail con formato HTML
		testoHtml.append("Avvenuta ricezione del Rapporto Efficienza Energetica dell'impianto in oggetto.<BR/><BR/>");
		testoHtml.append("Descrizione impianto<BR/>");

		testoHtml.append("Codice impianto: " + impiantoDto.getCodiceImpianto() + "<BR/>");

		testoHtml.append("Localizzazione: " + ubicazione + "<BR/><BR/>");
		
		testoHtml.append("Descrizione rapporto di controllo<BR/>");
		testoHtml.append("Data controllo: " + ConvertUtil.convertToString(vAllegato.getDataControllo()) + "<BR/>");
		if(GenericUtil.isNotNullOrEmpty(codiceBollino))
		{
			testoHtml.append("Codice bollino: " + codiceBollino + "<BR/>");
		}
		testoHtml.append("Componenti controllate: " + vAllegato.getElencoApparecchiature() + "<BR/>");
		testoHtml.append("Data invio rapporto: " + ConvertUtil.convertToString(vAllegato.getDataInvio()) + "<BR/><BR/><BR/>");
		
		testoHtml.append("Regione Piemonte<BR/><BR/>");
		testoHtml.append("Per qualsiasi approfondimento consultare il portale Sistema Piemonte oppure utilizzare il seguente<BR/>");
		testoHtml.append("link http://www.sistemapiemonte.it/cms/pa/ambiente/servizi/816-catasto-impianti-termici");

		ArrayList<String> destinatariSingoli = new ArrayList<String>();
		if (GenericUtil.isNotNullOrEmpty(manutentore.getEmail()))
		{
			
			log.debug("Stampo la mail del manutentore: "+manutentore.getEmail());
			destinatariSingoli.add(manutentore.getEmail());
		}
		
		if (GenericUtil.isNotNullOrEmpty(emailResponsabile))
		{
			log.debug("Stampo la mail del responsabile: "+emailResponsabile);

			destinatariSingoli.add(emailResponsabile);
		}

		if (terzoResponsabile != null && GenericUtil.isNotNullOrEmpty(terzoResponsabile.getEmail()))
		{
			destinatariSingoli.add(terzoResponsabile.getEmail());
		}

		
		ResultInvioMail resultInvioMail = sendMail(destinatariSingoli, null, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()), elencoAllegati);
		
		return resultInvioMail;
	}
	
	public ResultInvioMail sendMailInserisciManutenzione(SigitVRicercaAllegatiDto vAllegato, SigitTPersonaGiuridicaDto manutentore, String emailResponsabile, PersonaGiuridica terzoResponsabile) throws ServiceException {
		String oggetto = null;
		
		String ubicazione = MapDto.getIndirizzoCompleto(vAllegato.getComuneImpianto(), vAllegato.getIndirizzoUnitaImmob(), null, vAllegato.getCivicoUnitaImmob(), vAllegato.getSiglaProvImpianto());
		String codiceBollino = null;
		if(GenericUtil.isNotNullOrEmpty(vAllegato.getFkNumeroBollino()))
		{
			codiceBollino = vAllegato.getFkSiglaBollino() + "-" + vAllegato.getFkNumeroBollino();
		}
		
		oggetto = "CIT: avvenuta comunicazione manutenzione impianto " + vAllegato.getCodiceImpianto();
		
		// Compongo la mail con formato HTML
		StringBuffer testoHtml = getContenutoMailManutenzione(vAllegato, ubicazione, codiceBollino, false);
		
		ArrayList<String> destinatariSingoli = new ArrayList<String>();
		if (GenericUtil.isNotNullOrEmpty(manutentore.getEmail()))
		{
			destinatariSingoli.add(manutentore.getEmail());
		}
		
		if (GenericUtil.isNotNullOrEmpty(emailResponsabile))
		{
			destinatariSingoli.add(emailResponsabile);
		}

		if (terzoResponsabile != null && GenericUtil.isNotNullOrEmpty(terzoResponsabile.getEmail()))
		{
			destinatariSingoli.add(terzoResponsabile.getEmail());
		}
		
		ResultInvioMail resultInvioMail = null;
		
		if (destinatariSingoli != null && !destinatariSingoli.isEmpty())
		{
			resultInvioMail = sendMail(destinatariSingoli, null, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		}
		
		return resultInvioMail;
	}
	
	public ResultInvioMail sendMailAnnulaManutenzione(SigitVRicercaAllegatiDto vAllegato, SigitTPersonaGiuridicaDto manutentore, ArrayList<SigitTPersonaFisicaDto> delegati, String emailResponsabile, PersonaGiuridica terzoResponsabile) throws ServiceException 
	{
		String oggetto = null;

		String ubicazione = MapDto.getIndirizzoCompleto(vAllegato.getComuneImpianto(), vAllegato.getIndirizzoUnitaImmob(), null, vAllegato.getCivicoUnitaImmob(), vAllegato.getSiglaProvImpianto());
		String codiceBollino = null;
		if(GenericUtil.isNotNullOrEmpty(vAllegato.getFkNumeroBollino()))
		{
			codiceBollino = vAllegato.getFkSiglaBollino() + "-" + vAllegato.getFkNumeroBollino();
		}
		
		oggetto = "CIT - annullamento manutenzione per impianto " + vAllegato.getCodiceImpianto();
		
		// Compongo la mail con formato HTML
		StringBuffer testoHtml = getContenutoMailManutenzione(vAllegato, ubicazione, codiceBollino, true);
		
		ArrayList<String> destinatariSingoli = new ArrayList<String>();
		if (GenericUtil.isNotNullOrEmpty(manutentore.getEmail()))
		{
			destinatariSingoli.add(manutentore.getEmail());
		}
		
		for (SigitTPersonaFisicaDto delegato : delegati) {
			if (GenericUtil.isNotNullOrEmpty(delegato.getEmail()))
			{
				destinatariSingoli.add(delegato.getEmail());
			}
		}
		
		if (GenericUtil.isNotNullOrEmpty(emailResponsabile))
		{
			destinatariSingoli.add(emailResponsabile);
		}

		if (terzoResponsabile != null && GenericUtil.isNotNullOrEmpty(terzoResponsabile.getEmail()))
		{
			destinatariSingoli.add(terzoResponsabile.getEmail());
		}
		
		ResultInvioMail resultInvioMail = null;
		
		if (destinatariSingoli != null && !destinatariSingoli.isEmpty())
		{
			resultInvioMail = sendMail(destinatariSingoli, null, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		}
		
		return resultInvioMail;
	}
	
	private StringBuffer getContenutoMailManutenzione(SigitVRicercaAllegatiDto vAllegato, String ubicazione, String codiceBollino, boolean isAnnullamento) {
		StringBuffer testoHtml = new StringBuffer();
		
		if (isAnnullamento) {
			
			testoHtml.append("Si avvisa che la manutenzione dell'impianto in oggetto e' stata annullata.<BR/><BR/>");
		} else {
			testoHtml.append("Avvenuta comunicazione manutenzione sull'impianto in oggetto.<BR/><BR/>");

		}
		testoHtml.append("Descrizione impianto<BR/>");

		testoHtml.append("Codice impianto: " + vAllegato.getCodiceImpianto() + "<BR/>");

		testoHtml.append("Localizzazione: " + ubicazione + "<BR/><BR/>");
		testoHtml.append("Descrizione intervento di manutenzione<BR/>");
		testoHtml.append("Data controllo: " + ConvertUtil.convertToString(vAllegato.getDataControllo()) + "<BR/>");
		if(GenericUtil.isNotNullOrEmpty(codiceBollino))
		{
			testoHtml.append("Codice bollino: " + codiceBollino + "<BR/>");
		}
		testoHtml.append("Componenti controllate: " + GenericUtil.getStringValid(vAllegato.getElencoApparecchiature()) + "<BR/>");
		testoHtml.append("Data comunicazione manutenzione: " + ConvertUtil.convertToString(vAllegato.getDataInvio()) + "<BR/>");
		if (isAnnullamento) {			
			testoHtml.append("Data annullamento manutenzione: " + DateUtil.getDataCorrenteFormat() + "<BR/>");
		}
		
		return testoHtml;
	}
	
	public ResultInvioMail sendMailInserisciIspezione(Ispezione2018 ispezione) throws ServiceException 
	{
		String oggetto = null;
		StringBuffer testoHtml = new StringBuffer();

		ArrayList<String> destinatari = null;
		
		String localizzazione = null;
		
		if (ispezione.getCodiceImpianto() != null && !ispezione.getCodiceImpianto().equals("0")) {		
			localizzazione = ispezione.getLocalizzazioneImpianto();
		} else {
			localizzazione = ispezione.getLocalizzazioneDistributore();			
		}

		try {
			destinatari = getDbMgr().cercaIndirizziMailAbilitazioneByRuolo(Constants.ID_RUOLO_PA_ISPETTORE);
		} catch (DbManagerException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}

		oggetto = "CIT - richiesta nuova ispezione "+ ispezione.getIdentificativoIspezione();
		
		if (ispezione.getCodiceImpianto() != null && !ispezione.getCodiceImpianto().equals("0")) {
			oggetto += " su impianto ";
		} else {
			oggetto += " su distributore ";
		}
		oggetto	+= "con "+GenericUtil.getStringValid(localizzazione);
		
		String verAcc = null;
		//if (GenericUtil.isNotNullOrEmpty(ispezione.getIdVerifica()))
		if ((ispezione.getIdVerifica() != null && !Constants.DATO_NON_DISPONIBILE_S.equals(ispezione.getIdVerifica())))
		{
			verAcc = "a Verifica "+ispezione.getIdVerifica();
		} else if (GenericUtil.isNotNullOrEmpty(ispezione.getIdAccertamento()))
		{
			verAcc = "'Accertamento "+ispezione.getIdAccertamento();
		} 
		
		// Compongo la mail con formato HTML
		testoHtml.append("Dall" + verAcc + " e' stata richiesta una nuova ispezione.<BR/><BR/>");
		testoHtml.append("Descrizione dell'ispezione<BR/>");

		testoHtml.append("Ispezione numero: " + ispezione.getIdentificativoIspezione() + "<BR/>");
		testoHtml.append("Data creazione: " + ispezione.getDataCreazione() + "<BR/>");
		testoHtml.append("Stato: " + ispezione.getDescrizioneStato() + "<BR/>");
		if (ispezione.getCodiceImpianto() != null && !ispezione.getCodiceImpianto().equals("0")) {			
			testoHtml.append("Codice impianto: " + ispezione.getCodiceImpianto() + "<BR/>");
		} else {
			testoHtml.append("Distributore: " + ispezione.getIdDatoDistrib() + "<BR/>");
			testoHtml.append(ispezione.getDatoDistributoreAnnoRiferimentoDatiUtente() + "<BR/>");
		}
		if (GenericUtil.isNotNullOrEmpty(localizzazione))
		{
			testoHtml.append(StringUtils.capitalize(localizzazione) + "<BR/>");
		}
		if (GenericUtil.isNotNullOrEmpty(ispezione.getNote())) {			
			testoHtml.append("Note: " + ispezione.getNote() + "<BR/>");
		}

		
		ResultInvioMail resultInvioMail = sendMail(null, destinatari, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));

		return resultInvioMail;
	}
	
	public ResultInvioMail sendMailVerifica(String destinatario) throws ServiceException 
	{
		String oggetto = null;
		StringBuffer testoHtml = new StringBuffer();
		
		oggetto = "Registrazione al CIT:  conferma indirizzo e-mail";
		
		// Compongo la mail con formato HTML
		testoHtml.append("CIT - Catasto degli Impianti Termici, indirizzo e-mail scritto correttamente; tutte le notifiche future saranno mandate a questo indirizzo.<br/>");
		testoHtml.append("Si ricorda di eseguire il salvataggio dell'informazione a video.<br/><br/>");
		testoHtml.append("N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.");
		
		return sendMail(destinatario, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
	}
	
	public ResultInvioMail sendMailInserisciIncaricoCAT(Integer idPersonaGCat,
			Integer idPersonaGImp) throws ServiceException, DbManagerException {
		
		//cerco la persona giuridica cat by id
		PersonaGiuridica PGDelegato = getDbMgr().cercaPersonaGiuridicaById(idPersonaGCat);
		//cerco la persona giuridica impresa by id 
		PersonaGiuridica PGImpresa = getDbMgr().cercaPersonaGiuridicaById(idPersonaGImp);
		
		String oggetto = "Assegnazione incarico a Soggetto Delegato";
		StringBuffer testoHtml = new StringBuffer();
		testoHtml.append("L 'impresa <br/>");
		testoHtml.append(PGImpresa.getDenominazione()+"<br/>");
		testoHtml.append(PGImpresa.getCodiceFiscale()+"<br/>");
		testoHtml.append(PGImpresa.getSiglaRea() +" "+PGImpresa.getNumeroRea()+"<br/>");
		testoHtml.append("ha assegnato incarico al Soggetto Delegato<br/>");
		testoHtml.append(PGDelegato.getDenominazione()+"<br/>");
		testoHtml.append(PGDelegato.getCodiceFiscale()+"<br/>");
		testoHtml.append(PGDelegato.getSiglaRea()+" "+PGDelegato.getNumeroRea()+"<br/>");
		testoHtml.append("per operare sul CIT per conto suo.<br/><br/>");
		testoHtml.append("N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.");
		String testoTxt = GenericUtil.getStringaTxtToHtml(testoHtml.toString());
		ArrayList<String> destinatari = new ArrayList<String>();
		if(GenericUtil.checkValideEmail(PGImpresa.getEmail())) 
			destinatari.add(PGImpresa.getEmail());
		if(GenericUtil.checkValideEmail(PGDelegato.getEmail()))
			destinatari.add(PGDelegato.getEmail());
		
		return sendMail(null, destinatari, oggetto, testoHtml.toString(), testoTxt);
	}
	
	public ResultInvioMail sendMailCessaIncaricoCAT(Integer idPersonaGCat,
			Integer idPersonaGImp) throws ServiceException, DbManagerException {
		
		//cerco la persona giuridica cat by id
		PersonaGiuridica PGDelegato = getDbMgr().cercaPersonaGiuridicaById(idPersonaGCat);
		//cerco la persona giuridica impresa by id 
		PersonaGiuridica PGImpresa = getDbMgr().cercaPersonaGiuridicaById(idPersonaGImp);
		
		String oggetto = "Cessazione incarico a Soggetto Delegato";
		StringBuffer testoHtml = new StringBuffer();
		testoHtml.append("L 'impresa <br/>");
		testoHtml.append(PGImpresa.getDenominazione()+"<br/>");
		testoHtml.append(PGImpresa.getCodiceFiscale()+"<br/>");
		testoHtml.append(PGImpresa.getSiglaRea() +" "+PGImpresa.getNumeroRea()+"<br/>");
		testoHtml.append("ha cessato l'incarico al Soggetto Delegato <br/>");
		testoHtml.append(PGDelegato.getDenominazione()+"<br/>");
		testoHtml.append(PGDelegato.getCodiceFiscale()+"<br/>");
		testoHtml.append(PGDelegato.getSiglaRea()+" "+PGDelegato.getNumeroRea()+"<br/>");
		testoHtml.append("per operare sul CIT per conto suo.<br/><br/>");
		testoHtml.append("N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.");
		String testoTxt = GenericUtil.getStringaTxtToHtml(testoHtml.toString());
		ArrayList<String> destinatari = new ArrayList<String>();
		if(GenericUtil.checkValideEmail(PGImpresa.getEmail())) 
			destinatari.add(PGImpresa.getEmail());
		if(GenericUtil.checkValideEmail(PGDelegato.getEmail()))
			destinatari.add(PGDelegato.getEmail());
		
		return sendMail(null, destinatari, oggetto, testoHtml.toString(), testoTxt);
	}
	
//	
//	public void sendMail(String destinatario) throws ServiceException {
//		MailSender sender = new MailSender();
//		Mail email = new Mail();
//
//		
//		try {
//			System.out.println("INVIO EMAIL");
//			// Destinatario
//			email.setDestinatario(destinatario);
//			
//			email.setHost(getProperties().getProperty(Constants.MAIL_HOST));
//			email.setPort(getProperties().getProperty(Constants.MAIL_PORT));
//			
//			String mittente = getDbMgr().cercaConfigValueCarattere(Constants.WEB_MAIL_IND_MITT);
//			email.setMittente(mittente);
//			System.out.println("parametro da DB: "+mittente);
//			email.setOggetto("Registrazione al CIT:  conferma indirizzo e-mail");
//			String emailBodyHtml = "CIT - Catasto degli Impianti Termici, indirizzo e-mail scritto correttamente; tutte le notifiche future saranno mandate a questo indirizzo.<br/>";
//			emailBodyHtml += "Si ricorda di eseguire il salvataggio dell'informazione a video.<br/><br/>";
//			emailBodyHtml+="N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.";
//			email.setHtml(emailBodyHtml);
//			String emailBodyTxt = "CIT - Catasto degli Impianti Termici, indirizzo e-mail scritto correttamente; tutte le notifiche future saranno mandate a questo indirizzo.\n";
//			emailBodyTxt += "Si ricorda di eseguire il salvataggio dell'informazione a video.\n\n";
//			emailBodyTxt+="N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.";
//			email.setTesto(emailBodyTxt);
//		
//			sender.sendMail(email);
//			System.out.println("mail inviata");
//		} catch (Exception e) {
//			log.error(e);
//			throw new ServiceException(e, Messages.ERROR_INVIO_MAIL);
//		}
//
//	}
	
	/**
	 * Send mail 
	 * 
	 * @param attestatoOld
	 *            the attestato old
	 * @param attestatoNew
	 *            the attestato new
	 * @param emailDest
	 *            the email dest
	 * @param annullamento
	 *            the annullamento
	 * @throws BEException
	 *             the bE exception
	 */
	public ResultInvioMail sendMail(ArrayList<String> destinatariSingoli, ArrayList<String> destinatari, String oggetto, String testoHtml, String testoTxt)
			throws ServiceException {
		
		return sendMail(destinatariSingoli, destinatari, oggetto, testoHtml, testoTxt, null);
	}
	
	public ResultInvioMail sendMail(ArrayList<String> destinatariSingoli, ArrayList<String> destinatari, String oggetto, String testoHtml, String testoTxt, ArrayList<Allegato> elencoAllegati)
			throws ServiceException {
		MailSender sender = new MailSender();
		Mail email = new Mail();
		ResultInvioMail resultInvioMail = new ResultInvioMail();
		try {
			
			email.setHost(getProperties().getProperty(Constants.MAIL_HOST));
			email.setPort(getProperties().getProperty(Constants.MAIL_PORT));
			
			email.setIdEmail(getProperties().getProperty(Constants.MAIL_USER));
			email.setPassword(getProperties().getProperty(Constants.MAIL_PWD));
			
			email.setMittente(getDbMgr().cercaConfigValueCarattere(Constants.WEB_MAIL_IND_MITT));
	
			email.setOggetto(oggetto);
			email.setHtml(testoHtml);
			email.setTesto(testoTxt);
			
			if (elencoAllegati != null && elencoAllegati.size() > 0)
			{
				email.setElencoAllegati(elencoAllegati);
			}			
		
			if (destinatariSingoli != null && destinatariSingoli.size() > 0)
			{
				for (String destinatario : destinatariSingoli) {
					// Destinatario
					email.setDestinatario(destinatario);
					
					try
					{
						sender.sendMail(email);
						resultInvioMail.addDestinatarioOK(destinatario);
					} catch (Exception e) {
						log.error(e);
						resultInvioMail.addDestinatarioKO(destinatario);
						
						// Non rilancio l'exception ma proseguo con l'invio e colleziono i destinatari falliti
						//throw new ServiceException(e, Messages.ERROR_INVIO_MAIL);
					}
					
				}
			}
			if (destinatari != null && destinatari.size() > 0)
			{
				
				email.setDestinatari(destinatari);
				
				// Formatto gli indirizzi mail 
				String destElenco = destinatari.toString();
				String destElencoForm = destElenco.substring(1, destElenco.length()-1);
				
				//ArrayList<String> destinatariSingoli = new ArrayList<String>();
				try
				{
					sender.sendMail(email);
					resultInvioMail.addDestinatarioOK(destElencoForm);
				} catch (Exception e) {
					log.error(e);
					resultInvioMail.addDestinatarioKO(destElencoForm);
					
					// Non rilancio l'exception ma proseguo con l'invio e colleziono i destinatari falliti
					//throw new ServiceException(e, Messages.ERROR_INVIO_MAIL);
				}
//				catch (javax.mail.SendFailedException eMail)
//				{
//					
//				}
				
			}
			
		} catch (Exception e) {
			log.error(e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		
		
		return resultInvioMail;

	}
	
	public ResultInvioMail sendMail(String destinatario, String oggetto, String testoHtml, String testoTxt)
			throws ServiceException {
		
		ArrayList<String> destinatariSingoli = new ArrayList<String>();
		destinatariSingoli.add(destinatario);
		return sendMail(destinatariSingoli, null, oggetto, testoHtml, testoTxt);

	}
	
	/*
	public ModolSrvFacade getModol()
	{
		log.debug("[ServiziMgr::getModol] BEGIN");
		ModolSrvFacade modol = null;
		try {
			modol = getServiceModolXP().getModolXPServiceImp();
		}
		catch (Exception e) {
			log.error("[ServiziMgr::getModol] errore nella parsificazione della configurazione di MODOLXP:"+ e, e);
			throw new IllegalArgumentException("errore nella parsificazione della configurazione di MODOLXP");
		}
		return modol;
	}
	*/
	/*
	public ModolPdfGeneratorSrvFacade getModolPdf()
	{
		log.debug("[ServiziMgr::getModolPdf] BEGIN");
		ModolPdfGeneratorSrvFacade modol = null;
		try {
			modol = getServiceModolXPPdf().getModolXPPdfServiceImp();
		}
		catch (Exception e) {
			log.error("[ServiziMgr::getModolPdf] errore nella parsificazione della configurazione di MODOLXP:"+ e, e);
			throw new IllegalArgumentException("errore nella parsificazione della configurazione di MODOLXP");
		}
		return modol;
	}
	*/
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
	
	public ModolPdfGeneratorSrvITF getModolPdfA() {
		log.debug("[ServiziMgr::getModolPdfA] BEGIN");
		InputStream is = getClass().getResourceAsStream(MODOL_PDF_RESOURCE);
		if (is != null) {
			try {
				InfoPortaDelegata info = PDConfigReader.read(is);
				log.debug("[ServiziMgr::getModolPdfA] END");
				return (ModolPdfGeneratorSrvITF) PDProxy.newInstance(info);
			} 
			catch (Exception e) {
				log.error("[ServiziMgr::getModolPdfA] errore nella parsificazione della configurazione di MODOL:"+ e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione di MODOL");
			}
		} else{
			log.error("[ServiziMgr::getModolPdfA] configurazione di MODOL non trovata");
		}
		throw new IllegalArgumentException("configurazione di MODOL PDF non trovata");
	}
	*/
	
	/*
	public byte[] getXmlFromPdf(byte[] thePdf){
		log.debug("[ServiziMgr::getModolPdfA] START");

		Applicazione app;
		Utente utente;
//		XmlModel model;
		byte[] file;
		app = new Applicazione();
		app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
		utente = null;
		 try {
			file = getXmlFromModol(app,utente,thePdf); //recupero l'xml da modol
		} catch (ServiceException e) {
			log.error("Errore in getXmlFromPdf() - recupero dati xml da MODOL" + e.getMessage());
			log.error("Stampo l'eccezione: ",e);
			return null;
		}
		log.debug("[ServiziMgr::getXmlFromPdf] END");
		 return file;
	}
	*/
	/*
	public byte[] getXmlFromModol(Applicazione app, Utente utente, byte[] thePdf) throws ServiceException {
		log.debug("[ServiziMgr::getXmlFromModol] BEGIN");
		try {
			return getXmlFromModolServ(app, utente, thePdf);
		}
		catch(Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally {
			log.debug("[ServiziMgr::getXmlFromModol] END");
		}
	}
	*/
	/*
	public byte[] getXmlFromModolServ(Applicazione app, Utente utente, byte[] thePdf) throws ServiceException {
		log.debug("[ServiziMgr::getXmlFromModol] BEGIN");
		ProcessFormRequest pfr = new ProcessFormRequest();
		pfr.setContenuto(thePdf);
		try {
			ProcessFormResponse response=  getModol().processForm(app, utente, pfr);
			
			if (log.isDebugEnabled())
				log.debug("DATI XML FROM MODOL " + "\\n" + new String(response.getDatiXml()));
			
			return response.getDatiXml(); //ritorna l'xml con i dati, per metterlo in xmlBean usare AllegatoG Document
		} catch (ModolsrvException e) {
			log.error(e.getStackTrace());
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally{
			log.debug("[ServiziMgr::getXmlFromModol] END");
		}
	}
	*/
	/*
	public byte[] showModuloLibretto(Applicazione app, Utente utente, XmlModel xmlModel) throws ServiceException {
		log.debug("[ServiziMgr::showModuloLibretto] BEGIN");
		try
		{
			Modulo modulo = cercaModulo(app, Constants.CODICE_MODULO_MODOL_LIBRETTO);
			log.debug("CODICE MODOL LIBRETTO: "  + Constants.CODICE_MODULO_MODOL_LIBRETTO);
			if(modulo!=null)
			{
				//modulo.getModello().getRendererModality()[0].setSelezionataPerRendering(true);
				
				RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
				
				if (log.isDebugEnabled())
				{
					log.debug("########################################");
					log.debug("faccio la merge");
					log.debug("xmlModel: "+xmlModel.toString());
					log.debug("modulo: "+modulo);
					log.debug("########################################");
				}
				return getModol().mergeModulo(app, utente, modulo, xmlModel).getDataContent();
			}
			
			return null;
		}
		catch (Exception e) {
			log.error("Errore nella generazione del modulo", e);
			throw new ServiceException(e, "Errore nella generazione del modulo");
		}finally{
			log.debug("[ServiziMgr::showModuloLibretto] END");
		}
	}
	*/
	/*
	public byte[] showModuloLibrettoLight(Applicazione app, Utente utente, XmlModel xmlModel) throws ServiceException {
		log.debug("[ServiziMgr::showModuloLibretto] BEGIN");
		try
		{
			Modulo modulo = cercaModulo(app, Constants.CODICE_MODULO_MODOL_LIBRETTO_LIGHT);
			if(modulo!=null)
			{
				//modulo.getModello().getRendererModality()[0].setSelezionataPerRendering(true);
				
				RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
				
				if (log.isDebugEnabled())
				{
					log.debug("########################################");
					log.debug("faccio la merge");
					log.debug("xmlModel: "+xmlModel.toString());
					log.debug("modulo: "+modulo);
					log.debug("########################################");
				}
				
				return getModol().mergeModulo(app, utente, modulo, xmlModel).getDataContent();
			}
			
			return null;
		}
		catch (Exception e) {
			log.error("Errore nella generazione del modulo", e);
			throw new ServiceException(e, "Errore nella generazione del modulo");
		}finally{
			log.debug("[ServiziMgr::showModuloLibretto] END");
		}
	}
	*/
	/*
	public byte[] showModuloAllegato(Applicazione app, Utente utente, XmlModel xmlModel, String tipoAllegato) throws ServiceException {
		log.debug("[ServiziMgr::showModuloAllegato] BEGIN");
		try
		{
			String codModel = null; 
			if(Constants.ALLEGATO_TIPO_1.equals(tipoAllegato))
				codModel = Constants.CODICE_MODULO_MODOL_ALLEGATO_II;
			if(Constants.ALLEGATO_TIPO_2.equals(tipoAllegato))
				codModel = Constants.CODICE_MODULO_MODOL_ALLEGATO_III;
			if(Constants.ALLEGATO_TIPO_3.equals(tipoAllegato))
				codModel = Constants.CODICE_MODULO_MODOL_ALLEGATO_IV;
			if(Constants.ALLEGATO_TIPO_4.equals(tipoAllegato))
				codModel = Constants.CODICE_MODULO_MODOL_ALLEGATO_V;
			if(codModel == null)
				throw new ServiceException("Codice modulo non trovato");
			log.debug("codice modello: " + codModel);
			Modulo modulo = cercaModulo(app, codModel);
			if(modulo!=null)
			{
				RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
				
				if (log.isDebugEnabled())
				{
					log.debug("########################################");
					log.debug("faccio la merge");
					log.debug("xmlModel: "+xmlModel.toString());
					log.debug("modulo: "+modulo);
					log.debug("########################################");
				}
				
				return getModol().mergeModulo(app, utente, modulo, xmlModel).getDataContent();
			}
			
			return null;
		}
		catch (Exception e) {
			log.error("Errore nella generazione del modulo", e);
			throw new ServiceException(e, "");
		}finally{
			log.debug("[ServiziMgr::showModuloAllegato] END");
		}
	}
	*/
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
				
				if (log.isDebugEnabled())
				{
					log.debug("########################################");
					log.debug("faccio la merge");
					log.debug("xmlModel: "+xmlModel.toString());
					log.debug("modulo: "+modulo);
					log.debug("########################################");
				}
				
				modulo = getModol().mergeModulo(app, utente, modulo, xmlModel);
				return creaModuloStaticoModol(modulo);
				
			}
			
			return null;
		}
		catch (Exception e) {
			log.error("Errore nella generazione del modulo", e);
			throw new ServiceException(e, "");
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
				
				if (log.isDebugEnabled())
				{
					log.debug("########################################");
					log.debug("faccio la merge");
					log.debug("xmlModel: "+xmlModel.toString());
					log.debug("modulo: "+modulo);
					log.debug("########################################");
				}
				
				modulo = getModol().mergeModulo(app, utente, modulo, xmlModel);
				return creaModuloStaticoModol(modulo);
			}
			
			return null;
		}
		catch (Exception e) {
			log.error("Errore nella generazione del modulo", e);
			throw new ServiceException(e, "");
		}finally{
			log.debug("[ServiziMgr::showModuloRicevutaImportDistrib] END");
		}
	}
	*/
	/*
	public byte[] creaModuloStaticoModol(Modulo modulo) throws ServiceException {

		byte[] thePdfStatico = null;

		try
		{
			log.debug("PASSO creaModuloStaticoModol - 1");
//			if (log.isDebugEnabled())
//			{
//				log.debug("Stampo modulo: "+modulo);
//			}

			log.debug("PASSO creaModuloStaticoModol - 2");

			//a questo punto recupero l'xml dal modulo aggiornato 
			byte[] thePdf = modulo.getDataContent();

			log.debug("PASSO creaModuloStaticoModol - 3");

			it.csi.modolxp.modolxppdfgensrv.dto.Applicazione appPdfStatico = new it.csi.modolxp.modolxppdfgensrv.dto.Applicazione();
			appPdfStatico.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);

			log.debug("PASSO creaModuloStaticoModol - 4");

			byte[] thePdfStaticoNew = null;
			PdfStaticInputRequest pdfStaticInputRequest = new PdfStaticInputRequest();
			pdfStaticInputRequest.setPdfInput(thePdf);
			
			log.debug("PASSO creaModuloStaticoModol - 5");
			
			log.debug("toStaticPdf - PRIMA: "+System.currentTimeMillis());
			thePdfStaticoNew = getModolPdf().toStaticPdf(appPdfStatico, null, pdfStaticInputRequest);			
			log.debug("toStaticPdf - DOPO: "+System.currentTimeMillis());

			log.debug("PASSO creaModuloStaticoModol - 6");

			log.debug("PRIMA DELLA CREAZIONE DEL PDF STATICO");

			PdfAInputRequest pdfAInputRequest = new PdfAInputRequest();
			pdfAInputRequest.setPdfInput(thePdfStaticoNew);

			log.debug("PASSO creaModuloStaticoModol - 7");

			thePdfStatico = getModolPdf().toPdfA(appPdfStatico, null, pdfAInputRequest);
			
			log.debug("PASSO creaModuloStaticoModol - 8");

		}
		catch(Exception e){
			log.error("Errore nel metodo creaModuloStaticoModol", e);

			throw new ServiceException(e, "");
		}
		
		return thePdfStatico;
	}
	*/
	/*
	public TransazioneApp initTransazione() throws ServiceException {
		log.debug("[ServiziMgr::initTransazione] BEGIN");
		CriterioRicercaModulo criterio;
		try {
			
			Transazione transazione = getMDP().initTransazione(Constants.CODICE_APPLICATIVO_MDP, null);
			
			return MapDto.convertToTransazioneApp(transazione);
			
		}catch (Exception e) {
				log.error(e.getStackTrace());
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::initTransazione] END");
		}
	}
	
	public ArrayList<CodeDescription> cercaMetodiPagamento(TransazioneApp transazioneApp) throws ServiceException {
		log.debug("[ServiziMgr::cercaMetodiPagamento] BEGIN");
		CriterioRicercaModulo criterio;
		try {
			
			AppGateway[] metodiPag = getMDP().getModalitaPagamento(MapDto.convertToTransazione(transazioneApp), Constants.CODICE_APPLICATIVO_MDP);
			
			return MapDto.mapMetodiPagamento(metodiPag);
			
		}catch (Exception e) {
				log.error(e.getStackTrace());
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::cercaMetodiPagamento] END");
		}
	}
	
	public String startTransazione(TransazioneApp transazioneApp, String idGestorePagamento) throws ServiceException {
		log.debug("[ServiziMgr::startTransazione] BEGIN");
		try {
			Transazione transazione = MapDto.convertToTransazione(transazioneApp);
			
			String[] ids = idGestorePagamento.split(
					Constants.DIVIDE_IDS);
			transazione.setGatewayId(ids[0]);
			transazione.setGatewaypaymodeid(ids[1]);
			
			String urlMDP = getMDP().startTransazione(transazione, 
					new it.csi.mdp.core.business.dto.TransazioneExtraAttribute[0]);
			
			if (GenericUtil.isNullOrEmpty(urlMDP))
			{
				throw new ServiceException(null, Messages.S032);
			}
			
			return urlMDP;
			
		}
		catch (ServiceException e) {
			throw e;
		}
		catch (Exception e) {
				log.error(e.getStackTrace());
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::startTransazione] END");
		}
	}
	
	public TransazioneApp cercaTransazione(String idTransazione) throws ServiceException {
		log.debug("[ServiziMgr::cercaTransazione] BEGIN");
		try {
		
			Transazione transazione = getMDP().getStatoTransazione(idTransazione);
			
			return MapDto.convertToTransazioneApp(transazione);
			
		}catch (Exception e) {
				log.error(e.getStackTrace());
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::cercaTransazione] END");
		}
	}
	*/

	public MODDocument getLibretto(String idImpianto) throws ServiceException {
		log.debug("[ServiziMgr::getLibretto] BEGIN");
		try {
		
			
			Impianto impianto = getDbMgr().cercaImpiantoById(idImpianto);
			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(impianto.getImpCodImpianto(), Constants.ID_STATO_LIBRETTO_BOZZA);
			
			SigitTLibrettoDto libretto = null;
			
			MODDocument modDoc = null;
			if (librettoList != null && librettoList.size() > 0)
			{
				if (librettoList.size() == 1)
				{
					libretto = librettoList.get(0);
					log.debug("trovato libretto in stato bozza: " + libretto.getIdLibretto());
					SigitTLibTxtDto txtLibretto = getDbMgr().getTxtLibretto(libretto.getIdLibretto());
					if(txtLibretto==null) throw new ServiceException("Errore durante il recupero dei dati del libretto. Contattare l'amministrattore del sistema.");
					
					if (log.isDebugEnabled())
						log.debug("Contenuto xml: " + txtLibretto.getXmlLibretto());
					
					modDoc = MapDto.mapToMODDocument(XmlBeanUtils.readString(txtLibretto.getXmlLibretto()));
					
				}
				else
				{
					throw new ServiceException(Messages.ERROR_RECUPERO_SERVIZIO);
				}
			}
			else
			{
				log.debug("NON trovato libretto in stato bozza. Controllo se ci sono libretti consolidati");
				List<SigitTLibrettoDto> librettiConsolidati = getDbMgr().cercaLibrettoByStato(impianto.getImpCodImpianto(), Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
				if (librettiConsolidati != null && librettiConsolidati.size() > 0)
				{
					SigitTLibrettoDto librettoConsolidato = librettiConsolidati.get(0);
					String idLibretto = librettoConsolidato.getIdLibretto().toString();
					log.debug("Trovato ultimo libretto consolidato: "+idLibretto);
					return getDbMgr().getModuloLibretto(idImpianto, idLibretto, false);
				}
				else
				{
					log.debug("Nessun libretto trovato. Creiamo libretto solo con i dati precompilati");
//	il libretto e' nullo, prendere i dati dal db anche quando NON ci sono libretti consolidati
					return getDbMgr().getModuloLibretto(idImpianto, null, false);
//					modDoc = MODDocument.Factory.newInstance();
//					modDoc.addNewMOD().addNewRichiesta().addNewDatiPrecompilati().addNewSezCatasto();
				}
			}
			log.debug("Libretto in bozza. Compilazione solo dei dati precompilati");
			Richiesta richiesta = modDoc.getMOD().getRichiesta();
			
			DatiPrecompilati datiPrecompilati = richiesta.getDatiPrecompilati();
			datiPrecompilati.setCodiceImpianto(idImpianto);
			
			
			datiPrecompilati.setElencoCombustibile(MapDto.mapToElencoCombustibile(getDbMgr().getElencoCombustibile()));
			datiPrecompilati.setElencoFabbricante(MapDto.mapToElencoFabbricante(getDbMgr().getElencoMarche()));
			datiPrecompilati.setElencoFluidoTermoVett(MapDto.mapToElencoFluido(getDbMgr().getElencoFluidi()));
			datiPrecompilati.setElencoUM(MapDto.mapToElencoUnitaMisura(getDbMgr().getElencoUnitaMisura()));
			
			datiPrecompilati.setCodiceCatasto(idImpianto);

			SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(idImpianto);
			//dati scheda 1 - impianto e scheda 14 - consumo
			getDbMgr().compilaScheda1E14Libretto(richiesta, libretto, impiantoDto);
			
			//dati responsabile e terzo responsabile
			Integer codImpiantoInt = new Integer(impianto.getImpCodImpianto());
			getDbMgr().compilaDatiResponsabiliEControlliLibretto(new Integer(idImpianto), richiesta, getDbMgr().getCompGtDett(codImpiantoInt),
					getDbMgr().getCompGfDett(codImpiantoInt), getDbMgr().getCompScDett(codImpiantoInt), getDbMgr().getCompCgDett(codImpiantoInt));
			
			datiPrecompilati.setStatoModulo(Constants.STATO_MODULO_BOZZA);
			if(modDoc.getMOD().getSystem()==null)
				modDoc.getMOD().addNewSystem();
			if(modDoc.getMOD().getSystem().getCatDig()==null)
				modDoc.getMOD().getSystem().addNewCatDig();
			modDoc.getMOD().getSystem().getCatDig().setBtSalva(true);
			
			if (log.isDebugEnabled())
				GenericUtil.stampa(impianto, true, 3);
//			
//			log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//			log.debug("STAMPO RESULT: "+modDoc);
//			log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			
			return modDoc;
			
		}catch (Exception e) {
				log.error("Errore getLibretto",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getLibretto] END");
		}
	}

	public it.csi.sigit.sigitwebn.xml.librettoLight.data.MODDocument getLibrettoLight(String idImpianto) throws ServiceException {
		log.debug("[ServiziMgr::getLibretto] BEGIN");
		try {
			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(idImpianto, Constants.ID_STATO_LIBRETTO_BOZZA);

			String idLibretto = null;
			if (librettoList != null && librettoList.size() > 0)
			{
				if (librettoList.size() == 1)
				{
					idLibretto = ConvertUtil.convertToString(librettoList.get(0).getIdLibretto());
					log.debug("trovato libretto in stato bozza: " + idLibretto);
				}
				else
				{
					log.debug("trovati piu' libretti in bozza");
					throw new ServiceException(Messages.ERROR_RECUPERO_SERVIZIO);
				}
			}
			else
			{
				log.debug("NON trovato libretto in stato bozza. Controllo se ci sono libretti consolidati");
				List<SigitTLibrettoDto> librettiConsolidati = getDbMgr().cercaLibrettoByStato(idImpianto, Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
				if (librettiConsolidati != null && librettiConsolidati.size() > 0)
				{
					idLibretto = librettiConsolidati.get(0).getIdLibretto().toString();
					log.debug("Trovato ultimo libretto consolidato: "+idLibretto);
				}
			}
			return getDbMgr().getModuloLibrettoLight(idImpianto, idLibretto);
		}catch (Exception e) {
			log.error("Errore getLibretto",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getLibretto] END");
		}
	}
	
	
	
	/*
	public DettaglioAllegatoIndex getLibrettoIndexOLD(String idImpianto) throws ServiceException {
		log.debug("[ServiziMgr::getLibrettoIndexOLD] BEGIN");
		DettaglioAllegatoIndex result = new DettaglioAllegatoIndex();
		try {
		
			byte[] file = null;
			
			SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(idImpianto);

			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(idImpianto,  Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			//librettoList dovrebbe avere un solo libretto in stato bozza
			SigitTLibrettoDto libretto = librettoList.get(0);
			
			Metadati md = new Metadati();
			md.setCodiceImpianto(ConvertUtil.convertToString(impianto.getCodiceImpianto()));
			md.setCodIstatComune(impianto.getIstatComune());
			md.setCodIstatProvincia(StringUtils.substring(impianto.getIstatComune(), 0, 3));
			md.setDataRapporto(ConvertUtil.convertToString(libretto.getDataIntervento()));
			md.setIdRapporto(ConvertUtil.convertToString(libretto.getIdLibretto()));
			
			file = indexOpenFile(libretto.getFileIndex(), md);
			result.setFile(file);
			result.setNomeAllegato(libretto.getFileIndex());
			
			return result;
			
		}catch (Exception e) {
				log.error("Errore getLibrettoIndexOLD",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getLibrettoIndex] END");
		}
	}
	
	public DettaglioAllegatoIndex getAllegatoIndexOLD(String idImpianto, String idAllegato) throws ServiceException {
		log.debug("[ServiziMgr::getAllegatoIndex] BEGIN");
		DettaglioAllegatoIndex result = new DettaglioAllegatoIndex();
		try {
		
			byte[] file = null;
			
			SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(idImpianto);
			SigitVRicercaAllegatiDto allegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);

			//List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(idImpianto,  Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			//librettoList dovrebbe avere un solo libretto in stato bozza
			//SigitTLibrettoDto libretto = librettoList.get(0);
			
			Metadati md = new Metadati();
			md.setCodiceImpianto(ConvertUtil.convertToString(impianto.getCodiceImpianto()));
			md.setCodIstatComune(impianto.getIstatComune());
			md.setCodIstatProvincia(StringUtils.substring(impianto.getIstatComune(), 0, 3));
			md.setDataRapporto(ConvertUtil.convertToString(allegato.getDataControllo()));
			md.setIdRapporto(ConvertUtil.convertToString(allegato.getIdAllegato()));
			
			//file = indexOpenFile(allegato.getNomeAllegato(), md);
			result.setFile(file);
			result.setNomeAllegato(allegato.getNomeAllegato());
			
			return result;
			
		}catch (Exception e) {
				log.error("Errore getAllegatoIndex",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getAllegatoIndex] END");
		}
	}
	*/
	
	public DettaglioAllegatoIndex getLibrettoIndex(String idImpianto) throws ServiceException {
		log.debug("[ServiziMgr::getLibrettoIndex] BEGIN");
		DettaglioAllegatoIndex result = new DettaglioAllegatoIndex();
		try {
			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);

			byte[] file = null;
			String uid = null;


			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(idImpianto,  Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			
			if (librettoList == null || librettoList.size() == 0)
			{
				// Non esiste un libretto consolidato
				throw new ServiceException(Messages.S056);

			}
			
			//librettoList dovrebbe avere un solo libretto in stato bozza
			SigitTLibrettoDto libretto = librettoList.get(0);
			
			
			if (libretto != null)
			{
				if (GenericUtil.isNotNullOrEmpty(libretto.getUidIndex()))
				{
					uid = libretto.getUidIndex();
					file = indexOpenFileByUID(uid, libretto.getFileIndex(), oc);
				}
				
				if (file == null)
				{
					SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(idImpianto);

					Metadati md = new Metadati();
					md.setCodiceImpianto(ConvertUtil.convertToString(impianto.getCodiceImpianto()));
					md.setCodIstatComune(impianto.getIstatComune());
					md.setCodIstatProvincia(StringUtils.substring(impianto.getIstatComune(), 0, 3));
					md.setDataRapporto(ConvertUtil.convertToString(impianto.getDataIntervento()));
					md.setIdRapporto(ConvertUtil.convertToString(libretto.getIdLibretto()));
					
					uid = indexSearchUIDFileInFolderNew(libretto.getFileIndex(), md, oc, Constants.INDEX_FOLDER_LIBRETTI);
					
					if (uid != null)
					{
						file = indexOpenFileByUID(uid, libretto.getFileIndex(), oc);
					}
				}
				
			}

			result.setFile(file);
			result.setNomeAllegato(libretto.getFileIndex());
			
			return result;

		}
		catch (ServiceException e) {
			log.error("ServiceException getLibrettoIndex",e);
			throw e;
		}
		catch (Exception e) {
			log.error("Errore getLibrettoIndex",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getLibrettoIndex] END");
		}
	}

	public DettaglioAllegatoIndex getLibrettoIndexMARGE(String idImpianto) throws ServiceException {
		log.debug("[ServiziMgr::getLibrettoIndexMARGE] BEGIN");
		DettaglioAllegatoIndex result = new DettaglioAllegatoIndex();
		try {
			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);

			byte[] file = null;
			String uid = null;


			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(idImpianto,  Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			
			if (librettoList == null || librettoList.size() == 0)
			{
				// Non esiste un libretto consolidato
				throw new ServiceException(Messages.S056);

			}
			
			//librettoList dovrebbe avere un solo libretto in stato bozza
			SigitTLibrettoDto libretto = librettoList.get(0);
			
			
			if (libretto != null)
			{
				if (GenericUtil.isNotNullOrEmpty(libretto.getUidIndex()))
				{
					uid = libretto.getUidIndex();
					file = indexOpenFileByUID(uid, libretto.getFileIndex(), oc);
				}
				
				if (file == null)
				{
					SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(idImpianto);

					Metadati md = new Metadati();
					md.setCodiceImpianto(ConvertUtil.convertToString(impianto.getCodiceImpianto()));
					md.setCodIstatComune(impianto.getIstatComune());
					md.setCodIstatProvincia(StringUtils.substring(impianto.getIstatComune(), 0, 3));
					md.setDataRapporto(ConvertUtil.convertToString(impianto.getDataIntervento()));
					md.setIdRapporto(ConvertUtil.convertToString(libretto.getIdLibretto()));
					
					uid = indexSearchUIDFileInFolderNew(libretto.getFileIndex(), md, oc, Constants.INDEX_FOLDER_LIBRETTI);
					
					if (uid != null)
					{
						file = indexOpenFileByUID(uid, libretto.getFileIndex(), oc);
					}
				}
				
			}

			log.debug("[ServiziMgr::getLibrettoIndexMARGE] INIZIO prova");

			// PROVO AD UNIRE I DUE LIBRETTI - inizio
	        List<byte[]> list = new ArrayList<byte[]>();
            list.add(file);
            list.add(file);

			Document document = new Document();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
	        document.open();
	        PdfContentByte cb = writer.getDirectContent();
	        
	        for (byte[] in : list) {
	            PdfReader reader = new PdfReader(in);
	            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
	                document.newPage();
	                //import the page from source pdf
	                PdfImportedPage page = writer.getImportedPage(reader, i);
	                //add the page to the destination pdf
	                cb.addTemplate(page, 0, 0);
	            }
	        }
	        
	        outputStream.flush();
	        document.close();
	        outputStream.close();
			
	        byte[] ret = outputStream.toByteArray();

	        log.debug("[ServiziMgr::getLibrettoIndexMARGE] FINE prova");

			
			// PROVO AD UNIRE I DUE LIBRETTI - fine
			
			result.setFile(ret);
			result.setNomeAllegato(libretto.getFileIndex());
			
			return result;

		}
		catch (ServiceException e) {
			log.error("ServiceException getLibrettoIndexMARGE",e);
			throw e;
		}
		catch (Exception e) {
			log.error("Errore getLibrettoIndexMARGE",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getLibrettoIndexMARGE] END");
		}
	}
	
	/*
	public DettaglioDocumento getLibrettoXML(String idImpianto) throws ServiceException {
		log.debug("[ServiziMgr::getLibrettoXML] BEGIN");
		DettaglioDocumento result = new DettaglioDocumento();
		try {
			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);

			byte[] file = null;

			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(idImpianto,  Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			
			if (librettoList == null || librettoList.size() == 0)
			{
				// Non esiste un libretto consolidato
				throw new ServiceException(Messages.S056);

			}
			
			//librettoList dovrebbe avere un solo libretto in stato bozza
			SigitTLibrettoDto libretto = librettoList.get(0);
			
			
			if (libretto != null)
			{
				SigitTLibTxtDto libTxt = getDbMgr().getTxtLibretto(libretto.getIdLibretto());
				file = XmlBeanUtils.readString(libTxt.getXmlLibretto());
				
			}

			result.setFile(file);
			result.setNomeDocumento(libretto.getFileIndex()+".xml");
			
			return result;
			
		}
		catch (ServiceException e) {
			log.error("ServiceException getLibrettoXML",e);
			throw e;
		}
		catch (Exception e) {
			log.error("Errore getLibrettoXML",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getLibrettoXML] END");
		}
	}
	*/
	
	public DettaglioDocumento getLibrettoPdfNow(String idImpianto, boolean isConsolidato, String codiceFiscalePF, String idPersonaGiuridica) throws ServiceException {
		log.debug("[ServiziMgr::indexSearchFolder] BEGIN");
		DettaglioDocumento result = new DettaglioDocumento();
		try{
			
			DettaglioDocumentoMultiplo docMultiplo = getLibrettoCompletoNow(idImpianto, isConsolidato, codiceFiscalePF, idPersonaGiuridica);
			
			
			if (docMultiplo != null)
			{
				result.setFile(docMultiplo.getDocumentoPdf().getFile());
				result.setNomeDocumento(docMultiplo.getDocumentoPdf().getNomeDocumento());
			}
		}
		catch(Exception e){
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		log.debug("[ServiziMgr::indexSearchFolder] END");
		return result;
	}
	
	/*
	public DettaglioDocumentoMultiplo getLibrettoCompletoNowOld(String idImpianto, boolean isConsolidato) throws ServiceException {
		log.debug("[ServiziMgr::indexSearchFolder] BEGIN");
		DettaglioDocumentoMultiplo result = new DettaglioDocumentoMultiplo();
		try{
			

			it.csi.sigit.sigitext.dto.sigitext.Utente utente = new  it.csi.sigit.sigitext.dto.sigitext.Utente();
			utente.setUtente(Constants.SIGITEXT_UTENTE);
			utente.setPassword(getProperties().getProperty(Constants.SIGITEXT_PWD));

			it.csi.sigit.sigitext.dto.sigitext.Libretto libretto = getSigitExt().getLibrettoNow(ConvertUtil.convertToInteger(idImpianto), isConsolidato, utente);

			DettaglioDocumento doc = new DettaglioDocumento();
		
			if (libretto.getLibrettoPdf() != null)
			{
				doc.setFile(libretto.getLibrettoPdf().getDoc());
				doc.setNomeDocumento(libretto.getLibrettoPdf().getNome());
//				doc.setPdfStatic(ConvertUtil.convertToBooleanAllways(libretto.getLibrettoPdf().getIsPdfStatico()));
			}
			
			result.setDocumentoPdf(doc);
			
			doc = new DettaglioDocumento();
			doc.setFile(libretto.getLibrettoXml());
			
			result.setDocumentoXml(doc);
			
		}
		catch(Exception e){
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		log.debug("[ServiziMgr::indexSearchFolder] END");
		return result;
	}
	*/
	
	public DettaglioDocumentoMultiplo getLibrettoCompletoNow(String idImpianto, boolean isConsolidato, String codiceFiscalePF, String idPersonaGiuridica) throws ServiceException {
		log.debug("[ServiziMgr::getLibrettoCompletoNow] BEGIN");
		DettaglioDocumentoMultiplo result = new DettaglioDocumentoMultiplo();
		try{
			
			JWTDto jwtDto = JWTUtil.generaTokenFruitoreInterno(codiceFiscalePF, idPersonaGiuridica);

			it.csi.sigit.sigitext.dto.sigitext.Libretto libretto = getSigitExtMgr().getLibrettoNowJWT(ConvertUtil.convertToInteger(idImpianto), isConsolidato, jwtDto.getToken());

			DettaglioDocumento doc = new DettaglioDocumento();
		
			if (libretto.getLibrettoPdf() != null)
			{
				doc.setFile(libretto.getLibrettoPdf().getDoc());
				doc.setNomeDocumento(libretto.getLibrettoPdf().getNome());
//				doc.setPdfStatic(ConvertUtil.convertToBooleanAllways(libretto.getLibrettoPdf().getIsPdfStatico()));
			}
			
			result.setDocumentoPdf(doc);
			
			doc = new DettaglioDocumento();
			doc.setFile(libretto.getLibrettoXml());
			
			result.setDocumentoXml(doc);
			
		}
		catch(Exception e){
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		log.debug("[ServiziMgr::getLibrettoCompletoNow] END");
		return result;
	}
	
	public DettaglioDocumentoIndex getDocumentoIndex(Integer idDocumento) throws ServiceException {
		log.debug("[ServiziMgr::getDocumentoIndex] BEGIN");
		DettaglioDocumentoIndex result = new DettaglioDocumentoIndex();
		try {
			
			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);

			InputStream in = null;
			String uid = null;

			SigitTDocAggiuntivaDto documentoDto = getDbMgr().cercaDocumentoAggById(idDocumento);
			result.setNomeAllegato(documentoDto.getNomeDocOriginale());
			if (documentoDto != null)
			{
				if (GenericUtil.isNotNullOrEmpty(documentoDto.getUidIndex()))
				{
					uid = documentoDto.getUidIndex();
					in = mtomDownloadFile(uid);
					result.setFile(in);
				}
			}

			return result;

		}catch (Exception e) {
				log.error("Errore getDocumentoIndex",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getDocumentoIndex] END");
		}
	}

	public DettaglioDocumentoIndex getFileIndexMtomByUid(String uid, String nomeFile) throws ServiceException {
		log.debug("[ServiziMgr::getFileIndexMtomByUid] BEGIN");
		DettaglioDocumentoIndex result = new DettaglioDocumentoIndex();
		try {
			
			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);

			InputStream in = null;
			result.setNomeAllegato(nomeFile);
			if (uid != null)
			{
				if (GenericUtil.isNotNullOrEmpty(uid))
				{
					in = mtomDownloadFile(uid);
					result.setFile(in);
				}
			}

			return result;

		}catch (Exception e) {
				log.error("Errore getFileIndexMtomByUid",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getFileIndexMtomByUid] END");
		}
	}
	
	public byte[] getFileIndexByUid(String uid, String nomeFile) throws ServiceException {
		log.debug("[ServiziMgr::getFileIndexByUid] BEGIN");
		try {

			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);

			byte[] file = null;
			if (GenericUtil.isNotNullOrEmpty(uid))
			{
				log.debug("getFileIndexByUid - cerco con l'UID: "+uid);
				file = indexOpenFileByUID(uid, nomeFile, oc);
			}

			return file;

		}catch (Exception e) {
			log.error("Errore getFileIndexByUid",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getFileIndexByUid] END");
		}
	}
	
	public DettaglioAllegatoIndex getAllegatoIndex(String idImpianto, String idAllegato) throws ServiceException {
		log.debug("[ServiziMgr::getAllegatoIndexNew] BEGIN");
		DettaglioAllegatoIndex result = new DettaglioAllegatoIndex();
		try {
		
			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
			
			byte[] file = null;
			String uid = null;
			
			// recupero l'allegato
			SigitVRicercaAllegatiDto allegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);
			if(allegato == null) {
				allegato = MapDto.mapToSigitVRicercaAllegatiDto(getDbMgr().cercaSigitVRicercaAllegatiStoricoByIdAllegato(idAllegato));
			}

			if (allegato != null)
			{
				if (GenericUtil.isNotNullOrEmpty(allegato.getUidIndex()))
				{
					uid = allegato.getUidIndex();
					log.debug("getAllegatoIndex - cerco con l'UID: "+uid);
					file = indexOpenFileByUID(uid, allegato.getNomeAllegato(), oc);
				}
				
				if (file == null)
				{
					SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(idImpianto);

					Metadati md = new Metadati();
					md.setCodiceImpianto(ConvertUtil.convertToString(impianto.getCodiceImpianto()));
					md.setCodIstatComune(impianto.getIstatComune());
					md.setCodIstatProvincia(StringUtils.substring(impianto.getIstatComune(), 0, 3));
					md.setDataRapporto(ConvertUtil.convertToString(allegato.getDataControllo()));
					md.setIdRapporto(ConvertUtil.convertToString(allegato.getIdAllegato()));
					
					
					
					log.debug("getAllegatoIndex - cerco con il nome file nel FOLDER ");
					uid = indexSearchUIDFileInFolderNew(allegato.getNomeAllegato(), md, oc, Constants.INDEX_FOLDER_REE);
					
					
					if (uid != null)
					{
						file = indexOpenFileByUID(uid, allegato.getNomeAllegato(), oc);
					}
				}
				
			}
			
			result.setFile(file);
			result.setNomeAllegato(allegato.getNomeAllegato());
			
			return result;
			
		}catch (Exception e) {
				log.error("Errore getAllegatoIndexNew",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getAllegatoIndex] END");
		}
	}

	public DettaglioAllegatoIndex getAllegatoIndexFirmato(String idImpianto, String idAllegato) throws ServiceException {
		log.debug("[ServiziMgr::getAllegatoIndexNew] BEGIN");
		DettaglioAllegatoIndex result = new DettaglioAllegatoIndex();
		try {

			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);

			byte[] file = null;
			String uid = null;

			// recupero l'allegato
			SigitVRicercaAllegatiDto allegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);
			if(allegato == null) {
				allegato = MapDto.mapToSigitVRicercaAllegatiDto(getDbMgr().cercaSigitVRicercaAllegatiStoricoByIdAllegato(idAllegato));
			}

			if (allegato != null)
			{
				if (GenericUtil.isNotNullOrEmpty(allegato.getUidIndex()))
				{
					uid = allegato.getUidIndex();
					log.debug("getAllegatoIndex - cerco con l'UID: "+uid);
					file = indexOpenFileByUID(uid, allegato.getNomeAllegato(), oc);
				}

				if (file == null)
				{
					SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(idImpianto);

					Metadati md = new Metadati();
					md.setCodiceImpianto(ConvertUtil.convertToString(impianto.getCodiceImpianto()));
					md.setCodIstatComune(impianto.getIstatComune());
					md.setCodIstatProvincia(StringUtils.substring(impianto.getIstatComune(), 0, 3));
					md.setDataRapporto(ConvertUtil.convertToString(allegato.getDataControllo()));
					md.setIdRapporto(ConvertUtil.convertToString(allegato.getIdAllegato()));



					log.debug("getAllegatoIndex - cerco con il nome file nel FOLDER ");
					uid = indexSearchUIDFileInFolderNew(allegato.getNomeAllegato(), md, oc, Constants.INDEX_FOLDER_REE);


					if (uid != null)
					{
						file = indexOpenFileByUID(uid, allegato.getNomeAllegato(), oc);
					}
				}

			}

			result.setFile(file);
			result.setNomeAllegato(allegato.getNomeAllegato());

			return result;

		}catch (Exception e) {
			log.error("Errore getAllegatoIndexNew",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getAllegatoIndex] END");
		}
	}
	
	public void mtomUploadFileGeneric(ImportFileSuper dataFile)throws ServiceException{
		log.debug("[ServiziMgr::mtomUploadFileGeneric] BEGIN");
        try{
            MtomOperationContext moc = mtomGetOperationContext();

            MtomNode node = new MtomNode(dataFile.getUidIndex(),Constants.INDEX_PREFIX_NAME);

            FileInputStream fis = new FileInputStream(dataFile.getFile());
            Attachment a = new Attachment();
            a.fileName = dataFile.getNomeFileMod();
            a.fileType = dataFile.getContentType();
            a.attachmentDataHandler = new DataHandler(new InputStreamDataSource(fis, dataFile.getContentType(), dataFile.getNomeFileMod()));

            log.debug("Prima della chiusura dell'upload ");

            node = getCxf().getEcmEngineMtomDelegateImpl().directUploadMethod(a, node, moc);

            log.debug("Prima della chiusura del fis");

            fis.close();
            log.debug("Dopo la chiusura del fis");

        }
        catch(Exception e){
        	log.error("Errore mtomUploadFileGeneric",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);

        }
        log.debug("[ServiziMgr::mtomUploadFileGeneric] END");
    }
	
//	SOSTITUITO DA METODO GENERICO
//	public void mtomUploadFile(ImportDistribFilter dataFile)throws ServiceException{
//		log.debug("[ServiziMgr::mtomUploadFile] BEGIN");
//        try{
//            MtomOperationContext moc = mtomGetOperationContext();
//
//            MtomNode node = new MtomNode(dataFile.getUidIndex(),Constants.INDEX_PREFIX_NAME);
//
//            FileInputStream fis = new FileInputStream(dataFile.getFile());
//            Attachment a = new Attachment();
//            a.fileName = dataFile.getNomeFileMod();
//            a.fileType = dataFile.getContentType();
//            a.attachmentDataHandler = new DataHandler(new InputStreamDataSource(fis, dataFile.getContentType(), dataFile.getNomeFileMod()));
//
//            log.debug("Prima della chiusura dell'upload ");
//
//            node = getCxf().directUploadMethod(a, node, moc);
//
//            log.debug("Prima della chiusura del fis");
//
//            fis.close();
//            log.debug("Dopo la chiusura del fis");
//
//        }
//        catch(Exception e){
//        	log.error("Errore mtomUploadFile",e);
//			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
//			
////        	Message message = msgMgr.getMessage(MsgCodeEnum.G002);
////            message.replacePlaceholder(Constants.ERR_MTOM);
////            throw new ServiceException(e, message);
//        }
//        log.debug("[ServiziMgr::mtomUploadFile] END");
//    }

//	SOSTITUITO DA METODO GENERICO
//	public void mtomUploadFile(ImportDocumentoFilter docFilter)throws ServiceException{
//		log.debug("[ServiziMgr::mtomUploadFile] BEGIN");
//        try{
//            MtomOperationContext moc = mtomGetOperationContext();
//
//            MtomNode node = new MtomNode(docFilter.getUidIndex(),Constants.INDEX_PREFIX_NAME);
//
//            FileInputStream fis = new FileInputStream(docFilter.getFile());
//            Attachment a = new Attachment();
//            a.fileName = docFilter.getNomeFileMod();
//            a.fileType = docFilter.getContentType();
//            a.attachmentDataHandler = new DataHandler(new InputStreamDataSource(fis, a.fileType, a.fileName));
//
//            log.debug("Prima della chiusura dell'upload ");
//
//            node = getCxf().directUploadMethod(a, node, moc);
//
//            log.debug("Prima della chiusura del fis");
//
//            fis.close();
//            log.debug("Dopo la chiusura del fis");
//
//        }
//        catch(Exception e){
//        	log.error("Errore mtomUploadFile",e);
//			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
//			
////        	Message message = msgMgr.getMessage(MsgCodeEnum.G002);
////            message.replacePlaceholder(Constants.ERR_MTOM);
////            throw new ServiceException(e, message);
//        }
//        log.debug("[ServiziMgr::mtomUploadFile] END");
//    }
	
	public InputStream mtomDownloadFile(String uidDoc)throws ServiceException{
		log.debug("[ServiziMgr::mtomUploadFile] BEGIN");
        try{
            MtomOperationContext moc = mtomGetOperationContext();

            MtomNode node = new MtomNode(uidDoc,Constants.INDEX_PREFIX_NAME);

            
            log.debug("Prima del downolad ");

            Attachment indeFile = getCxf().getEcmEngineMtomDelegateImpl().downloadMethod(node, moc);

            log.debug("Prima della creazione dell'input stream");
			InputStream in = indeFile.attachmentDataHandler.getInputStream();
			
            log.debug("Dopo il downolad ");

            return in;
        }
        catch(Exception e){
        	log.error("Errore mtomUploadFile",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			
//        	Message message = msgMgr.getMessage(MsgCodeEnum.G002);
//            message.replacePlaceholder(Constants.ERR_MTOM);
//            throw new ServiceException(e, message);
        }
        finally
        {
        	log.debug("[ServiziMgr::mtomUploadFile] END");
        }
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
    
	public InvioDocument getRicevutaAllegato(String idAllegato, String actionPageBack) throws ServiceException {
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
			SigitVRicercaAllegatiDto allegatoDB = dbMgr.cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);


			if(allegatoDB != null) {

				//SigitRImpManutDto sigitRImpManut = getCommonDbMgr().getImpManutByPrimaryKey(rapporto.getFkImpManut());
							
				intestazione = invio.addNewIntestazione();
				descrizione = invio.addNewDescrizione();
				infoImpianto = invio.addNewInfoImpianto();
				infoRapporto = invio.addNewInfoRapporto();
				footer = invio.addNewFooter();
				
				// PAGINA DI RITORNO
				invio.setSubmitIndietroDo(actionPageBack);
				
				codiceRea = MapDto.getCodiceRea(allegatoDB.getPgSiglaRea(), ConvertUtil.convertToInteger(allegatoDB.getPgNumeroRea()));
				
				
				if (allegatoDB.getRuoloFunz().equalsIgnoreCase(Constants.RUOLO_ISPETTORE))
				{
					// E' un allegato collegato ad una ispezione
					// Devo recuperare l'ente ispettore
					DettaglioIspezione dettaglioIspezione = getDbMgr().getDettaglioIspezioneByIdIspezIspet(ConvertUtil.convertToInteger(allegatoDB.getFkIspezIspet()));
					descrizione.setRagioneSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
					
				}
				else
				{
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
				}
				
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
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getRicevutaAllegato] END");
		}
	}
	
	public ImportDistribDocument getRicevutaImportDistrib(Integer idImportDistrib, String actionPageBack) throws ServiceException {
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
				
				// PAGINA DI RITORNO
				//invio.setSubmitIndietroDo(actionPageBack);
				
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
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getRicevutaImportDistrib] END");
		}
	}
	
	
	public it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument getAllegato(DettaglioAllegato da, boolean isAllegatoInInsert) throws ServiceException
	{
		log.debug("[ServiziMgr::getAllegato] START");
		
		log.debug("[ServiziMgr::getAllegato] **************************************** ID ALLEGATO: "+da.getIdAllegato());
		
		it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument modAllegato = it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument.Factory.newInstance();
		try{
			String codImpianto = da.getCodiceImpianto();
			
			//in questo oggetto setto il responsabile dell'impianto
			SigitVTotImpiantoDto vTotImpiantoResp = null;

			//in questo oggetto setto il 3resonsabile (se c'e')
			SigitVRicerca3ResponsabileDto v3Resp = null;
			
			BigDecimal idRuolo = null;
			String denominazioneComuneResp = null;
			String siglaProvinciaResp = null;

			// Se il responsabile e una PF
			PersonaFisica pfResp = null;
			// Se il responsabile e una PG
			PersonaGiuridica pgResp = null;

			//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			PersonaGiuridica pg = null;

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			List<SigitVTotImpiantoDto> listResp = getDbMgr().cercaResponsabiliAttiviAllaDataByCodImpianto(da.getCodiceImpianto(), da.getDataControllo());
			if(listResp!=null && !listResp.isEmpty()){

				vTotImpiantoResp = listResp.get(0);
				idRuolo = vTotImpiantoResp.getIdRuolo();
				denominazioneComuneResp = vTotImpiantoResp.getDenominazioneComune();
				siglaProvinciaResp = vTotImpiantoResp.getSiglaProvincia();
			
				if(vTotImpiantoResp.getPfPg().equals(Constants.LABEL_PF))
				{
					pfResp = getDbMgr().cercaPersonaFisicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
				}else{
					pgResp = getDbMgr().cercaPersonaGiuridicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
				}
			}
			
			// Devo settare il responsabile/3 responsabile
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(da.getCodiceImpianto(), da.getDataControllo());
			if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
			{
				v3Resp = list3RespAttiviImpianto.get(0);
				pg = getDbMgr().cercaPersonaGiuridicaById(v3Resp.getFkPg3Resp().intValue());
				idRuolo = v3Resp.getFkRuolo();
				denominazioneComuneResp = v3Resp.getDenomComune3Resp();
				siglaProvinciaResp = v3Resp.getSiglaProv3Resp();
			}
			else
			{
				idRuolo = vTotImpiantoResp.getIdRuolo();
				denominazioneComuneResp = vTotImpiantoResp.getDenominazioneComune();
				siglaProvinciaResp = vTotImpiantoResp.getSiglaProvincia();
				pg = pgResp;
			}
			
			
			SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice = null;
			DettaglioIspezione dettaglioIspezione = null;
			// Se l'id ispezione e' valorizzato vuol dire che provengo delle ispezioni
			if (GenericUtil.isNotNullOrEmpty(da.getIdIspezione()))
			{
				// Recupero l'ispezione
				dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(da.getIdIspezione());
			}
			else
			{
				//cerco i dati dell'impresa manutentrice
				dettaglioImpresaManutentrice = getDbMgr().cercaTPersonaGiuridicaById(da.getIdPersonaGiuridica());
			}
			
			//dati locazione impianto
			List<SigitTUnitaImmobiliareDto> unitaImmobList = getDbMgr().getUnitaImmobiliariImpianto(new Integer(codImpianto));
			
			//sezione c. TRATTAMENTO DELL'ACQUA
			SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk();
			pkTrattAcqua.setCodiceImpianto(new BigDecimal(codImpianto));
			SigitTTrattH2ODto dettaglioTrattAcqua = this.getDbMgr().getSigitTTrattH2oDao().findByPrimaryKey(pkTrattAcqua );
		
			//CONTROLLO SE SONO IN MODIFICA O IN INSERIMENTO
			if(GenericUtil.isNotNullOrEmpty(da.getIdAllegato()) && !isAllegatoInInsert){
				//MODIFICA
				log.debug("[ServiziMgr::getAllegato] ****************************** MODIFICA ********************************************* ");
		
				//trovo il dettaglio dell'allegato con il suo xml salvato che devo visualizzare
				SigitTAllTxtDto allegatoTxt = getDbMgr().getAllTxtAllegato(ConvertUtil.convertToBigDecimal(da.getIdAllegato()));

				byte[] moduloXml = XmlBeanUtils.readString(allegatoTxt.getXmlAllegato());
				
				//lo ritrasformo in oggetto MODIIDocument
				modAllegato = MapDto.mapToMODIIDocument(moduloXml);
				
				//riaggiorno i dati che potrebbero cambiare
				it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta modRichiesta = modAllegato.getMODII().getRichiesta();
				//setto l'idAllegato che sto modificando
				modRichiesta.getDatiModulo().setIdAllegato(da.getIdAllegato());
				
				List<RowAllegatoII> modListaRowII = modRichiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
				
				if(modListaRowII!=null && modListaRowII.size()>0)
				{
					log.debug("[ServiziMgr::getAllegato] ***** MODIFICA ***** DENTRO LA LISTA ROWII --> dimensione: "+modListaRowII.size());
					
					for(RowAllegatoII rowAllegatoIIDto : modListaRowII){
						
						//per la parte di catasto
						MapDto.mapSezCatastoAllegatoTipo1(rowAllegatoIIDto, unitaImmobList, denominazioneComuneResp, siglaProvinciaResp);
						
						rowAllegatoIIDto.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(false));
						//setto i valori dell'impianto(comuni a tutte le pagine
						if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty())
						{
							if(Constants.ID_RUOLO_AMMINISTRATORE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == idRuolo.intValue())
							{
								rowAllegatoIIDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(true));
								rowAllegatoIIDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(false));
								rowAllegatoIIDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(false));
							}
							if(Constants.ID_RUOLO_OCCUPANTE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == idRuolo.intValue())
							{
								rowAllegatoIIDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(true));
								rowAllegatoIIDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(false));
								rowAllegatoIIDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(false));
							}
							if(Constants.ID_RUOLO_PROPRIETARIO == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == idRuolo.intValue())
							{
								rowAllegatoIIDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(true));
								rowAllegatoIIDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(false));
								rowAllegatoIIDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(false));
							}
						}
						else
						{
							rowAllegatoIIDto.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(true));
							rowAllegatoIIDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(false));
							rowAllegatoIIDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(false));
							rowAllegatoIIDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(false));
						}
						
						// dati responsabile impianto
						if(pg!=null)
						{
							rowAllegatoIIDto.setAA2RagSociale(pg.getDenominazione());
							rowAllegatoIIDto.setAA2Piva(pg.getCodiceFiscale());
							rowAllegatoIIDto.setAA2Cf(null);
							rowAllegatoIIDto.setAA2Cognome(null);
							rowAllegatoIIDto.setAA2Nome(null);

							if (ConvertUtil.convertToBooleanAllways(pg.getFlgIndirizzoEst()))
							{
								rowAllegatoIIDto.setAA2Indirizzo(pg.getEstIndirizzo());
								rowAllegatoIIDto.setAA2Comune(GenericUtil.getStringValid(pg.getEstCitta()) + " ("+GenericUtil.getStringValid(pg.getEstStato())+")");
								rowAllegatoIIDto.setAA2Prov(null);
							}
							else
							{
								rowAllegatoIIDto.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pg.getIndirizzo()) ? pg.getIndirizzo() : pg.getIndirizzoNonTrovato());
								rowAllegatoIIDto.setAA2Comune(pg.getComune());
								rowAllegatoIIDto.setAA2Prov(pg.getIdProvinciaSelez());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							rowAllegatoIIDto.setAA2Civico(pg.getCivico());
							
						}
						else
						{
							rowAllegatoIIDto.setAA2Cognome(pfResp.getCognome());
							rowAllegatoIIDto.setAA2Nome(pfResp.getNome());
							rowAllegatoIIDto.setAA2RagSociale(null);
							rowAllegatoIIDto.setAA2Piva(null);
							rowAllegatoIIDto.setAA2Cf(pfResp.getCodiceFiscale());
							
							if (ConvertUtil.convertToBooleanAllways(pfResp.getFlgIndirizzoEst()))
							{
								rowAllegatoIIDto.setAA2Indirizzo(pfResp.getEstIndirizzo());
								rowAllegatoIIDto.setAA2Comune(GenericUtil.getStringValid(pfResp.getEstCitta()) + " ("+GenericUtil.getStringValid(pfResp.getEstStato())+")");
								rowAllegatoIIDto.setAA2Prov(null);

							}
							else
							{
								rowAllegatoIIDto.setAA2Prov(pfResp.getIdProvinciaSelez());
								rowAllegatoIIDto.setAA2Comune(pfResp.getComune());
								rowAllegatoIIDto.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pfResp.getIndirizzo()) ? pfResp.getIndirizzo() : pfResp.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							rowAllegatoIIDto.setAA2Civico(pfResp.getCivico());
						}
						
						//impresa manutentrice
						if(dettaglioImpresaManutentrice!=null){
							rowAllegatoIIDto.setAA3RagSociale(dettaglioImpresaManutentrice.getDenominazione());
							rowAllegatoIIDto.setAA3Piva(dettaglioImpresaManutentrice.getCodiceFiscale());
							
							if (ConvertUtil.convertToBooleanAllways(dettaglioImpresaManutentrice.getFlgIndirizzoEstero()))
							{
								rowAllegatoIIDto.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoEstero());
								rowAllegatoIIDto.setAA3Comune(GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCittaEstero()) + " ("+GenericUtil.getStringValid(dettaglioImpresaManutentrice.getStatoEstero())+")");
								rowAllegatoIIDto.setAA3Prov(null);

							}
							else
							{
								rowAllegatoIIDto.setAA3Comune(dettaglioImpresaManutentrice.getComune());
								rowAllegatoIIDto.setAA3Prov(dettaglioImpresaManutentrice.getSiglaProv());

								if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoSitad()))
									rowAllegatoIIDto.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoSitad());
								else if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoNonTrovato()))
									rowAllegatoIIDto.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoNonTrovato());
								
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							rowAllegatoIIDto.setAA3Civico(dettaglioImpresaManutentrice.getCivico());
						}
						else if (dettaglioIspezione != null)
						{
							rowAllegatoIIDto.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
						}
						
					}//chiude il for sulle pagine di modulo
				}
				
				
			}else{
				
				//xxx
				
				//INSERIMENTO
				log.debug("[ServiziMgr::getAllegato] ****************************** INSERIMENTO ********************************************* ");
				//istanzio gli oggetti per modol
				it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument.MODII mod = modAllegato.addNewMODII();
				it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = mod.addNewRichiesta();
				List<RowAllegatoII> listaRow = richiesta.addNewDatiAllegato().addNewAllegatoII().getRowAllegatoIIList();
				modAllegato.getMODII().addNewSystem().addNewCatDig();
				//dati che sono comuni e non ripetuti per ogni pagina
				DatiModulo datiModulo = richiesta.addNewDatiModulo();
				DatiIntestazione datiIntestazione = richiesta.addNewDatiIntestazione();
				datiIntestazione.setCodiceBollino(ConvertUtil.formattaSiglaBollino(ConvertUtil.convertToBigDecimal(da.getNumeroBollinoVerde())));
				datiModulo.setStatoModulo(Constants.STATO_MODULO_BOZZA);
				log.debug("[ServiziMgr::getAllegato] ****** INSERIMENTO *****  da.getIdAllegato(): "+da.getIdAllegato());
				//setto l'idAllegato dentro il modulo
				datiModulo.setIdAllegato(da.getIdAllegato());
				
				//bisogna creare tante pagine quanti sono i risultati della seguente lista
				RowAllegatoII datiPrecompilati = null;
				
				List<SigitVSk4GtDto> listGt = null;
				
				log.debug("STAMPO da.getIdApparecchiature(): "+da.getIdApparecchiature());
				
				if (da.getIdApparecchiature() != null && da.getIdApparecchiature().size() > 0)
				{
					log.debug("C'e' la lista apparecchiature, quantita: "+da.getIdApparecchiature().size());

					// Recupero solo le apparecchiature selezionate nella pagina precedente
					listGt = getDbMgr().getCompGtAttiviInDataProgressivi(codImpianto, da.getDataControllo(), da.getIdApparecchiature());
				}
				else
				{
					log.debug("Recupero tutte le apparecchiature");
					
					// recupero tutte le apparecchiature
					listGt = getDbMgr().getCompGtAttiviInData(codImpianto, ConvertUtil.convertToDate(da.getDataControllo()));
				}
				
				if(listGt!=null){
					log.debug("[ServiziMgr::getAllegato] FRAAAAAAAAAAAAAAAAAAAAAAA---> LUNGHEZZA LISTA: "+listGt.size());
				
					for (SigitVSk4GtDto dto : listGt) {
						
						datiPrecompilati = RowAllegatoII.Factory.newInstance();
						
						datiPrecompilati.setCodiceCatasto(codImpianto);
						datiPrecompilati.setAFDataControllo(ConvertUtil.convertToXmlCalendar(ConvertUtil.convertToSqlDate(da.getDataControllo())));
						//campi obbligatori che cambiano a seconda della pagina
						datiPrecompilati.setAEDataInstallaz(ConvertUtil.convertToXmlCalendar(dto.getDataInstall()));
						datiPrecompilati.setAENumGT(ConvertUtil.convertToBigInteger(dto.getProgressivo()));
						//campi che non cambiano per le pagine
						datiPrecompilati.setAECombustibile(dto.getDesCombustibile());
						datiPrecompilati.setAEIDcombustibile(ConvertUtil.convertToString(dto.getIdCombustibile()));
						datiPrecompilati.setAEFabbricante(dto.getDesMarca());
						datiPrecompilati.setAEMatricola(dto.getMatricola());
						datiPrecompilati.setAEModello(dto.getModello());
						datiPrecompilati.setAEPotenzaNomUtile(dto.getPotenzaTermicaKw());
						if(Constants.ID_DETT_GT_GRUPPO_TERM_SING.equals(ConvertUtil.convertToString(dto.getFkDettaglioGt())));{
							datiPrecompilati.xsetAEGTsingolo(MapDto.getXmlBoolean(true));
							datiPrecompilati.xsetAEGTModulare(MapDto.getXmlBoolean(false));
							datiPrecompilati.xsetAETupoRadiante(MapDto.getXmlBoolean(false));
							datiPrecompilati.xsetAEGenAriaCalda(MapDto.getXmlBoolean(false));
						}
						if(Constants.ID_DETT_GT_GRUPPO_TERM_MOD.equals(ConvertUtil.convertToString(dto.getFkDettaglioGt()))){
							datiPrecompilati.xsetAEGTModulare(MapDto.getXmlBoolean(true));
							datiPrecompilati.xsetAEGTsingolo(MapDto.getXmlBoolean(false));
							datiPrecompilati.xsetAETupoRadiante(MapDto.getXmlBoolean(false));
							datiPrecompilati.xsetAEGenAriaCalda(MapDto.getXmlBoolean(false));
						}
						if(Constants.ID_DETT_GT_TUBO_RADIANTE.equals(ConvertUtil.convertToString(dto.getFkDettaglioGt()))){
							datiPrecompilati.xsetAETupoRadiante(MapDto.getXmlBoolean(true));
							datiPrecompilati.xsetAEGTModulare(MapDto.getXmlBoolean(false));
							datiPrecompilati.xsetAEGTsingolo(MapDto.getXmlBoolean(false));
							datiPrecompilati.xsetAEGenAriaCalda(MapDto.getXmlBoolean(false));
						}
						if(Constants.ID_DETT_GT_GEN_ARIA_CALDA.equals(ConvertUtil.convertToString(dto.getFkDettaglioGt()))){
							datiPrecompilati.xsetAEGenAriaCalda(MapDto.getXmlBoolean(true));
							datiPrecompilati.xsetAETupoRadiante(MapDto.getXmlBoolean(false));
							datiPrecompilati.xsetAEGTModulare(MapDto.getXmlBoolean(false));
							datiPrecompilati.xsetAEGTsingolo(MapDto.getXmlBoolean(false));
						}
							
						//setto i valori dell'impianto(comuni a tutte le pagine
						if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty())
						{
							if(Constants.ID_RUOLO_AMMINISTRATORE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == idRuolo.intValue())
								datiPrecompilati.xsetAA2FlagAmministr(MapDto.getXmlBoolean(true));
							if(Constants.ID_RUOLO_OCCUPANTE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == idRuolo.intValue())
								datiPrecompilati.xsetAA2FlagOccupante(MapDto.getXmlBoolean(true));
							if(Constants.ID_RUOLO_PROPRIETARIO == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == idRuolo.intValue())
								datiPrecompilati.xsetAA2FlagProprietario(MapDto.getXmlBoolean(true));
						}
						else
						{
							datiPrecompilati.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(true));
						}
						
						log.debug("[ServiziMgr::getAllegato]  ---> responsabile ed unità immobiliare *************** ");
						MapDto.mapSezCatastoAllegatoTipo1(datiPrecompilati, unitaImmobList, denominazioneComuneResp, siglaProvinciaResp);
						
						// dati responsabile impianto
						if(pg != null)
						{
							datiPrecompilati.setAA2RagSociale(pg.getDenominazione());
							datiPrecompilati.setAA2Piva(pg.getCodiceFiscale());

							if (ConvertUtil.convertToBooleanAllways(pg.getFlgIndirizzoEst()))
							{
								datiPrecompilati.setAA2Indirizzo(pg.getEstIndirizzo());
								datiPrecompilati.setAA2Comune(GenericUtil.getStringValid(pg.getEstCitta()) + " ("+GenericUtil.getStringValid(pg.getEstStato())+")");
								datiPrecompilati.setAA2Prov(null);
							}
							else
							{
								datiPrecompilati.setAA2Prov(pg.getIdProvinciaSelez());
								datiPrecompilati.setAA2Comune(pg.getComune());
								datiPrecompilati.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pg.getIndirizzo()) ? pg.getIndirizzo() : pg.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							datiPrecompilati.setAA2Civico(pg.getCivico());

							datiPrecompilati.setAA2Cognome(null);
							datiPrecompilati.setAA2Nome(null);
							datiPrecompilati.setAA2Cf(null);

						}
						else
						{
							datiPrecompilati.setAA2Cf(pfResp.getCodiceFiscale());
							datiPrecompilati.setAA2Cognome(pfResp.getCognome());
							datiPrecompilati.setAA2Nome(pfResp.getNome());
							
							if (ConvertUtil.convertToBooleanAllways(pfResp.getFlgIndirizzoEst()))
							{
								datiPrecompilati.setAA2Indirizzo(pfResp.getEstIndirizzo());
								datiPrecompilati.setAA2Comune(GenericUtil.getStringValid(pfResp.getEstCitta()) + " ("+GenericUtil.getStringValid(pfResp.getEstStato())+")");
								datiPrecompilati.setAA2Prov(null);
							}
							else
							{
								datiPrecompilati.setAA2Prov(pfResp.getIdProvinciaSelez());
								datiPrecompilati.setAA2Comune(pfResp.getComune());
								datiPrecompilati.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pfResp.getIndirizzo()) ? pfResp.getIndirizzo() : pfResp.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							datiPrecompilati.setAA2Civico(pfResp.getCivico());

							datiPrecompilati.setAA2RagSociale(null);
							datiPrecompilati.setAA2Piva(null);
						}
						
						//impresa manutentrice
						if(dettaglioImpresaManutentrice!=null){
							datiPrecompilati.setAA3RagSociale(dettaglioImpresaManutentrice.getDenominazione());
							datiPrecompilati.setAA3Piva(dettaglioImpresaManutentrice.getCodiceFiscale());

							if (ConvertUtil.convertToBooleanAllways(dettaglioImpresaManutentrice.getFlgIndirizzoEstero()))
							{
								datiPrecompilati.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoEstero());
								datiPrecompilati.setAA3Comune(GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCittaEstero()) + " ("+GenericUtil.getStringValid(dettaglioImpresaManutentrice.getStatoEstero())+")");
								datiPrecompilati.setAA3Prov(null);
							}
							else
							{
								datiPrecompilati.setAA3Prov(dettaglioImpresaManutentrice.getSiglaProv());
								datiPrecompilati.setAA3Comune(dettaglioImpresaManutentrice.getComune());
								if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoSitad()))
									datiPrecompilati.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoSitad());
								else if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoNonTrovato()))
									datiPrecompilati.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoNonTrovato());
							}
							
							datiPrecompilati.setAA3Civico(dettaglioImpresaManutentrice.getCivico());
						}
						else if (dettaglioIspezione != null)
						{
							datiPrecompilati.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
						}
						
						//SEZIONE C. Trattamento dell'acqua
						TrattamentoAcqua trattamentoAcqua = TrattamentoAcqua.Factory.newInstance();
						if(dettaglioTrattAcqua!=null){
							log.debug("FRAAAAAAAAAAA --- > trattamento acqua ");
							trattamentoAcqua.setACDurezzaTotH2O(dettaglioTrattAcqua.getL22DurezzaH2oFr());
							if(dettaglioTrattAcqua.getL23FlgTrattClimaAssente() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaAssente().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OAssente(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OAssente(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaFiltr().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OFiltraz(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OFiltraz(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaAddolc().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OAddolcim(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OAddolcim(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL23FlgTrattClimaChimico() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaChimico().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OCondizChimico(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OCondizChimico(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL24FlgTrattAcsAssente() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL24FlgTrattAcsAssente().intValue())
								trattamentoAcqua.xsetACFlagTrattAcsAssente(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattAcsAssente(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL24FlgTrattAcsFiltr() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL24FlgTrattAcsFiltr().intValue())
								trattamentoAcqua.xsetACFlagTrattAcsFiltraz(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattAcsFiltraz(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL24FlgTrattAcsAddolc() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL24FlgTrattAcsAddolc().intValue())
								trattamentoAcqua.xsetACFlagTrattAcsAddolcim(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattAcsAddolcim(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL24FlgTrattAcsChimico() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL24FlgTrattAcsChimico().intValue())
								trattamentoAcqua.xsetACFlagTrattAcsCondizChimico(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattAcsCondizChimico(MapDto.getXmlBoolean(false));
							}
							
							datiPrecompilati.setTrattamentoAcqua(trattamentoAcqua);
						}
						
						//devo creare tante istanze di RowFumi quanti sono gli n_moduli(può arrivare null, 0, 1,2,...)
						log.debug("FRAAAAAAAAAAA --- > "+dto.getNModuli());
						RowFumi rowFumi = null;
						if(dto.getNModuli() == null || dto.getNModuli().intValue() == 0){
							log.debug("FRAAAAAAAAAAA --- > nel null oppure se è zero");
							List<RowFumi> listaRowFumi = datiPrecompilati.addNewTabFumi().getRowFumiList();
							//istanzio la lista di RowFumi
							if(listaRowFumi!=null && listaRowFumi.size()>0){
								listaRowFumi.clear();
							}
							rowFumi = RowFumi.Factory.newInstance();
							rowFumi.setAETempFumi(null);
							rowFumi.setAETempAria(null);
							rowFumi.setAEO2(null);
							rowFumi.setAECO2(null);
							rowFumi.setAEBacharach1(null);
							rowFumi.setAEBacharach2(null);
							rowFumi.setAEBacharach3(null);
							rowFumi.setAECOcorretto(null);
							rowFumi.setAERendimCombu(null);
							rowFumi.setAERendimentoLegge(null);
							rowFumi.setAENox(null);
							//da valorizzare di default
							rowFumi.setAEModuloTermico(new BigDecimal("1"));
//							rowFumi.setAEPortataCombu(null);
//							rowFumi.setAEValorePortata(null);
//							rowFumi.setAECOfumiSecchi(null);
//							rowFumi.setAERispettoIndBacharach(null);
//							rowFumi.setAEMinimo(null);
							listaRowFumi.add(rowFumi);
							log.debug("FRAAAAAAAAAAA --- > nel null oppure se è zero dimensione lista : "+listaRowFumi.size());
						}else{
							int count = dto.getNModuli().intValue();
							log.debug("FRAAAAAAAAAAA ---  count > "+count);
							//istanzio la lista di RowFumi
							List<RowFumi> listaRowFumi = datiPrecompilati.addNewTabFumi().getRowFumiList();
							if(listaRowFumi!=null && listaRowFumi.size()>0){
								log.debug("FRAAAAAAAAAAA ---  sta pulendo ");
								listaRowFumi.clear();
							}
							
							log.debug("FRAAAAAAAAAAA --- > ADESSO dimensione listaRowFumi: "+listaRowFumi.size());
							for(int i = 1; i<=count; i++){
								log.debug("FRAAAAAAAAAAAAAAA NEL FOR i: "+i);
								rowFumi = RowFumi.Factory.newInstance();
								rowFumi.setAETempFumi(null);
								rowFumi.setAETempAria(null);
								rowFumi.setAEO2(null);
								rowFumi.setAECO2(null);
								rowFumi.setAEBacharach1(null);
								rowFumi.setAEBacharach2(null);
								rowFumi.setAEBacharach3(null);
								rowFumi.setAECOcorretto(null);
								rowFumi.setAERendimCombu(null);
								rowFumi.setAERendimentoLegge(null);
								rowFumi.setAENox(null);
								//da valorizzare di default
								rowFumi.setAEModuloTermico(ConvertUtil.convertToBigDecimal(i));
//								rowFumi.setAEPortataCombu(null);
//								rowFumi.setAEValorePortata(null);
//								rowFumi.setAECOfumiSecchi(null);
//								rowFumi.setAERispettoIndBacharach(null);
//								rowFumi.setAEMinimo(null);
								listaRowFumi.add(rowFumi);
								
								log.debug("FRAAAAAAAAAAAAAAA NEL FOR DIMENSIONE: "+listaRowFumi.size());
							}
						}
						
						//a questo punto setto l'oggetto che si ripete dentro l'arrayList del modulo
						listaRow.add(datiPrecompilati);
						
					} //chiede il for sulle pagine da duplicare
				}
				
			}
			
		    if(da.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_ALLEGATI))
		    	modAllegato.getMODII().getRichiesta().getDatiModulo().setURLchiudi(Constants.RETURN_PAGE_ELENCO_ALLEGATI_DA_PDF);
		    else if(da.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_IMPIANTO))
	    		modAllegato.getMODII().getRichiesta().getDatiModulo().setURLchiudi(Constants.RETURN_PAGE_ELENCO_ALLEGATI_IMPIANTO_DA_PDF);
		    else if(da.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_IMPIANTO_ISP))
	    		modAllegato.getMODII().getRichiesta().getDatiModulo().setURLchiudi(Constants.RETURN_PAGE_ELENCO_ALLEGATI_IMPIANTO_ISP_DA_PDF);
			
			if (log.isDebugEnabled())
			{
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				log.debug("STAMPO ALLEGATOII RESULT: "+modAllegato);
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}
		}
		catch (Exception e) {
			log.error("Errore getAllegato",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getAllegato] END");
		}
		return modAllegato;
	}
	
	
	
	public it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument getAllegatoTipo2(DettaglioAllegato da, boolean isAllegatoInInsert) throws ServiceException
	{
		log.debug("[ServiziMgr::getAllegatoTipo2] START");
		
		log.debug("[ServiziMgr::getAllegatoTipo2] **************************************** ID ALLEGATO: "+da.getIdAllegato());
		
		it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument modAllegato = it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument.Factory.newInstance();
		try{
			String codImpianto = da.getCodiceImpianto();
			
			//mi vado a cercare i dati dell'impresa manutentrice
			SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice = null;
			DettaglioIspezione dettaglioIspezione = null;
			// Se l'id ispezione e' valorizzato vuol dire che provengo delle ispezioni
			if (GenericUtil.isNotNullOrEmpty(da.getIdIspezione()))
			{
				// Recupero l'ispezione
				dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(da.getIdIspezione());
			}
			else
			{
				//mi vado a cercare i dati dell'impresa manutentrice
				dettaglioImpresaManutentrice = getDbMgr().cercaTPersonaGiuridicaById(da.getIdPersonaGiuridica());
			}
			
			//dati locazione impianto
			List<SigitTUnitaImmobiliareDto> unitaImmobList = getDbMgr().getUnitaImmobiliariImpianto(new Integer(codImpianto));
			
			
			//in questo oggetto setto il responsabile dell'impianto
			SigitVTotImpiantoDto vTotImpiantoResp = null;

			//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			SigitVRicerca3ResponsabileDto v3Resp = null;
			BigDecimal idRuolo = null;
			String denominazioneComuneResp;
			String siglaProvinciaResp;

			// Se il responsabile e una PF
			PersonaFisica pfResp = null;
			// Se il responsabile e una PG
			PersonaGiuridica pgResp = null;

			//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			PersonaGiuridica pg = null;

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			List<SigitVTotImpiantoDto> listResp = getDbMgr().cercaResponsabiliAttiviAllaDataByCodImpianto(da.getCodiceImpianto(), da.getDataControllo());
			if(listResp!=null && !listResp.isEmpty()){

				vTotImpiantoResp = listResp.get(0);
				idRuolo = vTotImpiantoResp.getIdRuolo();
				denominazioneComuneResp = vTotImpiantoResp.getDenominazioneComune();
				siglaProvinciaResp = vTotImpiantoResp.getSiglaProvincia();
			
				if(vTotImpiantoResp.getPfPg().equals(Constants.LABEL_PF))
				{
					pfResp = getDbMgr().cercaPersonaFisicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
				}else{
					pgResp = getDbMgr().cercaPersonaGiuridicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
				}
				
			}
			
			// Devo settare il responsabile/3 responsabile
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(da.getCodiceImpianto(), da.getDataControllo());
			if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
			{
				//TERZO RESPONSABILE TROVATO
				v3Resp = list3RespAttiviImpianto.get(0);
				idRuolo = v3Resp.getFkRuolo();
				denominazioneComuneResp = v3Resp.getDenomComune3Resp();
				siglaProvinciaResp = v3Resp.getSiglaProv3Resp();
				pg = getDbMgr().cercaPersonaGiuridicaById(v3Resp.getFkPg3Resp().intValue());
			}
			else
			{
				//TERZO RESPONSABILE NON TROVATO - RIPIEGO SUL RESPONSABILE
				idRuolo = vTotImpiantoResp.getIdRuolo();
				denominazioneComuneResp = vTotImpiantoResp.getDenominazioneComune();
				siglaProvinciaResp = vTotImpiantoResp.getSiglaProvincia();
				pg = pgResp;
			}
		
			//CONTROLLO SE SONO IN MODIFICA O IN INSERIMENTO
			if(GenericUtil.isNotNullOrEmpty(da.getIdAllegato()) && !isAllegatoInInsert){
				//MODIFICA
				log.debug("[ServiziMgr::getAllegatoTipo2] ****************************** MODIFICA ********************************************* ");
				
				//trovo il dettaglio dell'allegato con il suo xml salvato che devo visualizzare
				SigitTAllTxtDto allegatoTxt = getDbMgr().getAllTxtAllegato(ConvertUtil.convertToBigDecimal(da.getIdAllegato()));

				byte[] moduloXml = XmlBeanUtils.readString(allegatoTxt.getXmlAllegato());
				
				//lo ritrasformo in oggetto MODIIDocument
				modAllegato = MapDto.mapToMODIIIDocument(moduloXml);
				//riaggiorno i dati che potrebbero cambiare
				it.csi.sigit.sigitwebn.xml.allegato3.data.RichiestaDocument.Richiesta modRichiesta = modAllegato.getMODIII().getRichiesta();
				//setto l'idAllegato che sto modificando
				modRichiesta.getDatiModulo().setIdAllegato(da.getIdAllegato());
				
				List<RowAllegatoIII> modListaRowIII = modRichiesta.getDatiAllegato().getAllegatoIII().getRowAllegatoIIIList();
				
				if(modListaRowIII!=null && modListaRowIII.size()>0)
				{
					log.debug("[ServiziMgr::getAllegatoTipo2] ***** MODIFICA ***** DENTRO LA LISTA ROWII --> dimensione: "+modListaRowIII.size());
					
					for(RowAllegatoIII rowAllegatoIIIDto : modListaRowIII){
						
						//per la parte di catasto
						MapDto.mapSezCatastoAllegatoTipo2(rowAllegatoIIIDto, unitaImmobList, denominazioneComuneResp, siglaProvinciaResp);
						
						rowAllegatoIIIDto.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(false));
						//setto i valori dell'impianto(comuni a tutte le pagine
						if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty())
						{
							if(Constants.ID_RUOLO_AMMINISTRATORE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == idRuolo.intValue())
							{
								rowAllegatoIIIDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(true));
								rowAllegatoIIIDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(false));
								rowAllegatoIIIDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(false));
							}
							if(Constants.ID_RUOLO_OCCUPANTE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == idRuolo.intValue())
							{
								rowAllegatoIIIDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(true));
								rowAllegatoIIIDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(false));
								rowAllegatoIIIDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(false));
							}
							if(Constants.ID_RUOLO_PROPRIETARIO == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == idRuolo.intValue())
							{
								rowAllegatoIIIDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(true));
								rowAllegatoIIIDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(false));
								rowAllegatoIIIDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(false));
							}
						}
						else
						{
							rowAllegatoIIIDto.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(true));
							rowAllegatoIIIDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(false));
							rowAllegatoIIIDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(false));
							rowAllegatoIIIDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(false));
						}
						
						// dati responsabile impianto
						if(pg!=null)
						{
							rowAllegatoIIIDto.setAA2RagSociale(pg.getDenominazione());
							rowAllegatoIIIDto.setAA2Piva(pg.getCodiceFiscale());
							
							if (ConvertUtil.convertToBooleanAllways(pg.getFlgIndirizzoEst()))
							{
								rowAllegatoIIIDto.setAA2Indirizzo(pg.getEstIndirizzo());
								rowAllegatoIIIDto.setAA2Comune(GenericUtil.getStringValid(pg.getEstCitta()) + " ("+GenericUtil.getStringValid(pg.getEstStato())+")");
								rowAllegatoIIIDto.setAA2Prov(null);
							}
							else
							{
								rowAllegatoIIIDto.setAA2Prov(pg.getIdProvinciaSelez());
								rowAllegatoIIIDto.setAA2Comune(pg.getComune());
								rowAllegatoIIIDto.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pg.getIndirizzo()) ? pg.getIndirizzo() : pg.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							rowAllegatoIIIDto.setAA2Civico(pg.getCivico());

							rowAllegatoIIIDto.setAA2Cognome(null);
							rowAllegatoIIIDto.setAA2Cf(null);
							rowAllegatoIIIDto.setAA2Nome(null);
						}
						else
						{

							
							rowAllegatoIIIDto.setAA2Cf(pfResp.getCodiceFiscale());
							rowAllegatoIIIDto.setAA2Cognome(pfResp.getCognome());
							rowAllegatoIIIDto.setAA2Nome(pfResp.getNome());
							
							if (ConvertUtil.convertToBooleanAllways(pfResp.getFlgIndirizzoEst()))
							{
								rowAllegatoIIIDto.setAA2Indirizzo(pfResp.getEstIndirizzo());
								rowAllegatoIIIDto.setAA2Comune(GenericUtil.getStringValid(pfResp.getEstCitta()) + " ("+GenericUtil.getStringValid(pfResp.getEstStato())+")");
								rowAllegatoIIIDto.setAA2Prov(null);
							}
							else
							{							
								rowAllegatoIIIDto.setAA2Prov(pfResp.getIdProvinciaSelez());
								rowAllegatoIIIDto.setAA2Comune(pfResp.getComune());
								rowAllegatoIIIDto.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pfResp.getIndirizzo()) ? pfResp.getIndirizzo() : pfResp.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							rowAllegatoIIIDto.setAA2Civico(pfResp.getCivico());

							rowAllegatoIIIDto.setAA2RagSociale(null);
							rowAllegatoIIIDto.setAA2Piva(null);
						}
						
						//impresa manutentrice
						if(dettaglioImpresaManutentrice!=null){
							rowAllegatoIIIDto.setAA3RagSociale(dettaglioImpresaManutentrice.getDenominazione());
							rowAllegatoIIIDto.setAA3Piva(dettaglioImpresaManutentrice.getCodiceFiscale());

							if (ConvertUtil.convertToBooleanAllways(dettaglioImpresaManutentrice.getFlgIndirizzoEstero()))
							{
								rowAllegatoIIIDto.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoEstero());
								rowAllegatoIIIDto.setAA3Comune(GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCittaEstero()) + " ("+GenericUtil.getStringValid(dettaglioImpresaManutentrice.getStatoEstero())+")");
								rowAllegatoIIIDto.setAA3Prov(null);
							}
							else
							{
								rowAllegatoIIIDto.setAA3Prov(dettaglioImpresaManutentrice.getSiglaProv());
								rowAllegatoIIIDto.setAA3Comune(dettaglioImpresaManutentrice.getComune());
								if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoSitad()))
									rowAllegatoIIIDto.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoSitad());
								else if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoNonTrovato()))
									rowAllegatoIIIDto.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							rowAllegatoIIIDto.setAA3Civico(dettaglioImpresaManutentrice.getCivico());
						}
						else if (dettaglioIspezione != null)
						{
							rowAllegatoIIIDto.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
						}
						
					}//chiude il for sulle pagine di modulo
				}
				
				
			}else{
				//INSERIMENTO
				log.debug("[ServiziMgr::getAllegatoTipo2] ****************************** INSERIMENTO ********************************************* ");
				//istanzio gli oggetti per modol
				it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument.MODIII mod = modAllegato.addNewMODIII();
				it.csi.sigit.sigitwebn.xml.allegato3.data.RichiestaDocument.Richiesta richiesta = mod.addNewRichiesta();
				List<RowAllegatoIII> listaRow = richiesta.addNewDatiAllegato().addNewAllegatoIII().getRowAllegatoIIIList();
				modAllegato.getMODIII().addNewSystem().addNewCatDig();
				//dati che sono comuni e non ripetuti per ogni pagina
				it.csi.sigit.sigitwebn.xml.allegato3.data.DatiModuloDocument.DatiModulo datiModulo = richiesta.addNewDatiModulo();
				it.csi.sigit.sigitwebn.xml.allegato3.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = richiesta.addNewDatiIntestazione();
				datiIntestazione.setCodiceBollino(ConvertUtil.formattaSiglaBollino(ConvertUtil.convertToBigDecimal(da.getNumeroBollinoVerde())));
				datiModulo.setStatoModulo(Constants.STATO_MODULO_BOZZA);
				//setto l'idAllegato che adesso c'è l'ho
				datiModulo.setIdAllegato(da.getIdAllegato());
				
				//bisogna creare tante pagine quanti sono i risultati della seguente lista
				RowAllegatoIII datiPrecompilati = null;
				List<SigitVSk4GfDto> listGf = null;
				
				if (da.getIdApparecchiature() != null && da.getIdApparecchiature().size() > 0)
				{
					// Recupero solo le apparecchiature selezionate nella pagina precedente
					listGf = getDbMgr().getCompGfAttiviInDataProgressivi(codImpianto, da.getDataControllo(), da.getIdApparecchiature());
				}
				else
				{
					// recupero tutte le apparecchiature
					listGf = getDbMgr().getCompGfAttiviInData(codImpianto, ConvertUtil.convertToDate(da.getDataControllo()));
				}
				
				if(listGf!=null){
					log.debug("[ServiziMgr::getAllegatoTipo2] FRAAAAAAAAAAAAAAAAAAAAAAA---> LUNGHEZZA LISTA: "+listGf.size());
				
					for (SigitVSk4GfDto dto : listGf) {
						
						datiPrecompilati = RowAllegatoIII.Factory.newInstance();
						
						datiPrecompilati.setCodiceCatasto(codImpianto);
						datiPrecompilati.setAFDataControllo(ConvertUtil.convertToXmlCalendar(ConvertUtil.convertToSqlDate(da.getDataControllo())));
						//campi obbligatori che cambiano a seconda della pagina
						datiPrecompilati.setAEDataInstallaz(ConvertUtil.convertToXmlCalendar(dto.getDataInstall()));
						datiPrecompilati.setAENumGF(ConvertUtil.convertToBigInteger(dto.getProgressivo()));
						datiPrecompilati.setAENumCircuiti(ConvertUtil.convertToBigInteger(dto.getNCircuiti()));
						//campi che non cambiano per le pagine
						datiPrecompilati.setAECombustibile(dto.getDesCombustibile());
						datiPrecompilati.setAEFabbricante(dto.getDesMarca());
						datiPrecompilati.setAEMatricola(dto.getMatricola());
						datiPrecompilati.setAEModello(dto.getModello());
						
						it.csi.sigit.sigitwebn.xml.allegato3.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVerifica = datiPrecompilati.addNewControlloVerificaEnergetica();
						controlloVerifica.setAEPotenzaTermica(dto.getRiscPotenzaKw());
						controlloVerifica.setAEPotenzaFrigoNom(dto.getRaffPotenzaKw());
						
						datiPrecompilati.setControlloVerificaEnergetica(controlloVerifica);
						
						if(Constants.ID_DETT_GF_ASS_FIAMM_COMB.equals(ConvertUtil.convertToString(dto.getFkDettaglioGf()))){
							datiPrecompilati.xsetAEFlagFiamma(MapDto.getXmlBoolean(true));
							datiPrecompilati.xsetAEFlagAssorbimento(MapDto.getXmlBoolean(false));
							datiPrecompilati.xsetAEFlagCompress(MapDto.getXmlBoolean(false));
						}
						if(Constants.ID_DETT_GF_ASS_REC_CALORE.equals(ConvertUtil.convertToString(dto.getFkDettaglioGf()))){
							datiPrecompilati.xsetAEFlagFiamma(MapDto.getXmlBoolean(false));
							datiPrecompilati.xsetAEFlagAssorbimento(MapDto.getXmlBoolean(true));
							datiPrecompilati.xsetAEFlagCompress(MapDto.getXmlBoolean(false));
						}
						if(Constants.ID_DETT_GF_CICLO_COMPRESS.equals(ConvertUtil.convertToString(dto.getFkDettaglioGf()))){
							datiPrecompilati.xsetAEFlagFiamma(MapDto.getXmlBoolean(false));
							datiPrecompilati.xsetAEFlagAssorbimento(MapDto.getXmlBoolean(false));
							datiPrecompilati.xsetAEFlagCompress(MapDto.getXmlBoolean(true));
						}
						
						//setto i valori dell'impianto(comuni a tutte le pagine
						if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty())
						{
							if(Constants.ID_RUOLO_AMMINISTRATORE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == idRuolo.intValue())
								datiPrecompilati.xsetAA2FlagAmministr(MapDto.getXmlBoolean(true));
							if(Constants.ID_RUOLO_OCCUPANTE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == idRuolo.intValue())
								datiPrecompilati.xsetAA2FlagOccupante(MapDto.getXmlBoolean(true));
							if(Constants.ID_RUOLO_PROPRIETARIO == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == idRuolo.intValue())
								datiPrecompilati.xsetAA2FlagProprietario(MapDto.getXmlBoolean(true));
						}
						else
						{
							datiPrecompilati.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(true));
						}
						
						log.debug("[ServiziMgr::getAllegatoTipo2]  ---> responsabile ed unita'� immobiliare *************** ");
						MapDto.mapSezCatastoAllegatoTipo2(datiPrecompilati, unitaImmobList, denominazioneComuneResp, siglaProvinciaResp);
						
						// dati responsabile impianto
						if(pg!=null)
						{
							datiPrecompilati.setAA2RagSociale(pg.getDenominazione());
							datiPrecompilati.setAA2Piva(pg.getCodiceFiscale());
							
							if (ConvertUtil.convertToBooleanAllways(pg.getFlgIndirizzoEst()))
							{
								datiPrecompilati.setAA2Indirizzo(pg.getEstIndirizzo());
								datiPrecompilati.setAA2Comune(GenericUtil.getStringValid(pg.getEstCitta()) + " ("+GenericUtil.getStringValid(pg.getEstStato())+")");
								datiPrecompilati.setAA2Prov(null);
							}
							else
							{
								datiPrecompilati.setAA2Prov(pg.getIdProvinciaSelez());
								datiPrecompilati.setAA2Comune(pg.getComune());
								datiPrecompilati.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pg.getIndirizzo()) ? pg.getIndirizzo() : pg.getIndirizzoNonTrovato());
							}
						
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							datiPrecompilati.setAA2Civico(pg.getCivico());
							

						}
						else
						{

							datiPrecompilati.setAA2Cf(pfResp.getCodiceFiscale());
							datiPrecompilati.setAA2Cognome(pfResp.getCognome());
							datiPrecompilati.setAA2Nome(pfResp.getNome());

							if (ConvertUtil.convertToBooleanAllways(pfResp.getFlgIndirizzoEst()))
							{
								datiPrecompilati.setAA2Indirizzo(pfResp.getEstIndirizzo());
								datiPrecompilati.setAA2Comune(GenericUtil.getStringValid(pfResp.getEstCitta()) + " ("+GenericUtil.getStringValid(pfResp.getEstStato())+")");
								datiPrecompilati.setAA2Prov(null);
							}
							else
							{
								datiPrecompilati.setAA2Prov(pfResp.getIdProvinciaSelez());
								datiPrecompilati.setAA2Comune(pfResp.getComune());
								datiPrecompilati.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pfResp.getIndirizzo()) ? pfResp.getIndirizzo() : pfResp.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							datiPrecompilati.setAA2Civico(pfResp.getCivico());
						}
						
						//impresa manutentrice
						if(dettaglioImpresaManutentrice!=null){
							datiPrecompilati.setAA3RagSociale(dettaglioImpresaManutentrice.getDenominazione());
							datiPrecompilati.setAA3Piva(dettaglioImpresaManutentrice.getCodiceFiscale());

							if (ConvertUtil.convertToBooleanAllways(dettaglioImpresaManutentrice.getFlgIndirizzoEstero()))
							{
								datiPrecompilati.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoEstero());
								datiPrecompilati.setAA3Comune(GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCittaEstero()) + " ("+GenericUtil.getStringValid(dettaglioImpresaManutentrice.getStatoEstero())+")");
								datiPrecompilati.setAA3Prov(null);
							}
							else
							{
								datiPrecompilati.setAA3Prov(dettaglioImpresaManutentrice.getSiglaProv());
								datiPrecompilati.setAA3Comune(dettaglioImpresaManutentrice.getComune());
								if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoSitad()))
									datiPrecompilati.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoSitad());
								else if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoNonTrovato()))
									datiPrecompilati.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							datiPrecompilati.setAA3Civico(dettaglioImpresaManutentrice.getCivico());

						}
						else if (dettaglioIspezione != null)
						{
							datiPrecompilati.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
						}
						
						//SEZIONE C. Trattamento dell'acqua
						it.csi.sigit.sigitwebn.xml.allegato3.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua =  it.csi.sigit.sigitwebn.xml.allegato3.data.TrattamentoAcquaDocument.TrattamentoAcqua.Factory.newInstance();
						SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk();
						pkTrattAcqua.setCodiceImpianto(new BigDecimal(codImpianto));
						SigitTTrattH2ODto dettaglioTrattAcqua = this.getDbMgr().getSigitTTrattH2oDao().findByPrimaryKey(pkTrattAcqua );
						
						if(dettaglioTrattAcqua!=null){
							log.debug("FRAAAAAAAAAAA --- > trattamento acqua ");
							trattamentoAcqua.setACDurezzaTotH2O(dettaglioTrattAcqua.getL22DurezzaH2oFr());
							if(dettaglioTrattAcqua.getL23FlgTrattClimaAssente() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaAssente().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OAssente(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OAssente(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaFiltr().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OFiltraz(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OFiltraz(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaAddolc().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OAddolcim(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OAddolcim(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL23FlgTrattClimaChimico() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaChimico().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OCondizChimico(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OCondizChimico(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL24FlgTrattAcsNonRich() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL24FlgTrattAcsNonRich().intValue())
								trattamentoAcqua.xsetACFlagTrattH2ONR(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2ONR(MapDto.getXmlBoolean(false));
							}
							
							datiPrecompilati.setTrattamentoAcqua(trattamentoAcqua);
						}
						
						//devo creare tante istanze di RowFumi quanti sono gli n_moduli(può arrivare null, 0, 1,2,...)
						log.debug("FRAAAAAAAAAAA --- > getNCircuiti: "+dto.getNCircuiti());
						it.csi.sigit.sigitwebn.xml.allegato3.data.RowFumiDocument.RowFumi rowFumi = null;
					
						if(dto.getNCircuiti() == null || dto.getNCircuiti().intValue() == 0){
							log.debug(" getNCircuiti FRAAAAAAAAAAA --- > nel null oppure se è zero");

							datiPrecompilati.setTabFumi(it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII.TabFumi.Factory.newInstance()); 
							List<it.csi.sigit.sigitwebn.xml.allegato3.data.RowFumiDocument.RowFumi> rowFumiList = datiPrecompilati.getTabFumi().getRowFumiList();
							rowFumiList.clear();
		
							rowFumi = it.csi.sigit.sigitwebn.xml.allegato3.data.RowFumiDocument.RowFumi.Factory.newInstance();
							rowFumi.setAESurrisc(null);
							rowFumi.setAESottoRaffr(null);
							rowFumi.setAECondens(null);
							rowFumi.setAEEvaporaz(null);
							rowFumi.setAEIngLatoEst(null);
							rowFumi.setAEUscLatoEst(null);
							rowFumi.setAEIngLatoUtenze(null);
							rowFumi.setAEUscLatoUtenze(null);
							rowFumi.setAENumCircuito(ConvertUtil.convertToBigInteger("1"));
//							rowFumi.setAETuscFluido(null);
//							rowFumi.setAETbulboUmido(null);
//							rowFumi.setAETingFluidoSorg(null);
//							rowFumi.setAETuscFluidoSorg(null);
//							rowFumi.setAETingFluidoMacc(null);
//							rowFumi.setAETuscFluidoMacc(null);
//							rowFumi.setAEPotenzaAss(null);
//							rowFumi.setAEFiltriPuliti(null);
//							rowFumi.setAEVerifica(null);
							rowFumiList.add(rowFumi);
							log.debug(" getNCircuiti FRAAAAAAAAAAA --- > nel null oppure se è zero dimensione lista : "+rowFumiList.size());
						}else{
							int count = dto.getNCircuiti().intValue();
							log.debug(" getNCircuiti FRAAAAAAAAAAA ---  count > "+count);
							//istanzio la lista di RowFumi
							datiPrecompilati.setTabFumi(it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII.TabFumi.Factory.newInstance()); 
							List<it.csi.sigit.sigitwebn.xml.allegato3.data.RowFumiDocument.RowFumi> rowFumiList = datiPrecompilati.getTabFumi().getRowFumiList();
							rowFumiList.clear();
							
							//List<it.csi.sigit.sigitwebn.xml.allegato3.data.RowFumiDocument.RowFumi> listaRowFumi = datiPrecompilati.addNewTabFumi().getRowFumiList();
							log.debug(" getNCircuiti FRAAAAAAAAAAA ---  listaRowFumi : "+rowFumiList);

							for(int i = 1; i<=count; i++){
								log.debug("getNCircuiti FRAAAAAAAAAAAAAAA NEL FOR i: "+i);
								rowFumi = it.csi.sigit.sigitwebn.xml.allegato3.data.RowFumiDocument.RowFumi.Factory.newInstance();
								rowFumi.setAESurrisc(null);
								rowFumi.setAESottoRaffr(null);
								rowFumi.setAECondens(null);
								rowFumi.setAEEvaporaz(null);
								rowFumi.setAEIngLatoEst(null);
								rowFumi.setAEUscLatoEst(null);
								rowFumi.setAEIngLatoUtenze(null);
								rowFumi.setAEUscLatoUtenze(null);
								rowFumi.setAENumCircuito(ConvertUtil.convertToBigInteger(""+i));
//								rowFumi.setAETuscFluido(null);
//								rowFumi.setAETbulboUmido(null);
//								rowFumi.setAETingFluidoSorg(null);
//								rowFumi.setAETuscFluidoSorg(null);
//								rowFumi.setAETingFluidoMacc(null);
//								rowFumi.setAETuscFluidoMacc(null);
//								rowFumi.setAEPotenzaAss(null);
//								rowFumi.setAEFiltriPuliti(null);
//								rowFumi.setAEVerifica(null);
								rowFumiList.add(rowFumi);
								
								log.debug("getNCircuiti FRAAAAAAAAAAAAAAA NEL FOR DIMENSIONE: "+rowFumiList.size());
							}
						}
						
						//a questo punto setto l'oggetto che si ripete dentro l'arrayList del modulo
						listaRow.add(datiPrecompilati);
						
					}//chiude il for sulle pagine da duplicare
				}
				
			}
			
			if(da.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_ALLEGATI))
		    	modAllegato.getMODIII().getRichiesta().getDatiModulo().setURLchiudi(Constants.RETURN_PAGE_ELENCO_ALLEGATI_DA_PDF);
			else if(da.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_IMPIANTO))
	    		modAllegato.getMODIII().getRichiesta().getDatiModulo().setURLchiudi(Constants.RETURN_PAGE_ELENCO_ALLEGATI_IMPIANTO_DA_PDF);
			else if(da.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_IMPIANTO_ISP))
	    		modAllegato.getMODIII().getRichiesta().getDatiModulo().setURLchiudi(Constants.RETURN_PAGE_ELENCO_ALLEGATI_IMPIANTO_ISP_DA_PDF);
			
			if (log.isDebugEnabled())
			{
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				log.debug("STAMPO ALLEGATOIII RESULT: "+modAllegato);
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}
		}
		catch (Exception e) {
			log.error("Errore getAllegatoTipo2",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getAllegatoTipo2] END");
		}
		return modAllegato;
	}
	
	public it.csi.sigit.sigitwebn.xml.allegato4.data.MODIVDocument getAllegatoTipo3(DettaglioAllegato da, boolean isAllegatoInInsert) throws ServiceException
	{
		log.debug("[ServiziMgr::getAllegatoTipo3] START");
		
		log.debug("[ServiziMgr::getAllegatoTipo3] **************************************** ID ALLEGATO: "+da.getIdAllegato());
		
		it.csi.sigit.sigitwebn.xml.allegato4.data.MODIVDocument modAllegato = it.csi.sigit.sigitwebn.xml.allegato4.data.MODIVDocument.Factory.newInstance();
		try{
			String codImpianto = da.getCodiceImpianto();
			//in questo oggetto setto il responsabile dell'impianto
			SigitVTotImpiantoDto vTotImpiantoResp = null;

			//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			SigitVRicerca3ResponsabileDto v3Resp = null;
			BigDecimal idRuolo = null;
			String denominazioneComuneResp = null;
			String siglaProvinciaResp = null;
			

			// Se il responsabile e una PF
			PersonaFisica pfResp = null;
			// Se il responsabile e una PG
			PersonaGiuridica pgResp = null;

			//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			PersonaGiuridica pg = null;

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			List<SigitVTotImpiantoDto> listResp = getDbMgr().cercaResponsabiliAttiviAllaDataByCodImpianto(da.getCodiceImpianto(), da.getDataControllo());
			if(listResp!=null && !listResp.isEmpty()){

				vTotImpiantoResp = listResp.get(0);
				idRuolo = vTotImpiantoResp.getIdRuolo();
				denominazioneComuneResp = vTotImpiantoResp.getDenominazioneComune();
				siglaProvinciaResp = vTotImpiantoResp.getSiglaProvincia();

				if(vTotImpiantoResp.getPfPg().equals(Constants.LABEL_PF))
				{
					pfResp = getDbMgr().cercaPersonaFisicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
				}else{
					pgResp = getDbMgr().cercaPersonaGiuridicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
				}

			}
			
			// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(da.getCodiceImpianto(), da.getDataControllo());
			if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
			{
				v3Resp = list3RespAttiviImpianto.get(0);
				idRuolo = v3Resp.getFkRuolo();
				denominazioneComuneResp = v3Resp.getDenomComune3Resp();
				siglaProvinciaResp = v3Resp.getSiglaProv3Resp();
				pg = getDbMgr().cercaPersonaGiuridicaById(v3Resp.getFkPg3Resp().intValue());
			}
			else
			{
				idRuolo = vTotImpiantoResp.getIdRuolo();
				denominazioneComuneResp = vTotImpiantoResp.getDenominazioneComune();
				siglaProvinciaResp = vTotImpiantoResp.getSiglaProvincia();
				pg = pgResp;
			}
			
			
			//mi vado a cercare i dati dell'impresa manutentrice
			SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice = null;
			DettaglioIspezione dettaglioIspezione = null;
			// Se l'id ispezione e' valorizzato vuol dire che provengo delle ispezioni
			if (GenericUtil.isNotNullOrEmpty(da.getIdIspezione()))
			{
				// Recupero l'ispezione
				dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(da.getIdIspezione());
			}
			else
			{
				//mi vado a cercare i dati dell'impresa manutentrice
				dettaglioImpresaManutentrice = getDbMgr().cercaTPersonaGiuridicaById(da.getIdPersonaGiuridica());
			}

			
			//dati locazione impianto
			List<SigitTUnitaImmobiliareDto> unitaImmobList = getDbMgr().getUnitaImmobiliariImpianto(new Integer(codImpianto));
			
			//sezione c. tRATTAMENTO DELL'ACQUA
			SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk();
			pkTrattAcqua.setCodiceImpianto(new BigDecimal(codImpianto));
			SigitTTrattH2ODto dettaglioTrattAcqua = this.getDbMgr().getSigitTTrattH2oDao().findByPrimaryKey(pkTrattAcqua );
		
			//CONTROLLO SE SONO IN MODIFICA O IN INSERIMENTO
			if(GenericUtil.isNotNullOrEmpty(da.getIdAllegato()) && !isAllegatoInInsert){
				//MODIFICA
				log.debug("[ServiziMgr::getAllegatoTipo3] ****************************** MODIFICA ********************************************* ");
				
				//trovo il dettaglio dell'allegato con il suo xml salvato che devo visualizzare
				SigitTAllTxtDto allegatoTxt = getDbMgr().getAllTxtAllegato(ConvertUtil.convertToBigDecimal(da.getIdAllegato()));
				
				byte[] moduloXml = XmlBeanUtils.readString(allegatoTxt.getXmlAllegato());
				
				//lo ritrasformo in oggetto MODIIDocument
				modAllegato = MapDto.mapToMODIVDocument(moduloXml);
				//riaggiorno i dati che potrebbero cambiare
				it.csi.sigit.sigitwebn.xml.allegato4.data.RichiestaDocument.Richiesta modRichiesta = modAllegato.getMODIV().getRichiesta();
				//setto l'idAllegato che sto modificando
				modRichiesta.getDatiModulo().setIdAllegato(da.getIdAllegato());
				
				List<RowAllegatoIV> modListaRowIV = modRichiesta.getDatiAllegato().getAllegatoIV().getRowAllegatoIVList();
				
				if(modListaRowIV!=null && modListaRowIV.size()>0)
				{
					log.debug("[ServiziMgr::getAllegatoTipo3] ***** MODIFICA ***** DENTRO LA LISTA ROWIV --> dimensione: "+modListaRowIV.size());
					
					for(RowAllegatoIV rowAllegatoIVDto : modListaRowIV){
						

						String componente = ConvertUtil.convertToString(rowAllegatoIVDto.getAENumSC());
						
						
						//per la parte di catasto
						MapDto.mapSezCatastoAllegatoTipo3(rowAllegatoIVDto, unitaImmobList, denominazioneComuneResp, siglaProvinciaResp);
						
						rowAllegatoIVDto.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(false));
						//setto i valori dell'impianto(comuni a tutte le pagine
						if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty())
						{
							if(Constants.ID_RUOLO_AMMINISTRATORE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == idRuolo.intValue())
							{
								rowAllegatoIVDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(true));
								rowAllegatoIVDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(false));
								rowAllegatoIVDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(false));
							}
							if(Constants.ID_RUOLO_OCCUPANTE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == idRuolo.intValue())
							{
								rowAllegatoIVDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(true));
								rowAllegatoIVDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(false));
								rowAllegatoIVDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(false));
							}
							if(Constants.ID_RUOLO_PROPRIETARIO == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == idRuolo.intValue())
							{
								rowAllegatoIVDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(true));
								rowAllegatoIVDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(false));
								rowAllegatoIVDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(false));
							}
						}
						else
						{
							rowAllegatoIVDto.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(true));
							rowAllegatoIVDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(false));
							rowAllegatoIVDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(false));
							rowAllegatoIVDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(false));
						}
						
						// dati responsabile impianto
						if(pg!=null)
						{
							
							rowAllegatoIVDto.setAA2RagSociale(pg.getDenominazione());
							rowAllegatoIVDto.setAA2Piva(pg.getCodiceFiscale());

							if (ConvertUtil.convertToBooleanAllways(pg.getFlgIndirizzoEst()))
							{
								rowAllegatoIVDto.setAA2Indirizzo(pg.getEstIndirizzo());
								rowAllegatoIVDto.setAA2Comune(GenericUtil.getStringValid(pg.getEstCitta()) + " ("+GenericUtil.getStringValid(pg.getEstStato())+")");
								rowAllegatoIVDto.setAA2Prov(null);
							}
							else
							{
								rowAllegatoIVDto.setAA2Prov(pg.getIdProvinciaSelez());
								rowAllegatoIVDto.setAA2Comune(pg.getComune());
								rowAllegatoIVDto.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pg.getIndirizzo()) ? pg.getIndirizzo() : pg.getIndirizzoNonTrovato());
							}
							
							rowAllegatoIVDto.setAA2Nome(null);
							rowAllegatoIVDto.setAA2Cognome(null);
							rowAllegatoIVDto.setAA2Cf(null);

							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							rowAllegatoIVDto.setAA2Civico(pg.getCivico());
							
							
						}
						else
						{

							rowAllegatoIVDto.setAA2Cf(pfResp.getCodiceFiscale());
							rowAllegatoIVDto.setAA2Cognome(pfResp.getCognome());
							rowAllegatoIVDto.setAA2Nome(pfResp.getNome());

							if (ConvertUtil.convertToBooleanAllways(pfResp.getFlgIndirizzoEst()))
							{
								rowAllegatoIVDto.setAA2Indirizzo(pfResp.getEstIndirizzo());
								rowAllegatoIVDto.setAA2Comune(GenericUtil.getStringValid(pfResp.getEstCitta()) + " ("+GenericUtil.getStringValid(pfResp.getEstStato())+")");
								rowAllegatoIVDto.setAA2Prov(null);
							}
							else
							{
								rowAllegatoIVDto.setAA2Prov(pfResp.getIdProvinciaSelez());
								rowAllegatoIVDto.setAA2Comune(pfResp.getComune());
								rowAllegatoIVDto.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pfResp.getIndirizzo()) ? pfResp.getIndirizzo() : pfResp.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							rowAllegatoIVDto.setAA2Civico(pfResp.getCivico());

							rowAllegatoIVDto.setAA2Piva(null);
							rowAllegatoIVDto.setAA2RagSociale(null);

						}
						
						//impresa manutentrice
						if(dettaglioImpresaManutentrice!=null){
							rowAllegatoIVDto.setAA3RagSociale(dettaglioImpresaManutentrice.getDenominazione());
							rowAllegatoIVDto.setAA3Piva(dettaglioImpresaManutentrice.getCodiceFiscale());

							if (ConvertUtil.convertToBooleanAllways(dettaglioImpresaManutentrice.getFlgIndirizzoEstero()))
							{
								rowAllegatoIVDto.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoEstero());
								rowAllegatoIVDto.setAA3Comune(GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCittaEstero()) + " ("+GenericUtil.getStringValid(dettaglioImpresaManutentrice.getStatoEstero())+")");
								rowAllegatoIVDto.setAA3Prov(null);
							}
							else
							{
								rowAllegatoIVDto.setAA3Prov(dettaglioImpresaManutentrice.getSiglaProv());
								rowAllegatoIVDto.setAA3Comune(dettaglioImpresaManutentrice.getComune());
								
								if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoSitad()))
									rowAllegatoIVDto.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoSitad());
								else if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoNonTrovato()))
									rowAllegatoIVDto.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoNonTrovato());
							}

							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							rowAllegatoIVDto.setAA3Civico(dettaglioImpresaManutentrice.getCivico());

						}
						else if (dettaglioIspezione != null)
						{
							rowAllegatoIVDto.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
						}
						
					}//chiude il for sulle pagine di modulo
				}
				
				
			}else{
				//INSERIMENTO
				log.debug("[ServiziMgr::getAllegatoTipo3] ****************************** INSERIMENTO ********************************************* ");
				//istanzio gli oggetti per modol
				it.csi.sigit.sigitwebn.xml.allegato4.data.MODIVDocument.MODIV mod = modAllegato.addNewMODIV();
				it.csi.sigit.sigitwebn.xml.allegato4.data.RichiestaDocument.Richiesta richiesta = mod.addNewRichiesta();
				List<RowAllegatoIV> listaRow = richiesta.addNewDatiAllegato().addNewAllegatoIV().getRowAllegatoIVList();
				modAllegato.getMODIV().addNewSystem().addNewCatDig();
				//dati che sono comuni e non ripetuti per ogni pagina
				it.csi.sigit.sigitwebn.xml.allegato4.data.DatiModuloDocument.DatiModulo datiModulo = richiesta.addNewDatiModulo();
				it.csi.sigit.sigitwebn.xml.allegato4.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = richiesta.addNewDatiIntestazione();
				datiIntestazione.setCodiceBollino(ConvertUtil.formattaSiglaBollino(ConvertUtil.convertToBigDecimal(da.getNumeroBollinoVerde())));
				datiModulo.setStatoModulo(Constants.STATO_MODULO_BOZZA);
				//setto l'idAllegato che adesso c'è l'ho
				datiModulo.setIdAllegato(da.getIdAllegato());
				
				//bisogna creare tante pagine quanti sono i risultati della seguente lista
				RowAllegatoIV datiPrecompilati = null;
				List<SigitVSk4ScDto> listSc = null;
				
				if (da.getIdApparecchiature() != null && da.getIdApparecchiature().size() > 0)
				{
					// Recupero solo le apparecchiature selezionate nella pagina precedente
					listSc = getDbMgr().getCompScAttiviInDataProgressivi(codImpianto, da.getDataControllo(), da.getIdApparecchiature());
				}
				else
				{
					// recupero tutte le apparecchiature
					listSc = getDbMgr().getCompScAttiviInData(codImpianto, ConvertUtil.convertToDate(da.getDataControllo()));
				}
				
				if(listSc!=null){
					log.debug("[ServiziMgr::getAllegatoTipo3] FRAAAAAAAAAAAAAAAAAAAAAAA---> LUNGHEZZA LISTA: "+listSc.size());
				
					for (SigitVSk4ScDto dto : listSc) {
						
						datiPrecompilati = RowAllegatoIV.Factory.newInstance();
						
						datiPrecompilati.setCodiceCatasto(codImpianto);
						datiPrecompilati.setAFDataControllo(ConvertUtil.convertToXmlCalendar(ConvertUtil.convertToSqlDate(da.getDataControllo())));
						//campi obbligatori che cambiano a seconda della pagina
						datiPrecompilati.setAEDataInstallaz(ConvertUtil.convertToXmlCalendar(dto.getDataInstall()));
						datiPrecompilati.setAENumSC(ConvertUtil.convertToBigInteger(dto.getProgressivo()));
						//datiPrecompilati.setAENumCircuiti(ConvertUtil.convertToBigInteger(dto.getNCircuiti()));
						
						//campi che non cambiano per le pagine
						//datiPrecompilati.setAECombustibile(dto.getDesCombustibile());
						datiPrecompilati.setAEFabbricante(dto.getDesMarca());
						datiPrecompilati.setAEMatricola(dto.getMatricola());
						datiPrecompilati.setAEModello(dto.getModello());
						datiPrecompilati.setAEPotenzaTermNom(dto.getPotenzaTermicaKw());

						//setto i valori dell'impianto(comuni a tutte le pagine
						if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty())
						{
							if(Constants.ID_RUOLO_AMMINISTRATORE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == idRuolo.intValue())
								datiPrecompilati.xsetAA2FlagAmministr(MapDto.getXmlBoolean(true));
							if(Constants.ID_RUOLO_OCCUPANTE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == idRuolo.intValue())
								datiPrecompilati.xsetAA2FlagOccupante(MapDto.getXmlBoolean(true));
							if(Constants.ID_RUOLO_PROPRIETARIO == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == idRuolo.intValue())
								datiPrecompilati.xsetAA2FlagProprietario(MapDto.getXmlBoolean(true));
						}
						else
						{
							datiPrecompilati.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(true));
						}
						
						log.debug("[ServiziMgr::getAllegatoTipo3]  ---> responsabile ed unità immobiliare *************** ");
						MapDto.mapSezCatastoAllegatoTipo3(datiPrecompilati, unitaImmobList, denominazioneComuneResp, siglaProvinciaResp);
						
						// dati responsabile impianto
						if(pg!=null)
						{

							datiPrecompilati.setAA2RagSociale(pg.getDenominazione());
							datiPrecompilati.setAA2Piva(pg.getCodiceFiscale());

							if (ConvertUtil.convertToBooleanAllways(pg.getFlgIndirizzoEst()))
							{
								datiPrecompilati.setAA2Indirizzo(pg.getEstIndirizzo());
								datiPrecompilati.setAA2Comune(GenericUtil.getStringValid(pg.getEstCitta()) + " ("+GenericUtil.getStringValid(pg.getEstStato())+")");
								datiPrecompilati.setAA2Prov(null);
							}
							else
							{
								datiPrecompilati.setAA2Prov(pg.getIdProvinciaSelez());
								datiPrecompilati.setAA2Comune(pg.getComune());
								datiPrecompilati.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pg.getIndirizzo()) ? pg.getIndirizzo() : pg.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							datiPrecompilati.setAA2Civico(pg.getCivico());

						}
						else
						{
							datiPrecompilati.setAA2Cf(pfResp.getCodiceFiscale());
							datiPrecompilati.setAA2Cognome(pfResp.getCognome());
							datiPrecompilati.setAA2Nome(pfResp.getNome());

							if (ConvertUtil.convertToBooleanAllways(pfResp.getFlgIndirizzoEst()))
							{
								datiPrecompilati.setAA2Indirizzo(pfResp.getEstIndirizzo());
								datiPrecompilati.setAA2Comune(GenericUtil.getStringValid(pfResp.getEstCitta()) + " ("+GenericUtil.getStringValid(pfResp.getEstStato())+")");
								datiPrecompilati.setAA2Prov(null);
							}
							else
							{							
								datiPrecompilati.setAA2Prov(pfResp.getIdProvinciaSelez());
								datiPrecompilati.setAA2Comune(pfResp.getComune());
								datiPrecompilati.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pfResp.getIndirizzo()) ? pfResp.getIndirizzo() : pfResp.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							datiPrecompilati.setAA2Civico(pfResp.getCivico());
							
						}
						
						//impresa manutentrice
						if(dettaglioImpresaManutentrice!=null){
							datiPrecompilati.setAA3RagSociale(dettaglioImpresaManutentrice.getDenominazione());
							datiPrecompilati.setAA3Piva(dettaglioImpresaManutentrice.getCodiceFiscale());

							if (ConvertUtil.convertToBooleanAllways(dettaglioImpresaManutentrice.getFlgIndirizzoEstero()))
							{
								datiPrecompilati.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoEstero());
								datiPrecompilati.setAA3Comune(GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCittaEstero()) + " ("+GenericUtil.getStringValid(dettaglioImpresaManutentrice.getStatoEstero())+")");
								datiPrecompilati.setAA3Prov(null);
							}
							else
							{
								datiPrecompilati.setAA3Prov(dettaglioImpresaManutentrice.getSiglaProv());
								datiPrecompilati.setAA3Comune(dettaglioImpresaManutentrice.getComune());
	
								if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoSitad()))
									datiPrecompilati.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoSitad());
								else if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoNonTrovato()))
									datiPrecompilati.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoNonTrovato());
							}

							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							datiPrecompilati.setAA3Civico(dettaglioImpresaManutentrice.getCivico());

						}
						else if (dettaglioIspezione != null)
						{
							datiPrecompilati.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
						}
						
						//SEZIONE C. Trattamento dell'acqua
						it.csi.sigit.sigitwebn.xml.allegato4.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua =  it.csi.sigit.sigitwebn.xml.allegato4.data.TrattamentoAcquaDocument.TrattamentoAcqua.Factory.newInstance();
						if(dettaglioTrattAcqua!=null){
							log.debug("FRAAAAAAAAAAA --- > trattamento acqua ");
							trattamentoAcqua.setACDurezzaTotH2O(dettaglioTrattAcqua.getL22DurezzaH2oFr());
							
							if(dettaglioTrattAcqua.getL23FlgTrattClimaAssente() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaAssente().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OAssente(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OAssente(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaFiltr().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OFiltraz(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OFiltraz(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaAddolc().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OAddolcim(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OAddolcim(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL23FlgTrattClimaChimico() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaChimico().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OCondizChimico(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OCondizChimico(MapDto.getXmlBoolean(false));
							}
							
							if(dettaglioTrattAcqua.getL23FlgTrattRiscNonRich() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattRiscNonRich().intValue())
								trattamentoAcqua.xsetACFlagTrattH2ONR(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2ONR(MapDto.getXmlBoolean(false));
							}
							
							
							
							if(dettaglioTrattAcqua.getL24FlgTrattAcsAssente() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL24FlgTrattAcsAssente().intValue())
								trattamentoAcqua.xsetACFlagTrattAcsAssente(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattAcsAssente(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL24FlgTrattAcsFiltr() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL24FlgTrattAcsFiltr().intValue())
								trattamentoAcqua.xsetACFlagTrattAcsFiltraz(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattAcsFiltraz(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL24FlgTrattAcsAddolc() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL24FlgTrattAcsAddolc().intValue())
								trattamentoAcqua.xsetACFlagTrattAcsAddolcim(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattAcsAddolcim(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL24FlgTrattAcsChimico() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL24FlgTrattAcsChimico().intValue())
								trattamentoAcqua.xsetACFlagTrattAcsCondizChimico(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattAcsCondizChimico(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL24FlgTrattAcsNonRich() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL24FlgTrattAcsNonRich().intValue())
								trattamentoAcqua.xsetACFlagTrattAcsNR(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattAcsNR(MapDto.getXmlBoolean(false));
							}
							
							datiPrecompilati.setTrattamentoAcqua(trattamentoAcqua);
						}

						//a questo punto setto l'oggetto che si ripete dentro l'arrayList del modulo
						listaRow.add(datiPrecompilati);
						
					}//chiede il for sulle pagine da duplicare
				}
				
			}
			
			List<SigitDFluidoDto> elencoFluidi = getDbMgr().getElencoFluidi();
			modAllegato.getMODIV().getRichiesta().getDatiModulo().setElencoCombustibile(MapDto.mapToElencoCombustibileAllegato4(elencoFluidi));
			modAllegato.getMODIV().getRichiesta().getDatiModulo().setElencoFluidoTermoVett(MapDto.mapToElencoFluidoAllegato4(elencoFluidi));

			if(da.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_ALLEGATI))
		    	modAllegato.getMODIV().getRichiesta().getDatiModulo().setURLchiudi(Constants.RETURN_PAGE_ELENCO_ALLEGATI_DA_PDF);
			else if(da.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_IMPIANTO))
	    		modAllegato.getMODIV().getRichiesta().getDatiModulo().setURLchiudi(Constants.RETURN_PAGE_ELENCO_ALLEGATI_IMPIANTO_DA_PDF);
			else if(da.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_IMPIANTO_ISP))
	    		modAllegato.getMODIV().getRichiesta().getDatiModulo().setURLchiudi(Constants.RETURN_PAGE_ELENCO_ALLEGATI_IMPIANTO_ISP_DA_PDF);
			
			if (log.isDebugEnabled())
			{
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				log.debug("STAMPO ALLEGATOIV RESULT: "+modAllegato);
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}
		}
		catch (Exception e) {
			log.error("Errore getAllegatoTipo3",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getAllegatoTipo3] END");
		}
		return modAllegato;
	}
	
	

	public it.csi.sigit.sigitwebn.xml.allegato5.data.MODVDocument getAllegatoTipo4(DettaglioAllegato da, boolean isAllegatoInInsert) throws ServiceException
	{
		log.debug("[ServiziMgr::getAllegatoTipo4] START");
		
		log.debug("[ServiziMgr::getAllegatoTipo4] **************************************** ID ALLEGATO: "+da.getIdAllegato());
		
		it.csi.sigit.sigitwebn.xml.allegato5.data.MODVDocument modAllegato = it.csi.sigit.sigitwebn.xml.allegato5.data.MODVDocument.Factory.newInstance();
		try{
			String codImpianto = da.getCodiceImpianto();
			//in questo oggetto setto il responsabile dell'impianto
			SigitVTotImpiantoDto vTotImpiantoResp = null;

			//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			SigitVRicerca3ResponsabileDto vRic3Responsabile = null;
			
			BigDecimal idRuolo = null;
			String denominazioneComuneResp = null;
			String siglaProvinciaResp = null;

			// Se il responsabile e una PF
			PersonaFisica pfResp = null;
			// Se il responsabile e una PG
			PersonaGiuridica pgResp = null;

			//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			PersonaGiuridica pg = null;

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			List<SigitVTotImpiantoDto> listResp = getDbMgr().cercaResponsabiliAttiviAllaDataByCodImpianto(da.getCodiceImpianto(), da.getDataControllo());
			if(listResp!=null && !listResp.isEmpty()){

				vTotImpiantoResp = listResp.get(0);
				
				//dcosta: mev reignegnerizzazione viste
				idRuolo = vTotImpiantoResp.getIdRuolo();
				denominazioneComuneResp = vTotImpiantoResp.getDenominazioneComune();
				siglaProvinciaResp = vTotImpiantoResp.getSiglaProvincia();

				if(vTotImpiantoResp.getPfPg().equals(Constants.LABEL_PF))
				{
					pfResp = getDbMgr().cercaPersonaFisicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
				}else{
					pgResp = getDbMgr().cercaPersonaGiuridicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
				}

			}
			
			// Devo settare il responsabile/3 responsabile
			//dcosta: mev reingergnerizzazione viste (sostituito il return con SigitVRicerca3ResponsabileDto)
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(da.getCodiceImpianto(), da.getDataControllo());
			if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
			{
				vRic3Responsabile = list3RespAttiviImpianto.get(0);
				pg = getDbMgr().cercaPersonaGiuridicaById(vRic3Responsabile.getFkPg3Resp().intValue());
				idRuolo = vRic3Responsabile.getFkRuolo();
				denominazioneComuneResp = vRic3Responsabile.getDenomComune3Resp();
				siglaProvinciaResp = vRic3Responsabile.getSiglaProv3Resp();
			}
			else
			{
				idRuolo = vTotImpiantoResp.getIdRuolo();
				denominazioneComuneResp = vTotImpiantoResp.getDenominazioneComune();
				siglaProvinciaResp = vTotImpiantoResp.getSiglaProvincia();
				pg = pgResp;
			}
			
			
			//mi vado a cercare i dati dell'impresa manutentrice
			SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice = null;
			DettaglioIspezione dettaglioIspezione = null;
			// Se l'id ispezione e' valorizzato vuol dire che provengo delle ispezioni
			if (GenericUtil.isNotNullOrEmpty(da.getIdIspezione()))
			{
				// Recupero l'ispezione
				dettaglioIspezione = getDbMgr()
						.getDettaglioIspezioneById(da.getIdIspezione());
			}
			else
			{
				//mi vado a cercare i dati dell'impresa manutentrice
				//dettaglioImpresaManutentrice = getDbMgr().getImpresaManutentrice(da.getIdImpiantoRuoloPfPg());
				dettaglioImpresaManutentrice = getDbMgr().cercaTPersonaGiuridicaById(da.getIdPersonaGiuridica());

			}
			
			//dati locazione impianto
			List<SigitTUnitaImmobiliareDto> unitaImmobList = getDbMgr().getUnitaImmobiliariImpianto(new Integer(codImpianto));
			
			//sezione c. tRATTAMENTO DELL'ACQUA
			SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk();
			pkTrattAcqua.setCodiceImpianto(new BigDecimal(codImpianto));
			SigitTTrattH2ODto dettaglioTrattAcqua = this.getDbMgr().getSigitTTrattH2oDao().findByPrimaryKey(pkTrattAcqua );
		
			//CONTROLLO SE SONO IN MODIFICA O IN INSERIMENTO
			if(GenericUtil.isNotNullOrEmpty(da.getIdAllegato()) && !isAllegatoInInsert){
				//MODIFICA
				log.debug("[ServiziMgr::getAllegatoTipo4] ****************************** MODIFICA ********************************************* ");
				
				//trovo il dettaglio dell'allegato con il suo xml salvato che devo visualizzare
				SigitTAllTxtDto allegatoTxt = getDbMgr().getAllTxtAllegato(ConvertUtil.convertToBigDecimal(da.getIdAllegato()));

				byte[] moduloXml = XmlBeanUtils.readString(allegatoTxt.getXmlAllegato());
				
				//lo ritrasformo in oggetto MODIIDocument
				modAllegato = MapDto.mapToMODVDocument(moduloXml);
				//riaggiorno i dati che potrebbero cambiare
				it.csi.sigit.sigitwebn.xml.allegato5.data.RichiestaDocument.Richiesta modRichiesta = modAllegato.getMODV().getRichiesta();
				//setto l'idAllegato che sto modificando
				modRichiesta.getDatiModulo().setIdAllegato(da.getIdAllegato());
				
				List<RowAllegatoV> modListaRowV = modRichiesta.getDatiAllegato().getAllegatoV().getRowAllegatoVList();
				
				if(modListaRowV!=null && modListaRowV.size()>0)
				{
					log.debug("[ServiziMgr::getAllegatoTipo4] ***** MODIFICA ***** DENTRO LA LISTA ROWV --> dimensione: "+modListaRowV.size());
					
					for(RowAllegatoV rowAllegatoVDto : modListaRowV){
						
						//per la parte di catasto
						MapDto.mapSezCatastoAllegatoTipo4(rowAllegatoVDto, unitaImmobList, denominazioneComuneResp, siglaProvinciaResp);
						
						//setto i valori dell'impianto(comuni a tutte le pagine
						rowAllegatoVDto.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(false));
						//setto i valori dell'impianto(comuni a tutte le pagine
						if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty())
						{
							if(Constants.ID_RUOLO_AMMINISTRATORE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == idRuolo.intValue())
							{
								rowAllegatoVDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(true));
								rowAllegatoVDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(false));
								rowAllegatoVDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(false));
							}
							if(Constants.ID_RUOLO_OCCUPANTE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == idRuolo.intValue())
							{
								rowAllegatoVDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(true));
								rowAllegatoVDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(false));
								rowAllegatoVDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(false));
							}
							if(Constants.ID_RUOLO_PROPRIETARIO == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == idRuolo.intValue())
							{
								rowAllegatoVDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(true));
								rowAllegatoVDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(false));
								rowAllegatoVDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(false));
							}
						}
						else
						{
							rowAllegatoVDto.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(true));
							rowAllegatoVDto.xsetAA2FlagProprietario(MapDto.getXmlBoolean(false));
							rowAllegatoVDto.xsetAA2FlagOccupante(MapDto.getXmlBoolean(false));
							rowAllegatoVDto.xsetAA2FlagAmministr(MapDto.getXmlBoolean(false));
						}
						
						// dati responsabile impianto
						if(pg!=null)
						{

							rowAllegatoVDto.setAA2RagSociale(pg.getDenominazione());
							rowAllegatoVDto.setAA2Piva(pg.getCodiceFiscale());

							if (ConvertUtil.convertToBooleanAllways(pg.getFlgIndirizzoEst()))
							{
								rowAllegatoVDto.setAA2Indirizzo(pg.getEstIndirizzo());
								rowAllegatoVDto.setAA2Comune(GenericUtil.getStringValid(pg.getEstCitta()) + " ("+GenericUtil.getStringValid(pg.getEstStato())+")");
								rowAllegatoVDto.setAA2Prov(null);
							}
							else
							{
								rowAllegatoVDto.setAA2Prov(pg.getIdProvinciaSelez());
								rowAllegatoVDto.setAA2Comune(pg.getComune());
								rowAllegatoVDto.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pg.getIndirizzo()) ? pg.getIndirizzo() : pg.getIndirizzoNonTrovato());
							}

							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							rowAllegatoVDto.setAA2Civico(pg.getCivico());

							rowAllegatoVDto.setAA2Cognome(null);
							rowAllegatoVDto.setAA2Nome(null);
							rowAllegatoVDto.setAA2Cf(null);

						}
						else
						{

							rowAllegatoVDto.setAA2Cf(pfResp.getCodiceFiscale());
							rowAllegatoVDto.setAA2Cognome(pfResp.getCognome());
							rowAllegatoVDto.setAA2Nome(pfResp.getNome());

							if (ConvertUtil.convertToBooleanAllways(pfResp.getFlgIndirizzoEst()))
							{
								rowAllegatoVDto.setAA2Indirizzo(pfResp.getEstIndirizzo());
								rowAllegatoVDto.setAA2Comune(GenericUtil.getStringValid(pfResp.getEstCitta()) + " ("+GenericUtil.getStringValid(pfResp.getEstStato())+")");
								rowAllegatoVDto.setAA2Prov(null);
							}
							else
							{
								rowAllegatoVDto.setAA2Prov(pfResp.getIdProvinciaSelez());
								rowAllegatoVDto.setAA2Comune(pfResp.getComune());
								rowAllegatoVDto.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pfResp.getIndirizzo()) ? pfResp.getIndirizzo() : pfResp.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							rowAllegatoVDto.setAA2Civico(pfResp.getCivico());

							rowAllegatoVDto.setAA2RagSociale(null);
							rowAllegatoVDto.setAA2Piva(null);
							
							
						}
						
						//impresa manutentrice
						if(dettaglioImpresaManutentrice!=null){
							rowAllegatoVDto.setAA3RagSociale(dettaglioImpresaManutentrice.getDenominazione());
							rowAllegatoVDto.setAA3Piva(dettaglioImpresaManutentrice.getCodiceFiscale());

							
							if (ConvertUtil.convertToBooleanAllways(dettaglioImpresaManutentrice.getFlgIndirizzoEstero()))
							{
								rowAllegatoVDto.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoEstero());
								rowAllegatoVDto.setAA3Comune(GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCittaEstero()) + " ("+GenericUtil.getStringValid(dettaglioImpresaManutentrice.getStatoEstero())+")");
								rowAllegatoVDto.setAA3Prov(null);
							}
							else
							{
								rowAllegatoVDto.setAA3Prov(dettaglioImpresaManutentrice.getSiglaProv());
								rowAllegatoVDto.setAA3Comune(dettaglioImpresaManutentrice.getComune());
								if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoSitad()))
									rowAllegatoVDto.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoSitad());
								else if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoNonTrovato()))
									rowAllegatoVDto.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							rowAllegatoVDto.setAA3Civico(dettaglioImpresaManutentrice.getCivico());

						}
						else if (dettaglioIspezione != null)
						{
							rowAllegatoVDto.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
						}
						
					}//chiude il for sulle pagine di modulo
				}
				
				
			}else{
				//INSERIMENTO
				log.debug("[ServiziMgr::getAllegatoTipo4] ****************************** INSERIMENTO ********************************************* ");
				//istanzio gli oggetti per modol
				it.csi.sigit.sigitwebn.xml.allegato5.data.MODVDocument.MODV mod = modAllegato.addNewMODV();
				it.csi.sigit.sigitwebn.xml.allegato5.data.RichiestaDocument.Richiesta richiesta = mod.addNewRichiesta();
				List<RowAllegatoV> listaRow = richiesta.addNewDatiAllegato().addNewAllegatoV().getRowAllegatoVList();
			
				modAllegato.getMODV().addNewSystem().addNewCatDig();
				
				//dati che sono comuni e non ripetuti per ogni pagina
				it.csi.sigit.sigitwebn.xml.allegato5.data.DatiModuloDocument.DatiModulo datiModulo = richiesta.addNewDatiModulo();
				it.csi.sigit.sigitwebn.xml.allegato5.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = richiesta.addNewDatiIntestazione();
				datiIntestazione.setCodiceBollino(ConvertUtil.formattaSiglaBollino(ConvertUtil.convertToBigDecimal(da.getNumeroBollinoVerde())));
				datiModulo.setStatoModulo(Constants.STATO_MODULO_BOZZA);
				//setto l'idAllegato che adesso c'è l'ho
				datiModulo.setIdAllegato(da.getIdAllegato());
				
				//bisogna creare tante pagine quanti sono i risultati della seguente lista
				RowAllegatoV datiPrecompilati = null;
				List<SigitVSk4CgDto> listCg = null;
				
				if (da.getIdApparecchiature() != null && da.getIdApparecchiature().size() > 0)
				{
					// Recupero solo le apparecchiature selezionate nella pagina precedente
					listCg = getDbMgr().getCompCgAttiviInDataProgressivi(codImpianto, da.getDataControllo(), da.getIdApparecchiature());
				}
				else
				{
					// recupero tutte le apparecchiature
					listCg = getDbMgr().getCompCgAttiviInData(codImpianto, ConvertUtil.convertToDate(da.getDataControllo()));
				}
				
				if(listCg!=null){
					log.debug("[ServiziMgr::getAllegatoTipo3] FRAAAAAAAAAAAAAAAAAAAAAAA---> LUNGHEZZA LISTA: "+listCg.size());
				
					for (SigitVSk4CgDto dto : listCg) {
						
						datiPrecompilati = RowAllegatoV.Factory.newInstance();
						
						datiPrecompilati.setCodiceCatasto(codImpianto);
						datiPrecompilati.setAFDataControllo(ConvertUtil.convertToXmlCalendar(ConvertUtil.convertToSqlDate(da.getDataControllo())));
						//campi obbligatori che cambiano a seconda della pagina
						datiPrecompilati.setAEDataInstallaz(ConvertUtil.convertToXmlCalendar(dto.getDataInstall()));
						datiPrecompilati.setAENumCG(ConvertUtil.convertToBigInteger(dto.getProgressivo()));
						//datiPrecompilati.setAENumCircuiti(ConvertUtil.convertToBigInteger(dto.getNCircuiti()));
						
						//campi che non cambiano per le pagine
						//datiPrecompilati.setAECombustibile(dto.getDesCombustibile());
						datiPrecompilati.setAEFabbricante(dto.getDesMarca()); 
						datiPrecompilati.setAEMatricola(dto.getMatricola());
						datiPrecompilati.setAETipologia(dto.getTipologia());
						datiPrecompilati.setAECombustibile(dto.getDesCombustibile());
						
						//Tipo di dato non corretto
						datiPrecompilati.setAEEmissioniMonossido(MapDto.costruisciEmissioniMonossido(dto.getCoMin(), dto.getCoMax()));
						
						datiPrecompilati.setAEModello(dto.getModello());
						datiPrecompilati.setAEPotenzaElettrica(dto.getPotenzaElettricaKw());
						datiPrecompilati.setAEPotenzaTermica(dto.getPotenzaTermicaKw());
						
						if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty())
						{
							if(Constants.ID_RUOLO_AMMINISTRATORE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == idRuolo.intValue())
								datiPrecompilati.xsetAA2FlagAmministr(MapDto.getXmlBoolean(true));
							if(Constants.ID_RUOLO_OCCUPANTE == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == idRuolo.intValue())
								datiPrecompilati.xsetAA2FlagOccupante(MapDto.getXmlBoolean(true));
							if(Constants.ID_RUOLO_PROPRIETARIO == idRuolo.intValue() ||
									Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == idRuolo.intValue())
								datiPrecompilati.xsetAA2FlagProprietario(MapDto.getXmlBoolean(true));
						}
						else
						{
							datiPrecompilati.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(true));
						}
						
						log.debug("[ServiziMgr::getAllegatoTipo4]  ---> responsabile ed unità immobiliare *************** ");
						MapDto.mapSezCatastoAllegatoTipo4(datiPrecompilati, unitaImmobList, denominazioneComuneResp, siglaProvinciaResp);
						
						// dati responsabile impianto
						if(pg!=null)
						{

							datiPrecompilati.setAA2RagSociale(pg.getDenominazione());
							datiPrecompilati.setAA2Piva(pg.getCodiceFiscale());

							if (ConvertUtil.convertToBooleanAllways(pg.getFlgIndirizzoEst()))
							{
								datiPrecompilati.setAA2Indirizzo(pg.getEstIndirizzo());
								datiPrecompilati.setAA2Comune(GenericUtil.getStringValid(pg.getEstCitta()) + " ("+GenericUtil.getStringValid(pg.getEstStato())+")");
								datiPrecompilati.setAA2Prov(null);
							}
							else
							{
								datiPrecompilati.setAA2Prov(pg.getIdProvinciaSelez());
								datiPrecompilati.setAA2Comune(pg.getComune());
								datiPrecompilati.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pg.getIndirizzo()) ? pg.getIndirizzo() : pg.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							datiPrecompilati.setAA2Civico(pg.getCivico());

						}
						else
						{

							datiPrecompilati.setAA2Cf(pfResp.getCodiceFiscale());
							datiPrecompilati.setAA2Cognome(pfResp.getCognome());
							datiPrecompilati.setAA2Nome(pfResp.getNome());

							if (ConvertUtil.convertToBooleanAllways(pfResp.getFlgIndirizzoEst()))
							{
								datiPrecompilati.setAA2Indirizzo(pfResp.getEstIndirizzo());
								datiPrecompilati.setAA2Comune(GenericUtil.getStringValid(pfResp.getEstCitta()) + " ("+GenericUtil.getStringValid(pfResp.getEstStato())+")");
								datiPrecompilati.setAA2Prov(null);
							}
							else
							{
								datiPrecompilati.setAA2Prov(pfResp.getIdProvinciaSelez());
								datiPrecompilati.setAA2Comune(pfResp.getComune());
								datiPrecompilati.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pfResp.getIndirizzo()) ? pfResp.getIndirizzo() : pfResp.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							datiPrecompilati.setAA2Civico(pfResp.getCivico());

						}
						
						//impresa manutentrice
						if(dettaglioImpresaManutentrice!=null){
							datiPrecompilati.setAA3RagSociale(dettaglioImpresaManutentrice.getDenominazione());
							datiPrecompilati.setAA3Piva(dettaglioImpresaManutentrice.getCodiceFiscale());
							
							if (ConvertUtil.convertToBooleanAllways(dettaglioImpresaManutentrice.getFlgIndirizzoEstero()))
							{
								datiPrecompilati.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoEstero());
								datiPrecompilati.setAA3Comune(GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCittaEstero()) + " ("+GenericUtil.getStringValid(dettaglioImpresaManutentrice.getStatoEstero())+")");
								datiPrecompilati.setAA3Prov(null);
							}
							else
							{
								datiPrecompilati.setAA3Prov(dettaglioImpresaManutentrice.getSiglaProv());
								datiPrecompilati.setAA3Comune(dettaglioImpresaManutentrice.getComune());
								if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoSitad()))
									datiPrecompilati.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoSitad());
								else if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoNonTrovato()))
									datiPrecompilati.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoNonTrovato());
							}
							
							// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
							datiPrecompilati.setAA3Civico(dettaglioImpresaManutentrice.getCivico());
						}
						else if (dettaglioIspezione != null)
						{
							datiPrecompilati.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
						}
						
						//SEZIONE C. Trattamento dell'acqua
						it.csi.sigit.sigitwebn.xml.allegato5.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua =  it.csi.sigit.sigitwebn.xml.allegato5.data.TrattamentoAcquaDocument.TrattamentoAcqua.Factory.newInstance();
						if(dettaglioTrattAcqua!=null){
							log.debug("FRAAAAAAAAAAA --- > trattamento acqua ");
							trattamentoAcqua.setACDurezzaTotH2O(dettaglioTrattAcqua.getL22DurezzaH2oFr());
							
							if(dettaglioTrattAcqua.getL23FlgTrattClimaAssente() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaAssente().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OAssente(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OAssente(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaFiltr().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OFiltraz(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OFiltraz(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaAddolc().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OAddolcim(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OAddolcim(MapDto.getXmlBoolean(false));
							}
							if(dettaglioTrattAcqua.getL23FlgTrattClimaChimico() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL23FlgTrattClimaChimico().intValue())
								trattamentoAcqua.xsetACFlagTrattH2OCondizChimico(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2OCondizChimico(MapDto.getXmlBoolean(false));
							}
							
							// PERCH'E' QUI SI RICHIAMA IL 24?? IO IL 24 lo richiamo dopo
							if(dettaglioTrattAcqua.getL24FlgTrattAcsNonRich() !=null && Constants.SI_1 == dettaglioTrattAcqua.getL24FlgTrattAcsNonRich().intValue())
								trattamentoAcqua.xsetACFlagTrattH2ONR(MapDto.getXmlBoolean(true));
							else{
								trattamentoAcqua.xsetACFlagTrattH2ONR(MapDto.getXmlBoolean(false));
							}
							
							
							datiPrecompilati.setTrattamentoAcqua(trattamentoAcqua);
						}

						//a questo punto setto l'oggetto che si ripete dentro l'arrayList del modulo
						listaRow.add(datiPrecompilati);
						
					}//chiede il for sulle pagine da duplicare
				}
				
			}
			
			modAllegato.getMODV().getRichiesta().getDatiModulo().setElencoFluidoTermoVett(MapDto.mapToElencoFluidoAllegato5(getDbMgr().getElencoFluidi()));
			
			if(da.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_ALLEGATI))
		    	modAllegato.getMODV().getRichiesta().getDatiModulo().setURLchiudi(Constants.RETURN_PAGE_ELENCO_ALLEGATI_DA_PDF);
			else if(da.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_IMPIANTO))
	    		modAllegato.getMODV().getRichiesta().getDatiModulo().setURLchiudi(Constants.RETURN_PAGE_ELENCO_ALLEGATI_IMPIANTO_DA_PDF);
			else if(da.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_IMPIANTO_ISP))
	    		modAllegato.getMODV().getRichiesta().getDatiModulo().setURLchiudi(Constants.RETURN_PAGE_ELENCO_ALLEGATI_IMPIANTO_ISP_DA_PDF);
			
		    modAllegato.getMODV().getSystem().getCatDig().setModuloEditabile(true);
		    
			if (log.isDebugEnabled())
			{
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				log.debug("STAMPO ALLEGATOV RESULT: "+modAllegato);
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}
		}
		catch (Exception e) {
			log.error("Errore getAllegatoTipo4",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getAllegatoTipo4] END");
		}
		return modAllegato;
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
				throw new ServiceException(null, Messages.ERROR_RECUPERO_SERVIZIO);
			}
		}catch (Exception e) {
				log.error("Errore recupero modulo: ", e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::cercaModulo] END");
		}
	}
	*/
	/*
	public String indexUploadFileOld(String fileName, byte[]file, Metadati metadati) throws ServiceException {
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
				// Il file esiste gia', faccio l'update
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
			
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			
		}
		
		log.debug("[ServiziMgr::indexUploadFile] END");
		return uidFile;
	}
	*/

	public String caricaFileIndex(ImportFileSuper docFilter, String folder, String nomeFileMod, Metadati metadati) throws ServiceException {
		log.debug("[SigitMgr::caricaFileIndex] BEGIN");
		String uidIndex = null;
		try
		{
			uidIndex = indexUploadFileNew(nomeFileMod, new byte[0], metadati, folder, false);

			log.debug("inserisco il file fittizio - dopo - uid: "+uidIndex);

			docFilter.setUidIndex(uidIndex);
			docFilter.setNomeFileMod(nomeFileMod);

			// Inserisco il file vero
			log.debug("inserisco il file vero - prima");

			this.mtomUploadFileGeneric(docFilter);
		} catch (ServiceException e) {

			throw e;
		} 
		finally {
			log.debug("[SigitMgr::caricaFileIndex] END");

		}
		return uidIndex;
	}
	
	public String indexUploadFileNew(String fileName, byte[]file, Metadati metadati, String cartella, boolean isSovrascrivibile) throws ServiceException {
		log.debug("[ServiziMgr::indexUploadFileNew] BEGIN");
		String uidFile = null;
		Node n = null;
		Content c = null;
		Node nodoFile = null;
		OperationContext oc = null;
		try{
			
			oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
			log.debug("------- OPERATION CONTEXT --- "+oc);
			
			
			n = indexSearchFolder(getQueryLuceneSearchCartella(metadati, cartella), oc);
			log.info("Ricerca cartella='" + cartella + "'; metadati=" + metadati.toString() + ": " + (n != null ? n.getUid() : "null"));

			// Ho cercato la cartella passata come parametro
			if (n == null)
			{
				// Recupero il nodo del cod impianto
				n = new Node(indexGetFolder(metadati, oc));
				
				log.debug("STAMPO IL NODO CODICE_IMPIANTO: "+n.getUid());
				
				c = indexGetContentFolder(null);

				// creo la cartella passata come parametro
				n = indexCreateFolder(cartella, c, n, oc);

			}

			// Cerco il file
			Node nodeFile = indexSearchFolder(getQueryLuceneSearchFile(fileName, metadati, cartella), oc);

			c = indexGetContent(metadati, fileName, file);

			if (nodeFile != null && isSovrascrivibile)
			{
				// Il file esiste gia', faccio l'update
				getServiceIndex().getEcmengineDelegate().updateContentData(nodeFile, c, oc); 
				log.debug("------- UPDARE NODO --- "+nodoFile);
			}
			else
			{
				// Il file non esiste (oppure non e' previsto l'update), faccio l'insert
				nodeFile = getServiceIndex().getEcmengineDelegate().createContent(n, c, oc);
				log.debug("------- NUOVO NODO --- "+nodoFile);

				if (nodeFile != null)
				{
					uidFile = nodeFile.getUid();
				}

			}

		}
		catch (Exception e) {
			
			log.error("Errore index: ",e);
			
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			
		}
		
		log.debug("[ServiziMgr::indexUploadFileNew] END");
		return uidFile;
	}
	
	public String indexUploadDocumentoFileOld(String fileName, byte[]file, Metadati metadati) throws ServiceException {
		log.debug("[ServiziMgr::indexUploadDocumentoFile] BEGIN");
		String uidFile = null;
		Node n = null;
		Content c = null;
		Node nodoFile = null;
		OperationContext oc = null;
		try{
			
			oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
			log.debug("------- OPERATION CONTEXT --- "+oc);
			
			
			n = indexSearchFolder(getQueryLuceneSearchDocCodImpOld(metadati), oc);

			// Ho cercato la cartella dei DOC
			if (n == null)
			{
				// Recupero il nodo del cod impianto
				n = new Node(indexGetFolder(metadati, oc));
				
				log.debug("STAMPO IL NODO CODICE_IMPIANTO: "+n.getUid());
				
				c = indexGetContentFolder(null);

				// creo la cartella doc
				n = indexCreateFolder(Constants.INDEX_FOLDER_DOC, c, n, oc);

			}
			
			c = indexGetContent(metadati, fileName, file);

			// Non e' privista la modifica del documento
			n = getServiceIndex().getEcmengineDelegate().createContent(n, c, oc);
			log.debug("------- NUOVO NODO --- "+nodoFile);
			
			if (n != null)
			{
				uidFile = n.getUid();
			}
			
		}
		catch (Exception e) {
			
			log.error("Errore index: ",e);
			
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			
		}
		
		log.debug("[ServiziMgr::indexUploadFile] END");
		return uidFile;
	}
	
	public String indexUploadDistributoreFile(String fileName, byte[]file) throws ServiceException {
		log.debug("[ServiziMgr::indexUploadDistributoreFile] BEGIN");
		String uidFile = null;
		Node n = null;
		Content c = null;
		OperationContext oc = null;
		String annoCorrente = ConvertUtil.convertToString(DateUtil.getAnnoCorrente());
		try{
			
			
			oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
			log.debug("------- OPERATION CONTEXT --- "+oc);
			

			Node nodeAnno = indexSearchFolder(getQueryLuceneSearchDistrAnno(annoCorrente), oc); 

			log.debug("Stampo il node anno: "+nodeAnno);
			
			//c = indexGetContentDistr(fileName, file);
			//Content content = indexGetContentFolder(null);
			c = indexGetContentFolder(null);
			
			if (nodeAnno == null)
			{
				Node nodeApplicativo = indexSearchFolder(getQueryLuceneSearchApplicativoDistr(), oc); 

				
				log.debug("creo il node anno!!!!!!!!!!");
				nodeAnno = indexCreateFolder(annoCorrente, c, nodeApplicativo, oc);
				
				log.debug("Stampo il node anno appena creato: "+nodeAnno);

			}

			c = indexGetContentDistr(fileName, file);
			// Il file non esiste, faccio l'insert
			Node fileUpload = getServiceIndex().getEcmengineDelegate().createContent(nodeAnno, c, oc);
			
			log.debug("------- NODO TROVATO --- "+fileUpload);
			
			if (fileUpload != null)
			{
				uidFile = fileUpload.getUid();
				log.debug("UID - PADRE DEI DISTRIBUTORI: "+uidFile);
			}
			
		}
		catch (Exception e) {
			
			log.error("Errore index: ",e);
			
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			
		}
		
		log.debug("[ServiziMgr::indexUploadDistributoreFile] END");
		return uidFile;
	}
	
	/*
	public String indexUploadFileOld(String fileName, byte[]file, Metadati metadati) throws ServiceException {
		log.debug("[ServiziMgr::indexUploadFile] BEGIN");
		String uidFile = null;
		Node n = null;
		Content c = null;
		Node nodoFile = null;
		OperationContext oc = null;
		try{
			log.debug("------- PRIMA DELLA CREAZIONE --- ");
			n = null;//new Node(indexGetFolder(metadati));
//			log.debug("------- NODO FOLDER --- "+n.getUid());
			c = indexGetContent(metadati, fileName, file);
			log.debug("------- CONTENT --- "+c);
			oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
			log.debug("------- OPERATION CONTEXT --- "+oc);
			nodoFile = getServiceIndex().getEcmengineDelegate().createContent(n, c, oc);
			log.debug("------- NUOVO NODO --- "+nodoFile);
			uidFile = nodoFile.getUid();
			log.debug("------- DOPO LA CREAZIONE --- "+uidFile);
		}
		catch (Exception e) {
			//prima di rilanciare l'errore provo a fare un update del documento
			try
			{
				log.debug("------- PROVO CON LA MODIFICA DELL'ALLEGATO--- ");
				
				//Prima ricerco il file da sovrascrivere: la sintassi @cm\:name:"" mi permette di fare una ricerca puntuale 
				SearchParams param=new SearchParams();
				param.setLimit(1);
				param.setLuceneQuery("@cm\\:name:\""+fileName+"\"");
				NodeResponse resp=getServiceIndex().getEcmengineDelegate().luceneSearchNoMetadata(param,oc);
				
				if (resp!=null && resp.getNodeArray()!=null && resp.getNodeArray().length>0)
				{
					getServiceIndex().getEcmengineDelegate().updateContentData(resp.getNodeArray()[0], c, oc); 
					log.debug("------- MODIFICA ALLEGATO RIUSCITA--- ");
				}
			}
			catch (Exception e2) {
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			}
		}
		log.debug("[ServiziMgr::indexUploadFile] END");
		return uidFile;
	}
	*/
	
	public String indexSearchUIDFileInFolderNew(String fileName, Metadati metadati, OperationContext oc, String cartella) throws ServiceException {
		log.debug("[ServiziMgr::indexSearchUIDFileInFolder] BEGIN");
		String uid = null;
		try{
			
			log.debug("indexSearchUIDFileInFolderNew - cerco con il nome file nella cartella: "+cartella);

			// Siccome e' stata modificata l'archiviazione su INDEX (sono state aggiunte delle cartelle)
			// cerco prima dentro la cartella (parte nuova), se non la trovo, cerco nella cartella del codice impianto (per recuperare i file vecchi)
			uid = indexSearchUIDFileInFolder(fileName, metadati, oc, cartella);

			if (uid == null)
			{
				log.debug("indexSearchUIDFileInFolderNew - cerco con il nome file nella cartella codice_impianto: "+metadati.getCodiceImpianto());

				// se non l'ho trovato nella cartella specificata, la cerco nella cartella del codice impianto
				uid = indexSearchUIDFileInFolder(fileName, metadati, oc, null);
			}
			
			if (uid == null)
			{
				log.debug("indexSearchUIDFileInFolderNew - cerco con il nome file nella ROOT ");

				// Come ultimo tentativo cerco il nome del file su index
				uid = indexSearchUIDFileInAllRoot(fileName, metadati, oc);

			}
		}
		catch (Exception e) {
			// Se ricevo eccezione con l'UID provo a fare altre ricerche, quindi non rilancio l'eccezione
			//throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			log.error("Ho ricevuto un'eccezione nel metodo indexSearchUIDFileInFolder ma proseguo nella ricerca", e);
		}
		log.debug("[ServiziMgr::indexSearchUIDFileInFolder] END");
		return uid;
	}
	
	public String indexSearchUIDFileInFolder(String fileName, Metadati metadati, OperationContext oc, String cartella) throws ServiceException {
		log.debug("[ServiziMgr::indexSearchUIDFileInFolder] BEGIN");
		String uid = null;
		try{
			StringBuilder luceneQuery = new StringBuilder();
			luceneQuery.append("PATH:");
			luceneQuery.append("\"");
			luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
			luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
			luceneQuery.append(metadati.getCodIstatProvincia());
			luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
			luceneQuery.append(metadati.getCodIstatComune());
			luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
			luceneQuery.append(metadati.getCodiceImpianto());
			
			if (cartella != null)
			{
				luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
				luceneQuery.append(cartella);
			}
			
			luceneQuery.append("/*");
			luceneQuery.append("\"");
			luceneQuery.append(" AND ");
			luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
			luceneQuery.append("name:\"");
			luceneQuery.append(fileName);
			luceneQuery.append("\"");
			
			log.debug("-------> LUCENE QUERY "+luceneQuery);
			
			SearchParams params = new SearchParams();
			params.setLimit(0);
			params.setLuceneQuery(luceneQuery.toString());
			SearchResponse response = getServiceIndex().getEcmengineDelegate().luceneSearch(params, oc);
			if (response != null)
			{
				ResultContent[] results = response.getResultContentArray();
				
				if (results != null && results.length > 0)
				{
					log.debug("results.length " + results.length);
					uid = results[0].getUid();
					//result = getIndexManagement().retrieveContentData(new Node(uid), null, oc);
					//result = getIndexManagement().retrieveContentData(new Node(uid), indexGetContent(fileName), oc);
				}
			}
		}
		catch (Exception e) {
			// Se ricevo eccezione con l'UID provo a fare altre ricerche, quindi non rilancio l'eccezione
			//throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			log.error("Ho ricevuto un'eccezione nel metodo indexSearchUIDFileInFolder ma proseguo nella ricerca", e);
		}
		log.debug("[ServiziMgr::indexSearchUIDFileInFolder] END");
		return uid;
	}


	public String indexSearchUIDFileInAllRoot(String fileName, Metadati metadati, OperationContext oc) throws ServiceException {
		log.debug("[ServiziMgr::indexSearchUIDFileInAllRoot] BEGIN");
		String uid = null;
		try{
			StringBuilder luceneQuery = new StringBuilder();
//			luceneQuery.append("PATH:");
//			luceneQuery.append("\"");
//			luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
//			luceneQuery.append("//*");
//			luceneQuery.append("\"");
//			luceneQuery.append(" AND ");
			luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
			luceneQuery.append("name:\"");
			luceneQuery.append(fileName);
			luceneQuery.append("\"");
			
			log.debug("-------> ##### NEW ROOT LUCENE QUERY "+luceneQuery);
			
			SearchParams params = new SearchParams();
			params.setLimit(0);
			params.setLuceneQuery(luceneQuery.toString());
			SearchResponse response = getServiceIndex().getEcmengineDelegate().luceneSearch(params, oc);
			if (response != null)
			{
				ResultContent[] results = response.getResultContentArray();
				
				if (results != null && results.length > 0)
				{
					log.debug("results.length " + results.length);
					uid = results[0].getUid();
					//result = getIndexManagement().retrieveContentData(new Node(uid), null, oc);
					//result = getIndexManagement().retrieveContentData(new Node(uid), indexGetContent(fileName), oc);
				}
			}
		}
		catch (Exception e) {
			// Se ricevo eccezione con l'UID provo a fare altre ricerche, quindi non rilancio l'eccezione
			//throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			log.error("Ho ricevuto un'eccezione nel metodo indexSearchUIDFileInAllRoot ma proseguo nella ricerca", e);
		}
		log.debug("[ServiziMgr::indexSearchUIDFileInAllRoot] END");
		return uid;
	}
	
	public byte[] indexOpenFileByUIDNew(String uid, String fileName, OperationContext oc) throws ServiceException {
		log.debug("[ServiziMgr::indexOpenFileByUID] BEGIN");
		byte[] result = null;
		try{

			
			getServiceIndex().getEcmengineDelegate().retrieveContentData(new it.doqui.index.ecmengine.client.webservices.dto.Node(uid), indexGetContent(fileName), oc);	

			
			
			result = getServiceIndex().getEcmengineDelegate().retrieveContentData(new Node(uid), indexGetContent(fileName), oc);		
		}
		catch (Exception e) {
			// Se ricevo eccezione con l'UID provo a fare altre ricerche, quindi non rilancio l'eccezione
			//throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			log.error("Ho ricevuto un'eccezione nel metodo indexOpenFileByUID ma proseguo nella ricerca", e);
		}
		log.debug("[ServiziMgr::indexOpenFileByUID] END");
		return result;
	}
	
	public byte[] indexOpenFileByUID(String uid, String fileName, OperationContext oc) throws ServiceException {
		log.debug("[ServiziMgr::indexOpenFileByUID] BEGIN");
		byte[] result = null;
		try{

			
			result = getServiceIndex().getEcmengineDelegate().retrieveContentData(new Node(uid), indexGetContent(fileName), oc);		
		}
		catch (Exception e) {
			// Se ricevo eccezione con l'UID provo a fare altre ricerche, quindi non rilancio l'eccezione
			//throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			log.error("Ho ricevuto un'eccezione nel metodo indexOpenFileByUID ma proseguo nella ricerca", e);
		}
		log.debug("[ServiziMgr::indexOpenFileByUID] END");
		return result;
	}
	
	
	private final String INDEX_MNG_RESOURCE = "/META-INF/defpd_indexmngmt.xml";
	private final String INDEX_SRC_RESOURCE = "/META-INF/defpd_indexsearch.xml";
//	private final String INDEX_SEC_RESOURCE = "/META-INF/defpd_indexsecurity.xml";

	public void indexDeleteContent(String fileName, Metadati metadati) throws ServiceException
	{
		log.debug("[ServiziMgr::indexDeleteContent] START");
		try{
			StringBuilder luceneQuery = new StringBuilder();
			luceneQuery.append("PATH:");
			luceneQuery.append("\"");
			luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
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
			luceneQuery.append(fileName);
			luceneQuery.append("\"");
			
			log.debug("-------> LUCENE QUERY "+luceneQuery);
			
			SearchParams params = new SearchParams();
			params.setLimit(0);
			params.setLuceneQuery(luceneQuery.toString());
			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
			SearchResponse response = getServiceIndex().getEcmengineDelegate().luceneSearch(params, oc);
			ResultContent[] results = response.getResultContentArray();
			log.debug("results.length " + results.length);
			String uid = results[0].getUid();
			getServiceIndex().getEcmengineDelegate().deleteContent(new Node(uid), oc);
		}
		catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		
		log.debug("[ServiziMgr::indexDeleteContent] END");
	}
	
	public void indexDeleteContentByUid(String fileUid) throws ServiceException
	{
		log.debug("[ServiziMgr::indexDeleteContentByUid] START");
		try{
			
			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);

			getServiceIndex().getEcmengineDelegate().deleteContent(new Node(fileUid), oc);
		}
		catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		
		log.debug("[ServiziMgr::indexDeleteContentByUid] END");
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
	
	private Content indexGetContent(Metadati metadati, String fileName, byte[] file) throws ServiceException {
		log.debug("[ServiziMgr::indexGetContent] BEGIN");
		Content c = indexGetContent(fileName);
		c.setModelPrefixedName(Constants.INDEX_SIGIT_PREFIX_MODEL);
		c.setProperties(indexSetMetadati(metadati));
		c.setContent(file);
		log.debug("[ServiziMgr::indexGetContent] END");
		return c;
	}

	private Content indexGetContentDistr(String fileName, byte[] file) throws ServiceException {
		log.debug("[ServiziMgr::indexGetContentDistr] BEGIN");
		Content c = indexGetContent(fileName);
		c.setModelPrefixedName(Constants.INDEX_DISTRIBUTORI_PREFIX_MODEL);
		//c.setProperties(indexSetMetadati(metadati));
		c.setContent(file);
		log.debug("[ServiziMgr::indexGetContentDistr] END");
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
		catch (RemoteException e) {
			throw new ServiceException(e, /*CommonMsgCodeEnum.COMMON_S036*/"");
		}
		log.debug("[ServiziMgr::indexGetMimeType] Mime Type " + mime[0].getMimetype());
		log.debug("[ServiziMgr::indexGetMimeType] END");
		return mime[0].getMimetype();
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
	

	/*
	public String indexSearchFolder(SearchParams params, String folderName, String uidParent) throws ServiceException {
		log.debug("[ServiziMgr::indexSearchFolder] BEGIN");
		String uid = null;
		try{
			
			log.debug("Stampo la query lucene (OLD): "+params.getXPathQuery());
			//GenericUtil.stampa(params, true, 3);
			
			//Da sostituire con lucenesurcenometadata
			uid = getServiceIndex().getEcmengineDelegate().nodeExists(params, indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN));
		}
		catch(NoDataExtractedException e){
			if(uidParent!=null){
				uid = indexCreateFolder(folderName, uidParent);
			}
		}
		catch(Exception e){
			throw new ServiceException(e, "CommonMsgCodeEnum.COMMON_S036");
		}
		log.debug("[ServiziMgr::indexSearchFolder] END");
		return uid;
	}
	*/
	
	protected String indexCreateFolder(String folderName, String uidParent) throws ServiceException {
		log.debug("[ServiziMgr::indexCreateFolder] BEGIN");
		String uidFolder = null;
		try{
			uidFolder = getServiceIndex().getEcmengineDelegate().createContent(new Node(uidParent), indexGetContentFolder(folderName), indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN)).getUid();
		}
		catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		log.debug("[ServiziMgr::indexCreateFolder] END");
		return uidFolder;
	}
	
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
	
//	private SigitTPersonaGiuridicaDto getImpresaManutentrice(String idImpRuoloPfPg) throws ServiceException {
//		log.debug("[ServiziMgr::getImpresaManutentrice] BEGIN");
//		SigitTPersonaGiuridicaDto dettaglioPersonaGiuridica = null;
//		try {
//			SigitRImpRuoloPfpgPk pk = new SigitRImpRuoloPfpgPk();
//			pk.setIdImpRuoloPfpg(new BigDecimal(idImpRuoloPfPg));
//			SigitRImpRuoloPfpgDto dettaglioRuoloPfPg = getDbMgr().getSigitRImpRuoloPfpgDao().findByPrimaryKey(pk);
//			SigitTPersonaGiuridicaPk pkg = new SigitTPersonaGiuridicaPk();
//			pkg.setIdPersonaGiuridica(dettaglioRuoloPfPg.getFkPersonaGiuridica());
//			dettaglioPersonaGiuridica = getDbMgr().getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkg );
//		} catch (SigitRImpRuoloPfpgDaoException e) {
//			throw new ServiceException(e, "Eccezione nel cercare la persona giuridica dalla tabella sigit_r_imp_ruolo_pfpg");
//		} catch (SigitTPersonaGiuridicaDaoException e) {
//			throw new ServiceException(e, "Eccezione nel cercare la persona giuridica dalla tabella sigit_t_persona_giuridica");
//		}finally{
//			log.debug("[ServiziMgr::getImpresaManutentrice] END");
//		}
//		return dettaglioPersonaGiuridica;
//		
//	}
	
	/*
	private SearchParams getQueryLuceneSearchRootDistr()
	{
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
		luceneQuery.append(Constants.INDEX_NAME_DISTRIBUTORI+"\"");
		
		log.debug("getQueryLuceneSearchRootDistr: "+luceneQuery.toString());
		
		searchParams.setLuceneQuery(luceneQuery.toString());
		
		return searchParams;
	}
	*/
	
	private SearchParams getQueryLuceneSearchDocCodImpOld(Metadati metadati)
	{
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);
		
		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
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
		luceneQuery.append(Constants.INDEX_FOLDER_DOC+"\"");
		
		log.debug("getQueryLuceneSearchDocCodImp: "+luceneQuery.toString());
		
		searchParams.setLuceneQuery(luceneQuery.toString());
		
		return searchParams;
	}
	
	private SearchParams getQueryLuceneSearchCartella(Metadati metadati, String cartella)
	{
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);
		
		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
		if (metadati.getCodIstatProvincia() != null && !metadati.getCodIstatProvincia().equals("")) {
			luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
			luceneQuery.append(metadati.getCodIstatProvincia());
		}
		if (metadati.getCodIstatComune() != null && !metadati.getCodIstatComune().equals("")) {
			luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
			luceneQuery.append(metadati.getCodIstatComune());
		}
		if (metadati.getCodiceImpianto() != null && !metadati.getCodiceImpianto().equals("")) {
			luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
			luceneQuery.append(metadati.getCodiceImpianto());
		}
		luceneQuery.append("/*");
		luceneQuery.append("\"");
		luceneQuery.append(" AND ");
		luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
		luceneQuery.append("name:\"");
		luceneQuery.append(cartella+"\"");
		
		log.debug("getQueryLuceneSearchCartella: "+luceneQuery.toString());
		
		searchParams.setLuceneQuery(luceneQuery.toString());
		
		return searchParams;
	}
	
	private SearchParams getQueryLuceneSearchCodImp(Metadati metadati)
	{
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);
		
		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
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
		luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
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
		luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
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
	
	private SearchParams getQueryLuceneSearchApplicativoDistr()
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
		luceneQuery.append(Constants.INDEX_FRUITORE_DISTRIBUTORE + "\"");
		
		log.debug("getQueryLuceneSearchApplicativoDistr: "+luceneQuery.toString());
		
		searchParams.setLuceneQuery(luceneQuery.toString());
		
		return searchParams;
	}
	
	private SearchParams getQueryLuceneSearchDistrAnno(String anno)
	{
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
		
		log.debug("getQueryLuceneSearchDistrAnno: "+luceneQuery.toString());
		
		searchParams.setLuceneQuery(luceneQuery.toString());
		
		return searchParams;
	}
	
	private SearchParams getQueryLuceneSearchApplicativo()
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
		luceneQuery.append(Constants.INDEX_FRUITORE + "\"");
		
		log.debug("getQueryLuceneSearchApplicativo: "+luceneQuery.toString());
		
		searchParams.setLuceneQuery(luceneQuery.toString());
		
		return searchParams;
	}
	
	private SearchParams getQueryLuceneSearchFile(String nomeFile, Metadati metadati, String cartella)
	{
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);

		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatProvincia());
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatComune());
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodiceImpianto());
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(cartella);
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
	
	private String indexGetFolder(Metadati metadati, OperationContext op) throws ServiceException {
		log.debug("[ServiziMgr::indexGetFolder] BEGIN");
		boolean isSigitDocPaFolderMissing = true;
		Node nodeApplicativo = null;
		Node nodeProvincia = null;
		Node nodeComune = null;
		Node nodeCodImp = null;
		
		try {
			
			Content content = indexGetContentFolder(null);
			
			if (metadati.getCodiceImpianto() != null && !metadati.getCodiceImpianto().equals("")) {
				nodeCodImp = indexSearchFolder(getQueryLuceneSearchCodImp(metadati), op);
				log.debug("Ho cercato il codice impianto: "+nodeCodImp);
			}
			
			if (nodeCodImp == null)
			{
				log.debug("Non esiste il nodo codice impianto");
				
				if (metadati.getCodIstatComune() != null && !metadati.getCodIstatComune().equals("")) {
					nodeComune = indexSearchFolder(getQueryLuceneSearchComune(metadati), op);
					log.debug("Ho cercato il comune: "+nodeComune);
				}
				
				if (nodeComune == null)
				{
					log.debug("Non esiste il nodo comune");
					
					if (metadati.getCodIstatProvincia() != null && !metadati.getCodIstatProvincia().equals("")) {
						nodeProvincia = indexSearchFolder(getQueryLuceneSearchProvincia(metadati), op); 
						log.debug("Ho cercato la provincia: "+nodeProvincia);
					}
					
					if (nodeProvincia == null)
					{
						log.debug("Non esiste il nodo provincia");
						
						nodeApplicativo = indexSearchFolder(getQueryLuceneSearchApplicativo(), op); 

						log.debug("Ho cercato l'applicativo: "+nodeApplicativo);
						
						if (nodeApplicativo == null)
						{
							log.debug("Se non esiste neanche l'applicativo rilancio l'eccezione!!!");
							throw new ServiceException("Su INDEX non e' configurato l'applicativo");
						}
						
						if (metadati.getCodIstatProvincia() != null && !metadati.getCodIstatProvincia().equals("")) {
							log.debug("creo il nodo provincia");
							nodeProvincia = indexCreateFolder(metadati.getCodIstatProvincia(), content, nodeApplicativo, op);
							log.debug("ho creato il nodo provincia: "+nodeProvincia.getUid());
							isSigitDocPaFolderMissing = false;
						}
						
					}
					
					if (metadati.getCodIstatComune() != null && !metadati.getCodIstatComune().equals("")) {
						log.debug("creo il nodo comune");
						nodeComune = indexCreateFolder(metadati.getCodIstatComune(), content, nodeProvincia, op);
						log.debug("ho creato il nodo comune: " + nodeComune.getUid());
						isSigitDocPaFolderMissing = false;
					}

				}

				if (metadati.getCodiceImpianto() != null && !metadati.getCodiceImpianto().equals("")) {
					log.debug("creo il nodo codice impianto");
					nodeCodImp = indexCreateFolder(metadati.getCodiceImpianto(), content, nodeComune, op);
					log.debug("ho creato il nodo codice impianto: " + nodeCodImp.getUid());
					isSigitDocPaFolderMissing = false;
				}
				
				if (isSigitDocPaFolderMissing) {
					nodeCodImp = nodeApplicativo;
				}
				
			}
			
			return nodeCodImp.getUid();
		}
		catch (ServiceException e) {
			throw e;
		}
		catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[ServiziMgr::indexGetFolder] END");
		}
	}
	
	private String indexGetFolderDoc(Metadati metadati, OperationContext op) throws ServiceException {
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
							throw new ServiceException("Su INDEX non e' configurato l'applicativo");
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
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[ServiziMgr::indexGetFolder] END");
		}
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
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		log.debug("[ServiziMgr::indexCreateFolder] END");
		return folder;
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
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		log.debug("[ServiziMgr::indexSearchFolder] END");
		return node;
	}
	
	public String getMimeTypeFile(String nomeFile, byte[] file) throws ServiceException {
		log.debug("[ServiziMgr::getMimeType] BEGIN");
		String result = null;
		try{
			
			if (log.isDebugEnabled())
			{
				log.debug("Stampo il nome file: "+nomeFile);
				log.debug("Stampo il file: "+file);
			}
			
			FileInfo fileInfo = new FileInfo();
			fileInfo.setName(nomeFile);
			fileInfo.setContents(file);
			fileInfo.setStore(false);
			
			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
			
			FileFormatInfo[] fileFormatInfo = getServiceIndex().getEcmengineDelegate().getFileFormatInfo(fileInfo, oc);
			
			if (fileFormatInfo != null && fileFormatInfo.length > 0) {
				
				//GenericUtil.stampa(fileFormatInfo[0], true, 3);
				
				result = fileFormatInfo[0].getMimeType();
				/*
				outVal = new it.csi.sicee.siceeorch.dto.siceeorch.MimeTypeInfo();
				outVal.setMimeType(slot_fileFormatInfo[0].getMimeType());
				outVal.setDataIdentificazione(slot_fileFormatInfo[0]
						.getIdentificationDate());
				outVal.setDescrizione(slot_fileFormatInfo[0].getDescription());
				outVal.setFormatoVersione(slot_fileFormatInfo[0].getFormatVersion());
				outVal.setTipoCodice(slot_fileFormatInfo[0].getTypeCode());
				outVal.setTipoDescrizione(slot_fileFormatInfo[0]
						.getTypeDescription());
				outVal.setWarning(slot_fileFormatInfo[0].getWarning());
				*/
			}
		}
		catch (Exception e) {
			// Se ricevo eccezione con l'UID provo a fare altre ricerche, quindi non rilancio l'eccezione
			log.error("Ho ricevuto un'eccezione nel metodo getFileFormatInfo", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		log.debug("[ServiziMgr::indexOpenFileByUID] END");
		return result;
	}
	
	public void uploadXMLLibretto(Integer codiceImpianto, byte[] xml, String codiceFiscalePF, String idPersonaGiuridica) throws ServiceException {
		log.debug("[ServiziMgr::uploadXMLLibretto] START");
		try {
			JWTDto jwtDto = JWTUtil.generaTokenFruitoreInterno(codiceFiscalePF, idPersonaGiuridica);
			
			getSigitExtMgr().uploadXMLLibrettoJWT(codiceImpianto, xml, jwtDto.getToken());
		} catch (SigitextException e) {
			log.error("Errore sigitext uploadXMLLibretto", e);
			throw new ServiceException(e, e.getMessage());
		} catch (Exception e) {
			log.error("Errore sigitext uploadXMLLibretto", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			log.debug("[ServiziMgr::uploadXMLLibretto] END");
		}
	}
	
	public Integer uploadXMLControllo(Integer codiceImpianto, String tipoControllo, byte[] xml, String codiceFiscalePF, String idPersonaGiuridica) throws ServiceException {
		log.debug("[ServiziMgr::uploadXMLControllo] START");
		try {
			JWTDto jwtDto = JWTUtil.generaTokenFruitoreInterno(codiceFiscalePF, idPersonaGiuridica);
			
			return getSigitExtMgr().uploadXMLControlloJWT(codiceImpianto, tipoControllo, xml, jwtDto.getToken());
			
		} catch (SigitextException e) {
			log.error("Errore sigitext uploadXMLControllo", e);
			throw new ServiceException(e, e.getMessage());
		} catch (Exception e) {
			log.error("Errore sigitext uploadXMLControllo", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			log.debug("[ServiziMgr::uploadXMLControllo] END");
		}
	}
	
	public Documento getXMLLibrettoConsolidato(Integer codiceImpianto, String codiceFiscalePF, String idPersonaGiuridica) throws ServiceException {
		log.debug("[ServiziMgr::getXMLLibrettoConsolidato] START");
		try {
			JWTDto jwtDto = JWTUtil.generaTokenFruitoreInterno(codiceFiscalePF, idPersonaGiuridica);
			
			return getSigitExtMgr().getXMLLibrettoConsolidatoJWT(codiceImpianto, jwtDto.getToken());
		} catch (SigitextException e) {
			log.error("Errore sigitext getXMLLibrettoConsolidato", e);
			throw new ServiceException(e, e.getMessage());
		} catch (Exception e) {
			log.error("Errore sigitext getXMLLibrettoConsolidato", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			log.debug("[ServiziMgr::getXMLLibrettoConsolidato] END");
		}
	}
	
	public Documento downloadLetteraAvviso(Integer idIspezione, String codiceFiscalePF, String idPersonaGiuridica) throws ServiceException {
		log.debug("[ServiziMgr::downloadLetteraAvviso] START");
		try {
			JWTDto jwtDto = JWTUtil.generaTokenFruitoreInterno(codiceFiscalePF, idPersonaGiuridica);
			return getSigitExtMgr().getLetteraAvvisoJWT(idIspezione, jwtDto.getToken());
		} catch (SigitextException e) {
			log.error("Errore sigitext downloadLetteraAvviso", e);
			throw new ServiceException(e, e.getMessage());
		} catch (Exception e) {
			log.error("Errore sigitext downloadLetteraAvviso", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			log.debug("[ServiziMgr::downloadLetteraAvviso] END");
		}
	}
	
	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByFiltroJWT(ImpiantoFiltro impiantoFiltro, UtenteLoggato utente) throws ServiceException {
		log.debug("[ServiziMgr::getImpiantoByFiltroJWT] START");
		try {
			JWTDto jwtDto = JWTUtil.generaTokenFruitoreInterno(utente.getCodiceFiscale(), ConvertUtil.convertToString(utente.getRuolo().getIdPersonaGiuridica()));
			
			return getSigitExtMgr().getImpiantoByFiltroJWT(impiantoFiltro, jwtDto.getToken());
		} catch (SigitextException e) {
			log.error("Errore sigitext getImpiantoByFiltroJWT", e);
			throw new ServiceException(e, e.getMessage());
		} catch (Exception e) {
			log.error("Errore sigitext getImpiantoByFiltroJWT", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			log.debug("[ServiziMgr::getImpiantoByFiltroJWT] END");
		}
	}
	
	public List<Double> getLOCCSICoordinates(String indirizzo) throws ServiceException {
		log.debug("[ServiziMgr::getLOCCSICoordinates] START");
		try {
			
			if (this.tokenOauthLoccsi == null) {				
				this.tokenOauthLoccsi = getTokenLoccsi();
			}
			
			StringBuilder apiUrlString = new StringBuilder(getProperties().getProperty(Constants.LOCCSI_API_URL));
			apiUrlString.append("?q=").append(URLEncoder.encode(indirizzo, "UTF-8"));
			
			URL apiUrl = new URL(apiUrlString.toString());
			
			HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
		    
		    connection.setConnectTimeout(Constants.LOCCSI_TIMEOUT);
		    connection.setDoOutput(true);
		    connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setUseCaches(false);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("charset", "UTF-8");
			connection.setRequestProperty("Authorization", "Bearer " + tokenOauthLoccsi);
			
			int responseCode = connection.getResponseCode();
			
			if (responseCode == 401 || responseCode == 403) {
				this.tokenOauthLoccsi = getTokenLoccsi();
				connection.setRequestProperty("Authorization", "Bearer ".concat(tokenOauthLoccsi));
				responseCode = connection.getResponseCode();
			}
			
			if (responseCode != 200) {
				throw new ServiceException(getHttpResponse(connection.getErrorStream()));
			}
			
			String jsonResponseString = getHttpResponse(connection.getInputStream());
			
			JSONArray jsonResponse = new JSONArray(jsonResponseString);
			
			for (int i = 0; i < jsonResponse.length(); i++) {
				JSONObject coordinatesJson = jsonResponse.getJSONObject(i);
				
				if (coordinatesJson.getString("name").equals(Constants.LOCCSI_SEZIONE_COORDINATE_JSON)) {
					
					JSONArray featureList = coordinatesJson.getJSONObject("featureCollection").getJSONArray("features");
					
					if (featureList.length() == 0) {
						throw new ServiceException("Coordinate non trovate per l'indirizzo " + indirizzo);
					}
										
					JSONArray coordinates = featureList.getJSONObject(0).getJSONObject("geometry").getJSONArray("coordinates");
					
					List<Double> coordinatesList = new ArrayList<Double>();
					
					for (int j = 0; j < coordinates.length(); j++) {
						coordinatesList.add(coordinates.getDouble(j));
					}
					
					return coordinatesList;
				}
			}
			
			throw new ServiceException("Coordinate non trovate per l'indirizzo " + indirizzo);
			
		} catch (ServiceException e) {
			if (e.getMessage().contains("Coordinate non trovate")) {
				log.info("Errore LOCCSI getLOCCSICoordinates", e);
			} else {
				log.error("Errore LOCCSI getLOCCSICoordinates", e);
			}
			throw e;
		} catch (Exception e) {
			log.error("Errore LOCCSI getLOCCSICoordinates", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			log.debug("[ServiziMgr::getLOCCSICoordinates] END");
		}
		
		
	}

	private String getTokenLoccsi() throws Exception {

		String oauthURL = getProperties().getProperty(Constants.LOCCSI_TOKEN_URL);
		String consumerKey = getProperties().getProperty(Constants.LOCCSI_TOKEN_CONSUMERKEY);
		String consumerSecret = getProperties().getProperty(Constants.LOCCSI_TOKEN_CONSUMERSECRET);	
		
		StringBuilder tokenUrl = new StringBuilder(oauthURL);
		tokenUrl.append("?grant_type=client_credentials");
		
		URL apiUrl = new URL(tokenUrl.toString());
		HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
		connection.setConnectTimeout(Constants.LOCCSI_TIMEOUT);
	    connection.setDoOutput(true);
	    connection.setDoInput(true);
		connection.setInstanceFollowRedirects(false);
		connection.setUseCaches(false);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("charset", "UTF-8");
		
		StringBuilder postBody = new StringBuilder();
		postBody.append("client_id=");
		postBody.append(URLEncoder.encode(consumerKey,"UtF-8"));
		postBody.append("&client_secret=");
		postBody.append(URLEncoder.encode(consumerSecret,"UtF-8"));
		
		byte[] postBodyByteArray = postBody.toString().getBytes(StandardCharsets.UTF_8);
		
		int postBodyLength = postBodyByteArray.length;	
		connection.setRequestProperty("Content-Length", Integer.toString(postBodyLength));
		try(DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
		   wr.write(postBodyByteArray);
		   wr.close();
		}
		
		int responseCode = connection.getResponseCode();
				
		if (responseCode != 200) {
			throw new ServiceException(getHttpResponse(connection.getErrorStream()));
		}
		
		String jsonResponseString = getHttpResponse(connection.getInputStream());
		
		JSONObject json = new JSONObject(jsonResponseString);
        
		return json.getString("access_token");
	}
	
	private String getHttpResponse(InputStream responseStream) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(responseStream, StandardCharsets.UTF_8));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		return response.toString();
	}

	public it.doqui.index.ecmengine.client.webservices.dto.engine.security.Document extractDocument(EnvelopedContent content) throws RemoteException {
		OperationContext moc = new OperationContext();
		moc.setUsername(Constants.INDEX_USERNAME_ADMIN);
		moc.setPassword(Constants.INDEX_PSW);
		moc.setRepository(Constants.INDEX_REPOSITORY);
		moc.setFruitore(Constants.INDEX_FRUITORE);
		moc.setNomeFisico(Constants.INDEX_UTENTE);
		try {
			return getServiceIndex().getEcmengineDelegate().extractDocumentFromEnvelope(content, moc);
		}catch (Exception e){
			log.error("[EXTRACT DOCUMENT] Errore occorso nell'esecuzione del metodo:" + e.getMessage(), e);
			throw e;
		}
	}

}