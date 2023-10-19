package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitWrkLogMemoTuDao
 * @generated
 */
public class SigitWrkLogMemoTuDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitWrkLogMemoTuDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitWrkLogMemoTuDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitWrkLogMemoTuDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitWrkLogMemoTuDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitWrkLogMemoTuDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitWrkLogMemoTuDto) {
			return mapRow_internal((SigitWrkLogMemoTuDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitWrkLogMemoTuDto mapRow_internal(SigitWrkLogMemoTuDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitWrkLogMemoTuDto dto = objectToFill;

		// colonna [ID_LOG_MEMO_PTU]
		if (mapAllColumns || columnsToReadMap.get("ID_LOG_MEMO_PTU") != null)
			dto.setIdLogMemoPtu(rs.getBigDecimal("ID_LOG_MEMO_PTU"));

		// colonna [DT_LOG_MEMO_PTU]
		if (mapAllColumns || columnsToReadMap.get("DT_LOG_MEMO_PTU") != null)
			dto.setDtLogMemoPtu(rs.getTimestamp("DT_LOG_MEMO_PTU"));

		// colonna [NOTE_LOG_MEMO_PTU]
		if (mapAllColumns || columnsToReadMap.get("NOTE_LOG_MEMO_PTU") != null)
			dto.setNoteLogMemoPtu(rs.getString("NOTE_LOG_MEMO_PTU"));

		// colonna [MESSAGGIO_LOG_MEMO_PTU]
		if (mapAllColumns || columnsToReadMap.get("MESSAGGIO_LOG_MEMO_PTU") != null)
			dto.setMessaggioLogMemoPtu(rs.getString("MESSAGGIO_LOG_MEMO_PTU"));

		// colonna [ESITO_LOG_MEMO_PTU]
		if (mapAllColumns || columnsToReadMap.get("ESITO_LOG_MEMO_PTU") != null)
			dto.setEsitoLogMemoPtu(rs.getString("ESITO_LOG_MEMO_PTU"));

		return dto;
	}

}
