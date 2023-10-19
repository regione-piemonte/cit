package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTConsumoTipo1BDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTConsumoTipo1BPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTConsumoTipo1BDaoException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTConsumoTipo1B.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTConsumoTipo1BDao {

	/**
	 * Metodo di inserimento del DAO sigitTConsumoTipo1B. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTConsumoTipo1BPk
	 * @generated
	 */

	public SigitTConsumoTipo1BPk insert(SigitTConsumoTipo1BDto dto)

	;

	void customDeleterDeleteByIdAllegato(BigDecimal idAllegato) throws SigitTConsumoTipo1BDaoException;

	List<SigitTConsumoTipo1BDto> findByFilter(SigitTConsumoTipo1BDto filter) throws SigitTConsumoTipo1BDaoException;
}
