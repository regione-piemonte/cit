package it.csi.sigit.combustypwabff.resources;

import it.csi.sigit.combustypwabff.bff.dto.*;
import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.model.sigitext.SigitextDataFile;
import it.csi.sigit.combustypwabff.model.sigitext.SigitextImpiantoFiltro;
import it.csi.sigit.combustypwabff.resources.clients.SigitextClient;
import it.csi.sigit.combustypwabff.resources.clients.SigitextHttpClient;
import it.csi.sigit.combustypwabff.utils.Constants;
import it.csi.sigit.combustypwabff.utils.DocXmlExt;
import it.csi.sigit.combustypwabff.utils.MapDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class SigitextResource {

    protected static final Logger log = Logger.getLogger(Constants.APPLICATION_NAME);

    @Inject
    @RestClient
    SigitextClient sigitextClient;

    @Inject
    SigitextHttpClient sigitextHttpClient;

    public Response ping() throws CombustyPwaBffException {
        try {
            log.info("[SigitextResource:::ping] - START");
            return sigitextHttpClient.ping();
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.ping - Errore durante la chiamata al servizio ping.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio ping.");
        }
        finally {
            log.info("[SigitextResource:::ping] - STOP");
		}
    }

    public Response setAccesso(UtenteLoggato utenteLoggato) throws CombustyPwaBffException {
        try {
            log.info("[SigitextResource:::setAccesso] - START");
            return sigitextHttpClient.setAccesso(utenteLoggato);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.setAccesso - Errore durante la chiamata al servizio setAccesso.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio setAccesso.");
        }
        finally {
            log.info("[SigitextResource::setAccesso] - STOP");
		}
    }

    public Response setAccesso(String nome, String cognome, String codiceFiscale, String ruolo) throws CombustyPwaBffException {
        try {
            log.info("[SigitextResource::setAccesso] - START");
            return sigitextHttpClient.setAccesso(nome, cognome, codiceFiscale, ruolo);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.setAccesso - Errore durante la chiamata al servizio setAccesso.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio setAccesso.");
        }
        finally {
            log.info("[SigitextResource::setAccesso] - STOP");
		}
    }

    public Ruoli getRuoliDistributore(String cf, String cognome, String nome) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getRuoliDistributore] - START");
            return sigitextHttpClient.getRuoliDistributore(cf, cognome, nome);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getRuoliDistributore - Errore durante la chiamata al servizio getRuoliDistributori.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getRuoliDistributori.");
        }
        finally {
            log.info("[SigitextResource::getRuoliDistributore] - STOP");
		}
    }

