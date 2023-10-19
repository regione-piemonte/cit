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
	@Produces({"application/json;charset=UTF-8"})
	public Response getRuoli(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("cf") String cf, @QueryParam("nome") String nome, @QueryParam("cognome") String cognome);

	@POST
	@Path("/accesso")
	@Produces({ "application/json;charset=UTF-8" })
	public Response setAccesso(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, UtenteLoggato utenteLoggato);

}
