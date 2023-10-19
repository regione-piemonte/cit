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

/*PROTECTED REGION ID(R1729459631) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitLAccesso.
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
public class SigitLAccessoDaoImpl extends AbstractDAO implements SigitLAccessoDao {
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
	 * Metodo di inserimento del DAO sigitLAccesso. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitLAccessoPk
	 * @generated
	 */

	public SigitLAccessoPk insert(SigitLAccessoDto dto)

	{
		LOG.debug("[SigitLAccessoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	DT_ACCESSO,CODICE_FISCALE,NOME,COGNOME,RUOLO ) VALUES (  :DT_ACCESSO , :CODICE_FISCALE , :NOME , :COGNOME , :RUOLO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DT_ACCESSO]
		params.addValue("DT_ACCESSO", dto.getDtAccesso(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME]
		params.addValue("NOME", dto.getNome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COGNOME]
		params.addValue("COGNOME", dto.getCognome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [RUOLO]
		params.addValue("RUOLO", dto.getRuolo(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitLAccessoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the SIGIT_L_ACCESSO table.
	 * @generated
	 */

	public void delete(SigitLAccessoPk pk) throws SigitLAccessoDaoException {
		LOG.debug("[SigitLAccessoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE DT_ACCESSO = :DT_ACCESSO  AND CODICE_FISCALE = :CODICE_FISCALE ";

		if (pk == null) {
			LOG.error("[SigitLAccessoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitLAccessoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DT_ACCESSO]
		params.addValue("DT_ACCESSO", pk.getDtAccesso(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", pk.getCodiceFiscale(), java.sql.Types.VARCHAR);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitLAccessoDaoImpl::delete] END");
	}

	protected SigitLAccessoDaoRowMapper daArchiviareRowMapper = new SigitLAccessoDaoRowMapper(null,
			SigitLAccessoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_L_ACCESSO";
	}

	/** 
	 * Implementazione del finder daArchiviare
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitLAccessoDto> findDaArchiviare(java.lang.Integer input) throws SigitLAccessoDaoException {
		LOG.debug("[SigitLAccessoDaoImpl::findDaArchiviare] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT DT_ACCESSO,CODICE_FISCALE,NOME,COGNOME,RUOLO ");
		sql.append(" FROM SIGIT_L_ACCESSO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R108540026) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" DATE_PART('year', DT_ACCESSO) < (DATE_PART('year', now()) - 1) ");
		sql.append(" ORDER BY DT_ACCESSO ASC ");
		sql.append(
				" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RECORDS_STORICIZZAZIONE') ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-49662712) ENABLED START*/
		//***aggiungere tutte le condizioni
		/*PROTECTED REGION END*/
		List<SigitLAccessoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, daArchiviareRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitLAccessoDaoImpl::findDaArchiviare] esecuzione query", ex);
			throw new SigitLAccessoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitLAccessoDaoImpl", "findDaArchiviare", "esecuzione query", sql.toString());
			LOG.debug("[SigitLAccessoDaoImpl::findDaArchiviare] END");
		}
		return list;
	}

}
