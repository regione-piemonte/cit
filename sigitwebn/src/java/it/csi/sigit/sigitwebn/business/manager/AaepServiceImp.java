/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.Logger;

import it.csi.aaep.aaeporch.business.OrchestratoreIntf;
import it.csi.aaep.aaeporch.business.TAVTException_Exception;
import it.csi.aaep.aaeporch.business.UserException_Exception;
import it.csi.sigit.sigitwebn.util.Constants;

public class AaepServiceImp {

	OrchestratoreIntf ecmengineDelegate;
	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business.manager");
	
	public OrchestratoreIntf getEcmengineDelegate() {
		return ecmengineDelegate;
	}



	public void setEcmengineDelegate(OrchestratoreIntf ecmengineDelegate) {
		this.ecmengineDelegate = ecmengineDelegate;
	}



	public AaepServiceImp(String url)
	{
		
		try {
			log.info("### PRIMA DI ISTANZIARE AAEP");
			
			
			JaxWsProxyFactoryBean fact = new JaxWsProxyFactoryBean();
			fact.setServiceClass(OrchestratoreIntf.class);
			String mdpcoreAddress = url;
			fact.setAddress(mdpcoreAddress);
			fact.getInInterceptors().add(new LoggingInInterceptor());
			fact.getOutInterceptors().add(new LoggingOutInterceptor());

			ecmengineDelegate = (OrchestratoreIntf) fact.create();
			log.info("### DOPO DI ISTANZIARE AAEP");

			
			//log.info("Stampo le regioni: "+ecmengineDelegate.getElencoRegioni(null));
			
			//ecmengineDelegate = new OrchestratoreImplService(new URL(url));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JaxWsProxyFactoryBean fact = new JaxWsProxyFactoryBean();
		fact.setServiceClass(OrchestratoreIntf.class);
		String mdpcoreAddress = "http://tst-applogic.reteunitaria.piemonte.it/aaeporch/OrchestratoreService?wsdl";
		fact.setAddress(mdpcoreAddress);
		fact.getInInterceptors().add(new LoggingInInterceptor());
		fact.getOutInterceptors().add(new LoggingOutInterceptor());

		OrchestratoreIntf ecmengineDelegateMain = (OrchestratoreIntf) fact.create();
		
		
		try {
			System.out.println("Stampo le regioni: "+ecmengineDelegateMain.getElencoRegioni(null));
		} catch (UserException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TAVTException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
