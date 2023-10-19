/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service;

import it.csi.citpwa.model.DatiImpiantoModel;
import it.csi.citpwa.model.loccsi.LoccsiFeatureModel;
import it.csi.citpwa.model.sigitext.CodiceDescrizione;
import it.csi.citpwa.model.sigitext.Esito;
import it.csi.citpwa.model.sigitext.Persona;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.citpwa.model.xsd.libretto.MOD;
import it.csi.sigit.sigitext.ws.service.client.Impianto;

import java.util.List;

public interface IImpiantoService {
	public CodiceDescrizione[] getStatoImpianto() throws Exception;

	public List<Impianto> getImpiantiByfiltro(UtenteLoggato utenteLoggato, String cf3Responsabile, String cfImpresa, String cfProprietario, String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String numeroRea, String pdr, String pod, String siglaProvincia, String siglaRea, Float x, Float y, Float distanza)
			throws Exception;

	public List<LoccsiFeatureModel> getIndirizzoByLoccsi(String indirizzo) throws Exception;

	public Esito setImpianto(UtenteLoggato utenteLoggato, DatiImpiantoModel datiImpianto, String codice, Integer responsabilita) throws Exception;

	public List<LoccsiFeatureModel> getProvinciaByLoccsi(String comune) throws Exception;

	public MOD getDatiImpiantoXML(String codiceImpianto, UtenteLoggato utenteLoggato) throws Exception;

	public List<Persona> cercaResponsabileProprietario(UtenteLoggato utenteLoggato, Integer tipo, String cf,String siglaRea, String numeroRea) throws Exception;

	public Esito setRespprop(UtenteLoggato utenteLoggato, String codiceImpianto, Persona persona) throws Exception;

	public Esito aggiornaRespProp(UtenteLoggato utenteLoggato, String codiceImpianto, Persona persona) throws Exception;

	public Esito pdrDuplicato(UtenteLoggato utenteLoggato,String pdr) throws Exception;
	public Esito podDuplicato(UtenteLoggato utenteLoggato, String pod) throws Exception;
}
