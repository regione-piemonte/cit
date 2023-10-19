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

/*PROTECTED REGION ID(R2144093615) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTDocAggiuntiva.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byCodImpIdTipoDocAgg (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTDocAggiuntivaDaoImpl extends AbstractDAO implements SigitTDocAggiuntivaDao {
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

	protected SigitTDocAggiuntivaDaoRowMapper byCodImpIdTipoDocAggRowMapper = new SigitTDocAggiuntivaDaoRowMapper(null,
			SigitTDocAggiuntivaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DOC_AGGIUNTIVA";
	}

	/** 
	 * Implementazione del finder byCodImpIdTipoDocAgg
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDocAggiuntivaDto> findByCodImpIdTipoDocAgg(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTDocAggiuntivaDto input)
			throws SigitTDocAggiuntivaDaoException {
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::findByCodImpIdTipoDocAgg] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_DOC_AGGIUNTIVA,CODICE_IMPIANTO,FK_TIPO_DOCAGG,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,DES_ALTRO_TIPODOC,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_UPLOAD,DATA_DELETE ");
		sql.append(" FROM SIGIT_T_DOC_AGGIUNTIVA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1524779774) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codImpianto ");
		sql.append(" AND FK_TIPO_DOCAGG = :idTipoDocAgg ");
		sql.append(" AND DATA_DELETE IS NULL ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R148418988) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto());
		paramMap.addValue("idTipoDocAgg", input.getFkTipoDocagg());

		/*PROTECTED REGION END*/
		List<SigitTDocAggiuntivaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpIdTipoDocAggRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDocAggiuntivaDaoImpl::findByCodImpIdTipoDocAgg] esecuzione query", ex);
			throw new SigitTDocAggiuntivaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDocAggiuntivaDaoImpl", "findByCodImpIdTipoDocAgg", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTDocAggiuntivaDaoImpl::findByCodImpIdTipoDocAgg] END");
		}
		return list;
	}

}
