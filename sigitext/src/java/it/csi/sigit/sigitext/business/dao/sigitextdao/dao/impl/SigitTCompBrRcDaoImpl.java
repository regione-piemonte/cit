package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTCompBrRcDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTCompBrRcDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompBrRcDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompBrRcPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompBrRcDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class SigitTCompBrRcDaoImpl extends AbstractDAO implements SigitTCompBrRcDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);

	protected SigitTCompBrRcDaoRowMapper BrRcLegateAGtRowMapper = new SigitTCompBrRcDaoRowMapper(null, SigitTCompBrRcDto.class, this);

	protected NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public SigitTCompBrRcPk insert(SigitTCompBrRcDto dto) {
		LOG.debug("[SigitTCompBrRcDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_COMP_BR_RC,TIPOLOGIA_BR_RC,PROGRESSIVO_BR_RC,FK_TIPO_COMPONENTE,FK_PROGRESSIVO,FK_DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,POT_TERM_MAX_KW,POT_TERM_MIN_KW,DATA_INSTALL,DATA_DISMISS,FK_MARCA,MODELLO,MATRICOLA,FK_COMBUSTIBILE,FLG_DISMISSIONE ) VALUES (  :ID_COMP_BR_RC , :TIPOLOGIA_BR_RC , :PROGRESSIVO_BR_RC , :FK_TIPO_COMPONENTE , :FK_PROGRESSIVO , :FK_DATA_INSTALL , :CODICE_IMPIANTO , :TIPOLOGIA , :POT_TERM_MAX_KW , :POT_TERM_MIN_KW , :DATA_INSTALL , :DATA_DISMISS , :FK_MARCA , :MODELLO , :MATRICOLA , :FK_COMBUSTIBILE , :FLG_DISMISSIONE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_COMP_BR_RC]
		params.addValue("ID_COMP_BR_RC", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA_BR_RC]
		params.addValue("TIPOLOGIA_BR_RC", dto.getTipologiaBrRc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO_BR_RC]
		params.addValue("PROGRESSIVO_BR_RC", dto.getProgressivoBrRc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_COMPONENTE]
		params.addValue("FK_TIPO_COMPONENTE", dto.getFkTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_PROGRESSIVO]
		params.addValue("FK_PROGRESSIVO", dto.getFkProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_DATA_INSTALL]
		params.addValue("FK_DATA_INSTALL", dto.getFkDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA]
		params.addValue("TIPOLOGIA", dto.getTipologia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POT_TERM_MAX_KW]
		params.addValue("POT_TERM_MAX_KW", dto.getPotTermMaxKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [POT_TERM_MIN_KW]
		params.addValue("POT_TERM_MIN_KW", dto.getPotTermMinKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_DISMISS]
		params.addValue("DATA_DISMISS", dto.getDataDismiss(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_MARCA]
		params.addValue("FK_MARCA", dto.getFkMarca(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MODELLO]
		params.addValue("MODELLO", dto.getModello(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MATRICOLA]
		params.addValue("MATRICOLA", dto.getMatricola(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_COMBUSTIBILE]
		params.addValue("FK_COMBUSTIBILE", dto.getFkCombustibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_DISMISSIONE]
		params.addValue("FLG_DISMISSIONE", dto.getFlgDismissione(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdCompBrRc(newKey);
		LOG.debug("[SigitTCompBrRcDaoImpl::insert] END");
		return dto.createPk();

	}

	/**
	 * Custom deleter in the SIGIT_T_COMP_BR_RC table.
	 *
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-1280075788) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompBrRcDaoImpl::customDeleterByCodImpianto] END");
	}

	protected SigitTCompBrRcDaoRowMapper byTipoAndCodImpiantoOrderedRowMapper = new SigitTCompBrRcDaoRowMapper(null, SigitTCompBrRcDto.class, this);

	/**
	 * Restituisce il nome della tabella su cui opera il DAO
	 *
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_BR_RC";
	}

	/**
	 * Implementazione del finder byTipoAndCodImpiantoOrdered
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompBrRcDto> findByTipoAndCodImpiantoOrdered(SigitTCompBrRcDto input) throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::findByTipoAndCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_COMP_BR_RC,TIPOLOGIA_BR_RC,PROGRESSIVO_BR_RC,FK_TIPO_COMPONENTE,FK_PROGRESSIVO,FK_DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,POT_TERM_MAX_KW,POT_TERM_MIN_KW,DATA_INSTALL,DATA_DISMISS,FK_MARCA,MODELLO,MATRICOLA,FK_COMBUSTIBILE,FLG_DISMISSIONE ");
		sql.append(" FROM SIGIT_T_COMP_BR_RC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-114684646) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" 1 = 1 ");
		if (input.getTipologiaBrRc() != null)
			sql.append(" AND TIPOLOGIA_BR_RC = :tipoBrRc");
		sql.append(" AND CODICE_IMPIANTO = :codImpianto");
		sql.append(" ORDER BY PROGRESSIVO_BR_RC ASC, DATA_INSTALL DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R864629520) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("tipoBrRc", input.getTipologiaBrRc(), java.sql.Types.VARCHAR);
		paramMap.addValue("codImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTCompBrRcDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byTipoAndCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompBrRcDaoImpl::findByTipoAndCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitTCompBrRcDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompBrRcDaoImpl", "findByTipoAndCodImpiantoOrdered", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompBrRcDaoImpl::findByTipoAndCodImpiantoOrdered] END");
		}
		return list;
	}

	public List<SigitTCompBrRcDto> findBrRcLegateAGt(CompFilter input) throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::findBrRcLegateAGt] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_COMP_BR_RC,TIPOLOGIA_BR_RC,PROGRESSIVO_BR_RC,FK_TIPO_COMPONENTE,FK_PROGRESSIVO,FK_DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,POT_TERM_MAX_KW,POT_TERM_MIN_KW,DATA_INSTALL,DATA_DISMISS,FK_MARCA,MODELLO,MATRICOLA,FK_COMBUSTIBILE,FLG_DISMISSIONE ");
		sql.append(" FROM SIGIT_T_COMP_BR_RC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-778120343) ENABLED START*/
		sql.append(" 1 = 1 ");

		if (input.getCodImpianto() != null) {
			sql.append(" AND CODICE_IMPIANTO = :codiceImpianto ");
		}

		sql.append(" AND FK_TIPO_COMPONENTE = 'GT' ");

		if (input.getDataInstallazione() != null) {
			sql.append(" AND FK_DATA_INSTALL = :dataInstallazione ");
		}

		if (input.getProgressivo() != null) {
			sql.append(" AND FK_PROGRESSIVO = :progressivo ");
		}
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1766330375) ENABLED START*/

		if (input.getCodImpianto() != null) {
			paramMap.addValue("codiceImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		}

		if (input.getDataInstallazione() != null) {
			paramMap.addValue("dataInstallazione", input.getDataInstallazione(), java.sql.Types.DATE);
		}

		if (input.getProgressivo() != null) {
			paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		}

		/*PROTECTED REGION END*/
		List<SigitTCompBrRcDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, BrRcLegateAGtRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompBrRcDaoImpl::findBrRcLegateAGt] esecuzione query", ex);
			throw new SigitTCompBrRcDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompBrRcDaoImpl", "findBrRcLegateAGt", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompBrRcDaoImpl::findBrRcLegateAGt] END");
		}
		return list;
	}
}
