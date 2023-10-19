package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDCategoriaUtilDao
 * @generated
 */
public class SigitDCategoriaUtilDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDCategoriaUtilDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDCategoriaUtilDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDCategoriaUtilDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDCategoriaUtilDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDCategoriaUtilDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDCategoriaUtilDto) {
			return mapRow_internal((SigitDCategoriaUtilDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDCategoriaUtilDto mapRow_internal(SigitDCategoriaUtilDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDCategoriaUtilDto dto = objectToFill;

		// colonna [ID_CATEGORIA_UTIL]
		if (mapAllColumns || columnsToReadMap.get("ID_CATEGORIA_UTIL") != null)
			dto.setIdCategoriaUtil(rs.getString("ID_CATEGORIA_UTIL"));

		// colonna [DES_CATEGORIA_UTIL]
		if (mapAllColumns || columnsToReadMap.get("DES_CATEGORIA_UTIL") != null)
			dto.setDesCategoriaUtil(rs.getString("DES_CATEGORIA_UTIL"));

		return dto;
	}

}
