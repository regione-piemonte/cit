/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service;

import it.csi.citpwa.model.sigitext.UtenteLoggato;

public interface ILibrettoService {
	public byte[] getlibrettoByCodice(UtenteLoggato utente, String codiceImpianto) throws Exception;

	public void consolidaLibretto(String codiceImpianto, UtenteLoggato utente) throws Exception;
}
