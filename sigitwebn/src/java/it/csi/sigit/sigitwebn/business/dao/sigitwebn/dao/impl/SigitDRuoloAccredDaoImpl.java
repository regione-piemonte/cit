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

/*PROTECTED REGION ID(R-1329138385) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDRuoloAccred.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDRuoloAccredDaoImpl extends AbstractDAO implements SigitDRuoloAccredDao {
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
	 * Metodo di inserimento del DAO sigitDRuoloAccred. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitDRuoloAccredPk
	 * @generated
	 */

	public SigitDRuoloAccredPk insert(SigitDRuoloAccredDto dto)

	{
		LOG.debug("[SigitDRuoloAccredDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_RUOLO_ACCRED,DES_RUOLO_ACCRED ) VALUES (  :ID_RUOLO_ACCRED , :DES_RUOLO_ACCRED  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO_ACCRED]
		params.addValue("ID_RUOLO_ACCRED", dto.getIdRuoloAccred(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DES_RUOLO_ACCRED]
		params.addValue("DES_RUOLO_ACCRED", dto.getDesRuoloAccred(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitDRuoloAccredDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_D_RUOLO_ACCRED table.
	 * @generated
	 */
	public void update(SigitDRuoloAccredDto dto) throws SigitDRuoloAccredDaoException {
		LOG.debug("[SigitDRuoloAccredDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DES_RUOLO_ACCRED = :DES_RUOLO_ACCRED  WHERE ID_RUOLO_ACCRED = :ID_RUOLO_ACCRED ";

		if (dto.getIdRuoloAccred() == null) {
			LOG.error("[SigitDRuoloAccredDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitDRuoloAccredDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO_ACCRED]
		params.addValue("ID_RUOLO_ACCRED", dto.getIdRuoloAccred(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DES_RUOLO_ACCRED]
		params.addValue("DES_RUOLO_ACCRED", dto.getDesRuoloAccred(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitDRuoloAccredDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_D_RUOLO_ACCRED table.
	 * @generated
	 */

	public void delete(SigitDRuoloAccredPk pk) throws SigitDRuoloAccredDaoException {
		LOG.debug("[SigitDRuoloAccredDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_RUOLO_ACCRED = :ID_RUOLO_ACCRED ";

		if (pk == null) {
			LOG.error("[SigitDRuoloAccredDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitDRuoloAccredDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO_ACCRED]
		params.addValue("ID_RUOLO_ACCRED", pk.getIdRuoloAccred(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitDRuoloAccredDaoImpl::delete] END");
	}

	protected SigitDRuoloAccredDaoRowMapper findByPrimaryKeyRowMapper = new SigitDRuoloAccredDaoRowMapper(null,
			SigitDRuoloAccredDto.class, this);

	protected SigitDRuoloAccredDaoRowMapper findAllRowMapper = new SigitDRuoloAccredDaoRowMapper(null,
			SigitDRuoloAccredDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_RUOLO_ACCRED";
	}

	/** 
	 * Returns all rows from the SIGIT_D_RUOLO_ACCRED table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDRuoloAccredDto findByPrimaryKey(SigitDRuoloAccredPk pk) throws SigitDRuoloAccredDaoException {
		LOG.debug("[SigitDRuoloAccredDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_RUOLO_ACCRED,DES_RUOLO_ACCRED FROM " + getTableName()
				+ " WHERE ID_RUOLO_ACCRED = :ID_RUOLO_ACCRED ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO_ACCRED]
		params.addValue("ID_RUOLO_ACCRED", pk.getIdRuoloAccred(), java.sql.Types.NUMERIC);

		List<SigitDRuoloAccredDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDRuoloAccredDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDRuoloAccredDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDRuoloAccredDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitDRuoloAccredDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_RUOLO_ACCRED.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDRuoloAccredDto> findAll() throws SigitDRuoloAccredDaoException {
		LOG.debug("[SigitDRuoloAccredDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_RUOLO_ACCRED,DES_RUOLO_ACCRED FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDRuoloAccredDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDRuoloAccredDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDRuoloAccredDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDRuoloAccredDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDRuoloAccredDaoImpl::findAll] END");
		}
		return list;
	}

}
