/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package test;

//import it.csi.sigit.sigitbatchn.business.manager.util.MyHandlerNew;
//import it.csi.sigit.sigitbatchn.business.manager.util.PartialXmlEventReader;
//import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.DatiFornituraCliente;
import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.UTENZEDISTComunicazione;

//import it.csi.sigit.sigitbatchn.business.manager.UTENZEDISTComunicazione;
import it.csi.sigit.sigitbatchn.business.manager.util.Message;
import it.csi.sigit.sigitbatchn.business.manager.util.Messages;
import it.csi.sigit.sigitbatchn.business.manager.util.PartialXmlEventReader;
import it.csi.sigit.sigitbatchn.business.manager.util.ServiceException;
import it.csi.sigit.sigitbatchn.business.util.GenericUtil;
import it.csi.sigit.sigitbatchn.business.util.XmlValidationHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.namespace.QName;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.io.IOUtils;
import org.xml.sax.helpers.DefaultHandler;

//import com.ximpleware.AutoPilot;
//import com.ximpleware.NavException;
//import com.ximpleware.VTDGen;
//import com.ximpleware.VTDNav;
//import com.ximpleware.XPathEvalException;
//import com.ximpleware.XPathParseException;

public class TestParsXml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//parseXML();
		//parse2();
		//parse3FUNZIONA();
		//parse4n();
		
		//parseXmlValidation();
		
		unmarshalDemo();
		
	}
	
	private static void parseXmlValidation()
	{
		InputStream in = null;
		try {
		final JAXBContext context = JAXBContext.newInstance(UTENZEDISTComunicazione.class);
		final Unmarshaller um = context.createUnmarshaller();
		
		//String schemasDir = "sigitbatchn-xmlbean-client.jar/";
		String schemasDir = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
		String distributoreSchema = schemasDir + "D:\\progetti\\eclipse luna\\energia\\sigit_sigitbatchn\\src\\adobe\\Schemas\\Import-Utenze-Distributori-1.0.0.xsd";
		
		
		String fileXml = "C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 3\\2015_esempio XML 1.0.0_3.1.xml";
		in = GenericUtil.getFileInClassPath(fileXml);
				
		System.out.println("in: "+in);
		System.out.println("fileXml: "+fileXml);
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
		
			//reader = new BufferedReader(new FileReader("C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 3\\2015_esempio XML 1.0.0_3.1.xml"));
			//reader = new BufferedReader(new FileReader("C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 2\\2015_esempio XML 1.0.0_tc.1_BIG.xml"));
			//ism = new FileInputStream("/home/apps/jbcp09/dev-jboss43cp09-008/deploy/sigitbatchn/xml/test.xml");

			final QName qName = new QName("datiFornituraCliente");
			final XMLInputFactory xif = XMLInputFactory.newInstance();
			final XMLEventReader xmlEventReader = xif.createXMLEventReader(in);
			
			UTENZEDISTComunicazione utenze =
					(UTENZEDISTComunicazione) um.unmarshal(new PartialXmlEventReader(xmlEventReader, qName));

			um.unmarshal(new PartialXmlEventReader(xmlEventReader, qName));
			
			//System.out.println("Stampo il numero di forniture: "+utenze.getDatiFornituraCliente().size());

		} 
		catch(Exception e) {
			System.out.println("Errore nel rimappaggio del file: " +e);
			e.printStackTrace();
			//throw new ServiceException(e, new Message(Messages.ERROR_MAPPATURA_XML));
		} 
		finally {
			IOUtils.closeQuietly(in);
		}

	}
	
	
	
	private static void unmarshalDemoOK ()
	{
		 
	   try
	   {
	        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
	        Schema schema = sf.newSchema(new File("D:\\progetti\\eclipse luna\\energia\\sigit_sigitbatchn\\src\\adobe\\Schemas\\Import-Utenze-Distributori-1.0.0.xsd")); 
	 
	        
	        String schemasDir = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
			String distributoreSchema = schemasDir + "Import-Utenze-Distributori-1.0.0.xsd";
	        
	        JAXBContext jc = JAXBContext.newInstance(UTENZEDISTComunicazione.class);
	 
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        unmarshaller.setSchema(schema);
	        unmarshaller.setEventHandler(new TestXmlValidationHandler());
	        
	        String pathFile = "C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 3\\";
	        //String urlFile = "2015_allegatoII_CitTestAllegato_OK.xml";
	        String urlFile = "2015_esempio XML 1.0.0_3.3 - errato.xml"; // OK
	        //String urlFile = "2015_esempio XML 1.0.0_3.1.xml"; // OK
	        UTENZEDISTComunicazione customer = (UTENZEDISTComunicazione) unmarshaller.unmarshal(new File(pathFile+urlFile));
	    
	   }
	   catch (Exception ex)
	   {
		   ex.printStackTrace();
	   }
	}

	private static void unmarshalDemo ()
	{
		 
	   try
	   {
	        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
	        Schema schema = sf.newSchema(new File("D:\\progetti\\eclipse luna\\energia\\sigit_sigitbatchn\\src\\adobe\\Schemas\\Import-Utenze-Distributori-1.0.0.xsd")); 
	 
	        
	        String schemasDir = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
			String distributoreSchema = schemasDir + "Import-Utenze-Distributori-1.0.0.xsd";
	        
	        JAXBContext jc = JAXBContext.newInstance(UTENZEDISTComunicazione.class);
	 
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        unmarshaller.setSchema(schema);
	        
	        ValidationEventCollector validationCollector = new JAXB2ValidationEventCollector();
	        unmarshaller.setEventHandler(validationCollector);

	        //unmarshaller.setEventHandler(new TestXmlValidationHandler());
	        
	        
//	        System.out.println("ValidationEvent.ERROR: "+ValidationEvent.ERROR);
//	        System.out.println("ValidationEvent.FATAL_ERROR: "+ValidationEvent.FATAL_ERROR);
//	        System.out.println("ValidationEvent.WARNING: "+ValidationEvent.WARNING);
	        
	        //boolean isCorrect = true;
	        /*
	        unmarshaller.setEventHandler(new ValidationEventHandler() {
	            
	        	final boolean isCorrect = true;
	        	@SuppressWarnings("synthetic-access") public boolean handleEvent(ValidationEvent ve){
	              if (ve.getSeverity() != ValidationEvent.WARNING) {
	            	  ValidationEventLocator  vel=ve.getLocator();
	                System.out.println("WARNING - Line:Col[" + vel.getLineNumber() + ":"+ vel.getColumnNumber()+ "]:"+ ve.getMessage());
	                //isCorrect = true;
	              }
	              
	              if (true)
						throw new ServiceException(new Message(Messages.ERROR_MAPPATURA_XML));
					

	              System.out.println("RETURN TRUE");
	              return true;
	            }
	          }
	      );
	        */
	        
	        String pathFile = "C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 3\\";
	        //String urlFile = "2015_allegatoII_CitTestAllegato_OK.xml";
	        String urlFile = "2015_esempio XML 1.0.0_3.3 - errato.xml"; // OK
	        //String urlFile = "2015_esempio XML 1.0.0_3.1.xml"; // OK
	        UTENZEDISTComunicazione customer = (UTENZEDISTComunicazione) unmarshaller.unmarshal(new File(pathFile+urlFile));
	    
	        System.out.println("validationCollector: "+validationCollector);
	        System.out.println("validationCollector.hasEvents(): "+validationCollector.hasEvents());
	        
	        if(validationCollector.hasEvents())
	        {
	            for(ValidationEvent event:validationCollector.getEvents())
	            {
	                String msg = event.getMessage();
	                System.out.println(msg);
	            }
	        }
	        
	   }
	   catch (Exception ex)
	   {
		   ex.printStackTrace();
	   }
	}

	/*
	private static void parse4n()
	{
		try
		{
			final JAXBContext context = JAXBContext.newInstance(UTENZEDISTComunicazione.class);
		    final Unmarshaller um = context.createUnmarshaller();
		    Reader reader = null;
		    try {
		        //reader = new BufferedReader(new FileReader("C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 3\\2015_esempio XML 1.0.0_3.1.xml"));
		    	reader = new BufferedReader(new FileReader("C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 2\\2015_esempio XML 1.0.0_tc.1_BIG.xml"));
		        final QName qName = new QName("datiFornituraCliente");
		        final XMLInputFactory xif = XMLInputFactory.newInstance();
		        final XMLEventReader xmlEventReader = xif.createXMLEventReader(reader);
		        final UTENZEDISTComunicazione example =
		                (UTENZEDISTComunicazione) um.unmarshal(new PartialXmlEventReader(xmlEventReader, qName));
		        
		        System.out.println("Stampo example: "+example.getDatiFornituraCliente().size());
		        
		        
		    } finally {
		        IOUtils.closeQuietly(reader);
		    }
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	/*
	private static void parse3FUNZIONA()
	{
		try
		{
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
	   	 
	        DefaultHandler handler = new MyHandlerNew();
	 
	        InputStream ism = new FileInputStream("C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 3\\2015_esempio XML 1.0.0_3.1.xml");
	        
	        parser.parse(ism, handler);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	/*
	
	private static void parse2()
	{
		VTDGen vg = new VTDGen();
        int i;
        AutoPilot ap = new AutoPilot();
        try {
			//ap.selectXPath("/UTENZEDIST_Comunicazione/datiFornituraCliente/datiCliente/pfPg/text()");
        	ap.selectXPath("/UTENZEDIST_Comunicazione/datiFornituraCliente");
		
	        if (vg.parseFile("C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 2\\NEW BIG\\provaImportDistrib.xml", false))
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
		} 
        catch (XPathEvalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NavException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	/*
	private static void parseXML()
	{
		
		
		
		
		
		
		
		
		
		VTDGen vg = new VTDGen();
		
    	System.out.println("CREO VTDNav - prima");

    	
    	//VTDNav vn = vg.loadIndex(in);
    	
    	System.out.println("CREO VTDNav - dopo");
    	
    	
    	
    	
		if (vg.parseFile("C:\\Users\\1277\\Desktop\\test\\sigitbatch\\test di carico\\Caso 3\\2015_esempio XML 1.0.0_3.1.xml",true)){

			VTDNav vn = vg.getNav();
			
			
			
			System.out.println("VTDNav.FIRST_CHILD: "+VTDNav.FIRST_CHILD);
			try {
			
				System.out.println("vn.getNestingLevel(): "+vn.getNestingLevel());
				System.out.println("vnElementFragmentNs: "+vn.getElementFragmentNs().getSize());
				
				System.out.println("vn.getText(): "+vn.getText());

		          if (vn.toElement(VTDNav.FC,"datiFornituraCliente")){ 
		          }
		          else
		          {
		        	  System.out.println("NIENTE");
		          }
				
				System.out.println("vn: "+vn.getAttrValNS("datiFornituraCliente", "datiCliente"));
				
				System.out.println("STAMPO 1: "+vn.toElement(VTDNav.FIRST_CHILD));
									
				System.out.println("STAMPO 2: "+vn.toElement(VTDNav.FIRST_CHILD, "datiFornituraCliente"));
				System.out.println("STAMPO 3: "+vn.toElementNS(VTDNav.FIRST_CHILD,null, "datiFornituraCliente"));
				System.out.println("STAMPO 1.1: "+vn.toElement(VTDNav.FIRST_CHILD));


				System.out.println("vn.getAttrCount(): "+vn.getAttrCount());
				System.out.println("vn.datiFornituraCliente: "+vn.getAttrVal("datiFornituraCliente"));

				if (vn.matchElement("UTENZEDIST_Comunicazione")){ // match blix
				}
				else
				{
					System.out.println("Non e' presente UTENZEDIST_Comunicazione");
				}


				//toElementNS is the namespace aware version of toElement which navigates the cursor
				if (vn.toElement(VTDNav.FIRST_CHILD)){
					int i= vn.getText(); // get the VTD record index

					System.out.println("vn.getText(): "+vn.getText());
					System.out.println("vn.toString(i): "+vn.toString(i));

					if (i!=-1){
						// convert i into string before printing, 
						// toNormalizedString(i) and toRawString(i) are two other options
						System.out.println("the text node value at "+i+" ==> "+vn.toString(i));
					}
				}
			} catch (NavException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	*/
}
