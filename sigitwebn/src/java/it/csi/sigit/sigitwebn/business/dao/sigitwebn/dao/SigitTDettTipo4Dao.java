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
 * Interfaccia pubblica del DAO sigitTDettTipo4.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDettTipo4Dao {

	/**
	 * Metodo di inserimento del DAO sigitTDettTipo4. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDettTipo4Pk
	 * @generated
	 */

	public SigitTDettTipo4Pk insert(SigitTDettTipo4Dto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_DETT_TIPO4 table.
	 * @generated
	 */
	public void update(SigitTDettTipo4Dto dto) throws SigitTDettTipo4DaoException;

	/** 
	 * Custom deleter in the SIGIT_T_DETT_TIPO4 table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitTDettTipo4DaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_DETT_TIPO4.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo4Dto> findAll() throws SigitTDettTipo4DaoException;

	/** 
	 * Returns all rows from the SIGIT_T_DETT_TIPO4 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDettTipo4Dto findByPrimaryKey(SigitTDettTipo4Pk pk) throws SigitTDettTipo4DaoException;

	/** 
	 * Implementazione del finder byAllegatoCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo4Dto> findByAllegatoCodImpianto(SigitTDettTipo4Dto input)
			throws SigitTDettTipo4DaoException;

}
