/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.manager;

import it.csi.sigit.sigitbatchn.business.util.Constants;
import it.doqui.index.ecmengine.client.webservices.engine.EcmEngineWebServiceDelegate;
import it.doqui.index.ecmengine.client.webservices.engine.EcmEngineWebServiceDelegateServiceLocator;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

public class IndexServiceImp {

	EcmEngineWebServiceDelegate ecmengineDelegate;
	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business.manager");
	
	
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
			log.error("ERRORE: ", e);
			//e.printStackTrace();
		}
		catch (ServiceException e) {
			// TODO Auto-generated catch block
			log.error("ERRORE: ", e);
			//e.printStackTrace();
		}
	}
	
}
