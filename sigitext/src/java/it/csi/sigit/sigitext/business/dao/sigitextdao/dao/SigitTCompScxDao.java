package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompScxDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompScxPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompScxDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompScx.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompScxDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompScx. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompScxPk
	 * @generated
	 */

	public SigitTCompScxPk insert(SigitTCompScxDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_SCX table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompScxDaoException;

}
