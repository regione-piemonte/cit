package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitRPfPgDelegaDao
 * @generated
 */
public class SigitRPfPgDelegaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitRPfPgDelegaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitRPfPgDelegaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitRPfPgDelegaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitRPfPgDelegaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRPfPgDelegaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitRPfPgDelegaDto) {
			return mapRow_internal((SigitRPfPgDelegaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto) {
			return mapRow_internal((SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitRPfPgDelegaDto mapRow_internal(SigitRPfPgDelegaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitRPfPgDelegaDto dto = objectToFill;

		// colonna [ID_PERSONA_FISICA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_FISICA") != null)
			dto.setIdPersonaFisica(rs.getBigDecimal("ID_PERSONA_FISICA"));

		// colonna [ID_PERSONA_GIURIDICA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_GIURIDICA") != null)
			dto.setIdPersonaGiuridica(rs.getBigDecimal("ID_PERSONA_GIURIDICA"));

		// colonna [DATA_INIZIO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setDataInizio(rs.getDate("DATA_INIZIO"));

		// colonna [FK_RUOLO_ACCRED]
		if (mapAllColumns || columnsToReadMap.get("FK_RUOLO_ACCRED") != null)
			dto.setFkRuoloAccred(rs.getBigDecimal("FK_RUOLO_ACCRED"));

		// colonna [FK_TIPO_DM]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_DM") != null)
			dto.setFkTipoDm(rs.getString("FK_TIPO_DM"));

		// colonna [FLG_DELEGA]
		if (mapAllColumns || columnsToReadMap.get("FLG_DELEGA") != null)
			dto.setFlgDelega(rs.getString("FLG_DELEGA"));

		// colonna [DATA_FINE]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE") != null)
			dto.setDataFine(rs.getDate("DATA_FINE"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto
	 * @generated
	 */

	public SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto mapRow_internal(
			SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_FISICA") != null)
			dto.setDIdPersonaFisica(rs.getBigDecimal("ID_PERSONA_FISICA"));

		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_GIURIDICA") != null)
			dto.setDIdPersonaGiuridica(rs.getBigDecimal("ID_PERSONA_GIURIDICA"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setPfCognome(rs.getString("COGNOME"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setPfNome(rs.getString("NOME"));

		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setPfCodiceFiscale(rs.getString("CODICE_FISCALE"));

		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setDDataInizio(rs.getDate("DATA_INIZIO"));

		if (mapAllColumns || columnsToReadMap.get("DATA_FINE") != null)
			dto.setDDataFine(rs.getDate("DATA_FINE"));

		if (mapAllColumns || columnsToReadMap.get("FLG_DELEGA") != null)
			dto.setDFlgDelega(rs.getString("FLG_DELEGA"));

		return dto;
	}

}
