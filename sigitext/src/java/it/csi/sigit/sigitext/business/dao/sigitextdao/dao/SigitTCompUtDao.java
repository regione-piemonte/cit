package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompUtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompUtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompUtDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompUt.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompUtDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompUt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompUtPk
	 * @generated
	 */

	public SigitTCompUtPk insert(SigitTCompUtDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_UT table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompUtDaoException;

}
