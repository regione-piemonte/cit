package it.csi.sigit.sigitext.business.be.impl;

import it.csi.csi.wrapper.CSIException;
import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.UserApi;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.sigitext.*;
import it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public class UserApiServiceImpl implements UserApi {

	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}

	@Override
	public Response getRuoli(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String cf, String nome, String cognome) {
		try {
			Ruoli ruoli = getImplSigitextManager().getRuoli(cf, cognome, nome);
			if (ruoli != null)
				return Response.ok(ruoli).build();
			else {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(new Errore(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase(), "nessun combustibile trovato")).build();
			}
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response setAccesso(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, UtenteLoggato utenteLoggato) {
		try {
			if (utenteLoggato.getPfLoggato() != null && utenteLoggato.getRuoloLoggato() != null) {
				getImplSigitextManager().setAccesso(utenteLoggato);
				return Response.ok().build();

			} else {
				return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, "Formato modello non accettato")).build();
			}
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getDisponibilitaServizio(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, UtenteLoggato utenteLoggato, String servizio) {
		try {
			if (utenteLoggato.getPfLoggato() != null && servizio != null && !servizio.equals("")) {
				getImplSigitextManager().getDisponibilitaServizio(servizio, utenteLoggato.getPfLoggato().getCodiceFiscalePF());
				return Response.ok().build();

			} else {
				return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, "Servizio non disponibile.")).build();
			}
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
}
