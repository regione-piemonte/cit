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

import it.csi.sigit.sigitext.dto.sigitext.DatiAffidamento;
import it.csi.sigit.sigitext.dto.sigitext.RequestTerzoResponsabile;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;

@Path("/nominaterzoresponsabile")
@Produces({ "application/json" })
public interface NominaTerzoResponsabileApi {
	
	@GET
	@Path("/dettaglio")
	@Produces({"application/json"})
	Response getDettaglioNomina(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id_contratto") Integer idContratto, @QueryParam("codice_impianto") Integer codiceImpianto);
	
	@POST
	@Path("/delete/affidamento")
	@Produces({"application/json"})
	Response deleteAffidamento(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_fiscale") String codiceFiscale, @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica, @QueryParam("codice_impianto") Integer codiceImpianto, @RequestBody DatiAffidamento datiAffidamento);

	@GET
	@Path("/tipo/cessazione")
	@Produces({"application/json"})
	Response getTipoCessazione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);
	
	@GET
	@Path("/tipo/autodichiarazione")
	@Produces({"application/json"})
	Response getTipoAutodichiarazione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);
	
	@POST
	@Path("/cessazione/set")
	@Produces({"application/json"})
	Response setCessazione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody RequestTerzoResponsabile request);
	
	@POST
	@Path("/proroga/set")
	@Produces({"application/json"})
	Response setProroga(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody RequestTerzoResponsabile request);
	
	@POST
	@Path("/subentro/impianto/set")
	@Produces({"application/json"})
	Response setSubentrosuImpianto(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_fiscale") String codiceFiscale, @QueryParam("id_persona") Integer idPersona, 
			@QueryParam("codice_impianto") Integer codiceImpianto, @QueryParam("des_ruolo") String desRuolo, @RequestBody UtenteLoggato utenteLoggato);
	
	@POST
	@Path("/verify/contratto")
	@Produces({"application/json"})
	Response verifyContrattoTerzoResponsabile(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody RequestTerzoResponsabile requestVerifyContratto);
	
	@POST
	@Path("/nuovo/set")
	@Produces({"application/json"})
	Response setNuovoTerzoResp(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_impianto") Integer codiceImpianto, @RequestBody RequestTerzoResponsabile request);
}
