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
 * Interfaccia pubblica del DAO sigitTDatoDistrib.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDatoDistribDao {

	/**
	 * Metodo di inserimento del DAO sigitTDatoDistrib. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDatoDistribPk
	 * @generated
	 */

	public SigitTDatoDistribPk insert(SigitTDatoDistribDto dto)

	;

	/** 
	 * Deletes a single row in the SIGIT_T_DATO_DISTRIB table.
	 * @generated
	 */

	public void delete(SigitTDatoDistribPk pk) throws SigitTDatoDistribDaoException;

	/** 
		 * Implementazione del finder allByIdStatoImportDistrib con Qdef
		 * @generated
		 */

	public List<SigitTDatoDistribAllByIdStatoImportDistribDto> findAllByIdStatoImportDistrib(java.lang.Integer[] input)
			throws SigitTDatoDistribDaoException;

}
