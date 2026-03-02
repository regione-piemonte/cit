package it.csi.sigit.citpdnd.api.impl;


import it.csi.sigit.citpdnd.api.ImpiantiApi;
import it.csi.sigit.citpdnd.api.dto.Error;
import it.csi.sigit.citpdnd.api.dto.ListaImpianti;
import it.csi.sigit.citpdnd.dao.ImpiantiDao;
import it.csi.sigit.citpdnd.exception.CitpdndException;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.ext.Provider;

import java.math.BigDecimal;

@Provider
public class ImpiantiServiceImpl implements ImpiantiApi{

    @Inject
    ImpiantiDao impiantiDao;

    @Override
    @RolesAllowed({"reader"})
    public Response getImpiantoByCodiceImpianto(BigDecimal codImpianto, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {

            ListaImpianti impianti = impiantiDao.getImpiantoByCodiceImpianto(codImpianto);
            return Response.ok(impianti).build();

        } catch (CitpdndException e) {
            Error error = new Error();
            error.setCode(e.getCode());
            error.setErrorMessage(e.getMessage());
            return Response.status(500).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    @RolesAllowed({"reader"})
    public Response getImpiantoByIndirizzoImpianto(String indirizzo, String istatComune, String civico, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {

            ListaImpianti impianti = impiantiDao.getImpiantoByIndirizzoImpianto(indirizzo, istatComune, civico);
            return Response.ok(impianti).build();

        } catch (CitpdndException e) {
            Error error = new Error();
            error.setCode(e.getCode());
            error.setErrorMessage(e.getMessage());
            return Response.status(500).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Override
    @RolesAllowed({"reader"})
    public Response getLibrettoByCodiceImpianto(BigDecimal codImpianto, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        try {
            
            return impiantiDao.getLibrettoByCodiceImpianto(codImpianto);

        } catch (CitpdndException e) {
            Error error = new Error();
            error.setCode(e.getCode());
            error.setErrorMessage(e.getMessage());
            return Response.status(500).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
    }

}
