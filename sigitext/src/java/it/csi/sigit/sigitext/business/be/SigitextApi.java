/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.sigit.sigitext.business.be;

import it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/domini")
@Produces({ "application/json" })
public interface SigitextApi {

	@GET
	@Path("/ping")
	@Produces({ "application/json" })
	public Response ping(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/unita-misura")
	@Produces({ "application/json" })
	public Response getUnitaMisuraCIT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);
}
