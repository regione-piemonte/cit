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
 * Interfaccia pubblica del DAO sigitTAzione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTAzioneDao {

	/**
	 * Metodo di inserimento del DAO sigitTAzione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAzionePk
	 * @generated
	 */

	public SigitTAzionePk insert(SigitTAzioneDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_AZIONE table.
	 * @generated
	 */
	public void update(SigitTAzioneDto dto) throws SigitTAzioneDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_AZIONE table.
	 * @generated
	 */

	public void delete(SigitTAzionePk pk) throws SigitTAzioneDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_AZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAzioneDto findByPrimaryKey(SigitTAzionePk pk) throws SigitTAzioneDaoException;

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAzioneDto> findByExample(it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAzioneDto input)
			throws SigitTAzioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_AZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAzioneDto> findAll() throws SigitTAzioneDaoException;

}
