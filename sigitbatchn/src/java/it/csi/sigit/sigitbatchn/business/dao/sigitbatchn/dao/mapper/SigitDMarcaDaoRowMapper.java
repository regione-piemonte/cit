package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDMarcaDao
 * @generated
 */
public class SigitDMarcaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDMarcaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDMarcaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDMarcaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDMarcaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDMarcaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDMarcaDto) {
			return mapRow_internal((SigitDMarcaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDMarcaDto mapRow_internal(SigitDMarcaDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitDMarcaDto dto = objectToFill;

		// colonna [ID_MARCA]
		if (mapAllColumns || columnsToReadMap.get("ID_MARCA") != null)
			dto.setIdMarca(rs.getBigDecimal("ID_MARCA"));

		// colonna [DES_MARCA]
		if (mapAllColumns || columnsToReadMap.get("DES_MARCA") != null)
			dto.setDesMarca(rs.getString("DES_MARCA"));

		return dto;
	}

}
