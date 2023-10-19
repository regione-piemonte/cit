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

/*PROTECTED REGION ID(R-190748849) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitWrkLog.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - daArchiviare (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitWrkLogDaoImpl extends AbstractDAO implements SigitWrkLogDao {
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
	 * Metodo di inserimento del DAO sigitWrkLog. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitWrkLogPk
	 * @generated
	 */

	public SigitWrkLogPk insert(SigitWrkLogDto dto)

	{
		LOG.debug("[SigitWrkLogDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_FISCALE,DATA_OPERAZIONE,TBL_IMPATTATA,ID_RECORD,TIPO_OPERAZIONE,ID_LOG ) VALUES (  :CODICE_FISCALE , :DATA_OPERAZIONE , :TBL_IMPATTATA , :ID_RECORD , :TIPO_OPERAZIONE , :ID_LOG  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_OPERAZIONE]
		params.addValue("DATA_OPERAZIONE", dto.getDataOperazione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [TBL_IMPATTATA]
		params.addValue("TBL_IMPATTATA", dto.getTblImpattata(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_RECORD]
		params.addValue("ID_RECORD", dto.getIdRecord(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TIPO_OPERAZIONE]
		params.addValue("TIPO_OPERAZIONE", dto.getTipoOperazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_LOG]
		params.addValue("ID_LOG", newKey, java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdLog(newKey);
		LOG.debug("[SigitWrkLogDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the SIGIT_WRK_LOG table.
	 * @generated
	 */

	public void delete(SigitWrkLogPk pk) throws SigitWrkLogDaoException {
		LOG.debug("[SigitWrkLogDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_LOG = :ID_LOG ";

		if (pk == null) {
			LOG.error("[SigitWrkLogDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitWrkLogDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LOG]
		params.addValue("ID_LOG", pk.getIdLog(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitWrkLogDaoImpl::delete] END");
	}

	protected SigitWrkLogDaoRowMapper daArchiviareRowMapper = new SigitWrkLogDaoRowMapper(null, SigitWrkLogDto.class,
			this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_WRK_LOG";
	}

	/** 
	 * Implementazione del finder daArchiviare
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitWrkLogDto> findDaArchiviare(java.lang.Integer input) throws SigitWrkLogDaoException {
		LOG.debug("[SigitWrkLogDaoImpl::findDaArchiviare] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT CODICE_FISCALE,DATA_OPERAZIONE,TBL_IMPATTATA,ID_RECORD,TIPO_OPERAZIONE,ID_LOG ");
		sql.append(" FROM SIGIT_WRK_LOG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-469934545) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" DATE_PART('year', DATA_OPERAZIONE) <= DATE_PART('year', now())-2 ");
		sql.append(" ORDER BY ID_LOG ASC ");
		sql.append(
				" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RECORDS_STORICIZZAZIONE') ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-802505229) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitWrkLogDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, daArchiviareRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitWrkLogDaoImpl::findDaArchiviare] esecuzione query", ex);
			throw new SigitWrkLogDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitWrkLogDaoImpl", "findDaArchiviare", "esecuzione query", sql.toString());
			LOG.debug("[SigitWrkLogDaoImpl::findDaArchiviare] END");
		}
		return list;
	}

}
