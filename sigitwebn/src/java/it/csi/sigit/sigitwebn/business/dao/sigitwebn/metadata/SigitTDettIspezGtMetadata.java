package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTDettIspezGtMetadata extends DAOMetadata {

	/**
	 * contiene l'elenco dei nomi delle property del DTO associato al DAO a cui
	 * questi metadati fanno riferimento
	 */
	private final String[] propertyNames;

	/**
	 * contiene l'elenco dei nomi delle colonne della tabella associata al DAO a cui
	 * questi metadati fanno riferimento
	 */
	private final String[] columnNames;

	/**
	 * Contiene i metadati relativi a:
	 * DAO: [sigitTDettIspezGt]
	 * tabella: [SIGIT_T_DETT_ISPEZ_GT].
	 */
	public SigitTDettIspezGtMetadata() {
		columnNames = new String[]{"ID_DETT_ISPEZ_GT", "FK_ALLEGATO", "FK_TIPO_COMPONENTE", "PROGRESSIVO",
				"CODICE_IMPIANTO", "DATA_INSTALL", "S6D_FLG_EVACU_FUMI", "S6I_FLG_TIPO_B", "S6I_FLG_TIPO_C",
				"S6J_FK_CLASS_DPR660_96", "S6K_POT_TERM_FOCOL_KW", "S6K_BRUCIATORE_DA_KW", "S6K_BRUCIATORE_A_KW",
				"S6L_PORTATA_COMB_M3_H", "S6L_PORTATA_COMB_KG_H", "S6L_POT_TERM_FOCOL_KW", "S7A_FLG_MANUT_EFFETTUATA",
				"S7A_DATA_ULTIMA_MANUT", "S7B_FLG_REE_PRESENTE", "S7B_DATA_REE", "S7B_FLG_OSSERVAZIONI",
				"S7B_FLG_RACCOMAND", "S7B_FLG_PRESCR", "S8A_N_MODULO_TERMICO", "S8B_FUMO_MIS_1", "S8B_FUMO_MIS_2",
				"S8B_FUMO_MIS_3", "S8C_MARCA_STRUM_MISURA", "S8C_MODELLO_STRUM_MISURA", "S8C_MATRICOLA_STRUM_MISURA",
				"S8D_TEMP_FLUIDO_MANDATA_C", "S8D_TEMP_ARIA_C", "S8D_TEMP_FUMI_C", "S8D_O2_PERC", "S8D_CO2_PERC",
				"S8D_CO_FUMI_SECCHI_PPM", "S8D_NO_MG_KW_H", "S8E_INDICE_ARIA", "S8E_FUMI_SECCHI_NO_ARIA_PPM",
				"S8E_QS_PERC", "S8E_ET_PERC", "S8E_REND_COMB_PERC", "S8E_NOX_MG_KW_H", "S9A_FLG_MONOSSIDO_CARB",
				"S9B_FLG_FUMOSITA", "S9C_REND_MIN_COMBUST_PERC", "S9C_FLG_REND_COMBUST_SUFF",
				"S9D_OSSIDI_AZOTO_LIM_MG_KW_H", "S9D_FLG_OSSIDI_AZOTO", "S9E_FLG_RISPETTO_NORMATIVA",
				"S9E_FLG_NO_RISPETTO_7A", "S9E_FLG_NO_RISPETTO_7B", "S9E_FLG_NO_RISPETTO_9A", "S9E_FLG_NO_RISPETTO_9B",
				"S9E_FLG_NO_RISPETTO_9C", "S9E_FLG_NO_RISPETTO_9D", "DATA_ULT_MOD", "UTENTE_ULT_MOD", "CONTROLLOWEB",
				"S7A_FREQUENZA_MANUT_ALTRO", "S7A_FK_FREQUENZA_MANUT"};
		propertyNames = new String[]{"idDettIspezGt", "fkAllegato", "fkTipoComponente", "progressivo", "codiceImpianto",
				"dataInstall", "s6dFlgEvacuFumi", "s6iFlgTipoB", "s6iFlgTipoC", "s6jFkClassDpr66096",
				"s6kPotTermFocolKw", "s6kBruciatoreDaKw", "s6kBruciatoreAKw", "s6lPortataCombM3H", "s6lPortataCombKgH",
				"s6lPotTermFocolKw", "s7aFlgManutEffettuata", "s7aDataUltimaManut", "s7bFlgReePresente", "s7bDataRee",
				"s7bFlgOsservazioni", "s7bFlgRaccomand", "s7bFlgPrescr", "s8aNModuloTermico", "s8bFumoMis1",
				"s8bFumoMis2", "s8bFumoMis3", "s8cMarcaStrumMisura", "s8cModelloStrumMisura", "s8cMatricolaStrumMisura",
				"s8dTempFluidoMandataC", "s8dTempAriaC", "s8dTempFumiC", "s8dO2Perc", "s8dCo2Perc",
				"s8dCoFumiSecchiPpm", "s8dNoMgKwH", "s8eIndiceAria", "s8eFumiSecchiNoAriaPpm", "s8eQsPerc", "s8eEtPerc",
				"s8eRendCombPerc", "s8eNoxMgKwH", "s9aFlgMonossidoCarb", "s9bFlgFumosita", "s9cRendMinCombustPerc",
				"s9cFlgRendCombustSuff", "s9dOssidiAzotoLimMgKwH", "s9dFlgOssidiAzoto", "s9eFlgRispettoNormativa",
				"s9eFlgNoRispetto7a", "s9eFlgNoRispetto7b", "s9eFlgNoRispetto9a", "s9eFlgNoRispetto9b",
				"s9eFlgNoRispetto9c", "s9eFlgNoRispetto9d", "dataUltMod", "utenteUltMod", "controlloweb",
				"s7aFrequenzaManutAltro", "s7aFkFrequenzaManut"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTDettIspezGt] fa riferimento
	 * (SIGIT_T_DETT_ISPEZ_GT).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DETT_ISPEZ_GT";
	}

	/**
	 * Method 'getColumnNames'
	 * Restutuisce l'insieme dei nomi delle colonne gestite dal DAO.
	 * @return String[]
	 * @generated
	 */
	public String[] getColumnNames() {
		String ris[] = new String[columnNames.length];
		System.arraycopy(columnNames, 0, ris, 0, columnNames.length);
		return ris;
	}

}
