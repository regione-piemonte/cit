package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.*;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.*;
import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDStatoImpiantoDao
 * @generated
 */
public class SigitDStatoImpiantoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDStatoImpiantoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDStatoImpiantoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDStatoImpiantoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDStatoImpiantoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDStatoImpiantoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDStatoImpiantoDto) {
			return mapRow_internal((SigitDStatoImpiantoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDStatoImpiantoDto mapRow_internal(SigitDStatoImpiantoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDStatoImpiantoDto dto = objectToFill;

		// colonna [ID_STATO]
		if (mapAllColumns || columnsToReadMap.get("ID_STATO") != null)
			dto.setIdStato(rs.getBigDecimal("ID_STATO"));

		// colonna [DES_STATO]
		if (mapAllColumns || columnsToReadMap.get("DES_STATO") != null)
			dto.setDesStato(rs.getString("DES_STATO"));

		return dto;
	}

}
