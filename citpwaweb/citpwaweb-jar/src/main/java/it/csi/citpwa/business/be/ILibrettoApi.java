/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.be;

import it.csi.citpwa.model.DatiImpiantoModel;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/libretto")
@Produces({ "application/json" })
public interface ILibrettoApi {
	@GET
	@Path("/uid")
	@Produces({ "application/json" })
	public Response getLibrettoByCodice(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req,@QueryParam("codice-impianto")String codiceImpianto);

	@POST
	@Path("/consolida")
	@Produces({ "application/json" })
	public Response consolidaLibretto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req,@QueryParam("codice-impianto")String codiceImpianto);

}
