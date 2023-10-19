/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.be.impl;

import it.csi.citpwa.business.be.ICurrentUserApi;
import it.csi.citpwa.business.service.IAuthenticationService;
import it.csi.citpwa.model.sigitext.Errore;
import it.csi.citpwa.model.sigitext.Esito;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.citpwa.util.Constants;
import it.csi.sigit.sigitext.ws.service.client.SigitUserNotAuthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.net.SocketTimeoutException;

@Component
public class CurrentUserApiServiceImp implements ICurrentUserApi {

	@Autowired
	private IAuthenticationService authService;

	@Override
	public Response getCurrentUser(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		return Response.ok(authService.getCurrentUser(req)).build();
	}

	@Override
	public Response getRuoliUtente(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		try {
			return Response.ok(authService.getRuoliUtente(req)).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity(new Errore(Response.Status.UNAUTHORIZED.getStatusCode(), Response.Status.UNAUTHORIZED.getReasonPhrase(), "accesso negato - Utente non autorizzato")).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Errore(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase(), "nessun combustibile trovato"))
					.build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())).build();
		}
	}

	@Override
	public Response keepAliveSession(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		try {
			authService.ping();
			return Response.ok().build();
		} catch (SocketTimeoutException e) {
			return Response.status(418).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())).build();
		}
	}

	@Override
	public Response setAccesso(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, UtenteLoggato utenteLoggato) {
		try {
			UtenteLoggato result = authService.setAccesso(req, utenteLoggato);
			if (result != null)
				return Response.ok(result).build();
			else {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Errore nel recupero del ruolo")).build();
			}
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity(new Errore(Response.Status.UNAUTHORIZED.getStatusCode(), Response.Status.UNAUTHORIZED.getReasonPhrase(), "RUOLO SOSPESO O RADIATO")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())).build();
		}
	}
}
