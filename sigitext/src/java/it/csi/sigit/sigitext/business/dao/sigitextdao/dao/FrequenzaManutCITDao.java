package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.FrequenzaManutCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.FrequenzaManutCITPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.CombustibileCITDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.FrequenzaManutCITDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO CombustibileCIT.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface FrequenzaManutCITDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_COMBUSTIBILE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<FrequenzaManutCITDto> findAll() throws FrequenzaManutCITDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_COMBUSTIBILE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public FrequenzaManutCITDto findByPrimaryKey(FrequenzaManutCITPk pk) throws FrequenzaManutCITDaoException;

}
