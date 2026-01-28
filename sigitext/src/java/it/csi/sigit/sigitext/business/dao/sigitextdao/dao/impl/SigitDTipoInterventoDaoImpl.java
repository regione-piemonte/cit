package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDTipoInterventoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDTipoInterventoDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoInterventoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDTipoInterventoDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.util.performance.StopWatch;

public class SigitDTipoInterventoDaoImpl extends AbstractDAO implements SigitDTipoInterventoDao {

	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE);

	protected NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected SigitDTipoInterventoDaoRowMapper findAllRowMapper = new SigitDTipoInterventoDaoRowMapper(null, SigitDTipoInterventoDto.class, this);

	@Override
	public String getTableName() {
		return "SIGIT_D_TIPO_INTERVENTO";
	}

	@Override
	public List<SigitDTipoInterventoDto> findAll() throws SigitDTipoInterventoDaoException {
		logger.debug("[SigitDTipoInterventoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_TIPO_INTERVENTO,DES_TIPO_INTERVENTO FROM " + getTableName());

		sql.append(" ORDER BY ID_TIPO_INTERVENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDTipoInterventoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			logger.error("[SigitDDettaglioGtDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDTipoInterventoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoInterventoDaoImpl", "findAll", "esecuzione query", sql.toString());
			logger.debug("[SigitDTipoInterventoDaoImpl::findAll] END");
		}
		return list;
	}

}
