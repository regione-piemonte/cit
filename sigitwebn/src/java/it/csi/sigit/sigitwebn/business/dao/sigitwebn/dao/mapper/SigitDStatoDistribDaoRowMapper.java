package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDStatoDistribDao
 * @generated
 */
public class SigitDStatoDistribDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDStatoDistribDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDStatoDistribDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDStatoDistribDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDStatoDistribDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDStatoDistribDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDStatoDistribDto) {
			return mapRow_internal((SigitDStatoDistribDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDStatoDistribDto mapRow_internal(SigitDStatoDistribDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDStatoDistribDto dto = objectToFill;

		// colonna [ID_STATO_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("ID_STATO_DISTRIB") != null)
			dto.setIdStatoDistrib((Integer) rs.getObject("ID_STATO_DISTRIB"));

		// colonna [DES_STATO_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("DES_STATO_DISTRIB") != null)
			dto.setDesStatoDistrib(rs.getString("DES_STATO_DISTRIB"));

		return dto;
	}

}
