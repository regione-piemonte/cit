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

/*PROTECTED REGION ID(R-395980317) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRPfPgDelega.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - valideByIdPersonaFisica (datagen::CustomFinder)
 *   - personaFisicaByIdPersonaGiuridica (datagen::CustomFinder)
 *   - attivaByIdPersonaGiuridicaCFFisica (datagen::CustomFinder)
 *   - attivaByFilter (datagen::CustomFinder)
  * - UPDATERS:
 *   - cessaDelega (datagen::UpdateColumns)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRPfPgDelegaDaoImpl extends AbstractDAO implements SigitRPfPgDelegaDao {
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
	 * Metodo di inserimento del DAO sigitRPfPgDelega. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRPfPgDelegaPk
	 * @generated
	 */

	public SigitRPfPgDelegaPk insert(SigitRPfPgDelegaDto dto)

	{
		LOG.debug("[SigitRPfPgDelegaDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA_FISICA,ID_PERSONA_GIURIDICA,DATA_INIZIO,FK_RUOLO_ACCRED,FK_TIPO_DM,FLG_DELEGA,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD ) VALUES (  :ID_PERSONA_FISICA , :ID_PERSONA_GIURIDICA , :DATA_INIZIO , :FK_RUOLO_ACCRED , :FK_TIPO_DM , :FLG_DELEGA , :DATA_FINE , :DATA_ULT_MOD , :UTENTE_ULT_MOD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", dto.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", dto.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_RUOLO_ACCRED]
		params.addValue("FK_RUOLO_ACCRED", dto.getFkRuoloAccred(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_DM]
		params.addValue("FK_TIPO_DM", dto.getFkTipoDm(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_DELEGA]
		params.addValue("FLG_DELEGA", dto.getFlgDelega(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitRPfPgDelegaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the SIGIT_R_PF_PG_DELEGA table.
	 * @generated
	 */
	public void updateColumnsCessaDelega(SigitRPfPgDelegaDto dto) throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::updateColumnsCessaDelega] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DATA_FINE = :DATA_FINE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD  WHERE ID_PERSONA_FISICA = :ID_PERSONA_FISICA  AND ID_PERSONA_GIURIDICA = :ID_PERSONA_GIURIDICA  AND DATA_INIZIO = :DATA_INIZIO ";

		if (dto.getIdPersonaFisica() == null || dto.getIdPersonaGiuridica() == null || dto.getDataInizio() == null) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::updateColumnsCessaDelega] ERROR chiave primaria non impostata");
			throw new SigitRPfPgDelegaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", dto.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", dto.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRPfPgDelegaDaoImpl::updateColumnsCessaDelega] END");
	}

	protected SigitRPfPgDelegaDaoRowMapper findByPrimaryKeyRowMapper = new SigitRPfPgDelegaDaoRowMapper(null,
			SigitRPfPgDelegaDto.class, this);

	protected SigitRPfPgDelegaDaoRowMapper findAllRowMapper = new SigitRPfPgDelegaDaoRowMapper(null,
			SigitRPfPgDelegaDto.class, this);

	protected SigitRPfPgDelegaDaoRowMapper valideByIdPersonaFisicaRowMapper = new SigitRPfPgDelegaDaoRowMapper(null,
			SigitRPfPgDelegaDto.class, this);

	protected SigitRPfPgDelegaDaoRowMapper personaFisicaByIdPersonaGiuridicaRowMapper = new SigitRPfPgDelegaDaoRowMapper(
			null, SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto.class, this);

	protected SigitRPfPgDelegaDaoRowMapper attivaByIdPersonaGiuridicaCFFisicaRowMapper = new SigitRPfPgDelegaDaoRowMapper(
			null, SigitRPfPgDelegaDto.class, this);

	protected SigitRPfPgDelegaDaoRowMapper attivaByFilterRowMapper = new SigitRPfPgDelegaDaoRowMapper(null,
			SigitRPfPgDelegaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_PF_PG_DELEGA";
	}

	/** 
	 * Returns all rows from the SIGIT_R_PF_PG_DELEGA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRPfPgDelegaDto findByPrimaryKey(SigitRPfPgDelegaPk pk) throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_FISICA,ID_PERSONA_GIURIDICA,DATA_INIZIO,FK_RUOLO_ACCRED,FK_TIPO_DM,FLG_DELEGA,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD FROM "
						+ getTableName()
						+ " WHERE ID_PERSONA_FISICA = :ID_PERSONA_FISICA  AND ID_PERSONA_GIURIDICA = :ID_PERSONA_GIURIDICA  AND DATA_INIZIO = :DATA_INIZIO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", pk.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", pk.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", pk.getDataInizio(), java.sql.Types.DATE);

		List<SigitRPfPgDelegaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_R_PF_PG_DELEGA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfPgDelegaDto> findAll() throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_FISICA,ID_PERSONA_GIURIDICA,DATA_INIZIO,FK_RUOLO_ACCRED,FK_TIPO_DM,FLG_DELEGA,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitRPfPgDelegaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder valideByIdPersonaFisica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfPgDelegaDto> findValideByIdPersonaFisica(java.lang.Integer input)
			throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findValideByIdPersonaFisica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_FISICA,ID_PERSONA_GIURIDICA,DATA_INIZIO,FK_RUOLO_ACCRED,FK_TIPO_DM,FLG_DELEGA,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD ");
		sql.append(" FROM SIGIT_R_PF_PG_DELEGA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1158467769) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" ID_PERSONA_FISICA = :idPersFis");
		sql.append(" AND DATA_FINE IS NULL");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1861641047) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idPersFis", input);

		/*PROTECTED REGION END*/
		List<SigitRPfPgDelegaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, valideByIdPersonaFisicaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findValideByIdPersonaFisica] esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findValideByIdPersonaFisica", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findValideByIdPersonaFisica] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder personaFisicaByIdPersonaGiuridica con Qdef
		 * @generated
		 */

	public List<SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto> findPersonaFisicaByIdPersonaGiuridica(
			java.lang.Integer input) throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findPersonaFisicaByIdPersonaGiuridica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT d.ID_PERSONA_FISICA, d.ID_PERSONA_GIURIDICA, pf.COGNOME, pf.NOME, pf.CODICE_FISCALE, d.DATA_INIZIO, d.DATA_FINE, d.FLG_DELEGA");

		sql.append(" FROM SIGIT_R_PF_PG_DELEGA d, SIGIT_T_PERSONA_FISICA pf");

		sql.append(" WHERE ");

		sql.append("d.ID_PERSONA_FISICA = pf.ID_PERSONA_FISICA");

		sql.append(" AND ");

		sql.append("1=1");
		/*PROTECTED REGION ID(R206215045) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND ID_PERSONA_GIURIDICA = :idPersGiu");

		sql.append(" ORDER BY FLG_DELEGA");

		paramMap.addValue("idPersGiu", input);

		/*PROTECTED REGION END*/

		List<SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, personaFisicaByIdPersonaGiuridicaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findPersonaFisicaByIdPersonaGiuridica] ERROR esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findPersonaFisicaByIdPersonaGiuridica",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findPersonaFisicaByIdPersonaGiuridica] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attivaByIdPersonaGiuridicaCFFisica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfPgDelegaDto> findAttivaByIdPersonaGiuridicaCFFisica(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.DelegaFilter input)
			throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findAttivaByIdPersonaGiuridicaCFFisica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R966469469) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT del.ID_PERSONA_FISICA,del.ID_PERSONA_GIURIDICA,del.FK_RUOLO_ACCRED,del.FK_TIPO_DM,del.FLG_DELEGA,del.DATA_INIZIO,del.DATA_FINE,del.DATA_ULT_MOD,del.UTENTE_ULT_MOD ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R419228975) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_R_PF_PG_DELEGA del, SIGIT_T_PERSONA_FISICA pf ");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-106167893) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" del.id_persona_fisica = pf.id_persona_fisica");
		sql.append(" AND del.ID_PERSONA_GIURIDICA = :idPersGiu");
		sql.append(" AND pf.CODICE_FISCALE = :cfPersFis");
		sql.append(" AND del.DATA_FINE IS NULL");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1884326391) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idPersGiu", input.getIdPersonaGiuridica());
		paramMap.addValue("cfPersFis", input.getCfPersonaFisica());

		/*PROTECTED REGION END*/
		List<SigitRPfPgDelegaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attivaByIdPersonaGiuridicaCFFisicaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findAttivaByIdPersonaGiuridicaCFFisica] esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findAttivaByIdPersonaGiuridicaCFFisica",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findAttivaByIdPersonaGiuridicaCFFisica] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attivaByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfPgDelegaDto> findAttivaByFilter(SigitRPfPgDelegaDto input) throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findAttivaByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_FISICA,ID_PERSONA_GIURIDICA,DATA_INIZIO,FK_RUOLO_ACCRED,FK_TIPO_DM,FLG_DELEGA,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD ");
		sql.append(" FROM SIGIT_R_PF_PG_DELEGA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-305752179) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" DATA_FINE IS NULL");

		if (GenericUtil.isNotNullOrEmpty(input.getIdPersonaGiuridica())) {
			sql.append(" AND ID_PERSONA_GIURIDICA = :idPersGiu");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdPersonaFisica())) {
			sql.append(" AND ID_PERSONA_FISICA = :idPersFis");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgDelega())) {
			sql.append(" AND FLG_DELEGA = :flgDelega");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFkRuoloAccred())) {
			sql.append(" AND FK_RUOLO_ACCRED = :fkRuoloAccred");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFkTipoDm())) {
			sql.append(" AND FK_TIPO_DM = :fkTipoDm");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-7819179) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (GenericUtil.isNotNullOrEmpty(input.getIdPersonaGiuridica())) {
			paramMap.addValue("idPersGiu", input.getIdPersonaGiuridica());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdPersonaFisica())) {
			paramMap.addValue("idPersFis", input.getIdPersonaFisica());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgDelega())) {
			paramMap.addValue("flgDelega", input.getFlgDelega());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFkRuoloAccred())) {
			paramMap.addValue("fkRuoloAccred", input.getFkRuoloAccred());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFkTipoDm())) {
			paramMap.addValue("fkTipoDm", input.getFkTipoDm());
		}

		/*PROTECTED REGION END*/
		List<SigitRPfPgDelegaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attivaByFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findAttivaByFilter] esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findAttivaByFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findAttivaByFilter] END");
		}
		return list;
	}

}
