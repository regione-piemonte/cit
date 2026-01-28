/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.be.impl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.citpwa.model.sigitext.Scheda2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.citpwa.business.be.ILibrettoApi;
import it.csi.citpwa.business.service.IAuthenticationService;
import it.csi.citpwa.business.service.ILibrettoService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.model.sigitext.Esito;
import it.csi.citpwa.model.sigitext.Scheda1;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.citpwa.util.Constants;

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
			return Response.ok(librettoService.getLibrettoByCodice(user, codiceImpianto)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun libretto presente da scaricare")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getLibrettoDtoByCodice(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(librettoService.getLibrettoDtoByCodice(user, codiceImpianto)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun libretto presente da scaricare")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getXmlLibrettoNowByCodice(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, Boolean isConsolidato){
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(librettoService.getXmlLibrettoNowByCodice(user, codiceImpianto, isConsolidato)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun libretto presente da scaricare")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getXMLLibrettoConsolidatoJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto){
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(librettoService.getXMLLibrettoConsolidatoJWT(user, codiceImpianto)).build();
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
	
	@Override
	public Response setLibSch1IdImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, Integer codiceImpianto, Scheda1 scheda1) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			librettoService.setLibSch1IdImpianto(codiceImpianto, scheda1, user);
			return Response.ok().build();
		} catch (SigitExtException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, "Errore nel setLibSch1IdImpianto")).build();
		}
	}

	@Override
	public Response setLibSch2IdImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, Integer codiceImpianto, Scheda2 scheda2) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(librettoService.setLibSch2IdImpianto(codiceImpianto, scheda2, user)).build();
		} catch (SigitExtException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, "Errore nel setLibSch2IdImpianto")).build();
		}
	}
	
	@Override
	public Response getLibrettoNowJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, Boolean isConsolidato){
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(librettoService.getLibrettoNowByCodice(user, codiceImpianto, isConsolidato)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun libretto presente da scaricare")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getSchedaLibrettoJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto){
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(librettoService.getSchedaLibrettoByCodice(user, codiceImpianto)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun libretto presente da scaricare")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getCategorie() {
		try {
			return Response.ok(librettoService.getCategorie()).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getTipoIntervento(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest){
		try {
			return Response.ok(librettoService.getTipoIntervento()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun libretto presente da scaricare")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
}
