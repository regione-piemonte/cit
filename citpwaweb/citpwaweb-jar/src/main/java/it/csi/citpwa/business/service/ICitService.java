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
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.*;
import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.model.sigitext.geojson.FeatureCollection;
import it.csi.citpwa.model.xsd.libretto.MOD;
import it.csi.sigit.sigitext.ws.service.client.Impianto;
import it.csi.sigit.sigitext.ws.service.client.Libretto;

public interface ICitService {
	Ruoli getRuoliUtente(String cf, String nome, String cognome) throws SvistaException;

	String setAccesso(UtenteLoggato utenteLoggato) throws SvistaException;

	public CodiceDescrizione[] getStatoImpianto() throws SvistaException;

	public CodiceDescrizione[] getMarcaCIT() throws SvistaException, SocketTimeoutException;

	public CodiceDescrizione[] getCombustibileCIT() throws SvistaException, SocketTimeoutException;

	public CodiceDescrizione[] getClassDpr66096CIT() throws SvistaException, SocketTimeoutException;

	public CodiceDescrizione[] getFrequenzaManutCIT() throws SvistaException, SocketTimeoutException;

	public CodiceDescrizione[] getFluidoCIT() throws SvistaException, SocketTimeoutException;

	public CodiceDescrizione[] getTipologiaGT() throws SvistaException, SocketTimeoutException;

	public CodiceDescrizione[] getTipologiaGF() throws SvistaException, SocketTimeoutException;


	public CodiceDescrizione[] getFonteCIT() throws SvistaException, SocketTimeoutException;

	public CodiceDescrizione[] getTipoCannaFumaria() throws SvistaException, SocketTimeoutException;

	public CodiceDescrizione[] getStelle() throws SvistaException, SocketTimeoutException;

	public CodiceDescrizione[] getApparecchiature() throws SvistaException, SocketTimeoutException ;

	public CodiceDescrizione[] getAriaComburente() throws SvistaException, SocketTimeoutException;

	public CodiceDescrizione[] getControlloAria() throws SvistaException, SocketTimeoutException;

	public CodiceDescrizione[] getUnitaMisura() throws SvistaException, SocketTimeoutException;

	public Impianto[] getImpiantoByFiltroJWT(ImpiantoFiltro impiantoFiltro, String tokenJWT) throws SvistaException;

	public FeatureCollection getGeoJsonImpiantoByFiltroJWT(ImpiantoFiltro impiantoFiltro, String token) throws SvistaException;

	public FeatureCollection getGeoJsonImpiantoDuplicatiByFiltroResponsabileJWT(ImpiantoFiltro impiantoFiltro, String token) throws SvistaException;
	
	public Esito setImpianto(UtenteLoggato utenteLoggato, DatiImpianto datiImpianto, Integer tipoResponsabilita) throws SigitExtException, SvistaException, IOException;

	public MOD getLibrettoNow(String codiceImpianto, boolean isConsolidato, String tokenJWT) throws SvistaException;

	public byte[] getXMLControllo(Integer idAllegato) throws SvistaException, SocketTimeoutException;

	public Esito updateImpianto(UtenteLoggato utenteLoggato, DatiImpianto mapDatiImpianto) throws SvistaException;

	public Documento getLibrettoByUid(String uid, String token) throws SvistaException, IOException;
	
	public SigitTLibretto getLibrettoDtoByUid(String uid) throws SvistaException, IOException;

	public Persona[] getRespProp(Integer tipo, String cf, String siglaRea, String numeroRea) throws SvistaException;

	public Esito setRespProp(RespPropModel respPropModel) throws SvistaException, IOException;

	public DatiGT[] getGT(String codiceimpianto, Integer progressivo, Integer idPersona) throws Exception, SocketTimeoutException;

	public DatiGF[] getGF(String codiceimpianto, Integer progressivo, Integer idPersona) throws SvistaException, SocketTimeoutException;

	public DatiSC[] getSC(String codiceimpianto, Integer progressivo, Integer idPersona) throws SvistaException, SocketTimeoutException;

	public DatiCG[] getCG(String codiceimpianto, Integer progressivo, Integer idPersona) throws SvistaException, SocketTimeoutException;

