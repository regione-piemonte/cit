/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitVTotImpiantoDao
 * @generated
 */
public class SigitExtIspezione2018DaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitExtDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitExtIspezione2018DaoRowMapper(String[] columnsToRead, Class dtoClass,
			SigitExtDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitExtDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVTotImpiantoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitExtIspezione2018Dto) {
			return mapRow_internal((SigitExtIspezione2018Dto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitExtIspezione2018Dto mapRow_internal(
			SigitExtIspezione2018Dto objectToFill, ResultSet rs, int row)
			throws SQLException

	{
		SigitExtIspezione2018Dto dto = objectToFill;
		
		
		// colonna [ID_ISPEZIONE_2018]
		if (mapAllColumns || columnsToReadMap.get("ID_ISPEZIONE_2018") != null)
			dto.setIdIspezione2018(rs.getBigDecimal("ID_ISPEZIONE_2018"));

		// colonna [NOME]
		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNomeIspettore(rs.getString("NOME"));
		
		// colonna [COGNOME]
		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognomeIspettore(rs.getString("COGNOME"));
		
		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCfIspettore(rs.getString("CODICE_FISCALE"));
		
		// colonna [CF_ISPETTORE_SECONDARIO]
		if (mapAllColumns || columnsToReadMap.get("CF_ISPETTORE_SECONDARIO") != null)
			dto.setCfIspettoreSecondario(rs.getString("CF_ISPETTORE_SECONDARIO"));
		
		// colonna [DT_CREAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_CREAZIONE") != null)
			dto.setDataCreazione(rs.getDate("DT_CREAZIONE"));

		// colonna [ENTE_COMPETENTE]
		if (mapAllColumns || columnsToReadMap.get("ENTE_COMPETENTE") != null)
			dto.setEnteCompetente(rs.getString("ENTE_COMPETENTE"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

		// colonna [FK_STATO_ISPEZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_STATO_ISPEZIONE") != null)
			dto.setStatoIspezione(rs.getBigDecimal("FK_STATO_ISPEZIONE"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [FLG_ESITO]
		if (mapAllColumns || columnsToReadMap.get("FLG_ESITO") != null)
			dto.setFlgEsito(rs.getBigDecimal("FLG_ESITO"));
		

		return dto;
	}

}
