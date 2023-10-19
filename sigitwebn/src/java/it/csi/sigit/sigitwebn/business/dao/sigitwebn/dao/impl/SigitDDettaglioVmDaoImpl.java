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

/*PROTECTED REGION ID(R-56609201) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDDettaglioVm.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - byDescrizione (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDDettaglioVmDaoImpl extends AbstractDAO implements SigitDDettaglioVmDao {
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

	protected SigitDDettaglioVmDaoRowMapper findAllRowMapper = new SigitDDettaglioVmDaoRowMapper(null,
			SigitDDettaglioVmDto.class, this);

	protected SigitDDettaglioVmDaoRowMapper byDescrizioneRowMapper = new SigitDDettaglioVmDaoRowMapper(null,
			SigitDDettaglioVmDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_DETTAGLIO_VM";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_DETTAGLIO_VM.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDDettaglioVmDto> findAll() throws SigitDDettaglioVmDaoException {
		LOG.debug("[SigitDDettaglioVmDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_DETTAGLIO_VM,DES_DETTAGLIO_VM FROM " + getTableName());

		sql.append(" ORDER BY ID_DETTAGLIO_VM ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDDettaglioVmDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDDettaglioVmDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDDettaglioVmDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDDettaglioVmDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDDettaglioVmDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byDescrizione
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDDettaglioVmDto> findByDescrizione(java.lang.String input) throws SigitDDettaglioVmDaoException {
		LOG.debug("[SigitDDettaglioVmDaoImpl::findByDescrizione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_DETTAGLIO_VM,DES_DETTAGLIO_VM ");
		sql.append(" FROM SIGIT_D_DETTAGLIO_VM");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R79521254) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("UPPER(DES_DETTAGLIO_VM) LIKE UPPER(:descrizione)");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-949244644) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("descrizione", "%" + input + "%");

		/*PROTECTED REGION END*/
		List<SigitDDettaglioVmDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byDescrizioneRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDDettaglioVmDaoImpl::findByDescrizione] esecuzione query", ex);
			throw new SigitDDettaglioVmDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDDettaglioVmDaoImpl", "findByDescrizione", "esecuzione query", sql.toString());
			LOG.debug("[SigitDDettaglioVmDaoImpl::findByDescrizione] END");
		}
		return list;
	}

}
