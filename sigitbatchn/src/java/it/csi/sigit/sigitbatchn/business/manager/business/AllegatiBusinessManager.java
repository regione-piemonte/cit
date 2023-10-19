/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.manager.business;

//import it.csi.modol.modolsrv.dto.Applicazione;
//import it.csi.modol.modolsrv.dto.Utente;
//import it.csi.modol.modolsrv.dto.XmlModel;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitRImpManutDto;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitTImpiantoExtDto;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitTManutentoreDto;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitTRappControlloDto;
//import it.csi.sigit.common.dto.index.Metadati;
//import it.csi.sigit.common.manager.db.DbManagerException;
//import it.csi.sigit.common.manager.servizi.CommonServiziMgr;
//import it.csi.sigit.common.manager.servizi.ServiceException;
//import it.csi.sigit.common.util.ConvertUtil;
//import it.csi.sigit.common.util.CostantiApplicative;
//import it.csi.sigit.common.util.DateUtil;
//import it.csi.sigit.common.util.MapDto;
//import it.csi.sigit.common.util.XmlBeanUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public abstract class AllegatiBusinessManager { // extends AbstractBusinessMgr {
	/**
	 * Nome della classe
	 */
	final static String CLASS_NAME = AllegatiBusinessManager.class.getSimpleName();
	/**
	 * Valore per il read only di un allegato
	 */
	private static final String READ_ONLY = "false";
	/**
	 * Gestore dei servizi
	 */
	//protected CommonServiziMgr serviziMgr = null;

	/**
	 * Restituisce la decodifica del luogo dell'impianto
	 * 
	 * @param id Id da decodificare
	 * @return Decodifica
	 */
