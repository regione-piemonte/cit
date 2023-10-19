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

/*PROTECTED REGION ID(R1794668249) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDTipoAzione.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byCodice (datagen::CustomFinder)
 *   - findAll (datagen::FindAll)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDTipoAzioneDaoImpl extends AbstractDAO implements SigitDTipoAzioneDao {
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

	protected SigitDTipoAzioneDaoRowMapper byCodiceRowMapper = new SigitDTipoAzioneDaoRowMapper(null,
			SigitDTipoAzioneDto.class, this);

	protected SigitDTipoAzioneDaoRowMapper findAllRowMapper = new SigitDTipoAzioneDaoRowMapper(null,
			SigitDTipoAzioneDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_TIPO_AZIONE";
	}

	/** 
	 * Implementazione del finder byCodice
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoAzioneDto> findByCodice(java.lang.String input) throws SigitDTipoAzioneDaoException {
		LOG.debug("[SigitDTipoAzioneDaoImpl::findByCodice] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_TIPO_AZIONE,DES_TIPO_AZIONE ");
		sql.append(" FROM SIGIT_D_TIPO_AZIONE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1945217424) ENABLED START*/
		sql.append("DES_TIPO_AZIONE = :des");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1052761778) ENABLED START*/
		paramMap.addValue("des", input);
		/*PROTECTED REGION END*/
		List<SigitDTipoAzioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoAzioneDaoImpl::findByCodice] esecuzione query", ex);
			throw new SigitDTipoAzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoAzioneDaoImpl", "findByCodice", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoAzioneDaoImpl::findByCodice] END");
		}
		return list;
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_TIPO_AZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoAzioneDto> findAll() throws SigitDTipoAzioneDaoException {
		LOG.debug("[SigitDTipoAzioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_TIPO_AZIONE,DES_TIPO_AZIONE FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDTipoAzioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoAzioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDTipoAzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoAzioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoAzioneDaoImpl::findAll] END");
		}
		return list;
	}

}
