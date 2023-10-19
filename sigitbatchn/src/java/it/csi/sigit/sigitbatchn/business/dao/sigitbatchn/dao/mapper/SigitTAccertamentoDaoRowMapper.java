package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTAccertamentoDao
 * @generated
 */
public class SigitTAccertamentoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTAccertamentoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTAccertamentoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTAccertamentoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTAccertamentoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTAccertamentoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTAccertamentoDto) {
			return mapRow_internal((SigitTAccertamentoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitTAccertamentoByUtentiNonAttiviDto) {
			return mapRow_internal((SigitTAccertamentoByUtentiNonAttiviDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTAccertamentoDto mapRow_internal(SigitTAccertamentoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTAccertamentoDto dto = objectToFill;

		// colonna [ID_ACCERTAMENTO]
		if (mapAllColumns || columnsToReadMap.get("ID_ACCERTAMENTO") != null)
			dto.setIdAccertamento((Integer) rs.getObject("ID_ACCERTAMENTO"));

		// colonna [FK_VERIFICA]
		if (mapAllColumns || columnsToReadMap.get("FK_VERIFICA") != null)
			dto.setFkVerifica((Integer) rs.getObject("FK_VERIFICA"));

		// colonna [FK_STATO_ACCERTAMENTO]
		if (mapAllColumns || columnsToReadMap.get("FK_STATO_ACCERTAMENTO") != null)
			dto.setFkStatoAccertamento((Integer) rs.getObject("FK_STATO_ACCERTAMENTO"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [CF_UTENTE_ASSEGN]
		if (mapAllColumns || columnsToReadMap.get("CF_UTENTE_ASSEGN") != null)
			dto.setCfUtenteAssegn(rs.getString("CF_UTENTE_ASSEGN"));

		// colonna [DT_CREAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_CREAZIONE") != null)
			dto.setDtCreazione(rs.getDate("DT_CREAZIONE"));

		// colonna [DT_CONCLUSIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_CONCLUSIONE") != null)
			dto.setDtConclusione(rs.getDate("DT_CONCLUSIONE"));

		// colonna [FK_TIPO_CONCLUSIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_CONCLUSIONE") != null)
			dto.setFkTipoConclusione((Integer) rs.getObject("FK_TIPO_CONCLUSIONE"));

		// colonna [FK_TIPO_ANOMALIA]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_ANOMALIA") != null)
			dto.setFkTipoAnomalia((Integer) rs.getObject("FK_TIPO_ANOMALIA"));

		// colonna [DT_SVEGLIA]
		if (mapAllColumns || columnsToReadMap.get("DT_SVEGLIA") != null)
			dto.setDtSveglia(rs.getDate("DT_SVEGLIA"));

		// colonna [NOTE_SVEGLIA]
		if (mapAllColumns || columnsToReadMap.get("NOTE_SVEGLIA") != null)
			dto.setNoteSveglia(rs.getString("NOTE_SVEGLIA"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

		// colonna [SIGLA_PROV_COMPETENZA]
		if (mapAllColumns || columnsToReadMap.get("SIGLA_PROV_COMPETENZA") != null)
			dto.setSiglaProvCompetenza(rs.getString("SIGLA_PROV_COMPETENZA"));

		// colonna [ISTAT_PROV_COMPETENZA]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_PROV_COMPETENZA") != null)
			dto.setIstatProvCompetenza(rs.getString("ISTAT_PROV_COMPETENZA"));

		// colonna [DENOM_UTENTE_ASSEGN]
		if (mapAllColumns || columnsToReadMap.get("DENOM_UTENTE_ASSEGN") != null)
			dto.setDenomUtenteAssegn(rs.getString("DENOM_UTENTE_ASSEGN"));

		// colonna [ISTAT_COMUNE_COMPETENZA]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE_COMPETENZA") != null)
			dto.setIstatComuneCompetenza(rs.getString("ISTAT_COMUNE_COMPETENZA"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitTAccertamentoByUtentiNonAttiviDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTAccertamentoByUtentiNonAttiviDto
	 * @generated
	 */

	public SigitTAccertamentoByUtentiNonAttiviDto mapRow_internal(SigitTAccertamentoByUtentiNonAttiviDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		SigitTAccertamentoByUtentiNonAttiviDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_ACCERTAMENTO") != null)
			dto.setAccIdAccertamento((Integer) rs.getObject("ID_ACCERTAMENTO"));

		if (mapAllColumns || columnsToReadMap.get("CF_UTENTE_ASSEGN") != null)
			dto.setAccCfUtenteAssegn(rs.getString("CF_UTENTE_ASSEGN"));

		if (mapAllColumns || columnsToReadMap.get("DENOM_UTENTE_ASSEGN") != null)
			dto.setAccDenomUtenteAssegn(rs.getString("DENOM_UTENTE_ASSEGN"));

		if (mapAllColumns || columnsToReadMap.get("DT_SVEGLIA") != null)
			dto.setAccDtSveglia(rs.getDate("DT_SVEGLIA"));

		if (mapAllColumns || columnsToReadMap.get("NOTE_SVEGLIA") != null)
			dto.setAccNoteSveglia(rs.getString("NOTE_SVEGLIA"));

		if (mapAllColumns || columnsToReadMap.get("ID_RUOLO_PA") != null)
			dto.setAIdRuoloPa((Integer) rs.getObject("ID_RUOLO_PA"));

		if (mapAllColumns || columnsToReadMap.get("ISTAT_ABILITAZIONE") != null)
			dto.setAIstatAbilitazione(rs.getString("ISTAT_ABILITAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("MAIL_COMUNICAZIONE") != null)
			dto.setAMailComunicazione(rs.getString("MAIL_COMUNICAZIONE"));

		return dto;
	}

}
