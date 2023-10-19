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
 * Interfaccia pubblica del DAO sigitRImpRuoloPfpg.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRImpRuoloPfpgDao {

	/**
	 * Metodo di inserimento del DAO sigitRImpRuoloPfpg. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRImpRuoloPfpgPk
	 * @generated
	 */

	public SigitRImpRuoloPfpgPk insert(SigitRImpRuoloPfpgDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void update(SigitRImpRuoloPfpgDto dto) throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Custom updater in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void customUpdaterSubentroRespImpResp(SigitRImpRuoloPfpgDto filter, java.lang.Object value)
			throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Custom updater in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void customUpdaterSubentroPropImpProp(SigitRImpRuoloPfpgDto filter, java.lang.Object value)
			throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Custom updater in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void customUpdaterSubentroInstManut(SigitRImpRuoloPfpgDto filter, java.lang.Object value)
			throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Updates selected columns in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void updateColumnsFlgPrimoCaricatore(SigitRImpRuoloPfpgDto dto) throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Updates selected columns in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void updateColumnsTerminaRiga(SigitRImpRuoloPfpgDto dto) throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Deletes a single row in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */

	public void delete(SigitRImpRuoloPfpgPk pk) throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Custom deleter in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Custom deleter in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void customDeleterByFilter(SigitRImpRuoloPfpgDto filter) throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Returns all rows from the SIGIT_R_IMP_RUOLO_PFPG table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRImpRuoloPfpgDto findByPrimaryKey(SigitRImpRuoloPfpgPk pk) throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findByCodiceImpianto(java.lang.Integer input)
			throws SigitRImpRuoloPfpgDaoException;

	/** 
		 * Implementazione del finder manutentoriByCodiceImpianto con Qdef
		 * @generated
		 */

	public List<SigitRImpRuoloPfpgManutentoriByCodiceImpiantoDto> findManutentoriByCodiceImpianto(
			java.lang.Integer input) throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Implementazione del finder byRuoloConUtente
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findByRuoloConUtente(
			it.csi.sigit.sigitwebn.dto.allegati.FiltroRicercaCodiciImpianto input)
			throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Implementazione del finder attiviByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findAttiviByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaPfPg input)
			throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Implementazione del finder ruoloAttivoPgByCodImpiantoRuoloFunz
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findRuoloAttivoPgByCodImpiantoRuoloFunz(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter input)
			throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Implementazione del finder ruoloAttivoPfByCodImpiantoRuoloFunz
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findRuoloAttivoPfByCodImpiantoRuoloFunz(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter input)
			throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Implementazione del finder respImpRespAttivoPgByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findRespImpRespAttivoPgByCodImpianto(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter input)
			throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Implementazione del finder respImpRespAttivoPfByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findRespImpRespAttivoPfByCodImpianto(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter input)
			throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Implementazione del finder ruoloAttivoPgByCodImpiantoRuolo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findRuoloAttivoPgByCodImpiantoRuolo(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter input)
			throws SigitRImpRuoloPfpgDaoException;

	/** 
		 * Implementazione del finder genericByFilter con Qdef
		 * @generated
		 */

	public List<SigitRImpRuoloPfpgGenericByFilterDto> findGenericByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaImpiantiSoggettoFilter input)
			throws SigitRImpRuoloPfpgDaoException;

	/** 
		 * Implementazione del finder genericPfByFilter con Qdef
		 * @generated
		 */

	public List<SigitRImpRuoloPfpgGenericPfByFilterDto> findGenericPfByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaImpiantiSoggettoFilter input)
			throws SigitRImpRuoloPfpgDaoException;

}
