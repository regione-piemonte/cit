package it.csi.sigit.citpdnd.services.client;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("")
@RegisterRestClient(configKey = "index")
public interface IndexRestClient {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/tenants/{tenant}/nodes/{uid}/contents")
    byte[] getIndexNodeContent(@HeaderParam("Authorization") String authorization,
                               @HeaderParam("X-Request-Auth") String xRequestAuth,
                               @PathParam("tenant") String tenant,
                               @PathParam("uid") String uid,
                               @QueryParam("contentPropertyName") String contentPropertyName);

}
