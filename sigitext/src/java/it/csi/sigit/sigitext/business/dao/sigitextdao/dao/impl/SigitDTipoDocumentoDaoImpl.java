package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDTipoDocumentoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDTipoDocumentoDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoDocDto;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import it.csi.util.performance.StopWatch;

public class SigitDTipoDocumentoDaoImpl extends AbstractDAO implements SigitDTipoDocumentoDao {

	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE);

	protected SigitDTipoDocumentoDaoRowMapper findAllRowMapper = new SigitDTipoDocumentoDaoRowMapper(null,
			SigitDTipoDocDto.class, this);

	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<SigitDTipoDocDto> getTipoDocumenti() throws SigitextException {
		logger.debug("[SigitDTipoDocumentoDaoImpl::getTipoDocumenti] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT id_tipo_doc_agg,des_tipo_doc_agg FROM " + getTableName() + " WHERE fk_ragg_doc_agg = 2");

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDTipoDocDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			logger.error("[SigitDTipoDocumentoDaoImpl::getTipoDocumenti] ERROR esecuzione query", ex);
			throw new SigitextException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoDocumentoDaoImpl", "getTipoDocumenti", "esecuzione query", sql.toString());
			logger.debug("[SigitDTipoDocumentoDaoImpl::findAll] END");
		}
		return list;
	}
	
	@Override
	public String getDescrizioneById(Integer idTipoDocAgg) throws SigitextException {
		logger.debug("[SigitDTipoDocumentoDaoImpl::getDescrizioneById] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT des_tipo_doc_agg FROM " + getTableName() + " WHERE id_tipo_doc_agg = :id_tipo_doc_agg");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_tipo_doc_agg", idTipoDocAgg, java.sql.Types.NUMERIC);

		List<String> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.queryForList(sql.toString(), params, String.class);
		} catch (RuntimeException ex) {
			logger.error("[SigitDTipoDocumentoDaoImpl::getDescrizioneById] ERROR esecuzione query", ex);
			throw new SigitextException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoDocumentoDaoImpl", "getDescrizioneById", "esecuzione query", sql.toString());
			logger.debug("[SigitDTipoDocumentoDaoImpl::findAll] END");
		}
		if(list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public String getTableName() {
		return "sigit_d_tipo_doc_agg";
	}

}
