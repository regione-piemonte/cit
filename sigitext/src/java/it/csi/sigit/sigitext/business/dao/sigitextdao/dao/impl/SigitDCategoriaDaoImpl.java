package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDCategoriaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDCategoriaDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.sigit.sigitext.dto.sigitext.Categoria;
import it.csi.util.performance.StopWatch;

public class SigitDCategoriaDaoImpl implements SigitDCategoriaDao {
	
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	
	protected SigitDCategoriaDaoRowMapper findAllRowMapper = new SigitDCategoriaDaoRowMapper(null,
			Categoria.class, this);

	protected NamedParameterJdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> getCategorie() throws SigitExtDaoException {
		String nomeMetodo = "getComuniPG";
		LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] START");
		List<Categoria> result = new ArrayList<>();
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		String query = "SELECT * FROM sigit_d_categoria";
		try {
			stopWatch.start();
			result = jdbcTemplate.query(query, new MapSqlParameterSource(), findAllRowMapper);
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			LOG.error("[SigitExtDaoImpl::" + nomeMetodo + "] esecuzione query", ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", nomeMetodo, "esecuzione query", query);
			LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] END");
		}
		return result;
	}
	
}
