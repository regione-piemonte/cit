/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
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
 * Interfaccia pubblica del DAO sigitTAllRespTxt.
 * @generated
 */
public interface SigitTAllRespTxtDao {

	/**
	 * Metodo di inserimento del DAO sigitTAllRespTxt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAllRespTxtPk
	 * @generated
	 */

	public SigitTAllRespTxtPk insert(SigitTAllRespTxtDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_ALLRESP_TXT table.
	 * @generated
	 */
	public void update(SigitTAllRespTxtDto dto)
			throws SigitTAllRespTxtDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_ALLRESP_TXT table.
	 * @generated
	 */

	public void delete(SigitTAllRespTxtPk pk)
			throws SigitTAllRespTxtDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_ALLRESP_TXT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAllRespTxtDto findByPrimaryKey(SigitTAllRespTxtPk pk)
			throws SigitTAllRespTxtDaoException;

}
