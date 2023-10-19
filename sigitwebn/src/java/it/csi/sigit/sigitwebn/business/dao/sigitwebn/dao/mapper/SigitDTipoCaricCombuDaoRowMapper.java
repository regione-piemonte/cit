package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDTipoCaricCombuDao
 * @generated
 */
public class SigitDTipoCaricCombuDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDTipoCaricCombuDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDTipoCaricCombuDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipoCaricCombuDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoCaricCombuDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipoCaricCombuDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoCaricCombuDto) {
			return mapRow_internal((SigitDTipoCaricCombuDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDTipoCaricCombuDto mapRow_internal(SigitDTipoCaricCombuDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDTipoCaricCombuDto dto = objectToFill;

		// colonna [ID_TIPO_CARIC_COMBU]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CARIC_COMBU") != null)
			dto.setIdTipoCaricCombu(rs.getBigDecimal("ID_TIPO_CARIC_COMBU"));

		// colonna [DESC_TIPO_CARIC_COMBU]
		if (mapAllColumns || columnsToReadMap.get("DESC_TIPO_CARIC_COMBU") != null)
			dto.setDescTipoCaricCombu(rs.getString("DESC_TIPO_CARIC_COMBU"));

		return dto;
	}

}
