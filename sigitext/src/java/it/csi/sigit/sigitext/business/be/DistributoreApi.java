package it.csi.sigit.sigitext.business.be;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.web.bind.annotation.RequestBody;

import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDatoDistribDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTImportDistribDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTLogDistribDaoException;
import it.csi.sigit.sigitext.dto.sigitext.DocXml;
import it.csi.sigit.sigitext.dto.sigitext.ImportDatiDistributore;

														   

@Path("/distributore")
@Produces({ "application/json" })
public interface DistributoreApi {
	
	@POST
	@Path("/uploadXML")
	@Produces({"application/json"})
	public Response uploadXMLDistributoreJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("userCf") String userCf, @QueryParam("idPG") Integer idPersonaGiuridica, @QueryParam("sost") boolean sostituzione, @QueryParam("idID") Integer idImportDistrib, @QueryParam("jwt") String jwt, @RequestBody DocXml docXml);

	@GET
	@Path("/acquisizione/annulla")
	@Produces({"application/json"})
	public Response annullaAcquisizioneDatoDistributore(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("cf") String codiceFiscale, @QueryParam("idID") Integer idImportDistrib) throws SigitTImportDistribDaoException;

	@POST
	@Path("/datiDistributore")
	@Produces({"application/json"})
	public Response setDatiDistributoreSemplificatoJson(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("idPG") Integer idPersonaGiuridica, @QueryParam("piva") String piva, @QueryParam("cf") String cf, @RequestBody ImportDatiDistributore importDatiDistributore);
	
	@GET
	@Path("/datiDistributore")
	@Produces({"application/json"})
	public Response getDettaglioDatiDistributoreJson(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("idPG") Integer idPersonaGiuridica, @QueryParam("anno") String anno, @QueryParam("mese") String mese, @QueryParam("tc") String tipoCaricamento, @QueryParam("sf") String statoFile) throws SigitTImportDistribDaoException, SigitTDatoDistribDaoException, SigitTLogDistribDaoException;

	@GET
	@Path("/datiImport")
	@Produces({"application/json"})
	public Response getDettaglioDatiImportJson(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("idID") Integer idImportDistrib) throws SigitTImportDistribDaoException, SigitTDatoDistribDaoException, SigitTLogDistribDaoException;

	@POST
	@Path("/preUploadXML")
	@Produces({"application/json"})
	public Response preUploadXMLDistributoreJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("userCf") String userCf, @QueryParam("idPG") Integer idPersonaGiuridica, @QueryParam("sost") Boolean sostituzione, @QueryParam("idID") Integer idImportDistrib, @QueryParam("jwt") String jwt, @RequestBody DocXml docXml);

	@POST
	@Path("/postUploadXML")
	@Produces({"application/json"})
	public Response postUploadXMLDistributoreJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("idImport") Integer idImport, @QueryParam("uidIndex") String uidIndex);
}
