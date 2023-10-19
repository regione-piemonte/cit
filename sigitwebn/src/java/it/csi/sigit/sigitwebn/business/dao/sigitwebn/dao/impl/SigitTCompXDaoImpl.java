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

/*PROTECTED REGION ID(R267484911) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;

/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompX.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - ByCodImpianto (datagen::CustomFinder)
 *   - byTipoAndCodImpiantoOrdered (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 *   - byFilter (datagen::CustomDeleter)
 *   - byCodImpianto (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTCompXDaoImpl extends AbstractDAO implements SigitTCompXDao {
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
	 * Metodo di inserimento del DAO sigitTCompX. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompXPk
	 * @generated
	 */

	public SigitTCompXPk insert(SigitTCompXDto dto)

	{
		LOG.debug("[SigitTCompXDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,DATA_DISMISS,MATRICOLA,FK_MARCA,MODELLO,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_DISMISSIONE ) VALUES (  :CODICE_IMPIANTO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :DATA_DISMISS , :MATRICOLA , :FK_MARCA , :MODELLO , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :FLG_DISMISSIONE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_DISMISS]
		params.addValue("DATA_DISMISS", dto.getDataDismiss(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [MATRICOLA]
		params.addValue("MATRICOLA", dto.getMatricola(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_MARCA]
		params.addValue("FK_MARCA", dto.getFkMarca(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MODELLO]
		params.addValue("MODELLO", dto.getModello(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_DISMISSIONE]
		params.addValue("FLG_DISMISSIONE", dto.getFlgDismissione(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCompXDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_X table.
	 * @generated
	 */
	public void customDeleterByFilter(SigitTCompXDto filter) throws SigitTCompXDaoException {
		LOG.debug("[SigitTCompXDaoImpl::customDeleterByFilter] START");
		/*PROTECTED REGION ID(R1827557252) ENABLED START*/
		String sql = "DELETE FROM " + getTableName()
				+ " WHERE codice_impianto = :codImpianto AND id_tipo_componente = :tipoComponente";

		MapSqlParameterSource params = new MapSqlParameterSource();

		if (GenericUtil.isNotNullOrEmpty(filter.getProgressivo())) {
			sql += " AND progressivo = :progressivo ";
			params.addValue("progressivo", filter.getProgressivo(), java.sql.Types.NUMERIC);
		}

		params.addValue("codImpianto", filter.getCodiceImpianto(), java.sql.Types.NUMERIC);
		params.addValue("tipoComponente", filter.getIdTipoComponente(), java.sql.Types.VARCHAR);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompXDaoImpl::customDeleterByFilter] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_X table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTCompXDaoException {
		LOG.debug("[SigitTCompXDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-817471885) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompXDaoImpl::customDeleterByCodImpianto] END");
	}

	protected SigitTCompXDaoRowMapper ByCodImpiantoRowMapper = new SigitTCompXDaoRowMapper(null, SigitTCompXDto.class,
			this);

	protected SigitTCompXDaoRowMapper byTipoAndCodImpiantoOrderedRowMapper = new SigitTCompXDaoRowMapper(null,
			SigitTCompXDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_X";
	}

	/** 
	 * Implementazione del finder ByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompXDto> findByCodImpianto(Integer input) throws SigitTCompXDaoException {
		LOG.debug("[SigitTCompXDaoImpl::findByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,DATA_DISMISS,MATRICOLA,FK_MARCA,MODELLO,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_DISMISSIONE ");
		sql.append(" FROM SIGIT_T_COMP_X");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-353955075) ENABLED START*/
		sql.append(" CODICE_IMPIANTO = :codImpianto");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1502108955) ENABLED START*/

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTCompXDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompXDaoImpl::findByCodImpianto] esecuzione query", ex);
			throw new SigitTCompXDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompXDaoImpl", "findByCodImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompXDaoImpl::findByCodImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byTipoAndCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompXDto> findByTipoAndCodImpiantoOrdered(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTCompXDaoException {
		LOG.debug("[SigitTCompXDaoImpl::findByTipoAndCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,DATA_DISMISS,MATRICOLA,FK_MARCA,MODELLO,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_DISMISSIONE ");
		sql.append(" FROM SIGIT_T_COMP_X");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-385954573) ENABLED START*/
		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND ID_TIPO_COMPONENTE = :tipoComp");

		if (input.getProgressivo() != null) {
			sql.append(" AND PROGRESSIVO = :progressivo");
		}

		/*PROTECTED REGION END*/

		sql.append(" ORDER BY "); /*PROTECTED REGION ID(R1800873903) ENABLED START*/
		sql.append(" PROGRESSIVO ASC, DATA_INSTALL DESC");

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("tipoComp", input.getTipoComponente(), java.sql.Types.VARCHAR);

		if (input.getProgressivo() != null) {
			paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		}

		/*PROTECTED REGION END*/
		List<SigitTCompXDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byTipoAndCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompXDaoImpl::findByTipoAndCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitTCompXDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompXDaoImpl", "findByTipoAndCodImpiantoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTCompXDaoImpl::findByTipoAndCodImpiantoOrdered] END");
		}
		return list;
	}

}
