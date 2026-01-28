package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDStatoPgDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;

public class SigitDStatoPgDaoImpl extends AbstractDAO implements SigitDStatoPgDao {
	
	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE);
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

	@Override
	public String getTableName() {
		return "sigit_d_stato_pg";
	}

	@Override
	public String getDesStatoById(Integer idStato) throws SigitExtDaoException {
		logger.debug("[SigitDStatoPgDaoImpl::getDesStatoById] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT des_stato_pg ");
		sql.append(" FROM ");
		sql.append(getTableName());
		sql.append(" WHERE id_stato_pg = :id_stato_pg");

		paramMap.addValue("id_stato_pg", idStato);

		/*PROTECTED REGION END*/
		String result = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			result = jdbcTemplate.queryForObject(sql.toString(), paramMap, String.class);

		} catch (RuntimeException ex) {
			logger.error("[SigitDStatoPgDaoImpl::getDesStatoById] esecuzione query", ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("WrkConfigDaoImpl", "getDesStatoById", "esecuzione query", sql.toString());
			logger.debug("[SigitDStatoPgDaoImpl::getDesStatoById] END");
		}
		return result;
	}

}
