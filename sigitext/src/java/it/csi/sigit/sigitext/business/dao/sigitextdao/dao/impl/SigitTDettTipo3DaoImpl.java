package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTDettTipo3Dao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTDettTipo3DaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo3Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo3Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDettTipo3DaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class SigitTDettTipo3DaoImpl extends AbstractDAO implements SigitTDettTipo3Dao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	protected NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public SigitTDettTipo3Pk insert(SigitTDettTipo3Dto dto) {
		LOG.debug("[SigitTDettTipo3DaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_DETT_TIPO3,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FK_FLUIDO,FK_FLUIDO_ALIMENTAZ,E_FLUIDO_ALTRO,E_ALIMENTAZIONE_ALTRO,E_FLG_CLIMA_INVERNO,E_FLG_PRODUZ_ACS,E_FLG_POTENZA_COMPATIBILE,E_FLG_COIB_IDONEA,E_FLG_DISP_FUNZIONANTI,E_TEMP_EXT_C,E_TEMP_MAND_PRIMARIO_C,E_TEMP_RITOR_PRIMARIO_C,E_TEMP_MAND_SECONDARIO_C,E_TEMP_RIT_SECONDARIO_C,E_POTENZA_TERM_KW,E_PORT_FLUIDO_M3_H,DATA_ULT_MOD,UTENTE_ULT_MOD,E_CONTROLLOWEB ) VALUES (  :ID_DETT_TIPO3 , :FK_ALLEGATO , :CODICE_IMPIANTO , :FK_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :FK_FLUIDO , :FK_FLUIDO_ALIMENTAZ , :E_FLUIDO_ALTRO , :E_ALIMENTAZIONE_ALTRO , :E_FLG_CLIMA_INVERNO , :E_FLG_PRODUZ_ACS , :E_FLG_POTENZA_COMPATIBILE , :E_FLG_COIB_IDONEA , :E_FLG_DISP_FUNZIONANTI , :E_TEMP_EXT_C , :E_TEMP_MAND_PRIMARIO_C , :E_TEMP_RITOR_PRIMARIO_C , :E_TEMP_MAND_SECONDARIO_C , :E_TEMP_RIT_SECONDARIO_C , :E_POTENZA_TERM_KW , :E_PORT_FLUIDO_M3_H , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :E_CONTROLLOWEB  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DETT_TIPO3]
		params.addValue("ID_DETT_TIPO3", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_COMPONENTE]
		params.addValue("FK_TIPO_COMPONENTE", dto.getFkTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_FLUIDO]
		params.addValue("FK_FLUIDO", dto.getFkFluido(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_FLUIDO_ALIMENTAZ]
		params.addValue("FK_FLUIDO_ALIMENTAZ", dto.getFkFluidoAlimentaz(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLUIDO_ALTRO]
		params.addValue("E_FLUIDO_ALTRO", dto.getEFluidoAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_ALIMENTAZIONE_ALTRO]
		params.addValue("E_ALIMENTAZIONE_ALTRO", dto.getEAlimentazioneAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_FLG_CLIMA_INVERNO]
		params.addValue("E_FLG_CLIMA_INVERNO", dto.getEFlgClimaInverno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_PRODUZ_ACS]
		params.addValue("E_FLG_PRODUZ_ACS", dto.getEFlgProduzAcs(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_POTENZA_COMPATIBILE]
		params.addValue("E_FLG_POTENZA_COMPATIBILE", dto.getEFlgPotenzaCompatibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_COIB_IDONEA]
		params.addValue("E_FLG_COIB_IDONEA", dto.getEFlgCoibIdonea(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_DISP_FUNZIONANTI]
		params.addValue("E_FLG_DISP_FUNZIONANTI", dto.getEFlgDispFunzionanti(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_EXT_C]
		params.addValue("E_TEMP_EXT_C", dto.getETempExtC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_MAND_PRIMARIO_C]
		params.addValue("E_TEMP_MAND_PRIMARIO_C", dto.getETempMandPrimarioC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_RITOR_PRIMARIO_C]
		params.addValue("E_TEMP_RITOR_PRIMARIO_C", dto.getETempRitorPrimarioC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_MAND_SECONDARIO_C]
		params.addValue("E_TEMP_MAND_SECONDARIO_C", dto.getETempMandSecondarioC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_RIT_SECONDARIO_C]
		params.addValue("E_TEMP_RIT_SECONDARIO_C", dto.getETempRitSecondarioC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_POTENZA_TERM_KW]
		params.addValue("E_POTENZA_TERM_KW", dto.getEPotenzaTermKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_PORT_FLUIDO_M3_H]
		params.addValue("E_PORT_FLUIDO_M3_H", dto.getEPortFluidoM3H(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_CONTROLLOWEB]
		params.addValue("E_CONTROLLOWEB", dto.getEControlloweb(), java.sql.Types.TIMESTAMP);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdDettTipo3(newKey);
		LOG.debug("[SigitTDettTipo3DaoImpl::insert] END");
		return dto.createPk();

	}

	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitTDettTipo3DaoException {
		LOG.debug("[SigitTDettTipo3DaoImpl::customDeleterByIdAllegato] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE FK_ALLEGATO = :idAllegato";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idAllegato", filter);
		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettTipo3DaoImpl::customDeleterByIdAllegato] END");
	}

	protected SigitTDettTipo3DaoRowMapper byAllegatoCodImpiantoRowMapper = new SigitTDettTipo3DaoRowMapper(null, SigitTDettTipo3Dto.class, this);

	public List<SigitTDettTipo3Dto> findByAllegatoCodImpianto(SigitTDettTipo3Dto input) throws SigitTDettTipo3DaoException {
		LOG.debug("[SigitTDettTipo3DaoImpl::findByAllegatoCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		sql.append("SELECT ID_DETT_TIPO3,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FK_FLUIDO,FK_FLUIDO_ALIMENTAZ,E_FLUIDO_ALTRO,E_ALIMENTAZIONE_ALTRO,E_FLG_CLIMA_INVERNO,E_FLG_PRODUZ_ACS,E_FLG_POTENZA_COMPATIBILE,E_FLG_COIB_IDONEA,E_FLG_DISP_FUNZIONANTI,E_TEMP_EXT_C,E_TEMP_MAND_PRIMARIO_C,E_TEMP_RITOR_PRIMARIO_C,E_TEMP_MAND_SECONDARIO_C,E_TEMP_RIT_SECONDARIO_C,E_POTENZA_TERM_KW,E_PORT_FLUIDO_M3_H,DATA_ULT_MOD,UTENTE_ULT_MOD,E_CONTROLLOWEB ");
		sql.append(" FROM SIGIT_T_DETT_TIPO3");
		sql.append(" WHERE ");
		sql.append(" 1 = 1 ");
		if (input.getFkAllegato() != null) {
			sql.append(" AND  FK_ALLEGATO = :idAllegato ");
		}
		if (input.getCodiceImpianto() != null) {
			sql.append(" AND  CODICE_IMPIANTO = :idCodiceImpianto ");
		}
		if (input.getProgressivo() != null) {
			sql.append(" AND  PROGRESSIVO = :progressivo ");
		}
		sql.append(" ORDER BY PROGRESSIVO ");
		if (input.getFkAllegato() != null) {
			paramMap.addValue("idAllegato", input.getFkAllegato());
		}
		if (input.getCodiceImpianto() != null) {
			paramMap.addValue("idCodiceImpianto", input.getCodiceImpianto());
		}

		if (input.getProgressivo() != null) {
			paramMap.addValue("progressivo", input.getProgressivo());
		}
		/*PROTECTED REGION END*/
		List<SigitTDettTipo3Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAllegatoCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDettTipo3DaoImpl::findByAllegatoCodImpianto] esecuzione query", ex);
			throw new SigitTDettTipo3DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDettTipo3DaoImpl", "findByAllegatoCodImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDettTipo3DaoImpl::findByAllegatoCodImpianto] END");
		}
		return list;
	}

	public void update(SigitTDettTipo3Dto dto) throws SigitTDettTipo3DaoException {
		LOG.debug("[SigitTDettTipo3DaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_ALLEGATO = :FK_ALLEGATO ,CODICE_IMPIANTO = :CODICE_IMPIANTO ,FK_TIPO_COMPONENTE = :FK_TIPO_COMPONENTE ,PROGRESSIVO = :PROGRESSIVO ,DATA_INSTALL = :DATA_INSTALL ,FK_FLUIDO = :FK_FLUIDO ,FK_FLUIDO_ALIMENTAZ = :FK_FLUIDO_ALIMENTAZ ,E_FLUIDO_ALTRO = :E_FLUIDO_ALTRO ,E_ALIMENTAZIONE_ALTRO = :E_ALIMENTAZIONE_ALTRO ,E_FLG_CLIMA_INVERNO = :E_FLG_CLIMA_INVERNO ,E_FLG_PRODUZ_ACS = :E_FLG_PRODUZ_ACS ,E_FLG_POTENZA_COMPATIBILE = :E_FLG_POTENZA_COMPATIBILE ,E_FLG_COIB_IDONEA = :E_FLG_COIB_IDONEA ,E_FLG_DISP_FUNZIONANTI = :E_FLG_DISP_FUNZIONANTI ,E_TEMP_EXT_C = :E_TEMP_EXT_C ,E_TEMP_MAND_PRIMARIO_C = :E_TEMP_MAND_PRIMARIO_C ,E_TEMP_RITOR_PRIMARIO_C = :E_TEMP_RITOR_PRIMARIO_C ,E_TEMP_MAND_SECONDARIO_C = :E_TEMP_MAND_SECONDARIO_C ,E_TEMP_RIT_SECONDARIO_C = :E_TEMP_RIT_SECONDARIO_C ,E_POTENZA_TERM_KW = :E_POTENZA_TERM_KW ,E_PORT_FLUIDO_M3_H = :E_PORT_FLUIDO_M3_H ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,E_CONTROLLOWEB = :E_CONTROLLOWEB  WHERE ID_DETT_TIPO3 = :ID_DETT_TIPO3 ";

		if (dto.getIdDettTipo3() == null) {
			LOG.error("[SigitTDettTipo3DaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTDettTipo3DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DETT_TIPO3]
		params.addValue("ID_DETT_TIPO3", dto.getIdDettTipo3(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_COMPONENTE]
		params.addValue("FK_TIPO_COMPONENTE", dto.getFkTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_FLUIDO]
		params.addValue("FK_FLUIDO", dto.getFkFluido(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_FLUIDO_ALIMENTAZ]
		params.addValue("FK_FLUIDO_ALIMENTAZ", dto.getFkFluidoAlimentaz(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLUIDO_ALTRO]
		params.addValue("E_FLUIDO_ALTRO", dto.getEFluidoAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_ALIMENTAZIONE_ALTRO]
		params.addValue("E_ALIMENTAZIONE_ALTRO", dto.getEAlimentazioneAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_FLG_CLIMA_INVERNO]
		params.addValue("E_FLG_CLIMA_INVERNO", dto.getEFlgClimaInverno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_PRODUZ_ACS]
		params.addValue("E_FLG_PRODUZ_ACS", dto.getEFlgProduzAcs(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_POTENZA_COMPATIBILE]
		params.addValue("E_FLG_POTENZA_COMPATIBILE", dto.getEFlgPotenzaCompatibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_COIB_IDONEA]
		params.addValue("E_FLG_COIB_IDONEA", dto.getEFlgCoibIdonea(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_DISP_FUNZIONANTI]
		params.addValue("E_FLG_DISP_FUNZIONANTI", dto.getEFlgDispFunzionanti(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_EXT_C]
		params.addValue("E_TEMP_EXT_C", dto.getETempExtC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_MAND_PRIMARIO_C]
		params.addValue("E_TEMP_MAND_PRIMARIO_C", dto.getETempMandPrimarioC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_RITOR_PRIMARIO_C]
		params.addValue("E_TEMP_RITOR_PRIMARIO_C", dto.getETempRitorPrimarioC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_MAND_SECONDARIO_C]
		params.addValue("E_TEMP_MAND_SECONDARIO_C", dto.getETempMandSecondarioC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_RIT_SECONDARIO_C]
		params.addValue("E_TEMP_RIT_SECONDARIO_C", dto.getETempRitSecondarioC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_POTENZA_TERM_KW]
		params.addValue("E_POTENZA_TERM_KW", dto.getEPotenzaTermKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_PORT_FLUIDO_M3_H]
		params.addValue("E_PORT_FLUIDO_M3_H", dto.getEPortFluidoM3H(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_CONTROLLOWEB]
		params.addValue("E_CONTROLLOWEB", dto.getEControlloweb(), java.sql.Types.TIMESTAMP);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettTipo3DaoImpl::update] END");
	}

	public String getTableName() {
		return "SIGIT_T_DETT_TIPO3";
	}

}
