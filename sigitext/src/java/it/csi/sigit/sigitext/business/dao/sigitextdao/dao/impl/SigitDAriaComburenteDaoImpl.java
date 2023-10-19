package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDAriaComburenteDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDAriaComburenteDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDAriaComburenteDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDAriaComburenteDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R1347858567) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDAriaComburente.
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
public class SigitDAriaComburenteDaoImpl extends AbstractDAO implements SigitDAriaComburenteDao {
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

	protected SigitDAriaComburenteDaoRowMapper findAllRowMapper = new SigitDAriaComburenteDaoRowMapper(null,
			SigitDAriaComburenteDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_ARIA_COMBURENTE";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_ARIA_COMBURENTE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDAriaComburenteDto> findAll() throws SigitDAriaComburenteDaoException {
		LOG.debug("[SigitDAriaComburenteDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ARIA_COMBURENTE,DESC_ARIA_COMBURENTE FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDAriaComburenteDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDAriaComburenteDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDAriaComburenteDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDAriaComburenteDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDAriaComburenteDaoImpl::findAll] END");
		}
		return list;
	}

}
