package it.csi.citpwa.business.be.impl;

import it.csi.citpwa.business.be.IIspezioneApi;
import it.csi.citpwa.business.service.IAuthenticationService;
import it.csi.citpwa.business.service.IIspezioneService;
import it.csi.citpwa.model.DatiAzione;
import it.csi.citpwa.model.sigitext.DownloadFileExcelRequest;
import it.csi.citpwa.model.IspezioneDetail;
import it.csi.citpwa.model.sigitext.Esito;
import it.csi.citpwa.model.sigitext.PFLoggato;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.citpwa.util.Constants;
import it.csi.citpwa.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.math.BigDecimal;

@Component
public class IspezioneApiServiceImp implements IIspezioneApi {

    @Autowired
    IIspezioneService iIspezioneService;

    @Autowired
    private IAuthenticationService authenticationService;

    @Override
    public Response getIspezioni(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, IspezioneDetail ispezioneDetail) {
        try{
             return Response.ok(iIspezioneService.getIspezioni(ispezioneDetail)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato ispezione presente")).build();
        } catch (Exception e) {
            if("La ricerca ha prodotto troppi risultati. Inserire criteri di ricerca piu' restrittivi e riprovare.".equalsIgnoreCase(e.getMessage())){
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.WARN, e.getMessage())).build();
            }
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response getIspezione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer id) {
        try{
            return Response.ok(iIspezioneService.getIspezione(id)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato ispezione presente")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response downloadCopertinaIspezione(Integer idIspezione2018, HttpServletRequest req) throws Exception {
        var user = authenticationService.getCurrentUser(req);
        var res = iIspezioneService.downloadCopertinaIspezione(idIspezione2018, user);
        return Response.ok(res).build();
    }

    @Override
    public Response downloadLetteraAvviso(Integer idIspezione2018, HttpServletRequest req) throws Exception {
        var user = authenticationService.getCurrentUser(req);
        var res = iIspezioneService.downloadLetteraAvviso(idIspezione2018, user);
        return Response.ok(res).build();
    }

    @Override
    public Response downloadLetteraAvviso180Gg(Integer idIspezione2018, HttpServletRequest req) throws Exception {
        var user = authenticationService.getCurrentUser(req);
        var res = iIspezioneService.downloadLetteraAvviso180Gg(idIspezione2018, user);
        return Response.ok(res).build();
    }

    @Override
    public Response downloadFileExcel(DownloadFileExcelRequest downloadFileExcelRequest, HttpServletRequest req) throws Exception {
        var user = authenticationService.getCurrentUser(req);
        var res = iIspezioneService.downloadFileExcel(downloadFileExcelRequest, user);
        return Response.ok(res).build();
    }

    @Override
    public Response getStatoIspezione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        try{
            return Response.ok(iIspezioneService.getStatoIspezione()).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato stato ispezione presente")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response setIspezione(IspezioneDetail ispezioneDetail, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        try {
            UtenteLoggato user = authenticationService.getCurrentUser(httpRequest);
            String message = "Ispezione inserita con successo";
            if(ispezioneDetail.getIdIspezione2018()!=null){
                message = "Ispezione aggiornata con successo";
            }
            String idIspezione2018 = iIspezioneService.setIspezione(ispezioneDetail,user);
            Esito esito = new Esito(Constants.OK,message);
            esito.setIdIspezione2018(Long.parseLong(idIspezione2018));
            return Response.ok(esito).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun libretto presente da scaricare")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response assegna(IspezioneDetail ispezioneDetail, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        try {
            UtenteLoggato user = authenticationService.getCurrentUser(httpRequest);
            String idIspezione2018 = iIspezioneService.assegna(ispezioneDetail,user);
            Esito esito = new Esito(Constants.OK,"Ispezione assegnata con successo");
            esito.setIdIspezione2018(Long.parseLong(idIspezione2018));
            return Response.ok(esito).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun libretto presente da scaricare")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response concludi(IspezioneDetail ispezioneDetail, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        try {
            UtenteLoggato user = authenticationService.getCurrentUser(httpRequest);
            String idIspezione2018 = iIspezioneService.concludi(ispezioneDetail,user);
            Esito esito = new Esito(Constants.OK,"Ispezione conclusa con successo");
            esito.setIdIspezione2018(Long.parseLong(idIspezione2018));
            return Response.ok(esito).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun libretto presente da scaricare")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response assegnaImpianto(IspezioneDetail ispezioneDetail, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        try {
            UtenteLoggato user = authenticationService.getCurrentUser(httpRequest);
            String idIspezione2018 = iIspezioneService.assegnaImpianto(ispezioneDetail,user);
            Esito esito = new Esito(Constants.OK,"Ispezione assegnata con successo");
            esito.setIdIspezione2018(Long.parseLong(idIspezione2018));
            return Response.ok(esito).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun libretto presente da scaricare")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response annulla(BigDecimal id, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        try {
            UtenteLoggato user = authenticationService.getCurrentUser(httpRequest);
            String idIspezione2018 = iIspezioneService.annulla(id,user);
            Esito esito = new Esito(Constants.OK,"Ispezione annullata con successo");
            esito.setIdIspezione2018(Long.parseLong(idIspezione2018));
            return Response.ok(esito).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun libretto presente da scaricare")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response getAzione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idIspezione2018, String codiceFiscalePF) {
        try {
            UtenteLoggato utenteLoggato = new UtenteLoggato();
            PFLoggato pfLoggato = new PFLoggato();
            pfLoggato.setCodiceFiscalePF(codiceFiscalePF);
            utenteLoggato.setPfLoggato(pfLoggato);
            return Response.ok(iIspezioneService.getAzione(idIspezione2018, utenteLoggato)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato presente")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response setAzione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, DatiAzione datiAzione) {

        try {

            String resp = (String)iIspezioneService.setAzione(datiAzione);

            if(NumberUtil.isNumeric(resp)) {
                Esito esito = new Esito(Constants.OK, "Azione " + resp + " inserita con successo.");
                esito.setIdAzione(Long.parseLong(resp));
                return Response.ok(esito).build();
            }else{
                return Response.status(Response.Status.CONFLICT).entity(new Esito(Constants.KO, resp)).build();
            }

        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessuna Azione inserita")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }

    }

    @Override
    public Response getIspettore(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        try {
            return Response.ok(iIspezioneService.getIspettore()).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato ispettore presente")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }
}
