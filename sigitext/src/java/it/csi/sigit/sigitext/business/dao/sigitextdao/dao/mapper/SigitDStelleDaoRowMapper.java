package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDStelleDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitDStelleDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDStelleDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDStelleDao
 * @generated
 */
public class SigitDStelleDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDStelleDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDStelleDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDStelleDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDStelleDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDStelleDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDStelleDto) {
			return mapRow_internal((SigitDStelleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDStelleDto mapRow_internal(SigitDStelleDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitDStelleDto dto = objectToFill;

		// colonna [ID_STELLE]
		if (mapAllColumns || columnsToReadMap.get("ID_STELLE") != null)
			dto.setIdStelle(rs.getBigDecimal("ID_STELLE"));

		// colonna [DESC_STELLE]
		if (mapAllColumns || columnsToReadMap.get("DESC_STELLE") != null)
			dto.setDescStelle(rs.getString("DESC_STELLE"));

		return dto;
	}

}
