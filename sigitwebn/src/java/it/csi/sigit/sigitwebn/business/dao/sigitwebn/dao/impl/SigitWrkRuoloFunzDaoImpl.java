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

/*PROTECTED REGION ID(R311691471) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitWrkRuoloFunz.
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
public class SigitWrkRuoloFunzDaoImpl extends AbstractDAO implements SigitWrkRuoloFunzDao {
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

	protected SigitWrkRuoloFunzDaoRowMapper findAllRowMapper = new SigitWrkRuoloFunzDaoRowMapper(null,
			SigitWrkRuoloFunzDto.class, this);

	protected SigitWrkRuoloFunzDaoRowMapper findByPrimaryKeyRowMapper = new SigitWrkRuoloFunzDaoRowMapper(null,
			SigitWrkRuoloFunzDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_WRK_RUOLO_FUNZ";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_WRK_RUOLO_FUNZ.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitWrkRuoloFunzDto> findAll() throws SigitWrkRuoloFunzDaoException {
		LOG.debug("[SigitWrkRuoloFunzDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT RUOLO,FLG_ACQ_BOLLINO,FLG_ACQ_COD_IMP,FLG_ACQ_BOLL_TRANS,FLG_IMPIANTO,FLG_ALLEGATO,FLG_CONSULTAZIONE,FLG_ISPEZIONE,FLG_IMPORT_MASS_ALLEGATO,FLG_SUBENTRO,FLG_DELEGA,FLG_3RESPONSABILE,FLG_RIC_AVZ_IMPIANTI,FLG_DISTRIBUTORI,FLG_INCARICHI_CAT,FLG_IMPRESA,FLG_EXP_XML_MODOL FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitWrkRuoloFunzDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitWrkRuoloFunzDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitWrkRuoloFunzDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitWrkRuoloFunzDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitWrkRuoloFunzDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_WRK_RUOLO_FUNZ table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitWrkRuoloFunzDto findByPrimaryKey(SigitWrkRuoloFunzPk pk) throws SigitWrkRuoloFunzDaoException {
		LOG.debug("[SigitWrkRuoloFunzDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT RUOLO,FLG_ACQ_BOLLINO,FLG_ACQ_COD_IMP,FLG_ACQ_BOLL_TRANS,FLG_IMPIANTO,FLG_ALLEGATO,FLG_CONSULTAZIONE,FLG_ISPEZIONE,FLG_IMPORT_MASS_ALLEGATO,FLG_SUBENTRO,FLG_DELEGA,FLG_3RESPONSABILE,FLG_RIC_AVZ_IMPIANTI,FLG_DISTRIBUTORI,FLG_INCARICHI_CAT,FLG_IMPRESA,FLG_EXP_XML_MODOL FROM "
						+ getTableName() + " WHERE RUOLO = :RUOLO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [RUOLO]
		params.addValue("RUOLO", pk.getRuolo(), java.sql.Types.VARCHAR);

		List<SigitWrkRuoloFunzDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitWrkRuoloFunzDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitWrkRuoloFunzDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitWrkRuoloFunzDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitWrkRuoloFunzDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
