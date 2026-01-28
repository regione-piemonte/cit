package it.csi.citpwa.business.be.impl;

import it.csi.citpwa.business.be.IDocumentoApi;
import it.csi.citpwa.business.service.IAuthenticationService;
import it.csi.citpwa.business.service.IDocumentoService;
import it.csi.citpwa.business.service.INominaTerzoResponsabileService;
import it.csi.citpwa.model.sigitext.DocumentoPwa;
import it.csi.citpwa.model.sigitext.Esito;
import it.csi.citpwa.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.NotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Component
public class DocumentoApiServiceImp implements IDocumentoApi {

	@Autowired
	private IDocumentoService documentoService;
	@Autowired
	private IAuthenticationService authenticationService;
	
	
	@Override
	public Response setDocumento(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, DocumentoPwa documento, Integer idContratto, String cfUtenteLoggato, Integer codiceImpianto, Integer idAzione, String tipoDoc, Integer fkIspezIspett, String dataControllo) {
		try {
			return Response.ok(documentoService.setDocumento(documento, idContratto, cfUtenteLoggato, codiceImpianto, idAzione, tipoDoc, fkIspezIspett, dataControllo)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getElencoDocumenti(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer codiceImpianto, Integer idVerifica, Integer idAccertamento, Integer idIspezione2018) {
		try {
			return Response.ok(documentoService.getElencoDocumenti(codiceImpianto, idVerifica, idAccertamento, idIspezione2018)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun documento presente")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getDocumentoByUid(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String uidIndex) {
		try {
			return Response.ok(documentoService.getDocumentoByUid(uidIndex)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun documento presente")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response deleteDocumento(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String uidIndex) {
		try {
			return Response.ok(documentoService.deleteDocumento(uidIndex)).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun documento presente")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getTipoDocumento(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			return Response.ok(documentoService.getTipoDocumento()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO, "Nessun tipo documento presente")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}
}
