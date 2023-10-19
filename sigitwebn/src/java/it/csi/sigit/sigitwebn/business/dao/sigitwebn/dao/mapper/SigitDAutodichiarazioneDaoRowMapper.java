package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDAutodichiarazioneDao
 * @generated
 */
public class SigitDAutodichiarazioneDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDAutodichiarazioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDAutodichiarazioneDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDAutodichiarazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDAutodichiarazioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDAutodichiarazioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDAutodichiarazioneDto) {
			return mapRow_internal((SigitDAutodichiarazioneDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDAutodichiarazioneDto mapRow_internal(SigitDAutodichiarazioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDAutodichiarazioneDto dto = objectToFill;

		// colonna [ID_AUTODICHIARAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_AUTODICHIARAZIONE") != null)
			dto.setIdAutodichiarazione((Integer) rs.getObject("ID_AUTODICHIARAZIONE"));

		// colonna [DES_AUTODICHIARAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DES_AUTODICHIARAZIONE") != null)
			dto.setDesAutodichiarazione(rs.getString("DES_AUTODICHIARAZIONE"));

		return dto;
	}

}
