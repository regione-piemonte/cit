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
 * Interfaccia pubblica del DAO sigitTDocContratto.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDocContrattoDao {

	/**
	 * Metodo di inserimento del DAO sigitTDocContratto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDocContrattoPk
	 * @generated
	 */

	public SigitTDocContrattoPk insert(SigitTDocContrattoDto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_CONTRATTO table.
	 * @generated
	 */
	public void updateColumnsAggiornaNomeUid(SigitTDocContrattoDto dto) throws SigitTDocContrattoDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_CONTRATTO table.
	 * @generated
	 */
	public void updateColumnsAggiornaPerEliminazione(SigitTDocContrattoDto dto) throws SigitTDocContrattoDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_DOC_CONTRATTO table.
	 * @generated
	 */

	public void delete(SigitTDocContrattoPk pk) throws SigitTDocContrattoDaoException;

	/** 
	 * Implementazione del finder findByExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDocContrattoDto> findFindByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocContrattoDto input)
			throws SigitTDocContrattoDaoException;

}
