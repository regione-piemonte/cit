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

/*PROTECTED REGION ID(R-1070559223) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDTipoAnomalia.
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
public class SigitDTipoAnomaliaDaoImpl extends AbstractDAO implements SigitDTipoAnomaliaDao {
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

	protected SigitDTipoAnomaliaDaoRowMapper findByPrimaryKeyRowMapper = new SigitDTipoAnomaliaDaoRowMapper(null,
			SigitDTipoAnomaliaDto.class, this);

	protected SigitDTipoAnomaliaDaoRowMapper findAllRowMapper = new SigitDTipoAnomaliaDaoRowMapper(null,
			SigitDTipoAnomaliaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_TIPO_ANOMALIA";
	}

	/** 
	 * Returns all rows from the SIGIT_D_TIPO_ANOMALIA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDTipoAnomaliaDto findByPrimaryKey(SigitDTipoAnomaliaPk pk) throws SigitDTipoAnomaliaDaoException {
		LOG.debug("[SigitDTipoAnomaliaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_TIPO_ANOMALIA,DES_TIPO_ANOMALIA FROM " + getTableName()
				+ " WHERE ID_TIPO_ANOMALIA = :ID_TIPO_ANOMALIA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_ANOMALIA]
		params.addValue("ID_TIPO_ANOMALIA", pk.getIdTipoAnomalia(), java.sql.Types.INTEGER);

		List<SigitDTipoAnomaliaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoAnomaliaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDTipoAnomaliaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoAnomaliaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoAnomaliaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_TIPO_ANOMALIA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoAnomaliaDto> findAll() throws SigitDTipoAnomaliaDaoException {
		LOG.debug("[SigitDTipoAnomaliaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_TIPO_ANOMALIA,DES_TIPO_ANOMALIA FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDTipoAnomaliaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoAnomaliaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDTipoAnomaliaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoAnomaliaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoAnomaliaDaoImpl::findAll] END");
		}
		return list;
	}

}
