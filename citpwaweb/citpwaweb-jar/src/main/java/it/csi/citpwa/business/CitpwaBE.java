/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business;

import it.csi.citpwa.business.service.IAuthenticationService;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.exception.ValidationErrorException;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.sigit.sigitext.ws.service.client.SigitUserNotAuthorizedException;

import org.springframework.beans.factory.annotation.Autowired;

import java.net.SocketTimeoutException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/be")
@Consumes({ "application/json", MediaType.MULTIPART_FORM_DATA })
@Produces({ "application/json" })
public class CitpwaBE {

	@Autowired
	private IAuthenticationService authService;

	@GET
	@Path("/currentUser")
	public UtenteLoggato getCurrentUser(@Context HttpServletRequest req) throws SocketTimeoutException, SigitUserNotAuthorizedException, SvistaException, ValidationErrorException {
		return authService.getCurrentUser(req);
	}
}
