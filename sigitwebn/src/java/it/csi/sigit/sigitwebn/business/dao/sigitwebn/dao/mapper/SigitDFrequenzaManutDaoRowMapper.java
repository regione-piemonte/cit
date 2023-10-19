package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDFrequenzaManutDao
 * @generated
 */
public class SigitDFrequenzaManutDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDFrequenzaManutDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDFrequenzaManutDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDFrequenzaManutDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDFrequenzaManutDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDFrequenzaManutDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDFrequenzaManutDto) {
			return mapRow_internal((SigitDFrequenzaManutDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDFrequenzaManutDto mapRow_internal(SigitDFrequenzaManutDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDFrequenzaManutDto dto = objectToFill;

		// colonna [ID_FREQUENZA]
		if (mapAllColumns || columnsToReadMap.get("ID_FREQUENZA") != null)
			dto.setIdFrequenza((Integer) rs.getObject("ID_FREQUENZA"));

		// colonna [DES_FREQUENZA]
		if (mapAllColumns || columnsToReadMap.get("DES_FREQUENZA") != null)
			dto.setDesFrequenza(rs.getString("DES_FREQUENZA"));

		return dto;
	}

}
