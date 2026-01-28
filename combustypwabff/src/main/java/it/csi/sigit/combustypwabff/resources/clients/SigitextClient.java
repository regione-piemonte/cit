package it.csi.sigit.combustypwabff.resources.clients;

import it.csi.sigit.combustypwabff.bff.dto.*;
import it.csi.sigit.combustypwabff.model.sigitext.SigitextDataFile;
import it.csi.sigit.combustypwabff.model.sigitext.SigitextDatiImpresa;
import it.csi.sigit.combustypwabff.providers.SigitextClientObjectMapper;
import it.csi.sigit.combustypwabff.utils.DocXmlExt;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;


@Path("")
@RegisterRestClient(configKey = "sigitext")
@RegisterProvider(SigitextClientObjectMapper.class)
public interface SigitextClient {

    @GET
    @Path("/domini/ping")
    @Consumes(MediaType.APPLICATION_JSON)
    Response ping();

    @POST
    @Path("/user/accesso")
    @Consumes(MediaType.APPLICATION_JSON)
    Response setAccesso(UtenteLoggato utenteLoggato);

    @GET
    @Path("/user/accesso")
    @Consumes(MediaType.APPLICATION_JSON)
    Response setAccesso(
            @QueryParam("nm") String nome,
            @QueryParam("cn") String cognome,
            @QueryParam("cf") String cf,
            @QueryParam("rl") String ruolo);

    @GET
    @Path("/user/distributore/ruoli")
    @Consumes(MediaType.APPLICATION_JSON)
    Ruoli getRuoliDistributore(
            @QueryParam("cf") String cf,
            @QueryParam("cognome") String cognome,
            @QueryParam("nome") String nome);

    @GET
    @Path("user/disponibilitaservizio")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response getDisponibilitaServizio(
            @QueryParam("cf") String codiceFiscale,
            @QueryParam("servizio") String servizio);

    @POST
    @Path("user/disponibilitaservizio")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response getDisponibilitaServizio(UtenteLoggato utenteLoggato,
            @QueryParam("servizio") String servizio);

    @GET
    @Path("/accreditamento/dati")
    @Consumes(MediaType.APPLICATION_JSON)
    Accreditamento getDatiAccreditamento(
            @QueryParam("codice_fiscale") String cf);

    @POST
    @Path("/accreditamento/datiPersonaliUtente")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String setDatiPersonaliUtente(
            @QueryParam("codice_fiscale") String codiceFiscalePF,
            Persona persona);

    @GET
    @Path("/accreditamento/dati/impresa")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<DatiImpresa> getDatiImpresa(
            @QueryParam("codice_fiscale") String codiceFiscale,
            @QueryParam("sigla_REA") String siglaREA,
            @QueryParam("numero_REA") Integer numeroREA);

    @GET
    @Path("/accreditamento/distributore/dati/impresa")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<DatiImpresa> getDatiImpresaDistributore(
            @QueryParam("codice_fiscale") String codiceFiscale,
            @QueryParam("sigla_REA") String siglaREA,
            @QueryParam("numero_REA") Integer numeroREA);

    @POST
    @Path("/accreditamento/impresa/set")
    @Consumes(MediaType.APPLICATION_JSON)
    Response setImpresaAssociata(SigitextDatiImpresa datiImpresa,
                               @QueryParam("operation") String operation,
                               @QueryParam("codice_fiscale") String codiceFiscale);

    @GET
    @Path("/accreditamento/delega/set")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String setDelega(
            @QueryParam("codice_fiscale") String codiceFiscale,
            @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica,
            @QueryParam("id_persona") Integer idPersona);

    @POST
    @Path("/accreditamento/delega/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String deleteDelega(UtenteLoggato utenteLoggato,
            @QueryParam("id_persona") Integer idPersona);

    @DELETE
    @Path("/accreditamento/delega/delete/confirm")
    @Produces(MediaType.APPLICATION_JSON)
    String deleteDelegaConfirm(
            @QueryParam("codice_fiscale") String codiceFiscale,
            @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica,
            @QueryParam("id_persona") Integer idPersona);

    @DELETE
    @Path("/accreditamento/delega/soggetti/incarico/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String deleteIncaricoSoggettoDelegato(
            @QueryParam("codice_fiscale") String codiceFiscale,
            @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica,
            @QueryParam("id_persona_giuridica_cat") Integer idPersonaGiuridicaCat);

    @GET
    @Path("/accreditamento/getElencoDeleghe")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<DatiDelega> getElencoDeleghe(@QueryParam("id_persona_giuridica") Integer idPersonaGiuridica);

    @GET
    @Path("/accreditamento/getElencoIncarichi")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<DatiIncarico> getElencoIncarichi(@QueryParam("id_persona_giuridica") Integer idPersonaGiuridica);

    @GET
    @Path("/accreditamento/delega/soggetti")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<IncarichiSoggettiDelegati> getIncarichiSoggettiDelegati();

    @GET
    @Path("/accreditamento/mail/send/prova")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String sendEmailProva(@QueryParam("email_address") String emailAddress);

