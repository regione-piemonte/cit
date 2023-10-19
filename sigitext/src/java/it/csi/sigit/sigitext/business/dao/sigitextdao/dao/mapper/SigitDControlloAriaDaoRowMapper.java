package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDControlloAriaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitDControlloAriaDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDControlloAriaDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDControlloAriaDao
 *
 * @generated
 */
public class SigitDControlloAriaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 *
	 * @generated
	 */
	SigitDControlloAriaDaoImpl dao;

	/**
	 * costruttore
	 *
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *                      incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDControlloAriaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDControlloAriaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDControlloAriaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 *
	 * @param rs
	 * @param row
	 * @return SigitDControlloAriaDto
	 * @throws SQLException
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDControlloAriaDto) {
			return mapRow_internal((SigitDControlloAriaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDControlloAriaDto mapRow_internal(SigitDControlloAriaDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitDControlloAriaDto dto = objectToFill;

		// colonna [ID_CONTROLLO_ARIA]
		if (mapAllColumns || columnsToReadMap.get("ID_CONTROLLO_ARIA") != null)
			dto.setIdControlloAria(rs.getBigDecimal("ID_CONTROLLO_ARIA"));

		// colonna [DESC_CONTROLLO_ARIA]
		if (mapAllColumns || columnsToReadMap.get("DESC_CONTROLLO_ARIA") != null)
			dto.setDescControlloAria(rs.getString("DESC_CONTROLLO_ARIA"));

		return dto;
	}

}
