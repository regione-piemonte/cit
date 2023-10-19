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

/*PROTECTED REGION ID(R-464731141) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO SigitTGraffatura.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - byCodiceImpiantoInattivo (datagen::CustomFinder)
 *   - byCodiceImpiantoAttivo (datagen::CustomFinder)
 *   - byIdGraffatura (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTGraffaturaDaoImpl extends AbstractDAO implements SigitTGraffaturaDao {
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
	 * Metodo di inserimento del DAO SigitTGraffatura. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTGraffaturaPk
	 * @generated
	 */

	public SigitTGraffaturaPk insert(SigitTGraffaturaDto dto)

	{
		LOG.debug("[SigitTGraffaturaDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_GRAFFATURA,CODICE_IMPIANTO,DT_INSERIMENTO,DT_CANCELLAZIONE,UTENTE_ULT_MOD ) VALUES (  :ID_GRAFFATURA , :CODICE_IMPIANTO , :DT_INSERIMENTO , :DT_CANCELLAZIONE , :UTENTE_ULT_MOD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_GRAFFATURA]
		params.addValue("ID_GRAFFATURA", dto.getIdGraffatura(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_INSERIMENTO]
		params.addValue("DT_INSERIMENTO", dto.getDtInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DT_CANCELLAZIONE]
		params.addValue("DT_CANCELLAZIONE", dto.getDtCancellazione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTGraffaturaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_GRAFFATURA table.
	 * @generated
	 */
	public void update(SigitTGraffaturaDto dto) throws SigitTGraffaturaDaoException {
		LOG.debug("[SigitTGraffaturaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DT_CANCELLAZIONE = :DT_CANCELLAZIONE ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD  WHERE ID_GRAFFATURA = :ID_GRAFFATURA  AND CODICE_IMPIANTO = :CODICE_IMPIANTO  AND DT_INSERIMENTO = :DT_INSERIMENTO ";

		if (dto.getIdGraffatura() == null || dto.getCodiceImpianto() == null || dto.getDtInserimento() == null) {
			LOG.error("[SigitTGraffaturaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTGraffaturaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_GRAFFATURA]
		params.addValue("ID_GRAFFATURA", dto.getIdGraffatura(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_INSERIMENTO]
		params.addValue("DT_INSERIMENTO", dto.getDtInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DT_CANCELLAZIONE]
		params.addValue("DT_CANCELLAZIONE", dto.getDtCancellazione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTGraffaturaDaoImpl::update] END");
	}

	protected SigitTGraffaturaDaoRowMapper byCodiceImpiantoInattivoRowMapper = new SigitTGraffaturaDaoRowMapper(null,
			SigitTGraffaturaDto.class, this);

	protected SigitTGraffaturaDaoRowMapper byCodiceImpiantoAttivoRowMapper = new SigitTGraffaturaDaoRowMapper(null,
			SigitTGraffaturaDto.class, this);

	protected SigitTGraffaturaDaoRowMapper byIdGraffaturaRowMapper = new SigitTGraffaturaDaoRowMapper(null,
			SigitTGraffaturaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_GRAFFATURA";
	}

	/** 
	 * Implementazione del finder byCodiceImpiantoInattivo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTGraffaturaDto> findByCodiceImpiantoInattivo(java.lang.Integer input)
			throws SigitTGraffaturaDaoException {
		LOG.debug("[SigitTGraffaturaDaoImpl::findByCodiceImpiantoInattivo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1174682444) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT ID_GRAFFATURA,CODICE_IMPIANTO,DT_INSERIMENTO,DT_CANCELLAZIONE,UTENTE_ULT_MOD ");
		/*PROTECTED REGION END*/
		sql.append(" FROM SIGIT_T_GRAFFATURA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1424569308) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("nome = :nome");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R2092539366) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("nome", input);

		/*PROTECTED REGION END*/
		List<SigitTGraffaturaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoInattivoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTGraffaturaDaoImpl::findByCodiceImpiantoInattivo] esecuzione query", ex);
			throw new SigitTGraffaturaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTGraffaturaDaoImpl", "findByCodiceImpiantoInattivo", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTGraffaturaDaoImpl::findByCodiceImpiantoInattivo] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceImpiantoAttivo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTGraffaturaDto> findByCodiceImpiantoAttivo(java.lang.Integer input)
			throws SigitTGraffaturaDaoException {
		LOG.debug("[SigitTGraffaturaDaoImpl::findByCodiceImpiantoAttivo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-832217775) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT ID_GRAFFATURA,CODICE_IMPIANTO,DT_INSERIMENTO,DT_CANCELLAZIONE,UTENTE_ULT_MOD ");
		/*PROTECTED REGION END*/
		sql.append(" FROM SIGIT_T_GRAFFATURA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1082735927) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append("codice_impianto = :codice");
		sql.append(" AND dt_cancellazione IS NULL");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R85639147) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codice", input);

		/*PROTECTED REGION END*/
		List<SigitTGraffaturaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoAttivoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTGraffaturaDaoImpl::findByCodiceImpiantoAttivo] esecuzione query", ex);
			throw new SigitTGraffaturaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTGraffaturaDaoImpl", "findByCodiceImpiantoAttivo", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTGraffaturaDaoImpl::findByCodiceImpiantoAttivo] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byIdGraffatura
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTGraffaturaDto> findByIdGraffatura(java.lang.Integer input) throws SigitTGraffaturaDaoException {
		LOG.debug("[SigitTGraffaturaDaoImpl::findByIdGraffatura] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-2034983628) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT ID_GRAFFATURA,CODICE_IMPIANTO,DT_INSERIMENTO,DT_CANCELLAZIONE,UTENTE_ULT_MOD ");
		/*PROTECTED REGION END*/
		sql.append(" FROM SIGIT_T_GRAFFATURA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R489747700) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("id_graffatura = :id");
		sql.append(" and DT_CANCELLAZIONE IS NULL");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1117126706) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("id", input);

		/*PROTECTED REGION END*/
		List<SigitTGraffaturaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdGraffaturaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTGraffaturaDaoImpl::findByIdGraffatura] esecuzione query", ex);
			throw new SigitTGraffaturaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTGraffaturaDaoImpl", "findByIdGraffatura", "esecuzione query", sql.toString());
			LOG.debug("[SigitTGraffaturaDaoImpl::findByIdGraffatura] END");
		}
		return list;
	}

}
