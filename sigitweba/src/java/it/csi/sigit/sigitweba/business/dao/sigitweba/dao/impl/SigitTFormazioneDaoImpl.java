package it.csi.sigit.sigitweba.business.dao.sigitweba.dao.impl;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.mapper.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.qbe.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.metadata.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import it.csi.sigit.sigitweba.business.dao.impl.*;
import it.csi.sigit.sigitweba.business.dao.util.*;
import it.csi.sigit.sigitweba.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R-1922482055) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTFormazione.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - byIdPersona (datagen::CustomFinder)
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTFormazioneDaoImpl extends AbstractDAO implements SigitTFormazioneDao {
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
	 * Metodo di inserimento del DAO sigitTFormazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTFormazionePk
	 * @generated
	 */

	public SigitTFormazionePk insert(SigitTFormazioneDto dto)

	{
		LOG.debug("[SigitTFormazioneDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	DATA_CORSO,ID_PERSONA_FISICA,DES_CORSO ) VALUES (  :DATA_CORSO , :ID_PERSONA_FISICA , :DES_CORSO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_CORSO]
		params.addValue("DATA_CORSO", dto.getDataCorso(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", dto.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DES_CORSO]
		params.addValue("DES_CORSO", dto.getDesCorso(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTFormazioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_FORMAZIONE table.
	 * @generated
	 */
	public void update(SigitTFormazioneDto dto) throws SigitTFormazioneDaoException {
		LOG.debug("[SigitTFormazioneDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DES_CORSO = :DES_CORSO  WHERE DATA_CORSO = :DATA_CORSO  AND ID_PERSONA_FISICA = :ID_PERSONA_FISICA ";

		if (dto.getDataCorso() == null || dto.getIdPersonaFisica() == null) {
			LOG.error("[SigitTFormazioneDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTFormazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_CORSO]
		params.addValue("DATA_CORSO", dto.getDataCorso(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", dto.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DES_CORSO]
		params.addValue("DES_CORSO", dto.getDesCorso(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTFormazioneDaoImpl::update] END");
	}

	protected SigitTFormazioneDaoRowMapper byIdPersonaRowMapper = new SigitTFormazioneDaoRowMapper(null,
			SigitTFormazioneDto.class, this);

	protected SigitTFormazioneDaoRowMapper findAllRowMapper = new SigitTFormazioneDaoRowMapper(null,
			SigitTFormazioneDto.class, this);

	protected SigitTFormazioneDaoRowMapper findByPrimaryKeyRowMapper = new SigitTFormazioneDaoRowMapper(null,
			SigitTFormazioneDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_FORMAZIONE";
	}

	/** 
	 * Implementazione del finder byIdPersona
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTFormazioneDto> findByIdPersona(java.math.BigDecimal input) throws SigitTFormazioneDaoException {
		LOG.debug("[SigitTFormazioneDaoImpl::findByIdPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT DATA_CORSO,ID_PERSONA_FISICA,DES_CORSO ");
		sql.append(" FROM SIGIT_T_FORMAZIONE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-11778365) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("ID_PERSONA_FISICA = :idPersona");
		/*PROTECTED REGION END*/

		sql.append(" ORDER BY "); /*PROTECTED REGION ID(R515434853) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idPersona", input, java.sql.Types.NUMERIC);

		sql.append(" DATA_CORSO DESC");
		/*PROTECTED REGION END*/
		List<SigitTFormazioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdPersonaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTFormazioneDaoImpl::findByIdPersona] esecuzione query", ex);
			throw new SigitTFormazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTFormazioneDaoImpl", "findByIdPersona", "esecuzione query", sql.toString());
			LOG.debug("[SigitTFormazioneDaoImpl::findByIdPersona] END");
		}
		return list;
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_FORMAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTFormazioneDto> findAll() throws SigitTFormazioneDaoException {
		LOG.debug("[SigitTFormazioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT DATA_CORSO,ID_PERSONA_FISICA,DES_CORSO FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTFormazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTFormazioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTFormazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTFormazioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTFormazioneDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_T_FORMAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTFormazioneDto findByPrimaryKey(SigitTFormazionePk pk) throws SigitTFormazioneDaoException {
		LOG.debug("[SigitTFormazioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT DATA_CORSO,ID_PERSONA_FISICA,DES_CORSO FROM "
				+ getTableName() + " WHERE DATA_CORSO = :DATA_CORSO  AND ID_PERSONA_FISICA = :ID_PERSONA_FISICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_CORSO]
		params.addValue("DATA_CORSO", pk.getDataCorso(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", pk.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		List<SigitTFormazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTFormazioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTFormazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTFormazioneDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTFormazioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
