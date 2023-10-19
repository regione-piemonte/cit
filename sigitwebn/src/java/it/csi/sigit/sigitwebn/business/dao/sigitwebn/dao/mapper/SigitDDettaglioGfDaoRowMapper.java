package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDDettaglioGfDao
 * @generated
 */
public class SigitDDettaglioGfDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDDettaglioGfDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDDettaglioGfDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDDettaglioGfDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDDettaglioGfDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDDettaglioGfDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDDettaglioGfDto) {
			return mapRow_internal((SigitDDettaglioGfDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDDettaglioGfDto mapRow_internal(SigitDDettaglioGfDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDDettaglioGfDto dto = objectToFill;

		// colonna [ID_DETTAGLIO_GF]
		if (mapAllColumns || columnsToReadMap.get("ID_DETTAGLIO_GF") != null)
			dto.setIdDettaglioGf(rs.getBigDecimal("ID_DETTAGLIO_GF"));

		// colonna [DES_DETTAGLIO_GF]
		if (mapAllColumns || columnsToReadMap.get("DES_DETTAGLIO_GF") != null)
			dto.setDesDettaglioGf(rs.getString("DES_DETTAGLIO_GF"));

		return dto;
	}

}
