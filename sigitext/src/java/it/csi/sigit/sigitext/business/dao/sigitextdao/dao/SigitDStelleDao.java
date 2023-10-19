package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDStelleDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDStelleDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitDStelle.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDStelleDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_STELLE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDStelleDto> findAll() throws SigitDStelleDaoException;

}
