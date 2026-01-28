package it.csi.sigit.sigitext.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.AzioneApi;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAzioneDto;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.sigitext.AzioneIns;
import it.csi.sigit.sigitext.dto.sigitext.Esito;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;

public class AzioneApiServiceImpl implements AzioneApi {

	@Override
	public Response getAzione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest,
			Integer idVerifica, Integer idAccertamento, Integer idIspezione2018, UtenteLoggato utenteLoggato) {

		try {
			List<SigitTAzioneDto> response = getImplSigitextManager().getAzione(idVerifica, idAccertamento, idIspezione2018);
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}

	@Override
	public Response setAzioneVerifica(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, AzioneIns datiAzione) {

		try {			
			
			String response = getImplSigitextManager().setAzioneVerifica(datiAzione.getDatiAzione(), datiAzione.getUtenteLoggato(), datiAzione.getDocumentoPwa());

			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
		
	}

	@Override
	public Response getDocAzione(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Integer idAzione) {

		try {																									
			List<SigitTDocAzioneDto> response = getImplSigitextManager().getDocAzione(idAzione);					
			return Response.ok(response).build();
			
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
		
	}

	@Override
	public Response setAzioneIspezione(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, AzioneIns datiAzione) {
	try {			
			
			String response = getImplSigitextManager().setAzioneIspezione(datiAzione.getDatiAzione(), datiAzione.getUtenteLoggato(), datiAzione.getDocumentoPwa());

			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	
}
