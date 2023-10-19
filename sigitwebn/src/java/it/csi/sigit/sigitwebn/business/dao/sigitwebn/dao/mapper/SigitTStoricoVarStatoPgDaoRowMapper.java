package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTStoricoVarStatoPgDao
 * @generated
 */
public class SigitTStoricoVarStatoPgDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTStoricoVarStatoPgDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTStoricoVarStatoPgDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTStoricoVarStatoPgDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTStoricoVarStatoPgDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTStoricoVarStatoPgDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTStoricoVarStatoPgDto) {
			return mapRow_internal((SigitTStoricoVarStatoPgDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTStoricoVarStatoPgDto mapRow_internal(SigitTStoricoVarStatoPgDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTStoricoVarStatoPgDto dto = objectToFill;

		// colonna [DT_EVENTO]
		if (mapAllColumns || columnsToReadMap.get("DT_EVENTO") != null)
			dto.setDtEvento(rs.getTimestamp("DT_EVENTO"));

		// colonna [ID_PERSONA_GIURIDICA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_GIURIDICA") != null)
			dto.setIdPersonaGiuridica(rs.getBigDecimal("ID_PERSONA_GIURIDICA"));

		// colonna [DT_INIZIO_VARIAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_INIZIO_VARIAZIONE") != null)
			dto.setDtInizioVariazione(rs.getDate("DT_INIZIO_VARIAZIONE"));

		// colonna [MOTIVO]
		if (mapAllColumns || columnsToReadMap.get("MOTIVO") != null)
			dto.setMotivo(rs.getString("MOTIVO"));

		// colonna [STATO_PG_DA]
		if (mapAllColumns || columnsToReadMap.get("STATO_PG_DA") != null)
			dto.setStatoPgDa((Integer) rs.getObject("STATO_PG_DA"));

		// colonna [STATO_PG_A]
		if (mapAllColumns || columnsToReadMap.get("STATO_PG_A") != null)
			dto.setStatoPgA((Integer) rs.getObject("STATO_PG_A"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		return dto;
	}

}
