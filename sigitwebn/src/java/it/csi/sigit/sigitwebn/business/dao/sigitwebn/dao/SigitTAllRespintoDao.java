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
 * Interfaccia pubblica del DAO sigitTAllRespinto.
 * @generated
 */
public interface SigitTAllRespintoDao {

	/**
	 * Metodo di inserimento del DAO sigitTAllRespinto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAllRespintoPk
	 * @generated
	 */

	public SigitTAllRespintoPk insert(SigitTAllRespintoDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_ALL_RESPINTO table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter)
			throws SigitTAllRespintoDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_ALL_RESPINTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAllRespintoDto findByPrimaryKey(SigitTAllRespintoPk pk)
			throws SigitTAllRespintoDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_ALL_RESPINTO table that match the criteria ''.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAllRespintoDto> findAll()
			throws SigitTAllRespintoDaoException;

	/** 
	 * Implementazione del finder ByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAllRespintoDto> findByCodImpianto(Integer input)
			throws SigitTAllRespintoDaoException;

}
