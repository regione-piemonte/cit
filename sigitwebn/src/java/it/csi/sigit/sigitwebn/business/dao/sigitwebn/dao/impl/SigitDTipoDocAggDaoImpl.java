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

/*PROTECTED REGION ID(R-1582886593) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDTipoDocAgg.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byIdRaggDocAgg (datagen::CustomFinder)
 *   - findAll (datagen::FindAll)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDTipoDocAggDaoImpl extends AbstractDAO implements SigitDTipoDocAggDao {
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

	protected SigitDTipoDocAggDaoRowMapper byIdRaggDocAggRowMapper = new SigitDTipoDocAggDaoRowMapper(null,
			SigitDTipoDocAggDto.class, this);

	protected SigitDTipoDocAggDaoRowMapper findAllRowMapper = new SigitDTipoDocAggDaoRowMapper(null,
			SigitDTipoDocAggDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_TIPO_DOC_AGG";
	}

	/** 
	 * Implementazione del finder byIdRaggDocAgg
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoDocAggDto> findByIdRaggDocAgg(java.lang.Integer input) throws SigitDTipoDocAggDaoException {
		LOG.debug("[SigitDTipoDocAggDaoImpl::findByIdRaggDocAgg] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_TIPO_DOC_AGG,FK_RAGG_DOC_AGG,DES_TIPO_DOC_AGG ");
		sql.append(" FROM SIGIT_D_TIPO_DOC_AGG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-780277917) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" FK_RAGG_DOC_AGG = :idRaggDoc ");
		sql.append("ORDER BY ID_TIPO_DOC_AGG ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1833215169) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idRaggDoc", input);

		/*PROTECTED REGION END*/
		List<SigitDTipoDocAggDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdRaggDocAggRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoDocAggDaoImpl::findByIdRaggDocAgg] esecuzione query", ex);
			throw new SigitDTipoDocAggDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoDocAggDaoImpl", "findByIdRaggDocAgg", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoDocAggDaoImpl::findByIdRaggDocAgg] END");
		}
		return list;
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_TIPO_DOC_AGG.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoDocAggDto> findAll() throws SigitDTipoDocAggDaoException {
		LOG.debug("[SigitDTipoDocAggDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_DOC_AGG,FK_RAGG_DOC_AGG,DES_TIPO_DOC_AGG FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDTipoDocAggDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoDocAggDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDTipoDocAggDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoDocAggDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoDocAggDaoImpl::findAll] END");
		}
		return list;
	}

}
