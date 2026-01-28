package it.csi.citpwa.business.be.impl;

import it.csi.citpwa.business.be.RapProvaApi;
import it.csi.citpwa.business.service.IAuthenticationService;
import it.csi.citpwa.business.service.IRapProvaService;
import it.csi.citpwa.model.DatiRapProva;
import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.math.BigDecimal;
import java.util.List;

@Component
public class RapProvaApiServiceImpl implements RapProvaApi {

    @Autowired
    IRapProvaService iRapProvaService;

    @Autowired
    private IAuthenticationService authenticationService;

    @Override
    public Response getRapProva(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, DatiRapProva datiRapProva, String ordinamento) {

        try{
            List<DatiRapProva> list = iRapProvaService.getRapProva(datiRapProva, ordinamento);

            for(DatiRapProva elem : list) {
                elem.setDtControllo(elem.getDataControllo());
                if(elem.getElencoApparecchiature()!=null){
                    elem.setComponenti(elem.getElencoApparecchiature().split(","));
                }
                elem.setFkStatoRapProva(elem.getFkStatoRapp());
            }

            return Response.ok(list).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato rapporto prova presente")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }

    }

    @Override
    public Response deleteRapProva(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Boolean conferma, BigDecimal idAllegato, BigDecimal idIspezione2018) {

        try{
            UtenteLoggato user = authenticationService.getCurrentUser(httpRequest);
            iRapProvaService.deleteRapProva(conferma, idAllegato, idIspezione2018, user);
            return Response.ok("OK").build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato rapporto prova cancellato")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }

    }

    @Override
    public Response getRapProvaWeb(BigDecimal idAllegato, BigDecimal fkTipoDocumento) {

        try{
            RapProvaWeb response = iRapProvaService.getRapProvaWeb(idAllegato, fkTipoDocumento);
            return Response.ok(response).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato rapporto prova web presente")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }

    }

    @Override
    public Response setRapProvaWeb(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, RapProvaWeb rapProvaWeb) {

        try{
            var user = authenticationService.getCurrentUser(httpRequest);
            rapProvaWeb.setUtenteLoggato(user);

            var esito = iRapProvaService.setRapProvaWeb(rapProvaWeb);
            return Response.ok(esito).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato rapporto prova web inserito")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }

    }

    @Override
    public Response getPDFRapProva(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Boolean firmato, BigDecimal idAllegato) {

        try{
            var user = authenticationService.getCurrentUser(httpRequest);

            var fileBase64 = iRapProvaService.getPDFRapProva(firmato, idAllegato, user);

            return Response.ok(fileBase64).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun PDF rapporto prova web inserito")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }

    }

    @Override
    public Response updatePDFFirmatoRapProva(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, RapProvaWeb rapProvaWeb) {

        try{
            var user = authenticationService.getCurrentUser(httpRequest);
            rapProvaWeb.setUtenteLoggato(user);

            var esito = iRapProvaService.updatePDFFirmatoRapProva(rapProvaWeb);

            if (esito != null && "OK".equalsIgnoreCase(esito.getEsito())) {
                return Response.ok(esito).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(esito).build();
            }
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun PDF rapporto prova caricato")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }

    }

    @Override
    public Response setScansioneRapProva(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, RapProvaWeb rapProvaWeb) {

        try{
            var user = authenticationService.getCurrentUser(httpRequest);
            rapProvaWeb.setUtenteLoggato(user);

            var esito = iRapProvaService.setScansioneRapProva(rapProvaWeb);
            return Response.ok(esito).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun PDF rapporto prova caricato")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }

    }
}
