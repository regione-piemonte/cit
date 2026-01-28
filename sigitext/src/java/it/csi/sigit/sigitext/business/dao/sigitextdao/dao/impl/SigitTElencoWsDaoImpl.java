package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTElencoWsDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTElencoWsDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTElencoWsDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTElencoWsPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTElencoWsDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R-1556253111) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTElencoWs.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTElencoWsDaoImpl extends AbstractDAO implements SigitTElencoWsDao {
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

	protected SigitTElencoWsDaoRowMapper findByPrimaryKeyRowMapper = new SigitTElencoWsDaoRowMapper(null,
			SigitTElencoWsDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ELENCO_WS";
	}

	/** 
	 * Returns all rows from the SIGIT_T_ELENCO_WS table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTElencoWsDto findByPrimaryKey(SigitTElencoWsPk pk) throws SigitTElencoWsDaoException {
		LOG.debug("[SigitTElencoWsDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ELENCO_WS,DESCRIZIONE_WS FROM " + getTableName() + " WHERE ID_ELENCO_WS = :ID_ELENCO_WS ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ELENCO_WS]
		params.addValue("ID_ELENCO_WS", pk.getIdElencoWs(), java.sql.Types.INTEGER);

		List<SigitTElencoWsDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTElencoWsDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTElencoWsDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTElencoWsDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTElencoWsDaoImpl::findByPrimaryKey] END");
		}
		log.debug("list SigitTElencoWsDto findByPrimaryKey isEmpty : " + list.isEmpty());
		return list.isEmpty() ? null : list.get(0);
	}

}
