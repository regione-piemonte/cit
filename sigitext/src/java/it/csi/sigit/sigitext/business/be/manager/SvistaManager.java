/**
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 */
/**
 *
 */
package it.csi.sigit.sigitext.business.be.manager;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import it.csi.csi.wrapper.CSIException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.ws.service.svista.client.Comune;
import it.csi.sigit.sigitext.business.ws.service.svista.client.LimammEnteServiceLocator;
import it.csi.sigit.sigitext.business.ws.service.svista.client.LimammEnte_PortType;
import it.csi.sigit.sigitext.business.ws.service.svista.client.Provincia;
import it.csi.sigit.sigitext.dto.ComuneEstesoModel;
import it.csi.wso2.apiman.oauth2.helper.GenericWrapperFactoryBean;
import it.csi.wso2.apiman.oauth2.helper.OauthHelper;
import it.csi.wso2.apiman.oauth2.helper.TokenRetryManager;
import it.csi.wso2.apiman.oauth2.helper.WsProvider;
import it.csi.wso2.apiman.oauth2.helper.extra.axis1.Axis1Impl;


public class SvistaManager implements Serializable {

	private static final long serialVersionUID = -5261261685978312776L;
	
	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE + ".SvistaManager==>");

	private static final String PROPERTIES_RESOURCE = "/META-INF/sigitext.properties";

	public SvistaManager() {
	}

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
			logger.error("Errore SVISTA getSvita", e);
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
		
		logger.debug("oauthHelper: "+oauthHelper.getToken());
		
		return oauthHelper;
	}

	protected Properties getProperties() {
		logger.debug("[ServiceManager::getProperties] BEGIN");
		InputStream is = getClass().getResourceAsStream(PROPERTIES_RESOURCE);
		if (is != null) {
			try {
				Properties properties = new Properties();
				properties.load(is);
				return properties;
			} catch (Exception e) {
				logger.error("[ServiceManager::getProperties] errore nella parsificazione della configurazione delle PROPERTIES:" + e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione delle PROPERTIES");
			}
		} else {
			logger.error("[ServiceManager::getProperties] configurazione delle PROPERTIES non trovata");
		}
		throw new IllegalArgumentException("configurazione delle PROPERTIES non trovata");
	}

	public List<ComuneEstesoModel> getComuniEstesi() throws CSIException {

		logger.info("START [SvistaManager::getComuniEstesi]");
		List<ComuneEstesoModel> comuniEstesi = new ArrayList<>();
		List<Comune> comuni = null;
		List<Provincia> province = null;
		try {
			comuni = Arrays.asList(getSvista().cercaTuttiIComuni());
			province = Arrays.asList(getSvista().cercaTutteLeProvince());		

			Map<Long, Provincia> mapProvince = new HashMap<Long, Provincia>();
			for (Provincia provincia : province) {
				mapProvince.put(provincia.getId(), provincia);
			}
			for (Comune comune : comuni) {
				comuniEstesi.add(new ComuneEstesoModel(comune.getId(), comune.getCap(), comune.getCodIstat(),
							comune.getNome(), comune.getIdProvincia(), 
							mapProvince.get(comune.getIdProvincia()).getSigla(),
							mapProvince.get(comune.getIdProvincia()).getNome()));
			}
			
		} catch (Exception e) {
			logger.error( "Errore chiamata servizio esterno: ", e);
			throw new CSIException("Errore durante il recupero della lista dei comuni", e);
		}
		logger.info("END [SvistaManager::getComuniEstesi]");
		
		return comuniEstesi;
	}

}
