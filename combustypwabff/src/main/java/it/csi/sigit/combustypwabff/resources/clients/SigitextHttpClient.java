package it.csi.sigit.combustypwabff.resources.clients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.csi.sigit.combustypwabff.bff.dto.*;
import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.model.sigitext.SigitextDatiImpresa;
import it.csi.sigit.combustypwabff.utils.Constants;
import it.csi.sigit.combustypwabff.utils.DocXmlExt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


@ApplicationScoped
public class SigitextHttpClient {

    protected static final Logger log = Logger.getLogger(Constants.APPLICATION_NAME);

    @Inject
    @ConfigProperty(name = "quarkus.rest-client.sigitext.url")
    String sigitextBaseUrl;

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public SigitextHttpClient() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    //    @GET
    //    @Path("/domini/ping")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    Response ping();
    public Response ping() throws CombustyPwaBffException {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(sigitextBaseUrl + "/domini/ping"))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Response
                    .status(response.statusCode())
                    .entity(response.body())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        catch (IOException e) {
            log.error("SigitextHttpClient.ping - Errore durante l'invocazione del servizio sigitext.ping.", e);
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.ping.", e);
        } catch (InterruptedException e) {
            log.error("SigitextHttpClient.ping - Errore durante l'invocazione del servizio sigitext.ping.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.ping.", e);
        }
    }

    //    @POST
    //    @Path("/user/accesso")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    Response setAccesso(UtenteLoggato utenteLoggato);
    public Response setAccesso(UtenteLoggato utenteLoggato) throws CombustyPwaBffException {

        try {
            String body = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(utenteLoggato);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(sigitextBaseUrl + "/user/accesso"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Response
                    .status(response.statusCode())
                    .entity(response.body())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        catch (IOException | InterruptedException e) {
            log.error("SigitextHttpClient.setAccesso - Errore durante l'invocazione del servizio sigitext.setAccesso.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.setAccesso.", e);
        }
    }

    //    @GET
    //    @Path("/user/accesso")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    Response setAccesso(
    //            @QueryParam("nm") String nome,
    //            @QueryParam("cn") String cognome,
    //            @QueryParam("cf") String cf,
    //            @QueryParam("rl") String ruolo);
    public Response setAccesso(String nome, String cognome, String codiceFiscale, String ruolo) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/user/accesso")
                    .addParameter("nm", nome)
                    .addParameter("cn", cognome)
                    .addParameter("cf", codiceFiscale)
                    .addParameter("ruolo", ruolo)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Response
                    .status(response.statusCode())
                    .entity(response.body())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.setAccesso - Errore durante l'invocazione del servizio sigitext.setAccesso.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.setAccesso.", e);
        }
    }

    //    @GET
    //    @Path("/user/distributore/ruoli")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    Ruoli getRuoliDistributore(
    //            @QueryParam("cf") String cf,
    //            @QueryParam("cognome") String cognome,
    //            @QueryParam("nome") String nome);
    public Ruoli getRuoliDistributore(String codiceFiscale, String nome, String cognome) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/user/distributore/ruoli")
                    .addParameter("nome", nome)
                    .addParameter("cognome", cognome)
                    .addParameter("cf", codiceFiscale)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<Ruoli>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getRuoliDistributore - Errore durante l'invocazione del servizio sigitext.getRuoliDistributore.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getRuoliDistributore.", e);
        }
    }

    //    @GET
    //    @Path("user/disponibilitaservizio")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    Response getDisponibilitaServizio(
    //            @QueryParam("cf") String codiceFiscale,
    //            @QueryParam("servizio") String servizio);
    public Response getDisponibilitaServizio(String codiceFiscale, String servizio) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/user/disponibilitaservizio")
                    .addParameter("cf", codiceFiscale)
                    .addParameter("servizio", servizio)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Response
                    .status(response.statusCode())
                    .entity(response.body())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getDisponibilitaServizio - Errore durante l'invocazione del servizio sigitext.getDisponibilitaServizio.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getDisponibilitaServizio.", e);
        }
    }

    //    @POST
    //    @Path("user/disponibilitaservizio")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    Response getDisponibilitaServizio(UtenteLoggato utenteLoggato,
    //            @QueryParam("servizio") String servizio);

    //    @GET
    //    @Path("/accreditamento/dati")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    Accreditamento getDatiAccreditamento(
    //            @QueryParam("codice_fiscale") String cf);
    public Accreditamento getDatiAccreditamento(String codiceFiscale) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/dati")
                    .addParameter("codice_fiscale", codiceFiscale)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<Accreditamento>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getDatiAccreditamento - Errore durante l'invocazione del servizio sigitext.getDatiAccreditamento.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getDatiAccreditamento.", e);
        }
    }

    //    @POST
    //    @Path("/accreditamento/datiPersonaliUtente")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    String setDatiPersonaliUtente(
    //            @QueryParam("codice_fiscale") String codiceFiscalePF,
    //            Persona persona);
    public String setDatiPersonaliUtente(String codiceFiscalePF, Persona persona) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/datiPersonaliUtente")
                    .addParameter("codice_fiscale", codiceFiscalePF)
                    .build();

            String body = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(persona);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.setDatiPersonaliUtente - Errore durante l'invocazione del servizio sigitext.setDatiPersonaliUtente.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.setDatiPersonaliUtente.", e);
        }
    }

    //    @GET
    //    @Path("/accreditamento/dati/impresa")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    List<DatiImpresa> getDatiImpresa(
    //            @QueryParam("codice_fiscale") String codiceFiscale,
    //            @QueryParam("sigla_REA") String siglaREA,
    //            @QueryParam("numero_REA") Integer numeroREA);
    public List<DatiImpresa> getDatiImpresa(String codiceFiscale, String siglaREA, Integer numeroREA) throws CombustyPwaBffException {

        try {
            URIBuilder uriBuilder = new URIBuilder(sigitextBaseUrl + "/accreditamento/dati/impresa");

            if (codiceFiscale != null && !codiceFiscale.isEmpty())
                uriBuilder.addParameter("codice_fiscale", codiceFiscale);
            if (siglaREA != null && !siglaREA.isEmpty())
                uriBuilder.addParameter("sigla_REA", siglaREA);
            if (numeroREA != null)
                uriBuilder.addParameter("numero_REA", numeroREA.toString());

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uriBuilder.build())
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<List<DatiImpresa>>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getDatiImpresa - Errore durante l'invocazione del servizio sigitext.getDatiImpresa.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getDatiImpresa.", e);
        }
    }

    //    @GET
    //    @Path("/accreditamento/distributore/dati/impresa")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    List<DatiImpresa> getDatiImpresaDistributore(
    //            @QueryParam("codice_fiscale") String codiceFiscale,
    //            @QueryParam("sigla_REA") String siglaREA,
    //            @QueryParam("numero_REA") Integer numeroREA);
    public List<DatiImpresa> getDatiImpresaDistributore(String codiceFiscale, String siglaREA, Integer numeroREA) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/distributore/dati/impresa")
                    .addParameter("codice_fiscale", codiceFiscale)
                    .addParameter("sigla_REA", siglaREA)
                    .addParameter("numero_REA", numeroREA.toString())
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<List<DatiImpresa>>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getDatiImpresaDistributore - Errore durante l'invocazione del servizio sigitext.getDatiImpresaDistributore.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getDatiImpresaDistributore.", e);
        }
    }

    //    @POST
    //    @Path("/accreditamento/impresa/set")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    Response setImpresaAssociata(SigitextDatiImpresa datiImpresa,
    //                               @QueryParam("operation") String operation,
    //                               @QueryParam("codice_fiscale") String codiceFiscale);
    public Response setImpresaAssociata(SigitextDatiImpresa datiImpresa, String operation, String codiceFiscale) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/impresa/set")
                    .addParameter("operation", operation)
                    .addParameter("codice_fiscale", codiceFiscale)
                    .build();

            String body = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(datiImpresa);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Response
                    .status(response.statusCode())
                    .entity(response.body())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.setImpresaAssociata - Errore durante l'invocazione del servizio sigitext.setImpresaAssociata.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.setImpresaAssociata.", e);
        }
    }

    //    @GET
    //    @Path("/accreditamento/delega/set")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    String setDelega(
    //            @QueryParam("codice_fiscale") String codiceFiscale,
    //            @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica,
    //            @QueryParam("id_persona") Integer idPersona);
    public String setDelega(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersona) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/delega/set")
                    .addParameter("codice_fiscale", codiceFiscale)
                    .addParameter("id_persona_giuridica", idPersonaGiuridica.toString())
                    .addParameter("id_persona", idPersona.toString())
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
            //return objectMapper.readValue(response.body(), new TypeReference<String>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.setDelega - Errore durante l'invocazione del servizio sigitext.setDelega.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.setDelega.", e);
        }
    }

    //    @POST
    //    @Path("/accreditamento/delega/delete")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    String deleteDelega(UtenteLoggato utenteLoggato,
    //            @QueryParam("id_persona") Integer idPersona);
    public String deleteDelega(UtenteLoggato utenteLoggato, Integer idPersona) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/delega/delete")
                    .addParameter("id_persona", idPersona.toString())
                    .build();

            String body = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(utenteLoggato);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
            //return objectMapper.readValue(response.body(), new TypeReference<String>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.deleteDelega - Errore durante l'invocazione del servizio sigitext.deleteDelega.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.deleteDelega.", e);
        }
    }

    //    @DELETE
    //    @Path("/accreditamento/delega/delete/confirm")
    //    @Produces(MediaType.APPLICATION_JSON)
    //    String deleteDelegaConfirm(
    //            @QueryParam("codice_fiscale") String codiceFiscale,
    //            @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica,
    //            @QueryParam("id_persona") Integer idPersona);
    public String deleteDelegaConfirm(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersona) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/delega/delete/confirm")
                    .addParameter("codice_fiscale", codiceFiscale)
                    .addParameter("id_persona_giuridica", idPersonaGiuridica.toString())
                    .addParameter("id_persona", idPersona.toString())
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .DELETE()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
            //return objectMapper.readValue(response.body(), new TypeReference<String>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.deleteDelegaConfirm - Errore durante l'invocazione del servizio sigitext.deleteDelegaConfirm.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.deleteDelegaConfirm.", e);
        }
    }

    //    @DELETE
    //    @Path("/accreditamento/delega/soggetti/incarico/delete")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    String deleteIncaricoSoggettoDelegato(
    //            @QueryParam("codice_fiscale") String codiceFiscale,
    //            @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica,
    //            @QueryParam("id_persona_giuridica_cat") Integer idPersonaGiuridicaCat);
    public String deleteIncaricoSoggettoDelegato(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/delega/soggetti/incarico/delete")
                    .addParameter("codice_fiscale", codiceFiscale)
                    .addParameter("id_persona_giuridica", idPersonaGiuridica.toString())
                    .addParameter("id_persona_giuridica_cat", idPersonaGiuridicaCat.toString())
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .DELETE()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
            //return objectMapper.readValue(response.body(), new TypeReference<String>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.deleteIncaricoSoggettoDelegato - Errore durante l'invocazione del servizio sigitext.deleteIncaricoSoggettoDelegato.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.deleteIncaricoSoggettoDelegato.", e);
        }
    }

    //    @GET
    //    @Path("/accreditamento/getElencoDeleghe")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    List<DatiDelega> getElencoDeleghe(@QueryParam("id_persona_giuridica") Integer idPersonaGiuridica);
    public List<DatiDelega> getElencoDeleghe(Integer idPersonaGiuridica) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/getElencoDeleghe")
                    .addParameter("id_persona_giuridica", idPersonaGiuridica.toString())
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<List<DatiDelega>>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getElencoDeleghe - Errore durante l'invocazione del servizio sigitext.getElencoDeleghe.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getElencoDeleghe.", e);
        }
    }

    //    @GET
    //    @Path("/accreditamento/getElencoIncarichi")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    List<DatiIncarico> getElencoIncarichi(@QueryParam("id_persona_giuridica") Integer idPersonaGiuridica);
    public List<DatiIncarico> getElencoIncarichi(Integer idPersonaGiuridica) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/getElencoIncarichi")
                    .addParameter("id_persona_giuridica", idPersonaGiuridica.toString())
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<List<DatiIncarico>>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getElencoIncarichi - Errore durante l'invocazione del servizio sigitext.getElencoIncarichi.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getElencoIncarichi.", e);
        }
    }

    //    @GET
    //    @Path("/accreditamento/delega/soggetti")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    List<IncarichiSoggettiDelegati> getIncarichiSoggettiDelegati();
    public List<IncarichiSoggettiDelegati> getIncarichiSoggettiDelegati() throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/delega/soggetti")
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<List<IncarichiSoggettiDelegati>>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getIncarichiSoggettiDelegati - Errore durante l'invocazione del servizio sigitext.getIncarichiSoggettiDelegati.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getIncarichiSoggettiDelegati.", e);
        }
    }

    //    @GET
    //    @Path("/accreditamento/mail/send/prova")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    String sendEmailProva(@QueryParam("email_address") String emailAddress);
    public String sendEmailProva(String emailAddress) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/mail/send/prova")
                    .addParameter("email_address", emailAddress)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
            //return objectMapper.readValue(response.body(), new TypeReference<String>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.sendEmailProva - Errore durante l'invocazione del servizio sigitext.sendEmailProva.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.sendEmailProva.", e);
        }
    }

    //    @GET
    //    @Path("/accreditamento/delega/soggetti/incarico/set")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    Response setIncaricoSoggettoDelegato(
    //            @QueryParam("codice_fiscale") String codiceFiscale,
    //            @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica,
    //            @QueryParam("id_persona_giuridica_cat") Integer idPersonaGiuridicaCat);
    public Response setIncaricoSoggettoDelegato(String codiceFiscale, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/delega/soggetti/incarico/set")
                    .addParameter("codice_fiscale", codiceFiscale)
                    .addParameter("id_persona_giuridica", idPersonaGiuridica.toString())
                    .addParameter("id_persona_giuridica_cat", idPersonaGiuridicaCat.toString())
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Response
                    .status(response.statusCode())
                    .entity(response.body())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.setIncaricoSoggettoDelegato - Errore durante l'invocazione del servizio sigitext.setIncaricoSoggettoDelegato.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.setIncaricoSoggettoDelegato.", e);
        }
    }

    //    @GET
    //    @Path("/distributore/datiDistributore")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    Response getDettaglioDatiDistributoreJson(
    //            @QueryParam("idPG") Integer idPersonaGiuridica,
    //            @QueryParam("anno") String anno,
    //            @QueryParam("mese") String mese,
    //            @QueryParam("tc") String tipoCaricamento,
    //            @QueryParam("sf") String statoFile);
    public Response getDettaglioDatiDistributoreJson(Integer idPersonaGiuridica, String anno, String mese, String tipoCaricamento, String statoFile) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/distributore/datiDistributore")
                    .addParameter("idPG", idPersonaGiuridica.toString())
                    .addParameter("anno", anno)
                    .addParameter("mese", mese)
                    .addParameter("tc", tipoCaricamento)
                    .addParameter("sf", statoFile)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Response
                    .status(response.statusCode())
                    .entity(response.body())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getDettaglioDatiDistributoreJson - Errore durante l'invocazione del servizio sigitext.getDettaglioDatiDistributoreJson.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getDettaglioDatiDistributoreJson.", e);
        }
    }

    //    @POST
    //    @Path("/distributore/datiDistributore")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    Esito setDatiDistributoreSemplificatoJson(
    //            @QueryParam("idPG") Integer idPersonaGiuridica,
    //            @QueryParam("piva") String piva,
    //            @QueryParam("cf") String codiceFiscale,
    //            ImportDatiDistributore importDatiDistributore);
    public Esito setDatiDistributoreSemplificatoJson(Integer idPersonaGiuridica, String piva, String codiceFiscale, ImportDatiDistributore importDatiDistributore) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/distributore/datiDistributore")
                    .addParameter("idPG", idPersonaGiuridica.toString())
                    .addParameter("piva", piva)
                    .addParameter("cf", codiceFiscale)
                    .build();

            String body = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(importDatiDistributore);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<Esito>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.setDatiDistributoreSemplificatoJson - Errore durante l'invocazione del servizio sigitext.setDatiDistributoreSemplificatoJson.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.setDatiDistributoreSemplificatoJson.", e);
        }
    }

    //    @GET
    //    @Path("/distributore/datiImport")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    Response getDettaglioDatiImportJson(
    //            @QueryParam("idID") Integer idID);
    public Response getDettaglioDatiImportJson(Integer idID) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/distributore/datiImport")
                    .addParameter("idID", idID.toString())
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Response
                    .status(response.statusCode())
                    .entity(response.body())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getDettaglioDatiImportJson - Errore durante l'invocazione del servizio sigitext.getDettaglioDatiImportJson.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getDettaglioDatiImportJson.", e);
        }
    }

    //    @GET
    //    @Path("/distributore/acquisizione/annulla")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    Esito annullaAcquisizioneDatoDistributore(
    //            @QueryParam("cf") String codiceFiscale,
    //            @QueryParam("idID") Integer idImportDistrib);
    public Esito annullaAcquisizioneDatoDistributore(String codiceFiscale, Integer idImportDistrib) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/distributore/acquisizione/annulla")
                    .addParameter("cf", codiceFiscale)
                    .addParameter("idID", idImportDistrib.toString())
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<Esito>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.annullaAcquisizioneDatoDistributore - Errore durante l'invocazione del servizio sigitext.annullaAcquisizioneDatoDistributore.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.annullaAcquisizioneDatoDistributore.", e);
        }
    }

    //    @GET
    //    @Path("/impianto/resp_prop")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    List<Persona> cercaResponsabileProprietario(
    //            @QueryParam("tipo") Integer tipo,
    //            @QueryParam("cf") String cf,
    //            @QueryParam("sigla_rea") String siglaRea,
    //            @QueryParam("numero_rea") String numeroRea);
    public List<Persona> cercaResponsabileProprietario(Integer tipo,String cf, String siglaRea, String numeroRea) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/impianto/resp_prop")
                    .addParameter("tipo", tipo.toString())
                    .addParameter("cf", cf)
                    .addParameter("sigla_rea", siglaRea)
                    .addParameter("numero_rea", numeroRea)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<List<Persona>>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.cercaResponsabileProprietario - Errore durante l'invocazione del servizio sigitext.cercaResponsabileProprietario.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.cercaResponsabileProprietario.", e);
        }
    }

    //    @GET
    //    @Path("/svista/ce")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    List<ComuneEstesoModel> getComuniEstesi();
    public List<ComuneEstesoModel> getComuniEstesi() throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/svista/ce")
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<List<ComuneEstesoModel>>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getComuniEstesi - Errore durante l'invocazione del servizio sigitext.getComuniEstesi.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getComuniEstesi.", e);
        }
    }

    //    @GET
    //    @Path("/impianto/geo/filtro")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    FeatureCollection getGeoJsonImpiantoByFiltroJWT(
    //            @QueryParam("cf3-resp") String cf3Responsabile,
    //            @QueryParam("cf-impresa") String cfImpresa,
    //            @QueryParam("cf-proprietario") String cfProprietario,
    //            @QueryParam("cf-responsabile") String cfResponsabile,
    //            @QueryParam("civico") String civico,
    //            @QueryParam("codice-impianto") String codiceImpianto,
    //            @QueryParam("desc-comune") String descComune,
    //            @QueryParam("fk-stato") String fkStato,
    //            @QueryParam("flag-visu-proprietario") String flagVisuProprietario,
    //            @QueryParam("id-comune") String idComune,
    //            @QueryParam("indirizzo") String indirizzo,
    //            @QueryParam("istat-comune") String istatComune,
    //            @QueryParam("numero-rea") String numeroRea,
    //            @QueryParam("pdr") String pdr,
    //            @QueryParam("pod") String pod,
    //            @QueryParam("sigla-provincia") String siglaProvincia,
    //            @QueryParam("sigla-rea") String siglaRea,
    //            @QueryParam("x") Float x,
    //            @QueryParam("y") Float y,
    //            @QueryParam("distanza") Float distanza,
    //            @QueryParam("tokenJWT") String tokenJWT
    //    );
    public FeatureCollection getGeoJsonImpiantoByFiltroJWT(String cf3Responsabile, String cfImpresa, String cfProprietario,
                                                           String cfResponsabile, String civico, String codiceImpianto,
                                                           String descComune, String fkStato, String flagVisuProprietario,
                                                           String idComune, String indirizzo, String istatComune, String numeroRea,
                                                           String pdr, String pod, String siglaProvincia, String siglaRea,
                                                           Float x, Float y, Float distanza, String tokenJWT) throws CombustyPwaBffException {

        try {
            URIBuilder uriBuilder = new URIBuilder(sigitextBaseUrl + "/impianto/geo/filtro")
                    .addParameter("cf3-resp", cf3Responsabile)
                    .addParameter("cf-impresa", cfImpresa)
                    .addParameter("cf-proprietario", cfProprietario)
                    .addParameter("cf-responsabile", cfResponsabile)
                    .addParameter("civico", civico)
                    .addParameter("codice-impianto", codiceImpianto)
                    .addParameter("desc-comune", descComune)
                    .addParameter("fk-stato", fkStato)
                    .addParameter("flag-visu-proprietario", flagVisuProprietario)
                    .addParameter("id-comune", idComune)
                    .addParameter("indirizzo", indirizzo)
                    .addParameter("istat-comune", istatComune)
                    .addParameter("numero-rea", numeroRea)
                    .addParameter("pdr", pdr)
                    .addParameter("pod", pod)
                    .addParameter("sigla-provincia", siglaProvincia)
                    .addParameter("sigla-rea", siglaRea)
                    .addParameter("tokenJWT", tokenJWT);

            if (x != null)
                uriBuilder.addParameter("x", x.toString());
            if (y != null)
                uriBuilder.addParameter("y", y.toString());
            if (distanza != null)
                uriBuilder.addParameter("distanza", distanza.toString());

//            URI uri = new URIBuilder(sigitextBaseUrl + "/impianto/geo/filtro")
//                    .addParameter("cf3-resp", cf3Responsabile)
//                    .addParameter("cf-impresa", cfImpresa)
//                    .addParameter("cf-proprietario", cfProprietario)
//                    .addParameter("cf-responsabile", cfResponsabile)
//                    .addParameter("civico", civico)
//                    .addParameter("codice-impianto", codiceImpianto)
//                    .addParameter("desc-comune", descComune)
//                    .addParameter("fk-stato", fkStato)
//                    .addParameter("flag-visu-proprietario", flagVisuProprietario)
//                    .addParameter("id-comune", idComune)
//                    .addParameter("indirizzo", indirizzo)
//                    .addParameter("istat-comune", istatComune)
//                    .addParameter("numero-rea", numeroRea)
//                    .addParameter("pdr", pdr)
//                    .addParameter("pod", pod)
//                    .addParameter("sigla-provincia", siglaProvincia)
//                    .addParameter("sigla-rea", siglaRea)
//                    .addParameter("x", x != null ? x.toString() : "null")
//                    .addParameter("y", y != null ? y.toString() : "null")
//                    .addParameter("distanza", distanza != null ? distanza.toString() : "null")
//                    .addParameter("tokenJWT", tokenJWT)
//                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uriBuilder.build())
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<FeatureCollection>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getGeoJsonImpiantoByFiltroJWT - Errore durante l'invocazione del servizio sigitext.getGeoJsonImpiantoByFiltroJWT.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getGeoJsonImpiantoByFiltroJWT.", e);
        }
    }

    //    @POST
    //    @Path("/distributore/uploadXML")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    Response uploadXMLDistributoreJWT(
    //            @QueryParam("userCf") String userCf,
    //            @QueryParam("idPG") Integer idPG,
    //            @QueryParam("sost") Boolean sost,
    //            @QueryParam("idID") Integer idID,
    //            @QueryParam("jwt") String jwt,
    //            DocXml docXml);
    public Response uploadXMLDistributoreJWT(String userCf, Integer idPG, Boolean sost, Integer idID, String jwt, DocXml docXml) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/distributore/uploadXML")
                    .addParameter("userCf", userCf)
                    .addParameter("idPG", idPG.toString())
                    .addParameter("sost", sost.toString())
                    .addParameter("idID", idID.toString())
                    .addParameter("jwt", jwt)
                    .build();

            String body = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(docXml);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Response
                    .status(response.statusCode())
                    .entity(response.body())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.uploadXMLDistributoreJWT - Errore durante l'invocazione del servizio sigitext.uploadXMLDistributoreJWT.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.uploadXMLDistributoreJWT.", e);
        }
    }

    //    @POST
    //    @Path("/distributore/preUploadXML")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    Response preUploadXMLDistributoreJWT(
    //            @QueryParam("userCf") String userCf,
    //            @QueryParam("idPG") Integer idPG,
    //            @QueryParam("sost") Boolean sost,
    //            @QueryParam("idID") Integer idID,
    //            @QueryParam("jwt") String jwt,
    //            DocXmlExt docXml);
    public Response preUploadXMLDistributoreJWT(String userCf, Integer idPG, Boolean sost, Integer idID, String jwt, DocXmlExt docXml) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/distributore/preUploadXML")
                    .addParameter("userCf", userCf)
                    .addParameter("idPG", idPG.toString())
                    .addParameter("sost", sost.toString())
                    .addParameter("idID", idID != null ? idID.toString() : "0")
                    .addParameter("jwt", jwt)
                    .build();

            String body = objectMapper
                    //.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(docXml);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Response
                    .status(response.statusCode())
                    .entity(response.body())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.preUploadXMLDistributoreJWT - Errore durante l'invocazione del servizio sigitext.preUploadXMLDistributoreJWT.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.preUploadXMLDistributoreJWT.", e);
        }
    }

    //    @POST
    //    @Path("/distributore/postUploadXML")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    @Produces(MediaType.APPLICATION_JSON)
    //    Response postUploadXMLDistributoreJWT(
    //            @QueryParam("idImport") Integer idImport,
    //            @QueryParam("uidIndex") String uidIndex);
    public Response postUploadXMLDistributoreJWT(Integer idImport, String uidIndex) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/distributore/postUploadXML")
                    .addParameter("idImport", idImport.toString())
                    .addParameter("uidIndex", uidIndex)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Response
                    .status(response.statusCode())
                    .entity(response.body())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.postUploadXMLDistributoreJWT - Errore durante l'invocazione del servizio sigitext.postUploadXMLDistributoreJWT.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.postUploadXMLDistributoreJWT.", e);
        }
    }
    //    @GET
    //    @Path("/comp/combustibile")
    //    @Produces(MediaType.APPLICATION_JSON)
    //    List<CodiceDescrizione> getCombustibileCIT();
    public List<CodiceDescrizione> getCombustibileCIT() throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/comp/combustibile")
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<List<CodiceDescrizione>>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getCombustibileCIT - Errore durante l'invocazione del servizio sigitext.getCombustibileCIT.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getCombustibileCIT.", e);
        }
    }
    //    @GET
    //    @Path("/domini/unita-misura")
    //    @Produces(MediaType.APPLICATION_JSON)
    //    List<CodiceDescrizione> getUnitaMisuraCIT();
    public List<CodiceDescrizione> getUnitaMisuraCIT() throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/domini/unita-misura")
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<List<CodiceDescrizione>>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getUnitaMisuraCIT - Errore durante l'invocazione del servizio sigitext.getUnitaMisuraCIT.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getUnitaMisuraCIT.", e);
        }
    }
    //    @GET
    //    @Path("/accreditamento/token/impresa")
    //    @Produces(MediaType.APPLICATION_JSON)
    //    DatiToken getDatiTokenImpresa(@QueryParam("id_persona_giuridica") Integer idPersonaGiuridica);
    public DatiToken getDatiTokenImpresa(Integer idPersonaGiuridica) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/token/impresa")
                    .addParameter("id_persona_giuridica", idPersonaGiuridica.toString())
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<DatiToken>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getDatiTokenImpresa - Errore durante l'invocazione del servizio sigitext.getDatiTokenImpresa.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getDatiTokenImpresa.", e);
        }
    }

    //    @PUT
    //    @Path("/accreditamento/token/impresa")
    //    @Produces(MediaType.APPLICATION_JSON)
    //    DatiToken generateTokenImpresa(@QueryParam("id_persona_giuridica") Integer idPersonaGiuridica);
    public DatiToken generateTokenImpresa(Integer idPersonaGiuridica) throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/accreditamento/token/impresa")
                    .addParameter("id_persona_giuridica", idPersonaGiuridica.toString())
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .PUT(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<DatiToken>() { });
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.generateTokenImpresa - Errore durante l'invocazione del servizio sigitext.generateTokenImpresa.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.generateTokenImpresa.", e);
        }
    }

    //    @GET
    //    @Path("/impianto/geo/filtro/maxCombusty")
    //    Response getGeoJsonImpiantoMaxResults();
    public Response getGeoJsonImpiantoMaxResults() throws CombustyPwaBffException {

        try {
            URI uri = new URIBuilder(sigitextBaseUrl + "/impianto/geo/filtro/maxCombusty")
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Response
                    .status(response.statusCode())
                    .entity(response.body())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("SigitextHttpClient.getGeoJsonImpiantoMaxResults - Errore durante l'invocazione del servizio sigitext.getGeoJsonImpiantoMaxResults.", e);
            Thread.currentThread().interrupt();
            throw new CombustyPwaBffException(500, "Errore durante l'invocazione del servizio sigitext.getGeoJsonImpiantoMaxResults.", e);
        }
    }

}
