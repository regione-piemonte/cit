package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDControlloAriaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDControlloAriaDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDControlloAriaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDControlloAriaDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R746691823) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDControlloAria.
 * Il DAO implementa le seguenti operazioni:
 * - FINDERS:
 * - findAll (datagen::FindAll)
 * - UPDATERS:
 * <p>
 * --
 * - DELETERS:
 * <p>
 * --
 * <p>
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 *
 * @generated
 */
public class SigitDControlloAriaDaoImpl extends AbstractDAO implements SigitDControlloAriaDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 *
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 *
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected SigitDControlloAriaDaoRowMapper findAllRowMapper = new SigitDControlloAriaDaoRowMapper(null, SigitDControlloAriaDto.class, this);

	/**
	 * Restituisce il nome della tabella su cui opera il DAO
	 *
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_CONTROLLO_ARIA";
	}

	/**
	 * Restituisce tutte le righe della tabella SIGIT_D_CONTROLLO_ARIA.
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDControlloAriaDto> findAll() throws SigitDControlloAriaDaoException {
		LOG.debug("[SigitDControlloAriaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_CONTROLLO_ARIA,DESC_CONTROLLO_ARIA FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDControlloAriaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDControlloAriaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDControlloAriaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDControlloAriaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDControlloAriaDaoImpl::findAll] END");
		}
		return list;
	}

}
