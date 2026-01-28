package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRContr2019AutodichiarDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitRContr2019AutodichiarRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRContr2019AutodichiarDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRContr2019AutodichiarPk;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import it.csi.util.performance.StopWatch;

public class SigitRContr2019AutodichiarDaoImpl extends AbstractDAO implements SigitRContr2019AutodichiarDao {
	
	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE);
	
	protected SigitRContr2019AutodichiarRowMapper findAllRowMapper = new SigitRContr2019AutodichiarRowMapper(null, SigitRContr2019AutodichiarDto.class, this);
	
	protected NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public String getTableName() {
		return "sigit_r_contr2019_autodichiar";
	}
	
	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<SigitRContr2019AutodichiarDto> findAllByIdContratto(SigitRContr2019AutodichiarPk pk) throws SigitextException {
		logger.debug("[SigitRContr2019AutodichiarDaoImpl::findAllByIdContratto] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT id_contratto,id_autodichiarazione,flg_nomina_cessa FROM " + getTableName() + " WHERE id_contratto = :id_contratto");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_contratto",pk.getId_contratto());

		List<SigitRContr2019AutodichiarDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			logger.error("[SigitRContr2019AutodichiarDaoImpl::findAllByIdContratto] ERROR esecuzione query", ex);
			throw new SigitextException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRContr2019AutodichiarDaoImpl", "findAllByIdContratto", "esecuzione query", sql.toString());
			logger.debug("[SigitRContr2019AutodichiarDaoImpl::findAllByIdContratto] END");
		}
		return list;
	}
	
	public void insert(SigitRContr2019AutodichiarDto dto) throws SigitextException {
		logger.debug("[SigitRContr2019AutodichiarDaoImpl::insert] START");

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_CONTRATTO,ID_AUTODICHIARAZIONE,FLG_NOMINA_CESSA ) VALUES (  :ID_CONTRATTO , :ID_AUTODICHIARAZIONE , :FLG_NOMINA_CESSA )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("ID_CONTRATTO", dto.getId_contratto(), java.sql.Types.NUMERIC);

		params.addValue("ID_AUTODICHIARAZIONE", dto.getId_autodichiarazione(), java.sql.Types.NUMERIC);

		params.addValue("FLG_NOMINA_CESSA", dto.getFlg_nomina_cessa(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		logger.debug("[SigitRContr2019AutodichiarDaoImpl::insert] END");
	}
}
