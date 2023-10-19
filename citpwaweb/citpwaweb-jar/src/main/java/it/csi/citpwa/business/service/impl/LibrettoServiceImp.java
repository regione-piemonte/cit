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
import it.csi.citpwa.business.service.ILibrettoService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.model.JWTModel;
import it.csi.citpwa.model.sigitext.ImpiantoFiltro;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.citpwa.util.Constants;
import it.csi.citpwa.util.JWTUtil;
import it.csi.sigit.sigitext.ws.service.client.Documento;
import it.csi.sigit.sigitext.ws.service.client.Impianto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;

@Service
public class LibrettoServiceImp implements ILibrettoService {

	@Autowired
	ICitService citService;

	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

	@Override
	public byte[] getlibrettoByCodice(UtenteLoggato utente, String codiceImpianto) throws Exception {
		try {
			JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(utente.getPfLoggato().getCodiceFiscalePF(), null);
			ImpiantoFiltro filtro = new ImpiantoFiltro();
			filtro.setCodiceImpianto(Integer.parseInt(codiceImpianto));
			Impianto[] impianto = citService.getImpiantoByFiltroJWT(filtro, tokenJWT.getToken());
			if (impianto != null && impianto[0] != null && impianto[0].getUidIndexLibretto() != null) {
				Documento doc = citService.getLibrettoByUid(impianto[0].getUidIndexLibretto(), tokenJWT.getToken());
				if (doc != null && doc.getDoc() != null)
					return doc.getDoc();
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
	public void consolidaLibretto(String codiceImpianto,UtenteLoggato utente) throws Exception {
		log.info(Constants.IMPIANTO_LOG + "consolidaLibretto - start");
		try {
			citService.consolidaLibretto(codiceImpianto,utente);
		} catch (SigitExtException e) {
			log.error(Constants.IMPIANTO_LOG + "consolidaLibretto - error: ", e);
			throw e;
		} catch (Exception e) {
			log.error(Constants.IMPIANTO_LOG + "consolidaLibretto - error: ", e);
			throw new Exception("Errore generico nel recupero del libretto");
		} finally {
			log.info(Constants.IMPIANTO_LOG + " consolidaLibretto - end");
		}
	}
}
