package it.csi.sigit.sigitext.business.be.impl;

import it.csi.csi.wrapper.CSIException;
import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.SigitextApi;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.sigitext.*;
import it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;

public class SigitextApiServiceImpl implements SigitextApi {

	@Override
	public Response ping(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return Response.ok("PING OK!").header("someheader", "" + System.currentTimeMillis()).build();
	}

	@Override
	public Response getUnitaMisuraCIT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] unitaMisuraList = getImplSigitextManager().getUnitaMisuraCIT();
			return Response.ok(unitaMisuraList).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}

}
