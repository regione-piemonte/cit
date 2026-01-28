package it.csi.sigit.combustypwabff.bff.impl;


import it.csi.sigit.combustypwabff.bff.ComponenteApi;
import it.csi.sigit.combustypwabff.bff.dto.Error;
import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.services.ComponenteService;
import it.csi.sigit.combustypwabff.utils.Constants;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ComponenteApiServiceImpl implements ComponenteApi {

    @Inject
    ComponenteService componenteService;

    @Override
    public Response getCombustibile(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(componenteService.getCombustibile()).build();
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
    public Response getUnitaMisura(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(componenteService.getUnitaMisura()).build();
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