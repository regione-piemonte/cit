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
	 * Deletes a single row in the SIGIT_T_PERSONA_FISICA table.
	 * @generated
	 */

	public void delete(SigitTPersonaFisicaPk pk) throws SigitTPersonaFisicaDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_PERSONA_FISICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTPersonaFisicaDto findByPrimaryKey(SigitTPersonaFisicaPk pk) throws SigitTPersonaFisicaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_PERSONA_FISICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaFisicaDto> findAll() throws SigitTPersonaFisicaDaoException;

	/** 
	 * Implementazione del finder byCodFisc
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaFisicaDto> findByCodFisc(java.lang.String input) throws SigitTPersonaFisicaDaoException;

	/** 
	 * Implementazione del finder delegatiValidiByIdPersonaGiuridica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaFisicaDto> findDelegatiValidiByIdPersonaGiuridica(java.math.BigDecimal input)
			throws SigitTPersonaFisicaDaoException;

	/** 
		 * Implementazione del finder validatori con Qdef
		 * @generated
		 */

	public List<SigitTPersonaFisicaValidatoriDto> findValidatori(java.lang.String input)
			throws SigitTPersonaFisicaDaoException;

	/** 
		 * Implementazione del finder DaRuoloPA con Qdef
		 * @generated
		 */

	public List<SigitTPersonaFisicaDaRuoloPADto> findDaRuoloPA(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter input)
			throws SigitTPersonaFisicaDaoException;

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaFisicaDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaPersonaGiuridicaFisicaFilter input)
			throws SigitTPersonaFisicaDaoException;

}
