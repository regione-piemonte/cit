package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTDettIspezGtDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTDettIspezGtDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettIspezGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettIspezGtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDettIspezGtDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.util.performance.StopWatch;

public class SigitTDettIspezGtDaoImpl  extends AbstractDAO implements SigitTDettIspezGtDao{
	
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
	
	protected SigitTDettIspezGtDaoRowMapper byExampleRowMapper = new SigitTDettIspezGtDaoRowMapper(null,
			SigitTDettIspezGtDto.class, this);

	/**
	 * Metodo di inserimento del DAO sigitTVerifica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTVerificaPk
	 * @generated
	 */
	
	public String getTableName() {
		return "SIGIT_T_DETT_ISPEZ_GT";
	}

	public SigitTDettIspezGtPk insert(SigitTDettIspezGtDto dto)

	{
		LOG.debug("[SigitTRappIspezGtDtoImpl::insert] START");	

		final String sql = "INSERT INTO " + getTableName()
				+ " (   ID_DETT_ISPEZ_GT, FK_ALLEGATO, FK_TIPO_COMPONENTE, PROGRESSIVO, CODICE_IMPIANTO, DATA_INSTALL, DATA_ULT_MOD, UTENTE_ULT_MOD, S6D_FLG_EVACU_FUMI, S6I_FLG_TIPO_B, S6I_FLG_TIPO_C, S6J_FK_CLASS_DPR660_96, S6K_POT_TERM_FOCOL_KW, S6K_BRUCIATORE_DA_KW, S6K_BRUCIATORE_A_KW, S6L_PORTATA_COMB_M3_H, S6L_PORTATA_COMB_KG_H, S6L_POT_TERM_FOCOL_KW, S7A_FK_FREQUENZA_MANUT, S7A_FREQUENZA_MANUT_ALTRO, S7A_FLG_MANUT_EFFETTUATA, S7A_DATA_ULTIMA_MANUT, S7B_FLG_REE_PRESENTE, S7B_DATA_REE, S7B_FLG_OSSERVAZIONI, S7B_FLG_RACCOMAND, S7B_FLG_PRESCR, S8A_N_MODULO_TERMICO, S8B_FUMO_MIS_1, S8B_FUMO_MIS_2, S8B_FUMO_MIS_3, S8C_MARCA_STRUM_MISURA, S8C_MODELLO_STRUM_MISURA, S8C_MATRICOLA_STRUM_MISURA, S8D_TEMP_FLUIDO_MANDATA_C, S8D_TEMP_ARIA_C, S8D_TEMP_FUMI_C, S8D_O2_PERC, S8D_CO2_PERC, S8D_CO_FUMI_SECCHI_PPM, S8D_NO_MG_KW_H, S8E_INDICE_ARIA, S8E_FUMI_SECCHI_NO_ARIA_PPM, S8E_QS_PERC, S8E_ET_PERC, S8E_REND_COMB_PERC, S8E_NOX_MG_KW_H, S9A_FLG_MONOSSIDO_CARB, S9B_FLG_FUMOSITA, S9C_REND_MIN_COMBUST_PERC, S9C_FLG_REND_COMBUST_SUFF, S9D_OSSIDI_AZOTO_LIM_MG_KW_H, S9D_FLG_OSSIDI_AZOTO, S9E_FLG_RISPETTO_NORMATIVA, S9E_FLG_NO_RISPETTO_7A, S9E_FLG_NO_RISPETTO_7B, S9E_FLG_NO_RISPETTO_9A, S9E_FLG_NO_RISPETTO_9B, S9E_FLG_NO_RISPETTO_9C, S9E_FLG_NO_RISPETTO_9D, CONTROLLOWEB ) " 
				+ " VALUES (  :ID_DETT_ISPEZ_GT, :FK_ALLEGATO, :FK_TIPO_COMPONENTE, :PROGRESSIVO, :CODICE_IMPIANTO, :DATA_INSTALL, :DATA_ULT_MOD, :UTENTE_ULT_MOD, :S6D_FLG_EVACU_FUMI, :S6I_FLG_TIPO_B, :S6I_FLG_TIPO_C, :S6J_FK_CLASS_DPR660_96, :S6K_POT_TERM_FOCOL_KW, :S6K_BRUCIATORE_DA_KW, :S6K_BRUCIATORE_A_KW, :S6L_PORTATA_COMB_M3_H, :S6L_PORTATA_COMB_KG_H, :S6L_POT_TERM_FOCOL_KW, :S7A_FK_FREQUENZA_MANUT, :S7A_FREQUENZA_MANUT_ALTRO, :S7A_FLG_MANUT_EFFETTUATA, :S7A_DATA_ULTIMA_MANUT, :S7B_FLG_REE_PRESENTE, :S7B_DATA_REE, :S7B_FLG_OSSERVAZIONI, :S7B_FLG_RACCOMAND, :S7B_FLG_PRESCR, :S8A_N_MODULO_TERMICO, :S8B_FUMO_MIS_1, :S8B_FUMO_MIS_2, :S8B_FUMO_MIS_3, :S8C_MARCA_STRUM_MISURA, :S8C_MODELLO_STRUM_MISURA, :S8C_MATRICOLA_STRUM_MISURA, :S8D_TEMP_FLUIDO_MANDATA_C, :S8D_TEMP_ARIA_C, :S8D_TEMP_FUMI_C, :S8D_O2_PERC, :S8D_CO2_PERC, :S8D_CO_FUMI_SECCHI_PPM, :S8D_NO_MG_KW_H, :S8E_INDICE_ARIA, :S8E_FUMI_SECCHI_NO_ARIA_PPM, :S8E_QS_PERC, :S8E_ET_PERC, :S8E_REND_COMB_PERC, :S8E_NOX_MG_KW_H, :S9A_FLG_MONOSSIDO_CARB, :S9B_FLG_FUMOSITA, :S9C_REND_MIN_COMBUST_PERC, :S9C_FLG_REND_COMBUST_SUFF, :S9D_OSSIDI_AZOTO_LIM_MG_KW_H, :S9D_FLG_OSSIDI_AZOTO, :S9E_FLG_RISPETTO_NORMATIVA, :S9E_FLG_NO_RISPETTO_7A, :S9E_FLG_NO_RISPETTO_7B, :S9E_FLG_NO_RISPETTO_9A, :S9E_FLG_NO_RISPETTO_9B, :S9E_FLG_NO_RISPETTO_9C, :S9E_FLG_NO_RISPETTO_9D, :CONTROLLOWEB )";

		MapSqlParameterSource params = new MapSqlParameterSource();
		
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());
		  		
		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_DETT_ISPEZ_GT", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1C_FLG_REE_INVIATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1C_FLG_REE_BOLLINO]
		params.addValue("FK_TIPO_COMPONENTE", dto.getFkTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S1C_SIGLA_BOLLINO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1C_NUM_BOLLINO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1E_DT_PRIMA_INSTALLAZIONE]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [S1E_POT_UTILE_KW]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [S1L_DENOM_DELEGATO]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);		

		params.addValue("S6D_FLG_EVACU_FUMI", dto.getS6dFlgEvacuFumi(), java.sql.Types.VARCHAR);
		params.addValue("S6I_FLG_TIPO_B", dto.getS6iFlgTipoB(), java.sql.Types.NUMERIC);
		params.addValue("S6I_FLG_TIPO_C", dto.getS6iFlgTipoC(), java.sql.Types.NUMERIC);
		params.addValue("S6J_FK_CLASS_DPR660_96", dto.getS6jFkClassDpr66096(), java.sql.Types.VARCHAR);
		params.addValue("S6K_POT_TERM_FOCOL_KW", dto.getS6kPotTermFocolKw(), java.sql.Types.NUMERIC);
		params.addValue("S6K_BRUCIATORE_DA_KW", dto.getS6kBruciatoreDaKw(), java.sql.Types.NUMERIC);
		params.addValue("S6K_BRUCIATORE_A_KW", dto.getS6kBruciatoreAKw(), java.sql.Types.NUMERIC);
		params.addValue("S6L_PORTATA_COMB_M3_H", dto.getS6lPortataCombM3H(), java.sql.Types.NUMERIC);
		params.addValue("S6L_PORTATA_COMB_KG_H", dto.getS6lPortataCombKgH(), java.sql.Types.VARCHAR);
		params.addValue("S6L_POT_TERM_FOCOL_KW", dto.getS6lPotTermFocolKw(), java.sql.Types.NUMERIC);
		params.addValue("S7A_FK_FREQUENZA_MANUT", dto.getS7aFkFrequenzaManut(), java.sql.Types.NUMERIC);
		params.addValue("S7A_FREQUENZA_MANUT_ALTRO", dto.getS7aFrequenzaManutAltro(), java.sql.Types.VARCHAR);
		params.addValue("S7A_FLG_MANUT_EFFETTUATA", dto.getS7aFlgManutEffettuata(), java.sql.Types.NUMERIC);
		params.addValue("S7A_DATA_ULTIMA_MANUT", dto.getS7aDataUltimaManut(), java.sql.Types.DATE);
		params.addValue("S7B_FLG_REE_PRESENTE", dto.getS7bFlgReePresente(), java.sql.Types.NUMERIC);
		params.addValue("S7B_DATA_REE", dto.getS7bDataRee(), java.sql.Types.DATE);
		params.addValue("S7B_FLG_OSSERVAZIONI", dto.getS7bFlgOsservazioni(), java.sql.Types.NUMERIC);
		params.addValue("S7B_FLG_RACCOMAND", dto.getS7bFlgRaccomand(), java.sql.Types.NUMERIC);
		params.addValue("S7B_FLG_PRESCR", dto.getS7bFlgPrescr(), java.sql.Types.NUMERIC);
		params.addValue("S8A_N_MODULO_TERMICO", dto.getS8aNModuloTermico(), java.sql.Types.VARCHAR);
		params.addValue("S8B_FUMO_MIS_1", dto.getS8bFumoMis1(), java.sql.Types.NUMERIC);
		params.addValue("S8B_FUMO_MIS_2", dto.getS8bFumoMis2(), java.sql.Types.NUMERIC);
		params.addValue("S8B_FUMO_MIS_3", dto.getS8bFumoMis3(), java.sql.Types.NUMERIC);
		params.addValue("S8C_MARCA_STRUM_MISURA", dto.getS8cMarcaStrumMisura(), java.sql.Types.VARCHAR);
		params.addValue("S8C_MODELLO_STRUM_MISURA", dto.getS8cModelloStrumMisura(), java.sql.Types.VARCHAR);
		params.addValue("S8C_MATRICOLA_STRUM_MISURA", dto.getS8cMatricolaStrumMisura(), java.sql.Types.VARCHAR);
		params.addValue("S8D_TEMP_FLUIDO_MANDATA_C", dto.getS8dTempFluidoMandataC(), java.sql.Types.NUMERIC);
		params.addValue("S8D_TEMP_ARIA_C", dto.getS8dTempAriaC(), java.sql.Types.NUMERIC);
		params.addValue("S8D_TEMP_FUMI_C", dto.getS8dTempFumiC(), java.sql.Types.NUMERIC);
		params.addValue("S8D_O2_PERC", dto.getS8dO2Perc(), java.sql.Types.NUMERIC);
		params.addValue("S8D_CO2_PERC", dto.getS8dCo2Perc(), java.sql.Types.NUMERIC);
		params.addValue("S8D_CO_FUMI_SECCHI_PPM", dto.getS8dCoFumiSecchiPpm(), java.sql.Types.NUMERIC);
		params.addValue("S8D_NO_MG_KW_H", dto.getS8dNoMgKwH(), java.sql.Types.NUMERIC);
		params.addValue("S8E_INDICE_ARIA", dto.getS8eIndiceAria(), java.sql.Types.NUMERIC);
		params.addValue("S8E_FUMI_SECCHI_NO_ARIA_PPM", dto.getS8eFumiSecchiNoAriaPpm(), java.sql.Types.NUMERIC);
		params.addValue("S8E_QS_PERC", dto.getS8eQsPerc(), java.sql.Types.NUMERIC);
		params.addValue("S8E_ET_PERC", dto.getS8eEtPerc(), java.sql.Types.NUMERIC);
		params.addValue("S8E_REND_COMB_PERC", dto.getS8eRendCombPerc(), java.sql.Types.NUMERIC);
		params.addValue("S8E_NOX_MG_KW_H", dto.getS8eNoxMgKwH(), java.sql.Types.NUMERIC);
		params.addValue("S9A_FLG_MONOSSIDO_CARB", dto.getS9aFlgMonossidoCarb(), java.sql.Types.VARCHAR);
		params.addValue("S9B_FLG_FUMOSITA", dto.getS9bFlgFumosita(), java.sql.Types.VARCHAR);
		params.addValue("S9C_REND_MIN_COMBUST_PERC", dto.getS9cRendMinCombustPerc(), java.sql.Types.NUMERIC);
		params.addValue("S9C_FLG_REND_COMBUST_SUFF", dto.getS9cFlgRendCombustSuff(), java.sql.Types.NUMERIC);
		params.addValue("S9D_OSSIDI_AZOTO_LIM_MG_KW_H", dto.getS9dOssidiAzotoLimMgKwH(), java.sql.Types.NUMERIC);
		params.addValue("S9D_FLG_OSSIDI_AZOTO", dto.getS9dFlgOssidiAzoto(), java.sql.Types.VARCHAR);
		params.addValue("S9E_FLG_RISPETTO_NORMATIVA", dto.getS9eFlgRispettoNormativa(), java.sql.Types.NUMERIC);
		params.addValue("S9E_FLG_NO_RISPETTO_7A", dto.getS9eFlgNoRispetto7a(), java.sql.Types.NUMERIC);
		params.addValue("S9E_FLG_NO_RISPETTO_7B", dto.getS9eFlgNoRispetto7b(), java.sql.Types.NUMERIC);
		params.addValue("S9E_FLG_NO_RISPETTO_9A", dto.getS9eFlgNoRispetto9a(), java.sql.Types.NUMERIC);
		params.addValue("S9E_FLG_NO_RISPETTO_9B", dto.getS9eFlgNoRispetto9b(), java.sql.Types.NUMERIC);
		params.addValue("S9E_FLG_NO_RISPETTO_9C", dto.getS9eFlgNoRispetto9c(), java.sql.Types.NUMERIC);
		params.addValue("S9E_FLG_NO_RISPETTO_9D", dto.getS9eFlgNoRispetto9d(), java.sql.Types.NUMERIC);
		params.addValue("CONTROLLOWEB", dto.getControlloWeb(), java.sql.Types.TIMESTAMP);
				
		insert(jdbcTemplate, sql, params);
		
		dto.setSigitTDettIspezGtPk(new SigitTDettIspezGtPk());		
		dto.getSigitTDettIspezGtPk().setIdDettIspezGt(newKey);
		
		LOG.debug("[SigitTRappIspezGtDtoImpl::insert] END");
		return dto.getSigitTDettIspezGtPk();

	}
		
	public List<SigitTDettIspezGtDto> findByFkAllegato(BigDecimal fkAllegato) throws SigitTDettIspezGtDaoException {
		
			
		LOG.debug("[SigitTDettIspezGtDaoImpl::findByPrimaryKey] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_DETT_ISPEZ_GT, FK_ALLEGATO, FK_TIPO_COMPONENTE, PROGRESSIVO, CODICE_IMPIANTO, DATA_INSTALL, S6D_FLG_EVACU_FUMI, S6I_FLG_TIPO_B, " +
				"S6I_FLG_TIPO_C, S6J_FK_CLASS_DPR660_96, S6K_POT_TERM_FOCOL_KW, S6K_BRUCIATORE_DA_KW, S6K_BRUCIATORE_A_KW, S6L_PORTATA_COMB_M3_H, S6L_PORTATA_COMB_KG_H, " +
				"S6L_POT_TERM_FOCOL_KW, S7A_FLG_MANUT_EFFETTUATA, S7A_DATA_ULTIMA_MANUT, S7B_FLG_REE_PRESENTE, S7B_DATA_REE, S7B_FLG_OSSERVAZIONI, S7B_FLG_RACCOMAND, " +
				"S7B_FLG_PRESCR, S8A_N_MODULO_TERMICO, S8B_FUMO_MIS_1, S8B_FUMO_MIS_2, S8B_FUMO_MIS_3, S8C_MARCA_STRUM_MISURA, S8C_MODELLO_STRUM_MISURA, " +
				"S8C_MATRICOLA_STRUM_MISURA, S8D_TEMP_FLUIDO_MANDATA_C, S8D_TEMP_ARIA_C, S8D_TEMP_FUMI_C, S8D_O2_PERC, S8D_CO2_PERC, S8D_CO_FUMI_SECCHI_PPM, S8D_NO_MG_KW_H, " +
				"S8E_INDICE_ARIA, S8E_FUMI_SECCHI_NO_ARIA_PPM, S8E_QS_PERC, S8E_ET_PERC, S8E_REND_COMB_PERC, S8E_NOX_MG_KW_H, S9A_FLG_MONOSSIDO_CARB, S9B_FLG_FUMOSITA, " +
				"S9C_REND_MIN_COMBUST_PERC, S9C_FLG_REND_COMBUST_SUFF, S9D_OSSIDI_AZOTO_LIM_MG_KW_H, S9D_FLG_OSSIDI_AZOTO, S9E_FLG_RISPETTO_NORMATIVA, S9E_FLG_NO_RISPETTO_7A, " +
				"S9E_FLG_NO_RISPETTO_7B, S9E_FLG_NO_RISPETTO_9A, S9E_FLG_NO_RISPETTO_9B, S9E_FLG_NO_RISPETTO_9C, S9E_FLG_NO_RISPETTO_9D, DATA_ULT_MOD, UTENTE_ULT_MOD, " +
				"CONTROLLOWEB, S7A_FREQUENZA_MANUT_ALTRO, S7A_FK_FREQUENZA_MANUT ");
		sql.append(" FROM "+getTableName());
		sql.append(" WHERE FK_ALLEGATO = :FK_ALLEGATO");
		sql.append(" ORDER BY S8A_N_MODULO_TERMICO");

		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByFkAllegato] query: " + sql);


		paramMap.addValue("FK_ALLEGATO", fkAllegato);

		/*PROTECTED REGION END*/
		List<SigitTDettIspezGtDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, new RowMapper<SigitTDettIspezGtDto>() {

				@Override
				public SigitTDettIspezGtDto mapRow(ResultSet rs, int arg1) throws SQLException {
					SigitTDettIspezGtDto sigitTDettIspezGtDto = new SigitTDettIspezGtDto();
					sigitTDettIspezGtDto.setControlloWeb(rs.getTimestamp("CONTROLLOWEB"));		
					sigitTDettIspezGtDto.setIdDettIspezGt(rs.getBigDecimal("ID_DETT_ISPEZ_GT"));
					sigitTDettIspezGtDto.setFkAllegato(rs.getBigDecimal("FK_ALLEGATO"));
					sigitTDettIspezGtDto.setFkTipoComponente(rs.getString("FK_TIPO_COMPONENTE"));
					sigitTDettIspezGtDto.setProgressivo(rs.getBigDecimal("PROGRESSIVO"));
					sigitTDettIspezGtDto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));
					sigitTDettIspezGtDto.setDataInstall(rs.getDate("DATA_INSTALL"));
					sigitTDettIspezGtDto.setS6dFlgEvacuFumi(rs.getString("S6D_FLG_EVACU_FUMI"));
					sigitTDettIspezGtDto.setS6iFlgTipoB(rs.getBigDecimal("S6I_FLG_TIPO_B"));
					sigitTDettIspezGtDto.setS6iFlgTipoC(rs.getBigDecimal("S6I_FLG_TIPO_C"));
					sigitTDettIspezGtDto.setS6jFkClassDpr66096(rs.getString("S6J_FK_CLASS_DPR660_96"));
					sigitTDettIspezGtDto.setS6kPotTermFocolKw(rs.getBigDecimal("S6K_POT_TERM_FOCOL_KW"));
					sigitTDettIspezGtDto.setS6kBruciatoreDaKw(rs.getBigDecimal("S6K_BRUCIATORE_DA_KW"));
					sigitTDettIspezGtDto.setS6kBruciatoreAKw(rs.getBigDecimal("S6K_BRUCIATORE_A_KW"));
					sigitTDettIspezGtDto.setS6lPortataCombM3H(rs.getBigDecimal("S6L_PORTATA_COMB_M3_H"));
					sigitTDettIspezGtDto.setS6lPortataCombKgH(rs.getString("S6L_PORTATA_COMB_KG_H"));
					sigitTDettIspezGtDto.setS6lPotTermFocolKw(rs.getBigDecimal("S6L_POT_TERM_FOCOL_KW"));
					sigitTDettIspezGtDto.setS7aFlgManutEffettuata(rs.getBigDecimal("S7A_FLG_MANUT_EFFETTUATA"));
					sigitTDettIspezGtDto.setS7aDataUltimaManut(rs.getDate("S7A_DATA_ULTIMA_MANUT"));
					sigitTDettIspezGtDto.setS7bFlgReePresente(rs.getBigDecimal("S7B_FLG_REE_PRESENTE"));
					sigitTDettIspezGtDto.setS7bDataRee(rs.getDate("S7B_DATA_REE"));
					sigitTDettIspezGtDto.setS7bFlgOsservazioni(rs.getBigDecimal("S7B_FLG_OSSERVAZIONI"));
					sigitTDettIspezGtDto.setS7bFlgRaccomand(rs.getBigDecimal("S7B_FLG_RACCOMAND"));
					sigitTDettIspezGtDto.setS7bFlgPrescr(rs.getBigDecimal("S7B_FLG_PRESCR"));
					sigitTDettIspezGtDto.setS8aNModuloTermico(rs.getString("S8A_N_MODULO_TERMICO"));
					sigitTDettIspezGtDto.setS8bFumoMis1(rs.getBigDecimal("S8B_FUMO_MIS_1"));
					sigitTDettIspezGtDto.setS8bFumoMis2(rs.getBigDecimal("S8B_FUMO_MIS_2"));
					sigitTDettIspezGtDto.setS8bFumoMis3(rs.getBigDecimal("S8B_FUMO_MIS_3"));
					sigitTDettIspezGtDto.setS8cMarcaStrumMisura(rs.getString("S8C_MARCA_STRUM_MISURA"));
					sigitTDettIspezGtDto.setS8cModelloStrumMisura(rs.getString("S8C_MODELLO_STRUM_MISURA"));
					sigitTDettIspezGtDto.setS8cMatricolaStrumMisura(rs.getString("S8C_MATRICOLA_STRUM_MISURA"));
					sigitTDettIspezGtDto.setS8dTempFluidoMandataC(rs.getBigDecimal("S8D_TEMP_FLUIDO_MANDATA_C"));
					sigitTDettIspezGtDto.setS8dTempAriaC(rs.getBigDecimal("S8D_TEMP_ARIA_C"));
					sigitTDettIspezGtDto.setS8dTempFumiC(rs.getBigDecimal("S8D_TEMP_FUMI_C"));
					sigitTDettIspezGtDto.setS8dO2Perc(rs.getBigDecimal("S8D_O2_PERC"));
					sigitTDettIspezGtDto.setS8dCo2Perc(rs.getBigDecimal("S8D_CO2_PERC"));
					sigitTDettIspezGtDto.setS8dCoFumiSecchiPpm(rs.getBigDecimal("S8D_CO_FUMI_SECCHI_PPM"));
					sigitTDettIspezGtDto.setS8dNoMgKwH(rs.getBigDecimal("S8D_NO_MG_KW_H"));
					sigitTDettIspezGtDto.setS8eIndiceAria(rs.getBigDecimal("S8E_INDICE_ARIA"));
					sigitTDettIspezGtDto.setS8eFumiSecchiNoAriaPpm(rs.getBigDecimal("S8E_FUMI_SECCHI_NO_ARIA_PPM"));
					sigitTDettIspezGtDto.setS8eQsPerc(rs.getBigDecimal("S8E_QS_PERC"));
					sigitTDettIspezGtDto.setS8eEtPerc(rs.getBigDecimal("S8E_ET_PERC"));
					sigitTDettIspezGtDto.setS8eRendCombPerc(rs.getBigDecimal("S8E_REND_COMB_PERC"));
					sigitTDettIspezGtDto.setS8eNoxMgKwH(rs.getBigDecimal("S8E_NOX_MG_KW_H"));
					sigitTDettIspezGtDto.setS9aFlgMonossidoCarb(rs.getString("S9A_FLG_MONOSSIDO_CARB"));
					sigitTDettIspezGtDto.setS9bFlgFumosita(rs.getString("S9B_FLG_FUMOSITA"));
					sigitTDettIspezGtDto.setS9cRendMinCombustPerc(rs.getBigDecimal("S9C_REND_MIN_COMBUST_PERC"));
					sigitTDettIspezGtDto.setS9cFlgRendCombustSuff(rs.getBigDecimal("S9C_FLG_REND_COMBUST_SUFF"));
					sigitTDettIspezGtDto.setS9dOssidiAzotoLimMgKwH(rs.getBigDecimal("S9D_OSSIDI_AZOTO_LIM_MG_KW_H"));
					sigitTDettIspezGtDto.setS9dFlgOssidiAzoto(rs.getString("S9D_FLG_OSSIDI_AZOTO"));
					sigitTDettIspezGtDto.setS9eFlgRispettoNormativa(rs.getBigDecimal("S9E_FLG_RISPETTO_NORMATIVA"));
					sigitTDettIspezGtDto.setS9eFlgNoRispetto7a(rs.getBigDecimal("S9E_FLG_NO_RISPETTO_7A"));
					sigitTDettIspezGtDto.setS9eFlgNoRispetto7b(rs.getBigDecimal("S9E_FLG_NO_RISPETTO_7B"));
					sigitTDettIspezGtDto.setS9eFlgNoRispetto9a(rs.getBigDecimal("S9E_FLG_NO_RISPETTO_9A"));
					sigitTDettIspezGtDto.setS9eFlgNoRispetto9b(rs.getBigDecimal("S9E_FLG_NO_RISPETTO_9B"));
					sigitTDettIspezGtDto.setS9eFlgNoRispetto9c(rs.getBigDecimal("S9E_FLG_NO_RISPETTO_9C"));
					sigitTDettIspezGtDto.setS9eFlgNoRispetto9d(rs.getBigDecimal("S9E_FLG_NO_RISPETTO_9D"));
					sigitTDettIspezGtDto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));
					sigitTDettIspezGtDto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));
					sigitTDettIspezGtDto.setS7aFrequenzaManutAltro(rs.getString("S7A_FREQUENZA_MANUT_ALTRO"));
					sigitTDettIspezGtDto.setS7aFkFrequenzaManut(rs.getInt("S7A_FK_FREQUENZA_MANUT"));
					sigitTDettIspezGtDto.setControlloWeb(rs.getTimestamp("CONTROLLOWEB"));
					
					return sigitTDettIspezGtDto;
				}
			});

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDettIspezGtDaoImpl::findByFkAllegato] esecuzione query", ex);
			throw new SigitTDettIspezGtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findByFkAllegato", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTDettIspezGtDaoImpl::findByFkAllegato] END");
		}

		return list;
		
		
	}
	
	
	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettIspezGtDto> findByExample(
			SigitTDettIspezGtDto input)
			throws SigitTDettIspezGtDaoException {
		LOG.debug("[SigitTDettIspezGtDaoImpl::findByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_DETT_ISPEZ_GT,FK_ALLEGATO,FK_TIPO_COMPONENTE,PROGRESSIVO,CODICE_IMPIANTO,DATA_INSTALL,S6D_FLG_EVACU_FUMI,S6I_FLG_TIPO_B,S6I_FLG_TIPO_C,S6J_FK_CLASS_DPR660_96,S6K_POT_TERM_FOCOL_KW,S6K_BRUCIATORE_DA_KW,S6K_BRUCIATORE_A_KW,S6L_PORTATA_COMB_M3_H,S6L_PORTATA_COMB_KG_H,S6L_POT_TERM_FOCOL_KW,S7A_FLG_MANUT_EFFETTUATA,S7A_DATA_ULTIMA_MANUT,S7B_FLG_REE_PRESENTE,S7B_DATA_REE,S7B_FLG_OSSERVAZIONI,S7B_FLG_RACCOMAND,S7B_FLG_PRESCR,S8A_N_MODULO_TERMICO,S8B_FUMO_MIS_1,S8B_FUMO_MIS_2,S8B_FUMO_MIS_3,S8C_MARCA_STRUM_MISURA,S8C_MODELLO_STRUM_MISURA,S8C_MATRICOLA_STRUM_MISURA,S8D_TEMP_FLUIDO_MANDATA_C,S8D_TEMP_ARIA_C,S8D_TEMP_FUMI_C,S8D_O2_PERC,S8D_CO2_PERC,S8D_CO_FUMI_SECCHI_PPM,S8D_NO_MG_KW_H,S8E_INDICE_ARIA,S8E_FUMI_SECCHI_NO_ARIA_PPM,S8E_QS_PERC,S8E_ET_PERC,S8E_REND_COMB_PERC,S8E_NOX_MG_KW_H,S9A_FLG_MONOSSIDO_CARB,S9B_FLG_FUMOSITA,S9C_REND_MIN_COMBUST_PERC,S9C_FLG_REND_COMBUST_SUFF,S9D_OSSIDI_AZOTO_LIM_MG_KW_H,S9D_FLG_OSSIDI_AZOTO,S9E_FLG_RISPETTO_NORMATIVA,S9E_FLG_NO_RISPETTO_7A,S9E_FLG_NO_RISPETTO_7B,S9E_FLG_NO_RISPETTO_9A,S9E_FLG_NO_RISPETTO_9B,S9E_FLG_NO_RISPETTO_9C,S9E_FLG_NO_RISPETTO_9D,DATA_ULT_MOD,UTENTE_ULT_MOD,CONTROLLOWEB,S7A_FREQUENZA_MANUT_ALTRO,S7A_FK_FREQUENZA_MANUT ");
		sql.append(" FROM SIGIT_T_DETT_ISPEZ_GT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R241265676) ENABLED START*/
		sql.append(" 1 = 1 ");

		if (input.getFkAllegato() != null) {
			sql.append(" AND  FK_ALLEGATO = :idAllegato ");
		}
		if (input.getCodiceImpianto() != null) {
			sql.append(" AND  CODICE_IMPIANTO = :idCodiceImpianto ");
		}

		if (input.getProgressivo() != null) {
			sql.append(" AND PROGRESSIVO = :progressivo ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getS8aNModuloTermico())) {
			sql.append(" AND S8A_N_MODULO_TERMICO = :modulo ");
		}

		sql.append(" ORDER BY PROGRESSIVO, TO_NUMBER(S8A_N_MODULO_TERMICO)");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-230134858) ENABLED START*/
		if (input.getFkAllegato() != null) {
			paramMap.addValue("idAllegato", input.getFkAllegato());
		}
		if (input.getCodiceImpianto() != null) {
			paramMap.addValue("idCodiceImpianto", input.getCodiceImpianto());
		}

		if (input.getProgressivo() != null) {
			paramMap.addValue("progressivo", input.getProgressivo());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getS8aNModuloTermico())) {
			paramMap.addValue("modulo", input.getS8aNModuloTermico());
		}
		/*PROTECTED REGION END*/
		List<SigitTDettIspezGtDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDettIspezGtDaoImpl::findByExample] esecuzione query", ex);
			throw new SigitTDettIspezGtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDettIspezGtDaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDettIspezGtDaoImpl::findByExample] END");
		}
		return list;
	}
	
	public void delete(BigDecimal idAllegato) throws SigitTDettIspezGtDaoException {

		LOG.debug("[SigitTDettIspezGtDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE FK_ALLEGATO = :ID_ALLEGATO ";
		if (idAllegato == null) {
			LOG.error("[SigitTDettIspezGtDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTDettIspezGtDaoException("Chiave primaria non impostata");
		}
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ID_ALLEGATO", idAllegato, java.sql.Types.NUMERIC);
		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAllegatoDaoImpl::delete] END");
		
	}
	
	/** 
	 * Updates a single row in the SIGIT_T_DETT_ISPEZ_GT table.
	 * @generated
	 */
	public void update(SigitTDettIspezGtDto dto) throws SigitTDettIspezGtDaoException {
		LOG.debug("[SigitTDettIspezGtDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_ALLEGATO = :FK_ALLEGATO ,FK_TIPO_COMPONENTE = :FK_TIPO_COMPONENTE ,PROGRESSIVO = :PROGRESSIVO ,CODICE_IMPIANTO = :CODICE_IMPIANTO ,DATA_INSTALL = :DATA_INSTALL ,S6D_FLG_EVACU_FUMI = :S6D_FLG_EVACU_FUMI ,S6I_FLG_TIPO_B = :S6I_FLG_TIPO_B ,S6I_FLG_TIPO_C = :S6I_FLG_TIPO_C ,S6J_FK_CLASS_DPR660_96 = :S6J_FK_CLASS_DPR660_96 ,S6K_POT_TERM_FOCOL_KW = :S6K_POT_TERM_FOCOL_KW ,S6K_BRUCIATORE_DA_KW = :S6K_BRUCIATORE_DA_KW ,S6K_BRUCIATORE_A_KW = :S6K_BRUCIATORE_A_KW ,S6L_PORTATA_COMB_M3_H = :S6L_PORTATA_COMB_M3_H ,S6L_PORTATA_COMB_KG_H = :S6L_PORTATA_COMB_KG_H ,S6L_POT_TERM_FOCOL_KW = :S6L_POT_TERM_FOCOL_KW ,S7A_FLG_MANUT_EFFETTUATA = :S7A_FLG_MANUT_EFFETTUATA ,S7A_DATA_ULTIMA_MANUT = :S7A_DATA_ULTIMA_MANUT ,S7B_FLG_REE_PRESENTE = :S7B_FLG_REE_PRESENTE ,S7B_DATA_REE = :S7B_DATA_REE ,S7B_FLG_OSSERVAZIONI = :S7B_FLG_OSSERVAZIONI ,S7B_FLG_RACCOMAND = :S7B_FLG_RACCOMAND ,S7B_FLG_PRESCR = :S7B_FLG_PRESCR ,S8A_N_MODULO_TERMICO = :S8A_N_MODULO_TERMICO ,S8B_FUMO_MIS_1 = :S8B_FUMO_MIS_1 ,S8B_FUMO_MIS_2 = :S8B_FUMO_MIS_2 ,S8B_FUMO_MIS_3 = :S8B_FUMO_MIS_3 ,S8C_MARCA_STRUM_MISURA = :S8C_MARCA_STRUM_MISURA ,S8C_MODELLO_STRUM_MISURA = :S8C_MODELLO_STRUM_MISURA ,S8C_MATRICOLA_STRUM_MISURA = :S8C_MATRICOLA_STRUM_MISURA ,S8D_TEMP_FLUIDO_MANDATA_C = :S8D_TEMP_FLUIDO_MANDATA_C ,S8D_TEMP_ARIA_C = :S8D_TEMP_ARIA_C ,S8D_TEMP_FUMI_C = :S8D_TEMP_FUMI_C ,S8D_O2_PERC = :S8D_O2_PERC ,S8D_CO2_PERC = :S8D_CO2_PERC ,S8D_CO_FUMI_SECCHI_PPM = :S8D_CO_FUMI_SECCHI_PPM ,S8D_NO_MG_KW_H = :S8D_NO_MG_KW_H ,S8E_INDICE_ARIA = :S8E_INDICE_ARIA ,S8E_FUMI_SECCHI_NO_ARIA_PPM = :S8E_FUMI_SECCHI_NO_ARIA_PPM ,S8E_QS_PERC = :S8E_QS_PERC ,S8E_ET_PERC = :S8E_ET_PERC ,S8E_REND_COMB_PERC = :S8E_REND_COMB_PERC ,S8E_NOX_MG_KW_H = :S8E_NOX_MG_KW_H ,S9A_FLG_MONOSSIDO_CARB = :S9A_FLG_MONOSSIDO_CARB ,S9B_FLG_FUMOSITA = :S9B_FLG_FUMOSITA ,S9C_REND_MIN_COMBUST_PERC = :S9C_REND_MIN_COMBUST_PERC ,S9C_FLG_REND_COMBUST_SUFF = :S9C_FLG_REND_COMBUST_SUFF ,S9D_OSSIDI_AZOTO_LIM_MG_KW_H = :S9D_OSSIDI_AZOTO_LIM_MG_KW_H ,S9D_FLG_OSSIDI_AZOTO = :S9D_FLG_OSSIDI_AZOTO ,S9E_FLG_RISPETTO_NORMATIVA = :S9E_FLG_RISPETTO_NORMATIVA ,S9E_FLG_NO_RISPETTO_7A = :S9E_FLG_NO_RISPETTO_7A ,S9E_FLG_NO_RISPETTO_7B = :S9E_FLG_NO_RISPETTO_7B ,S9E_FLG_NO_RISPETTO_9A = :S9E_FLG_NO_RISPETTO_9A ,S9E_FLG_NO_RISPETTO_9B = :S9E_FLG_NO_RISPETTO_9B ,S9E_FLG_NO_RISPETTO_9C = :S9E_FLG_NO_RISPETTO_9C ,S9E_FLG_NO_RISPETTO_9D = :S9E_FLG_NO_RISPETTO_9D ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,CONTROLLOWEB = :CONTROLLOWEB ,S7A_FREQUENZA_MANUT_ALTRO = :S7A_FREQUENZA_MANUT_ALTRO ,S7A_FK_FREQUENZA_MANUT = :S7A_FK_FREQUENZA_MANUT  WHERE ID_DETT_ISPEZ_GT = :ID_DETT_ISPEZ_GT ";

		if (dto.getIdDettIspezGt() == null) {
			LOG.error("[SigitTDettIspezGtDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTDettIspezGtDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DETT_ISPEZ_GT]
		params.addValue("ID_DETT_ISPEZ_GT", dto.getIdDettIspezGt(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_COMPONENTE]
		params.addValue("FK_TIPO_COMPONENTE", dto.getFkTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [S6D_FLG_EVACU_FUMI]
		params.addValue("S6D_FLG_EVACU_FUMI", dto.getS6dFlgEvacuFumi(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S6I_FLG_TIPO_B]
		params.addValue("S6I_FLG_TIPO_B", dto.getS6iFlgTipoB(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S6I_FLG_TIPO_C]
		params.addValue("S6I_FLG_TIPO_C", dto.getS6iFlgTipoC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S6J_FK_CLASS_DPR660_96]
		params.addValue("S6J_FK_CLASS_DPR660_96", dto.getS6jFkClassDpr66096(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S6K_POT_TERM_FOCOL_KW]
		params.addValue("S6K_POT_TERM_FOCOL_KW", dto.getS6kPotTermFocolKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S6K_BRUCIATORE_DA_KW]
		params.addValue("S6K_BRUCIATORE_DA_KW", dto.getS6kBruciatoreDaKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S6K_BRUCIATORE_A_KW]
		params.addValue("S6K_BRUCIATORE_A_KW", dto.getS6kBruciatoreAKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S6L_PORTATA_COMB_M3_H]
		params.addValue("S6L_PORTATA_COMB_M3_H", dto.getS6lPortataCombM3H(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S6L_PORTATA_COMB_KG_H]
		params.addValue("S6L_PORTATA_COMB_KG_H", dto.getS6lPortataCombKgH(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S6L_POT_TERM_FOCOL_KW]
		params.addValue("S6L_POT_TERM_FOCOL_KW", dto.getS6lPotTermFocolKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S7A_FLG_MANUT_EFFETTUATA]
		params.addValue("S7A_FLG_MANUT_EFFETTUATA", dto.getS7aFlgManutEffettuata(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S7A_DATA_ULTIMA_MANUT]
		params.addValue("S7A_DATA_ULTIMA_MANUT", dto.getS7aDataUltimaManut(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [S7B_FLG_REE_PRESENTE]
		params.addValue("S7B_FLG_REE_PRESENTE", dto.getS7bFlgReePresente(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S7B_DATA_REE]
		params.addValue("S7B_DATA_REE", dto.getS7bDataRee(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [S7B_FLG_OSSERVAZIONI]
		params.addValue("S7B_FLG_OSSERVAZIONI", dto.getS7bFlgOsservazioni(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S7B_FLG_RACCOMAND]
		params.addValue("S7B_FLG_RACCOMAND", dto.getS7bFlgRaccomand(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S7B_FLG_PRESCR]
		params.addValue("S7B_FLG_PRESCR", dto.getS7bFlgPrescr(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8A_N_MODULO_TERMICO]
		params.addValue("S8A_N_MODULO_TERMICO", dto.getS8aNModuloTermico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S8B_FUMO_MIS_1]
		params.addValue("S8B_FUMO_MIS_1", dto.getS8bFumoMis1(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8B_FUMO_MIS_2]
		params.addValue("S8B_FUMO_MIS_2", dto.getS8bFumoMis2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8B_FUMO_MIS_3]
		params.addValue("S8B_FUMO_MIS_3", dto.getS8bFumoMis3(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8C_MARCA_STRUM_MISURA]
		params.addValue("S8C_MARCA_STRUM_MISURA", dto.getS8cMarcaStrumMisura(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S8C_MODELLO_STRUM_MISURA]
		params.addValue("S8C_MODELLO_STRUM_MISURA", dto.getS8cModelloStrumMisura(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S8C_MATRICOLA_STRUM_MISURA]
		params.addValue("S8C_MATRICOLA_STRUM_MISURA", dto.getS8cMatricolaStrumMisura(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S8D_TEMP_FLUIDO_MANDATA_C]
		params.addValue("S8D_TEMP_FLUIDO_MANDATA_C", dto.getS8dTempFluidoMandataC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8D_TEMP_ARIA_C]
		params.addValue("S8D_TEMP_ARIA_C", dto.getS8dTempAriaC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8D_TEMP_FUMI_C]
		params.addValue("S8D_TEMP_FUMI_C", dto.getS8dTempFumiC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8D_O2_PERC]
		params.addValue("S8D_O2_PERC", dto.getS8dO2Perc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8D_CO2_PERC]
		params.addValue("S8D_CO2_PERC", dto.getS8dCo2Perc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8D_CO_FUMI_SECCHI_PPM]
		params.addValue("S8D_CO_FUMI_SECCHI_PPM", dto.getS8dCoFumiSecchiPpm(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8D_NO_MG_KW_H]
		params.addValue("S8D_NO_MG_KW_H", dto.getS8dNoMgKwH(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8E_INDICE_ARIA]
		params.addValue("S8E_INDICE_ARIA", dto.getS8eIndiceAria(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8E_FUMI_SECCHI_NO_ARIA_PPM]
		params.addValue("S8E_FUMI_SECCHI_NO_ARIA_PPM", dto.getS8eFumiSecchiNoAriaPpm(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8E_QS_PERC]
		params.addValue("S8E_QS_PERC", dto.getS8eQsPerc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8E_ET_PERC]
		params.addValue("S8E_ET_PERC", dto.getS8eEtPerc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8E_REND_COMB_PERC]
		params.addValue("S8E_REND_COMB_PERC", dto.getS8eRendCombPerc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S8E_NOX_MG_KW_H]
		params.addValue("S8E_NOX_MG_KW_H", dto.getS8eNoxMgKwH(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S9A_FLG_MONOSSIDO_CARB]
		params.addValue("S9A_FLG_MONOSSIDO_CARB", dto.getS9aFlgMonossidoCarb(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S9B_FLG_FUMOSITA]
		params.addValue("S9B_FLG_FUMOSITA", dto.getS9bFlgFumosita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S9C_REND_MIN_COMBUST_PERC]
		params.addValue("S9C_REND_MIN_COMBUST_PERC", dto.getS9cRendMinCombustPerc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S9C_FLG_REND_COMBUST_SUFF]
		params.addValue("S9C_FLG_REND_COMBUST_SUFF", dto.getS9cFlgRendCombustSuff(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S9D_OSSIDI_AZOTO_LIM_MG_KW_H]
		params.addValue("S9D_OSSIDI_AZOTO_LIM_MG_KW_H", dto.getS9dOssidiAzotoLimMgKwH(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S9D_FLG_OSSIDI_AZOTO]
		params.addValue("S9D_FLG_OSSIDI_AZOTO", dto.getS9dFlgOssidiAzoto(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S9E_FLG_RISPETTO_NORMATIVA]
		params.addValue("S9E_FLG_RISPETTO_NORMATIVA", dto.getS9eFlgRispettoNormativa(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S9E_FLG_NO_RISPETTO_7A]
		params.addValue("S9E_FLG_NO_RISPETTO_7A", dto.getS9eFlgNoRispetto7a(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S9E_FLG_NO_RISPETTO_7B]
		params.addValue("S9E_FLG_NO_RISPETTO_7B", dto.getS9eFlgNoRispetto7b(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S9E_FLG_NO_RISPETTO_9A]
		params.addValue("S9E_FLG_NO_RISPETTO_9A", dto.getS9eFlgNoRispetto9a(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S9E_FLG_NO_RISPETTO_9B]
		params.addValue("S9E_FLG_NO_RISPETTO_9B", dto.getS9eFlgNoRispetto9b(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S9E_FLG_NO_RISPETTO_9C]
		params.addValue("S9E_FLG_NO_RISPETTO_9C", dto.getS9eFlgNoRispetto9c(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S9E_FLG_NO_RISPETTO_9D]
		params.addValue("S9E_FLG_NO_RISPETTO_9D", dto.getS9eFlgNoRispetto9d(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CONTROLLOWEB]
		params.addValue("CONTROLLOWEB", dto.getControlloWeb(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [S7A_FREQUENZA_MANUT_ALTRO]
		params.addValue("S7A_FREQUENZA_MANUT_ALTRO", dto.getS7aFrequenzaManutAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S7A_FK_FREQUENZA_MANUT]
		params.addValue("S7A_FK_FREQUENZA_MANUT", dto.getS7aFkFrequenzaManut(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettIspezGtDaoImpl::update] END");
	}
	
	

}
