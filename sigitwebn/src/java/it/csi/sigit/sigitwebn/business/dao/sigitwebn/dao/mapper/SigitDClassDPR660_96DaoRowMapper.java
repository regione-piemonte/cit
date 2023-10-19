package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDClassDPR660_96Dao
 * @generated
 */
public class SigitDClassDPR660_96DaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDClassDPR660_96DaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDClassDPR660_96DaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDClassDPR660_96Dao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDClassDPR660_96DaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDClassDPR660_96Dto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDClassDPR660_96Dto) {
			return mapRow_internal((SigitDClassDPR660_96Dto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDClassDPR660_96Dto mapRow_internal(SigitDClassDPR660_96Dto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDClassDPR660_96Dto dto = objectToFill;

		// colonna [ID_CLASS]
		if (mapAllColumns || columnsToReadMap.get("ID_CLASS") != null)
			dto.setIdClass(rs.getString("ID_CLASS"));

		// colonna [DES_CLASS]
		if (mapAllColumns || columnsToReadMap.get("DES_CLASS") != null)
			dto.setDesClass(rs.getString("DES_CLASS"));

		return dto;
	}

}
