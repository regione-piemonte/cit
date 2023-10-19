package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTRappIspezGtMetadata extends DAOMetadata {

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
	 * DAO: [sigitTRappIspezGt]
	 * tabella: [SIGIT_T_RAPP_ISPEZ_GT].
	 */
	public SigitTRappIspezGtMetadata() {
		columnNames = new String[]{"ID_ALLEGATO", "S1C_FLG_REE_INVIATO", "S1C_FLG_REE_BOLLINO", "S1C_SIGLA_BOLLINO",
				"S1C_NUM_BOLLINO", "S1E_DT_PRIMA_INSTALLAZIONE", "S1E_POT_FOCOLARE_KW", "S1E_POT_UTILE_KW",
				"S1L_DENOM_DELEGATO", "S1L_FLG_DELEGA", "S2B1_FLG_TERMO_CONTAB", "S2B2_FLG_UNI_10200",
				"S2F_FLG_TRATT_CLIMA_NON_RICH", "S2F_FLG_TRATT_ACS_NON_RICH", "S3A_FLG_LOCALE_INT_IDONEO",
				"S3B_FLG_GEN_EXT_IDONEO", "S3C_FLG_VENTILAZ_SUFF", "S3D_FLG_EVAC_FUMI_IDONEO",
				"S3E_FLG_CARTELLI_PRESENTI", "S3F_FLG_ESTINZ_PRESENTI", "S3G_FLG_INTERR_GEN_PRESENTI",
				"S3H_FLG_RUBIN_PRESENTE", "S3I_FLG_ASSENZA_PERD_COMB", "S3J_FLG_TEMP_AMB_FUNZ", "S3K_FLG_DM_1_12_1975",
				"S4A_FLG_LIB_IMP_PRESENTE", "S4B_FLG_LIB_COMPILATO", "S4C_FLG_CONFORMITA_PRESENTE",
				"S4D_FLG_LIB_USO_PRESENTE", "S4E_FLG_PRATICA_VVF_PRESENTE", "S4F_FLG_PRATICA_INAIL_PRESENTE",
				"S4G_FLG_DM12_1975", "S4G_MATRICOLA_DM_1_12_1975", "S5A_FLG_ADOZIONE_VALVOLE_TERM",
				"S5A_FLG_ISOLAMENTE_RETE", "S5A_FLG_ADOZ_SIST_TRATTAM_H2O", "S5A_FLG_SOSTITUZ_SIST_REGOLAZ",
				"S5B_FLG_NO_INTERV_CONV", "S5B_FLG_RELAZ_DETTAGLIO", "S5B_FLG_RELAZ_DETTAGLIO_SUCC",
				"S5B_FLG_VALUTAZ_NON_ESEGUITA", "S5B_MOTIVO_RELAZ_NON_ESEG", "S5C_FLG_DIMENS_CORRETTO",
				"S5C_FLG_DIMENS_NON_CONTROLL", "S5C_FLG_DIMENS_RELAZ_SUCCES", "DATA_ULT_MOD", "UTENTE_ULT_MOD",
				"S1C_DATA_REE", "S5C_FLG_DIMENS_NON_CORRETTO"};
		propertyNames = new String[]{"idAllegato", "s1cFlgReeInviato", "s1cFlgReeBollino", "s1cSiglaBollino",
				"s1cNumBollino", "s1eDtPrimaInstallazione", "s1ePotFocolareKw", "s1ePotUtileKw", "s1lDenomDelegato",
				"s1lFlgDelega", "s2b1FlgTermoContab", "s2b2FlgUni10200", "s2fFlgTrattClimaNonRich",
				"s2fFlgTrattAcsNonRich", "s3aFlgLocaleIntIdoneo", "s3bFlgGenExtIdoneo", "s3cFlgVentilazSuff",
				"s3dFlgEvacFumiIdoneo", "s3eFlgCartelliPresenti", "s3fFlgEstinzPresenti", "s3gFlgInterrGenPresenti",
				"s3hFlgRubinPresente", "s3iFlgAssenzaPerdComb", "s3jFlgTempAmbFunz", "s3kFlgDm1121975",
				"s4aFlgLibImpPresente", "s4bFlgLibCompilato", "s4cFlgConformitaPresente", "s4dFlgLibUsoPresente",
				"s4eFlgPraticaVvfPresente", "s4fFlgPraticaInailPresente", "s4gFlgDm121975", "s4gMatricolaDm1121975",
				"s5aFlgAdozioneValvoleTerm", "s5aFlgIsolamenteRete", "s5aFlgAdozSistTrattamH2o",
				"s5aFlgSostituzSistRegolaz", "s5bFlgNoIntervConv", "s5bFlgRelazDettaglio", "s5bFlgRelazDettaglioSucc",
				"s5bFlgValutazNonEseguita", "s5bMotivoRelazNonEseg", "s5cFlgDimensCorretto", "s5cFlgDimensNonControll",
				"s5cFlgDimensRelazSucces", "dataUltMod", "utenteUltMod", "s1cDataRee", "s5cFlgDimensNonCorretto"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTRappIspezGt] fa riferimento
	 * (SIGIT_T_RAPP_ISPEZ_GT).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_RAPP_ISPEZ_GT";
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
