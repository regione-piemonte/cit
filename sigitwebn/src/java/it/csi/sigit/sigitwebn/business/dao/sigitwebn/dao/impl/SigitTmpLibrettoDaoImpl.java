package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import it.csi.sigit.sigitwebn.business.dao.impl.*;
import it.csi.sigit.sigitwebn.business.dao.util.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import java.util.Map;
import java.util.TreeMap;

/*PROTECTED REGION ID(R818956377) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTmpLibretto.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - DaElaborare (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTmpLibrettoDaoImpl extends AbstractDAO implements SigitTmpLibrettoDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
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

	/** 
	 * Updates a single row in the SIGIT_TMP_LIBRETTO table.
	 * @generated
	 */
	public void update(SigitTmpLibrettoDto dto) throws SigitTmpLibrettoDaoException {
		LOG.debug("[SigitTmpLibrettoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FLG_ELABORATO = :FLG_ELABORATO ,FLG_ESITO_ELAB = :FLG_ESITO_ELAB ,DATA_ELAB = :DATA_ELAB  WHERE ID_LIBRETTO = :ID_LIBRETTO ";

		if (dto.getIdLibretto() == null) {
			LOG.error("[SigitTmpLibrettoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTmpLibrettoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LIBRETTO]
		params.addValue("ID_LIBRETTO", dto.getIdLibretto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_ELABORATO]
		params.addValue("FLG_ELABORATO", dto.getFlgElaborato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_ESITO_ELAB]
		params.addValue("FLG_ESITO_ELAB", dto.getFlgEsitoElab(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ELAB]
		params.addValue("DATA_ELAB", dto.getDataElab(), java.sql.Types.TIMESTAMP);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTmpLibrettoDaoImpl::update] END");
	}

	protected SigitTmpLibrettoDaoRowMapper DaElaborareRowMapper = new SigitTmpLibrettoDaoRowMapper(null,
			SigitTmpLibrettoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_TMP_LIBRETTO";
	}

	/** 
	 * Implementazione del finder DaElaborare
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTmpLibrettoDto> findDaElaborare(String input) throws SigitTmpLibrettoDaoException {
		LOG.debug("[SigitTmpLibrettoDaoImpl::findDaElaborare] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_LIBRETTO,FLG_ELABORATO,FLG_ESITO_ELAB,DATA_ELAB ");
		sql.append(" FROM SIGIT_TMP_LIBRETTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R401747970) ENABLED START*/
		sql.append(" FLG_ELABORATO IS NULL OR FLG_ELABORATO = 0");
		sql.append(" ORDER BY ID_LIBRETTO ");
		sql.append(
				" LIMIT (select valore_config_num from sigit_wrk_config where chiave_config = 'MAX_LIBRETTI_DA_ELABORARE')");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R449848960) ENABLED START*/

		/*PROTECTED REGION END*/
		List<SigitTmpLibrettoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, DaElaborareRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTmpLibrettoDaoImpl::findDaElaborare] esecuzione query", ex);
			throw new SigitTmpLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTmpLibrettoDaoImpl", "findDaElaborare", "esecuzione query", sql.toString());
			LOG.debug("[SigitTmpLibrettoDaoImpl::findDaElaborare] END");
		}
		return list;
	}

}
