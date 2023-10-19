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
 * Interfaccia pubblica del DAO sigitTDatoDistrib.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDatoDistribDao {

	/**
	 * Metodo di inserimento del DAO sigitTDatoDistrib. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDatoDistribPk
	 * @generated
	 */

	public SigitTDatoDistribPk insert(SigitTDatoDistribDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_DATO_DISTRIB table.
	 * @generated
	 */
	public void customDeleterByFkImportDistrib(java.lang.Integer filter) throws SigitTDatoDistribDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_DATO_DISTRIB table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDatoDistribDto findByPrimaryKey(SigitTDatoDistribPk pk) throws SigitTDatoDistribDaoException;

	/** 
	 * Implementazione del finder byIdImportDistrib
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDatoDistribDto> findByIdImportDistrib(Integer input) throws SigitTDatoDistribDaoException;

}
