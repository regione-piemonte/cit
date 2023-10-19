/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.sigit.sigitext.business.be;

import it.csi.sigit.sigitext.dto.sigitext.RespPropModel;
import it.csi.sigit.sigitext.dto.sigitext.SetImpiantoModel;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/impianto")
@Produces({ "application/json" })
public interface ImpiantoApi {

	@GET
	@Path("/filtro")
	@Produces({ "application/json" })
	public Response getImpiantiByFiltroJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("cf3-resp") String cf3Responsabile, @QueryParam("cf-impresa") String cfImpresa, @QueryParam("cf-proprietario") String cfProprietario, @QueryParam("cf-responsabile") String cfResponsabile, @QueryParam("civico") String civico, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("desc-comune") String descComune, @QueryParam("fk-stato") String fkStato, @QueryParam("flag-visu-proprietario") String flagVisuProprietario, @QueryParam("id-comune") String idComune, @QueryParam("indirizzo") String indirizzo, @QueryParam("istat-comune") String istatComune, @QueryParam("numero-rea") String numeroRea, @QueryParam("pdr") String pdr, @QueryParam("pod") String pod, @QueryParam("sigla-provincia") String siglaProvincia, @QueryParam("sigla-rea") String siglaRea, @QueryParam("x") Float x, @QueryParam("y") Float y, @QueryParam("distanza") Float distanza, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/codice")
	@Produces({ "application/json" })
	public Response getImpiantoByCodiceJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") Integer codiceImpianto, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/pod")
	@Produces({ "application/json" })
	public Response getImpiantoByPODJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("pod") String pod, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/pdr")
	@Produces({ "application/json" })
	public Response getImpiantoByPDRJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("pdr") String pdr, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/indirizzo")
	@Produces({ "application/json" })
	public Response getImpiantoByIndirizzoJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("indirizzo") String indirizzo, @QueryParam("civico") Integer civico, @QueryParam("istat") String istat, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/stato")
	@Produces({ "application/json" })
	public Response getStatoImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@POST
	@Path("/setImpianto")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response setImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, SetImpiantoModel setImpiantoModel, @QueryParam("responsabilita") Integer responsabilita);

	@POST
	@Path("/setModificaImpianto")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response setModificaImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, SetImpiantoModel setImpiantoModel);

	@GET
	@Path("/resp_prop")
	@Produces({ "application/json;charset=UTF-8" })
	public Response getRespProp(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("tipo") int tipo, @QueryParam("cf") String cf,@QueryParam("sigla_rea") String siglaRea, @QueryParam("numero_rea") String numeroRea);

	@POST
	@Path("/resp_prop")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response setNuovoRespProp(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, RespPropModel respPropModel);

}
