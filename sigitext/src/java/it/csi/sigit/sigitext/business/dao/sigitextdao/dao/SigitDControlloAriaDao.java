package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDControlloAriaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDControlloAriaDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitDControlloAria.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDControlloAriaDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_CONTROLLO_ARIA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDControlloAriaDto> findAll() throws SigitDControlloAriaDaoException;

}
