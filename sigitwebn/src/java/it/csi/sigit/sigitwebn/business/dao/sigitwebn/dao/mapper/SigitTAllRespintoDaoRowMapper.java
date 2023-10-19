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
 * RowMapper specifico del DAO SigitTAllRespintoDao
 * @generated
 */
public class SigitTAllRespintoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTAllRespintoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTAllRespintoDaoRowMapper(String[] columnsToRead,
			Class dtoClass, SigitTAllRespintoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTAllRespintoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTAllRespintoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTAllRespintoDto) {
			return mapRow_internal((SigitTAllRespintoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTAllRespintoDto mapRow_internal(
			SigitTAllRespintoDto objectToFill, ResultSet rs, int row)
			throws SQLException

	{
		SigitTAllRespintoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("DATA_CONTROLLO") != null)
			dto.setDataControllo(rs.getDate("DATA_CONTROLLO"));

		if (mapAllColumns || columnsToReadMap.get("ID_IMP_RUOLO_PFPG") != null)
			dto.setIdImpRuoloPfpg(rs.getBigDecimal("ID_IMP_RUOLO_PFPG"));

		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_DOCUMENTO") != null)
			dto.setFkTipoDocumento(rs.getBigDecimal("FK_TIPO_DOCUMENTO"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA_BOLLINO") != null)
			dto.setSiglaBollino(rs.getString("SIGLA_BOLLINO"));

		if (mapAllColumns || columnsToReadMap.get("NUMERO_BOLLINO") != null)
			dto.setNumeroBollino(rs.getBigDecimal("NUMERO_BOLLINO"));

		if (mapAllColumns || columnsToReadMap.get("NOME_ALLEGATO") != null)
			dto.setNomeAllegato(rs.getString("NOME_ALLEGATO"));

		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		if (mapAllColumns || columnsToReadMap.get("DATA_RESPINTA") != null)
			dto.setDataRespinta(rs.getDate("DATA_RESPINTA"));

		if (mapAllColumns || columnsToReadMap.get("DATA_INVIO") != null)
			dto.setDataInvio(rs.getDate("DATA_INVIO"));

		if (mapAllColumns || columnsToReadMap.get("F_OSSERVAZIONI") != null)
			dto.setFOsservazioni(rs.getString("F_OSSERVAZIONI"));

		if (mapAllColumns || columnsToReadMap.get("F_RACCOMANDAZIONI") != null)
			dto.setFRaccomandazioni(rs.getString("F_RACCOMANDAZIONI"));

		if (mapAllColumns || columnsToReadMap.get("F_PRESCRIZIONI") != null)
			dto.setFPrescrizioni(rs.getString("F_PRESCRIZIONI"));

		if (mapAllColumns || columnsToReadMap.get("F_INTERVENTO_ENTRO") != null)
			dto.setFInterventoEntro(rs.getDate("F_INTERVENTO_ENTRO"));

		if (mapAllColumns || columnsToReadMap.get("ID_ALLEGATO") != null)
			dto.setIdAllegato(rs.getBigDecimal("ID_ALLEGATO"));

		if (mapAllColumns || columnsToReadMap.get("UID_INDEX") != null)
			dto.setUidIndex(rs.getString("UID_INDEX"));

		return dto;
	}

}
