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

/*PROTECTED REGION ID(R-1979014103) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVCompTe.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byCodImpiantoOrdered (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVCompTeDaoImpl extends AbstractDAO implements SigitVCompTeDao {
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

	protected SigitVCompTeDaoRowMapper byCodImpiantoOrderedRowMapper = new SigitVCompTeDaoRowMapper(null,
			SigitVCompTeDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_COMP_TE";
	}

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompTeDto> findByCodImpiantoOrdered(Integer input) throws SigitVCompTeDaoException {
		LOG.debug("[SigitVCompTeDaoImpl::findByCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,DATA_INSTALL,PROGRESSIVO,DATA_DISMISS,MATRICOLA,FK_MARCA,DES_MARCA,MODELLO,NUM_VENTILATORI,TIPO_VENTILATORI,CAPACITA_L,FLG_DISMISSIONE ");
		sql.append(" FROM VISTA_COMP_TE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1811910177) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" ORDER BY PROGRESSIVO ASC, DATA_INSTALL DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R459526889) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVCompTeDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompTeDaoImpl::findByCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitVCompTeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompTeDaoImpl", "findByCodImpiantoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVCompTeDaoImpl::findByCodImpiantoOrdered] END");
		}
		return list;
	}

}
