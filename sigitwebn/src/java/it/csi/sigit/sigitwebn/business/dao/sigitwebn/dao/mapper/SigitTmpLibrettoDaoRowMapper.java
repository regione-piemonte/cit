package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTmpLibrettoDao
 * @generated
 */
public class SigitTmpLibrettoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTmpLibrettoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTmpLibrettoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTmpLibrettoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTmpLibrettoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTmpLibrettoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTmpLibrettoDto) {
			return mapRow_internal((SigitTmpLibrettoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTmpLibrettoDto mapRow_internal(SigitTmpLibrettoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTmpLibrettoDto dto = objectToFill;

		// colonna [ID_LIBRETTO]
		if (mapAllColumns || columnsToReadMap.get("ID_LIBRETTO") != null)
			dto.setIdLibretto(rs.getBigDecimal("ID_LIBRETTO"));

		// colonna [FLG_ELABORATO]
		if (mapAllColumns || columnsToReadMap.get("FLG_ELABORATO") != null)
			dto.setFlgElaborato(rs.getBigDecimal("FLG_ELABORATO"));

		// colonna [FLG_ESITO_ELAB]
		if (mapAllColumns || columnsToReadMap.get("FLG_ESITO_ELAB") != null)
			dto.setFlgEsitoElab(rs.getBigDecimal("FLG_ESITO_ELAB"));

		// colonna [DATA_ELAB]
		if (mapAllColumns || columnsToReadMap.get("DATA_ELAB") != null)
			dto.setDataElab(rs.getTimestamp("DATA_ELAB"));

		return dto;
	}

}
