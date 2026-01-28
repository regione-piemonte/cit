package it.csi.sigit.combustypwabff.bff.impl;


import it.csi.sigit.combustypwabff.bff.UserApi;
import it.csi.sigit.combustypwabff.bff.dto.Error;
import it.csi.sigit.combustypwabff.bff.dto.UserInfo;
import it.csi.sigit.combustypwabff.bff.dto.UtenteLoggato;
import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.filter.IrideIdAdapterFilter;
import it.csi.sigit.combustypwabff.services.UserService;
import it.csi.sigit.combustypwabff.utils.Constants;
import it.csi.sigit.combustypwabff.utils.MapDto;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.ext.Provider;
import org.apache.log4j.Logger;

@Provider
public class UserApiServiceImpl implements UserApi {

    protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_NAME);

    @Inject
    UserService userService;

    @Override
    public Response getCurrentUser(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        UserInfo currentUser = (UserInfo) httpRequest.getAttribute(IrideIdAdapterFilter.USERINFO_SESSIONATTR);
        logger.info("[UsersApiServiceImpl::getCurrentUser] UserInfo: " + (currentUser != null ? currentUser.toString() : "null"));
        if (currentUser != null){
            UtenteLoggato utenteLoggato = MapDto.mapCurrentUserToUtenteLoggato(currentUser);
            return Response.ok(utenteLoggato).build();
        } else {
            Error error = new Error();
            error.setErrorMessage("utente non trovato");
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @Override
    public Response keepAlive(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            userService.keepAlive();
            return Response.ok().build();
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
    public Response setAccesso(UtenteLoggato utenteLoggato, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            userService.setAccesso(utenteLoggato);
            return Response.ok(utenteLoggato).build();
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
    public Response getDisponibilitaServizio(UtenteLoggato utenteLoggato, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(userService.getDisponibilitaServizio(utenteLoggato)).build();
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