package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDTipoComponenteDao
 * @generated
 */
public class SigitDTipoComponenteDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDTipoComponenteDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDTipoComponenteDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipoComponenteDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoComponenteDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipoComponenteDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoComponenteDto) {
			return mapRow_internal((SigitDTipoComponenteDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDTipoComponenteDto mapRow_internal(SigitDTipoComponenteDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDTipoComponenteDto dto = objectToFill;

		// colonna [ID_TIPO_COMPONENTE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_COMPONENTE") != null)
			dto.setIdTipoComponente(rs.getString("ID_TIPO_COMPONENTE"));

		// colonna [DES_TIPO_COMPONENTE]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_COMPONENTE") != null)
			dto.setDesTipoComponente(rs.getString("DES_TIPO_COMPONENTE"));

		// colonna [FLG_VISUALIZZA]
		if (mapAllColumns || columnsToReadMap.get("FLG_VISUALIZZA") != null)
			dto.setFlgVisualizza(rs.getBigDecimal("FLG_VISUALIZZA"));

		return dto;
	}

}