//	public String decodificaLuogoImpianto(BigInteger id) {
//		return id == null ? null : dbMgr.decodificaLuogoImpianto(id);
//	}
//
//	/**
//	 * Restituisce la decodifica del luogo dell'impianto
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaLuogoImpianto(Integer id) {
//		return id == null ? null : dbMgr.decodificaLuogoImpianto(id);
//	}
//
//	/**
//	 * Restituisce la decodifica della destinazione dell'impianto
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaDestinazione(BigInteger id) {
//		return id == null ? null : dbMgr.decodificaDestinazione(id);
//	}
//
//	/**
//	 * Restituisce la decodifica della destinazione dell'impianto
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaDestinazione(Integer id) {
//		return id == null ? null : dbMgr.decodificaDestinazione(id);
//	}
//
//	/**
//	 * Restituisce la decodifica del fluido
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaFluido(BigInteger id) {
//		return id == null ? null : dbMgr.decodificaFluido(id);
//	}
//
//	/**
//	 * Restituisce la decodifica del fluido
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaFluido(Integer id) {
//		return id == null ? null : dbMgr.decodificaFluido(id);
//	}
//
//	/**
//	 * Restituisce la decodifica del tipo di apparecchiatura
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaTipoApparecchitura(BigInteger id) {
//		return id == null ? null : dbMgr.decodificaTipoApparecchitura(id);
//	}
//
//	/**
//	 * Restituisce la decodifica del tipo di apparecchiatura
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaTipoApparecchitura(Integer id) {
//		return id == null ? null : dbMgr.decodificaTipoApparecchitura(id);
//	}
//
//	/**
//	 * Restituisce la decodifica della marca dell'apparecchiatura
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaMarcaApparecchiatura(BigInteger id) {
//		return id == null ? null : dbMgr.decodificaMarcaApparecchiatura(id);
//	}
//
//	/**
//	 * Restituisce la decodifica della marca dell'apparecchiatura
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaMarcaApparecchiatura(Integer id) {
//		return id == null ? null : dbMgr.decodificaMarcaApparecchiatura(id);
//	}
//
//	/**
//	 * Restituisce la decodifica del tipo
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaTipo(BigInteger id) {
//		return id == null ? null : dbMgr.decodificaTipo(id);
//	}
//
//	/**
//	 * Restituisce la decodifica del tipo
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaTipo(Integer id) {
//		return id == null ? null : dbMgr.decodificaTipo(id);
//	}
//
//	/**
//	 * Restituisce la decodifica del tiraggio
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaTiraggio(BigInteger id) {
//		return id == null ? null : dbMgr.decodificaTiraggio(id);
//	}
//
//	/**
//	 * Restituisce la decodifica del tiraggio
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaTiraggio(Integer id) {
//		return id == null ? null : dbMgr.decodificaTiraggio(id);
//	}
//
//	/**
//	 * Restituisce la decodifica del combustibile
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaCombustibile(BigInteger id) {
//		return id == null ? null : dbMgr.decodificaCombustibile(id);
//	}
//
//	/**
//	 * Restituisce la decodifica del combustibile
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaCombustibile(Integer id) {
//		return id == null ? null : dbMgr.decodificaCombustibile(id);
//	}
//
//	/**
//	 * Restituisce la decodifica de
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaPotenzaImpianto(BigInteger id) {
//		return id == null ? null : dbMgr.decodificaPotenzaImpianto(id);
//	}
//
//	/**
//	 * Restituisce la decodifica de
//	 * 
//	 * @param id Id da decodificare
//	 * @return Decodifica
//	 */
//	public String decodificaPotenzaImpianto(Integer id) {
//		return id == null ? null : dbMgr.decodificaPotenzaImpianto(id);
//	}
//
//	/**
//	 * Conta le apparecchiature da inserire in un allegato per un impianto
//	 * 
//	 * @param idImpianto Id dell'impianto
//	 * @return Numero di apparecchiature
//	 */
//	public Integer contaApparecchiature(BigInteger idImpianto) {
//		return dbMgr.contaApparecchiature(idImpianto);
//	}

	/**
	 * Restituisce il nome della provincia data la sigla
	 * 
	 * @param siglaProvincia Sigla della provincia
	 * @return Nome della provincia, null se non trovato
	 */
//	public String getNomeProvincia(String siglaProvincia) {
//		final String METHOD_NAME = "getNomeProvincia";
//		String nomeProvincia = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			nomeProvincia = serviziMgr.getDsProvinciaBySigla(siglaProvincia);
//		}
//		catch(ServiceException e) {
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//		return nomeProvincia;
//	}

	
	/**
	 * Invia un allegato F su Index
	 * 
	 * @param allegatoF Allegato F da inviare
	 * @param idRapportoControllo Id del rapporto di controllo
	 * @throws BusinessMgrException Errore durante l'invio dell'allegato
	 */
//	public void inviaAllegato(AllegatoFDocument allegatoF, Integer idRapportoControllo)
//			throws BusinessMgrException {
//		final String METHOD_NAME = "inviaAllegato";
//		SigitTRappControlloDto rapportoControlloDto = null;
//		SigitTImpiantoExtDto impiantoDto = null;
//		String nomeAllegato = null;
//		Applicazione app = null;
//		Utente utente = null;
//		XmlModel model = null;
//		//List<Corpo> listaCorpi = null;
//		byte[] datiXml = null;
//		byte[] moduloPdf = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			// 1. Recupero del Rapporto di Controllo
//			rapportoControlloDto = dbMgr.cercaRapportoControllo(idRapportoControllo);
//			// 2.1 Recupero l'id impianto
//			SigitRImpManutDto impManut = dbMgr.getImpManutByPrimaryKey(rapportoControlloDto.getFkImpManut());
//			// 2.2 Recupero dell'impianto
//			impiantoDto = dbMgr.getInfoImpianto(impManut.getIdImpianto());
//			nomeAllegato = getNomeAllegato(rapportoControlloDto, impiantoDto);
//			loggerHelper.debug(CLASS_NAME, METHOD_NAME, "Nome dell'allegato " + nomeAllegato);
//			aggiornaRapportoControllo(rapportoControlloDto, nomeAllegato);
//			// 6. Set "read only" dell'allegato
//			/*
//			listaCorpi = allegatoF.getCorpoList();
//			
//			for(Corpo corpo : listaCorpi) {
//				System.out.println("Stampo il valore - corpo.getOsservazioni(): "+corpo.getOsservazioni());
//				corpo.setRead(READ_ONLY);
//			}
//			*/
//			
//			// 7. Conversione in byte[]
//			datiXml = XmlBeanUtils.extractByteArray(allegatoF);
//			// 8. Renderizzazione PDF
//			model = new XmlModel();
//			model.setXmlContent(datiXml);
//			app = new Applicazione();
//			app.setCodiceApplicazione(CostantiApplicative.CODICE_APPLICAZIONE_MODOL);
//			moduloPdf = serviziMgr.showModuloF(app, utente, model);
//			uploadAllegato(moduloPdf, rapportoControlloDto, impiantoDto);
//		}
//		catch(IOException e) {
//			throw new BusinessMgrException(e);
//		}
//		catch(ServiceException e) {
//			throw new BusinessMgrException(e);
//		}
//		catch(DbManagerException e) {
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//	}

	/**
	 * Invia un allegato G su Index
	 * 
	 * @param allegatoG Allegato G da inviare
	 * @param idRapportoControllo Id del rapporto di controllo
	 * @throws BusinessMgrException Errore durante l'invio dell'allegato
	 */
//	public void inviaAllegato(AllegatoGDocument.AllegatoG allegatoG, Integer idRapportoControllo)
//			throws BusinessMgrException {
//		final String METHOD_NAME = "inviaAllegato";
//		SigitTRappControlloDto rapportoControlloDto = null;
//		SigitTImpiantoExtDto impiantoDto = null;
//		String nomeAllegato = null;
//		Applicazione app = null;
//		Utente utente = null;
//		XmlModel model = null;
//		byte[] datiXml = null;
//		byte[] moduloPdf = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			// 1. Recupero del Rapporto di Controllo
//			rapportoControlloDto = dbMgr.cercaRapportoControllo(idRapportoControllo);
//			
//			// 2.1 Recupero l'id impianto
//			SigitRImpManutDto impManut = dbMgr.getImpManutByPrimaryKey(rapportoControlloDto.getFkImpManut());
//			// 2.2 Recupero dell'impianto
//			impiantoDto = dbMgr.getInfoImpianto(impManut.getIdImpianto());
//			nomeAllegato = getNomeAllegato(rapportoControlloDto, impiantoDto);
//			loggerHelper.debug(CLASS_NAME, METHOD_NAME, "Nome dell'allegato " + nomeAllegato);
//			aggiornaRapportoControllo(rapportoControlloDto, nomeAllegato);
//			// 6. Set "read only" dell'allegato
//			allegatoG.setRead(READ_ONLY);
//			// 7. Conversione in byte[] XML
//			datiXml = XmlBeanUtils.extractByteArray(allegatoG);
//			// 8. Renderizzazione PDF
//			model = new XmlModel();
//			model.setXmlContent(datiXml);
//			app = new Applicazione();
//			app.setCodiceApplicazione(CostantiApplicative.CODICE_APPLICAZIONE_MODOL);
//			moduloPdf = serviziMgr.showModuloG(app, utente, model);
//			uploadAllegato(moduloPdf, rapportoControlloDto, impiantoDto);
//		}
//		catch(IOException e) {
//			throw new BusinessMgrException(e);
//		}
//		catch(ServiceException e) {
//			throw new BusinessMgrException(e);
//		}
//		catch(DbManagerException e) {
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//	}

	/**
	 * Restituisce il nome dell'allegato
	 * 
	 * @param rapportoControlloDto DTO del rapporto di controllo
	 * @param impiantoDto DTO dell'impianto
	 * @return Nome dell'allegato
	 */
//	private String getNomeAllegato(SigitTRappControlloDto rapportoControlloDto, SigitTImpiantoExtDto impiantoDto) {
//		StringBuilder nomeAllegato = null;
//
//		nomeAllegato = new StringBuilder();
//		nomeAllegato.append(impiantoDto.getModello());
//		nomeAllegato.append("_");
//		nomeAllegato.append(impiantoDto.getCodiceImpianto());
//		nomeAllegato.append("_");
//		nomeAllegato.append(ConvertUtil.convertToString(rapportoControlloDto.getDataRapporto(), ConvertUtil.FORMAT_DATE_UNDERSCORE));
//		nomeAllegato.append("_");
//		nomeAllegato.append(rapportoControlloDto.getIdRapportoControllo());
//		nomeAllegato.append(".pdf");
//		return nomeAllegato.toString();
//	}

	/**
	 * Inizializza l'invio di un allegato
	 * 
	 * @param rapportoControlloDto DTO del rapporto di controllo
	 * @param impiantoDto DTO dell'impianto
	 * @return Metadati associati all'allegato
	 * @throws DbManagerException Errore durante l'inizializzazione dell'invio
	 *             dell'allegato
	 */
//	private void uploadAllegato(byte[] thePdf, SigitTRappControlloDto rapportoControlloDto, SigitTImpiantoExtDto impiantoDto)
//			throws BusinessMgrException {
//		final String METHOD_NAME = "uploadAllegato";
//		SigitTManutentoreDto manutentore = null;
//		Metadati metadati = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		// 8. Recupero dei metadati
//		loggerHelper.debug(CLASS_NAME, METHOD_NAME, "Recupero dei metadati");
//		try {
//			// Recupero l'id manutentore
//			SigitRImpManutDto impManut = dbMgr.getImpManutByPrimaryKey(rapportoControlloDto.getFkImpManut());
//			
//			manutentore = dbMgr.cercaManutentoreByPk(impManut.getIdManutentore());
//			metadati = MapDto.mapToMetadati(rapportoControlloDto, impiantoDto, manutentore);
//			// 9. Upload del file su INDEX
//			serviziMgr.indexUploadFile(rapportoControlloDto.getNomeAllegato(), thePdf, metadati);
//			// getServiziMgr().indexUploadFile(nome.toString(), file, metadati);
//			// getServiziMgr().indexUploadFile("test.pdf", file, metadati);
//		}
//		catch(DbManagerException e) {
//			throw new BusinessMgrException(e);
//		}
//		catch(ServiceException e) {
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//	}

	/**
	 * Aggiorna il rapporto di controllo
	 * 
	 * @param rapportoControlloDto DTO da aggiornare
	 * @param nomeAllegato Nome dell'allegato
	 * @throws DbManagerException Errore durante l'aggiornamento dei dati
	 */
//	private void aggiornaRapportoControllo(SigitTRappControlloDto rapportoControlloDto, String nomeAllegato) throws BusinessMgrException {
//		final String METHOD_NAME = "aggiornaRapportoControllo";
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		// 3. Modifica della data di invio, stato e nome allegato
//		loggerHelper.debug(CLASS_NAME, METHOD_NAME, "Aggiornamento dei dati dell'allegato");
//		rapportoControlloDto.setDataInvio(DateUtil.getSqlDataCorrente());
//		rapportoControlloDto.setFkStatoRapp(CostantiApplicative.STATO_RAPPORTO_INVIATO);
//		rapportoControlloDto.setNomeAllegato(nomeAllegato);
//		try {
//			dbMgr.modificaRapportoControllo(rapportoControlloDto);
//		}
//		catch(DbManagerException e) {
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//	}

	/**
	 * Imposta il gestore dei servizi
	 * 
	 * @param serviziMgr Gestore dei servizi
	 */
//	public void setServiziMgr(CommonServiziMgr serviziMgr) {
//		this.serviziMgr = serviziMgr;
//	}
//
//	/**
//	 * Restituisce il gestore dei servizi
//	 * 
//	 * @return Gestore dei servizi
//	 */
//	public CommonServiziMgr getServiziMgr() {
//		return serviziMgr;
//	}

	/**
	 * Restituisce l'array di byte che rappresenta il logo della provincia
	 * 
	 * @param sigla Sigla della provincia
	 * @return Il logo della provincia sotto forma di array di byte
	 */
//	public byte[] getLogoProvincia(String sigla) {
//		return dbMgr.getLogoProvincia(sigla);
//	}

}
