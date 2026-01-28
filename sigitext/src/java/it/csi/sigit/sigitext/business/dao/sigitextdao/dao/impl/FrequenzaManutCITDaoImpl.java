package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.CombustibileCITDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.FrequenzaManutCITDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.CombustibileCITDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.FrequenzaManutCITDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.FrequenzaManutCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.FrequenzaManutCITPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.CombustibileCITDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.FrequenzaManutCITDaoException;
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
public class FrequenzaManutCITDaoImpl extends AbstractDAO implements FrequenzaManutCITDao {
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

	protected FrequenzaManutCITDaoRowMapper findAllRowMapper = new FrequenzaManutCITDaoRowMapper(
			new String[]{"ID_FREQUENZA", "DES_FREQUENZA"}, FrequenzaManutCITDto.class, this);

	protected FrequenzaManutCITDaoRowMapper findByPrimaryKeyRowMapper = new FrequenzaManutCITDaoRowMapper(null,
			FrequenzaManutCITDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_FREQUENZA_MANUT";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_COMBUSTIBILE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<FrequenzaManutCITDto> findAll() throws FrequenzaManutCITDaoException {
		LOG.debug("[FrequenzaManutCITDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT DISTINCT ID_FREQUENZA,DES_FREQUENZA FROM " + getTableName());

		sql.append(" ORDER BY ID_FREQUENZA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<FrequenzaManutCITDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[FrequenzaManutCITDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new FrequenzaManutCITDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("FrequenzaManutCITDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[FrequenzaManutCITDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_COMBUSTIBILE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public FrequenzaManutCITDto findByPrimaryKey(FrequenzaManutCITPk pk) throws FrequenzaManutCITDaoException {
		LOG.debug("[FrequenzaManutCITDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_FREQUENZA,DES_FREQUENZA FROM " + getTableName()
				+ " WHERE ID_FREQUENZA = :ID_FREQUENZA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_COMBUSTIBILE]
		params.addValue("ID_FREQUENZA", pk.getIdFrequenza(), java.sql.Types.NUMERIC);

		List<FrequenzaManutCITDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[FrequenzaManutCITDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new FrequenzaManutCITDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("FrequenzaManutCITDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[FrequenzaManutCITDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
