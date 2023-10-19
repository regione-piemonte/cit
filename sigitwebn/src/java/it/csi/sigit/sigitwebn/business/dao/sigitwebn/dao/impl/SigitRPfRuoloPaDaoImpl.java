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

/*PROTECTED REGION ID(R-1726662833) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRPfRuoloPa.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - ByExample (datagen::CustomFinder)
 *   - allActive (datagen::CustomFinder)
 *   - allActiveDistinctIstatAbilitazioni (datagen::CustomFinder)
 *   - allByIstatValidatore (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - cessaAbilitazione (datagen::UpdateColumns)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRPfRuoloPaDaoImpl extends AbstractDAO implements SigitRPfRuoloPaDao {
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
	 * Metodo di inserimento del DAO sigitRPfRuoloPa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRPfRuoloPaPk
	 * @generated
	 */

	public SigitRPfRuoloPaPk insert(SigitRPfRuoloPaDto dto)

	{
		LOG.debug("[SigitRPfRuoloPaDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA_FISICA,ID_RUOLO_PA,ISTAT_ABILITAZIONE,DATA_INIZIO,DATA_FINE,NOTE,DESC_ABILITAZIONE ) VALUES (  :ID_PERSONA_FISICA , :ID_RUOLO_PA , :ISTAT_ABILITAZIONE , :DATA_INIZIO , :DATA_FINE , :NOTE , :DESC_ABILITAZIONE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", dto.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_RUOLO_PA]
		params.addValue("ID_RUOLO_PA", dto.getIdRuoloPa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ISTAT_ABILITAZIONE]
		params.addValue("ISTAT_ABILITAZIONE", dto.getIstatAbilitazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DESC_ABILITAZIONE]
		params.addValue("DESC_ABILITAZIONE", dto.getDescAbilitazione(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitRPfRuoloPaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_R_PF_RUOLO_PA table.
	 * @generated
	 */
	public void update(SigitRPfRuoloPaDto dto) throws SigitRPfRuoloPaDaoException {
		LOG.debug("[SigitRPfRuoloPaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DATA_FINE = :DATA_FINE ,NOTE = :NOTE ,DESC_ABILITAZIONE = :DESC_ABILITAZIONE  WHERE ID_PERSONA_FISICA = :ID_PERSONA_FISICA  AND ID_RUOLO_PA = :ID_RUOLO_PA  AND ISTAT_ABILITAZIONE = :ISTAT_ABILITAZIONE  AND DATA_INIZIO = :DATA_INIZIO ";

		if (dto.getIdPersonaFisica() == null || dto.getIdRuoloPa() == null || dto.getIstatAbilitazione() == null
				|| dto.getDataInizio() == null) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitRPfRuoloPaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", dto.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_RUOLO_PA]
		params.addValue("ID_RUOLO_PA", dto.getIdRuoloPa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ISTAT_ABILITAZIONE]
		params.addValue("ISTAT_ABILITAZIONE", dto.getIstatAbilitazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DESC_ABILITAZIONE]
		params.addValue("DESC_ABILITAZIONE", dto.getDescAbilitazione(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRPfRuoloPaDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_R_PF_RUOLO_PA table.
	 * @generated
	 */
	public void updateColumnsCessaAbilitazione(SigitRPfRuoloPaDto dto) throws SigitRPfRuoloPaDaoException {
		LOG.debug("[SigitRPfRuoloPaDaoImpl::updateColumnsCessaAbilitazione] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DATA_FINE = :DATA_FINE  WHERE ID_PERSONA_FISICA = :ID_PERSONA_FISICA  AND ID_RUOLO_PA = :ID_RUOLO_PA  AND ISTAT_ABILITAZIONE = :ISTAT_ABILITAZIONE  AND DATA_INIZIO = :DATA_INIZIO ";

		if (dto.getIdPersonaFisica() == null || dto.getIdRuoloPa() == null || dto.getIstatAbilitazione() == null
				|| dto.getDataInizio() == null) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::updateColumnsCessaAbilitazione] ERROR chiave primaria non impostata");
			throw new SigitRPfRuoloPaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", dto.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_RUOLO_PA]
		params.addValue("ID_RUOLO_PA", dto.getIdRuoloPa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ISTAT_ABILITAZIONE]
		params.addValue("ISTAT_ABILITAZIONE", dto.getIstatAbilitazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRPfRuoloPaDaoImpl::updateColumnsCessaAbilitazione] END");
	}

	protected SigitRPfRuoloPaDaoRowMapper findByPrimaryKeyRowMapper = new SigitRPfRuoloPaDaoRowMapper(null,
			SigitRPfRuoloPaDto.class, this);

	protected SigitRPfRuoloPaDaoRowMapper ByExampleRowMapper = new SigitRPfRuoloPaDaoRowMapper(null,
			SigitRPfRuoloPaByExampleDto.class, this);

	protected SigitRPfRuoloPaDaoRowMapper allActiveRowMapper = new SigitRPfRuoloPaDaoRowMapper(null,
			SigitRPfRuoloPaAllActiveDto.class, this);

	protected SigitRPfRuoloPaDaoRowMapper allActiveDistinctIstatAbilitazioniRowMapper = new SigitRPfRuoloPaDaoRowMapper(
			new String[]{"ISTAT_ABILITAZIONE", "DESC_ABILITAZIONE"}, SigitRPfRuoloPaDto.class, this);

	protected SigitRPfRuoloPaDaoRowMapper allByIstatValidatoreRowMapper = new SigitRPfRuoloPaDaoRowMapper(
			new String[]{"DESC_ABILITAZIONE"}, SigitRPfRuoloPaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_PF_RUOLO_PA";
	}

	/** 
	 * Returns all rows from the SIGIT_R_PF_RUOLO_PA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRPfRuoloPaDto findByPrimaryKey(SigitRPfRuoloPaPk pk) throws SigitRPfRuoloPaDaoException {
		LOG.debug("[SigitRPfRuoloPaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_FISICA,ID_RUOLO_PA,ISTAT_ABILITAZIONE,DATA_INIZIO,DATA_FINE,NOTE,DESC_ABILITAZIONE FROM "
						+ getTableName()
						+ " WHERE ID_PERSONA_FISICA = :ID_PERSONA_FISICA  AND ID_RUOLO_PA = :ID_RUOLO_PA  AND ISTAT_ABILITAZIONE = :ISTAT_ABILITAZIONE  AND DATA_INIZIO = :DATA_INIZIO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", pk.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_RUOLO_PA]
		params.addValue("ID_RUOLO_PA", pk.getIdRuoloPa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ISTAT_ABILITAZIONE]
		params.addValue("ISTAT_ABILITAZIONE", pk.getIstatAbilitazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", pk.getDataInizio(), java.sql.Types.DATE);

		List<SigitRPfRuoloPaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitRPfRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfRuoloPaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfRuoloPaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
		 * Implementazione del finder ByExample con Qdef
		 * @generated
		 */

	public List<SigitRPfRuoloPaByExampleDto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfRuoloPaDto input)
			throws SigitRPfRuoloPaDaoException {
		LOG.debug("[SigitRPfRuoloPaDaoImpl::findByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT rpa.ID_RUOLO_PA, dr.DES_RUOLO_PA, rpa.ISTAT_ABILITAZIONE, ab.MAIL_COMUNICAZIONE, pf.ID_PERSONA_FISICA, pf.COGNOME, pf.NOME, pf.CODICE_FISCALE, rpa.DATA_INIZIO, rpa.DATA_FINE, rpa.NOTE, rpa.DESC_ABILITAZIONE");

		sql.append(
				" FROM SIGIT_R_PF_RUOLO_PA rpa, SIGIT_T_PERSONA_FISICA pf, SIGIT_T_ABILITAZIONE ab, SIGIT_D_RUOLO_PA dr");

		sql.append(" WHERE ");

		sql.append(
				"rpa.ID_PERSONA_FISICA = pf.ID_PERSONA_FISICA AND rpa.ID_RUOLO_PA = ab.ID_RUOLO_PA AND rpa.ISTAT_ABILITAZIONE = ab.ISTAT_ABILITAZIONE AND rpa.ID_RUOLO_PA = dr.ID_RUOLO_PA");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R1613006687) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		if (GenericUtil.isNotNullOrEmpty(input.getIdRuoloPa())) {
			sql.append(" AND rpa.ID_RUOLO_PA = :idRuoloPa ");
			paramMap.addValue("idRuoloPa", input.getIdRuoloPa());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdPersonaFisica())) {
			sql.append(" AND pf.ID_PERSONA_FISICA = :idPf ");
			paramMap.addValue("idPf", input.getIdPersonaFisica());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIstatAbilitazione())) {
			sql.append(" AND rpa.ISTAT_ABILITAZIONE = :istatAbil ");
			paramMap.addValue("istatAbil", input.getIstatAbilitazione());
		}

		/*PROTECTED REGION END*/

		List<SigitRPfRuoloPaByExampleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ByExampleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::findByExample] ERROR esecuzione query", ex);
			throw new SigitRPfRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfRuoloPaDaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfRuoloPaDaoImpl::findByExample] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder allActive con Qdef
		 * @generated
		 */

	public List<SigitRPfRuoloPaAllActiveDto> findAllActive(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfRuoloPaDto input)
			throws SigitRPfRuoloPaDaoException {
		LOG.debug("[SigitRPfRuoloPaDaoImpl::findAllActive] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT rpa.ID_RUOLO_PA, dr.DES_RUOLO_PA, rpa.ISTAT_ABILITAZIONE, ab.MAIL_COMUNICAZIONE, pf.ID_PERSONA_FISICA, pf.COGNOME, pf.NOME, pf.CODICE_FISCALE, rpa.DATA_INIZIO, rpa.DATA_FINE, rpa.NOTE, rpa.DESC_ABILITAZIONE");

		sql.append(
				" FROM SIGIT_R_PF_RUOLO_PA rpa, SIGIT_T_PERSONA_FISICA pf, SIGIT_T_ABILITAZIONE ab, SIGIT_D_RUOLO_PA dr");

		sql.append(" WHERE ");

		sql.append(
				"rpa.ID_PERSONA_FISICA = pf.ID_PERSONA_FISICA AND rpa.ID_RUOLO_PA = ab.ID_RUOLO_PA AND rpa.ISTAT_ABILITAZIONE = ab.ISTAT_ABILITAZIONE AND rpa.ID_RUOLO_PA = dr.ID_RUOLO_PA");

		sql.append(" AND ");

		sql.append("(rpa.DATA_FINE is null OR rpa.DATA_FINE > NOW())");
		/*PROTECTED REGION ID(R1162051443) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		if (GenericUtil.isNotNullOrEmpty(input.getIdRuoloPa())) {
			sql.append(" AND rpa.ID_RUOLO_PA = :idRuoloPa ");
			paramMap.addValue("idRuoloPa", input.getIdRuoloPa());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdPersonaFisica())) {
			sql.append(" AND pf.ID_PERSONA_FISICA = :idPf ");
			paramMap.addValue("idPf", input.getIdPersonaFisica());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIstatAbilitazione())) {
			sql.append(" AND rpa.ISTAT_ABILITAZIONE = :istatAbil ");
			paramMap.addValue("istatAbil", input.getIstatAbilitazione());
		}

		/*PROTECTED REGION END*/

		List<SigitRPfRuoloPaAllActiveDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, allActiveRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::findAllActive] ERROR esecuzione query", ex);
			throw new SigitRPfRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfRuoloPaDaoImpl", "findAllActive", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfRuoloPaDaoImpl::findAllActive] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder allActiveDistinctIstatAbilitazioni
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfRuoloPaDto> findAllActiveDistinctIstatAbilitazioni(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfRuoloPaDto input)
			throws SigitRPfRuoloPaDaoException {
		LOG.debug("[SigitRPfRuoloPaDaoImpl::findAllActiveDistinctIstatAbilitazioni] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT DISTINCT ISTAT_ABILITAZIONE,DESC_ABILITAZIONE ");
		sql.append(" FROM SIGIT_R_PF_RUOLO_PA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1184075403) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append(" DESC_ABILITAZIONE is not null ");
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		if (input != null) {
			if (input.getIstatAbilitazione() != null) {
				sql.append(" AND ISTAT_ABILITAZIONE = :istat_abilitazione");
				paramMap.addValue("istat_abilitazione", input.getIstatAbilitazione());
			}
			if (input.getDescAbilitazione() != null) {
				sql.append(" AND DESC_ABILITAZIONE = :desc_abilitazione");
				paramMap.addValue("desc_abilitazione", input.getDescAbilitazione());
			}
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1067804393) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitRPfRuoloPaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, allActiveDistinctIstatAbilitazioniRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::findAllActiveDistinctIstatAbilitazioni] esecuzione query", ex);
			throw new SigitRPfRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfRuoloPaDaoImpl", "findAllActiveDistinctIstatAbilitazioni",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitRPfRuoloPaDaoImpl::findAllActiveDistinctIstatAbilitazioni] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder allByIstatValidatore
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfRuoloPaDto> findAllByIstatValidatore(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfRuoloPaDto input)
			throws SigitRPfRuoloPaDaoException {
		LOG.debug("[SigitRPfRuoloPaDaoImpl::findAllByIstatValidatore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT DISTINCT DESC_ABILITAZIONE ");
		sql.append(" FROM SIGIT_R_PF_RUOLO_PA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2140857280) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		log.debug(input.getIstatAbilitazione());
		log.debug(input.getIdRuoloPa());
		sql.append("istat_abilitazione = :istat");
		sql.append(" AND id_ruolo_pa = :id");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1472337278) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("istat", input.getIstatAbilitazione());
		paramMap.addValue("id", input.getIdRuoloPa());

		/*PROTECTED REGION END*/
		List<SigitRPfRuoloPaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, allByIstatValidatoreRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::findAllByIstatValidatore] esecuzione query", ex);
			throw new SigitRPfRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfRuoloPaDaoImpl", "findAllByIstatValidatore", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRPfRuoloPaDaoImpl::findAllByIstatValidatore] END");
		}
		return list;
	}

}
