package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompCsDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompCsPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompCsDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompCs.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompCsDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompCs. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompCsPk
	 * @generated
	 */

	public SigitTCompCsPk insert(SigitTCompCsDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_CS table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompCsDaoException;

}
