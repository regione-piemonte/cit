package it.csi.sigit.sigitext.business.be.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.NominaTerzoResponsabileApi;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.sigitext.DatiAffidamento;
import it.csi.sigit.sigitext.dto.sigitext.Esito;
import it.csi.sigit.sigitext.dto.sigitext.RequestTerzoResponsabile;
import it.csi.sigit.sigitext.dto.sigitext.ResponseGetDettaglioNomina;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public class NominaTerzoResponsabileApiServiceImpl implements NominaTerzoResponsabileApi {
	
	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}

	@Override
	public Response getDettaglioNomina(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idContratto, Integer codiceImpianto) {
		try {
			ResponseGetDettaglioNomina response = getImplSigitextManager().getDettaglioNomina(idContratto, codiceImpianto);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response deleteAffidamento(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscale, Integer idPersonaGiuridica, Integer codiceImpianto, DatiAffidamento datiAffidamento) {
		try {
			String response = getImplSigitextManager().deleteAffidamento(codiceFiscale, idPersonaGiuridica, codiceImpianto, datiAffidamento);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getTipoCessazione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			List<Map<Integer, String>> response = getImplSigitextManager().getTipoCessazione();
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getTipoAutodichiarazione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			List<Map<Integer, String>> response = getImplSigitextManager().getTipoAutodichiarazione();
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response setCessazione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, RequestTerzoResponsabile requestSetCessazione) {
		try {
			String response = getImplSigitextManager().setCessazione(requestSetCessazione);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setProroga(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, RequestTerzoResponsabile requestSetCessazione) {
		try {
			String response = getImplSigitextManager().setProroga(requestSetCessazione);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response setSubentrosuImpianto(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, String codiceFiscale, Integer idPersona, Integer codiceImpianto, String desRuolo, UtenteLoggato utenteLoggato) {
		try {
			String response = getImplSigitextManager().setSubentrosuImpianto(codiceFiscale, idPersona, codiceImpianto, desRuolo, utenteLoggato);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response verifyContrattoTerzoResponsabile(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, RequestTerzoResponsabile requestVerifyContratto) {
		try {
			String response = getImplSigitextManager().verifyContrattoTerzoResponsabile(requestVerifyContratto);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response setNuovoTerzoResp(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Integer codiceImpianto, RequestTerzoResponsabile request) {
		try {
			String response = getImplSigitextManager().setNuovoTerzoResp(codiceImpianto, request);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

}
