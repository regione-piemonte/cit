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

/*PROTECTED REGION ID(R1096025391) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTRifCatast.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 
 *    --
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 *   - byIdImportDistrib (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTRifCatastDaoImpl extends AbstractDAO implements SigitTRifCatastDao {
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
	 * Custom deleter in the SIGIT_T_RIF_CATAST table.
	 * @generated
	 */
	public void customDeleterByIdImportDistrib(java.lang.Integer filter) throws SigitTRifCatastDaoException {
		LOG.debug("[SigitTRifCatastDaoImpl::customDeleterByIdImportDistrib] START");
		/*PROTECTED REGION ID(R733348189) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " rc WHERE "
				+ "EXISTS (SELECT 1 FROM SIGIT_T_DATO_DISTRIB dd where rc.FK_DATO_DISTRIB = dd.ID_DATO_DISTRIB AND dd.FK_IMPORT_DISTRIB = :idImportDistrib)";

		/*
		DELETE FROM SIGIT_T_RIF_CATAST rc WHERE
		EXISTS (SELECT 1 FROM SIGIT_T_DATO_DISTRIB dd where rc.FK_DATO_DISTRIB = dd.ID_DATO_DISTRIB AND dd.FK_IMPORT_DISTRIB = 6)
		 */

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idImportDistrib", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTRifCatastDaoImpl::customDeleterByIdImportDistrib] END");
	}

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_RIF_CATAST";
	}

}
