package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;


import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDDettaglioGfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDDettaglioGfDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitDDettaglioGf.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDDettaglioGfDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_DETTAGLIO_GF.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDDettaglioGfDto> findAll() throws SigitDDettaglioGfDaoException;

}
