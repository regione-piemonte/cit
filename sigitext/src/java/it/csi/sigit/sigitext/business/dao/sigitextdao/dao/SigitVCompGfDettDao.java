package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVCompGfDettDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVCompGfDettDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitVCompGfDett.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVCompGfDettDao {

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompGfDettDto> findByCodImpiantoOrdered(Integer input)
			throws SigitVCompGfDettDaoException;

}
