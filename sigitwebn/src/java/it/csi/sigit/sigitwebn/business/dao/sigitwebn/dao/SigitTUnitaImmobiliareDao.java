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
 * Interfaccia pubblica del DAO sigitTUnitaImmobiliare.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTUnitaImmobiliareDao {

	/**
	 * Metodo di inserimento del DAO sigitTUnitaImmobiliare. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTUnitaImmobiliarePk
	 * @generated
	 */

	public SigitTUnitaImmobiliarePk insert(SigitTUnitaImmobiliareDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_UNITA_IMMOBILIARE table.
	 * @generated
	 */
	public void update(SigitTUnitaImmobiliareDto dto) throws SigitTUnitaImmobiliareDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_UNITA_IMMOBILIARE table.
	 * @generated
	 */
	public void updateColumnsDaOnline(SigitTUnitaImmobiliareDto dto) throws SigitTUnitaImmobiliareDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_UNITA_IMMOBILIARE table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTUnitaImmobiliareDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_UNITA_IMMOBILIARE table.
	 * @generated
	 */
	public void customDeleterByCodImpiantoSecondarie(java.lang.Integer filter)
			throws SigitTUnitaImmobiliareDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_UNITA_IMMOBILIARE table.
	 * @generated
	 */

	public void delete(SigitTUnitaImmobiliarePk pk) throws SigitTUnitaImmobiliareDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_UNITA_IMMOBILIARE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTUnitaImmobiliareDto findByPrimaryKey(SigitTUnitaImmobiliarePk pk)
			throws SigitTUnitaImmobiliareDaoException;

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUnitaImmobiliareDto> findByCodiceImpianto(java.lang.Integer input)
			throws SigitTUnitaImmobiliareDaoException;

	/** 
	 * Implementazione del finder unitaPrincipaleImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUnitaImmobiliareDto> findUnitaPrincipaleImpianto(java.lang.Integer input)
			throws SigitTUnitaImmobiliareDaoException;

	/** 
	 * Implementazione del finder principaleByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUnitaImmobiliareDto> findPrincipaleByFilter(SigitTUnitaImmobiliareDto input)
			throws SigitTUnitaImmobiliareDaoException;

	/** 
		 * Implementazione del finder principaleByCodiceImpianto con Qdef
		 * @generated
		 */

	public List<SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto> findPrincipaleByCodiceImpianto(
			java.lang.Integer input) throws SigitTUnitaImmobiliareDaoException;

}
