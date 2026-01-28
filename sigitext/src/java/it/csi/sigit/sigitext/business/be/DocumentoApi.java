package it.csi.sigit.sigitext.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
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

import it.csi.sigit.sigitext.dto.sigitext.DocumentoPwa;

@Path("/documento")
@Produces({ "application/json" })
public interface DocumentoApi {
	
	@POST
	@Path("/set")
	@Produces({"application/json"})
	Response setDocumento(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody DocumentoPwa documento, 
			@QueryParam("idContratto") Integer idContratto, @QueryParam("cfUtenteLoggato") String cfUtenteLoggato, @QueryParam("codice_impianto") Integer codiceImpianto, @QueryParam("id_azione") Integer idAzione, @QueryParam("tipo_doc") String tipoDoc,
			@QueryParam("fk_ispez_ispett") Integer fkIspezIspett, @QueryParam("data_controllo") String dataControllo);
	
	@GET
	@Path("/elenco")
	@Produces({"application/json"})
	Response getElencoDocumenti(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, 
			@QueryParam("codice_impianto") String codiceImpianto, @QueryParam("id_verifica") String idVerifica, @QueryParam("id_accertamento") String idAccertamento, @QueryParam("id_ispezione_2018") String idIspezione2018);
	
	@GET
	@Path("/uid")
	@Produces({"application/json"})
	Response getDocumentoByUid(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("uidIndex") String uidIndex);
	
	@DELETE
	@Path("/uid")
	@Produces({"application/json"})
	Response deleteDocumento(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("uidIndex") String uidIndex);
	
	
	@GET
	@Path("/getTipoDocumenti")
	@Produces({"application/json"})
	Response getTipoDocumenti(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

}
