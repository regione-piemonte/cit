package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTCompGtDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTCompGtCompletoDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTCompGtDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGtCompletoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompGtDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class SigitTCompGtDaoImpl extends AbstractDAO implements SigitTCompGtDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);

	protected NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected SigitTCompGtDaoRowMapper rowMapper = new SigitTCompGtDaoRowMapper(null, SigitTCompGtDto.class, this);

	protected SigitTCompGtCompletoDaoRowMapper rowMapperCompleto = new SigitTCompGtCompletoDaoRowMapper(null, SigitTCompGtCompletoDto.class, this);

	public SigitTCompGtPk insert(SigitTCompGtDto dto) {
		LOG.debug("[SigitTCompGtDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,FK_FLUIDO,FK_DETTAGLIO_GT,RENDIMENTO_PERC,N_MODULI,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,FK_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,NOTE,TEMPO_MANUT_ANNI,MEDI_IMP_ORE_OPERATIVE,ID_TIPO_CANNA_FUMARIA ) VALUES (  :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :CODICE_IMPIANTO , :FK_FLUIDO , :FK_DETTAGLIO_GT , :RENDIMENTO_PERC , :N_MODULI , :DATA_DISMISS , :FLG_DISMISSIONE , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :FK_MARCA , :FK_COMBUSTIBILE , :MATRICOLA , :MODELLO , :POTENZA_TERMICA_KW , :NOTE , :TEMPO_MANUT_ANNI , :MEDI_IMP_ORE_OPERATIVE , :ID_TIPO_CANNA_FUMARIA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_FLUIDO]
		params.addValue("FK_FLUIDO", dto.getFkFluido(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_DETTAGLIO_GT]
		params.addValue("FK_DETTAGLIO_GT", dto.getFkDettaglioGt(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [RENDIMENTO_PERC]
		params.addValue("RENDIMENTO_PERC", dto.getRendimentoPerc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [N_MODULI]
		params.addValue("N_MODULI", dto.getNModuli(), java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TEMPO_MANUT_ANNI]
		params.addValue("TEMPO_MANUT_ANNI", dto.getTempoManutAnni(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MEDI_IMP_ORE_OPERATIVE]
		params.addValue("MEDI_IMP_ORE_OPERATIVE", dto.getMediImpOreOperative(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CANNA_FUMARIA]
		params.addValue("ID_TIPO_CANNA_FUMARIA", dto.getIdTipoCannaFumaria(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCompGtDaoImpl::insert] END");
		return dto.createPk();

	}

	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::customDeleterByCodImpianto] START");

		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompGtDaoImpl::customDeleterByCodImpianto] END");
	}

	public List<SigitTCompGtCompletoDto> ricercaComponentiByFiltro(CompFilter input) throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::findByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("select stcg.*, sddg.des_dettaglio_gt, sdf.des_fluido, sdc.des_combustibile, sdm.des_marca, pg.codice_fiscale, pg.numero_rea, pg.sigla_rea "
				+ "from sigit_t_comp_gt stcg join sigit_r_comp4_manut srcm on stcg.codice_impianto = srcm.codice_impianto and stcg.progressivo = srcm.progressivo and srcm.id_tipo_componente = stcg.id_tipo_componente "
				+ "join sigit_t_persona_giuridica pg on pg.id_persona_giuridica = srcm.fk_persona_giuridica "
				+ "left join sigit_d_dettaglio_gt sddg on sddg.id_dettaglio_gt = stcg.fk_dettaglio_gt " + "left join sigit_d_fluido sdf on sdf.id_fluido = stcg.fk_fluido "
				+ "left join sigit_d_combustibile sdc on sdc.id_combustibile = stcg.fk_combustibile " + "left join sigit_d_marca sdm on sdm.id_marca = stcg.fk_marca where srcm.data_fine is null");
		sql.append(" AND srcm.id_tipo_componente = '" + it.csi.sigit.sigitext.business.util.Constants.TIPO_COMPONENTE_GT + "'");

		if (input.getCodImpianto() != null) {
			sql.append(" AND srcm.codice_impianto = :codiceImpianto");
			paramMap.addValue("codiceImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		}

		if (input.getProgressivo() != null) {
			sql.append(" AND srcm.progressivo = :progressivo");
			paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		}

		if (input.getIdPG() != null) {
			sql.append(" AND srcm.fk_persona_giuridica = :persona");
			paramMap.addValue("persona", input.getIdPG(), java.sql.Types.NUMERIC);
		}

		sql.append(" ORDER BY PROGRESSIVO ASC, DATA_INSTALL DESC");

		List<SigitTCompGtCompletoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, rowMapperCompleto);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompGtDaoImpl::findByExample] esecuzione query", ex);
			throw new SigitTCompGtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompGtDaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompGtDaoImpl::findByExample] END");
		}
		return list;
	}

	@Override
	public void update(SigitTCompGtDto dto) throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_FLUIDO = :FK_FLUIDO ,FK_DETTAGLIO_GT = :FK_DETTAGLIO_GT ,RENDIMENTO_PERC = :RENDIMENTO_PERC ,N_MODULI = :N_MODULI ,DATA_DISMISS = :DATA_DISMISS ,FLG_DISMISSIONE = :FLG_DISMISSIONE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,FK_MARCA = :FK_MARCA ,FK_COMBUSTIBILE = :FK_COMBUSTIBILE ,MATRICOLA = :MATRICOLA ,MODELLO = :MODELLO ,POTENZA_TERMICA_KW = :POTENZA_TERMICA_KW ,NOTE = :NOTE ,TEMPO_MANUT_ANNI = :TEMPO_MANUT_ANNI ,MEDI_IMP_ORE_OPERATIVE = :MEDI_IMP_ORE_OPERATIVE ,ID_TIPO_CANNA_FUMARIA = :ID_TIPO_CANNA_FUMARIA  WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND DATA_INSTALL = :DATA_INSTALL  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (dto.getIdTipoComponente() == null || dto.getProgressivo() == null || dto.getDataInstall() == null || dto.getCodiceImpianto() == null) {
			LOG.error("[SigitTCompGtDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTCompGtDaoException("Chiave primaria non impostata");
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

		// valorizzazione paametro relativo a colonna [FK_FLUIDO]
		params.addValue("FK_FLUIDO", dto.getFkFluido(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_DETTAGLIO_GT]
		params.addValue("FK_DETTAGLIO_GT", dto.getFkDettaglioGt(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [RENDIMENTO_PERC]
		params.addValue("RENDIMENTO_PERC", dto.getRendimentoPerc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [N_MODULI]
		params.addValue("N_MODULI", dto.getNModuli(), java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TEMPO_MANUT_ANNI]
		params.addValue("TEMPO_MANUT_ANNI", dto.getTempoManutAnni(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MEDI_IMP_ORE_OPERATIVE]
		params.addValue("MEDI_IMP_ORE_OPERATIVE", dto.getMediImpOreOperative(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CANNA_FUMARIA]
		params.addValue("ID_TIPO_CANNA_FUMARIA", dto.getIdTipoCannaFumaria(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompGtDaoImpl::update] END");
	}

	@Override
	public void delete(CompFilter compFilter) throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (compFilter == null) {
			LOG.error("[SigitTCompGtDaoImpl::delete] ERROR filtroo non impostato");
			throw new SigitTCompGtDaoException("Filtro non impostato");
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

	public void delete(SigitTCompGtPk pk) throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND DATA_INSTALL = :DATA_INSTALL  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (pk == null) {
			LOG.error("[SigitTCompGtDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTCompGtDaoException("Chiave primaria non impostata");
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
		LOG.debug("[SigitTCompGtDaoImpl::delete] END");
	}

	public void customDeleterByFilter(CompFilter filter) throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::customDeleterByFilter] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ID_TIPO_COMPONENTE", filter.getTipoComponente(), java.sql.Types.VARCHAR);
		params.addValue("PROGRESSIVO", filter.getProgressivo(), java.sql.Types.NUMERIC);
		params.addValue("CODICE_IMPIANTO", filter.getCodImpianto(), java.sql.Types.NUMERIC);
		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompGtDaoImpl::customDeleterByFilter] END");
	}

	public String getTableName() {
		return "SIGIT_T_COMP_GT";
	}

}
