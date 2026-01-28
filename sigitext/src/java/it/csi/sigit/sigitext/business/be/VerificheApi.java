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

import it.csi.sigit.sigitext.dto.RicercaDatiVerifica;
import it.csi.sigit.sigitext.dto.VerificaIns;
import it.csi.sigit.sigitext.dto.sigitext.VerificaMassiva;

@Path("/verifiche")
@Produces({ "application/json" })
public interface VerificheApi {
	
	@POST
	@Path("/getElencoVerifiche")
	@Produces({"application/json"})
	Response getElencoVerifiche(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, 
			@RequestBody RicercaDatiVerifica datiVerifica);
	
	@GET
	@Path("/getDistributore")
	@Produces({"application/json"})
	Response getDistributore(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, 
			@QueryParam("id_dato_distrib") Integer idDatoDistrib);
	
	@POST
	@Path("/setVerifica")
	@Produces({"application/json"})
	Response setVerifica(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, 
			@RequestBody VerificaIns verificaIns);
	
	@POST
	@Path("/setVerificaMassiva")
	@Produces({"application/json"})
	Response setVerificaMassiva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, 
			@RequestBody VerificaMassiva verifica, @QueryParam("flg_isp_pagamento") Integer flgIspPagamento);
	
	@GET
	@Path("/getDettaglioVerifica")
	@Produces({"application/json"})
	Response getDettaglioVerifica(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, 
			@QueryParam("id_verifica") Integer idVerifica);
	
	@DELETE
	@Path("/deleteVerifica")
	@Produces({"application/json"})
	Response deleteVerifica(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, 
			@QueryParam("id_verifica") Integer idVerifica);
	
	@GET
	@Path("/getControllo")
	@Produces({"application/json"})
	Response getControllo(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, 
			@QueryParam("sigla_ree") String siglaRee, @QueryParam("numero_ree") Long numeroRee);
	
	@GET
	@Path("/getTipoVerifica")
	@Produces({"application/json"})
	Response getTipoVerifica(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);
	
	@GET
	@Path("/getAssegnatario")
	@Produces({"application/json"})
	Response getAssegnatario(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);
	
	@GET
	@Path("/getSiglaRee")
	@Produces({"application/json"})
	Response getSiglaRee(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

}
