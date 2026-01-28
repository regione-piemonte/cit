package it.csi.sigit.combustypwabff.resources;

import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.utils.Constants;
import it.doqui.index.ecmengine.mtom.Attachment;
import it.doqui.index.ecmengine.mtom.StreamingService;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.mail.util.ByteArrayDataSource;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.Logger;
import org.eclipse.microprofile.config.ConfigProvider;

import java.util.HashMap;

@ApplicationScoped
public class MtomResource {

    public static final String INDEX_USER = "admin@sigit";
    public static final String INDEX_SECRET = "sigit";
    public static final String INDEX_REPOSITORY = "primary";
    public static final String INDEX_PREFIX_NAME = "cm:content";

    protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_NAME);

//    @CXFClient("mtom")
//    StreamingService mtomService;

    public String directUploadMethod(byte[] file, String fileName, String uidIndex) throws CombustyPwaBffException {

        logger.info("directUploadMethod - START");

        Attachment attachment = new Attachment();

        logger.info("directUploadMethod - passo 1");

        attachment.setFileName(fileName);

        logger.info("directUploadMethod - passo 2");

        attachment.setFileType("application/xml");

        logger.info("directUploadMethod - passo 3");

        DataSource ds = new ByteArrayDataSource(file, "application/xml");

        logger.info("directUploadMethod - passo 4");

        attachment.setAttachmentDataHandler(new DataHandler(ds));

        try {

            logger.info("directUploadMethod - passo 5");

        	return getMtomService().directUploadMethod(attachment, INDEX_USER, INDEX_SECRET, INDEX_REPOSITORY, uidIndex, INDEX_PREFIX_NAME);
        } catch (Exception e) {
            logger.error("Errore directUploadMethod", e);
            throw new CombustyPwaBffException(500, "Errore directUploadMethod");
        }
        finally {
            logger.info("directUploadMethod - STOP");
		}

    }

    private static StreamingService getMtomService() {

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(StreamingService.class);
        factory.setAddress(ConfigProvider.getConfig().getValue("quarkus.cxf.client.mtom.client-endpoint-url", String.class));

        HashMap<String, Object> factoryProperties = new HashMap<String, Object>();
        factoryProperties.put("mtom-enabled", Boolean.TRUE);
        factory.setProperties(factoryProperties);

        return (StreamingService) factory.create();
    }

}
