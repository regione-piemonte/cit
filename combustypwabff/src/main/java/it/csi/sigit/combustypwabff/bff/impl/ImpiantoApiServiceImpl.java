package it.csi.sigit.combustypwabff.bff.impl;


import it.csi.sigit.combustypwabff.bff.ImpiantoApi;
import it.csi.sigit.combustypwabff.bff.dto.Error;
import it.csi.sigit.combustypwabff.bff.dto.FeatureCollection;
import it.csi.sigit.combustypwabff.bff.dto.UserInfo;
import it.csi.sigit.combustypwabff.bff.dto.UtenteLoggato;
import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.filter.IrideIdAdapterFilter;
import it.csi.sigit.combustypwabff.model.sigitext.SigitextErrore;
import it.csi.sigit.combustypwabff.services.ImpiantoService;
import it.csi.sigit.combustypwabff.utils.Constants;
import it.csi.sigit.combustypwabff.utils.MapDto;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

public class ImpiantoApiServiceImpl implements ImpiantoApi {

    @Inject
    ImpiantoService impiantoService;

    @Override
    public Response cercaResponsabileProprietario(Integer tipo, String cf, String siglaRea, String numeroRea, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(impiantoService.cercaResponsabileProprietario(tipo, cf, siglaRea, numeroRea)).build();
        } catch (CombustyPwaBffException e) {
            it.csi.sigit.combustypwabff.bff.dto.Error error = new it.csi.sigit.combustypwabff.bff.dto.Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            it.csi.sigit.combustypwabff.bff.dto.Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response getComuniEstesi(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(impiantoService.getComuniEstesi()).build();
        } catch (CombustyPwaBffException e) {
            it.csi.sigit.combustypwabff.bff.dto.Error error = new it.csi.sigit.combustypwabff.bff.dto.Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            it.csi.sigit.combustypwabff.bff.dto.Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response getGeoJsonImpianto(String ruolo, String piva, String codiceFiscalePF,
                                       String cf3Resp, String cfImpresa, String cfProprietario, String cfResponsabile, String civico,
                                       String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune,
                                       String indirizzo, String istatComune, String siglaRea, String numeroRea, String pdr, String pod,
                                       String siglaProvincia, Float x, Float y, Float distanza, Boolean ricercaCompleta,
                                       SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            UserInfo currentUser = (UserInfo) httpRequest.getAttribute(IrideIdAdapterFilter.USERINFO_SESSIONATTR);
            UtenteLoggato utenteLoggato = MapDto.mapParamToUtenteLoggato(currentUser, ruolo, piva, codiceFiscalePF);
            FeatureCollection fc = impiantoService.getGeoJsonImpianto(utenteLoggato, cf3Resp, cfImpresa, cfProprietario, cfResponsabile, civico, codiceImpianto, descComune,
                    fkStato, flagVisuProprietario, idComune, indirizzo, istatComune, siglaRea, numeroRea, pdr, pod, siglaProvincia, x, y, distanza, ricercaCompleta);

            if (fc != null && fc.getFeatures() != null && !fc.getFeatures().isEmpty()) {
                return Response.ok(fc).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(SigitextErrore.builder()
                                .status(String.valueOf(Response.Status.NOT_FOUND.getStatusCode()))
                                .code(Response.Status.NOT_FOUND.getReasonPhrase())
                                .title("Nessun impianto trovato che soddisfa i parametri inseriti")
                                .build())
                        .build();
            }

        } catch (CombustyPwaBffException e) {
            it.csi.sigit.combustypwabff.bff.dto.Error error = new it.csi.sigit.combustypwabff.bff.dto.Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            it.csi.sigit.combustypwabff.bff.dto.Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response getGeoJsonImpiantoMaxResults(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return impiantoService.getGeoJsonImpiantoMaxResults();
        } catch (CombustyPwaBffException e) {
            it.csi.sigit.combustypwabff.bff.dto.Error error = new it.csi.sigit.combustypwabff.bff.dto.Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            it.csi.sigit.combustypwabff.bff.dto.Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response getIndirizzoImpianto(String indirizzo, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(impiantoService.getIndirizzoImpianto(indirizzo)).build();
        } catch (CombustyPwaBffException e) {
            it.csi.sigit.combustypwabff.bff.dto.Error error = new it.csi.sigit.combustypwabff.bff.dto.Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            it.csi.sigit.combustypwabff.bff.dto.Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    public Response getProvinciaImpianto(String comune, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(impiantoService.getProvinciaImpianto(comune)).build();
        } catch (CombustyPwaBffException e) {
            it.csi.sigit.combustypwabff.bff.dto.Error error = new it.csi.sigit.combustypwabff.bff.dto.Error();
            error.setErrorMessage(e.getMessage());
            return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            it.csi.sigit.combustypwabff.bff.dto.Error error = new Error();
            error.setErrorMessage(Constants.ERRORE_GENERICO);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }
}