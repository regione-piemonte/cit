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

/*PROTECTED REGION ID(R-1783097855) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRImpRuoloPfpg.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byPersonaGiuridicaCodImpianto (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - responsabileAttivoByCodImpianto (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRImpRuoloPfpgDaoImpl extends AbstractDAO implements SigitRImpRuoloPfpgDao {
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

	protected SigitRImpRuoloPfpgDaoRowMapper byPersonaGiuridicaCodImpiantoRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(
			null, SigitRImpRuoloPfpgDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper findByPrimaryKeyRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(null,
			SigitRImpRuoloPfpgDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper responsabileAttivoByCodImpiantoRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(
			null, SigitRImpRuoloPfpgDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_IMP_RUOLO_PFPG";
	}

	/** 
	 * Implementazione del finder byPersonaGiuridicaCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findByPersonaGiuridicaCodImpianto(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitRImpRuoloPfpgDto input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByPersonaGiuridicaCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-957183473) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("  DATA_FINE IS NULL");
		if (input.getFkPersonaGiuridica() != null)
			sql.append(" AND FK_PERSONA_GIURIDICA = :idPersonaGiuridica");
		if (input.getCodiceImpianto() != null)
			sql.append(" AND CODICE_IMPIANTO = :codiceImpianto");
		if (input.getFkRuolo() != null)
			sql.append(" AND FK_RUOLO = :idRuolo");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R516969659) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input.getFkPersonaGiuridica() != null)
			paramMap.addValue("idPersonaGiuridica", input.getFkPersonaGiuridica());
		if (input.getCodiceImpianto() != null)
			paramMap.addValue("codiceImpianto", input.getCodiceImpianto());
		if (input.getFkRuolo() != null)
			paramMap.addValue("idRuolo", input.getFkRuolo());

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byPersonaGiuridicaCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findByPersonaGiuridicaCodImpianto] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findByPersonaGiuridicaCodImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByPersonaGiuridicaCodImpianto] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_R_IMP_RUOLO_PFPG table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRImpRuoloPfpgDto findByPrimaryKey(SigitRImpRuoloPfpgPk pk) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE FROM "
						+ getTableName() + " WHERE ID_IMP_RUOLO_PFPG = :ID_IMP_RUOLO_PFPG ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_IMP_RUOLO_PFPG]
		params.addValue("ID_IMP_RUOLO_PFPG", pk.getIdImpRuoloPfpg(), java.sql.Types.NUMERIC);

		List<SigitRImpRuoloPfpgDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder responsabileAttivoByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findResponsabileAttivoByCodImpianto(java.lang.Integer input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findResponsabileAttivoByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1966987436) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("fk_ruolo in (4,5,10,11,12,13) AND data_fine is null AND codice_impianto = :cod_impianto");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R971954622) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("cod_impianto", input);

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, responsabileAttivoByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findResponsabileAttivoByCodImpianto] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findResponsabileAttivoByCodImpianto",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findResponsabileAttivoByCodImpianto] END");
		}
		return list;
	}

}
