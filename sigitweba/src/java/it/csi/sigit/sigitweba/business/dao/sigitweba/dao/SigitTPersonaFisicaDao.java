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
 * Interfaccia pubblica del DAO sigitTPersonaFisica.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTPersonaFisicaDao {

	/**
	 * Metodo di inserimento del DAO sigitTPersonaFisica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTPersonaFisicaPk
	 * @generated
	 */

	public SigitTPersonaFisicaPk insert(SigitTPersonaFisicaDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_PERSONA_FISICA table.
	 * @generated
	 */
	public void update(SigitTPersonaFisicaDto dto) throws SigitTPersonaFisicaDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_PERSONA_FISICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTPersonaFisicaDto findByPrimaryKey(SigitTPersonaFisicaPk pk) throws SigitTPersonaFisicaDaoException;

	/** 
	 * Implementazione del finder findByCodFisc
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaFisicaDto> findFindByCodFisc(java.lang.String input)
			throws SigitTPersonaFisicaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_PERSONA_FISICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaFisicaDto> findAll() throws SigitTPersonaFisicaDaoException;

}
