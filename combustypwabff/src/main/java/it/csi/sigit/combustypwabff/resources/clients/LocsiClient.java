package it.csi.sigit.combustypwabff.resources.clients;

import it.csi.sigit.combustypwabff.model.locsi.LoccsiModel;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("")
@RegisterRestClient(configKey = "locsi")
public interface LocsiClient {

    @GET
    @Path("/suggest")
    @Produces(MediaType.APPLICATION_JSON)
    List<LoccsiModel> suggest(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("q") String indirizzo);
}
