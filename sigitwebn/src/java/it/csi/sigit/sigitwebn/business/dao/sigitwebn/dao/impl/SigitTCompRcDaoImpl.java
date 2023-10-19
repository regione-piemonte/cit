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

/*PROTECTED REGION ID(R2109963621) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompRc.
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
public class SigitTCompRcDaoImpl extends AbstractDAO implements SigitTCompRcDao {
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
	 * Metodo di inserimento del DAO sigitTCompRc. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompRcPk
	 * @generated
	 */

	public SigitTCompRcPk insert(SigitTCompRcDto dto)

	{
		LOG.debug("[SigitTCompRcDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,TIPOLOGIA,FLG_INSTALLATO,FLG_INDIPENDENTE,PORTATA_MANDATA_LS,PORTATA_RIPRESA_LS,POTENZA_MANDATA_KW,POTENZA_RIPRESA_KW ) VALUES (  :CODICE_IMPIANTO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :TIPOLOGIA , :FLG_INSTALLATO , :FLG_INDIPENDENTE , :PORTATA_MANDATA_LS , :PORTATA_RIPRESA_LS , :POTENZA_MANDATA_KW , :POTENZA_RIPRESA_KW  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA]
		params.addValue("TIPOLOGIA", dto.getTipologia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_INSTALLATO]
		params.addValue("FLG_INSTALLATO", dto.getFlgInstallato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_INDIPENDENTE]
		params.addValue("FLG_INDIPENDENTE", dto.getFlgIndipendente(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [PORTATA_MANDATA_LS]
		params.addValue("PORTATA_MANDATA_LS", dto.getPortataMandataLs(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [PORTATA_RIPRESA_LS]
		params.addValue("PORTATA_RIPRESA_LS", dto.getPortataRipresaLs(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [POTENZA_MANDATA_KW]
		params.addValue("POTENZA_MANDATA_KW", dto.getPotenzaMandataKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [POTENZA_RIPRESA_KW]
		params.addValue("POTENZA_RIPRESA_KW", dto.getPotenzaRipresaKw(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCompRcDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_RC table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompRcDaoException {
		LOG.debug("[SigitTCompRcDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-1141594946) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompRcDaoImpl::customDeleterByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_RC table.
	 * @generated
	 */
	public void customDeleterByCodImpiantoProgr(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompRcDaoException {
		LOG.debug("[SigitTCompRcDaoImpl::customDeleterByCodImpiantoProgr] START");
		/*PROTECTED REGION ID(R-1123526218) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE CODICE_IMPIANTO = :codImpianto AND PROGRESSIVO = :progressivo";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodImpianto(), java.sql.Types.NUMERIC);
		params.addValue("progressivo", filter.getProgressivo(), java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompRcDaoImpl::customDeleterByCodImpiantoProgr] END");
	}

	protected SigitTCompRcDaoRowMapper ByCodImpiantoRowMapper = new SigitTCompRcDaoRowMapper(null,
			SigitTCompRcDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_RC";
	}

	/** 
	 * Implementazione del finder ByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompRcDto> findByCodImpianto(Integer input) throws SigitTCompRcDaoException {
		LOG.debug("[SigitTCompRcDaoImpl::findByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,TIPOLOGIA,FLG_INSTALLATO,FLG_INDIPENDENTE,PORTATA_MANDATA_LS,PORTATA_RIPRESA_LS,POTENZA_MANDATA_KW,POTENZA_RIPRESA_KW ");
		sql.append(" FROM SIGIT_T_COMP_RC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1490359798) ENABLED START*/

		sql.append("CODICE_IMPIANTO = :codImpianto");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-162922740) ENABLED START*/

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTCompRcDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompRcDaoImpl::findByCodImpianto] esecuzione query", ex);
			throw new SigitTCompRcDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompRcDaoImpl", "findByCodImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompRcDaoImpl::findByCodImpianto] END");
		}
		return list;
	}

}
