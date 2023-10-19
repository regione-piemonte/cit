package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDTipoConclusioneDao
 * @generated
 */
public class SigitDTipoConclusioneDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDTipoConclusioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDTipoConclusioneDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipoConclusioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoConclusioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipoConclusioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoConclusioneDto) {
			return mapRow_internal((SigitDTipoConclusioneDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDTipoConclusioneDto mapRow_internal(SigitDTipoConclusioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDTipoConclusioneDto dto = objectToFill;

		// colonna [ID_TIPO_CONCLUSIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CONCLUSIONE") != null)
			dto.setIdTipoConclusione((Integer) rs.getObject("ID_TIPO_CONCLUSIONE"));

		// colonna [DES_TIPO_CONCLUSIONE]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_CONCLUSIONE") != null)
			dto.setDesTipoConclusione(rs.getString("DES_TIPO_CONCLUSIONE"));

		return dto;
	}

}
