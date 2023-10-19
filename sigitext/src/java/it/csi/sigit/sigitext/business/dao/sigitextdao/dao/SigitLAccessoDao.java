package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitLAccessoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitLAccessoPk;

/**
 * Interfaccia pubblica del DAO sigitLAccesso.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitLAccessoDao {

	/**
	 * Metodo di inserimento del DAO sigitLAccesso. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitLAccessoPk
	 * @generated
	 */

	public SigitLAccessoPk insert(SigitLAccessoDto dto)

	;

}
