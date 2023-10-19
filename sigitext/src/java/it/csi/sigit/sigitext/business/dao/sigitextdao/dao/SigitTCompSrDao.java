package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompSrDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompSrPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompSrDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompSr.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompSrDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompSr. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompSrPk
	 * @generated
	 */

	public SigitTCompSrPk insert(SigitTCompSrDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_SR table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompSrDaoException;

}
