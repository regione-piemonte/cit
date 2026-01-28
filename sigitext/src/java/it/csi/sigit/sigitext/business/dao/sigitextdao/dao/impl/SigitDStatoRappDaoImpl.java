package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDStatoRappDao;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import it.csi.util.performance.StopWatch;

public class SigitDStatoRappDaoImpl extends AbstractDAO implements SigitDStatoRappDao {
	
	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE);
	
	protected NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String getDesStatoRappById(Integer idStatoRapp) throws SigitextException {
		logger.debug("[SigitDStatoRappDaoImpl::getDesStatoRappById] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT des_stato_rapp FROM " + getTableName() + " WHERE id_stato_rapp = :id_stato_rapp");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_stato_rapp", idStatoRapp, java.sql.Types.NUMERIC);

		List<String> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.queryForList(sql.toString(), params, String.class);
		} catch (RuntimeException ex) {
			logger.error("[SigitDStatoRappDaoImpl::getDesStatoRappById] ERROR esecuzione query", ex);
			throw new SigitextException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStatoRappDaoImpl", "getDesStatoRappById", "esecuzione query", sql.toString());
			logger.debug("[SigitDStatoRappDaoImpl::findAll] END");
		}
		if(list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public String getTableName() {
		return "sigit_d_stato_rapp";
	}

}
