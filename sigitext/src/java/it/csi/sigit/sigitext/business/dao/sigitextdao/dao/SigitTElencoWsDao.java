package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTElencoWsDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTElencoWsPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTElencoWsDaoException;

/**
 * Interfaccia pubblica del DAO sigitTElencoWs.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTElencoWsDao {

	/** 
	 * Returns all rows from the SIGIT_T_ELENCO_WS table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTElencoWsDto findByPrimaryKey(SigitTElencoWsPk pk) throws SigitTElencoWsDaoException;

}
