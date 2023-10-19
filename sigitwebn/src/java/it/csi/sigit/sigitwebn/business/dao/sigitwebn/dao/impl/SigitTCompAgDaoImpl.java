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

/*PROTECTED REGION ID(R-969777521) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;

/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompAg.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - componentiCancellate (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *   - byCodImpianto (datagen::CustomDeleter)
 *   - byFilter (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTCompAgDaoImpl extends AbstractDAO implements SigitTCompAgDao {
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
	 * Metodo di inserimento del DAO sigitTCompAg. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompAgPk
	 * @generated
	 */

	public SigitTCompAgPk insert(SigitTCompAgDto dto)

	{
		LOG.debug("[SigitTCompAgDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,MATRICOLA,MODELLO,POTENZA_TERMICA_KW ) VALUES (  :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :CODICE_IMPIANTO , :TIPOLOGIA , :DATA_DISMISS , :FLG_DISMISSIONE , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :FK_MARCA , :MATRICOLA , :MODELLO , :POTENZA_TERMICA_KW  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA]
		params.addValue("TIPOLOGIA", dto.getTipologia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_DISMISS]
		params.addValue("DATA_DISMISS", dto.getDataDismiss(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FLG_DISMISSIONE]
		params.addValue("FLG_DISMISSIONE", dto.getFlgDismissione(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_MARCA]
		params.addValue("FK_MARCA", dto.getFkMarca(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MATRICOLA]
		params.addValue("MATRICOLA", dto.getMatricola(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MODELLO]
		params.addValue("MODELLO", dto.getModello(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POTENZA_TERMICA_KW]
		params.addValue("POTENZA_TERMICA_KW", dto.getPotenzaTermicaKw(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCompAgDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_COMP_AG table.
	 * @generated
	 */
	public void update(SigitTCompAgDto dto) throws SigitTCompAgDaoException {
		LOG.debug("[SigitTCompAgDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET TIPOLOGIA = :TIPOLOGIA ,DATA_DISMISS = :DATA_DISMISS ,FLG_DISMISSIONE = :FLG_DISMISSIONE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,FK_MARCA = :FK_MARCA ,MATRICOLA = :MATRICOLA ,MODELLO = :MODELLO ,POTENZA_TERMICA_KW = :POTENZA_TERMICA_KW  WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND DATA_INSTALL = :DATA_INSTALL  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (dto.getIdTipoComponente() == null || dto.getProgressivo() == null || dto.getDataInstall() == null
				|| dto.getCodiceImpianto() == null) {
			LOG.error("[SigitTCompAgDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTCompAgDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA]
		params.addValue("TIPOLOGIA", dto.getTipologia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_DISMISS]
		params.addValue("DATA_DISMISS", dto.getDataDismiss(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FLG_DISMISSIONE]
		params.addValue("FLG_DISMISSIONE", dto.getFlgDismissione(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_MARCA]
		params.addValue("FK_MARCA", dto.getFkMarca(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MATRICOLA]
		params.addValue("MATRICOLA", dto.getMatricola(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MODELLO]
		params.addValue("MODELLO", dto.getModello(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POTENZA_TERMICA_KW]
		params.addValue("POTENZA_TERMICA_KW", dto.getPotenzaTermicaKw(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompAgDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_COMP_AG table.
	 * @generated
	 */

	public void delete(SigitTCompAgPk pk) throws SigitTCompAgDaoException {
		LOG.debug("[SigitTCompAgDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND DATA_INSTALL = :DATA_INSTALL  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (pk == null) {
			LOG.error("[SigitTCompAgDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTCompAgDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", pk.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", pk.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompAgDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_AG table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTCompAgDaoException {
		LOG.debug("[SigitTCompAgDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R1598513267) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompAgDaoImpl::customDeleterByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_AG table.
	 * @generated
	 */
	public void customDeleterByFilter(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompAgDaoException {
		LOG.debug("[SigitTCompAgDaoImpl::customDeleterByFilter] START");
		/*PROTECTED REGION ID(R1020530052) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";
		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("ID_TIPO_COMPONENTE", filter.getTipoComponente(), java.sql.Types.VARCHAR);

		params.addValue("PROGRESSIVO", filter.getProgressivo(), java.sql.Types.NUMERIC);

		params.addValue("CODICE_IMPIANTO", filter.getCodImpianto(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompAgDaoImpl::customDeleterByFilter] END");
	}

	protected SigitTCompAgDaoRowMapper findByPrimaryKeyRowMapper = new SigitTCompAgDaoRowMapper(null,
			SigitTCompAgDto.class, this);

	protected SigitTCompAgDaoRowMapper componentiCancellateRowMapper = new SigitTCompAgDaoRowMapper(null,
			SigitTCompAgDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_AG";
	}

	/** 
	 * Returns all rows from the SIGIT_T_COMP_AG table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompAgDto findByPrimaryKey(SigitTCompAgPk pk) throws SigitTCompAgDaoException {
		LOG.debug("[SigitTCompAgDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,MATRICOLA,MODELLO,POTENZA_TERMICA_KW FROM "
						+ getTableName()
						+ " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND DATA_INSTALL = :DATA_INSTALL  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", pk.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", pk.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		List<SigitTCompAgDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompAgDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTCompAgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompAgDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompAgDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder componentiCancellate
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompAgDto> findComponentiCancellate(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTCompAgDaoException {
		LOG.debug("[SigitTCompAgDaoImpl::findComponentiCancellate] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,MATRICOLA,MODELLO,POTENZA_TERMICA_KW ");
		sql.append(" FROM SIGIT_T_COMP_AG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1824331699) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("CODICE_IMPIANTO = :codImpianto");

		sql.append(" AND ID_TIPO_COMPONENTE = :tipoComponente");

		if (GenericUtil.isNotNullOrEmpty(input.getProgressivo()))
			sql.append(" AND PROGRESSIVO = :progressivo");

		if (input.getListDateInstallazione() != null && !input.getListDateInstallazione().isEmpty()) {
			sql.append(" AND TO_CHAR(DATA_INSTALL,'DD/MM/YYYY') NOT IN  (");
			boolean aggVirg = false;
			for (String data : input.getListDateInstallazione()) {
				if (aggVirg)
					sql.append(", ");
				sql.append(" '" + data + "'");
				aggVirg = true;
			}
			sql.append(") ");
		}

		if (input.getListProgressivi() != null && !input.getListProgressivi().isEmpty()) {
			sql.append(" AND PROGRESSIVO NOT IN  (");
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
		/*PROTECTED REGION ID(R160855957) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("tipoComponente", input.getTipoComponente(), java.sql.Types.VARCHAR);
		paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTCompAgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, componentiCancellateRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompAgDaoImpl::findComponentiCancellate] esecuzione query", ex);
			throw new SigitTCompAgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompAgDaoImpl", "findComponentiCancellate", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTCompAgDaoImpl::findComponentiCancellate] END");
		}
		return list;
	}

}
