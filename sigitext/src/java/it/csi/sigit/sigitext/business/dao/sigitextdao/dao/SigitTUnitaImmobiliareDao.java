package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTUnitaImmobiliarePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTUnitaImmobiliareDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTUnitaImmobiliare.
 * Espone le operazioni che possono essere eseguite per la gestione
 * della tabella [Table[TRANSIENT]]
 *
 * @generated
 */
public interface SigitTUnitaImmobiliareDao {

	/**
	 * Updates a single row in the SIGIT_T_UNITA_IMMOBILIARE table.
	 *
	 * @generated
	 */
	public void update(SigitTUnitaImmobiliareDto dto) throws SigitTUnitaImmobiliareDaoException;

	/**
	 * Implementazione del finder byCodiceImpianto
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUnitaImmobiliareDto> findByCodiceImpianto(Integer input) throws SigitTUnitaImmobiliareDaoException, SigitTUnitaImmobiliareDaoException;

	/**
	 * Implementazione del finder unitaPrincipaleImpianto
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUnitaImmobiliareDto> findUnitaPrincipaleImpianto(Integer input) throws SigitTUnitaImmobiliareDaoException;

	public SigitTUnitaImmobiliarePk insert(SigitTUnitaImmobiliareDto dto);

	public void updateColumnsDaOnline(SigitTUnitaImmobiliareDto dto) throws SigitTUnitaImmobiliareDaoException;
}
