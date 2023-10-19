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
 * Interfaccia pubblica del DAO sigitTDocAllegato.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDocAllegatoDao {

	/**
	 * Metodo di inserimento del DAO sigitTDocAllegato. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDocAllegatoPk
	 * @generated
	 */

	public SigitTDocAllegatoPk insert(SigitTDocAllegatoDto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_ALLEGATO table.
	 * @generated
	 */
	public void updateColumnsAggiornaNomeUid(SigitTDocAllegatoDto dto) throws SigitTDocAllegatoDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_ALLEGATO table.
	 * @generated
	 */
	public void updateColumnsAggiornaEliminaDoc(SigitTDocAllegatoDto dto) throws SigitTDocAllegatoDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_DOC_ALLEGATO table.
	 * @generated
	 */

	public void delete(SigitTDocAllegatoPk pk) throws SigitTDocAllegatoDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_DOC_ALLEGATO table.
	 * @generated
	 */
	public void customDeleterByIdAllegatoDel(java.math.BigDecimal filter) throws SigitTDocAllegatoDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_DOC_ALLEGATO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDocAllegatoDto findByPrimaryKey(SigitTDocAllegatoPk pk) throws SigitTDocAllegatoDaoException;

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDocAllegatoDto> findByIdAllegato(java.lang.Integer input) throws SigitTDocAllegatoDaoException;

}
