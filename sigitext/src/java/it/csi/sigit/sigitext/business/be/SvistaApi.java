/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.sigit.sigitext.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/svista")
@Produces({ "application/json" })
public interface SvistaApi {

	@GET
	@Path("/ce")
	@Produces({ "application/json" })
	public Response getComuniEstesi(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

}
