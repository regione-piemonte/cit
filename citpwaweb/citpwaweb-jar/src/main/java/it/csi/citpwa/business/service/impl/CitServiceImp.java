/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.csi.citpwa.business.service.ICitService;
import it.csi.citpwa.business.service.ValidationService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.model.SetImpiantoModel;
import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.model.xsd.libretto.MOD;
import it.csi.citpwa.util.Constants;
import it.csi.sigit.sigitext.ws.service.client.Documento;
import it.csi.sigit.sigitext.ws.service.client.Impianto;
import it.csi.sigit.sigitext.ws.service.client.Libretto;
import it.csi.sigit.sigitext.ws.service.client.SigitextSigitext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.ws.rs.NotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Service
public class CitServiceImp implements ICitService {

	private SigitextSigitext clientSigitext;

	@Value("${CIT_URL}")
	private String citUrl;

	@Autowired
	ValidationService validationService;

	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

	@Override
	public Ruoli getRuoliUtente(String cf, String nome, String cognome) throws Exception {
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
			throw new Exception("Errore durante il recupero dei ruoli", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getRuoliUtente - end");
		}
	}

	@Override
	public String setAccesso(UtenteLoggato utenteLoggato) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "setAccesso - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/user/accesso").build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
			HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(utenteLoggato), headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			int responseCode = response.getStatusCode().value();
			if (responseCode != 200) {
				Errore error = objectMapper.readValue(response.getBody(), Errore.class);
				log.debug(error);
			}
			return Constants.OK;
		} catch (Exception e) {
			log.error("Errore durante la chiamata a setAccesso", e);
			throw new Exception("Errore durante il salvataggio dell'accesso", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setAccesso - end");
		}
	}

	@Override
	public CodiceDescrizione[] getStatoImpianto() throws Exception {
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
			log.error("Errore durante la chiamata a setAccesso", e);
			throw new Exception("Errore durante il salvataggio dell'accesso", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getStatoImpianto - end");
		}
	}

	@Override
	public Impianto[] getImpiantoByFiltroJWT(ImpiantoFiltro impiantoFiltro, String token) throws Exception {
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
				builder.queryParam("codice-impianto", impiantoFiltro.getCodiceImpianto());

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

			builder.queryParam("tokenJWT", token);

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
				log.error("Errore durante il recupero degli impianti", e);
				throw new Exception("Errore durante il recupero degli impianti");
			}
		} catch (Exception e) {
			log.error("Errore durante il recupero degli impianti", e);
			throw new Exception("Errore durante il recupero degli impianti", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getImpiantoByFiltro - end");
		}
	}

	@Override
	public Esito setImpianto(UtenteLoggato utenteLoggato, DatiImpianto datiImpianto, Integer tipoResponsabilita) throws SigitExtException, Exception {
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
			headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
			SetImpiantoModel setImpiantoModel = new SetImpiantoModel(utenteLoggato, datiImpianto);
			String json = objectMapper.writeValueAsString(setImpiantoModel);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			log.error("Errore inserimento impianto: " + e.getResponseBodyAsString(), e);
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			throw new SigitExtException(esito.getDescrizioneEsito());
		} catch (Exception e) {
			log.error("Errore inserimento impianto", e);
			throw new Exception("Errore durante l'inserimento dell'impianto", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setImpianto - end");
		}
	}

	@Override
	public Esito updateImpianto(UtenteLoggato utenteLoggato, DatiImpianto datiImpianto) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "updateImpianto - start");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/setModificaImpianto").build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
			SetImpiantoModel setImpiantoModel = new SetImpiantoModel(utenteLoggato, datiImpianto);
			String json = objectMapper.writeValueAsString(setImpiantoModel);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (Exception e) {
			log.error("Errore aggiornamento impianto", e);
			throw new Exception("Errore durante l'aggiornamento dell'impianto", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setImpianto - end");
		}
	}

	@Override
	public MOD getLibrettoNow(String codiceImpianto, boolean isConsolidato, String tokenJWT) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getLibrettoNow - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/now");
			builder.queryParam("codice_impianto", codiceImpianto);
			builder.queryParam("consolidato", isConsolidato);
			builder.queryParam("tokenJWT", tokenJWT);

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
				log.error("Errore durante il recupero del libretto", e);
				throw new Exception("Errore durante il recupero dei dati");
			}
		} catch (Exception e) {
			log.error("Errore durante il recupero del libretto", e);
			throw new Exception("Errore durante il recupero dei dati", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getLibrettoNow - end");
		}
	}

	@Override
	public byte[] getXMLControllo(Integer idAllegato) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getXMLControllo - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/xml");
			builder.queryParam("id-allegato", idAllegato);
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
				log.error("Errore durante il recupero dell'xml del controllo", e);
				throw new Exception("Errore durante il recupero dell'xml del controllo");
			}

		} catch (Exception e) {
			log.error("Errore durante il recupero dell' xml del controllo", e);
			throw new Exception("Errore durante il recupero dell'xml del controllo", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getXMLControllo - end");
		}
	}

	@Override
	public Documento getLibrettoByUid(String uid, String token) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getLibrettoByUid - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/uid");
			builder.queryParam("uid", uid);
			builder.queryParam("tokenJWT", token);

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), Documento.class);
		} catch (HttpClientErrorException e) {
			int responseCode = e.getStatusCode().value();
			if (responseCode == 404) {
				throw new NotFoundException();
			} else {
				ObjectMapper mapper = new ObjectMapper();
				Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
				throw new SigitExtException(esito.getDescrizioneEsito());
			}
		} catch (Exception e) {
			log.error("Errore durante il recupero del libretto", e);
			throw new Exception("Errore durante il recupero dei dati", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getLibrettoByUid - end");
		}
	}

	@Override
	public Persona[] getRespProp(Integer tipo, String cf, String siglaRea, String numeroRea) throws Exception {
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
				log.error("Errore durante il recupero del responsabile/propreitario", e);
				throw new Exception("Errore durante il recupero del responsabile/propreitario");
			}
		} catch (Exception e) {
			log.error("Errore durante il recupero del responsabile/propreitario", e);
			throw new Exception("Errore durante il recupero del responsabile/propreitario", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getRespProp - end");
		}
	}

	@Override
	public Esito setRespProp(RespPropModel respPropModel) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "setRespProp - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/impianto/resp_prop");
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
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
				log.error("Errore durante l'invio del componente: " + e.getResponseBodyAsString(), e);
				throw new SigitExtException(esito.getDescrizioneEsito());
			}
		} catch (Exception e) {
			log.error("Errore durante l'inserimento di un responsabile/proprietario", e);
			throw new Exception("Errore durante l'inserimento di un responsabile/proprietario", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "setRespProp - end");
		}
	}

	@Override
	public DatiGT[] getGT(String codiceimpianto, Integer progressivo, Integer idPersona) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getGT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/gt");
			builder.queryParam("codice-impianto", codiceimpianto);
			if (progressivo != null)
				builder.queryParam("progressivo", progressivo);
			if (idPersona != null)
				builder.queryParam("id-persona", idPersona);
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
				log.error("Errore durante il recupero dei componenti GT", e);
				throw new Exception("Errore durante il recupero dei componenti GT");
			}
		} catch (Exception e) {
			log.error("Errore durante il recupero dei componenti GT", e);
			throw new Exception("Errore durante il recupero dei componenti GT", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getGT - end");
		}
	}

	@Override
	public DatiGF[] getGF(String codiceimpianto, Integer progressivo, Integer idPersona) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getGF - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/gf");
			builder.queryParam("codice-impianto", codiceimpianto);
			if (progressivo != null)
				builder.queryParam("progressivo", progressivo);
			if (idPersona != null)
				builder.queryParam("id-persona", idPersona);
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
				log.error("Errore durante il recupero dei componenti GF", e);
				throw new Exception("Errore durante il recupero dei componenti GF");
			}
		} catch (Exception e) {
			log.error("Errore durante il recupero dei componenti GF", e);
			throw new Exception("Errore durante il recupero dei componenti GF", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getGF - end");
		}
	}

	@Override
	public DatiSC[] getSC(String codiceimpianto, Integer progressivo, Integer idPersona) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getSC - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/sc");
			builder.queryParam("codice-impianto", codiceimpianto);
			if (progressivo != null)
				builder.queryParam("progressivo", progressivo);
			if (idPersona != null)
				builder.queryParam("id-persona", idPersona);
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
				log.error("Errore durante il recupero dei componenti SC", e);
				throw new Exception("Errore durante il recupero dei componenti SC");
			}
		} catch (Exception e) {
			log.error("Errore durante il recupero dei componenti SC", e);
			throw new Exception("Errore durante il recupero dei componenti SC", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getSC - end");
		}
	}

	@Override
	public DatiCG[] getCG(String codiceimpianto, Integer progressivo, Integer idPersona) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getCG - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/cg");
			builder.queryParam("codice-impianto", codiceimpianto);
			if (progressivo != null)
				builder.queryParam("progressivo", progressivo);
			if (idPersona != null)
				builder.queryParam("id-persona", idPersona);
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
				log.error("Errore durante il recupero dei componenti CG", e);
				throw new Exception("Errore durante il recupero dei componenti CG");
			}
		} catch (Exception e) {
			log.error("Errore durante il recupero dei componenti CG", e);
			throw new Exception("Errore durante il recupero dei componenti CG", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getCG - end");
		}
	}

	@Override
	public CodiceDescrizione[] getMarcaCIT() throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getmarcaCIT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/marca").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a setAccesso", e);
			throw new Exception("Errore durante il salvataggio dell'accesso", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getMarcaCIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getCombustibileCIT() throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getCombustibileCIT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/combustibile").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a setAccesso", e);
			throw new Exception("Errore durante il salvataggio dell'accesso", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getCombustibileCIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getFluidoCIT() throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getFluidoCIT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/fluido").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a setAccesso", e);
			throw new Exception("Errore durante il salvataggio dell'accesso", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getFluidoCIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getTipologiaGT() throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getTipologiaGT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/tipologiaGT").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a setAccesso", e);
			throw new Exception("Errore durante il salvataggio dell'accesso", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getTipologiaGT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getTipologiaGF() throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getTipologiaGF - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/tipologiaGF").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a setAccesso", e);
			throw new Exception("Errore durante il salvataggio dell'accesso", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getTipologiaGF - end");
		}
	}

	@Override
	public CodiceDescrizione[] getFonteCIT() throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getFonteCIT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/fonte").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getFonteCIT", e);
			throw new Exception("Errore durante il recupero dei dati", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "v - end");
		}
	}

	@Override
	public CodiceDescrizione[] getTipoCannaFumaria() throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getTipoCannaFumaria - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/canna-fumaria").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a setAccesso", e);
			throw new Exception("Errore durante il salvataggio dell'accesso", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getTipoCannaFumaria - end");
		}
	}

	@Override
	public CodiceDescrizione[] getStelle() throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getStelle - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/stelle").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getStelle", e);
			throw new Exception("Errore durante il recupero dei dati", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getStelle - end");
		}
	}

	@Override
	public CodiceDescrizione[] getApparecchiature() throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getApparecchiature - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/apparecchiature").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getApparecchiature", e);
			throw new Exception("Errore durante il recupero dei dati", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getApparecchiature - end");
		}
	}

	@Override
	public CodiceDescrizione[] getAriaComburente() throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getAriaComburente - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/aria-comburente").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getAriaComburente", e);
			throw new Exception("Errore durante il recupero dei dati", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getAriaComburente - end");
		}
	}

	@Override
	public CodiceDescrizione[] getControlloAria() throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getControlloAria - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/controllo-aria").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getControlloAria", e);
			throw new Exception("Errore durante il recupero dei dati", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getControlloAria - end");
		}
	}

	@Override
	public CodiceDescrizione[] getUnitaMisura() throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getUnitaMisura - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(citUrl + "/domini/unita-misura").build().toUriString();
			log.debug(urlTemplate);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			int responseCode = response.getStatusCode().value();
			return objectMapper.readValue(response.getBody(), CodiceDescrizione[].class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante la chiamata a getUnitaMisura", e);
			throw new Exception("Errore durante il recupero dei dati", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getUnitaMisura - end");
		}
	}

	@Override
	public Esito updateGT(UpdateGtModel updateGtModel, Integer idImpresaSelez) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "updateGT - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/gt");
			if (idImpresaSelez != null) {
				builder.queryParam("id-impresa", idImpresaSelez);
			}
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
			String json = objectMapper.writeValueAsString(updateGtModel);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.PUT, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			log.error("Errore durante l'invio del componente: " + e.getResponseBodyAsString(), e);
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			if (esito.getEsito().equals(Constants.KO_PG)) {
				throw new NotFoundException();
			} else
				throw new SigitExtException(esito.getDescrizioneEsito());
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore durante l'aggiornamento", e);
			throw new Exception("Errore durante l'aggiornamento", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "updateGT - end");
		}
	}

	@Override
	public Esito updateGF(UpdateGfModel updateGfModel, Integer idImpresaSelez) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "updateGF - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/gf");
			if (idImpresaSelez != null) {
				builder.queryParam("id-impresa", idImpresaSelez);
			}
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
			String json = objectMapper.writeValueAsString(updateGfModel);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.PUT, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			log.error("Errore durante l'invio del componente: " + e.getResponseBodyAsString(), e);
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			if (esito.getEsito().equals(Constants.KO_PG)) {
				throw new NotFoundException();
			} else
				throw new SigitExtException(esito.getDescrizioneEsito());

		} catch (Exception e) {
			log.error("Errore durante l'aggiornamento", e);
			throw new Exception("Errore durante l'aggiornamento", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "updateGF - end");
		}
	}

	@Override
	public Esito updateSC(UpdateScModel updateScModel, Integer idImpresaSelez) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "updateSC - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/sc");
			if (idImpresaSelez != null) {
				builder.queryParam("id-impresa", idImpresaSelez);
			}
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
			String json = objectMapper.writeValueAsString(updateScModel);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.PUT, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			log.error("Errore durante l'invio del componente: " + e.getResponseBodyAsString(), e);
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			if (esito.getEsito().equals(Constants.KO_PG)) {
				throw new NotFoundException();
			} else
				throw new SigitExtException(esito.getDescrizioneEsito());

		} catch (Exception e) {
			log.error("Errore durante l'aggiornamento", e);
			throw new Exception("Errore durante l'aggiornamento", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "updateSC - end");
		}
	}

	@Override
	public Esito updateCG(UpdateCgModel updateCgModel, Integer idImpresaSelez) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "updateCG - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp/cg");
			if (idImpresaSelez != null) {
				builder.queryParam("id-impresa", idImpresaSelez);
			}
			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
			String json = objectMapper.writeValueAsString(updateCgModel);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.PUT, entity, String.class);
			return objectMapper.readValue(response.getBody(), Esito.class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			log.error("Errore durante l'invio del componente: " + e.getResponseBodyAsString(), e);
			ObjectMapper mapper = new ObjectMapper();
			Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
			if (esito.getEsito().equals(Constants.KO_PG)) {
				throw new NotFoundException();
			} else
				throw new SigitExtException(esito.getDescrizioneEsito());

		} catch (Exception e) {
			log.error("Errore durante l'aggiornamento", e);
			throw new Exception("Errore durante l'aggiornamento", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "updateCG - end");
		}
	}

	@Override
	public List<Controllo> getControlli(String codiceImpianto, String ordinamento, Integer numRighe) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getControlli - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/all");
			builder.queryParam("codice-impianto", codiceImpianto);
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
			throw new Exception("Errore recupero controlli", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getControlli - end");
		}
	}

	@Override
	public byte[] getRicevutaControllo(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, UtenteLoggato utenteLoggato) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getRicevutaControllo - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/ricevuta");
			builder.queryParam("id-allegato", idAllegato);
			builder.queryParam("ruolo", utenteLoggato.getRuoloLoggato().getRuolo());
			if (utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica() != null)
				builder.queryParam("id-impresa", utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica());

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<byte[]> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, byte[].class);
			return response.getBody();
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore recupero ricevuta", e);
			throw new Exception("Errore recupero ricevuta", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getRicevutaControllo - end");
		}
	}

	@Override
	public PdfControllo getPDFControllo(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, Boolean firmato, UtenteLoggato utenteLoggato)
			throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getRicevutaControllo - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/pdf");
			builder.queryParam("id-allegato", idAllegato);
			builder.queryParam("codice-impianto", codiceImpianto);
			builder.queryParam("ruolo", utenteLoggato.getRuoloLoggato().getRuolo());
			builder.queryParam("firmato", firmato);
			if (utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica() != null)
				builder.queryParam("id-impresa", utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica());

			String urlTemplate = builder.build().toUriString();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
			return objectMapper.readValue(response.getBody(), PdfControllo.class);
		} catch (ResourceAccessException e) {
			throw new SocketTimeoutException();
		} catch (Exception e) {
			log.error("Errore recupero ricevuta", e);
			throw new Exception("Errore recupero ricevuta", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getRicevutaControllo - end");
		}
	}

	@Override
	public List<ControlloDisponibile> getControlliDisponibili(String codiceImpianto, String tipoComponente, String tipoControllo, String dataControllo, UtenteLoggato utenteLoggato) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "getControlliDisponibili - start");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/controlli-disponibili");
			builder.queryParam("tipologia-componente", tipoComponente);
			builder.queryParam("tipologia-controllo", tipoControllo);
			builder.queryParam("codice-impianto", codiceImpianto);
			builder.queryParam("ruolo", utenteLoggato.getRuoloLoggato().getRuolo());
			if (utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica() != null)
				builder.queryParam("id-impresa", utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica());
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
			throw new Exception("Errore recupero controllo disponibile", e);
		} catch (Exception e) {
			log.error("Errore recupero controllo disponibile", e);
			throw new Exception("Errore recupero controllo disponibile", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "getControlliDisponibili - end");
		}
	}

	@Override
	public Integer uploadXMLControlloJWT(Integer codiceImpianto, String tipoControllo, byte[] xml, String token) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "uploadXMLControlloJWT - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/controllo/xml");
			builder.queryParam("codice_impianto", codiceImpianto);
			builder.queryParam("tipo-controllo", tipoControllo);
			builder.queryParam("tokenJWT", token);

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
			log.error("Errore durante l'upload del ree", e);
			throw new Exception("Errore durante l'upload del ree", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "uploadXMLControlloJWT - end");
		}
	}

	@Override
	public Integer modificaControlloJWT(Integer idAllegato, Integer codiceImpianto, String tipoControllo, byte[] xml, String token) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "modificaControlloJWT - start");
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo");
			if (idAllegato != null)
				builder.queryParam("id-allegato", idAllegato);
			builder.queryParam("codice-impianto", codiceImpianto);
			builder.queryParam("tipo-controllo", tipoControllo);
			builder.queryParam("tokenJWT", token);

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
			throw new Exception("Errore durante la modifica del ree", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "modificaControlloJWT - end");
		}
	}

	@Override
	public void uploadReeFirmato(Integer idAllegato, byte[] ree, String fileName, String contentType, Integer idPersonaGiuridica, String piva, String ruolo) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "uploadReeFirmato - start");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/ree-firmato");
			builder.queryParam("id-allegato", idAllegato);
			builder.queryParam("ruolo", ruolo);
			if (idPersonaGiuridica != null)
				builder.queryParam("id-impresa", idPersonaGiuridica);
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
			log.error("Errore durante l'upload del ree", e);
			throw new Exception("Errore durante l'upload del ree", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "uploadReeFirmato - end");
		}
	}

	@Override
	public Esito deleteControllo(Integer idAllegato, Integer idPersonaGiuridica, String piva, String ruolo) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "deleteControllo - start");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo");
			builder.queryParam("id-allegato", idAllegato);
			builder.queryParam("ruolo", ruolo);
			if (idPersonaGiuridica != null)
				builder.queryParam("id-impresa", idPersonaGiuridica);
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
			throw new Exception("Errore durante la cancellazione del controllo", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "deleteControllo - end");
		}
	}

	@Override
	public Esito delComponente(String codiceImpianto, String tipo, Integer progressivo, String cf) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "delComponente - start");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/comp");
			builder.queryParam("codice-impianto", codiceImpianto);
			builder.queryParam("tipo", tipo);
			builder.queryParam("progressivo", progressivo);
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
			throw new Exception("Errore durante la cancellazione del componente", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "delComponente - end");
		}
	}

	@Override
	public Esito inviaREE(Integer idAllegato, Integer idPersonaGiuridica, String cfutenteLoggato, RuoloLoggato ruoloLoggato) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "inviaREE - start");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/controllo/invia");
			builder.queryParam("id-allegato", idAllegato);
			builder.queryParam("ruolo", ruoloLoggato.getRuolo());
			if (idPersonaGiuridica != null)
				builder.queryParam("id-impresa", idPersonaGiuridica);
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
			throw new Exception("Errore durante l'invio del ree", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "inviaREE - end");
		}
	}

	@Override
	public Esito consolidaLibretto(String codiceImpianto, UtenteLoggato utenteLoggato) throws Exception {
		log.info(Constants.CITSERVICE_LOG + "consolidaLibretto - start");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/libretto/consolida");
			builder.queryParam("codice-impianto", codiceImpianto);
			if (utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica() != null)
				builder.queryParam("id-impresa", utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica());

			if (utenteLoggato.getRuoloLoggato().getRuolo() != null)
				builder.queryParam("ruolo", utenteLoggato.getRuoloLoggato().getRuolo());

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
			throw new Exception("Errore durante il consolidamento del libretto", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "consolidaLibretto - end");
		}
	}
	@Override
	public void ping() throws Exception {
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
			throw new Exception("Errore durante il ping al servizio", e);
		} finally {
			log.info(Constants.CITSERVICE_LOG + "ping - end");
		}
	}
}
