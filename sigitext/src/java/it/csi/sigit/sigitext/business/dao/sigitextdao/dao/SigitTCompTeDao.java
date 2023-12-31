package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompTeDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompTePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompTeDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompTe.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompTeDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompTe. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompTePk
	 * @generated
	 */

	public SigitTCompTePk insert(SigitTCompTeDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_TE table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompTeDaoException;

}
