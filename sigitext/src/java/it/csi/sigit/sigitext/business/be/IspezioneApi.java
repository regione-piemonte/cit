package it.csi.sigit.sigitext.business.be;

import java.math.BigDecimal;

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

import it.csi.sigit.sigitext.dto.sigitext.AssegnaIspezione;
import it.csi.sigit.sigitext.dto.sigitext.Ispezione;
import it.csi.sigit.sigitext.dto.sigitext.DatiIspezione;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;


@Path("/ispezione")
@Produces({ "application/json" })
public interface IspezioneApi {
	
	@POST
	@Path("/getElencoIspezioni")
	@Produces({"application/json"})
	Response getElencoIspezioni(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id_verifica") Integer idVerifica, @QueryParam("id_accertamento") Integer idAccertamento,
			@RequestBody DatiIspezione datiIspezione);
	
	@GET
	@Path("/getDettaglioIspezione")
	@Produces({"application/json"})
	Response getDettaglioIspezione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id_ispezione_2018") Integer idIspezione2018);

	@GET
	@Path("/getStatoIspezione")
	@Produces({"application/json"})
	Response getStatoIspezione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);
		
	@GET
	@Path("/getIspettore")
	@Produces({"application/json"})
	Response getIspettore(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);
	
	@POST
	@Path("/assegnaIspezione")
	Response assegnaIspezione (@QueryParam("id_ispezione_2018") BigDecimal idIspezione2018, @RequestBody AssegnaIspezione assegnaIspezione);
	
	@POST
	@Path("/assegnaImpiantoIspezione")
	Response assegnaImpiantoIspezione (@QueryParam("id_ispezione_2018") BigDecimal idIspezione2018, @QueryParam("codice_impianto") BigDecimal codiceImpianto, @RequestBody UtenteLoggato utenteLoggato);
	
	@POST
	@Path("/concludiIspezione")
	Response concludiIspezione(@RequestBody Ispezione ispezione);
	
	@POST
	@Path("/setIspezione")
	Response setIspezione(@QueryParam("id_verifica") BigDecimal idVerifica, @QueryParam("id_accertamento") BigDecimal idAccertamento ,@RequestBody Ispezione ispezione);

	@POST
	@Path("/annullaIspezione")
	Response annullaIspezione (@RequestBody Ispezione ispezione);
	
}
