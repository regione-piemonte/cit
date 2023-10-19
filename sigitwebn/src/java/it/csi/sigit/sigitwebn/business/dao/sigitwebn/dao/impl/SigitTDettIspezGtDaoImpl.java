package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import it.csi.sigit.sigitwebn.business.dao.impl.*;
import it.csi.sigit.sigitwebn.business.dao.util.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import java.util.Map;
import java.util.TreeMap;

/*PROTECTED REGION ID(R1113787951) ENABLED START*/
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTDettIspezGt.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - byIdAllegato (datagen::CustomFinder)
 *   - byExample (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - dettDettIspezGtComune (datagen::CustomUpdater)
 * - DELETERS:
 *   - deleteByIdAllegato (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTDettIspezGtDaoImpl extends AbstractDAO implements SigitTDettIspezGtDao {
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
	 * Metodo di inserimento del DAO sigitTDettIspezGt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDettIspezGtPk
	 * @generated
	 */

	public SigitTDettIspezGtPk insert(SigitTDettIspezGtDto dto)

	{
		LOG.debug("[SigitTDettIspezGtDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_DETT_ISPEZ_GT,FK_ALLEGATO,FK_TIPO_COMPONENTE,PROGRESSIVO,CODICE_IMPIANTO,DATA_INSTALL,S6D_FLG_EVACU_FUMI,S6I_FLG_TIPO_B,S6I_FLG_TIPO_C,S6J_FK_CLASS_DPR660_96,S6K_POT_TERM_FOCOL_KW,S6K_BRUCIATORE_DA_KW,S6K_BRUCIATORE_A_KW,S6L_PORTATA_COMB_M3_H,S6L_PORTATA_COMB_KG_H,S6L_POT_TERM_FOCOL_KW,S7A_FLG_MANUT_EFFETTUATA,S7A_DATA_ULTIMA_MANUT,S7B_FLG_REE_PRESENTE,S7B_DATA_REE,S7B_FLG_OSSERVAZIONI,S7B_FLG_RACCOMAND,S7B_FLG_PRESCR,S8A_N_MODULO_TERMICO,S8B_FUMO_MIS_1,S8B_FUMO_MIS_2,S8B_FUMO_MIS_3,S8C_MARCA_STRUM_MISURA,S8C_MODELLO_STRUM_MISURA,S8C_MATRICOLA_STRUM_MISURA,S8D_TEMP_FLUIDO_MANDATA_C,S8D_TEMP_ARIA_C,S8D_TEMP_FUMI_C,S8D_O2_PERC,S8D_CO2_PERC,S8D_CO_FUMI_SECCHI_PPM,S8D_NO_MG_KW_H,S8E_INDICE_ARIA,S8E_FUMI_SECCHI_NO_ARIA_PPM,S8E_QS_PERC,S8E_ET_PERC,S8E_REND_COMB_PERC,S8E_NOX_MG_KW_H,S9A_FLG_MONOSSIDO_CARB,S9B_FLG_FUMOSITA,S9C_REND_MIN_COMBUST_PERC,S9C_FLG_REND_COMBUST_SUFF,S9D_OSSIDI_AZOTO_LIM_MG_KW_H,S9D_FLG_OSSIDI_AZOTO,S9E_FLG_RISPETTO_NORMATIVA,S9E_FLG_NO_RISPETTO_7A,S9E_FLG_NO_RISPETTO_7B,S9E_FLG_NO_RISPETTO_9A,S9E_FLG_NO_RISPETTO_9B,S9E_FLG_NO_RISPETTO_9C,S9E_FLG_NO_RISPETTO_9D,DATA_ULT_MOD,UTENTE_ULT_MOD,CONTROLLOWEB,S7A_FREQUENZA_MANUT_ALTRO,S7A_FK_FREQUENZA_MANUT ) VALUES (  :ID_DETT_ISPEZ_GT , :FK_ALLEGATO , :FK_TIPO_COMPONENTE , :PROGRESSIVO , :CODICE_IMPIANTO , :DATA_INSTALL , :S6D_FLG_EVACU_FUMI , :S6I_FLG_TIPO_B , :S6I_FLG_TIPO_C , :S6J_FK_CLASS_DPR660_96 , :S6K_POT_TERM_FOCOL_KW , :S6K_BRUCIATORE_DA_KW , :S6K_BRUCIATORE_A_KW , :S6L_PORTATA_COMB_M3_H , :S6L_PORTATA_COMB_KG_H , :S6L_POT_TERM_FOCOL_KW , :S7A_FLG_MANUT_EFFETTUATA , :S7A_DATA_ULTIMA_MANUT , :S7B_FLG_REE_PRESENTE , :S7B_DATA_REE , :S7B_FLG_OSSERVAZIONI , :S7B_FLG_RACCOMAND , :S7B_FLG_PRESCR , :S8A_N_MODULO_TERMICO , :S8B_FUMO_MIS_1 , :S8B_FUMO_MIS_2 , :S8B_FUMO_MIS_3 , :S8C_MARCA_STRUM_MISURA , :S8C_MODELLO_STRUM_MISURA , :S8C_MATRICOLA_STRUM_MISURA , :S8D_TEMP_FLUIDO_MANDATA_C , :S8D_TEMP_ARIA_C , :S8D_TEMP_FUMI_C , :S8D_O2_PERC , :S8D_CO2_PERC , :S8D_CO_FUMI_SECCHI_PPM , :S8D_NO_MG_KW_H , :S8E_INDICE_ARIA , :S8E_FUMI_SECCHI_NO_ARIA_PPM , :S8E_QS_PERC , :S8E_ET_PERC , :S8E_REND_COMB_PERC , :S8E_NOX_MG_KW_H , :S9A_FLG_MONOSSIDO_CARB , :S9B_FLG_FUMOSITA , :S9C_REND_MIN_COMBUST_PERC , :S9C_FLG_REND_COMBUST_SUFF , :S9D_OSSIDI_AZOTO_LIM_MG_KW_H , :S9D_FLG_OSSIDI_AZOTO , :S9E_FLG_RISPETTO_NORMATIVA , :S9E_FLG_NO_RISPETTO_7A , :S9E_FLG_NO_RISPETTO_7B , :S9E_FLG_NO_RISPETTO_9A , :S9E_FLG_NO_RISPETTO_9B , :S9E_FLG_NO_RISPETTO_9C , :S9E_FLG_NO_RISPETTO_9D , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :CONTROLLOWEB , :S7A_FREQUENZA_MANUT_ALTRO , :S7A_FK_FREQUENZA_MANUT  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DETT_ISPEZ_GT]
		params.addValue("ID_DETT_ISPEZ_GT", newKey, java.sql.Types.NUMERIC);

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
		params.addValue("CONTROLLOWEB", dto.getControlloweb(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [S7A_FREQUENZA_MANUT_ALTRO]
		params.addValue("S7A_FREQUENZA_MANUT_ALTRO", dto.getS7aFrequenzaManutAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S7A_FK_FREQUENZA_MANUT]
		params.addValue("S7A_FK_FREQUENZA_MANUT", dto.getS7aFkFrequenzaManut(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdDettIspezGt(newKey);
		LOG.debug("[SigitTDettIspezGtDaoImpl::insert] END");
		return dto.createPk();

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
		params.addValue("CONTROLLOWEB", dto.getControlloweb(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [S7A_FREQUENZA_MANUT_ALTRO]
		params.addValue("S7A_FREQUENZA_MANUT_ALTRO", dto.getS7aFrequenzaManutAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S7A_FK_FREQUENZA_MANUT]
		params.addValue("S7A_FK_FREQUENZA_MANUT", dto.getS7aFkFrequenzaManut(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettIspezGtDaoImpl::update] END");
	}

	/** 
	 * Custom updater in the SIGIT_T_DETT_ISPEZ_GT table.
	 * @generated
	 */
	public void customUpdaterDettDettIspezGtComune(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGtDto filter,
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGtDto value)
			throws SigitTDettIspezGtDaoException {
		LOG.debug("[SigitTDettIspezGtDaoImpl::customUpdaterDettDettIspezGtComune] START");
		/*PROTECTED REGION ID(R-245046360) ENABLED START*/
		//***scrivere la custom query
		final String sql = "UPDATE " + getTableName() + " SET "

				+ " S6D_FLG_EVACU_FUMI = :S6D_FLG_EVACU_FUMI ," + " S6I_FLG_TIPO_B = :S6I_FLG_TIPO_B ,"
				+ " S6I_FLG_TIPO_C = :S6I_FLG_TIPO_C ," + " S6J_FK_CLASS_DPR660_96 = :S6J_FK_CLASS_DPR660_96 ,"
				+ " S6K_POT_TERM_FOCOL_KW = :S6K_POT_TERM_FOCOL_KW ,"
				+ " S6K_BRUCIATORE_DA_KW = :S6K_BRUCIATORE_DA_KW ," + " S6K_BRUCIATORE_A_KW = :S6K_BRUCIATORE_A_KW ,"
				+ " S6L_PORTATA_COMB_M3_H = :S6L_PORTATA_COMB_M3_H ,"
				+ " S6L_PORTATA_COMB_KG_H = :S6L_PORTATA_COMB_KG_H ,"
				+ " S6L_POT_TERM_FOCOL_KW = :S6L_POT_TERM_FOCOL_KW ,"
				+ " S7A_FK_FREQUENZA_MANUT = :S7A_FK_FREQUENZA_MANUT ,"
				+ " S7A_FLG_MANUT_EFFETTUATA = :S7A_FLG_MANUT_EFFETTUATA ,"
				+ " S7A_DATA_ULTIMA_MANUT = :S7A_DATA_ULTIMA_MANUT ,"
				+ " S7B_FLG_REE_PRESENTE = :S7B_FLG_REE_PRESENTE ," + " S7B_DATA_REE = :S7B_DATA_REE ,"
				+ " S7B_FLG_OSSERVAZIONI = :S7B_FLG_OSSERVAZIONI ," + " S7B_FLG_RACCOMAND = :S7B_FLG_RACCOMAND ,"
				+ " S7B_FLG_PRESCR = :S7B_FLG_PRESCR," + " S7A_FREQUENZA_MANUT_ALTRO = :S7A_FREQUENZA_MANUT_ALTRO"
				+ " WHERE ID_DETT_ISPEZ_GT <> :ID_DETT_ISPEZ_GT " + " AND FK_ALLEGATO = :FK_ALLEGATO"
				+ " AND PROGRESSIVO = :PROGRESSIVO" + " AND CODICE_IMPIANTO = :CODICE_IMPIANTO"
				+ " AND DATA_INSTALL = :DATA_INSTALL";

		MapSqlParameterSource params = new MapSqlParameterSource();

		//parametri per le condizioni nella where
		params.addValue("ID_DETT_ISPEZ_GT", filter.getIdDettIspezGt(), java.sql.Types.NUMERIC);
		params.addValue("FK_ALLEGATO", filter.getFkAllegato(), java.sql.Types.NUMERIC);
		params.addValue("FK_TIPO_COMPONENTE", filter.getFkTipoComponente(), java.sql.Types.VARCHAR);
		params.addValue("PROGRESSIVO", filter.getProgressivo(), java.sql.Types.NUMERIC);
		params.addValue("CODICE_IMPIANTO", filter.getCodiceImpianto(), java.sql.Types.NUMERIC);
		params.addValue("DATA_INSTALL", filter.getDataInstall(), java.sql.Types.DATE);

		//parametri per le assegnazioni nella parte set
		params.addValue("S6D_FLG_EVACU_FUMI", value.getS6dFlgEvacuFumi(), java.sql.Types.VARCHAR);
		params.addValue("S6I_FLG_TIPO_B", value.getS6iFlgTipoB(), java.sql.Types.NUMERIC);
		params.addValue("S6I_FLG_TIPO_C", value.getS6iFlgTipoC(), java.sql.Types.NUMERIC);
		params.addValue("S6J_FK_CLASS_DPR660_96", value.getS6jFkClassDpr66096(), java.sql.Types.VARCHAR);
		params.addValue("S6K_POT_TERM_FOCOL_KW", value.getS6kPotTermFocolKw(), java.sql.Types.NUMERIC);
		params.addValue("S6K_BRUCIATORE_DA_KW", value.getS6kBruciatoreDaKw(), java.sql.Types.NUMERIC);
		params.addValue("S6K_BRUCIATORE_A_KW", value.getS6kBruciatoreAKw(), java.sql.Types.NUMERIC);
		params.addValue("S6L_PORTATA_COMB_M3_H", value.getS6lPortataCombM3H(), java.sql.Types.NUMERIC);
		params.addValue("S6L_PORTATA_COMB_KG_H", value.getS6lPortataCombKgH(), java.sql.Types.VARCHAR);
		params.addValue("S6L_POT_TERM_FOCOL_KW", value.getS6lPotTermFocolKw(), java.sql.Types.NUMERIC);
		params.addValue("S7A_FK_FREQUENZA_MANUT", value.getS7aFkFrequenzaManut(), java.sql.Types.INTEGER);
		params.addValue("S7A_FLG_MANUT_EFFETTUATA", value.getS7aFlgManutEffettuata(), java.sql.Types.NUMERIC);
		params.addValue("S7A_DATA_ULTIMA_MANUT", value.getS7aDataUltimaManut(), java.sql.Types.DATE);
		params.addValue("S7B_FLG_REE_PRESENTE", value.getS7bFlgReePresente(), java.sql.Types.NUMERIC);
		params.addValue("S7B_DATA_REE", value.getS7bDataRee(), java.sql.Types.DATE);
		params.addValue("S7B_FLG_OSSERVAZIONI", value.getS7bFlgOsservazioni(), java.sql.Types.NUMERIC);
		params.addValue("S7B_FLG_RACCOMAND", value.getS7bFlgRaccomand(), java.sql.Types.NUMERIC);
		params.addValue("S7B_FLG_PRESCR", value.getS7bFlgPrescr(), java.sql.Types.NUMERIC);
		params.addValue("S7A_FREQUENZA_MANUT_ALTRO", value.getS7aFrequenzaManutAltro(), java.sql.Types.VARCHAR);

		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettIspezGtDaoImpl::customUpdaterDettDettIspezGtComune] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_DETT_ISPEZ_GT table.
	 * @generated
	 */
	public void customDeleterDeleteByIdAllegato(java.lang.Integer filter) throws SigitTDettIspezGtDaoException {
		LOG.debug("[SigitTDettIspezGtDaoImpl::customDeleterDeleteByIdAllegato] START");
		/*PROTECTED REGION ID(R1303700671) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE FK_ALLEGATO = :idAllegato";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idAllegato", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettIspezGtDaoImpl::customDeleterDeleteByIdAllegato] END");
	}

	protected SigitTDettIspezGtDaoRowMapper byIdAllegatoRowMapper = new SigitTDettIspezGtDaoRowMapper(null,
			SigitTDettIspezGtDto.class, this);

	protected SigitTDettIspezGtDaoRowMapper byExampleRowMapper = new SigitTDettIspezGtDaoRowMapper(null,
			SigitTDettIspezGtDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DETT_ISPEZ_GT";
	}

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettIspezGtDto> findByIdAllegato(java.math.BigDecimal input)
			throws SigitTDettIspezGtDaoException {
		LOG.debug("[SigitTDettIspezGtDaoImpl::findByIdAllegato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_DETT_ISPEZ_GT,FK_ALLEGATO,FK_TIPO_COMPONENTE,PROGRESSIVO,CODICE_IMPIANTO,DATA_INSTALL,S6D_FLG_EVACU_FUMI,S6I_FLG_TIPO_B,S6I_FLG_TIPO_C,S6J_FK_CLASS_DPR660_96,S6K_POT_TERM_FOCOL_KW,S6K_BRUCIATORE_DA_KW,S6K_BRUCIATORE_A_KW,S6L_PORTATA_COMB_M3_H,S6L_PORTATA_COMB_KG_H,S6L_POT_TERM_FOCOL_KW,S7A_FLG_MANUT_EFFETTUATA,S7A_DATA_ULTIMA_MANUT,S7B_FLG_REE_PRESENTE,S7B_DATA_REE,S7B_FLG_OSSERVAZIONI,S7B_FLG_RACCOMAND,S7B_FLG_PRESCR,S8A_N_MODULO_TERMICO,S8B_FUMO_MIS_1,S8B_FUMO_MIS_2,S8B_FUMO_MIS_3,S8C_MARCA_STRUM_MISURA,S8C_MODELLO_STRUM_MISURA,S8C_MATRICOLA_STRUM_MISURA,S8D_TEMP_FLUIDO_MANDATA_C,S8D_TEMP_ARIA_C,S8D_TEMP_FUMI_C,S8D_O2_PERC,S8D_CO2_PERC,S8D_CO_FUMI_SECCHI_PPM,S8D_NO_MG_KW_H,S8E_INDICE_ARIA,S8E_FUMI_SECCHI_NO_ARIA_PPM,S8E_QS_PERC,S8E_ET_PERC,S8E_REND_COMB_PERC,S8E_NOX_MG_KW_H,S9A_FLG_MONOSSIDO_CARB,S9B_FLG_FUMOSITA,S9C_REND_MIN_COMBUST_PERC,S9C_FLG_REND_COMBUST_SUFF,S9D_OSSIDI_AZOTO_LIM_MG_KW_H,S9D_FLG_OSSIDI_AZOTO,S9E_FLG_RISPETTO_NORMATIVA,S9E_FLG_NO_RISPETTO_7A,S9E_FLG_NO_RISPETTO_7B,S9E_FLG_NO_RISPETTO_9A,S9E_FLG_NO_RISPETTO_9B,S9E_FLG_NO_RISPETTO_9C,S9E_FLG_NO_RISPETTO_9D,DATA_ULT_MOD,UTENTE_ULT_MOD,CONTROLLOWEB,S7A_FREQUENZA_MANUT_ALTRO,S7A_FK_FREQUENZA_MANUT ");
		sql.append(" FROM SIGIT_T_DETT_ISPEZ_GT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R307123054) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("FK_ALLEGATO = :idAllegato");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1811443860) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idAllegato", input);

		/*PROTECTED REGION END*/
		List<SigitTDettIspezGtDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDettIspezGtDaoImpl::findByIdAllegato] esecuzione query", ex);
			throw new SigitTDettIspezGtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDettIspezGtDaoImpl", "findByIdAllegato", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDettIspezGtDaoImpl::findByIdAllegato] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettIspezGtDto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGtDto input)
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

}
