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

/*PROTECTED REGION ID(R1857260531) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTUserWs.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - userWsCustom (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTUserWsDaoImpl extends AbstractDAO implements SigitTUserWsDao {
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
	 * Updates a single row in the SIGIT_T_USER_WS table.
	 * @generated
	 */
	public void update(SigitTUserWsDto dto) throws SigitTUserWsDaoException {
		LOG.debug("[SigitTUserWsDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET USER_WS = :USER_WS ,PWD_WS = :PWD_WS ,DT_CREAZIONE_TOKEN = :DT_CREAZIONE_TOKEN ,DT_SCADENZA_TOKEN = :DT_SCADENZA_TOKEN ,TOKEN = :TOKEN  WHERE ID_USER_WS = :ID_USER_WS ";

		if (dto.getIdUserWs() == null) {
			LOG.error("[SigitTUserWsDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTUserWsDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_USER_WS]
		params.addValue("ID_USER_WS", dto.getIdUserWs(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [USER_WS]
		params.addValue("USER_WS", dto.getUserWs(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PWD_WS]
		params.addValue("PWD_WS", dto.getPwdWs(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DT_CREAZIONE_TOKEN]
		params.addValue("DT_CREAZIONE_TOKEN", dto.getDtCreazioneToken(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DT_SCADENZA_TOKEN]
		params.addValue("DT_SCADENZA_TOKEN", dto.getDtScadenzaToken(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [TOKEN]
		params.addValue("TOKEN", dto.getToken(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTUserWsDaoImpl::update] END");
	}

	protected SigitTUserWsDaoRowMapper findAllRowMapper = new SigitTUserWsDaoRowMapper(null, SigitTUserWsDto.class,
			this);

	protected SigitTUserWsDaoRowMapper userWsCustomRowMapper = new SigitTUserWsDaoRowMapper(null, SigitTUserWsDto.class,
			this);

	protected SigitTUserWsDaoRowMapper findByPrimaryKeyRowMapper = new SigitTUserWsDaoRowMapper(null,
			SigitTUserWsDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_USER_WS";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_USER_WS.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUserWsDto> findAll() throws SigitTUserWsDaoException {
		LOG.debug("[SigitTUserWsDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_USER_WS,USER_WS,PWD_WS,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTUserWsDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTUserWsDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTUserWsDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTUserWsDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTUserWsDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder userWsCustom
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUserWsDto> findUserWsCustom(java.lang.Integer input) throws SigitTUserWsDaoException {
		LOG.debug("[SigitTUserWsDaoImpl::findUserWsCustom] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_USER_WS,USER_WS,PWD_WS,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN ");
		sql.append(" FROM SIGIT_T_USER_WS");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-348745525) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("ID_USER_WS > :idUserWs");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1340612905) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idUserWs", input);

		/*PROTECTED REGION END*/
		List<SigitTUserWsDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, userWsCustomRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTUserWsDaoImpl::findUserWsCustom] esecuzione query", ex);
			throw new SigitTUserWsDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTUserWsDaoImpl", "findUserWsCustom", "esecuzione query", sql.toString());
			LOG.debug("[SigitTUserWsDaoImpl::findUserWsCustom] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_T_USER_WS table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTUserWsDto findByPrimaryKey(SigitTUserWsPk pk) throws SigitTUserWsDaoException {
		LOG.debug("[SigitTUserWsDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_USER_WS,USER_WS,PWD_WS,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN FROM " + getTableName()
						+ " WHERE ID_USER_WS = :ID_USER_WS ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_USER_WS]
		params.addValue("ID_USER_WS", pk.getIdUserWs(), java.sql.Types.INTEGER);

		List<SigitTUserWsDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTUserWsDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTUserWsDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTUserWsDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTUserWsDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
