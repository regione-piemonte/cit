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
 * Interfaccia pubblica del DAO sigitTDocAggiuntiva.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDocAggiuntivaDao {

	/**
	 * Metodo di inserimento del DAO sigitTDocAggiuntiva. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDocAggiuntivaPk
	 * @generated
	 */

	public SigitTDocAggiuntivaPk insert(SigitTDocAggiuntivaDto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_AGGIUNTIVA table.
	 * @generated
	 */
	public void updateColumnsAggiornaNomeUid(SigitTDocAggiuntivaDto dto) throws SigitTDocAggiuntivaDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_AGGIUNTIVA table.
	 * @generated
	 */
	public void updateColumnsAggiornaEliminaDoc(SigitTDocAggiuntivaDto dto) throws SigitTDocAggiuntivaDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_DOC_AGGIUNTIVA table.
	 * @generated
	 */

	public void delete(SigitTDocAggiuntivaPk pk) throws SigitTDocAggiuntivaDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_DOC_AGGIUNTIVA table.
	 * @generated
	 */
	public void customDeleterByIdIspezione(java.math.BigDecimal filter) throws SigitTDocAggiuntivaDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_DOC_AGGIUNTIVA table.
	 * @generated
	 */
	public void customDeleterByCodImpDel(java.lang.Integer filter) throws SigitTDocAggiuntivaDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_DOC_AGGIUNTIVA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDocAggiuntivaDto findByPrimaryKey(SigitTDocAggiuntivaPk pk) throws SigitTDocAggiuntivaDaoException;

	/** 
	 * Implementazione del finder byCodImpIdTipoDocAgg
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDocAggiuntivaDto> findByCodImpIdTipoDocAgg(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAggiuntivaDto input)
			throws SigitTDocAggiuntivaDaoException;

	/** 
	 * Implementazione del finder byCodImp
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDocAggiuntivaDto> findByCodImp(java.lang.Integer input) throws SigitTDocAggiuntivaDaoException;

	/** 
		 * Implementazione del finder byCodImpDecod con Qdef
		 * @generated
		 */

	public List<SigitTDocAggiuntivaByCodImpDecodDto> findByCodImpDecod(java.lang.Integer input)
			throws SigitTDocAggiuntivaDaoException;

}
