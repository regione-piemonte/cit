/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.be.impl;

import it.csi.citpwa.business.be.IComponenteApi;
import it.csi.citpwa.business.service.IAuthenticationService;
import it.csi.citpwa.business.service.IComponentService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.exception.ValidationErrorException;
import it.csi.citpwa.model.DatiCGModel;
import it.csi.citpwa.model.DatiGFModel;
import it.csi.citpwa.model.DatiGTModel;
import it.csi.citpwa.model.DatiSCModel;
import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.util.Constants;
import it.csi.sigit.sigitext.ws.service.client.SigitUserNotAuthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Component
public class ComponentApiServiceImp implements IComponenteApi {

	@Autowired
	IAuthenticationService authenticationService;

	@Autowired
	IComponentService componentService;

	@Override
	public Response getGT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, Integer progressivo) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			List<DatiGTModel> datiGTList = componentService.getGT(user, codiceImpianto, progressivo);
			return Response.ok(datiGTList).build();
		} catch (ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(new Esito(Constants.KO, Constants.UTENTE_NON_AUTORIZZATO)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getGF(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, Integer progressivo) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			List<DatiGFModel> datiGTList = componentService.getGF(user, codiceImpianto, progressivo);
			return Response.ok(datiGTList).build();
		} catch (ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(new Esito(Constants.KO, Constants.UTENTE_NON_AUTORIZZATO)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getSC(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, Integer progressivo) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			List<DatiSCModel> datiGTList = componentService.getSC(user, codiceImpianto, progressivo);
			return Response.ok(datiGTList).build();
		} catch (ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(new Esito(Constants.KO, Constants.UTENTE_NON_AUTORIZZATO)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getCG(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, Integer progressivo) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			List<DatiCGModel> datiGTList = componentService.getCG(user, codiceImpianto, progressivo);
			return Response.ok(datiGTList).build();
		} catch (ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(new Esito(Constants.KO, Constants.UTENTE_NON_AUTORIZZATO)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getmarcaCIT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		try {
			return Response.ok(componentService.getMarcaCIT()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Errore(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase(), Constants.NESSUN_COMBUSTIBILE_TROVATO))
					.build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())).build();
		}
	}

	@Override
	public Response getFluidoCIT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		try {
			return Response.ok(componentService.getFluidoCIT()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Errore(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase(), Constants.NESSUN_COMBUSTIBILE_TROVATO))
					.build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())).build();
		}
	}

	@Override
	public Response getCombustibileCIT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		try {
			return Response.ok(componentService.getCombustibileCIT()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Errore(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase(), Constants.NESSUN_COMBUSTIBILE_TROVATO))
					.build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())).build();
		}
	}

	@Override
	public Response getClassDpr66096CIT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		try {
			return Response.ok(componentService.getClassDpr66096CIT()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Errore(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase(), Constants.NESSUN_ELEMENTO_TROVATO))
					.build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())).build();
		}
	}

	@Override
	public Response getFrequenzaManutCIT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		try {
			return Response.ok(componentService.getFrequenzaManutCIT()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Errore(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase(), Constants.NESSUN_ELEMENTO_TROVATO))
					.build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())).build();
		}
	}

	@Override
	public Response getTipologiaGT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		try {
			return Response.ok(componentService.getTipologiaGT()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Errore(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase(), Constants.NESSUN_COMBUSTIBILE_TROVATO))
					.build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())).build();
		}
	}

	@Override
	public Response getTipologiaGF(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		try {
			return Response.ok(componentService.getTipologiaGF()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Errore(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase(), Constants.NESSUN_COMBUSTIBILE_TROVATO))
					.build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())).build();
		}
	}
	@Override
	public Response getFonte(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		try {
			return Response.ok(componentService.getFonteCIT()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Errore(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase(), Constants.NESSUN_COMBUSTIBILE_TROVATO))
					.build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())).build();
		}
	}

	@Override
	public Response getTipoCannaFumaria(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		try {
			return Response.ok(componentService.getTipoCannaFumaria()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Errore(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase(), Constants.NESSUN_COMBUSTIBILE_TROVATO))
					.build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())).build();
		}
	}

	public Response updateGT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, List<DatiGTModel> datiGTModel, Integer idImpresaSelez) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			Esito esito = componentService.updateGT(codiceImpianto, DatiGTModel.modelToDto.convert(datiGTModel), user, idImpresaSelez);
			return Response.ok(esito).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO_PG, e.getMessage())).build();
		} catch (ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	public Response updateGF(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, List<DatiGFModel> datiGFModel, Integer idImpresaSelez) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			Esito esito = componentService.updateGF(codiceImpianto, DatiGFModel.modelToDto.convert(datiGFModel), user, idImpresaSelez);
			return Response.ok(esito).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO_PG, e.getMessage())).build();
		} catch (ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	public Response updateSC(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, List<DatiSCModel> datiScModel, Integer idImpresaSelez) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			Esito esito = componentService.updateSC(codiceImpianto, DatiSCModel.modelToDto.convert(datiScModel), user, idImpresaSelez);
			return Response.ok(esito).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO_PG, e.getMessage())).build();
		} catch (ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	public Response updateCG(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, List<DatiCGModel> datiCGModel, Integer idImpresaSelez) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			Esito esito = componentService.updateCG(codiceImpianto, DatiCGModel.modelToDto.convert(datiCGModel), user, idImpresaSelez);
			return Response.ok(esito).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO_PG, e.getMessage())).build();
		} catch (ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response checkDismettiSostituisciComponente(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String dataMinima, String dataMassima, String dataDismiss) {
		try {
			Esito esito = componentService.chekDismettiSostituisci(dataMinima, dataMassima, dataDismiss);
			return Response.ok(esito).build();
		} catch (ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response delComponente(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req, String codiceImpianto, String tipo, Integer progressivo) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			Esito esito = componentService.delComponente(codiceImpianto, tipo, progressivo, user);
			return Response.ok(esito).build();
		} catch (SigitExtException | ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
}
