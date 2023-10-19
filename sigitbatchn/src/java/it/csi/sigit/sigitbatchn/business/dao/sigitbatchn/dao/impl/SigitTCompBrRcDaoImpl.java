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

/*PROTECTED REGION ID(R-404406331) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompBrRc.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byTipoAndCodImpiantoOrdered (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTCompBrRcDaoImpl extends AbstractDAO implements SigitTCompBrRcDao {
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

	protected SigitTCompBrRcDaoRowMapper byTipoAndCodImpiantoOrderedRowMapper = new SigitTCompBrRcDaoRowMapper(null,
			SigitTCompBrRcDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_BR_RC";
	}

	/** 
	 * Implementazione del finder byTipoAndCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompBrRcDto> findByTipoAndCodImpiantoOrdered(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTCompBrRcDto input)
			throws SigitTCompBrRcDaoException {
		LOG.debug("[SigitTCompBrRcDaoImpl::findByTipoAndCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_COMP_BR_RC,TIPOLOGIA_BR_RC,PROGRESSIVO_BR_RC,FK_TIPO_COMPONENTE,FK_PROGRESSIVO,FK_DATA_INSTALL,CODICE_IMPIANTO,TIPOLOGIA,POT_TERM_MAX_KW,POT_TERM_MIN_KW,DATA_INSTALL,DATA_DISMISS,FK_MARCA,MODELLO,MATRICOLA,FK_COMBUSTIBILE,FLG_DISMISSIONE ");
		sql.append(" FROM SIGIT_T_COMP_BR_RC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-114684646) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" 1 = 1 ");
		if (input.getTipologiaBrRc() != null)
			sql.append(" AND TIPOLOGIA_BR_RC = :tipoBrRc");
		sql.append(" AND CODICE_IMPIANTO = :codImpianto");
		sql.append(" ORDER BY PROGRESSIVO_BR_RC ASC, DATA_INSTALL DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R864629520) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("tipoBrRc", input.getTipologiaBrRc(), java.sql.Types.VARCHAR);
		paramMap.addValue("codImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTCompBrRcDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byTipoAndCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompBrRcDaoImpl::findByTipoAndCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitTCompBrRcDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompBrRcDaoImpl", "findByTipoAndCodImpiantoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTCompBrRcDaoImpl::findByTipoAndCodImpiantoOrdered] END");
		}
		return list;
	}

}
