package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDStatoSanzioneDao
 * @generated
 */
public class SigitDStatoSanzioneDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDStatoSanzioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDStatoSanzioneDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDStatoSanzioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDStatoSanzioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDStatoSanzioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDStatoSanzioneDto) {
			return mapRow_internal((SigitDStatoSanzioneDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDStatoSanzioneDto mapRow_internal(SigitDStatoSanzioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDStatoSanzioneDto dto = objectToFill;

		// colonna [ID_STATO_SANZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_STATO_SANZIONE") != null)
			dto.setIdStatoSanzione((Integer) rs.getObject("ID_STATO_SANZIONE"));

		// colonna [DES_STATO_SANZIONE]
		if (mapAllColumns || columnsToReadMap.get("DES_STATO_SANZIONE") != null)
			dto.setDesStatoSanzione(rs.getString("DES_STATO_SANZIONE"));

		return dto;
	}

}
