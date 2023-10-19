package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDTipoCannaFumariaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDTipoCannaFumariaDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoCannaFumariaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoCannaFumariaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDTipoCannaFumariaDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class SigitDTipoCannaFumariaDaoImpl extends AbstractDAO implements SigitDTipoCannaFumariaDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);

	protected NamedParameterJdbcTemplate jdbcTemplate;


	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected SigitDTipoCannaFumariaDaoRowMapper findAllRowMapper = new SigitDTipoCannaFumariaDaoRowMapper(null,
			SigitDTipoCannaFumariaDto.class, this);

	protected SigitDTipoCannaFumariaDaoRowMapper findByPrimaryKeyRowMapper = new SigitDTipoCannaFumariaDaoRowMapper(
			null, SigitDTipoCannaFumariaDto.class, this);

	public String getTableName() {
		return "SIGIT_D_TIPO_CANNA_FUMARIA";
	}


	public List<SigitDTipoCannaFumariaDto> findAll() throws SigitDTipoCannaFumariaDaoException {
		LOG.debug("[SigitDTipoCannaFumariaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_CANNA_FUMARIA,DESC_TIPO_CANNA_FUMARIA FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDTipoCannaFumariaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoCannaFumariaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDTipoCannaFumariaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoCannaFumariaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoCannaFumariaDaoImpl::findAll] END");
		}
		return list;
	}

	public SigitDTipoCannaFumariaDto findByPrimaryKey(SigitDTipoCannaFumariaPk pk)
			throws SigitDTipoCannaFumariaDaoException {
		LOG.debug("[SigitDTipoCannaFumariaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_TIPO_CANNA_FUMARIA,DESC_TIPO_CANNA_FUMARIA FROM "
				+ getTableName() + " WHERE ID_TIPO_CANNA_FUMARIA = :ID_TIPO_CANNA_FUMARIA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CANNA_FUMARIA]
		params.addValue("ID_TIPO_CANNA_FUMARIA", pk.getIdTipoCannaFumaria(), java.sql.Types.NUMERIC);

		List<SigitDTipoCannaFumariaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoCannaFumariaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDTipoCannaFumariaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoCannaFumariaDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitDTipoCannaFumariaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
