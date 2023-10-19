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
 * Interfaccia pubblica del DAO sigitTImpianto.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTImpiantoDao {

	/**
	 * Metodo di inserimento del DAO sigitTImpianto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTImpiantoPk
	 * @generated
	 */

	public SigitTImpiantoPk insert(SigitTImpiantoDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_IMPIANTO table.
	 * @generated
	 */
	public void update(SigitTImpiantoDto dto) throws SigitTImpiantoDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_IMPIANTO table.
	 * @generated
	 */
	public void updateColumnsUpdateDatiOnline(SigitTImpiantoDto dto) throws SigitTImpiantoDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_IMPIANTO table.
	 * @generated
	 */
	public void updateColumnsUpdateBloccoNomina3R(SigitTImpiantoDto dto) throws SigitTImpiantoDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_IMPIANTO table.
	 * @generated
	 */

	public void delete(SigitTImpiantoPk pk) throws SigitTImpiantoDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_IMPIANTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTImpiantoDto findByPrimaryKey(SigitTImpiantoPk pk) throws SigitTImpiantoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_IMPIANTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImpiantoDto> findAll() throws SigitTImpiantoDaoException;

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImpiantoDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoFilter input)
			throws SigitTImpiantoDaoException;

	/** 
		 * Implementazione del finder aggiornamentoCoordinate con Qdef
		 * @generated
		 */

	public List<SigitTImpiantoAggiornamentoCoordinateDto> findAggiornamentoCoordinate(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoAggiornamentoCoordinateFilter input)
			throws SigitTImpiantoDaoException;

	/** 
	 * Implementazione del finder byAccertamentoIstatComune
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImpiantoDto> findByAccertamentoIstatComune(java.lang.String input)
			throws SigitTImpiantoDaoException;

}
