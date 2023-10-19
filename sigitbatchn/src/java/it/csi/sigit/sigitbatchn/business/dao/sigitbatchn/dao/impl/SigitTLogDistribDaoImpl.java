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

/*PROTECTED REGION ID(R-1328234841) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTLogDistrib.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - byIdImportDistrib (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTLogDistribDaoImpl extends AbstractDAO implements SigitTLogDistribDao {
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
	 * Metodo di inserimento del DAO sigitTLogDistrib. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTLogDistribPk
	 * @generated
	 */

	public SigitTLogDistribPk insert(SigitTLogDistribDto dto)

	{
		LOG.debug("[SigitTLogDistribDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_LOG_DISTRIB,FK_IMPORT_DISTRIB,MSG_ERRORE ) VALUES (  :ID_LOG_DISTRIB , :FK_IMPORT_DISTRIB , :MSG_ERRORE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LOG_DISTRIB]
		params.addValue("ID_LOG_DISTRIB", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_IMPORT_DISTRIB]
		params.addValue("FK_IMPORT_DISTRIB", dto.getFkImportDistrib(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [MSG_ERRORE]
		params.addValue("MSG_ERRORE", dto.getMsgErrore(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdLogDistrib(newKey);
		LOG.debug("[SigitTLogDistribDaoImpl::insert] END");
		return dto.createPk();

	}

	protected SigitTLogDistribDaoRowMapper byIdImportDistribRowMapper = new SigitTLogDistribDaoRowMapper(null,
			SigitTLogDistribDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_LOG_DISTRIB";
	}

	/** 
	 * Implementazione del finder byIdImportDistrib
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLogDistribDto> findByIdImportDistrib(java.lang.Integer input)
			throws SigitTLogDistribDaoException {
		LOG.debug("[SigitTLogDistribDaoImpl::findByIdImportDistrib] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_LOG_DISTRIB,FK_IMPORT_DISTRIB,MSG_ERRORE ");
		sql.append(" FROM SIGIT_T_LOG_DISTRIB");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1989168153) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("FK_IMPORT_DISTRIB = :idImportDistrib");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1659556849) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idImportDistrib", input);

		/*PROTECTED REGION END*/
		List<SigitTLogDistribDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdImportDistribRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTLogDistribDaoImpl::findByIdImportDistrib] esecuzione query", ex);
			throw new SigitTLogDistribDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTLogDistribDaoImpl", "findByIdImportDistrib", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTLogDistribDaoImpl::findByIdImportDistrib] END");
		}
		return list;
	}

}
