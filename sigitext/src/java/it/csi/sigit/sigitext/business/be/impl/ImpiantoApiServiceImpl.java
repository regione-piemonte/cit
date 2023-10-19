package it.csi.sigit.sigitext.business.be.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.csi.csi.wrapper.CSIException;
import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.ImpiantoApi;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.be.manager.ValidationManager;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.sigit.sigitext.business.util.MapDto;
import it.csi.sigit.sigitext.business.util.exceptions.ValidationManagerException;
import it.csi.sigit.sigitext.dto.sigitext.*;
import it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.xml.bind.ValidationException;
import java.util.Arrays;
import java.util.List;

public class ImpiantoApiServiceImpl implements ImpiantoApi {
	@Override
	public Response getImpiantiByFiltroJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String cf3Responsabile, String cfImpresa, String cfProprietario, String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String numeroRea, String pdr, String pod, String siglaProvincia, String siglaRea, Float x, Float y, Float distanza, String tokenJWT) {
		try {
			ImpiantoFiltro impiantoFiltro = mapParamToImpiantoFiltro(cf3Responsabile, cfImpresa, cfProprietario, cfResponsabile, civico, codiceImpianto, descComune, fkStato, flagVisuProprietario, idComune, indirizzo, istatComune, numeroRea, pdr, pod, siglaProvincia, siglaRea, x, y, distanza);
			Impianto[] impiantoArray = getImplSigitextManager().getImpiantiByFiltroJWT(impiantoFiltro, tokenJWT);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	private ImpiantoFiltro mapParamToImpiantoFiltro(String cf3Responsabile, String cfImpresa, String cfProprietario, String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String numeroRea, String pdr, String pod, String siglaProvincia, String siglaRea, Float x, Float y, Float distanza) {
		ImpiantoFiltro impiantoFiltro = new ImpiantoFiltro();
		impiantoFiltro.setCf3Responsabile(cf3Responsabile);
		impiantoFiltro.setCfImpresa(cfImpresa);
		impiantoFiltro.setCfProprietario(cfProprietario);
		impiantoFiltro.setCfResponsabile(cfResponsabile);
		impiantoFiltro.setCivico(civico);
		impiantoFiltro.setCodiceImpianto(GenericUtil.isNotNullOrEmpty(codiceImpianto) ? Integer.parseInt(codiceImpianto) : null);
		impiantoFiltro.setDescComune(descComune);
		impiantoFiltro.setFkStato(GenericUtil.isNotNullOrEmpty(fkStato) ? Integer.parseInt(fkStato) : null);
		impiantoFiltro.setFlagVisuProprietario(GenericUtil.isNotNullOrEmpty(flagVisuProprietario) ? Boolean.parseBoolean(flagVisuProprietario) : null);
		impiantoFiltro.setIdComune(idComune);
		impiantoFiltro.setIndirizzo(indirizzo);
		impiantoFiltro.setIstatComune(istatComune);
		impiantoFiltro.setNumeroRea(GenericUtil.isNotNullOrEmpty(numeroRea) ? Integer.parseInt(numeroRea) : null);
		impiantoFiltro.setPdr(pdr);
		impiantoFiltro.setPod(pod);
		impiantoFiltro.setSiglaProvincia(siglaProvincia);
		impiantoFiltro.setSiglaRea(siglaRea);
		impiantoFiltro.setX(x);
		impiantoFiltro.setY(y);
		impiantoFiltro.setDistanza(distanza);
		System.out.println(impiantoFiltro);
		return impiantoFiltro;
	}

	@Override
	public Response getImpiantoByCodiceJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer codiceImpianto, String tokenJWT) {
		try {
			Impianto[] impiantoArray = getImplSigitextManager().getImpiantoByCodiceJWT(codiceImpianto, tokenJWT);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getImpiantoByPODJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String pod, String tokenJWT) {
		try {
			Impianto[] impiantoArray = getImplSigitextManager().getImpiantoByPODJWT(pod, tokenJWT);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getImpiantoByPDRJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String pdr, String tokenJWT) {
		try {
			Impianto[] impiantoArray = getImplSigitextManager().getImpiantoByPDRJWT(pdr, tokenJWT);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getImpiantoByIndirizzoJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String indirizzo, Integer civico, String istat, String tokenJWT) {
		try {
			Impianto[] impiantoArray = getImplSigitextManager().getImpiantoByIndirizzoJWT(indirizzo, civico, istat, tokenJWT);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getStatoImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] statiImpianto = getImplSigitextManager().getStatiImpianto();
			return Response.ok(statiImpianto).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response setImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, SetImpiantoModel setImpiantoModel, Integer responsabilita) {
		try {
			Esito esito = getImplSigitextManager().salvaImpianto(setImpiantoModel.getUtenteLoggato(), setImpiantoModel.getDatiImpianto(), responsabilita);
			return Response.ok(esito).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", e.getMessage())).build();
		}
	}

	@Override
	public Response setModificaImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, SetImpiantoModel setImpiantoModel) {
		try {
			Esito esito = getImplSigitextManager().updateImpianto(setImpiantoModel.getUtenteLoggato(), setImpiantoModel.getDatiImpianto());
			return Response.ok(esito).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore inserimento del nuovo impianto")).build();
		}
	}

	@Override
	public Response getRespProp(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, int tipo, String cf,String siglaRea, String numeroRea) {
		try {
			Persona[] persona = getImplSigitextManager().getRespProp(tipo, cf,siglaRea,numeroRea);
			return Response.ok(persona).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore inserimento del nuovo impianto")).build();
		}
	}

	@Override
	public Response setNuovoRespProp(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, RespPropModel respPropModel) {
		try {
			Esito esito = getImplSigitextManager().salvaResponsabile(respPropModel);
			return Response.ok(esito).build();
		} catch (ValidationManagerException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito("KO", e.getMsg().getText())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore inserimento responsabile/proprietario")).build();
		}
	}

	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}
}
