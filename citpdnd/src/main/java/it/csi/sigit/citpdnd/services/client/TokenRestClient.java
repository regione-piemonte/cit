package it.csi.sigit.citpdnd.services.client;

import it.csi.sigit.citpdnd.model.TokenModel;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("")
@RegisterRestClient(configKey = "token")
public interface TokenRestClient {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    TokenModel getToken(@HeaderParam("Content-Type") String contentType,
                        @QueryParam("grant_type") String grantType,
                        @QueryParam("client_id") String clientId,
                        @QueryParam("client_secret") String clientSecret);

}
