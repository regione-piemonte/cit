package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.PotenzaImpDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.PotenzaImpDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO PotenzaImp.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface PotenzaImpDao {

	/** 
	 * Restituisce tutte le righe della tabella OLD_SIGIT_D_POTENZA_IMP.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<PotenzaImpDto> findAll() throws PotenzaImpDaoException;

}
