package it.csi.sigit.sigitweba.business.dao.sigitweba.dao.mapper;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDDmDao
 * @generated
 */
public class SigitDDmDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDDmDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDDmDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDDmDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDDmDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDDmDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDDmDto) {
			return mapRow_internal((SigitDDmDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDDmDto mapRow_internal(SigitDDmDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitDDmDto dto = objectToFill;

		// colonna [TIPO_DM37_2008]
		if (mapAllColumns || columnsToReadMap.get("TIPO_DM37_2008") != null)
			dto.setTipoDm372008(rs.getString("TIPO_DM37_2008"));

		// colonna [DES_TIPO_DM37_2008]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_DM37_2008") != null)
			dto.setDesTipoDm372008(rs.getString("DES_TIPO_DM37_2008"));

		return dto;
	}

}
