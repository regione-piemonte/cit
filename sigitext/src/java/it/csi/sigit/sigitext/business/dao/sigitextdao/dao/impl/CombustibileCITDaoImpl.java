package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.CombustibileCITDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.CombustibileCITDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.CombustibileCITDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R1179506403) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO CombustibileCIT.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class CombustibileCITDaoImpl extends AbstractDAO implements CombustibileCITDao {
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

	protected CombustibileCITDaoRowMapper findAllRowMapper = new CombustibileCITDaoRowMapper(
			new String[]{"ID_COMBUSTIBILE", "DES_COMBUSTIBILE"}, CombustibileCITDto.class, this);

	protected CombustibileCITDaoRowMapper findByPrimaryKeyRowMapper = new CombustibileCITDaoRowMapper(null,
			CombustibileCITDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_COMBUSTIBILE";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_COMBUSTIBILE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<CombustibileCITDto> findAll() throws CombustibileCITDaoException {
		LOG.debug("[CombustibileCITDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT DISTINCT ID_COMBUSTIBILE,DES_COMBUSTIBILE FROM " + getTableName());

		sql.append(" ORDER BY ID_COMBUSTIBILE ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<CombustibileCITDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[CombustibileCITDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new CombustibileCITDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("CombustibileCITDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[CombustibileCITDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_COMBUSTIBILE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public CombustibileCITDto findByPrimaryKey(CombustibileCITPk pk) throws CombustibileCITDaoException {
		LOG.debug("[CombustibileCITDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_COMBUSTIBILE,DES_COMBUSTIBILE FROM " + getTableName()
				+ " WHERE ID_COMBUSTIBILE = :ID_COMBUSTIBILE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_COMBUSTIBILE]
		params.addValue("ID_COMBUSTIBILE", pk.getIdCombustibile(), java.sql.Types.NUMERIC);

		List<CombustibileCITDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[CombustibileCITDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new CombustibileCITDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("CombustibileCITDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[CombustibileCITDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
