package it.csi.citpwa.business.service.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.csi.citpwa.business.service.IIspezioneService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.*;
import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.util.Constants;
import it.csi.citpwa.util.JWTUtil;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.Exception;

@Service
public class IspezioneServiceImpl implements IIspezioneService {

    @Value("${CIT_URL}")
    private String citUrl;

    private final static String getElencoIspezioniUrl = "/ispezione/getElencoIspezioni";

    private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

    @Override
    public  List<IspezioneDetail> getIspezioni(IspezioneDetail ispezioneDetail) throws Exception {
        log.info(Constants.ISPEZIONESERVICE_LOG + "getIspezioni - start");
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + getElencoIspezioniUrl);
            if(ispezioneDetail.getFkVerifica()!=null) {
                builder.queryParam("id_verifica", ispezioneDetail.getFkVerifica());
            }
            if(ispezioneDetail.getFkAccertamento()!=null) {
                builder.queryParam("id_accertamento", ispezioneDetail.getFkAccertamento());
            }
            String urlTemplate = builder.build().toUriString();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
            HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(ispezioneDetail), headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

            return objectMapper.readValue(response.getBody(),  new TypeReference<List<IspezioneDetail>>(){});

        } catch (HttpClientErrorException e) {
            manageHttpClientErrorException(e);
        } finally {
            log.info(Constants.ISPEZIONESERVICE_LOG + "getIspezioni - end");
        }
        return null;
    }

    @Override
    public IspezioneDetail getIspezione(Integer id) throws Exception {
        log.info(Constants.ISPEZIONESERVICE_LOG + "getDettaglioIspezione - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/ispezione/getDettaglioIspezione");
            if(id!=null) {
                builder.queryParam("id_ispezione_2018", id);
            }
            String urlTemplate = builder.build().toUriString();

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return  objectMapper.readValue(response.getBody(), IspezioneDetail.class);

        } catch (HttpClientErrorException e) {
            manageHttpClientErrorException(e);
        } finally {
            log.info(Constants.ISPEZIONESERVICE_LOG + "getDettaglioIspezione - end");
        }
        return null;
    }

    @Override
    public String downloadCopertinaIspezione(Integer idIspezione2018, UtenteLoggato utenteLoggato) {
        var token = JWTUtil.generaTokenFruitoreInterno(utenteLoggato.getPfLoggato().getCodiceFiscalePF(), null);

        return new RestTemplate().getForObject(citUrl + "/impianto/copertinaIspezione?idIspezione={0}&tokenJWT={1}",
                String.class, idIspezione2018, token.getToken());
    }

    @Override
    public String downloadLetteraAvviso(Integer idIspezione2018, UtenteLoggato utenteLoggato) {
        var token = JWTUtil.generaTokenFruitoreInterno(utenteLoggato.getPfLoggato().getCodiceFiscalePF(), null);

        return new RestTemplate().getForObject(citUrl + "/impianto/letteraAvviso?idIspezione={0}&tokenJWT={1}",
                String.class, idIspezione2018, token.getToken());
    }

    @Override
    public String downloadLetteraAvviso180Gg(Integer idIspezione2018, UtenteLoggato utenteLoggato) {
        var token = JWTUtil.generaTokenFruitoreInterno(utenteLoggato.getPfLoggato().getCodiceFiscalePF(), null);

        return new RestTemplate().getForObject(citUrl + "/impianto/letteraAvviso180Gg?idIspezione={0}&tokenJWT={1}",
                String.class, idIspezione2018, token.getToken());
    }

    @Override
    public String downloadFileExcel(DownloadFileExcelRequest downloadFileExcelRequest, UtenteLoggato utenteLoggato) throws Exception {
        var body = new ObjectMapper().writeValueAsString(downloadFileExcelRequest);

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var entity = new HttpEntity<>(body, headers);

        var token = JWTUtil.generaTokenFruitoreInterno(utenteLoggato.getPfLoggato().getCodiceFiscalePF(), null);

        return new RestTemplate().exchange(citUrl + "/impianto/fileExcel?tokenJWT={0}", HttpMethod.POST,
                entity, String.class, token.getToken()).getBody();
    }

    @Override
    public List<StatoIspezione> getStatoIspezione() throws Exception  {
        log.info(Constants.ISPEZIONESERVICE_LOG + "getStatoIspezione - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/ispezione/getStatoIspezione");
            String urlTemplate = builder.build().toUriString();

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            return  objectMapper.readValue(response.getBody(),  new TypeReference<List<StatoIspezione>>(){});

        } catch (HttpClientErrorException e) {
            manageHttpClientErrorException(e);
        } finally {
            log.info(Constants.CITSERVICE_LOG + "getStatoIspezione - end");
        }
        return null;
    }

    @Override
    public String setIspezione(IspezioneDetail ispezioneDetail, UtenteLoggato utenteLoggato) throws Exception{
        log.info(Constants.ISPEZIONESERVICE_LOG + "setIspezione - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/ispezione/setIspezione");
            if(ispezioneDetail.getFkVerifica()!=null) {
                builder.queryParam("id_verifica", ispezioneDetail.getFkVerifica());
            }
            if(ispezioneDetail.getFkAccertamento()!=null) {
                builder.queryParam("id_accertamento", ispezioneDetail.getFkAccertamento());
            }
            String urlTemplate = builder.build().toUriString();


            Ispezione ispezione = new Ispezione();
            DatiIspezione datiIspezione = new DatiIspezione();
            datiIspezione.setIdIspezione2018(ispezioneDetail.getIdIspezione2018());
            datiIspezione.setCodiceImpianto(ispezioneDetail.getCodiceImpianto());
            datiIspezione.setFkStatoIspezione(BigDecimal.ONE);
            datiIspezione.setFlgIspPagamento(ispezioneDetail.getFlgIspPagamento());
            datiIspezione.setNote(ispezioneDetail.getNote());
            datiIspezione.setNoteSveglia(ispezioneDetail.getNoteSveglia());
            datiIspezione.setNote(ispezioneDetail.getNote());
            datiIspezione.setDtSveglia(ispezioneDetail.getDtSveglia());
            datiIspezione.setCfIspettoreSecondario(ispezioneDetail.getCfIspettoreSecondario());
            datiIspezione.setIstatComuneCompetenza(ispezioneDetail.getIstatComuneCompetenza());
            datiIspezione.setIstatProvCompetenza(ispezioneDetail.getIstatProvCompetenza()); 
            //datiIspezione.setEmpty(true);
            ispezione.setDatiIspezione(datiIspezione);

            ispezione.setUtenteLoggato(utenteLoggato);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
            HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(ispezione), headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

            return  objectMapper.readValue(response.getBody(),  String.class);

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "setIspezione - end");
        }
        return null;
    }

    @Override
    public String assegna(IspezioneDetail ispezioneDetail, UtenteLoggato utenteLoggato) throws Exception{
        log.info(Constants.ISPEZIONESERVICE_LOG + "assegna - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/ispezione/assegnaIspezione");

            if(ispezioneDetail.getIdIspezione2018()!=null) {
              builder.queryParam("id_ispezione_2018", ispezioneDetail.getIdIspezione2018());
            }

            String urlTemplate = builder.build().toUriString();

            Ispezione ispezione = new Ispezione();
            Persona persona = new Persona();
            persona.setCodiceFiscale(ispezioneDetail.getCfUtenteAssegn());
            ispezione.setPersona(persona);

            ispezione.setUtenteLoggato(utenteLoggato);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
            HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(ispezione), headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

            return  response.getBody();

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "assegna - end");
        }
        return null;
    }

    @Override
    public String concludi(IspezioneDetail ispezioneDetail, UtenteLoggato utenteLoggato) throws Exception{
        log.info(Constants.ISPEZIONESERVICE_LOG + "concludi - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/ispezione/concludiIspezione");
            String urlTemplate = builder.build().toUriString();

            Ispezione ispezione = new Ispezione();
            DatiIspezione datiIspezione = new DatiIspezione();
            datiIspezione.setIdIspezione2018(ispezioneDetail.getIdIspezione2018());
            datiIspezione.setEnteCompetente(ispezioneDetail.getEnteCompetente());
            datiIspezione.setFlgEsito(ispezioneDetail.getFlgEsito());
            datiIspezione.setNote(ispezioneDetail.getNote());
            ispezione.setDatiIspezione(datiIspezione);

            ispezione.setUtenteLoggato(utenteLoggato);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
            HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(ispezione), headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

            return  response.getBody();

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }else if(e instanceof HttpServerErrorException){
                manageHttpClientErrorException((HttpServerErrorException) e);
            }else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "concludi - end");
        }
        return null;
    }

    @Override
    public String assegnaImpianto(IspezioneDetail ispezioneDetail, UtenteLoggato user) throws Exception {
        log.info(Constants.ISPEZIONESERVICE_LOG + "assegnaImpianto - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/ispezione/assegnaImpiantoIspezione");

            if(ispezioneDetail.getIdIspezione2018()!=null) {
                builder.queryParam("id_ispezione_2018", ispezioneDetail.getIdIspezione2018());
            }

            if(ispezioneDetail.getCodiceImpianto()!=null) {
                builder.queryParam("codice_impianto", ispezioneDetail.getCodiceImpianto());
            }

            String urlTemplate = builder.build().toUriString();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
            HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(user), headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

            return  response.getBody();

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "assegnaImpianto - end");
        }
        return null;
    }

    @Override
    public String annulla(BigDecimal id, UtenteLoggato user) throws Exception {
        log.info(Constants.ISPEZIONESERVICE_LOG + "annulla - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/ispezione/annullaIspezione");
            String urlTemplate = builder.build().toUriString();

            Ispezione ispezione = new Ispezione();
            DatiIspezione datiIspezione = new DatiIspezione();
            datiIspezione.setIdIspezione2018(id);
            ispezione.setDatiIspezione(datiIspezione);
            ispezione.setUtenteLoggato(user);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
            HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(ispezione), headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

            return  response.getBody();

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "annulla - end");
        }
        return null;
    }

    private String getStringFromBigDecimalArray(BigDecimal[] bda){
        StringBuilder sb = new StringBuilder();
        for (BigDecimal bd : bda){
            sb.append(bd).append(",");
        }
        String sbStr = sb.toString();
        return sbStr.substring(0,sbStr.length()-1);
    }
    @Override
    public String setIspezioneMassiva(IspezioneMassiva ispezioneMassiva, UtenteLoggatoModel user) throws Exception {
        log.info(Constants.ISPEZIONESERVICE_LOG + "setIspezioneMassiva - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/verifiche/setVerificaMassiva");
            if(ispezioneMassiva.getFlgIspPagamento()!=null) {
                builder.queryParam("flg_isp_pagamento", ispezioneMassiva.getFlgIspPagamento());
            }
            String urlTemplate = builder.build().toUriString();

            VerificaMassiva verificaMassiva = new VerificaMassiva();
            Verifica verifica = new Verifica();
            if(ispezioneMassiva.getFkTipoVerifica()!=null) {
                verifica.setTipoVerifica(ispezioneMassiva.getFkTipoVerifica().intValue());
                if(new BigDecimal(1).equals(ispezioneMassiva.getFkTipoVerifica())){
                    if(ispezioneMassiva.getCodiceImpianto()!=null) {
                        verifica.setCodiceImpianto(getStringFromBigDecimalArray(ispezioneMassiva.getCodiceImpianto()));
                    }
                }
                if(new BigDecimal(4).equals(ispezioneMassiva.getFkTipoVerifica())){
                    if(ispezioneMassiva.getFkDatoDistrib()!=null) {
                        verifica.setIdDatoDistributore(getStringFromBigDecimalArray(ispezioneMassiva.getFkDatoDistrib()));
                    }
                }
            }

            verificaMassiva.setVerifica(verifica);
            verificaMassiva.setUtenteLoggatoModel(user);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType(Constants.CITSERVICE_MEDIA_TYPE, "json", StandardCharsets.UTF_8));
            HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(verificaMassiva), headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, String.class);

            return response.getBody();

        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                manageHttpClientErrorException((HttpClientErrorException) e);
            }if(e instanceof HttpServerErrorException) {
                manageHttpClientErrorException((HttpServerErrorException) e);
            } else{
                throw e;
            }
        } finally {
            log.info(Constants.CITSERVICE_LOG + "setIspezioneMassiva - end");
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

    @Override
    public Object setAzione(DatiAzione datiAzione) throws SvistaException, IOException {

        log.info(Constants.CITSERVICE_LOG + "setAzione - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/azione/ispezione/setAzione");
            String urlTemplate = builder.build().toUriString();

            UtenteLoggato utenteLoggato = new UtenteLoggato();
            utenteLoggato.setPfLoggato(new PFLoggato());
            utenteLoggato.getPfLoggato().setCodiceFiscalePF(datiAzione.getCfUtenteAzione());

            DocumentoPwa documentoPwa = new DocumentoPwa();
            documentoPwa.setMimeType(datiAzione.getDocContentType());
            documentoPwa.setDoc(datiAzione.getDocBase64());
            documentoPwa.setTipoDocumento("azione_ispezione");
            documentoPwa.setNome(datiAzione.getNomeDocOriginale());

            Azione azione = new Azione();
            azione.setCfUtenteAzione(datiAzione.getCfUtenteAzione());
            if(datiAzione.getIdVerifica()!=null) {
                azione.setFkAzione(datiAzione.getIdVerifica().intValue());
            }
            if(datiAzione.getIdIspezione2018()!=null) {
                azione.setFkAzione(datiAzione.getIdIspezione2018().intValue());
            }
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
    public Object getAzione(Integer idIspezione2018, UtenteLoggato utenteLoggato) throws SvistaException , IOException {
        log.info(Constants.CITSERVICE_LOG + "getAzione - start");
        try {

            List<SigitTAzione> listSigitTAzione = getSigitTAzione(idIspezione2018, utenteLoggato);

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

    private List<SigitTAzione> getSigitTAzione(Integer idIspezione2018, UtenteLoggato utenteLoggato) throws JsonProcessingException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/azione/getAzione");
        builder.queryParam("id_ispezione_2018", idIspezione2018);
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
    public Object getIspettore() throws IOException  {

        log.info(Constants.CITSERVICE_LOG + "getIspettore - start");
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(citUrl + "/ispezione/getIspettore");
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
            log.info(Constants.CITSERVICE_LOG + "getIspettore - end");
        }
        return null;


    }
}
