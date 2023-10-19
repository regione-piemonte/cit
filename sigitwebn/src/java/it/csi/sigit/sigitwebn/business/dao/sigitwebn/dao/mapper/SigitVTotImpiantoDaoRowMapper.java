package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitVTotImpiantoDao
 * @generated
 */
public class SigitVTotImpiantoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitVTotImpiantoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitVTotImpiantoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitVTotImpiantoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitVTotImpiantoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVTotImpiantoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitVTotImpiantoDto) {
			return mapRow_internal((SigitVTotImpiantoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitVTotImpiantoCercaImpiantoPerAllegatiDto) {
			return mapRow_internal((SigitVTotImpiantoCercaImpiantoPerAllegatiDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof SigitVTotImpiantoCercaUbicazioneImpiantoDto) {
			return mapRow_internal((SigitVTotImpiantoCercaUbicazioneImpiantoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitVTotImpiantoDto mapRow_internal(SigitVTotImpiantoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitVTotImpiantoDto dto = objectToFill;

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [DENOMINAZIONE_PROVINCIA]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_PROVINCIA") != null)
			dto.setDenominazioneProvincia(rs.getString("DENOMINAZIONE_PROVINCIA"));

		// colonna [SIGLA_PROVINCIA]
		if (mapAllColumns || columnsToReadMap.get("SIGLA_PROVINCIA") != null)
			dto.setSiglaProvincia(rs.getString("SIGLA_PROVINCIA"));

		// colonna [ISTAT_COMUNE]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE") != null)
			dto.setIstatComune(rs.getString("ISTAT_COMUNE"));

		// colonna [DENOMINAZIONE_COMUNE]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_COMUNE") != null)
			dto.setDenominazioneComune(rs.getString("DENOMINAZIONE_COMUNE"));

		// colonna [INDIRIZZO_SITAD]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_SITAD") != null)
			dto.setIndirizzoSitad(rs.getString("INDIRIZZO_SITAD"));

		// colonna [CIVICO]
		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("CIVICO"));

		// colonna [FLG_PRINCIPALE]
		if (mapAllColumns || columnsToReadMap.get("FLG_PRINCIPALE") != null)
			dto.setFlgPrincipale(rs.getBigDecimal("FLG_PRINCIPALE"));

		// colonna [PF_PG]
		if (mapAllColumns || columnsToReadMap.get("PF_PG") != null)
			dto.setPfPg(rs.getString("PF_PG"));

		// colonna [ID_PERSONA_FISICA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_FISICA") != null)
			dto.setIdPersonaFisica(rs.getBigDecimal("ID_PERSONA_FISICA"));

		// colonna [NOME]
		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("NOME"));

		// colonna [DENOMINAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setDenominazione(rs.getString("DENOMINAZIONE"));

		// colonna [ID_RUOLO]
		if (mapAllColumns || columnsToReadMap.get("ID_RUOLO") != null)
			dto.setIdRuolo(rs.getBigDecimal("ID_RUOLO"));

		// colonna [DES_RUOLO]
		if (mapAllColumns || columnsToReadMap.get("DES_RUOLO") != null)
			dto.setDesRuolo(rs.getString("DES_RUOLO"));

		// colonna [RUOLO_FUNZ]
		if (mapAllColumns || columnsToReadMap.get("RUOLO_FUNZ") != null)
			dto.setRuoloFunz(rs.getString("RUOLO_FUNZ"));

		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodiceFiscale(rs.getString("CODICE_FISCALE"));

		// colonna [SIGLA_REA]
		if (mapAllColumns || columnsToReadMap.get("SIGLA_REA") != null)
			dto.setSiglaRea(rs.getString("SIGLA_REA"));

		// colonna [NUMERO_REA]
		if (mapAllColumns || columnsToReadMap.get("NUMERO_REA") != null)
			dto.setNumeroRea(rs.getBigDecimal("NUMERO_REA"));

		// colonna [ID_IMP_RUOLO_PFPG]
		if (mapAllColumns || columnsToReadMap.get("ID_IMP_RUOLO_PFPG") != null)
			dto.setIdImpRuoloPfpg(rs.getBigDecimal("ID_IMP_RUOLO_PFPG"));

		// colonna [DATA_INIZIO_PFPG]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO_PFPG") != null)
			dto.setDataInizioPfpg(rs.getDate("DATA_INIZIO_PFPG"));

		// colonna [DATA_FINE_PFPG]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE_PFPG") != null)
			dto.setDataFinePfpg(rs.getDate("DATA_FINE_PFPG"));

		// colonna [FLG_VISU_PROPRIETARIO]
		if (mapAllColumns || columnsToReadMap.get("FLG_VISU_PROPRIETARIO") != null)
			dto.setFlgVisuProprietario(rs.getBigDecimal("FLG_VISU_PROPRIETARIO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitVTotImpiantoCercaImpiantoPerAllegatiDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVTotImpiantoCercaImpiantoPerAllegatiDto
	 * @generated
	 */

	public SigitVTotImpiantoCercaImpiantoPerAllegatiDto mapRow_internal(
			SigitVTotImpiantoCercaImpiantoPerAllegatiDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitVTotImpiantoCercaImpiantoPerAllegatiDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("CODICEIMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("codiceImpianto"));

		if (mapAllColumns || columnsToReadMap.get("SIGLAPROVINCIA") != null)
			dto.setSiglaProvincia(rs.getString("siglaProvincia"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNE") != null)
			dto.setIstatComune(rs.getString("istatComune"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONEPROVINCIA") != null)
			dto.setDenominazioneProvincia(rs.getString("denominazioneProvincia"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONECOMUNE") != null)
			dto.setDenominazioneComune(rs.getString("denominazioneComune"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO") != null)
			dto.setIndirizzo(rs.getString("indirizzo"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("civico"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setDenominazione(rs.getString("denominazione"));

		if (mapAllColumns || columnsToReadMap.get("DESCRUOLO") != null)
			dto.setDescRuolo(rs.getString("descRuolo"));

		if (mapAllColumns || columnsToReadMap.get("IDPERSONAFISICA") != null)
			dto.setIdPersonaFisica(rs.getBigDecimal("idPersonaFisica"));

		if (mapAllColumns || columnsToReadMap.get("PFPG") != null)
			dto.setPfPg(rs.getString("pfPg"));

		if (mapAllColumns || columnsToReadMap.get("IDRUOLO") != null)
			dto.setIdRuolo(rs.getBigDecimal("idRuolo"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitVTotImpiantoCercaUbicazioneImpiantoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVTotImpiantoCercaUbicazioneImpiantoDto
	 * @generated
	 */

	public SigitVTotImpiantoCercaUbicazioneImpiantoDto mapRow_internal(
			SigitVTotImpiantoCercaUbicazioneImpiantoDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitVTotImpiantoCercaUbicazioneImpiantoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("CODICEIMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("codiceImpianto"));

		if (mapAllColumns || columnsToReadMap.get("SIGLAPROVINCIA") != null)
			dto.setSiglaProvincia(rs.getString("siglaProvincia"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNE") != null)
			dto.setIstatComune(rs.getString("istatComune"));

		if (mapAllColumns || columnsToReadMap.get("PROVINCIA") != null)
			dto.setProvincia(rs.getString("provincia"));

		if (mapAllColumns || columnsToReadMap.get("COMUNE") != null)
			dto.setComune(rs.getString("comune"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO") != null)
			dto.setIndirizzo(rs.getString("indirizzo"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("civico"));

		return dto;
	}

}
