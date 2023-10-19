package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVRicercaAllegatiDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitVRicercaAllegati.
 * Espone le operazioni che possono essere eseguite per la gestione
 * della tabella [Table[TRANSIENT]]
 *
 * @generated
 */
public interface SigitVRicercaAllegatiDao {

	/**
	 * Implementazione del finder inviatiByCodImpiantoOrderedByData
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findInviatiByCodImpiantoOrderedByData(Integer input) throws SigitVRicercaAllegatiDaoException;

	/**
	 * Implementazione del finder manutByCodImpianto
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findManutByCodImpianto(Integer input) throws SigitVRicercaAllegatiDaoException;

	public List<SigitVRicercaAllegatiDto> findControlliByCodImpiantoOrdered(Integer codice, String ordinamento,Integer limit) throws SigitVRicercaAllegatiDaoException;

	public List<SigitVRicercaAllegatiDto> findByIdAllegato(String idAllegato) throws SigitVRicercaAllegatiDaoException;
}
