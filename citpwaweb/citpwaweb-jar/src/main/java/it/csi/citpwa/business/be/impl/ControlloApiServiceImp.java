/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.be.impl;

import it.csi.citpwa.business.be.IControlloApi;
import it.csi.citpwa.business.service.IAuthenticationService;
import it.csi.citpwa.business.service.IControlliService;
import it.csi.citpwa.exception.ValidationErrorException;
import it.csi.citpwa.model.ManutFormModel;
import it.csi.citpwa.model.PdfControlloModel;
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
import java.io.File;
import java.net.SocketTimeoutException;
import java.util.Date;

@Component
public class ControlloApiServiceImp implements IControlloApi {

	@Autowired
	private IControlliService controlliService;

	@Autowired
	private IAuthenticationService authenticationService;

	@Override
	public Response getControlli(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, String ordinamento, Integer numRighe) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(controlliService.recuperaDati(codiceImpianto, ordinamento, numRighe, user)).build();
		} catch (SocketTimeoutException e) {
			return Response.status(418).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getXmlControllo(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, Integer idAllegato, String tipoDoc) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(controlliService.getXmlCOntrollo(idAllegato, tipoDoc, user)).build();
		} catch (SocketTimeoutException e) {
			return Response.status(418).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getRicevutaControllo(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(controlliService.getRicevuta(tipoComponente, codiceImpianto, progressivo, dataInstallazione, idAllegato, user)).build();
		} catch (SocketTimeoutException e) {
			return Response.status(418).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getPDFControllo(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, Boolean firmato) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			PdfControlloModel pdfControlloModel = PdfControlloModel.dtoToModel.convert(controlliService.getPDFControllo(tipoComponente, codiceImpianto, progressivo, dataInstallazione, idAllegato, firmato, user));
			return Response.ok(pdfControlloModel).build();
		} catch (SocketTimeoutException e) {
			return Response.status(418).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getControlliDisponibili(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, String tipoComponente, String tipoControllo, String dataControllo) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(controlliService.getControlliDisponibili(codiceImpianto, tipoComponente, tipoControllo, dataControllo, user)).build();
		} catch (SocketTimeoutException e) {
			return Response.status(418).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response uploadReeFirmato(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, File ree, String fileName, String mimeType, Integer idAllegato) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			controlliService.uploadReeFirmato(idAllegato, ree, fileName, mimeType, user);
			return Response.ok().build();
		} catch (SocketTimeoutException e) {
			return Response.status(418).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response inviaManutenzione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, String tipoControllo, ManutFormModel manutFormModel) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			controlliService.inviaManutenzione(codiceImpianto, tipoControllo, manutFormModel, user);
			return Response.ok().build();
		} catch (SocketTimeoutException e) {
			return Response.status(418).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response inserisciREE(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, String tipoControllo, boolean inviaBool, String ree) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			Esito esito = controlliService.inserisciREE(codiceImpianto, tipoControllo, ree, inviaBool, user);
			if (esito.getEsito().equals(Constants.OK))
				return Response.ok().build();
			else
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(esito).build();
		} catch (SocketTimeoutException e) {
			return Response.status(418).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response modificaREE(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, Integer idAllegato, String codiceImpianto, String tipoControllo, boolean invia, String ree) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			controlliService.modificaREE(idAllegato, codiceImpianto, tipoControllo, invia, ree, user);
			return Response.ok().build();
		} catch (SocketTimeoutException e) {
			return Response.status(418).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response inviaREE(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, Integer idAllegato) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			Esito esito = controlliService.inviaREE(idAllegato, user);
			return Response.ok(esito).build();
		} catch (SocketTimeoutException e) {
			return Response.status(418).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response cancellaControllo(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, Integer idAllegato, Integer statoRapp) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			controlliService.deleteControllo(idAllegato, statoRapp, user);
			return Response.ok().build();
		} catch (SocketTimeoutException e) {
			return Response.status(418).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
}
