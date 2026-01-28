package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTControlloLibrettoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTControlloLibrettoDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTControlloLibrettoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTControlloLibrettoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTControlloLibrettoDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R753862051) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTControlloLibretto.
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
public class SigitTControlloLibrettoDaoImpl extends AbstractDAO implements SigitTControlloLibrettoDao {
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

	protected SigitTControlloLibrettoDaoRowMapper findByPrimaryKeyRowMapper = new SigitTControlloLibrettoDaoRowMapper(
			null, SigitTControlloLibrettoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_CONTROLLO_LIBRETTO";
	}

	/** 
	 * Returns all rows from the SIGIT_T_CONTROLLO_LIBRETTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTControlloLibrettoDto findByPrimaryKey(SigitTControlloLibrettoPk pk)
			throws SigitTControlloLibrettoDaoException {
		LOG.debug("[SigitTControlloLibrettoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT CODICE_IMPIANTO,FLG_L1_CONTROLLOWEB,FLG_L5_CONTROLLOWEB,FLG_L6_CONTROLLOWEB,FLG_L7_CONTROLLOWEB,DT_ULT_MOD,UTENTE_ULT_AGG FROM "
						+ getTableName() + " WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		List<SigitTControlloLibrettoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTControlloLibrettoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTControlloLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTControlloLibrettoDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTControlloLibrettoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}
	
	public void insert(SigitTControlloLibrettoDto dto) throws SigitTControlloLibrettoDaoException {
		LOG.debug("[SigitTControlloLibrettoDaoImpl::insert] START");
		final StringBuilder sql = new StringBuilder(
				"INSERT INTO "
		+ getTableName() 
		+ " (CODICE_IMPIANTO, flg_l1_controlloweb, flg_l5_controlloweb, flg_l6_controlloweb, flg_l7_controlloweb, dt_ult_mod, utente_ult_agg) "
		+ "VALUES (:CODICE_IMPIANTO, :flg_l1_controlloweb, :flg_l5_controlloweb, :flg_l6_controlloweb, :flg_l7_controlloweb, :dt_ult_mod, :utente_ult_agg)");
		

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);
		params.addValue("flg_l1_controlloweb", dto.getFlgL1Controlloweb(), java.sql.Types.NUMERIC);
		params.addValue("flg_l5_controlloweb", dto.getFlgL5Controlloweb(), java.sql.Types.NUMERIC);
		params.addValue("flg_l6_controlloweb", dto.getFlgL6Controlloweb(), java.sql.Types.NUMERIC);
		params.addValue("flg_l7_controlloweb", dto.getFlgL7Controlloweb(), java.sql.Types.NUMERIC);
		params.addValue("dt_ult_mod", dto.getDtUltMod(), java.sql.Types.TIMESTAMP);
		params.addValue("utente_ult_agg", dto.getUtenteUltAgg(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);
	}
	
	public void update(SigitTControlloLibrettoDto dto) throws SigitTControlloLibrettoDaoException {
		LOG.debug("[SigitTControlloLibrettoDaoImpl::insert] START");
		final StringBuilder sql = new StringBuilder(
				"UPDATE " 
		+ getTableName() 
		+ " SET flg_l1_controlloweb = :flg_l1_controlloweb, flg_l5_controlloweb = :flg_l5_controlloweb, flg_l6_controlloweb = :flg_l6_controlloweb, flg_l7_controlloweb = :flg_l7_controlloweb, dt_ult_mod = :dt_ult_mod, utente_ult_agg = :utente_ult_agg "
		+ "WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);
		params.addValue("flg_l1_controlloweb", dto.getFlgL1Controlloweb(), java.sql.Types.NUMERIC);
		params.addValue("flg_l5_controlloweb", dto.getFlgL5Controlloweb(), java.sql.Types.NUMERIC);
		params.addValue("flg_l6_controlloweb", dto.getFlgL6Controlloweb(), java.sql.Types.NUMERIC);
		params.addValue("flg_l7_controlloweb", dto.getFlgL7Controlloweb(), java.sql.Types.NUMERIC);
		params.addValue("dt_ult_mod", dto.getDtUltMod(), java.sql.Types.TIMESTAMP);
		params.addValue("utente_ult_agg", dto.getUtenteUltAgg(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
	}

}
