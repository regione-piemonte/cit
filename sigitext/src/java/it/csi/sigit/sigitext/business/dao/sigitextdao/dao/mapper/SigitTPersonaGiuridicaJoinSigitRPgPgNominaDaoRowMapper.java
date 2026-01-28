package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTPersonaGiuridicaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTPersonaGiuridicaDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto;

public class SigitTPersonaGiuridicaJoinSigitRPgPgNominaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {
	
	SigitTPersonaGiuridicaDaoImpl dao;
	
	public SigitTPersonaGiuridicaJoinSigitRPgPgNominaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTPersonaGiuridicaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTPersonaGiuridicaDaoImpl) dao;
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

		if (dtoInstance instanceof SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto) {
			return mapRow_internal((SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto) dtoInstance, rs);
		}

		return dtoInstance;
	}

	public SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto mapRow_internal(SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto objectToFill, ResultSet rs)
			throws SQLException {
		SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto dto = objectToFill;

		// colonna [ID_PERSONA_GIURIDICA_IMPRESA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_GIURIDICA_IMPRESA") != null)
			dto.setId_persona_giuridica_impresa(rs.getBigDecimal("ID_PERSONA_GIURIDICA_IMPRESA"));

		// colonna [ID_PERSONA_GIURIDICA_CAT]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_GIURIDICA_CAT") != null)
			dto.setId_persona_giuridica_cat(rs.getBigDecimal("ID_PERSONA_GIURIDICA_CAT"));

		// colonna [DENOMINAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setDenominazione(rs.getString("DENOMINAZIONE"));

		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodice_fiscale(rs.getString("CODICE_FISCALE"));

		// colonna [DATA_INIZIO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setData_inizio(rs.getDate("DATA_INIZIO"));

		// colonna [DATA_FINE]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE") != null)
			dto.setData_fine(rs.getDate("DATA_FINE"));

		return dto;
	}

}
