package it.csi.sigit.combustypwabff.bff.impl;

import it.csi.sigit.combustypwabff.bff.AccreditamentoApi;
import it.csi.sigit.combustypwabff.bff.dto.DatiImpresa;
import it.csi.sigit.combustypwabff.bff.dto.Error;
import it.csi.sigit.combustypwabff.bff.dto.Persona;
import it.csi.sigit.combustypwabff.bff.dto.UtenteLoggato;
import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.services.AccreditamentoService;
import it.csi.sigit.combustypwabff.utils.Constants;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

public class AccreditamentoApiServiceImpl implements AccreditamentoApi {

    @Inject
    AccreditamentoService accreditamentoService;

    @Override
    public Response deleteDelega(UtenteLoggato utenteLoggato, Integer idPersona, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.deleteDelega(utenteLoggato, idPersona)).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response deleteDelegaConfirm(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersona, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.deleteDelegaConfirm(codiceFiscale, idPersonaGiuridica, idPersona)).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response deleteIncaricoSoggettoDelegato(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.deleteIncaricoSoggettoDelegato(codiceFiscale, idPersonaGiuridica, idPersonaGiuridicaCat)).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response generateTokenImpresa(Integer idPersonaGiuridica, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.generateTokenImpresa(idPersonaGiuridica)).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response getDatiAccreditamento(String codiceFiscale, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.getDatiAccreditamento(codiceFiscale)).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response getDatiImpresa(String codiceFiscale, String siglaREA, Integer numeroREA, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.getDatiImpresa(codiceFiscale, siglaREA, numeroREA)).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response getDatiImpresaDistributore(String codiceFiscale, String siglaREA, Integer numeroREA, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.getDatiImpresaDistributore(codiceFiscale, siglaREA, numeroREA)).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response getDatiTokenImpresa(Integer idPersonaGiuridica, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.getDatiTokenImpresa(idPersonaGiuridica)).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response getElencoDeleghe(Integer idPersonaGiuridica, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.getElencoDeleghe(idPersonaGiuridica)).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response getElencoIncarichi(Integer idPersonaGiuridica, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.getElencoIncarichi(idPersonaGiuridica)).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response getIncarichiSoggettiDelegati(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.getIncarichiSoggettiDelegati()).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response sendEmailProva(String emailAddress, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.sendEmailProva(emailAddress)).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response setDatiPersonaliUtente(Persona persona, String codiceFiscale, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.setDatiPersonaliUtente(codiceFiscale, persona)).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response setDelega(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersona, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(accreditamentoService.setDelega(codiceFiscale, idPersonaGiuridica, idPersona)).build();
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response setImpresaAssociata(DatiImpresa datiImpresa, String operation, String codiceFiscale, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return accreditamentoService.setImpresaAssociata(datiImpresa, operation, codiceFiscale);
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response setIncaricoSoggettoDelegato(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return accreditamentoService.setIncaricoSoggettoDelegato(codiceFiscale, idPersonaGiuridica, idPersonaGiuridicaCat);
        } catch (CombustyPwaBffException e) {
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }
}
