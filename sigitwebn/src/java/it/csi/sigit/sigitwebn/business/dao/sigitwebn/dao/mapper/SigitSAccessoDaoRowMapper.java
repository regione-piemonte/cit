package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitSAccessoDao
 * @generated
 */
public class SigitSAccessoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitSAccessoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitSAccessoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitSAccessoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitSAccessoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitSAccessoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitSAccessoDto) {
			return mapRow_internal((SigitSAccessoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitSAccessoDto mapRow_internal(SigitSAccessoDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitSAccessoDto dto = objectToFill;

		// colonna [DT_ACCESSO]
		if (mapAllColumns || columnsToReadMap.get("DT_ACCESSO") != null)
			dto.setDtAccesso(rs.getTimestamp("DT_ACCESSO"));

		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodiceFiscale(rs.getString("CODICE_FISCALE"));

		// colonna [NOME]
		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("NOME"));

		// colonna [COGNOME]
		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("COGNOME"));

		// colonna [RUOLO]
		if (mapAllColumns || columnsToReadMap.get("RUOLO") != null)
			dto.setRuolo(rs.getString("RUOLO"));

		return dto;
	}

}
