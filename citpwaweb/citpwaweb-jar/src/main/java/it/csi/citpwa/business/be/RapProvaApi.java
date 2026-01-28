package it.csi.citpwa.business.be;

import it.csi.citpwa.model.DatiRapProva;
import it.csi.citpwa.model.sigitext.RapProvaWeb;
import it.csi.citpwa.model.sigitext.RapportoDiProva;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.math.BigDecimal;

@Path("/rapprova")
@Produces({ "application/json" })
public interface RapProvaApi {

    @POST
    @Path("/getRapProva")
    @Produces({"application/json"})
    Response getRapProva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody DatiRapProva datiRapProva, @QueryParam("ordinamento") String ordinamento);

    @POST
    @Path("deleteRapProva")
    @Produces({"application/json"})
    Response deleteRapProva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("conferma") Boolean conferma, @QueryParam("id_allegato") BigDecimal idAllegato, @QueryParam("id_ispezione_2018") BigDecimal idIspezione2018);

    @GET
    @Path("getRapProvaWeb")
    @Produces({"application/json"})
    Response getRapProvaWeb(@QueryParam("id_allegato") BigDecimal idAllegato, @QueryParam("fk_Tipo_Documento") BigDecimal fkTipoDocumento);

    @POST
    @Path("setRapProvaWeb")
    @Produces({"application/json"})
    Response setRapProvaWeb(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, RapProvaWeb rapProvaWeb);

    @POST
    @Path("getPDFRapProva")
    @Produces({"application/json"})
    Response getPDFRapProva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("firmato") Boolean firmato, @QueryParam("id_allegato") BigDecimal idAllegato);

    @POST
    @Path("updatePDFFirmatoRapProva")
    @Produces({"application/json"})
    Response updatePDFFirmatoRapProva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody RapProvaWeb rapProvaWeb);

    @POST
    @Path("setScansioneRapProva")
    @Produces({"application/json"})
    Response setScansioneRapProva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody RapProvaWeb rapProvaWeb);


}
