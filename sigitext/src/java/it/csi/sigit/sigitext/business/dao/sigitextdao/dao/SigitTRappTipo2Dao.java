package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo2Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo2Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTRappTipo2DaoException;

/**
 * Interfaccia pubblica del DAO sigitTRappTipo2.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTRappTipo2Dao {

	/**
	 * Metodo di inserimento del DAO sigitTRappTipo2. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRappTipo2Pk
	 * @generated
	 */

	public SigitTRappTipo2Pk insert(SigitTRappTipo2Dto dto)

	;

	void delete(SigitTRappTipo2Pk sigitTRappTipo2Pk) throws SigitTRappTipo2DaoException;

	SigitTRappTipo2Dto findByPrimaryKey(SigitTRappTipo2Pk sigitTRappTipo2Pk) throws SigitTRappTipo2DaoException;
}
