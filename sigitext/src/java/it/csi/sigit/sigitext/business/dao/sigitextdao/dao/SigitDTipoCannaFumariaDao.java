package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoCannaFumariaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoCannaFumariaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDTipoCannaFumariaDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitDTipoCannaFumaria.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDTipoCannaFumariaDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_TIPO_CANNA_FUMARIA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoCannaFumariaDto> findAll() throws SigitDTipoCannaFumariaDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_TIPO_CANNA_FUMARIA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDTipoCannaFumariaDto findByPrimaryKey(SigitDTipoCannaFumariaPk pk)
			throws SigitDTipoCannaFumariaDaoException;

}
