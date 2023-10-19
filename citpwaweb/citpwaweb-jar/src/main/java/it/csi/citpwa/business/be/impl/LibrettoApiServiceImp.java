/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.be.impl;

import it.csi.citpwa.business.be.ILibrettoApi;
import it.csi.citpwa.business.service.IAuthenticationService;
import it.csi.citpwa.business.service.ILibrettoService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.model.sigitext.Esito;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.citpwa.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Component
public class LibrettoApiServiceImp implements ILibrettoApi {

	@Autowired
	ILibrettoService librettoService;
	@Autowired
	IAuthenticationService authenticationService;

	@Override
	public Response getLibrettoByCodice(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(librettoService.getlibrettoByCodice(user, codiceImpianto)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun libretto presente da scaricare")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response consolidaLibretto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			librettoService.consolidaLibretto(codiceImpianto, user);
			return Response.ok().build();
		} catch (SigitExtException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, "Errore nel recupero del libretto")).build();
		}
	}
}
