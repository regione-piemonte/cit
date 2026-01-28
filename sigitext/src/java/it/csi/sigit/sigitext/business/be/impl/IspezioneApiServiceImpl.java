package it.csi.sigit.sigitext.business.be.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.IspezioneApi;
import it.csi.sigit.sigitext.business.be.manager.IspezioneManager;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDStatoIspezioneDto;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.Assegnatario;
import it.csi.sigit.sigitext.dto.sigitext.AssegnaIspezione;
import it.csi.sigit.sigitext.dto.sigitext.Ispezione;
import it.csi.sigit.sigitext.dto.sigitext.DatiIspezione;
import it.csi.sigit.sigitext.dto.sigitext.Esito;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;

public class IspezioneApiServiceImpl implements IspezioneApi{

	@Override
	public Response getElencoIspezioni(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Integer idVerifica, Integer idAccertamento, DatiIspezione datiIspezione) {
				
		try {			
			List<DatiIspezione> response = getImplSigitextManager().getElencoIspezioni(idVerifica, idAccertamento, datiIspezione);
			return Response.ok(response).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
		
	}

	@Override
	public Response getDettaglioIspezione(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Integer idIspezione2018) {
				
		try {
			DatiIspezione response = getImplSigitextManager().getDettaglioIspezione(idIspezione2018);
			return Response.ok(response).build();	
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}		
		
	}
	
	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}
	
	private IspezioneManager getImplIspezioneManager() {
		return (IspezioneManager) SpringApplicationContextHelper.getBean("ispezioneManager");
	}


	@Override
	public Response getStatoIspezione(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {		
		try {
			List<SigitDStatoIspezioneDto> response = getImplSigitextManager().getStatoIspezione();
			return Response.ok(response).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response assegnaIspezione(BigDecimal idIspezione2018, AssegnaIspezione assegnaIspezione) {
	
		try {
			getImplIspezioneManager().assegnaIspezione(idIspezione2018, assegnaIspezione);
			return Response.ok(idIspezione2018).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response assegnaImpiantoIspezione(BigDecimal idIspezione2018, BigDecimal codiceImpianto,
			UtenteLoggato utenteLoggato) {

		try {
			getImplIspezioneManager().assegnaImpiantoIspezione(idIspezione2018, codiceImpianto, utenteLoggato);
			return Response.ok(idIspezione2018).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
		
	}

	@Override
	public Response concludiIspezione(Ispezione ispezione) {

		try {
			if(ispezione.getDatiIspezione()!=null && ispezione.getDatiIspezione().getIdIspezione2018()!=null) {
				getImplIspezioneManager().concludiIspezione(ispezione);
				return Response.ok(ispezione.getDatiIspezione().getIdIspezione2018()).build();
			}else {
				throw new BadRequestException("numero ispezione non presente");
			}
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
		
	}

	@Override
	public Response setIspezione(BigDecimal idVerifica, BigDecimal idAccertamento, Ispezione ispezione) {

		try {
			BigDecimal idIspezione2018 = getImplIspezioneManager().setIspezione(idVerifica, idAccertamento, ispezione);
			return Response.ok(idIspezione2018).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
		
	}

	@Override
	public Response annullaIspezione(Ispezione ispezione) {

		try {
			if(ispezione.getDatiIspezione()!=null && ispezione.getDatiIspezione().getIdIspezione2018()!=null) {
				getImplIspezioneManager().annullaIspezione(ispezione);
				return Response.ok(ispezione.getDatiIspezione().getIdIspezione2018()).build();
			}else{
				throw new BadRequestException("numero ispezione non presente");
			}
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();				
		} catch (BadRequestException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
		
	}
	
	@Override
	public Response getIspettore(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {

		try {
			List<Assegnatario> response = getImplSigitextManager().getIspettore();
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
		
	}
	
	

}
