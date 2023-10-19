package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.PotenzaImpDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.PotenzaImpDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.PotenzaImpDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.PotenzaImpDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R1260246359) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO PotenzaImp.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class PotenzaImpDaoImpl extends AbstractDAO implements PotenzaImpDao {
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

	protected PotenzaImpDaoRowMapper findAllRowMapper = new PotenzaImpDaoRowMapper(
			new String[]{"ID_POTENZA", "DES_POTENZA"}, PotenzaImpDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "OLD_SIGIT_D_POTENZA_IMP";
	}

	/** 
	 * Restituisce tutte le righe della tabella OLD_SIGIT_D_POTENZA_IMP.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<PotenzaImpDto> findAll() throws PotenzaImpDaoException {
		LOG.debug("[PotenzaImpDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT DISTINCT ID_POTENZA,DES_POTENZA FROM " + getTableName());

		sql.append(" ORDER BY ID_POTENZA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<PotenzaImpDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[PotenzaImpDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new PotenzaImpDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("PotenzaImpDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[PotenzaImpDaoImpl::findAll] END");
		}
		return list;
	}

}
