package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTCompCgDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTCompCgCompletoDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTCompCgDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompCgCompletoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompCgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompCgPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompCgDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class SigitTCompCgDaoImpl extends AbstractDAO implements SigitTCompCgDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);

	protected NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected SigitTCompCgDaoRowMapper byExampleRowMapper = new SigitTCompCgDaoRowMapper(null, SigitTCompCgDto.class, this);
	protected SigitTCompCgCompletoDaoRowMapper rowMapperCompleto = new SigitTCompCgCompletoDaoRowMapper(null, SigitTCompCgCompletoDto.class, this);

	public SigitTCompCgPk insert(SigitTCompCgDto dto) {
		LOG.debug("[SigitTCompCgDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,POTENZA_ELETTRICA_KW,TEMP_H2O_OUT_MIN,TEMP_H2O_OUT_MAX,TEMP_H2O_IN_MIN,TEMP_H2O_IN_MAX,TEMP_H2O_MOTORE_MIN,TEMP_H2O_MOTORE_MAX,TEMP_FUMI_VALLE_MIN,TEMP_FUMI_VALLE_MAX,TEMP_FUMI_MONTE_MIN,TEMP_FUMI_MONTE_MAX,CO_MIN,CO_MAX,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,FK_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,ALIMENTAZIONE,NOTE,TEMPO_MANUT_ANNI ) VALUES (  :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :CODICE_IMPIANTO , :TIPOLOGIA , :POTENZA_ELETTRICA_KW , :TEMP_H2O_OUT_MIN , :TEMP_H2O_OUT_MAX , :TEMP_H2O_IN_MIN , :TEMP_H2O_IN_MAX , :TEMP_H2O_MOTORE_MIN , :TEMP_H2O_MOTORE_MAX , :TEMP_FUMI_VALLE_MIN , :TEMP_FUMI_VALLE_MAX , :TEMP_FUMI_MONTE_MIN , :TEMP_FUMI_MONTE_MAX , :CO_MIN , :CO_MAX , :DATA_DISMISS , :FLG_DISMISSIONE , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :FK_MARCA , :FK_COMBUSTIBILE , :MATRICOLA , :MODELLO , :POTENZA_TERMICA_KW , :ALIMENTAZIONE , :NOTE , :TEMPO_MANUT_ANNI  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA]
		params.addValue("TIPOLOGIA", dto.getTipologia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POTENZA_ELETTRICA_KW]
		params.addValue("POTENZA_ELETTRICA_KW", dto.getPotenzaElettricaKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_H2O_OUT_MIN]
		params.addValue("TEMP_H2O_OUT_MIN", dto.getTempH2oOutMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_H2O_OUT_MAX]
		params.addValue("TEMP_H2O_OUT_MAX", dto.getTempH2oOutMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_H2O_IN_MIN]
		params.addValue("TEMP_H2O_IN_MIN", dto.getTempH2oInMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_H2O_IN_MAX]
		params.addValue("TEMP_H2O_IN_MAX", dto.getTempH2oInMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_H2O_MOTORE_MIN]
		params.addValue("TEMP_H2O_MOTORE_MIN", dto.getTempH2oMotoreMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_H2O_MOTORE_MAX]
		params.addValue("TEMP_H2O_MOTORE_MAX", dto.getTempH2oMotoreMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_FUMI_VALLE_MIN]
		params.addValue("TEMP_FUMI_VALLE_MIN", dto.getTempFumiValleMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_FUMI_VALLE_MAX]
		params.addValue("TEMP_FUMI_VALLE_MAX", dto.getTempFumiValleMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_FUMI_MONTE_MIN]
		params.addValue("TEMP_FUMI_MONTE_MIN", dto.getTempFumiMonteMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_FUMI_MONTE_MAX]
		params.addValue("TEMP_FUMI_MONTE_MAX", dto.getTempFumiMonteMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CO_MIN]
		params.addValue("CO_MIN", dto.getCoMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CO_MAX]
		params.addValue("CO_MAX", dto.getCoMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_DISMISS]
		params.addValue("DATA_DISMISS", dto.getDataDismiss(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FLG_DISMISSIONE]
		params.addValue("FLG_DISMISSIONE", dto.getFlgDismissione(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_MARCA]
		params.addValue("FK_MARCA", dto.getFkMarca(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_COMBUSTIBILE]
		params.addValue("FK_COMBUSTIBILE", dto.getFkCombustibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MATRICOLA]
		params.addValue("MATRICOLA", dto.getMatricola(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MODELLO]
		params.addValue("MODELLO", dto.getModello(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POTENZA_TERMICA_KW]
		params.addValue("POTENZA_TERMICA_KW", dto.getPotenzaTermicaKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ALIMENTAZIONE]
		params.addValue("ALIMENTAZIONE", dto.getAlimentazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TEMPO_MANUT_ANNI]
		params.addValue("TEMPO_MANUT_ANNI", dto.getTempoManutAnni(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCompCgDaoImpl::insert] END");
		return dto.createPk();

	}

	/**
	 * Custom deleter in the SIGIT_T_COMP_CG table.
	 *
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompCgDaoException {
		LOG.debug("[SigitTCompCgDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-1709946031) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompCgDaoImpl::customDeleterByCodImpianto] END");
	}

	public List<SigitTCompCgDto> ricercaComponentiByFiltro(CompFilter input) throws SigitTCompCgDaoException {
		LOG.debug("[SigitTCompCgDaoImpl::findByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,POTENZA_ELETTRICA_KW,TEMP_H2O_OUT_MIN,TEMP_H2O_OUT_MAX,TEMP_H2O_IN_MIN,TEMP_H2O_IN_MAX,TEMP_H2O_MOTORE_MIN,TEMP_H2O_MOTORE_MAX,TEMP_FUMI_VALLE_MIN,TEMP_FUMI_VALLE_MAX,TEMP_FUMI_MONTE_MIN,TEMP_FUMI_MONTE_MAX,CO_MIN,CO_MAX,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,FK_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,ALIMENTAZIONE,NOTE,TEMPO_MANUT_ANNI ");
		sql.append(" FROM SIGIT_T_COMP_CG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1048680528) ENABLED START*/
		sql.append(" 1 = 1 ");

		if (input.getCodImpianto() != null) {
			sql.append(" AND CODICE_IMPIANTO = :codiceImpianto");
		}

		if (input.getProgressivo() != null) {
			sql.append(" AND PROGRESSIVO = :progressivo");
		}

		if (input.getDataInstallazione() != null) {
			sql.append(" AND DATA_INSTALL = :dataInstall");
		}

		sql.append(" AND ID_TIPO_COMPONENTE = '" + it.csi.sigit.sigitext.business.util.Constants.TIPO_COMPONENTE_CG + "'");

		if (input.getCodImpianto() != null) {
			paramMap.addValue("codiceImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		}

		if (input.getDataInstallazione() != null) {
			paramMap.addValue("dataInstall", input.getDataInstallazione(), java.sql.Types.DATE);
		}

		if (input.getProgressivo() != null) {
			paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		}

		sql.append(" ORDER BY PROGRESSIVO ASC, DATA_INSTALL DESC");

		/*PROTECTED REGION END*/
		List<SigitTCompCgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompCgDaoImpl::findByExample] esecuzione query", ex);
			throw new SigitTCompCgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompCgDaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompCgDaoImpl::findByExample] END");
		}
		return list;
	}

	@Override
	public List<SigitTCompCgCompletoDto> ricercaComponentiCompletoByFiltro(CompFilter input) throws SigitTCompCgDaoException {
		LOG.debug("[SigitTCompCgDaoImpl::ricercaComponentiCompletoByFiltro] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("select cg.*, marca.des_marca, combustibile.des_combustibile, pg.codice_fiscale, pg.numero_rea, pg.sigla_rea "
				+ "from sigit_t_comp_cg cg join sigit_r_comp4_manut manut on cg.codice_impianto = manut.codice_impianto and cg.progressivo = manut.progressivo and cg.id_tipo_componente = manut.id_tipo_componente "
				+ "join sigit_t_persona_giuridica pg on pg.id_persona_giuridica = manut.fk_persona_giuridica "
				+ "left join sigit_d_marca marca on marca.id_marca = cg.fk_marca " + "left join sigit_d_combustibile combustibile on combustibile.id_combustibile = cg.fk_combustibile "
				+ "where manut.data_fine is null");

		sql.append(" AND cg.id_tipo_componente = '" + it.csi.sigit.sigitext.business.util.Constants.TIPO_COMPONENTE_CG + "'");

		if (input.getCodImpianto() != null) {
			sql.append(" AND cg.codice_impianto = :codiceImpianto");
			paramMap.addValue("codiceImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		}

		if (input.getProgressivo() != null) {
			sql.append(" AND cg.progressivo = :progressivo");
			paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		}

		if (input.getIdPG() != null) {
			sql.append(" AND manut.fk_persona_giuridica = :persona");
			paramMap.addValue("persona", input.getIdPG(), java.sql.Types.NUMERIC);
		}

		sql.append(" ORDER BY PROGRESSIVO ASC, DATA_INSTALL DESC");

		List<SigitTCompCgCompletoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, rowMapperCompleto);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompCgDaoImpl::ricercaComponentiCompletoByFiltro] esecuzione query", ex);
			throw new SigitTCompCgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompCgDaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompCgDaoImpl::ricercaComponentiCompletoByFiltro] END");
		}
		return list;
	}

	public void update(SigitTCompCgDto dto) throws SigitTCompCgDaoException {
		LOG.debug("[SigitTCompCgDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET TIPOLOGIA = :TIPOLOGIA ,POTENZA_ELETTRICA_KW = :POTENZA_ELETTRICA_KW ,TEMP_H2O_OUT_MIN = :TEMP_H2O_OUT_MIN ,TEMP_H2O_OUT_MAX = :TEMP_H2O_OUT_MAX ,TEMP_H2O_IN_MIN = :TEMP_H2O_IN_MIN ,TEMP_H2O_IN_MAX = :TEMP_H2O_IN_MAX ,TEMP_H2O_MOTORE_MIN = :TEMP_H2O_MOTORE_MIN ,TEMP_H2O_MOTORE_MAX = :TEMP_H2O_MOTORE_MAX ,TEMP_FUMI_VALLE_MIN = :TEMP_FUMI_VALLE_MIN ,TEMP_FUMI_VALLE_MAX = :TEMP_FUMI_VALLE_MAX ,TEMP_FUMI_MONTE_MIN = :TEMP_FUMI_MONTE_MIN ,TEMP_FUMI_MONTE_MAX = :TEMP_FUMI_MONTE_MAX ,CO_MIN = :CO_MIN ,CO_MAX = :CO_MAX ,DATA_DISMISS = :DATA_DISMISS ,FLG_DISMISSIONE = :FLG_DISMISSIONE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,FK_MARCA = :FK_MARCA ,FK_COMBUSTIBILE = :FK_COMBUSTIBILE ,MATRICOLA = :MATRICOLA ,MODELLO = :MODELLO ,POTENZA_TERMICA_KW = :POTENZA_TERMICA_KW ,ALIMENTAZIONE = :ALIMENTAZIONE ,NOTE = :NOTE ,TEMPO_MANUT_ANNI = :TEMPO_MANUT_ANNI  WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND DATA_INSTALL = :DATA_INSTALL  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (dto.getIdTipoComponente() == null || dto.getProgressivo() == null || dto.getDataInstall() == null || dto.getCodiceImpianto() == null) {
			LOG.error("[SigitTCompCgDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTCompCgDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA]
		params.addValue("TIPOLOGIA", dto.getTipologia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POTENZA_ELETTRICA_KW]
		params.addValue("POTENZA_ELETTRICA_KW", dto.getPotenzaElettricaKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_H2O_OUT_MIN]
		params.addValue("TEMP_H2O_OUT_MIN", dto.getTempH2oOutMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_H2O_OUT_MAX]
		params.addValue("TEMP_H2O_OUT_MAX", dto.getTempH2oOutMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_H2O_IN_MIN]
		params.addValue("TEMP_H2O_IN_MIN", dto.getTempH2oInMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_H2O_IN_MAX]
		params.addValue("TEMP_H2O_IN_MAX", dto.getTempH2oInMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_H2O_MOTORE_MIN]
		params.addValue("TEMP_H2O_MOTORE_MIN", dto.getTempH2oMotoreMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_H2O_MOTORE_MAX]
		params.addValue("TEMP_H2O_MOTORE_MAX", dto.getTempH2oMotoreMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_FUMI_VALLE_MIN]
		params.addValue("TEMP_FUMI_VALLE_MIN", dto.getTempFumiValleMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_FUMI_VALLE_MAX]
		params.addValue("TEMP_FUMI_VALLE_MAX", dto.getTempFumiValleMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_FUMI_MONTE_MIN]
		params.addValue("TEMP_FUMI_MONTE_MIN", dto.getTempFumiMonteMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TEMP_FUMI_MONTE_MAX]
		params.addValue("TEMP_FUMI_MONTE_MAX", dto.getTempFumiMonteMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CO_MIN]
		params.addValue("CO_MIN", dto.getCoMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CO_MAX]
		params.addValue("CO_MAX", dto.getCoMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_DISMISS]
		params.addValue("DATA_DISMISS", dto.getDataDismiss(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FLG_DISMISSIONE]
		params.addValue("FLG_DISMISSIONE", dto.getFlgDismissione(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_MARCA]
		params.addValue("FK_MARCA", dto.getFkMarca(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_COMBUSTIBILE]
		params.addValue("FK_COMBUSTIBILE", dto.getFkCombustibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MATRICOLA]
		params.addValue("MATRICOLA", dto.getMatricola(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MODELLO]
		params.addValue("MODELLO", dto.getModello(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POTENZA_TERMICA_KW]
		params.addValue("POTENZA_TERMICA_KW", dto.getPotenzaTermicaKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ALIMENTAZIONE]
		params.addValue("ALIMENTAZIONE", dto.getAlimentazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TEMPO_MANUT_ANNI]
		params.addValue("TEMPO_MANUT_ANNI", dto.getTempoManutAnni(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompCgDaoImpl::update] END");
	}

	public void delete(SigitTCompCgPk pk) throws SigitTCompCgDaoException {
		LOG.debug("[SigitTCompCgDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND DATA_INSTALL = :DATA_INSTALL  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (pk == null) {
			LOG.error("[SigitTCompCgDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTCompCgDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", pk.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", pk.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompCgDaoImpl::delete] END");
	}

	@Override
	public void delete(CompFilter compFilter) throws SigitTCompCgDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (compFilter == null) {
			LOG.error("[SigitTCompGtDaoImpl::delete] ERROR filtroo non impostato");
			throw new SigitTCompCgDaoException("Filtro non impostato");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", compFilter.getTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", compFilter.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", compFilter.getCodImpianto(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompGtDaoImpl::delete] END");
	}

	@Override
	public void customDeleterByFilter(CompFilter filter) throws SigitTCompCgDaoException {
		LOG.debug("[SigitTCompCgDaoImpl::customDeleterByFilter] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ID_TIPO_COMPONENTE", filter.getTipoComponente(), java.sql.Types.VARCHAR);
		params.addValue("PROGRESSIVO", filter.getProgressivo(), java.sql.Types.NUMERIC);
		params.addValue("CODICE_IMPIANTO", filter.getCodImpianto(), java.sql.Types.NUMERIC);
		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompCgDaoImpl::customDeleterByFilter] END");
	}

	public String getTableName() {
		return "SIGIT_T_COMP_CG";
	}

}
