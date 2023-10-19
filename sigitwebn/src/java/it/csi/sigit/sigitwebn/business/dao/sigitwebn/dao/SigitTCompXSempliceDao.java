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
 * Interfaccia pubblica del DAO sigitTCompXSemplice.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompXSempliceDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompXSemplice. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompXSemplicePk
	 * @generated
	 */

	public SigitTCompXSemplicePk insert(SigitTCompXSempliceDto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_T_COMPX_SEMPLICE table.
	 * @generated
	 */
	public void updateColumnsSez5(SigitTCompXSempliceDto dto) throws SigitTCompXSempliceDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_COMPX_SEMPLICE table.
	 * @generated
	 */
	public void updateColumnsSez6(SigitTCompXSempliceDto dto) throws SigitTCompXSempliceDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_COMPX_SEMPLICE table.
	 * @generated
	 */
	public void updateColumnsSez7(SigitTCompXSempliceDto dto) throws SigitTCompXSempliceDaoException;

	/** 
	 * Updates a single row in the SIGIT_T_COMPX_SEMPLICE table.
	 * @generated
	 */
	public void update(SigitTCompXSempliceDto dto) throws SigitTCompXSempliceDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMPX_SEMPLICE table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompXSempliceDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_COMPX_SEMPLICE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompXSempliceDto findByPrimaryKey(SigitTCompXSemplicePk pk) throws SigitTCompXSempliceDaoException;

}
