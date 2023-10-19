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
 * Interfaccia pubblica del DAO sigitRPfPgDelega.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRPfPgDelegaDao {

	/**
	 * Metodo di inserimento del DAO sigitRPfPgDelega. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRPfPgDelegaPk
	 * @generated
	 */

	public SigitRPfPgDelegaPk insert(SigitRPfPgDelegaDto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_R_PF_PG_DELEGA table.
	 * @generated
	 */
	public void updateColumnsCessaDelega(SigitRPfPgDelegaDto dto) throws SigitRPfPgDelegaDaoException;

	/** 
	 * Returns all rows from the SIGIT_R_PF_PG_DELEGA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRPfPgDelegaDto findByPrimaryKey(SigitRPfPgDelegaPk pk) throws SigitRPfPgDelegaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_R_PF_PG_DELEGA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfPgDelegaDto> findAll() throws SigitRPfPgDelegaDaoException;

	/** 
	 * Implementazione del finder valideByIdPersonaFisica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfPgDelegaDto> findValideByIdPersonaFisica(java.lang.Integer input)
			throws SigitRPfPgDelegaDaoException;

	/** 
		 * Implementazione del finder personaFisicaByIdPersonaGiuridica con Qdef
		 * @generated
		 */

	public List<SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto> findPersonaFisicaByIdPersonaGiuridica(
			java.lang.Integer input) throws SigitRPfPgDelegaDaoException;

	/** 
	 * Implementazione del finder attivaByIdPersonaGiuridicaCFFisica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfPgDelegaDto> findAttivaByIdPersonaGiuridicaCFFisica(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.DelegaFilter input)
			throws SigitRPfPgDelegaDaoException;

	/** 
	 * Implementazione del finder attivaByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfPgDelegaDto> findAttivaByFilter(SigitRPfPgDelegaDto input) throws SigitRPfPgDelegaDaoException;

}
