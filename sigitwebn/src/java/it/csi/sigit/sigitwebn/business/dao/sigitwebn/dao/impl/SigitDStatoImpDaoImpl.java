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

/*PROTECTED REGION ID(R-2146871129) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDStatoImp.
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
public class SigitDStatoImpDaoImpl extends AbstractDAO implements SigitDStatoImpDao {
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

	protected SigitDStatoImpDaoRowMapper findAllRowMapper = new SigitDStatoImpDaoRowMapper(null,
			SigitDStatoImpDto.class, this);

	protected SigitDStatoImpDaoRowMapper findByPrimaryKeyRowMapper = new SigitDStatoImpDaoRowMapper(null,
			SigitDStatoImpDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_STATO_IMP";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_STATO_IMP.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDStatoImpDto> findAll() throws SigitDStatoImpDaoException {
		LOG.debug("[SigitDStatoImpDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_STATO,DES_STATO FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDStatoImpDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDStatoImpDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDStatoImpDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStatoImpDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDStatoImpDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_STATO_IMP table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDStatoImpDto findByPrimaryKey(SigitDStatoImpPk pk) throws SigitDStatoImpDaoException {
		LOG.debug("[SigitDStatoImpDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_STATO,DES_STATO FROM " + getTableName() + " WHERE ID_STATO = :ID_STATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO]
		params.addValue("ID_STATO", pk.getIdStato(), java.sql.Types.NUMERIC);

		List<SigitDStatoImpDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDStatoImpDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDStatoImpDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStatoImpDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitDStatoImpDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
