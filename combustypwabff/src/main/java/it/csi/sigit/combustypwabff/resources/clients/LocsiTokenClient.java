package it.csi.sigit.combustypwabff.resources.clients;

import it.csi.sigit.combustypwabff.model.locsi.LocsiTokenModel;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("")
@RegisterRestClient(configKey = "locsi-token")
public interface LocsiTokenClient {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    LocsiTokenModel getToken(@HeaderParam("Content-Type") String contentType,
                             @QueryParam("grant_type") String grantType,
                             @QueryParam("client_id") String clientId,
                             @QueryParam("client_secret") String clientSecret);

}
