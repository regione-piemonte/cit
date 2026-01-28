package it.csi.citpwa.business.be;

import it.csi.citpwa.model.sigitext.Documento;
import it.csi.citpwa.model.sigitext.DocumentoPwa;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/documento")
@Produces({ "application/json" })
public interface IDocumentoApi {
	
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
	                            @QueryParam("codice_impianto") Integer codiceImpianto, @QueryParam("id_verifica") Integer idVerifica, @QueryParam("id_accertamento") Integer idAccertamento, @QueryParam("id_ispezione_2018") Integer idIspezione2018);

	@GET
	@Path("/uid")
	@Produces({"application/json"})
	Response getDocumentoByUid(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("uidIndex") String uidIndex);
	
	@DELETE
	@Path("/uid")
	@Produces({"application/json"})
	Response deleteDocumento(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("uidIndex") String uidIndex);


	@GET
	@Path("/getTipoDocumento")
	@Produces({"application/json"})
	Response getTipoDocumento(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);
}
