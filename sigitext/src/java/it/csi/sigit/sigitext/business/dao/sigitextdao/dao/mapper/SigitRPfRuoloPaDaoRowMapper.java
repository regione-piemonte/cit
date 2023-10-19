package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRPfRuoloPaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitRPfRuoloPaDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfRuoloPaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfRuoloPaFindByPfDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitRPfRuoloPaDao
 * @generated
 */
public class SigitRPfRuoloPaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitRPfRuoloPaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitRPfRuoloPaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitRPfRuoloPaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitRPfRuoloPaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRPfRuoloPaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitRPfRuoloPaDto) {
			return mapRow_internal((SigitRPfRuoloPaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitRPfRuoloPaFindByPfDto) {
			return mapRow_internal((SigitRPfRuoloPaFindByPfDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitRPfRuoloPaDto mapRow_internal(SigitRPfRuoloPaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitRPfRuoloPaDto dto = objectToFill;

		// colonna [ID_PERSONA_FISICA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_FISICA") != null)
			dto.setIdPersonaFisica(rs.getBigDecimal("ID_PERSONA_FISICA"));

		// colonna [ID_RUOLO_PA]
		if (mapAllColumns || columnsToReadMap.get("ID_RUOLO_PA") != null)
			dto.setIdRuoloPa((Integer) rs.getObject("ID_RUOLO_PA"));

		// colonna [ISTAT_ABILITAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_ABILITAZIONE") != null)
			dto.setIstatAbilitazione(rs.getString("ISTAT_ABILITAZIONE"));

		// colonna [DATA_INIZIO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setDataInizio(rs.getDate("DATA_INIZIO"));

		// colonna [DATA_FINE]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE") != null)
			dto.setDataFine(rs.getDate("DATA_FINE"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

		// colonna [DESC_ABILITAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DESC_ABILITAZIONE") != null)
			dto.setDescAbilitazione(rs.getString("DESC_ABILITAZIONE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitRPfRuoloPaFindByPfDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRPfRuoloPaFindByPfDto
	 * @generated
	 */

	public SigitRPfRuoloPaFindByPfDto mapRow_internal(SigitRPfRuoloPaFindByPfDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitRPfRuoloPaFindByPfDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_RUOLO_PA") != null)
			dto.setRPfRuoloPaIdRuoloPa((Integer) rs.getObject("ID_RUOLO_PA"));

		if (mapAllColumns || columnsToReadMap.get("DES_RUOLO_PA") != null)
			dto.setDRuoloPaDesRuoloPa(rs.getString("DES_RUOLO_PA"));

		if (mapAllColumns || columnsToReadMap.get("ISTAT_ABILITAZIONE") != null)
			dto.setRPfRuoloPaIstatAbilitazione(rs.getString("ISTAT_ABILITAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("DESC_ABILITAZIONE") != null)
			dto.setRPfRuoloPaDescAbilitazione(rs.getString("DESC_ABILITAZIONE"));

		return dto;
	}

}
