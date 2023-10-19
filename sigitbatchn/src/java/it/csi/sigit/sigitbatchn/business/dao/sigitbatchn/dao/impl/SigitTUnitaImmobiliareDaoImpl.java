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

/*PROTECTED REGION ID(R-10435969) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTUnitaImmobiliare.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byCodiceImpianto (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTUnitaImmobiliareDaoImpl extends AbstractDAO implements SigitTUnitaImmobiliareDao {
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

	protected SigitTUnitaImmobiliareDaoRowMapper findByPrimaryKeyRowMapper = new SigitTUnitaImmobiliareDaoRowMapper(
			null, SigitTUnitaImmobiliareDto.class, this);

	protected SigitTUnitaImmobiliareDaoRowMapper byCodiceImpiantoRowMapper = new SigitTUnitaImmobiliareDaoRowMapper(
			null, SigitTUnitaImmobiliareDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_UNITA_IMMOBILIARE";
	}

	/** 
	 * Returns all rows from the SIGIT_T_UNITA_IMMOBILIARE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTUnitaImmobiliareDto findByPrimaryKey(SigitTUnitaImmobiliarePk pk)
			throws SigitTUnitaImmobiliareDaoException {
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_UNITA_IMM,CODICE_IMPIANTO,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,CIVICO,CAP,SCALA,PALAZZO,INTERNO,NOTE,FLG_PRINCIPALE,SEZIONE,FOGLIO,PARTICELLA,SUBALTERNO,POD_ELETTRICO,PDR_GAS,DATA_ULT_MOD,UTENTE_ULT_MOD,L1_2_FLG_SINGOLA_UNITA,L1_2_FK_CATEGORIA,L1_2_VOL_RISC_M3,L1_2_VOL_RAFF_M3,FLG_NOPDR,FLG_NOACCATASTATO FROM "
						+ getTableName() + " WHERE ID_UNITA_IMM = :ID_UNITA_IMM ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_IMM]
		params.addValue("ID_UNITA_IMM", pk.getIdUnitaImm(), java.sql.Types.NUMERIC);

		List<SigitTUnitaImmobiliareDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTUnitaImmobiliareDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTUnitaImmobiliareDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTUnitaImmobiliareDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUnitaImmobiliareDto> findByCodiceImpianto(java.lang.Integer input)
			throws SigitTUnitaImmobiliareDaoException {
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_UNITA_IMM,CODICE_IMPIANTO,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,CIVICO,CAP,SCALA,PALAZZO,INTERNO,NOTE,FLG_PRINCIPALE,SEZIONE,FOGLIO,PARTICELLA,SUBALTERNO,POD_ELETTRICO,PDR_GAS,DATA_ULT_MOD,UTENTE_ULT_MOD,L1_2_FLG_SINGOLA_UNITA,L1_2_FK_CATEGORIA,L1_2_VOL_RISC_M3,L1_2_VOL_RAFF_M3,FLG_NOPDR,FLG_NOACCATASTATO ");
		sql.append(" FROM SIGIT_T_UNITA_IMMOBILIARE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-744734130) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" CODICE_IMPIANTO = :codiceImpianto");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1487035300) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codiceImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitTUnitaImmobiliareDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTUnitaImmobiliareDaoImpl::findByCodiceImpianto] esecuzione query", ex);
			throw new SigitTUnitaImmobiliareDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTUnitaImmobiliareDaoImpl", "findByCodiceImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findByCodiceImpianto] END");
		}
		return list;
	}

}
