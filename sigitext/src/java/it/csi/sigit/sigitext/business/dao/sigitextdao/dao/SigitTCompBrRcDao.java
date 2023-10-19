package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompBrRcDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompBrRcPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompBrRcDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTCompBrRc.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompBrRcDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompBrRc. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompBrRcPk
	 * @generated
	 */

	public SigitTCompBrRcPk insert(SigitTCompBrRcDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_BR_RC table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompBrRcDaoException;

	/** 
	 * Implementazione del finder byTipoAndCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompBrRcDto> findByTipoAndCodImpiantoOrdered(
			SigitTCompBrRcDto input)
			throws SigitTCompBrRcDaoException;

	public List<SigitTCompBrRcDto> findBrRcLegateAGt(CompFilter filtroGT) throws SigitTCompBrRcDaoException;
}
