package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDRuoloDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDRuoloDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDRuoloDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDRuoloPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDRuoloDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.util.performance.StopWatch;

public class SigitDRuoloDaoImpl extends AbstractDAO implements SigitDRuoloDao {
	
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
	
	protected SigitDRuoloDaoRowMapper findByPrimaryKeyRowMapper = new SigitDRuoloDaoRowMapper(null, SigitDRuoloDto.class, this);

	@Override
	public SigitDRuoloDto findById(SigitDRuoloPk pk) throws SigitDRuoloDaoException {
		LOG.debug("[SigitDRuoloDaoImpl::findById] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_RUOLO, DES_RUOLO, RUOLO_FUNZ FROM " + getTableName() + " WHERE ID_RUOLO = :ID_RUOLO");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ID_RUOLO", pk.getIdRuolo(), java.sql.Types.INTEGER);

		List<SigitDRuoloDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDRuoloDaoImpl::findById] ERROR esecuzione query", ex);
			throw new SigitDRuoloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDRuoloDaoImpl", "findById", "esecuzione query", sql.toString());
			LOG.debug("[SigitDRuoloDaoImpl::findById] END");
		}
		return list.get(0);
	}
	
	@Override
	public SigitDRuoloDto findByDes(String desRuolo, String ruoloFunz) throws SigitDRuoloDaoException {
		LOG.debug("[SigitDRuoloDaoImpl::findByDes] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_RUOLO, DES_RUOLO, RUOLO_FUNZ FROM " + getTableName() + " WHERE DES_RUOLO = :DES_RUOLO AND RUOLO_FUNZ = :ruoloFunz");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("DES_RUOLO", desRuolo, java.sql.Types.VARCHAR);
		params.addValue("ruoloFunz", ruoloFunz);

		List<SigitDRuoloDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDRuoloDaoImpl::findByDes] ERROR esecuzione query", ex);
			throw new SigitDRuoloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDRuoloDaoImpl", "findByDes", "esecuzione query", sql.toString());
			LOG.debug("[SigitDRuoloDaoImpl::findByDes] END");
		}
		return list.get(0);
	}
	
	
	@Override
	public List<SigitDRuoloDto> findByRuoloFunz(String ruoloFunz) throws SigitDRuoloDaoException {
		LOG.debug("[SigitDRuoloDaoImpl::findByRuoloFunz] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_RUOLO, DES_RUOLO, RUOLO_FUNZ FROM " + getTableName() + " WHERE ruolo_funz = :ruolo_funz");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ruolo_funz", ruoloFunz, java.sql.Types.VARCHAR);

		List<SigitDRuoloDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDRuoloDaoImpl::findByRuoloFunz] ERROR esecuzione query", ex);
			throw new SigitDRuoloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDRuoloDaoImpl", "findByRuoloFunz", "esecuzione query", sql.toString());
			LOG.debug("[SigitDRuoloDaoImpl::findByRuoloFunz] END");
		}
		return list;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "sigit_d_ruolo";
	}

}
