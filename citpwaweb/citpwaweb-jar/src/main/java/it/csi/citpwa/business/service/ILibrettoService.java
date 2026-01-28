/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service;

import java.io.IOException;

import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.sigitext.*;
import it.csi.sigit.sigitext.ws.service.client.Documento;

public interface ILibrettoService {
	public byte[] getLibrettoByCodice(UtenteLoggato utente, String codiceImpianto) throws SvistaException, IOException;
	
	SigitTLibretto getLibrettoDtoByCodice(UtenteLoggato utente, String codiceImpianto) throws SvistaException, IOException;
	
	byte[] getXmlLibrettoNowByCodice(UtenteLoggato utente, String codiceImpianto, Boolean isConsolidato) throws SvistaException, IOException;

	byte[] getXMLLibrettoConsolidatoJWT(UtenteLoggato utente, String codiceImpianto) throws SvistaException, IOException;

	public void consolidaLibretto(String codiceImpianto, UtenteLoggato utente) throws SvistaException;
	
	String setLibSch1IdImpianto(Integer codiceImpianto, Scheda1 scheda1, UtenteLoggato utenteLoggato);

	String setLibSch2IdImpianto(Integer codiceImpianto, Scheda2 scheda2, UtenteLoggato utenteLoggato);
	
	byte[] getLibrettoNowByCodice(UtenteLoggato utente, String codiceImpianto, Boolean isConsolidato) throws SvistaException, IOException;
	
	Scheda1 getSchedaLibrettoByCodice(UtenteLoggato utente, String codiceImpianto) throws IOException;
	
	Categoria[] getCategorie() throws IOException;
	
	CodiceDescrizione[] getTipoIntervento() throws IOException;
	
}
