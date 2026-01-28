package it.csi.sigit.sigitext.business.be.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.jboss.resteasy.spi.BadRequestException;

import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.VerificheApi;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTVerificaDto;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.Assegnatario;
import it.csi.sigit.sigitext.dto.RicercaDatiVerifica;
import it.csi.sigit.sigitext.dto.VerificaIns;
import it.csi.sigit.sigitext.dto.sigitext.Controlli;
import it.csi.sigit.sigitext.dto.sigitext.DatiDistributore;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioVerifica;
import it.csi.sigit.sigitext.dto.sigitext.Esito;
import it.csi.sigit.sigitext.dto.sigitext.TipoVerifica;
import it.csi.sigit.sigitext.dto.sigitext.TipoVerificaEnum;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggatoModel;
import it.csi.sigit.sigitext.dto.sigitext.Verifica;
import it.csi.sigit.sigitext.dto.sigitext.VerificaMassiva;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public class VerificheApiServiceImpl implements VerificheApi {

	@Override
	public Response getElencoVerifiche(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, 
			RicercaDatiVerifica datiVerifica) {
		try {
			List<SigitTVerificaDto> response = getImplSigitextManager().getElencoVerifiche(datiVerifica);
			return Response.ok(response).build();
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();		
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getDistributore(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, 
			Integer idDatoDistrib) {
		try {
			DatiDistributore response = getImplSigitextManager().getDistributore(idDatoDistrib);
			return Response.ok(response).build();
		} catch (SigitextException e) {
				return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();			
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response setVerifica(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, 
			VerificaIns verificaIns) {
		try {
			Verifica verifica = verificaIns.getVerifica();
			UtenteLoggatoModel utenteLoggatoModel = verificaIns.getUtenteLoggatoModel();
			String response = getImplSigitextManager().setVerifica(verifica, utenteLoggatoModel);
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}			

	@Override
	public Response setVerificaMassiva(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, VerificaMassiva verifica, Integer flgIspPagamento) {
		try {
			String response = getImplSigitextManager().setVerificaMassiva(verifica, flgIspPagamento);
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getDettaglioVerifica(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Integer idVerifica) {

		try {
			DettaglioVerifica response = getImplSigitextManager().getDettaglioVerifica(idVerifica);
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response deleteVerifica(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Integer idVerifica) {
		try {
			String response = getImplSigitextManager().deleteVerifica(idVerifica);
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}

	@Override
	public Response getControllo(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, String siglaRee, Long numeroRee) {

		try {
			Controlli response = getImplSigitextManager().getControllo(siglaRee, numeroRee);
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();					
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
		
	}

	@Override
	public Response getTipoVerifica(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {

		try {
			List<TipoVerifica> list = new ArrayList<>();
			for (TipoVerificaEnum tipoVerificaEnum : TipoVerificaEnum.values()) {
				TipoVerifica t = new TipoVerifica();
				t.setId(tipoVerificaEnum.getIdDb());
				t.setValue(tipoVerificaEnum.getDescrizioneDb());
				list.add(t);
			} 
			return Response.ok(list).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
		
	}

	@Override
	public Response getAssegnatario(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {

		try {
			List<Assegnatario> response = getImplSigitextManager().getAssegnatario();
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
		
	}

	@Override
	public Response getSiglaRee(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {

		try {
			List<String> response = getImplSigitextManager().getSiglaRee();
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
		
	}



}
