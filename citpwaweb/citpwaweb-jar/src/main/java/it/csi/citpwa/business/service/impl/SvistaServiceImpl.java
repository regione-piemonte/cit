package it.csi.citpwa.business.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.csi.citpwa.business.service.ISvistaService;
import it.csi.citpwa.business.ws.service.svista.client.Comune;
import it.csi.citpwa.business.ws.service.svista.client.LimammEnteServiceLocator;
import it.csi.citpwa.business.ws.service.svista.client.LimammEntePortType;
import it.csi.citpwa.business.ws.service.svista.client.Provincia;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.ComuneEstesoModel;
import it.csi.citpwa.util.AppServletContextListener;
import it.csi.citpwa.util.Constants;
import it.csi.wso2.apiman.oauth2.helper.GenericWrapperFactoryBean;
import it.csi.wso2.apiman.oauth2.helper.OauthHelper;
import it.csi.wso2.apiman.oauth2.helper.TokenRetryManager;
import it.csi.wso2.apiman.oauth2.helper.WsProvider;
import it.csi.wso2.apiman.oauth2.helper.extra.axis1.Axis1Impl;

@Service
public class SvistaServiceImpl implements ISvistaService {

	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

	//SIGIT-SVISTA
	@Value("${SVISTA_WSDL_URL}")
	private String svistaWsdlUrl;

	@Value("${API_GWECOSIS_TOKEN_URL}")
	private String apiGwecosisTokenUrl;

	@Value("${API_GWECOSIS_TOKEN_CONSUMERKEY}")
	private String apiGwecosisTokenConsumerkey;

	@Value("${API_GWECOSIS_TOKEN_CONSUMERSECRET}")
	private String apiGwecosisTokenConsumerkeysecret;

	private static OauthHelper oauthHelper = null;
	
	@SuppressWarnings("unchecked")
	public List<ComuneEstesoModel> getComuniEstesiDaSessionContext(){
		log.info("START [SvistaServiceImpl::getComuniEstesiDaSessionContext]");
		List<ComuneEstesoModel> comuniEstesi = null;
		try {
			if (AppServletContextListener.getServletContext().getAttribute("comuniEstesi") == null){
				comuniEstesi = cercaTuttiIComuniEstesi();
			}
			else comuniEstesi = (List<ComuneEstesoModel>) AppServletContextListener.getServletContext().getAttribute("comuniEstesi");  
		} catch (Exception e) {
		}
		return comuniEstesi;
	}
	
	public List<ComuneEstesoModel> cercaTuttiIComuniEstesi() {
		
		log.info("START [SvistaServiceImpl::cercaTuttiIComuniEstesi]");
		List<ComuneEstesoModel> tuttiIComuniEstesi = new ArrayList<>();
		List<Comune> tuttiIComuni = null;
		List<Provincia> tutteLeProvince = null;
		try {
			log.info("cercaTuttiIComuni - START");
			tuttiIComuni = Arrays.asList(getSvista().cercaTuttiIComuni());
			log.info("cercaTuttiIComuni - END");
			log.info("cercaTutteLeProvince - START");
			tutteLeProvince = Arrays.asList(getSvista().cercaTutteLeProvince());		
			log.info("cercaTutteLeProvince - END");
			Map<Long, Provincia> mapProvince = tutteLeProvince.stream()
					.collect(Collectors.toMap(Provincia::getId, Function.identity()));
			tuttiIComuniEstesi = tuttiIComuni.stream()
					.map(comune -> new ComuneEstesoModel(comune.getId(), comune.getCap(), comune.getCodIstat(),
							comune.getNome(), comune.getIdProvincia(), 
							mapProvince.get(comune.getIdProvincia()).getSigla(),
							mapProvince.get(comune.getIdProvincia()).getNome()))
					.collect(Collectors.toList());
		} catch (Exception e) {
			 log.error( "Errore chiamata servizio esterno: ",e);
			 tuttiIComuniEstesi = null;
		}
		log.info("END [SvistaServiceImpl::cercaTuttiIComuniEstesi]");
		return tuttiIComuniEstesi;
	}

	private LimammEntePortType getSvista() throws SvistaException {
		int timeout = Constants.APIMAN_TIMEOUT;

		LimammEntePortType limAmmEnte = null;

		try {
			LimammEnteServiceLocator serviceLoc = new LimammEnteServiceLocator();
			serviceLoc.setlimammEnteEndpointAddress(svistaWsdlUrl);
			LimammEntePortType port = serviceLoc.getlimammEnte();

			TokenRetryManager trm = new TokenRetryManager();
			trm.setOauthHelper(getOauthHelper(apiGwecosisTokenUrl, apiGwecosisTokenConsumerkey, apiGwecosisTokenConsumerkeysecret, timeout));
			
			WsProvider wsp = new Axis1Impl();
			trm.setWsProvider(wsp);
			GenericWrapperFactoryBean gwfb = new GenericWrapperFactoryBean();
			gwfb.setEndPoint(svistaWsdlUrl);
			gwfb.setWrappedClass(LimammEntePortType.class.getCanonicalName());
			gwfb.setTokenRetryManager(trm);
			gwfb.setPort(port);
			limAmmEnte = (LimammEntePortType) gwfb.create();
		
		} catch (javax.xml.rpc.ServiceException | ClassNotFoundException e) {
			log.error("Errore SvistaServiceImpl::getSvista: ", e);
			throw new SvistaException();
		}
		
		log.info("END [SvistaServiceImpl::getSvista]");
		return limAmmEnte;
	}

	private static OauthHelper getOauthHelper(String oauthURL, String consumerKey, String consumerSecret, int timeout) {
		log.info("START SvistaServiceImpl::getOauthHelper");
		try {
			if (oauthHelper == null) {
				oauthHelper = new OauthHelper(oauthURL, consumerKey, consumerSecret, timeout);
				System.out.println("oauthHelper: " + oauthHelper.getToken());
			}
		} catch (Exception e) {
			log.error("Errore in OauthHelper: " + e);
		}
		log.info("END SvistaServiceImpl::getOauthHelper");
		return oauthHelper;
	}

}
