package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDAriaComburenteDao
 * @generated
 */
public class SigitDAriaComburenteDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDAriaComburenteDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDAriaComburenteDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDAriaComburenteDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDAriaComburenteDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDAriaComburenteDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDAriaComburenteDto) {
			return mapRow_internal((SigitDAriaComburenteDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDAriaComburenteDto mapRow_internal(SigitDAriaComburenteDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDAriaComburenteDto dto = objectToFill;

		// colonna [ID_ARIA_COMBURENTE]
		if (mapAllColumns || columnsToReadMap.get("ID_ARIA_COMBURENTE") != null)
			dto.setIdAriaComburente(rs.getBigDecimal("ID_ARIA_COMBURENTE"));

		// colonna [DESC_ARIA_COMBURENTE]
		if (mapAllColumns || columnsToReadMap.get("DESC_ARIA_COMBURENTE") != null)
			dto.setDescAriaComburente(rs.getString("DESC_ARIA_COMBURENTE"));

		return dto;
	}

}
