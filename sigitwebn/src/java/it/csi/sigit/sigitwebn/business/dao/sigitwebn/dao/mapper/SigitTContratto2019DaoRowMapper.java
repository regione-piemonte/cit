package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTContratto2019Dao
 * @generated
 */
public class SigitTContratto2019DaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTContratto2019DaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTContratto2019DaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTContratto2019Dao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTContratto2019DaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTContratto2019Dto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTContratto2019Dto) {
			return mapRow_internal((SigitTContratto2019Dto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTContratto2019Dto mapRow_internal(SigitTContratto2019Dto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTContratto2019Dto dto = objectToFill;

		// colonna [ID_CONTRATTO]
		if (mapAllColumns || columnsToReadMap.get("ID_CONTRATTO") != null)
			dto.setIdContratto(rs.getBigDecimal("ID_CONTRATTO"));

		// colonna [FK_PG_3_RESP]
		if (mapAllColumns || columnsToReadMap.get("FK_PG_3_RESP") != null)
			dto.setFkPg3Resp(rs.getBigDecimal("FK_PG_3_RESP"));

		// colonna [FK_IMP_RUOLO_PFPG_RESP]
		if (mapAllColumns || columnsToReadMap.get("FK_IMP_RUOLO_PFPG_RESP") != null)
			dto.setFkImpRuoloPfpgResp(rs.getBigDecimal("FK_IMP_RUOLO_PFPG_RESP"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [DATA_INIZIO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setDataInizio(rs.getDate("DATA_INIZIO"));

		// colonna [DATA_FINE]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE") != null)
			dto.setDataFine(rs.getDate("DATA_FINE"));

		// colonna [FLG_TACITO_RINNOVO]
		if (mapAllColumns || columnsToReadMap.get("FLG_TACITO_RINNOVO") != null)
			dto.setFlgTacitoRinnovo(rs.getBigDecimal("FLG_TACITO_RINNOVO"));

		// colonna [DATA_CARICAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_CARICAMENTO") != null)
			dto.setDataCaricamento(rs.getTimestamp("DATA_CARICAMENTO"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		// colonna [DATA_CESSAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DATA_CESSAZIONE") != null)
			dto.setDataCessazione(rs.getDate("DATA_CESSAZIONE"));

		// colonna [DATA_INSERIMENTO_CESSAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO_CESSAZIONE") != null)
			dto.setDataInserimentoCessazione(rs.getTimestamp("DATA_INSERIMENTO_CESSAZIONE"));

		// colonna [MOTIVO_CESSAZIONE]
		if (mapAllColumns || columnsToReadMap.get("MOTIVO_CESSAZIONE") != null)
			dto.setMotivoCessazione(rs.getString("MOTIVO_CESSAZIONE"));

		// colonna [FK_TIPO_CESSAZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_CESSAZIONE") != null)
			dto.setFkTipoCessazione((Integer) rs.getObject("FK_TIPO_CESSAZIONE"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

		return dto;
	}

}
