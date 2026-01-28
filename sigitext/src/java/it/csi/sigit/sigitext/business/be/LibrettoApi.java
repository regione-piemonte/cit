/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.sigit.sigitext.business.be;

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

import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitext.dto.sigitext.Scheda1;
import it.csi.sigit.sigitext.dto.sigitext.Scheda2;

@Path("/libretto")
@Produces({ "application/json" })
public interface LibrettoApi {
	@GET
	@Path("/uid")
	@Produces({ "application/json" })
	public Response getLibrettoByUIDJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("uid") String uid, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/dto/uid")
	@Produces({ "application/json" })
	public Response getLibrettoDtoByUIDJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("uid") String uid);

	@GET
	@Path("/xml/now")
	@Produces({ "application/json" })
	public Response getXMLLibrettoNowJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") Integer codiceImpianto, @QueryParam("consolidato") Boolean isConsolidato, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/now")
	@Produces({ "application/json" })
	public Response getLibrettoNowJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") Integer codiceImpianto, @QueryParam("consolidato") Boolean isConsolidato, @QueryParam("tokenJWT") java.lang.String tokenJWT);
	
	@GET
	@Path("/scheda-libretto")
	@Produces({ "application/json" })
	public Response getSchedaLibrettoJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") Integer codiceImpianto, @QueryParam("tokenJWT") java.lang.String tokenJWT);

	@GET
	@Path("/xml/consolidato")
	@Produces({ "application/json" })
	public Response getXMLLibrettoConsolidatoJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") Integer codiceImpianto, @QueryParam("tokenJWT") String tokenJWT);

	@POST
	@Path("/xml")
	@Produces({ "application/json" })
	public Response uploadXMLLibrettoJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") Integer codiceImpianto, byte[] xml, @QueryParam("tokenJWT") String tokenJWT);

	@POST
	@Path("/controllo/xml")
	@Produces({ "application/json" })
	public Response uploadXMLControlloJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") Integer codiceImpianto, @QueryParam("tipo-controllo") String tipoControllo, byte[] xml, @QueryParam("tokenJWT") String tokenJWT);

	@POST
	@Path("/consolida")
	@Produces({ "application/json" })
	public Response consolidaLibretto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("id-impresa") Integer idImpresa, @QueryParam("ruolo") String descrizioneRuolo, @QueryParam("codice-rea") String codiceRea, @QueryParam("cf") String cfUtenteMod);
	
	@GET
	@Path("/manuntentori/comuni")
	@Produces({ "application/json" })
	Response getComuniPGJWT(@QueryParam("token") String jwt) throws SigitExtDaoException;

	@POST
	@Path("/manuntentori")
	@Produces({ "application/json" })
	Response getManutentoriJWT(@RequestBody String jwt, @QueryParam("denominazione") String denominazione, @QueryParam("comune") String comune) throws SigitExtDaoException;
	
	@POST
	@Path("/setLibSch1IdImpianto")
	@Produces({"application/json"})
	Response setLibSch1IdImpianto(@QueryParam("codice-impianto") Integer codiceImpianto, @RequestBody Scheda1 scheda1, @QueryParam("cfUtenteLoggato") String cfUtenteLoggato) throws SigitExtDaoException;
	
	@POST
	@Path("/setLibSch2IdImpianto")
	@Produces({"application/json"})
	Response setLibSch2IdImpianto(@QueryParam("codice-impianto") Integer codiceImpianto, @RequestBody Scheda2 scheda2, @QueryParam("cfUtenteLoggato") String cfUtenteLoggato) throws SigitExtDaoException;
	
	
	@GET
	@Path("/tipoIntervento")
	@Produces({"application/json"})
	Response getTipoIntervento(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);
	
	@GET
	@Path("/categorie")
	@Produces({ "application/json" })
	Response getCategorie();

}
