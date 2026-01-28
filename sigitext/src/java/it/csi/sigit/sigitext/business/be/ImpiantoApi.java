/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.sigit.sigitext.business.be;

import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDatoDistribDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTImportDistribDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTLogDistribDaoException;
import it.csi.sigit.sigitext.dto.sigitext.DatiImpianto;
import it.csi.sigit.sigitext.dto.sigitext.DownloadFileExcelRequest;
import it.csi.sigit.sigitext.dto.sigitext.RespPropModel;
import it.csi.sigit.sigitext.dto.sigitext.SetImpiantoModel;
import it.csi.sigit.sigitext.dto.sigitext.SubentroComponente;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.web.bind.annotation.RequestBody;

@Path("/impianto")
@Produces({ "application/json" })
public interface ImpiantoApi {

	@GET
	@Path("/filtro")
	@Produces({ "application/json" })
	public Response getImpiantiByFiltroJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("cf3-resp") String cf3Responsabile, @QueryParam("cf-impresa") String cfImpresa, @QueryParam("cf-proprietario") String cfProprietario, @QueryParam("cf-responsabile") String cfResponsabile, @QueryParam("civico") String civico, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("desc-comune") String descComune, @QueryParam("fk-stato") String fkStato, @QueryParam("flag-visu-proprietario") String flagVisuProprietario, @QueryParam("id-comune") String idComune, @QueryParam("indirizzo") String indirizzo, @QueryParam("istat-comune") String istatComune, @QueryParam("numero-rea") String numeroRea, @QueryParam("pdr") String pdr, @QueryParam("pod") String pod, @QueryParam("sigla-provincia") String siglaProvincia, @QueryParam("sigla-rea") String siglaRea, @QueryParam("x") Float x, @QueryParam("y") Float y, @QueryParam("distanza") Float distanza, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/geo/filtro")
	@Produces({ "application/json" })
	public Response getImpiantiGeoByFiltroJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("cf3-resp") String cf3Responsabile, @QueryParam("cf-impresa") String cfImpresa, @QueryParam("cf-proprietario") String cfProprietario, @QueryParam("cf-responsabile") String cfResponsabile, @QueryParam("civico") String civico, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("desc-comune") String descComune, @QueryParam("fk-stato") String fkStato, @QueryParam("flag-visu-proprietario") String flagVisuProprietario, @QueryParam("id-comune") String idComune, @QueryParam("indirizzo") String indirizzo, @QueryParam("istat-comune") String istatComune, @QueryParam("numero-rea") String numeroRea, @QueryParam("pdr") String pdr, @QueryParam("pod") String pod, @QueryParam("sigla-provincia") String siglaProvincia, @QueryParam("sigla-rea") String siglaRea, @QueryParam("x") Float x, @QueryParam("y") Float y, @QueryParam("distanza") Float distanza, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/geo/filtro/duplicatiresponsabile")
	@Produces({ "application/json" })
	public Response getImpiantiGeoByFiltroDuplicatiResponsabileJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("cf3-resp") String cf3Responsabile, @QueryParam("cf-impresa") String cfImpresa, @QueryParam("cf-proprietario") String cfProprietario, @QueryParam("cf-responsabile") String cfResponsabile, @QueryParam("civico") String civico, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("desc-comune") String descComune, @QueryParam("fk-stato") String fkStato, @QueryParam("flag-visu-proprietario") String flagVisuProprietario, @QueryParam("id-comune") String idComune, @QueryParam("indirizzo") String indirizzo, @QueryParam("istat-comune") String istatComune, @QueryParam("numero-rea") String numeroRea, @QueryParam("pdr") String pdr, @QueryParam("pod") String pod, @QueryParam("sigla-provincia") String siglaProvincia, @QueryParam("sigla-rea") String siglaRea, @QueryParam("x") Float x, @QueryParam("y") Float y, @QueryParam("distanza") Float distanza, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/geo/filtro/max")
	@Produces({ "application/json" })
	public Response getImpiantiGeoByFiltroMaxNumRecords(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/geo/filtro/maxCombusty")
	@Produces({ "application/json" })
	public Response getCombustyImpiantiGeoByFiltroMaxNumRecords(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@GET
	@Path("/codice")
	@Produces({ "application/json" })
	public Response getImpiantoByCodiceJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") Integer codiceImpianto, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/pod")
	@Produces({ "application/json" })
	public Response getImpiantoByPODJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("pod") String pod, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/pdr")
	@Produces({ "application/json" })
	public Response getImpiantoByPDRJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("pdr") String pdr, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/indirizzo")
	@Produces({ "application/json" })
	public Response getImpiantoByIndirizzoJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("indirizzo") String indirizzo, @QueryParam("civico") Integer civico, @QueryParam("istat") String istat, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/stato")
	@Produces({ "application/json" })
	public Response getStatoImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	@POST
	@Path("/setImpianto")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response setImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, SetImpiantoModel setImpiantoModel, @QueryParam("responsabilita") Integer responsabilita);

