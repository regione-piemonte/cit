package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDFluidoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDFluidoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDFluidoDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitDFluido.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDFluidoDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_FLUIDO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDFluidoDto> findAll() throws SigitDFluidoDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_FLUIDO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDFluidoDto findByPrimaryKey(SigitDFluidoPk pk) throws SigitDFluidoDaoException;

}
