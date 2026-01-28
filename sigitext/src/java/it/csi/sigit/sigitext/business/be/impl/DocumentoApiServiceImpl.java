package it.csi.sigit.sigitext.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.DocumentoApi;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoDocDto;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.sigitext.Documento;
import it.csi.sigit.sigitext.dto.sigitext.DocumentoPwa;
import it.csi.sigit.sigitext.dto.sigitext.Esito;
import it.csi.sigit.sigitext.dto.sigitext.ResponseGetElencoDocumenti;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public class DocumentoApiServiceImpl implements DocumentoApi {

	@Override
	public Response setDocumento(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, DocumentoPwa documento, Integer idContratto, String cfUtenteLoggato, Integer codiceImpianto, Integer idAzione, String tipoDoc, Integer fkIspezIspett, String dataControllo) {
		try {
			String response = getImplSigitextManager().setDocumento(documento, idContratto, cfUtenteLoggato, codiceImpianto, idAzione, tipoDoc, fkIspezIspett, dataControllo);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getElencoDocumenti(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceImpianto, String idVerifica, String idAccertamento, String idIspezione2018) {
		try {
			ResponseGetElencoDocumenti response = getImplSigitextManager().getElencoDocumenti(codiceImpianto, idVerifica, idAccertamento, idIspezione2018);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getDocumentoByUid(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String uidIndex) {
		try {
			Documento response = getImplSigitextManager().getDocumentoByUid(uidIndex);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}
	
	@Override
	public Response deleteDocumento(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String uidIndex) {
		try {
			String response = getImplSigitextManager().deleteDocumento(uidIndex);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getTipoDocumenti(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		try {
			List<SigitDTipoDocDto> response = getImplSigitextManager().getTipoDocumenti();
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

}
