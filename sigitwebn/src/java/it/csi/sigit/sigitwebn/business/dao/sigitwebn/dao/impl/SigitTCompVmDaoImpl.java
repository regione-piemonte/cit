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

/*PROTECTED REGION ID(R1872515057) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompVm.
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
public class SigitTCompVmDaoImpl extends AbstractDAO implements SigitTCompVmDao {
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
	 * Metodo di inserimento del DAO sigitTCompVm. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompVmPk
	 * @generated
	 */

	public SigitTCompVmPk insert(SigitTCompVmDto dto)

	{
		LOG.debug("[SigitTCompVmDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FK_DETTAGLIO_VM,ALTRO_TIPOLOGIA,PORTATA_MAX_ARIA_M3H,RENDIMENTO_COP ) VALUES (  :CODICE_IMPIANTO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :FK_DETTAGLIO_VM , :ALTRO_TIPOLOGIA , :PORTATA_MAX_ARIA_M3H , :RENDIMENTO_COP  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_DETTAGLIO_VM]
		params.addValue("FK_DETTAGLIO_VM", dto.getFkDettaglioVm(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ALTRO_TIPOLOGIA]
		params.addValue("ALTRO_TIPOLOGIA", dto.getAltroTipologia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PORTATA_MAX_ARIA_M3H]
		params.addValue("PORTATA_MAX_ARIA_M3H", dto.getPortataMaxAriaM3h(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [RENDIMENTO_COP]
		params.addValue("RENDIMENTO_COP", dto.getRendimentoCop(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCompVmDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_VM table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompVmDaoException {
		LOG.debug("[SigitTCompVmDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-1137402428) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompVmDaoImpl::customDeleterByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_VM table.
	 * @generated
	 */
	public void customDeleterByCodImpiantoProgr(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompVmDaoException {
		LOG.debug("[SigitTCompVmDaoImpl::customDeleterByCodImpiantoProgr] START");
		/*PROTECTED REGION ID(R-48688016) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE CODICE_IMPIANTO = :codImpianto AND PROGRESSIVO = :progressivo";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodImpianto(), java.sql.Types.NUMERIC);
		params.addValue("progressivo", filter.getProgressivo(), java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompVmDaoImpl::customDeleterByCodImpiantoProgr] END");
	}

	protected SigitTCompVmDaoRowMapper ByCodImpiantoRowMapper = new SigitTCompVmDaoRowMapper(null,
			SigitTCompVmDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_VM";
	}

	/** 
	 * Implementazione del finder ByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompVmDto> findByCodImpianto(Integer input) throws SigitTCompVmDaoException {
		LOG.debug("[SigitTCompVmDaoImpl::findByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FK_DETTAGLIO_VM,ALTRO_TIPOLOGIA,PORTATA_MAX_ARIA_M3H,RENDIMENTO_COP ");
		sql.append(" FROM SIGIT_T_COMP_VM");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1467334192) ENABLED START*/

		sql.append("CODICE_IMPIANTO = :codImpianto");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-876716526) ENABLED START*/

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTCompVmDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompVmDaoImpl::findByCodImpianto] esecuzione query", ex);
			throw new SigitTCompVmDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompVmDaoImpl", "findByCodImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompVmDaoImpl::findByCodImpianto] END");
		}
		return list;
	}

}
