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

/*PROTECTED REGION ID(R1749835905) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompPo.
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
public class SigitTCompPoDaoImpl extends AbstractDAO implements SigitTCompPoDao {
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
	 * Metodo di inserimento del DAO sigitTCompPo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompPoPk
	 * @generated
	 */

	public SigitTCompPoPk insert(SigitTCompPoDto dto)

	{
		LOG.debug("[SigitTCompPoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FLG_GIRI_VARIABILI,POT_NOMINALE_KW ) VALUES (  :CODICE_IMPIANTO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :FLG_GIRI_VARIABILI , :POT_NOMINALE_KW  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FLG_GIRI_VARIABILI]
		params.addValue("FLG_GIRI_VARIABILI", dto.getFlgGiriVariabili(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [POT_NOMINALE_KW]
		params.addValue("POT_NOMINALE_KW", dto.getPotNominaleKw(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCompPoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_PO table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompPoDaoException {
		LOG.debug("[SigitTCompPoDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-181599476) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompPoDaoImpl::customDeleterByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_PO table.
	 * @generated
	 */
	public void customDeleterByCodImpiantoProgr(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompPoDaoException {
		LOG.debug("[SigitTCompPoDaoImpl::customDeleterByCodImpiantoProgr] START");
		/*PROTECTED REGION ID(R1937030184) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE CODICE_IMPIANTO = :codImpianto AND PROGRESSIVO = :progressivo";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodImpianto(), java.sql.Types.NUMERIC);
		params.addValue("progressivo", filter.getProgressivo(), java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompPoDaoImpl::customDeleterByCodImpiantoProgr] END");
	}

	protected SigitTCompPoDaoRowMapper ByCodImpiantoRowMapper = new SigitTCompPoDaoRowMapper(null,
			SigitTCompPoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_PO";
	}

	/** 
	 * Implementazione del finder ByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompPoDto> findByCodImpianto(Integer input) throws SigitTCompPoDaoException {
		LOG.debug("[SigitTCompPoDaoImpl::findByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FLG_GIRI_VARIABILI,POT_NOMINALE_KW ");
		sql.append(" FROM SIGIT_T_COMP_PO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1755367400) ENABLED START*/

		sql.append("CODICE_IMPIANTO = :codImpianto");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-537621670) ENABLED START*/

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTCompPoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompPoDaoImpl::findByCodImpianto] esecuzione query", ex);
			throw new SigitTCompPoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompPoDaoImpl", "findByCodImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompPoDaoImpl::findByCodImpianto] END");
		}
		return list;
	}

}
