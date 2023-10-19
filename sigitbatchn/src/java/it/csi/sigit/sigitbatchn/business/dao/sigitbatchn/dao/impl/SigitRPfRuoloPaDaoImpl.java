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

/*PROTECTED REGION ID(R-165634033) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRPfRuoloPa.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - IdUtentiPAAttivi (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRPfRuoloPaDaoImpl extends AbstractDAO implements SigitRPfRuoloPaDao {
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

	protected SigitRPfRuoloPaDaoRowMapper IdUtentiPAAttiviRowMapper = new SigitRPfRuoloPaDaoRowMapper(
			new String[]{"ID_PERSONA_FISICA"}, SigitRPfRuoloPaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_PF_RUOLO_PA";
	}

	/** 
	 * Implementazione del finder IdUtentiPAAttivi
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfRuoloPaDto> findIdUtentiPAAttivi(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitRPfRuoloPaDto input)
			throws SigitRPfRuoloPaDaoException {
		LOG.debug("[SigitRPfRuoloPaDaoImpl::findIdUtentiPAAttivi] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT DISTINCT ID_PERSONA_FISICA ");
		sql.append(" FROM SIGIT_R_PF_RUOLO_PA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R182084170) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("data_fine is null");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1474528224) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitRPfRuoloPaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, IdUtentiPAAttiviRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::findIdUtentiPAAttivi] esecuzione query", ex);
			throw new SigitRPfRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfRuoloPaDaoImpl", "findIdUtentiPAAttivi", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfRuoloPaDaoImpl::findIdUtentiPAAttivi] END");
		}
		return list;
	}

}
