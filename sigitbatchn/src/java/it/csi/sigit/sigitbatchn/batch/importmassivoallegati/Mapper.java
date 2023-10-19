/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch.importmassivoallegati;



import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

import org.apache.commons.lang.StringUtils;

/**
 * Mappatore di classi
 * 
 * @author 71845 - Marco Giacometto
 */
public class Mapper {
	/**
	 * Manager business
	 */
	//private ImportMassivoImpiantiBusinessMgr businessMgr = null;
	/**
	 * Manager dei servizi
	 */
	//private CommonServiziMgr serviziMgr = null;

	/**
	 * Mappa l'identificazione di un impianto nelle informazioni
	 * sull'identificazione
	 * 
	 * @param identificazioneImpianto Identificazione impianto
	 * @param manutentore Manutentore dell'impianto
	 * @return Informazioni sull'identificazione mappate
	 * @throws BusinessMgrException Errore durante il recupero delle
	 *             informazioni del manutentore
	 * @throws ServiceException Errore durante il recupero dell'Id L2 di un
	 *             indirizzo
	 */
//	public IdentificazioneInfo mapToIdentificazioneInfo(IdentificazioneImpianto identificazioneImpianto, SigitTManutentoreDto manutentoreDB)
//			throws BusinessMgrException, ServiceException {
//		IdentificazioneInfo identificazioneInfo = null;
//		//SigitTManutentoreDto manutentoreDto = null;
//		Integer idL2 = null;
//
//		identificazioneInfo = new IdentificazioneInfo();
//		identificazioneInfo.setCodiceImpianto(identificazioneImpianto.getCodiceImpianto().intValue());
//		identificazioneInfo.setDataAssegnazione(ConvertUtil.convertToString(identificazioneImpianto.getDataAssegnazione()));
//		identificazioneInfo.setDataDismissione(ConvertUtil.convertToString(identificazioneImpianto.getDataDismissione()));
//		identificazioneInfo.setDataInstallazione(ConvertUtil.convertToString(identificazioneImpianto.getDataInstallazione()));
//		identificazioneInfo.setIdDestinazione(ConvertUtil.convertToString(identificazioneImpianto.getDestinazioneImpianto()));
//		identificazioneInfo.setIdEvacuazione(ConvertUtil.convertToString(identificazioneImpianto.getEvacuazioneFumi()));
//		identificazioneInfo.setIdFluido(ConvertUtil.convertToString(identificazioneImpianto.getFluido()));
//		identificazioneInfo.setIdLuogo(ConvertUtil.convertToString(identificazioneImpianto.getLuogoImpianto()));
//		identificazioneInfo.setIdPotenza(ConvertUtil.convertToString(identificazioneImpianto.getPotenzaImpianto()));
//		identificazioneInfo.setIdStato(ConvertUtil.convertToString(identificazioneImpianto.getStatoImpianto()));
//		identificazioneInfo.setIdTipologia(ConvertUtil.convertToString(identificazioneImpianto.getTipologiaImpianto()));
//		identificazioneInfo.setIndirizzo(identificazioneImpianto.getIndirizzo());
//		identificazioneInfo.setNote(identificazioneImpianto.getNote());
//		
//		identificazioneInfo.setCodiceFiscale(manutentoreDB.getCodiceFiscale());
//		identificazioneInfo.setNumeroRea(ConvertUtil.convertToString(manutentoreDB.getNumeroRea()));
//		identificazioneInfo.setSiglaRea(manutentoreDB.getSiglaRea());
//		identificazioneInfo.setDitta(manutentoreDB.getDenominazione());
//		identificazioneInfo.setIdManutentore(ConvertUtil.convertToString(manutentoreDB.getIdManutentore()));
//		// Impostazione dell'indirizzo
//		//idL2 = businessMgr.cercaIdL2(identificazioneImpianto.getIndirizzo(), identificazioneImpianto.getIstatComune());
//		identificazioneInfo.setCivico(identificazioneImpianto.getCivico());
//		identificazioneInfo.setIdComune(identificazioneImpianto.getIstatComune());
//		if(idL2 != null) {
//			identificazioneInfo.setIdIndirizzo(ConvertUtil.convertToString(idL2));
//			identificazioneInfo.setDsIndirizzo(identificazioneImpianto.getIndirizzo());
//			identificazioneInfo.setIndirizzoNonTrovato(null);
//		}
//		else {
//			identificazioneInfo.setIdIndirizzo(null);
//			identificazioneInfo.setDsIndirizzo(null);
//			identificazioneInfo.setIndirizzoNonTrovato(identificazioneImpianto.getIndirizzo());
//		}
//		return identificazioneInfo;
//	}

