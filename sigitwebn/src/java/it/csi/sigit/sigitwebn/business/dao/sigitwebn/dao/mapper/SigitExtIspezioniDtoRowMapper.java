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
public class SigitExtIspezioniDtoRowMapper extends BaseDaoRowMapper
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
	public SigitExtIspezioniDtoRowMapper(String[] columnsToRead, Class dtoClass,
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

		if (dtoInstance instanceof SigitExtIspezioniDto) {
			return mapRow_internal((SigitExtIspezioniDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitExtIspezioniDto mapRow_internal(
			SigitExtIspezioniDto objectToFill, ResultSet rs, int row)
			throws SQLException

	{
		SigitExtIspezioniDto dto = objectToFill;

		// colonna [ID_ISPEZIONE_2018]
		if (mapAllColumns || columnsToReadMap.get("ID_ISPEZIONE_2018") != null)
			dto.setIdIspezione2018((Integer) rs.getObject("ID_ISPEZIONE_2018"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [DES_STATO_ISPEZIONE]
		if (mapAllColumns || columnsToReadMap.get("DES_STATO_ISPEZIONE") != null)
			dto.setDesStatoIspezione(rs.getString("DES_STATO_ISPEZIONE"));

		// lettura colonna [DT_CREAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_CREAZIONE") != null)
			dto.setDtCreazione(rs.getTimestamp("DT_CREAZIONE"));

		// lettura colonna [FLG_ESITO]
		if (mapAllColumns || columnsToReadMap.get("FLG_ESITO") != null)
			dto.setFlgEsito(rs.getBigDecimal("FLG_ESITO"));

		// colonna [NOME]
		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("NOME"));

		// colonna [COGNOME]
		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("COGNOME"));

		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodiceFiscale(rs.getString("CODICE_FISCALE"));

		// colonna [ISTAT_PROV_COMPETENZA]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_PROV_COMPETENZA") != null)
			dto.setIstatProvCompetenza(rs.getString("ISTAT_PROV_COMPETENZA"));

		// colonna [CF_ISPETTORE_SECONDARIO]
		if (mapAllColumns || columnsToReadMap.get("CF_ISPETTORE_SECONDARIO") != null)
			dto.setCfIspettoreSecondario(rs.getString("CF_ISPETTORE_SECONDARIO"));

		// colonna [FLG_ISP_PAGAMENTO]
		if (mapAllColumns || columnsToReadMap.get("FLG_ISP_PAGAMENTO") != null)
			dto.setFlgIspPagamento(rs.getBigDecimal("FLG_ISP_PAGAMENTO"));

		// colonna [INDIRIZZO_UNITA_IMMOB]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_UNITA_IMMOB") != null)
			dto.setIndirizzoUnitaImmob(rs.getString("INDIRIZZO_UNITA_IMMOB"));

		// colonna [CIVICO]
		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("CIVICO"));

		// colonna [DENOMINAZIONE_COMUNE]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_COMUNE") != null)
			dto.setDenominazioneComune(rs.getString("DENOMINAZIONE_COMUNE"));

		// colonna [SIGLA_PROVINCIA]
		if (mapAllColumns || columnsToReadMap.get("SIGLA_PROVINCIA") != null)
			dto.setSiglaProvincia(rs.getString("SIGLA_PROVINCIA"));

		// colonna [L1_3_POT_H2O_KW]
		if (mapAllColumns || columnsToReadMap.get("L1_3_POT_H2O_KW") != null)
			dto.setL13PotH2oKw(rs.getBigDecimal("L1_3_POT_H2O_KW"));

		// colonna [L1_3_POT_CLIMA_INV_KW]
		if (mapAllColumns || columnsToReadMap.get("L1_3_POT_CLIMA_INV_KW") != null)
			dto.setL13PotClimaInvKw(rs.getBigDecimal("L1_3_POT_CLIMA_INV_KW"));

		// colonna [L1_3_POT_CLIMA_EST_KW]
		if (mapAllColumns || columnsToReadMap.get("L1_3_POT_CLIMA_EST_KW") != null)
			dto.setL13PotClimaEstKw(rs.getBigDecimal("L1_3_POT_CLIMA_EST_KW"));


		return dto;
	}

}
