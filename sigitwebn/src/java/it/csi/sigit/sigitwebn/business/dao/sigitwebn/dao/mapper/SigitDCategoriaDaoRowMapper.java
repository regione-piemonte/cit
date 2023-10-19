package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDCategoriaDao
 * @generated
 */
public class SigitDCategoriaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDCategoriaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDCategoriaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDCategoriaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDCategoriaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDCategoriaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDCategoriaDto) {
			return mapRow_internal((SigitDCategoriaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDCategoriaDto mapRow_internal(SigitDCategoriaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDCategoriaDto dto = objectToFill;

		// colonna [ID_CATEGORIA]
		if (mapAllColumns || columnsToReadMap.get("ID_CATEGORIA") != null)
			dto.setIdCategoria(rs.getString("ID_CATEGORIA"));

		// colonna [DES_CATEGORIA]
		if (mapAllColumns || columnsToReadMap.get("DES_CATEGORIA") != null)
			dto.setDesCategoria(rs.getString("DES_CATEGORIA"));

		return dto;
	}

}
