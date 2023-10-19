package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDStatoRappDao
 * @generated
 */
public class SigitDStatoRappDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDStatoRappDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDStatoRappDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDStatoRappDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDStatoRappDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDStatoRappDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDStatoRappDto) {
			return mapRow_internal((SigitDStatoRappDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDStatoRappDto mapRow_internal(SigitDStatoRappDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDStatoRappDto dto = objectToFill;

		// colonna [ID_STATO_RAPP]
		if (mapAllColumns || columnsToReadMap.get("ID_STATO_RAPP") != null)
			dto.setIdStatoRapp(rs.getBigDecimal("ID_STATO_RAPP"));

		// colonna [DES_STATO_RAPP]
		if (mapAllColumns || columnsToReadMap.get("DES_STATO_RAPP") != null)
			dto.setDesStatoRapp(rs.getString("DES_STATO_RAPP"));

		return dto;
	}

}
