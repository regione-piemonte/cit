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

/*PROTECTED REGION ID(R1888645179) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTLibTxt.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byCodImpianti (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *   - AllByCodImpianto (datagen::CustomDeleter)
 *   - BozzaByCodImpianto (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTLibTxtDaoImpl extends AbstractDAO implements SigitTLibTxtDao {
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
	 * Metodo di inserimento del DAO sigitTLibTxt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTLibTxtPk
	 * @generated
	 */

	public SigitTLibTxtPk insert(SigitTLibTxtDto dto)

	{
		LOG.debug("[SigitTLibTxtDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_LIBRETTO,XML_LIBRETTO ) VALUES (  :ID_LIBRETTO , :XML_LIBRETTO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LIBRETTO]
		params.addValue("ID_LIBRETTO", dto.getIdLibretto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [XML_LIBRETTO]
		params.addValue("XML_LIBRETTO", dto.getXmlLibretto(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTLibTxtDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_LIB_TXT table.
	 * @generated
	 */
	public void update(SigitTLibTxtDto dto) throws SigitTLibTxtDaoException {
		LOG.debug("[SigitTLibTxtDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET XML_LIBRETTO = :XML_LIBRETTO  WHERE ID_LIBRETTO = :ID_LIBRETTO ";

		if (dto.getIdLibretto() == null) {
			LOG.error("[SigitTLibTxtDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTLibTxtDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LIBRETTO]
		params.addValue("ID_LIBRETTO", dto.getIdLibretto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [XML_LIBRETTO]
		params.addValue("XML_LIBRETTO", dto.getXmlLibretto(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTLibTxtDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_LIB_TXT table.
	 * @generated
	 */

	public void delete(SigitTLibTxtPk pk) throws SigitTLibTxtDaoException {
		LOG.debug("[SigitTLibTxtDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_LIBRETTO = :ID_LIBRETTO ";

		if (pk == null) {
			LOG.error("[SigitTLibTxtDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTLibTxtDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LIBRETTO]
		params.addValue("ID_LIBRETTO", pk.getIdLibretto(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTLibTxtDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_LIB_TXT table.
	 * @generated
	 */
	public void customDeleterAllByCodImpianto(java.math.BigDecimal filter) throws SigitTLibTxtDaoException {
		LOG.debug("[SigitTLibTxtDaoImpl::customDeleterAllByCodImpianto] START");
		/*PROTECTED REGION ID(R276523512) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " a WHERE EXISTS (select 1 from sigit_t_libretto where codice_impianto = :codImpianto and a.id_libretto = id_libretto)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTLibTxtDaoImpl::customDeleterAllByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_LIB_TXT table.
	 * @generated
	 */
	public void customDeleterBozzaByCodImpianto(java.math.BigDecimal filter) throws SigitTLibTxtDaoException {
		LOG.debug("[SigitTLibTxtDaoImpl::customDeleterBozzaByCodImpianto] START");
		/*PROTECTED REGION ID(R349704203) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " a WHERE EXISTS ("
				+ "select 1 from sigit_t_libretto where codice_impianto = :codImpianto and fk_stato = 1 and a.id_libretto = id_libretto)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTLibTxtDaoImpl::customDeleterBozzaByCodImpianto] END");
	}

	protected SigitTLibTxtDaoRowMapper findByPrimaryKeyRowMapper = new SigitTLibTxtDaoRowMapper(null,
			SigitTLibTxtDto.class, this);

	protected SigitTLibTxtDaoRowMapper byCodImpiantiRowMapper = new SigitTLibTxtDaoRowMapper(null,
			SigitTLibTxtByCodImpiantiDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_LIB_TXT";
	}

	/** 
	 * Returns all rows from the SIGIT_T_LIB_TXT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTLibTxtDto findByPrimaryKey(SigitTLibTxtPk pk) throws SigitTLibTxtDaoException {
		LOG.debug("[SigitTLibTxtDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_LIBRETTO,XML_LIBRETTO FROM " + getTableName() + " WHERE ID_LIBRETTO = :ID_LIBRETTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LIBRETTO]
		params.addValue("ID_LIBRETTO", pk.getIdLibretto(), java.sql.Types.NUMERIC);

		List<SigitTLibTxtDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTLibTxtDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTLibTxtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTLibTxtDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTLibTxtDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
		 * Implementazione del finder byCodImpianti con Qdef
		 * @generated
		 */

	public List<SigitTLibTxtByCodImpiantiDto> findByCodImpianti(java.lang.String input)
			throws SigitTLibTxtDaoException {
		LOG.debug("[SigitTLibTxtDaoImpl::findByCodImpianti] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT lib.CODICE_IMPIANTO, txt.XML_LIBRETTO");

		sql.append(" FROM SIGIT_T_LIB_TXT txt, SIGIT_T_LIBRETTO lib");

		sql.append(" WHERE ");

		sql.append("txt.ID_LIBRETTO = lib.ID_LIBRETTO");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R-1802865669) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND lib.ID_LIBRETTO IN ");
		sql.append(" (SELECT MAX(lib.ID_LIBRETTO) ");
		sql.append(" FROM SIGIT_T_LIBRETTO lib ");
		sql.append(" WHERE CODICE_IMPIANTO IN (" + input + ") ");
		sql.append(" AND FK_MOTIVO_CONSOLID = 1 ");
		sql.append(" GROUP BY lib.CODICE_IMPIANTO) ");

		/*PROTECTED REGION END*/

		List<SigitTLibTxtByCodImpiantiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpiantiRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTLibTxtDaoImpl::findByCodImpianti] ERROR esecuzione query", ex);
			throw new SigitTLibTxtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTLibTxtDaoImpl", "findByCodImpianti", "esecuzione query", sql.toString());
			LOG.debug("[SigitTLibTxtDaoImpl::findByCodImpianti] END");
		}
		return list;
	}

}
