package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDUnitaMisuraDao
 * @generated
 */
public class SigitDUnitaMisuraDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDUnitaMisuraDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDUnitaMisuraDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDUnitaMisuraDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDUnitaMisuraDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDUnitaMisuraDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDUnitaMisuraDto) {
			return mapRow_internal((SigitDUnitaMisuraDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDUnitaMisuraDto mapRow_internal(SigitDUnitaMisuraDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDUnitaMisuraDto dto = objectToFill;

		// colonna [ID_UNITA_MISURA]
		if (mapAllColumns || columnsToReadMap.get("ID_UNITA_MISURA") != null)
			dto.setIdUnitaMisura(rs.getString("ID_UNITA_MISURA"));

		// colonna [DES_UNITA_MISURA]
		if (mapAllColumns || columnsToReadMap.get("DES_UNITA_MISURA") != null)
			dto.setDesUnitaMisura(rs.getString("DES_UNITA_MISURA"));

		return dto;
	}

}
