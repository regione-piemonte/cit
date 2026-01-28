package it.csi.sigit.combustypwabff.resources;

import it.csi.sigit.combustypwabff.bff.dto.FeatureModel;
import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.model.locsi.LoccsiFeatureModel;
import it.csi.sigit.combustypwabff.model.locsi.LoccsiModel;
import it.csi.sigit.combustypwabff.resources.clients.LocsiClient;
import it.csi.sigit.combustypwabff.resources.clients.LocsiTokenClient;
import it.csi.sigit.combustypwabff.utils.Constants;
import it.csi.sigit.combustypwabff.utils.MapDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class LocsiResource {

    protected static final Logger log = Logger.getLogger(Constants.APPLICATION_NAME);

    protected static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    protected static final String CLIENT_CREDENTIALS = "client_credentials";

    protected static final String IND_LOCCSI_COMUNI = "ind_loccsi_comuni";
    protected static final String IND_LOCCSI_CIVICI_FULL = "ind_loccsi_civici_bdtre";
    protected static final String IND_LOCCSI_STRADE = "ind_loccsi_strade";
    protected static final String LABEL_LOCCSI_FULL = "FULL";
    protected static final String LABEL_LOCCSI_STRADE = "STRADE";
    protected static final String LABEL_LOCCSI_COMUNI = "COMUNI";

    @Inject
    @RestClient
    LocsiTokenClient locsiTokenClient;

    @Inject
    @RestClient
    LocsiClient locsiClient;

    @Inject
    @ConfigProperty(name = "locsi-token.client-id")
    String clientId;

    @Inject
    @ConfigProperty(name = "locsi-token.secret")
    String clientSecret;

    public List<FeatureModel> getIndirizzoImpianto(String indirizzo) throws CombustyPwaBffException {

        List<FeatureModel> featureModels = new ArrayList<>();
        try {
            String tokenBearer = "Bearer " + locsiTokenClient.getToken(CONTENT_TYPE, CLIENT_CREDENTIALS, clientId, clientSecret).getAccess_token();
            List<LoccsiModel> loccsiModels = locsiClient.suggest(tokenBearer, indirizzo);

            if (loccsiModels != null && !loccsiModels.isEmpty()) {
                for (LoccsiModel loccsiModel : loccsiModels) {
                    switch (loccsiModel.getName()) {
                        case IND_LOCCSI_CIVICI_FULL:
                            for (LoccsiFeatureModel featureModel : loccsiModel.getFeatureCollection().getFeatures()) {
                                featureModel.setType(LABEL_LOCCSI_FULL);
                                featureModels.add(MapDto.maploccsifeatureModelToFeatureModel(featureModel));
                            }
                            break;
                        case IND_LOCCSI_STRADE:
                            for (LoccsiFeatureModel featureModel : loccsiModel.getFeatureCollection().getFeatures()) {
                                featureModel.setType(LABEL_LOCCSI_STRADE);
                                featureModels.add(MapDto.maploccsifeatureModelToFeatureModel(featureModel));
                            }
                            break;
                        case IND_LOCCSI_COMUNI:
                            for (LoccsiFeatureModel featureModel : loccsiModel.getFeatureCollection().getFeatures()) {
                                featureModel.getProperties().setComune(featureModel.getProperties().getLoccsiLabel());
                                featureModel.setType(LABEL_LOCCSI_COMUNI);
                                featureModels.add(MapDto.maploccsifeatureModelToFeatureModel(featureModel));
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (Exception e) {
            log.error("LocsiResource.suggest - Errore durante la chiamata al servizio suggest.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio suggest.");
        }

        return featureModels;
    }

    public List<FeatureModel> getProvinciaImpianto(String indirizzo) throws CombustyPwaBffException {

        List<FeatureModel> featureModels = new ArrayList<>();
        try {
            String tokenBearer = "Bearer " + locsiTokenClient.getToken(CONTENT_TYPE, CLIENT_CREDENTIALS, clientId, clientSecret).getAccess_token();
            List<LoccsiModel> loccsiModels = locsiClient.suggest(tokenBearer, indirizzo);
            if (loccsiModels != null && !loccsiModels.isEmpty()) {
                for (LoccsiModel loccsiModel : loccsiModels) {
                    if (IND_LOCCSI_COMUNI.equals(loccsiModel.getName())) {
                        for (LoccsiFeatureModel featureModel : loccsiModel.getFeatureCollection().getFeatures()) {
                            featureModel.getProperties().setComune(featureModel.getProperties().getLoccsiLabel());
                            featureModel.setType(LABEL_LOCCSI_COMUNI);
                            featureModels.add(MapDto.maploccsifeatureModelToFeatureModel(featureModel));
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("LocsiResource.suggest - Errore durante la chiamata al servizio suggest.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio suggest.");
        }

        return featureModels;
    }
}
