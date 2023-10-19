package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompCiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompCiPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompCiDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompCi.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompCiDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompCi. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompCiPk
	 * @generated
	 */

	public SigitTCompCiPk insert(SigitTCompCiDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_CI table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompCiDaoException;

}
