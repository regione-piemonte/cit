package it.csi.sigit.sigitext.business.be;

import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/user")
@Produces({ "application/json" })
public interface UserApi {
	
	@GET
	@Path("/ruoli")
	@Produces({"application/json"})
	public Response getRuoli(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("cf") String cf, @QueryParam("nome") String nome, @QueryParam("cognome") String cognome);

	@GET
	@Path("/distributore/ruoli")
	@Produces({"application/json"})
	public Response getRuoliDistributore(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("cf") String cf, @QueryParam("nome") String nome, @QueryParam("cognome") String cognome);

	@POST
	@Path("/accesso")
	@Produces({"application/json"})
	public Response setAccesso(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, UtenteLoggato utenteLoggato);

	@GET
	@Path("/accesso")
	@Produces({"application/json"})
	public Response salvaAccesso(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("nm") String nome,  @QueryParam("cn") String cognome,  @QueryParam("cf") String cf,  @QueryParam("rl") String ruolo);

	@POST
	@Path("/disponibilitaservizio")
	@Produces({"application/json"})
	public Response getDisponibilitaServizio(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, UtenteLoggato utenteLoggato, @QueryParam("servizio") String servizio);

	@GET
	@Path("/disponibilitaservizio")
	@Produces({"application/json"})
	public Response getDisponibilitaServizio(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("cf") String codiceFiscale, @QueryParam("servizio") String servizio);

}
