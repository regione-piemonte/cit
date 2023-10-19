package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTRifCatastDao
 * @generated
 */
public class SigitTRifCatastDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTRifCatastDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTRifCatastDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTRifCatastDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTRifCatastDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTRifCatastDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTRifCatastDto) {
			return mapRow_internal((SigitTRifCatastDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTRifCatastDto mapRow_internal(SigitTRifCatastDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTRifCatastDto dto = objectToFill;

		// colonna [ID_RIF_CATAST]
		if (mapAllColumns || columnsToReadMap.get("ID_RIF_CATAST") != null)
			dto.setIdRifCatast((Integer) rs.getObject("ID_RIF_CATAST"));

		// colonna [FK_DATO_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("FK_DATO_DISTRIB") != null)
			dto.setFkDatoDistrib((Integer) rs.getObject("FK_DATO_DISTRIB"));

		// colonna [SEZIONE]
		if (mapAllColumns || columnsToReadMap.get("SEZIONE") != null)
			dto.setSezione(rs.getString("SEZIONE"));

		// colonna [FOGLIO]
		if (mapAllColumns || columnsToReadMap.get("FOGLIO") != null)
			dto.setFoglio(rs.getString("FOGLIO"));

		// colonna [PARTICELLA]
		if (mapAllColumns || columnsToReadMap.get("PARTICELLA") != null)
			dto.setParticella(rs.getString("PARTICELLA"));

		// colonna [SUBALTERNO]
		if (mapAllColumns || columnsToReadMap.get("SUBALTERNO") != null)
			dto.setSubalterno(rs.getString("SUBALTERNO"));

		return dto;
	}

}
