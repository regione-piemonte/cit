/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.Logger;

import it.csi.sigit.sigitwebn.util.Constants;
import it.doqui.index.ecmengine.client.mtom.EcmEngineMtomDelegate;
import it.doqui.index.ecmengine.client.mtom.EcmEngineMtomDelegateImpl;


public class MtomServiceImp {

	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business.manager");


	/*
	EcmEngineMtomDelegate ecmengineDelegate;

	public EcmEngineMtomDelegate getEcmEngineMtomDelegate() {
		return ecmengineDelegate;
	}



	public void setEcmEngineMtomDelegate(EcmEngineMtomDelegate ecmengineDelegate) {
		this.ecmengineDelegate = ecmengineDelegate;
	}



	public MtomServiceImp(String url)
	{
		
		try {

			
			log.info("### PRIMA DI AVER ISTANZIATO MTOM");
			JaxWsProxyFactoryBean fact = new JaxWsProxyFactoryBean();
			fact.setServiceClass(EcmEngineMtomDelegate.class);
			String mdpcoreAddress = url;
			fact.setAddress(mdpcoreAddress);
			fact.getInInterceptors().add(new LoggingInInterceptor());
			fact.getOutInterceptors().add(new LoggingOutInterceptor());

			ecmengineDelegate = (EcmEngineMtomDelegate) fact.create();
			
			
			log.info("### DOPO AVER ISTANZIATO MTOM");
			log.info("### STAMPO: "+(ecmengineDelegate!=null));
	
			
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	EcmEngineMtomDelegateImpl ecmengineDelegateImpl;

	public EcmEngineMtomDelegateImpl getEcmEngineMtomDelegateImpl() {
		return ecmengineDelegateImpl;
	}



	public void setEcmEngineMtomDelegateImpl(EcmEngineMtomDelegateImpl ecmengineDelegateImpl) {
		this.ecmengineDelegateImpl = ecmengineDelegateImpl;
	}



	public MtomServiceImp(String url)
	{
		
		try {

			
			
			
			log.info("### PRIMA DI AVER ISTANZIATO MTOM");

			ecmengineDelegateImpl = new EcmEngineMtomDelegateImpl(url);
			
			log.info("### DOPO AVER ISTANZIATO MTOM");
			log.info("### STAMPO: "+(ecmengineDelegateImpl!=null));
	
			
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
