package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitVRicerca3ResponsabileDao
 * @generated
 */
public class SigitVRicerca3ResponsabileDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitVRicerca3ResponsabileDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitVRicerca3ResponsabileDaoRowMapper(String[] columnsToRead, Class dtoClass,
			SigitVRicerca3ResponsabileDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitVRicerca3ResponsabileDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVRicerca3ResponsabileDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitVRicerca3ResponsabileDto) {
			return mapRow_internal((SigitVRicerca3ResponsabileDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitVRicerca3ResponsabileByFkPgPfContaDto) {
			return mapRow_internal((SigitVRicerca3ResponsabileByFkPgPfContaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof SigitVRicerca3ResponsabileByFkPgPfRowDto) {
			return mapRow_internal((SigitVRicerca3ResponsabileByFkPgPfRowDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitVRicerca3ResponsabileDto mapRow_internal(SigitVRicerca3ResponsabileDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		SigitVRicerca3ResponsabileDto dto = objectToFill;

		// colonna [ID_CONTRATTO]
		if (mapAllColumns || columnsToReadMap.get("ID_CONTRATTO") != null)
			dto.setIdContratto(rs.getBigDecimal("ID_CONTRATTO"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [FK_RUOLO]
		if (mapAllColumns || columnsToReadMap.get("FK_RUOLO") != null)
			dto.setFkRuolo(rs.getBigDecimal("FK_RUOLO"));

		// colonna [DES_RUOLO]
		if (mapAllColumns || columnsToReadMap.get("DES_RUOLO") != null)
			dto.setDesRuolo(rs.getString("DES_RUOLO"));

		// colonna [DATA_CARICAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_CARICAMENTO") != null)
			dto.setDataCaricamento(rs.getTimestamp("DATA_CARICAMENTO"));

		// colonna [DATA_CESSAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DATA_CESSAZIONE") != null)
			dto.setDataCessazione(rs.getTimestamp("DATA_CESSAZIONE"));

		// colonna [DATA_INSERIMENTO_CESSAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO_CESSAZIONE") != null)
			dto.setDataInserimentoCessazione(rs.getTimestamp("DATA_INSERIMENTO_CESSAZIONE"));

		// colonna [FK_PG_3_RESP]
		if (mapAllColumns || columnsToReadMap.get("FK_PG_3_RESP") != null)
			dto.setFkPg3Resp(rs.getBigDecimal("FK_PG_3_RESP"));

		// colonna [FK_IMP_RUOLO_PFPG_RESP]
		if (mapAllColumns || columnsToReadMap.get("FK_IMP_RUOLO_PFPG_RESP") != null)
			dto.setFkImpRuoloPfpgResp(rs.getBigDecimal("FK_IMP_RUOLO_PFPG_RESP"));

		// colonna [DATA_INIZIO_CONTRATTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO_CONTRATTO") != null)
			dto.setDataInizioContratto(rs.getDate("DATA_INIZIO_CONTRATTO"));

		// colonna [DATA_FINE_CONTRATTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE_CONTRATTO") != null)
			dto.setDataFineContratto(rs.getDate("DATA_FINE_CONTRATTO"));

		// colonna [FLG_TACITO_RINNOVO]
		if (mapAllColumns || columnsToReadMap.get("FLG_TACITO_RINNOVO") != null)
			dto.setFlgTacitoRinnovo(rs.getBigDecimal("FLG_TACITO_RINNOVO"));

		// colonna [RESP_CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("RESP_CODICE_FISCALE") != null)
			dto.setRespCodiceFiscale(rs.getString("RESP_CODICE_FISCALE"));

		// colonna [RESP_DENOMINAZIONE]
		if (mapAllColumns || columnsToReadMap.get("RESP_DENOMINAZIONE") != null)
			dto.setRespDenominazione(rs.getString("RESP_DENOMINAZIONE"));

		// colonna [RESP_NOME]
		if (mapAllColumns || columnsToReadMap.get("RESP_NOME") != null)
			dto.setRespNome(rs.getString("RESP_NOME"));

		// colonna [TERZO_RESP_DENOMINAZIONE]
		if (mapAllColumns || columnsToReadMap.get("TERZO_RESP_DENOMINAZIONE") != null)
			dto.setTerzoRespDenominazione(rs.getString("TERZO_RESP_DENOMINAZIONE"));

		// colonna [TERZO_RESP_SIGLA_REA]
		if (mapAllColumns || columnsToReadMap.get("TERZO_RESP_SIGLA_REA") != null)
			dto.setTerzoRespSiglaRea(rs.getString("TERZO_RESP_SIGLA_REA"));

		// colonna [TERZO_RESP_NUMERO_REA]
		if (mapAllColumns || columnsToReadMap.get("TERZO_RESP_NUMERO_REA") != null)
			dto.setTerzoRespNumeroRea(rs.getBigDecimal("TERZO_RESP_NUMERO_REA"));

		// colonna [CODICE_FISCALE_3_RESP]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE_3_RESP") != null)
			dto.setCodiceFiscale3Resp(rs.getString("CODICE_FISCALE_3_RESP"));

		// colonna [DENOM_COMUNE_3_RESP]
		if (mapAllColumns || columnsToReadMap.get("DENOM_COMUNE_3_RESP") != null)
			dto.setDenomComune3Resp(rs.getString("DENOM_COMUNE_3_RESP"));

		// colonna [SIGLA_PROV_3_RESP]
		if (mapAllColumns || columnsToReadMap.get("SIGLA_PROV_3_RESP") != null)
			dto.setSiglaProv3Resp(rs.getString("SIGLA_PROV_3_RESP"));

		// colonna [DENOM_PROVINCIA_3_RESP]
		if (mapAllColumns || columnsToReadMap.get("DENOM_PROVINCIA_3_RESP") != null)
			dto.setDenomProvincia3Resp(rs.getString("DENOM_PROVINCIA_3_RESP"));

		// colonna [DENOM_COMUNE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("DENOM_COMUNE_IMPIANTO") != null)
			dto.setDenomComuneImpianto(rs.getString("DENOM_COMUNE_IMPIANTO"));

		// colonna [DENOM_PROV_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("DENOM_PROV_IMPIANTO") != null)
			dto.setDenomProvImpianto(rs.getString("DENOM_PROV_IMPIANTO"));

		// colonna [SIGLA_PROV_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("SIGLA_PROV_IMPIANTO") != null)
			dto.setSiglaProvImpianto(rs.getString("SIGLA_PROV_IMPIANTO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitVRicerca3ResponsabileByFkPgPfContaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVRicerca3ResponsabileByFkPgPfContaDto
	 * @generated
	 */

	public SigitVRicerca3ResponsabileByFkPgPfContaDto mapRow_internal(
			SigitVRicerca3ResponsabileByFkPgPfContaDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitVRicerca3ResponsabileByFkPgPfContaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("CONTARESP") != null)
			dto.setContaResp(rs.getBigDecimal("contaResp"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitVRicerca3ResponsabileByFkPgPfRowDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVRicerca3ResponsabileByFkPgPfRowDto
	 * @generated
	 */

	public SigitVRicerca3ResponsabileByFkPgPfRowDto mapRow_internal(
			SigitVRicerca3ResponsabileByFkPgPfRowDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitVRicerca3ResponsabileByFkPgPfRowDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONERESP") != null)
			dto.setDenominazioneResp(rs.getString("denominazioneResp"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE3RESP") != null)
			dto.setDenominazione3Resp(rs.getString("denominazione3Resp"));

		if (mapAllColumns || columnsToReadMap.get("DATAINIZIOCONTRATTO") != null)
			dto.setDataInizioContratto(rs.getDate("dataInizioContratto"));

		if (mapAllColumns || columnsToReadMap.get("DATAFINECONTRATTO") != null)
			dto.setDataFineContratto(rs.getDate("dataFineContratto"));

		if (mapAllColumns || columnsToReadMap.get("DATACESSAZIONE") != null)
			dto.setDataCessazione(rs.getTimestamp("dataCessazione"));

		if (mapAllColumns || columnsToReadMap.get("FLGTACITORINNOVO") != null)
			dto.setFlgTacitoRinnovo(rs.getBigDecimal("flgTacitoRinnovo"));

		return dto;
	}

}
