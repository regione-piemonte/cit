package it.csi.citpwa.business.service.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.csi.citpwa.business.service.IRapProvaService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.DatiRapProva;
import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.ws.rs.NotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class RapProvaServiceImpl implements IRapProvaService {

    @Value("${CIT_URL}")
    private String citUrl;

    private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

    @Override
    public List<DatiRapProva> getRapProva(DatiRapProva datiRapProva, String ordinamento) throws SvistaException, IOException {

        log.info(Constants.ISPEZIONESERVICE_LOG + "getRapProva - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/rapProva/getRapProva");
            if(datiRapProva.getCodiceImpianto()!=null) {
                builder.queryParam("codice_impianto", datiRapProva.getCodiceImpianto());
            }
            if(datiRapProva.getIdIspezione2018()!=null) {
                builder.queryParam("id_ispezione_2018", datiRapProva.getIdIspezione2018());
            }
            builder.queryParam("ordinamento", ordinamento);
            String urlTemplate = builder.build().toUriString();

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            return  objectMapper.readValue(response.getBody(),  new TypeReference<List<DatiRapProva>>(){});

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }if(e instanceof HttpServerErrorException) {
                manageHttpClientErrorException((HttpServerErrorException) e);
            } else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "getRapProva - end");
        }
        return null;

    }

    @Override
    public void setRapProva(RapportoDiProva rapportoDiProva) throws SigitExtException, IOException  {

        log.info(Constants.ISPEZIONESERVICE_LOG + "setRapProva - start");
        try {

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/rapProva/setRapProva");
            String urlTemplate = builder.build().toUriString();

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String json = objectMapper.writeValueAsString(rapportoDiProva);

            HttpEntity<String> entity = new HttpEntity<>(json, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }if(e instanceof HttpServerErrorException) {
                manageHttpClientErrorException((HttpServerErrorException) e);
            } else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "setRapProva - end");
        }

    }

    @Override
    public void inviaRapProva(Boolean conferma, BigDecimal idAllegato, BigDecimal codiceImpianto, UtenteLoggato user) throws SigitExtException, IOException  {

        log.info(Constants.ISPEZIONESERVICE_LOG + "inviaRapProva - start");
        try {

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/rapProva/inviaRapProva");
            builder.queryParam("conferma",conferma);
            builder.queryParam("id_allegato",idAllegato);
            builder.queryParam("codice_impianto",codiceImpianto);
            String urlTemplate = builder.build().toUriString();

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String json = objectMapper.writeValueAsString(user);

            HttpEntity<String> entity = new HttpEntity<>(json, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }if(e instanceof HttpServerErrorException) {
                manageHttpClientErrorException((HttpServerErrorException) e);
            } else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "inviaRapProva - end");
        }

    }

    @Override
    public void deleteRapProva(Boolean conferma, BigDecimal idAllegato, BigDecimal idIspezione2018, UtenteLoggato user) throws SvistaException, IOException{

        log.info(Constants.ISPEZIONESERVICE_LOG + "deleteRapProva - start");
        try {

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/rapProva/deleteRapProva");
            builder.queryParam("conferma",conferma);
            builder.queryParam("id_allegato",idAllegato);
            builder.queryParam("id_ispezione_2018",idIspezione2018);
            String urlTemplate = builder.build().toUriString();

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String json = objectMapper.writeValueAsString(user);

            HttpEntity<String> entity = new HttpEntity<>(json, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }if(e instanceof HttpServerErrorException) {
                manageHttpClientErrorException((HttpServerErrorException) e);
            } else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "deleteRapProva - end");
        }

    }

    @Override
    public RapProvaWeb getRapProvaWeb(BigDecimal idAllegato, BigDecimal fkTipoDocumento) throws SvistaException, IOException {

        log.info(Constants.ISPEZIONESERVICE_LOG + "getRapProva - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/rapProva/getRapProvaWeb");
            builder.queryParam("id_allegato", idAllegato);
            builder.queryParam("fk_Tipo_Documento", fkTipoDocumento);

            String urlTemplate = builder.build().toUriString();

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return  objectMapper.readValue(response.getBody(),  RapProvaWeb.class);

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }if(e instanceof HttpServerErrorException) {
                manageHttpClientErrorException((HttpServerErrorException) e);
            } else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "getRapProva - end");
        }
        return null;

    }

    @Override
    public Esito setRapProvaWeb(RapProvaWeb rapProvaWeb) throws SvistaException, IOException{

        log.info(Constants.ISPEZIONESERVICE_LOG + "setRapProvaWeb - start");
        try {

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/rapProva/setRapProvaWeb");
            String urlTemplate = builder.build().toUriString();

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String json = objectMapper.writeValueAsString(rapProvaWeb);

            HttpEntity<String> entity = new HttpEntity<>(json, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

            return objectMapper.readValue(response.getBody(), Esito.class);

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
            	log.error("Errore durante l'esecuzione del metodo setRapProvaWeb (client):", e);
                manageHttpClientErrorException((HttpClientErrorException) e);
            }if(e instanceof HttpServerErrorException) {
            	log.error("Errore durante l'esecuzione del metodo setRapProvaWeb (server):", e);
                manageHttpClientErrorException((HttpServerErrorException) e);
            } else{
            	log.error("Errore durante l'esecuzione del metodo setRapProvaWeb (server):", e);
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "setRapProvaWeb - end");
        }

        return null;
    }

    @Override
    public FileBase64 getPDFRapProva(Boolean firmato, BigDecimal idAllegato, UtenteLoggato user) throws SigitExtException, IOException {

        log.info(Constants.ISPEZIONESERVICE_LOG + "getRapProva - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/rapProva/getPDFRapProva");
            builder.queryParam("id_allegato", idAllegato);
            builder.queryParam("firmato", firmato);

            String urlTemplate = builder.build().toUriString();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String json = objectMapper.writeValueAsString(user);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
            HttpEntity<String> entity = new HttpEntity<>(json, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

            return objectMapper.readValue(response.getBody(), FileBase64.class);

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }if(e instanceof HttpServerErrorException) {
                manageHttpClientErrorException((HttpServerErrorException) e);
            } else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "getRapProva - end");
        }
        return null;

    }

    @Override
    public Esito updatePDFFirmatoRapProva(RapProvaWeb rapProvaWeb) throws SigitExtException, IOException {

        log.info(Constants.ISPEZIONESERVICE_LOG + "updatePDFFirmatoRapProva - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/rapProva/updatePDFFirmatoRapProva");

            String urlTemplate = builder.build().toUriString();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String json = objectMapper.writeValueAsString(rapProvaWeb);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
            HttpEntity<String> entity = new HttpEntity<>(json, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

            return  objectMapper.readValue(response.getBody(), Esito.class);

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }if(e instanceof HttpServerErrorException) {
                manageHttpClientErrorException((HttpServerErrorException) e);
            } else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "updatePDFFirmatoRapProva - end");
        }
        return null;

    }

    @Override
    public Esito setScansioneRapProva(RapProvaWeb rapProvaWeb) throws SigitExtException, IOException {

        log.info(Constants.ISPEZIONESERVICE_LOG + "setScansioneRapProva - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/rapProva/setScansioneRapProva");

            String urlTemplate = builder.build().toUriString();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String json = objectMapper.writeValueAsString(rapProvaWeb);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
            HttpEntity<String> entity = new HttpEntity<>(json, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

            return objectMapper.readValue(response.getBody(), Esito.class);

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }if(e instanceof HttpServerErrorException) {
                manageHttpClientErrorException((HttpServerErrorException) e);
            } else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "setScansioneRapProva - end");
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

    private static void manageHttpClientErrorException(HttpServerErrorException e) throws IOException {
        int responseCode = e.getStatusCode().value();
        if (responseCode == 404) {
            throw new NotFoundException();
        } else {
            ObjectMapper mapper = new ObjectMapper();
            Esito esito = mapper.readValue(e.getResponseBodyAsByteArray(), Esito.class);
            throw new SigitExtException(esito.getDescrizioneEsito());
        }
    }


}
