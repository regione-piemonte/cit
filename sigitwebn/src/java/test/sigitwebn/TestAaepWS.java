package test.sigitwebn;

import java.net.URL;
import java.util.List;

/*
 *  TestAvvioWisp
 *  
 *  La classe e' un esempio di invocazione dei servizi del Motore dei Pagamenti
 *  per generare l'URL di redirezione verso il WISP (Wizard Interattivo di Scelta del PSP) di AgID
 * 
 */


import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import it.csi.aaep.aaeporch.business.OrchestratoreImplService;
import it.csi.aaep.aaeporch.business.Regione;
//import it.csi.sigit.sigitext.stubs.CodiceDescrizione;
//import it.csi.sigit.sigitext.stubs.SigitextSigitextService;

//import javax.xml.soap.SOAPException;

public class TestAaepWS {

	
	public static void main(String[] args){
		
		
		try {
			
			it.csi.aaep.aaeporch.business.OrchestratoreImplService serviceAaep = new OrchestratoreImplService(new URL("http://tst-applogic.reteunitaria.piemonte.it/aaeporch/OrchestratoreService?wsdl"));
			//serviceAaep.
			
			
			JaxWsProxyFactoryBean fact = new JaxWsProxyFactoryBean();
			fact.setServiceClass(OrchestratoreImplService.class);
			String mdpcoreAddress = "http://tst-applogic.reteunitaria.piemonte.it/aaeporch/OrchestratoreService?wsdl";
			fact.setAddress( mdpcoreAddress);
			fact.getInInterceptors().add(new LoggingInInterceptor());
			fact.getOutInterceptors().add(new LoggingOutInterceptor());
			
			OrchestratoreImplService clientcxfmdp = (OrchestratoreImplService)fact.create();

			System.out.println("Stampo clientcxfmdp: "+clientcxfmdp);

			it.csi.aaep.aaeporch.business.Utente utente = new it.csi.aaep.aaeporch.business.Utente();
        	utente.setCodiceFiscaleUtente("TDRGPP76L17L219C");
			List<Regione> codDesc = clientcxfmdp.getOrchestratoreImplPort().getElencoRegioni(utente);
			
			System.out.println("Stampo codDesc: "+codDesc);
			
			
			System.out.println("url: " + clientcxfmdp.getWSDLDocumentLocation());
						
			// Richiamo WS x correttezza chiamata
			//CalcolaMacServizi.getMacRiceviRT()
			
			
		}catch (Exception e){
			System.err.println(e.toString());
			e.printStackTrace();
		}
		
		
	}
}
