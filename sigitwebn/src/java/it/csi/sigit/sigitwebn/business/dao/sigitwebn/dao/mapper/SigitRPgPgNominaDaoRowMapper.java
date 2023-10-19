package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitRPgPgNominaDao
 * @generated
 */
public class SigitRPgPgNominaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitRPgPgNominaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitRPgPgNominaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitRPgPgNominaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitRPgPgNominaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRPgPgNominaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitRPgPgNominaDto) {
			return mapRow_internal((SigitRPgPgNominaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto) {
			return mapRow_internal((SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitRPgPgNominaDto mapRow_internal(SigitRPgPgNominaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitRPgPgNominaDto dto = objectToFill;

		// colonna [ID_PERSONA_GIURIDICA_CAT]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_GIURIDICA_CAT") != null)
			dto.setIdPersonaGiuridicaCat(rs.getBigDecimal("ID_PERSONA_GIURIDICA_CAT"));

		// colonna [ID_PERSONA_GIURIDICA_IMPRESA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_GIURIDICA_IMPRESA") != null)
			dto.setIdPersonaGiuridicaImpresa(rs.getBigDecimal("ID_PERSONA_GIURIDICA_IMPRESA"));

		// colonna [DATA_INIZIO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setDataInizio(rs.getDate("DATA_INIZIO"));

		// colonna [DATA_FINE]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE") != null)
			dto.setDataFine(rs.getDate("DATA_FINE"));

		// colonna [DATA_ULTIMA_MODIFICA]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULTIMA_MODIFICA") != null)
			dto.setDataUltimaModifica(rs.getDate("DATA_ULTIMA_MODIFICA"));

		// colonna [UTENTE_ULTIMA_MODIFICA]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULTIMA_MODIFICA") != null)
			dto.setUtenteUltimaModifica(rs.getString("UTENTE_ULTIMA_MODIFICA"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto
	 * @generated
	 */

	public SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto mapRow_internal(
			SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_GIURIDICA_CAT") != null)
			dto.setDIdPersonaGiuridicaCat(rs.getBigDecimal("ID_PERSONA_GIURIDICA_CAT"));

		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_GIURIDICA_IMPRESA") != null)
			dto.setDIdPersonaGiuridicaImpresa(rs.getBigDecimal("ID_PERSONA_GIURIDICA_IMPRESA"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setPgDenominazione(rs.getString("DENOMINAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setPgCodiceFiscale(rs.getString("CODICE_FISCALE"));

		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setDDataInizio(rs.getDate("DATA_INIZIO"));

		if (mapAllColumns || columnsToReadMap.get("DATA_FINE") != null)
			dto.setDDataFine(rs.getDate("DATA_FINE"));

		return dto;
	}

}
