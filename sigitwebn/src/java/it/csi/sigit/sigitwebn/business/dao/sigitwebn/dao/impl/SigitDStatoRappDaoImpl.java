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

/*PROTECTED REGION ID(R1685937423) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDStatoRapp.
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
public class SigitDStatoRappDaoImpl extends AbstractDAO implements SigitDStatoRappDao {
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

	protected SigitDStatoRappDaoRowMapper findAllRowMapper = new SigitDStatoRappDaoRowMapper(null,
			SigitDStatoRappDto.class, this);

	protected SigitDStatoRappDaoRowMapper findByPrimaryKeyRowMapper = new SigitDStatoRappDaoRowMapper(null,
			SigitDStatoRappDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_STATO_RAPP";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_STATO_RAPP.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDStatoRappDto> findAll() throws SigitDStatoRappDaoException {
		LOG.debug("[SigitDStatoRappDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_STATO_RAPP,DES_STATO_RAPP FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDStatoRappDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDStatoRappDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDStatoRappDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStatoRappDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDStatoRappDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_STATO_RAPP table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDStatoRappDto findByPrimaryKey(SigitDStatoRappPk pk) throws SigitDStatoRappDaoException {
		LOG.debug("[SigitDStatoRappDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_STATO_RAPP,DES_STATO_RAPP FROM " + getTableName()
				+ " WHERE ID_STATO_RAPP = :ID_STATO_RAPP ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_RAPP]
		params.addValue("ID_STATO_RAPP", pk.getIdStatoRapp(), java.sql.Types.NUMERIC);

		List<SigitDStatoRappDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDStatoRappDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDStatoRappDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStatoRappDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitDStatoRappDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
