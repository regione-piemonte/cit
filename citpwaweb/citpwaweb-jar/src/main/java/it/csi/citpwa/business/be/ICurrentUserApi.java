/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.citpwa.business.be;

import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.exception.ValidationErrorException;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.sigit.sigitext.ws.service.client.SigitUserNotAuthorizedException;

import java.net.SocketTimeoutException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/currentUser")
@Produces({ "application/json" })
public interface ICurrentUserApi {

	@GET
	@Produces({ "application/json" })
	public Response getCurrentUser(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req)
	throws SigitUserNotAuthorizedException, SocketTimeoutException, SvistaException, ValidationErrorException;

	@GET
	@Path("/roles")
	@Produces({ "application/json" })
	public Response getRuoliUtente(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Path("/keep-alive")
	@Produces({ "application/json" })
	public Response keepAliveSession(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@POST
	@Path("/accesso")
	@Produces({ "application/json" })
	public Response setAccesso(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, UtenteLoggato utenteLoggato);

	@POST
	@Path("/disponibilitaservizio")
	@Produces({ "application/json" })
	public Response getDisponibilitaServizio(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, UtenteLoggato utenteLoggato);

}
