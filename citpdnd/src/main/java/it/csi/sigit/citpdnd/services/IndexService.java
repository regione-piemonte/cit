package it.csi.sigit.citpdnd.services;

import it.csi.sigit.citpdnd.entities.SigitLibretto;
import it.csi.sigit.citpdnd.exception.CitpdndException;
import it.csi.sigit.citpdnd.services.client.IndexRestClient;
import it.csi.sigit.citpdnd.services.client.TokenRestClient;
import it.csi.sigit.citpdnd.utils.Constants;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.log4j.Logger;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class IndexService {

    protected static final Logger log = Logger.getLogger(Constants.APPLICATION_NAME);

    protected static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    protected static final String CLIENT_CREDENTIALS = "client_credentials";
    protected static final String CONTENT_PROPERTY_NAME = "cm:content";

    @Inject
    @RestClient
    TokenRestClient tokenRestClient;

    @Inject
    @RestClient
    IndexRestClient indexRestClient;

    @Inject
    @ConfigProperty(name = "token.client-id")
    String clientId;

    @Inject
    @ConfigProperty(name = "token.secret")
    String clientSecret;

    @Inject
    @ConfigProperty(name = "index.tenant")
    String indexTenant;

    @Inject
    @ConfigProperty(name = "index.key64")
    String indexKey64;

    public byte[] getLibrettoPdf(SigitLibretto libretto) throws CitpdndException {

        byte[] librettoDoc = new byte[0];
        try {
            String tokenBearer = "Bearer " + tokenRestClient.getToken(CONTENT_TYPE, CLIENT_CREDENTIALS, clientId, clientSecret).getAccess_token();
            librettoDoc = indexRestClient.getIndexNodeContent(tokenBearer, indexKey64, indexTenant, libretto.getUidIndex(), CONTENT_PROPERTY_NAME);

        } catch (Exception e) {
            log.error("ImpiantiDao.getLibrettoByCodiceImpianto - " + e.getMessage(), e);
            throw new CitpdndException("06", Constants.ERROR_MESSAGE_CODE_06);
        }

        return librettoDoc;
    }
}
