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

/*PROTECTED REGION ID(R1490398927) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitWrkLogPrec.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 *   - Old (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitWrkLogPrecDaoImpl extends AbstractDAO implements SigitWrkLogPrecDao {
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
	 * Metodo di inserimento del DAO sigitWrkLogPrec. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitWrkLogPrecPk
	 * @generated
	 */

	public SigitWrkLogPrecPk insert(SigitWrkLogPrecDto dto)

	{
		LOG.debug("[SigitWrkLogPrecDaoImpl::insert] START");
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
		params.addValue("ID_LOG", dto.getIdLog(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitWrkLogPrecDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom deleter in the SIGIT_WRK_LOG_PREC table.
	 * @generated
	 */
	public void customDeleterOld(java.lang.Integer filter) throws SigitWrkLogPrecDaoException {
		LOG.debug("[SigitWrkLogPrecDaoImpl::customDeleterOld] START");
		/*PROTECTED REGION ID(R-1529421487) ENABLED START*/
		//***scrivere la custom query
		final StringBuffer sql = new StringBuffer("DELETE FROM " + getTableName() + " wlog WHERE ");
		MapSqlParameterSource params = new MapSqlParameterSource();

		sql.append(" EXISTS ");
		sql.append(" (SELECT 1 FROM SIGIT_WRK_LOG_PREC wlog2 ");
		sql.append(" WHERE   wlog.id_log = wlog2.id_log ");
		sql.append(" AND DATE_PART('year', DATA_OPERAZIONE) <= DATE_PART('year', now())-3 ");
		sql.append(" ORDER BY ID_LOG ASC ");
		sql.append(
				" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RECORDS_STORICIZZAZIONE')) ");

		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitWrkLogPrecDaoImpl::customDeleterOld] END");
	}

	protected SigitWrkLogPrecDaoRowMapper findAllRowMapper = new SigitWrkLogPrecDaoRowMapper(null,
			SigitWrkLogPrecDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_WRK_LOG_PREC";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_WRK_LOG_PREC.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitWrkLogPrecDto> findAll() throws SigitWrkLogPrecDaoException {
		LOG.debug("[SigitWrkLogPrecDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT CODICE_FISCALE,DATA_OPERAZIONE,TBL_IMPATTATA,ID_RECORD,TIPO_OPERAZIONE,ID_LOG FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitWrkLogPrecDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitWrkLogPrecDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitWrkLogPrecDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitWrkLogPrecDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitWrkLogPrecDaoImpl::findAll] END");
		}
		return list;
	}

}
