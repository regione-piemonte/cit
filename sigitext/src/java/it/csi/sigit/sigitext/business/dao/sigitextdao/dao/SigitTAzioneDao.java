package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzionePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAzioneDaoException;

import java.util.List;

public interface SigitTAzioneDao {


	public SigitTAzionePk insert(SigitTAzioneDto dto);

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
	public List<SigitTAzioneDto> findByExample(SigitTAzioneDto input)
			throws SigitTAzioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_AZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAzioneDto> findAll() throws SigitTAzioneDaoException;

}
