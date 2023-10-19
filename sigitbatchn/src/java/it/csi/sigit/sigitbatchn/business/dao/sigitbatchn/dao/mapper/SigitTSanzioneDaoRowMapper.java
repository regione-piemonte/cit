package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTSanzioneDao
 * @generated
 */
public class SigitTSanzioneDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTSanzioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTSanzioneDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTSanzioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTSanzioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTSanzioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTSanzioneDto) {
			return mapRow_internal((SigitTSanzioneDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitTSanzioneAccertamentiByUtentiNonAttiviDto) {
			return mapRow_internal((SigitTSanzioneAccertamentiByUtentiNonAttiviDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof SigitTSanzioneIspezione2018ByUtentiNonAttiviDto) {
			return mapRow_internal((SigitTSanzioneIspezione2018ByUtentiNonAttiviDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTSanzioneDto mapRow_internal(SigitTSanzioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTSanzioneDto dto = objectToFill;

		// colonna [ID_SANZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_SANZIONE") != null)
			dto.setIdSanzione((Integer) rs.getObject("ID_SANZIONE"));

		// colonna [FK_STATO_SANZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_STATO_SANZIONE") != null)
			dto.setFkStatoSanzione((Integer) rs.getObject("FK_STATO_SANZIONE"));

		// colonna [FK_ISPEZIONE_2018]
		if (mapAllColumns || columnsToReadMap.get("FK_ISPEZIONE_2018") != null)
			dto.setFkIspezione2018((Integer) rs.getObject("FK_ISPEZIONE_2018"));

		// colonna [FK_ACCERTAMENTO]
		if (mapAllColumns || columnsToReadMap.get("FK_ACCERTAMENTO") != null)
			dto.setFkAccertamento((Integer) rs.getObject("FK_ACCERTAMENTO"));

		// colonna [FK_PF_SANZIONATA]
		if (mapAllColumns || columnsToReadMap.get("FK_PF_SANZIONATA") != null)
			dto.setFkPfSanzionata(rs.getBigDecimal("FK_PF_SANZIONATA"));

		// colonna [FK_PG_SANZIONATA]
		if (mapAllColumns || columnsToReadMap.get("FK_PG_SANZIONATA") != null)
			dto.setFkPgSanzionata(rs.getBigDecimal("FK_PG_SANZIONATA"));

		// colonna [MOTIVAZIONE_SANZIONE]
		if (mapAllColumns || columnsToReadMap.get("MOTIVAZIONE_SANZIONE") != null)
			dto.setMotivazioneSanzione(rs.getString("MOTIVAZIONE_SANZIONE"));

		// colonna [VALORE_SANZIONE]
		if (mapAllColumns || columnsToReadMap.get("VALORE_SANZIONE") != null)
			dto.setValoreSanzione(rs.getBigDecimal("VALORE_SANZIONE"));

		// colonna [DT_CREAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_CREAZIONE") != null)
			dto.setDtCreazione(rs.getDate("DT_CREAZIONE"));

		// colonna [DT_COMUNICAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_COMUNICAZIONE") != null)
			dto.setDtComunicazione(rs.getDate("DT_COMUNICAZIONE"));

		// colonna [DT_PAGAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DT_PAGAMENTO") != null)
			dto.setDtPagamento(rs.getDate("DT_PAGAMENTO"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

		// colonna [MOTIVO_ANNULLAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MOTIVO_ANNULLAMENTO") != null)
			dto.setMotivoAnnullamento(rs.getString("MOTIVO_ANNULLAMENTO"));

		// colonna [DT_ANNULLAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DT_ANNULLAMENTO") != null)
			dto.setDtAnnullamento(rs.getDate("DT_ANNULLAMENTO"));

		// colonna [CF_RESPONSABILE]
		if (mapAllColumns || columnsToReadMap.get("CF_RESPONSABILE") != null)
			dto.setCfResponsabile(rs.getString("CF_RESPONSABILE"));

		// colonna [DENOM_UT_RESPONSABILE]
		if (mapAllColumns || columnsToReadMap.get("DENOM_UT_RESPONSABILE") != null)
			dto.setDenomUtResponsabile(rs.getString("DENOM_UT_RESPONSABILE"));

		// colonna [DT_SVEGLIA]
		if (mapAllColumns || columnsToReadMap.get("DT_SVEGLIA") != null)
			dto.setDtSveglia(rs.getDate("DT_SVEGLIA"));

		// colonna [NOTE_SVEGLIA]
		if (mapAllColumns || columnsToReadMap.get("NOTE_SVEGLIA") != null)
			dto.setNoteSveglia(rs.getString("NOTE_SVEGLIA"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitTSanzioneAccertamentiByUtentiNonAttiviDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTSanzioneAccertamentiByUtentiNonAttiviDto
	 * @generated
	 */

	public SigitTSanzioneAccertamentiByUtentiNonAttiviDto mapRow_internal(
			SigitTSanzioneAccertamentiByUtentiNonAttiviDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitTSanzioneAccertamentiByUtentiNonAttiviDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_SANZIONE") != null)
			dto.setSIdSanzione((Integer) rs.getObject("ID_SANZIONE"));

		if (mapAllColumns || columnsToReadMap.get("CF_RESPONSABILE") != null)
			dto.setSCfResponsabile(rs.getString("CF_RESPONSABILE"));

		if (mapAllColumns || columnsToReadMap.get("DENOM_UT_RESPONSABILE") != null)
			dto.setSDenomUtResponsabile(rs.getString("DENOM_UT_RESPONSABILE"));

		if (mapAllColumns || columnsToReadMap.get("DT_SVEGLIA") != null)
			dto.setSDtSveglia(rs.getDate("DT_SVEGLIA"));

		if (mapAllColumns || columnsToReadMap.get("NOTE_SVEGLIA") != null)
			dto.setSNoteSveglia(rs.getString("NOTE_SVEGLIA"));

		if (mapAllColumns || columnsToReadMap.get("ID_RUOLO_PA") != null)
			dto.setAIdRuoloPa((Integer) rs.getObject("ID_RUOLO_PA"));

		if (mapAllColumns || columnsToReadMap.get("ISTAT_ABILITAZIONE") != null)
			dto.setAIstatAbilitazione(rs.getString("ISTAT_ABILITAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("MAIL_COMUNICAZIONE") != null)
			dto.setAMailComunicazione(rs.getString("MAIL_COMUNICAZIONE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitTSanzioneIspezione2018ByUtentiNonAttiviDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTSanzioneIspezione2018ByUtentiNonAttiviDto
	 * @generated
	 */

	public SigitTSanzioneIspezione2018ByUtentiNonAttiviDto mapRow_internal(
			SigitTSanzioneIspezione2018ByUtentiNonAttiviDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitTSanzioneIspezione2018ByUtentiNonAttiviDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_SANZIONE") != null)
			dto.setSIdSanzione((Integer) rs.getObject("ID_SANZIONE"));

		if (mapAllColumns || columnsToReadMap.get("CF_RESPONSABILE") != null)
			dto.setSCfResponsabile(rs.getString("CF_RESPONSABILE"));

		if (mapAllColumns || columnsToReadMap.get("DENOM_UT_RESPONSABILE") != null)
			dto.setSDenomUtResponsabile(rs.getString("DENOM_UT_RESPONSABILE"));

		if (mapAllColumns || columnsToReadMap.get("DT_SVEGLIA") != null)
			dto.setSDtSveglia(rs.getDate("DT_SVEGLIA"));

		if (mapAllColumns || columnsToReadMap.get("NOTE_SVEGLIA") != null)
			dto.setSNoteSveglia(rs.getString("NOTE_SVEGLIA"));

		if (mapAllColumns || columnsToReadMap.get("ID_RUOLO_PA") != null)
			dto.setAIdRuoloPa((Integer) rs.getObject("ID_RUOLO_PA"));

		if (mapAllColumns || columnsToReadMap.get("ISTAT_ABILITAZIONE") != null)
			dto.setAIstatAbilitazione(rs.getString("ISTAT_ABILITAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("MAIL_COMUNICAZIONE") != null)
			dto.setAMailComunicazione(rs.getString("MAIL_COMUNICAZIONE"));

		return dto;
	}

}
