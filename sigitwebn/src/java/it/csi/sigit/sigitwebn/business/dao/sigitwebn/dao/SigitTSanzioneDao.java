package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import it.csi.sigit.sigitwebn.business.dao.util.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO sigitTSanzione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTSanzioneDao {

	/**
	 * Metodo di inserimento del DAO sigitTSanzione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTSanzionePk
	 * @generated
	 */

	public SigitTSanzionePk insert(SigitTSanzioneDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_SANZIONE table.
	 * @generated
	 */
	public void update(SigitTSanzioneDto dto) throws SigitTSanzioneDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_SANZIONE table.
	 * @generated
	 */
	public void updateColumnsNote(SigitTSanzioneDto dto) throws SigitTSanzioneDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_SANZIONE table.
	 * @generated
	 */
	public void updateColumnsPerPagamento(SigitTSanzioneDto dto) throws SigitTSanzioneDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_SANZIONE table.
	 * @generated
	 */
	public void updateColumnsPerAssegnazione(SigitTSanzioneDto dto) throws SigitTSanzioneDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_SANZIONE table.
	 * @generated
	 */
	public void updateColumnsPerAnnullamento(SigitTSanzioneDto dto) throws SigitTSanzioneDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_SANZIONE table.
	 * @generated
	 */
	public void updateColumnsInfoSveglia(SigitTSanzioneDto dto) throws SigitTSanzioneDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_SANZIONE table.
	 * @generated
	 */

	public void delete(SigitTSanzionePk pk) throws SigitTSanzioneDaoException;

	/** 
	 * Implementazione del finder validaByIdAccertamento
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTSanzioneDto> findValidaByIdAccertamento(java.lang.Integer input)
			throws SigitTSanzioneDaoException;

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTSanzioneDto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTSanzioneDto input)
			throws SigitTSanzioneDaoException;

	/** 
	 * Implementazione del finder sveglieAttiveByCF
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTSanzioneDto> findSveglieAttiveByCF(java.lang.String input) throws SigitTSanzioneDaoException;

	/** 
	 * Implementazione del finder validaByIdIspezione
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTSanzioneDto> findValidaByIdIspezione(java.lang.Integer input) throws SigitTSanzioneDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_SANZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTSanzioneDto findByPrimaryKey(SigitTSanzionePk pk) throws SigitTSanzioneDaoException;

	/** 
	 * Implementazione del finder byRicerca
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTSanzioneDto> findByRicerca(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaSanzioniFilter input)
			throws SigitTSanzioneDaoException;

}
