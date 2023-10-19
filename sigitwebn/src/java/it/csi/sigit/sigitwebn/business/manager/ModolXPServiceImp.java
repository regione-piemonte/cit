/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager;

//import it.csi.modolxp.modolxppdfgensrv.business.session.facade.ModolPdfGeneratorSrvFacade;
//import it.csi.modolxp.modolxpsrv.business.session.facade.ModolSrvFacade;
//import it.csi.modolxp.modolxpsrv.client.ModolxpsrvServiceClient;
//import it.csi.modolxp.modolxpsrv.dto.publish.ModolxpsrvServiceDto;
//import it.csi.modolxp.modolxpsrv.exception.ModolsrvException;
import it.csi.sigit.sigitwebn.util.Constants;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

public class ModolXPServiceImp {

	protected static final Logger log = Logger
	.getLogger(Constants.APPLICATION_CODE + ".ModolXPServiceImp==>");

	/*
	ModolSrvFacade modolxpsrv;
	
	public ModolSrvFacade getModolXPServiceImp() {
		return modolxpsrv;
	}

	public void setModolXPServiceImp(ModolSrvFacade modolxpsrv) {
		this.modolxpsrv = modolxpsrv;
	}

	public ModolXPServiceImp(String url, String context, String port)
	{
		
		if (log.isDebugEnabled())
		{
			log.debug("ModolXPServiceImp - Stampo param ricevuto [url]: "+url);
			log.debug("ModolXPServiceImp - Stampo param ricevuto [context]: "+context);
			log.debug("ModolXPServiceImp - Stampo param ricevuto [port]: "+port);
		}
		
		ModolxpsrvServiceDto modolxpsrvService = new ModolxpsrvServiceDto();
        modolxpsrvService.setServer(url);
        modolxpsrvService.setContext(context);
        modolxpsrvService.setPort(new Integer(port));
//        modolxpsrvService.setServer("tst-applogic.reteunitaria.piemonte.it");
//        modolxpsrvService.setContext("/modolxp/modolxpsrv/");
//        modolxpsrvService.setPort(new Integer(80));
        
        try {
			modolxpsrv = ModolxpsrvServiceClient.getModolxpsrvService(modolxpsrvService);

			if (log.isDebugEnabled())
				log.debug("modolxpsrv - creazione: "+modolxpsrv);
			
		} catch (ModolsrvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
	}
	*/
}
