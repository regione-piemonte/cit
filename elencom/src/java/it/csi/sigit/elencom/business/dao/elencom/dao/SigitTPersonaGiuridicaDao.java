package it.csi.sigit.elencom.business.dao.elencom.dao;

import it.csi.sigit.elencom.business.dao.elencom.dao.*;
import it.csi.sigit.elencom.business.dao.elencom.dto.*;
import it.csi.sigit.elencom.business.dao.elencom.qbe.*;
import it.csi.sigit.elencom.business.dao.elencom.metadata.*;
import it.csi.sigit.elencom.business.dao.elencom.exceptions.*;
import it.csi.sigit.elencom.business.dao.util.*;
import it.csi.sigit.elencom.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO sigitTPersonaGiuridica.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTPersonaGiuridicaDao {

	/**
	 * Metodo di inserimento del DAO sigitTPersonaGiuridica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTPersonaGiuridicaPk
	 * @generated
	 */

	public SigitTPersonaGiuridicaPk insert(SigitTPersonaGiuridicaDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_PERSONA_GIURIDICA table.
	 * @generated
	 */
	public void update(SigitTPersonaGiuridicaDto dto) throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Implementazione del finder province
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findProvince(String input) throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Implementazione del finder comuni
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findComuni(String input) throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Implementazione del finder personaGiuridica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findPersonaGiuridica(
			it.csi.sigit.elencom.business.dao.elencom.dto.SigitTPersonaGiuridicaDto input)
			throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_PERSONA_GIURIDICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTPersonaGiuridicaDto findByPrimaryKey(SigitTPersonaGiuridicaPk pk)
			throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_PERSONA_GIURIDICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findAll() throws SigitTPersonaGiuridicaDaoException;

}
