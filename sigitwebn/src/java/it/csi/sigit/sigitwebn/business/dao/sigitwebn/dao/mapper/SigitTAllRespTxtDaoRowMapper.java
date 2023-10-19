/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTAllRespTxtDao
 * @generated
 */
public class SigitTAllRespTxtDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTAllRespTxtDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTAllRespTxtDaoRowMapper(String[] columnsToRead, Class dtoClass,
			SigitTAllRespTxtDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTAllRespTxtDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTAllRespTxtDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTAllRespTxtDto) {
			return mapRow_internal((SigitTAllRespTxtDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTAllRespTxtDto mapRow_internal(
			SigitTAllRespTxtDto objectToFill, ResultSet rs, int row)
			throws SQLException

	{
		SigitTAllRespTxtDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("DATA_CONTROLLO") != null)
			dto.setDataControllo(rs.getDate("DATA_CONTROLLO"));

		if (mapAllColumns || columnsToReadMap.get("ID_IMP_RUOLO_PFPG") != null)
			dto.setIdImpRuoloPfpg(rs.getBigDecimal("ID_IMP_RUOLO_PFPG"));

		if (mapAllColumns || columnsToReadMap.get("ID_ALLEGATO") != null)
			dto.setIdAllegato(rs.getBigDecimal("ID_ALLEGATO"));

		if (mapAllColumns || columnsToReadMap.get("XML_ALLEGATO") != null)
			dto.setXmlAllegato(rs.getString("XML_ALLEGATO"));

		return dto;
	}

}
