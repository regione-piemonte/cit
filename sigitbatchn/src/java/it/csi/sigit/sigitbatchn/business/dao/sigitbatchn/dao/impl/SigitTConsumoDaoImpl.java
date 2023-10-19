package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.*;
import it.csi.sigit.sigitbatchn.business.dao.util.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R670208015) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTConsumo.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - ByCodImpiantoAndTipo (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
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
	 * Implementazione del finder ByCodImpiantoAndTipo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTConsumoDto> findByCodImpiantoAndTipo(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTConsumoDto input)
			throws SigitTConsumoDaoException {
		LOG.debug("[SigitTConsumoDaoImpl::findByCodImpiantoAndTipo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_CONSUMO,CODICE_IMPIANTO,FK_TIPO_CONSUMO,FK_COMBUSTIBILE,FK_UNITA_MISURA,ACQUISTI,LETTURA_INIZIALE,LETTURA_FINALE,CONSUMO,ESERCIZIO_DA,ESERCIZIO_A,DATA_ULT_MOD,UTENTE_ULT_MOD ");
		sql.append(" FROM SIGIT_T_CONSUMO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R776212175) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_TIPO_CONSUMO = :tipoConsumo");
		sql.append(" ORDER BY FK_COMBUSTIBILE ASC, FK_UNITA_MISURA ASC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1582340101) ENABLED START*/
		//***aggiungere tutte le condizioni

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
