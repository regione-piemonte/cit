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
 * Interfaccia pubblica del DAO sigitTDocAzione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDocAzioneDao {

	/**
	 * Metodo di inserimento del DAO sigitTDocAzione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDocAzionePk
	 * @generated
	 */

	public SigitTDocAzionePk insert(SigitTDocAzioneDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_DOC_AZIONE table.
	 * @generated
	 */
	public void update(SigitTDocAzioneDto dto) throws SigitTDocAzioneDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_AZIONE table.
	 * @generated
	 */
	public void updateColumnsAggiornaNomeUid(SigitTDocAzioneDto dto) throws SigitTDocAzioneDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_DOC_AZIONE table.
	 * @generated
	 */

	public void delete(SigitTDocAzionePk pk) throws SigitTDocAzioneDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_DOC_AZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDocAzioneDto findByPrimaryKey(SigitTDocAzionePk pk) throws SigitTDocAzioneDaoException;

	/** 
	 * Implementazione del finder byIdAzione
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDocAzioneDto> findByIdAzione(java.lang.Integer input) throws SigitTDocAzioneDaoException;

}
