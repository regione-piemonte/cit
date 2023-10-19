/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.sigit.sigitext.business.be;

import it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/libretto")
@Produces({ "application/json" })
public interface LibrettoApi {
	@GET
	@Path("/uid")
	@Produces({ "application/json" })
	public Response getLibrettoByUIDJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("uid") String uid, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/xml/now")
	@Produces({ "application/json" })
	public Response getXMLLibrettoNowJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") Integer codiceImpianto, @QueryParam("consolidato") Boolean isConsolidato, @QueryParam("tokenJWT") String tokenJWT);

	@GET
	@Path("/now")
	@Produces({ "application/json" })
	public Response getLibrettoNowJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") Integer codiceImpianto, @QueryParam("consolidato") Boolean isConsolidato, @QueryParam("tokenJWT") java.lang.String tokenJWT);

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

}
