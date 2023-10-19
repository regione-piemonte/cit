package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.WrkConfigDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.WrkConfigDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO WrkConfig.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface WrkConfigDao {

	/** 
	 * Implementazione del finder byChiaveConfig
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<WrkConfigDto> findByChiaveConfig(String input) throws WrkConfigDaoException;

}
