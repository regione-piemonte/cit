package it.csi.sigit.sigitext.business.be.manager;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ImportFileSuper;
import it.doqui.index.ecmengine.client.webservices.engine.EcmEngineWebServiceDelegate;
import it.doqui.index.ecmengine.client.webservices.engine.EcmEngineWebServiceDelegateServiceLocator;

import javax.activation.DataHandler;
import javax.xml.rpc.ServiceException;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class IndexServiceImp {

	EcmEngineWebServiceDelegate ecmengineDelegate;


	public EcmEngineWebServiceDelegate getEcmengineDelegate() {
		return ecmengineDelegate;
	}



	public void setEcmengineDelegate(EcmEngineWebServiceDelegate ecmengineDelegate) {
		this.ecmengineDelegate = ecmengineDelegate;
	}



	public IndexServiceImp(String url)
	{
		EcmEngineWebServiceDelegateServiceLocator ecmengineLocator =
				new EcmEngineWebServiceDelegateServiceLocator();

		try {


			ecmengineDelegate = ecmengineLocator.getEcmEngineManagement(new URL(url));
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

