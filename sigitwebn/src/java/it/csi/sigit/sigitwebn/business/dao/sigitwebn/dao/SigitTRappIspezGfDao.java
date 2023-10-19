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
 * Interfaccia pubblica del DAO sigitTRappIspezGf.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTRappIspezGfDao {

	/**
	 * Metodo di inserimento del DAO sigitTRappIspezGf. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRappIspezGfPk
	 * @generated
	 */

	public SigitTRappIspezGfPk insert(SigitTRappIspezGfDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_RAPP_ISPEZ_GF table.
	 * @generated
	 */
	public void update(SigitTRappIspezGfDto dto) throws SigitTRappIspezGfDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_RAPP_ISPEZ_GF table.
	 * @generated
	 */
	public void customDeleterDeleteByIdAllegato(java.lang.Integer filter) throws SigitTRappIspezGfDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_RAPP_ISPEZ_GF table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTRappIspezGfDto findByPrimaryKey(SigitTRappIspezGfPk pk) throws SigitTRappIspezGfDaoException;

}
