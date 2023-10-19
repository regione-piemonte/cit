package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompVrDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompVrPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompVrDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompVr.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompVrDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompVr. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompVrPk
	 * @generated
	 */

	public SigitTCompVrPk insert(SigitTCompVrDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_VR table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompVrDaoException;

}
