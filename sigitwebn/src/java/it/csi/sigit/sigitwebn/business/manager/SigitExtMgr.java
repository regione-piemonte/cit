package it.csi.sigit.sigitwebn.business.manager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.csi.iride2.policy.base.nmsf.stub.base.exceptions.InternalException;
import it.csi.sigit.sigitext.dto.sigitext.Documento;
import it.csi.sigit.sigitext.dto.sigitext.Impianto;
import it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro;
import it.csi.sigit.sigitext.dto.sigitext.Libretto;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import it.csi.sigit.sigitwebn.dto.Esito;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.InternalServerErrorException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

public class SigitExtMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	public Impianto[] getImpiantoByFiltroJWT(ImpiantoFiltro impiantoFiltro, String token) throws Exception {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constants.SIGITEXT_URL + "/impianto/filtro");
			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getCf3Responsabile()))
				builder.queryParam("cf3-resp", impiantoFiltro.getCf3Responsabile());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getCfImpresa()))
				builder.queryParam("cf-impresa", impiantoFiltro.getCfImpresa());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getCfProprietario()))
				builder.queryParam("cf-proprietario", impiantoFiltro.getCfProprietario());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getCfResponsabile()))
				builder.queryParam("cf-responsabile", impiantoFiltro.getCfResponsabile());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getCivico()))
				builder.queryParam("civico", impiantoFiltro.getCivico());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getCodiceImpianto()))
				builder.queryParam("codice-impianto", impiantoFiltro.getCodiceImpianto());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getDescComune()))
				builder.queryParam("desc-comune", impiantoFiltro.getDescComune());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getFkStato()))
				builder.queryParam("fk-stato", impiantoFiltro.getFkStato());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getFlagVisuProprietario()))
				builder.queryParam("flag-visu-proprietario", impiantoFiltro.getFlagVisuProprietario());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getIdComune()))
				builder.queryParam("id-comune", impiantoFiltro.getIdComune());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getIndirizzo()))
				builder.queryParam("indirizzo", impiantoFiltro.getIndirizzo());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getIstatComune()))
				builder.queryParam("istat-comune", impiantoFiltro.getIstatComune());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getNumeroRea()))
				builder.queryParam("numero-rea", impiantoFiltro.getNumeroRea());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getPdr()))
				builder.queryParam("pdr", impiantoFiltro.getPdr());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getPod()))
				builder.queryParam("pod", impiantoFiltro.getPod());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getSiglaProvincia()))
				builder.queryParam("sigla-provincia", impiantoFiltro.getSiglaProvincia());

			if (GenericUtil.isNotNullOrEmpty(impiantoFiltro.getSiglaRea()))
				builder.queryParam("sigla-rea", impiantoFiltro.getSiglaRea());

			builder.queryParam("tokenJWT", token);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), Impianto[].class);
		} catch (HttpServerErrorException | HttpClientErrorException e) {
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitextException(esito.getDescrizioneEsito());
		}
	}

	public Libretto getLibrettoNowJWT(Integer codiceImpianto, boolean isConsolidato, String token) throws SigitextException, IOException {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constants.SIGITEXT_URL + "/libretto/now");
			builder.queryParam("codice_impianto", codiceImpianto);
			builder.queryParam("tokenJWT", token);
			builder.queryParam("consolidato", isConsolidato);
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), Libretto.class);
		} catch (HttpServerErrorException | HttpClientErrorException e) {
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitextException(esito.getDescrizioneEsito());
		} catch (Exception e) {
			log.error("Errore chiamata servizio", e);
			throw new InternalServerErrorException("Errore interno del server");
		}
	}

	public void uploadXMLLibrettoJWT(Integer codiceImpianto, byte[] xml, String token) throws IOException, SigitextException {
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constants.SIGITEXT_URL + "/libretto/xml");
			builder.queryParam("codice_impianto", codiceImpianto);
			builder.queryParam("tokenJWT", token);
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<byte[]> entity = new HttpEntity<>(xml, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
		} catch (HttpServerErrorException | HttpClientErrorException e) {
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitextException(esito.getDescrizioneEsito());
		} catch (Exception e) {
			log.error("Errore chiamata servizio", e);
			throw new InternalServerErrorException("Errore interno del server");
		}
	}

	public Integer uploadXMLControlloJWT(Integer codiceImpianto, String tipoControllo, byte[] xml, String token) throws IOException, SigitextException {
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constants.SIGITEXT_URL + "/libretto/controllo/xml");
			builder.queryParam("codice_impianto", codiceImpianto);
			builder.queryParam("tipo-controllo", tipoControllo);
			builder.queryParam("tokenJWT", token);
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<byte[]> entity = new HttpEntity<>(xml, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			return Integer.parseInt(response.getBody());
		} catch (HttpServerErrorException | HttpClientErrorException e) {
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitextException(esito.getDescrizioneEsito());
		} catch (Exception e) {
			log.error("Errore chiamata servizio", e);
			throw new InternalServerErrorException("Errore interno del server");
		}
	}

	public Documento getXMLLibrettoConsolidatoJWT(Integer codiceImpianto, String token) throws IOException, SigitextException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constants.SIGITEXT_URL + "/libretto/xml/consolidato");
			builder.queryParam("codice_impianto", codiceImpianto);
			builder.queryParam("tokenJWT", token);
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return mapper.readValue(response.getBody(), Documento.class);
		} catch (HttpServerErrorException | HttpClientErrorException e) {
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitextException(esito.getDescrizioneEsito());
		} catch (Exception e) {
			log.error("Errore chiamata servizio", e);
			throw new InternalServerErrorException("Errore interno del server");
		}
	}
}
