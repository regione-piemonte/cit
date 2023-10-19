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
 * Interfaccia pubblica del DAO sigitTLogDistrib.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTLogDistribDao {

	/**
	 * Metodo di inserimento del DAO sigitTLogDistrib. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTLogDistribPk
	 * @generated
	 */

	public SigitTLogDistribPk insert(SigitTLogDistribDto dto)

	;

	/** 
	 * Implementazione del finder byIdImportDistrib
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLogDistribDto> findByIdImportDistrib(java.lang.Integer input) throws SigitTLogDistribDaoException;

}
