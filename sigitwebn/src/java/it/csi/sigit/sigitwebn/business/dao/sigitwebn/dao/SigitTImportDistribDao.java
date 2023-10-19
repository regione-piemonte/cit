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
 * Interfaccia pubblica del DAO sigitTImportDistrib.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTImportDistribDao {

	/**
	 * Metodo di inserimento del DAO sigitTImportDistrib. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTImportDistribPk
	 * @generated
	 */

	public SigitTImportDistribPk insert(SigitTImportDistribDto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_T_IMPORT_DISTRIB table.
	 * @generated
	 */
	public void updateColumnsAnnullaImport(SigitTImportDistribDto dto) throws SigitTImportDistribDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_IMPORT_DISTRIB table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTImportDistribDto findByPrimaryKey(SigitTImportDistribPk pk) throws SigitTImportDistribDaoException;

	/** 
		 * Implementazione del finder byIdPersonaGiuridica con Qdef
		 * @generated
		 */

	public List<SigitTImportDistribByIdPersonaGiuridicaDto> findByIdPersonaGiuridica(java.lang.Integer input)
			throws SigitTImportDistribDaoException;

	/** 
		 * Implementazione del finder ricevutaByIdImportDistrib con Qdef
		 * @generated
		 */

	public List<SigitTImportDistribRicevutaByIdImportDistribDto> findRicevutaByIdImportDistrib(java.lang.Integer input)
			throws SigitTImportDistribDaoException;

}
