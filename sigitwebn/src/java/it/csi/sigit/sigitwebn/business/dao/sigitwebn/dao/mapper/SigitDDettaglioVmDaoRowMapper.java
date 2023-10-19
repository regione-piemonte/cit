package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDDettaglioVmDao
 * @generated
 */
public class SigitDDettaglioVmDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDDettaglioVmDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDDettaglioVmDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDDettaglioVmDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDDettaglioVmDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDDettaglioVmDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDDettaglioVmDto) {
			return mapRow_internal((SigitDDettaglioVmDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDDettaglioVmDto mapRow_internal(SigitDDettaglioVmDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDDettaglioVmDto dto = objectToFill;

		// colonna [ID_DETTAGLIO_VM]
		if (mapAllColumns || columnsToReadMap.get("ID_DETTAGLIO_VM") != null)
			dto.setIdDettaglioVm(rs.getBigDecimal("ID_DETTAGLIO_VM"));

		// colonna [DES_DETTAGLIO_VM]
		if (mapAllColumns || columnsToReadMap.get("DES_DETTAGLIO_VM") != null)
			dto.setDesDettaglioVm(rs.getString("DES_DETTAGLIO_VM"));

		return dto;
	}

}
