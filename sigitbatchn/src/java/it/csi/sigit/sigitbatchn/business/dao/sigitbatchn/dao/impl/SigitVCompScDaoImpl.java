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

/*PROTECTED REGION ID(R-670510169) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVCompSc.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - getCompJoinAllegatoComp (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVCompScDaoImpl extends AbstractDAO implements SigitVCompScDao {
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

	protected SigitVCompScDaoRowMapper getCompJoinAllegatoCompRowMapper = new SigitVCompScDaoRowMapper(null,
			SigitVCompScDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_COMP_SC";
	}

	/** 
	 * Implementazione del finder getCompJoinAllegatoComp
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompScDto> findGetCompJoinAllegatoComp(
			it.csi.sigit.sigitbatchn.business.util.InputAllegatiComp input) throws SigitVCompScDaoException {
		LOG.debug("[SigitVCompScDaoImpl::findGetCompJoinAllegatoComp] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1847527060) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT VISTA_COMP_SC.* ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1825009474) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM VISTA_COMP_SC, SIGIT_R_ALLEGATO_COMP_SC");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R750957616) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append(" (VISTA_COMP_SC.CODICE_IMPIANTO = SIGIT_R_ALLEGATO_COMP_SC.CODICE_IMPIANTO");
		sql.append(" AND VISTA_COMP_SC.PROGRESSIVO = SIGIT_R_ALLEGATO_COMP_SC.PROGRESSIVO");
		sql.append(" AND VISTA_COMP_SC.DATA_INSTALL = SIGIT_R_ALLEGATO_COMP_SC.DATA_INSTALL");
		sql.append(" AND VISTA_COMP_SC.ID_TIPO_COMPONENTE = SIGIT_R_ALLEGATO_COMP_SC.ID_TIPO_COMPONENTE)");
		sql.append(" AND SIGIT_R_ALLEGATO_COMP_SC.ID_ALLEGATO = :idAllegato");
		sql.append(" AND SIGIT_R_ALLEGATO_COMP_SC.CODICE_IMPIANTO = :codiceImpianto");
		sql.append(" AND VISTA_COMP_SC.DATA_DISMISS IS NULL");
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1929735866) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idAllegato", input.getIdAllegato());
		paramMap.addValue("codiceImpianto", input.getCodiceImpianto());

		/*PROTECTED REGION END*/
		List<SigitVCompScDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, getCompJoinAllegatoCompRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompScDaoImpl::findGetCompJoinAllegatoComp] esecuzione query", ex);
			throw new SigitVCompScDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompScDaoImpl", "findGetCompJoinAllegatoComp", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVCompScDaoImpl::findGetCompJoinAllegatoComp] END");
		}
		return list;
	}

}