	/**
	 * Mappa le informazioni su manutentore ed impianto nelle inforazioni sul
	 * subentro
	 * 
	 * @param manutentoreDto Informazioni sul manutentore
	 * @param impiantoDto Informazioni sull'impianto
	 * @return Informazioni sul subentro mappate
	 * @throws BusinessMgrException Errore durante il recupero dei dati
	 */
//	public SubentroInfo mapToSubentroInfo(BigInteger codiceImpianto, String siglaRea, String numeroRea) throws NumberFormatException,
//			BusinessMgrException {
//		SubentroInfo subentroInfo = null;
//		SigitTManutentoreDto manutentoreDto = null;
//		SigitTImpiantoDto impiantoDto = null;
//
//		subentroInfo = new SubentroInfo();
//		impiantoDto = businessMgr.cercaImpianto(codiceImpianto.intValue());
//		manutentoreDto = businessMgr.cercaManutentore(siglaRea, new Integer(numeroRea));
//		subentroInfo.setIdManutentore(manutentoreDto.getIdManutentore());
//		subentroInfo.setIdImpianto(impiantoDto.getIdImpianto());
//		return subentroInfo;
//	}

	/**
	 * Mappa un'apparecchiatura nelle inforazioni sull'apparecchiatura
	 * 
	 * @param apparecchiatura Apparecchiatura
	 * @return Informazioni sull'apparecchiatura mappate
	 */
//	public ApparecchiatureInfo mapToApparecchiaturaInfo(Apparecchiatura apparecchiatura) {
//		ApparecchiatureInfo apparecchiatureInfo = null;
//
//		apparecchiatureInfo = new ApparecchiatureInfo();
//		apparecchiatureInfo.setAnnoDiCostruzione(apparecchiatura.getAnnoCostruzione());
//		apparecchiatureInfo.setAnnoDiCostruzioneStringa(ConvertUtil.convertToString(apparecchiatura.getAnnoCostruzione()));
//		apparecchiatureInfo.setCampoDiFunzionamentoA(apparecchiatura.getCampoFunzionamentoA());
//		apparecchiatureInfo.setCampoDiFunzionamentoDa(apparecchiatura.getCampoFunzionamentoDa());
//		apparecchiatureInfo.setDataDismissione(ConvertUtil.convertToString(apparecchiatura.getDataDismissione()));
//		apparecchiatureInfo.setDataInstallazione(ConvertUtil.convertToString(apparecchiatura.getDataInstallazione()));
//		apparecchiatureInfo.setIdCombustibile(ConvertUtil.convertToInteger(apparecchiatura.getCombustibile()));
//		apparecchiatureInfo.setIdLocaleInstallazione(ConvertUtil.convertToString(apparecchiatura.getLocaleInstallazione()));
//		apparecchiatureInfo.setIdMarca(ConvertUtil.convertToInteger(apparecchiatura.getMarca()));
//		apparecchiatureInfo.setIdMarcaturaEnergetica(ConvertUtil.convertToInteger(apparecchiatura.getMarcaEnergetica()));
//		apparecchiatureInfo.setIdTipo(ConvertUtil.convertToInteger(apparecchiatura.getTipo()));
//		apparecchiatureInfo.setIdTipoApparecchiatura(ConvertUtil.convertToInteger(apparecchiatura.getTipoApparecchiatura()));
//		apparecchiatureInfo.setIdTipoBruciatore(ConvertUtil.convertToInteger(apparecchiatura.getTipoBruciatore()));
//		apparecchiatureInfo.setIdTipoInstallazione(ConvertUtil.convertToInteger(apparecchiatura.getTipoInstallazione()));
//		apparecchiatureInfo.setIdTiraggio(ConvertUtil.convertToInteger(apparecchiatura.getTiraggio()));
//		apparecchiatureInfo.setMarcaModello(apparecchiatura.getModello());
//		apparecchiatureInfo.setNote(apparecchiatura.getNote());
//		apparecchiatureInfo.setMatricola(apparecchiatura.getMatricola());
//		apparecchiatureInfo.setModello(apparecchiatura.getModello());
//		apparecchiatureInfo.setNumeroApparecchiatura(apparecchiatura.getNumeroApparecchiatura());
//		apparecchiatureInfo.setPotenzaTermicaNominaleFocolare(apparecchiatura.getPotenzaTermicaNominaleFocolare());
//		apparecchiatureInfo.setPotenzaTermicaNominaleUtile(apparecchiatura.getPotenzaTermicaNominaleUtile());
//		apparecchiatureInfo.setIdAbbinato(apparecchiatura.getAbbinataA());
//		return apparecchiatureInfo;
//	}

