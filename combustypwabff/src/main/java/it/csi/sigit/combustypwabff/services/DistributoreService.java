package it.csi.sigit.combustypwabff.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.csi.sigit.combustypwabff.bff.dto.*;
import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.model.sigitext.SigitextDataFile;
import it.csi.sigit.combustypwabff.resources.MtomResource;
import it.csi.sigit.combustypwabff.resources.SigitextResource;
import it.csi.sigit.combustypwabff.utils.Constants;
import it.csi.sigit.combustypwabff.utils.DocXmlExt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;

import java.math.BigDecimal;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DistributoreService {

    @Inject
    SigitextResource sigitextResource;

    @Inject
    MtomResource mtomResource;

    protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_NAME);

    public Ruoli getRuoliDistributore(String cf, String cognome, String nome) throws CombustyPwaBffException {

        return sigitextResource.getRuoliDistributore(cf, cognome, nome);
    }

    public Response getDettaglioDatiDistributoreJson(Integer idPersonaGiuridica, String anno, String mese, String tipoCaricamento, String statoFile) throws CombustyPwaBffException {

        return sigitextResource.getDettaglioDatiDistributoreJson(idPersonaGiuridica, anno, mese, tipoCaricamento, statoFile);
    }

    public Esito setDatiDistributoreSemplificatoJson(ImportDatiDistributore importDatiDistributore, Integer idPersonaGiuridica, String piva, String cf) throws CombustyPwaBffException {

        return sigitextResource.setDatiDistributoreSemplificatoJson(importDatiDistributore, idPersonaGiuridica, piva, cf);
    }

    public Esito annullaAcquisizioneDatoDistributore(String cf, Integer idID) throws CombustyPwaBffException {

        return sigitextResource.annullaAcquisizioneDatoDistributore(cf, idID);
    }

    public Response uploadXMLDistributoreJWT(DocXml docXml, String userCf, Integer idPersonaGiuridica, Boolean sost, Integer idID, String jwt) throws CombustyPwaBffException {

        return sigitextResource.uploadXMLDistributoreJWT(docXml, userCf, idPersonaGiuridica, sost, idID, jwt);
    }

    /*
    public Response uploadXMLDistributoreMtomJWT(DocXml docXml, String userCf, Integer idPersonaGiuridica, Boolean sost, Integer idID, String jwt) throws CombustyPwaBffException {

    	logger.info("uploadXMLDistributoreMtomJWT - START");
        //byte[] file = docXml.getFile();
        byte[] file = null;
        try {
            file = FileUtils.readFileToByteArray(docXml.getFile());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            // errore
        }
        checkDimensioneFileDistrib(file);

        it.csi.sigit.combustypwabff.utils.DocXmlExt docXmlExt = new it.csi.sigit.combustypwabff.utils.DocXmlExt();
        docXmlExt.setNomeFile(docXml.getNomeFile());
        docXmlExt.setDataUpload(docXml.getDataUpload());
        docXmlExt.setUidIndex(docXml.getUidIndex());
        docXmlExt.setDescrizione(docXml.getDescrizione());

        docXmlExt.setFile(new byte[0]);
        SigitextDataFile dataFile = sigitextResource.preUploadXMLDistributoreJWT(docXmlExt, userCf, idPersonaGiuridica, sost, idID, jwt);

        logger.info("uploadXMLDistributoreMtomJWT - eseguito preUploadXMLDistributoreJWT");

        String esitoUploadMtom = mtomResource.directUploadMethod(file, dataFile.getNomeFileMod(), dataFile.getUidIndex());
        logger.info("uploadXMLDistributoreMtomJWT - Esito upload mtom: " + esitoUploadMtom);

    	logger.info("uploadXMLDistributoreMtomJWT - STOP");
    	
        return sigitextResource.postUploadXMLDistributoreJWT(dataFile.getIdImport(), dataFile.getUidIndex());
    }
	*/
    
    public Response uploadXMLDistributoreMtomJWT(MultipartFormDataInput input, String userCf, Integer idPersonaGiuridica, Boolean sost, Integer idID, String jwt) throws CombustyPwaBffException {

    	logger.info("uploadXMLDistributoreMtomJWT - START");

        try
        {

            // Ottieni tutte le parti del form
            Map<String, List<InputPart>> formParts = input.getFormDataMap();

            // Supponiamo che il file sia nel campo "file"
            List<InputPart> fileParts = formParts.get("file");
            if (fileParts != null && !fileParts.isEmpty()) {
                InputPart filePart = fileParts.get(0);

                // Ottieni lo stream del file
                InputStream inputStream = filePart.getBody(InputStream.class, null);

                // Converti in byte[]
                byte[] fileBytes = inputStream.readAllBytes();

                // Ora hai il file in memoria come byte[]
                logger.info("uploadXMLDistributoreMtomJWT - File size in bytes: " + fileBytes.length);

                // Puoi farci quello che vuoi (salvare altrove, elaborare, etc.)
                logger.info("uploadXMLDistributoreMtomJWT - File ricevuto con successo. Dimensione: " + fileBytes.length + " bytes.");

                checkDimensioneFileDistrib(fileBytes);

                it.csi.sigit.combustypwabff.utils.DocXmlExt docXmlExt = new it.csi.sigit.combustypwabff.utils.DocXmlExt();
                docXmlExt.setNomeFile(getValueMultipart(formParts, "nomeFile"));
                docXmlExt.setDataUpload(getValueMultipart(formParts, "dataUpload"));
                docXmlExt.setUidIndex(getValueMultipart(formParts, "uidIndex"));
                docXmlExt.setDescrizione(getValueMultipart(formParts, "descrizione"));

                docXmlExt.setFile(new byte[0]);
                Response preUploadXMLDistributoreJWTResponse = sigitextResource.preUploadXMLDistributoreJWT(docXmlExt, userCf, idPersonaGiuridica, sost, idID, jwt);
                String jsonResponse = preUploadXMLDistributoreJWTResponse.readEntity(String.class);
                ObjectMapper objectMapper = new ObjectMapper();
                SigitextDataFile dataFile = null;
                try {
                    dataFile = objectMapper.readValue(jsonResponse,  new TypeReference<SigitextDataFile>() { });
                } catch (JsonProcessingException e) {
                    try {
                        logger.error("Errore durante la lettura del datafile.",e);
                        Esito esito = objectMapper.readValue(jsonResponse,  new TypeReference<Esito>() { });
                        return preUploadXMLDistributoreJWTResponse;
                    } catch (Exception ee) {
                        logger.error("Errore durante la lettura dell'esito.",e);
                        throw new CombustyPwaBffException(500, "Errore non gestito durante la chiamata del servizio preUploadXxmlDistributoreJWT");
                    }
                }

                logger.info("uploadXMLDistributoreMtomJWT - eseguito preUploadXMLDistributoreJWT");

                String esitoUploadMtom = mtomResource.directUploadMethod(fileBytes, dataFile.getNomeFileMod(), dataFile.getUidIndex());
                logger.info("uploadXMLDistributoreMtomJWT - Esito upload mtom: " + esitoUploadMtom);

                Response postUploadXMLDistributoreJWTResponse = sigitextResource.postUploadXMLDistributoreJWT(dataFile.getIdImport(), dataFile.getUidIndex());
                logger.info("uploadXMLDistributoreMtomJWT - STOP");

                return postUploadXMLDistributoreJWTResponse;

            } else {
                logger.info("Nessun file trovato nel campo 'file'.");

                return null;
            }

        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            logger.info("Errore durante l'elaborazione del file.", e);
            throw new CombustyPwaBffException(500, "Errore durante l'elaborazione del file.");
        }
    }

    private String getValueMultipart(Map<String, List<InputPart>> formParts, String properties)
    {
        try {
            List<InputPart> fileParts = formParts.get(properties);
            if (fileParts != null && !fileParts.isEmpty()) {
                InputPart filePart = fileParts.get(0);
                // Ottieni lo stream del file
                String value = filePart.getBody(String.class, null);
                return value;
            }
        }
        catch (Exception e)
        {
            logger.info("getValueMultipart - eccezione: "+e);
        }
        return null;
    }

    private void checkDimensioneFileDistrib(byte[] bytes) throws CombustyPwaBffException {

        if (bytes == null || bytes.length == 0) {
            throw new CombustyPwaBffException(200, "Attenzione. Il file XML non puo' essere vuoto.");
        }

        BigDecimal max = new BigDecimal(Constants.MAX_FILESIZE_DOC_DISTRIBUTORE_EXT);

        if (bytes.length > max.intValue()) {
            logger.error("Dimesioni file oltre il limite consentito.");
            throw new CombustyPwaBffException(200, "Attenzione. Dimensione del documento non corretta. Ripetere il caricamento.");
        }
        
        logger.info("checkDimensioneFileDistrib - bytes.length: "+bytes.length);
    }

    public Response getDettaglioDatiImportJson(Integer idID) throws CombustyPwaBffException {

        return sigitextResource.getDettaglioDatiImportJson(idID);
    }
}
