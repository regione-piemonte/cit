package it.csi.sigit.combustypwabff.services;

import it.csi.sigit.combustypwabff.bff.dto.*;
import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.model.sigitext.SigitextImpiantoFiltro;
import it.csi.sigit.combustypwabff.resources.LocsiResource;
import it.csi.sigit.combustypwabff.resources.SigitextResource;
import it.csi.sigit.combustypwabff.utils.Constants;
import it.csi.sigit.combustypwabff.utils.MapDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class ImpiantoService {

    @Inject
    LocsiResource locsiResource;

    @Inject
    SigitextResource sigitextResource;

    @Inject
    ValidationService validationService;

    public List<Persona> cercaResponsabileProprietario(Integer tipo, String cf, String siglaRea, String numeroRea) throws CombustyPwaBffException {

        return sigitextResource.cercaResponsabileProprietario(tipo, cf, siglaRea, numeroRea);
    }

    public List<ComuneEstesoModel> getComuniEstesi() throws CombustyPwaBffException {

        return sigitextResource.getComuniEstesi();
    }

    public List<FeatureModel> getIndirizzoImpianto(String indirizzo) throws CombustyPwaBffException {

        return locsiResource.getIndirizzoImpianto(indirizzo);
    }

    public List<FeatureModel> getProvinciaImpianto(String indirizzo) throws CombustyPwaBffException {

        return locsiResource.getProvinciaImpianto(indirizzo);
    }

    public FeatureCollection getGeoJsonImpianto(UtenteLoggato utenteLoggato, String cf3Resp, String cfImpresa, String cfProprietario, String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String siglaRea, String numeroRea, String pdr, String pod, String siglaProvincia, Float x, Float y, Float distanza, Boolean ricercaCompleta) throws CombustyPwaBffException {

        SigitextImpiantoFiltro impiantoFiltro = MapDto.mapParamToImpiantoFiltro(cf3Resp, cfImpresa, cfProprietario, cfResponsabile, civico, codiceImpianto, descComune, fkStato, flagVisuProprietario, idComune, indirizzo, istatComune, numeroRea, pdr, pod, siglaProvincia, siglaRea, x, y, distanza, utenteLoggato);
        if (validationService.validateRicercaImpianto(utenteLoggato, impiantoFiltro).equals(true)) {
            if (!ricercaCompleta && utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_IMPRESA)) {
                impiantoFiltro.setNumeroRea(Integer.parseInt(utenteLoggato.getRuoloLoggato().getNumeroRea()));
                impiantoFiltro.setSiglaRea(utenteLoggato.getRuoloLoggato().getSiglaRea());
                impiantoFiltro.setCfImpresa(utenteLoggato.getRuoloLoggato().getPiva());
            }

            if (utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_PROPRIETARIO) || utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {
                impiantoFiltro.setFlagVisuProprietario(true);
            }

            if (utenteLoggato.getRuoloLoggato().getIstatAbilitazione() != null && !utenteLoggato.getRuoloLoggato().getIstatAbilitazione().isEmpty()) {
                if (utenteLoggato.getRuoloLoggato().getIstatAbilitazione().length() > 2) {
                    String cod = utenteLoggato.getRuoloLoggato().getIstatAbilitazione().substring(2);
                    impiantoFiltro.setIstatComune(cod);
                }
            }
            return sigitextResource.getGeoJsonImpiantoByFiltroJWT(impiantoFiltro, "tokenJWT");

        } else {
            throw new CombustyPwaBffException(Response.Status.UNAUTHORIZED.getStatusCode(), "Utente non autorizzato.");
        }

    }

    public Response getGeoJsonImpiantoMaxResults() throws CombustyPwaBffException {

        return sigitextResource.getGeoJsonImpiantoMaxResults();
    }
}
