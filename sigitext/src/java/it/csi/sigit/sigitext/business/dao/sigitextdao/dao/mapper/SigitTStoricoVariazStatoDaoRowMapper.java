package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTStoricoVariazStatoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTStoricoVariazStatoDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTStoricoVariazStatoDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTStoricoVariazStatoDao
 *
 * @generated
 */
public class SigitTStoricoVariazStatoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 *
	 * @generated
	 */
	SigitTStoricoVariazStatoDaoImpl dao;

	/**
	 * costruttore
	 *
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *                      incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTStoricoVariazStatoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTStoricoVariazStatoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTStoricoVariazStatoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 *
	 * @param rs
	 * @param row
	 * @return SigitTStoricoVariazStatoDto
	 * @throws SQLException
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTStoricoVariazStatoDto) {
			return mapRow_internal((SigitTStoricoVariazStatoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTStoricoVariazStatoDto mapRow_internal(SigitTStoricoVariazStatoDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitTStoricoVariazStatoDto dto = objectToFill;

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [DT_EVENTO]
		if (mapAllColumns || columnsToReadMap.get("DT_EVENTO") != null)
			dto.setDtEvento(rs.getTimestamp("DT_EVENTO"));

		// colonna [DT_INIZIO_VARIAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_INIZIO_VARIAZIONE") != null)
			dto.setDtInizioVariazione(rs.getDate("DT_INIZIO_VARIAZIONE"));

		// colonna [MOTIVO]
		if (mapAllColumns || columnsToReadMap.get("MOTIVO") != null)
			dto.setMotivo(rs.getString("MOTIVO"));

		// colonna [STATO_DA]
		if (mapAllColumns || columnsToReadMap.get("STATO_DA") != null)
			dto.setStatoDa(rs.getBigDecimal("STATO_DA"));

		// colonna [STATO_A]
		if (mapAllColumns || columnsToReadMap.get("STATO_A") != null)
			dto.setStatoA(rs.getBigDecimal("STATO_A"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		return dto;
	}

}
