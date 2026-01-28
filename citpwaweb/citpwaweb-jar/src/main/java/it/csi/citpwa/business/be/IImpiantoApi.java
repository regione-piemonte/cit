/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.be;

import it.csi.citpwa.model.DatiImpiantoModel;
import it.csi.citpwa.model.SubentroComponente;
import it.csi.citpwa.model.sigitext.DatiImpianto;
import it.csi.citpwa.model.sigitext.Persona;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/impianto")
@Produces({ "application/json" })
public interface IImpiantoApi {
	@GET
	@Path("/stato")
	@Produces({ "application/json" })
	public Response getStatoImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Path("/list")
	@Produces({ "application/json" })
	public Response getListImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("cf3-resp") String cf3Responsabile, @QueryParam("cf-impresa") String cfImpresa, @QueryParam("cf-proprietario") String cfProprietario, @QueryParam("cf-responsabile") String cfResponsabile, @QueryParam("civico") String civico, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("desc-comune") String descComune, @QueryParam("fk-stato") String fkStato, @QueryParam("flag-visu-proprietario") String flagVisuProprietario, @QueryParam("id-comune") String idComune, @QueryParam("indirizzo") String indirizzo, @QueryParam("istat-comune") String istatComune, @QueryParam("numero-rea") String numeroRea, @QueryParam("pdr") String pdr, @QueryParam("pod") String pod, @QueryParam("sigla-provincia") String siglaProvincia, @QueryParam("sigla-rea") String siglaRea, @QueryParam("x") Float x, @QueryParam("y") Float y, @QueryParam("distanza") Float distanza);

	@GET
	@Path("/geojson")
	@Produces({ "application/json" })
	public Response getGeoJsonImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("cf3-resp") String cf3Responsabile, @QueryParam("cf-impresa") String cfImpresa, @QueryParam("cf-proprietario") String cfProprietario, @QueryParam("cf-responsabile") String cfResponsabile, @QueryParam("civico") String civico, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("desc-comune") String descComune, @QueryParam("fk-stato") String fkStato, @QueryParam("flag-visu-proprietario") String flagVisuProprietario, @QueryParam("id-comune") String idComune, @QueryParam("indirizzo") String indirizzo, @QueryParam("istat-comune") String istatComune, @QueryParam("numero-rea") String numeroRea, @QueryParam("pdr") String pdr, @QueryParam("pod") String pod, @QueryParam("sigla-provincia") String siglaProvincia, @QueryParam("sigla-rea") String siglaRea, @QueryParam("x") Float x, @QueryParam("y") Float y, @QueryParam("distanza") Float distanza, @QueryParam("ricercaCompleta") Boolean ricercaCompleta);

	@GET
	@Path("/impresa/geojson")
	@Produces({ "application/json" })
	public Response getGeoJsonImpiantoByImpresa(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("cf-impresa") String cfImpresa, @QueryParam("numero-rea") String numeroRea, @QueryParam("sigla-rea") String siglaRea);

	@GET
	@Path("/responsabile/geojson/duplicati")
	@Produces({ "application/json" })
	public Response getGeoJsonImpiantoDuplicatiByResponsabile(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("cf3-resp") String cf3Responsabile, @QueryParam("cf-impresa") String cfImpresa, @QueryParam("cf-proprietario") String cfProprietario, @QueryParam("cf-responsabile") String cfResponsabile, @QueryParam("civico") String civico, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("desc-comune") String descComune, @QueryParam("fk-stato") String fkStato, @QueryParam("flag-visu-proprietario") String flagVisuProprietario, @QueryParam("id-comune") String idComune, @QueryParam("indirizzo") String indirizzo, @QueryParam("istat-comune") String istatComune, @QueryParam("numero-rea") String numeroRea, @QueryParam("pdr") String pdr, @QueryParam("pod") String pod, @QueryParam("sigla-provincia") String siglaProvincia, @QueryParam("sigla-rea") String siglaRea, @QueryParam("x") Float x, @QueryParam("y") Float y, @QueryParam("distanza") Float distanza, @QueryParam("ricercaCompleta") Boolean ricercaCompleta);

	@GET
	@Path("/geojson/max")
	@Produces({ "application/json" })
	public Response getGeoJsonImpiantoMaxResults(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Path("/indirizzo")
	@Produces({ "application/json" })
	public Response getIndirizzoImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("indirizzo") String indirizzo);

	@POST
	@Path("/setImpianto")
	@Produces({ "application/json" })
	public Response setImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, DatiImpiantoModel datiImpianto,@QueryParam("responsabilita") Integer responsabilita);

	@POST
	@Path("/setImpianto/{codice}")
	@Produces({ "application/json" })
	public Response setImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, DatiImpiantoModel datiImpianto, @PathParam("codice") String codice);

	@GET
	@Path("/pv")
	@Produces({ "application/json" })
	public Response getProvinciaImpiano(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("comune") String comune);

	@GET
	@Path("/ce")
	@Produces({ "application/json" })
	public Response getComuniEstesiImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Path("/dati-impianto")
	@Produces({ "application/json" })
	public Response getDatiImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codice);

	@GET
	@Path("/resp-prop")
	@Produces({ "application/json" })
	public Response cercaResponsabileProprietario(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("tipo") Integer tipo, @QueryParam("cf") String cf,@QueryParam("sigla-rea") String siglaRea,@QueryParam("numero-rea") String numeroRea, @QueryParam("checkAbilitazioneInsImpianto") Boolean checkAbilitazioneInsImpianto);

	@POST
	@Path("/resp-prop/{codice}")
	@Produces({ "application/json" })
	public Response setResponsabileProprietario(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @PathParam("codice") String codice, Persona persona);

	@PUT
	@Path("/resp-prop/{codice}")
	@Produces({ "application/json" })
	public Response aggiornaRespProp(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @PathParam("codice") String codice, Persona persona);

	@GET
	@Path("/pdr-duplicato")
	@Produces({ "application/json" })
	public Response pdrDuplicato(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("pdr") String pdr);

	@GET
	@Path("/pod-duplicato")
	@Produces({ "application/json" })
	public Response podDuplicato(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("pod") String pod);

	@GET
	@Path("/podpdr-duplicato")
	@Produces({ "application/json" })
	public Response podpdrDuplicato(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("pod") String pod, @QueryParam("pdr") String pdr);
	
	@POST
	@Path("/verify")
	@Produces({"application/json"})
	Response verifyIndirizzoImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody DatiImpianto datiImpianto, @QueryParam("checkContrattoInEssere") Boolean checkContrattoInEssere);
	
	@GET
	@Path("/responsabili/elenco/storico")
	@Produces({ "application/json" })
	Response getElencoStoricoResponsabiliImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") String codiceImpianto);

	@POST
	@Path("/subentro/componenti")
	@Produces({ "application/json" })
	public Response setSubentroComponente(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") String codiceImpianto, @QueryParam("id_persona_giuridica") String id_persona_giuridica, @QueryParam("sendMail") Boolean sendMail, @RequestBody SubentroComponente subentro);

	@GET
	@Path("/codice")
	@Produces({ "application/json" })
	Response getImpiantoByCodiceJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") String codiceImpianto);

}
