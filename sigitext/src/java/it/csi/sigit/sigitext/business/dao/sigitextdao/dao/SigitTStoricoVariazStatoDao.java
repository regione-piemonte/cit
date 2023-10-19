package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTStoricoVariazStatoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTStoricoVariazStatoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTStoricoVariazStatoDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTStoricoVariazStato.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTStoricoVariazStatoDao {

	/**
	 * Metodo di inserimento del DAO sigitTStoricoVariazStato. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTStoricoVariazStatoPk
	 * @generated
	 */

	public SigitTStoricoVariazStatoPk insert(SigitTStoricoVariazStatoDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_STORICO_VARIAZ_STATO table.
	 * @generated
	 */
	public void customDeleterByCodiceImpianto(Integer filter) throws SigitTStoricoVariazStatoDaoException;

	/** 
	 * Implementazione del finder findByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTStoricoVariazStatoDto> findFindByCodiceImpianto(Integer input)
			throws SigitTStoricoVariazStatoDaoException;

}
