package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDTipoAnomaliaDao
 * @generated
 */
public class SigitDTipoAnomaliaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDTipoAnomaliaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDTipoAnomaliaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipoAnomaliaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoAnomaliaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipoAnomaliaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoAnomaliaDto) {
			return mapRow_internal((SigitDTipoAnomaliaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDTipoAnomaliaDto mapRow_internal(SigitDTipoAnomaliaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDTipoAnomaliaDto dto = objectToFill;

		// colonna [ID_TIPO_ANOMALIA]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_ANOMALIA") != null)
			dto.setIdTipoAnomalia((Integer) rs.getObject("ID_TIPO_ANOMALIA"));

		// colonna [DES_TIPO_ANOMALIA]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_ANOMALIA") != null)
			dto.setDesTipoAnomalia(rs.getString("DES_TIPO_ANOMALIA"));

		return dto;
	}

}
