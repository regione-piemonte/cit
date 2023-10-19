package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVCompScDettDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVCompScDettDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitVCompScDett.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVCompScDettDao {

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompScDettDto> findByCodImpiantoOrdered(Integer input)
			throws SigitVCompScDettDaoException;

}
