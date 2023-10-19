package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTConsumoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTConsumoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTConsumoDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTConsumo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTConsumoDao {

	/**
	 * Metodo di inserimento del DAO sigitTConsumo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTConsumoPk
	 * @generated
	 */

	public SigitTConsumoPk insert(SigitTConsumoDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_CONSUMO table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTConsumoDaoException;

	/** 
	 * Implementazione del finder ByCodImpiantoAndTipo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTConsumoDto> findByCodImpiantoAndTipo(
			SigitTConsumoDto input) throws SigitTConsumoDaoException;

}
