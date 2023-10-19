package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTUserWSDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTUserWSDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTUserWS.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTUserWSDao {

	/** 
	 * Implementazione del finder byUserWS
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUserWSDto> findByUserWS(String input) throws SigitTUserWSDaoException;

}
