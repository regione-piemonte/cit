package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTStoricoVarStatoPgDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTStoricoVarStatoPgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTStoricoVarStatoPgDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;

public class SigitTStoricoVarStatoPgDaoImpl extends AbstractDAO implements SigitTStoricoVarStatoPgDao {
	
	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE);
	
	protected NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String getTableName() {
		return "sigit_t_storico_var_stato_pg";
	}

	@Override
	public void insert(SigitTStoricoVarStatoPgDto dto) throws SigitTStoricoVarStatoPgDaoException {
		logger.debug("[SigitTStoricoVarStatoPgDaoImpl::insert] START");
		
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("INSERT INTO "
				+ getTableName()
				+ " (dt_evento, id_persona_giuridica, dt_inizio_variazione, motivo, stato_pg_da, stato_pg_a, data_ult_mod, utente_ult_mod) "
				+ "VALUES "
				+ "(:dt_evento, :id_persona_giuridica, :dt_inizio_variazione, :motivo, :stato_pg_da, :stato_pg_a, :data_ult_mod, :utente_ult_mod)");
		
		paramMap.addValue("dt_evento", dto.getDt_evento());
		paramMap.addValue("id_persona_giuridica", dto.getId_persona_giuridica());
		paramMap.addValue("dt_inizio_variazione", dto.getDt_inizio_variazione());
		paramMap.addValue("motivo", dto.getMotivo());
		paramMap.addValue("stato_pg_da", dto.getStato_pg_da());
		paramMap.addValue("stato_pg_a", dto.getStato_pg_a());
		paramMap.addValue("data_ult_mod", dto.getData_ult_mod());
		paramMap.addValue("utente_ult_mod", dto.getUtente_ult_mod());
		
		insert(jdbcTemplate, sql.toString(), paramMap);

		logger.debug("[SigitTStoricoVarStatoPgDaoImpl::insert] END");
	}

	@Override
	public void update(SigitTStoricoVarStatoPgDto dto) throws SigitTStoricoVarStatoPgDaoException {
logger.debug("[SigitTStoricoVarStatoPgDaoImpl::update] START");
		
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("UPDATE "
				+ getTableName()
				+ " SET dt_inizio_variazione = :dt_inizio_variazione, motivo = :motivo, stato_pg_da = :stato_pg_da, stato_pg_a = :stato_pg_a, data_ult_mod = :data_ult_mod, utente_ult_mod = :utente_ult_mod "
				+ "WHERE "
				+ "dt_evento = :dt_evento AND id_persona_giuridica = :id_persona_giuridica");
				
		paramMap.addValue("dt_evento", dto.getDt_evento());
		paramMap.addValue("id_persona_giuridica", dto.getId_persona_giuridica());
		paramMap.addValue("dt_inizio_variazione", dto.getDt_inizio_variazione());
		paramMap.addValue("motivo", dto.getMotivo());
		paramMap.addValue("stato_pg_da", dto.getStato_pg_da());
		paramMap.addValue("stato_pg_a", dto.getStato_pg_a());
		paramMap.addValue("data_ult_mod", dto.getData_ult_mod());
		paramMap.addValue("utente_ult_mod", dto.getUtente_ult_mod());
		
		insert(jdbcTemplate, sql.toString(), paramMap);

		logger.debug("[SigitTStoricoVarStatoPgDaoImpl::update] END");
	}

}
