package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDRuoloDao
 * @generated
 */
public class SigitDRuoloDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDRuoloDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDRuoloDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDRuoloDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDRuoloDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDRuoloDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDRuoloDto) {
			return mapRow_internal((SigitDRuoloDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDRuoloDto mapRow_internal(SigitDRuoloDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitDRuoloDto dto = objectToFill;

		// colonna [ID_RUOLO]
		if (mapAllColumns || columnsToReadMap.get("ID_RUOLO") != null)
			dto.setIdRuolo(rs.getBigDecimal("ID_RUOLO"));

		// colonna [DES_RUOLO]
		if (mapAllColumns || columnsToReadMap.get("DES_RUOLO") != null)
			dto.setDesRuolo(rs.getString("DES_RUOLO"));

		// colonna [RUOLO_FUNZ]
		if (mapAllColumns || columnsToReadMap.get("RUOLO_FUNZ") != null)
			dto.setRuoloFunz(rs.getString("RUOLO_FUNZ"));

		return dto;
	}

}
