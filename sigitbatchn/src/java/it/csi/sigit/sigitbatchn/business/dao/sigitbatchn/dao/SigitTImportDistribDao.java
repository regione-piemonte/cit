package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import it.csi.sigit.sigitbatchn.business.dao.util.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
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
	 * Custom updater in the SIGIT_T_IMPORT_DISTRIB table.
	 * @generated
	 */
	public void customUpdaterAggiornaById(java.lang.Object filter,
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDistribDto value)
			throws SigitTImportDistribDaoException;

	/** 
	 * Custom updater in the SIGIT_T_IMPORT_DISTRIB table.
	 * @generated
	 */
	public void customUpdaterAggiornaDataInvioMailAssistenza(java.lang.Object filter, java.lang.Object value)
			throws SigitTImportDistribDaoException;

	/** 
	 * Implementazione del finder daElaborare
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImportDistribDto> findDaElaborare(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDistribDto input)
			throws SigitTImportDistribDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_IMPORT_DISTRIB table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTImportDistribDto findByPrimaryKey(SigitTImportDistribPk pk) throws SigitTImportDistribDaoException;

	/** 
	 * Implementazione del finder daInviareMailAssistenza
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImportDistribDto> findDaInviareMailAssistenza(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDistribDto input)
			throws SigitTImportDistribDaoException;

	/** 
		 * Implementazione del finder ricevutaByIdImportDistrib con Qdef
		 * @generated
		 */

	public List<SigitTImportDistribRicevutaByIdImportDistribDto> findRicevutaByIdImportDistrib(java.lang.Integer input)
			throws SigitTImportDistribDaoException;

}
