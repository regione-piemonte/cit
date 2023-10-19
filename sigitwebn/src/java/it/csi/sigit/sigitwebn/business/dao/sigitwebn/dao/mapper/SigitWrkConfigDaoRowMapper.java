package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitWrkConfigDao
 * @generated
 */
public class SigitWrkConfigDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitWrkConfigDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitWrkConfigDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitWrkConfigDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitWrkConfigDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitWrkConfigDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitWrkConfigDto) {
			return mapRow_internal((SigitWrkConfigDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitWrkConfigDto mapRow_internal(SigitWrkConfigDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitWrkConfigDto dto = objectToFill;

		// colonna [ID_CONFIG]
		if (mapAllColumns || columnsToReadMap.get("ID_CONFIG") != null)
			dto.setIdConfig(rs.getBigDecimal("ID_CONFIG"));

		// colonna [CHIAVE_CONFIG]
		if (mapAllColumns || columnsToReadMap.get("CHIAVE_CONFIG") != null)
			dto.setChiaveConfig(rs.getString("CHIAVE_CONFIG"));

		// colonna [VALORE_CONFIG_NUM]
		if (mapAllColumns || columnsToReadMap.get("VALORE_CONFIG_NUM") != null)
			dto.setValoreConfigNum(rs.getBigDecimal("VALORE_CONFIG_NUM"));

		// colonna [VALORE_CONFIG_CHAR]
		if (mapAllColumns || columnsToReadMap.get("VALORE_CONFIG_CHAR") != null)
			dto.setValoreConfigChar(rs.getString("VALORE_CONFIG_CHAR"));

		// colonna [VALORE_FLAG]
		if (mapAllColumns || columnsToReadMap.get("VALORE_FLAG") != null)
			dto.setValoreFlag(rs.getString("VALORE_FLAG"));

		return dto;
	}

}
