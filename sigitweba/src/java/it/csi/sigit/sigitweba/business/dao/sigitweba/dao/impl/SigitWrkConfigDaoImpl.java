package it.csi.sigit.sigitweba.business.dao.sigitweba.dao.impl;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.mapper.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.qbe.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.metadata.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import it.csi.sigit.sigitweba.business.dao.impl.*;
import it.csi.sigit.sigitweba.business.dao.util.*;
import it.csi.sigit.sigitweba.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R-894406527) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitWrkConfig.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byChiaveConfig (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitWrkConfigDaoImpl extends AbstractDAO implements SigitWrkConfigDao {
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

	protected SigitWrkConfigDaoRowMapper byChiaveConfigRowMapper = new SigitWrkConfigDaoRowMapper(null,
			SigitWrkConfigDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_WRK_CONFIG";
	}

	/** 
	 * Implementazione del finder byChiaveConfig
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitWrkConfigDto> findByChiaveConfig(java.lang.String input) throws SigitWrkConfigDaoException {
		LOG.debug("[SigitWrkConfigDaoImpl::findByChiaveConfig] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_CONFIG,CHIAVE_CONFIG,VALORE_CONFIG_NUM,VALORE_CONFIG_CHAR,VALORE_FLAG ");
		sql.append(" FROM SIGIT_WRK_CONFIG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R833772130) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("CHIAVE_CONFIG = :chiave");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R957696422) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("chiave", input, java.sql.Types.VARCHAR);

		/*PROTECTED REGION END*/
		List<SigitWrkConfigDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byChiaveConfigRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitWrkConfigDaoImpl::findByChiaveConfig] esecuzione query", ex);
			throw new SigitWrkConfigDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitWrkConfigDaoImpl", "findByChiaveConfig", "esecuzione query", sql.toString());
			LOG.debug("[SigitWrkConfigDaoImpl::findByChiaveConfig] END");
		}
		return list;
	}

}
