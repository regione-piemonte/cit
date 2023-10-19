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
 * Interfaccia pubblica del DAO sigitTDettTipo3.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDettTipo3Dao {

	/**
	 * Metodo di inserimento del DAO sigitTDettTipo3. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDettTipo3Pk
	 * @generated
	 */

	public SigitTDettTipo3Pk insert(SigitTDettTipo3Dto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_DETT_TIPO3 table.
	 * @generated
	 */
	public void update(SigitTDettTipo3Dto dto) throws SigitTDettTipo3DaoException;

	/** 
	 * Custom deleter in the SIGIT_T_DETT_TIPO3 table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitTDettTipo3DaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_DETT_TIPO3.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo3Dto> findAll() throws SigitTDettTipo3DaoException;

	/** 
	 * Returns all rows from the SIGIT_T_DETT_TIPO3 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDettTipo3Dto findByPrimaryKey(SigitTDettTipo3Pk pk) throws SigitTDettTipo3DaoException;

	/** 
	 * Implementazione del finder byAllegatoCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo3Dto> findByAllegatoCodImpianto(SigitTDettTipo3Dto input)
			throws SigitTDettTipo3DaoException;

}
