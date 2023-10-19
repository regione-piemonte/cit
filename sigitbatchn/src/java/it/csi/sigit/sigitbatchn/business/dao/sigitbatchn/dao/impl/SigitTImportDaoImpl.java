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

/*PROTECTED REGION ID(R1470980975) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTImport.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - daElaborare (datagen::CustomFinder)
 *   - daInviareMailAssistenza (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - aggiornaIdAllegato (datagen::UpdateColumns)
 *   - aggiornaIdPersGiuridica (datagen::UpdateColumns)
 *   - aggiornaDataInvioMailAssistenza (datagen::CustomUpdater)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTImportDaoImpl extends AbstractDAO implements SigitTImportDao {
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
	 * Updates a single row in the SIGIT_T_IMPORT table.
	 * @generated
	 */
	public void update(SigitTImportDto dto) throws SigitTImportDaoException {
		LOG.debug("[SigitTImportDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DATA_INIZIO = :DATA_INIZIO ,DATA_FINE = :DATA_FINE ,NOME_FILE_IMPORT = :NOME_FILE_IMPORT ,FLG_ESITO = :FLG_ESITO ,CODICE_IMPIANTO = :CODICE_IMPIANTO ,FK_PRE_IMPORT = :FK_PRE_IMPORT ,FK_ALLEGATO = :FK_ALLEGATO ,MSG_ERRORE = :MSG_ERRORE ,FK_PERSONA_GIURIDICA = :FK_PERSONA_GIURIDICA ,DATA_INVIO_MAIL_MANUT = :DATA_INVIO_MAIL_MANUT ,DATA_INVIO_MAIL_ASSISTENZA = :DATA_INVIO_MAIL_ASSISTENZA ,FK_PG_CAT = :FK_PG_CAT  WHERE ID_IMPORT = :ID_IMPORT ";

		if (dto.getIdImport() == null) {
			LOG.error("[SigitTImportDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTImportDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_IMPORT]
		params.addValue("ID_IMPORT", dto.getIdImport(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NOME_FILE_IMPORT]
		params.addValue("NOME_FILE_IMPORT", dto.getNomeFileImport(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_ESITO]
		params.addValue("FLG_ESITO", dto.getFlgEsito(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_PRE_IMPORT]
		params.addValue("FK_PRE_IMPORT", dto.getFkPreImport(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MSG_ERRORE]
		params.addValue("MSG_ERRORE", dto.getMsgErrore(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_PERSONA_GIURIDICA]
		params.addValue("FK_PERSONA_GIURIDICA", dto.getFkPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INVIO_MAIL_MANUT]
		params.addValue("DATA_INVIO_MAIL_MANUT", dto.getDataInvioMailManut(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_INVIO_MAIL_ASSISTENZA]
		params.addValue("DATA_INVIO_MAIL_ASSISTENZA", dto.getDataInvioMailAssistenza(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_PG_CAT]
		params.addValue("FK_PG_CAT", dto.getFkPgCat(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTImportDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_IMPORT table.
	 * @generated
	 */
	public void updateColumnsAggiornaIdAllegato(SigitTImportDto dto) throws SigitTImportDaoException {
		LOG.debug("[SigitTImportDaoImpl::updateColumnsAggiornaIdAllegato] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_ALLEGATO = :FK_ALLEGATO  WHERE ID_IMPORT = :ID_IMPORT ";

		if (dto.getIdImport() == null) {
			LOG.error("[SigitTImportDaoImpl::updateColumnsAggiornaIdAllegato] ERROR chiave primaria non impostata");
			throw new SigitTImportDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_IMPORT]
		params.addValue("ID_IMPORT", dto.getIdImport(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTImportDaoImpl::updateColumnsAggiornaIdAllegato] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_IMPORT table.
	 * @generated
	 */
	public void updateColumnsAggiornaIdPersGiuridica(SigitTImportDto dto) throws SigitTImportDaoException {
		LOG.debug("[SigitTImportDaoImpl::updateColumnsAggiornaIdPersGiuridica] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_PERSONA_GIURIDICA = :FK_PERSONA_GIURIDICA  WHERE ID_IMPORT = :ID_IMPORT ";

		if (dto.getIdImport() == null) {
			LOG.error(
					"[SigitTImportDaoImpl::updateColumnsAggiornaIdPersGiuridica] ERROR chiave primaria non impostata");
			throw new SigitTImportDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_PERSONA_GIURIDICA]
		params.addValue("FK_PERSONA_GIURIDICA", dto.getFkPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_IMPORT]
		params.addValue("ID_IMPORT", dto.getIdImport(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTImportDaoImpl::updateColumnsAggiornaIdPersGiuridica] END");
	}

	/** 
	 * Custom updater in the SIGIT_T_IMPORT table.
	 * @generated
	 */
	public void customUpdaterAggiornaDataInvioMailAssistenza(java.lang.Object filter, java.lang.Object value)
			throws SigitTImportDaoException {
		LOG.debug("[SigitTImportDaoImpl::customUpdaterAggiornaDataInvioMailAssistenza] START");
		/*PROTECTED REGION ID(R811248266) ENABLED START*/
		//***scrivere la custom query
		final StringBuffer sql = new StringBuffer(
				"UPDATE " + getTableName() + " SET DATA_INVIO_MAIL_ASSISTENZA = :dataInvio ");
		sql.append(" WHERE DATA_INVIO_MAIL_ASSISTENZA IS NULL");
		sql.append(" AND DATA_FINE IS NOT NULL");

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("dataInvio", value, java.sql.Types.TIMESTAMP);

		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTImportDaoImpl::customUpdaterAggiornaDataInvioMailAssistenza] END");
	}

	protected SigitTImportDaoRowMapper findByPrimaryKeyRowMapper = new SigitTImportDaoRowMapper(null,
			SigitTImportDto.class, this);

	protected SigitTImportDaoRowMapper daElaborareRowMapper = new SigitTImportDaoRowMapper(null, SigitTImportDto.class,
			this);

	protected SigitTImportDaoRowMapper daInviareMailAssistenzaRowMapper = new SigitTImportDaoRowMapper(null,
			SigitTImportDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_IMPORT";
	}

	/** 
	 * Returns all rows from the SIGIT_T_IMPORT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTImportDto findByPrimaryKey(SigitTImportPk pk) throws SigitTImportDaoException {
		LOG.debug("[SigitTImportDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_IMPORT,DATA_INIZIO,DATA_FINE,NOME_FILE_IMPORT,FLG_ESITO,CODICE_IMPIANTO,FK_PRE_IMPORT,FK_ALLEGATO,MSG_ERRORE,FK_PERSONA_GIURIDICA,DATA_INVIO_MAIL_MANUT,DATA_INVIO_MAIL_ASSISTENZA,FK_PG_CAT FROM "
						+ getTableName() + " WHERE ID_IMPORT = :ID_IMPORT ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_IMPORT]
		params.addValue("ID_IMPORT", pk.getIdImport(), java.sql.Types.INTEGER);

		List<SigitTImportDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTImportDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTImportDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImportDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTImportDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder daElaborare
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImportDto> findDaElaborare(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDto input)
			throws SigitTImportDaoException {
		LOG.debug("[SigitTImportDaoImpl::findDaElaborare] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMPORT,DATA_INIZIO,DATA_FINE,NOME_FILE_IMPORT,FLG_ESITO,CODICE_IMPIANTO,FK_PRE_IMPORT,FK_ALLEGATO,MSG_ERRORE,FK_PERSONA_GIURIDICA,DATA_INVIO_MAIL_MANUT,DATA_INVIO_MAIL_ASSISTENZA,FK_PG_CAT ");
		sql.append(" FROM SIGIT_T_IMPORT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1766535937) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" DATA_FINE IS NULL ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1196847051) ENABLED START*/
		//***aggiungere tutte le condizioni

		//paramMap.addValue("nome", input);

		/*PROTECTED REGION END*/
		List<SigitTImportDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, daElaborareRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTImportDaoImpl::findDaElaborare] esecuzione query", ex);
			throw new SigitTImportDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImportDaoImpl", "findDaElaborare", "esecuzione query", sql.toString());
			LOG.debug("[SigitTImportDaoImpl::findDaElaborare] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder daInviareMailAssistenza
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImportDto> findDaInviareMailAssistenza(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDto input)
			throws SigitTImportDaoException {
		LOG.debug("[SigitTImportDaoImpl::findDaInviareMailAssistenza] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMPORT,DATA_INIZIO,DATA_FINE,NOME_FILE_IMPORT,FLG_ESITO,CODICE_IMPIANTO,FK_PRE_IMPORT,FK_ALLEGATO,MSG_ERRORE,FK_PERSONA_GIURIDICA,DATA_INVIO_MAIL_MANUT,DATA_INVIO_MAIL_ASSISTENZA,FK_PG_CAT ");
		sql.append(" FROM SIGIT_T_IMPORT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1422353916) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" DATA_INVIO_MAIL_ASSISTENZA IS NULL");
		sql.append(" AND DATA_FINE IS NOT NULL");
		sql.append(" ORDER BY ID_IMPORT ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1268184686) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitTImportDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, daInviareMailAssistenzaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTImportDaoImpl::findDaInviareMailAssistenza] esecuzione query", ex);
			throw new SigitTImportDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImportDaoImpl", "findDaInviareMailAssistenza", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTImportDaoImpl::findDaInviareMailAssistenza] END");
		}
		return list;
	}

}
