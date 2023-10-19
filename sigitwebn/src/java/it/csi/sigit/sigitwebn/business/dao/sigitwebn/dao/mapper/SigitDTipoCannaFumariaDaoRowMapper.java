package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDTipoCannaFumariaDao
 * @generated
 */
public class SigitDTipoCannaFumariaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDTipoCannaFumariaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDTipoCannaFumariaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipoCannaFumariaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoCannaFumariaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipoCannaFumariaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoCannaFumariaDto) {
			return mapRow_internal((SigitDTipoCannaFumariaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDTipoCannaFumariaDto mapRow_internal(SigitDTipoCannaFumariaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDTipoCannaFumariaDto dto = objectToFill;

		// colonna [ID_TIPO_CANNA_FUMARIA]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CANNA_FUMARIA") != null)
			dto.setIdTipoCannaFumaria(rs.getBigDecimal("ID_TIPO_CANNA_FUMARIA"));

		// colonna [DESC_TIPO_CANNA_FUMARIA]
		if (mapAllColumns || columnsToReadMap.get("DESC_TIPO_CANNA_FUMARIA") != null)
			dto.setDescTipoCannaFumaria(rs.getString("DESC_TIPO_CANNA_FUMARIA"));

		return dto;
	}

}
