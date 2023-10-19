/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.be;

import it.csi.citpwa.model.ManutFormModel;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.io.File;
import java.util.Date;

@Path("/controllo")
@Produces({ "application/json" })
public interface IControlloApi {
	@GET
	@Path("/all")
	public Response getControlli(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("ordinamento") String ordinamento, @QueryParam("num-righe") Integer numRighe);

	@GET
	@Path("/xml")
	public Response getXmlControllo(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("id") Integer idAllegato, @QueryParam("tipo") String tipoDoc);

	@GET
	@Path("/ricevuta")
	public Response getRicevutaControllo(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("tipo-componente") String tipoComponente, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("progressivo") Integer progressivo, @QueryParam("data-installazione") Date dataInstallazione, @QueryParam("id-allegato") String idAllegato);

	@GET
	@Path("/pdf")
	public Response getPDFControllo(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("tipo-componente") String tipoComponente, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("progressivo") Integer progressivo, @QueryParam("data-installazione") Date dataInstallazione, @QueryParam("id-allegato") String idAllegato, @QueryParam("firmato") Boolean firmato);

	@GET
	@Path("/controlli-disponibili")
	public Response getControlliDisponibili(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("tipo-componente") String tipoComponente, @QueryParam("tipo-controllo") String tipoControllo, @QueryParam("data-controllo") String dataControllo);

	@POST
	@Path("/ree-firmato")
	public Response uploadReeFirmato(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, File ree, @QueryParam("nome") String fileName, @QueryParam("tipo") String mimeType, @QueryParam("id-allegato") Integer idAllegato);

	@POST
	@Path("/manutenzione")
	public Response inviaManutenzione(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("tipo-controllo") String tipoControllo, ManutFormModel manutFormModel);

	@POST
	@Path("/ree")
	@Consumes({ "application/json" })
	public Response inserisciREE(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("tipo-controllo") String tipoControllo, @QueryParam("invia") boolean invia, String xml);

	@PUT
	@Path("/ree")
	@Consumes({ "application/json" })
	public Response modificaREE(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("id-allegato") Integer idAllegato, @QueryParam("codice-impianto") String codiceImpianto, @QueryParam("tipo-controllo") String tipoControllo, @QueryParam("invia") boolean invia, String xml);

	@POST
	@Path("/ree/invia")
	@Consumes({ "application/json" })
	public Response inviaREE(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("id-allegato") Integer idAllegato);

	@DELETE
	@Consumes({ "application/json" })
	public Response cancellaControllo(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req, @QueryParam("id-allegato") Integer idAllegato, @QueryParam("stato-rapp") Integer statoRapp);
}
