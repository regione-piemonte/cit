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

/*PROTECTED REGION ID(R-1838474339) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRPgPgNomina.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - personaGiuridicaCatByIdPersonaGiuridica (datagen::CustomFinder)
 *   - attivaByIdPersonaGiuridicaImpGiuridicaCat (datagen::CustomFinder)
 *   - attivaByIdPersonaGiuridicaCat (datagen::CustomFinder)
  * - UPDATERS:
 *   - cessaIncarico (datagen::UpdateColumns)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRPgPgNominaDaoImpl extends AbstractDAO implements SigitRPgPgNominaDao {
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
	 * Metodo di inserimento del DAO sigitRPgPgNomina. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRPgPgNominaPk
	 * @generated
	 */

	public SigitRPgPgNominaPk insert(SigitRPgPgNominaDto dto)

	{
		LOG.debug("[SigitRPgPgNominaDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA_GIURIDICA_CAT,ID_PERSONA_GIURIDICA_IMPRESA,DATA_INIZIO,DATA_FINE,DATA_ULTIMA_MODIFICA,UTENTE_ULTIMA_MODIFICA ) VALUES (  :ID_PERSONA_GIURIDICA_CAT , :ID_PERSONA_GIURIDICA_IMPRESA , :DATA_INIZIO , :DATA_FINE , :DATA_ULTIMA_MODIFICA , :UTENTE_ULTIMA_MODIFICA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA_CAT]
		params.addValue("ID_PERSONA_GIURIDICA_CAT", dto.getIdPersonaGiuridicaCat(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA_IMPRESA]
		params.addValue("ID_PERSONA_GIURIDICA_IMPRESA", dto.getIdPersonaGiuridicaImpresa(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_ULTIMA_MODIFICA]
		params.addValue("DATA_ULTIMA_MODIFICA", dto.getDataUltimaModifica(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [UTENTE_ULTIMA_MODIFICA]
		params.addValue("UTENTE_ULTIMA_MODIFICA", dto.getUtenteUltimaModifica(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitRPgPgNominaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the SIGIT_R_PG_PG_NOMINA table.
	 * @generated
	 */
	public void updateColumnsCessaIncarico(SigitRPgPgNominaDto dto) throws SigitRPgPgNominaDaoException {
		LOG.debug("[SigitRPgPgNominaDaoImpl::updateColumnsCessaIncarico] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DATA_FINE = :DATA_FINE ,DATA_ULTIMA_MODIFICA = :DATA_ULTIMA_MODIFICA ,UTENTE_ULTIMA_MODIFICA = :UTENTE_ULTIMA_MODIFICA  WHERE ID_PERSONA_GIURIDICA_CAT = :ID_PERSONA_GIURIDICA_CAT  AND ID_PERSONA_GIURIDICA_IMPRESA = :ID_PERSONA_GIURIDICA_IMPRESA  AND DATA_INIZIO = :DATA_INIZIO ";

		if (dto.getIdPersonaGiuridicaCat() == null || dto.getIdPersonaGiuridicaImpresa() == null
				|| dto.getDataInizio() == null) {
			LOG.error("[SigitRPgPgNominaDaoImpl::updateColumnsCessaIncarico] ERROR chiave primaria non impostata");
			throw new SigitRPgPgNominaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_ULTIMA_MODIFICA]
		params.addValue("DATA_ULTIMA_MODIFICA", dto.getDataUltimaModifica(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [UTENTE_ULTIMA_MODIFICA]
		params.addValue("UTENTE_ULTIMA_MODIFICA", dto.getUtenteUltimaModifica(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA_CAT]
		params.addValue("ID_PERSONA_GIURIDICA_CAT", dto.getIdPersonaGiuridicaCat(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA_IMPRESA]
		params.addValue("ID_PERSONA_GIURIDICA_IMPRESA", dto.getIdPersonaGiuridicaImpresa(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRPgPgNominaDaoImpl::updateColumnsCessaIncarico] END");
	}

	protected SigitRPgPgNominaDaoRowMapper findByPrimaryKeyRowMapper = new SigitRPgPgNominaDaoRowMapper(null,
			SigitRPgPgNominaDto.class, this);

	protected SigitRPgPgNominaDaoRowMapper personaGiuridicaCatByIdPersonaGiuridicaRowMapper = new SigitRPgPgNominaDaoRowMapper(
			null, SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto.class, this);

	protected SigitRPgPgNominaDaoRowMapper attivaByIdPersonaGiuridicaImpGiuridicaCatRowMapper = new SigitRPgPgNominaDaoRowMapper(
			null, SigitRPgPgNominaDto.class, this);

	protected SigitRPgPgNominaDaoRowMapper attivaByIdPersonaGiuridicaCatRowMapper = new SigitRPgPgNominaDaoRowMapper(
			null, SigitRPgPgNominaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_PG_PG_NOMINA";
	}

	/** 
	 * Returns all rows from the SIGIT_R_PG_PG_NOMINA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRPgPgNominaDto findByPrimaryKey(SigitRPgPgNominaPk pk) throws SigitRPgPgNominaDaoException {
		LOG.debug("[SigitRPgPgNominaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_GIURIDICA_CAT,ID_PERSONA_GIURIDICA_IMPRESA,DATA_INIZIO,DATA_FINE,DATA_ULTIMA_MODIFICA,UTENTE_ULTIMA_MODIFICA FROM "
						+ getTableName()
						+ " WHERE ID_PERSONA_GIURIDICA_CAT = :ID_PERSONA_GIURIDICA_CAT  AND ID_PERSONA_GIURIDICA_IMPRESA = :ID_PERSONA_GIURIDICA_IMPRESA  AND DATA_INIZIO = :DATA_INIZIO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA_CAT]
		params.addValue("ID_PERSONA_GIURIDICA_CAT", pk.getIdPersonaGiuridicaCat(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA_IMPRESA]
		params.addValue("ID_PERSONA_GIURIDICA_IMPRESA", pk.getIdPersonaGiuridicaImpresa(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", pk.getDataInizio(), java.sql.Types.DATE);

		List<SigitRPgPgNominaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPgPgNominaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitRPgPgNominaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPgPgNominaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPgPgNominaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
		 * Implementazione del finder personaGiuridicaCatByIdPersonaGiuridica con Qdef
		 * @generated
		 */

	public List<SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto> findPersonaGiuridicaCatByIdPersonaGiuridica(
			java.lang.Integer input) throws SigitRPgPgNominaDaoException {
		LOG.debug("[SigitRPgPgNominaDaoImpl::findPersonaGiuridicaCatByIdPersonaGiuridica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT d.ID_PERSONA_GIURIDICA_CAT, d.ID_PERSONA_GIURIDICA_IMPRESA, pg.DENOMINAZIONE, pg.CODICE_FISCALE, d.DATA_INIZIO, d.DATA_FINE");

		sql.append(" FROM SIGIT_R_PG_PG_NOMINA d, SIGIT_T_PERSONA_GIURIDICA pg");

		sql.append(" WHERE ");

		sql.append("d.ID_PERSONA_GIURIDICA_CAT = pg.ID_PERSONA_GIURIDICA");

		sql.append(" AND ");

		sql.append("d.id_persona_giuridica_impresa = :idPersGiuImp");
		/*PROTECTED REGION ID(R1584017908) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPersGiuImp", input);

		/*PROTECTED REGION END*/

		List<SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, personaGiuridicaCatByIdPersonaGiuridicaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPgPgNominaDaoImpl::findPersonaGiuridicaCatByIdPersonaGiuridica] ERROR esecuzione query",
					ex);
			throw new SigitRPgPgNominaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPgPgNominaDaoImpl", "findPersonaGiuridicaCatByIdPersonaGiuridica",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitRPgPgNominaDaoImpl::findPersonaGiuridicaCatByIdPersonaGiuridica] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attivaByIdPersonaGiuridicaImpGiuridicaCat
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPgPgNominaDto> findAttivaByIdPersonaGiuridicaImpGiuridicaCat(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPgPgNominaDto input)
			throws SigitRPgPgNominaDaoException {
		LOG.debug("[SigitRPgPgNominaDaoImpl::findAttivaByIdPersonaGiuridicaImpGiuridicaCat] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_GIURIDICA_CAT,ID_PERSONA_GIURIDICA_IMPRESA,DATA_INIZIO,DATA_FINE,DATA_ULTIMA_MODIFICA,UTENTE_ULTIMA_MODIFICA ");
		sql.append(" FROM SIGIT_R_PG_PG_NOMINA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1685956701) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" ID_PERSONA_GIURIDICA_CAT = :idPersGiuCat");
		sql.append(" AND ID_PERSONA_GIURIDICA_IMPRESA = :idPersGiuImp");
		sql.append(" AND DATA_FINE IS NULL");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R155513599) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idPersGiuCat", input.getIdPersonaGiuridicaCat());
		paramMap.addValue("idPersGiuImp", input.getIdPersonaGiuridicaImpresa());

		/*PROTECTED REGION END*/
		List<SigitRPgPgNominaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attivaByIdPersonaGiuridicaImpGiuridicaCatRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRPgPgNominaDaoImpl::findAttivaByIdPersonaGiuridicaImpGiuridicaCat] esecuzione query", ex);
			throw new SigitRPgPgNominaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPgPgNominaDaoImpl", "findAttivaByIdPersonaGiuridicaImpGiuridicaCat",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitRPgPgNominaDaoImpl::findAttivaByIdPersonaGiuridicaImpGiuridicaCat] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attivaByIdPersonaGiuridicaCat
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPgPgNominaDto> findAttivaByIdPersonaGiuridicaCat(java.lang.Integer input)
			throws SigitRPgPgNominaDaoException {
		LOG.debug("[SigitRPgPgNominaDaoImpl::findAttivaByIdPersonaGiuridicaCat] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_GIURIDICA_CAT,ID_PERSONA_GIURIDICA_IMPRESA,DATA_INIZIO,DATA_FINE,DATA_ULTIMA_MODIFICA,UTENTE_ULTIMA_MODIFICA ");
		sql.append(" FROM SIGIT_R_PG_PG_NOMINA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R434650916) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" ID_PERSONA_GIURIDICA_CAT = :idPersGiuCat");
		sql.append(" AND DATA_FINE IS NULL");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1469840286) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idPersGiuCat", input);

		/*PROTECTED REGION END*/
		List<SigitRPgPgNominaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attivaByIdPersonaGiuridicaCatRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRPgPgNominaDaoImpl::findAttivaByIdPersonaGiuridicaCat] esecuzione query", ex);
			throw new SigitRPgPgNominaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPgPgNominaDaoImpl", "findAttivaByIdPersonaGiuridicaCat", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRPgPgNominaDaoImpl::findAttivaByIdPersonaGiuridicaCat] END");
		}
		return list;
	}

}
