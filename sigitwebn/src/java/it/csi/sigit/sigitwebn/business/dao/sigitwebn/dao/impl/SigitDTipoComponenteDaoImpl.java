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

/*PROTECTED REGION ID(R-800828227) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDTipoComponente.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - allValide (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDTipoComponenteDaoImpl extends AbstractDAO implements SigitDTipoComponenteDao {
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

	protected SigitDTipoComponenteDaoRowMapper allValideRowMapper = new SigitDTipoComponenteDaoRowMapper(null,
			SigitDTipoComponenteDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_TIPO_COMPONENTE";
	}

	/** 
	 * Implementazione del finder allValide
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoComponenteDto> findAllValide(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoComponenteDto input)
			throws SigitDTipoComponenteDaoException {
		LOG.debug("[SigitDTipoComponenteDaoImpl::findAllValide] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_TIPO_COMPONENTE,DES_TIPO_COMPONENTE,FLG_VISUALIZZA ");
		sql.append(" FROM SIGIT_D_TIPO_COMPONENTE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R913578254) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("FLG_VISUALIZZA = " + Constants.SI_1);
		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DES_TIPO_COMPONENTE ASC"); /*PROTECTED REGION ID(R-863281420) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitDTipoComponenteDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, allValideRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoComponenteDaoImpl::findAllValide] esecuzione query", ex);
			throw new SigitDTipoComponenteDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoComponenteDaoImpl", "findAllValide", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoComponenteDaoImpl::findAllValide] END");
		}
		return list;
	}

}
