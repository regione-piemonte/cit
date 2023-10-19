package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRPgPgNominaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitRPgPgNominaDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPgPgNominaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRPgPgNominaDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R1385438609) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRPgPgNomina.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPgCat (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRPgPgNominaDaoImpl extends AbstractDAO implements SigitRPgPgNominaDao {
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

	protected SigitRPgPgNominaDaoRowMapper findByPgCatRowMapper = new SigitRPgPgNominaDaoRowMapper(null,
			SigitRPgPgNominaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_PG_PG_NOMINA";
	}

	/** 
	 * Implementazione del finder findByPgCat
	 * @generated
	 */
	@SuppressWarnings("unchecked")

	public List<SigitRPgPgNominaDto> findFindByPgCat(Integer input) throws SigitRPgPgNominaDaoException {
		LOG.debug("[SigitRPgPgNominaDaoImpl::findFindByPgCat] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_GIURIDICA_CAT,ID_PERSONA_GIURIDICA_IMPRESA,DATA_INIZIO,DATA_FINE,DATA_ULTIMA_MODIFICA,UTENTE_ULTIMA_MODIFICA ");
		sql.append(" FROM SIGIT_R_PG_PG_NOMINA");
		sql.append(" WHERE ");
		sql.append(" ID_PERSONA_GIURIDICA_CAT = :idPersGiuCat");
		sql.append(" AND DATA_FINE IS NULL");
		paramMap.addValue("idPersGiuCat", input);
		List<SigitRPgPgNominaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByPgCatRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRPgPgNominaDaoImpl::findFindByPgCat] esecuzione query", ex);
			throw new SigitRPgPgNominaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPgPgNominaDaoImpl", "findFindByPgCat", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPgPgNominaDaoImpl::findFindByPgCat] END");
		}
		return list;
	}

}
