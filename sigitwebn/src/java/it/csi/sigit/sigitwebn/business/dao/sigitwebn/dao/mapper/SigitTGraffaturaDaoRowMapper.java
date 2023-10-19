package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTGraffaturaDao
 * @generated
 */
public class SigitTGraffaturaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTGraffaturaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTGraffaturaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTGraffaturaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTGraffaturaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTGraffaturaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTGraffaturaDto) {
			return mapRow_internal((SigitTGraffaturaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTGraffaturaDto mapRow_internal(SigitTGraffaturaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTGraffaturaDto dto = objectToFill;

		// colonna [ID_GRAFFATURA]
		if (mapAllColumns || columnsToReadMap.get("ID_GRAFFATURA") != null)
			dto.setIdGraffatura(rs.getBigDecimal("ID_GRAFFATURA"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [DT_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DT_INSERIMENTO") != null)
			dto.setDtInserimento(rs.getTimestamp("DT_INSERIMENTO"));

		// colonna [DT_CANCELLAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_CANCELLAZIONE") != null)
			dto.setDtCancellazione(rs.getTimestamp("DT_CANCELLAZIONE"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		return dto;
	}

}
