package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDTipoCessazioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDTipoCessazioneRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoCessazioneDto;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import it.csi.util.performance.StopWatch;

public class SigitDTipoCessazioneDaoImpl extends AbstractDAO implements SigitDTipoCessazioneDao {
	
	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE);
	
	protected SigitDTipoCessazioneRowMapper findAllRowMapper = new SigitDTipoCessazioneRowMapper(null, SigitDTipoCessazioneDto.class, this);
	
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	@Override
	public String getTableName() {
		return "SIGIT_D_TIPO_CESSAZIONE";
	}
	
	@Override
	public List<SigitDTipoCessazioneDto> getAllTipoCessazioneByIdTipoCessazioneMajorZero() throws SigitextException {
		logger.debug("[SigitDTipoCessazioneDaoImpl::getAllTipoCessazioneByIdTipoCessazioneMajorZero] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT id_tipo_cessazione,des_tipo_cessazione FROM " + getTableName() + " WHERE id_tipo_cessazione <> 0");

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDTipoCessazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			logger.error("[SigitDTipoCessazioneDaoImpl::getAllTipoCessazioneByIdTipoCessazioneMajorZero] ERROR esecuzione query", ex);
			throw new SigitextException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoCessazioneDaoImpl", "getAllTipoCessazioneByIdTipoCessazioneMajorZero", "esecuzione query", sql.toString());
			logger.debug("[SigitDTipoCessazioneDaoImpl::getAllTipoCessazioneByIdTipoCessazioneMajorZero] END");
		}
		return list;
	}
	
	@Override
	public SigitDTipoCessazioneDto getTipoCessazioneByDes(String des) throws SigitextException {
		logger.debug("[SigitDTipoCessazioneDaoImpl::getTipoCessazioneByDes] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT id_tipo_cessazione,des_tipo_cessazione FROM " + getTableName() + " WHERE des_tipo_cessazione = :des_tipo_cessazione");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("des_tipo_cessazione", des, java.sql.Types.VARCHAR);

		List<SigitDTipoCessazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			logger.error("[SigitDTipoCessazioneDaoImpl::getTipoCessazioneByDes] ERROR esecuzione query", ex);
			throw new SigitextException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoCessazioneDaoImpl", "getTipoCessazioneByDes", "esecuzione query", sql.toString());
			logger.debug("[SigitDTipoCessazioneDaoImpl::getTipoCessazioneByDes] END");
		}
		return list.get(0);
	}
	
	@Override
	public SigitDTipoCessazioneDto getTipoCessazioneById(Integer id) throws SigitextException {
		logger.debug("[SigitDTipoCessazioneDaoImpl::getTipoCessazioneByDes] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT id_tipo_cessazione,des_tipo_cessazione FROM " + getTableName() + " WHERE id_tipo_cessazione = :id_tipo_cessazione");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_tipo_cessazione", id, java.sql.Types.NUMERIC);

		List<SigitDTipoCessazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			logger.error("[SigitDTipoCessazioneDaoImpl::getTipoCessazioneByDes] ERROR esecuzione query", ex);
			throw new SigitextException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoCessazioneDaoImpl", "getTipoCessazioneByDes", "esecuzione query", sql.toString());
			logger.debug("[SigitDTipoCessazioneDaoImpl::getTipoCessazioneByDes] END");
		}
		return list.get(0);
	}

}
