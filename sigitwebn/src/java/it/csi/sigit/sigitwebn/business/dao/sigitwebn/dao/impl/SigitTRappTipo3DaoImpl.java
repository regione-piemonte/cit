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

/*PROTECTED REGION ID(R-1669003313) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTRappTipo3.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTRappTipo3DaoImpl extends AbstractDAO implements SigitTRappTipo3Dao {
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
	 * Metodo di inserimento del DAO sigitTRappTipo3. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRappTipo3Pk
	 * @generated
	 */

	public SigitTRappTipo3Pk insert(SigitTRappTipo3Dto dto)

	{
		LOG.debug("[SigitTRappTipo3DaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALLEGATO,D_FLG_LOCALE_IDONEO,D_FLG_LINEA_ELETT_IDONEA,D_FLG_COIB_IDONEA,D_FLG_ASSENZA_PERDITE,F_FLG_VALVOLE_TERMOST,F_FLG_VERIFICA_PARAM,F_FLG_PERDITE_H2O,F_FLG_INSTALL_INVOLUCRO,C_FLG_TRATT_CLIMA_NON_RICHIEST,C_FLG_TRATT_ACS_NON_RICHIESTO ) VALUES (  :ID_ALLEGATO , :D_FLG_LOCALE_IDONEO , :D_FLG_LINEA_ELETT_IDONEA , :D_FLG_COIB_IDONEA , :D_FLG_ASSENZA_PERDITE , :F_FLG_VALVOLE_TERMOST , :F_FLG_VERIFICA_PARAM , :F_FLG_PERDITE_H2O , :F_FLG_INSTALL_INVOLUCRO , :C_FLG_TRATT_CLIMA_NON_RICHIEST , :C_FLG_TRATT_ACS_NON_RICHIESTO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_LOCALE_IDONEO]
		params.addValue("D_FLG_LOCALE_IDONEO", dto.getDFlgLocaleIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_LINEA_ELETT_IDONEA]
		params.addValue("D_FLG_LINEA_ELETT_IDONEA", dto.getDFlgLineaElettIdonea(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_COIB_IDONEA]
		params.addValue("D_FLG_COIB_IDONEA", dto.getDFlgCoibIdonea(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_ASSENZA_PERDITE]
		params.addValue("D_FLG_ASSENZA_PERDITE", dto.getDFlgAssenzaPerdite(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_VALVOLE_TERMOST]
		params.addValue("F_FLG_VALVOLE_TERMOST", dto.getFFlgValvoleTermost(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_VERIFICA_PARAM]
		params.addValue("F_FLG_VERIFICA_PARAM", dto.getFFlgVerificaParam(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_PERDITE_H2O]
		params.addValue("F_FLG_PERDITE_H2O", dto.getFFlgPerditeH2o(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_INSTALL_INVOLUCRO]
		params.addValue("F_FLG_INSTALL_INVOLUCRO", dto.getFFlgInstallInvolucro(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [C_FLG_TRATT_CLIMA_NON_RICHIEST]
		params.addValue("C_FLG_TRATT_CLIMA_NON_RICHIEST", dto.getCFlgTrattClimaNonRichiest(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [C_FLG_TRATT_ACS_NON_RICHIESTO]
		params.addValue("C_FLG_TRATT_ACS_NON_RICHIESTO", dto.getCFlgTrattAcsNonRichiesto(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTRappTipo3DaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_RAPP_TIPO3 table.
	 * @generated
	 */
	public void update(SigitTRappTipo3Dto dto) throws SigitTRappTipo3DaoException {
		LOG.debug("[SigitTRappTipo3DaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET D_FLG_LOCALE_IDONEO = :D_FLG_LOCALE_IDONEO ,D_FLG_LINEA_ELETT_IDONEA = :D_FLG_LINEA_ELETT_IDONEA ,D_FLG_COIB_IDONEA = :D_FLG_COIB_IDONEA ,D_FLG_ASSENZA_PERDITE = :D_FLG_ASSENZA_PERDITE ,F_FLG_VALVOLE_TERMOST = :F_FLG_VALVOLE_TERMOST ,F_FLG_VERIFICA_PARAM = :F_FLG_VERIFICA_PARAM ,F_FLG_PERDITE_H2O = :F_FLG_PERDITE_H2O ,F_FLG_INSTALL_INVOLUCRO = :F_FLG_INSTALL_INVOLUCRO ,C_FLG_TRATT_CLIMA_NON_RICHIEST = :C_FLG_TRATT_CLIMA_NON_RICHIEST ,C_FLG_TRATT_ACS_NON_RICHIESTO = :C_FLG_TRATT_ACS_NON_RICHIESTO  WHERE ID_ALLEGATO = :ID_ALLEGATO ";

		if (dto.getIdAllegato() == null) {
			LOG.error("[SigitTRappTipo3DaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTRappTipo3DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_LOCALE_IDONEO]
		params.addValue("D_FLG_LOCALE_IDONEO", dto.getDFlgLocaleIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_LINEA_ELETT_IDONEA]
		params.addValue("D_FLG_LINEA_ELETT_IDONEA", dto.getDFlgLineaElettIdonea(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_COIB_IDONEA]
		params.addValue("D_FLG_COIB_IDONEA", dto.getDFlgCoibIdonea(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_ASSENZA_PERDITE]
		params.addValue("D_FLG_ASSENZA_PERDITE", dto.getDFlgAssenzaPerdite(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_VALVOLE_TERMOST]
		params.addValue("F_FLG_VALVOLE_TERMOST", dto.getFFlgValvoleTermost(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_VERIFICA_PARAM]
		params.addValue("F_FLG_VERIFICA_PARAM", dto.getFFlgVerificaParam(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_PERDITE_H2O]
		params.addValue("F_FLG_PERDITE_H2O", dto.getFFlgPerditeH2o(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_INSTALL_INVOLUCRO]
		params.addValue("F_FLG_INSTALL_INVOLUCRO", dto.getFFlgInstallInvolucro(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [C_FLG_TRATT_CLIMA_NON_RICHIEST]
		params.addValue("C_FLG_TRATT_CLIMA_NON_RICHIEST", dto.getCFlgTrattClimaNonRichiest(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [C_FLG_TRATT_ACS_NON_RICHIESTO]
		params.addValue("C_FLG_TRATT_ACS_NON_RICHIESTO", dto.getCFlgTrattAcsNonRichiesto(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTRappTipo3DaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_RAPP_TIPO3 table.
	 * @generated
	 */

	public void delete(SigitTRappTipo3Pk pk) throws SigitTRappTipo3DaoException {
		LOG.debug("[SigitTRappTipo3DaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ";

		if (pk == null) {
			LOG.error("[SigitTRappTipo3DaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTRappTipo3DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTRappTipo3DaoImpl::delete] END");
	}

	protected SigitTRappTipo3DaoRowMapper findAllRowMapper = new SigitTRappTipo3DaoRowMapper(null,
			SigitTRappTipo3Dto.class, this);

	protected SigitTRappTipo3DaoRowMapper findByPrimaryKeyRowMapper = new SigitTRappTipo3DaoRowMapper(null,
			SigitTRappTipo3Dto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_RAPP_TIPO3";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_RAPP_TIPO3.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTRappTipo3Dto> findAll() throws SigitTRappTipo3DaoException {
		LOG.debug("[SigitTRappTipo3DaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,D_FLG_LOCALE_IDONEO,D_FLG_LINEA_ELETT_IDONEA,D_FLG_COIB_IDONEA,D_FLG_ASSENZA_PERDITE,F_FLG_VALVOLE_TERMOST,F_FLG_VERIFICA_PARAM,F_FLG_PERDITE_H2O,F_FLG_INSTALL_INVOLUCRO,C_FLG_TRATT_CLIMA_NON_RICHIEST,C_FLG_TRATT_ACS_NON_RICHIESTO FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTRappTipo3Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTRappTipo3DaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTRappTipo3DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTRappTipo3DaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTRappTipo3DaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_T_RAPP_TIPO3 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTRappTipo3Dto findByPrimaryKey(SigitTRappTipo3Pk pk) throws SigitTRappTipo3DaoException {
		LOG.debug("[SigitTRappTipo3DaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,D_FLG_LOCALE_IDONEO,D_FLG_LINEA_ELETT_IDONEA,D_FLG_COIB_IDONEA,D_FLG_ASSENZA_PERDITE,F_FLG_VALVOLE_TERMOST,F_FLG_VERIFICA_PARAM,F_FLG_PERDITE_H2O,F_FLG_INSTALL_INVOLUCRO,C_FLG_TRATT_CLIMA_NON_RICHIEST,C_FLG_TRATT_ACS_NON_RICHIESTO FROM "
						+ getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		List<SigitTRappTipo3Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTRappTipo3DaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTRappTipo3DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTRappTipo3DaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTRappTipo3DaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
