package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitWrkLogDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitWrkLogPk;

/**
 * Interfaccia pubblica del DAO sigitWrkLog.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitWrkLogDao {

	/**
	 * Metodo di inserimento del DAO sigitWrkLog. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitWrkLogPk
	 * @generated
	 */

	public SigitWrkLogPk insert(SigitWrkLogDto dto)

	;

}
