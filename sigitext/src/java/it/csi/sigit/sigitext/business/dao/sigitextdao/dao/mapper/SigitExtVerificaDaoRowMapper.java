/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitExtDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitExtDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitExtVerificaDto;
import it.csi.sigit.sigitext.business.util.ConvertUtil;

/**
 * RowMapper specifico del DAO SigitVTotImpiantoDao
 * @generated
 */
public class SigitExtVerificaDaoRowMapper extends BaseDaoRowMapper
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
	public SigitExtVerificaDaoRowMapper(String[] columnsToRead, Class dtoClass,
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

		if (dtoInstance instanceof SigitExtVerificaDto) {
			return mapRow_internal((SigitExtVerificaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitExtVerificaDto mapRow_internal(
			SigitExtVerificaDto objectToFill, ResultSet rs, int row)
			throws SQLException

	{
		SigitExtVerificaDto dto = objectToFill;
		
		
		// colonna [ID_VERIFICA]
		if (mapAllColumns || columnsToReadMap.get("ID_VERIFICA") != null)
			dto.setIdVerifica((Integer) rs.getObject("ID_VERIFICA"));

		// colonna [FK_TIPO_VERIFICA]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_VERIFICA") != null)
			dto.setFkTipoVerifica((Integer) rs.getObject("FK_TIPO_VERIFICA"));

		// colonna [FK_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("FK_ALLEGATO") != null)
			dto.setFkAllegato(rs.getBigDecimal("FK_ALLEGATO"));

		// colonna [FK_DATO_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("FK_DATO_DISTRIB") != null)
			dto.setFkDatoDistrib(rs.getInt("FK_DATO_DISTRIB"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [CF_UTENTE_CARICAMENTO]
		if (mapAllColumns || columnsToReadMap.get("CF_UTENTE_CARICAMENTO") != null)
			dto.setCfUtenteCaricamento(rs.getString("CF_UTENTE_CARICAMENTO"));

		// colonna [DENOM_UTENTE_CARICAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DENOM_UTENTE_CARICAMENTO") != null)
			dto.setDenomUtenteCaricamento(rs.getString("DENOM_UTENTE_CARICAMENTO"));

		// colonna [DT_CARICAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DT_CARICAMENTO") != null)
			dto.setDtCaricamento(rs.getDate("DT_CARICAMENTO"));

		// colonna [SIGLA_BOLLINO]
		if (mapAllColumns || columnsToReadMap.get("SIGLA_BOLLINO") != null)
			dto.setSiglaBollino(rs.getString("SIGLA_BOLLINO"));

		// colonna [NUMERO_BOLLINO]
		if (mapAllColumns || columnsToReadMap.get("NUMERO_BOLLINO") != null)
			dto.setNumeroBollino(rs.getBigDecimal("NUMERO_BOLLINO"));

		// colonna [DT_SVEGLIA]
		if (mapAllColumns || columnsToReadMap.get("DT_SVEGLIA") != null)
			dto.setDtSveglia(rs.getDate("DT_SVEGLIA"));

		// colonna [NOTE_SVEGLIA]
		if (mapAllColumns || columnsToReadMap.get("NOTE_SVEGLIA") != null)
			dto.setNoteSveglia(rs.getString("NOTE_SVEGLIA"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));
		
		if (mapAllColumns || columnsToReadMap.get("ID_ACCERTAMENTO") != null)
			dto.setFkAccertamento(rs.getBigDecimal("ID_ACCERTAMENTO"));
		
		if (mapAllColumns || columnsToReadMap.get("ID_ISPEZIONE_2018") != null)
			dto.setFkIspezione(rs.getBigDecimal("ID_ISPEZIONE_2018"));

		return dto;
	}

}
