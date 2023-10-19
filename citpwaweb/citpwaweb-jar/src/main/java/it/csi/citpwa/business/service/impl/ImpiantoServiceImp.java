/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service.impl;

import it.csi.citpwa.business.service.ICitService;
import it.csi.citpwa.business.service.IImpiantoService;
import it.csi.citpwa.business.service.ILoccsiService;
import it.csi.citpwa.business.service.ValidationService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.exception.ValidationErrorException;
import it.csi.citpwa.model.DatiImpiantoModel;
import it.csi.citpwa.model.JWTModel;
import it.csi.citpwa.model.loccsi.LoccsiFeatureModel;
import it.csi.citpwa.model.loccsi.LoccsiModel;
import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.model.xsd.libretto.MOD;
import it.csi.citpwa.util.Constants;
import it.csi.citpwa.util.JWTUtil;
import it.csi.sigit.sigitext.ws.service.client.Impianto;
import it.csi.sigit.sigitext.ws.service.client.SigitUserNotAuthorizedException;
import it.csi.sigit.sigitext.ws.service.client.SigitextException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ImpiantoServiceImp implements IImpiantoService {

	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

	@Autowired
	private ICitService citService;

	@Autowired
	private ILoccsiService loccsiService;

	@Autowired
	private ValidationService validationService;

	@Override
	public CodiceDescrizione[] getStatoImpianto() throws Exception {
		log.info(Constants.IMPIANTO_LOG + "getStatoImpianto - start");
		try {
			return citService.getStatoImpianto();
		} catch (Exception e) {
			log.error(Constants.IMPIANTO_LOG + "getStatoImpianto - error: ", e);
			throw new Exception("Errore recupero STATI impianto");
		} finally {
			log.info(Constants.IMPIANTO_LOG + "getStatoImpianto - end");
		}
	}

	@Override
	public List<Impianto> getImpiantiByfiltro(UtenteLoggato utenteLoggato, String cf3Responsabile, String cfImpresa, String cfProprietario, String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String numeroRea, String pdr, String pod, String siglaProvincia, String siglaRea, Float x, Float y, Float distanza)
			throws Exception {
		log.info(Constants.IMPIANTO_LOG + "getImpiantiByFiltro - start");
		try {

			ImpiantoFiltro impiantoFiltro = mapParamToImpiantoFiltro(cf3Responsabile, cfImpresa, cfProprietario, cfResponsabile, civico, codiceImpianto, descComune, fkStato, flagVisuProprietario, idComune, indirizzo, istatComune, numeroRea, pdr, pod, siglaProvincia, siglaRea, x, y, distanza, utenteLoggato);
			if (validationService.validateRicercaImpianto(utenteLoggato, impiantoFiltro)) {
				if (utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_IMPRESA)) {
					impiantoFiltro.setNumeroRea(Integer.parseInt(utenteLoggato.getRuoloLoggato().getNumeroRea()));
					impiantoFiltro.setSiglaRea(utenteLoggato.getRuoloLoggato().getSiglaRea());
					impiantoFiltro.setCfImpresa(utenteLoggato.getRuoloLoggato().getPiva());

				}

				if (utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_PROPRIETARIO) || utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {
					impiantoFiltro.setFlagVisuProprietario(true);
				}

				if (utenteLoggato.getRuoloLoggato().getIstatAbilitazione() != null && !utenteLoggato.getRuoloLoggato().getIstatAbilitazione().isEmpty()) {
					if (utenteLoggato.getRuoloLoggato().getIstatAbilitazione().length() > 2) {
						String cod = utenteLoggato.getRuoloLoggato().getIstatAbilitazione().substring(2);
						impiantoFiltro.setIstatComune(cod);
					}
				}

				JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(utenteLoggato.getPfLoggato().getCodiceFiscalePF(), null);
				Impianto[] impiantoArray = citService.getImpiantoByFiltroJWT(impiantoFiltro, tokenJWT.getToken());
				if (impiantoArray != null && impiantoArray.length != 0)
					return Arrays.asList(impiantoArray);
				else
					return null;
			} else
				throw new SigitUserNotAuthorizedException();
		} catch (NotFoundException e) {
			return null;
		} catch (Exception e) {
			log.error(Constants.IMPIANTO_LOG + "getImpiantiByFiltro - error: ", e);
			throw new Exception("Errore generico nel recupero impianti");
		} finally {
			log.info(Constants.IMPIANTO_LOG + "getImpiantiByFiltro - end");
		}
	}

	@Override
	public List<LoccsiFeatureModel> getIndirizzoByLoccsi(String indirizzo) throws Exception {
		log.info(Constants.IMPIANTO_LOG + "getIndirizzoByLoccsi - start");
		try {
			List<LoccsiModel> model;
			List<LoccsiFeatureModel> featureModels = new ArrayList<>();
			LoccsiModel[] loccsiModelArray = loccsiService.getLOCCSICoordinates(indirizzo);
			if (loccsiModelArray != null && loccsiModelArray.length > 0) {
				model = Arrays.asList(loccsiModelArray);
				for (LoccsiModel loccsiModel : model) {
					switch (loccsiModel.getName()) {
						case Constants.IND_LOCCSI_CIVICI_FULL:
							for (LoccsiFeatureModel featureModel : loccsiModel.getFeatureCollection().getFeatures()) {
								featureModel.setType(Constants.LABEL_LOCCSI_FULL);
								featureModels.add(featureModel);
							}
							break;
						case Constants.IND_LOCCSI_STRADE:
							for (LoccsiFeatureModel featureModel : loccsiModel.getFeatureCollection().getFeatures()) {
								featureModel.setType(Constants.LABEL_LOCCSI_STRADE);
								featureModels.add(featureModel);
							}
							break;
						case Constants.IND_LOCCSI_COMUNI:
							for (LoccsiFeatureModel featureModel : loccsiModel.getFeatureCollection().getFeatures()) {
								featureModel.getProperties().setComune(featureModel.getProperties().getLoccsiLabel());
								featureModel.setType(Constants.LABEL_LOCCSI_COMUNI);
								featureModels.add(featureModel);
							}
							break;
					}
				}
				return featureModels;
			} else
				return null;
		} catch (Exception e) {
			log.error(Constants.IMPIANTO_LOG + "getIndirizzoByLoccsi - error: ", e);
			throw new Exception("Errore recupero indirizzo su loccsi");
		} finally {
			log.info(Constants.IMPIANTO_LOG + "getIndirizzoByLoccsi - end");
		}

	}

	@Override
	public List<Persona> cercaResponsabileProprietario(UtenteLoggato utente, Integer tipo, String cf, String siglaRea, String numeroRea) throws Exception {
		log.info(Constants.IMPIANTO_LOG + "cercaResponsabileProprietario - start");
		try {
			if (validationService.isAbilitatoInserisciImpianto(utente)) {
				Persona[] persona = citService.getRespProp(tipo, cf, siglaRea, numeroRea);
				if (persona != null && persona.length != 0)
					return Arrays.asList(persona);
				else
					throw new NotFoundException();
			} else {
				throw new SigitUserNotAuthorizedException();
			}
		} catch (SigitUserNotAuthorizedException e) {
			log.error(Constants.IMPIANTO_LOG + "cercaResponsabileProprietario - utente non autorizzato alla ricerca: ", e);
			throw new NotFoundException();
		} catch (NotFoundException e) {
			log.error(Constants.IMPIANTO_LOG + "cercaResponsabileProprietario - nessun responsabile/proprietario trovato: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.IMPIANTO_LOG + "cercaResponsabileProprietario - error: ", e);
			throw new Exception("Errore recupero persone");
		} finally {
			log.info(Constants.IMPIANTO_LOG + "cercaresponsabileProprietario - end");
		}
	}

	@Override
	public Esito setRespprop(UtenteLoggato utenteLoggato, String codiceImpianto, Persona persona) throws Exception {
		log.info(Constants.IMPIANTO_LOG + "setRespProp - start");
		Persona[] personaRicerca;
		try {
			if (validationService.isAbilitatoInserisciImpianto(utenteLoggato)) {
				Esito esito = validationService.validaNuovoResponsabileProprietario(persona);
				if (esito.getEsito().equals(Constants.OK)) {
					if (persona.getIdPersona() == null) {
						personaRicerca = citService.getRespProp(persona.getTipo(), persona.getCodiceFiscale(),null,null);
						if (personaRicerca != null && personaRicerca.length != 0) {
							throw new ValidationErrorException(" Il codice fiscale inserito e' gia' presente nel sistema. Per associarlo all'impianto premere il tasto 'cerca per codice fiscale'");
						}
					}
					RespPropModel respPropModel = new RespPropModel();
					respPropModel.setPersona(persona);
					respPropModel.setUtenteLoggato(utenteLoggato);
					respPropModel.setCodiceImpianto(codiceImpianto);
					return citService.setRespProp(respPropModel);
				} else
					throw new ValidationErrorException(esito.getDescrizioneEsito());
			} else {
				throw new SigitUserNotAuthorizedException();
			}
		} catch (SigitExtException e) {
			log.error(Constants.IMPIANTO_LOG + "setRespProp - error: ", e);
			throw new SigitExtException(e.getMessage());
		} catch (ValidationErrorException e) {
			log.error(Constants.IMPIANTO_LOG + "setRespProp - error: ", e);
			throw new ValidationErrorException(e.getMessage());
		} catch (SigitUserNotAuthorizedException e) {
			log.error(Constants.IMPIANTO_LOG + "setRespProp - utente non autorizzato: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.IMPIANTO_LOG + "setRespProp - error: ", e);
			throw new Exception("Errore inserimento responsabile/proprietario", e);
		} finally {
			log.info(Constants.IMPIANTO_LOG + "setRespProp - end");
		}
	}

	@Override
	public Esito aggiornaRespProp(UtenteLoggato utenteLoggato, String codiceImpianto, Persona persona) throws Exception {
		log.info(Constants.IMPIANTO_LOG + "aggiornaRespProp - start");
		try {
			Persona[] personaRicerca;
			if (validationService.isAbilitatoInserisciImpianto(utenteLoggato)) {
				personaRicerca = citService.getRespProp(persona.getTipo(), persona.getCodiceFiscale(),null,null);
				if (personaRicerca != null && personaRicerca.length != 0) {
					persona.setIdPersona(personaRicerca[0].getIdPersona());
				} else
					throw new NotFoundException("Nessun responsabile trovato");
				RespPropModel respPropModel = new RespPropModel();
				respPropModel.setPersona(persona);
				respPropModel.setUtenteLoggato(utenteLoggato);
				respPropModel.setCodiceImpianto(codiceImpianto);
				return citService.setRespProp(respPropModel);
			} else {
				throw new SigitUserNotAuthorizedException();
			}
		} catch (ValidationErrorException | SigitExtException e) {
			log.error(Constants.IMPIANTO_LOG + "aggiornaRespProp - error: ", e);
			throw new ValidationErrorException(e.getMessage());
		} catch (SigitUserNotAuthorizedException e) {
			log.error(Constants.IMPIANTO_LOG + "aggiornaRespProp - utente non autorizzato: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.IMPIANTO_LOG + "aggiornaRespProp - error: ", e);
			throw new Exception("Errore inserimento responsabile/proprietario", e);
		} finally {
			log.info(Constants.IMPIANTO_LOG + "aggiornaRespProp - end");
		}
	}

	@Override
	public Esito setImpianto(UtenteLoggato utenteLoggato, DatiImpiantoModel datiImpianto, String codice, Integer responsabilita) throws Exception {
		log.info(Constants.IMPIANTO_LOG + "setimpianto - start");
		try {
			if (validationService.isAbilitatoInserisciImpianto(utenteLoggato)) {
				Esito esito = validationService.validaInserisciImpianto(datiImpianto, utenteLoggato);
				if (esito.getEsito().equals(Constants.OK)) {
					if (codice == null)
						return citService.setImpianto(utenteLoggato, validationService.mapDatiImpianto(datiImpianto), responsabilita);
					else {
						datiImpianto.setCodiceImpianto(codice);
						return citService.updateImpianto(utenteLoggato, validationService.mapDatiImpianto(datiImpianto));
					}
				} else
					throw new ValidationErrorException(esito.getDescrizioneEsito());
			} else
				throw new SigitUserNotAuthorizedException();

		} catch (ValidationErrorException e) {
			log.error(Constants.IMPIANTO_LOG + "setImpianto - error: ", e);
			throw new ValidationErrorException(e.getMessage());
		} catch (SigitUserNotAuthorizedException e) {
			log.error(Constants.IMPIANTO_LOG + "setImpianto - error: ", e);
			throw new SigitUserNotAuthorizedException();
		} catch (Exception e) {
			log.error(Constants.IMPIANTO_LOG + "setImpianto - error: ", e);
			throw new Exception(e.getMessage());
		} finally {
			log.info(Constants.IMPIANTO_LOG + "setImpianto - end");
		}
	}

	private ImpiantoFiltro mapParamToImpiantoFiltro(String cf3Responsabile, String cfImpresa, String cfProprietario, String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String numeroRea, String pdr, String pod, String siglaProvincia, String siglaRea, Float x, Float y, Float distanza, UtenteLoggato utenteLoggato) {
		ImpiantoFiltro impiantoFiltro = new ImpiantoFiltro();
		String ruolo = utenteLoggato.getRuoloLoggato().getRuolo();

		if (ruolo.equals(Constants.RUOLO_3RESPONSABILE))
			impiantoFiltro.setCf3Responsabile(utenteLoggato.getRuoloLoggato().getPiva());
		else
			impiantoFiltro.setCf3Responsabile(cf3Responsabile);
		impiantoFiltro.setCfImpresa(cfImpresa);

		if (ruolo.equals(Constants.RUOLO_PROPRIETARIO)) {
			impiantoFiltro.setCfProprietario(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
			impiantoFiltro.setFlagVisuProprietario(true);
		} else if (ruolo.equals(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {
			impiantoFiltro.setCfProprietario(utenteLoggato.getRuoloLoggato().getPiva());
			impiantoFiltro.setFlagVisuProprietario(true);
		} else
			impiantoFiltro.setCfProprietario(cfProprietario);

		if (ruolo.equals(Constants.RUOLO_RESPONSABILE))
			impiantoFiltro.setCfResponsabile(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
		else if (ruolo.equals(Constants.RUOLO_RESPONSABILE_IMPRESA))
			impiantoFiltro.setCfResponsabile(utenteLoggato.getRuoloLoggato().getPiva());
		else
			impiantoFiltro.setCfResponsabile(cfResponsabile);

		impiantoFiltro.setCivico(civico);
		impiantoFiltro.setCodiceImpianto(codiceImpianto != null ? Integer.parseInt(codiceImpianto) : null);
		impiantoFiltro.setDescComune(descComune);
		impiantoFiltro.setFkStato(fkStato != null ? Integer.parseInt(fkStato) : null);
		impiantoFiltro.setFlagVisuProprietario(flagVisuProprietario != null ? Boolean.parseBoolean(flagVisuProprietario) : null);
		impiantoFiltro.setIdComune(idComune);
		impiantoFiltro.setIndirizzo(indirizzo);
		impiantoFiltro.setIstatComune(istatComune);
		impiantoFiltro.setNumeroRea(numeroRea != null ? Integer.parseInt(numeroRea) : null);
		impiantoFiltro.setPdr(pdr);
		impiantoFiltro.setPod(pod);
		impiantoFiltro.setSiglaProvincia(siglaProvincia);
		impiantoFiltro.setSiglaRea(siglaRea);
		impiantoFiltro.setX(x);
		impiantoFiltro.setY(y);
		impiantoFiltro.setDistanza(distanza);
		return impiantoFiltro;
	}

	@Override
	public List<LoccsiFeatureModel> getProvinciaByLoccsi(String comune) throws Exception {
		try {
			List<LoccsiModel> model;
			List<LoccsiFeatureModel> featureModels = new ArrayList<>();
			LoccsiModel[] loccsiModelArray = loccsiService.getLOCCSICoordinates(comune);
			if (loccsiModelArray != null && loccsiModelArray.length > 0) {
				model = Arrays.asList(loccsiModelArray);
				for (LoccsiModel loccsiModel : model) {
					if (loccsiModel.getName().equals(Constants.IND_LOCCSI_COMUNI)) {
						featureModels.addAll(loccsiModel.getFeatureCollection().getFeatures());
					}
				}
				return featureModels;
			} else
				return null;
		} catch (Exception e) {
			log.error(Constants.IMPIANTO_LOG + "getProvinciaByLoccsi - error: ", e);
			throw new Exception("Errore recupero indirizzo su loccsi");
		} finally {
			log.info(Constants.IMPIANTO_LOG + "getPorivinciaByLoccsi - end");
		}
	}

	@Override
	public MOD getDatiImpiantoXML(String codiceImpianto, UtenteLoggato utenteLoggato) throws Exception {
		log.info(Constants.IMPIANTO_LOG + "getDatiImpiantoXML - start");
		try {
			JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(utenteLoggato.getPfLoggato().getCodiceFiscalePF(), null);
			return citService.getLibrettoNow(codiceImpianto, false, tokenJWT.getToken());
		} catch (NotFoundException e) {
			return null;
		} catch (Exception e) {
			log.error(Constants.IMPIANTO_LOG + "getDatiImpiantoXML - error: ", e);
			throw new Exception("Errore generico nel recupero del libretto");
		} finally {
			log.info(Constants.IMPIANTO_LOG + " getDatiImpiantoXML - end");
		}
	}

	@Override
	public Esito podDuplicato(UtenteLoggato utenteLoggato, String pod) throws Exception {
		log.info(Constants.IMPIANTO_LOG + "podPdrDuplicato - start");
		Esito esito = new Esito(Constants.OK,"Codice pod univoco");
		try {
			JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(utenteLoggato.getPfLoggato().getCodiceFiscalePF(), null);
			ImpiantoFiltro filtro = new ImpiantoFiltro();
			filtro.setPod(pod);
			filtro.setFkStato(Constants.FK_STATO_IMPIANTO_ATTIVO);
			Impianto[] impiantiByPod = citService.getImpiantoByFiltroJWT(filtro,tokenJWT.getToken());
			if(impiantiByPod!=null && impiantiByPod.length>0){
				throw new SigitExtException();
			}
			return esito;
		} catch (SigitExtException e) {
			throw new SigitExtException("Codice pod duplicato");
		} catch (Exception e) {
			log.error(Constants.IMPIANTO_LOG + "podPdrDuplicato - error: ", e);
			throw new Exception("Errore generico nel recupero degli impianti");
		} finally {
			log.info(Constants.IMPIANTO_LOG + " podPdrDuplicato - end");
		}
	}

	public Esito pdrDuplicato(UtenteLoggato utenteLoggato,  String pdr) throws Exception {
		log.info(Constants.IMPIANTO_LOG + "pdrDuplicato - start");
		Esito esito = new Esito(Constants.OK,"Codice pdr univoco");
		try {
			JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(utenteLoggato.getPfLoggato().getCodiceFiscalePF(), null);
			ImpiantoFiltro filtro = new ImpiantoFiltro();
			filtro.setPdr(pdr);
			filtro.setFkStato(Constants.FK_STATO_IMPIANTO_ATTIVO);
			Impianto[] impiantiByPdr = citService.getImpiantoByFiltroJWT(filtro,tokenJWT.getToken());
			if(impiantiByPdr!=null && impiantiByPdr.length>0){
				throw new SigitExtException();
			}
			return esito;
		} catch (SigitExtException e) {
			throw new SigitExtException("Codice pdr duplicato");
		} catch (Exception e) {
			log.error(Constants.IMPIANTO_LOG + "pdrDuplicato - error: ", e);
			throw new Exception("Errore generico nel recupero degli impianti");
		} finally {
			log.info(Constants.IMPIANTO_LOG + " pdrDuplicato - end");
		}
	}
}
