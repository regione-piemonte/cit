package it.csi.sigit.sigitext.business.be.impl;

import it.csi.csi.wrapper.CSIException;
import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.ControlloApi;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.exceptions.ValidationManagerException;
import it.csi.sigit.sigitext.dto.sigitext.*;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.Date;
import java.util.List;

public class ControlloApiServiceImpl implements ControlloApi {
	@Override
	public Response getControlli(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceImpianto, String ordinamento, Integer numRighe) {
		try {
			List<Controllo> controllo = getImplSigitextManager().getControlli(codiceImpianto, ordinamento, numRighe);
			return Response.ok(controllo).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response downloadXMLControllo(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idAllegato) {
		try {
			return Response.ok(getImplSigitextManager().downloadXMLControllo(idAllegato)).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getRicevutaControllo(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, String ruolo, Integer idPersonaGiuridica) {
		try {
			byte[] documento = getImplSigitextManager().getRicevutaControllo(tipoComponente, codiceImpianto, progressivo, dataInstallazione, idAllegato, ruolo, idPersonaGiuridica);
			return Response.ok(documento).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getPDFControllo(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, Boolean firmato, String ruolo, Integer idPersonaGiuridica) {
		try {
			PdfControllo documento = getImplSigitextManager().getPDFControllo(tipoComponente, codiceImpianto, progressivo, dataInstallazione, idAllegato, firmato, ruolo, idPersonaGiuridica);
			return Response.ok(documento).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getControlliDisponibili(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceImpianto, Date dataControllo, String tipoControllo, String tipoComponente, String ruolo, Integer idImpresa) {
		try {
			List<ControlloDisponibile> controlloDisponibileList = getImplSigitextManager().getControlloDisponibile(codiceImpianto, dataControllo, tipoControllo, tipoComponente, ruolo, idImpresa);
			return Response.ok(controlloDisponibileList).build();
		}catch (ValidationManagerException e){
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMsg().getText())).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getStelle(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] stelleArray = getImplSigitextManager().getStelle();
			return Response.ok(stelleArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getApparecchiature(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] apparecchiatureArray = getImplSigitextManager().getApparecchiature();
			return Response.ok(apparecchiatureArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getControlloAria(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] controlloAriaArray = getImplSigitextManager().getControlloAria();
			return Response.ok(controlloAriaArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getAriaComburente(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] controlloAriaArray = getImplSigitextManager().getAriaComburente();
			return Response.ok(controlloAriaArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response uploadReeFirmato(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, byte[] file, Integer idAllegato, String fileName, String contentType, String ruolo, Integer idImpresa, String cf) {
		try {
			Esito esito = getImplSigitextManager().uploadReeFirmato(file, idAllegato, fileName, contentType, ruolo, idImpresa, cf);
			return Response.ok(esito).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response deleteControllo(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idAllegato, String ruolo, Integer idImpresa, String cf) {
		try {
			Esito esito = getImplSigitextManager().deleteControllo(idAllegato, ruolo, idImpresa, cf);
			return Response.ok(esito).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response updateControlloJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idAllegato, Integer codiceImpianto, String tipoControllo, byte[] xml, String tokenJWT) {
		try {
			Esito esito = getImplSigitextManager().updateControllo(idAllegato, codiceImpianto, tipoControllo, xml, tokenJWT);
			return Response.ok(esito).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response inviaControllo(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer idAllegato, String ruolo, Integer idImpresa, String cf, Boolean cat) {
		try {
			Esito esito = getImplSigitextManager().inviaAllegato(idAllegato, ruolo, idImpresa, cf,cat);
			return Response.ok(esito).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}

}
