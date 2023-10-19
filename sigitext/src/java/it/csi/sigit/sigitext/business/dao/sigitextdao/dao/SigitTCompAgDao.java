package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompAgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompAgPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompAgDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompAg.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompAgDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompAg. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompAgPk
	 * @generated
	 */

	public SigitTCompAgPk insert(SigitTCompAgDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_AG table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompAgDaoException;

}
