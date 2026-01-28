/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.be;

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

import it.csi.citpwa.model.sigitext.Scheda2;
import org.springframework.web.bind.annotation.RequestBody;

import it.csi.citpwa.model.sigitext.Scheda1;

@Path("/libretto")
@Produces({ "application/json" })
public interface ILibrettoApi {
	
	@GET
	@Path("/uid")
	@Produces({ "application/json" })
	public Response getLibrettoByCodice(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req,@QueryParam("codice-impianto")String codiceImpianto);
	
	@GET
	@Path("/dto/uid")
	@Produces({ "application/json" })
	public Response getLibrettoDtoByCodice(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req,@QueryParam("codice-impianto")String codiceImpianto);
		
	@GET
	@Path("/xml/now")
	@Produces({ "application/json" })
	Response getXmlLibrettoNowByCodice(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("consolidato") Boolean isConsolidato);

	@GET
	@Path("/xml/consolidato")
	@Produces({ "application/json" })
	Response getXMLLibrettoConsolidatoJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto);

	@POST
	@Path("/consolida")
	@Produces({ "application/json" })
	public Response consolidaLibretto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req,@QueryParam("codice-impianto")String codiceImpianto);
	
	@POST
	@Path("/setLibSch1IdImpianto")
	@Produces({"application/json"})
	Response setLibSch1IdImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") Integer codiceImpianto, @RequestBody Scheda1 scheda1);

	@POST
	@Path("/setLibSch2IdImpianto")
	@Produces({"application/json"})
	Response setLibSch2IdImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") Integer codiceImpianto, @RequestBody Scheda2 scheda2);
	
	@GET
	@Path("/now")
	@Produces({ "application/json" })
	Response getLibrettoNowJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("consolidato") Boolean isConsolidato);
	
	@GET
	@Path("/scheda-libretto")
	@Produces({ "application/json" })
	Response getSchedaLibrettoJWT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto);
	
	@GET
	@Path("/categorie")
	@Produces({ "application/json" })
	Response getCategorie();
	
	@GET
	@Path("/tipoIntervento")
	@Produces({"application/json"})
	Response getTipoIntervento(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);
	
}
