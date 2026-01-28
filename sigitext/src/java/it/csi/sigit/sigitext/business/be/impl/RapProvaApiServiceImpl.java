package it.csi.sigit.sigitext.business.be.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.Logger;
import org.apache.soap.providers.com.Log;
import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.RapProvaApi;
import it.csi.sigit.sigitext.business.be.manager.RapProvaManager;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.FileBase64;
import it.csi.sigit.sigitext.dto.RapProvaWeb;
import it.csi.sigit.sigitext.dto.sigitext.DatiRapProva;
import it.csi.sigit.sigitext.dto.sigitext.Esito;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;

public class RapProvaApiServiceImpl implements RapProvaApi {
	
	protected static final Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".SigitextManager==>");
	
	private RapProvaManager getImplRapProvaManager() {
		return (RapProvaManager) SpringApplicationContextHelper.getBean("rapProvaManager");
	}

	@Override
	public Response getControlliRapProva(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, BigDecimal codiceImpianto, BigDecimal idIspezione2018) {				
		
		try {			
			String response = getImplRapProvaManager().getControlliRapProva(codiceImpianto, idIspezione2018);
			return Response.ok(response).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	

	@Override
	public Response getRapProva(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, BigDecimal codiceImpianto, BigDecimal idIspezione2018, String ordinamento) {
		try {
			List<DatiRapProva> response = getImplRapProvaManager().getRapProva(codiceImpianto, idIspezione2018, ordinamento);
			return Response.ok(response).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response deleteRapProva(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, BigDecimal idAllegato, BigDecimal idIspezione2018,
			UtenteLoggato utenteLoggato) {
		try {
			getImplRapProvaManager().deleteRapProva(idAllegato, idIspezione2018, utenteLoggato);
			return Response.ok().build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getRapProvaWeb(BigDecimal idAllegato) {
		try {
			RapProvaWeb response = getImplRapProvaManager().getRapProvaWeb(idAllegato);
			return Response.ok(response).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response setRapProvaWeb(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, RapProvaWeb rapProvaWeb) {
		try {
			Esito response = getImplRapProvaManager().setRapProvaWeb(rapProvaWeb);
			return Response.ok(response).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			log.error("Errore in setRapProvaWeb: ", e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getPDFRapProva(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Boolean firmato, BigDecimal idAllegato, UtenteLoggato utenteLoggato) {
		try {
			FileBase64 response = getImplRapProvaManager().getPDFRapProva(firmato, idAllegato, utenteLoggato);
			return Response.ok(response).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response updatePDFFirmatoRapProva(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, RapProvaWeb rapProvaWeb) {
		try {
			Esito response = getImplRapProvaManager().updatePDFFirmatoRapProva(rapProvaWeb);
			return Response.ok(response).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setScansioneRapProva(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, RapProvaWeb rapProvaWeb) {
		try {
			Esito response = getImplRapProvaManager().setScansioneRapProva(rapProvaWeb);
			return Response.ok(response).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

}
