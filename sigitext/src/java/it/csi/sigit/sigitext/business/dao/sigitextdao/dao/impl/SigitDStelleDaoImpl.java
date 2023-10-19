package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDStelleDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDStelleDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDStelleDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDStelleDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R1962746567) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDStelle.
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
public class SigitDStelleDaoImpl extends AbstractDAO implements SigitDStelleDao {
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

	protected SigitDStelleDaoRowMapper findAllRowMapper = new SigitDStelleDaoRowMapper(null, SigitDStelleDto.class,
			this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_STELLE";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_STELLE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDStelleDto> findAll() throws SigitDStelleDaoException {
		LOG.debug("[SigitDStelleDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_STELLE,DESC_STELLE FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDStelleDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDStelleDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDStelleDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStelleDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDStelleDaoImpl::findAll] END");
		}
		return list;
	}

}
