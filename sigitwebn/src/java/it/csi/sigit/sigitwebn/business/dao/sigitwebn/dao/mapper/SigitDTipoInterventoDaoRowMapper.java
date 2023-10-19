package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDTipoInterventoDao
 * @generated
 */
public class SigitDTipoInterventoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDTipoInterventoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDTipoInterventoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipoInterventoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoInterventoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipoInterventoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoInterventoDto) {
			return mapRow_internal((SigitDTipoInterventoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDTipoInterventoDto mapRow_internal(SigitDTipoInterventoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDTipoInterventoDto dto = objectToFill;

		// colonna [ID_TIPO_INTERVENTO]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_INTERVENTO") != null)
			dto.setIdTipoIntervento(rs.getBigDecimal("ID_TIPO_INTERVENTO"));

		// colonna [DES_TIPO_INTERVENTO]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_INTERVENTO") != null)
			dto.setDesTipoIntervento(rs.getString("DES_TIPO_INTERVENTO"));

		return dto;
	}

}
