/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service;

import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.exception.ValidationErrorException;
import it.csi.citpwa.model.sigitext.Ruoli;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.sigit.sigitext.ws.service.client.SigitUserNotAuthorizedException;

import java.net.SocketTimeoutException;

import javax.servlet.http.HttpServletRequest;

public interface IAuthenticationService {

	public UtenteLoggato getCurrentUser(HttpServletRequest req) throws SvistaException, SocketTimeoutException, ValidationErrorException, SigitUserNotAuthorizedException;

	public void localLogout(HttpServletRequest req);

	public Ruoli getRuoliUtente(HttpServletRequest req) throws SvistaException, SigitUserNotAuthorizedException, SocketTimeoutException, ValidationErrorException ;

	public UtenteLoggato setAccesso(HttpServletRequest req, UtenteLoggato utenteLoggato) throws SvistaException, SigitUserNotAuthorizedException;

	public String getDisponibilitaServizio(UtenteLoggato utenteLoggato) throws SvistaException;

	public void ping() throws SvistaException, SocketTimeoutException;

}
