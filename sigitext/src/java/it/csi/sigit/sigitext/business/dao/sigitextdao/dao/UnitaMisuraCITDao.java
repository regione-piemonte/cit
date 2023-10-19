package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.UnitaMisuraCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.UnitaMisuraCITPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.UnitaMisuraCITDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO UnitaMisuraCIT.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface UnitaMisuraCITDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_UNITA_MISURA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<UnitaMisuraCITDto> findAll() throws UnitaMisuraCITDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_UNITA_MISURA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public UnitaMisuraCITDto findByPrimaryKey(UnitaMisuraCITPk pk) throws UnitaMisuraCITDaoException;

}
