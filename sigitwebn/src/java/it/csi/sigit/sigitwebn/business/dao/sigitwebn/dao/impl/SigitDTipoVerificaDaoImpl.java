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

/*PROTECTED REGION ID(R1357079803) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDTipoVerifica.
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
public class SigitDTipoVerificaDaoImpl extends AbstractDAO implements SigitDTipoVerificaDao {
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

	protected SigitDTipoVerificaDaoRowMapper findByPrimaryKeyRowMapper = new SigitDTipoVerificaDaoRowMapper(null,
			SigitDTipoVerificaDto.class, this);

	protected SigitDTipoVerificaDaoRowMapper findAllRowMapper = new SigitDTipoVerificaDaoRowMapper(null,
			SigitDTipoVerificaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_TIPO_VERIFICA";
	}

	/** 
	 * Returns all rows from the SIGIT_D_TIPO_VERIFICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDTipoVerificaDto findByPrimaryKey(SigitDTipoVerificaPk pk) throws SigitDTipoVerificaDaoException {
		LOG.debug("[SigitDTipoVerificaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_TIPO_VERIFICA,DES_TIPO_VERIFICA FROM " + getTableName()
				+ " WHERE ID_TIPO_VERIFICA = :ID_TIPO_VERIFICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_VERIFICA]
		params.addValue("ID_TIPO_VERIFICA", pk.getIdTipoVerifica(), java.sql.Types.INTEGER);

		List<SigitDTipoVerificaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoVerificaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDTipoVerificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoVerificaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoVerificaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_TIPO_VERIFICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoVerificaDto> findAll() throws SigitDTipoVerificaDaoException {
		LOG.debug("[SigitDTipoVerificaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_TIPO_VERIFICA,DES_TIPO_VERIFICA FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDTipoVerificaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoVerificaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDTipoVerificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoVerificaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoVerificaDaoImpl::findAll] END");
		}
		return list;
	}

}
