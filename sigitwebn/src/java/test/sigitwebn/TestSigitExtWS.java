package test.sigitwebn;

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

//import it.csi.sigit.sigitext.stubs.CodiceDescrizione;
//import it.csi.sigit.sigitext.stubs.SigitextSigitextService;
//import it.csi.sigit.sigitext.stubs.SigitextSigitextServiceLocator;
//import it.csi.sigit.sigitext.stubs.SigitextSigitextSoapBindingStub;
import it.csi.sigit.sigitwebn.util.GenericUtil;

//import javax.xml.soap.SOAPException;

public class TestSigitExtWS {

	
	public static void main(String[] args){
		
		
		//final String appId="TEST_TEST";
		final String appId="SICEE_NODO";
		
		try {
			/*
            it.csi.sigit.sigitext.stubs.SigitextSigitextServiceLocator prova =  new it.csi.sigit.sigitext.stubs.SigitextSigitextServiceLocator();
			
            System.out.println("getsigitextSigitextAddress: "+prova.getsigitextSigitextAddress());
            
            
            prova.setsigitextSigitextEndpointAddress("http://www.sistemapiemonte.it/sigitextApplSigitextWsfad/services/sigitextSigitext");

            it.csi.sigit.sigitext.stubs.SigitextSigitextSoapBindingStub binding = (it.csi.sigit.sigitext.stubs.SigitextSigitextSoapBindingStub) prova.getsigitextSigitext();
            
            System.out.println("getsigitextSigitextAddress: "+prova.getsigitextSigitextAddress());
	        
	        it.csi.sigit.sigitext.stubs.CodiceDescrizione[] value = null;
            value = binding.getTipo();
			
            System.out.println("Stampa value: "+value);

            GenericUtil.stampa(value, false, 3);
			*/
			
			
			
		}catch (Exception e){
			System.err.println(e.toString());
			e.printStackTrace();
		}
		
		
	}
}
