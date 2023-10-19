package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDUnitaMisuraDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDUnitaMisuraPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDUnitaMisuraDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitDUnitaMisura.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDUnitaMisuraDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_UNITA_MISURA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDUnitaMisuraDto> findAll() throws SigitDUnitaMisuraDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_UNITA_MISURA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDUnitaMisuraDto findByPrimaryKey(SigitDUnitaMisuraPk pk) throws SigitDUnitaMisuraDaoException;

}
