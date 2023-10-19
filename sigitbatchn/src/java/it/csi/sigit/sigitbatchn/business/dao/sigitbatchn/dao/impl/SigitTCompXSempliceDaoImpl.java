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

/*PROTECTED REGION ID(R-1974200273) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompXSemplice.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTCompXSempliceDaoImpl extends AbstractDAO implements SigitTCompXSempliceDao {
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

	protected SigitTCompXSempliceDaoRowMapper findByPrimaryKeyRowMapper = new SigitTCompXSempliceDaoRowMapper(null,
			SigitTCompXSempliceDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMPX_SEMPLICE";
	}

	/** 
	 * Returns all rows from the SIGIT_T_COMPX_SEMPLICE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompXSempliceDto findByPrimaryKey(SigitTCompXSemplicePk pk) throws SigitTCompXSempliceDaoException {
		LOG.debug("[SigitTCompXSempliceDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT CODICE_IMPIANTO,L5_1_FLG_SR_ONOFF,L5_1_FLG_SR_GENERATORE,L5_1_FLG_SR_INDIPENDENTE,L5_1_FLG_VALVOLE_REGOLAZIONE,L5_1_FLG_SR_MULTIGRADINO,L5_1_FLG_SR_INVERTER,L5_1_FLG_SR_ALTRI,L5_1_SR_DESCRIZIONE,L5_2_FLG_TERMO_ONOFF,L5_2_FLG_TERMO_PROPORZIONALE,L5_2_FLG_CONTR_ENTALPICO,L5_2_FLG_CONTR_PORTATA,L5_2_FLG_VALVOLE_TERMO,L5_2_FLG_VALVOLE_2,L5_2_FLG_VALVOLE_3,L5_2_NOTE,L5_3_FLG_TELELETTURA,L5_3_FLG_TELEGESTIONE,L5_3_DES_SISTEMA_INSTALLAZ,L5_3_DATA_SOSTITUZ,L5_3_DES_SISTEMA_SOSTITUZ,L5_4_FLG_UIC,L5_4_FLG_RISC,L5_4_FLG_RAFF,L5_4_FLG_ACS,L5_4_FLG_TIPOLOGIA,L5_4_DES_SISTEMA_INSTALLAZ,L5_4_DATA_SOSTITUZ,L5_4_DES_SISTEMA_SOSTITUZ,L6_1_FLG_VERTICALE,L6_1_FLG_ORIZZONTALE,L6_1_FLG_CAN,L6_1_ALTRO,L6_2_FLG_COIBENT,L6_2_NOTE,L7_0_FLG_RADIATORI,L7_0_FLG_TERMOCONVETTORI,L7_0_FLG_VENTILCONVETTORI,L7_0_FLG_PANNELLI,L7_0_FLG_BOCCHETTE,L7_0_FLG_STRISCE,L7_0_FLG_TRAVI,L7_0_ALTRO,DATA_ULT_MOD,UTENTE_ULT_MOD FROM "
						+ getTableName() + " WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		List<SigitTCompXSempliceDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompXSempliceDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTCompXSempliceDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompXSempliceDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompXSempliceDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
