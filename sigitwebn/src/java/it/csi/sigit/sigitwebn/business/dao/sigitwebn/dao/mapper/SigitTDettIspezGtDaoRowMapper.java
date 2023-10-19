package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTDettIspezGtDao
 * @generated
 */
public class SigitTDettIspezGtDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTDettIspezGtDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTDettIspezGtDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTDettIspezGtDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTDettIspezGtDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTDettIspezGtDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTDettIspezGtDto) {
			return mapRow_internal((SigitTDettIspezGtDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTDettIspezGtDto mapRow_internal(SigitTDettIspezGtDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTDettIspezGtDto dto = objectToFill;

		// colonna [ID_DETT_ISPEZ_GT]
		if (mapAllColumns || columnsToReadMap.get("ID_DETT_ISPEZ_GT") != null)
			dto.setIdDettIspezGt(rs.getBigDecimal("ID_DETT_ISPEZ_GT"));

		// colonna [FK_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("FK_ALLEGATO") != null)
			dto.setFkAllegato(rs.getBigDecimal("FK_ALLEGATO"));

		// colonna [FK_TIPO_COMPONENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_COMPONENTE") != null)
			dto.setFkTipoComponente(rs.getString("FK_TIPO_COMPONENTE"));

		// colonna [PROGRESSIVO]
		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setProgressivo(rs.getBigDecimal("PROGRESSIVO"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [DATA_INSTALL]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSTALL") != null)
			dto.setDataInstall(rs.getDate("DATA_INSTALL"));

		// colonna [S6D_FLG_EVACU_FUMI]
		if (mapAllColumns || columnsToReadMap.get("S6D_FLG_EVACU_FUMI") != null)
			dto.setS6dFlgEvacuFumi(rs.getString("S6D_FLG_EVACU_FUMI"));

		// colonna [S6I_FLG_TIPO_B]
		if (mapAllColumns || columnsToReadMap.get("S6I_FLG_TIPO_B") != null)
			dto.setS6iFlgTipoB(rs.getBigDecimal("S6I_FLG_TIPO_B"));

		// colonna [S6I_FLG_TIPO_C]
		if (mapAllColumns || columnsToReadMap.get("S6I_FLG_TIPO_C") != null)
			dto.setS6iFlgTipoC(rs.getBigDecimal("S6I_FLG_TIPO_C"));

		// colonna [S6J_FK_CLASS_DPR660_96]
		if (mapAllColumns || columnsToReadMap.get("S6J_FK_CLASS_DPR660_96") != null)
			dto.setS6jFkClassDpr66096(rs.getString("S6J_FK_CLASS_DPR660_96"));

		// colonna [S6K_POT_TERM_FOCOL_KW]
		if (mapAllColumns || columnsToReadMap.get("S6K_POT_TERM_FOCOL_KW") != null)
			dto.setS6kPotTermFocolKw(rs.getBigDecimal("S6K_POT_TERM_FOCOL_KW"));

		// colonna [S6K_BRUCIATORE_DA_KW]
		if (mapAllColumns || columnsToReadMap.get("S6K_BRUCIATORE_DA_KW") != null)
			dto.setS6kBruciatoreDaKw(rs.getBigDecimal("S6K_BRUCIATORE_DA_KW"));

		// colonna [S6K_BRUCIATORE_A_KW]
		if (mapAllColumns || columnsToReadMap.get("S6K_BRUCIATORE_A_KW") != null)
			dto.setS6kBruciatoreAKw(rs.getBigDecimal("S6K_BRUCIATORE_A_KW"));

		// colonna [S6L_PORTATA_COMB_M3_H]
		if (mapAllColumns || columnsToReadMap.get("S6L_PORTATA_COMB_M3_H") != null)
			dto.setS6lPortataCombM3H(rs.getBigDecimal("S6L_PORTATA_COMB_M3_H"));

		// colonna [S6L_PORTATA_COMB_KG_H]
		if (mapAllColumns || columnsToReadMap.get("S6L_PORTATA_COMB_KG_H") != null)
			dto.setS6lPortataCombKgH(rs.getString("S6L_PORTATA_COMB_KG_H"));

		// colonna [S6L_POT_TERM_FOCOL_KW]
		if (mapAllColumns || columnsToReadMap.get("S6L_POT_TERM_FOCOL_KW") != null)
			dto.setS6lPotTermFocolKw(rs.getBigDecimal("S6L_POT_TERM_FOCOL_KW"));

		// colonna [S7A_FLG_MANUT_EFFETTUATA]
		if (mapAllColumns || columnsToReadMap.get("S7A_FLG_MANUT_EFFETTUATA") != null)
			dto.setS7aFlgManutEffettuata(rs.getBigDecimal("S7A_FLG_MANUT_EFFETTUATA"));

		// colonna [S7A_DATA_ULTIMA_MANUT]
		if (mapAllColumns || columnsToReadMap.get("S7A_DATA_ULTIMA_MANUT") != null)
			dto.setS7aDataUltimaManut(rs.getDate("S7A_DATA_ULTIMA_MANUT"));

		// colonna [S7B_FLG_REE_PRESENTE]
		if (mapAllColumns || columnsToReadMap.get("S7B_FLG_REE_PRESENTE") != null)
			dto.setS7bFlgReePresente(rs.getBigDecimal("S7B_FLG_REE_PRESENTE"));

		// colonna [S7B_DATA_REE]
		if (mapAllColumns || columnsToReadMap.get("S7B_DATA_REE") != null)
			dto.setS7bDataRee(rs.getDate("S7B_DATA_REE"));

		// colonna [S7B_FLG_OSSERVAZIONI]
		if (mapAllColumns || columnsToReadMap.get("S7B_FLG_OSSERVAZIONI") != null)
			dto.setS7bFlgOsservazioni(rs.getBigDecimal("S7B_FLG_OSSERVAZIONI"));

		// colonna [S7B_FLG_RACCOMAND]
		if (mapAllColumns || columnsToReadMap.get("S7B_FLG_RACCOMAND") != null)
			dto.setS7bFlgRaccomand(rs.getBigDecimal("S7B_FLG_RACCOMAND"));

		// colonna [S7B_FLG_PRESCR]
		if (mapAllColumns || columnsToReadMap.get("S7B_FLG_PRESCR") != null)
			dto.setS7bFlgPrescr(rs.getBigDecimal("S7B_FLG_PRESCR"));

		// colonna [S8A_N_MODULO_TERMICO]
		if (mapAllColumns || columnsToReadMap.get("S8A_N_MODULO_TERMICO") != null)
			dto.setS8aNModuloTermico(rs.getString("S8A_N_MODULO_TERMICO"));

		// colonna [S8B_FUMO_MIS_1]
		if (mapAllColumns || columnsToReadMap.get("S8B_FUMO_MIS_1") != null)
			dto.setS8bFumoMis1(rs.getBigDecimal("S8B_FUMO_MIS_1"));

		// colonna [S8B_FUMO_MIS_2]
		if (mapAllColumns || columnsToReadMap.get("S8B_FUMO_MIS_2") != null)
			dto.setS8bFumoMis2(rs.getBigDecimal("S8B_FUMO_MIS_2"));

		// colonna [S8B_FUMO_MIS_3]
		if (mapAllColumns || columnsToReadMap.get("S8B_FUMO_MIS_3") != null)
			dto.setS8bFumoMis3(rs.getBigDecimal("S8B_FUMO_MIS_3"));

		// colonna [S8C_MARCA_STRUM_MISURA]
		if (mapAllColumns || columnsToReadMap.get("S8C_MARCA_STRUM_MISURA") != null)
			dto.setS8cMarcaStrumMisura(rs.getString("S8C_MARCA_STRUM_MISURA"));

		// colonna [S8C_MODELLO_STRUM_MISURA]
		if (mapAllColumns || columnsToReadMap.get("S8C_MODELLO_STRUM_MISURA") != null)
			dto.setS8cModelloStrumMisura(rs.getString("S8C_MODELLO_STRUM_MISURA"));

		// colonna [S8C_MATRICOLA_STRUM_MISURA]
		if (mapAllColumns || columnsToReadMap.get("S8C_MATRICOLA_STRUM_MISURA") != null)
			dto.setS8cMatricolaStrumMisura(rs.getString("S8C_MATRICOLA_STRUM_MISURA"));

		// colonna [S8D_TEMP_FLUIDO_MANDATA_C]
		if (mapAllColumns || columnsToReadMap.get("S8D_TEMP_FLUIDO_MANDATA_C") != null)
			dto.setS8dTempFluidoMandataC(rs.getBigDecimal("S8D_TEMP_FLUIDO_MANDATA_C"));

		// colonna [S8D_TEMP_ARIA_C]
		if (mapAllColumns || columnsToReadMap.get("S8D_TEMP_ARIA_C") != null)
			dto.setS8dTempAriaC(rs.getBigDecimal("S8D_TEMP_ARIA_C"));

		// colonna [S8D_TEMP_FUMI_C]
		if (mapAllColumns || columnsToReadMap.get("S8D_TEMP_FUMI_C") != null)
			dto.setS8dTempFumiC(rs.getBigDecimal("S8D_TEMP_FUMI_C"));

		// colonna [S8D_O2_PERC]
		if (mapAllColumns || columnsToReadMap.get("S8D_O2_PERC") != null)
			dto.setS8dO2Perc(rs.getBigDecimal("S8D_O2_PERC"));

		// colonna [S8D_CO2_PERC]
		if (mapAllColumns || columnsToReadMap.get("S8D_CO2_PERC") != null)
			dto.setS8dCo2Perc(rs.getBigDecimal("S8D_CO2_PERC"));

		// colonna [S8D_CO_FUMI_SECCHI_PPM]
		if (mapAllColumns || columnsToReadMap.get("S8D_CO_FUMI_SECCHI_PPM") != null)
			dto.setS8dCoFumiSecchiPpm(rs.getBigDecimal("S8D_CO_FUMI_SECCHI_PPM"));

		// colonna [S8D_NO_MG_KW_H]
		if (mapAllColumns || columnsToReadMap.get("S8D_NO_MG_KW_H") != null)
			dto.setS8dNoMgKwH(rs.getBigDecimal("S8D_NO_MG_KW_H"));

		// colonna [S8E_INDICE_ARIA]
		if (mapAllColumns || columnsToReadMap.get("S8E_INDICE_ARIA") != null)
			dto.setS8eIndiceAria(rs.getBigDecimal("S8E_INDICE_ARIA"));

		// colonna [S8E_FUMI_SECCHI_NO_ARIA_PPM]
		if (mapAllColumns || columnsToReadMap.get("S8E_FUMI_SECCHI_NO_ARIA_PPM") != null)
			dto.setS8eFumiSecchiNoAriaPpm(rs.getBigDecimal("S8E_FUMI_SECCHI_NO_ARIA_PPM"));

		// colonna [S8E_QS_PERC]
		if (mapAllColumns || columnsToReadMap.get("S8E_QS_PERC") != null)
			dto.setS8eQsPerc(rs.getBigDecimal("S8E_QS_PERC"));

		// colonna [S8E_ET_PERC]
		if (mapAllColumns || columnsToReadMap.get("S8E_ET_PERC") != null)
			dto.setS8eEtPerc(rs.getBigDecimal("S8E_ET_PERC"));

		// colonna [S8E_REND_COMB_PERC]
		if (mapAllColumns || columnsToReadMap.get("S8E_REND_COMB_PERC") != null)
			dto.setS8eRendCombPerc(rs.getBigDecimal("S8E_REND_COMB_PERC"));

		// colonna [S8E_NOX_MG_KW_H]
		if (mapAllColumns || columnsToReadMap.get("S8E_NOX_MG_KW_H") != null)
			dto.setS8eNoxMgKwH(rs.getBigDecimal("S8E_NOX_MG_KW_H"));

		// colonna [S9A_FLG_MONOSSIDO_CARB]
		if (mapAllColumns || columnsToReadMap.get("S9A_FLG_MONOSSIDO_CARB") != null)
			dto.setS9aFlgMonossidoCarb(rs.getString("S9A_FLG_MONOSSIDO_CARB"));

		// colonna [S9B_FLG_FUMOSITA]
		if (mapAllColumns || columnsToReadMap.get("S9B_FLG_FUMOSITA") != null)
			dto.setS9bFlgFumosita(rs.getString("S9B_FLG_FUMOSITA"));

		// colonna [S9C_REND_MIN_COMBUST_PERC]
		if (mapAllColumns || columnsToReadMap.get("S9C_REND_MIN_COMBUST_PERC") != null)
			dto.setS9cRendMinCombustPerc(rs.getBigDecimal("S9C_REND_MIN_COMBUST_PERC"));

		// colonna [S9C_FLG_REND_COMBUST_SUFF]
		if (mapAllColumns || columnsToReadMap.get("S9C_FLG_REND_COMBUST_SUFF") != null)
			dto.setS9cFlgRendCombustSuff(rs.getBigDecimal("S9C_FLG_REND_COMBUST_SUFF"));

		// colonna [S9D_OSSIDI_AZOTO_LIM_MG_KW_H]
		if (mapAllColumns || columnsToReadMap.get("S9D_OSSIDI_AZOTO_LIM_MG_KW_H") != null)
			dto.setS9dOssidiAzotoLimMgKwH(rs.getBigDecimal("S9D_OSSIDI_AZOTO_LIM_MG_KW_H"));

		// colonna [S9D_FLG_OSSIDI_AZOTO]
		if (mapAllColumns || columnsToReadMap.get("S9D_FLG_OSSIDI_AZOTO") != null)
			dto.setS9dFlgOssidiAzoto(rs.getString("S9D_FLG_OSSIDI_AZOTO"));

		// colonna [S9E_FLG_RISPETTO_NORMATIVA]
		if (mapAllColumns || columnsToReadMap.get("S9E_FLG_RISPETTO_NORMATIVA") != null)
			dto.setS9eFlgRispettoNormativa(rs.getBigDecimal("S9E_FLG_RISPETTO_NORMATIVA"));

		// colonna [S9E_FLG_NO_RISPETTO_7A]
		if (mapAllColumns || columnsToReadMap.get("S9E_FLG_NO_RISPETTO_7A") != null)
			dto.setS9eFlgNoRispetto7a(rs.getBigDecimal("S9E_FLG_NO_RISPETTO_7A"));

		// colonna [S9E_FLG_NO_RISPETTO_7B]
		if (mapAllColumns || columnsToReadMap.get("S9E_FLG_NO_RISPETTO_7B") != null)
			dto.setS9eFlgNoRispetto7b(rs.getBigDecimal("S9E_FLG_NO_RISPETTO_7B"));

		// colonna [S9E_FLG_NO_RISPETTO_9A]
		if (mapAllColumns || columnsToReadMap.get("S9E_FLG_NO_RISPETTO_9A") != null)
			dto.setS9eFlgNoRispetto9a(rs.getBigDecimal("S9E_FLG_NO_RISPETTO_9A"));

		// colonna [S9E_FLG_NO_RISPETTO_9B]
		if (mapAllColumns || columnsToReadMap.get("S9E_FLG_NO_RISPETTO_9B") != null)
			dto.setS9eFlgNoRispetto9b(rs.getBigDecimal("S9E_FLG_NO_RISPETTO_9B"));

		// colonna [S9E_FLG_NO_RISPETTO_9C]
		if (mapAllColumns || columnsToReadMap.get("S9E_FLG_NO_RISPETTO_9C") != null)
			dto.setS9eFlgNoRispetto9c(rs.getBigDecimal("S9E_FLG_NO_RISPETTO_9C"));

		// colonna [S9E_FLG_NO_RISPETTO_9D]
		if (mapAllColumns || columnsToReadMap.get("S9E_FLG_NO_RISPETTO_9D") != null)
			dto.setS9eFlgNoRispetto9d(rs.getBigDecimal("S9E_FLG_NO_RISPETTO_9D"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		// colonna [CONTROLLOWEB]
		if (mapAllColumns || columnsToReadMap.get("CONTROLLOWEB") != null)
			dto.setControlloweb(rs.getTimestamp("CONTROLLOWEB"));

		// colonna [S7A_FREQUENZA_MANUT_ALTRO]
		if (mapAllColumns || columnsToReadMap.get("S7A_FREQUENZA_MANUT_ALTRO") != null)
			dto.setS7aFrequenzaManutAltro(rs.getString("S7A_FREQUENZA_MANUT_ALTRO"));

		// colonna [S7A_FK_FREQUENZA_MANUT]
		if (mapAllColumns || columnsToReadMap.get("S7A_FK_FREQUENZA_MANUT") != null)
			dto.setS7aFkFrequenzaManut((Integer) rs.getObject("S7A_FK_FREQUENZA_MANUT"));

		return dto;
	}

}
