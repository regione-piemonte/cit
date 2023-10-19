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
 * Interfaccia pubblica del DAO sigitTContratto2019.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTContratto2019Dao {

	/**
	 * Metodo di inserimento del DAO sigitTContratto2019. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTContratto2019Pk
	 * @generated
	 */

	public SigitTContratto2019Pk insert(SigitTContratto2019Dto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_T_CONTRATTO_2019 table.
	 * @generated
	 */
	public void updateColumnsPerRevoca(SigitTContratto2019Dto dto) throws SigitTContratto2019DaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_CONTRATTO_2019 table.
	 * @generated
	 */
	public void updateColumnsPerProroga(SigitTContratto2019Dto dto) throws SigitTContratto2019DaoException;

	/** 
	 * Custom deleter in the SIGIT_T_CONTRATTO_2019 table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTContratto2019DaoException;

	/** 
	 * Returns all rows from the SIGIT_T_CONTRATTO_2019 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTContratto2019Dto findByPrimaryKey(SigitTContratto2019Pk pk) throws SigitTContratto2019DaoException;

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTContratto2019Dto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ContrattoFilter input)
			throws SigitTContratto2019DaoException;

	/** 
	 * Implementazione del finder byId3Responsabile
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTContratto2019Dto> findById3Responsabile(java.math.BigDecimal input)
			throws SigitTContratto2019DaoException;

	/** 
	 * Implementazione del finder byIdResponsabile
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTContratto2019Dto> findByIdResponsabile(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter input)
			throws SigitTContratto2019DaoException;

	/** 
	 * Implementazione del finder byCodImpSysdate
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTContratto2019Dto> findByCodImpSysdate(java.math.BigDecimal input)
			throws SigitTContratto2019DaoException;

}
