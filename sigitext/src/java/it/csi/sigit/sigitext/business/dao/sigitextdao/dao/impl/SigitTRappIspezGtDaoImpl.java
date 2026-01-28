package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTRappIspezGtDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTRappIspezGtDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappIspezGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappIspezGtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitSLibrettoDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTRappIspezGtDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.util.performance.StopWatch;

public class SigitTRappIspezGtDaoImpl  extends AbstractDAO implements SigitTRappIspezGtDao{
	
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

	/**
	 * Metodo di inserimento del DAO sigitTVerifica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTVerificaPk
	 * @generated
	 */
	
	public String getTableName() {
		return "SIGIT_T_RAPP_ISPEZ_GT";
	}
	
	
	protected SigitTRappIspezGtDaoRowMapper findByIdAllegatoRowMapper = new SigitTRappIspezGtDaoRowMapper(null, SigitTRappIspezGtDto.class, this);

	public SigitTRappIspezGtPk insert(SigitTRappIspezGtDto dto) throws SigitTRappIspezGtDaoException

	{
		LOG.debug("[SigitTRappIspezGtDtoImpl::insert] START");	

		final String sql = "INSERT INTO " + getTableName()
				+ " ( ID_ALLEGATO, S1C_FLG_REE_INVIATO, S1C_FLG_REE_BOLLINO, S1C_SIGLA_BOLLINO, S1C_NUM_BOLLINO, S1E_DT_PRIMA_INSTALLAZIONE, S1E_POT_FOCOLARE_KW, S1E_POT_UTILE_KW, S1L_DENOM_DELEGATO, S1L_FLG_DELEGA, S2B1_FLG_TERMO_CONTAB, S2B2_FLG_UNI_10200, S2F_FLG_TRATT_CLIMA_NON_RICH, S2F_FLG_TRATT_ACS_NON_RICH, S3A_FLG_LOCALE_INT_IDONEO, S3B_FLG_GEN_EXT_IDONEO, S3C_FLG_VENTILAZ_SUFF, S3D_FLG_EVAC_FUMI_IDONEO, S3E_FLG_CARTELLI_PRESENTI, S3F_FLG_ESTINZ_PRESENTI, S3G_FLG_INTERR_GEN_PRESENTI, S3H_FLG_RUBIN_PRESENTE, S3I_FLG_ASSENZA_PERD_COMB, S3J_FLG_TEMP_AMB_FUNZ, S3K_FLG_DM_1_12_1975, S4A_FLG_LIB_IMP_PRESENTE, S4B_FLG_LIB_COMPILATO, S4C_FLG_CONFORMITA_PRESENTE, S4D_FLG_LIB_USO_PRESENTE, S4E_FLG_PRATICA_VVF_PRESENTE, S4F_FLG_PRATICA_INAIL_PRESENTE, S4G_FLG_DM12_1975, S4G_MATRICOLA_DM_1_12_1975, S5A_FLG_ADOZIONE_VALVOLE_TERM, S5A_FLG_ISOLAMENTE_RETE, S5A_FLG_ADOZ_SIST_TRATTAM_H2O, S5A_FLG_SOSTITUZ_SIST_REGOLAZ, S5B_FLG_NO_INTERV_CONV, S5B_FLG_RELAZ_DETTAGLIO, S5B_FLG_RELAZ_DETTAGLIO_SUCC, S5B_FLG_VALUTAZ_NON_ESEGUITA, S5B_MOTIVO_RELAZ_NON_ESEG, S5C_FLG_DIMENS_CORRETTO, S5C_FLG_DIMENS_NON_CONTROLL, S5C_FLG_DIMENS_RELAZ_SUCCES, DATA_ULT_MOD, UTENTE_ULT_MOD, S1C_DATA_REE, S5C_FLG_DIMENS_NON_CORRETTO ) " 
				+ " VALUES (  :ID_ALLEGATO, :S1C_FLG_REE_INVIATO, :S1C_FLG_REE_BOLLINO, :S1C_SIGLA_BOLLINO, :S1C_NUM_BOLLINO, :S1E_DT_PRIMA_INSTALLAZIONE, :S1E_POT_FOCOLARE_KW, :S1E_POT_UTILE_KW, :S1L_DENOM_DELEGATO, :S1L_FLG_DELEGA, :S2B1_FLG_TERMO_CONTAB, :S2B2_FLG_UNI_10200, :S2F_FLG_TRATT_CLIMA_NON_RICH, :S2F_FLG_TRATT_ACS_NON_RICH, :S3A_FLG_LOCALE_INT_IDONEO, :S3B_FLG_GEN_EXT_IDONEO, :S3C_FLG_VENTILAZ_SUFF, :S3D_FLG_EVAC_FUMI_IDONEO, :S3E_FLG_CARTELLI_PRESENTI, :S3F_FLG_ESTINZ_PRESENTI, :S3G_FLG_INTERR_GEN_PRESENTI, :S3H_FLG_RUBIN_PRESENTE, :S3I_FLG_ASSENZA_PERD_COMB, :S3J_FLG_TEMP_AMB_FUNZ, :S3K_FLG_DM_1_12_1975, :S4A_FLG_LIB_IMP_PRESENTE, :S4B_FLG_LIB_COMPILATO, :S4C_FLG_CONFORMITA_PRESENTE, :S4D_FLG_LIB_USO_PRESENTE, :S4E_FLG_PRATICA_VVF_PRESENTE, :S4F_FLG_PRATICA_INAIL_PRESENTE, :S4G_FLG_DM12_1975, :S4G_MATRICOLA_DM_1_12_1975, :S5A_FLG_ADOZIONE_VALVOLE_TERM, :S5A_FLG_ISOLAMENTE_RETE, :S5A_FLG_ADOZ_SIST_TRATTAM_H2O, :S5A_FLG_SOSTITUZ_SIST_REGOLAZ, :S5B_FLG_NO_INTERV_CONV, :S5B_FLG_RELAZ_DETTAGLIO, :S5B_FLG_RELAZ_DETTAGLIO_SUCC, :S5B_FLG_VALUTAZ_NON_ESEGUITA, :S5B_MOTIVO_RELAZ_NON_ESEG, :S5C_FLG_DIMENS_CORRETTO, :S5C_FLG_DIMENS_NON_CONTROLL, :S5C_FLG_DIMENS_RELAZ_SUCCES, :DATA_ULT_MOD, :UTENTE_ULT_MOD, :S1C_DATA_REE, :S5C_FLG_DIMENS_NON_CORRETTO )";

		MapSqlParameterSource params = new MapSqlParameterSource();
		  		
		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getSigitTRappIspezGtPk().getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1C_FLG_REE_INVIATO]
		params.addValue("S1C_FLG_REE_INVIATO", dto.getS1cFlgReeInviato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1C_FLG_REE_BOLLINO]
		params.addValue("S1C_FLG_REE_BOLLINO", dto.getS1cFlgReeBollino(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1C_SIGLA_BOLLINO]
		params.addValue("S1C_SIGLA_BOLLINO", dto.getS1cSiglaBollino(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S1C_NUM_BOLLINO]
		params.addValue("S1C_NUM_BOLLINO", dto.getS1cNumBollino(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1E_DT_PRIMA_INSTALLAZIONE]
		params.addValue("S1E_DT_PRIMA_INSTALLAZIONE", dto.getS1eDtPrimaInstallazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [S1E_POT_FOCOLARE_KW]
		params.addValue("S1E_POT_FOCOLARE_KW", dto.getS1ePotFocolareKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1E_POT_UTILE_KW]
		params.addValue("S1E_POT_UTILE_KW", dto.getS1ePotUtileKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1L_DENOM_DELEGATO]
		params.addValue("S1L_DENOM_DELEGATO", dto.getS1lDenomDelegato(), java.sql.Types.VARCHAR);		
		
		// valorizzazione paametro relativo a colonna [S1L_FLG_DELEGA]
		params.addValue("S1L_FLG_DELEGA", dto.getS1lFlgDelega(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S2B1_FLG_TERMO_CONTAB]
		params.addValue("S2B1_FLG_TERMO_CONTAB", dto.getS2b1FlgTermoContab(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S2B2_FLG_UNI_10200]
		params.addValue("S2B2_FLG_UNI_10200", dto.getS2b2FlgUni10200(), java.sql.Types.NUMERIC);		  
		
		// valorizzazione paametro relativo a colonna [S2F_FLG_TRATT_CLIMA_NON_RICH]
		params.addValue("S2F_FLG_TRATT_CLIMA_NON_RICH", dto.getS2fFlgTrattClimaNonRich(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S2F_FLG_TRATT_ACS_NON_RICH]
		params.addValue("S2F_FLG_TRATT_ACS_NON_RICH", dto.getS2fFlgTrattAcsNonRich(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3A_FLG_LOCALE_INT_IDONEO]
		params.addValue("S3A_FLG_LOCALE_INT_IDONEO", dto.getS3aFlgLocaleIntIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3B_FLG_GEN_EXT_IDONEO]
		params.addValue("S3B_FLG_GEN_EXT_IDONEO", dto.getS3bFlgGenExtIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3C_FLG_VENTILAZ_SUFF]
		params.addValue("S3C_FLG_VENTILAZ_SUFF", dto.getS3cFlgVentilazSuff(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S3D_FLG_EVAC_FUMI_IDONEO]
		params.addValue("S3D_FLG_EVAC_FUMI_IDONEO", dto.getS3dFlgEvacFumiIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3E_FLG_CARTELLI_PRESENTI]
		params.addValue("S3E_FLG_CARTELLI_PRESENTI", dto.getS3eFlgCartelliPresenti(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3F_FLG_ESTINZ_PRESENTI]
		params.addValue("S3F_FLG_ESTINZ_PRESENTI", dto.getS3fFlgEstinzPresenti(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3G_FLG_INTERR_GEN_PRESENTI]
		params.addValue("S3G_FLG_INTERR_GEN_PRESENTI", dto.getS3gFlgInterrGenPresenti(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3H_FLG_RUBIN_PRESENTE]
		params.addValue("S3H_FLG_RUBIN_PRESENTE", dto.getS3hFlgRubinPresente(), java.sql.Types.NUMERIC);
			
		// valorizzazione paametro relativo a colonna [S3I_FLG_ASSENZA_PERD_COMB]
		params.addValue("S3I_FLG_ASSENZA_PERD_COMB", dto.getS3iFlgAssenzaPerdComb(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3J_FLG_TEMP_AMB_FUNZ]
		params.addValue("S3J_FLG_TEMP_AMB_FUNZ", dto.getS3jFlgTempAmbFunz(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3K_FLG_DM_1_12_1975]
		params.addValue("S3K_FLG_DM_1_12_1975", dto.getS3kFlgDm1121975(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S4A_FLG_LIB_IMP_PRESENTE]
		params.addValue("S4A_FLG_LIB_IMP_PRESENTE", dto.getS4aFlgLibImpPresente(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S4B_FLG_LIB_COMPILATO]
		params.addValue("S4B_FLG_LIB_COMPILATO", dto.getS4bFlgLibCompilato(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S4C_FLG_CONFORMITA_PRESENTE]		
		params.addValue("S4C_FLG_CONFORMITA_PRESENTE", dto.getS4cFlgConformitaPresente(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S4D_FLG_LIB_USO_PRESENTE]
		params.addValue("S4D_FLG_LIB_USO_PRESENTE", dto.getS4dFlgLibUsoPresente(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S4E_FLG_PRATICA_VVF_PRESENTE]
		params.addValue("S4E_FLG_PRATICA_VVF_PRESENTE", dto.getS4eFlgPraticaVvfPresente(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S4F_FLG_PRATICA_INAIL_PRESENTE]
		params.addValue("S4F_FLG_PRATICA_INAIL_PRESENTE", dto.getS4fFlgPraticaInailPresente(), java.sql.Types.NUMERIC);		
		
		// valorizzazione paametro relativo a colonna [S4G_FLG_DM12_1975]
		params.addValue("S4G_FLG_DM12_1975", dto.getS4gFlgDm121975(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S4G_MATRICOLA_DM_1_12_1975]
		params.addValue("S4G_MATRICOLA_DM_1_12_1975", dto.getS4gMatricolaDm1121975(), java.sql.Types.VARCHAR);
		
		// valorizzazione paametro relativo a colonna [S5A_FLG_ADOZIONE_VALVOLE_TERM]
		params.addValue("S5A_FLG_ADOZIONE_VALVOLE_TERM", dto.getS5aFlgAdozioneValvoleTerm(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S5A_FLG_ISOLAMENTE_RETE]
		params.addValue("S5A_FLG_ISOLAMENTE_RETE", dto.getS5aFlgIsolamenteRete(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S5A_FLG_ADOZ_SIST_TRATTAM_H2O]
		params.addValue("S5A_FLG_ADOZ_SIST_TRATTAM_H2O", dto.getS5aFlgAdozSistTrattam_h2o(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S5A_FLG_SOSTITUZ_SIST_REGOLAZ]
		params.addValue("S5A_FLG_SOSTITUZ_SIST_REGOLAZ", dto.getS5aFlgSostituzSistRegolaz(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S5B_FLG_NO_INTERV_CONV]
		params.addValue("S5B_FLG_NO_INTERV_CONV", dto.getS5bFlgNoIntervConv(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S5B_FLG_RELAZ_DETTAGLIO]
		params.addValue("S5B_FLG_RELAZ_DETTAGLIO", dto.getS5bFlgRelazDettaglio(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S5B_FLG_RELAZ_DETTAGLIO_SUCC]		
		params.addValue("S5B_FLG_RELAZ_DETTAGLIO_SUCC", dto.getS5bFlgRelazDettaglioSucc(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S5B_MOTIVO_RELAZ_NON_ESEG]
		params.addValue("S5B_MOTIVO_RELAZ_NON_ESEG", dto.getS5bMotivoRelazNonEseg(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S5C_FLG_DIMENS_NON_CONTROLL]
		params.addValue("S5C_FLG_DIMENS_NON_CONTROLL", dto.getS5cFlgDimensNonControll(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3J_FLG_TEMP_AMB_FUNZ]
		params.addValue("S3J_FLG_TEMP_AMB_FUNZ", dto.getS3jFlgTempAmbFunz(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3K_FLG_DM_1_12_1975]
		params.addValue("S3K_FLG_DM_1_12_1975", dto.getS3kFlgDm1121975(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S3J_FLG_TEMP_AMB_FUNZ]
		params.addValue("S3J_FLG_TEMP_AMB_FUNZ", dto.getS3jFlgTempAmbFunz(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5B_FLG_VALUTAZ_NON_ESEGUITA]
		params.addValue("S5B_FLG_VALUTAZ_NON_ESEGUITA", dto.getS5bFlgValutazNonEseguita(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S5B_MOTIVO_RELAZ_NON_ESEG]
		params.addValue("S5B_MOTIVO_RELAZ_NON_ESEG", dto.getS5bMotivoRelazNonEseg(), java.sql.Types.VARCHAR);
		
		// valorizzazione paametro relativo a colonna [S5C_FLG_DIMENS_CORRETTO]
		params.addValue("S5C_FLG_DIMENS_CORRETTO", dto.getS5cFlgDimensCorretto(), java.sql.Types.NUMERIC);		
		
		// valorizzazione paametro relativo a colonna [S5C_FLG_DIMENS_NON_CONTROLL]
		params.addValue("S5C_FLG_DIMENS_NON_CONTROLL", dto.getS5cFlgDimensNonControll(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [S5C_FLG_DIMENS_RELAZ_SUCCES]
		params.addValue("S5C_FLG_DIMENS_RELAZ_SUCCES", dto.getS5cFlgDimensRelazSucces(), java.sql.Types.NUMERIC);
		
		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);
		
		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S1C_DATA_REE]
		params.addValue("S1C_DATA_REE", dto.getS1cDataRee(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [S5C_FLG_DIMENS_NON_CORRETTO]
		params.addValue("S5C_FLG_DIMENS_NON_CORRETTO", dto.getS5cFlgDimensNonCorretto(), java.sql.Types.NUMERIC);
		
		insert(jdbcTemplate, sql, params);
		
		LOG.debug("[SigitTRappIspezGtDtoImpl::insert] END");
		return dto.getSigitTRappIspezGtPk();

	}
	
	public SigitTRappIspezGtPk update(SigitTRappIspezGtDto dto) throws SigitTRappIspezGtDaoException

	{
		LOG.debug("[SigitTRappIspezGtDtoImpl::update] START");	

		final String sql = "UPDATE " + getTableName() 
				+ " SET S1C_FLG_REE_INVIATO = :S1C_FLG_REE_INVIATO, S1C_FLG_REE_BOLLINO = :S1C_FLG_REE_BOLLINO, S1C_SIGLA_BOLLINO = :S1C_SIGLA_BOLLINO, S1C_NUM_BOLLINO = :S1C_NUM_BOLLINO, S1C_DATA_REE = :S1C_DATA_REE, S1E_DT_PRIMA_INSTALLAZIONE = :S1E_DT_PRIMA_INSTALLAZIONE, S1E_POT_FOCOLARE_KW = :S1E_POT_FOCOLARE_KW, S1E_POT_UTILE_KW = :S1E_POT_UTILE_KW, S1L_DENOM_DELEGATO = :S1L_DENOM_DELEGATO, S1L_FLG_DELEGA = :S1L_FLG_DELEGA, S2B1_FLG_TERMO_CONTAB = :S2B1_FLG_TERMO_CONTAB, S2B2_FLG_UNI_10200= :S2B2_FLG_UNI_10200, S2F_FLG_TRATT_CLIMA_NON_RICH = :S2F_FLG_TRATT_CLIMA_NON_RICH, S2F_FLG_TRATT_ACS_NON_RICH = :S2F_FLG_TRATT_ACS_NON_RICH, S3A_FLG_LOCALE_INT_IDONEO = :S3A_FLG_LOCALE_INT_IDONEO, S3B_FLG_GEN_EXT_IDONEO = :S3B_FLG_GEN_EXT_IDONEO, S3C_FLG_VENTILAZ_SUFF = :S3C_FLG_VENTILAZ_SUFF, S3D_FLG_EVAC_FUMI_IDONEO =     • :S3D_FLG_EVAC_FUMI_IDONEO, S3E_FLG_CARTELLI_PRESENTI = :S3E_FLG_CARTELLI_PRESENTI, S3F_FLG_ESTINZ_PRESENTI = :S3F_FLG_ESTINZ_PRESENTI, S3G_FLG_INTERR_GEN_PRESENTI = :S3G_FLG_INTERR_GEN_PRESENTI, S3H_FLG_RUBIN_PRESENTE = :S3H_FLG_RUBIN_PRESENTE, S3I_FLG_ASSENZA_PERD_COMB = :S3I_FLG_ASSENZA_PERD_COMB, S3J_FLG_TEMP_AMB_FUNZ = :S3J_FLG_TEMP_AMB_FUNZ, S3K_FLG_DM_1_12_1975 = :S3K_FLG_DM_1_12_1975, S4A_FLG_LIB_IMP_PRESENTE = :S4A_FLG_LIB_IMP_PRESENTE, S4B_FLG_LIB_COMPILATO = :S4B_FLG_LIB_COMPILATO, S4C_FLG_CONFORMITA_PRESENTE = :S4C_FLG_CONFORMITA_PRESENTE, S4D_FLG_LIB_USO_PRESENTE = :S4D_FLG_LIB_USO_PRESENTE, S4E_FLG_PRATICA_VVF_PRESENTE = :S4E_FLG_PRATICA_VVF_PRESENTE, S4F_FLG_PRATICA_INAIL_PRESENTE = :S4F_FLG_PRATICA_INAIL_PRESENTE, S4G_FLG_DM12_1975 = :S4G_FLG_DM12_1975, S4G_MATRICOLA_DM_1_12_1975 = :S4G_MATRICOLA_DM_1_12_1975, S5A_FLG_ADOZIONE_VALVOLE_TERM = :S5A_FLG_ADOZIONE_VALVOLE_TERM, S5A_FLG_ISOLAMENTE_RETE = :S5A_FLG_ISOLAMENTE_RETE, S5A_FLG_ADOZ_SIST_TRATTAM_H2O = :S5A_FLG_ADOZ_SIST_TRATTAM_H2O, S5A_FLG_SOSTITUZ_SIST_REGOLAZ = :S5A_FLG_SOSTITUZ_SIST_REGOLAZ, S5B_FLG_NO_INTERV_CONV = :S5B_FLG_NO_INTERV_CONV, S5B_FLG_RELAZ_DETTAGLIO = :S5B_FLG_RELAZ_DETTAGLIO, S5B_FLG_RELAZ_DETTAGLIO_SUCC = :S5B_FLG_RELAZ_DETTAGLIO_SUCC, S5B_FLG_VALUTAZ_NON_ESEGUITA = :S5B_FLG_VALUTAZ_NON_ESEGUITA, S5B_MOTIVO_RELAZ_NON_ESEG = :S5B_MOTIVO_RELAZ_NON_ESEG, S5C_FLG_DIMENS_CORRETTO = :S5C_FLG_DIMENS_CORRETTO, S5C_FLG_DIMENS_NON_CORRETTO =  :S5C_FLG_DIMENS_NON_CORRETTO, S5C_FLG_DIMENS_NON_CONTROLL = :S5C_FLG_DIMENS_NON_CONTROLL, S5C_FLG_DIMENS_RELAZ_SUCCES = :S5C_FLG_DIMENS_RELAZ_SUCCES, DATA_ULT_MOD = :DATA_ULT_MOD, UTENTE_ULT_MOD = :UTENTE_ULT_MOD " + 
				" WHERE ID_ALLEGATO= :ID_ALLEGATO ";
						
		MapSqlParameterSource params = new MapSqlParameterSource();
		  		
		params.addValue("S1C_FLG_REE_INVIATO", dto.getS1cFlgReeInviato(), java.sql.Types.NUMERIC);
		params.addValue("S1C_FLG_REE_BOLLINO", dto.getS1cFlgReeBollino(), java.sql.Types.NUMERIC);
		params.addValue("S1C_SIGLA_BOLLINO", dto.getS1cSiglaBollino(), java.sql.Types.VARCHAR);
		params.addValue("S1C_NUM_BOLLINO", dto.getS1cNumBollino(), java.sql.Types.NUMERIC);
		params.addValue("S1C_DATA_REE", dto.getS1cDataRee(), java.sql.Types.DATE);
		params.addValue("S1E_DT_PRIMA_INSTALLAZIONE", dto.getS1eDtPrimaInstallazione(), java.sql.Types.DATE);
		params.addValue("S1E_POT_FOCOLARE_KW", dto.getS1ePotFocolareKw(), java.sql.Types.NUMERIC);
		params.addValue("S1E_POT_UTILE_KW", dto.getS1ePotUtileKw(), java.sql.Types.NUMERIC);
		params.addValue("S1L_DENOM_DELEGATO", dto.getS1lDenomDelegato(), java.sql.Types.VARCHAR);
		params.addValue("S1L_FLG_DELEGA", dto.getS1lFlgDelega(), java.sql.Types.NUMERIC);
		params.addValue("S2B1_FLG_TERMO_CONTAB", dto.getS2b1FlgTermoContab(), java.sql.Types.NUMERIC);
		params.addValue("S2B2_FLG_UNI_10200", dto.getS2b2FlgUni10200(), java.sql.Types.NUMERIC);
		params.addValue("S2F_FLG_TRATT_CLIMA_NON_RICH", dto.getS2fFlgTrattClimaNonRich(), java.sql.Types.NUMERIC);
		params.addValue("S2F_FLG_TRATT_ACS_NON_RICH", dto.getS2fFlgTrattAcsNonRich(), java.sql.Types.NUMERIC);
		params.addValue("S3A_FLG_LOCALE_INT_IDONEO", dto.getS3aFlgLocaleIntIdoneo(), java.sql.Types.NUMERIC);
		params.addValue("S3B_FLG_GEN_EXT_IDONEO", dto.getS3bFlgGenExtIdoneo(), java.sql.Types.NUMERIC);
		params.addValue("S3C_FLG_VENTILAZ_SUFF", dto.getS3cFlgVentilazSuff(), java.sql.Types.NUMERIC);
		params.addValue("S3D_FLG_EVAC_FUMI_IDONEO", dto.getS3dFlgEvacFumiIdoneo(), java.sql.Types.NUMERIC);
		params.addValue("S3E_FLG_CARTELLI_PRESENTI", dto.getS3eFlgCartelliPresenti(), java.sql.Types.NUMERIC);
		params.addValue("S3F_FLG_ESTINZ_PRESENTI", dto.getS3fFlgEstinzPresenti(), java.sql.Types.NUMERIC);
		params.addValue("S3G_FLG_INTERR_GEN_PRESENTI", dto.getS3gFlgInterrGenPresenti(), java.sql.Types.NUMERIC);
		params.addValue("S3H_FLG_RUBIN_PRESENTE", dto.getS3hFlgRubinPresente(), java.sql.Types.NUMERIC);
		params.addValue("S3I_FLG_ASSENZA_PERD_COMB", dto.getS3iFlgAssenzaPerdComb(), java.sql.Types.NUMERIC);
		params.addValue("S3J_FLG_TEMP_AMB_FUNZ", dto.getS3jFlgTempAmbFunz(), java.sql.Types.NUMERIC);
		params.addValue("S3K_FLG_DM_1_12_1975", dto.getS3kFlgDm1121975(), java.sql.Types.NUMERIC);
		params.addValue("S4A_FLG_LIB_IMP_PRESENTE", dto.getS4aFlgLibImpPresente(), java.sql.Types.NUMERIC);
		params.addValue("S4B_FLG_LIB_COMPILATO", dto.getS4bFlgLibCompilato(), java.sql.Types.NUMERIC);
		params.addValue("S4C_FLG_CONFORMITA_PRESENTE", dto.getS4cFlgConformitaPresente(), java.sql.Types.NUMERIC);
		params.addValue("S4D_FLG_LIB_USO_PRESENTE", dto.getS4dFlgLibUsoPresente(), java.sql.Types.NUMERIC);
		params.addValue("S4E_FLG_PRATICA_VVF_PRESENTE", dto.getS4eFlgPraticaVvfPresente(), java.sql.Types.NUMERIC);
		params.addValue("S4F_FLG_PRATICA_INAIL_PRESENTE", dto.getS4fFlgPraticaInailPresente(), java.sql.Types.NUMERIC);
		params.addValue("S4G_FLG_DM12_1975", dto.getS4gFlgDm121975(), java.sql.Types.NUMERIC);
		params.addValue("S4G_MATRICOLA_DM_1_12_1975", dto.getS4gMatricolaDm1121975(), java.sql.Types.VARCHAR);
		params.addValue("S5A_FLG_ADOZIONE_VALVOLE_TERM", dto.getS5aFlgAdozioneValvoleTerm(), java.sql.Types.NUMERIC);
		params.addValue("S5A_FLG_ISOLAMENTE_RETE", dto.getS5aFlgIsolamenteRete(), java.sql.Types.NUMERIC);
		params.addValue("S5A_FLG_ADOZ_SIST_TRATTAM_H2O", dto.getS5aFlgAdozSistTrattamH2o(), java.sql.Types.NUMERIC);
		params.addValue("S5A_FLG_SOSTITUZ_SIST_REGOLAZ", dto.getS5aFlgSostituzSistRegolaz(), java.sql.Types.NUMERIC);
		params.addValue("S5B_FLG_NO_INTERV_CONV", dto.getS5bFlgNoIntervConv(), java.sql.Types.NUMERIC);
		params.addValue("S5B_FLG_RELAZ_DETTAGLIO", dto.getS5bFlgRelazDettaglio(), java.sql.Types.NUMERIC);
		params.addValue("S5B_FLG_RELAZ_DETTAGLIO_SUCC", dto.getS5bFlgRelazDettaglioSucc(), java.sql.Types.NUMERIC);
		params.addValue("S5B_FLG_VALUTAZ_NON_ESEGUITA", dto.getS5bFlgValutazNonEseguita(), java.sql.Types.NUMERIC);
		params.addValue("S5B_MOTIVO_RELAZ_NON_ESEG", dto.getS5bMotivoRelazNonEseg(), java.sql.Types.VARCHAR);
		params.addValue("S5C_FLG_DIMENS_CORRETTO", dto.getS5cFlgDimensCorretto(), java.sql.Types.NUMERIC);
		params.addValue("S5C_FLG_DIMENS_NON_CORRETTO", dto.getS5cFlgDimensNonCorretto(), java.sql.Types.NUMERIC);
		params.addValue("S5C_FLG_DIMENS_NON_CONTROLL", dto.getS5cFlgDimensNonControll(), java.sql.Types.NUMERIC);
		params.addValue("S5C_FLG_DIMENS_RELAZ_SUCCES", dto.getS5cFlgDimensRelazSucces(), java.sql.Types.NUMERIC);
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);
		
		update(jdbcTemplate, sql, params);
		
		LOG.debug("[SigitTRappIspezGtDtoImpl::update] END");
		return dto.getSigitTRappIspezGtPk();

	}
	
	@Override
	public void delete(BigDecimal idAllegato) throws SigitTRappIspezGtDaoException {

		LOG.debug("[SigitTRappIspezGtDtoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ";
		if (idAllegato == null) {
			LOG.error("[SigitTRappIspezGtDtoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTRappIspezGtDaoException("Chiave primaria non impostata");
		}
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ID_ALLEGATO", idAllegato, java.sql.Types.NUMERIC);
		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTRappIspezGtDtoImpl::delete] END");
		
	}	
	
	public SigitTRappIspezGtDto findByIdAllegato(BigDecimal idAllegato) throws SigitSLibrettoDaoException {
		LOG.debug("[SigitSLibrettoDaoImpl::findByLibrettoFilter] START");
		
		SigitTRappIspezGtDto sigitTRappIspezGtDto = new SigitTRappIspezGtDto();
		
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		sql.append("SELECT ID_ALLEGATO, S1C_FLG_REE_INVIATO, S1C_FLG_REE_BOLLINO, S1C_SIGLA_BOLLINO, S1C_NUM_BOLLINO, S1E_DT_PRIMA_INSTALLAZIONE, S1E_POT_FOCOLARE_KW, S1E_POT_UTILE_KW, "
				+ "S1L_DENOM_DELEGATO, S1L_FLG_DELEGA, S2B1_FLG_TERMO_CONTAB, S2B2_FLG_UNI_10200, S2F_FLG_TRATT_CLIMA_NON_RICH, S2F_FLG_TRATT_ACS_NON_RICH, S3A_FLG_LOCALE_INT_IDONEO, "
				+ "S3B_FLG_GEN_EXT_IDONEO, S3C_FLG_VENTILAZ_SUFF, S3D_FLG_EVAC_FUMI_IDONEO, S3E_FLG_CARTELLI_PRESENTI, S3F_FLG_ESTINZ_PRESENTI, S3G_FLG_INTERR_GEN_PRESENTI, "
				+ "S3H_FLG_RUBIN_PRESENTE, S3I_FLG_ASSENZA_PERD_COMB, S3J_FLG_TEMP_AMB_FUNZ, S3K_FLG_DM_1_12_1975, S4A_FLG_LIB_IMP_PRESENTE, S4B_FLG_LIB_COMPILATO, "
				+ "S4C_FLG_CONFORMITA_PRESENTE, S4D_FLG_LIB_USO_PRESENTE, S4E_FLG_PRATICA_VVF_PRESENTE, S4F_FLG_PRATICA_INAIL_PRESENTE, S4G_FLG_DM12_1975, "
				+ "S4G_MATRICOLA_DM_1_12_1975, S5A_FLG_ADOZIONE_VALVOLE_TERM, S5A_FLG_ISOLAMENTE_RETE, S5A_FLG_ADOZ_SIST_TRATTAM_H2O, S5A_FLG_SOSTITUZ_SIST_REGOLAZ, "
				+ "S5B_FLG_NO_INTERV_CONV, S5B_FLG_RELAZ_DETTAGLIO, S5B_FLG_RELAZ_DETTAGLIO_SUCC, S5B_FLG_VALUTAZ_NON_ESEGUITA, S5B_MOTIVO_RELAZ_NON_ESEG, S5C_FLG_DIMENS_CORRETTO, "
				+ "S5C_FLG_DIMENS_NON_CONTROLL, S5C_FLG_DIMENS_RELAZ_SUCCES, DATA_ULT_MOD, UTENTE_ULT_MOD, S1C_DATA_REE, S5C_FLG_DIMENS_NON_CORRETTO ");
		sql.append(" FROM SIGIT_T_RAPP_ISPEZ_GT");
		sql.append(" WHERE ");
		sql.append(" ID_ALLEGATO = :idAllegato");				
		paramMap.addValue("idAllegato", idAllegato);
		List<SigitTRappIspezGtDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByIdAllegatoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitSLibrettoDaoImpl::findByLibrettoFilter] esecuzione query", ex);
			throw new SigitSLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitSLibrettoDaoImpl", "findByLibrettoFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitSLibrettoDaoImpl::findByLibrettoFilter] END");
		}
		
		if(list != null && list.size() > 0) {
			
			sigitTRappIspezGtDto = list.get(0);
			
		}
		return sigitTRappIspezGtDto;
	}
	

}
