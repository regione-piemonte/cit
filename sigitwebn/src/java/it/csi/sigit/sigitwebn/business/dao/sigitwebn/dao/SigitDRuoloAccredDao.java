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
 * Interfaccia pubblica del DAO sigitDRuoloAccred.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDRuoloAccredDao {

	/**
	 * Metodo di inserimento del DAO sigitDRuoloAccred. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitDRuoloAccredPk
	 * @generated
	 */

	public SigitDRuoloAccredPk insert(SigitDRuoloAccredDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_D_RUOLO_ACCRED table.
	 * @generated
	 */
	public void update(SigitDRuoloAccredDto dto) throws SigitDRuoloAccredDaoException;

	/** 
	 * Deletes a single row in the SIGIT_D_RUOLO_ACCRED table.
	 * @generated
	 */

	public void delete(SigitDRuoloAccredPk pk) throws SigitDRuoloAccredDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_RUOLO_ACCRED table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDRuoloAccredDto findByPrimaryKey(SigitDRuoloAccredPk pk) throws SigitDRuoloAccredDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_RUOLO_ACCRED.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDRuoloAccredDto> findAll() throws SigitDRuoloAccredDaoException;

}
