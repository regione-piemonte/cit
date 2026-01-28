package it.csi.sigit.combustypwabff.bff.impl;

import it.csi.sigit.combustypwabff.bff.DistributoreApi;
import it.csi.sigit.combustypwabff.bff.dto.DocXml;
import it.csi.sigit.combustypwabff.bff.dto.Error;
import it.csi.sigit.combustypwabff.bff.dto.ImportDatiDistributore;
import it.csi.sigit.combustypwabff.bff.dto.UserInfo;
import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.filter.IrideIdAdapterFilter;
import it.csi.sigit.combustypwabff.model.JWTModel;
import it.csi.sigit.combustypwabff.services.DistributoreService;
import it.csi.sigit.combustypwabff.services.JwtService;
import it.csi.sigit.combustypwabff.utils.Constants;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

public class DistributoreApiServiceImpl implements DistributoreApi {

    @Inject
    DistributoreService distributoreService;

    @Inject
    JwtService jwtService;

    @Override
    public Response annullaAcquisizioneDatoDistributore(String cf, Integer idID, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(distributoreService.annullaAcquisizioneDatoDistributore(cf, idID)).build();
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
    public Response getDettaglioDatiDistributoreJson(Integer idPersonaGiuridica, String anno, String mese, String tipoCaricamento, String statoFile, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return distributoreService.getDettaglioDatiDistributoreJson(idPersonaGiuridica, anno, mese, tipoCaricamento, statoFile);
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
    public Response getDettaglioDatiImportJson(Integer idID, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return distributoreService.getDettaglioDatiImportJson(idID);
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
    public Response getRuoliDistributore(String cf, String nome, String cognome, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(distributoreService.getRuoliDistributore(cf, cognome, nome)).build();
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
    public Response setDatiDistributoreSemplificatoJson(ImportDatiDistributore importDatiDistributore, Integer idPersonaGiuridica, String piva, String cf, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            return Response.ok(distributoreService.setDatiDistributoreSemplificatoJson(importDatiDistributore, idPersonaGiuridica, piva, cf)).build();
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
    //public Response uploadXMLDistributoreJWT(org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput docXml, Boolean sost, Integer idPG, Integer idID, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
    public Response uploadXMLDistributoreJWT(MultipartFormDataInput input, Boolean sost, Integer idPG, Integer idID, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            UserInfo currentUser = (UserInfo) httpRequest.getAttribute(IrideIdAdapterFilter.USERINFO_SESSIONATTR);
            JWTModel tokenJWT = jwtService.generaTokenFruitoreInterno(currentUser.getCodFisc(), idPG.toString());

            //return distributoreService.uploadXMLDistributoreMtomJWT(docXml, currentUser.getCodFisc(), idPG, sost, idID, tokenJWT.getToken());
            return distributoreService.uploadXMLDistributoreMtomJWT(input, currentUser.getCodFisc(), idPG, sost, idID, tokenJWT.getToken());

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
