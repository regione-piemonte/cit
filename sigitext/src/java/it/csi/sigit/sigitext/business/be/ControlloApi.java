package it.csi.sigit.sigitext.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.Date;

@Path("/controllo")
@Produces({ "application/json" })
public interface ControlloApi {
	@GET
	@Path("/all")
	public Response getControlli(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("ordinamento") String ordinamento, @QueryParam("num-righe") Integer numRighe);

	@GET
	@Path("/xml")
	public Response downloadXMLControllo(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id-allegato") Integer idAllegato);

	@GET
	@Path("/ricevuta")
	public Response getRicevutaControllo(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("tipo-componente") String tipoComponente, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("progressivo") Integer progressivo, @QueryParam("data-installazione") Date dataInstallazione, @QueryParam("id-allegato") String idAllegato, @QueryParam("ruolo") String ruolo, @QueryParam("id-impresa") Integer idImpresa);

	@GET
	@Path("/pdf")
	public Response getPDFControllo(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("tipo-componente") String tipoComponente, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("progressivo") Integer progressivo, @QueryParam("data-installazione") Date dataInstallazione, @QueryParam("id-allegato") String idAllegato, @QueryParam("firmato") Boolean firmato, @QueryParam("ruolo") String ruolo, @QueryParam("id-impresa") Integer idImpresa);

	@GET
	@Path("/controlli-disponibili")
	public Response getControlliDisponibili(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("data-controllo") Date dataControllo, @QueryParam("tipologia-controllo") String tipoControllo, @QueryParam("tipologia-componente") String tipoComponente, @QueryParam("ruolo") String ruolo, @QueryParam("id-impresa") Integer idImpresa);

	@GET
	@Path("/stelle")
	public Response getStelle(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/apparecchiature")
	public Response getApparecchiature(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/controllo-aria")
	public Response getControlloAria(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/aria-comburente")
	public Response getAriaComburente(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@POST
	@Path("/ree-firmato")
	public Response uploadReeFirmato(@Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders,
			@Context HttpServletRequest httpRequest,
			byte[] file,
			@QueryParam("id-allegato") Integer idAllegato,
			@QueryParam("nome") String fileName,
			@QueryParam("content-type") String contentType,
			@QueryParam("ruolo") String ruolo,
			@QueryParam("id-impresa") Integer idImpresa,
			@QueryParam("cf") String cf);

	@DELETE
	public Response deleteControllo(@Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders,
			@Context HttpServletRequest httpRequest,
			@QueryParam("id-allegato") Integer idAllegato,
			@QueryParam("ruolo") String ruolo,
			@QueryParam("id-impresa") Integer idImpresa,
			@QueryParam("cf") String cf);

	@POST
	public Response updateControlloJWT(@Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders,
			@Context HttpServletRequest httpRequest,
			@QueryParam("id-allegato") Integer idAllegato,
			@QueryParam("codice-impianto") Integer codiceImpianto,
			@QueryParam("tipo-controllo") String tipoControllo,
			byte[] xml,
			@QueryParam("tokenJWT") String tokenJWT);

	@POST
	  @Path("/invia")
	public Response inviaControllo(@Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders,
			@Context HttpServletRequest httpRequest,
			@QueryParam("id-allegato") Integer idAllegato,
			@QueryParam("ruolo") String ruolo,
			@QueryParam("id-impresa") Integer idImpresa,
			@QueryParam("cf") String cf,
			@QueryParam("cat") Boolean cat);

}
