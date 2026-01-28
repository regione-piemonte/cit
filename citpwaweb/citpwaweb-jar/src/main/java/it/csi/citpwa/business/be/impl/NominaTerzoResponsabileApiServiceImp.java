package it.csi.citpwa.business.be.impl;

import it.csi.citpwa.business.be.INominaTerzoResponsabileApi;
import it.csi.citpwa.business.service.INominaTerzoResponsabileService;
import it.csi.citpwa.model.sigitext.DatiAffidamento;
import it.csi.citpwa.model.sigitext.Esito;
import it.csi.citpwa.model.sigitext.RequestTerzoResponsabile;
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
public class NominaTerzoResponsabileApiServiceImp implements INominaTerzoResponsabileApi {
	
	@Autowired
	private INominaTerzoResponsabileService nominaTerzoResponsabileService;

	@Override
	public Response getDettaglioNomina(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idContratto, Integer codiceImpianto) {
		try {
			return Response.ok(nominaTerzoResponsabileService.getDettaglioNomina(idContratto, codiceImpianto)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato dettaglio nomina presente")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response deleteAffidamento(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscale, Integer idPersonaGiuridica, Integer codiceImpianto, DatiAffidamento datiAffidamento) {
		try {
			return Response.ok(nominaTerzoResponsabileService.deleteAffidamento(codiceFiscale, idPersonaGiuridica, codiceImpianto, datiAffidamento)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato affidamento presente")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getTipoCessazione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			return Response.ok(nominaTerzoResponsabileService.getTipoCessazione()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessuna cessazione presente")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getTipoAutodichiarazione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			return Response.ok(nominaTerzoResponsabileService.getTipoAutodichiarazione()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessuna autodichiarazione presente")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setCessazione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, RequestTerzoResponsabile requestTerzoResponsabile) {
		try {
			return Response.ok(nominaTerzoResponsabileService.setCessazione(requestTerzoResponsabile)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Errore")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setProroga(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, RequestTerzoResponsabile requestTerzoResponsabile) {
		try {
			return Response.ok(nominaTerzoResponsabileService.setProroga(requestTerzoResponsabile)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Errore")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setSubentrosuImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscale, Integer idPersona, Integer codiceImpianto, String desRuolo, UtenteLoggato utenteLoggato) {
		try {
			return Response.ok(nominaTerzoResponsabileService.setSubentrosuImpianto(codiceFiscale, idPersona, codiceImpianto, desRuolo, utenteLoggato)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Errore")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response verifyContrattoTerzoResponsabile(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, RequestTerzoResponsabile requestVerifyContratto) {
		try {
			return Response.ok(nominaTerzoResponsabileService.verifyContrattoTerzoResponsabile(requestVerifyContratto)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Errore")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setNuovoTerzoResp(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer codiceImpianto, RequestTerzoResponsabile request) {
		try {
			return Response.ok(nominaTerzoResponsabileService.setNuovoTerzoResp(codiceImpianto, request)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Errore")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
}
