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

/*PROTECTED REGION ID(R471225391) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTConsumoTipo1B.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byFilter (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *   - deleteByIdAllegato (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTConsumoTipo1BDaoImpl extends AbstractDAO implements SigitTConsumoTipo1BDao {
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
	 * Metodo di inserimento del DAO sigitTConsumoTipo1B. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTConsumoTipo1BPk
	 * @generated
	 */

	public SigitTConsumoTipo1BPk insert(SigitTConsumoTipo1BDto dto)

	{
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_CONSUMO_TIPO1B,ESERCIZIO,LETTURA_INIZIALE,LETTURA_FINALE,CONSUMO,FK_ALLEGATO,ID_TIPO_CONSUMO_1B,ID_UNITA_MISURA ) VALUES (  :ID_CONSUMO_TIPO1B , :ESERCIZIO , :LETTURA_INIZIALE , :LETTURA_FINALE , :CONSUMO , :FK_ALLEGATO , :ID_TIPO_CONSUMO_1B , :ID_UNITA_MISURA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONSUMO_TIPO1B]
		params.addValue("ID_CONSUMO_TIPO1B", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ESERCIZIO]
		params.addValue("ESERCIZIO", dto.getEsercizio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [LETTURA_INIZIALE]
		params.addValue("LETTURA_INIZIALE", dto.getLetturaIniziale(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [LETTURA_FINALE]
		params.addValue("LETTURA_FINALE", dto.getLetturaFinale(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CONSUMO]
		params.addValue("CONSUMO", dto.getConsumo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CONSUMO_1B]
		params.addValue("ID_TIPO_CONSUMO_1B", dto.getIdTipoConsumo1b(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_UNITA_MISURA]
		params.addValue("ID_UNITA_MISURA", dto.getIdUnitaMisura(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdConsumoTipo1b(newKey);
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_CONSUMO_TIPO1B table.
	 * @generated
	 */
	public void update(SigitTConsumoTipo1BDto dto) throws SigitTConsumoTipo1BDaoException {
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET ESERCIZIO = :ESERCIZIO ,LETTURA_INIZIALE = :LETTURA_INIZIALE ,LETTURA_FINALE = :LETTURA_FINALE ,CONSUMO = :CONSUMO ,FK_ALLEGATO = :FK_ALLEGATO ,ID_TIPO_CONSUMO_1B = :ID_TIPO_CONSUMO_1B ,ID_UNITA_MISURA = :ID_UNITA_MISURA  WHERE ID_CONSUMO_TIPO1B = :ID_CONSUMO_TIPO1B ";

		if (dto.getIdConsumoTipo1b() == null) {
			LOG.error("[SigitTConsumoTipo1BDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTConsumoTipo1BDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONSUMO_TIPO1B]
		params.addValue("ID_CONSUMO_TIPO1B", dto.getIdConsumoTipo1b(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ESERCIZIO]
		params.addValue("ESERCIZIO", dto.getEsercizio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [LETTURA_INIZIALE]
		params.addValue("LETTURA_INIZIALE", dto.getLetturaIniziale(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [LETTURA_FINALE]
		params.addValue("LETTURA_FINALE", dto.getLetturaFinale(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CONSUMO]
		params.addValue("CONSUMO", dto.getConsumo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CONSUMO_1B]
		params.addValue("ID_TIPO_CONSUMO_1B", dto.getIdTipoConsumo1b(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_UNITA_MISURA]
		params.addValue("ID_UNITA_MISURA", dto.getIdUnitaMisura(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_CONSUMO_TIPO1B table.
	 * @generated
	 */

	public void delete(SigitTConsumoTipo1BPk pk) throws SigitTConsumoTipo1BDaoException {
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_CONSUMO_TIPO1B = :ID_CONSUMO_TIPO1B ";

		if (pk == null) {
			LOG.error("[SigitTConsumoTipo1BDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTConsumoTipo1BDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONSUMO_TIPO1B]
		params.addValue("ID_CONSUMO_TIPO1B", pk.getIdConsumoTipo1b(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_CONSUMO_TIPO1B table.
	 * @generated
	 */
	public void customDeleterDeleteByIdAllegato(java.math.BigDecimal filter) throws SigitTConsumoTipo1BDaoException {
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::customDeleterDeleteByIdAllegato] START");
		/*PROTECTED REGION ID(R-839650885) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE FK_ALLEGATO = :fk_allegato";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("fk_allegato", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::customDeleterDeleteByIdAllegato] END");
	}

	protected SigitTConsumoTipo1BDaoRowMapper findByPrimaryKeyRowMapper = new SigitTConsumoTipo1BDaoRowMapper(null,
			SigitTConsumoTipo1BDto.class, this);

	protected SigitTConsumoTipo1BDaoRowMapper byFilterRowMapper = new SigitTConsumoTipo1BDaoRowMapper(null,
			SigitTConsumoTipo1BDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_CONSUMO_TIPO1B";
	}

	/** 
	 * Returns all rows from the SIGIT_T_CONSUMO_TIPO1B table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTConsumoTipo1BDto findByPrimaryKey(SigitTConsumoTipo1BPk pk) throws SigitTConsumoTipo1BDaoException {
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CONSUMO_TIPO1B,ESERCIZIO,LETTURA_INIZIALE,LETTURA_FINALE,CONSUMO,FK_ALLEGATO,ID_TIPO_CONSUMO_1B,ID_UNITA_MISURA FROM "
						+ getTableName() + " WHERE ID_CONSUMO_TIPO1B = :ID_CONSUMO_TIPO1B ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONSUMO_TIPO1B]
		params.addValue("ID_CONSUMO_TIPO1B", pk.getIdConsumoTipo1b(), java.sql.Types.NUMERIC);

		List<SigitTConsumoTipo1BDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTConsumoTipo1BDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTConsumoTipo1BDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTConsumoTipo1BDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTConsumoTipo1BDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTConsumoTipo1BDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTConsumoTipo1BDto input)
			throws SigitTConsumoTipo1BDaoException {
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_CONSUMO_TIPO1B,ESERCIZIO,LETTURA_INIZIALE,LETTURA_FINALE,CONSUMO,FK_ALLEGATO,ID_TIPO_CONSUMO_1B,ID_UNITA_MISURA ");
		sql.append(" FROM SIGIT_T_CONSUMO_TIPO1B");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-572900874) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append("1=1");
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		if (GenericUtil.isNotNullOrEmpty(input.getFkAllegato())) {
			sql.append(" AND FK_ALLEGATO = :idAllegato");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoConsumo1b())) {
			sql.append(" AND ID_TIPO_CONSUMO_1B = :idTipoConsumo1B");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R300505868) ENABLED START*/
		//***aggiungere tutte le condizioni
		if (GenericUtil.isNotNullOrEmpty(input.getFkAllegato())) {
			paramMap.addValue("idAllegato", input.getFkAllegato());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoConsumo1b())) {
			paramMap.addValue("idTipoConsumo1B", input.getIdTipoConsumo1b());
		}

		/*PROTECTED REGION END*/
		List<SigitTConsumoTipo1BDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTConsumoTipo1BDaoImpl::findByFilter] esecuzione query", ex);
			throw new SigitTConsumoTipo1BDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTConsumoTipo1BDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitTConsumoTipo1BDaoImpl::findByFilter] END");
		}
		return list;
	}

}
