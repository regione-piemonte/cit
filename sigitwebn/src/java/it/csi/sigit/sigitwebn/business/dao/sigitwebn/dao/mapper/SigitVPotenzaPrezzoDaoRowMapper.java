package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitVPotenzaPrezzoDao
 * @generated
 */
public class SigitVPotenzaPrezzoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitVPotenzaPrezzoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitVPotenzaPrezzoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitVPotenzaPrezzoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitVPotenzaPrezzoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVPotenzaPrezzoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitVPotenzaPrezzoDto) {
			return mapRow_internal((SigitVPotenzaPrezzoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitVPotenzaPrezzoDto mapRow_internal(SigitVPotenzaPrezzoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitVPotenzaPrezzoDto dto = objectToFill;

		// colonna [ID_POTENZA]
		if (mapAllColumns || columnsToReadMap.get("ID_POTENZA") != null)
			dto.setIdPotenza(rs.getBigDecimal("ID_POTENZA"));

		// colonna [DES_POTENZA]
		if (mapAllColumns || columnsToReadMap.get("DES_POTENZA") != null)
			dto.setDesPotenza(rs.getString("DES_POTENZA"));

		// colonna [LIMITE_INFERIORE]
		if (mapAllColumns || columnsToReadMap.get("LIMITE_INFERIORE") != null)
			dto.setLimiteInferiore(rs.getBigDecimal("LIMITE_INFERIORE"));

		// colonna [LIMITE_SUPERIORE]
		if (mapAllColumns || columnsToReadMap.get("LIMITE_SUPERIORE") != null)
			dto.setLimiteSuperiore(rs.getBigDecimal("LIMITE_SUPERIORE"));

		// colonna [ID_PREZZO]
		if (mapAllColumns || columnsToReadMap.get("ID_PREZZO") != null)
			dto.setIdPrezzo(rs.getBigDecimal("ID_PREZZO"));

		// colonna [PREZZO]
		if (mapAllColumns || columnsToReadMap.get("PREZZO") != null)
			dto.setPrezzo(rs.getBigDecimal("PREZZO"));

		// colonna [DT_INIZIO]
		if (mapAllColumns || columnsToReadMap.get("DT_INIZIO") != null)
			dto.setDtInizio(rs.getDate("DT_INIZIO"));

		// colonna [DT_FINE]
		if (mapAllColumns || columnsToReadMap.get("DT_FINE") != null)
			dto.setDtFine(rs.getDate("DT_FINE"));

		return dto;
	}

}
