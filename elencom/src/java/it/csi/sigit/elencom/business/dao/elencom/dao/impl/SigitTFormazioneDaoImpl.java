package it.csi.sigit.elencom.business.dao.elencom.dao.impl;

import it.csi.sigit.elencom.business.dao.elencom.dao.*;
import it.csi.sigit.elencom.business.dao.elencom.dao.mapper.*;
import it.csi.sigit.elencom.business.dao.elencom.dto.*;
import it.csi.sigit.elencom.business.dao.elencom.qbe.*;
import it.csi.sigit.elencom.business.dao.elencom.metadata.*;
import it.csi.sigit.elencom.business.dao.elencom.exceptions.*;
import it.csi.sigit.elencom.business.dao.impl.*;
import it.csi.sigit.elencom.business.dao.util.*;
import it.csi.sigit.elencom.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R-941010631) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTFormazione.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - formazionePG (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTFormazioneDaoImpl extends AbstractDAO implements SigitTFormazioneDao {
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

	protected SigitTFormazioneDaoRowMapper formazionePGRowMapper = new SigitTFormazioneDaoRowMapper(null,
			SigitTFormazioneDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_FORMAZIONE";
	}

	/** 
	 * Implementazione del finder formazionePG
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTFormazioneDto> findFormazionePG(Integer input) throws SigitTFormazioneDaoException {
		LOG.debug("[SigitTFormazioneDaoImpl::findFormazionePG] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1976475148) ENABLED START*/
		sql.append("SELECT DATA_CORSO,DES_CORSO, FORM.ID_PERSONA_FISICA ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1626622626) ENABLED START*/
		sql.append(" FROM SIGIT_T_FORMAZIONE FORM, SIGIT_T_PERSONA_FISICA PF, SIGIT_R_PF_PG_DELEGA DEL");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1727445170) ENABLED START*/
		sql.append(" FORM.ID_PERSONA_FISICA = PF.ID_PERSONA_FISICA "
				+ "AND DEL.ID_PERSONA_FISICA = PF.ID_PERSONA_FISICA " + "AND DEL.FLG_DELEGA = 'A' ");
		sql.append(" AND ID_PERSONA_GIURIDICA = :pg");
		sql.append(" ORDER BY DATA_CORSO DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R667934502) ENABLED START*/

		paramMap.addValue("pg", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTFormazioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, formazionePGRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTFormazioneDaoImpl::findFormazionePG] esecuzione query", ex);
			throw new SigitTFormazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTFormazioneDaoImpl", "findFormazionePG", "esecuzione query", sql.toString());
			LOG.debug("[SigitTFormazioneDaoImpl::findFormazionePG] END");
		}
		return list;
	}

}
