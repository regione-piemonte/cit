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

/*PROTECTED REGION ID(R-1196959665) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTStoricoVarStatoPg.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - piuRecenteByIdPg (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTStoricoVarStatoPgDaoImpl extends AbstractDAO implements SigitTStoricoVarStatoPgDao {
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
	 * Metodo di inserimento del DAO sigitTStoricoVarStatoPg. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTStoricoVarStatoPgPk
	 * @generated
	 */

	public SigitTStoricoVarStatoPgPk insert(SigitTStoricoVarStatoPgDto dto)

	{
		LOG.debug("[SigitTStoricoVarStatoPgDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	DT_EVENTO,ID_PERSONA_GIURIDICA,DT_INIZIO_VARIAZIONE,MOTIVO,STATO_PG_DA,STATO_PG_A,DATA_ULT_MOD,UTENTE_ULT_MOD ) VALUES (  :DT_EVENTO , :ID_PERSONA_GIURIDICA , :DT_INIZIO_VARIAZIONE , :MOTIVO , :STATO_PG_DA , :STATO_PG_A , :DATA_ULT_MOD , :UTENTE_ULT_MOD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DT_EVENTO]
		params.addValue("DT_EVENTO", dto.getDtEvento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", dto.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_INIZIO_VARIAZIONE]
		params.addValue("DT_INIZIO_VARIAZIONE", dto.getDtInizioVariazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [MOTIVO]
		params.addValue("MOTIVO", dto.getMotivo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [STATO_PG_DA]
		params.addValue("STATO_PG_DA", dto.getStatoPgDa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [STATO_PG_A]
		params.addValue("STATO_PG_A", dto.getStatoPgA(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTStoricoVarStatoPgDaoImpl::insert] END");
		return dto.createPk();

	}

	protected SigitTStoricoVarStatoPgDaoRowMapper findByPrimaryKeyRowMapper = new SigitTStoricoVarStatoPgDaoRowMapper(
			null, SigitTStoricoVarStatoPgDto.class, this);

	protected SigitTStoricoVarStatoPgDaoRowMapper piuRecenteByIdPgRowMapper = new SigitTStoricoVarStatoPgDaoRowMapper(
			null, SigitTStoricoVarStatoPgDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_STORICO_VAR_STATO_PG";
	}

	/** 
	 * Returns all rows from the SIGIT_T_STORICO_VAR_STATO_PG table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTStoricoVarStatoPgDto findByPrimaryKey(SigitTStoricoVarStatoPgPk pk)
			throws SigitTStoricoVarStatoPgDaoException {
		LOG.debug("[SigitTStoricoVarStatoPgDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT DT_EVENTO,ID_PERSONA_GIURIDICA,DT_INIZIO_VARIAZIONE,MOTIVO,STATO_PG_DA,STATO_PG_A,DATA_ULT_MOD,UTENTE_ULT_MOD FROM "
						+ getTableName()
						+ " WHERE DT_EVENTO = :DT_EVENTO  AND ID_PERSONA_GIURIDICA = :ID_PERSONA_GIURIDICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DT_EVENTO]
		params.addValue("DT_EVENTO", pk.getDtEvento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", pk.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);

		List<SigitTStoricoVarStatoPgDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTStoricoVarStatoPgDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTStoricoVarStatoPgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTStoricoVarStatoPgDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTStoricoVarStatoPgDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder piuRecenteByIdPg
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTStoricoVarStatoPgDto> findPiuRecenteByIdPg(java.lang.Integer input)
			throws SigitTStoricoVarStatoPgDaoException {
		LOG.debug("[SigitTStoricoVarStatoPgDaoImpl::findPiuRecenteByIdPg] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT DT_EVENTO,ID_PERSONA_GIURIDICA,DT_INIZIO_VARIAZIONE,MOTIVO,STATO_PG_DA,STATO_PG_A,DATA_ULT_MOD,UTENTE_ULT_MOD ");
		sql.append(" FROM SIGIT_T_STORICO_VAR_STATO_PG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-183693137) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" ID_PERSONA_GIURIDICA = :idPg");
		sql.append(" ORDER BY DT_INIZIO_VARIAZIONE DESC");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-518956173) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idPg", input);

		/*PROTECTED REGION END*/
		List<SigitTStoricoVarStatoPgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, piuRecenteByIdPgRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTStoricoVarStatoPgDaoImpl::findPiuRecenteByIdPg] esecuzione query", ex);
			throw new SigitTStoricoVarStatoPgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTStoricoVarStatoPgDaoImpl", "findPiuRecenteByIdPg", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTStoricoVarStatoPgDaoImpl::findPiuRecenteByIdPg] END");
		}
		return list;
	}

}
