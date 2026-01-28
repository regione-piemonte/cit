package it.csi.sigit.sigitext.business.be.impl;

import it.csi.csi.wrapper.CSIException;
import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.ComponenteApi;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.sigitext.*;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import org.jboss.resteasy.spi.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public class ComponentApiServiceImpl implements ComponenteApi {
	@Override
	public Response getGT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceImpianto, Integer progressivo, Integer idPg) {
		try {
			DatiGT[] impiantoArray = getImplSigitextManager().getGT(codiceImpianto, progressivo, idPg);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getGF(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceImpianto, Integer progressivo, Integer idPg) {
		try {
			DatiGF[] impiantoArray = getImplSigitextManager().getGF(codiceImpianto, progressivo, idPg);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getSC(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceImpianto, Integer progressivo, Integer idPg) {
		try {
			DatiSC[] impiantoArray = getImplSigitextManager().getSC(codiceImpianto, progressivo, idPg);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getCG(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceImpianto, Integer progressivo, Integer idPg) {
		try {
			DatiCG[] impiantoArray = getImplSigitextManager().getCG(codiceImpianto, progressivo, idPg);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getTipologiaGT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] tipologiaArray = getImplSigitextManager().getTipologiaGT();
			return Response.ok(tipologiaArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getTipologiaGF(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] tipologiaArray = getImplSigitextManager().getTipologiaGF();
			return Response.ok(tipologiaArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getCombustibileCIT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] combustibili = getImplSigitextManager().getCombustibileCIT();
			return Response.ok(combustibili).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getClassDpr66096CIT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] classificazioni = getImplSigitextManager().getClassDpr66096CIT();
			return Response.ok(classificazioni).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getFrequenzaManutCIT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] frequenze = getImplSigitextManager().getFrequenzaManutCIT();
			return Response.ok(frequenze).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getMarcaCIT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] marcaList = getImplSigitextManager().getMarcaCIT();
			return Response.ok(marcaList).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getFonteCIT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] marcaList = getImplSigitextManager().getFonteCIT();
			return Response.ok(marcaList).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getFluidoCIT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] marcaList = getImplSigitextManager().getFluidoCIT();
			return Response.ok(marcaList).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getTipoCannaFumaria(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] marcaList = getImplSigitextManager().getTipoCannaFumaria();
			return Response.ok(marcaList).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response updateGT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest,Integer idImpresa, UpdateGtModel updateGtModel) {
		try {
			Esito esito = getImplSigitextManager().updateGT(updateGtModel.getCodiceImpianto(), updateGtModel.getDatiGTList(), updateGtModel.getUtenteLoggato(),idImpresa);
			return Response.ok(esito).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO_PG, e.getMessage())).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response updateGF(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest,Integer idImpresa, UpdateGfModel updateGfModel) {
		try {
			Esito esito = getImplSigitextManager().updateGF(updateGfModel.getCodiceImpianto(), updateGfModel.getDatiGFList(), updateGfModel.getUtenteLoggato(),idImpresa);
			return Response.ok(esito).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO_PG, e.getMessage())).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response updateSC(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest,Integer idImpresa, UpdateScModel updateScModel) {
		try {
			Esito esito = getImplSigitextManager().updateSC(updateScModel.getCodiceImpianto(), updateScModel.getDatiSCList(), updateScModel.getUtenteLoggato(),idImpresa);
			return Response.ok(esito).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO_PG, e.getMessage())).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response updateCG(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest,Integer idImpresa, UpdateCgModel updateCgModel) {
		try {
			Esito esito = getImplSigitextManager().updateCG(updateCgModel.getCodiceImpianto(), updateCgModel.getDatiCGList(), updateCgModel.getUtenteLoggato(),idImpresa);
			return Response.ok(esito).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new Esito(Constants.KO_PG, e.getMessage())).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response delComponenteImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceImpianto, String tipologia, Integer progressivo, String cfUtente) {
		try {
			Esito esito = getImplSigitextManager().delComponenteImpianto(codiceImpianto, tipologia, progressivo, cfUtente);
			return Response.ok(esito).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}

}
