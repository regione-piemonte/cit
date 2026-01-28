package it.csi.sigit.sigitext.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.AccreditamentoApi;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.exceptions.ValidationManagerException;
import it.csi.sigit.sigitext.dto.sigitext.Accreditamento;
import it.csi.sigit.sigitext.dto.sigitext.DatiDelega;
import it.csi.sigit.sigitext.dto.sigitext.DatiImpresa;
import it.csi.sigit.sigitext.dto.sigitext.DatiIncarico;
import it.csi.sigit.sigitext.dto.sigitext.DatiToken;
import it.csi.sigit.sigitext.dto.sigitext.Esito;
import it.csi.sigit.sigitext.dto.sigitext.IncarichiSoggettiDelegatiResponse;
import it.csi.sigit.sigitext.dto.sigitext.Persona;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public class AccreditamentoApiServiceImpl implements AccreditamentoApi {

	@Override
	public Response getDatiAccreditamento(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscalePF) {
		try {
			Accreditamento response = getImplSigitextManager().getDatiAccreditamento(codiceFiscalePF);
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setDatiPersonaliUtente(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscalePF, Persona persona) {
		try {
			String response = getImplSigitextManager().setDatiPersonaliUtente(codiceFiscalePF, persona);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getDatiImpresa(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscale, String siglaRea, Integer numeroRea) {
		try {
			List<DatiImpresa> response = getImplSigitextManager().getDatiImpresa(codiceFiscale, siglaRea, numeroRea);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getDatiImpresaDistributore(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscale, String siglaRea, Integer numeroRea) {
		try {
			List<DatiImpresa> response = getImplSigitextManager().getDatiImpresaDistributore(codiceFiscale, siglaRea, numeroRea);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setImpresaAssociata(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String operation, String codiceFiscalePF, DatiImpresa datiImpresa) {
		try {
			String response = getImplSigitextManager().setImpresaAssociata(operation, codiceFiscalePF, datiImpresa);
			return Response.ok(response).build();
		}catch(ValidationManagerException vx) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, vx.getMsg() != null ? vx.getMsg().getText() : vx.getMessage())).build();	
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setDelega(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona) {
		try {
			String response = getImplSigitextManager().setDelega(codiceFiscalePF, idPersonaGiuridica, idPersona);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response deleteDelega(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, UtenteLoggato utenteLoggato, Integer idPersona) {
		try {
			String response = getImplSigitextManager().deleteDelega(utenteLoggato, idPersona);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response deleteDelegaConfirm(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona) {
		try {
			String response = getImplSigitextManager().deleteDelegaConfirm(codiceFiscalePF, idPersonaGiuridica, idPersona);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getIncarichiSoggettiDelegati (SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			List<IncarichiSoggettiDelegatiResponse> response = getImplSigitextManager().getIncarichiSoggettiDelegati();
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setIncaricoSoggettoDelegato(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) {
		try {
			String response = getImplSigitextManager().setIncaricoSoggettoDelegato(codiceFiscalePF, idPersonaGiuridica, idPersonaGiuridicaCat);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response deleteIncaricoSoggettoDelegato(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) {
		try {
			String response = getImplSigitextManager().deleteIncaricoSoggettoDelegato(codiceFiscalePF, idPersonaGiuridica, idPersonaGiuridicaCat);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response sendEmailProva(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String emailAddress) {
		try {
			String response = getImplSigitextManager().sendEmailProva(emailAddress);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}

	@Override
	public Response getElencoDeleghe(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Integer idImpresaGiuridica) {
		try {
			List<DatiDelega> response = getImplSigitextManager().getElencoDeleghe(idImpresaGiuridica);
			return Response.ok(response).build();
		}  catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getElencoIncarichi(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Integer idImpresaGiuridica) {
		try {
			List<DatiIncarico> response = getImplSigitextManager().getElencoIncarichi(idImpresaGiuridica);
			return Response.ok(response).build();
		}  catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getDatiTokenImpresa(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Integer idPersonaGiuridica) {
		try {
			DatiToken response = getImplSigitextManager().getDatiTokenImpresa(idPersonaGiuridica);
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response generateTokenImpresa(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Integer idPersonaGiuridica) {
		try {
			DatiToken response = getImplSigitextManager().generateTokenImpresa(idPersonaGiuridica);
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	

}
