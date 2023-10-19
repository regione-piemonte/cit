package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.MarcaCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.MarcaCITPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.MarcaCITDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO MarcaCIT.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface MarcaCITDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_MARCA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<MarcaCITDto> findAll() throws MarcaCITDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_MARCA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public MarcaCITDto findByPrimaryKey(MarcaCITPk pk) throws MarcaCITDaoException;

}
