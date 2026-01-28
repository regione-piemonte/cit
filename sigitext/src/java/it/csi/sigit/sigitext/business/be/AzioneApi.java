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

import it.csi.sigit.sigitext.dto.sigitext.AzioneIns;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;

@Path("/azione")
@Produces({ "application/json" })
public interface AzioneApi {
	
	@POST
	@Path("/getAzione")
	@Produces({"application/json"})
	Response getAzione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id_verifica") Integer idVerifica, @QueryParam("id_accertamento") Integer idAccertamento,
			@QueryParam("id_ispezione_2018") Integer idIspezione2018, @RequestBody UtenteLoggato utenteLoggato);


	@POST
	@Path("/verifica/setAzione")
	@Produces({"application/json"})
	Response setAzioneVerifica(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, 
			@RequestBody AzioneIns datiAzione);
	
	@POST
	@Path("/ispezione/setAzione")
	@Produces({"application/json"})
	Response setAzioneIspezione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, 
			@RequestBody AzioneIns datiAzione);

	
	@GET
	@Path("/getDocAzione")
	@Produces({"application/json"})
	Response getDocAzione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id_azione") Integer idAzione);
	
}

