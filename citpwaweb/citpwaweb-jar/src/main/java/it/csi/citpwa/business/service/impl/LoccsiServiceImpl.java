/*
 * ******************************************************************************
 *  SPDX-License-Identifier: EUPL-1.2
 *  Copyright Regione Piemonte - 2021
 * *****************************************************************************
 */
package it.csi.citpwa.business.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.csi.citpwa.business.service.ILoccsiService;
import it.csi.citpwa.model.loccsi.LoccsiModel;
import it.csi.citpwa.util.Constants;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.xml.rpc.ServiceException;

@Service
public class LoccsiServiceImpl implements ILoccsiService {

	@Value("${LOCCSI_API_URL}")
	private String loccsiApiUrl;

	@Value("${LOCCSI_AUTH_URL}")
	private String oauthUrl;

	@Value("${LOCCSI_KEY}")
	private String key;

	@Value("${LOCCSI_SECRET}")
	private String secret;

	private String tokenOauthLoccsi;

	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

	@Override
	public LoccsiModel[] getLOCCSICoordinates(String indirizzo) throws ServiceException, JSONException, JsonProcessingException {
		log.info("[ServiziMgr::getLOCCSICoordinates] Ricerco indirizzi LOCCSI");
		ObjectMapper objectMapper = new ObjectMapper();
				if (this.tokenOauthLoccsi == null)
					this.tokenOauthLoccsi = getTokenLoccsi();

		StringBuilder apiUrlString = new StringBuilder(loccsiApiUrl);
		apiUrlString.append("?q= " + indirizzo);

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + tokenOauthLoccsi);
		headers.set("charset", "UTF-8");
		HttpEntity<String> entity = new HttpEntity<>("", headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(apiUrlString.toString(), HttpMethod.GET, entity, String.class);
			String jsonResponseString = response.getBody();
			JSONArray jsonResponse = new JSONArray(jsonResponseString);
			return objectMapper.readValue(jsonResponse.toString(), LoccsiModel[].class);
		} catch (HttpClientErrorException e) {
			if (e.getStatusCode() == HttpStatus.UNAUTHORIZED || e.getStatusCode() == HttpStatus.FORBIDDEN) {
				this.tokenOauthLoccsi = getTokenLoccsi();
				headers.set("Authorization", "Bearer " + tokenOauthLoccsi);
				headers.set("charset", "UTF-8");
				entity = new HttpEntity<>("", headers);
				ResponseEntity<String> response = restTemplate.exchange(apiUrlString.toString(), HttpMethod.GET, entity, String.class);
				String jsonResponseString = response.getBody();
				JSONArray jsonResponse = new JSONArray(jsonResponseString);
				return objectMapper.readValue(jsonResponse.toString(), LoccsiModel[].class);
			}
			throw new ServiceException();
		} catch (JSONException | JsonProcessingException e) {
			log.error("Errore LOCCSI getLOCCSICoordinates", e);
			throw e;
		} finally {
			log.info("[ServiziMgr::getLOCCSICoordinates] END");
		}

	}

	private String getTokenLoccsi() throws ServiceException, JSONException {
		log.info("[ServiziMgr::getLOCCSICoordinates] get token LOCCSI");
		try {
			String oauthURL = this.oauthUrl;
			String consumerKey = this.key;
			String consumerSecret = this.secret;

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();

			headers.set("Content-Type", "application/x-www-form-urlencoded");
			headers.set("charset", "UTF-8");

			log.info(oauthURL);
			log.info(consumerSecret);
			log.info(consumerKey);
			log.info(headers);

			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			map.add("client_id", consumerKey);
			map.add("client_secret", consumerSecret);
			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
			ResponseEntity<String> response = restTemplate.exchange(oauthURL + "?grant_type=" + Constants.CLIENT_CREDENTIALS, HttpMethod.POST, entity, String.class);

			int responseCode = response.getStatusCode().value();

			if (responseCode != 200)
				throw new ServiceException();

			String jsonResponseString = response.getBody();

			JSONObject json = new JSONObject(jsonResponseString);

			return json.getString("access_token");
		}catch (Exception e){
			log.error("errore recupero token loccsi: ",e);
			throw e;
		}
	}
}
