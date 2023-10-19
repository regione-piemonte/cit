package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDUnitaMisuraDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDUnitaMisuraDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDUnitaMisuraDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDUnitaMisuraPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDUnitaMisuraDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R-752942769) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDUnitaMisura.
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
public class SigitDUnitaMisuraDaoImpl extends AbstractDAO implements SigitDUnitaMisuraDao {
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

	protected SigitDUnitaMisuraDaoRowMapper findAllRowMapper = new SigitDUnitaMisuraDaoRowMapper(null,
			SigitDUnitaMisuraDto.class, this);

	protected SigitDUnitaMisuraDaoRowMapper findByPrimaryKeyRowMapper = new SigitDUnitaMisuraDaoRowMapper(null,
			SigitDUnitaMisuraDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_UNITA_MISURA";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_UNITA_MISURA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDUnitaMisuraDto> findAll() throws SigitDUnitaMisuraDaoException {
		LOG.debug("[SigitDUnitaMisuraDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_UNITA_MISURA,DES_UNITA_MISURA FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDUnitaMisuraDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDUnitaMisuraDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDUnitaMisuraDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDUnitaMisuraDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDUnitaMisuraDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_UNITA_MISURA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDUnitaMisuraDto findByPrimaryKey(SigitDUnitaMisuraPk pk) throws SigitDUnitaMisuraDaoException {
		LOG.debug("[SigitDUnitaMisuraDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_UNITA_MISURA,DES_UNITA_MISURA FROM " + getTableName()
				+ " WHERE ID_UNITA_MISURA = :ID_UNITA_MISURA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_MISURA]
		params.addValue("ID_UNITA_MISURA", pk.getIdUnitaMisura(), java.sql.Types.VARCHAR);

		List<SigitDUnitaMisuraDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDUnitaMisuraDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDUnitaMisuraDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDUnitaMisuraDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitDUnitaMisuraDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
