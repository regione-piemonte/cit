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

/*PROTECTED REGION ID(R-2116666065) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTImpianto.
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
public class SigitTImpiantoDaoImpl extends AbstractDAO implements SigitTImpiantoDao {
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

	protected SigitTImpiantoDaoRowMapper findByPrimaryKeyRowMapper = new SigitTImpiantoDaoRowMapper(null,
			SigitTImpiantoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_IMPIANTO";
	}

	/** 
	 * Returns all rows from the SIGIT_T_IMPIANTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTImpiantoDto findByPrimaryKey(SigitTImpiantoPk pk) throws SigitTImpiantoDaoException {
		LOG.debug("[SigitTImpiantoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT CODICE_IMPIANTO,ISTAT_COMUNE,FK_STATO,DATA_ASSEGNAZIONE,DATA_DISMISSIONE,DENOMINAZIONE_COMUNE,SIGLA_PROVINCIA,DENOMINAZIONE_PROVINCIA,L1_3_POT_H2O_KW,L1_3_POT_CLIMA_INV_KW,L1_3_POT_CLIMA_EST_KW,L1_3_ALTRO,L1_4_FLG_H2O,L1_4_FLG_ARIA,L1_4_ALTRO,L1_5_FLG_GENERATORE,L1_5_FLG_POMPA,L1_5_FLG_FRIGO,L1_5_FLG_TELERISC,L1_5_FLG_TELERAFFR,L1_5_FLG_COGENERATORE,L1_5_ALTRO,L1_5_SUP_PANNELLI_SOL_M2,L1_5_ALTRO_INTEGRAZIONE,L1_5_ALTRO_INTEGR_POT_KW,L1_5_FLG_ALTRO_CLIMA_INV,L1_5_FLG_ALTRO_CLIMA_ESTATE,L1_5_FLG_ALTRO_ACS,L1_5_ALTRO_DESC,DATA_ULT_MOD,UTENTE_ULT_MOD,MOTIVAZIONE,PROPRIETARIO,DATA_INSERIMENTO,NOTE,FLG_TIPO_IMPIANTO,FLG_APPARECC_UI_EXT,FLG_CONTABILIZZAZIONE,DATA_INTERVENTO,FK_TIPO_INTERVENTO,L11_1_FLG_NORMA_UNI_10389_1,L11_1_ALTRA_NORMA,FLG_BLOCCO_NOMINA_3R,FLG_VISU_PROPRIETARIO,FLG_NO_OPENDATA,COORD_X_LONG_DD,COORD_Y_LAT_DD FROM "
						+ getTableName() + " WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		List<SigitTImpiantoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTImpiantoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImpiantoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTImpiantoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
