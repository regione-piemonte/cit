package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaFisicaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTPersonaFisicaDaoException;

import java.util.List;

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
	 * Implementazione del finder byCodiceFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaFisicaDto> findByCodiceFiscale(String input) throws SigitTPersonaFisicaDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_PERSONA_FISICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTPersonaFisicaDto findByPrimaryKey(SigitTPersonaFisicaPk pk) throws SigitTPersonaFisicaDaoException;

}
