package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import it.csi.sigit.sigitwebn.business.dao.impl.*;
import it.csi.sigit.sigitwebn.business.dao.util.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import java.util.Map;
import java.util.TreeMap;

/*PROTECTED REGION ID(R-1822926765) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTSanzione.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - validaByIdAccertamento (datagen::CustomFinder)
 *   - byExample (datagen::CustomFinder)
 *   - sveglieAttiveByCF (datagen::CustomFinder)
 *   - validaByIdIspezione (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byRicerca (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - note (datagen::UpdateColumns)
 *   - perPagamento (datagen::UpdateColumns)
 *   - perAssegnazione (datagen::UpdateColumns)
 *   - perAnnullamento (datagen::UpdateColumns)
 *   - infoSveglia (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTSanzioneDaoImpl extends AbstractDAO implements SigitTSanzioneDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Metodo di inserimento del DAO sigitTSanzione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTSanzionePk
	 * @generated
	 */

	public SigitTSanzionePk insert(SigitTSanzioneDto dto)

	{
		LOG.debug("[SigitTSanzioneDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_SANZIONE,FK_STATO_SANZIONE,FK_ISPEZIONE_2018,FK_ACCERTAMENTO,FK_PF_SANZIONATA,FK_PG_SANZIONATA,MOTIVAZIONE_SANZIONE,VALORE_SANZIONE,DT_CREAZIONE,DT_COMUNICAZIONE,DT_PAGAMENTO,NOTE,MOTIVO_ANNULLAMENTO,DT_ANNULLAMENTO,CF_RESPONSABILE,DENOM_UT_RESPONSABILE,DT_SVEGLIA,NOTE_SVEGLIA ) VALUES (  :ID_SANZIONE , :FK_STATO_SANZIONE , :FK_ISPEZIONE_2018 , :FK_ACCERTAMENTO , :FK_PF_SANZIONATA , :FK_PG_SANZIONATA , :MOTIVAZIONE_SANZIONE , :VALORE_SANZIONE , :DT_CREAZIONE , :DT_COMUNICAZIONE , :DT_PAGAMENTO , :NOTE , :MOTIVO_ANNULLAMENTO , :DT_ANNULLAMENTO , :CF_RESPONSABILE , :DENOM_UT_RESPONSABILE , :DT_SVEGLIA , :NOTE_SVEGLIA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SANZIONE]
		params.addValue("ID_SANZIONE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_STATO_SANZIONE]
		params.addValue("FK_STATO_SANZIONE", dto.getFkStatoSanzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ISPEZIONE_2018]
		params.addValue("FK_ISPEZIONE_2018", dto.getFkIspezione2018(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ACCERTAMENTO]
		params.addValue("FK_ACCERTAMENTO", dto.getFkAccertamento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PF_SANZIONATA]
		params.addValue("FK_PF_SANZIONATA", dto.getFkPfSanzionata(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_PG_SANZIONATA]
		params.addValue("FK_PG_SANZIONATA", dto.getFkPgSanzionata(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MOTIVAZIONE_SANZIONE]
		params.addValue("MOTIVAZIONE_SANZIONE", dto.getMotivazioneSanzione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [VALORE_SANZIONE]
		params.addValue("VALORE_SANZIONE", dto.getValoreSanzione(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_CREAZIONE]
		params.addValue("DT_CREAZIONE", dto.getDtCreazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DT_COMUNICAZIONE]
		params.addValue("DT_COMUNICAZIONE", dto.getDtComunicazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DT_PAGAMENTO]
		params.addValue("DT_PAGAMENTO", dto.getDtPagamento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MOTIVO_ANNULLAMENTO]
		params.addValue("MOTIVO_ANNULLAMENTO", dto.getMotivoAnnullamento(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DT_ANNULLAMENTO]
		params.addValue("DT_ANNULLAMENTO", dto.getDtAnnullamento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CF_RESPONSABILE]
		params.addValue("CF_RESPONSABILE", dto.getCfResponsabile(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOM_UT_RESPONSABILE]
		params.addValue("DENOM_UT_RESPONSABILE", dto.getDenomUtResponsabile(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DT_SVEGLIA]
		params.addValue("DT_SVEGLIA", dto.getDtSveglia(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE_SVEGLIA]
		params.addValue("NOTE_SVEGLIA", dto.getNoteSveglia(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdSanzione(newKey);
		LOG.debug("[SigitTSanzioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_SANZIONE table.
	 * @generated
	 */
	public void update(SigitTSanzioneDto dto) throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_STATO_SANZIONE = :FK_STATO_SANZIONE ,FK_ISPEZIONE_2018 = :FK_ISPEZIONE_2018 ,FK_ACCERTAMENTO = :FK_ACCERTAMENTO ,FK_PF_SANZIONATA = :FK_PF_SANZIONATA ,FK_PG_SANZIONATA = :FK_PG_SANZIONATA ,MOTIVAZIONE_SANZIONE = :MOTIVAZIONE_SANZIONE ,VALORE_SANZIONE = :VALORE_SANZIONE ,DT_CREAZIONE = :DT_CREAZIONE ,DT_COMUNICAZIONE = :DT_COMUNICAZIONE ,DT_PAGAMENTO = :DT_PAGAMENTO ,NOTE = :NOTE ,MOTIVO_ANNULLAMENTO = :MOTIVO_ANNULLAMENTO ,DT_ANNULLAMENTO = :DT_ANNULLAMENTO ,CF_RESPONSABILE = :CF_RESPONSABILE ,DENOM_UT_RESPONSABILE = :DENOM_UT_RESPONSABILE ,DT_SVEGLIA = :DT_SVEGLIA ,NOTE_SVEGLIA = :NOTE_SVEGLIA  WHERE ID_SANZIONE = :ID_SANZIONE ";

		if (dto.getIdSanzione() == null) {
			LOG.error("[SigitTSanzioneDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTSanzioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SANZIONE]
		params.addValue("ID_SANZIONE", dto.getIdSanzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_STATO_SANZIONE]
		params.addValue("FK_STATO_SANZIONE", dto.getFkStatoSanzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ISPEZIONE_2018]
		params.addValue("FK_ISPEZIONE_2018", dto.getFkIspezione2018(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ACCERTAMENTO]
		params.addValue("FK_ACCERTAMENTO", dto.getFkAccertamento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PF_SANZIONATA]
		params.addValue("FK_PF_SANZIONATA", dto.getFkPfSanzionata(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_PG_SANZIONATA]
		params.addValue("FK_PG_SANZIONATA", dto.getFkPgSanzionata(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MOTIVAZIONE_SANZIONE]
		params.addValue("MOTIVAZIONE_SANZIONE", dto.getMotivazioneSanzione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [VALORE_SANZIONE]
		params.addValue("VALORE_SANZIONE", dto.getValoreSanzione(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_CREAZIONE]
		params.addValue("DT_CREAZIONE", dto.getDtCreazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DT_COMUNICAZIONE]
		params.addValue("DT_COMUNICAZIONE", dto.getDtComunicazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DT_PAGAMENTO]
		params.addValue("DT_PAGAMENTO", dto.getDtPagamento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MOTIVO_ANNULLAMENTO]
		params.addValue("MOTIVO_ANNULLAMENTO", dto.getMotivoAnnullamento(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DT_ANNULLAMENTO]
		params.addValue("DT_ANNULLAMENTO", dto.getDtAnnullamento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CF_RESPONSABILE]
		params.addValue("CF_RESPONSABILE", dto.getCfResponsabile(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOM_UT_RESPONSABILE]
		params.addValue("DENOM_UT_RESPONSABILE", dto.getDenomUtResponsabile(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DT_SVEGLIA]
		params.addValue("DT_SVEGLIA", dto.getDtSveglia(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE_SVEGLIA]
		params.addValue("NOTE_SVEGLIA", dto.getNoteSveglia(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTSanzioneDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_SANZIONE table.
	 * @generated
	 */
	public void updateColumnsNote(SigitTSanzioneDto dto) throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::updateColumnsNote] START");
		final String sql = "UPDATE " + getTableName() + " SET NOTE = :NOTE  WHERE ID_SANZIONE = :ID_SANZIONE ";

		if (dto.getIdSanzione() == null) {
			LOG.error("[SigitTSanzioneDaoImpl::updateColumnsNote] ERROR chiave primaria non impostata");
			throw new SigitTSanzioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_SANZIONE]
		params.addValue("ID_SANZIONE", dto.getIdSanzione(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTSanzioneDaoImpl::updateColumnsNote] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_SANZIONE table.
	 * @generated
	 */
	public void updateColumnsPerPagamento(SigitTSanzioneDto dto) throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::updateColumnsPerPagamento] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DT_PAGAMENTO = :DT_PAGAMENTO ,FK_STATO_SANZIONE = :FK_STATO_SANZIONE  WHERE ID_SANZIONE = :ID_SANZIONE ";

		if (dto.getIdSanzione() == null) {
			LOG.error("[SigitTSanzioneDaoImpl::updateColumnsPerPagamento] ERROR chiave primaria non impostata");
			throw new SigitTSanzioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DT_PAGAMENTO]
		params.addValue("DT_PAGAMENTO", dto.getDtPagamento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_STATO_SANZIONE]
		params.addValue("FK_STATO_SANZIONE", dto.getFkStatoSanzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_SANZIONE]
		params.addValue("ID_SANZIONE", dto.getIdSanzione(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTSanzioneDaoImpl::updateColumnsPerPagamento] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_SANZIONE table.
	 * @generated
	 */
	public void updateColumnsPerAssegnazione(SigitTSanzioneDto dto) throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::updateColumnsPerAssegnazione] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET CF_RESPONSABILE = :CF_RESPONSABILE ,DENOM_UT_RESPONSABILE = :DENOM_UT_RESPONSABILE  WHERE ID_SANZIONE = :ID_SANZIONE ";

		if (dto.getIdSanzione() == null) {
			LOG.error("[SigitTSanzioneDaoImpl::updateColumnsPerAssegnazione] ERROR chiave primaria non impostata");
			throw new SigitTSanzioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CF_RESPONSABILE]
		params.addValue("CF_RESPONSABILE", dto.getCfResponsabile(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOM_UT_RESPONSABILE]
		params.addValue("DENOM_UT_RESPONSABILE", dto.getDenomUtResponsabile(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_SANZIONE]
		params.addValue("ID_SANZIONE", dto.getIdSanzione(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTSanzioneDaoImpl::updateColumnsPerAssegnazione] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_SANZIONE table.
	 * @generated
	 */
	public void updateColumnsPerAnnullamento(SigitTSanzioneDto dto) throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::updateColumnsPerAnnullamento] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET MOTIVO_ANNULLAMENTO = :MOTIVO_ANNULLAMENTO ,DT_ANNULLAMENTO = :DT_ANNULLAMENTO ,FK_STATO_SANZIONE = :FK_STATO_SANZIONE ,DT_SVEGLIA = :DT_SVEGLIA ,NOTE_SVEGLIA = :NOTE_SVEGLIA  WHERE ID_SANZIONE = :ID_SANZIONE ";

		if (dto.getIdSanzione() == null) {
			LOG.error("[SigitTSanzioneDaoImpl::updateColumnsPerAnnullamento] ERROR chiave primaria non impostata");
			throw new SigitTSanzioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [MOTIVO_ANNULLAMENTO]
		params.addValue("MOTIVO_ANNULLAMENTO", dto.getMotivoAnnullamento(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DT_ANNULLAMENTO]
		params.addValue("DT_ANNULLAMENTO", dto.getDtAnnullamento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_STATO_SANZIONE]
		params.addValue("FK_STATO_SANZIONE", dto.getFkStatoSanzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DT_SVEGLIA]
		params.addValue("DT_SVEGLIA", dto.getDtSveglia(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE_SVEGLIA]
		params.addValue("NOTE_SVEGLIA", dto.getNoteSveglia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_SANZIONE]
		params.addValue("ID_SANZIONE", dto.getIdSanzione(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTSanzioneDaoImpl::updateColumnsPerAnnullamento] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_SANZIONE table.
	 * @generated
	 */
	public void updateColumnsInfoSveglia(SigitTSanzioneDto dto) throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::updateColumnsInfoSveglia] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DT_SVEGLIA = :DT_SVEGLIA ,NOTE_SVEGLIA = :NOTE_SVEGLIA  WHERE ID_SANZIONE = :ID_SANZIONE ";

		if (dto.getIdSanzione() == null) {
			LOG.error("[SigitTSanzioneDaoImpl::updateColumnsInfoSveglia] ERROR chiave primaria non impostata");
			throw new SigitTSanzioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DT_SVEGLIA]
		params.addValue("DT_SVEGLIA", dto.getDtSveglia(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE_SVEGLIA]
		params.addValue("NOTE_SVEGLIA", dto.getNoteSveglia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_SANZIONE]
		params.addValue("ID_SANZIONE", dto.getIdSanzione(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTSanzioneDaoImpl::updateColumnsInfoSveglia] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_SANZIONE table.
	 * @generated
	 */

	public void delete(SigitTSanzionePk pk) throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_SANZIONE = :ID_SANZIONE ";

		if (pk == null) {
			LOG.error("[SigitTSanzioneDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTSanzioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SANZIONE]
		params.addValue("ID_SANZIONE", pk.getIdSanzione(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTSanzioneDaoImpl::delete] END");
	}

	protected SigitTSanzioneDaoRowMapper validaByIdAccertamentoRowMapper = new SigitTSanzioneDaoRowMapper(null,
			SigitTSanzioneDto.class, this);

	protected SigitTSanzioneDaoRowMapper byExampleRowMapper = new SigitTSanzioneDaoRowMapper(null,
			SigitTSanzioneDto.class, this);

	protected SigitTSanzioneDaoRowMapper sveglieAttiveByCFRowMapper = new SigitTSanzioneDaoRowMapper(null,
			SigitTSanzioneDto.class, this);

	protected SigitTSanzioneDaoRowMapper validaByIdIspezioneRowMapper = new SigitTSanzioneDaoRowMapper(null,
			SigitTSanzioneDto.class, this);

	protected SigitTSanzioneDaoRowMapper findByPrimaryKeyRowMapper = new SigitTSanzioneDaoRowMapper(null,
			SigitTSanzioneDto.class, this);

	protected SigitTSanzioneDaoRowMapper byRicercaRowMapper = new SigitTSanzioneDaoRowMapper(null,
			SigitTSanzioneDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_SANZIONE";
	}

	/** 
	 * Implementazione del finder validaByIdAccertamento
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTSanzioneDto> findValidaByIdAccertamento(java.lang.Integer input)
			throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::findValidaByIdAccertamento] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_SANZIONE,FK_STATO_SANZIONE,FK_ISPEZIONE_2018,FK_ACCERTAMENTO,FK_PF_SANZIONATA,FK_PG_SANZIONATA,MOTIVAZIONE_SANZIONE,VALORE_SANZIONE,DT_CREAZIONE,DT_COMUNICAZIONE,DT_PAGAMENTO,NOTE,MOTIVO_ANNULLAMENTO,DT_ANNULLAMENTO,CF_RESPONSABILE,DENOM_UT_RESPONSABILE,DT_SVEGLIA,NOTE_SVEGLIA ");
		sql.append(" FROM SIGIT_T_SANZIONE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R508273968) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" FK_ACCERTAMENTO = :fkAccertamento");
		sql.append(" AND FK_STATO_SANZIONE != " + Constants.ID_STATO_SANZIONE_ANNULLATA);
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-542812398) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("fkAccertamento", input);

		/*PROTECTED REGION END*/
		List<SigitTSanzioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, validaByIdAccertamentoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTSanzioneDaoImpl::findValidaByIdAccertamento] esecuzione query", ex);
			throw new SigitTSanzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTSanzioneDaoImpl", "findValidaByIdAccertamento", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTSanzioneDaoImpl::findValidaByIdAccertamento] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTSanzioneDto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTSanzioneDto input)
			throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::findByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_SANZIONE,FK_STATO_SANZIONE,FK_ISPEZIONE_2018,FK_ACCERTAMENTO,FK_PF_SANZIONATA,FK_PG_SANZIONATA,MOTIVAZIONE_SANZIONE,VALORE_SANZIONE,DT_CREAZIONE,DT_COMUNICAZIONE,DT_PAGAMENTO,NOTE,MOTIVO_ANNULLAMENTO,DT_ANNULLAMENTO,CF_RESPONSABILE,DENOM_UT_RESPONSABILE,DT_SVEGLIA,NOTE_SVEGLIA ");
		sql.append(" FROM SIGIT_T_SANZIONE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R750201772) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" 1 = 1 ");

		if (input.getFkAccertamento() != null) {
			sql.append(" AND FK_ACCERTAMENTO = :fkAccertamento");
		}

		if (input.getFkIspezione2018() != null) {
			sql.append(" AND FK_ISPEZIONE_2018 = :fkIspezione");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1632985066) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input.getFkAccertamento() != null) {
			paramMap.addValue("fkAccertamento", input.getFkAccertamento(), java.sql.Types.INTEGER);
		}

		if (input.getFkIspezione2018() != null) {
			paramMap.addValue("fkIspezione", input.getFkIspezione2018(), java.sql.Types.INTEGER);
		}

		/*PROTECTED REGION END*/
		List<SigitTSanzioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTSanzioneDaoImpl::findByExample] esecuzione query", ex);
			throw new SigitTSanzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTSanzioneDaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTSanzioneDaoImpl::findByExample] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder sveglieAttiveByCF
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTSanzioneDto> findSveglieAttiveByCF(java.lang.String input) throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::findSveglieAttiveByCF] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_SANZIONE,FK_STATO_SANZIONE,FK_ISPEZIONE_2018,FK_ACCERTAMENTO,FK_PF_SANZIONATA,FK_PG_SANZIONATA,MOTIVAZIONE_SANZIONE,VALORE_SANZIONE,DT_CREAZIONE,DT_COMUNICAZIONE,DT_PAGAMENTO,NOTE,MOTIVO_ANNULLAMENTO,DT_ANNULLAMENTO,CF_RESPONSABILE,DENOM_UT_RESPONSABILE,DT_SVEGLIA,NOTE_SVEGLIA ");
		sql.append(" FROM SIGIT_T_SANZIONE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-234905971) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("1 = 1");

		// Mancano ancora i campi
		//sql.append("nome = :nome");
		sql.append(" AND ID_SANZIONE > 0 ");

		// sto cercando gli accertamenti assegnati
		sql.append(" AND DT_SVEGLIA IS NOT NULL");
		sql.append(" AND CF_RESPONSABILE = :cfUtente");

		sql.append(" ORDER BY DT_SVEGLIA DESC");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-2106554027) ENABLED START*/
		//***aggiungere tutte le condizioni

		// Mancano ancora i campi
		paramMap.addValue("cfUtente", input);

		/*PROTECTED REGION END*/
		List<SigitTSanzioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, sveglieAttiveByCFRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTSanzioneDaoImpl::findSveglieAttiveByCF] esecuzione query", ex);
			throw new SigitTSanzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTSanzioneDaoImpl", "findSveglieAttiveByCF", "esecuzione query", sql.toString());
			LOG.debug("[SigitTSanzioneDaoImpl::findSveglieAttiveByCF] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder validaByIdIspezione
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTSanzioneDto> findValidaByIdIspezione(java.lang.Integer input) throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::findValidaByIdIspezione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_SANZIONE,FK_STATO_SANZIONE,FK_ISPEZIONE_2018,FK_ACCERTAMENTO,FK_PF_SANZIONATA,FK_PG_SANZIONATA,MOTIVAZIONE_SANZIONE,VALORE_SANZIONE,DT_CREAZIONE,DT_COMUNICAZIONE,DT_PAGAMENTO,NOTE,MOTIVO_ANNULLAMENTO,DT_ANNULLAMENTO,CF_RESPONSABILE,DENOM_UT_RESPONSABILE,DT_SVEGLIA,NOTE_SVEGLIA ");
		sql.append(" FROM SIGIT_T_SANZIONE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1034383270) ENABLED START*/
		sql.append(" FK_ISPEZIONE_2018 = :fkIspezione");
		sql.append(" AND FK_STATO_SANZIONE != " + Constants.ID_STATO_SANZIONE_ANNULLATA);
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1120546520) ENABLED START*/

		paramMap.addValue("fkIspezione", input);

		/*PROTECTED REGION END*/
		List<SigitTSanzioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, validaByIdIspezioneRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTSanzioneDaoImpl::findValidaByIdIspezione] esecuzione query", ex);
			throw new SigitTSanzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTSanzioneDaoImpl", "findValidaByIdIspezione", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTSanzioneDaoImpl::findValidaByIdIspezione] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_T_SANZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTSanzioneDto findByPrimaryKey(SigitTSanzionePk pk) throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_SANZIONE,FK_STATO_SANZIONE,FK_ISPEZIONE_2018,FK_ACCERTAMENTO,FK_PF_SANZIONATA,FK_PG_SANZIONATA,MOTIVAZIONE_SANZIONE,VALORE_SANZIONE,DT_CREAZIONE,DT_COMUNICAZIONE,DT_PAGAMENTO,NOTE,MOTIVO_ANNULLAMENTO,DT_ANNULLAMENTO,CF_RESPONSABILE,DENOM_UT_RESPONSABILE,DT_SVEGLIA,NOTE_SVEGLIA FROM "
						+ getTableName() + " WHERE ID_SANZIONE = :ID_SANZIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SANZIONE]
		params.addValue("ID_SANZIONE", pk.getIdSanzione(), java.sql.Types.INTEGER);

		List<SigitTSanzioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTSanzioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTSanzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTSanzioneDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTSanzioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byRicerca
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTSanzioneDto> findByRicerca(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaSanzioniFilter input)
			throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::findByRicerca] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R245199471) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_SANZIONE,FK_STATO_SANZIONE,FK_ISPEZIONE_2018,FK_ACCERTAMENTO,FK_PF_SANZIONATA,FK_PG_SANZIONATA,MOTIVAZIONE_SANZIONE,VALORE_SANZIONE,DT_CREAZIONE,DT_COMUNICAZIONE,DT_PAGAMENTO,NOTE,MOTIVO_ANNULLAMENTO,DT_ANNULLAMENTO,CF_RESPONSABILE,DENOM_UT_RESPONSABILE,DT_SVEGLIA,NOTE_SVEGLIA");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1378167615) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_SANZIONE");

		if (GenericUtil.isNotNullOrEmpty(input.getCfPFSanzionata())) {
			sql.append(" JOIN sigit_t_persona_fisica FISICA ON FISICA.id_persona_fisica = FK_PF_SANZIONATA");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCfPGSanzionata())) {
			sql.append(
					" JOIN sigit_t_persona_giuridica GIURIDICA ON GIURIDICA.id_persona_giuridica = FK_PG_SANZIONATA");
		}
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R9112665) ENABLED START*/
		sql.append(" 1 = 1 ");

		if (GenericUtil.isNotNullOrEmpty(input.getCfPFSanzionata())) {
			sql.append(" AND FISICA.codice_fiscale = :codicefiscale");
			paramMap.addValue("codicefiscale", input.getCfPFSanzionata());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCfPGSanzionata())) {
			sql.append(" AND GIURIDICA.codice_fiscale = :piva");
			paramMap.addValue("piva", input.getCfPGSanzionata());
		}

		//		input.getCfResponsabile()????
		if (GenericUtil.isNotNullOrEmpty(input.getCfResponsabile())) {
			sql.append(" AND CF_RESPONSABILE = :cfResponsabile");
			paramMap.addValue("cfResponsabile", input.getCfResponsabile());
		}

		if (input.getDataAnnullamentoA() != null) {
			sql.append(" AND DT_ANNULLAMENTO <= :dataAnnullamentoA");
			paramMap.addValue("dataAnnullamentoA", input.getDataAnnullamentoA());
		}

		if (input.getDataAnnullamentoDa() != null) {
			sql.append(" AND DT_ANNULLAMENTO >= :dataAnnullamentoDa");
			paramMap.addValue("dataAnnullamentoDa", input.getDataAnnullamentoDa());
		}

		if (input.getDataComunicazioneA() != null) {
			sql.append(" AND DT_COMUNICAZIONE <= :dataComunicazioneA");
			paramMap.addValue("dataComunicazioneA", input.getDataComunicazioneA());
		}

		if (input.getDataComunicazioneDa() != null) {
			sql.append(" AND DT_COMUNICAZIONE >= :dataComunicazioneDa");
			paramMap.addValue("dataComunicazioneDa", input.getDataComunicazioneDa());
		}

		if (input.getDataCreazioneA() != null) {
			sql.append(" AND DT_CREAZIONE <= :dataCreazioneA");
			paramMap.addValue("dataCreazioneA", input.getDataCreazioneA());
		}

		if (input.getDataCreazioneDa() != null) {
			sql.append(" AND DT_CREAZIONE >= :dataCreazioneDa");
			paramMap.addValue("dataCreazioneDa", input.getDataCreazioneDa());
		}

		if (input.getDataPagamentoA() != null) {
			sql.append(" AND DT_CREAZIONE <= :dataPagamentoA");
			paramMap.addValue("dataPagamentoA", input.getDataPagamentoA());
		}

		if (input.getDataPagamentoDa() != null) {
			sql.append(" AND DT_CREAZIONE >= :dataPagamentoDa");
			paramMap.addValue("dataPagamentoDa", input.getDataPagamentoDa());
		}

		if (input.getFkStatoSanzione() != null) {
			sql.append(" AND fk_stato_sanzione = :fkStato");
			paramMap.addValue("fkStato", input.getFkStatoSanzione());
		}

		if (input.getIdentificativo() != null) {
			sql.append(" AND id_sanzione = :identificativo");
			paramMap.addValue("identificativo", input.getIdentificativo());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getMotivo())) {
			sql.append(" AND motivazione_sanzione LIKE :motivo");
			paramMap.addValue("motivo", "%" + input.getMotivo() + "%");
		}

		if (input.getValoreSanzioneA() != null) {
			sql.append(" AND valore_sanzione <= :valoreA");
			paramMap.addValue("valoreA", input.getValoreSanzioneA());
		}

		if (input.getValoreSanzioneDa() != null) {
			sql.append(" AND valore_sanzione >= :valoreDa");
			paramMap.addValue("valoreDa", input.getValoreSanzioneDa());
		}

		if (input.isAssociataAdAccertamento()) {
			sql.append(" AND fk_accertamento IS NOT NULL");
		}

		if (input.isAssociataAdIspezione()) {
			sql.append(" AND fk_ispezione_2018 IS NOT NULL");
		}

		sql.append(" ORDER BY ID_SANZIONE DESC");

		sql.append(
				" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RIGHE_RIC_AVZ_IMP') ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1163056393) ENABLED START*/

		/*PROTECTED REGION END*/
		List<SigitTSanzioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byRicercaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTSanzioneDaoImpl::findByRicerca] esecuzione query", ex);
			throw new SigitTSanzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTSanzioneDaoImpl", "findByRicerca", "esecuzione query", sql.toString());
			LOG.debug("[SigitTSanzioneDaoImpl::findByRicerca] END");
		}
		return list;
	}

}
