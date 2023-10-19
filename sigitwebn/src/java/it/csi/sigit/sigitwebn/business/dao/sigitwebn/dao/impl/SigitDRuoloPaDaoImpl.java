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

/*PROTECTED REGION ID(R37591567) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDRuoloPa.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDRuoloPaDaoImpl extends AbstractDAO implements SigitDRuoloPaDao {
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

	protected SigitDRuoloPaDaoRowMapper findByPrimaryKeyRowMapper = new SigitDRuoloPaDaoRowMapper(null,
			SigitDRuoloPaDto.class, this);

	protected SigitDRuoloPaDaoRowMapper findAllRowMapper = new SigitDRuoloPaDaoRowMapper(null, SigitDRuoloPaDto.class,
			this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_RUOLO_PA";
	}

	/** 
	 * Returns all rows from the SIGIT_D_RUOLO_PA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDRuoloPaDto findByPrimaryKey(SigitDRuoloPaPk pk) throws SigitDRuoloPaDaoException {
		LOG.debug("[SigitDRuoloPaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_RUOLO_PA,DES_RUOLO_PA FROM " + getTableName() + " WHERE ID_RUOLO_PA = :ID_RUOLO_PA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO_PA]
		params.addValue("ID_RUOLO_PA", pk.getIdRuoloPa(), java.sql.Types.INTEGER);

		List<SigitDRuoloPaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDRuoloPaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDRuoloPaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitDRuoloPaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_RUOLO_PA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDRuoloPaDto> findAll() throws SigitDRuoloPaDaoException {
		LOG.debug("[SigitDRuoloPaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_RUOLO_PA,DES_RUOLO_PA FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDRuoloPaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDRuoloPaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDRuoloPaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDRuoloPaDaoImpl::findAll] END");
		}
		return list;
	}

}
