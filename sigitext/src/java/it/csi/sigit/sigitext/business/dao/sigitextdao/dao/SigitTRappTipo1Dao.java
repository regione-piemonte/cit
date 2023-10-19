package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo1Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo1Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTRappTipo1DaoException;

/**
 * Interfaccia pubblica del DAO sigitTRappTipo1.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTRappTipo1Dao {

	/**
	 * Metodo di inserimento del DAO sigitTRappTipo1. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRappTipo1Pk
	 * @generated
	 */

	public SigitTRappTipo1Pk insert(SigitTRappTipo1Dto dto);

	public SigitTRappTipo1Dto findByPrimaryKey(SigitTRappTipo1Pk pk) throws SigitTRappTipo1DaoException;

	void delete(SigitTRappTipo1Pk sigitTRappTipo1Pk) throws SigitTRappTipo1DaoException;
}
