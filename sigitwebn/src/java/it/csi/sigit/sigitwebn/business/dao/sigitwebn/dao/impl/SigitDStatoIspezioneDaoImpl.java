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

/*PROTECTED REGION ID(R589689791) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDStatoIspezione.
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
public class SigitDStatoIspezioneDaoImpl extends AbstractDAO implements SigitDStatoIspezioneDao {
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

	protected SigitDStatoIspezioneDaoRowMapper findAllRowMapper = new SigitDStatoIspezioneDaoRowMapper(null,
			SigitDStatoIspezioneDto.class, this);

	protected SigitDStatoIspezioneDaoRowMapper byDescrizioneRowMapper = new SigitDStatoIspezioneDaoRowMapper(null,
			SigitDStatoIspezioneDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_STATO_ISPEZIONE";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_STATO_ISPEZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDStatoIspezioneDto> findAll() throws SigitDStatoIspezioneDaoException {
		LOG.debug("[SigitDStatoIspezioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_STATO_ISPEZIONE,DES_STATO_ISPEZIONE FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDStatoIspezioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDStatoIspezioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDStatoIspezioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStatoIspezioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDStatoIspezioneDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byDescrizione
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDStatoIspezioneDto> findByDescrizione(java.lang.String input)
			throws SigitDStatoIspezioneDaoException {
		LOG.debug("[SigitDStatoIspezioneDaoImpl::findByDescrizione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_STATO_ISPEZIONE,DES_STATO_ISPEZIONE ");
		sql.append(" FROM SIGIT_D_STATO_ISPEZIONE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-854539941) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("nome = :nome");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R159629383) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("nome", input);

		/*PROTECTED REGION END*/
		List<SigitDStatoIspezioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byDescrizioneRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDStatoIspezioneDaoImpl::findByDescrizione] esecuzione query", ex);
			throw new SigitDStatoIspezioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStatoIspezioneDaoImpl", "findByDescrizione", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitDStatoIspezioneDaoImpl::findByDescrizione] END");
		}
		return list;
	}

}
