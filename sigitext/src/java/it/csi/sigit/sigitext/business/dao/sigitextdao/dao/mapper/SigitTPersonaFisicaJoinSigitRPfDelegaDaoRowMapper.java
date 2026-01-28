package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTPersonaFisicaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTPersonaFisicaDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaFisicaJoinSigitRPfDelegaDto;

public class SigitTPersonaFisicaJoinSigitRPfDelegaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper  {

	SigitTPersonaFisicaDaoImpl dao;
	
	public SigitTPersonaFisicaJoinSigitRPfDelegaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTPersonaFisicaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTPersonaFisicaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTPersonaFisicaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTPersonaFisicaJoinSigitRPfDelegaDto) {
			return mapRow_internal((SigitTPersonaFisicaJoinSigitRPfDelegaDto) dtoInstance, rs);
		}

		return dtoInstance;
	}

	public SigitTPersonaFisicaJoinSigitRPfDelegaDto mapRow_internal(SigitTPersonaFisicaJoinSigitRPfDelegaDto objectToFill, ResultSet rs)
			throws SQLException {
		SigitTPersonaFisicaJoinSigitRPfDelegaDto dto = objectToFill;

		// colonna [ID_PERSONA_FISICA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_FISICA") != null)
			dto.setId_persona_fisica(rs.getBigDecimal("ID_PERSONA_FISICA"));

		// colonna [NOME]
		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setId_persona_giuridica(rs.getBigDecimal("ID_PERSONA_GIURIDICA"));

		// colonna [COGNOME]
		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("COGNOME"));

		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodice_fiscale(rs.getString("CODICE_FISCALE"));

		// colonna [NOME]
		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("NOME"));

		// colonna [DATA_INIZIO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setData_inizio(rs.getDate("DATA_INIZIO"));

		// colonna [FLG_DELEGA]
		if (mapAllColumns || columnsToReadMap.get("FLG_DELEGA") != null)
			dto.setTipo_legame(rs.getString("FLG_DELEGA"));

		return dto;
	}

}
