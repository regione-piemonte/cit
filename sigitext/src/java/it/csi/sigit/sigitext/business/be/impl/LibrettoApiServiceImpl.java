package it.csi.sigit.sigitext.business.be.impl;

import it.csi.csi.wrapper.CSIException;
import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.LibrettoApi;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.sigit.sigitext.dto.sigitext.*;
import it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public class LibrettoApiServiceImpl implements LibrettoApi {

	@Override
	public Response getLibrettoByUIDJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String uid, String tokenJWT) {
		try {
			Documento documento = getImplSigitextManager().getLibrettoByUIDJWT(uid, tokenJWT);
			return Response.ok(documento).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getLibrettoDtoByUIDJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String uid) {
		try {
			return Response.ok(getImplSigitextManager().getLibrettoDtoByUIDJWT(uid)).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getXMLLibrettoNowJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer codiceImpianto, Boolean isConsolidato, String tokenJWT) {
		try {
			Documento documento = getImplSigitextManager().getXMLLibrettoNowJWT(codiceImpianto, isConsolidato, tokenJWT);
			return Response.ok(documento).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getLibrettoNowJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer codiceImpianto, Boolean isConsolidato, String tokenJWT) {
		try {
			Libretto libretto = getImplSigitextManager().getLibrettoNowJWT(codiceImpianto, isConsolidato, tokenJWT);
			return Response.ok(libretto).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getSchedaLibrettoJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer codiceImpianto, String tokenJWT) {
		try {
			Scheda1 libretto = getImplSigitextManager().getSchedaLibrettoJWT(codiceImpianto, tokenJWT);
			return Response.ok(libretto).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getXMLLibrettoConsolidatoJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer codiceImpianto, String tokenJWT) {
		try {
			Documento documento = getImplSigitextManager().getXMLLibrettoConsolidatoJWT(codiceImpianto, tokenJWT);
			return Response.ok(documento).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response uploadXMLLibrettoJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer codiceImpianto, byte[] xml, String tokenJWT) {
		try {
			getImplSigitextManager().uploadXMLLibrettoJWT(codiceImpianto, xml, tokenJWT);
			return Response.ok().build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response uploadXMLControlloJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer codiceImpianto, String tipoControllo, byte[] xml, String tokenJWT) {
		try {
			Integer idAllegato = getImplSigitextManager().uploadXMLControlloJWT(codiceImpianto, tipoControllo, xml, tokenJWT);
			return Response.ok(idAllegato).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response consolidaLibretto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceImpianto, Integer idImpresa,String descrizioneRuolo,String codiceRea,String cfUtenteMod) {
		try {
			Esito esito = getImplSigitextManager().consolidaLibrettoEsplicito(ConvertUtil.convertToInteger(codiceImpianto),idImpresa, descrizioneRuolo, codiceRea, cfUtenteMod);
			return Response.ok(esito).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore consolida libretto")).build();
		}
	}
	
	@Override
	public Response getComuniPGJWT(String jwt) throws SigitExtDaoException {
		try {
			return Response.ok(getImplSigitextManager().getComuniPGJWT(jwt)).build();
		} catch (SigitExtDaoException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore consolida libretto")).build();
		}
	}
	
	@Override
	public Response getManutentoriJWT(String denominazione, String comune, String jwt)
			throws SigitExtDaoException {
		try {
			return Response.ok(getImplSigitextManager().getManutentoriJWT(denominazione, comune, jwt)).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (SigitExcessiveResultsException e) {
			return Response.status(507 /* HTTP STATUS: INSUFFICIENT_STORAGE */).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore consolida libretto")).build();
		}
	}
	
	@Override
	public Response setLibSch1IdImpianto(Integer codiceImpianto, Scheda1 scheda1, String cfUtenteLoggato) throws SigitExtDaoException {
		try {
			
			String response = getImplSigitextManager().setLibSch1IdImpianto(codiceImpianto, scheda1, cfUtenteLoggato);
			
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getCategorie() {
		try {
			return Response.ok(getImplSigitextManager().getCategorie()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		}
	}
	
		
	@Override
	public Response getTipoIntervento(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] tipologiaArray = getImplSigitextManager().getTipoIntervento();
			return Response.ok(tipologiaArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}


	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}

	@Override
	public Response setLibSch2IdImpianto(Integer codiceImpianto, Scheda2 scheda2, String cfUtenteLoggato)
			throws SigitExtDaoException {
		try {
			
			String response = getImplSigitextManager().setLibSch2IdImpianto(codiceImpianto, scheda2, cfUtenteLoggato);
			
			return Response.ok(response).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		}
	}
}
