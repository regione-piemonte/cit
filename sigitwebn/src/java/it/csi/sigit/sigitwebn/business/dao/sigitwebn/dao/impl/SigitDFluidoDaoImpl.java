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

/*PROTECTED REGION ID(R678668047) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDFluido.
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
public class SigitDFluidoDaoImpl extends AbstractDAO implements SigitDFluidoDao {
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

	protected SigitDFluidoDaoRowMapper findAllRowMapper = new SigitDFluidoDaoRowMapper(null, SigitDFluidoDto.class,
			this);

	protected SigitDFluidoDaoRowMapper findByPrimaryKeyRowMapper = new SigitDFluidoDaoRowMapper(null,
			SigitDFluidoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_FLUIDO";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_FLUIDO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDFluidoDto> findAll() throws SigitDFluidoDaoException {
		LOG.debug("[SigitDFluidoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_FLUIDO,DES_FLUIDO FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDFluidoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDFluidoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDFluidoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDFluidoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDFluidoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_FLUIDO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDFluidoDto findByPrimaryKey(SigitDFluidoPk pk) throws SigitDFluidoDaoException {
		LOG.debug("[SigitDFluidoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_FLUIDO,DES_FLUIDO FROM " + getTableName() + " WHERE ID_FLUIDO = :ID_FLUIDO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_FLUIDO]
		params.addValue("ID_FLUIDO", pk.getIdFluido(), java.sql.Types.NUMERIC);

		List<SigitDFluidoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDFluidoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDFluidoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDFluidoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitDFluidoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
