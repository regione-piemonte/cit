package it.csi.sigit.combustypwabff.services;

import it.csi.sigit.combustypwabff.bff.dto.*;
import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.resources.SigitextResource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class AccreditamentoService {

    @Inject
    SigitextResource sigitextResource;

    public Accreditamento getDatiAccreditamento(String cf) throws CombustyPwaBffException {

        return sigitextResource.getDatiAccreditamento(cf);
    }

    public String setDatiPersonaliUtente(String codiceFiscale, Persona persona) throws CombustyPwaBffException {

        return sigitextResource.setDatiPersonaliUtente(codiceFiscale, persona);
    }

    public List<DatiImpresa> getDatiImpresa(String codiceFiscale, String siglaREA, Integer numeroREA) throws CombustyPwaBffException {

        return sigitextResource.getDatiImpresa(codiceFiscale, siglaREA, numeroREA);
    }

    public List<DatiImpresa> getDatiImpresaDistributore(String codiceFiscale, String siglaREA, Integer numeroREA) throws CombustyPwaBffException {

        return sigitextResource.getDatiImpresaDistributore(codiceFiscale, siglaREA, numeroREA);
    }

    public Response setImpresaAssociata(DatiImpresa datiImpresa, String operation, String codiceFiscale) throws CombustyPwaBffException {

        return sigitextResource.setImpresaAssociata(datiImpresa, operation, codiceFiscale);
    }

    public String setDelega(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersona) throws CombustyPwaBffException {

        return sigitextResource.setDelega(codiceFiscale, idPersonaGiuridica, idPersona);
    }

    public String deleteDelega(UtenteLoggato utenteLoggato, Integer idPersona) throws CombustyPwaBffException {

        return sigitextResource.deleteDelega(utenteLoggato, idPersona);
    }

    public String deleteDelegaConfirm(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersona) throws CombustyPwaBffException {

        return sigitextResource.deleteDelegaConfirm(codiceFiscale, idPersonaGiuridica, idPersona);
    }

    public String deleteIncaricoSoggettoDelegato(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws CombustyPwaBffException {

        return sigitextResource.deleteIncaricoSoggettoDelegato(codiceFiscale, idPersonaGiuridica, idPersonaGiuridicaCat);
    }

    public List<DatiDelega> getElencoDeleghe(Integer idPersonaGiuridica) throws CombustyPwaBffException {

        return sigitextResource.getElencoDeleghe(idPersonaGiuridica);
    }

    public List<DatiIncarico> getElencoIncarichi(Integer idPersonaGiuridica) throws CombustyPwaBffException {

        return sigitextResource.getElencoIncarichi(idPersonaGiuridica);
    }

    public List<IncarichiSoggettiDelegati> getIncarichiSoggettiDelegati() throws CombustyPwaBffException {

        return sigitextResource.getIncarichiSoggettiDelegati();
    }

    public String sendEmailProva(String emailAddress) throws CombustyPwaBffException {

        return sigitextResource.sendEmailProva(emailAddress);
    }

    public Response setIncaricoSoggettoDelegato(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws CombustyPwaBffException {

        return sigitextResource.setIncaricoSoggettoDelegato(codiceFiscale, idPersonaGiuridica, idPersonaGiuridicaCat);
    }

    public Object generateTokenImpresa(Integer idPersonaGiuridica) throws CombustyPwaBffException {

        return sigitextResource.generateTokenImpresa(idPersonaGiuridica);
    }

    public Object getDatiTokenImpresa(Integer idPersonaGiuridica) throws CombustyPwaBffException {

        return sigitextResource.getDatiTokenImpresa(idPersonaGiuridica);
    }
}
