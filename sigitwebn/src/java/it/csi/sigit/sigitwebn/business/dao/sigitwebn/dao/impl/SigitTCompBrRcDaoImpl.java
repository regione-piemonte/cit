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

/*PROTECTED REGION ID(R831956741) ENABLED START*/
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompBrRc.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byFilter (datagen::CustomFinder)
 *   - BrRcLegateAGt (datagen::CustomFinder)
 *   - byTipoAndCodImpiantoOrdered (datagen::CustomFinder)
 *   - findAll (datagen::FindAll)
 *   - BrRcLegateAGtComplex (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *   - byCodImpianto (datagen::CustomDeleter)
 *   - byFilterComp (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTCompBrRcDaoImpl extends AbstractDAO implements SigitTCompBrRcDao {
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
	 * Metodo di inserimento del DAO sigitTCompBrRc. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompBrRcPk
	 * @generated
	 */

	public SigitTCompBrRcPk insert(SigitTCompBrRcDto dto)

	{
		LOG.debug("[SigitTCompBrRcDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_COMP_BR_RC,TIPOLOGIA_BR_RC,PROGRESSIVO_BR_RC,FK_TIPO_COMPONENTE,FK_PROGRESSIVO,FK_DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,POT_TERM_MAX_KW,POT_TERM_MIN_KW,DATA_INSTALL,DATA_DISMISS,FK_MARCA,MODELLO,MATRICOLA,FK_COMBUSTIBILE,FLG_DISMISSIONE ) VALUES (  :ID_COMP_BR_RC , :TIPOLOGIA_BR_RC , :PROGRESSIVO_BR_RC , :FK_TIPO_COMPONENTE , :FK_PROGRESSIVO , :FK_DATA_INSTALL , :CODICE_IMPIANTO , :TIPOLOGIA , :POT_TERM_MAX_KW , :POT_TERM_MIN_KW , :DATA_INSTALL , :DATA_DISMISS , :FK_MARCA , :MODELLO , :MATRICOLA , :FK_COMBUSTIBILE , :FLG_DISMISSIONE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_COMP_BR_RC]
		params.addValue("ID_COMP_BR_RC", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA_BR_RC]
		params.addValue("TIPOLOGIA_BR_RC", dto.getTipologiaBrRc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO_BR_RC]
		params.addValue("PROGRESSIVO_BR_RC", dto.getProgressivoBrRc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_COMPONENTE]
		params.addValue("FK_TIPO_COMPONENTE", dto.getFkTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_PROGRESSIVO]
		params.addValue("FK_PROGRESSIVO", dto.getFkProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_DATA_INSTALL]
		params.addValue("FK_DATA_INSTALL", dto.getFkDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA]
		params.addValue("TIPOLOGIA", dto.getTipologia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POT_TERM_MAX_KW]
		params.addValue("POT_TERM_MAX_KW", dto.getPotTermMaxKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [POT_TERM_MIN_KW]
		params.addValue("POT_TERM_MIN_KW", dto.getPotTermMinKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_DISMISS]
		params.addValue("DATA_DISMISS", dto.getDataDismiss(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_MARCA]
		params.addValue("FK_MARCA", dto.getFkMarca(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MODELLO]
		params.addValue("MODELLO", dto.getModello(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MATRICOLA]
		params.addValue("MATRICOLA", dto.getMatricola(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_COMBUSTIBILE]
		params.addValue("FK_COMBUSTIBILE", dto.getFkCombustibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_DISMISSIONE]
		params.addValue("FLG_DISMISSIONE", dto.getFlgDismissione(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdCompBrRc(newKey);
		LOG.debug("[SigitTCompBrRcDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_COMP_BR_RC table.
	 * @generated
	 */
	public void update(SigitTCompBrRcDto dto) throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET TIPOLOGIA_BR_RC = :TIPOLOGIA_BR_RC ,PROGRESSIVO_BR_RC = :PROGRESSIVO_BR_RC ,FK_TIPO_COMPONENTE = :FK_TIPO_COMPONENTE ,FK_PROGRESSIVO = :FK_PROGRESSIVO ,FK_DATA_INSTALL = :FK_DATA_INSTALL ,CODICE_IMPIANTO = :CODICE_IMPIANTO ,TIPOLOGIA = :TIPOLOGIA ,POT_TERM_MAX_KW = :POT_TERM_MAX_KW ,POT_TERM_MIN_KW = :POT_TERM_MIN_KW ,DATA_INSTALL = :DATA_INSTALL ,DATA_DISMISS = :DATA_DISMISS ,FK_MARCA = :FK_MARCA ,MODELLO = :MODELLO ,MATRICOLA = :MATRICOLA ,FK_COMBUSTIBILE = :FK_COMBUSTIBILE ,FLG_DISMISSIONE = :FLG_DISMISSIONE  WHERE ID_COMP_BR_RC = :ID_COMP_BR_RC ";

		if (dto.getIdCompBrRc() == null) {
			LOG.error("[SigitTCompBrRcDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTCompBrRcDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_COMP_BR_RC]
		params.addValue("ID_COMP_BR_RC", dto.getIdCompBrRc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA_BR_RC]
		params.addValue("TIPOLOGIA_BR_RC", dto.getTipologiaBrRc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO_BR_RC]
		params.addValue("PROGRESSIVO_BR_RC", dto.getProgressivoBrRc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_COMPONENTE]
		params.addValue("FK_TIPO_COMPONENTE", dto.getFkTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_PROGRESSIVO]
		params.addValue("FK_PROGRESSIVO", dto.getFkProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_DATA_INSTALL]
		params.addValue("FK_DATA_INSTALL", dto.getFkDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA]
		params.addValue("TIPOLOGIA", dto.getTipologia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POT_TERM_MAX_KW]
		params.addValue("POT_TERM_MAX_KW", dto.getPotTermMaxKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [POT_TERM_MIN_KW]
		params.addValue("POT_TERM_MIN_KW", dto.getPotTermMinKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_DISMISS]
		params.addValue("DATA_DISMISS", dto.getDataDismiss(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_MARCA]
		params.addValue("FK_MARCA", dto.getFkMarca(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MODELLO]
		params.addValue("MODELLO", dto.getModello(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MATRICOLA]
		params.addValue("MATRICOLA", dto.getMatricola(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_COMBUSTIBILE]
		params.addValue("FK_COMBUSTIBILE", dto.getFkCombustibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_DISMISSIONE]
		params.addValue("FLG_DISMISSIONE", dto.getFlgDismissione(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompBrRcDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_COMP_BR_RC table.
	 * @generated
	 */

	public void delete(SigitTCompBrRcPk pk) throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_COMP_BR_RC = :ID_COMP_BR_RC ";

		if (pk == null) {
			LOG.error("[SigitTCompBrRcDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTCompBrRcDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_COMP_BR_RC]
		params.addValue("ID_COMP_BR_RC", pk.getIdCompBrRc(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompBrRcDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_BR_RC table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-1764517138) ENABLED START*/

		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompBrRcDaoImpl::customDeleterByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_BR_RC table.
	 * @generated
	 */
	public void customDeleterByFilterComp(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::customDeleterByFilterComp] START");
		/*PROTECTED REGION ID(R1896567386) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE TIPOLOGIA_BR_RC = :TIPO_COMPONENTE  AND PROGRESSIVO_BR_RC = :PROGRESSIVO  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";
		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("TIPO_COMPONENTE", filter.getTipoComponente(), java.sql.Types.VARCHAR);

		params.addValue("PROGRESSIVO", filter.getProgressivo(), java.sql.Types.NUMERIC);

		params.addValue("CODICE_IMPIANTO", filter.getCodImpianto(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompBrRcDaoImpl::customDeleterByFilterComp] END");
	}

	protected SigitTCompBrRcDaoRowMapper findByPrimaryKeyRowMapper = new SigitTCompBrRcDaoRowMapper(null,
			SigitTCompBrRcDto.class, this);

	protected SigitTCompBrRcDaoRowMapper byFilterRowMapper = new SigitTCompBrRcDaoRowMapper(null,
			SigitTCompBrRcDto.class, this);

	protected SigitTCompBrRcDaoRowMapper BrRcLegateAGtRowMapper = new SigitTCompBrRcDaoRowMapper(null,
			SigitTCompBrRcDto.class, this);

	protected SigitTCompBrRcDaoRowMapper byTipoAndCodImpiantoOrderedRowMapper = new SigitTCompBrRcDaoRowMapper(null,
			SigitTCompBrRcDto.class, this);

	protected SigitTCompBrRcDaoRowMapper findAllRowMapper = new SigitTCompBrRcDaoRowMapper(null,
			SigitTCompBrRcDto.class, this);

	protected SigitTCompBrRcDaoRowMapper BrRcLegateAGtComplexRowMapper = new SigitTCompBrRcDaoRowMapper(null,
			SigitTCompBrRcBrRcLegateAGtComplexDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_BR_RC";
	}

	/** 
	 * Returns all rows from the SIGIT_T_COMP_BR_RC table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompBrRcDto findByPrimaryKey(SigitTCompBrRcPk pk) throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_COMP_BR_RC,TIPOLOGIA_BR_RC,PROGRESSIVO_BR_RC,FK_TIPO_COMPONENTE,FK_PROGRESSIVO,FK_DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,POT_TERM_MAX_KW,POT_TERM_MIN_KW,DATA_INSTALL,DATA_DISMISS,FK_MARCA,MODELLO,MATRICOLA,FK_COMBUSTIBILE,FLG_DISMISSIONE FROM "
						+ getTableName() + " WHERE ID_COMP_BR_RC = :ID_COMP_BR_RC ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_COMP_BR_RC]
		params.addValue("ID_COMP_BR_RC", pk.getIdCompBrRc(), java.sql.Types.NUMERIC);

		List<SigitTCompBrRcDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompBrRcDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTCompBrRcDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompBrRcDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompBrRcDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompBrRcDto> findByFilter(SigitTCompBrRcDto input) throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_COMP_BR_RC,TIPOLOGIA_BR_RC,PROGRESSIVO_BR_RC,FK_TIPO_COMPONENTE,FK_PROGRESSIVO,FK_DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,POT_TERM_MAX_KW,POT_TERM_MIN_KW,DATA_INSTALL,DATA_DISMISS,FK_MARCA,MODELLO,MATRICOLA,FK_COMBUSTIBILE,FLG_DISMISSIONE ");
		sql.append(" FROM SIGIT_T_COMP_BR_RC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2024314923) ENABLED START*/

		sql.append(" 1 = 1 ");
		sql.append(" AND CODICE_IMPIANTO = :codiceImpianto");
		sql.append(" AND TIPOLOGIA_BR_RC = :tipoBrRc");
		sql.append(" AND PROGRESSIVO_BR_RC = :progressivoBrRc");
		sql.append(" AND FK_TIPO_COMPONENTE = :fkTipoComponente");
		sql.append(" AND FK_PROGRESSIVO = :fkProgressivo");
		sql.append(" AND FK_DATA_INSTALL = :fkDataInstall");
		sql.append(" AND DATA_INSTALL = :dataInstall");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-790183049) ENABLED START*/

		paramMap.addValue("codiceImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("tipoBrRc", input.getTipologiaBrRc());
		paramMap.addValue("progressivoBrRc", input.getProgressivoBrRc(), java.sql.Types.NUMERIC);
		paramMap.addValue("fkTipoComponente", input.getFkTipoComponente());
		paramMap.addValue("fkProgressivo", input.getFkProgressivo(), java.sql.Types.NUMERIC);
		paramMap.addValue("fkDataInstall", input.getFkDataInstall(), java.sql.Types.DATE);
		paramMap.addValue("dataInstall", input.getDataInstall(), java.sql.Types.DATE);

		/*PROTECTED REGION END*/
		List<SigitTCompBrRcDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompBrRcDaoImpl::findByFilter] esecuzione query", ex);
			throw new SigitTCompBrRcDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompBrRcDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompBrRcDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder BrRcLegateAGt
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompBrRcDto> findBrRcLegateAGt(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::findBrRcLegateAGt] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_COMP_BR_RC,TIPOLOGIA_BR_RC,PROGRESSIVO_BR_RC,FK_TIPO_COMPONENTE,FK_PROGRESSIVO,FK_DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,POT_TERM_MAX_KW,POT_TERM_MIN_KW,DATA_INSTALL,DATA_DISMISS,FK_MARCA,MODELLO,MATRICOLA,FK_COMBUSTIBILE,FLG_DISMISSIONE ");
		sql.append(" FROM SIGIT_T_COMP_BR_RC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-778120343) ENABLED START*/
		sql.append(" 1 = 1 ");

		if (input.getCodImpianto() != null) {
			sql.append(" AND CODICE_IMPIANTO = :codiceImpianto ");
		}

		sql.append(" AND FK_TIPO_COMPONENTE = 'GT' ");

		if (input.getDataInstallazione() != null) {
			sql.append(" AND FK_DATA_INSTALL = :dataInstallazione ");
		}

		if (input.getProgressivo() != null) {
			sql.append(" AND FK_PROGRESSIVO = :progressivo ");
		}
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1766330375) ENABLED START*/

		if (input.getCodImpianto() != null) {
			paramMap.addValue("codiceImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		}

		if (input.getDataInstallazione() != null) {
			paramMap.addValue("dataInstallazione", input.getDataInstallazione(), java.sql.Types.DATE);
		}

		if (input.getProgressivo() != null) {
			paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		}

		/*PROTECTED REGION END*/
		List<SigitTCompBrRcDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, BrRcLegateAGtRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompBrRcDaoImpl::findBrRcLegateAGt] esecuzione query", ex);
			throw new SigitTCompBrRcDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompBrRcDaoImpl", "findBrRcLegateAGt", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompBrRcDaoImpl::findBrRcLegateAGt] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byTipoAndCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompBrRcDto> findByTipoAndCodImpiantoOrdered(SigitTCompBrRcDto input)
			throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::findByTipoAndCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_COMP_BR_RC,TIPOLOGIA_BR_RC,PROGRESSIVO_BR_RC,FK_TIPO_COMPONENTE,FK_PROGRESSIVO,FK_DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,POT_TERM_MAX_KW,POT_TERM_MIN_KW,DATA_INSTALL,DATA_DISMISS,FK_MARCA,MODELLO,MATRICOLA,FK_COMBUSTIBILE,FLG_DISMISSIONE ");
		sql.append(" FROM SIGIT_T_COMP_BR_RC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2026654588) ENABLED START*/

		sql.append(" 1 = 1 ");
		if (input.getTipologiaBrRc() != null) {
			sql.append(" AND TIPOLOGIA_BR_RC = :tipoBrRc");
		}

		if (input.getProgressivoBrRc() != null) {
			sql.append(" AND PROGRESSIVO_BR_RC = :progressivo");
		}

		sql.append(" AND CODICE_IMPIANTO = :codImpianto");
		sql.append(" ORDER BY PROGRESSIVO_BR_RC ASC, DATA_INSTALL DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-717653434) ENABLED START*/

		if (input.getTipologiaBrRc() != null) {
			paramMap.addValue("tipoBrRc", input.getTipologiaBrRc(), java.sql.Types.VARCHAR);
		}
		if (input.getProgressivoBrRc() != null) {
			paramMap.addValue("progressivo", input.getProgressivoBrRc(), java.sql.Types.NUMERIC);
		}
		paramMap.addValue("codImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTCompBrRcDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byTipoAndCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompBrRcDaoImpl::findByTipoAndCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitTCompBrRcDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompBrRcDaoImpl", "findByTipoAndCodImpiantoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTCompBrRcDaoImpl::findByTipoAndCodImpiantoOrdered] END");
		}
		return list;
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_COMP_BR_RC.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompBrRcDto> findAll() throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_COMP_BR_RC,TIPOLOGIA_BR_RC,PROGRESSIVO_BR_RC,FK_TIPO_COMPONENTE,FK_PROGRESSIVO,FK_DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,POT_TERM_MAX_KW,POT_TERM_MIN_KW,DATA_INSTALL,DATA_DISMISS,FK_MARCA,MODELLO,MATRICOLA,FK_COMBUSTIBILE,FLG_DISMISSIONE FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTCompBrRcDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompBrRcDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTCompBrRcDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompBrRcDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompBrRcDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder BrRcLegateAGtComplex con Qdef
		 * @generated
		 */

	public List<SigitTCompBrRcBrRcLegateAGtComplexDto> findBrRcLegateAGtComplex(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::findBrRcLegateAGtComplex] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_COMP_BR_RC, TIPOLOGIA_BR_RC, PROGRESSIVO_BR_RC, FK_TIPO_COMPONENTE, FK_PROGRESSIVO, FK_DATA_INSTALL, CODICE_IMPIANTO, MODELLO, MATRICOLA, ID_MARCA, DES_MARCA");

		sql.append(" FROM SIGIT_T_COMP_BR_RC, SIGIT_D_MARCA");

		sql.append(" WHERE ");

		sql.append("FK_MARCA = ID_MARCA");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R1526394083) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		if (input.getCodImpianto() != null) {
			sql.append(" AND CODICE_IMPIANTO = :codiceImpianto ");
			paramMap.addValue("codiceImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		}

		sql.append(" AND FK_TIPO_COMPONENTE = 'GT' ");

		if (input.getDataInstallazione() != null) {
			sql.append(" AND FK_DATA_INSTALL = :dataInstallazione ");
			paramMap.addValue("dataInstallazione", input.getDataInstallazione(), java.sql.Types.DATE);
		}

		if (input.getProgressivo() != null) {
			sql.append(" AND FK_PROGRESSIVO = :progressivo ");
			paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getTipoComponente())) {
			sql.append(" AND TIPOLOGIA_BR_RC = :tipoComponente ");
			paramMap.addValue("tipoComponente", input.getTipoComponente());
		}

		if (input.getDataControllo() != null) {
			sql.append(" AND :dataControllo BETWEEN DATA_INSTALL AND COALESCE(DATA_DISMISS, CURRENT_DATE) ");
			paramMap.addValue("dataControllo", input.getDataControllo(), java.sql.Types.DATE);
		}

		/*PROTECTED REGION END*/

		List<SigitTCompBrRcBrRcLegateAGtComplexDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, BrRcLegateAGtComplexRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompBrRcDaoImpl::findBrRcLegateAGtComplex] ERROR esecuzione query", ex);
			throw new SigitTCompBrRcDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompBrRcDaoImpl", "findBrRcLegateAGtComplex", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTCompBrRcDaoImpl::findBrRcLegateAGtComplex] END");
		}
		return list;
	}

}
