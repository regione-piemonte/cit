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

/*PROTECTED REGION ID(R-31346955) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDTipoCannaFumaria.
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
public class SigitDTipoCannaFumariaDaoImpl extends AbstractDAO implements SigitDTipoCannaFumariaDao {
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

	protected SigitDTipoCannaFumariaDaoRowMapper findAllRowMapper = new SigitDTipoCannaFumariaDaoRowMapper(null,
			SigitDTipoCannaFumariaDto.class, this);

	protected SigitDTipoCannaFumariaDaoRowMapper findByPrimaryKeyRowMapper = new SigitDTipoCannaFumariaDaoRowMapper(
			null, SigitDTipoCannaFumariaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_TIPO_CANNA_FUMARIA";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_TIPO_CANNA_FUMARIA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoCannaFumariaDto> findAll() throws SigitDTipoCannaFumariaDaoException {
		LOG.debug("[SigitDTipoCannaFumariaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_CANNA_FUMARIA,DESC_TIPO_CANNA_FUMARIA FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDTipoCannaFumariaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoCannaFumariaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDTipoCannaFumariaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoCannaFumariaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoCannaFumariaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_TIPO_CANNA_FUMARIA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDTipoCannaFumariaDto findByPrimaryKey(SigitDTipoCannaFumariaPk pk)
			throws SigitDTipoCannaFumariaDaoException {
		LOG.debug("[SigitDTipoCannaFumariaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_TIPO_CANNA_FUMARIA,DESC_TIPO_CANNA_FUMARIA FROM "
				+ getTableName() + " WHERE ID_TIPO_CANNA_FUMARIA = :ID_TIPO_CANNA_FUMARIA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CANNA_FUMARIA]
		params.addValue("ID_TIPO_CANNA_FUMARIA", pk.getIdTipoCannaFumaria(), java.sql.Types.NUMERIC);

		List<SigitDTipoCannaFumariaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoCannaFumariaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDTipoCannaFumariaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoCannaFumariaDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitDTipoCannaFumariaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
