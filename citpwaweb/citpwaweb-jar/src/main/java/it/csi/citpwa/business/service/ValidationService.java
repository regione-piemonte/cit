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
import it.csi.citpwa.model.sigitext.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;

public interface ValidationService {
	public Esito validaInserisciImpianto(DatiImpiantoModel datiImpianto, UtenteLoggato utenteLoggato);

	public boolean isNotNullOrEmpty(Object s);

	public boolean isNotNullOrEmpty(Integer s);

	public boolean isNotNullOrEmpty(String s);

	public Boolean validateRicercaImpianto(UtenteLoggato utenteLoggato, ImpiantoFiltro impiantoFiltro);

	public Boolean isAbilitatoInserisciImpianto(UtenteLoggato utenteLoggato);

	public Boolean isStatoPGValido(UtenteLoggato utenteLoggato);

	public DatiImpianto mapDatiImpianto(DatiImpiantoModel datiImpianto);

	public Esito validaNuovoResponsabileProprietario(Persona persona);

	public XMLGregorianCalendar convertToDate(String date,String format) throws ParseException, DatatypeConfigurationException;
}
