package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitRImpRuoloPfpgDao
 * @generated
 */
public class SigitRImpRuoloPfpgDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitRImpRuoloPfpgDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitRImpRuoloPfpgDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitRImpRuoloPfpgDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitRImpRuoloPfpgDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRImpRuoloPfpgDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitRImpRuoloPfpgDto) {
			return mapRow_internal((SigitRImpRuoloPfpgDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitRImpRuoloPfpgManutentoriByCodiceImpiantoDto) {
			return mapRow_internal((SigitRImpRuoloPfpgManutentoriByCodiceImpiantoDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof SigitRImpRuoloPfpgGenericByFilterDto) {
			return mapRow_internal((SigitRImpRuoloPfpgGenericByFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof SigitRImpRuoloPfpgGenericPfByFilterDto) {
			return mapRow_internal((SigitRImpRuoloPfpgGenericPfByFilterDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitRImpRuoloPfpgDto mapRow_internal(SigitRImpRuoloPfpgDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitRImpRuoloPfpgDto dto = objectToFill;

		// colonna [ID_IMP_RUOLO_PFPG]
		if (mapAllColumns || columnsToReadMap.get("ID_IMP_RUOLO_PFPG") != null)
			dto.setIdImpRuoloPfpg(rs.getBigDecimal("ID_IMP_RUOLO_PFPG"));

		// colonna [FK_RUOLO]
		if (mapAllColumns || columnsToReadMap.get("FK_RUOLO") != null)
			dto.setFkRuolo(rs.getBigDecimal("FK_RUOLO"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [DATA_INIZIO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setDataInizio(rs.getDate("DATA_INIZIO"));

		// colonna [DATA_FINE]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE") != null)
			dto.setDataFine(rs.getDate("DATA_FINE"));

		// colonna [FK_PERSONA_FISICA]
		if (mapAllColumns || columnsToReadMap.get("FK_PERSONA_FISICA") != null)
			dto.setFkPersonaFisica(rs.getBigDecimal("FK_PERSONA_FISICA"));

		// colonna [FK_PERSONA_GIURIDICA]
		if (mapAllColumns || columnsToReadMap.get("FK_PERSONA_GIURIDICA") != null)
			dto.setFkPersonaGiuridica(rs.getBigDecimal("FK_PERSONA_GIURIDICA"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		// colonna [FLG_PRIMO_CARICATORE]
		if (mapAllColumns || columnsToReadMap.get("FLG_PRIMO_CARICATORE") != null)
			dto.setFlgPrimoCaricatore(rs.getBigDecimal("FLG_PRIMO_CARICATORE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitRImpRuoloPfpgManutentoriByCodiceImpiantoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRImpRuoloPfpgManutentoriByCodiceImpiantoDto
	 * @generated
	 */

	public SigitRImpRuoloPfpgManutentoriByCodiceImpiantoDto mapRow_internal(
			SigitRImpRuoloPfpgManutentoriByCodiceImpiantoDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitRImpRuoloPfpgManutentoriByCodiceImpiantoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setPgCodiceFiscale(rs.getString("CODICE_FISCALE"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA_REA") != null)
			dto.setPgSiglaRea(rs.getString("SIGLA_REA"));

		if (mapAllColumns || columnsToReadMap.get("NUMERO_REA") != null)
			dto.setPgNumeroRea(rs.getBigDecimal("NUMERO_REA"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setPgDenominazione(rs.getString("DENOMINAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_DOCUMENTO") != null)
			dto.setTdDesTipoDocumento(rs.getString("DES_TIPO_DOCUMENTO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitRImpRuoloPfpgGenericByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRImpRuoloPfpgGenericByFilterDto
	 * @generated
	 */

	public SigitRImpRuoloPfpgGenericByFilterDto mapRow_internal(SigitRImpRuoloPfpgGenericByFilterDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		SigitRImpRuoloPfpgGenericByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDIMPRUOLOPGPF") != null)
			dto.setIdImpRuoloPgPf(rs.getBigDecimal("idImpRuoloPgPf"));

		if (mapAllColumns || columnsToReadMap.get("CODICEIMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("codiceImpianto"));

		if (mapAllColumns || columnsToReadMap.get("DATAINIZIO") != null)
			dto.setDataInizio(rs.getDate("dataInizio"));

		if (mapAllColumns || columnsToReadMap.get("DATAFINE") != null)
			dto.setDataFine(rs.getDate("dataFine"));

		if (mapAllColumns || columnsToReadMap.get("IDPERSONAFISICA") != null)
			dto.setIdPersonaFisica(rs.getBigDecimal("idPersonaFisica"));

		if (mapAllColumns || columnsToReadMap.get("IDPERSONAGIURIDICA") != null)
			dto.setIdPersonaGiuridica(rs.getBigDecimal("idPersonaGiuridica"));

		if (mapAllColumns || columnsToReadMap.get("DESRUOLO") != null)
			dto.setDesRuolo(rs.getString("desRuolo"));

		if (mapAllColumns || columnsToReadMap.get("RUOLOFUNZ") != null)
			dto.setRuoloFunz(rs.getString("ruoloFunz"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitRImpRuoloPfpgGenericPfByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRImpRuoloPfpgGenericPfByFilterDto
	 * @generated
	 */

	public SigitRImpRuoloPfpgGenericPfByFilterDto mapRow_internal(SigitRImpRuoloPfpgGenericPfByFilterDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		SigitRImpRuoloPfpgGenericPfByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDIMPRUOLOPGPF") != null)
			dto.setIdImpRuoloPgPf(rs.getBigDecimal("idImpRuoloPgPf"));

		if (mapAllColumns || columnsToReadMap.get("CODICEIMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("codiceImpianto"));

		if (mapAllColumns || columnsToReadMap.get("DATAINIZIO") != null)
			dto.setDataInizio(rs.getDate("dataInizio"));

		if (mapAllColumns || columnsToReadMap.get("DATAFINE") != null)
			dto.setDataFine(rs.getDate("dataFine"));

		if (mapAllColumns || columnsToReadMap.get("IDPERSONAFISICA") != null)
			dto.setIdPersonaFisica(rs.getBigDecimal("idPersonaFisica"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		return dto;
	}

}
