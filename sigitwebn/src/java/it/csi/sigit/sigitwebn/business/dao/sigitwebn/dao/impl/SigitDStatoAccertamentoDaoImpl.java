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

/*PROTECTED REGION ID(R2099400175) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDStatoAccertamento.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDStatoAccertamentoDaoImpl extends AbstractDAO implements SigitDStatoAccertamentoDao {
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

	protected SigitDStatoAccertamentoDaoRowMapper findByPrimaryKeyRowMapper = new SigitDStatoAccertamentoDaoRowMapper(
			null, SigitDStatoAccertamentoDto.class, this);

	protected SigitDStatoAccertamentoDaoRowMapper findAllRowMapper = new SigitDStatoAccertamentoDaoRowMapper(null,
			SigitDStatoAccertamentoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_STATO_ACCERTAMENTO";
	}

	/** 
	 * Returns all rows from the SIGIT_D_STATO_ACCERTAMENTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDStatoAccertamentoDto findByPrimaryKey(SigitDStatoAccertamentoPk pk)
			throws SigitDStatoAccertamentoDaoException {
		LOG.debug("[SigitDStatoAccertamentoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_STATO_ACCERTAMENTO,DES_STATO_ACCERTAMENTO FROM "
				+ getTableName() + " WHERE ID_STATO_ACCERTAMENTO = :ID_STATO_ACCERTAMENTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_ACCERTAMENTO]
		params.addValue("ID_STATO_ACCERTAMENTO", pk.getIdStatoAccertamento(), java.sql.Types.INTEGER);

		List<SigitDStatoAccertamentoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDStatoAccertamentoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDStatoAccertamentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStatoAccertamentoDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitDStatoAccertamentoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_STATO_ACCERTAMENTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDStatoAccertamentoDto> findAll() throws SigitDStatoAccertamentoDaoException {
		LOG.debug("[SigitDStatoAccertamentoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_STATO_ACCERTAMENTO,DES_STATO_ACCERTAMENTO FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDStatoAccertamentoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDStatoAccertamentoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDStatoAccertamentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStatoAccertamentoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDStatoAccertamentoDaoImpl::findAll] END");
		}
		return list;
	}

}
