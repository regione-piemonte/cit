package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAbilitazioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAbilitazionePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAbilitazioneDaoException;

import java.util.List;

public interface SigitTAbilitazioneDao {

	/**
	 * Metodo di inserimento del DAO sigitTAbilitazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 *
	 * @param dto
	 * @return SigitTAbilitazionePk
	 * @generated
	 */

	public SigitTAbilitazionePk insert(SigitTAbilitazioneDto dto)

	;

	/**
	 * Updates a single row in the SIGIT_T_ABILITAZIONE table.
	 *
	 * @generated
	 */
	public void update(SigitTAbilitazioneDto dto) throws SigitTAbilitazioneDaoException;

	/**
	 * Returns all rows from the SIGIT_T_ABILITAZIONE table that match the primary key criteria
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAbilitazioneDto findByPrimaryKey(SigitTAbilitazionePk pk) throws SigitTAbilitazioneDaoException;

	/**
	 * Implementazione del finder byExample
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAbilitazioneDto> findByExample(SigitTAbilitazioneDto input) throws SigitTAbilitazioneDaoException;

	/**
	 * Restituisce tutte le righe della tabella SIGIT_T_ABILITAZIONE.
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAbilitazioneDto> findAll() throws SigitTAbilitazioneDaoException;

	/**
	 * Implementazione del finder comboIstatAbilitazione
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAbilitazioneDto> findComboIstatAbilitazione(java.lang.Integer input) throws SigitTAbilitazioneDaoException;

}
