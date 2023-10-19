package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDFluidoDao
 * @generated
 */
public class SigitDFluidoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDFluidoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDFluidoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDFluidoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDFluidoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDFluidoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDFluidoDto) {
			return mapRow_internal((SigitDFluidoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDFluidoDto mapRow_internal(SigitDFluidoDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitDFluidoDto dto = objectToFill;

		// colonna [ID_FLUIDO]
		if (mapAllColumns || columnsToReadMap.get("ID_FLUIDO") != null)
			dto.setIdFluido(rs.getBigDecimal("ID_FLUIDO"));

		// colonna [DES_FLUIDO]
		if (mapAllColumns || columnsToReadMap.get("DES_FLUIDO") != null)
			dto.setDesFluido(rs.getString("DES_FLUIDO"));

		return dto;
	}

}
