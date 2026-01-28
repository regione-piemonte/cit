package it.csi.sigit.sigitext.business.be;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.web.bind.annotation.RequestBody;

import it.csi.sigit.sigitext.dto.RapProvaWeb;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;

@Path("/rapProva")
@Produces({ "application/json" })
public interface RapProvaApi {
	
	@GET
	@Path("/getControlliRapProva")
	@Produces({"application/json"})
	Response getControlliRapProva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") BigDecimal codiceImpianto, @QueryParam("id_ispezione_2018") BigDecimal idIspezione2018);

	@POST
	@Path("/getRapProva")
	@Produces({"application/json"})
	Response getRapProva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") BigDecimal codiceImpianto, @QueryParam("id_ispezione_2018") BigDecimal idIspezione2018, @QueryParam("ordinamento") String ordinamento);

	@POST
	@Path("deleteRapProva")
	@Produces({"application/json"})
	Response deleteRapProva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id_allegato") BigDecimal idAllegato, @QueryParam("id_ispezione_2018") BigDecimal idIspezione2018, @RequestBody UtenteLoggato utenteLoggato);
	
	@GET
	@Path("getRapProvaWeb")
	@Produces({"application/json"})
	Response getRapProvaWeb(@QueryParam("id_allegato") BigDecimal idAllegato);
	
	@POST
	@Path("setRapProvaWeb")
	@Produces({"application/json"})
	Response setRapProvaWeb(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody RapProvaWeb rapProvaWeb);
	
	@POST
	@Path("getPDFRapProva")
	@Produces({"application/json"})
	Response getPDFRapProva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("firmato") Boolean firmato, @QueryParam("id_allegato") BigDecimal idAllegato, @RequestBody UtenteLoggato utenteLoggato);
	
	@POST
	@Path("updatePDFFirmatoRapProva")
	@Produces({"application/json"})
	Response updatePDFFirmatoRapProva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody RapProvaWeb rapProvaWeb);
	
	@POST
	@Path("setScansioneRapProva")
	@Produces({"application/json"})
	Response setScansioneRapProva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody RapProvaWeb rapProvaWeb);
}
