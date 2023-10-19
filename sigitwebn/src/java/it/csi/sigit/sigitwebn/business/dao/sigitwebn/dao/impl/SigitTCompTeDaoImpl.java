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

/*PROTECTED REGION ID(R-1208644123) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompTe.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - ByCodImpianto (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 *   - byCodImpianto (datagen::CustomDeleter)
 *   - byCodImpiantoProgr (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTCompTeDaoImpl extends AbstractDAO implements SigitTCompTeDao {
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
	 * Metodo di inserimento del DAO sigitTCompTe. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompTePk
	 * @generated
	 */

	public SigitTCompTePk insert(SigitTCompTeDto dto)

	{
		LOG.debug("[SigitTCompTeDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CAPACITA_L,NUM_VENTILATORI,TIPO_VENTILATORI ) VALUES (  :CODICE_IMPIANTO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :CAPACITA_L , :NUM_VENTILATORI , :TIPO_VENTILATORI  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CAPACITA_L]
		params.addValue("CAPACITA_L", dto.getCapacitaL(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [NUM_VENTILATORI]
		params.addValue("NUM_VENTILATORI", dto.getNumVentilatori(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TIPO_VENTILATORI]
		params.addValue("TIPO_VENTILATORI", dto.getTipoVentilatori(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCompTeDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_TE table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompTeDaoException {
		LOG.debug("[SigitTCompTeDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R206591230) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompTeDaoImpl::customDeleterByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_TE table.
	 * @generated
	 */
	public void customDeleterByCodImpiantoProgr(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompTeDaoException {
		LOG.debug("[SigitTCompTeDaoImpl::customDeleterByCodImpiantoProgr] START");
		/*PROTECTED REGION ID(R800117110) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE CODICE_IMPIANTO = :codImpianto AND PROGRESSIVO = :progressivo";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodImpianto(), java.sql.Types.NUMERIC);
		params.addValue("progressivo", filter.getProgressivo(), java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompTeDaoImpl::customDeleterByCodImpiantoProgr] END");
	}

	protected SigitTCompTeDaoRowMapper ByCodImpiantoRowMapper = new SigitTCompTeDaoRowMapper(null,
			SigitTCompTeDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_TE";
	}

	/** 
	 * Implementazione del finder ByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompTeDto> findByCodImpianto(Integer input) throws SigitTCompTeDaoException {
		LOG.debug("[SigitTCompTeDaoImpl::findByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CAPACITA_L,NUM_VENTILATORI,TIPO_VENTILATORI ");
		sql.append(" FROM SIGIT_T_COMP_TE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1597629002) ENABLED START*/
		sql.append("CODICE_IMPIANTO = :codImpianto");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1401295028) ENABLED START*/

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTCompTeDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompTeDaoImpl::findByCodImpianto] esecuzione query", ex);
			throw new SigitTCompTeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompTeDaoImpl", "findByCodImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompTeDaoImpl::findByCodImpianto] END");
		}
		return list;
	}

}
