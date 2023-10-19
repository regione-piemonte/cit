/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service;

import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.model.*;
import it.csi.citpwa.model.sigitext.Esito;
import it.csi.citpwa.model.sigitext.PdfControllo;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.sigit.sigitext.ws.service.client.Documento;

import java.io.File;
import java.util.Date;
import java.util.List;

public interface IControlliService {
	public DatiControlloModel recuperaDati(String codiceImpianto, String ordinamento, Integer numRighe, UtenteLoggato utenteLoggato) throws Exception;

	public byte[] getRicevuta(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, UtenteLoggato utenteLoggato) throws Exception;

	public PdfControllo getPDFControllo(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, Boolean firmato, UtenteLoggato utenteLoggato)
			throws Exception;

	public List<ControlloDisponibileModel> getControlliDisponibili(String codiceImpianto, String tipoComponente, String tipoControllo, String dataControllo, UtenteLoggato utenteLoggato)
			throws Exception;

	public Object getXmlCOntrollo(Integer idAllegato, String tipoDoc, UtenteLoggato user) throws Exception;

	public void uploadReeFirmato(Integer idAllegato, File ree, String fileName, String mimeType, UtenteLoggato user) throws Exception;

	public void inviaManutenzione(String codiceImpianto, String tipoControllo, ManutFormModel manutFormModel, UtenteLoggato user) throws Exception;

	public Esito inserisciREE(String codiceImpianto, String tipoControllo, String ree,boolean invia, UtenteLoggato user) throws Exception;

	public void deleteControllo(Integer idAllegato, Integer statoRapp, UtenteLoggato utenteLoggato) throws Exception;

	public void modificaREE(Integer idAllegato, String codiceImpianto, String tipoControllo,boolean invia, String ree, UtenteLoggato user) throws Exception;

	public Esito inviaREE(Integer idAllegato, UtenteLoggato user) throws Exception;
}
