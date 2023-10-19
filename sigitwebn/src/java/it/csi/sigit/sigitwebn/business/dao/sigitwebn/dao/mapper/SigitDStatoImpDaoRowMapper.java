package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDStatoImpDao
 * @generated
 */
public class SigitDStatoImpDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDStatoImpDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDStatoImpDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDStatoImpDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDStatoImpDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDStatoImpDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDStatoImpDto) {
			return mapRow_internal((SigitDStatoImpDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDStatoImpDto mapRow_internal(SigitDStatoImpDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDStatoImpDto dto = objectToFill;

		// colonna [ID_STATO]
		if (mapAllColumns || columnsToReadMap.get("ID_STATO") != null)
			dto.setIdStato(rs.getBigDecimal("ID_STATO"));

		// colonna [DES_STATO]
		if (mapAllColumns || columnsToReadMap.get("DES_STATO") != null)
			dto.setDesStato(rs.getString("DES_STATO"));

		return dto;
	}

}
