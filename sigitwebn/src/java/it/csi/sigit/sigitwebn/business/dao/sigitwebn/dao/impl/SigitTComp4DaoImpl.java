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

/*PROTECTED REGION ID(R-139895697) ENABLED START*/
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTComp4.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - componentiCancellate (datagen::CustomFinder)
 *   - byFilter (datagen::CustomFinder)
 *   - nonControllateByCodImp (datagen::CustomFinder)
 *   - nonControllateByFilter (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *   - byCodImpianto (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTComp4DaoImpl extends AbstractDAO implements SigitTComp4Dao {
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
	 * Metodo di inserimento del DAO sigitTComp4. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTComp4Pk
	 * @generated
	 */

	public SigitTComp4Pk insert(SigitTComp4Dto dto)

	{
		LOG.debug("[SigitTComp4DaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DT_CONTROLLOWEB ) VALUES (  :CODICE_IMPIANTO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DT_CONTROLLOWEB  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_CONTROLLOWEB]
		params.addValue("DT_CONTROLLOWEB", dto.getDtControlloweb(), java.sql.Types.TIMESTAMP);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTComp4DaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_COMP4 table.
	 * @generated
	 */
	public void update(SigitTComp4Dto dto) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DT_CONTROLLOWEB = :DT_CONTROLLOWEB  WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO  AND ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO ";

		if (dto.getCodiceImpianto() == null || dto.getIdTipoComponente() == null || dto.getProgressivo() == null) {
			LOG.error("[SigitTComp4DaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTComp4DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_CONTROLLOWEB]
		params.addValue("DT_CONTROLLOWEB", dto.getDtControlloweb(), java.sql.Types.TIMESTAMP);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTComp4DaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_COMP4 table.
	 * @generated
	 */

	public void delete(SigitTComp4Pk pk) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO  AND ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO ";

		if (pk == null) {
			LOG.error("[SigitTComp4DaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTComp4DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", pk.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTComp4DaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP4 table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-1844262065) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTComp4DaoImpl::customDeleterByCodImpianto] END");
	}

	protected SigitTComp4DaoRowMapper findByPrimaryKeyRowMapper = new SigitTComp4DaoRowMapper(null,
			SigitTComp4Dto.class, this);

	protected SigitTComp4DaoRowMapper componentiCancellateRowMapper = new SigitTComp4DaoRowMapper(null,
			SigitTComp4Dto.class, this);

	protected SigitTComp4DaoRowMapper byFilterRowMapper = new SigitTComp4DaoRowMapper(null, SigitTComp4Dto.class, this);

	protected SigitTComp4DaoRowMapper nonControllateByCodImpRowMapper = new SigitTComp4DaoRowMapper(null,
			SigitTComp4Dto.class, this);

	protected SigitTComp4DaoRowMapper nonControllateByFilterRowMapper = new SigitTComp4DaoRowMapper(null,
			SigitTComp4Dto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP4";
	}

	/** 
	 * Returns all rows from the SIGIT_T_COMP4 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTComp4Dto findByPrimaryKey(SigitTComp4Pk pk) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DT_CONTROLLOWEB FROM " + getTableName()
						+ " WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO  AND ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", pk.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.NUMERIC);

		List<SigitTComp4Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTComp4DaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTComp4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTComp4DaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTComp4DaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder componentiCancellate
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTComp4Dto> findComponentiCancellate(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::findComponentiCancellate] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DT_CONTROLLOWEB ");
		sql.append(" FROM SIGIT_T_COMP4");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1589357491) ENABLED START*/

		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND ID_TIPO_COMPONENTE = :tipoComponente");
		if (GenericUtil.isNotNullOrEmpty(input.getProgressivo()))
			sql.append(" AND PROGRESSIVO = :progressivo");

		/*
		if (input.getListDateInstallazione() != null
				&& !input.getListDateInstallazione().isEmpty()) {
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
		 */

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
		/*PROTECTED REGION ID(R-1144878187) ENABLED START*/

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("tipoComponente", input.getTipoComponente(), java.sql.Types.VARCHAR);
		paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTComp4Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, componentiCancellateRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTComp4DaoImpl::findComponentiCancellate] esecuzione query", ex);
			throw new SigitTComp4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTComp4DaoImpl", "findComponentiCancellate", "esecuzione query", sql.toString());
			LOG.debug("[SigitTComp4DaoImpl::findComponentiCancellate] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTComp4Dto> findByFilter(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R772734904) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DT_CONTROLLOWEB ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1773215818) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_COMP4 c");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1082248720) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append(" 1 = 1 ");
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" AND CODICE_IMPIANTO = :codImpianto");

		if (GenericUtil.isNotNullOrEmpty(input.getTipoComponente())) {
			sql.append(" AND ID_TIPO_COMPONENTE = :tipoComp");
		} else if (input.getListTipiComponente() != null && !input.getListTipiComponente().isEmpty()) {
			sql.append(" AND ID_TIPO_COMPONENTE  IN (");
			for (int i = 0; i < input.getListTipiComponente().size(); i++) {
				sql.append("'" + input.getListTipiComponente().get(i) + "'");
				if (i < (input.getListTipiComponente().size() - 1)) {
					sql.append(",");
				}
			}
			sql.append(")");
		}

		if (input.getCheckControllate() != null && input.getCheckControllate()) {
			sql.append(" AND DT_CONTROLLOWEB IS NOT NULL ");
		}

		/*PROTECTED REGION END*/

		sql.append(" ORDER BY "); /*PROTECTED REGION ID(R1690591826) ENABLED START*/
		//***aggiungere tutte le condizioni

		sql.append(" PROGRESSIVO ASC");

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		if (GenericUtil.isNotNullOrEmpty(input.getTipoComponente())) {
			paramMap.addValue("tipoComp", input.getTipoComponente(), java.sql.Types.VARCHAR);
		}

		/*PROTECTED REGION END*/
		List<SigitTComp4Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTComp4DaoImpl::findByFilter] esecuzione query", ex);
			throw new SigitTComp4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTComp4DaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitTComp4DaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder nonControllateByCodImp
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTComp4Dto> findNonControllateByCodImp(java.lang.Integer input) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::findNonControllateByCodImp] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DT_CONTROLLOWEB ");
		sql.append(" FROM SIGIT_T_COMP4");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1799467134) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codImpianto ");
		sql.append(" AND DT_CONTROLLOWEB is null ");
		sql.append(" ORDER BY ID_TIPO_COMPONENTE, PROGRESSIVO");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R931657472) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitTComp4Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, nonControllateByCodImpRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTComp4DaoImpl::findNonControllateByCodImp] esecuzione query", ex);
			throw new SigitTComp4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTComp4DaoImpl", "findNonControllateByCodImp", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTComp4DaoImpl::findNonControllateByCodImp] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder nonControllateByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTComp4Dto> findNonControllateByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::findNonControllateByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DT_CONTROLLOWEB ");
		sql.append(" FROM SIGIT_T_COMP4");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-773535546) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codImpianto ");
		sql.append(" AND ID_TIPO_COMPONENTE = :tipoComponente ");

		if (input.getListProgressivi() != null && !input.getListProgressivi().isEmpty()) {
			// JIRA-604, controllava le apparecchiature non selezionate, invece bisogna controllare solo quelle selezionate 
			//sql.append(" AND PROGRESSIVO NOT IN  (");

			sql.append(" AND PROGRESSIVO IN  (");
			boolean aggVirg = false;
			for (String progr : input.getListProgressivi()) {
				if (aggVirg)
					sql.append(", ");
				sql.append(progr);
				aggVirg = true;
			}
			sql.append(") ");
		}

		sql.append(" AND DT_CONTROLLOWEB is null ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1624201668) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("tipoComponente", input.getTipoComponente(), java.sql.Types.VARCHAR);

		/*PROTECTED REGION END*/
		List<SigitTComp4Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, nonControllateByFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTComp4DaoImpl::findNonControllateByFilter] esecuzione query", ex);
			throw new SigitTComp4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTComp4DaoImpl", "findNonControllateByFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTComp4DaoImpl::findNonControllateByFilter] END");
		}
		return list;
	}

}
