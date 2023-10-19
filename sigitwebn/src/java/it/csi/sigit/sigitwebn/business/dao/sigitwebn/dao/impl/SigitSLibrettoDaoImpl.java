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

/*PROTECTED REGION ID(R1897118545) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitSLibretto.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - daCancellare (datagen::CustomFinder)
 *   - byCodiceImpianto (datagen::CustomFinder)
 *   - byCodiceImpiantoNonBozza (datagen::CustomFinder)
 *   - byLibrettoFilter (datagen::CustomFinder)
  * - UPDATERS:
 *   - storicizzaByCodImpianto (datagen::CustomUpdater)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitSLibrettoDaoImpl extends AbstractDAO implements SigitSLibrettoDao {
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
	 * Metodo di inserimento del DAO sigitSLibretto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitSLibrettoPk
	 * @generated
	 */

	public SigitSLibrettoPk insert(SigitSLibrettoDto dto)

	{
		LOG.debug("[SigitSLibrettoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO ) VALUES (  :ID_LIBRETTO , :FK_STATO , :FK_MOTIVO_CONSOLID , :FK_TIPO_DOCUMENTO , :DATA_CONSOLIDAMENTO , :FILE_INDEX , :UID_INDEX , :CF_REDATTORE , :FLG_CONTROLLO_BOZZA , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :CODICE_IMPIANTO  )";

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

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitSLibrettoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom updater in the SIGIT_S_LIBRETTO table.
	 * @generated
	 */
	public void customUpdaterStoricizzaByCodImpianto(SigitSLibrettoDto filter, java.lang.Object value)
			throws SigitSLibrettoDaoException {
		LOG.debug("[SigitSLibrettoDaoImpl::customUpdaterStoricizzaByCodImpianto] START");
		/*PROTECTED REGION ID(R-450609652) ENABLED START*/
		//***scrivere la custom query
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_STATO = 3 ,  data_ult_mod = :dataUltMod, utente_ult_mod =  :utenteUltMod"
				+ " WHERE CODICE_IMPIANTO = :codImpianto AND FK_STATO = 2";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodiceImpianto(), java.sql.Types.NUMERIC);
		params.addValue("dataUltMod", filter.getDataUltMod(), java.sql.Types.TIMESTAMP);
		params.addValue("utenteUltMod", filter.getUtenteUltMod(), java.sql.Types.VARCHAR);
		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitSLibrettoDaoImpl::customUpdaterStoricizzaByCodImpianto] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_S_LIBRETTO table.
	 * @generated
	 */

	public void delete(SigitSLibrettoPk pk) throws SigitSLibrettoDaoException {
		LOG.debug("[SigitSLibrettoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_LIBRETTO = :ID_LIBRETTO ";

		if (pk == null) {
			LOG.error("[SigitSLibrettoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitSLibrettoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LIBRETTO]
		params.addValue("ID_LIBRETTO", pk.getIdLibretto(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitSLibrettoDaoImpl::delete] END");
	}

	protected SigitSLibrettoDaoRowMapper daCancellareRowMapper = new SigitSLibrettoDaoRowMapper(null,
			SigitSLibrettoDto.class, this);

	protected SigitSLibrettoDaoRowMapper byCodiceImpiantoRowMapper = new SigitSLibrettoDaoRowMapper(null,
			SigitSLibrettoDto.class, this);

	protected SigitSLibrettoDaoRowMapper byCodiceImpiantoNonBozzaRowMapper = new SigitSLibrettoDaoRowMapper(null,
			SigitSLibrettoByCodiceImpiantoNonBozzaDto.class, this);

	protected SigitSLibrettoDaoRowMapper byLibrettoFilterRowMapper = new SigitSLibrettoDaoRowMapper(null,
			SigitSLibrettoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_S_LIBRETTO";
	}

	/** 
	 * Implementazione del finder daCancellare
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitSLibrettoDto> findDaCancellare(java.lang.Integer input) throws SigitSLibrettoDaoException {
		LOG.debug("[SigitSLibrettoDaoImpl::findDaCancellare] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO ");
		sql.append(" FROM SIGIT_S_LIBRETTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-840593183) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" DATE_PART('year', DATA_CONSOLIDAMENTO) <= DATE_PART('year', now())-11 ");
		sql.append(" ORDER BY ID_LIBRETTO ASC ");
		sql.append(
				" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RECORDS_STORICIZZAZIONE')");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R591978881) ENABLED START*/
		//***aggiungere tutte le condizioni

		//paramMap.addValue("nome", input);

		/*PROTECTED REGION END*/
		List<SigitSLibrettoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, daCancellareRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitSLibrettoDaoImpl::findDaCancellare] esecuzione query", ex);
			throw new SigitSLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitSLibrettoDaoImpl", "findDaCancellare", "esecuzione query", sql.toString());
			LOG.debug("[SigitSLibrettoDaoImpl::findDaCancellare] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitSLibrettoDto> findByCodiceImpianto(java.lang.Integer input) throws SigitSLibrettoDaoException {
		LOG.debug("[SigitSLibrettoDaoImpl::findByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO ");
		sql.append(" FROM SIGIT_S_LIBRETTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R684356881) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" ORDER BY DATA_CONSOLIDAMENTO desc ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R620790609) ENABLED START*/
		//***aggiungere tutte le condizioni
		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitSLibrettoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitSLibrettoDaoImpl::findByCodiceImpianto] esecuzione query", ex);
			throw new SigitSLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitSLibrettoDaoImpl", "findByCodiceImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitSLibrettoDaoImpl::findByCodiceImpianto] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCodiceImpiantoNonBozza con Qdef
		 * @generated
		 */

	public List<SigitSLibrettoByCodiceImpiantoNonBozzaDto> findByCodiceImpiantoNonBozza(java.lang.Integer input)
			throws SigitSLibrettoDaoException {
		LOG.debug("[SigitSLibrettoDaoImpl::findByCodiceImpiantoNonBozza] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT lib.ID_LIBRETTO, lib.DATA_CONSOLIDAMENTO, mot.DES_MOTIVO_CONSOLID, lib.FILE_INDEX, lib.UID_INDEX");

		sql.append(" FROM SIGIT_S_LIBRETTO lib, SIGIT_D_MOTIVO_CONSOLID mot");

		sql.append(" WHERE ");

		sql.append("lib.FK_MOTIVO_CONSOLID = mot.ID_MOTIVO_CONSOLID");

		sql.append(" AND ");

		sql.append("lib.codice_impianto = :codiceImpianto AND lib.fk_stato != 1");
		/*PROTECTED REGION ID(R-732820660) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" ORDER BY ID_LIBRETTO DESC ");

		paramMap.addValue("codiceImpianto", input);

		/*PROTECTED REGION END*/

		List<SigitSLibrettoByCodiceImpiantoNonBozzaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoNonBozzaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitSLibrettoDaoImpl::findByCodiceImpiantoNonBozza] ERROR esecuzione query", ex);
			throw new SigitSLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitSLibrettoDaoImpl", "findByCodiceImpiantoNonBozza", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitSLibrettoDaoImpl::findByCodiceImpiantoNonBozza] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byLibrettoFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitSLibrettoDto> findByLibrettoFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.LibrettoFilter input)
			throws SigitSLibrettoDaoException {
		LOG.debug("[SigitSLibrettoDaoImpl::findByLibrettoFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO ");
		sql.append(" FROM SIGIT_S_LIBRETTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R411679848) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_STATO = :idStato");

		sql.append(" ORDER BY DATA_CONSOLIDAMENTO desc ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R757737178) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto());
		paramMap.addValue("idStato", input.getIdStatoLibretto());

		/*PROTECTED REGION END*/
		List<SigitSLibrettoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byLibrettoFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitSLibrettoDaoImpl::findByLibrettoFilter] esecuzione query", ex);
			throw new SigitSLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitSLibrettoDaoImpl", "findByLibrettoFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitSLibrettoDaoImpl::findByLibrettoFilter] END");
		}
		return list;
	}

}
