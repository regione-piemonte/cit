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
 * Interfaccia pubblica del DAO sigitRIspezIspet.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRIspezIspetDao {

	/**
	 * Metodo di inserimento del DAO sigitRIspezIspet. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRIspezIspetPk
	 * @generated
	 */

	public SigitRIspezIspetPk insert(SigitRIspezIspetDto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_R_ISPEZ_ISPET table.
	 * @generated
	 */
	public void updateColumnsAggiornaDataFine(SigitRIspezIspetDto dto) throws SigitRIspezIspetDaoException;

	/** 
	 * Implementazione del finder byIdIspezione
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRIspezIspetDto> findByIdIspezione(java.lang.Integer input) throws SigitRIspezIspetDaoException;

	/** 
	 * Returns all rows from the SIGIT_R_ISPEZ_ISPET table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRIspezIspetDto findByPrimaryKey(SigitRIspezIspetPk pk) throws SigitRIspezIspetDaoException;

}
