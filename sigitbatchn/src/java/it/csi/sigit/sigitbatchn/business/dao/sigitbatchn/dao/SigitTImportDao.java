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
 * Interfaccia pubblica del DAO sigitTImport.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTImportDao {

	/** 
	 * Updates a single row in the SIGIT_T_IMPORT table.
	 * @generated
	 */
	public void update(SigitTImportDto dto) throws SigitTImportDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_IMPORT table.
	 * @generated
	 */
	public void updateColumnsAggiornaIdAllegato(SigitTImportDto dto) throws SigitTImportDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_IMPORT table.
	 * @generated
	 */
	public void updateColumnsAggiornaIdPersGiuridica(SigitTImportDto dto) throws SigitTImportDaoException;

	/** 
	 * Custom updater in the SIGIT_T_IMPORT table.
	 * @generated
	 */
	public void customUpdaterAggiornaDataInvioMailAssistenza(java.lang.Object filter, java.lang.Object value)
			throws SigitTImportDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_IMPORT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTImportDto findByPrimaryKey(SigitTImportPk pk) throws SigitTImportDaoException;

	/** 
	 * Implementazione del finder daElaborare
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImportDto> findDaElaborare(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDto input)
			throws SigitTImportDaoException;

	/** 
	 * Implementazione del finder daInviareMailAssistenza
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImportDto> findDaInviareMailAssistenza(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDto input)
			throws SigitTImportDaoException;

}
