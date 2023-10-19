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

/*PROTECTED REGION ID(R-1760137239) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTTrattH2O.
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
public class SigitTTrattH2ODaoImpl extends AbstractDAO implements SigitTTrattH2ODao {
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

	protected SigitTTrattH2ODaoRowMapper findByPrimaryKeyRowMapper = new SigitTTrattH2ODaoRowMapper(null,
			SigitTTrattH2ODto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_TRATT_H2O";
	}

	/** 
	 * Returns all rows from the SIGIT_T_TRATT_H2O table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTTrattH2ODto findByPrimaryKey(SigitTTrattH2OPk pk) throws SigitTTrattH2ODaoException {
		LOG.debug("[SigitTTrattH2ODaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT CODICE_IMPIANTO,L2_1_H2O_CLIMA_M3,L2_2_DUREZZA_H2O_FR,L2_3_FLG_TRATT_RISC_NON_RICH,L2_3_FLG_TRATT_CLIMA_ASSENTE,L2_3_DUREZZA_TOT_H2O_FR,L2_3_FLG_TRATT_CLIMA_FILTR,L2_3_FLG_TRATT_CLIMA_ADDOLC,L2_3_FLG_TRATT_CLIMA_CHIMICO,L2_3_FLG_TRATT_GELO_ASSENTE,L2_3_FLG_TRATT_GELO_GLI_ETIL,L2_3_PERC_GLI_ETIL,L2_3_PH_GLI_ETIL,L2_3_FLG_TRATT_GELO_GLI_PROP,L2_3_PERC_GLI_PROP,L2_3_PH_GLI_PROP,L2_4_FLG_TRATT_ACS_NON_RICH,L2_4_FLG_TRATT_ACS_ASSENTE,L2_4_FLG_TRATT_ACS_FILTR,L2_4_FLG_TRATT_ACS_ADDOLC,L2_4_DUREZZA_ADDOLC_FR,L2_4_FLG_TRATT_ACS_CHIMICO,L2_5_FLG_TRATT_RAFF_ASSENTE,L2_5_FLG_TRATT_RAFF_NO_RT,L2_5_FLG_TRATT_RAFF_RTP,L2_5_FLG_TRATT_RAFF_RTT,L2_5_FLG_TRATT_RAFF_ACQ,L2_5_FLG_TRATT_RAFF_PZZ,L2_5_FLG_TRATT_RAFF_H2O_SUP,L2_5_FLG_TRATT_F_FILT_SIC,L2_5_FLG_TRATT_F_FILT_MAS,L2_5_FLG_TRATT_F_NO_TRATT,L2_5_TRATT_F_ALTRO,L2_5_FLG_TRATT_T_ADDOLC,L2_5_FLG_TRATT_T_OSMOSI,L2_5_FLG_TRATT_T_DEMIN,L2_5_FLG_TRATT_T_NO_TRATT,L2_5_TRATT_T_ALTRO,L2_5_FLG_TRATT_C_PAANTINCRO,L2_5_FLG_TRATT_C_PAANTICORR,L2_5_FLG_TRATT_C_AAA,L2_5_FLG_TRATT_C_BIOCIDA,L2_5_FLG_TRATT_C_NO_TRATT,L2_5_TRATT_C_ALTRO,L2_5_FLG_SPURGO_AUTOM,L2_5_CONDUC_H2O_ING,L2_5_TARATURA FROM "
						+ getTableName() + " WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		List<SigitTTrattH2ODto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTTrattH2ODaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTTrattH2ODaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTTrattH2ODaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTTrattH2ODaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
