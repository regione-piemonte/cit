package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDDettaglioGtDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDDettaglioGtDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDDettaglioGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDDettaglioGtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDDettaglioGtDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.util.performance.StopWatch;

public class SigitDDettaglioGtDaoImpl extends AbstractDAO implements SigitDDettaglioGtDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);

	protected NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected SigitDDettaglioGtDaoRowMapper findAllRowMapper = new SigitDDettaglioGtDaoRowMapper(null, SigitDDettaglioGtDto.class, this);

	public String getTableName() {
		return "SIGIT_D_DETTAGLIO_GT";
	}

	public List<SigitDDettaglioGtDto> findAll() throws SigitDDettaglioGtDaoException {
		LOG.debug("[SigitDDettaglioGtDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_DETTAGLIO_GT,DES_DETTAGLIO_GT FROM " + getTableName());

		sql.append(" ORDER BY ID_DETTAGLIO_GT ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDDettaglioGtDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDDettaglioGtDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDDettaglioGtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDDettaglioGtDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDDettaglioGtDaoImpl::findAll] END");
		}
		return list;
	}
	
	/** 
	 * Returns all rows from the SIGIT_D_DETTAGLIO_GT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDDettaglioGtDto findByPrimaryKey(SigitDDettaglioGtPk pk) throws SigitDDettaglioGtDaoException {
		LOG.debug("[SigitDDettaglioGtDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_DETTAGLIO_GT,DES_DETTAGLIO_GT FROM " + getTableName() + " WHERE ID_DETTAGLIO_GT = :ID_DETTAGLIO_GT ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_MARCA]
		params.addValue("ID_DETTAGLIO_GT", pk.getIdDettaglioGt(), java.sql.Types.NUMERIC);

		List<SigitDDettaglioGtDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDDettaglioGtDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDDettaglioGtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDDettaglioGtDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitDDettaglioGtDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
