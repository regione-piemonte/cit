package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVCompGtDettDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVCompGtDettDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitVCompGtDett.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVCompGtDettDao {

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompGtDettDto> findByCodImpiantoOrdered(Integer input)
			throws SigitVCompGtDettDaoException;

}
