package it.csi.citpwa.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.citpwa.business.be.IAccreditamentoApi;
import it.csi.citpwa.business.service.IAccreditamentoService;
import it.csi.citpwa.model.sigitext.DatiDelega;
import it.csi.citpwa.model.sigitext.DatiImpresa;
import it.csi.citpwa.model.sigitext.DatiIncarico;
import it.csi.citpwa.model.sigitext.Esito;
import it.csi.citpwa.model.sigitext.IncarichiSoggettiDelegatiResponse;
import it.csi.citpwa.model.sigitext.Persona;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.citpwa.util.Constants;

@Component
public class AccreditamentoApiServiceImp implements IAccreditamentoApi {
	
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

	@Autowired
	private IAccreditamentoService accreditamentoService;

	@Override
	public Response getDatiAccreditamento(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscalePF) {
		try {
			return Response.ok(accreditamentoService.getDatiAccreditamento(codiceFiscalePF)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato accreditamento presente")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setDatiPersonaliUtente(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscalePF, Persona persona) {
		try {
			return Response.ok(accreditamentoService.setDatiPersonaliUtente(codiceFiscalePF, persona)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato personale salvato")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getDatiImpresa(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscale, String siglaRea, Integer numeroRea) {
		try {
			return Response.ok(accreditamentoService.getDatiImpresa(codiceFiscale, siglaRea, numeroRea)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato impresa presente")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setDelega(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest,  String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona) {
		try {
			return Response.ok(accreditamentoService.setDelega(codiceFiscalePF, idPersonaGiuridica, idPersona)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response deleteDelega(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, UtenteLoggato utenteLoggato, Integer idPersona) {
		try {
			String response = accreditamentoService.deleteDelega(utenteLoggato, idPersona);
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response deleteDelegaConfirm(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona) {
		try {
			String response = accreditamentoService.deleteDelegaConfirm(codiceFiscalePF, idPersonaGiuridica, idPersona);
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getIncarichiSoggettiDelegati (SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			List<IncarichiSoggettiDelegatiResponse> response = accreditamentoService.getIncarichiSoggettiDelegati();
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setIncaricoSoggettoDelegato(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest,  String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) {
		try {
			return Response.ok(accreditamentoService.setIncaricoSoggettoDelegato(codiceFiscalePF, idPersonaGiuridica, idPersonaGiuridicaCat)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response deleteIncaricoSoggettoDelegato(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest,  String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) {
		try {
			return Response.ok(accreditamentoService.deleteIncaricoSoggettoDelegato(codiceFiscalePF, idPersonaGiuridica, idPersonaGiuridicaCat)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response sendEmailProva (SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String emailAddress) {
		try {
			String response = accreditamentoService.sendEmailProva(emailAddress);
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setImpresaAssociata(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String operation, String codiceFiscalePF, DatiImpresa datiImpresa) {
		try {
			String response = accreditamentoService.setImpresaAssociata(operation, codiceFiscalePF, datiImpresa);
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getElencoIncarichi(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idPersonaGiuridica) {
		try {
			List<DatiIncarico> incarichi = accreditamentoService.getElencoIncarichi(idPersonaGiuridica);
			return Response.ok(incarichi).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getElencoDeleghe(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idPersonaGiuridica) {
		try {
			List<DatiDelega> deleghe = accreditamentoService.getElencoDeleghe(idPersonaGiuridica);
			return Response.ok(deleghe).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getDatiTokenImpresa(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idPersonaGiuridica) {
		try {
			String datiToken = accreditamentoService.getDatiTokenImpresa(idPersonaGiuridica);
			return Response.ok(datiToken).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response generateTokenImpresa(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idPersonaGiuridica) {
		try {
			String datiToken = accreditamentoService.generateTokenImpresa(idPersonaGiuridica);
			return Response.ok(datiToken).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

}
