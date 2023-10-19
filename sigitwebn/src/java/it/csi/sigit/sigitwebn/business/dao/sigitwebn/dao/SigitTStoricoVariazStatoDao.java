package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import it.csi.sigit.sigitwebn.business.dao.util.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public List<SigitTStoricoVariazStatoDto> findFindByCodiceImpianto(java.lang.Integer input)
			throws SigitTStoricoVariazStatoDaoException;

}
