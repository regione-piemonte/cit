package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.*;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.*;
import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDStatoIspezioneDao
 * @generated
 */
public class SigitDStatoIspezioneDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDStatoIspezioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDStatoIspezioneDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDStatoIspezioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDStatoIspezioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDStatoIspezioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDStatoIspezioneDto) {
			return mapRow_internal((SigitDStatoIspezioneDto) dtoInstance, rs);
		}

		return dtoInstance;
	}

	public SigitDStatoIspezioneDto mapRow_internal(SigitDStatoIspezioneDto objectToFill, ResultSet rs) throws SQLException {
		SigitDStatoIspezioneDto dto = objectToFill;

		// colonna [ID_STATO]
		if (mapAllColumns || columnsToReadMap.get("ID_STATO_ISPEZIONE") != null)
			dto.setIdStatoIspezione(rs.getBigDecimal("ID_STATO_ISPEZIONE"));

		// colonna [DES_STATO]
		if (mapAllColumns || columnsToReadMap.get("DES_STATO_ISPEZIONE") != null)
			dto.setDesStatoIspezione(rs.getString("DES_STATO_ISPEZIONE"));

		return dto;
	}

}
