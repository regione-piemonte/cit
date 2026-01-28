/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import it.csi.citpwa.model.*;
import it.csi.citpwa.model.enums.TipoStatoDistributoreEnum;
import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.model.sigitext.geojson.FeatureCollection;

import it.csi.citpwa.util.NumberUtil;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.csi.citpwa.business.service.ICitService;
import it.csi.citpwa.business.service.ValidationService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.xsd.libretto.MOD;
import it.csi.citpwa.util.Constants;
import it.csi.sigit.sigitext.ws.service.client.Impianto;
import it.csi.sigit.sigitext.ws.service.client.Libretto;

@Service
public class CitServiceImp implements ICitService {

	@Value("${CIT_URL}")
	private String citUrl;

	private final ValidationService validationService;
	
	@Autowired
	public CitServiceImp(ValidationService validationService){
		this.validationService = validationService;
	}

	private static final String CODICE_FISCALE_REQUEST_PARAM = "codice_fiscale";
	private static final String ID_PERSONA_GIURIDICA_REQUEST_PARAM = "id_persona_giuridica";
	private static final String ID_PERSONA_REQUEST_PARAM = "id_persona";
	private static final String ID_VERIFICA_REQUEST_PARAM = "id_verifica";
	private static final String CODICE_IMPIANTO_REQUEST_PARAM = "codice_impianto";
	private static final String CONSOLIDATO_REQUEST_PARAM = "consolidato";

	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

	@Override
	public Ruoli getRuoliUtente(String cf, String nome, String cognome) throws SvistaException {
		log.info(Constants.CITSERVICE_LOG + "getRuoliUtente - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/user/ruoli").queryParam("cf", cf).queryParam("nome", nome).queryParam("cognome", cognome).build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			if (responseCode != 200) {
				Errore error = objectMapper.readValue(response.getBody(), Errore.class);
				log.debug(error);
			}
			return objectMapper.readValue(response.getBody(), Ruoli.class);
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getRuoli", e);
			throw new SvistaException("Errore durante il recupero dei ruoli", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getRuoliUtente - end");
		}
	}

	@Override
	public String getDisponibilitaServizio(UtenteLoggato utenteLoggato) throws SvistaException {
		log.info(Constants.CITSERVICE_LOG + "getDisponibilitaServizio - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/user/disponibilitaservizio");
			builder.queryParam("servizio", "CIT_PWA");
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
			HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(utenteLoggato), headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			int responseCode = response.getStatusCode().value();
			if (responseCode != 200) {
				Errore error = objectMapper.readValue(response.getBody(), Errore.class);
				log.debug(error);
			}
			return Constants.OK;
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getDisponibilitaServizio", e);
			throw new SvistaException("Errore durante il controllo della disponibilita servizio.", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getDisponibilitaServizio - end");
		}
	}