	/**
	 * Mappa un altro edificio nelle informazioni su un altro edificio
	 * 
	 * @param altriEdifici Altro edificio da mappare
	 * @param identificazioneInfo Informazioni sull'identificazione
	 * @param principale Flag per indicare se l'indirizzo è il principale
	 * @return Informazioni sull'altro edificio
	 */
//	public AltriEdificiInfo mapToAltriEdificiInfo(AltriEdifici altriEdifici, IdentificazioneInfo identificazioneInfo) {
//		return mapToAltriEdificiInfo(altriEdifici, identificazioneInfo, false);
//	}

	/**
	 * Mappa un altro edificio nelle informazioni su un altro edificio
	 * 
	 * @param altriEdifici Altro edificio da mappare
	 * @param identificazioneInfo Informazioni sull'identificazione
	 * @param principale Flag per indicare se l'indirizzo è il principale
	 * @return Informazioni sull'altro edificio
	 */
//	public AltriEdificiInfo mapToAltriEdificiInfo(AltriEdifici altriEdifici, IdentificazioneInfo identificazioneInfo, boolean principale) {
//		AltriEdificiInfo altriEdificiInfo = null;
//		Integer idL2 = null;
//
//		altriEdificiInfo = new AltriEdificiInfo();
//		//idL2 = businessMgr.cercaIdL2(altriEdifici.getIndirizzo(), identificazioneInfo.getIdComune());
//		if(idL2 != null) {
//			altriEdificiInfo.setIdL2(idL2);
//			altriEdificiInfo.setIndirizzoNonTrovato(null);
//			altriEdificiInfo.setIndirizzo(altriEdifici.getIndirizzo());
//		}
//		else {
//			altriEdificiInfo.setIdL2(null);
//			altriEdificiInfo.setIndirizzoNonTrovato(altriEdifici.getIndirizzo());
//			altriEdificiInfo.setIndirizzo(null);
//		}
//		altriEdificiInfo.setCivico(altriEdifici.getIndirizzo());
//		altriEdificiInfo.setCodiceIstatComune(identificazioneInfo.getIdComune());
//		altriEdificiInfo.setPrincipale(principale);
//		return altriEdificiInfo;
//	}

