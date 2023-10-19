/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.be.impl;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.citpwa.business.be.IImpiantoApi;
import it.csi.citpwa.business.service.IAuthenticationService;
import it.csi.citpwa.business.service.IImpiantoService;
import it.csi.citpwa.business.service.ISvistaService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.exception.ValidationErrorException;
import it.csi.citpwa.model.ComuneEstesoModel;
import it.csi.citpwa.model.DatiImpiantoModel;
import it.csi.citpwa.model.loccsi.LoccsiFeatureModel;
import it.csi.citpwa.model.sigitext.Errore;
import it.csi.citpwa.model.sigitext.Esito;
import it.csi.citpwa.model.sigitext.Persona;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.citpwa.model.xsd.libretto.MOD;
import it.csi.citpwa.util.Constants;
import it.csi.sigit.sigitext.ws.service.client.Impianto;
import it.csi.sigit.sigitext.ws.service.client.SigitUserNotAuthorizedException;

@Component
public class ImpiantoApiServiceImp implements IImpiantoApi {

	@Autowired
	private IImpiantoService impiantoService;

	@Autowired
	private IAuthenticationService authenticationService;
	
	@Autowired
	private ISvistaService svistaService;

	@Override
	public Response getStatoImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(impiantoService.getStatoImpianto()).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity(new Errore(Response.Status.NOT_FOUND.getStatusCode(),
							Response.Status.NOT_FOUND.getReasonPhrase(), "nessun combustibile trovato"))
					.build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
							Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage()))
					.build();
		}
	}

	@Override
	public Response getListImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req,
			String cf3Responsabile, String cfImpresa, String cfProprietario, String cfResponsabile, String civico,
			String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune,
			String indirizzo, String istatComune, String numeroRea, String pdr, String pod, String siglaProvincia,
			String siglaRea, Float x, Float y, Float distanza) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			List<Impianto> impianti = impiantoService.getImpiantiByfiltro(user, cf3Responsabile, cfImpresa,
					cfProprietario, cfResponsabile, civico, codiceImpianto, descComune, fkStato, flagVisuProprietario,
					idComune, indirizzo, istatComune, numeroRea, pdr, pod, siglaProvincia, siglaRea, x, y, distanza);
			if (impianti != null && impianti.size() != 0)
				return Response.ok(impianti).build();
			else {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(new Errore(Response.Status.NOT_FOUND.getStatusCode(),
								Response.Status.NOT_FOUND.getReasonPhrase(),
								"Nessun impianto trovato che soddisfa i parametri inseriti"))
						.build();
			}

		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity(new Errore(Response.Status.UNAUTHORIZED.getStatusCode(),
							Response.Status.UNAUTHORIZED.getReasonPhrase(), "Utente non autorizzato"))
					.build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Errore(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
							Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage()))
					.build();
		}
	}

	@Override
	public Response getIndirizzoImpianto(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req, String indirizzo) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			List<LoccsiFeatureModel> loccsiModelList = impiantoService.getIndirizzoByLoccsi(indirizzo);
			if (loccsiModelList != null && loccsiModelList.size() != 0)
				return Response.ok(loccsiModelList).build();
			else {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(new Esito(Constants.KO, "Indirizzo non trovato")).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Esito(Constants.KO, "Errore recupero indirizzo")).build();
		}
	}

	@Override
	public Response setImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req,
			DatiImpiantoModel datiImpianto, Integer responsabilita) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			Esito esito = impiantoService.setImpianto(user, datiImpianto, null, responsabilita);
			return Response.ok(esito).build();
		} catch (ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity(new Esito(Constants.KO, "Utente non autorizzato")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response setImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req,
			DatiImpiantoModel datiImpianto, String codice) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			Esito esito = impiantoService.setImpianto(user, datiImpianto, codice, null);
			return Response.ok(esito).build();
		} catch (ValidationErrorException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity(new Esito(Constants.KO, "Utente non autorizzato")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Esito(Constants.KO, e.getMessage())).build();
		}
	}

	@Override
	public Response getComuniEstesiImpianto(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req) {
		try {
			List<ComuneEstesoModel> comuniEstesiModelList = svistaService.getComuniEstesiDaSessionContext();
			if (comuniEstesiModelList != null && comuniEstesiModelList.size() != 0)
				return Response.ok(comuniEstesiModelList).build();
			else {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(new Esito(Constants.KO, "Comuni estesi non trovati")).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Esito(Constants.KO, "Errore recupero comuni estesi")).build();
		}
	}

	@Override
	public Response getProvinciaImpiano(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req, String comune) {
		try {
			List<LoccsiFeatureModel> loccsiModelList = impiantoService.getProvinciaByLoccsi(comune);
			if (loccsiModelList != null && loccsiModelList.size() != 0)
				return Response.ok(loccsiModelList).build();
			else {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(new Esito(Constants.KO, "Indirizzo non trovato")).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Esito(Constants.KO, "Errore recupero indirizzo")).build();
		}
	}

	@Override
	public Response getDatiImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req,
			String codice) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			MOD mod = impiantoService.getDatiImpiantoXML(codice, user);
			if (mod != null)
				return Response.ok(mod).build();
			else {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(new Esito(Constants.KO, "Dati impianto non trovati")).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Esito(Constants.KO, "Errore recupero dati impianto")).build();
		}
	}

	@Override
	public Response cercaResponsabileProprietario(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req, Integer tipo, String cf, String siglaRea, String numeroRea) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(impiantoService.cercaResponsabileProprietario(user, tipo, cf, siglaRea, numeroRea))
					.build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity(new Esito(Constants.KO, "Utente non autorizzato")).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity(new Esito(Constants.KO, "Nessun Responsabile/proprietario trovato")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Esito(Constants.KO, "Errore recupero responsabili/proprietari")).build();
		}
	}

	@Override
	public Response setResponsabileProprietario(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req, String codiceImpianto, Persona persona) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			Esito esito = impiantoService.setRespprop(user, codiceImpianto, persona);
			Source source = new StreamSource(new ByteArrayInputStream(esito.getXmlLibretto()));
			JAXBContext context = JAXBContext.newInstance(MOD.class);
			JAXBElement<MOD> root = context.createUnmarshaller().unmarshal(source, MOD.class);
			return Response.ok(root.getValue()).build();
		} catch (ValidationErrorException | SigitExtException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.KO, e.getMessage())).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity(new Esito(Constants.KO, "Utente non autorizzato")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Esito(Constants.KO, "Errore inserimento responsabile/proprietario")).build();
		}
	}

	@Override
	public Response aggiornaRespProp(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req,
			String codiceImpianto, Persona persona) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			Esito esito = impiantoService.aggiornaRespProp(user, codiceImpianto, persona);
			Source source = new StreamSource(new ByteArrayInputStream(esito.getXmlLibretto()));
			JAXBContext context = JAXBContext.newInstance(MOD.class);
			JAXBElement<MOD> root = context.createUnmarshaller().unmarshal(source, MOD.class);
			return Response.ok(root.getValue()).build();
		} catch (SigitUserNotAuthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity(new Esito(Constants.KO, "Utente non autorizzato")).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity(new Esito(Constants.KO, "Nessun Responsabile/proprietario trovato")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Esito(Constants.KO, "Errore inserimento responsabile/proprietario")).build();
		}
	}

	@Override
	public Response pdrDuplicato(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req,
			String pdr) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(impiantoService.pdrDuplicato(user, pdr)).build();
		} catch (SigitExtException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.OK, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, "")).build();
		}
	}

	@Override
	public Response podDuplicato(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req,
			String pod) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			return Response.ok(impiantoService.podDuplicato(user, pod)).build();
		} catch (SigitExtException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.OK, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, "")).build();
		}
	}

	@Override
	public Response podpdrDuplicato(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req,
			String pod, String pdr) {
		try {
			UtenteLoggato user = authenticationService.getCurrentUser(req);
			Esito esito = null;
			esito = impiantoService.podDuplicato(user, pod);
			esito = impiantoService.pdrDuplicato(user, pdr);
			return Response.ok(new Esito(Constants.OK, "POD e PDR non duplicati")).build();
		} catch (SigitExtException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.OK, "POD o PDR duplicato")).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.KO, "")).build();
		}
	}

}
