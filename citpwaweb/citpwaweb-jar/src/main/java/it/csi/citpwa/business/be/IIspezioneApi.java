package it.csi.citpwa.business.be;


import it.csi.citpwa.model.*;
import it.csi.citpwa.model.sigitext.DownloadFileExcelRequest;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.math.BigDecimal;

@Path("/ispezione")
@Produces({ "application/json" })
public interface IIspezioneApi {

    @POST
    @Path("/getIspezioni")
    @Produces({"application/json"})
    Response getIspezioni(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest,@RequestBody IspezioneDetail ispezioneDetail);

    @GET
    @Path("/getIspezione")
    @Produces({"application/json"})
    Response getIspezione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id") Integer id);

    @GET
    @Path("/copertinaIspezione")
    @Produces({"application/json"})
    Response downloadCopertinaIspezione(@QueryParam("idIspezione2018") Integer idIspezione2018, @Context HttpServletRequest req) throws Exception;

    @GET
    @Path("/letteraAvviso")
    @Produces({"application/json"})
    Response downloadLetteraAvviso(@QueryParam("idIspezione2018") Integer idIspezione2018, @Context HttpServletRequest req) throws Exception;

    @GET
    @Path("/letteraAvviso180Gg")
    @Produces({"application/json"})
    Response downloadLetteraAvviso180Gg(@QueryParam("idIspezione2018") Integer idIspezione2018, @Context HttpServletRequest req) throws Exception;

    @POST
    @Path("/fileExcel")
    @Produces({"application/json"})
    Response downloadFileExcel(@RequestBody DownloadFileExcelRequest downloadFileExcelRequest, @Context HttpServletRequest req) throws Exception;

    @GET
    @Path("/getStatoIspezione")
    @Produces({"application/json"})
    Response getStatoIspezione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

    @POST
    @Path("/setIspezione")
    @Produces({"application/json"})
    Response setIspezione(@RequestBody IspezioneDetail ispezioneDetail, @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

    @POST
    @Path("/assegna")
    @Produces({"application/json"})
    Response assegna(@RequestBody IspezioneDetail ispezioneDetail, @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

    @POST
    @Path("/concludi")
    @Produces({"application/json"})
    Response concludi(@RequestBody IspezioneDetail ispezioneDetail, @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

    @POST
    @Path("/assegnaImpianto")
    @Produces({"application/json"})
    Response assegnaImpianto(@RequestBody IspezioneDetail ispezioneDetail, @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

    @POST
    @Path("/annulla")
    @Produces({"application/json"})
    Response annulla(@QueryParam("id") BigDecimal id, @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

    @GET
    @Path("/getAzione")
    @Produces({"application/json"})
    Response getAzione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id") Integer idIspezione2018, @QueryParam("codice_fiscale") String codiceFiscalePF);

    @POST
    @Path("/setAzione")
    @Produces({"application/json"})
    Response setAzione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody DatiAzione datiAzione);

    @GET
    @Path("/getIspettore")
    @Produces({"application/json"})
    Response getIspettore(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

}