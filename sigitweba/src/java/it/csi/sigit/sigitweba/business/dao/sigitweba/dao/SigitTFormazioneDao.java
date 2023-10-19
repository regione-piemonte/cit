package it.csi.sigit.sigitweba.business.dao.sigitweba.dao;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.qbe.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.metadata.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import it.csi.sigit.sigitweba.business.dao.util.*;
import it.csi.sigit.sigitweba.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO sigitTFormazione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTFormazioneDao {

	/**
	 * Metodo di inserimento del DAO sigitTFormazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTFormazionePk
	 * @generated
	 */

	public SigitTFormazionePk insert(SigitTFormazioneDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_FORMAZIONE table.
	 * @generated
	 */
	public void update(SigitTFormazioneDto dto) throws SigitTFormazioneDaoException;

	/** 
	 * Implementazione del finder byIdPersona
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTFormazioneDto> findByIdPersona(java.math.BigDecimal input) throws SigitTFormazioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_FORMAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTFormazioneDto> findAll() throws SigitTFormazioneDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_FORMAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTFormazioneDto findByPrimaryKey(SigitTFormazionePk pk) throws SigitTFormazioneDaoException;

}
