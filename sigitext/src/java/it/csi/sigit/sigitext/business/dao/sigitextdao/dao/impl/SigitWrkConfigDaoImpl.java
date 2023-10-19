package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitWrkConfigDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitWrkConfigDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitWrkConfigDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitWrkConfigPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitWrkConfigDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class SigitWrkConfigDaoImpl extends AbstractDAO implements SigitWrkConfigDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 *
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 *
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected SigitWrkConfigDaoRowMapper findAllRowMapper = new SigitWrkConfigDaoRowMapper(null, SigitWrkConfigDto.class, this);

	protected SigitWrkConfigDaoRowMapper findByPrimaryKeyRowMapper = new SigitWrkConfigDaoRowMapper(null, SigitWrkConfigDto.class, this);

	protected SigitWrkConfigDaoRowMapper byChiaveConfigRowMapper = new SigitWrkConfigDaoRowMapper(null, SigitWrkConfigDto.class, this);

	/**
	 * Restituisce il nome della tabella su cui opera il DAO
	 *
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_WRK_CONFIG";
	}

	/**
	 * Restituisce tutte le righe della tabella SIGIT_WRK_CONFIG.
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitWrkConfigDto> findAll() throws SigitWrkConfigDaoException {
		LOG.debug("[SigitWrkConfigDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_CONFIG,CHIAVE_CONFIG,VALORE_CONFIG_NUM,VALORE_CONFIG_CHAR,VALORE_FLAG FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitWrkConfigDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitWrkConfigDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitWrkConfigDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitWrkConfigDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitWrkConfigDaoImpl::findAll] END");
		}
		return list;
	}

	/**
	 * Returns all rows from the SIGIT_WRK_CONFIG table that match the primary key criteria
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitWrkConfigDto findByPrimaryKey(SigitWrkConfigPk pk) throws SigitWrkConfigDaoException {
		LOG.debug("[SigitWrkConfigDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_CONFIG,CHIAVE_CONFIG,VALORE_CONFIG_NUM,VALORE_CONFIG_CHAR,VALORE_FLAG FROM " + getTableName() + " WHERE ID_CONFIG = :ID_CONFIG ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONFIG]
		params.addValue("ID_CONFIG", pk.getIdConfig(), java.sql.Types.NUMERIC);

		List<SigitWrkConfigDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitWrkConfigDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitWrkConfigDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitWrkConfigDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitWrkConfigDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * Implementazione del finder byChiaveConfig
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitWrkConfigDto> findByChiaveConfig(String input) throws SigitWrkConfigDaoException {
		LOG.debug("[SigitWrkConfigDaoImpl::findByChiaveConfig] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_CONFIG,CHIAVE_CONFIG,VALORE_CONFIG_NUM,VALORE_CONFIG_CHAR,VALORE_FLAG ");
		sql.append(" FROM SIGIT_WRK_CONFIG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R833772143) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("CHIAVE_CONFIG = :chiave");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R957696435) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("chiave", input);

		/*PROTECTED REGION END*/
		List<SigitWrkConfigDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byChiaveConfigRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitWrkConfigDaoImpl::findByChiaveConfig] esecuzione query", ex);
			throw new SigitWrkConfigDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitWrkConfigDaoImpl", "findByChiaveConfig", "esecuzione query", sql.toString());
			LOG.debug("[SigitWrkConfigDaoImpl::findByChiaveConfig] END");
		}
		return list;
	}

}
