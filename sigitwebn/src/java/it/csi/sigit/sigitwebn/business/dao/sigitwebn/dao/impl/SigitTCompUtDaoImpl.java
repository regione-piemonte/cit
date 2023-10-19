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

/*PROTECTED REGION ID(R2043251137) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompUt.
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
public class SigitTCompUtDaoImpl extends AbstractDAO implements SigitTCompUtDao {
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
	 * Metodo di inserimento del DAO sigitTCompUt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompUtPk
	 * @generated
	 */

	public SigitTCompUtPk insert(SigitTCompUtDto dto)

	{
		LOG.debug("[SigitTCompUtDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,PORTATA_MANDATA_LS,PORTATA_RIPRESA_LS,POTENZA_MANDATA_KW,POTENZA_RIPRESA_KW ) VALUES (  :CODICE_IMPIANTO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :PORTATA_MANDATA_LS , :PORTATA_RIPRESA_LS , :POTENZA_MANDATA_KW , :POTENZA_RIPRESA_KW  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [PORTATA_MANDATA_LS]
		params.addValue("PORTATA_MANDATA_LS", dto.getPortataMandataLs(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [PORTATA_RIPRESA_LS]
		params.addValue("PORTATA_RIPRESA_LS", dto.getPortataRipresaLs(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [POTENZA_MANDATA_KW]
		params.addValue("POTENZA_MANDATA_KW", dto.getPotenzaMandataKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [POTENZA_RIPRESA_KW]
		params.addValue("POTENZA_RIPRESA_KW", dto.getPotenzaRipresaKw(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCompUtDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_UT table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompUtDaoException {
		LOG.debug("[SigitTCompUtDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R1041382316) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompUtDaoImpl::customDeleterByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_UT table.
	 * @generated
	 */
	public void customDeleterByCodImpiantoProgr(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompUtDaoException {
		LOG.debug("[SigitTCompUtDaoImpl::customDeleterByCodImpiantoProgr] START");
		/*PROTECTED REGION ID(R-1843796088) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE CODICE_IMPIANTO = :codImpianto AND PROGRESSIVO = :progressivo";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodImpianto(), java.sql.Types.NUMERIC);
		params.addValue("progressivo", filter.getProgressivo(), java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompUtDaoImpl::customDeleterByCodImpiantoProgr] END");
	}

	protected SigitTCompUtDaoRowMapper ByCodImpiantoRowMapper = new SigitTCompUtDaoRowMapper(null,
			SigitTCompUtDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_UT";
	}

	/** 
	 * Implementazione del finder ByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompUtDto> findByCodImpianto(Integer input) throws SigitTCompUtDaoException {
		LOG.debug("[SigitTCompUtDaoImpl::findByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,PORTATA_MANDATA_LS,PORTATA_RIPRESA_LS,POTENZA_MANDATA_KW,POTENZA_RIPRESA_KW ");
		sql.append(" FROM SIGIT_T_COMP_UT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1669637304) ENABLED START*/
		sql.append("CODICE_IMPIANTO = :codImpianto");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R661414906) ENABLED START*/
		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/
		List<SigitTCompUtDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompUtDaoImpl::findByCodImpianto] esecuzione query", ex);
			throw new SigitTCompUtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompUtDaoImpl", "findByCodImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompUtDaoImpl::findByCodImpianto] END");
		}
		return list;
	}

}
