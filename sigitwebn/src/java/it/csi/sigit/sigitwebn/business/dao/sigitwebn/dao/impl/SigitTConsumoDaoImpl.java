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

/*PROTECTED REGION ID(R1096075087) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTConsumo.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - byCodImpianto (datagen::CustomFinder)
 *   - ByCodImpiantoAndTipo (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - CombuByCodImpianto (datagen::CustomDeleter)
 *   - EnergiaByCodImpianto (datagen::CustomDeleter)
 *   - AcquaByCodImpianto (datagen::CustomDeleter)
 *   - ByCodImpianto (datagen::CustomDeleter)
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTConsumoDaoImpl extends AbstractDAO implements SigitTConsumoDao {
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
	 * Metodo di inserimento del DAO sigitTConsumo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTConsumoPk
	 * @generated
	 */

	public SigitTConsumoPk insert(SigitTConsumoDto dto)

	{
		LOG.debug("[SigitTConsumoDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_CONSUMO,CODICE_IMPIANTO,FK_TIPO_CONSUMO,FK_COMBUSTIBILE,FK_UNITA_MISURA,ACQUISTI,LETTURA_INIZIALE,LETTURA_FINALE,CONSUMO,ESERCIZIO_DA,ESERCIZIO_A,DATA_ULT_MOD,UTENTE_ULT_MOD ) VALUES (  :ID_CONSUMO , :CODICE_IMPIANTO , :FK_TIPO_CONSUMO , :FK_COMBUSTIBILE , :FK_UNITA_MISURA , :ACQUISTI , :LETTURA_INIZIALE , :LETTURA_FINALE , :CONSUMO , :ESERCIZIO_DA , :ESERCIZIO_A , :DATA_ULT_MOD , :UTENTE_ULT_MOD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONSUMO]
		params.addValue("ID_CONSUMO", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CONSUMO]
		params.addValue("FK_TIPO_CONSUMO", dto.getFkTipoConsumo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_COMBUSTIBILE]
		params.addValue("FK_COMBUSTIBILE", dto.getFkCombustibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_UNITA_MISURA]
		params.addValue("FK_UNITA_MISURA", dto.getFkUnitaMisura(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ACQUISTI]
		params.addValue("ACQUISTI", dto.getAcquisti(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [LETTURA_INIZIALE]
		params.addValue("LETTURA_INIZIALE", dto.getLetturaIniziale(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [LETTURA_FINALE]
		params.addValue("LETTURA_FINALE", dto.getLetturaFinale(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CONSUMO]
		params.addValue("CONSUMO", dto.getConsumo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ESERCIZIO_DA]
		params.addValue("ESERCIZIO_DA", dto.getEsercizioDa(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ESERCIZIO_A]
		params.addValue("ESERCIZIO_A", dto.getEsercizioA(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdConsumo(newKey);
		LOG.debug("[SigitTConsumoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_CONSUMO table.
	 * @generated
	 */
	public void update(SigitTConsumoDto dto) throws SigitTConsumoDaoException {
		LOG.debug("[SigitTConsumoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET CODICE_IMPIANTO = :CODICE_IMPIANTO ,FK_TIPO_CONSUMO = :FK_TIPO_CONSUMO ,FK_COMBUSTIBILE = :FK_COMBUSTIBILE ,FK_UNITA_MISURA = :FK_UNITA_MISURA ,ACQUISTI = :ACQUISTI ,LETTURA_INIZIALE = :LETTURA_INIZIALE ,LETTURA_FINALE = :LETTURA_FINALE ,CONSUMO = :CONSUMO ,ESERCIZIO_DA = :ESERCIZIO_DA ,ESERCIZIO_A = :ESERCIZIO_A ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD  WHERE ID_CONSUMO = :ID_CONSUMO ";

		if (dto.getIdConsumo() == null) {
			LOG.error("[SigitTConsumoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTConsumoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONSUMO]
		params.addValue("ID_CONSUMO", dto.getIdConsumo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CONSUMO]
		params.addValue("FK_TIPO_CONSUMO", dto.getFkTipoConsumo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_COMBUSTIBILE]
		params.addValue("FK_COMBUSTIBILE", dto.getFkCombustibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_UNITA_MISURA]
		params.addValue("FK_UNITA_MISURA", dto.getFkUnitaMisura(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ACQUISTI]
		params.addValue("ACQUISTI", dto.getAcquisti(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [LETTURA_INIZIALE]
		params.addValue("LETTURA_INIZIALE", dto.getLetturaIniziale(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [LETTURA_FINALE]
		params.addValue("LETTURA_FINALE", dto.getLetturaFinale(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CONSUMO]
		params.addValue("CONSUMO", dto.getConsumo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ESERCIZIO_DA]
		params.addValue("ESERCIZIO_DA", dto.getEsercizioDa(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ESERCIZIO_A]
		params.addValue("ESERCIZIO_A", dto.getEsercizioA(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTConsumoDaoImpl::update] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_CONSUMO table.
	 * @generated
	 */
	public void customDeleterCombuByCodImpianto(Integer filter) throws SigitTConsumoDaoException {
		LOG.debug("[SigitTConsumoDaoImpl::customDeleterCombuByCodImpianto] START");
		/*PROTECTED REGION ID(R-961280572) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE CODICE_IMPIANTO = :codImpianto AND FK_TIPO_CONSUMO = '"
				+ it.csi.sigit.sigitwebn.util.Constants.TIPO_CONSUMO_CB + "'";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTConsumoDaoImpl::customDeleterCombuByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_CONSUMO table.
	 * @generated
	 */
	public void customDeleterEnergiaByCodImpianto(Integer filter) throws SigitTConsumoDaoException {
		LOG.debug("[SigitTConsumoDaoImpl::customDeleterEnergiaByCodImpianto] START");
		/*PROTECTED REGION ID(R1676960601) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE CODICE_IMPIANTO = :codImpianto AND FK_TIPO_CONSUMO = '"
				+ it.csi.sigit.sigitwebn.util.Constants.TIPO_CONSUMO_EE + "'";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTConsumoDaoImpl::customDeleterEnergiaByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_CONSUMO table.
	 * @generated
	 */
	public void customDeleterAcquaByCodImpianto(Integer filter) throws SigitTConsumoDaoException {
		LOG.debug("[SigitTConsumoDaoImpl::customDeleterAcquaByCodImpianto] START");
		/*PROTECTED REGION ID(R920704075) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE CODICE_IMPIANTO = :codImpianto AND FK_TIPO_CONSUMO = '"
				+ it.csi.sigit.sigitwebn.util.Constants.TIPO_CONSUMO_H2O + "'";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTConsumoDaoImpl::customDeleterAcquaByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_CONSUMO table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTConsumoDaoException {
		LOG.debug("[SigitTConsumoDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R415389072) ENABLED START*/
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTConsumoDaoImpl::customDeleterByCodImpianto] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_CONSUMO table.
	 * @generated
	 */

	public void delete(SigitTConsumoPk pk) throws SigitTConsumoDaoException {
		LOG.debug("[SigitTConsumoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_CONSUMO = :ID_CONSUMO ";

		if (pk == null) {
			LOG.error("[SigitTConsumoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTConsumoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONSUMO]
		params.addValue("ID_CONSUMO", pk.getIdConsumo(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTConsumoDaoImpl::delete] END");
	}

	protected SigitTConsumoDaoRowMapper byCodImpiantoRowMapper = new SigitTConsumoDaoRowMapper(null,
			SigitTConsumoDto.class, this);

	protected SigitTConsumoDaoRowMapper ByCodImpiantoAndTipoRowMapper = new SigitTConsumoDaoRowMapper(null,
			SigitTConsumoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_CONSUMO";
	}

	/** 
	 * Implementazione del finder byCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTConsumoDto> findByCodImpianto(Integer input) throws SigitTConsumoDaoException {
		LOG.debug("[SigitTConsumoDaoImpl::findByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_CONSUMO,CODICE_IMPIANTO,FK_TIPO_CONSUMO,FK_COMBUSTIBILE,FK_UNITA_MISURA,ACQUISTI,LETTURA_INIZIALE,LETTURA_FINALE,CONSUMO,ESERCIZIO_DA,ESERCIZIO_A,DATA_ULT_MOD,UTENTE_ULT_MOD ");
		sql.append(" FROM SIGIT_T_CONSUMO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1631484960) ENABLED START*/
		sql.append("CODICE_IMPIANTO = :codImpianto");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1844137570) ENABLED START*/

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTConsumoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTConsumoDaoImpl::findByCodImpianto] esecuzione query", ex);
			throw new SigitTConsumoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTConsumoDaoImpl", "findByCodImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitTConsumoDaoImpl::findByCodImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder ByCodImpiantoAndTipo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTConsumoDto> findByCodImpiantoAndTipo(SigitTConsumoDto input) throws SigitTConsumoDaoException {
		LOG.debug("[SigitTConsumoDaoImpl::findByCodImpiantoAndTipo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_CONSUMO,CODICE_IMPIANTO,FK_TIPO_CONSUMO,FK_COMBUSTIBILE,FK_UNITA_MISURA,ACQUISTI,LETTURA_INIZIALE,LETTURA_FINALE,CONSUMO,ESERCIZIO_DA,ESERCIZIO_A,DATA_ULT_MOD,UTENTE_ULT_MOD ");
		sql.append(" FROM SIGIT_T_CONSUMO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1649436007) ENABLED START*/
		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_TIPO_CONSUMO = :tipoConsumo");
		sql.append(" ORDER BY FK_COMBUSTIBILE ASC, FK_UNITA_MISURA ASC, ESERCIZIO_DA ASC, ESERCIZIO_A ASC");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R473472443) ENABLED START*/

		paramMap.addValue("codImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("tipoConsumo", input.getFkTipoConsumo(), java.sql.Types.VARCHAR);

		/*PROTECTED REGION END*/
		List<SigitTConsumoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ByCodImpiantoAndTipoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTConsumoDaoImpl::findByCodImpiantoAndTipo] esecuzione query", ex);
			throw new SigitTConsumoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTConsumoDaoImpl", "findByCodImpiantoAndTipo", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTConsumoDaoImpl::findByCodImpiantoAndTipo] END");
		}
		return list;
	}

}
