/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service;

import java.io.File;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.ControlloDisponibileModel;
import it.csi.citpwa.model.DatiControlloModel;
import it.csi.citpwa.model.ManutFormModel;
import it.csi.citpwa.model.sigitext.Esito;
import it.csi.citpwa.model.sigitext.PdfControllo;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.sigit.sigitext.ws.service.client.SigitUserNotAuthorizedException;

public interface IControlliService {
	public DatiControlloModel recuperaDati(String codiceImpianto, String ordinamento, Integer numRighe, UtenteLoggato utenteLoggato) throws SvistaException, SocketTimeoutException;

	public byte[] getRicevuta(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, UtenteLoggato utenteLoggato) throws SvistaException, SocketTimeoutException, SigitUserNotAuthorizedException;

	public PdfControllo getPDFControllo(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, Boolean firmato, UtenteLoggato utenteLoggato)
			throws SvistaException, SocketTimeoutException, SigitUserNotAuthorizedException;

	public List<ControlloDisponibileModel> getControlliDisponibili(String codiceImpianto, String tipoComponente, String tipoControllo, String dataControllo, UtenteLoggato utenteLoggato)
			throws SvistaException, SigitUserNotAuthorizedException, SocketTimeoutException;

	public Object getXmlCOntrollo(Integer idAllegato, String tipoDoc, UtenteLoggato user) throws SvistaException, SocketTimeoutException, JAXBException;

	public void uploadReeFirmato(Integer idAllegato, File ree, String fileName, String mimeType, UtenteLoggato user) throws SvistaException, SocketTimeoutException;

	public void inviaManutenzione(String codiceImpianto, String tipoControllo, ManutFormModel manutFormModel, UtenteLoggato user) throws SvistaException, SocketTimeoutException;

	public Esito inserisciREE(String codiceImpianto, String tipoControllo, String ree, boolean invia, UtenteLoggato user) throws SvistaException , SocketTimeoutException;

	public void deleteControllo(Integer idAllegato, Integer statoRapp, UtenteLoggato utenteLoggato) throws SvistaException, SocketTimeoutException;

	public void modificaREE(Integer idAllegato, String codiceImpianto, String tipoControllo, boolean invia, String ree, UtenteLoggato user) throws SvistaException, SocketTimeoutException;

	public Esito inviaREE(Integer idAllegato, UtenteLoggato user) throws SvistaException, SocketTimeoutException;
}
