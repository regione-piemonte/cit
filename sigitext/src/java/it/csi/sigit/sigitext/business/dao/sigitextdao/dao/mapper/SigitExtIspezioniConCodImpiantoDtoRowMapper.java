/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitExtDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitExtDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitExtIspezioniConCodImpiantoDto;

/**
 * RowMapper specifico del DAO SigitVTotImpiantoDao
 * @generated
 */
public class SigitExtIspezioniConCodImpiantoDtoRowMapper extends BaseDaoRowMapper
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
	public SigitExtIspezioniConCodImpiantoDtoRowMapper(String[] columnsToRead, Class dtoClass,
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

		if (dtoInstance instanceof SigitExtIspezioniConCodImpiantoDto) {
			return mapRow_internal((SigitExtIspezioniConCodImpiantoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitExtIspezioniConCodImpiantoDto mapRow_internal(
			SigitExtIspezioniConCodImpiantoDto objectToFill, ResultSet rs, int row)
			throws SQLException

	{
		SigitExtIspezioniConCodImpiantoDto dto = objectToFill;
		
		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [RUOLO]
		if (mapAllColumns || columnsToReadMap.get("RUOLO") != null)
			dto.setRuolo(rs.getString("RUOLO"));
		
		// colonna [ID_RESPONSABILE]
		if (mapAllColumns || columnsToReadMap.get("ID_RESPONSABILE") != null)
			dto.setIdResponsabile(rs.getBigDecimal("ID_RESPONSABILE"));
		
		// colonna [COGNOME_DENOMINAZIONE]
		if (mapAllColumns || columnsToReadMap.get("COGNOME_DENOMINAZIONE") != null)
			dto.setCognomeDenominazione(rs.getString("COGNOME_DENOMINAZIONE"));
		
		// colonna [NOME]
		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("NOME"));
		
		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodiceFiscale(rs.getString("CODICE_FISCALE"));

		// colonna [INDIRIZZO]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO") != null)
			dto.setIndirizzo(rs.getString("INDIRIZZO"));

		// colonna [CIVICO]
		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("CIVICO"));

		// colonna [CAP]
		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("CAP"));

		// colonna [COMUNE]
		if (mapAllColumns || columnsToReadMap.get("COMUNE") != null)
			dto.setComune(rs.getString("COMUNE"));

		// colonna [PROVINCIA]
		if (mapAllColumns || columnsToReadMap.get("PROVINCIA") != null)
			dto.setProvincia(rs.getString("PROVINCIA"));
		
		// colonna [EMAIL]
		if (mapAllColumns || columnsToReadMap.get("EMAIL") != null)
			dto.setEmail(rs.getString("EMAIL"));

		// colonna [SIGLA_REA]
		if (mapAllColumns || columnsToReadMap.get("SIGLA_REA") != null)
			dto.setSiglaRea(rs.getString("SIGLA_REA"));

		// colonna [NUMERO_REA]
		if (mapAllColumns || columnsToReadMap.get("NUMERO_REA") != null)
			dto.setNumeroRea(rs.getBigDecimal("NUMERO_REA"));

		
		return dto;
	}

}
