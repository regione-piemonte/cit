package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDDettaglioGfDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDDettaglioGfDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDDettaglioGfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDDettaglioGfDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R-1475328689) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDDettaglioGf.
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
public class SigitDDettaglioGfDaoImpl extends AbstractDAO implements SigitDDettaglioGfDao {
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

	protected SigitDDettaglioGfDaoRowMapper findAllRowMapper = new SigitDDettaglioGfDaoRowMapper(null,
			SigitDDettaglioGfDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_DETTAGLIO_GF";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_DETTAGLIO_GF.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDDettaglioGfDto> findAll() throws SigitDDettaglioGfDaoException {
		LOG.debug("[SigitDDettaglioGfDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_DETTAGLIO_GF,DES_DETTAGLIO_GF FROM " + getTableName());

		sql.append(" ORDER BY ID_DETTAGLIO_GF ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDDettaglioGfDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDDettaglioGfDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDDettaglioGfDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDDettaglioGfDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDDettaglioGfDaoImpl::findAll] END");
		}
		return list;
	}

}
