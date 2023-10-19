/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service;

import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.model.xsd.libretto.MOD;
import it.csi.sigit.sigitext.ws.service.client.Documento;
import it.csi.sigit.sigitext.ws.service.client.Impianto;

import javax.print.Doc;
import java.util.Date;
import java.util.List;

public interface ICitService {
	Ruoli getRuoliUtente(String cf, String nome, String cognome) throws Exception;

	String setAccesso(UtenteLoggato utenteLoggato) throws Exception;

	public CodiceDescrizione[] getStatoImpianto() throws Exception;

	public CodiceDescrizione[] getMarcaCIT() throws Exception;

	public CodiceDescrizione[] getCombustibileCIT() throws Exception;

	public CodiceDescrizione[] getFluidoCIT() throws Exception;

	public CodiceDescrizione[] getTipologiaGT() throws Exception;

	public CodiceDescrizione[] getTipologiaGF() throws Exception;


	public CodiceDescrizione[] getFonteCIT() throws Exception;

	public CodiceDescrizione[] getTipoCannaFumaria() throws Exception;

	public CodiceDescrizione[] getStelle() throws Exception;

	public CodiceDescrizione[] getApparecchiature() throws Exception;

	public CodiceDescrizione[] getAriaComburente() throws Exception;

	public CodiceDescrizione[] getControlloAria() throws Exception;

	public CodiceDescrizione[] getUnitaMisura() throws Exception;

	public Impianto[] getImpiantoByFiltroJWT(ImpiantoFiltro impiantoFiltro, String tokenJWT) throws Exception;

	public Esito setImpianto(UtenteLoggato utenteLoggato, DatiImpianto datiImpianto, Integer tipoResponsabilita) throws Exception;

	public MOD getLibrettoNow(String codiceImpianto, boolean isConsolidato, String tokenJWT) throws Exception;

	public byte[] getXMLControllo(Integer idAllegato) throws Exception;

	public Esito updateImpianto(UtenteLoggato utenteLoggato, DatiImpianto mapDatiImpianto) throws Exception;

	public Documento getLibrettoByUid(String uid, String token) throws Exception;

	public Persona[] getRespProp(Integer tipo, String cf, String siglaRea, String numeroRea) throws Exception;

	public Esito setRespProp(RespPropModel respPropModel) throws Exception;

	public DatiGT[] getGT(String codiceimpianto, Integer progressivo, Integer idPersona) throws Exception;

	public DatiGF[] getGF(String codiceimpianto, Integer progressivo, Integer idPersona) throws Exception;

	public DatiSC[] getSC(String codiceimpianto, Integer progressivo, Integer idPersona) throws Exception;

	public DatiCG[] getCG(String codiceimpianto, Integer progressivo, Integer idPersona) throws Exception;

	public Esito updateGT(UpdateGtModel updateGtModel, Integer idImpresaSelez) throws Exception;

	public Esito updateGF(UpdateGfModel updateGfModel, Integer idImpresaSelez) throws Exception;

	public Esito updateSC(UpdateScModel updateGtModel, Integer idImpresaSelez) throws Exception;

	public Esito updateCG(UpdateCgModel updateGfModel, Integer idImpresaSelez) throws Exception;

	public List<Controllo> getControlli(String codiceImpianto, String ordinamento, Integer numRighe) throws Exception;

	public byte[] getRicevutaControllo(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, UtenteLoggato utenteLoggato) throws Exception;

	public PdfControllo getPDFControllo(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, Boolean firmato, UtenteLoggato utenteLoggato)
			throws Exception;

	public List<ControlloDisponibile> getControlliDisponibili(String codiceImpianto, String tipoComponente, String tipoControllo, String dataControllo, UtenteLoggato utenteLoggato) throws Exception;

	public Integer uploadXMLControlloJWT(Integer codiceImpianto, String tipoControllo, byte[] xml, String token) throws Exception;

	public void uploadReeFirmato(Integer idAllegato, byte[] ree, String fileName, String contentType, Integer idPersonaGiuridica, String piva, String ruolo) throws Exception;

	public Integer modificaControlloJWT(Integer idAllegato, Integer codiceImpianto, String tipoControllo, byte[] xml, String token) throws Exception;

	public Esito deleteControllo(Integer idAllegato, Integer idPersonaGiuridica, String piva, String ruolo) throws Exception;

	public Esito delComponente(String codiceImpianto, String tipo, Integer progressivo, String cf) throws Exception;

	public Esito inviaREE(Integer idAllegato, Integer idPersonaGiuridica, String piva, RuoloLoggato ruoloLoggato) throws Exception;

	public Esito consolidaLibretto(String codiceImpianto, UtenteLoggato utenteLoggato) throws Exception;

	public void ping() throws Exception;
}
