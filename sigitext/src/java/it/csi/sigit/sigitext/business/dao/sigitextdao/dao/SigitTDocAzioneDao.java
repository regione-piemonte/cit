package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAzioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAzionePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDocAzioneDaoException;

import java.util.List;

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
	 *
	 * @generated
	 */
	public void update(SigitTDocAzioneDto dto) throws SigitTDocAzioneDaoException;

	/**
	 * Updates selected columns in the SIGIT_T_DOC_AZIONE table.
	 *
	 * @generated
	 */
	public void updateColumnsAggiornaNomeUid(SigitTDocAzioneDto dto) throws SigitTDocAzioneDaoException;

	/**
	 * Deletes a single row in the SIGIT_T_DOC_AZIONE table.
	 *
	 * @generated
	 */

	public void delete(SigitTDocAzionePk pk) throws SigitTDocAzioneDaoException;

	/**
	 * Returns all rows from the SIGIT_T_DOC_AZIONE table that match the primary key criteria
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDocAzioneDto findByPrimaryKey(SigitTDocAzionePk pk) throws SigitTDocAzioneDaoException;

	/**
	 * Implementazione del finder byIdAzione
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDocAzioneDto> findByIdAzione(java.lang.Integer input) throws SigitTDocAzioneDaoException;

}
