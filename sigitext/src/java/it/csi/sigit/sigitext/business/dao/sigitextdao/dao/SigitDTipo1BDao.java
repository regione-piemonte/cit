package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipo1BDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDTipo1BDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitDTipo1B.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDTipo1BDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_TIPO_1B.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipo1BDto> findAll() throws SigitDTipo1BDaoException;

}
