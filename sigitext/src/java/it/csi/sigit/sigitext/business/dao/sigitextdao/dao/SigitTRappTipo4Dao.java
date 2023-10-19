package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo4Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo4Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTRappTipo4DaoException;

/**
 * Interfaccia pubblica del DAO sigitTRappTipo4.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTRappTipo4Dao {

	/**
	 * Metodo di inserimento del DAO sigitTRappTipo4. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRappTipo4Pk
	 * @generated
	 */

	public SigitTRappTipo4Pk insert(SigitTRappTipo4Dto dto)

	;

	void delete(SigitTRappTipo4Pk sigitTRappTipo4Pk) throws SigitTRappTipo4DaoException;

	SigitTRappTipo4Dto findByPrimaryKey(SigitTRappTipo4Pk sigitTRappTipo4Pk) throws SigitTRappTipo4DaoException;
}
