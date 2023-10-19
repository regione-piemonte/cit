package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVCompCgDettDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVCompCgDettDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitVCompCgDett.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVCompCgDettDao {

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompCgDettDto> findByCodImpiantoOrdered(Integer input)
			throws SigitVCompCgDettDaoException;

}
