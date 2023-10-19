/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.be.manager;

import it.csi.sigit.sigitext.business.util.Constants;
import it.doqui.index.ecmengine.client.mtom.EcmEngineMtomDelegateImpl;
import org.apache.log4j.Logger;

public class MtomServiceImp {

	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business.manager");

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
