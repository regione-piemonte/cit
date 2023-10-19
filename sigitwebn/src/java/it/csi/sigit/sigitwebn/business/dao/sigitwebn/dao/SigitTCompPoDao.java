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
 * Interfaccia pubblica del DAO sigitTCompPo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompPoDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompPo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompPoPk
	 * @generated
	 */

	public SigitTCompPoPk insert(SigitTCompPoDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_PO table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompPoDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_PO table.
	 * @generated
	 */
	public void customDeleterByCodImpiantoProgr(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompPoDaoException;

	/** 
	 * Implementazione del finder ByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompPoDto> findByCodImpianto(Integer input) throws SigitTCompPoDaoException;

}