	public Esito updateGT(UpdateGtModel updateGtModel, Integer idImpresaSelez) throws SvistaException, IOException;

	public Esito updateGF(UpdateGfModel updateGfModel, Integer idImpresaSelez) throws SvistaException, IOException;

	public Esito updateSC(UpdateScModel updateGtModel, Integer idImpresaSelez) throws SvistaException, IOException;

	public Esito updateCG(UpdateCgModel updateGfModel, Integer idImpresaSelez) throws SvistaException, IOException;

	public List<Controllo> getControlli(String codiceImpianto, String ordinamento, Integer numRighe) throws SvistaException, SocketTimeoutException;

	public byte[] getRicevutaControllo(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, UtenteLoggato utenteLoggato) throws SvistaException, IOException;

	public PdfControllo getPDFControllo(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, Boolean firmato, UtenteLoggato utenteLoggato)
			throws SvistaException, IOException;

	public List<ControlloDisponibile> getControlliDisponibili(String codiceImpianto, String tipoComponente, String tipoControllo, String dataControllo, UtenteLoggato utenteLoggato) throws SvistaException, IOException;

	public Integer uploadXMLControlloJWT(Integer codiceImpianto, String tipoControllo, byte[] xml, String token) throws SvistaException, IOException;

	public void uploadReeFirmato(Integer idAllegato, byte[] ree, String fileName, String contentType, Integer idPersonaGiuridica, String piva, String ruolo) throws SvistaException, IOException;

	public Integer modificaControlloJWT(Integer idAllegato, Integer codiceImpianto, String tipoControllo, byte[] xml, String token) throws SvistaException, IOException;

	public Esito deleteControllo(Integer idAllegato, Integer idPersonaGiuridica, String piva, String ruolo) throws SvistaException, IOException;

	public Esito delComponente(String codiceImpianto, String tipo, Integer progressivo, String cf) throws SvistaException, IOException;

	public Esito inviaREE(Integer idAllegato, Integer idPersonaGiuridica, String piva, RuoloLoggato ruoloLoggato) throws SvistaException, IOException;

	public Esito consolidaLibretto(String codiceImpianto, UtenteLoggato utenteLoggato) throws SvistaException, IOException;

	public void ping() throws SvistaException, SocketTimeoutException;

	String getDisponibilitaServizio(UtenteLoggato utenteLoggato) throws SvistaException;
	
	Documento getXmlLibrettoNow(Integer codiceImpianto, Boolean isConsolidato, String token) throws SvistaException, IOException;

	Documento getXMLLibrettoConsolidatoJWT(int i, String token) throws IOException;

	String setLibSch1IdImpianto(Integer codiceImpianto, Scheda1 scheda1, UtenteLoggato utenteLoggato) throws IOException;

	String setLibSch2IdImpianto(Integer codiceImpianto, Scheda2 scheda2, UtenteLoggato utenteLoggato) throws IOException;
	
	Libretto getLibrettoNowByCodice(Integer codiceImpianto, Boolean isConsolidato, String token) throws SvistaException, IOException;

	Scheda1 getSchedaLibrettoByCodice(Integer codiceImpianto, String token) throws SvistaException, IOException;
	
	Categoria[] getCategorie() throws IOException;
	
	CodiceDescrizione[] getTipoIntervento() throws IOException;
	
	String setDocumento(DocumentoPwa documento, Integer idContratto, String cfUtenteLoggato, Integer codiceImpianto, Integer idAzione, String tipoDoc, Integer fkIspezIspett, String dataControllo) throws SvistaException, IOException;
	ResponseGetElencoDocumenti getElencoDocumenti(Integer codiceImpianto, Integer idVerifica, Integer idAccertamento, Integer idIspezione2018) throws SvistaException, IOException;
	Documento getDocumentoByUid(String uidIndex) throws SvistaException, IOException;
	String deleteDocumento(String uidIndex) throws SvistaException, IOException;

	Object getTipoDocumento() throws SvistaException, IOException;
	
