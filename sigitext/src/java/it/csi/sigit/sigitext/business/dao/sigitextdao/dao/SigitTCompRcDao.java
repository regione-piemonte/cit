package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompRcDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompRcPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompRcDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompRc.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompRcDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompRc. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompRcPk
	 * @generated
	 */

	public SigitTCompRcPk insert(SigitTCompRcDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_RC table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompRcDaoException;

}
