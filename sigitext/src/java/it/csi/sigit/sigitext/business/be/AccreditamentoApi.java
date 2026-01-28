package it.csi.sigit.sigitext.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.web.bind.annotation.RequestBody;

import it.csi.sigit.sigitext.dto.sigitext.DatiImpresa;
import it.csi.sigit.sigitext.dto.sigitext.Persona;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;

@Path("/accreditamento")
@Produces({ "application/json" })
public interface AccreditamentoApi {
	
	@GET
	@Path("/dati")
	@Produces({"application/json"})
	Response getDatiAccreditamento(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_fiscale") String codiceFiscalePF);
	
	@POST
	@Path("/datiPersonaliUtente")
	@Produces({"application/json"})
	Response setDatiPersonaliUtente(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_fiscale") String codiceFiscalePF, @RequestBody Persona persona);
	
	@GET
	@Path("/dati/impresa")
	@Produces({"application/json"})
	Response getDatiImpresa(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_fiscale") String codiceFiscale, @QueryParam("sigla_REA") String siglaRea, @QueryParam("numero_REA") Integer numeroRea);
	
	@GET
	@Path("/distributore/dati/impresa")
	@Produces({"application/json"})
	Response getDatiImpresaDistributore(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_fiscale") String codiceFiscale, @QueryParam("sigla_REA") String siglaRea, @QueryParam("numero_REA") Integer numeroRea);
	
	@POST
	@Path("/impresa/set")
	@Produces({"application/json"})
	Response setImpresaAssociata(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("operation") String operation, @QueryParam("codice_fiscale") String codiceFiscalePF, @RequestBody DatiImpresa datiImpresa);
	
	@GET
	@Path("/delega/set")
	@Produces({"application/json"})
	Response setDelega(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_fiscale") String codiceFiscalePF,  @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica, @QueryParam("id_persona") Integer idPersona);
	
	@POST
	@Path("/delega/delete")
	@Produces({"application/json"})
	Response deleteDelega(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @RequestBody UtenteLoggato utenteLoggato, @QueryParam("id_persona") Integer idPersona);
	
	@DELETE
	@Path("/delega/delete/confirm")
	@Produces({"application/json"})
	Response deleteDelegaConfirm(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("codice_fiscale") String codiceFiscalePF,  @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica, @QueryParam("id_persona") Integer idPersona);
	
	@GET
	@Path("/delega/soggetti")
	@Produces({"application/json"})
	Response getIncarichiSoggettiDelegati (@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);
	
	@GET
	@Path("/delega/soggetti/incarico/set")
	@Produces({"application/json"})
	Response setIncaricoSoggettoDelegato(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, 
			@QueryParam("codice_fiscale") String codiceFiscalePF,  @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica, @QueryParam("id_persona_giuridica_cat") Integer idPersonaGiuridicaCat);
	
	@DELETE
	@Path("/delega/soggetti/incarico/delete")
	@Produces({"application/json"})
	Response deleteIncaricoSoggettoDelegato(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, 
			@QueryParam("codice_fiscale") String codiceFiscalePF,  @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica, @QueryParam("id_persona_giuridica_cat") Integer idPersonaGiuridicaCat);
	
	@GET
	@Path("/mail/send/prova")
	@Produces({"application/json"})
	Response sendEmailProva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("email_address") String emailAddress);
	 
	@GET
	@Path("/getElencoDeleghe")
	@Produces({"application/json"})
	Response getElencoDeleghe(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id_persona_giuridica") Integer idImpresaGiuridica);

	@GET
	@Path("/getElencoIncarichi")
	@Produces({"application/json"})
	Response getElencoIncarichi(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id_persona_giuridica") Integer idImpresaGiuridica);

	@GET
	@Path("/token/impresa")
	@Produces({"application/json"})
	Response getDatiTokenImpresa(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica);

	@PUT
	@Path("/token/impresa")
	@Produces({"application/json"})
	Response generateTokenImpresa(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest, @QueryParam("id_persona_giuridica") Integer idPersonaGiuridica);
}
