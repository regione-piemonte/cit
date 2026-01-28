package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDAutodichiarazioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDAutodichiarazioneRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDAutodichiarazioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDAutodichiarazionePk;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import it.csi.util.performance.StopWatch;

public class SigitDAutodichiarazioneDaoImpl extends AbstractDAO implements SigitDAutodichiarazioneDao {
	
	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE);
	
	protected SigitDAutodichiarazioneRowMapper findAllRowMapper = new SigitDAutodichiarazioneRowMapper(null, SigitDAutodichiarazioneDto.class, this);
	
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String getTableName() {
		return "SIGIT_D_AUTODICHIARAZIONE";
	}
	
	public List<SigitDAutodichiarazioneDto> findAll() throws SigitextException {
		logger.debug("[SigitDAutodichiarazioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT id_autodichiarazione,des_autodichiarazione FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDAutodichiarazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			logger.error("[SigitDAutodichiarazioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitextException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDAutodichiarazioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			logger.debug("[SigitDAutodichiarazioneDaoImpl::findAll] END");
		}
		return list;
	}
	
	public String getDesById(SigitDAutodichiarazionePk pk) throws SigitextException {
		logger.debug("[SigitDAutodichiarazioneDaoImpl::getDesById] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT des_autodichiarazione FROM " + getTableName() + " WHERE id_autodichiarazione = :id_autodichiarazione");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_autodichiarazione", pk.getId_autodichiarazione());

		List<String> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.queryForList(sql.toString(), params, String.class);
		} catch (RuntimeException ex) {
			logger.error("[SigitDAutodichiarazioneDaoImpl::getDesById] ERROR esecuzione query", ex);
			throw new SigitextException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDAutodichiarazioneDaoImpl", "getDesById", "esecuzione query", sql.toString());
			logger.debug("[SigitDAutodichiarazioneDaoImpl::getDesById] END");
		}
		return list.get(0);
	}

}
