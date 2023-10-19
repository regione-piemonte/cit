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
 * RowMapper specifico del DAO SigitVTotImpiantoDao
 * @generated
 */
public class SigitExtImpiantoDaoRowMapper extends BaseDaoRowMapper
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
	public SigitExtImpiantoDaoRowMapper(String[] columnsToRead, Class dtoClass,
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

		if (dtoInstance instanceof SigitExtImpiantoDto) {
			return mapRow_internal((SigitExtImpiantoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitExtImpiantoDto mapRow_internal(
			SigitExtImpiantoDto objectToFill, ResultSet rs, int row)
			throws SQLException

	{
		SigitExtImpiantoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA_PROVINCIA") != null)
			dto.setSiglaProvincia(rs.getString("SIGLA_PROVINCIA"));

		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE") != null)
			dto.setIstatComune(rs.getString("ISTAT_COMUNE"));

		if (mapAllColumns
				|| columnsToReadMap.get("DENOMINAZIONE_PROVINCIA") != null)
			dto.setDenominazioneProvincia(rs
					.getString("DENOMINAZIONE_PROVINCIA"));

		if (mapAllColumns
				|| columnsToReadMap.get("DENOMINAZIONE_COMUNE") != null)
			dto.setDenominazioneComune(rs.getString("DENOMINAZIONE_COMUNE"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_SITAD") != null)
			dto.setIndirizzo(rs.getString("INDIRIZZO_SITAD"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("CIVICO"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_RESPONSABILE") != null)
			dto.setDenominazioneResponsabile(rs.getString("DENOMINAZIONE_RESPONSABILE"));
		
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_3_RESPONSABILE") != null)
			dto.setDenominazione3Responsabile(rs.getString("DENOMINAZIONE_3_RESPONSABILE"));



		return dto;
	}

}
