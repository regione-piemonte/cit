package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTDatoDistribDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTLogDistribDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ConsumoPodPdrFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTDatoDistribDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTLogDistribDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLogDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLogDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDatoDistribDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTLogDistribDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;

public class SigitTLogDistribDaoImpl extends AbstractDAO implements SigitTLogDistribDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);

	protected NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getTableName() {
		return "SIGIT_T_LOG_DISTRIB";
	}

	protected SigitTLogDistribDaoRowMapper findByPrimaryKeyRowMapper = new SigitTLogDistribDaoRowMapper(null,
			SigitTLogDistribDto.class, this);

	@SuppressWarnings("unchecked")
	public List<SigitTLogDistribDto> findByPrimaryKey(SigitTLogDistribPk pk)
			throws SigitTLogDistribDaoException {
		LOG.debug("[SigitTLogDistribDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_LOG_DISTRIB,FK_IMPORT_DISTRIB,MSG_ERRORE FROM "
						+ getTableName() + " WHERE ID_LOG_DISTRIB = :ID_LOG_DISTRIB ");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ID_LOG_DISTRIB", pk.getIdLogDistrib(), java.sql.Types.INTEGER);

		List<SigitTLogDistribDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTLogDistribDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTLogDistribDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTLogDistribDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTLogDistribDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	public List<SigitTLogDistribDto> findByFkImportDistrib(Integer fkImportDistrib)
			throws SigitTLogDistribDaoException {
		LOG.debug("[SigitTLogDistribDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT DISTINCT ID_LOG_DISTRIB,FK_IMPORT_DISTRIB,MSG_ERRORE FROM "
						+ getTableName() + " WHERE FK_IMPORT_DISTRIB = :FK_IMPORT_DISTRIB ");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("FK_IMPORT_DISTRIB", fkImportDistrib, java.sql.Types.INTEGER);

		List<SigitTLogDistribDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTLogDistribDaoImpl::findByFkImportDistrib] ERROR esecuzione query", ex);
			throw new SigitTLogDistribDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTLogDistribDaoImpl", "findByFkImportDistrib", "esecuzione query", sql.toString());
			LOG.debug("[SigitTLogDistribDaoImpl::findByFkImportDistrib] END");
		}
		return list.isEmpty() ? null : list;
	}
}
