package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDDettaglioGtDao
 * @generated
 */
public class SigitDDettaglioGtDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDDettaglioGtDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDDettaglioGtDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDDettaglioGtDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDDettaglioGtDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDDettaglioGtDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDDettaglioGtDto) {
			return mapRow_internal((SigitDDettaglioGtDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDDettaglioGtDto mapRow_internal(SigitDDettaglioGtDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDDettaglioGtDto dto = objectToFill;

		// colonna [ID_DETTAGLIO_GT]
		if (mapAllColumns || columnsToReadMap.get("ID_DETTAGLIO_GT") != null)
			dto.setIdDettaglioGt(rs.getBigDecimal("ID_DETTAGLIO_GT"));

		// colonna [DES_DETTAGLIO_GT]
		if (mapAllColumns || columnsToReadMap.get("DES_DETTAGLIO_GT") != null)
			dto.setDesDettaglioGt(rs.getString("DES_DETTAGLIO_GT"));

		return dto;
	}

}
