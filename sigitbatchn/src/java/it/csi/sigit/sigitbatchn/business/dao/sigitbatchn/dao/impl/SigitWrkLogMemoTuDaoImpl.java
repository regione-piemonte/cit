package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.*;
import it.csi.sigit.sigitbatchn.business.dao.util.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R1760107887) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitWrkLogMemoTu.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitWrkLogMemoTuDaoImpl extends AbstractDAO implements SigitWrkLogMemoTuDao {
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
	 * Metodo di inserimento del DAO sigitWrkLogMemoTu. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitWrkLogMemoTuPk
	 * @generated
	 */

	public SigitWrkLogMemoTuPk insert(SigitWrkLogMemoTuDto dto)

	{
		LOG.debug("[SigitWrkLogMemoTuDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_LOG_MEMO_PTU,DT_LOG_MEMO_PTU,NOTE_LOG_MEMO_PTU,MESSAGGIO_LOG_MEMO_PTU,ESITO_LOG_MEMO_PTU ) VALUES (  :ID_LOG_MEMO_PTU , :DT_LOG_MEMO_PTU , :NOTE_LOG_MEMO_PTU , :MESSAGGIO_LOG_MEMO_PTU , :ESITO_LOG_MEMO_PTU  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LOG_MEMO_PTU]
		params.addValue("ID_LOG_MEMO_PTU", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_LOG_MEMO_PTU]
		params.addValue("DT_LOG_MEMO_PTU", dto.getDtLogMemoPtu(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NOTE_LOG_MEMO_PTU]
		params.addValue("NOTE_LOG_MEMO_PTU", dto.getNoteLogMemoPtu(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MESSAGGIO_LOG_MEMO_PTU]
		params.addValue("MESSAGGIO_LOG_MEMO_PTU", dto.getMessaggioLogMemoPtu(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ESITO_LOG_MEMO_PTU]
		params.addValue("ESITO_LOG_MEMO_PTU", dto.getEsitoLogMemoPtu(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdLogMemoPtu(newKey);
		LOG.debug("[SigitWrkLogMemoTuDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_WRK_LOG_MEMO_PTU table.
	 * @generated
	 */
	public void update(SigitWrkLogMemoTuDto dto) throws SigitWrkLogMemoTuDaoException {
		LOG.debug("[SigitWrkLogMemoTuDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DT_LOG_MEMO_PTU = :DT_LOG_MEMO_PTU ,NOTE_LOG_MEMO_PTU = :NOTE_LOG_MEMO_PTU ,MESSAGGIO_LOG_MEMO_PTU = :MESSAGGIO_LOG_MEMO_PTU ,ESITO_LOG_MEMO_PTU = :ESITO_LOG_MEMO_PTU  WHERE ID_LOG_MEMO_PTU = :ID_LOG_MEMO_PTU ";

		if (dto.getIdLogMemoPtu() == null) {
			LOG.error("[SigitWrkLogMemoTuDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitWrkLogMemoTuDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LOG_MEMO_PTU]
		params.addValue("ID_LOG_MEMO_PTU", dto.getIdLogMemoPtu(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_LOG_MEMO_PTU]
		params.addValue("DT_LOG_MEMO_PTU", dto.getDtLogMemoPtu(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NOTE_LOG_MEMO_PTU]
		params.addValue("NOTE_LOG_MEMO_PTU", dto.getNoteLogMemoPtu(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MESSAGGIO_LOG_MEMO_PTU]
		params.addValue("MESSAGGIO_LOG_MEMO_PTU", dto.getMessaggioLogMemoPtu(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ESITO_LOG_MEMO_PTU]
		params.addValue("ESITO_LOG_MEMO_PTU", dto.getEsitoLogMemoPtu(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitWrkLogMemoTuDaoImpl::update] END");
	}

	protected SigitWrkLogMemoTuDaoRowMapper findByPrimaryKeyRowMapper = new SigitWrkLogMemoTuDaoRowMapper(null,
			SigitWrkLogMemoTuDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_WRK_LOG_MEMO_PTU";
	}

	/** 
	 * Returns all rows from the SIGIT_WRK_LOG_MEMO_PTU table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitWrkLogMemoTuDto findByPrimaryKey(SigitWrkLogMemoTuPk pk) throws SigitWrkLogMemoTuDaoException {
		LOG.debug("[SigitWrkLogMemoTuDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_LOG_MEMO_PTU,DT_LOG_MEMO_PTU,NOTE_LOG_MEMO_PTU,MESSAGGIO_LOG_MEMO_PTU,ESITO_LOG_MEMO_PTU FROM "
						+ getTableName() + " WHERE ID_LOG_MEMO_PTU = :ID_LOG_MEMO_PTU ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LOG_MEMO_PTU]
		params.addValue("ID_LOG_MEMO_PTU", pk.getIdLogMemoPtu(), java.sql.Types.NUMERIC);

		List<SigitWrkLogMemoTuDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitWrkLogMemoTuDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitWrkLogMemoTuDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitWrkLogMemoTuDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitWrkLogMemoTuDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
