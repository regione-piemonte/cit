package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitRRuoloTipodocDao
 * @generated
 */
public class SigitRRuoloTipodocDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitRRuoloTipodocDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitRRuoloTipodocDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitRRuoloTipodocDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitRRuoloTipodocDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRRuoloTipodocDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitRRuoloTipodocDto) {
			return mapRow_internal((SigitRRuoloTipodocDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitRRuoloTipodocDto mapRow_internal(SigitRRuoloTipodocDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitRRuoloTipodocDto dto = objectToFill;

		// colonna [ID_RUOLO]
		if (mapAllColumns || columnsToReadMap.get("ID_RUOLO") != null)
			dto.setIdRuolo(rs.getBigDecimal("ID_RUOLO"));

		// colonna [ID_TIPO_DOCUMENTO]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_DOCUMENTO") != null)
			dto.setIdTipoDocumento(rs.getBigDecimal("ID_TIPO_DOCUMENTO"));

		return dto;
	}

}
