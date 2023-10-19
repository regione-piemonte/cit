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

/*PROTECTED REGION ID(R1774859993) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDStatoDistrib.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDStatoDistribDaoImpl extends AbstractDAO implements SigitDStatoDistribDao {
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

	protected SigitDStatoDistribDaoRowMapper findAllRowMapper = new SigitDStatoDistribDaoRowMapper(null,
			SigitDStatoDistribDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_STATO_DISTRIB";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_STATO_DISTRIB.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDStatoDistribDto> findAll() throws SigitDStatoDistribDaoException {
		LOG.debug("[SigitDStatoDistribDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_STATO_DISTRIB,DES_STATO_DISTRIB FROM " + getTableName());

		sql.append(" ORDER BY DES_STATO_DISTRIB ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDStatoDistribDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDStatoDistribDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDStatoDistribDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStatoDistribDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDStatoDistribDaoImpl::findAll] END");
		}
		return list;
	}

}
