/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service;

import it.csi.citpwa.model.sigitext.Ruoli;
import it.csi.citpwa.model.sigitext.UtenteLoggato;

import javax.servlet.http.HttpServletRequest;

public interface IAuthenticationService {

	public UtenteLoggato getCurrentUser(HttpServletRequest req);

	public void localLogout(HttpServletRequest req);

	public Ruoli getRuoliUtente(HttpServletRequest req) throws Exception;

	public UtenteLoggato setAccesso(HttpServletRequest req, UtenteLoggato utenteLoggato) throws Exception;

	public void ping() throws Exception;
}
