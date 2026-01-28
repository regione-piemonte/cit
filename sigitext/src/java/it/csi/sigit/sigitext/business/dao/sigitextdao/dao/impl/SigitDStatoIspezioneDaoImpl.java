package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDStatoIspezioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDStatoIspezioneDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDStatoIspezioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDStatoIspezioneDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;

/*PROTECTED REGION ID(R-1354246589) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDStatoIspezione.
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
public class SigitDStatoIspezioneDaoImpl extends AbstractDAO implements SigitDStatoIspezioneDao {
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

	protected SigitDStatoIspezioneDaoRowMapper findAllRowMapper = new SigitDStatoIspezioneDaoRowMapper(null,
			SigitDStatoIspezioneDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_STATO_ISPEZIONE";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_STATO_IMP.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDStatoIspezioneDto> findAll() throws SigitDStatoIspezioneDaoException {
		LOG.debug("[SigitDStatoIspezioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_STATO_ISPEZIONE,DES_STATO_ISPEZIONE FROM " + getTableName() + " WHERE ID_STATO_ISPEZIONE != 0");

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDStatoIspezioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDStatoIspezioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDStatoIspezioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDStatoImpiantoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDStatoIspezioneDaoImpl::findAll] END");
		}
		return list;
	}



}
