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
 * Interfaccia pubblica del DAO sigitTPersonaGiuridica.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTPersonaGiuridicaDao {

	/**
	 * Metodo di inserimento del DAO sigitTPersonaGiuridica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTPersonaGiuridicaPk
	 * @generated
	 */

	public SigitTPersonaGiuridicaPk insert(SigitTPersonaGiuridicaDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_PERSONA_GIURIDICA table.
	 * @generated
	 */
	public void update(SigitTPersonaGiuridicaDto dto) throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_PERSONA_GIURIDICA table.
	 * @generated
	 */

	public void delete(SigitTPersonaGiuridicaPk pk) throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_PERSONA_GIURIDICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTPersonaGiuridicaDto findByPrimaryKey(SigitTPersonaGiuridicaPk pk)
			throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_PERSONA_GIURIDICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findAll() throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Implementazione del finder byCodiceRea
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByCodiceRea(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleFilter input)
			throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Implementazione del finder byCodiceFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByCodiceFiscale(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleFilter input)
			throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Implementazione del finder byCodiceReaAndFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByCodiceReaAndFiscale(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleFilter input)
			throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByCodiceImpianto(java.lang.Integer input)
			throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Implementazione del finder acquisitoCodImpByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findAcquisitoCodImpByCodiceImpianto(java.lang.Integer input)
			throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Implementazione del finder catValidi
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findCatValidi(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto input)
			throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Implementazione del finder cat
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findCat(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto input)
			throws SigitTPersonaGiuridicaDaoException;

	/** 
		 * Implementazione del finder byParam con Qdef
		 * @generated
		 */

	public List<SigitTPersonaGiuridicaByParamDto> findByParam(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto input)
			throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Implementazione del finder incarichiCatAttivi
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findIncarichiCatAttivi(java.lang.Integer input)
			throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaPersonaGiuridicaFisicaFilter input)
			throws SigitTPersonaGiuridicaDaoException;

}
