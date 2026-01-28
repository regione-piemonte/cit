package it.csi.citpwa.business.be.impl;

import it.csi.citpwa.business.be.IVerificaApi;
import it.csi.citpwa.business.service.IAuthenticationService;
import it.csi.citpwa.business.service.IVerificaService;
import it.csi.citpwa.model.*;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import it.csi.citpwa.util.NumberUtil;

@Component
public class VerificaApiServiceimpl implements IVerificaApi {

    @Autowired
    IVerificaService verificaService;

    @Autowired
    private IAuthenticationService authenticationService;

    @Override
    public Response getTipoVerifica(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        try {
            return Response.ok(verificaService.getTipoVerifica()).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato tipo verifica presente")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response getVerifica(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idVerifica) {
        try {
            return Response.ok(verificaService.getVerifica(idVerifica)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato verifica presente")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response setVerifica(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, VerificaFEModel verificaIns) {

        Verifica verifica = new Verifica();
        if (verificaIns.getIdVerifica() !=null) {
            verifica.setIdentificativo("" + verificaIns.getIdVerifica());
        }
        verifica.setTipoVerifica(verificaIns.getFkTipoVerifica());

        if(verificaIns.getDtCaricamento()!=null) {
            verifica.setDataCaricamento(new SimpleDateFormat("dd/MM/yyyy").format(new Date(verificaIns.getDtCaricamento())));
        }
        verifica.setCfUtenteCaricamento(verificaIns.getCfUtenteCaricamento());
        if(verificaIns.getCodiceImpianto()!=null) {
            verifica.setCodiceImpianto("" + verificaIns.getCodiceImpianto());
        }
        //verifica.setDenomUtenteCaricamento(verificaIns.getDenomUtenteCaricamento());???
        //verifica.setIdAllegato(verificaIns.getIdAllegato());
        if(verificaIns.getNumeroBollino()!=null) {
            verifica.setNumeroBollino("" + verificaIns.getNumeroBollino());
        }
        verifica.setSiglaBollino(verificaIns.getSiglaBollino());
        if(verificaIns.getDtSveglia()!=null) {
            verifica.setDataSveglia(new SimpleDateFormat("dd/MM/yyyy").format(new Date(verificaIns.getDtSveglia())));
        }else{
            verifica.setDataSveglia("");
        }
        verifica.setIdDatoDistributore(verificaIns.getFkDatoDistrib());
        verifica.setNote(verificaIns.getNote());
        verifica.setNoteSveglia(verificaIns.getNoteSveglia());

        UtenteLoggatoModel utenteLoggato = new  UtenteLoggatoModel();
        utenteLoggato.setCodiceFiscale(verificaIns.getCfUtenteCaricamento());
        //utenteLoggato.setDenominazione("");

        try {
            String resp = verificaService.setVerifica(verifica, utenteLoggato);
            if("OK".equalsIgnoreCase(resp) || NumberUtil.isNumeric(resp)) {
                if (verificaIns.getIdVerifica() == null) {
                    Esito esito = new Esito(Constants.OK, "Verifica " + resp + " inserita con successo.");
                    esito.setIdVerifica(Long.parseLong(resp));
                    return Response.ok(esito).build();
                }else{
                    Esito esito = new Esito(Constants.OK, "Verifica " + verificaIns.getIdVerifica() + " aggiornata con successo.");
                    esito.setIdVerifica(verificaIns.getIdVerifica());
                    return Response.ok(esito).build();
                }
            }else{
                return Response.status(Response.Status.CONFLICT).entity(new Esito(Constants.KO, resp)).build();
            }
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato verifica salvato")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response getVerifiche(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, RicercaDatiVerificaModel ricercaDatiVerificaModel) {
        try {
            RicercaDatiVerifica ricercaDatiVerifica = new RicercaDatiVerifica();
            ricercaDatiVerifica.setIdVerifica(ricercaDatiVerificaModel.getIdVerifica());
            ricercaDatiVerifica.setFkTipoVerifica(ricercaDatiVerificaModel.getFkTipoVerifica());
            ricercaDatiVerifica.setFkAllegato(ricercaDatiVerificaModel.getFkAllegato());
            ricercaDatiVerifica.setFkDatoDistrib(ricercaDatiVerificaModel.getFkDatoDistrib());
            ricercaDatiVerifica.setCodiceImpianto(ricercaDatiVerificaModel.getCodiceImpianto());
            ricercaDatiVerifica.setCfUtenteCaricamento(ricercaDatiVerificaModel.getCfUtenteCaricamento());
            ricercaDatiVerifica.setDenomUtenteCaricamento(ricercaDatiVerificaModel.getDenomUtenteCaricamento());
            if(ricercaDatiVerificaModel.getDtCaricamentoDa()!=null) {
                ricercaDatiVerifica.setDtCaricamentoDa(new Date(ricercaDatiVerificaModel.getDtCaricamentoDa()));
            }
            if(ricercaDatiVerificaModel.getDtCaricamentoA()!=null) {
                ricercaDatiVerifica.setDtCaricamentoA(new Date(ricercaDatiVerificaModel.getDtCaricamentoA()));
            }
            ricercaDatiVerifica.setSiglaRee(ricercaDatiVerificaModel.getSiglaRee());
            ricercaDatiVerifica.setNumeroRee(ricercaDatiVerificaModel.getNumeroRee());
            if(ricercaDatiVerificaModel.getDtVeglia()!=null) {
                ricercaDatiVerifica.setDtSveglia(new Date(ricercaDatiVerificaModel.getDtVeglia()));
            }
            ricercaDatiVerifica.setNoteSveglia(ricercaDatiVerificaModel.getNoteSveglia());
            ricercaDatiVerifica.setNote(ricercaDatiVerificaModel.getNote());

            return Response.ok(verificaService.getVerifiche(ricercaDatiVerifica)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato verifica presente")).build();
        } catch (Exception e) {
            if("La ricerca ha prodotto troppi risultati. Inserire criteri di ricerca piu' restrittivi e riprovare.".equalsIgnoreCase(e.getMessage())){
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.WARN, e.getMessage())).build();
            }
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response deleteVerifica(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idVerifica) {
        try {
            String resp = verificaService.deleteVerifica(idVerifica);
            if("OK".equalsIgnoreCase(resp) ) {
                return Response.ok(new Esito(Constants.OK, "Verifica "+idVerifica+" cancellata con successo.")).build();
            }else{
                return Response.status(Response.Status.CONFLICT).entity(new Esito(Constants.KO, resp)).build();
            }

        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato verifica cancellato")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response getDistributore(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Long idDatoDistrib) {
        try {
            DatiDistributori datiDistributori = (DatiDistributori)verificaService.getDistributore(idDatoDistrib);
            if(datiDistributori.getFkStatoDistrib()==null){
                return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Non esiste un distributore con il codice specificato")).build();
            }
            return Response.ok(verificaService.getDistributore(idDatoDistrib)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato distributore presente")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response getControllo(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String siglaRee, Long numeroRee) {
        try {
            return Response.ok(verificaService.getControllo(siglaRee, numeroRee)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Non esiste un REE con il codice specificato")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response getAssegnatario(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        try {
            return Response.ok(verificaService.getAssegnatario()).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato assegnatario presente")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response getSiglaRee(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        try {
            return Response.ok(verificaService.getSiglaRee()).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato presente")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response getAzione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idVerifica, String codiceFiscalePF) {
        try {
            UtenteLoggato utenteLoggato = new UtenteLoggato();
            PFLoggato pfLoggato = new PFLoggato();
            pfLoggato.setCodiceFiscalePF(codiceFiscalePF);
            utenteLoggato.setPfLoggato(pfLoggato);
            return Response.ok(verificaService.getAzione(idVerifica, utenteLoggato)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun dato presente")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }

    @Override
    public Response setAzione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, DatiAzione datiAzione) {

        try {

            String resp = (String)verificaService.setAzione(datiAzione);

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
    public Response setIspezioneMassiva(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, IspezioneMassiva ispezioneMassiva) {

        try {

            UtenteLoggato user = authenticationService.getCurrentUser(httpRequest);
            UtenteLoggatoModel model = new UtenteLoggatoModel();
            if(user!=null && user.getPfLoggato()!=null) {
                model.setCodiceFiscale(user.getPfLoggato().getCodiceFiscalePF());
            }
            String ret = verificaService.setIspezioneMassiva(ispezioneMassiva, model);

            Esito esito = new Esito(Constants.OK, "Inserimento massivo eseguito con successo");
            if(!"OK".equals(ret)){
                String message = "";
                String stato = "KO";
                int length = 0;
                if(ispezioneMassiva!=null){
                    if(ispezioneMassiva.getCodiceImpianto()!=null){
                        length = ispezioneMassiva.getCodiceImpianto().length;
                    }
                    if(ispezioneMassiva.getFkDatoDistrib()!=null){
                        length = ispezioneMassiva.getFkDatoDistrib().length;
                    }
                    int split = ret.split(",").length;
                    if(length == split){
                        message = "Codici non esistenti";
                    }else{
                        message = "Inserimento avvenuto ad esclusione dei codici: " +ret;
                    }
                    esito.setEsito(stato);
                    esito.setDescrizioneEsito(message);
                }

                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(esito).build();
            }

            return Response.ok(esito).build();

        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessuna ispezione inserita")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
        }
    }
}
