package it.csi.citpwa.business.be;


import it.csi.citpwa.model.*;
import it.csi.citpwa.model.sigitext.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.web.bind.annotation.RequestBody;

@Path("/verifica")
@Produces({ "application/json" })
public interface IVerificaApi {

    @GET
    @Path("/tipoVerifica")
    @Produces({"application/json"})
    Response getTipoVerifica(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

    @GET
    @Path("/getVerifica")
    @Produces({"application/json"})
    Response getVerifica(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id") Integer idVerifica);

    @POST
    @Path("/setVerifica")
    @Produces({"application/json"})
    Response setVerifica(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody VerificaFEModel verifica);



    @POST
    @Path("/getVerifiche")
    @Produces({"application/json"})
    Response getVerifiche(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody RicercaDatiVerificaModel ricercaDatiVerifica);

    @DELETE
    @Path("/delete")
    @Produces({"application/json"})
    Response deleteVerifica(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id") Integer idVerifica);

    @GET
    @Path("/getDistributore")
    @Produces({"application/json"})
    Response getDistributore(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest,
                             @QueryParam("id_dato_distrib") Long idDatoDistrib);

    @GET
    @Path("/getControllo")
    @Produces({"application/json"})
    Response getControllo(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest,
                          @QueryParam("sigla_ree") String siglaRee, @QueryParam("numero_ree") Long numeroRee);

    @GET
    @Path("/getAssegnatario")
    @Produces({"application/json"})
    Response getAssegnatario(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

    @GET
    @Path("/getSiglaRee")
    @Produces({"application/json"})
    Response getSiglaRee(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

    @GET
    @Path("/getAzione")
    @Produces({"application/json"})
    Response getAzione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id_verifica") Integer idVerifica, @QueryParam("codice_fiscale") String codiceFiscalePF);

    @POST
    @Path("/setAzione")
    @Produces({"application/json"})
    Response setAzione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody DatiAzione datiAzione);

    @POST
    @Path("/setIspezioneMassiva")
    @Produces({"application/json"})
    Response setIspezioneMassiva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody IspezioneMassiva ispezioneMassiva);

}