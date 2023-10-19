package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitWrkLogMemoDao
 * @generated
 */
public class SigitWrkLogMemoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitWrkLogMemoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitWrkLogMemoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitWrkLogMemoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitWrkLogMemoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitWrkLogMemoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitWrkLogMemoDto) {
			return mapRow_internal((SigitWrkLogMemoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitWrkLogMemoDto mapRow_internal(SigitWrkLogMemoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitWrkLogMemoDto dto = objectToFill;

		// colonna [ID_LOG_MEMO]
		if (mapAllColumns || columnsToReadMap.get("ID_LOG_MEMO") != null)
			dto.setIdLogMemo(rs.getBigDecimal("ID_LOG_MEMO"));

		// colonna [DT_LOG_MEMO]
		if (mapAllColumns || columnsToReadMap.get("DT_LOG_MEMO") != null)
			dto.setDtLogMemo(rs.getTimestamp("DT_LOG_MEMO"));

		// colonna [DESC_LOG_MEMO]
		if (mapAllColumns || columnsToReadMap.get("DESC_LOG_MEMO") != null)
			dto.setDescLogMemo(rs.getString("DESC_LOG_MEMO"));

		return dto;
	}

}
