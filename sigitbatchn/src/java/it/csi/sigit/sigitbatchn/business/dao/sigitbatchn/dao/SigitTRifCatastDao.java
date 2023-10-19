package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import it.csi.sigit.sigitbatchn.business.dao.util.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO sigitTRifCatast.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTRifCatastDao {

	/**
	 * Metodo di inserimento del DAO sigitTRifCatast. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRifCatastPk
	 * @generated
	 */

	public SigitTRifCatastPk insert(SigitTRifCatastDto dto)

	;

	/** 
	 * Deletes a single row in the SIGIT_T_RIF_CATAST table.
	 * @generated
	 */

	public void delete(SigitTRifCatastPk pk) throws SigitTRifCatastDaoException;

	/** 
		 * Implementazione del finder allByIdStatoImportDistrib con Qdef
		 * @generated
		 */

	public List<SigitTRifCatastAllByIdStatoImportDistribDto> findAllByIdStatoImportDistrib(java.lang.Integer[] input)
			throws SigitTRifCatastDaoException;

}
