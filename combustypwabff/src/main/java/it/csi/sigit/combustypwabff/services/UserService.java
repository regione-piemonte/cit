package it.csi.sigit.combustypwabff.services;

import it.csi.sigit.combustypwabff.bff.dto.UtenteLoggato;
import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.resources.SigitextResource;
import it.csi.sigit.combustypwabff.utils.Constants;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class UserService {

    @Inject
    SigitextResource sigitextResource;

    public Response setAccesso(UtenteLoggato utenteLoggato) throws CombustyPwaBffException {

        return sigitextResource.setAccesso(utenteLoggato.getPfLoggato().getNomePF(),
                utenteLoggato.getPfLoggato().getCognomePF(),
                utenteLoggato.getPfLoggato().getCodiceFiscalePF(),
                utenteLoggato.getRuoloLoggato().getRuolo());
    }

    public void keepAlive() throws CombustyPwaBffException {

        sigitextResource.ping();
    }

    public String getDisponibilitaServizio(UtenteLoggato utenteLoggato) throws CombustyPwaBffException {

        sigitextResource.getDisponibilitaServizio(utenteLoggato.getPfLoggato().getCodiceFiscalePF(), Constants.SERVICE_NAME);

        return Constants.OK;
    }
}
