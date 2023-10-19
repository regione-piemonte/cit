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

/*PROTECTED REGION ID(R1650157065) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRComp4Manut.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - manutentoriByCodiceImpianto (datagen::CustomFinder)
 *   - attiviByFilter (datagen::CustomFinder)
 *   - byPersonaGiuridicaCodImpianto (datagen::CustomFinder)
 *   - attiviByFilterSubentro (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - perSubentro (datagen::CustomUpdater)
 * - DELETERS:
 *   - byFilter (datagen::CustomDeleter)
 *   - byCodImpianto (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRComp4ManutDaoImpl extends AbstractDAO implements SigitRComp4ManutDao {
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
	 * Metodo di inserimento del DAO sigitRComp4Manut. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRComp4ManutPk
	 * @generated
	 */

	public SigitRComp4ManutPk insert(SigitRComp4ManutDto dto)

	{
		LOG.debug("[SigitRComp4ManutDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_R_COMP4_MANUT,FK_PERSONA_GIURIDICA,CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INIZIO,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_RUOLO ) VALUES (  :ID_R_COMP4_MANUT , :FK_PERSONA_GIURIDICA , :CODICE_IMPIANTO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INIZIO , :DATA_FINE , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :FK_RUOLO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_R_COMP4_MANUT]
		params.addValue("ID_R_COMP4_MANUT", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PERSONA_GIURIDICA]
		params.addValue("FK_PERSONA_GIURIDICA", dto.getFkPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_RUOLO]
		params.addValue("FK_RUOLO", dto.getFkRuolo(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdRComp4Manut(newKey);
		LOG.debug("[SigitRComp4ManutDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_R_COMP4_MANUT table.
	 * @generated
	 */
	public void update(SigitRComp4ManutDto dto) throws SigitRComp4ManutDaoException {
		LOG.debug("[SigitRComp4ManutDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_PERSONA_GIURIDICA = :FK_PERSONA_GIURIDICA ,CODICE_IMPIANTO = :CODICE_IMPIANTO ,ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE ,PROGRESSIVO = :PROGRESSIVO ,DATA_INIZIO = :DATA_INIZIO ,DATA_FINE = :DATA_FINE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,FK_RUOLO = :FK_RUOLO  WHERE ID_R_COMP4_MANUT = :ID_R_COMP4_MANUT ";

		if (dto.getIdRComp4Manut() == null) {
			LOG.error("[SigitRComp4ManutDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitRComp4ManutDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_R_COMP4_MANUT]
		params.addValue("ID_R_COMP4_MANUT", dto.getIdRComp4Manut(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PERSONA_GIURIDICA]
		params.addValue("FK_PERSONA_GIURIDICA", dto.getFkPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_RUOLO]
		params.addValue("FK_RUOLO", dto.getFkRuolo(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRComp4ManutDaoImpl::update] END");
	}

	/** 
	 * Custom updater in the SIGIT_R_COMP4_MANUT table.
	 * @generated
	 */
	public void customUpdaterPerSubentro(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter,
			java.lang.Object value) throws SigitRComp4ManutDaoException {
		LOG.debug("[SigitRComp4ManutDaoImpl::customUpdaterPerSubentro] START");
		/*PROTECTED REGION ID(R1710976883) ENABLED START*/
		//***scrivere la custom query
		final StringBuffer sql = new StringBuffer();

		sql.append(" UPDATE " + getTableName() + " SET ");
		sql.append(" DATA_FINE = CURRENT_DATE-1, ");
		sql.append(" UTENTE_ULT_MOD = :utUltMod, ");
		sql.append(" DATA_ULT_MOD = :dataUltMod ");
		sql.append(" WHERE CODICE_IMPIANTO = :codImpianto ");
		sql.append(" AND ID_TIPO_COMPONENTE = :idTipoComp");
		sql.append(" AND DATA_FINE IS NULL ");

		if (filter.getListProgressivi() != null && !filter.getListProgressivi().isEmpty()) {
			sql.append(" AND PROGRESSIVO IN  (");
			boolean aggVirg = false;
			for (String progr : filter.getListProgressivi()) {
				if (aggVirg)
					sql.append(", ");
				sql.append(progr);
				aggVirg = true;
			}
			sql.append(") ");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodImpianto(), java.sql.Types.NUMERIC);
		params.addValue("idTipoComp", filter.getTipoComponente(), java.sql.Types.VARCHAR);
		params.addValue("utUltMod", value, java.sql.Types.VARCHAR);
		params.addValue("dataUltMod", DateUtil.getSqlDataCorrente(), java.sql.Types.TIMESTAMP);

		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRComp4ManutDaoImpl::customUpdaterPerSubentro] END");
	}

	/** 
	 * Custom deleter in the SIGIT_R_COMP4_MANUT table.
	 * @generated
	 */
	public void customDeleterByFilter(SigitRComp4ManutDto filter) throws SigitRComp4ManutDaoException {
		LOG.debug("[SigitRComp4ManutDaoImpl::customDeleterByFilter] START");
		/*PROTECTED REGION ID(R1051185223) ENABLED START*/
		//***scrivere la custom query
		final StringBuffer sql = new StringBuffer("DELETE FROM " + getTableName() + " WHERE ");

		sql.append(" CODICE_IMPIANTO = :codImpianto");

		sql.append(" AND ID_TIPO_COMPONENTE = :idTipoComp");
		sql.append(" AND PROGRESSIVO = :progressivo");
		//sql.append(" AND DATA_INSTALL = :dataInstallazione");

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("codImpianto", filter.getCodiceImpianto(), java.sql.Types.NUMERIC);

		params.addValue("idTipoComp", filter.getIdTipoComponente(), java.sql.Types.VARCHAR);

		params.addValue("progressivo", filter.getProgressivo(), java.sql.Types.NUMERIC);

		//		params.addValue("dataInstallazione", filter.getDataInstall(),
		//				java.sql.Types.DATE);

		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRComp4ManutDaoImpl::customDeleterByFilter] END");
	}

	/** 
	 * Custom deleter in the SIGIT_R_COMP4_MANUT table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitRComp4ManutDaoException {
		LOG.debug("[SigitRComp4ManutDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-499261552) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto ";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRComp4ManutDaoImpl::customDeleterByCodImpianto] END");
	}

	protected SigitRComp4ManutDaoRowMapper manutentoriByCodiceImpiantoRowMapper = new SigitRComp4ManutDaoRowMapper(null,
			SigitRComp4ManutManutentoriByCodiceImpiantoDto.class, this);

	protected SigitRComp4ManutDaoRowMapper attiviByFilterRowMapper = new SigitRComp4ManutDaoRowMapper(null,
			SigitRComp4ManutDto.class, this);

	protected SigitRComp4ManutDaoRowMapper byPersonaGiuridicaCodImpiantoRowMapper = new SigitRComp4ManutDaoRowMapper(
			null, SigitRComp4ManutDto.class, this);

	protected SigitRComp4ManutDaoRowMapper attiviByFilterSubentroRowMapper = new SigitRComp4ManutDaoRowMapper(null,
			SigitRComp4ManutDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_COMP4_MANUT";
	}

	/** 
		 * Implementazione del finder manutentoriByCodiceImpianto con Qdef
		 * @generated
		 */

	public List<SigitRComp4ManutManutentoriByCodiceImpiantoDto> findManutentoriByCodiceImpianto(java.lang.Integer input)
			throws SigitRComp4ManutDaoException {
		LOG.debug("[SigitRComp4ManutDaoImpl::findManutentoriByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT pg.CODICE_FISCALE, pg.SIGLA_REA, pg.NUMERO_REA, pg.DENOMINAZIONE, td.DES_TIPO_DOCUMENTO, cm.PROGRESSIVO, cm.FK_PERSONA_GIURIDICA, cm.ID_TIPO_COMPONENTE");

		sql.append(
				" FROM SIGIT_R_COMP4_MANUT cm, SIGIT_T_PERSONA_GIURIDICA pg, SIGIT_R_RUOLO_TIPODOC rtd, SIGIT_D_TIPO_DOCUMENTO td");

		sql.append(" WHERE ");

		sql.append(
				"cm.FK_PERSONA_GIURIDICA = pg.ID_PERSONA_GIURIDICA AND cm.FK_RUOLO = rtd.ID_RUOLO AND rtd.ID_TIPO_DOCUMENTO = td.ID_TIPO_DOCUMENTO");

		sql.append(" AND ");

		sql.append("cm.DATA_FINE IS NULL AND cm.CODICE_IMPIANTO = :codImpianto");
		/*PROTECTED REGION ID(R145619045) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" ORDER BY td.ID_TIPO_DOCUMENTO , cm.FK_PERSONA_GIURIDICA, cm.PROGRESSIVO");
		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/

		List<SigitRComp4ManutManutentoriByCodiceImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, manutentoriByCodiceImpiantoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRComp4ManutDaoImpl::findManutentoriByCodiceImpianto] ERROR esecuzione query", ex);
			throw new SigitRComp4ManutDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRComp4ManutDaoImpl", "findManutentoriByCodiceImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRComp4ManutDaoImpl::findManutentoriByCodiceImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attiviByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRComp4ManutDto> findAttiviByFilter(SigitRComp4ManutDto input) throws SigitRComp4ManutDaoException {
		LOG.debug("[SigitRComp4ManutDaoImpl::findAttiviByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_R_COMP4_MANUT,FK_PERSONA_GIURIDICA,CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INIZIO,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_RUOLO ");
		sql.append(" FROM SIGIT_R_COMP4_MANUT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1722170696) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		sql.append(" DATA_FINE IS NULL");

		if (input.getCodiceImpianto() != null)
			sql.append(" AND CODICE_IMPIANTO = :codImpianto");

		if (input.getFkRuolo() != null)
			sql.append(" AND FK_RUOLO = :ruolo");

		if (input.getIdTipoComponente() != null)
			sql.append(" AND ID_TIPO_COMPONENTE = :idTipoComp");

		if (input.getProgressivo() != null)
			sql.append(" AND PROGRESSIVO = :progressivo");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1566719494) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input.getCodiceImpianto() != null)
			paramMap.addValue("codImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);

		if (input.getFkRuolo() != null)
			paramMap.addValue("ruolo", input.getFkRuolo(), java.sql.Types.NUMERIC);

		if (input.getIdTipoComponente() != null)
			paramMap.addValue("idTipoComp", input.getIdTipoComponente(), java.sql.Types.VARCHAR);

		if (input.getProgressivo() != null)
			paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitRComp4ManutDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attiviByFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRComp4ManutDaoImpl::findAttiviByFilter] esecuzione query", ex);
			throw new SigitRComp4ManutDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRComp4ManutDaoImpl", "findAttiviByFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitRComp4ManutDaoImpl::findAttiviByFilter] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byPersonaGiuridicaCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRComp4ManutDto> findByPersonaGiuridicaCodImpianto(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitRComp4ManutDaoException {
		LOG.debug("[SigitRComp4ManutDaoImpl::findByPersonaGiuridicaCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_R_COMP4_MANUT,FK_PERSONA_GIURIDICA,CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INIZIO,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_RUOLO ");
		sql.append(" FROM SIGIT_R_COMP4_MANUT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-877040285) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("  DATA_FINE IS NULL");
		if (input.getIdPG() != null)
			sql.append(" AND FK_PERSONA_GIURIDICA = :idPersonaGiuridica");
		if (input.getCodImpianto() != null)
			sql.append(" AND CODICE_IMPIANTO = :codiceImpianto");
		if (input.getIdRuolo() != null)
			sql.append(" AND FK_RUOLO = :idRuolo");

		if (input.getListProgressivi() != null && !input.getListProgressivi().isEmpty()) {
			sql.append(" AND PROGRESSIVO IN  (");
			boolean aggVirg = false;
			for (String progr : input.getListProgressivi()) {
				if (aggVirg)
					sql.append(", ");
				sql.append(progr);
				aggVirg = true;
			}
			sql.append(") ");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-537881281) ENABLED START*/
		//***aggiungere tutte le condizioni
		if (input.getIdPG() != null)
			paramMap.addValue("idPersonaGiuridica", input.getIdPG(), java.sql.Types.NUMERIC);
		if (input.getCodImpianto() != null)
			paramMap.addValue("codiceImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		if (input.getIdRuolo() != null)
			paramMap.addValue("idRuolo", input.getIdRuolo(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitRComp4ManutDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byPersonaGiuridicaCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRComp4ManutDaoImpl::findByPersonaGiuridicaCodImpianto] esecuzione query", ex);
			throw new SigitRComp4ManutDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRComp4ManutDaoImpl", "findByPersonaGiuridicaCodImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRComp4ManutDaoImpl::findByPersonaGiuridicaCodImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attiviByFilterSubentro
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRComp4ManutDto> findAttiviByFilterSubentro(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaPfPg input)
			throws SigitRComp4ManutDaoException {
		LOG.debug("[SigitRComp4ManutDaoImpl::findAttiviByFilterSubentro] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_R_COMP4_MANUT,FK_PERSONA_GIURIDICA,CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INIZIO,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_RUOLO ");
		sql.append(" FROM SIGIT_R_COMP4_MANUT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1983521904) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" DATA_FINE IS NULL");

		if (input.getIdRuoloList() != null && !input.getIdRuoloList().isEmpty()) {
			sql.append(" AND FK_RUOLO IN (" + ConvertUtil.getStringByList(input.getIdRuoloList()) + ")");
		}

		if (input.getIdPersonaGiuridica() != null) {
			sql.append(" AND FK_PERSONA_GIURIDICA = :fkGiuridica");
		}

		if (input.getIsEscludiDataOdierna()) {
			sql.append(" AND DATA_INIZIO <> CURRENT_DATE ");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-479073102) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input.getIdRuolo() != null) {
			paramMap.addValue("ruolo", input.getIdRuolo(), java.sql.Types.NUMERIC);
		}

		if (input.getIdPersonaGiuridica() != null) {
			paramMap.addValue("fkGiuridica", input.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);
		}

		/*PROTECTED REGION END*/
		List<SigitRComp4ManutDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attiviByFilterSubentroRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRComp4ManutDaoImpl::findAttiviByFilterSubentro] esecuzione query", ex);
			throw new SigitRComp4ManutDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRComp4ManutDaoImpl", "findAttiviByFilterSubentro", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRComp4ManutDaoImpl::findAttiviByFilterSubentro] END");
		}
		return list;
	}

}
