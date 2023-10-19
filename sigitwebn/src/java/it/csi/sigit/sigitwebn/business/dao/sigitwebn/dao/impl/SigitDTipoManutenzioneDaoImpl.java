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

/*PROTECTED REGION ID(R1029580119) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDTipoManutenzione.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - forCombo (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDTipoManutenzioneDaoImpl extends AbstractDAO implements SigitDTipoManutenzioneDao {
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

	protected SigitDTipoManutenzioneDaoRowMapper forComboRowMapper = new SigitDTipoManutenzioneDaoRowMapper(null,
			SigitDTipoManutenzioneDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_TIPO_MANUTENZIONE";
	}

	/** 
	 * Implementazione del finder forCombo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoManutenzioneDto> findForCombo(java.lang.String input)
			throws SigitDTipoManutenzioneDaoException {
		LOG.debug("[SigitDTipoManutenzioneDaoImpl::findForCombo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE ");
		sql.append(" FROM SIGIT_D_TIPO_MANUTENZIONE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1260884714) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("ID_TIPO_MANUTENZIONE > 0 ");
		sql.append(" AND ID_TIPO_MANUTENZIONE < 99 ");
		sql.append(" ORDER BY ID_TIPO_MANUTENZIONE ASC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1313284248) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitDTipoManutenzioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, forComboRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoManutenzioneDaoImpl::findForCombo] esecuzione query", ex);
			throw new SigitDTipoManutenzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoManutenzioneDaoImpl", "findForCombo", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoManutenzioneDaoImpl::findForCombo] END");
		}
		return list;
	}

}
