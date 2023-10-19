package it.csi.sigit.sigitext.business.be.impl;

import it.csi.csi.wrapper.CSIException;
import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.LibrettoApi;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.sigit.sigitext.dto.sigitext.*;
import it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;
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

	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}
}
