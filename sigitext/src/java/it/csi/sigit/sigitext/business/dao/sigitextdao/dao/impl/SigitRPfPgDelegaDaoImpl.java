package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRPfPgDelegaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitRPfPgDelegaDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfPgDelegaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfPgDelegaFindByPfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRPfPgDelegaDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R-1467034665) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRPfPgDelega.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPf (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRPfPgDelegaDaoImpl extends AbstractDAO implements SigitRPfPgDelegaDao {
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

	protected SigitRPfPgDelegaDaoRowMapper findByPfRowMapper = new SigitRPfPgDelegaDaoRowMapper(null,
			SigitRPfPgDelegaFindByPfDto.class, this);

	protected SigitRPfPgDelegaDaoRowMapper findByPgRowMapper = new SigitRPfPgDelegaDaoRowMapper(null,
			SigitRPfPgDelegaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_PF_PG_DELEGA";
	}

	/** 
		 * Implementazione del finder findByPf con Qdef
		 * @generated
		 */

	public List<SigitRPfPgDelegaFindByPfDto> findFindByPf(Integer input) throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findFindByPf] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("select"
				+" pfPgDelega.ID_PERSONA_FISICA,"
				+" pg.ID_PERSONA_GIURIDICA,"
				+" pg.CODICE_FISCALE,"
				+" pg.SIGLA_REA,"
				+" pg.NUMERO_REA,"
				+" pg.DENOMINAZIONE,"
				+" pg.DATA_CESSAZIONE,"
				+" pg.FK_STATO_PG,"
				+" statoPg.DES_STATO_PG,"
				+" pg.FLG_DM37_LETTERAC,"
				+" pg.FLG_AMMINISTRATORE,"
				+" pg.FLG_SOGG_INCARICATO,"
				+" pg.FLG_TERZO_RESPONSABILE,"
				+" pg.FLG_DISTRIBUTORE,"
				+" pg.FLG_CAT"
				+" from"
				+" SIGIT_R_PF_PG_DELEGA pfPgDelega"
				+" join"
				+" SIGIT_T_PERSONA_GIURIDICA pg on"
				+" pfPgDelega.ID_PERSONA_GIURIDICA = pg.ID_PERSONA_GIURIDICA"
				+" and pfPgDelega.data_fine is null"
		+" join"
		+" SIGIT_D_STATO_PG statoPg on"
		+" pg.FK_STATO_PG = statoPg.ID_STATO_PG"
		+" where"
		+" pfPgDelega.id_persona_fisica = :id_persona_fisica");
		paramMap.addValue("id_persona_fisica", input);
		List<SigitRPfPgDelegaFindByPfDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByPfRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findFindByPf] ERROR esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findFindByPf", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findFindByPf] END");
		}
		return list;
	}

	public List<SigitRPfPgDelegaDto> findFindByPg(Integer input) throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findFindByPg] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_PERSONA_FISICA,ID_PERSONA_GIURIDICA,DATA_INIZIO,FK_RUOLO_ACCRED,FK_TIPO_DM,FLG_DELEGA,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD FROM "
				+getTableName()
				+" where"
				+" id_persona_giuridica = :id_persona_giuridica AND "
				+ "data_fine IS NULL");
		paramMap.addValue("id_persona_giuridica", input);
		List<SigitRPfPgDelegaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByPgRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findFindByPg] ERROR esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findFindByPg", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findFindByPg] END");
		}
		return list;
	}
	
	public List<SigitRPfPgDelegaDto> findFindByIdPersonaFisica(Integer input) throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findFindByPg] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_PERSONA_FISICA,ID_PERSONA_GIURIDICA,DATA_INIZIO,FK_RUOLO_ACCRED,FK_TIPO_DM,FLG_DELEGA,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD FROM "
				+getTableName()
				+" where"
				+" id_persona_fisica = :id_persona_fisica AND "
				+ "data_fine IS NULL");
		paramMap.addValue("id_persona_fisica", input);
		List<SigitRPfPgDelegaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByPgRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findFindByPg] ERROR esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findFindByPg", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findFindByPg] END");
		}
		return list;
	}
	
	public List<SigitRPfPgDelegaDto> findByPfAndPg(Integer idPersonaFisica, Integer idPersonaGiuridica) throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findFindByPg] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_PERSONA_FISICA,ID_PERSONA_GIURIDICA,DATA_INIZIO,FK_RUOLO_ACCRED,FK_TIPO_DM,FLG_DELEGA,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD FROM "
				+getTableName()
				+" where"
				+" id_persona_giuridica = :id_persona_giuridica AND "
				+" id_persona_fisica = :id_persona_fisica AND "
				+ "data_fine IS NULL");
		paramMap.addValue("id_persona_giuridica", idPersonaGiuridica);
		paramMap.addValue("id_persona_fisica", idPersonaFisica);
		List<SigitRPfPgDelegaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByPgRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findFindByPfAndPg] ERROR esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findFindByPfAndPg", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findFindByPfAndPg] END");
		}
		return list;
	}
	
	public void insert(SigitRPfPgDelegaDto dto) throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::insert] START");
		
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("INSERT INTO "
				+getTableName()
				+ " (id_persona_fisica, id_persona_giuridica, data_inizio, fk_ruolo_accred, fk_tipo_dm, flg_delega, data_fine, data_ult_mod, utente_ult_mod) "
				+ "VALUES "
				+ "(:id_persona_fisica, :id_persona_giuridica, :data_inizio, :fk_ruolo_accred, :fk_tipo_dm, :flg_delega, :data_fine, :data_ult_mod, :utente_ult_mod)");
				
		paramMap.addValue("id_persona_fisica", dto.getIdPersonaFisica());
		paramMap.addValue("id_persona_giuridica", dto.getIdPersonaGiuridica());
		paramMap.addValue("data_inizio", dto.getDataInizio());
		paramMap.addValue("fk_ruolo_accred", dto.getFkRuoloAccred());
		paramMap.addValue("fk_tipo_dm", dto.getFkTipoDm());
		paramMap.addValue("flg_delega", dto.getFlgDelega());
		paramMap.addValue("data_fine", dto.getDataFine());
		paramMap.addValue("data_ult_mod", dto.getDataUltMod());
		paramMap.addValue("utente_ult_mod", dto.getUtenteUltMod());
		
		insert(jdbcTemplate, sql.toString(), paramMap);

		LOG.debug("[SigitRPfPgDelegaDaoImpl::insert] END");
	}
	
	public void update(SigitRPfPgDelegaDto dto) throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::insert] START");
		
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("UPDATE "
				+getTableName()
				+ " SET data_fine = :data_fine, data_ult_mod = :data_ult_mod, utente_ult_mod = :utente_ult_mod "
				+ "WHERE id_persona_fisica = :id_persona_fisica AND id_persona_giuridica = :id_persona_giuridica AND data_inizio = :data_inizio");
				
		paramMap.addValue("id_persona_fisica", dto.getIdPersonaFisica());
		paramMap.addValue("id_persona_giuridica", dto.getIdPersonaGiuridica());
		paramMap.addValue("data_inizio", dto.getDataInizio());
		paramMap.addValue("data_fine", dto.getDataFine());
		paramMap.addValue("data_ult_mod", dto.getDataUltMod());
		paramMap.addValue("utente_ult_mod", dto.getUtenteUltMod());
		
		update(jdbcTemplate, sql.toString(), paramMap);

		LOG.debug("[SigitRPfPgDelegaDaoImpl::insert] END");
	}
}
