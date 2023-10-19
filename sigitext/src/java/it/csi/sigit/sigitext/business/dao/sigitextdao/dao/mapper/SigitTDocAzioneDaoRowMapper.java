package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTDocAzioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTDocAzioneDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAzioneDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SigitTDocAzioneDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTDocAzioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTDocAzioneDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTDocAzioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTDocAzioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTDocAzioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTDocAzioneDto) {
			return mapRow_internal((SigitTDocAzioneDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTDocAzioneDto mapRow_internal(SigitTDocAzioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTDocAzioneDto dto = objectToFill;

		// colonna [ID_DOC_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_DOC_AZIONE") != null)
			dto.setIdDocAzione((Integer) rs.getObject("ID_DOC_AZIONE"));

		// colonna [FK_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_AZIONE") != null)
			dto.setFkAzione((Integer) rs.getObject("FK_AZIONE"));

		// colonna [NOME_DOC_ORIGINALE]
		if (mapAllColumns || columnsToReadMap.get("NOME_DOC_ORIGINALE") != null)
			dto.setNomeDocOriginale(rs.getString("NOME_DOC_ORIGINALE"));

		// colonna [NOME_DOC]
		if (mapAllColumns || columnsToReadMap.get("NOME_DOC") != null)
			dto.setNomeDoc(rs.getString("NOME_DOC"));

		// colonna [UID_INDEX]
		if (mapAllColumns || columnsToReadMap.get("UID_INDEX") != null)
			dto.setUidIndex(rs.getString("UID_INDEX"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getDate("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		return dto;
	}

}
