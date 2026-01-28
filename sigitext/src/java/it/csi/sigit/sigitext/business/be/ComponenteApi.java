package it.csi.sigit.sigitext.business.be;

import it.csi.sigit.sigitext.dto.sigitext.UpdateCgModel;
import it.csi.sigit.sigitext.dto.sigitext.UpdateGfModel;
import it.csi.sigit.sigitext.dto.sigitext.UpdateGtModel;
import it.csi.sigit.sigitext.dto.sigitext.UpdateScModel;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/comp")
@Produces({ "application/json" })
public interface ComponenteApi {
	@GET
	@Path("/gt")
	public Response getGT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("progressivo") Integer progressivo, @QueryParam("id-persona") Integer idPg);

	@GET
	@Path("/gf")
	public Response getGF(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("progressivo") Integer progressivo, @QueryParam("id-persona") Integer idPg);

	@GET
	@Path("/sc")
	public Response getSC(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("progressivo") Integer progressivo, @QueryParam("id-persona") Integer idPg);

	@GET
	@Path("/cg")
	public Response getCG(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("progressivo") Integer progressivo, @QueryParam("id-persona") Integer idPg);

	@PUT
	@Path("/gt")
	public Response updateGT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id-impresa") Integer idImpresa, UpdateGtModel updateGtModel);

	@PUT
	@Path("/gf")
	public Response updateGF(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id-impresa") Integer idImpresa, UpdateGfModel updateGfModel);

	@PUT
	@Path("/sc")
	public Response updateSC(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id-impresa") Integer idImpresa, UpdateScModel updateScModel);

	@PUT
	@Path("/cg")
	public Response updateCG(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id-impresa") Integer idImpresa, UpdateCgModel updateCgModel);

	@GET
	@Path("/tipologiaGT")
	public Response getTipologiaGT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/tipologiaGF")
	public Response getTipologiaGF(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/combustibile")
	@Produces({ "application/json" })
	public Response getCombustibileCIT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/classDpr66096")
	@Produces({ "application/json" })
	public Response getClassDpr66096CIT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/frequenzaManut")
	@Produces({ "application/json" })
	public Response getFrequenzaManutCIT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/marca")
	@Produces({ "application/json" })
	public Response getMarcaCIT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/fonte")
	@Produces({ "application/json" })
	public Response getFonteCIT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/fluido")
	@Produces({ "application/json" })
	public Response getFluidoCIT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/canna-fumaria")
	@Produces({ "application/json" })
	public Response getTipoCannaFumaria(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@DELETE()
	public Response delComponenteImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("tipo") String tipologia, @QueryParam("progressivo") Integer progressivo, @QueryParam("cf") String cf);

}
