package it.csi.sigit.sigitext.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.csi.wrapper.CSIException;
import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.SvistaApi;
import it.csi.sigit.sigitext.business.be.manager.SvistaManager;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.ComuneEstesoModel;
import it.csi.sigit.sigitext.dto.sigitext.Esito;

public class SvistaApiServiceImpl implements SvistaApi {

	@Override
	public Response getComuniEstesi(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {

		try {
			List<ComuneEstesoModel> ce = getImplSvistaManager().getComuniEstesi();
			return Response.ok(ce).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	private SvistaManager getImplSvistaManager() {
		return (SvistaManager) SpringApplicationContextHelper.getBean("svistaManager");
	}

}
