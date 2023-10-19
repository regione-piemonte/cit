package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDRuoloPaDao
 * @generated
 */
public class SigitDRuoloPaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDRuoloPaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDRuoloPaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDRuoloPaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDRuoloPaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDRuoloPaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDRuoloPaDto) {
			return mapRow_internal((SigitDRuoloPaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDRuoloPaDto mapRow_internal(SigitDRuoloPaDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitDRuoloPaDto dto = objectToFill;

		// colonna [ID_RUOLO_PA]
		if (mapAllColumns || columnsToReadMap.get("ID_RUOLO_PA") != null)
			dto.setIdRuoloPa((Integer) rs.getObject("ID_RUOLO_PA"));

		// colonna [DES_RUOLO_PA]
		if (mapAllColumns || columnsToReadMap.get("DES_RUOLO_PA") != null)
			dto.setDesRuoloPa(rs.getString("DES_RUOLO_PA"));

		return dto;
	}

}
