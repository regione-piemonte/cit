package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompRvDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompRvPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompRvDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompRv.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompRvDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompRv. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompRvPk
	 * @generated
	 */

	public SigitTCompRvPk insert(SigitTCompRvDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_RV table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompRvDaoException;

}
