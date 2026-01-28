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
import java.util.List;

import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.DatiAzione;
import it.csi.citpwa.model.DatiImpiantoModel;
import it.csi.citpwa.model.JWTModel;
import it.csi.citpwa.model.SubentroComponente;
import it.csi.citpwa.model.loccsi.LoccsiFeatureModel;
import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.model.sigitext.geojson.FeatureCollection;
import it.csi.citpwa.model.xsd.libretto.MOD;
import it.csi.sigit.sigitext.ws.service.client.Impianto;
import it.csi.sigit.sigitext.ws.service.client.SigitUserNotAuthorizedException;

public interface IImpiantoService {
	public CodiceDescrizione[] getStatoImpianto() throws SvistaException;

	public List<Impianto> getImpiantiByfiltro(UtenteLoggato utenteLoggato, String cf3Responsabile, String cfImpresa, String cfProprietario, String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String numeroRea, String pdr, String pod, String siglaProvincia, String siglaRea, Float x, Float y, Float distanza)
			throws SvistaException;

	public FeatureCollection getGeoJsonImpiantiByfiltro(UtenteLoggato utenteLoggato, String cf3Responsabile, String cfImpresa, String cfProprietario, String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String numeroRea, String pdr, String pod, String siglaProvincia, String siglaRea, Float x, Float y, Float distanza, Boolean ricercaCompleta)
			throws SvistaException;

	public FeatureCollection getGeoJsonImpiantiDuplicatiByfiltroResponsabile(UtenteLoggato utenteLoggato, String cf3Responsabile, String cfImpresa, String cfProprietario, String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String numeroRea, String pdr, String pod, String siglaProvincia, String siglaRea, Float x, Float y, Float distanza, Boolean ricercaCompleta)
			throws SvistaException;

	public List<LoccsiFeatureModel> getIndirizzoByLoccsi(String indirizzo) throws SvistaException;

	public Esito setImpianto(UtenteLoggato utenteLoggato, DatiImpiantoModel datiImpianto, String codice, Integer responsabilita) throws SvistaException, SigitUserNotAuthorizedException;

	public List<LoccsiFeatureModel> getProvinciaByLoccsi(String comune) throws SvistaException;

	public MOD getDatiImpiantoXML(String codiceImpianto, UtenteLoggato utenteLoggato) throws SvistaException;

	public List<Persona> cercaResponsabileProprietario(UtenteLoggato utenteLoggato, Integer tipo, String cf,String siglaRea, String numeroRea, Boolean checkAbilitazioneInsImpianto) throws SvistaException;

	public Esito setRespprop(UtenteLoggato utenteLoggato, String codiceImpianto, Persona persona) throws SvistaException;

	public Esito aggiornaRespProp(UtenteLoggato utenteLoggato, String codiceImpianto, Persona persona) throws SvistaException;

	public Esito pdrDuplicato(UtenteLoggato utenteLoggato,String pdr) throws SvistaException;
	public Esito podDuplicato(UtenteLoggato utenteLoggato, String pod) throws SvistaException;
	String verifyIndirizzoImpianto(DatiImpianto datiImpianto, Boolean checkContrattoInEssere) throws SvistaException;
	List<Persona> getElencoStoricoResponsabiliImpianto(String codiceImpianto) throws SvistaException;
	Esito setSubentroComponente(String codiceImpianto, String idPersonaGiuridica, Boolean sendMail, SubentroComponente subentro);

	Impianto[] getImpiantoByCodiceJWT(String codiceImpianto, JWTModel tokenJWT) throws IOException;

	public Integer getGeoJsonImpiantoMaxResults() throws SvistaException;

}
