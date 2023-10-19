package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTDocAllegatoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTDocAllegatoDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAllegatoDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTDocAllegatoDao
 *
 * @generated
 */
public class SigitTDocAllegatoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 *
	 * @generated
	 */
	SigitTDocAllegatoDaoImpl dao;

	/**
	 * costruttore
	 *
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *                      incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTDocAllegatoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTDocAllegatoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTDocAllegatoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 *
	 * @param rs
	 * @param row
	 * @return SigitTDocAllegatoDto
	 * @throws SQLException
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTDocAllegatoDto) {
			return mapRow_internal((SigitTDocAllegatoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTDocAllegatoDto mapRow_internal(SigitTDocAllegatoDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitTDocAllegatoDto dto = objectToFill;

		// colonna [ID_DOC_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("ID_DOC_ALLEGATO") != null)
			dto.setIdDocAllegato((Integer) rs.getObject("ID_DOC_ALLEGATO"));

		// colonna [FK_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("FK_ALLEGATO") != null)
			dto.setFkAllegato(rs.getBigDecimal("FK_ALLEGATO"));

		// colonna [NOME_DOC_ORIGINALE]
		if (mapAllColumns || columnsToReadMap.get("NOME_DOC_ORIGINALE") != null)
			dto.setNomeDocOriginale(rs.getString("NOME_DOC_ORIGINALE"));

		// colonna [NOME_DOC]
		if (mapAllColumns || columnsToReadMap.get("NOME_DOC") != null)
			dto.setNomeDoc(rs.getString("NOME_DOC"));

		// colonna [UID_INDEX]
		if (mapAllColumns || columnsToReadMap.get("UID_INDEX") != null)
			dto.setUidIndex(rs.getString("UID_INDEX"));

		// colonna [DESCRIZIONE]
		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONE") != null)
			dto.setDescrizione(rs.getString("DESCRIZIONE"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getDate("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		// colonna [DATA_UPLOAD]
		if (mapAllColumns || columnsToReadMap.get("DATA_UPLOAD") != null)
			dto.setDataUpload(rs.getTimestamp("DATA_UPLOAD"));

		// colonna [DATA_DELETE]
		if (mapAllColumns || columnsToReadMap.get("DATA_DELETE") != null)
			dto.setDataDelete(rs.getTimestamp("DATA_DELETE"));

		return dto;
	}

}
