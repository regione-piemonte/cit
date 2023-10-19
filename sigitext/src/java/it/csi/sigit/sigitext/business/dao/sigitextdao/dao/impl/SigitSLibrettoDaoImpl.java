package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitSLibrettoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.LibrettoFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitSLibrettoDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitSLibrettoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitSLibrettoDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class SigitSLibrettoDaoImpl extends AbstractDAO implements SigitSLibrettoDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);

	protected NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void customUpdaterStoricizzaByCodImpianto(SigitSLibrettoDto filter, Object value) throws SigitSLibrettoDaoException {
		LOG.debug("[SigitSLibrettoDaoImpl::customUpdaterStoricizzaByCodImpianto] START");
		final String sql = "UPDATE " + getTableName() + " SET FK_STATO = 3 ,  data_ult_mod = :dataUltMod, utente_ult_mod =  :utenteUltMod" + " WHERE CODICE_IMPIANTO = :codImpianto AND FK_STATO = 2";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodiceImpianto(), java.sql.Types.NUMERIC);
		params.addValue("dataUltMod", filter.getDataUltMod(), java.sql.Types.TIMESTAMP);
		params.addValue("utenteUltMod", filter.getUtenteUltMod(), java.sql.Types.VARCHAR);
		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitSLibrettoDaoImpl::customUpdaterStoricizzaByCodImpianto] END");
	}

	protected SigitSLibrettoDaoRowMapper byLibrettoFilterRowMapper = new SigitSLibrettoDaoRowMapper(null, SigitSLibrettoDto.class, this);

	public List<SigitSLibrettoDto> findByLibrettoFilter(LibrettoFilter input) throws SigitSLibrettoDaoException {
		LOG.debug("[SigitSLibrettoDaoImpl::findByLibrettoFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		sql.append("SELECT ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO ");
		sql.append(" FROM SIGIT_S_LIBRETTO");
		sql.append(" WHERE ");
		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_STATO = :idStato");
		sql.append(" ORDER BY DATA_CONSOLIDAMENTO desc ");
		paramMap.addValue("codImpianto", input.getCodiceImpianto());
		paramMap.addValue("idStato", input.getIdStatoLibretto());
		List<SigitSLibrettoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byLibrettoFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitSLibrettoDaoImpl::findByLibrettoFilter] esecuzione query", ex);
			throw new SigitSLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitSLibrettoDaoImpl", "findByLibrettoFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitSLibrettoDaoImpl::findByLibrettoFilter] END");
		}
		return list;
	}

	public String getTableName() {
		return "SIGIT_S_LIBRETTO";
	}

}
