package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTImportDistribDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTImportDistribDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribByIdPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribRicevutaByIdImportDistribDto;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SigitTImportDistribDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {


	SigitTImportDistribDaoImpl dao;

	public SigitTImportDistribDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTImportDistribDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTImportDistribDaoImpl) dao;
	}

	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTImportDistribDto) {
			return mapRow_internal((SigitTImportDistribDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitTImportDistribByIdPersonaGiuridicaDto) {
			return mapRow_internal((SigitTImportDistribByIdPersonaGiuridicaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof SigitTImportDistribRicevutaByIdImportDistribDto) {
			return mapRow_internal((SigitTImportDistribRicevutaByIdImportDistribDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTImportDistribDto mapRow_internal(SigitTImportDistribDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTImportDistribDto dto = objectToFill;

		// colonna [ID_IMPORT_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("ID_IMPORT_DISTRIB") != null)
			dto.setIdImportDistrib((Integer) rs.getObject("ID_IMPORT_DISTRIB"));

		// colonna [FK_PERSONA_GIURIDICA]
		if (mapAllColumns || columnsToReadMap.get("FK_PERSONA_GIURIDICA") != null)
			dto.setFkPersonaGiuridica(rs.getBigDecimal("FK_PERSONA_GIURIDICA"));

		// colonna [FK_STATO_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("FK_STATO_DISTRIB") != null)
			dto.setFkStatoDistrib((Integer) rs.getObject("FK_STATO_DISTRIB"));

		// colonna [DATA_INIZIO_ELAB]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO_ELAB") != null)
			dto.setDataInizioElab(rs.getTimestamp("DATA_INIZIO_ELAB"));

		// colonna [DATA_FINE_ELAB]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE_ELAB") != null)
			dto.setDataFineElab(rs.getTimestamp("DATA_FINE_ELAB"));

		// colonna [DATA_ANNULLAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_ANNULLAMENTO") != null)
			dto.setDataAnnullamento(rs.getTimestamp("DATA_ANNULLAMENTO"));

		// colonna [NOME_FILE_IMPORT]
		if (mapAllColumns || columnsToReadMap.get("NOME_FILE_IMPORT") != null)
			dto.setNomeFileImport(rs.getString("NOME_FILE_IMPORT"));

		// colonna [UID_INDEX]
		if (mapAllColumns || columnsToReadMap.get("UID_INDEX") != null)
			dto.setUidIndex(rs.getString("UID_INDEX"));

		// colonna [ANNO_RIFERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("ANNO_RIFERIMENTO") != null)
			dto.setAnnoRiferimento(rs.getBigDecimal("ANNO_RIFERIMENTO"));

		// colonna [DATA_INVIO_MAIL_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("DATA_INVIO_MAIL_DISTRIB") != null)
			dto.setDataInvioMailDistrib(rs.getTimestamp("DATA_INVIO_MAIL_DISTRIB"));

		// colonna [DATA_INVIO_MAIL_ASSISTENZA]
		if (mapAllColumns || columnsToReadMap.get("DATA_INVIO_MAIL_ASSISTENZA") != null)
			dto.setDataInvioMailAssistenza(rs.getTimestamp("DATA_INVIO_MAIL_ASSISTENZA"));

		// colonna [TOT_RECORD_ELABORATI]
		if (mapAllColumns || columnsToReadMap.get("TOT_RECORD_ELABORATI") != null)
			dto.setTotRecordElaborati(rs.getBigDecimal("TOT_RECORD_ELABORATI"));

		// colonna [TOT_RECORD_SCARTATI]
		if (mapAllColumns || columnsToReadMap.get("TOT_RECORD_SCARTATI") != null)
			dto.setTotRecordScartati(rs.getBigDecimal("TOT_RECORD_SCARTATI"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		// colonna [UTENTE_CARICAMENTO]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_CARICAMENTO") != null)
			dto.setUtenteCaricamento(rs.getString("UTENTE_CARICAMENTO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitTImportDistribByIdPersonaGiuridicaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTImportDistribByIdPersonaGiuridicaDto
	 * @generated
	 */

	public SigitTImportDistribByIdPersonaGiuridicaDto mapRow_internal(
			SigitTImportDistribByIdPersonaGiuridicaDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitTImportDistribByIdPersonaGiuridicaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_IMPORT_DISTRIB") != null)
			dto.setIdIdImportDistrib((Integer) rs.getObject("ID_IMPORT_DISTRIB"));
		
		// colonna [FK_PERSONA_GIURIDICA]
			if (mapAllColumns || columnsToReadMap.get("FK_PERSONA_GIURIDICA") != null) {
				BigDecimal fkPersonaGiuridica = rs.getBigDecimal("FK_PERSONA_GIURIDICA");
			    if (fkPersonaGiuridica != null) {
			        dto.setFkPersonaGiuridica(fkPersonaGiuridica.intValue());
			    } else {
			        dto.setFkPersonaGiuridica(null); 
			    }
			}

		// colonna [FK_STATO_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("FK_STATO_DISTRIB") != null)
			dto.setFkStatoDistrib((Integer) rs.getObject("FK_STATO_DISTRIB"));

		if (mapAllColumns || columnsToReadMap.get("DES_STATO_DISTRIB") != null)
			dto.setSdDesStatoDistrib(rs.getString("DES_STATO_DISTRIB"));
		
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO_ELAB") != null)
			dto.setIdDataInizioElab(rs.getTimestamp("DATA_INIZIO_ELAB"));

		if (mapAllColumns || columnsToReadMap.get("DATA_FINE_ELAB") != null)
			dto.setIdDataFineElab(rs.getTimestamp("DATA_FINE_ELAB"));

		if (mapAllColumns || columnsToReadMap.get("DATA_ANNULLAMENTO") != null)
			dto.setIdDataAnnullamento(rs.getTimestamp("DATA_ANNULLAMENTO"));

		if (mapAllColumns || columnsToReadMap.get("NOME_FILE_IMPORT") != null)
			dto.setIdNomeFileImport(rs.getString("NOME_FILE_IMPORT"));

		if (mapAllColumns || columnsToReadMap.get("UID_INDEX") != null)
			dto.setUidIndex(rs.getString("UID_INDEX"));
		
		if (mapAllColumns || columnsToReadMap.get("ANNO_RIFERIMENTO") != null)
			dto.setIdAnnoRiferimento(rs.getBigDecimal("ANNO_RIFERIMENTO"));

		// colonna [DATA_INVIO_MAIL_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("DATA_INVIO_MAIL_DISTRIB") != null)
			dto.setDataInvioMailDistrib(rs.getString("DATA_INVIO_MAIL_DISTRIB"));

		// colonna [DATA_INVIO_MAIL_ASSISTENZA]
		if (mapAllColumns || columnsToReadMap.get("DATA_INVIO_MAIL_ASSISTENZA") != null)
			dto.setDataInvioMailAssistenza(rs.getString("DATA_INVIO_MAIL_ASSISTENZA"));

		if (mapAllColumns || columnsToReadMap.get("TOT_RECORD_ELABORATI") != null)
			dto.setIdTotRecordElaborati(rs.getBigDecimal("TOT_RECORD_ELABORATI"));

		if (mapAllColumns || columnsToReadMap.get("TOT_RECORD_SCARTATI") != null)
			dto.setIdTotRecordScartati(rs.getBigDecimal("TOT_RECORD_SCARTATI"));
		
		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getString("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		// colonna [UTENTE_CARICAMENTO]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_CARICAMENTO") != null)
			dto.setUtenteCaricamento(rs.getString("UTENTE_CARICAMENTO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitTImportDistribRicevutaByIdImportDistribDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTImportDistribRicevutaByIdImportDistribDto
	 * @generated
	 */

	public SigitTImportDistribRicevutaByIdImportDistribDto mapRow_internal(
			SigitTImportDistribRicevutaByIdImportDistribDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitTImportDistribRicevutaByIdImportDistribDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_IMPORT_DISTRIB") != null)
			dto.setIdIdImportDistrib((Integer) rs.getObject("ID_IMPORT_DISTRIB"));

		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO_ELAB") != null)
			dto.setIdDataInizioElab(rs.getTimestamp("DATA_INIZIO_ELAB"));

		if (mapAllColumns || columnsToReadMap.get("DATA_FINE_ELAB") != null)
			dto.setIdDataFineElab(rs.getTimestamp("DATA_FINE_ELAB"));

		if (mapAllColumns || columnsToReadMap.get("NOME_FILE_IMPORT") != null)
			dto.setIdNomeFileImport(rs.getString("NOME_FILE_IMPORT"));

		if (mapAllColumns || columnsToReadMap.get("ANNO_RIFERIMENTO") != null)
			dto.setIdAnnoRiferimento(rs.getBigDecimal("ANNO_RIFERIMENTO"));

		if (mapAllColumns || columnsToReadMap.get("DES_STATO_DISTRIB") != null)
			dto.setSdDesStatoDistrib(rs.getString("DES_STATO_DISTRIB"));

		if (mapAllColumns || columnsToReadMap.get("DATA_ANNULLAMENTO") != null)
			dto.setIdDataAnnullamento(rs.getTimestamp("DATA_ANNULLAMENTO"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA_REA") != null)
			dto.setPgSiglaRea(rs.getString("SIGLA_REA"));

		if (mapAllColumns || columnsToReadMap.get("NUMERO_REA") != null)
			dto.setPgNumeroRea(rs.getBigDecimal("NUMERO_REA"));

		if (mapAllColumns || columnsToReadMap.get("COMUNE") != null)
			dto.setPgComune(rs.getString("COMUNE"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA_PROV") != null)
			dto.setPgSiglaProv(rs.getString("SIGLA_PROV"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_SITAD") != null)
			dto.setPgIndirizzoSitad(rs.getString("INDIRIZZO_SITAD"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_NON_TROVATO") != null)
			dto.setPgIndirizzoNonTrovato(rs.getString("INDIRIZZO_NON_TROVATO"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setPgCivico(rs.getString("CIVICO"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setPgDenominazione(rs.getString("DENOMINAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setPgCodiceFiscale(rs.getString("CODICE_FISCALE"));

		return dto;
	}

}