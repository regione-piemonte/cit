/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ContrattoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaAvanzataImpiantoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaIspezioniFilter;

import java.math.BigDecimal;
import java.util.*;

/**
 * Interfaccia pubblica del DAO non rpesente sul DB.
 * @generated
 */
public interface SigitExtDao {

	public String findIndirizzoMailAbilitazioneByExample (String ruolo, String istat, BigDecimal idPersonaFisica) throws SigitExtDaoException;

	/** 
	 * Implementazione del finder responsabiliByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitExtRespImpDto> findResponsabiliByCodiceImpianto(java.lang.Integer input)
			throws SigitExtDaoException;

	@SuppressWarnings("unchecked")
	public SigitExtRespImpDto findResponsabileAttivoByCodiceImpianto(java.lang.Integer input)
			throws SigitExtDaoException;
	
//	public List<SigitExtImpiantoDto> findImpiantiByFilter(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoFilter input)
//			throws SigitExtDaoException;
//	
	public BigDecimal getSeqTNumeroBollino() throws SigitExtDaoException;
	
	public BigDecimal getSeqTImportDistrib() throws SigitExtDaoException;

	public BigDecimal getSeqTCodiceImpianto() throws SigitExtDaoException;

	//public List<SigitExtContrattoImpDto> findStoriaContrattiImpianto(ContrattoFilter input) throws SigitExtDaoException;

	public List<SigitExtContrattoImpDto> findStoriaContrattiImpiantoNew(ContrattoFilter input) throws SigitExtDaoException;
	
	public Integer findByFiltriUtenteCount(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaAllegati input)
			throws SigitExtDaoException;
	
	public Integer findByTransazioneImpFilterCount(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TransazioneFilter input)
			throws SigitExtDaoException;
	
	public Integer findByTransazioneBollFilterCount(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TransazioneFilter input)
			throws SigitExtDaoException;
	
	@SuppressWarnings("unchecked")
	public Integer findCodImpiantoUtilizzatiByIdTransCount(
			java.lang.Integer input) throws SigitExtDaoException;
	
	@SuppressWarnings("unchecked")
	public Integer findImpiantiByFilterCount(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoFilter input)
			throws SigitExtDaoException;
	
	@SuppressWarnings("unchecked")
	public Integer findManutentoriByFilterCount(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitExtDaoException;
	
	@SuppressWarnings("unchecked")
	public List<SigitExtComponenteDto> findComponentiByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitExtDaoException;
	
	@SuppressWarnings("unchecked")
	public List<SigitExtComponenteDto> findComponentiByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input, String nomeTabellaComp)
			throws SigitExtDaoException;
	
	@SuppressWarnings("unchecked")
	public List<SigitExtComponenteDto> findComponentiSubentroByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input, String nomeTabellaComp)
			throws SigitExtDaoException;

//	@SuppressWarnings("unchecked")
//	public List<SigitExtDocAggiuntivaByCodImpiantoDto> findDocumentazioneByCodiceImpianto(java.lang.Integer input, boolean isIspezione)
//			throws SigitExtDaoException;
	
	@SuppressWarnings("unchecked")
	public Integer findRapportiInviatiCatCount(
			Integer input)
			throws SigitExtDaoException;
	
	@SuppressWarnings("unchecked")
	public List<SigitExtVerificaDto> findVerificaById(SigitTVerificaPk id) throws SigitExtDaoException;
	
	@SuppressWarnings("unchecked")
	public List<SigitExtIspezione2018Dto> findIspezioni2018ByFilter(RicercaIspezioniFilter filter) throws SigitExtDaoException;
	
	@SuppressWarnings("unchecked")
	public BigDecimal getNextIdByTable (String tableName, String idColumnName) throws SigitExtDaoException;

	@SuppressWarnings("unchecked")
	public Integer findLogDaStoricizzareCount() throws SigitExtDaoException;
	@SuppressWarnings("unchecked")
	public Integer findLogDaCancellareCount() throws SigitExtDaoException;
	@SuppressWarnings("unchecked")
	public Integer findLibrettiDaStoricizzareCount() throws SigitExtDaoException;
	@SuppressWarnings("unchecked")
	public Integer findLibrettiDaCancellareCount() throws SigitExtDaoException;
	@SuppressWarnings("unchecked")
	public Integer findLogAccessoDaStoricizzareCount() throws SigitExtDaoException;
	@SuppressWarnings("unchecked")
	public Integer findLogAccessoDaCancellareCount() throws SigitExtDaoException;
	@SuppressWarnings("unchecked")
	public Integer findImpiantiSenzaCoordinateCount() throws SigitExtDaoException;
	@SuppressWarnings("unchecked")
	public Integer findImpiantiAggiornatiADataCount(String date) throws SigitExtDaoException;
	@SuppressWarnings("unchecked")
	public List<SigitExtIspezioniDto> findIspezioniDettByListIdIspez(ArrayList<String> listIdIspezioni)
			throws SigitExtDaoException;
			
	@SuppressWarnings("unchecked")
	public List<SigitExtIspezioniConCodImpiantoDto> findIspezioniDettConCodImpiantoByListConImpianti(ArrayList<String> listCodImpianti)
			throws SigitExtDaoException;

	@SuppressWarnings("unchecked")
	public List<SigitExtIspezioniSenzaCodImpiantoDto> findIspezioniDettSenzaCodImpiantoByListIdIspez(ArrayList<String> listIdIspezioni)
			throws SigitExtDaoException;
			
	//@SuppressWarnings("unchecked")
	//public Integer storicizzaLog() throws SigitExtDaoException;
	
	public BigDecimal getSeqTCodiceImpiantoMax() throws SigitExtDaoException;

	public BigDecimal getSeqTGraffatura() throws SigitExtDaoException;

	public SigitTGraffaturaPk insertGraffaturaWithId(SigitTGraffaturaDto dto);

	public SigitTGraffaturaPk insertGraffaturaAutoIncrement(SigitTGraffaturaDto dto) throws SigitExtDaoException;
}
