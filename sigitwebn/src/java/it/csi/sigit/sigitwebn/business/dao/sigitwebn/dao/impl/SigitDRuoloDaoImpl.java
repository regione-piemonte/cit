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

/*PROTECTED REGION ID(R-602289489) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDRuolo.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byDesRuolo (datagen::CustomFinder)
 *   - byRuoloFunzionale (datagen::CustomFinder)
 *   - byRuoloFunzionaleCodImp (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDRuoloDaoImpl extends AbstractDAO implements SigitDRuoloDao {
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

	protected SigitDRuoloDaoRowMapper findAllRowMapper = new SigitDRuoloDaoRowMapper(null, SigitDRuoloDto.class, this);

	protected SigitDRuoloDaoRowMapper findByPrimaryKeyRowMapper = new SigitDRuoloDaoRowMapper(null,
			SigitDRuoloDto.class, this);

	protected SigitDRuoloDaoRowMapper byDesRuoloRowMapper = new SigitDRuoloDaoRowMapper(null, SigitDRuoloDto.class,
			this);

	protected SigitDRuoloDaoRowMapper byRuoloFunzionaleRowMapper = new SigitDRuoloDaoRowMapper(null,
			SigitDRuoloDto.class, this);

	protected SigitDRuoloDaoRowMapper byRuoloFunzionaleCodImpRowMapper = new SigitDRuoloDaoRowMapper(null,
			SigitDRuoloDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_RUOLO";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_RUOLO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDRuoloDto> findAll() throws SigitDRuoloDaoException {
		LOG.debug("[SigitDRuoloDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_RUOLO,DES_RUOLO,RUOLO_FUNZ FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDRuoloDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDRuoloDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDRuoloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDRuoloDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDRuoloDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_RUOLO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDRuoloDto findByPrimaryKey(SigitDRuoloPk pk) throws SigitDRuoloDaoException {
		LOG.debug("[SigitDRuoloDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_RUOLO,DES_RUOLO,RUOLO_FUNZ FROM " + getTableName() + " WHERE ID_RUOLO = :ID_RUOLO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO]
		params.addValue("ID_RUOLO", pk.getIdRuolo(), java.sql.Types.NUMERIC);

		List<SigitDRuoloDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDRuoloDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDRuoloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDRuoloDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitDRuoloDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byDesRuolo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDRuoloDto> findByDesRuolo(java.lang.String input) throws SigitDRuoloDaoException {
		LOG.debug("[SigitDRuoloDaoImpl::findByDesRuolo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_RUOLO,DES_RUOLO,RUOLO_FUNZ ");
		sql.append(" FROM SIGIT_D_RUOLO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-192357905) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" UPPER(des_ruolo) = UPPER(:desRuolo)");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-787563981) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("desRuolo", input);

		/*PROTECTED REGION END*/
		List<SigitDRuoloDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byDesRuoloRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDRuoloDaoImpl::findByDesRuolo] esecuzione query", ex);
			throw new SigitDRuoloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDRuoloDaoImpl", "findByDesRuolo", "esecuzione query", sql.toString());
			LOG.debug("[SigitDRuoloDaoImpl::findByDesRuolo] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byRuoloFunzionale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDRuoloDto> findByRuoloFunzionale(java.lang.String input) throws SigitDRuoloDaoException {
		LOG.debug("[SigitDRuoloDaoImpl::findByRuoloFunzionale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_RUOLO,DES_RUOLO,RUOLO_FUNZ ");
		sql.append(" FROM SIGIT_D_RUOLO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1859823270) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" UPPER(RUOLO_FUNZ) = UPPER(:ruoloFunz)");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1594456996) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("ruoloFunz", input);

		/*PROTECTED REGION END*/
		List<SigitDRuoloDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byRuoloFunzionaleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDRuoloDaoImpl::findByRuoloFunzionale] esecuzione query", ex);
			throw new SigitDRuoloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDRuoloDaoImpl", "findByRuoloFunzionale", "esecuzione query", sql.toString());
			LOG.debug("[SigitDRuoloDaoImpl::findByRuoloFunzionale] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byRuoloFunzionaleCodImp
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDRuoloDto> findByRuoloFunzionaleCodImp(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.SubentroFilter input) throws SigitDRuoloDaoException {
		LOG.debug("[SigitDRuoloDaoImpl::findByRuoloFunzionaleCodImp] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_RUOLO,DES_RUOLO,RUOLO_FUNZ ");
		sql.append(" FROM SIGIT_D_RUOLO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R776734970) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" UPPER(RUOLO_FUNZ) = UPPER(:ruoloFunz)");

		sql.append(" AND ID_RUOLO IN( ");
		sql.append(" SELECT FK_RUOLO FROM SIGIT_R_COMP4_MANUT WHERE CODICE_IMPIANTO = :codImpianto ");
		sql.append(" AND DATA_FINE IS NULL AND FK_RUOLO IN(" + Constants.ID_RUOLO_MANUTENTORE_ALL_1 + ","
				+ Constants.ID_RUOLO_MANUTENTORE_ALL_2 + "," + Constants.ID_RUOLO_MANUTENTORE_ALL_3 + ","
				+ Constants.ID_RUOLO_MANUTENTORE_ALL_4 + "))");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-810455928) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("ruoloFunz", input.getDescRuoloFunz());
		paramMap.addValue("codImpianto", input.getCodiceImpianto());

		/*PROTECTED REGION END*/
		List<SigitDRuoloDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byRuoloFunzionaleCodImpRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDRuoloDaoImpl::findByRuoloFunzionaleCodImp] esecuzione query", ex);
			throw new SigitDRuoloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDRuoloDaoImpl", "findByRuoloFunzionaleCodImp", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitDRuoloDaoImpl::findByRuoloFunzionaleCodImp] END");
		}
		return list;
	}

}
