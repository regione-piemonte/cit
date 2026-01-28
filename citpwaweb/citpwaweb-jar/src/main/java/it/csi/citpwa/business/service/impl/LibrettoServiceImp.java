/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service.impl;

import java.io.IOException;

import javax.ws.rs.NotFoundException;

import it.csi.citpwa.model.sigitext.*;
import it.csi.sigit.sigitext.ws.service.client.Impianto;
import it.csi.sigit.sigitext.ws.service.client.Libretto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.citpwa.business.service.ICitService;
import it.csi.citpwa.business.service.ILibrettoService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.JWTModel;
import it.csi.citpwa.util.Constants;
import it.csi.citpwa.util.JWTUtil;

@Service
public class LibrettoServiceImp implements ILibrettoService {

	@Autowired
	ICitService citService;

	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

	@Override
	public byte[] getLibrettoByCodice(UtenteLoggato utente, String codiceImpianto) throws SvistaException, IOException {
		try {
			JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(utente.getPfLoggato().getCodiceFiscalePF(), null);
			Impianto impianto = getImpiantoByCodice(codiceImpianto, tokenJWT);
			if (impianto != null && impianto.getUidIndexLibretto() != null) {
				Documento doc = citService.getLibrettoByUid(impianto.getUidIndexLibretto(), tokenJWT.getToken());
				if (doc != null && doc.getDoc() != null)
					return doc.getDoc().getBytes();
				else
					throw new NotFoundException();
			} else
				throw new NotFoundException();
		} catch (NotFoundException e) {
			log.error(Constants.LIBRETTO_LOG + "getLibrettoByCodice - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.LIBRETTO_LOG + "getLibrettoByCodice - error: ", e);
			throw e;
		}
	}
	
	@Override
	public SigitTLibretto getLibrettoDtoByCodice(UtenteLoggato utente, String codiceImpianto) throws SvistaException, IOException {
		try {
			JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(utente.getPfLoggato().getCodiceFiscalePF(), null);
			Impianto impianto = getImpiantoByCodice(codiceImpianto, tokenJWT);
			if (impianto != null && impianto.getUidIndexLibretto() != null) {
				return citService.getLibrettoDtoByUid(impianto.getUidIndexLibretto());
			} else
				throw new NotFoundException();
		} catch (NotFoundException e) {
			log.error(Constants.LIBRETTO_LOG + "getLibrettoByCodice - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.LIBRETTO_LOG + "getLibrettoByCodice - error: ", e);
			throw e;
		}
	}
	
	private Impianto getImpiantoByCodice(String codiceImpianto, JWTModel tokenJWT) {
		ImpiantoFiltro filtro = new ImpiantoFiltro();
		filtro.setCodiceImpianto(Integer.parseInt(codiceImpianto));
		Impianto[] impianto = citService.getImpiantoByFiltroJWT(filtro, tokenJWT.getToken());
		if (impianto != null && impianto[0] != null && impianto[0].getUidIndexLibretto() != null) {
			return impianto[0];
		}
		return null;
	}
	
	@Override
	public byte[] getXmlLibrettoNowByCodice(UtenteLoggato utente, String codiceImpianto, Boolean isConsolidato) throws IOException {
		try {
			JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(utente.getPfLoggato().getCodiceFiscalePF(), null);
			
			Documento doc = citService.getXmlLibrettoNow(Integer.parseInt(codiceImpianto), isConsolidato, tokenJWT.getToken());
			
			if (doc != null && doc.getDoc() != null) {
				return doc.getDoc().getBytes();
			}
			
			throw new NotFoundException();
			
		} catch (NotFoundException e) {
			log.error(Constants.LIBRETTO_LOG + "getXmllibrettoNowByCodice - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.LIBRETTO_LOG + "getXmllibrettoNowByCodice - error: ", e);
			throw e;
		}
	}

	@Override
	public byte[] getXMLLibrettoConsolidatoJWT(UtenteLoggato utente, String codiceImpianto) throws SvistaException, IOException {
		try {
			JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(utente.getPfLoggato().getCodiceFiscalePF(), null);

			Documento doc = citService.getXMLLibrettoConsolidatoJWT(Integer.parseInt(codiceImpianto), tokenJWT.getToken());

			if (doc != null && doc.getDoc() != null) {
				return doc.getDoc().getBytes();
			}

			throw new NotFoundException();

		} catch (NotFoundException e) {
			log.error(Constants.LIBRETTO_LOG + "getXMLLibrettoConsolidatoJWT - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.LIBRETTO_LOG + "getXMLLibrettoConsolidatoJWT - error: ", e);
			throw e;
		}
	}


	@Override
	public void consolidaLibretto(String codiceImpianto,UtenteLoggato utente) throws SvistaException {
		log.info(Constants.IMPIANTO_LOG + "consolidaLibretto - start");
		try {
			citService.consolidaLibretto(codiceImpianto,utente);
		} catch (SigitExtException e) {
			log.error(Constants.IMPIANTO_LOG + "consolidaLibretto - error: ", e);
			throw e;
		} catch (Exception e) {
			log.error(Constants.IMPIANTO_LOG + "consolidaLibretto - error: ", e);
			throw new SvistaException("Errore generico nel recupero del libretto");
		} finally {
			log.info(Constants.IMPIANTO_LOG + " consolidaLibretto - end");
		}
	}
	
	@Override
	public String setLibSch1IdImpianto(Integer codiceImpianto, Scheda1 scheda1, UtenteLoggato utenteLoggato) {
		log.info(Constants.SETLIBSCHEDA1IMPIANTO_LOG + "setLibSch1IdImpianto - start");
		String response;
		try {
			response = citService.setLibSch1IdImpianto(codiceImpianto, scheda1, utenteLoggato);
		} catch (SigitExtException e) {
			log.error(Constants.SETLIBSCHEDA1IMPIANTO_LOG + "setLibSch1IdImpianto - error: ", e);
			throw e;
		} catch (Exception e) {
			log.error(Constants.SETLIBSCHEDA1IMPIANTO_LOG + "setLibSch1IdImpianto - error: ", e);
			throw new SvistaException("Errore generico nel setLibSch1IdImpianto");
		} finally {
			log.info(Constants.SETLIBSCHEDA1IMPIANTO_LOG + " setLibSch1IdImpianto - end");
		}
		
		return response;
	}

	@Override
	public String setLibSch2IdImpianto(Integer codiceImpianto, Scheda2 scheda2, UtenteLoggato utenteLoggato) {
		log.info(Constants.SETLIBSCHEDA2IMPIANTO_LOG + "setLibSch2IdImpianto - start");
		String response;
		try {
			response = citService.setLibSch2IdImpianto(codiceImpianto, scheda2, utenteLoggato);
		} catch (SigitExtException e) {
			log.error(Constants.SETLIBSCHEDA2IMPIANTO_LOG + "setLibSch2IdImpianto - error: ", e);
			throw e;
		} catch (Exception e) {
			log.error(Constants.SETLIBSCHEDA2IMPIANTO_LOG + "setLibSch2IdImpianto - error: ", e);
			throw new SvistaException("Errore generico nel setLibSch2IdImpianto");
		} finally {
			log.info(Constants.SETLIBSCHEDA2IMPIANTO_LOG + " setLibSch2IdImpianto - end");
		}

		return response;
	}
	
	@Override
	public byte[] getLibrettoNowByCodice(UtenteLoggato utente, String codiceImpianto, Boolean isConsolidato) throws IOException {
		try {
			JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(utente.getPfLoggato().getCodiceFiscalePF(), null);
			
			Libretto doc = citService.getLibrettoNowByCodice(Integer.parseInt(codiceImpianto), isConsolidato, tokenJWT.getToken());
			
			if (doc != null && doc.getLibrettoPdf().getDoc() != null) {
				return doc.getLibrettoPdf().getDoc();
			}
			
			throw new NotFoundException();
			
		} catch (NotFoundException e) {
			log.error(Constants.LIBRETTO_LOG + "getLibrettoNowByCodice - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.LIBRETTO_LOG + "getLibrettoNowByCodice - error: ", e);
			throw e;
		}
	}
	
	@Override
	public Scheda1 getSchedaLibrettoByCodice(UtenteLoggato utente, String codiceImpianto) throws IOException {
		try {
			JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(utente.getPfLoggato().getCodiceFiscalePF(), null);
			
			return citService.getSchedaLibrettoByCodice(Integer.parseInt(codiceImpianto), tokenJWT.getToken());
		} catch (Exception e) {
			log.error(Constants.LIBRETTO_LOG + "getSchedaLibrettoByCodice - error: ", e);
			throw e;
		}
	}
	
	@Override
	public CodiceDescrizione[] getTipoIntervento() throws IOException{
		try {
			return citService.getTipoIntervento();
		} catch (Exception e) {
			log.error(Constants.LIBRETTO_LOG + "getTipoIntervento - error: ", e);
			throw e;
		}
	}
	
	@Override
	public Categoria[] getCategorie() throws IOException {
		return this.citService.getCategorie();
	}
	
}
