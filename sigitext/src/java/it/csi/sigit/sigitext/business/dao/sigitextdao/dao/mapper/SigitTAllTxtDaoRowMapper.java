package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;


import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAllTxtDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTAllTxtDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllTxtDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTAllTxtDao
 * @generated
 */
public class SigitTAllTxtDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTAllTxtDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTAllTxtDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTAllTxtDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTAllTxtDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTAllTxtDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTAllTxtDto) {
			return mapRow_internal((SigitTAllTxtDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTAllTxtDto mapRow_internal(SigitTAllTxtDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitTAllTxtDto dto = objectToFill;

		// colonna [ID_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("ID_ALLEGATO") != null)
			dto.setIdAllegato(rs.getBigDecimal("ID_ALLEGATO"));

		// colonna [XML_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("XML_ALLEGATO") != null)
			dto.setXmlAllegato(rs.getString("XML_ALLEGATO"));

		return dto;
	}

}
