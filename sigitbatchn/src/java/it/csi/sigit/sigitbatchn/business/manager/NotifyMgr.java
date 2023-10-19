package it.csi.sigit.sigitbatchn.business.manager;

import it.csi.sigit.sigitbatchn.business.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

public class NotifyMgr {
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");
	private final String PROPERTIES_RESOURCE = "/META-INF/sigitbatchn.properties";

	protected Properties getProperties() {
		log.debug("[NotifyMgr::getProperties] BEGIN");
		InputStream is = getClass().getResourceAsStream(PROPERTIES_RESOURCE);

		if (is != null) {
			try {
				Properties properties = new Properties();
				properties.load(is);

				return properties;
			} catch (Exception e) {
				log.error("[NotifyMgr::getProperties] errore nella parsificazione della configurazione delle PROPERTIES:" + e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione delle PROPERTIES");
			}
		} else {
			log.error("[NotifyMgr::getProperties] configurazione delle PROPERTIES non trovata");
		}
		throw new IllegalArgumentException("configurazione delle PROPERTIES non trovata");
	}

	public String sendMessages(String messages) throws Exception {
		log.debug("[NotifyMgr::sendMessages] BEGIN");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getProperties().getProperty(Constants.NOTIFY_MB_URL) + "/topics/messages");
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add("x-authentication", getProperties().getProperty(Constants.NOTIFY_TOKEN));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(messages, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			return response.getStatusCode().value()+" "+response.getStatusCode().getReasonPhrase()+": "+response.getBody();
		} catch (Exception e) {
			log.error("[NotifyMgr::getProperties] errore nell'inserimento dei messaggi:" + e, e);
			throw new IllegalArgumentException("errore nell'inserimento dei messaggi");
		}
	}

	/*
	public String getStatus(String bulkUUID) throws Exception {
		log.debug("[NotifyMgr::getStatus] BEGIN");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getProperties().getProperty(Constants.NOTIFY_STATUS_URL) + "/status/messages").queryParam("bulk_id", bulkUUID);
			String urlTemplate = builder.build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add("x-authentication", getProperties().getProperty(Constants.NOTIFY_TOKEN));
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			log.debug("response: "+response);
			log.debug("response: "+response.getHeaders());
			return response.getBody();
		} catch (Exception e) {
			log.error("[NotifyMgr::getStatus] errore nel recupero dello stato dei messaggi:" + e, e);
			throw new IllegalArgumentException("errore nel recupero dello stato dei messaggi");
		}
	}
	*/
}
