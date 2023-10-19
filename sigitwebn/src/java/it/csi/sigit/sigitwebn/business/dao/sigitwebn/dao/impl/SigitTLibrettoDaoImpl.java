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

/*PROTECTED REGION ID(R-1845996205) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTLibretto.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byCodiceImpianto (datagen::CustomFinder)
 *   - byLibrettoFilter (datagen::CustomFinder)
 *   - byCodiceImpOrderById (datagen::CustomFinder)
 *   - byCodiceImpNonBozza (datagen::CustomFinder)
 *   - daArchiviare (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - storicizzaByCodImpianto (datagen::CustomUpdater)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *   - bozzaByCodiceImpianto (datagen::CustomDeleter)
 *   - byCodImpianto (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTLibrettoDaoImpl extends AbstractDAO implements SigitTLibrettoDao {
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
	 * Metodo di inserimento del DAO sigitTLibretto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTLibrettoPk
	 * @generated
	 */

	public SigitTLibrettoPk insert(SigitTLibrettoDto dto)

	{
		LOG.debug("[SigitTLibrettoDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO ) VALUES (  :ID_LIBRETTO , :FK_STATO , :FK_MOTIVO_CONSOLID , :FK_TIPO_DOCUMENTO , :DATA_CONSOLIDAMENTO , :FILE_INDEX , :UID_INDEX , :CF_REDATTORE , :FLG_CONTROLLO_BOZZA , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :CODICE_IMPIANTO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LIBRETTO]
		params.addValue("ID_LIBRETTO", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_STATO]
		params.addValue("FK_STATO", dto.getFkStato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_MOTIVO_CONSOLID]
		params.addValue("FK_MOTIVO_CONSOLID", dto.getFkMotivoConsolid(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_DOCUMENTO]
		params.addValue("FK_TIPO_DOCUMENTO", dto.getFkTipoDocumento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_CONSOLIDAMENTO]
		params.addValue("DATA_CONSOLIDAMENTO", dto.getDataConsolidamento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FILE_INDEX]
		params.addValue("FILE_INDEX", dto.getFileIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CF_REDATTORE]
		params.addValue("CF_REDATTORE", dto.getCfRedattore(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_CONTROLLO_BOZZA]
		params.addValue("FLG_CONTROLLO_BOZZA", dto.getFlgControlloBozza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdLibretto(newKey);
		LOG.debug("[SigitTLibrettoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */
	public void update(SigitTLibrettoDto dto) throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_STATO = :FK_STATO ,FK_MOTIVO_CONSOLID = :FK_MOTIVO_CONSOLID ,FK_TIPO_DOCUMENTO = :FK_TIPO_DOCUMENTO ,DATA_CONSOLIDAMENTO = :DATA_CONSOLIDAMENTO ,FILE_INDEX = :FILE_INDEX ,UID_INDEX = :UID_INDEX ,CF_REDATTORE = :CF_REDATTORE ,FLG_CONTROLLO_BOZZA = :FLG_CONTROLLO_BOZZA ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,CODICE_IMPIANTO = :CODICE_IMPIANTO  WHERE ID_LIBRETTO = :ID_LIBRETTO ";

		if (dto.getIdLibretto() == null) {
			LOG.error("[SigitTLibrettoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTLibrettoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LIBRETTO]
		params.addValue("ID_LIBRETTO", dto.getIdLibretto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_STATO]
		params.addValue("FK_STATO", dto.getFkStato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_MOTIVO_CONSOLID]
		params.addValue("FK_MOTIVO_CONSOLID", dto.getFkMotivoConsolid(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_DOCUMENTO]
		params.addValue("FK_TIPO_DOCUMENTO", dto.getFkTipoDocumento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_CONSOLIDAMENTO]
		params.addValue("DATA_CONSOLIDAMENTO", dto.getDataConsolidamento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FILE_INDEX]
		params.addValue("FILE_INDEX", dto.getFileIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CF_REDATTORE]
		params.addValue("CF_REDATTORE", dto.getCfRedattore(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_CONTROLLO_BOZZA]
		params.addValue("FLG_CONTROLLO_BOZZA", dto.getFlgControlloBozza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTLibrettoDaoImpl::update] END");
	}

	/** 
	 * Custom updater in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */
	public void customUpdaterStoricizzaByCodImpianto(SigitTLibrettoDto filter, java.lang.Object value)
			throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::customUpdaterStoricizzaByCodImpianto] START");
		/*PROTECTED REGION ID(R-1617305971) ENABLED START*/
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_STATO = 3 ,  data_ult_mod = :dataUltMod, utente_ult_mod =  :utenteUltMod"
				+ " WHERE CODICE_IMPIANTO = :codImpianto AND FK_STATO = 2";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodiceImpianto(), java.sql.Types.NUMERIC);
		params.addValue("dataUltMod", filter.getDataUltMod(), java.sql.Types.TIMESTAMP);
		params.addValue("utenteUltMod", filter.getUtenteUltMod(), java.sql.Types.VARCHAR);
		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTLibrettoDaoImpl::customUpdaterStoricizzaByCodImpianto] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */

	public void delete(SigitTLibrettoPk pk) throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_LIBRETTO = :ID_LIBRETTO ";

		if (pk == null) {
			LOG.error("[SigitTLibrettoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTLibrettoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LIBRETTO]
		params.addValue("ID_LIBRETTO", pk.getIdLibretto(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTLibrettoDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */
	public void customDeleterBozzaByCodiceImpianto(java.lang.Integer filter) throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::customDeleterBozzaByCodiceImpianto] START");
		/*PROTECTED REGION ID(R-1546575240) ENABLED START*/
		//***scrivere la custom query
		StringBuilder sql = new StringBuilder();

		sql.append("DELETE FROM " + getTableName() + " WHERE ");

		sql.append(" CODICE_IMPIANTO = :codice_impianto ");
		sql.append(" AND FK_STATO = " + Constants.ID_STATO_LIBRETTO_BOZZA);

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codice_impianto", filter);

		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTLibrettoDaoImpl::customDeleterBozzaByCodiceImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-1159643307) ENABLED START*/
		//***scrivere la custom query
		final StringBuilder sql = new StringBuilder("DELETE FROM " + getTableName() + " WHERE ");

		sql.append(" CODICE_IMPIANTO = :codImpianto");

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("codImpianto", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTLibrettoDaoImpl::customDeleterByCodImpianto] END");
	}

	protected SigitTLibrettoDaoRowMapper findByPrimaryKeyRowMapper = new SigitTLibrettoDaoRowMapper(null,
			SigitTLibrettoDto.class, this);

	protected SigitTLibrettoDaoRowMapper byCodiceImpiantoRowMapper = new SigitTLibrettoDaoRowMapper(null,
			SigitTLibrettoDto.class, this);

	protected SigitTLibrettoDaoRowMapper byLibrettoFilterRowMapper = new SigitTLibrettoDaoRowMapper(null,
			SigitTLibrettoDto.class, this);

	protected SigitTLibrettoDaoRowMapper byCodiceImpOrderByIdRowMapper = new SigitTLibrettoDaoRowMapper(null,
			SigitTLibrettoDto.class, this);

	protected SigitTLibrettoDaoRowMapper byCodiceImpNonBozzaRowMapper = new SigitTLibrettoDaoRowMapper(null,
			SigitTLibrettoByCodiceImpNonBozzaDto.class, this);

	protected SigitTLibrettoDaoRowMapper daArchiviareRowMapper = new SigitTLibrettoDaoRowMapper(null,
			SigitTLibrettoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_LIBRETTO";
	}

	/** 
	 * Returns all rows from the SIGIT_T_LIBRETTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTLibrettoDto findByPrimaryKey(SigitTLibrettoPk pk) throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO FROM "
						+ getTableName() + " WHERE ID_LIBRETTO = :ID_LIBRETTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LIBRETTO]
		params.addValue("ID_LIBRETTO", pk.getIdLibretto(), java.sql.Types.NUMERIC);

		List<SigitTLibrettoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTLibrettoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTLibrettoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTLibrettoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLibrettoDto> findByCodiceImpianto(java.lang.Integer input) throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::findByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO ");
		sql.append(" FROM SIGIT_T_LIBRETTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1016383598) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" ORDER BY DATA_CONSOLIDAMENTO desc ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-562556688) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitTLibrettoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTLibrettoDaoImpl::findByCodiceImpianto] esecuzione query", ex);
			throw new SigitTLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTLibrettoDaoImpl", "findByCodiceImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitTLibrettoDaoImpl::findByCodiceImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byLibrettoFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLibrettoDto> findByLibrettoFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.LibrettoFilter input)
			throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::findByLibrettoFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO ");
		sql.append(" FROM SIGIT_T_LIBRETTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1289060631) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_STATO = :idStato");

		sql.append(" ORDER BY DATA_CONSOLIDAMENTO desc ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-425610119) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto());
		paramMap.addValue("idStato", input.getIdStatoLibretto());

		/*PROTECTED REGION END*/
		List<SigitTLibrettoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byLibrettoFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTLibrettoDaoImpl::findByLibrettoFilter] esecuzione query", ex);
			throw new SigitTLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTLibrettoDaoImpl", "findByLibrettoFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitTLibrettoDaoImpl::findByLibrettoFilter] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceImpOrderById
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLibrettoDto> findByCodiceImpOrderById(java.lang.Integer input) throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::findByCodiceImpOrderById] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO ");
		sql.append(" FROM SIGIT_T_LIBRETTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R113207457) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codiceImpianto");
		sql.append(" ORDER BY ID_LIBRETTO desc ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R95027649) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codiceImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitTLibrettoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpOrderByIdRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTLibrettoDaoImpl::findByCodiceImpOrderById] esecuzione query", ex);
			throw new SigitTLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTLibrettoDaoImpl", "findByCodiceImpOrderById", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTLibrettoDaoImpl::findByCodiceImpOrderById] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCodiceImpNonBozza con Qdef
		 * @generated
		 */

	public List<SigitTLibrettoByCodiceImpNonBozzaDto> findByCodiceImpNonBozza(java.lang.Integer input)
			throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::findByCodiceImpNonBozza] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT lib.ID_LIBRETTO, lib.DATA_CONSOLIDAMENTO, mc.DES_MOTIVO_CONSOLID, lib.FILE_INDEX, lib.UID_INDEX");

		sql.append(" FROM SIGIT_T_LIBRETTO lib, SIGIT_D_MOTIVO_CONSOLID mc");

		sql.append(" WHERE ");

		sql.append("lib.FK_MOTIVO_CONSOLID = mc.ID_MOTIVO_CONSOLID");

		sql.append(" AND ");

		sql.append("lib.codice_impianto = :codiceImpianto AND lib.fk_stato != 1");
		/*PROTECTED REGION ID(R-874932304) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" ORDER BY ID_LIBRETTO DESC ");

		paramMap.addValue("codiceImpianto", input);

		/*PROTECTED REGION END*/

		List<SigitTLibrettoByCodiceImpNonBozzaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpNonBozzaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTLibrettoDaoImpl::findByCodiceImpNonBozza] ERROR esecuzione query", ex);
			throw new SigitTLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTLibrettoDaoImpl", "findByCodiceImpNonBozza", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTLibrettoDaoImpl::findByCodiceImpNonBozza] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder daArchiviare
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLibrettoDto> findDaArchiviare(java.lang.Integer input) throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::findDaArchiviare] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO ");
		sql.append(" FROM SIGIT_T_LIBRETTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R545593038) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" DATE_PART('year', DATA_CONSOLIDAMENTO) <= DATE_PART('year', now())-6 ");
		sql.append(" ORDER BY ID_LIBRETTO ASC ");
		sql.append(
				" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RECORDS_STORICIZZAZIONE')");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R614078772) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitTLibrettoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, daArchiviareRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTLibrettoDaoImpl::findDaArchiviare] esecuzione query", ex);
			throw new SigitTLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTLibrettoDaoImpl", "findDaArchiviare", "esecuzione query", sql.toString());
			LOG.debug("[SigitTLibrettoDaoImpl::findDaArchiviare] END");
		}
		return list;
	}

}
