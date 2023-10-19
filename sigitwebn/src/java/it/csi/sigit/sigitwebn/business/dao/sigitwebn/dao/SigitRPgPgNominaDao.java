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
 * Interfaccia pubblica del DAO sigitRPgPgNomina.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRPgPgNominaDao {

	/**
	 * Metodo di inserimento del DAO sigitRPgPgNomina. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRPgPgNominaPk
	 * @generated
	 */

	public SigitRPgPgNominaPk insert(SigitRPgPgNominaDto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_R_PG_PG_NOMINA table.
	 * @generated
	 */
	public void updateColumnsCessaIncarico(SigitRPgPgNominaDto dto) throws SigitRPgPgNominaDaoException;

	/** 
	 * Returns all rows from the SIGIT_R_PG_PG_NOMINA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRPgPgNominaDto findByPrimaryKey(SigitRPgPgNominaPk pk) throws SigitRPgPgNominaDaoException;

	/** 
		 * Implementazione del finder personaGiuridicaCatByIdPersonaGiuridica con Qdef
		 * @generated
		 */

	public List<SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto> findPersonaGiuridicaCatByIdPersonaGiuridica(
			java.lang.Integer input) throws SigitRPgPgNominaDaoException;

	/** 
	 * Implementazione del finder attivaByIdPersonaGiuridicaImpGiuridicaCat
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPgPgNominaDto> findAttivaByIdPersonaGiuridicaImpGiuridicaCat(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPgPgNominaDto input)
			throws SigitRPgPgNominaDaoException;

	/** 
	 * Implementazione del finder attivaByIdPersonaGiuridicaCat
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPgPgNominaDto> findAttivaByIdPersonaGiuridicaCat(java.lang.Integer input)
			throws SigitRPgPgNominaDaoException;

}
