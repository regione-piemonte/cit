package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompXDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompXPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompXDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTCompX.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompXDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompX. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompXPk
	 * @generated
	 */

	public SigitTCompXPk insert(SigitTCompXDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_X table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompXDaoException;

	/** 
	 * Implementazione del finder byTipoAndCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompXDto> findByTipoAndCodImpiantoOrdered(
			it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter input) throws SigitTCompXDaoException;

}
