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

/*PROTECTED REGION ID(R834610487) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDFonteEnSfruttata.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDFonteEnSfruttataDaoImpl extends AbstractDAO implements SigitDFonteEnSfruttataDao {
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

	protected SigitDFonteEnSfruttataDaoRowMapper findAllRowMapper = new SigitDFonteEnSfruttataDaoRowMapper(null,
			SigitDFonteEnSfruttataDto.class, this);

	protected SigitDFonteEnSfruttataDaoRowMapper findByPrimaryKeyRowMapper = new SigitDFonteEnSfruttataDaoRowMapper(
			null, SigitDFonteEnSfruttataDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_FONTE_EN_SFRUTTATA";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_FONTE_EN_SFRUTTATA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDFonteEnSfruttataDto> findAll() throws SigitDFonteEnSfruttataDaoException {
		LOG.debug("[SigitDFonteEnSfruttataDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_FONTE_EN_SFRUTTATA,DESC_FONTE_EN_SFRUTTATA FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDFonteEnSfruttataDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDFonteEnSfruttataDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDFonteEnSfruttataDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDFonteEnSfruttataDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDFonteEnSfruttataDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_FONTE_EN_SFRUTTATA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDFonteEnSfruttataDto findByPrimaryKey(SigitDFonteEnSfruttataPk pk)
			throws SigitDFonteEnSfruttataDaoException {
		LOG.debug("[SigitDFonteEnSfruttataDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_FONTE_EN_SFRUTTATA,DESC_FONTE_EN_SFRUTTATA FROM "
				+ getTableName() + " WHERE ID_FONTE_EN_SFRUTTATA = :ID_FONTE_EN_SFRUTTATA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_FONTE_EN_SFRUTTATA]
		params.addValue("ID_FONTE_EN_SFRUTTATA", pk.getIdFonteEnSfruttata(), java.sql.Types.NUMERIC);

		List<SigitDFonteEnSfruttataDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDFonteEnSfruttataDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDFonteEnSfruttataDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDFonteEnSfruttataDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitDFonteEnSfruttataDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
