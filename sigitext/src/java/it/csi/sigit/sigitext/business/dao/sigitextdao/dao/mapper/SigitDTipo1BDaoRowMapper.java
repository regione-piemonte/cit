package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDTipo1BDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitDTipo1BDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipo1BDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDTipo1BDao
 * @generated
 */
public class SigitDTipo1BDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDTipo1BDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDTipo1BDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipo1BDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipo1BDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipo1BDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipo1BDto) {
			return mapRow_internal((SigitDTipo1BDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDTipo1BDto mapRow_internal(SigitDTipo1BDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitDTipo1BDto dto = objectToFill;

		// colonna [ID_TIPO_1B]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_1B") != null)
			dto.setIdTipo1b(rs.getBigDecimal("ID_TIPO_1B"));

		// colonna [DESC_TIPO_1B]
		if (mapAllColumns || columnsToReadMap.get("DESC_TIPO_1B") != null)
			dto.setDescTipo1b(rs.getString("DESC_TIPO_1B"));

		return dto;
	}

}
