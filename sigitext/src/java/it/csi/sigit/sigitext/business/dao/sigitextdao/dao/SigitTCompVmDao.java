package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompVmDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompVmPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompVmDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompVm.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompVmDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompVm. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompVmPk
	 * @generated
	 */

	public SigitTCompVmPk insert(SigitTCompVmDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_VM table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompVmDaoException;

}
