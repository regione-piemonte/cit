package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDRuoloAccredDao
 * @generated
 */
public class SigitDRuoloAccredDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDRuoloAccredDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDRuoloAccredDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDRuoloAccredDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDRuoloAccredDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDRuoloAccredDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDRuoloAccredDto) {
			return mapRow_internal((SigitDRuoloAccredDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDRuoloAccredDto mapRow_internal(SigitDRuoloAccredDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDRuoloAccredDto dto = objectToFill;

		// colonna [ID_RUOLO_ACCRED]
		if (mapAllColumns || columnsToReadMap.get("ID_RUOLO_ACCRED") != null)
			dto.setIdRuoloAccred(rs.getBigDecimal("ID_RUOLO_ACCRED"));

		// colonna [DES_RUOLO_ACCRED]
		if (mapAllColumns || columnsToReadMap.get("DES_RUOLO_ACCRED") != null)
			dto.setDesRuoloAccred(rs.getString("DES_RUOLO_ACCRED"));

		return dto;
	}

}
