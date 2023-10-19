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

/*PROTECTED REGION ID(R-666430227) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDCombustibile.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - byElencoId (datagen::CustomFinder)
 *   - byNotInElencoId (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDCombustibileDaoImpl extends AbstractDAO implements SigitDCombustibileDao {
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

	protected SigitDCombustibileDaoRowMapper findAllRowMapper = new SigitDCombustibileDaoRowMapper(null,
			SigitDCombustibileDto.class, this);

	protected SigitDCombustibileDaoRowMapper byElencoIdRowMapper = new SigitDCombustibileDaoRowMapper(null,
			SigitDCombustibileDto.class, this);

	protected SigitDCombustibileDaoRowMapper byNotInElencoIdRowMapper = new SigitDCombustibileDaoRowMapper(null,
			SigitDCombustibileDto.class, this);

	protected SigitDCombustibileDaoRowMapper findByPrimaryKeyRowMapper = new SigitDCombustibileDaoRowMapper(null,
			SigitDCombustibileDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_COMBUSTIBILE";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_COMBUSTIBILE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDCombustibileDto> findAll() throws SigitDCombustibileDaoException {
		LOG.debug("[SigitDCombustibileDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_COMBUSTIBILE,DES_COMBUSTIBILE FROM " + getTableName());

		sql.append(" ORDER BY ID_COMBUSTIBILE ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDCombustibileDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDCombustibileDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDCombustibileDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDCombustibileDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDCombustibileDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byElencoId
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDCombustibileDto> findByElencoId(java.util.ArrayList<java.lang.Integer> input)
			throws SigitDCombustibileDaoException {
		LOG.debug("[SigitDCombustibileDaoImpl::findByElencoId] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_COMBUSTIBILE,DES_COMBUSTIBILE ");
		sql.append(" FROM SIGIT_D_COMBUSTIBILE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-292979682) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R388128228) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input != null && !input.isEmpty()) {
			sql.append(" ID_COMBUSTIBILE IN  (");
			boolean aggVirg = false;
			for (Integer progr : input) {
				if (aggVirg)
					sql.append(", ");
				sql.append(progr);
				aggVirg = true;
			}
			sql.append(") ");
		}

		/*PROTECTED REGION END*/
		List<SigitDCombustibileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byElencoIdRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDCombustibileDaoImpl::findByElencoId] esecuzione query", ex);
			throw new SigitDCombustibileDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDCombustibileDaoImpl", "findByElencoId", "esecuzione query", sql.toString());
			LOG.debug("[SigitDCombustibileDaoImpl::findByElencoId] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byNotInElencoId
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDCombustibileDto> findByNotInElencoId(java.util.ArrayList<java.lang.Integer> input)
			throws SigitDCombustibileDaoException {
		LOG.debug("[SigitDCombustibileDaoImpl::findByNotInElencoId] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_COMBUSTIBILE,DES_COMBUSTIBILE ");
		sql.append(" FROM SIGIT_D_COMBUSTIBILE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1015370748) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-531158338) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input != null && !input.isEmpty()) {
			sql.append(" ID_COMBUSTIBILE NOT IN  (");
			boolean aggVirg = false;
			for (Integer progr : input) {
				if (aggVirg)
					sql.append(", ");
				sql.append(progr);
				aggVirg = true;
			}
			sql.append(") ");
		}
		/*PROTECTED REGION END*/
		List<SigitDCombustibileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byNotInElencoIdRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDCombustibileDaoImpl::findByNotInElencoId] esecuzione query", ex);
			throw new SigitDCombustibileDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDCombustibileDaoImpl", "findByNotInElencoId", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitDCombustibileDaoImpl::findByNotInElencoId] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_COMBUSTIBILE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDCombustibileDto findByPrimaryKey(SigitDCombustibilePk pk) throws SigitDCombustibileDaoException {
		LOG.debug("[SigitDCombustibileDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_COMBUSTIBILE,DES_COMBUSTIBILE FROM " + getTableName()
				+ " WHERE ID_COMBUSTIBILE = :ID_COMBUSTIBILE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_COMBUSTIBILE]
		params.addValue("ID_COMBUSTIBILE", pk.getIdCombustibile(), java.sql.Types.NUMERIC);

		List<SigitDCombustibileDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDCombustibileDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDCombustibileDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDCombustibileDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitDCombustibileDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
