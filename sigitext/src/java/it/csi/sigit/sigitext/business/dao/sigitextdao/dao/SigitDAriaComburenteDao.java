package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDAriaComburenteDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDAriaComburenteDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitDAriaComburente.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDAriaComburenteDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_ARIA_COMBURENTE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDAriaComburenteDto> findAll() throws SigitDAriaComburenteDaoException;

}