	@POST
	@Path("/setModificaImpianto")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response setModificaImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, SetImpiantoModel setImpiantoModel);

	@GET
	@Path("/resp_prop")
	@Produces({ "application/json" })
	public Response getRespProp(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("tipo") int tipo, @QueryParam("cf") String cf,@QueryParam("sigla_rea") String siglaRea, @QueryParam("numero_rea") String numeroRea);

	@POST
	@Path("/resp_prop")
	@Produces({ "application/json" })
	public Response setNuovoRespProp(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, RespPropModel respPropModel);
	
	@GET
	@Path("/consumipodpdr")
	@Produces({ "application/json" })
	public Response getConsumiByPodPdrJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice") String podPdr, @QueryParam("tokenJWT") String tokenJWT);
	
	@GET
	@Path("/manuntentori/comuni")
	@Produces({ "application/json" })
	Response getComuniPGJWT(String jwt) throws SigitExtDaoException;

	@POST
	@Path("/manuntentori")
	@Produces({ "application/json" })
	Response getManutentoriJWT(@QueryParam("denominazione") String denominazione, @QueryParam("comune") String comune, @RequestBody String jwt) throws SigitExtDaoException;
	
	@GET
	@Path("/copertinaIspezione")
	@Produces({ "application/json" })
	public Response getCopertinaIspezioneJWT(@QueryParam("idIspezione") Integer idIspezione, @QueryParam("tokenJWT") String tokenJWT);
	
	@GET
	@Path("/letteraAvviso")
	@Produces({ "application/json" })
	public Response getLetteraAvvisoJWT(@QueryParam("idIspezione") Integer idIspezione, @QueryParam("tokenJWT") String tokenJWT);
	
	@GET
	@Path("/letteraAvviso180Gg")
	@Produces({ "application/json" })
	public Response getLetteraAvviso180GgJWT(@QueryParam("idIspezione") Integer idIspezione, @QueryParam("tokenJWT") String tokenJWT);
	
	@POST
	@Path("/fileExcel")
	@Produces({ "application/json" })
	public Response getFileExcelJWT(@RequestBody DownloadFileExcelRequest downloadFileExcelRequest, @QueryParam("tokenJWT") String tokenJWT);
	
	@GET
	@Path("/compByGeoportale")
	@Produces({ "application/json" })
	public Response getComponentiGeoportaleJWT(@QueryParam("coords") String coords, @QueryParam("tc") String tipoComponente, @QueryParam("tokenJWT") String tokenJWT);
	
	@POST
	@Path("/verify")
	@Produces({"application/json"})
	Response verifyIndirizzoImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody DatiImpianto datiImpianto, @QueryParam("checkContrattoInEssere") Boolean checkContrattoInEssere);
	
	@GET
	@Path("/responsabili/elenco/storico")
	@Produces({ "application/json" })
	public Response getElencoStoricoResponsabiliImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") String codiceImpianto);
	
	@POST
	@Path("/subentro/componenti")
	@Produces({ "application/json" })
	public Response setSubentroComponente(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") String codiceImpianto, @QueryParam("id_persona_giuridica") String idPersonaGiuridica, @QueryParam("sendMail") Boolean sendMail, @RequestBody SubentroComponente subentro);

	@GET
	@Path("/datiDistributore")
	@Produces({"application/json"})
	public Response getDettaglioDatiDistributoreJson(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, UtenteLoggato utenteloggato, @QueryParam("idGP") Integer idPersonaGiuridica, @QueryParam("nr") Integer numeroRecords, @QueryParam("idID") Integer idImportDistrib, @QueryParam("idDD") Integer idDatoDistrib, @QueryParam("ord") String ordinamento, @QueryParam("filter") String filter) throws SigitTImportDistribDaoException, SigitTDatoDistribDaoException, SigitTLogDistribDaoException;

}
