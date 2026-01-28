package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTControlloLibrettoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTControlloLibrettoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTControlloLibrettoDaoException;

/**
 * Interfaccia pubblica del DAO sigitTControlloLibretto.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTControlloLibrettoDao {

	/** 
	 * Returns all rows from the SIGIT_T_CONTROLLO_LIBRETTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTControlloLibrettoDto findByPrimaryKey(SigitTControlloLibrettoPk pk) throws SigitTControlloLibrettoDaoException;
	void insert(SigitTControlloLibrettoDto dto) throws SigitTControlloLibrettoDaoException;
	void update(SigitTControlloLibrettoDto dto) throws SigitTControlloLibrettoDaoException;

}
