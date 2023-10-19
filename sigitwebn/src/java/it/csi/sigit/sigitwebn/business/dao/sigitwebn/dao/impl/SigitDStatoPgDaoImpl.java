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

/*PROTECTED REGION ID(R-1899329585) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDStatoPg.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDStatoPgDaoImpl extends AbstractDAO implements SigitDStatoPgDao {
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

	protected SigitDStatoPgDaoRowMapper findAllRowMapper = new SigitDStatoPgDaoRowMapper(null, SigitDStatoPgDto.class,
			this);

	protected SigitDStatoPgDaoRowMapper findByPrimaryKeyRowMapper = new SigitDStatoPgDaoRowMapper(null,
			SigitDStatoPgDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_STATO_PG";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_STATO_PG.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDStatoPgDto> findAll() throws SigitDStatoPgDaoException {
		LOG.debug("[SigitDStatoPgDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_STATO_PG,DES_STATO_PG FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDStatoPgDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDStatoPgDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDStatoPgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStatoPgDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDStatoPgDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_STATO_PG table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDStatoPgDto findByPrimaryKey(SigitDStatoPgPk pk) throws SigitDStatoPgDaoException {
		LOG.debug("[SigitDStatoPgDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_STATO_PG,DES_STATO_PG FROM " + getTableName() + " WHERE ID_STATO_PG = :ID_STATO_PG ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_PG]
		params.addValue("ID_STATO_PG", pk.getIdStatoPg(), java.sql.Types.INTEGER);

		List<SigitDStatoPgDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDStatoPgDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDStatoPgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStatoPgDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitDStatoPgDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
