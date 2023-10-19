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

/*PROTECTED REGION ID(R62211919) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO SigitTStoricoVarStato.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByCodiceImpianto (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTStoricoVarStatoDaoImpl extends AbstractDAO implements SigitTStoricoVarStatoDao {
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

	protected SigitTStoricoVarStatoDaoRowMapper findByCodiceImpiantoRowMapper = new SigitTStoricoVarStatoDaoRowMapper(
			null, SigitTStoricoVarStatoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_STORICO_VARIAZ_STATO";
	}

	/** 
	 * Implementazione del finder findByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTStoricoVarStatoDto> findFindByCodiceImpianto(java.lang.Integer input)
			throws SigitTStoricoVarStatoDaoException {
		LOG.debug("[SigitTStoricoVarStatoDaoImpl::findFindByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,DT_EVENTO,DT_INIZIO_VARIAZIONE,MOTIVO,STATO_DA,STATO_A,DATA_ULT_MOD,UTENTE_ULT_MOD ");
		sql.append(" FROM SIGIT_T_STORICO_VARIAZ_STATO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1912678135) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("nome = :nome");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1717083737) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("nome", input);

		/*PROTECTED REGION END*/
		List<SigitTStoricoVarStatoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTStoricoVarStatoDaoImpl::findFindByCodiceImpianto] esecuzione query", ex);
			throw new SigitTStoricoVarStatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTStoricoVarStatoDaoImpl", "findFindByCodiceImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTStoricoVarStatoDaoImpl::findFindByCodiceImpianto] END");
		}
		return list;
	}

}