	Accreditamento getDatiAccreditamento(String codiceFiscalePF) throws SvistaException, IOException;
	String setDatiPersonaliUtente(String codiceFiscalePF, Persona persona) throws SvistaException, IOException;
	List<DatiImpresa> getDatiImpresa(String codiceFiscale, String siglaRea, Integer numeroRea) throws SvistaException, IOException;
	String setDelega(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona) throws SvistaException, IOException;
	String deleteDelega(UtenteLoggato utenteLoggato, Integer idPersona) throws SvistaException, IOException;
	String deleteDelegaConfirm(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona) throws SvistaException, IOException;
	List<IncarichiSoggettiDelegatiResponse> getIncarichiSoggettiDelegati() throws SvistaException, IOException;
	String setIncaricoSoggettoDelegato(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws SvistaException, IOException;
	String deleteIncaricoSoggettoDelegato(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws SvistaException, IOException;
	String sendEmailProva(String emailAddress) throws SvistaException, IOException;
	String setImpresaAssociata(String operation, String codiceFiscalePF, DatiImpresa datiImpresa) throws SvistaException, IOException;
	List<DatiIncarico> getElencoIncarichi(Integer idPersonaGiuridica) throws SvistaException, IOException ;
	List<DatiDelega> getElencoDeleghe(Integer idPersonaGiuridica) throws SvistaException, IOException ;

	List<TipoVerifica> getTipoVerifica() throws SvistaException, IOException;

	DettaglioVerificaModel getVerifica(Integer idVerifica) throws SvistaException, IOException ;

	String setVerifica(Verifica verifica, UtenteLoggatoModel utenteLoggato)  throws SvistaException , IOException ;

	Object getVerifiche(RicercaDatiVerifica ricercaDatiVerifica)  throws SvistaException, IOException ;

	String deleteVerifica(Integer idVerifica)  throws SvistaException , IOException ;

	Object getDistributore(Long idDatoDistrib) throws SvistaException, IOException ;

	Object getControllo(String siglaRee, Long numeroRee) throws SvistaException, IOException ;

	Object getAssegnatario() throws SvistaException, IOException ;

	Object getSiglaRee() throws SvistaException, IOException ;
	
	ResponseGetDettaglioNomina getDettaglioNomina(Integer idContratto, Integer codiceImpianto) throws SvistaException, IOException;
	String deleteAffidamento(String codiceFiscale, Integer idPersonaGiuridica, Integer codiceImpianto, DatiAffidamento datiAffidamento) throws SvistaException, IOException;
	List<Map<Integer, String>> getTipoCessazione() throws SvistaException, IOException;
	List<Map<Integer, String>> getTipoAutodichiarazione() throws SvistaException, IOException;

	Object getAzione(Integer idVerifica, UtenteLoggato utenteLoggato) throws SvistaException , IOException ;

    Object setAzione(DatiAzione datiAzione)  throws SvistaException , IOException ;
	String verifyIndirizzoImpianto(DatiImpianto datiImpianto, Boolean checkContrattoInEssere) throws SvistaException, IOException;
	List<Persona> getElencoStoricoResponsabiliImpianto(String codiceImpianto) throws SvistaException, IOException;
	Esito setSubentroComponente(String codiceImpianto, String idPersonaGiuridica, Boolean sendMail, SubentroComponente subentro) throws JsonProcessingException;
	String setCessazione(RequestTerzoResponsabile requestTerzoResponsabile) throws SvistaException, IOException;
	String setProroga(RequestTerzoResponsabile requestTerzoResponsabile) throws SvistaException, IOException;
	String setSubentrosuImpianto(String codiceFiscale, Integer idPersona, Integer codiceImpianto, String desRuolo, UtenteLoggato utenteLoggato) throws SvistaException, IOException;
	String verifyContrattoTerzoResponsabile(RequestTerzoResponsabile requestVerifyContratto) throws SvistaException, IOException;
	String setNuovoTerzoResp(Integer codiceImpianto, RequestTerzoResponsabile request) throws SvistaException, IOException;

	Impianto[] getImpiantoByCodiceJWT(String codiceImpianto, JWTModel tokenJWT) throws SvistaException, IOException;

	String getDatiTokenImpresa(Integer idPersonaGiuridica) throws SigitExtException, IOException;
	String generateTokenImpresa(Integer idPersonaGiuridica) throws SigitExtException, IOException;

	public Integer getGeoJsonImpiantoMaxResults() throws SigitExtException;
}
