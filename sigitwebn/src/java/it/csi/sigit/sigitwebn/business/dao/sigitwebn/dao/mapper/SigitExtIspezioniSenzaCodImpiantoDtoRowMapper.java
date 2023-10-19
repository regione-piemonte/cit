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
public class SigitExtIspezioniSenzaCodImpiantoDtoRowMapper extends BaseDaoRowMapper
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
	public SigitExtIspezioniSenzaCodImpiantoDtoRowMapper(String[] columnsToRead, Class dtoClass,
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

		if (dtoInstance instanceof SigitExtIspezioniSenzaCodImpiantoDto) {
			return mapRow_internal((SigitExtIspezioniSenzaCodImpiantoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitExtIspezioniSenzaCodImpiantoDto mapRow_internal(
			SigitExtIspezioniSenzaCodImpiantoDto objectToFill, ResultSet rs, int row)
			throws SQLException

	{
		SigitExtIspezioniSenzaCodImpiantoDto dto = objectToFill;
		
		// colonna [ID_ISPEZIONE_2018]
		if (mapAllColumns || columnsToReadMap.get("ID_ISPEZIONE_2018") != null)
			dto.setIdIspezione2018((Integer) rs.getObject("ID_ISPEZIONE_2018"));



		// colonna [FLG_PF_PG]
		if (mapAllColumns || columnsToReadMap.get("FLG_PF_PG") != null)
			dto.setFlgPfPg(rs.getString("FLG_PF_PG"));

		// colonna [COGNOME_DENOM]
		if (mapAllColumns || columnsToReadMap.get("COGNOME_DENOM") != null)
			dto.setCognomeDenom(rs.getString("COGNOME_DENOM"));

		// colonna [NOME]
		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("NOME"));

		// colonna [CF_PIVA]
		if (mapAllColumns || columnsToReadMap.get("CF_PIVA") != null)
			dto.setCfPiva(rs.getString("CF_PIVA"));

		// colonna [DUG]
		if (mapAllColumns || columnsToReadMap.get("DUG") != null)
			dto.setDug(rs.getString("DUG"));

		// colonna [INDIRIZZO]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO") != null)
			dto.setIndirizzo(rs.getString("INDIRIZZO"));

		// colonna [CIVICO]
		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("CIVICO"));

		// colonna [CAP]
		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("CAP"));

		// colonna [ISTAT_COMUNE]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE") != null)
			dto.setIstatComune(rs.getString("ISTAT_COMUNE"));

		// colonna [FLG_PF_PG_FATT]
		if (mapAllColumns || columnsToReadMap.get("FLG_PF_PG_FATT") != null)
			dto.setFlgPfPgFatt(rs.getString("FLG_PF_PG_FATT"));

		// colonna [COGNOME_DENOM_FATT]
		if (mapAllColumns || columnsToReadMap.get("COGNOME_DENOM_FATT") != null)
			dto.setCognomeDenomFatt(rs.getString("COGNOME_DENOM_FATT"));

		// colonna [NOME_FATT]
		if (mapAllColumns || columnsToReadMap.get("NOME_FATT") != null)
			dto.setNomeFatt(rs.getString("NOME_FATT"));

		// colonna [CF_PIVA_FATT]
		if (mapAllColumns || columnsToReadMap.get("CF_PIVA_FATT") != null)
			dto.setCfPivaFatt(rs.getString("CF_PIVA_FATT"));

		// colonna [DUG_FATT]
		if (mapAllColumns || columnsToReadMap.get("DUG_FATT") != null)
			dto.setDugFatt(rs.getString("DUG_FATT"));

		// colonna [INDIRIZZO_FATT]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_FATT") != null)
			dto.setIndirizzoFatt(rs.getString("INDIRIZZO_FATT"));

		// colonna [CIVICO_FATT]
		if (mapAllColumns || columnsToReadMap.get("CIVICO_FATT") != null)
			dto.setCivicoFatt(rs.getString("CIVICO_FATT"));

		// colonna [CAP_FATT]
		if (mapAllColumns || columnsToReadMap.get("CAP_FATT") != null)
			dto.setCapFatt(rs.getString("CAP_FATT"));

		// colonna [ISTAT_COMUNE_FATT]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE_FATT") != null)
			dto.setIstatComuneFatt(rs.getString("ISTAT_COMUNE_FATT"));
		
		// colonna [DES_TIPO_CONTRATTO_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_CONTRATTO_DISTRIB") != null)
			dto.setDesTipoContrattoDistrib(rs.getString("DES_TIPO_CONTRATTO_DISTRIB"));

		// colonna [DES_CATEGORIA_UTIL]
		if (mapAllColumns || columnsToReadMap.get("DES_CATEGORIA_UTIL") != null)
			dto.setDesCategoriaUtil(rs.getString("DES_CATEGORIA_UTIL"));

		// colonna [DES_COMBUSTIBILE]
		if (mapAllColumns || columnsToReadMap.get("DES_COMBUSTIBILE") != null)
			dto.setDesCombustibile(rs.getString("DES_COMBUSTIBILE"));

		// colonna [DES_UNITA_MISURA]
		if (mapAllColumns || columnsToReadMap.get("DES_UNITA_MISURA") != null)
			dto.setDesUnitaMisura(rs.getString("DES_UNITA_MISURA"));

		// colonna [ANNO_RIF]
		if (mapAllColumns || columnsToReadMap.get("ANNO_RIF") != null)
			dto.setAnnoRif(rs.getBigDecimal("ANNO_RIF"));

		// colonna [NR_MESI_FATTUR]
		if (mapAllColumns || columnsToReadMap.get("NR_MESI_FATTUR") != null)
			dto.setNrMesiFattur(rs.getBigDecimal("NR_MESI_FATTUR"));

		// colonna [CONSUMO_ANNO]
		if (mapAllColumns || columnsToReadMap.get("CONSUMO_ANNO") != null)
			dto.setConsumoAnno(rs.getBigDecimal("CONSUMO_ANNO"));

		// colonna [CONSUMO_MENSILE]
		if (mapAllColumns || columnsToReadMap.get("CONSUMO_MENSILE") != null)
			dto.setConsumoMensile(rs.getBigDecimal("CONSUMO_MENSILE"));

		return dto;
	}

}