	@Override
	public String setAccesso(UtenteLoggato utenteLoggato) throws SvistaException {
		log.info(Constants.CITSERVICE_LOG + "setAccesso - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/user/accesso").build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
			HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(utenteLoggato), headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			int responseCode = response.getStatusCode().value();
			if (responseCode != 200) {
				Errore error = objectMapper.readValue(response.getBody(), Errore.class);
				log.debug(error);
			}
			return Constants.OK;
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_SETACCESSO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_SALVATAGGIO_ACCESSO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setAccesso - end");
		}
	}

	@Override
	public CodiceDescrizione[] getStatoImpianto() throws SvistaException {
		log.info(Constants.CITSERVICE_LOG + "getStatoImpianto - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/stato").build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			if (responseCode != 200) {
				Errore error = objectMapper.readValue(response.getBody(), Errore.class);
				log.debug(error);
			}
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_SETACCESSO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_SALVATAGGIO_ACCESSO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getStatoImpianto - end");
		}
	}

	@Override
	public Impianto[] getImpiantoByFiltroJWT(ImpiantoFiltro impiantoFiltro, String token) throws SvistaException {
		log.info(Constants.CITSERVICE_LOG + "getImpiantoByFiltro - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/filtro");
			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCf3Responsabile()))
				builder.queryParam("cf3-resp", impiantoFiltro.getCf3Responsabile());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCfImpresa()))
				builder.queryParam("cf-impresa", impiantoFiltro.getCfImpresa());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCfProprietario()))
				builder.queryParam("cf-proprietario", impiantoFiltro.getCfProprietario());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCfResponsabile()))
				builder.queryParam("cf-responsabile", impiantoFiltro.getCfResponsabile());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCivico()))
				builder.queryParam("civico", impiantoFiltro.getCivico());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCodiceImpianto()))
				builder.queryParam(Constants.CITSERVICE_PARAM_CODICE_IMPIANTO, impiantoFiltro.getCodiceImpianto());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getDescComune()))
				builder.queryParam("desc-comune", impiantoFiltro.getDescComune());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getFkStato()))
				builder.queryParam("fk-stato", impiantoFiltro.getFkStato());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getFlagVisuProprietario()))
				builder.queryParam("flag-visu-proprietario", impiantoFiltro.getFlagVisuProprietario());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getIdComune()))
				builder.queryParam("id-comune", impiantoFiltro.getIdComune());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getIndirizzo()))
				builder.queryParam("indirizzo", impiantoFiltro.getIndirizzo());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getIstatComune()))
				builder.queryParam("istat-comune", impiantoFiltro.getIstatComune());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getNumeroRea()))
				builder.queryParam("numero-rea", impiantoFiltro.getNumeroRea());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getPdr()))
				builder.queryParam("pdr", impiantoFiltro.getPdr());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getPod()))
				builder.queryParam("pod", impiantoFiltro.getPod());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getSiglaProvincia()))
				builder.queryParam("sigla-provincia", impiantoFiltro.getSiglaProvincia());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getSiglaRea()))
				builder.queryParam("sigla-rea", impiantoFiltro.getSiglaRea());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getX()))
				builder.queryParam("x", impiantoFiltro.getX());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getY()))
				builder.queryParam("y", impiantoFiltro.getY());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getDistanza()))
				builder.queryParam("distanza", impiantoFiltro.getDistanza());

			builder.queryParam(Constants.CITSERVICE_PARAM_TOKEN_JWT, token);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), Impianto[].class);
		} catch (HttpClientErrorException e) {
			int responseCode = e.getStatusCode().value();
			if (responseCode == 404) {
				throw new NotFoundException();
			} else {
				log.error(Constants.CITSERVICE_ERRORE_RECUPERO_IMPIANTI, e);
				throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_IMPIANTI);
			}
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_IMPIANTI, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_IMPIANTI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getImpiantoByFiltro - end");
		}
	}

	@Override
	public FeatureCollection getGeoJsonImpiantoByFiltroJWT(ImpiantoFiltro impiantoFiltro, String token) throws SvistaException {
		log.info(Constants.CITSERVICE_LOG + "getGeoJsonImpiantoByFiltroJWT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/geo/filtro");
			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCf3Responsabile()))
				builder.queryParam("cf3-resp", impiantoFiltro.getCf3Responsabile());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCfImpresa()))
				builder.queryParam("cf-impresa", impiantoFiltro.getCfImpresa());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCfProprietario()))
				builder.queryParam("cf-proprietario", impiantoFiltro.getCfProprietario());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCfResponsabile()))
				builder.queryParam("cf-responsabile", impiantoFiltro.getCfResponsabile());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCivico()))
				builder.queryParam("civico", impiantoFiltro.getCivico());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCodiceImpianto()))
				builder.queryParam(Constants.CITSERVICE_PARAM_CODICE_IMPIANTO, impiantoFiltro.getCodiceImpianto());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getDescComune()))
				builder.queryParam("desc-comune", impiantoFiltro.getDescComune());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getFkStato()))
				builder.queryParam("fk-stato", impiantoFiltro.getFkStato());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getFlagVisuProprietario()))
				builder.queryParam("flag-visu-proprietario", impiantoFiltro.getFlagVisuProprietario());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getIdComune()))
				builder.queryParam("id-comune", impiantoFiltro.getIdComune());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getIndirizzo()))
				builder.queryParam("indirizzo", impiantoFiltro.getIndirizzo());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getIstatComune()))
				builder.queryParam("istat-comune", impiantoFiltro.getIstatComune());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getNumeroRea()))
				builder.queryParam("numero-rea", impiantoFiltro.getNumeroRea());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getPdr()))
				builder.queryParam("pdr", impiantoFiltro.getPdr());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getPod()))
				builder.queryParam("pod", impiantoFiltro.getPod());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getSiglaProvincia()))
				builder.queryParam("sigla-provincia", impiantoFiltro.getSiglaProvincia());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getSiglaRea()))
				builder.queryParam("sigla-rea", impiantoFiltro.getSiglaRea());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getX()))
				builder.queryParam("x", impiantoFiltro.getX());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getY()))
				builder.queryParam("y", impiantoFiltro.getY());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getDistanza()))
				builder.queryParam("distanza", impiantoFiltro.getDistanza());

			builder.queryParam(Constants.CITSERVICE_PARAM_TOKEN_JWT, token);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), FeatureCollection.class);
		} catch (HttpClientErrorException e) {
			int responseCode = e.getStatusCode().value();
			if (responseCode == 404) {
				throw new NotFoundException();
			} else {
				log.error(Constants.CITSERVICE_ERRORE_RECUPERO_IMPIANTI, e);
				throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_IMPIANTI, e);
			}
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_IMPIANTI, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_IMPIANTI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getGeoJsonImpiantoByFiltroJWT - end");
		}
	}

	@Override
	public FeatureCollection getGeoJsonImpiantoDuplicatiByFiltroResponsabileJWT(ImpiantoFiltro impiantoFiltro, String token) throws SvistaException {
		log.info(Constants.CITSERVICE_LOG + "getGeoJsonImpiantoByFiltroJWT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/geo/filtro/duplicatiresponsabile");
			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCf3Responsabile()))
				builder.queryParam("cf3-resp", impiantoFiltro.getCf3Responsabile());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCfImpresa()))
				builder.queryParam("cf-impresa", impiantoFiltro.getCfImpresa());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCfProprietario()))
				builder.queryParam("cf-proprietario", impiantoFiltro.getCfProprietario());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCfResponsabile()))
				builder.queryParam("cf-responsabile", impiantoFiltro.getCfResponsabile());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCivico()))
				builder.queryParam("civico", impiantoFiltro.getCivico());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getCodiceImpianto()))
				builder.queryParam(Constants.CITSERVICE_PARAM_CODICE_IMPIANTO, impiantoFiltro.getCodiceImpianto());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getDescComune()))
				builder.queryParam("desc-comune", impiantoFiltro.getDescComune());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getFkStato()))
				builder.queryParam("fk-stato", impiantoFiltro.getFkStato());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getFlagVisuProprietario()))
				builder.queryParam("flag-visu-proprietario", impiantoFiltro.getFlagVisuProprietario());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getIdComune()))
				builder.queryParam("id-comune", impiantoFiltro.getIdComune());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getIndirizzo()))
				builder.queryParam("indirizzo", impiantoFiltro.getIndirizzo());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getIstatComune()))
				builder.queryParam("istat-comune", impiantoFiltro.getIstatComune());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getNumeroRea()))
				builder.queryParam("numero-rea", impiantoFiltro.getNumeroRea());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getPdr()))
				builder.queryParam("pdr", impiantoFiltro.getPdr());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getPod()))
				builder.queryParam("pod", impiantoFiltro.getPod());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getSiglaProvincia()))
				builder.queryParam("sigla-provincia", impiantoFiltro.getSiglaProvincia());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getSiglaRea()))
				builder.queryParam("sigla-rea", impiantoFiltro.getSiglaRea());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getX()))
				builder.queryParam("x", impiantoFiltro.getX());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getY()))
				builder.queryParam("y", impiantoFiltro.getY());

			if (validationService.isNotNullOrEmpty(impiantoFiltro.getDistanza()))
				builder.queryParam("distanza", impiantoFiltro.getDistanza());

			builder.queryParam(Constants.CITSERVICE_PARAM_TOKEN_JWT, token);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), FeatureCollection.class);
		} catch (HttpClientErrorException e) {
			int responseCode = e.getStatusCode().value();
			if (responseCode == 404) {
				throw new NotFoundException();
			} else {
				log.error(Constants.CITSERVICE_ERRORE_RECUPERO_IMPIANTI, e);
				throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_IMPIANTI, e);
			}
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_IMPIANTI, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_IMPIANTI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getGeoJsonImpiantoByFiltroJWT - end");
		}
	}
	
	@Override
	public Esito setImpianto(UtenteLoggato utenteLoggato, DatiImpianto datiImpianto, Integer tipoResponsabilita) throws SigitExtException, SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "setImpianto - start");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/setImpianto");
			if (tipoResponsabilita != null) {
				builder.queryParam("responsabilita", tipoResponsabilita);
			}
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
			SetImpiantoModel setImpiantoModel = new SetImpiantoModel(utenteLoggato, datiImpianto);
			String json = objectMapper.writeValueAsString(setImpiantoModel);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			log.error("Errore inserimento impianto: " + e.getResponseBodyAsString(), e);
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitExtException(esito.getDescrizioneEsito());
		} catch (Exception e) {
			log.error("Errore inserimento impianto", e);
			throw new SvistaException("Errore durante l'inserimento dell'impianto", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setImpianto - end");
		}
	}

	@Override
	public Esito updateImpianto(UtenteLoggato utenteLoggato, DatiImpianto datiImpianto) throws SvistaException {
		log.info(Constants.CITSERVICE_LOG + "updateImpianto - start");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/setModificaImpianto").build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
			SetImpiantoModel setImpiantoModel = new SetImpiantoModel(utenteLoggato, datiImpianto);
			String json = objectMapper.writeValueAsString(setImpiantoModel);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (Exception e) {
			log.error("Errore aggiornamento impianto", e);
			throw new SvistaException("Errore durante l'aggiornamento dell'impianto", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setImpianto - end");
		}
	}

	@Override
	public MOD getLibrettoNow(String codiceImpianto, boolean isConsolidato, String tokenJWT) throws SvistaException {
		log.info(Constants.CITSERVICE_LOG + "getLibrettoNow - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/now");
			builder.queryParam(CODICE_IMPIANTO_REQUEST_PARAM, codiceImpianto);
			builder.queryParam(CONSOLIDATO_REQUEST_PARAM, isConsolidato);
			builder.queryParam(Constants.CITSERVICE_PARAM_TOKEN_JWT, tokenJWT);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			Libretto libretto = objectMapper.readValue(response.getBody(), Libretto.class);
			Source source = new StreamSource(new ByteArrayInputStream(libretto.getLibrettoXml()));
			JAXBContext context = JAXBContext.newInstance(MOD.class);
			JAXBElement<MOD> root = context.createUnmarshaller().unmarshal(source, MOD.class);
			return root.getValue();
		} catch (HttpClientErrorException e) {
			int responseCode = e.getStatusCode().value();
			if (responseCode == 404) {
				throw new NotFoundException();
			} else {
				log.error(Constants.CITSERVICE_ERRORE_RECUPERO_LIBRETTO, e);
				throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI);
			}
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_LIBRETTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getLibrettoNow - end");
		}
	}

	@Override
	public byte[] getXMLControllo(Integer idAllegato) throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getXMLControllo - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/xml");
			builder.queryParam(Constants.CITSERVICE_PARAM_ID_ALLEGATO, idAllegato);
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<byte[]> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, byte[].class);
			return response.getBody();
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException e) {
			int responseCode = e.getStatusCode().value();
			if (responseCode == 404) {
				throw new NotFoundException();
			} else {
				log.error(Constants.CITSERVICE_ERRORE_RECUPERO_XML_CONTROLLO, e);
				throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_XML_CONTROLLO);
			}

		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_XML_CONTROLLO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_XML_CONTROLLO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getXMLControllo - end");
		}
	}

	@Override
	public Documento getLibrettoByUid(String uid, String token) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getLibrettoByUid - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/uid");
			builder.queryParam("uid", uid);
			builder.queryParam(Constants.CITSERVICE_PARAM_TOKEN_JWT, token);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), Documento.class);
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_LIBRETTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getLibrettoByUid - end");
		}
		return null;
	}


	@Override
	public SigitTLibretto getLibrettoDtoByUid(String uid) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getLibrettoDtoByUid - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/dto/uid");
			builder.queryParam("uid", uid);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), SigitTLibretto.class);
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_LIBRETTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getLibrettoDtoByUid - end");
		}
		return null;
	}

	@Override
	public Documento getXmlLibrettoNow(Integer codiceImpianto, Boolean isConsolidato, String token) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getXmlLibrettoNow - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/xml/now");
			builder.queryParam(CODICE_IMPIANTO_REQUEST_PARAM, codiceImpianto);
			builder.queryParam(CONSOLIDATO_REQUEST_PARAM, isConsolidato);
			builder.queryParam(Constants.CITSERVICE_PARAM_TOKEN_JWT, token);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), Documento.class);
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_LIBRETTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getXmlLibrettoNow - end");
		}
		return null;
	}

	@Override
	public Documento getXMLLibrettoConsolidatoJWT(int codiceImpianto, String token) throws IOException {
		log.info(Constants.CITSERVICE_LOG + "getXMLLibrettoConsolidatoJWT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/xml/consolidato");
			builder.queryParam(CODICE_IMPIANTO_REQUEST_PARAM, codiceImpianto);
			builder.queryParam(Constants.CITSERVICE_PARAM_TOKEN_JWT, token);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), Documento.class);
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_LIBRETTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getXMLLibrettoConsolidatoJWT - end");
		}
		return null;
	}

	@Override
	public Persona[] getRespProp(Integer tipo, String cf, String siglaRea, String numeroRea) throws SvistaException {
		log.info(Constants.CITSERVICE_LOG + "getRespProp - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/resp_prop");
			builder.queryParam("tipo", tipo);
			if (cf != null) {
				builder.queryParam("cf", cf.toUpperCase());
			}
			if (siglaRea != null && numeroRea != null) {
				builder.queryParam("sigla_rea", siglaRea.toUpperCase());
				builder.queryParam("numero_rea", numeroRea.toUpperCase());
			}
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), Persona[].class);
		} catch (HttpClientErrorException e) {
			int responseCode = e.getStatusCode().value();
			if (responseCode == 404) {
				throw new NotFoundException();
			} else {
				log.error(Constants.CITSERVICE_ERRORE_RECUPERO_RESP_PROP, e);
				throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_RESP_PROP);
			}
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_RESP_PROP, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_RESP_PROP, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getRespProp - end");
		}
	}

	@Override
	public Esito setRespProp(RespPropModel respPropModel) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "setRespProp - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/resp_prop");
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
			String json = objectMapper.writeValueAsString(respPropModel);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (HttpClientErrorException e) {
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			int responseCode = e.getStatusCode().value();
			if (responseCode == 404) {
				throw new NotFoundException();
			} else {
				log.error(Constants.CITSERVICE_ERRORE_INVIO_COMP + e.getResponseBodyAsString(), e);
				throw new SigitExtException(esito.getDescrizioneEsito());
			}
		} catch (Exception e) {
			log.error("Errore durante l'inserimento di un responsabile/proprietario", e);
			throw new SvistaException("Errore durante l'inserimento di un responsabile/proprietario", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setRespProp - end");
		}
	}

	@Override
	public DatiGT[] getGT(String codiceimpianto, Integer progressivo, Integer idPersona) throws Exception, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getGT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/gt");
			builder.queryParam(Constants.CITSERVICE_PARAM_CODICE_IMPIANTO, codiceimpianto);
			if (progressivo != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_PROGRESSIVO, progressivo);
			if (idPersona != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_PERSONA, idPersona);
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), DatiGT[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException e) {
			int responseCode = e.getStatusCode().value();
			if (responseCode == 404) {
				throw new NotFoundException();
			} else {
				log.error(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_GT, e);
				throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_GT);
			}
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_GT, e);
			throw new Exception(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_GT, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getGT - end");
		}
	}

	@Override
	public DatiGF[] getGF(String codiceimpianto, Integer progressivo, Integer idPersona) throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getGF - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/gf");
			builder.queryParam(Constants.CITSERVICE_PARAM_CODICE_IMPIANTO, codiceimpianto);
			if (progressivo != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_PROGRESSIVO, progressivo);
			if (idPersona != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_PERSONA, idPersona);
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), DatiGF[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException e) {
			int responseCode = e.getStatusCode().value();
			if (responseCode == 404) {
				throw new NotFoundException();
			} else {
				log.error(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_GF, e);
				throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_GF);
			}
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_GF, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_GF, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getGF - end");
		}
	}

	@Override
	public DatiSC[] getSC(String codiceimpianto, Integer progressivo, Integer idPersona) throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getSC - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/sc");
			builder.queryParam(Constants.CITSERVICE_PARAM_CODICE_IMPIANTO, codiceimpianto);
			if (progressivo != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_PROGRESSIVO, progressivo);
			if (idPersona != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_PERSONA, idPersona);
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), DatiSC[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException e) {
			int responseCode = e.getStatusCode().value();
			if (responseCode == 404) {
				throw new NotFoundException();
			} else {
				log.error(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_SC, e);
				throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_SC);
			}
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_SC, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_SC, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getSC - end");
		}
	}

	@Override
	public DatiCG[] getCG(String codiceimpianto, Integer progressivo, Integer idPersona) throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getCG - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/cg");
			builder.queryParam(Constants.CITSERVICE_PARAM_CODICE_IMPIANTO, codiceimpianto);
			if (progressivo != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_PROGRESSIVO, progressivo);
			if (idPersona != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_PERSONA, idPersona);
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), DatiCG[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException e) {
			int responseCode = e.getStatusCode().value();
			if (responseCode == 404) {
				throw new NotFoundException();
			} else {
				log.error(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_CG, e);
				throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_CG);
			}
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_CG, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_COMP_CG, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getCG - end");
		}
	}

	@Override
	public CodiceDescrizione[] getMarcaCIT() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getmarcaCIT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/marca").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_SETACCESSO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_SALVATAGGIO_ACCESSO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getMarcaCIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getCombustibileCIT() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getCombustibileCIT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/combustibile").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_SETACCESSO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_SALVATAGGIO_ACCESSO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getCombustibileCIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getClassDpr66096CIT() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getClassDpr66096CIT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/classDpr66096").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_SETACCESSO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_SALVATAGGIO_ACCESSO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getClassDpr66096CIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getFrequenzaManutCIT() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getFrequenzaManutCIT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/frequenzaManut").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_SETACCESSO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_SALVATAGGIO_ACCESSO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getFrequenzaManutCIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getFluidoCIT() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getFluidoCIT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/fluido").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_SETACCESSO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_SALVATAGGIO_ACCESSO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getFluidoCIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getTipologiaGT() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getTipologiaGT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/tipologiaGT").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_SETACCESSO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_SALVATAGGIO_ACCESSO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getTipologiaGT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getTipologiaGF() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getTipologiaGF - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/tipologiaGF").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_SETACCESSO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_SALVATAGGIO_ACCESSO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getTipologiaGF - end");
		}
	}

	@Override
	public CodiceDescrizione[] getFonteCIT() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getFonteCIT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/fonte").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getFonteCIT", e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "v - end");
		}
	}

	@Override
	public CodiceDescrizione[] getTipoCannaFumaria() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getTipoCannaFumaria - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/canna-fumaria").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_SETACCESSO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_SALVATAGGIO_ACCESSO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getTipoCannaFumaria - end");
		}
	}

	@Override
	public CodiceDescrizione[] getStelle() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getStelle - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/stelle").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getStelle", e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getStelle - end");
		}
	}

	@Override
	public CodiceDescrizione[] getApparecchiature() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getApparecchiature - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/apparecchiature").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getApparecchiature", e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getApparecchiature - end");
		}
	}

	@Override
	public CodiceDescrizione[] getAriaComburente() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getAriaComburente - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/aria-comburente").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getAriaComburente", e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getAriaComburente - end");
		}
	}

	@Override
	public CodiceDescrizione[] getControlloAria() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getControlloAria - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/controllo-aria").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getControlloAria", e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getControlloAria - end");
		}
	}

	@Override
	public CodiceDescrizione[] getUnitaMisura() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getUnitaMisura - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/domini/unita-misura").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getUnitaMisura", e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getUnitaMisura - end");
		}
	}

	@Override
	public Esito updateGT(UpdateGtModel updateGtModel, Integer idImpresaSelez) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "updateGT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/gt");
			if (idImpresaSelez != null) {
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_IMPRESA, idImpresaSelez);
			}
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
			String json = objectMapper.writeValueAsString(updateGtModel);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.PUT, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			log.error(Constants.CITSERVICE_ERRORE_INVIO_COMP + e.getResponseBodyAsString(), e);
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			if (esito.getEsito().equals(Constants.KO_PG)) {
				throw new NotFoundException();
			} else
				throw new SigitExtException(esito.getDescrizioneEsito());
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_AGGIORNAMENTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_AGGIORNAMENTO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "updateGT - end");
		}
	}

	@Override
	public Esito updateGF(UpdateGfModel updateGfModel, Integer idImpresaSelez) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "updateGF - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/gf");
			if (idImpresaSelez != null) {
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_IMPRESA, idImpresaSelez);
			}
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
			String json = objectMapper.writeValueAsString(updateGfModel);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.PUT, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			log.error(Constants.CITSERVICE_ERRORE_INVIO_COMP + e.getResponseBodyAsString(), e);
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			if (esito.getEsito().equals(Constants.KO_PG)) {
				throw new NotFoundException();
			} else
				throw new SigitExtException(esito.getDescrizioneEsito());

		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_AGGIORNAMENTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_AGGIORNAMENTO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "updateGF - end");
		}
	}

	@Override
	public Esito updateSC(UpdateScModel updateScModel, Integer idImpresaSelez) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "updateSC - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/sc");
			if (idImpresaSelez != null) {
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_IMPRESA, idImpresaSelez);
			}
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
			String json = objectMapper.writeValueAsString(updateScModel);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.PUT, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			log.error(Constants.CITSERVICE_ERRORE_INVIO_COMP + e.getResponseBodyAsString(), e);
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			if (esito.getEsito().equals(Constants.KO_PG)) {
				throw new NotFoundException();
			} else
				throw new SigitExtException(esito.getDescrizioneEsito());

		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_AGGIORNAMENTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_AGGIORNAMENTO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "updateSC - end");
		}
	}

	@Override
	public Esito updateCG(UpdateCgModel updateCgModel, Integer idImpresaSelez) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "updateCG - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/cg");
			if (idImpresaSelez != null) {
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_IMPRESA, idImpresaSelez);
			}
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
			String json = objectMapper.writeValueAsString(updateCgModel);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.PUT, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			log.error(Constants.CITSERVICE_ERRORE_INVIO_COMP + e.getResponseBodyAsString(), e);
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			if (esito.getEsito().equals(Constants.KO_PG)) {
				throw new NotFoundException();
			} else
				throw new SigitExtException(esito.getDescrizioneEsito());

		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_AGGIORNAMENTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_AGGIORNAMENTO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "updateCG - end");
		}
	}

	@Override
	public List<Controllo> getControlli(String codiceImpianto, String ordinamento, Integer numRighe) throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "getControlli - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/all");
			builder.queryParam(Constants.CITSERVICE_PARAM_CODICE_IMPIANTO, codiceImpianto);
			builder.queryParam("ordinamento", ordinamento);
			if (numRighe != null)
				builder.queryParam("num-righe", numRighe);
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), new TypeReference<List<Controllo>>() {
			});
		} catch (ResourceAccessException e) {
			log.error("Timeout recupero controlli", e);
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore recupero controlli", e);
			throw new SvistaException("Errore recupero controlli", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getControlli - end");
		}
	}

	@Override
	public byte[] getRicevutaControllo(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, UtenteLoggato utenteLoggato) throws
			SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getRicevutaControllo - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/ricevuta");
			builder.queryParam(Constants.CITSERVICE_PARAM_ID_ALLEGATO, idAllegato);
			builder.queryParam(Constants.CITSERVICE_PARAM_RUOLO, utenteLoggato.getRuoloLoggato().getRuolo());
			if (utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica() != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_IMPRESA, utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica());

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<byte[]> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, byte[].class);
			return response.getBody();
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_RICEVUTA, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_RICEVUTA, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getRicevutaControllo - end");
		}
	}

	@Override
	public PdfControllo getPDFControllo(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, Boolean firmato, UtenteLoggato utenteLoggato)
			throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getRicevutaControllo - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/pdf");
			builder.queryParam(Constants.CITSERVICE_PARAM_ID_ALLEGATO, idAllegato);
			builder.queryParam(Constants.CITSERVICE_PARAM_CODICE_IMPIANTO, codiceImpianto);
			builder.queryParam(Constants.CITSERVICE_PARAM_RUOLO, utenteLoggato.getRuoloLoggato().getRuolo());
			builder.queryParam("firmato", firmato);
			if (utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica() != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_IMPRESA, utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica());

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), PdfControllo.class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_RICEVUTA, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_RICEVUTA, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getRicevutaControllo - end");
		}
	}

	@Override
	public List<ControlloDisponibile> getControlliDisponibili(String codiceImpianto, String tipoComponente, String tipoControllo, String dataControllo, UtenteLoggato utenteLoggato) throws
			SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getControlliDisponibili - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/controlli-disponibili");
			builder.queryParam("tipologia-componente", tipoComponente);
			builder.queryParam("tipologia-controllo", tipoControllo);
			builder.queryParam(Constants.CITSERVICE_PARAM_CODICE_IMPIANTO, codiceImpianto);
			builder.queryParam(Constants.CITSERVICE_PARAM_RUOLO, utenteLoggato.getRuoloLoggato().getRuolo());
			if (utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica() != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_IMPRESA, utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica());
			builder.queryParam("data-controllo", dataControllo);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), new TypeReference<List<ControlloDisponibile>>() {
			});
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			if (e.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
				ObjectMapper mapper = new ObjectMapper();
				Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
				throw new SigitExtException(esito.getDescrizioneEsito());
			}
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_CONTROLLO_DISP, e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_CONTROLLO_DISP, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_CONTROLLO_DISP, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getControlliDisponibili - end");
		}
	}

	@Override
	public Integer uploadXMLControlloJWT(Integer codiceImpianto, String tipoControllo, byte[] xml, String token) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "uploadXMLControlloJWT - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/controllo/xml");
			builder.queryParam(CODICE_IMPIANTO_REQUEST_PARAM, codiceImpianto);
			builder.queryParam("tipo-controllo", tipoControllo);
			builder.queryParam(Constants.CITSERVICE_PARAM_TOKEN_JWT, token);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<byte[]> entity = new HttpEntity<>(xml, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			return Integer.parseInt(response.getBody());
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitExtException(esito.getDescrizioneEsito());
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_UPLOAD_REE, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_UPLOAD_REE, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "uploadXMLControlloJWT - end");
		}
	}

	@Override
	public Integer modificaControlloJWT(Integer idAllegato, Integer codiceImpianto, String tipoControllo, byte[] xml, String token) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "modificaControlloJWT - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo");
			if (idAllegato != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_ALLEGATO, idAllegato);
			builder.queryParam(Constants.CITSERVICE_PARAM_CODICE_IMPIANTO, codiceImpianto);
			builder.queryParam("tipo-controllo", tipoControllo);
			builder.queryParam(Constants.CITSERVICE_PARAM_TOKEN_JWT, token);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<byte[]> entity = new HttpEntity<>(xml, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(response.getBody(), Esito.class);
			return esito.getIdAllegatoNew();
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitExtException(esito.getDescrizioneEsito());
		} catch (Exception e) {
			log.error("Errore durante la modifica del ree", e);
			throw new SvistaException("Errore durante la modifica del ree", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "modificaControlloJWT - end");
		}
	}

	@Override
	public void uploadReeFirmato(Integer idAllegato, byte[] ree, String fileName, String contentType, Integer idPersonaGiuridica, String piva, String ruolo) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "uploadReeFirmato - start");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/ree-firmato");
			builder.queryParam(Constants.CITSERVICE_PARAM_ID_ALLEGATO, idAllegato);
			builder.queryParam(Constants.CITSERVICE_PARAM_RUOLO, ruolo);
			if (idPersonaGiuridica != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_IMPRESA, idPersonaGiuridica);
			builder.queryParam("cf", piva);
			builder.queryParam("nome", fileName);
			builder.queryParam("content-type", contentType);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<byte[]> entity = new HttpEntity<>(ree, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			objectMapper.readValue(response.getBody(), Esito.class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitExtException(esito.getDescrizioneEsito());
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_UPLOAD_REE, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_UPLOAD_REE, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "uploadReeFirmato - end");
		}
	}

	@Override
	public Esito deleteControllo(Integer idAllegato, Integer idPersonaGiuridica, String piva, String ruolo) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "deleteControllo - start");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo");
			builder.queryParam(Constants.CITSERVICE_PARAM_ID_ALLEGATO, idAllegato);
			builder.queryParam(Constants.CITSERVICE_PARAM_RUOLO, ruolo);
			if (idPersonaGiuridica != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_IMPRESA, idPersonaGiuridica);
			if (piva != null)
				builder.queryParam("cf", piva);
			String urlTemplate = builder.build().toUriString();
			log.info(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.DELETE, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsString(), Esito.class);
			throw new SigitExtException(esito.getDescrizioneEsito());
		} catch (Exception e) {
			log.error("Errore durante la cancellazione del controllo", e);
			throw new SvistaException("Errore durante la cancellazione del controllo", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "deleteControllo - end");
		}
	}

	@Override
	public Esito delComponente(String codiceImpianto, String tipo, Integer progressivo, String cf) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "delComponente - start");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp");
			builder.queryParam(Constants.CITSERVICE_PARAM_CODICE_IMPIANTO, codiceImpianto);
			builder.queryParam("tipo", tipo);
			builder.queryParam(Constants.CITSERVICE_PARAM_PROGRESSIVO, progressivo);
			builder.queryParam("cf", cf);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.DELETE, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			ObjectMapper mapper = new ObjectMapper();
			log.error("Errore durante la cancellazione del componente: " + e.getMessage(), e);
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitExtException(esito.getDescrizioneEsito());
		} catch (Exception e) {
			log.error("Errore durante la cancellazione del componente: " + e.getMessage(), e);
			throw new SvistaException("Errore durante la cancellazione del componente", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "delComponente - end");
		}
	}

	@Override
	public Esito inviaREE(Integer idAllegato, Integer idPersonaGiuridica, String cfutenteLoggato, RuoloLoggato ruoloLoggato) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "inviaREE - start");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/invia");
			builder.queryParam(Constants.CITSERVICE_PARAM_ID_ALLEGATO, idAllegato);
			builder.queryParam(Constants.CITSERVICE_PARAM_RUOLO, ruoloLoggato.getRuolo());
			if (idPersonaGiuridica != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_IMPRESA, idPersonaGiuridica);
			if (ruoloLoggato.getCat() != null)
				builder.queryParam("cat", ruoloLoggato.getCat());
			if (cfutenteLoggato != null)
				builder.queryParam("cf", cfutenteLoggato);
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			log.error("Errore durante l'invio del ree: " + e.getResponseBodyAsString(), e);
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitExtException(esito.getDescrizioneEsito());
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante l'invio del ree", e);
			throw new SvistaException("Errore durante l'invio del ree", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "inviaREE - end");
		}
	}

	@Override
	public Esito consolidaLibretto(String codiceImpianto, UtenteLoggato utenteLoggato) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "consolidaLibretto - start");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/consolida");
			builder.queryParam(Constants.CITSERVICE_PARAM_CODICE_IMPIANTO, codiceImpianto);
			if (utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica() != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_ID_IMPRESA, utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica());

			if (utenteLoggato.getRuoloLoggato().getRuolo() != null)
				builder.queryParam(Constants.CITSERVICE_PARAM_RUOLO, utenteLoggato.getRuoloLoggato().getRuolo());

			if (utenteLoggato.getPfLoggato().getCodiceFiscalePF() != null)
				builder.queryParam("cf", utenteLoggato.getPfLoggato().getCodiceFiscalePF());

			if (utenteLoggato.getRuoloLoggato().getNumeroRea() != null && utenteLoggato.getRuoloLoggato().getSiglaRea() != null)
				builder.queryParam("codice-rea", utenteLoggato.getRuoloLoggato().getSiglaRea() + "-" + utenteLoggato.getRuoloLoggato().getNumeroRea());

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			log.error("Errore durante il consolidamento del libretto: " + e.getResponseBodyAsString(), e);
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitExtException(esito.getDescrizioneEsito());
		} catch (Exception e) {
			log.error("Errore durante il consolidamento del libretto", e);
			throw new SvistaException("Errore durante il consolidamento del libretto", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "consolidaLibretto - end");
		}
	}

	@Override
	public void ping() throws SvistaException, SocketTimeoutException {
		log.info(Constants.CITSERVICE_LOG + "ping - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/domini/ping");
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>(headers);
			restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante il ping al servizio", e);
			throw new SvistaException("Errore durante il ping al servizio", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "ping - end");
		}
	}

	@Override
	public String setLibSch1IdImpianto(Integer codiceImpianto, Scheda1 scheda1, UtenteLoggato utenteLoggato) throws IOException {
		log.info(Constants.CITSERVICE_LOG + "setLibSch1IdImpianto - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/setLibSch1IdImpianto");


			builder.queryParam("cfUtenteLoggato", utenteLoggato.getPfLoggato().getCodiceFiscalePF());
			builder.queryParam("codice-impianto", codiceImpianto);
			String urlTemplate = builder.build().toUriString();

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
			String json = objectMapper.writeValueAsString(scheda1);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

			return response.getBody();

		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_SETLIBSCHEDA1IMPIANTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_SETLIBSCHEDA1IMPIANTO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setLibSch1IdImpianto - end");
		}
		return null;
	}

	@Override
	public String setLibSch2IdImpianto(Integer codiceImpianto, Scheda2 scheda2, UtenteLoggato utenteLoggato) throws IOException {
		log.info(Constants.CITSERVICE_LOG + "setLibSch2IdImpianto - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/setLibSch2IdImpianto");


			builder.queryParam("cfUtenteLoggato", utenteLoggato.getPfLoggato().getCodiceFiscalePF());
			builder.queryParam("codice-impianto", codiceImpianto);
			String urlTemplate = builder.build().toUriString();

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
			String json = objectMapper.writeValueAsString(scheda2);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

			return response.getBody();

		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_SETLIBSCHEDA2IMPIANTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_SETLIBSCHEDA2IMPIANTO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setLibSch2IdImpianto - end");
		}
		return null;
	}

	private static void manageHttpClientErrorException(HttpClientErrorException e) throws IOException {
		int responseCode = e.getStatusCode().value();
		if (responseCode == 404) {
			throw new NotFoundException();
		} else {
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitExtException(esito.getDescrizioneEsito());
		}
	}

	@Override
	public Libretto getLibrettoNowByCodice(Integer codiceImpianto, Boolean isConsolidato, String token) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getLibrettoNowByCodice - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/now");
			builder.queryParam(CODICE_IMPIANTO_REQUEST_PARAM, codiceImpianto);
			builder.queryParam(CONSOLIDATO_REQUEST_PARAM, isConsolidato);
			builder.queryParam(Constants.CITSERVICE_PARAM_TOKEN_JWT, token);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), Libretto.class);
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_LIBRETTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getLibrettoNowByCodice - end");
		}
		return null;
	}

	@Override
	public Scheda1 getSchedaLibrettoByCodice(Integer codiceImpianto, String token) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getLibrettoNowByCodice - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/scheda-libretto");
			builder.queryParam(CODICE_IMPIANTO_REQUEST_PARAM, codiceImpianto);
			builder.queryParam(Constants.CITSERVICE_PARAM_TOKEN_JWT, token);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), Scheda1.class);
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_LIBRETTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getLibrettoNowByCodice - end");
		}
		return null;
	}

	@Override
	public CodiceDescrizione[] getTipoIntervento() throws IOException {
		log.info(Constants.CITSERVICE_LOG + "getTipoIntervento - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/tipoIntervento");

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, null, String.class);
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_LIBRETTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getTipoIntervento - end");
		}
		
		return new CodiceDescrizione[] {};
	}

	@Override
	public String setDocumento(DocumentoPwa documento, Integer idContratto, String cfUtenteLoggato, Integer codiceImpianto, Integer idAzione, String tipoDoc, Integer fkIspezIspett, String dataControllo) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "setDocumento - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/documento/set");
			builder.queryParam("cfUtenteLoggato", cfUtenteLoggato);
			builder.queryParam(CODICE_IMPIANTO_REQUEST_PARAM, codiceImpianto);
			builder.queryParam("id_azione", idAzione);
			builder.queryParam("tipo_doc", tipoDoc);
			if (idContratto != null) {
				builder.queryParam("idContratto", idContratto);
			}
			if (fkIspezIspett != null) {
				builder.queryParam("fk_ispez_ispett", fkIspezIspett);
			}
			if (dataControllo != null && !dataControllo.isEmpty()) {
				builder.queryParam("data_controllo", dataControllo);
			}
			String urlTemplate = builder.build().toUriString();

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			String json = objectMapper.writeValueAsString(documento);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

			return response.getBody();

		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_DOCUMENTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DOCUMENTO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setDocumento - end");
		}
		return null;
	}

	@Override
	public ResponseGetElencoDocumenti getElencoDocumenti(Integer codiceImpianto, Integer idVerifica, Integer idAccertamento, Integer idIspezione2018) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getElencoDocumenti - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/documento/elenco");
			builder.queryParam(ID_VERIFICA_REQUEST_PARAM, idVerifica);
			builder.queryParam("id_accertamento", idAccertamento);
			builder.queryParam("id_ispezione_2018", idIspezione2018);
			builder.queryParam(CODICE_IMPIANTO_REQUEST_PARAM, codiceImpianto);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);


			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);


			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			return objectMapper.readValue(response.getBody(), ResponseGetElencoDocumenti.class);

		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_DOCUMENTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DOCUMENTO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getElencoDocumenti - end");
		}
		return null;
	}

	@Override
	public Documento getDocumentoByUid(String uidIndex) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getDocumentoByUid - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/documento/uid");
			builder.queryParam("uidIndex", uidIndex);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, null, String.class);
			return objectMapper.readValue(response.getBody(), Documento.class);
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_DOCUMENTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DOCUMENTO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getDocumentoByUid - end");
		}
		return null;
	}

	@Override
	public String deleteDocumento(String uidIndex) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "deleteDocumento - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/documento/uid");
			builder.queryParam("uidIndex", uidIndex);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.DELETE, null, String.class);
			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_DELETE_DOCUMENTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_DELETE_DOCUMENTO, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "deleteDocumento - end");
		}
		return null;
	}


	@Override
	public Categoria[] getCategorie() throws IOException {
		log.info(Constants.CITSERVICE_LOG + "getCategorie - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = citUrl + "/libretto/categorie";
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), Categoria[].class);
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_LIBRETTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getCategorie - end");
		}
		return new Categoria[] {};
	}

	@Override
	public Object getTipoDocumento() throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getTipoDocumento - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = citUrl + "/documento/getTipoDocumenti";
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, null, String.class);
			return objectMapper.readValue(response.getBody(), Object[].class);
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} catch (Exception e) {
			log.error(Constants.CITSERVICE_ERRORE_RECUPERO_LIBRETTO, e);
			throw new SvistaException(Constants.CITSERVICE_ERRORE_RECUPERO_DATI, e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getTipoDocumento - end");
		}
		return null;
	}

	@Override
	public Accreditamento getDatiAccreditamento(String codiceFiscalePF) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getDatiAccreditamento - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/dati");
			builder.queryParam(CODICE_FISCALE_REQUEST_PARAM, codiceFiscalePF);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);


			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.getBody(), Accreditamento.class);
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getDatiAccreditamento - end");
		}
		return null;
	}

	@Override
	public String setDatiPersonaliUtente(String codiceFiscalePF, Persona persona) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "setDatiPersonaliUtente - start");
		try {

			ObjectMapper objectMapper = new ObjectMapper();

			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/datiPersonaliUtente");
			builder.queryParam(CODICE_FISCALE_REQUEST_PARAM, codiceFiscalePF);
			String urlTemplate = builder.build().toUriString();

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			String json = objectMapper.writeValueAsString(persona);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setDatiPersonaliUtente - end");
		}
		return null;
	}

	@Override
	public List<DatiImpresa> getDatiImpresa(String codiceFiscale, String siglaRea, Integer numeroRea) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getDatiImpresa - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/dati/impresa");
			if (codiceFiscale != null)
				builder.queryParam(CODICE_FISCALE_REQUEST_PARAM, codiceFiscale);
			if (siglaRea != null)
				builder.queryParam("sigla_REA", siglaRea);
			if (numeroRea != null)
				builder.queryParam("numero_REA", numeroRea);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);


			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.getBody(), new TypeReference<List<DatiImpresa>>() {
			});
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getDatiImpresa - end");
		}
		return new ArrayList<>();
	}

	@Override
	public String setDelega(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "setDelega - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/delega/set");
			builder.queryParam(CODICE_FISCALE_REQUEST_PARAM, codiceFiscalePF);
			builder.queryParam(ID_PERSONA_GIURIDICA_REQUEST_PARAM, idPersonaGiuridica);
			builder.queryParam(ID_PERSONA_REQUEST_PARAM, idPersona);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);


			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setDelega - end");
		}
		return null;
	}

	@Override
	public String deleteDelega(UtenteLoggato utenteLoggato, Integer idPersona) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "deleteDelega - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/delega/delete");
			builder.queryParam(ID_PERSONA_REQUEST_PARAM, idPersona);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(utenteLoggato);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "deleteDelega - end");
		}
		return null;
	}


	@Override
	public String deleteDelegaConfirm(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "deleteDelegaConfirm - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/delega/delete/confirm");
			builder.queryParam(CODICE_FISCALE_REQUEST_PARAM, codiceFiscalePF);
			builder.queryParam(ID_PERSONA_GIURIDICA_REQUEST_PARAM, idPersonaGiuridica);
			builder.queryParam(ID_PERSONA_REQUEST_PARAM, idPersona);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.DELETE, entity, String.class);

			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "deleteDelegaConfirm - end");
		}
		return null;
	}

	@Override
	public List<IncarichiSoggettiDelegatiResponse> getIncarichiSoggettiDelegati() throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getIncarichiSoggettiDelegati - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/delega/soggetti");
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.getBody(), new TypeReference<List<IncarichiSoggettiDelegatiResponse>>() {
			});

		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getIncarichiSoggettiDelegati - end");
		}
		return new ArrayList<>();
	}

	@Override
	public String setIncaricoSoggettoDelegato(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "setIncaricoSoggettoDelegato - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/delega/soggetti/incarico/set");
			builder.queryParam(CODICE_FISCALE_REQUEST_PARAM, codiceFiscalePF);
			builder.queryParam(ID_PERSONA_GIURIDICA_REQUEST_PARAM, idPersonaGiuridica);
			builder.queryParam("id_persona_giuridica_cat", idPersonaGiuridicaCat);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);


			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setIncaricoSoggettoDelegato - end");
		}
		return null;
	}

	@Override
	public String deleteIncaricoSoggettoDelegato(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "deleteIncaricoSoggettoDelegato - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/delega/soggetti/incarico/delete");
			builder.queryParam(CODICE_FISCALE_REQUEST_PARAM, codiceFiscalePF);
			builder.queryParam(ID_PERSONA_GIURIDICA_REQUEST_PARAM, idPersonaGiuridica);
			builder.queryParam("id_persona_giuridica_cat", idPersonaGiuridicaCat);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);


			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.DELETE, entity, String.class);

			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "deleteIncaricoSoggettoDelegato - end");
		}
		return null;
	}

	@Override
	public String sendEmailProva(String emailAddress) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "sendEmailProva - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/mail/send/prova");
			builder.queryParam("email_address", emailAddress);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);


			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "sendEmailProva - end");
		}
		return null;
	}

	@Override
	public String setImpresaAssociata(String operation, String codiceFiscalePF, DatiImpresa datiImpresa) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "setImpresaAssociata - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/impresa/set");
			builder.queryParam(CODICE_FISCALE_REQUEST_PARAM, codiceFiscalePF);
			builder.queryParam("operation", operation);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			String json = objectMapper.writeValueAsString(datiImpresa);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setImpresaAssociata - end");
		}
		return null;
	}

	@Override
	public List<DatiIncarico> getElencoIncarichi(Integer idPersonaGiuridica) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getElencoIncarichi - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/getElencoIncarichi");
			builder.queryParam(ID_PERSONA_GIURIDICA_REQUEST_PARAM, idPersonaGiuridica);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);


			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.getBody(), new TypeReference<>() {
			});
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getElencoIncarichi - end");
		}
		return new ArrayList<>();
	}

	@Override
	public List<DatiDelega> getElencoDeleghe(Integer idPersonaGiuridica) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getDatiAccreditamento - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/getElencoDeleghe");
			builder.queryParam(ID_PERSONA_GIURIDICA_REQUEST_PARAM, idPersonaGiuridica);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);


			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.getBody(), new TypeReference<>() {
			});
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getDatiAccreditamento - end");
		}
		return new ArrayList<>();
	}

	@Override
	public List<TipoVerifica> getTipoVerifica() throws SvistaException, IOException {

		log.info(Constants.CITSERVICE_LOG + "getTipoVerifica - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/verifiche/getTipoVerifica");
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.getBody(), new TypeReference<>() {
			});
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getTipoVerifica - end");
		}
		return null;
	}

	@Override
	public DettaglioVerificaModel getVerifica(Integer idVerifica) throws SvistaException, IOException {

		log.info(Constants.CITSERVICE_LOG + "getVerifica - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/verifiche/getDettaglioVerifica");
			builder.queryParam(ID_VERIFICA_REQUEST_PARAM, idVerifica);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			DettaglioVerifica dettaglioVerifica =  objectMapper.readValue(response.getBody(),  new TypeReference<DettaglioVerifica>(){});

			DettaglioVerificaModel dettaglioVerificaModel = new DettaglioVerificaModel();

			dettaglioVerificaModel.setStato(dettaglioVerifica.getDatiImpianto().getStato());
			dettaglioVerificaModel.setDataVar(dettaglioVerifica.getDatiImpianto().getDataVar());
			dettaglioVerificaModel.setMotivazione(dettaglioVerifica.getDatiImpianto().getMotivazione());
			dettaglioVerificaModel.setTipoImpianto(dettaglioVerifica.getDatiImpianto().getTipoImpianto());
			if(dettaglioVerifica.getDatiImpianto()!=null && NumberUtil.isNumeric(dettaglioVerifica.getDatiImpianto().getCodiceImpianto())) {
				dettaglioVerificaModel.setCodiceImpianto(Long.parseLong(dettaglioVerifica.getDatiImpianto().getCodiceImpianto()));
			}

			dettaglioVerificaModel.setFlgApparevvUiExt(dettaglioVerifica.getDatiImpianto().getFlgApparevvUiExt());
			dettaglioVerificaModel.setFlgContabilizzazione(dettaglioVerifica.getDatiImpianto().getFlgContabilizzazione());
			dettaglioVerificaModel.setStradario(dettaglioVerifica.getDatiImpianto().getStradario());
			dettaglioVerificaModel.setIndirizzoSitad(dettaglioVerifica.getDatiImpianto().getIndirizzoSitad());
			dettaglioVerificaModel.setIndirizzoNonTrovato(dettaglioVerifica.getDatiImpianto().getIndirizzoNonTrovato());
			dettaglioVerificaModel.setComune(dettaglioVerifica.getDatiImpianto().getComune());
			dettaglioVerificaModel.setCivico(dettaglioVerifica.getDatiImpianto().getCivico());
			dettaglioVerificaModel.setProvincia(dettaglioVerifica.getDatiImpianto().getProvincia());
			dettaglioVerificaModel.setPod(dettaglioVerifica.getDatiImpianto().getPod());
			dettaglioVerificaModel.setPdr(dettaglioVerifica.getDatiImpianto().getPdr());
			dettaglioVerificaModel.setFlgNoPdr(dettaglioVerifica.getDatiImpianto().getFlgNoPdr());
			dettaglioVerificaModel.setFlgVisuProprietario(dettaglioVerifica.getDatiImpianto().getFlgVisuProprietario());
			dettaglioVerificaModel.setCoordX(dettaglioVerifica.getDatiImpianto().getCoordX());
			dettaglioVerificaModel.setCoordY(dettaglioVerifica.getDatiImpianto().getCoordY());
			dettaglioVerificaModel.setSiglaProv(dettaglioVerifica.getDatiImpianto().getSiglaProv());
			dettaglioVerificaModel.setIstatComune(dettaglioVerifica.getDatiImpianto().getIstatComune());
			dettaglioVerificaModel.setFlgMedioimpianto(dettaglioVerifica.getDatiImpianto().getFlgMedioimpianto());

			dettaglioVerificaModel.setIdVerifica(dettaglioVerifica.getDatiVerifica().getIdVerifica());
			dettaglioVerificaModel.setFkTipoVerifica(dettaglioVerifica.getDatiVerifica().getFkTipoVerifica());
			dettaglioVerificaModel.setDesTipoVerifica(dettaglioVerifica.getDatiVerifica().getDesTipoVerifica());
			dettaglioVerificaModel.setFkAllegato(dettaglioVerifica.getDatiVerifica().getFkAllegato());
			dettaglioVerificaModel.setFkDatoDistrib(dettaglioVerifica.getDatiVerifica().getFkDatoDistrib());
			if(dettaglioVerifica.getDatiVerifica()!=null && dettaglioVerifica.getDatiVerifica().getCodiceImpianto()!=null
			&& NumberUtil.isNumeric(dettaglioVerifica.getDatiVerifica().getCodiceImpianto())) {
				dettaglioVerificaModel.setCodiceImpianto(Long.parseLong(dettaglioVerifica.getDatiVerifica().getCodiceImpianto()));
			}

			dettaglioVerificaModel.setCfUtenteCaricamento(dettaglioVerifica.getDatiVerifica().getCfUtenteCaricamento());
			dettaglioVerificaModel.setDenomUtenteCaricamento(dettaglioVerifica.getDatiVerifica().getDenomUtenteCaricamento());
			if(dettaglioVerifica.getDatiVerifica().getDtCaricamento()!=null) {
				dettaglioVerificaModel.setDtCaricamento(dettaglioVerifica.getDatiVerifica().getDtCaricamento().getTime());
			}
			dettaglioVerificaModel.setSiglaBollino(dettaglioVerifica.getDatiVerifica().getSiglaRee());

			if(dettaglioVerifica.getDatiVerifica()!=null && dettaglioVerifica.getDatiVerifica().getNumeroRee()!=null
					&& NumberUtil.isNumeric(dettaglioVerifica.getDatiVerifica().getNumeroRee())) {
				dettaglioVerificaModel.setNumeroBollino(Integer.parseInt(dettaglioVerifica.getDatiVerifica().getNumeroRee()));
			}

			if(dettaglioVerifica.getDatiVerifica().getDtSveglia()!=null) {
				dettaglioVerificaModel.setDtSveglia(dettaglioVerifica.getDatiVerifica().getDtSveglia().getTime());
			}
			dettaglioVerificaModel.setNoteSveglia(dettaglioVerifica.getDatiVerifica().getNoteSveglia());
			dettaglioVerificaModel.setNote(dettaglioVerifica.getDatiVerifica().getNote());


			return dettaglioVerificaModel;

		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getVerifica - end");
		}
		return null;

	}

	@Override
	public String setVerifica(Verifica verifica, UtenteLoggatoModel utenteLoggato) throws SvistaException , IOException {

		log.info(Constants.CITSERVICE_LOG + "setVerifica - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/verifiche/setVerifica");
			String urlTemplate = builder.build().toUriString();

			VerificaIns verificaIns = new VerificaIns();
			verificaIns.setVerifica(verifica);
			verificaIns.setUtenteLoggatoModel(utenteLoggato);

			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			String json = objectMapper.writeValueAsString(verificaIns);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setVerifica - end");
		}
		return null;

	}

	@Override
	public List<SigitTVerificaModel>  getVerifiche(RicercaDatiVerifica ricercaDatiVerifica)throws SvistaException , IOException{

		log.info(Constants.CITSERVICE_LOG + "getVerifiche - start");
		try {

			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/verifiche/getElencoVerifiche");
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			String json = objectMapper.writeValueAsString(ricercaDatiVerifica);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

			List<SigitTVerifica> listSigitTVerifica =  objectMapper.readValue(response.getBody(), new TypeReference<>() {
			});

			List<SigitTVerificaModel> listSigitTVerificaModel = new ArrayList<>();
			if(listSigitTVerifica!=null) {
				for (int i = 0; i < listSigitTVerifica.size(); i++) {
					SigitTVerificaModel sigitTVerificaModel = new SigitTVerificaModel();
					SigitTVerifica sigitTVerifica = listSigitTVerifica.get(i);

					sigitTVerificaModel.setFkTipoVerifica(sigitTVerifica.getFkTipoVerifica());
					sigitTVerificaModel.setFkAllegato(sigitTVerifica.getFkAllegato());
					sigitTVerificaModel.setFkDatoDistrib(sigitTVerifica.getFkDatoDistrib());
					sigitTVerificaModel.setCfUtenteCaricamento(sigitTVerifica.getCfUtenteCaricamento());
					sigitTVerificaModel.setCfUtenteCaricamento(sigitTVerifica.getCfUtenteCaricamento());
					sigitTVerificaModel.setIdVerifica(sigitTVerifica.getIdVerifica());
					if(sigitTVerifica.getDtSveglia()!=null) {
						sigitTVerificaModel.setDtSveglia(sigitTVerifica.getDtSveglia().getTime());
					}
					if(sigitTVerifica.getDtCaricamento()!=null) {
						sigitTVerificaModel.setDtCaricamento(sigitTVerifica.getDtCaricamento().getTime());
					}
					sigitTVerificaModel.setDenomUtenteCaricamento(sigitTVerifica.getDenomUtenteCaricamento());
					sigitTVerificaModel.setNote(sigitTVerifica.getNote());
					sigitTVerificaModel.setNoteSveglia(sigitTVerifica.getNoteSveglia());
					sigitTVerificaModel.setNumeroBollino(sigitTVerifica.getNumeroBollino());
					sigitTVerificaModel.setSiglaBollino(sigitTVerifica.getSiglaBollino());
					sigitTVerificaModel.setCodiceImpianto(sigitTVerifica.getCodiceImpianto());

					listSigitTVerificaModel.add(sigitTVerificaModel);
				}
			}

			return listSigitTVerificaModel;
		} catch (HttpClientErrorException  e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getVerifiche - end");
		}
		return null;
	}

	@Override
	public String deleteVerifica(Integer idVerifica) throws SvistaException , IOException {

		log.info(Constants.CITSERVICE_LOG + "deleteVerifica - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/verifiche/deleteVerifica");
			builder.queryParam(ID_VERIFICA_REQUEST_PARAM, idVerifica);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.DELETE, entity, String.class);

			return response.getBody();


		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "deleteVerifica - end");
		}
		return null;

	}

	@Override
	public Object getDistributore(Long idDatoDistrib)  throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getDistributore - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/verifiche/getDistributore");
			builder.queryParam("id_dato_distrib", idDatoDistrib);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			DatiDistributori datiDistributori =  objectMapper.readValue(response.getBody(),  new TypeReference<DatiDistributori>(){});

			datiDistributori.setStatoDistribDesc(TipoStatoDistributoreEnum.valueOfId(datiDistributori.getFkStatoDistrib()).tipoStatoDistirbutoreDesc);

			return datiDistributori;

		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getDistributore - end");
		}
		return null;
	}

	@Override
	public Object getControllo(String siglaRee, Long numeroRee)  throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getControllo - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/verifiche/getControllo");
			builder.queryParam("sigla_ree", siglaRee);
			builder.queryParam("numero_ree", numeroRee);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.getBody(),  new TypeReference<Controlli>(){});
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getControllo - end");
		}
		return null;
	}

	@Override
	public Object getAssegnatario()  throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getAssegnatario - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/verifiche/getAssegnatario");
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.getBody(),  new TypeReference<List<Assegnatario>>(){});
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getAssegnatario - end");
		}
		return null;
	}

	@Override
	public Object getSiglaRee() throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getSiglaRee - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/verifiche/getSiglaRee");

			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.getBody(),  new TypeReference<List<String>>(){});
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getSiglaRee - end");
		}
		return null;
	}
	
	@Override
	public ResponseGetDettaglioNomina getDettaglioNomina(Integer idContratto, Integer codiceImpianto) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getDettaglioNomina - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/nominaterzoresponsabile/dettaglio");
			builder.queryParam("id_contratto", idContratto);
			builder.queryParam(CODICE_IMPIANTO_REQUEST_PARAM, codiceImpianto);
			String urlTemplate = builder.build().toUriString();
			
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.getBody(), new TypeReference<>() {
			});
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getDettaglioNomina - end");
		}
		return null;
	}
	
	@Override
	public String deleteAffidamento(String codiceFiscale, Integer idPersonaGiuridica, Integer codiceImpianto, DatiAffidamento datiAffidamento) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "deleteAffidamento - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/nominaterzoresponsabile/delete/affidamento");
			builder.queryParam(CODICE_FISCALE_REQUEST_PARAM, codiceFiscale);
			builder.queryParam(ID_PERSONA_GIURIDICA_REQUEST_PARAM, idPersonaGiuridica);
			builder.queryParam(CODICE_IMPIANTO_REQUEST_PARAM, codiceImpianto);
			String urlTemplate = builder.build().toUriString();
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(datiAffidamento);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			
			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "deleteAffidamento - end");
		}
		return null;
	}
	
	@Override
	public List<Map<Integer, String>> getTipoCessazione() throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getTipoCessazione - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/nominaterzoresponsabile/tipo/cessazione");
			String urlTemplate = builder.build().toUriString();
			
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.getBody(), new TypeReference<>() {
			});
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getTipoCessazione - end");
		}
		return List.of();
	}
	
	@Override
	public List<Map<Integer, String>> getTipoAutodichiarazione() throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getTipoCessazione - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/nominaterzoresponsabile/tipo/autodichiarazione");
			String urlTemplate = builder.build().toUriString();
			
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.getBody(), new TypeReference<>() {
			});
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getTipoCessazione - end");
		}
		return List.of();
	}

	@Override
	public Object getAzione(Integer idVerifica, UtenteLoggato utenteLoggato) throws SvistaException , IOException {
		log.info(Constants.CITSERVICE_LOG + "getAzione - start");
		try {

			List<SigitTAzione> listSigitTAzione = getSigitTAzione(idVerifica, utenteLoggato);

			List<DatiAzione> listDatiAzione = new ArrayList<DatiAzione>();
			if(listSigitTAzione!=null) {
				for (int i = 0; i < listSigitTAzione.size(); i++) {
					DatiAzione datiAzione = new DatiAzione();
					SigitTAzione sigitTAzione = listSigitTAzione.get(i);

					List<SigitTDocAzione> listSigitTDocAzione = getSigitTDocAzione(sigitTAzione.getIdAzione());

					if(listSigitTDocAzione!=null && listSigitTDocAzione.size()>0){
						SigitTDocAzione sigitTDocAzione = listSigitTDocAzione.get(0);
						if(sigitTDocAzione!=null){
							datiAzione.setNomeDoc(sigitTDocAzione.getNomeDoc());
							datiAzione.setNomeDocOriginale(sigitTDocAzione.getNomeDocOriginale());
							datiAzione.setUidIndex(sigitTDocAzione.getUidIndex());
							datiAzione.setMimeTypeDoc(sigitTDocAzione.getMimeTypeDoc());
						}
					}

					datiAzione.setIdAzione(new BigDecimal(sigitTAzione.getIdAzione()));
					datiAzione.setDtAzione(sigitTAzione.getDtAzione().getTime());
					datiAzione.setFkTipoAzione(new BigDecimal(sigitTAzione.getFkTipoAzione()));
					datiAzione.setIdVerifica(new BigDecimal(sigitTAzione.getFkVerifica()));
					datiAzione.setIdAccertamento(new BigDecimal(sigitTAzione.getFkAccertamento()));
					datiAzione.setIdIspezione2018(new BigDecimal(sigitTAzione.getFkIspezione2018()));
					datiAzione.setIdSanzione(new BigDecimal(sigitTAzione.getFkSanzione()));
					datiAzione.setDescrizioneAzione(sigitTAzione.getDescrizioneAzione());
					datiAzione.setCfUtenteAzione(sigitTAzione.getCfUtenteAzione());
					datiAzione.setDenomUtenteAzione(sigitTAzione.getDenomUtenteAzione());


					listDatiAzione.add(datiAzione);
				}
			}

			return listDatiAzione;
		} catch (HttpClientErrorException  e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getAzione - end");
		}
		return null;
	}

	@Override
	public Object setAzione(DatiAzione datiAzione) throws SvistaException , IOException {

		log.info(Constants.CITSERVICE_LOG + "setAzione - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/azione/verifica/setAzione");
			String urlTemplate = builder.build().toUriString();

			UtenteLoggato utenteLoggato = new UtenteLoggato();
			utenteLoggato.setPfLoggato(new PFLoggato());
			utenteLoggato.getPfLoggato().setCodiceFiscalePF(datiAzione.getCfUtenteAzione());

			DocumentoPwa documentoPwa = new DocumentoPwa();
			documentoPwa.setMimeType(datiAzione.getDocContentType());
			documentoPwa.setDoc(datiAzione.getDocBase64());
			documentoPwa.setTipoDocumento("azione_verifica");
			documentoPwa.setNome(datiAzione.getNomeDocOriginale());

			Azione azione = new Azione();
			azione.setCfUtenteAzione(datiAzione.getCfUtenteAzione());
			azione.setFkAzione(datiAzione.getIdVerifica().intValue());
			azione.setDataAzione(new SimpleDateFormat("dd/MM/yyyy").format(new Date(datiAzione.getDtAzione())));
			azione.setDescrizione(datiAzione.getDescrizioneAzione());

			AzioneIns azioneIns = new AzioneIns();
			azioneIns.setDatiAzione(azione);
			azioneIns.setDocumentoPwa(documentoPwa);
			azioneIns.setUtenteLoggato(utenteLoggato);

			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			String json = objectMapper.writeValueAsString(azioneIns);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setAzione - end");
		}
		return null;

	}
	
	@Override
	public String verifyIndirizzoImpianto(DatiImpianto datiImpianto, Boolean checkContrattoInEssere) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "verifyIndirizzoImpianto - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/verify");
			String urlTemplate = builder.queryParam("checkContrattoInEssere", checkContrattoInEssere).build().toUriString();
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(datiImpianto);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			
			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "verifyIndirizzoImpianto - end");
		}
		return null;
	}
	
	@Override
	public List<Persona> getElencoStoricoResponsabiliImpianto(String codiceImpianto) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getElencoStoricoResponsabiliImpianto - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/responsabili/elenco/storico");
			builder.queryParam(CODICE_IMPIANTO_REQUEST_PARAM, codiceImpianto);
			String urlTemplate = builder.build().toUriString();
			
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.getBody(), new TypeReference<ArrayList<Persona>>() {
			});
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getElencoStoricoResponsabiliImpianto - end");
		}
		return null;
	}



	private List<SigitTAzione> getSigitTAzione(Integer idVerifica, UtenteLoggato utenteLoggato) throws JsonProcessingException {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/azione/getAzione");
		builder.queryParam("id_verifica", idVerifica);
		String urlTemplate = builder.build().toUriString();

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		String json = objectMapper.writeValueAsString(utenteLoggato);
		HttpEntity<String> entity = new HttpEntity<>(json, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

		List<SigitTAzione> listSigitTAzione =  objectMapper.readValue(response.getBody(), new TypeReference<>() {
		});
		return listSigitTAzione;
	}

	private List<SigitTDocAzione> getSigitTDocAzione(Integer idAzione) throws JsonProcessingException {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/azione/getDocAzione");
		builder.queryParam("id_azione", idAzione);
		String urlTemplate = builder.build().toUriString();

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(null, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		List<SigitTDocAzione> listSigitTDocAzione =  objectMapper.readValue(response.getBody(), new TypeReference<>() {
		});
		return listSigitTDocAzione;
	}


	@Override
	public Esito setSubentroComponente(String codiceImpianto, String idPersonaGiuridica, Boolean sendMail, SubentroComponente subentro) throws JsonProcessingException {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/subentro/componenti");
		builder.queryParam("id_persona_giuridica", idPersonaGiuridica);
		builder.queryParam("codice_impianto", codiceImpianto);
		builder.queryParam("sendMail", sendMail);
		String urlTemplate = builder.build().toUriString();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper objectMapper = new ObjectMapper();

		HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(subentro), headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
		return objectMapper.readValue(response.getBody(), Esito.class);
	}
	
	@Override
	public String setCessazione(RequestTerzoResponsabile requestTerzoResponsabile) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "setCessazione - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/nominaterzoresponsabile/cessazione/set");
			String urlTemplate = builder.build().toUriString();
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(requestTerzoResponsabile);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			
			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setCessazione - end");
		}
		return null;
	}
	
	@Override
	public String setProroga(RequestTerzoResponsabile requestTerzoResponsabile) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "setProroga - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/nominaterzoresponsabile/proroga/set");
			String urlTemplate = builder.build().toUriString();
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(requestTerzoResponsabile);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			
			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setProroga - end");
		}
		return null;
	}
	
	
	@Override
	public String setSubentrosuImpianto(String codiceFiscale, Integer idPersona, Integer codiceImpianto, String desRuolo, UtenteLoggato utenteLoggato) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "setSubentrosuImpianto - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/nominaterzoresponsabile/subentro/impianto/set");
			builder.queryParam("codice_fiscale", codiceFiscale);
			if(idPersona == null) {
				builder.queryParam("id_persona", -3000);
			}else{
				builder.queryParam("id_persona", idPersona);
			}
			builder.queryParam("codice_impianto", codiceImpianto);
			builder.queryParam("des_ruolo", desRuolo);
			String urlTemplate = builder.build().toUriString();
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			ObjectMapper objectMapper = new ObjectMapper();
			HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(utenteLoggato), headers);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			
			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setSubentrosuImpianto - end");
		}
		return null;
	}
	
	@Override
	public String verifyContrattoTerzoResponsabile(RequestTerzoResponsabile requestVerifyContratto) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "verifyContrattoTerzoResponsabile - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/nominaterzoresponsabile/verify/contratto");
			String urlTemplate = builder.build().toUriString();
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(requestVerifyContratto);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			
			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "verifyContrattoTerzoResponsabile - end");
		}
		return null;
	}
	
	@Override
	public String setNuovoTerzoResp(Integer codiceImpianto, RequestTerzoResponsabile request) throws SvistaException, IOException {
		log.info(Constants.CITSERVICE_LOG + "verifyContrattoTerzoResponsabile - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/nominaterzoresponsabile/nuovo/set");
			builder.queryParam("codice_impianto", codiceImpianto);
			String urlTemplate = builder.build().toUriString();
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(request);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			
			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "verifyContrattoTerzoResponsabile - end");
		}
		return null;
	}

	@Override
	public Impianto[] getImpiantoByCodiceJWT(String codiceImpianto, JWTModel tokenJWT) throws SvistaException, IOException {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/codice");
		builder.queryParam("codice_impianto", codiceImpianto);
		builder.queryParam("tokenJWT", tokenJWT.getToken());
		String urlTemplate = builder.build().toUriString();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
		HttpEntity<String> entity = new HttpEntity<>(null, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(response.getBody(), new TypeReference<>() {
		});

	}

	@Override
	public String getDatiTokenImpresa(Integer idPersonaGiuridica) throws SigitExtException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getDatiTokenImpresa - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/token/impresa");
			builder.queryParam(ID_PERSONA_GIURIDICA_REQUEST_PARAM, idPersonaGiuridica);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getDatiTokenImpresa - end");
		}
		return null;
	}

	@Override
	public String generateTokenImpresa(Integer idPersonaGiuridica) throws SigitExtException, IOException {
		log.info(Constants.CITSERVICE_LOG + "getDatiTokenImpresa - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/accreditamento/token/impresa");
			builder.queryParam(ID_PERSONA_GIURIDICA_REQUEST_PARAM, idPersonaGiuridica);
			String urlTemplate = builder.build().toUriString();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.PUT, entity, String.class);

			return response.getBody();
		} catch (HttpClientErrorException e) {
			manageHttpClientErrorException(e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getDatiTokenImpresa - end");
		}
		return null;
	}

	@Override
	public Integer getGeoJsonImpiantoMaxResults() throws SigitExtException {
		log.info(Constants.CITSERVICE_LOG + "getGeoJsonImpiantoMaxResults - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/geo/filtro/max").build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			if (responseCode != 200) {
				Errore error = objectMapper.readValue(response.getBody(), Errore.class);
				log.debug(error);
			}
			return Integer.valueOf(response.getBody());
		} catch (Exception e) {
			log.error("Errore durante il recupero del numero massimo di impinati restituibili", e);
			throw new SvistaException("Errore durante il recupero del numero massimo di impinati restituibili", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getGeoJsonImpiantoMaxResults - end");
		}
	}

}
