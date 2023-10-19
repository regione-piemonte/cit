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

/*PROTECTED REGION ID(R-1266668411) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVCompGf.
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
public class SigitVCompGfDaoImpl extends AbstractDAO implements SigitVCompGfDao {
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

	protected SigitVCompGfDaoRowMapper getCompJoinAllegatoCompRowMapper = new SigitVCompGfDaoRowMapper(null,
			SigitVCompGfDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_COMP_GF";
	}

	/** 
	 * Implementazione del finder getCompJoinAllegatoComp
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompGfDto> findGetCompJoinAllegatoComp(
			it.csi.sigit.sigitbatchn.business.util.InputAllegatiComp input) throws SigitVCompGfDaoException {
		LOG.debug("[SigitVCompGfDaoImpl::findGetCompJoinAllegatoComp] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-553728603) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT VISTA_COMP_GF.* ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1375583891) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM VISTA_COMP_GF, SIGIT_R_ALLEGATO_COMP_GF");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-296333569) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append(" (VISTA_COMP_GF.CODICE_IMPIANTO = SIGIT_R_ALLEGATO_COMP_GF.CODICE_IMPIANTO");
		sql.append(" AND VISTA_COMP_GF.PROGRESSIVO = SIGIT_R_ALLEGATO_COMP_GF.PROGRESSIVO");
		sql.append(" AND VISTA_COMP_GF.DATA_INSTALL = SIGIT_R_ALLEGATO_COMP_GF.DATA_INSTALL");
		sql.append(" AND VISTA_COMP_GF.ID_TIPO_COMPONENTE = SIGIT_R_ALLEGATO_COMP_GF.ID_TIPO_COMPONENTE)");
		sql.append(" AND SIGIT_R_ALLEGATO_COMP_GF.ID_ALLEGATO = :idAllegato");
		sql.append(" AND SIGIT_R_ALLEGATO_COMP_GF.CODICE_IMPIANTO = :codiceImpianto");
		sql.append(" AND VISTA_COMP_GF.DATA_DISMISS IS NULL");
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-471519797) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idAllegato", input.getIdAllegato());
		paramMap.addValue("codiceImpianto", input.getCodiceImpianto());

		/*PROTECTED REGION END*/
		List<SigitVCompGfDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, getCompJoinAllegatoCompRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompGfDaoImpl::findGetCompJoinAllegatoComp] esecuzione query", ex);
			throw new SigitVCompGfDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompGfDaoImpl", "findGetCompJoinAllegatoComp", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVCompGfDaoImpl::findGetCompJoinAllegatoComp] END");
		}
		return list;
	}

}
