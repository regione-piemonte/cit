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

/*PROTECTED REGION ID(R-1018990417) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDAutodichiarazione.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - forCombo (datagen::CustomFinder)
 *   - findAll (datagen::FindAll)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDAutodichiarazioneDaoImpl extends AbstractDAO implements SigitDAutodichiarazioneDao {
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

	protected SigitDAutodichiarazioneDaoRowMapper forComboRowMapper = new SigitDAutodichiarazioneDaoRowMapper(null,
			SigitDAutodichiarazioneDto.class, this);

	protected SigitDAutodichiarazioneDaoRowMapper findAllRowMapper = new SigitDAutodichiarazioneDaoRowMapper(null,
			SigitDAutodichiarazioneDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_AUTODICHIARAZIONE";
	}

	/** 
	 * Implementazione del finder forCombo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDAutodichiarazioneDto> findForCombo(java.lang.String input)
			throws SigitDAutodichiarazioneDaoException {
		LOG.debug("[SigitDAutodichiarazioneDaoImpl::findForCombo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_AUTODICHIARAZIONE,DES_AUTODICHIARAZIONE ");
		sql.append(" FROM SIGIT_D_AUTODICHIARAZIONE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1739253064) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("DES_AUTODICHIARAZIONE = :des");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1037166086) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("des", input);

		/*PROTECTED REGION END*/
		List<SigitDAutodichiarazioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, forComboRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDAutodichiarazioneDaoImpl::findForCombo] esecuzione query", ex);
			throw new SigitDAutodichiarazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDAutodichiarazioneDaoImpl", "findForCombo", "esecuzione query", sql.toString());
			LOG.debug("[SigitDAutodichiarazioneDaoImpl::findForCombo] END");
		}
		return list;
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_AUTODICHIARAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDAutodichiarazioneDto> findAll() throws SigitDAutodichiarazioneDaoException {
		LOG.debug("[SigitDAutodichiarazioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AUTODICHIARAZIONE,DES_AUTODICHIARAZIONE FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDAutodichiarazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDAutodichiarazioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDAutodichiarazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDAutodichiarazioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDAutodichiarazioneDaoImpl::findAll] END");
		}
		return list;
	}

}
