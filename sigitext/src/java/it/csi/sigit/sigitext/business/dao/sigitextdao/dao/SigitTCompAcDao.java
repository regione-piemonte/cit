package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompAcDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompAcPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompAcDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompAc.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompAcDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompAc. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompAcPk
	 * @generated
	 */

	public SigitTCompAcPk insert(SigitTCompAcDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_AC table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompAcDaoException;

}
