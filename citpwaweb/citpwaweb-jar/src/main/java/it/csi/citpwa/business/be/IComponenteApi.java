/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.be;

import it.csi.citpwa.model.DatiCGModel;
import it.csi.citpwa.model.DatiGFModel;
import it.csi.citpwa.model.DatiGTModel;
import it.csi.citpwa.model.DatiSCModel;
import it.csi.citpwa.model.sigitext.DatiGT;
import it.csi.citpwa.model.sigitext.UpdateGtModel;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/componente")
@Produces({ "application/json" })
public interface IComponenteApi {

	@GET
	@Path("/gt")
	public Response getGT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("progressivo") Integer progressivo);

	@GET
	@Path("/gf")
	public Response getGF(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("progressivo") Integer progressivo);

	@GET
	@Path("/sc")
	public Response getSC(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("progressivo") Integer progressivo);

	@GET
	@Path("/cg")
	public Response getCG(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("progressivo") Integer progressivo);

	@PUT
	@Path("/gt")
	public Response updateGT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, List<DatiGTModel> datiGTModel,@QueryParam("id-impresa") Integer idImpresaSelez);

	@PUT
	@Path("/gf")
	public Response updateGF(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, List<DatiGFModel> datiGFModel,@QueryParam("id-impresa") Integer idImpresaSelez);

	@PUT
	@Path("/sc")
	public Response updateSC(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, List<DatiSCModel> datiSCModel,@QueryParam("id-impresa") Integer idImpresaSelez);

	@PUT
	@Path("/cg")
	public Response updateCG(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, List<DatiCGModel> datiCGModel,@QueryParam("id-impresa") Integer idImpresaSelez);

	@GET
	@Path("/marca")
	@Produces({ "application/json" })
	public Response getmarcaCIT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Path("/fluido")
	@Produces({ "application/json" })
	public Response getFluidoCIT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Path("/combustibile")
	@Produces({ "application/json" })
	public Response getCombustibileCIT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Path("/tipologiaGT")
	@Produces({ "application/json" })
	public Response getTipologiaGT(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Path("/tipologiaGF")
	@Produces({ "application/json" })
	public Response getTipologiaGF(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Path("/fonte")
	@Produces({ "application/json" })
	public Response getFonte(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Path("/canna-fumaria")
	@Produces({ "application/json" })
	public Response getTipoCannaFumaria(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@POST
	@Path("/dismetti")
	@Produces({ "application/json" })
	public Response checkDismettiSostituisciComponente(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("data-minima") String dataMinima, @QueryParam("data-massima") String dataMassima, @QueryParam("data-dismiss") String dataDismiss);

	@DELETE
	@Produces({ "application/json" })
	public Response delComponente(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("tipo") String tipo, @QueryParam("progressivo") Integer progressivo);

}
