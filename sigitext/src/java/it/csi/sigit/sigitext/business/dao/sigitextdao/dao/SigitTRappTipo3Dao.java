package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo3Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo3Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTRappTipo3DaoException;

/**
 * Interfaccia pubblica del DAO sigitTRappTipo3.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTRappTipo3Dao {

	/**
	 * Metodo di inserimento del DAO sigitTRappTipo3. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRappTipo3Pk
	 * @generated
	 */

	public SigitTRappTipo3Pk insert(SigitTRappTipo3Dto dto)

	;

	void delete(SigitTRappTipo3Pk sigitTRappTipo3Pk) throws SigitTRappTipo3DaoException;

	public SigitTRappTipo3Dto findByPrimaryKey(SigitTRappTipo3Pk sigitTRappTipo3Pk) throws SigitTRappTipo3DaoException;
}