//    public Response getDisponibilitaServizio(UtenteLoggato utenteLoggato, String servizio) throws CombustyPwaBffException {
//        try {
//            log.info("[SigitextResource::getDisponibilitaServizio] - START");
//            return sigitextClient.getDisponibilitaServizio(utenteLoggato, servizio);
//        } catch (Exception e) {
//            log.error("SigitextResource.getDisponibilitaServizio - Errore durante la chiamata al servizio getDisponibilitaServizio.", e);
//            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getDisponibilitaServizio.");
//        }
//        finally {
//            log.info("[SigitextResource::getDisponibilitaServizio] - STOP");
//		}
//    }

    public Response getDisponibilitaServizio(String codiceFiscale, String servizio) throws CombustyPwaBffException {
        try {
            log.info("[SigitextResource::getDisponibilitaServizio] - START");
            return sigitextHttpClient.getDisponibilitaServizio(codiceFiscale, servizio);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getDisponibilitaServizio - Errore durante la chiamata al servizio getDisponibilitaServizio.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getDisponibilitaServizio.");
        }
        finally {
            log.info("[SigitextResource::getDisponibilitaServizio] - STOP");
		}
    }

    public Accreditamento getDatiAccreditamento(String cf) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getDatiAccreditamento] - START");
            Accreditamento accreditamento = sigitextHttpClient.getDatiAccreditamento(cf);
            for (DatiDelega dl : accreditamento.getDatiDelegaList()) {
                dl.setDataInizioLegame(dl.getDataInizioLegame() + "T00:00:00Z[UTC]");
            }
            for (DatiIncarico di : accreditamento.getDatiIncaricoList()) {
                di.setDataInizioLegame(di.getDataInizioLegame() + "T00:00:00Z[UTC]");
                if (di.getDataFineLegame() != null && !di.getDataFineLegame().isEmpty())
                    di.setDataFineLegame(di.getDataFineLegame() + "T00:00:00Z[UTC]");
            }
            return accreditamento;
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getDatiImpresaDistributore - Errore durante la chiamata al servizio getDatiAccreditamento.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getDatiAccreditamento.");
        }
        finally {
            log.info("[SigitextResource::getDatiAccreditamento] - STOP");
		}
    }

    public Response getDettaglioDatiDistributoreJson(Integer idPersonaGiuridica, String anno, String mese, String tipoCaricamento, String statoFile) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getDettaglioDatiDistributoreJson] - START");
            return sigitextHttpClient.getDettaglioDatiDistributoreJson(idPersonaGiuridica, anno, mese, tipoCaricamento, statoFile);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getDatiDistributore - Errore durante la chiamata al servizio getDettaglioDatiDistributoreJson.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getDettaglioDatiDistributoreJson.");
        }
        finally {
            log.info("[SigitextResource::getDettaglioDatiDistributoreJson] - STOP");
		}
    }

    public Response getDettaglioDatiImportJson(Integer idID) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getDettaglioDatiImportJson] - START");
            return sigitextHttpClient.getDettaglioDatiImportJson(idID);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getDettaglioDatiImportJson - Errore durante la chiamata al servizio getDettaglioDatiImportJson.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getDettaglioDatiImportJson.");
        }
        finally {
            log.info("[SigitextResource::getDettaglioDatiImportJson] - STOP");
		}
    }

    public Esito setDatiDistributoreSemplificatoJson(ImportDatiDistributore importDatiDistributore, Integer idPersonaGiurida, String piva, String cf) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::setDatiDistributoreSemplificatoJson] - START");
            return sigitextHttpClient.setDatiDistributoreSemplificatoJson(idPersonaGiurida, piva, cf, importDatiDistributore);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.setDatiDistributoreSemplificatoJson - Errore durante la chiamata al servizio setDatiDistributoreSemplificatoJson.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio setDatiDistributoreSemplificatoJson.");
        }
        finally {
            log.info("[SigitextResource::setDatiDistributoreSemplificatoJson] - STOP");
		}
    }

    public String setDatiPersonaliUtente(String codiceFiscale, Persona persona) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::setDatiPersonaliUtente] - START");
            return sigitextHttpClient.setDatiPersonaliUtente(codiceFiscale, persona);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.setDatiPersonaliUtente - Errore durante la chiamata al servizio setDatiPersonaliUtente.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio setDatiPersonaliUtente.");
        }
        finally {
            log.info("[SigitextResource::setDatiPersonaliUtente] - STOP");
		}
    }

    public List<DatiImpresa> getDatiImpresa(String codiceFiscale, String siglaREA, Integer numeroREA) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getDatiImpresa] - START");
            return sigitextHttpClient.getDatiImpresa(codiceFiscale, siglaREA, numeroREA);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getDatiImpresa - Errore durante la chiamata al servizio getDatiImpresa.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getDatiImpresa.");
        }
        finally {
            log.info("[SigitextResource::getDatiImpresa] - STOP");
		}
    }

    public List<DatiImpresa> getDatiImpresaDistributore(String codiceFiscale, String siglaREA, Integer numeroREA) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getDatiImpresaDistributore] - START");
            return sigitextHttpClient.getDatiImpresaDistributore(codiceFiscale, siglaREA, numeroREA);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getDatiImpresaDistributore - Errore durante la chiamata al servizio getDatiImpresaDistributore.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getDatiImpresaDistributore.");
        }
        finally {
            log.info("[SigitextResource::getDatiImpresaDistributore] - STOP");
		}
    }

    public Response setImpresaAssociata(DatiImpresa datiImpresa, String operation, String codiceFiscale) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::setImpresaAssociata] - START");
            return sigitextHttpClient.setImpresaAssociata(MapDto.mapDatiImpresaToSigitExtDatiImpresa(datiImpresa), operation, codiceFiscale);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.setImpresaAssociata - Errore durante la chiamata al servizio setImpresaAssociata.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio setImpresaAssociata.");
        }
        finally {
            log.info("[SigitextResource::setImpresaAssociata] - STOP");
		}
    }

    public String setDelega(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersona) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::setDelega] - START");
            return sigitextHttpClient.setDelega(codiceFiscale, idPersonaGiuridica, idPersona);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.setDelega - Errore durante la chiamata al servizio setDelega.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio setDelega.");
        }
        finally {
            log.info("[SigitextResource::setDelega] - STOP");
		}
    }

    public String deleteDelega(UtenteLoggato utenteLoggato, Integer idPersona) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::deleteDelega] - START");
            return sigitextHttpClient.deleteDelega(utenteLoggato, idPersona);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.deleteDelega - Errore durante la chiamata al servizio deleteDelega.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio deleteDelega.");
        }
        finally {
            log.info("[SigitextResource::deleteDelega] - STOP");
		}
    }

    public String deleteDelegaConfirm(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersona) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::deleteDelegaConfirm] - START");
            return sigitextHttpClient.deleteDelegaConfirm(codiceFiscale, idPersonaGiuridica, idPersona);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.deleteDelegaConfirm - Errore durante la chiamata al servizio deleteDelegaConfirm.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio deleteDelegaConfirm.");
        }
        finally {
            log.info("[SigitextResource::deleteDelegaConfirm] - STOP");
		}
    }

    public String deleteIncaricoSoggettoDelegato(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::deleteIncaricoSoggettoDelegato] - START");
            return sigitextHttpClient.deleteIncaricoSoggettoDelegato(codiceFiscale, idPersonaGiuridica, idPersonaGiuridicaCat);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.deleteIncaricoSoggettoDelegato - Errore durante la chiamata al servizio deleteIncaricoSoggettoDelegato.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio deleteIncaricoSoggettoDelegato.");
        }
        finally {
            log.info("[SigitextResource::deleteIncaricoSoggettoDelegato] - STOP");
		}
    }

    public List<DatiDelega> getElencoDeleghe(Integer idPersonaGiuridica) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getElencoDeleghe] - START");
            return sigitextHttpClient.getElencoDeleghe(idPersonaGiuridica);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getElencoDeleghe - Errore durante la chiamata al servizio getElencoDeleghe.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getElencoDeleghe.");
        }
        finally {
            log.info("[SigitextResource::getElencoDeleghe] - STOP");
		}
    }

    public List<DatiIncarico> getElencoIncarichi(Integer idPersonaGiuridica) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getElencoIncarichi] - START");
            return sigitextHttpClient.getElencoIncarichi(idPersonaGiuridica);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getElencoIncarichi - Errore durante la chiamata al servizio getElencoIncarichi.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getElencoIncarichi.");
        }
        finally {
            log.info("[SigitextResource::getElencoIncarichi] - STOP");
		}
    }

    public List<IncarichiSoggettiDelegati> getIncarichiSoggettiDelegati() throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getIncarichiSoggettiDelegati] - START");
            return sigitextHttpClient.getIncarichiSoggettiDelegati();
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getIncarichiSoggettiDelegati - Errore durante la chiamata al servizio getIncarichiSoggettiDelegati.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getIncarichiSoggettiDelegati.");
        }
        finally {
            log.info("[SigitextResource::getIncarichiSoggettiDelegati] - STOP");
		}
    }

    public String sendEmailProva(String emailAddress) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::sendEmailProva] - START");
            return sigitextHttpClient.sendEmailProva(emailAddress);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.sendEmailProva - Errore durante la chiamata al servizio sendEmailProva.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio sendEmailProva.");
        }
        finally {
            log.info("[SigitextResource::sendEmailProva] - STOP");
		}
    }

    public Response setIncaricoSoggettoDelegato(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::setIncaricoSoggettoDelegato] - START");
            return sigitextHttpClient.setIncaricoSoggettoDelegato(codiceFiscale, idPersonaGiuridica, idPersonaGiuridicaCat);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.setIncaricoSoggettoDelegato - Errore durante la chiamata al servizio setIncaricoSoggettoDelegato.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio setIncaricoSoggettoDelegato.");
        }
        finally {
            log.info("[SigitextResource::setIncaricoSoggettoDelegato] - STOP");
		}
    }

    public List<Persona> cercaResponsabileProprietario(Integer tipo, String cf, String siglaRea, String numeroRea) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::cercaResponsabileProprietario] - START");
            return sigitextHttpClient.cercaResponsabileProprietario(tipo, cf, siglaRea, numeroRea);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.cercaResponsabileProprietario - Errore durante la chiamata al servizio cercaResponsabileProprietario.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio cercaResponsabileProprietario.");
        }
        finally {
            log.info("[SigitextResource::cercaResponsabileProprietario] - STOP");
		}
    }

    public List<ComuneEstesoModel> getComuniEstesi() throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getComuniEstesi] - START");
            return sigitextHttpClient.getComuniEstesi();
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getComuniEstesi - Errore durante la chiamata al servizio getComuniEstesi.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getComuniEstesi.");
        }
        finally {
            log.info("[SigitextResource::getComuniEstesi] - STOP");
		}
    }

    public Esito annullaAcquisizioneDatoDistributore(String cf, Integer idID) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::annullaAcquisizioneDatoDistributore] - START");
            return sigitextHttpClient.annullaAcquisizioneDatoDistributore(cf, idID);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.annullaAcquisizioneDatoDistributore - Errore durante la chiamata al servizio annullaAcquisizioneDatoDistributore.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio annullaAcquisizioneDatoDistributore.");
        }
        finally {
            log.info("[SigitextResource::annullaAcquisizioneDatoDistributore] - STOP");
		}
    }

    public FeatureCollection getGeoJsonImpiantoByFiltroJWT(SigitextImpiantoFiltro impiantoFiltro, String tokenJWT) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getGeoJsonImpiantoByFiltroJWT] - START");
            return sigitextHttpClient.getGeoJsonImpiantoByFiltroJWT(
                    impiantoFiltro.getCf3Responsabile(),
                    impiantoFiltro.getCfImpresa(),
                    impiantoFiltro.getCfProprietario(),
                    impiantoFiltro.getCfResponsabile(),
                    impiantoFiltro.getCivico(),
                    impiantoFiltro.getCodiceImpianto() != null ? impiantoFiltro.getCodiceImpianto().toString() : null,
                    impiantoFiltro.getDescComune(),
                    impiantoFiltro.getFkStato() != null ? impiantoFiltro.getFkStato().toString() : null,
                    impiantoFiltro.getFlagVisuProprietario() != null ? impiantoFiltro.getFlagVisuProprietario().toString() : null,
                    impiantoFiltro.getIdComune(),
                    impiantoFiltro.getIndirizzo(),
                    impiantoFiltro.getIstatComune(),
                    impiantoFiltro.getNumeroRea() != null ? impiantoFiltro.getNumeroRea().toString() : null,
                    impiantoFiltro.getPdr(),
                    impiantoFiltro.getPod(),
                    impiantoFiltro.getSiglaProvincia(),
                    impiantoFiltro.getSiglaRea(),
                    impiantoFiltro.getX(),
                    impiantoFiltro.getY(),
                    impiantoFiltro.getDistanza(),
                    tokenJWT);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getGeoJsonImpiantoByFiltroJWT - Errore durante la chiamata al servizio getGeoJsonImpiantoByFiltroJWT.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getGeoJsonImpiantoByFiltroJWT.");
        }
        finally {
            log.info("[SigitextResource::getGeoJsonImpiantoByFiltroJWT] - STOP");
		}
    }

    public Response uploadXMLDistributoreJWT(DocXml docXml, String userCf, Integer idPersonaGiuridica, Boolean sost, Integer idID, String jwt) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::uploadXMLDistributoreJWT] - START");
            return sigitextHttpClient.uploadXMLDistributoreJWT(userCf, idPersonaGiuridica, sost, idID, jwt, docXml);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.uploadXMLDistributoreJWT - Errore durante la chiamata al servizio uploadXMLDistributoreJWT.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio uploadXMLDistributoreJWT.");
        }
        finally {
            log.info("[SigitextResource::uploadXMLDistributoreJWT] - STOP");
		}
    }

    public Response preUploadXMLDistributoreJWT(DocXmlExt docXml, String userCf, Integer idPersonaGiuridica, Boolean sost, Integer idID, String jwt) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::preUploadXMLDistributoreJWT] - START");
            return sigitextHttpClient.preUploadXMLDistributoreJWT(userCf, idPersonaGiuridica, sost, idID, jwt, docXml);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.uploadXMLDistributoreJWT - Errore durante la chiamata al servizio preUploadXMLDistributoreJWT.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio preUploadXMLDistributoreJWT.");
        }
        finally {
            log.info("[SigitextResource::preUploadXMLDistributoreJWT] - STOP");
		}
    }

    public Response postUploadXMLDistributoreJWT(Integer idImport, String uidIndex) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::postUploadXMLDistributoreJWT] - START");
            return sigitextHttpClient.postUploadXMLDistributoreJWT(idImport, uidIndex);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.uploadXMLDistributoreJWT - Errore durante la chiamata al servizio uploadXMLDistributoreJWT.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio uploadXMLDistributoreJWT.");
        }
        finally {
            log.info("[SigitextResource::postUploadXMLDistributoreJWT] - STOP");
		}
    }

    public List<CodiceDescrizione> getCombustibile() throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getCombustibile] - START");
            return sigitextHttpClient.getCombustibileCIT();
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getCombustibile - Errore durante la chiamata al servizio getCombustibile.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getCombustibile.");
        }
        finally {
            log.info("[SigitextResource::getCombustibile] - STOP");
		}
    }

    public List<CodiceDescrizione> getUnitaMisura() throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getUnitaMisura] - START");
            return sigitextHttpClient.getUnitaMisuraCIT();
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getUnitaMisura - Errore durante la chiamata al servizio getUnitaMisura.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getUnitaMisura.");
        }
        finally {
            log.info("[SigitextResource::getUnitaMisura] - STOP");
		}
    }

    public Object generateTokenImpresa(Integer idPersonaGiuridica) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::generateTokenImpresa] - START");
            return sigitextHttpClient.generateTokenImpresa(idPersonaGiuridica);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.generateTokenImpresa - Errore durante la chiamata al servizio generateTokenImpresa.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio generateTokenImpresa.");
        }
        finally {
            log.info("[SigitextResource::generateTokenImpresa] - STOP");
		}
    }

    public Object getDatiTokenImpresa(Integer idPersonaGiuridica) throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getDatiTokenImpresa] - START");
            return sigitextHttpClient.getDatiTokenImpresa(idPersonaGiuridica);
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getDatiTokenImpresa - Errore durante la chiamata al servizio getDatiTokenImpresa.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getDatiTokenImpresa.");
        }
        finally {
            log.info("[SigitextResource::getDatiTokenImpresa] - STOP");
		}
    }

    public Response getGeoJsonImpiantoMaxResults() throws CombustyPwaBffException {

        try {
            log.info("[SigitextResource::getGeoJsonImpiantoMaxResults] - START");
            return sigitextHttpClient.getGeoJsonImpiantoMaxResults();
        } catch (CombustyPwaBffException e) {
            throw e;
        } catch (Exception e) {
            log.error("SigitextResource.getGeoJsonImpiantoMaxResults - Errore durante la chiamata al servizio getGeoJsonImpiantoMaxResults.", e);
            throw new CombustyPwaBffException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Errore durante la chiamata al servizio getGeoJsonImpiantoMaxResults.");
        }
        finally {
            log.info("[SigitextResource::getGeoJsonImpiantoMaxResults] - STOP");
		}
    }
}
