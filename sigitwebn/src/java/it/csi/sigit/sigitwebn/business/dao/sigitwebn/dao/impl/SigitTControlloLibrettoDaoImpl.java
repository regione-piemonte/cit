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

/*PROTECTED REGION ID(R-403013969) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTControlloLibretto.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 *   - aggiornaControlloScheda7 (datagen::UpdateColumns)
 *   - aggiornaControlloScheda5 (datagen::UpdateColumns)
 *   - aggiornaControlloScheda6 (datagen::UpdateColumns)
 *   - aggiornaControlloScheda1 (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTControlloLibrettoDaoImpl extends AbstractDAO implements SigitTControlloLibrettoDao {
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
	 * Metodo di inserimento del DAO sigitTControlloLibretto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTControlloLibrettoPk
	 * @generated
	 */

	public SigitTControlloLibrettoPk insert(SigitTControlloLibrettoDto dto)

	{
		LOG.debug("[SigitTControlloLibrettoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,FLG_L1_CONTROLLOWEB,FLG_L5_CONTROLLOWEB,FLG_L6_CONTROLLOWEB,FLG_L7_CONTROLLOWEB,DT_ULT_MOD,UTENTE_ULT_AGG ) VALUES (  :CODICE_IMPIANTO , :FLG_L1_CONTROLLOWEB , :FLG_L5_CONTROLLOWEB , :FLG_L6_CONTROLLOWEB , :FLG_L7_CONTROLLOWEB , :DT_ULT_MOD , :UTENTE_ULT_AGG  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_L1_CONTROLLOWEB]
		params.addValue("FLG_L1_CONTROLLOWEB", dto.getFlgL1Controlloweb(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_L5_CONTROLLOWEB]
		params.addValue("FLG_L5_CONTROLLOWEB", dto.getFlgL5Controlloweb(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_L6_CONTROLLOWEB]
		params.addValue("FLG_L6_CONTROLLOWEB", dto.getFlgL6Controlloweb(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_L7_CONTROLLOWEB]
		params.addValue("FLG_L7_CONTROLLOWEB", dto.getFlgL7Controlloweb(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_ULT_MOD]
		params.addValue("DT_ULT_MOD", dto.getDtUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_AGG]
		params.addValue("UTENTE_ULT_AGG", dto.getUtenteUltAgg(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTControlloLibrettoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the SIGIT_T_CONTROLLO_LIBRETTO table.
	 * @generated
	 */
	public void updateColumnsAggiornaControlloScheda7(SigitTControlloLibrettoDto dto)
			throws SigitTControlloLibrettoDaoException {
		LOG.debug("[SigitTControlloLibrettoDaoImpl::updateColumnsAggiornaControlloScheda7] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FLG_L7_CONTROLLOWEB = :FLG_L7_CONTROLLOWEB ,DT_ULT_MOD = :DT_ULT_MOD ,UTENTE_ULT_AGG = :UTENTE_ULT_AGG  WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (dto.getCodiceImpianto() == null) {
			LOG.error(
					"[SigitTControlloLibrettoDaoImpl::updateColumnsAggiornaControlloScheda7] ERROR chiave primaria non impostata");
			throw new SigitTControlloLibrettoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FLG_L7_CONTROLLOWEB]
		params.addValue("FLG_L7_CONTROLLOWEB", dto.getFlgL7Controlloweb(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_ULT_MOD]
		params.addValue("DT_ULT_MOD", dto.getDtUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_AGG]
		params.addValue("UTENTE_ULT_AGG", dto.getUtenteUltAgg(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTControlloLibrettoDaoImpl::updateColumnsAggiornaControlloScheda7] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_CONTROLLO_LIBRETTO table.
	 * @generated
	 */
	public void updateColumnsAggiornaControlloScheda5(SigitTControlloLibrettoDto dto)
			throws SigitTControlloLibrettoDaoException {
		LOG.debug("[SigitTControlloLibrettoDaoImpl::updateColumnsAggiornaControlloScheda5] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FLG_L5_CONTROLLOWEB = :FLG_L5_CONTROLLOWEB ,DT_ULT_MOD = :DT_ULT_MOD ,UTENTE_ULT_AGG = :UTENTE_ULT_AGG  WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (dto.getCodiceImpianto() == null) {
			LOG.error(
					"[SigitTControlloLibrettoDaoImpl::updateColumnsAggiornaControlloScheda5] ERROR chiave primaria non impostata");
			throw new SigitTControlloLibrettoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FLG_L5_CONTROLLOWEB]
		params.addValue("FLG_L5_CONTROLLOWEB", dto.getFlgL5Controlloweb(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_ULT_MOD]
		params.addValue("DT_ULT_MOD", dto.getDtUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_AGG]
		params.addValue("UTENTE_ULT_AGG", dto.getUtenteUltAgg(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTControlloLibrettoDaoImpl::updateColumnsAggiornaControlloScheda5] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_CONTROLLO_LIBRETTO table.
	 * @generated
	 */
	public void updateColumnsAggiornaControlloScheda6(SigitTControlloLibrettoDto dto)
			throws SigitTControlloLibrettoDaoException {
		LOG.debug("[SigitTControlloLibrettoDaoImpl::updateColumnsAggiornaControlloScheda6] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FLG_L6_CONTROLLOWEB = :FLG_L6_CONTROLLOWEB ,DT_ULT_MOD = :DT_ULT_MOD ,UTENTE_ULT_AGG = :UTENTE_ULT_AGG  WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (dto.getCodiceImpianto() == null) {
			LOG.error(
					"[SigitTControlloLibrettoDaoImpl::updateColumnsAggiornaControlloScheda6] ERROR chiave primaria non impostata");
			throw new SigitTControlloLibrettoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FLG_L6_CONTROLLOWEB]
		params.addValue("FLG_L6_CONTROLLOWEB", dto.getFlgL6Controlloweb(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_ULT_MOD]
		params.addValue("DT_ULT_MOD", dto.getDtUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_AGG]
		params.addValue("UTENTE_ULT_AGG", dto.getUtenteUltAgg(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTControlloLibrettoDaoImpl::updateColumnsAggiornaControlloScheda6] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_CONTROLLO_LIBRETTO table.
	 * @generated
	 */
	public void updateColumnsAggiornaControlloScheda1(SigitTControlloLibrettoDto dto)
			throws SigitTControlloLibrettoDaoException {
		LOG.debug("[SigitTControlloLibrettoDaoImpl::updateColumnsAggiornaControlloScheda1] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FLG_L1_CONTROLLOWEB = :FLG_L1_CONTROLLOWEB ,DT_ULT_MOD = :DT_ULT_MOD ,UTENTE_ULT_AGG = :UTENTE_ULT_AGG  WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (dto.getCodiceImpianto() == null) {
			LOG.error(
					"[SigitTControlloLibrettoDaoImpl::updateColumnsAggiornaControlloScheda1] ERROR chiave primaria non impostata");
			throw new SigitTControlloLibrettoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FLG_L1_CONTROLLOWEB]
		params.addValue("FLG_L1_CONTROLLOWEB", dto.getFlgL1Controlloweb(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_ULT_MOD]
		params.addValue("DT_ULT_MOD", dto.getDtUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_AGG]
		params.addValue("UTENTE_ULT_AGG", dto.getUtenteUltAgg(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTControlloLibrettoDaoImpl::updateColumnsAggiornaControlloScheda1] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_CONTROLLO_LIBRETTO table.
	 * @generated
	 */

	public void delete(SigitTControlloLibrettoPk pk) throws SigitTControlloLibrettoDaoException {
		LOG.debug("[SigitTControlloLibrettoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (pk == null) {
			LOG.error("[SigitTControlloLibrettoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTControlloLibrettoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTControlloLibrettoDaoImpl::delete] END");
	}

	protected SigitTControlloLibrettoDaoRowMapper findByPrimaryKeyRowMapper = new SigitTControlloLibrettoDaoRowMapper(
			null, SigitTControlloLibrettoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_CONTROLLO_LIBRETTO";
	}

	/** 
	 * Returns all rows from the SIGIT_T_CONTROLLO_LIBRETTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTControlloLibrettoDto findByPrimaryKey(SigitTControlloLibrettoPk pk)
			throws SigitTControlloLibrettoDaoException {
		LOG.debug("[SigitTControlloLibrettoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT CODICE_IMPIANTO,FLG_L1_CONTROLLOWEB,FLG_L5_CONTROLLOWEB,FLG_L6_CONTROLLOWEB,FLG_L7_CONTROLLOWEB,DT_ULT_MOD,UTENTE_ULT_AGG FROM "
						+ getTableName() + " WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		List<SigitTControlloLibrettoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTControlloLibrettoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTControlloLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTControlloLibrettoDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTControlloLibrettoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