	/**
	 * Mappa un'apparecchiatura impianto nelle informazioni di apparecchiatura
	 * impianto
	 * 
	 * @param allegato Apparecchiature impianto
	 * @return Informazioni di apparecchiature impianto mappate
	 */
//	public AllegatoInfo mapToAllegatoInfo(AllegatoF allegato, Pagina pagina) {
//		AllegatoInfo allegatoInfo = null;
//
//		allegatoInfo = new AllegatoInfo();
//		allegatoInfo.setBollinoVerde(ConvertUtil.convertToString(allegato.getNumeroBollino()));
//		allegatoInfo.setDataControllo(new Date(allegato.getDataRapporto().getTimeInMillis()));
//		allegatoInfo.setDataControlloStringa(ConvertUtil.convertToString(allegato.getDataRapporto()));
//		allegatoInfo.setId(0);
//		allegatoInfo.setIdSiglaBollinoVerdeAllegato(allegato.getSiglaBollino());
//		allegatoInfo.setNote(pagina.getNoteDocumentazione());
//		allegatoInfo.setNoteBollinoVerdeAllegato(pagina.getNoteDocumentazione());
//		allegatoInfo.setOsservazioni(allegato.getOsservazioni());
//		allegatoInfo.setPrescrizioni(pagina.getPrescrizioni());
//		allegatoInfo.setRaccomandazioni(pagina.getRaccomandazioni());
//		allegatoInfo.setSiglaBollinoVerde(allegato.getSiglaBollino());
//		allegatoInfo.setStato("1"); // Inviato
//		return allegatoInfo;
//	}

	/**
	 * Mappa un reponsabile nelle informazioni di responsabile
	 * 
	 * @param responsabile Responsabile
	 * @return Informazioni di responsabile mappate
	 */
//	public ResponsabiliInfo mapToResponsabiliInfo(Responsabile responsabile) {
//		ResponsabiliInfo responsabiliInfo = null;
//		Integer idL2 = null;
//
//		responsabiliInfo = new ResponsabiliInfo();
//		responsabiliInfo.setCivico(responsabile.getCivicoRes());
//		responsabiliInfo.setCodiceFiscaleResponsabile(responsabile.getCodiceFiscaleRes());
//		responsabiliInfo.setDataInizioResponsabilita(ConvertUtil.convertToDate(responsabile.getDataInizioRes()));
//		responsabiliInfo.setDataInizioResponsabilitaStringa(ConvertUtil.convertToString(responsabile.getDataInizioRes()));
//		responsabiliInfo.setDataFineResponsabilita(ConvertUtil.convertToDate(responsabile.getDataFineRes()));
//		responsabiliInfo.setDataFineResponsabilitaStringa(ConvertUtil.convertToString(responsabile.getDataFineRes()));
//		responsabiliInfo.setDenominazione(responsabile.getDenominazioneRes());
//		responsabiliInfo.setIdComune(responsabile.getIstatComuneRes());
//		responsabiliInfo.setIdTitolo(ConvertUtil.convertToInteger(responsabile.getTitoloRes()));
//		responsabiliInfo.setEmail(responsabile.getEmailRes());
//		responsabiliInfo.setNote(null);
//
//		if(idL2 != null) {
//			responsabiliInfo.setIdIndirizzo(idL2);
//			responsabiliInfo.setIndirizzoNonTrovato(null);
//		}
//		else {
//			responsabiliInfo.setIdIndirizzo(null);
//			responsabiliInfo.setIndirizzoNonTrovato(responsabile.getIndirizzoRes());
//		}
//		
//		return responsabiliInfo;
//	}

	/**
	 * Restituisce il manager business
	 * 
	 * @return Manager business
	 */
//	public ImportMassivoImpiantiBusinessMgr getBusinessMgr() {
//		return businessMgr;
//	}

	/**
	 * Imposta il manager business
	 * 
	 * @param businessMgr Manager business
	 */
//	public void setBusinessMgr(ImportMassivoImpiantiBusinessMgr businessMgr) {
//		this.businessMgr = businessMgr;
//	}

	/**
	 * Restituisce il manager dei servizi
	 * 
	 * @return Manager dei servizi
	 */
//	public CommonServiziMgr getServiziMgr() {
//		return serviziMgr;
//	}

	/**
	 * Imposta il manager dei servizi
	 * 
	 * @param serviziMgr Manager dei servizi
	 */
//	public void setServiziMgr(CommonServiziMgr serviziMgr) {
//		this.serviziMgr = serviziMgr;
//	}
}
