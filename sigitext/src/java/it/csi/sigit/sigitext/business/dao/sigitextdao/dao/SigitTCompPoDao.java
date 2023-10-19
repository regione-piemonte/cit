package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompPoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompPoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompPoDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompPo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompPoDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompPo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompPoPk
	 * @generated
	 */

	public SigitTCompPoPk insert(SigitTCompPoDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_PO table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompPoDaoException;

}