    @GET
    @Path("/accreditamento/delega/soggetti/incarico/set")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response setIncaricoSoggettoDelegato(
            @QueryParam("codice_fiscale") String codiceFiscale,
            @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica,
            @QueryParam("id_persona_giuridica_cat") Integer idPersonaGiuridicaCat);

    @GET
    @Path("/distributore/datiDistributore")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response getDettaglioDatiDistributoreJson(
            @QueryParam("idPG") Integer idPersonaGiuridica,
            @QueryParam("anno") String anno,
            @QueryParam("mese") String mese,
            @QueryParam("tc") String tipoCaricamento,
            @QueryParam("sf") String statoFile);

    @POST
    @Path("/distributore/datiDistributore")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Esito setDatiDistributoreSemplificatoJson(
            @QueryParam("idPG") Integer idPersonaGiuridica,
            @QueryParam("piva") String piva,
            @QueryParam("cf") String codiceFiscale,
            ImportDatiDistributore importDatiDistributore);

    @GET
    @Path("/distributore/datiImport")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response getDettaglioDatiImportJson(
            @QueryParam("idID") Integer idID);

    @GET
    @Path("/distributore/acquisizione/annulla")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Esito annullaAcquisizioneDatoDistributore(
            @QueryParam("cf") String codiceFiscale,
            @QueryParam("idID") Integer idImportDistrib);

    @GET
    @Path("/impianto/resp_prop")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<Persona> cercaResponsabileProprietario(
            @QueryParam("tipo") Integer tipo,
            @QueryParam("cf") String cf,
            @QueryParam("sigla_rea") String siglaRea,
            @QueryParam("numero_rea") String numeroRea);

    @GET
    @Path("/svista/ce")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<ComuneEstesoModel> getComuniEstesi();

    @GET
    @Path("/impianto/geo/filtro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    FeatureCollection getGeoJsonImpiantoByFiltroJWT(
            @QueryParam("cf3-resp") String cf3Responsabile,
            @QueryParam("cf-impresa") String cfImpresa,
            @QueryParam("cf-proprietario") String cfProprietario,
            @QueryParam("cf-responsabile") String cfResponsabile,
            @QueryParam("civico") String civico,
            @QueryParam("codice-impianto") String codiceImpianto,
            @QueryParam("desc-comune") String descComune,
            @QueryParam("fk-stato") String fkStato,
            @QueryParam("flag-visu-proprietario") String flagVisuProprietario,
            @QueryParam("id-comune") String idComune,
            @QueryParam("indirizzo") String indirizzo,
            @QueryParam("istat-comune") String istatComune,
            @QueryParam("numero-rea") String numeroRea,
            @QueryParam("pdr") String pdr,
            @QueryParam("pod") String pod,
            @QueryParam("sigla-provincia") String siglaProvincia,
            @QueryParam("sigla-rea") String siglaRea,
            @QueryParam("x") Float x,
            @QueryParam("y") Float y,
            @QueryParam("distanza") Float distanza,
            @QueryParam("tokenJWT") String tokenJWT
    );

    @POST
    @Path("/distributore/uploadXML")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response uploadXMLDistributoreJWT(
            @QueryParam("userCf") String userCf,
            @QueryParam("idPG") Integer idPG,
            @QueryParam("sost") Boolean sost,
            @QueryParam("idID") Integer idID,
            @QueryParam("jwt") String jwt,
            DocXml docXml);

    @POST
    @Path("/distributore/preUploadXML")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response preUploadXMLDistributoreJWT(
            @QueryParam("userCf") String userCf,
            @QueryParam("idPG") Integer idPG,
            @QueryParam("sost") Boolean sost,
            @QueryParam("idID") Integer idID,
            @QueryParam("jwt") String jwt,
            DocXmlExt docXml);

    @POST
    @Path("/distributore/postUploadXML")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response postUploadXMLDistributoreJWT(
            @QueryParam("idImport") Integer idImport,
            @QueryParam("uidIndex") String uidIndex);

    @GET
    @Path("/comp/combustibile")
    @Produces(MediaType.APPLICATION_JSON)
    List<CodiceDescrizione> getCombustibileCIT();

    @GET
    @Path("/domini/unita-misura")
    @Produces(MediaType.APPLICATION_JSON)
    List<CodiceDescrizione> getUnitaMisuraCIT();

    @GET
    @Path("/accreditamento/token/impresa")
    @Produces(MediaType.APPLICATION_JSON)
    DatiToken getDatiTokenImpresa(@QueryParam("id_persona_giuridica") Integer idPersonaGiuridica);

    @PUT
    @Path("/accreditamento/token/impresa")
    @Produces(MediaType.APPLICATION_JSON)
    DatiToken generateTokenImpresa(@QueryParam("id_persona_giuridica") Integer idPersonaGiuridica);

    @GET
    @Path("/impianto/geo/filtro/maxCombusty")
    Response getGeoJsonImpiantoMaxResults();
}
