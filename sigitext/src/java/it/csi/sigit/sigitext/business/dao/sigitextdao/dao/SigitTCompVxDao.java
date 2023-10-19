package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompVxDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompVxPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompVxDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTCompVx.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompVxDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompVx. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompVxPk
	 * @generated
	 */

	public SigitTCompVxPk insert(SigitTCompVxDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_VX table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompVxDaoException, SigitTCompVxDaoException;

	/** 
	 * Implementazione del finder ByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompVxDto> findByCodImpianto(Integer input) throws SigitTCompVxDaoException;

}
