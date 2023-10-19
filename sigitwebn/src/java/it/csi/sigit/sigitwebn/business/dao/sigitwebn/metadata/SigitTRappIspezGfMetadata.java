package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTRappIspezGfMetadata extends DAOMetadata {

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
	 * DAO: [sigitTRappIspezGf]
	 * tabella: [SIGIT_T_RAPP_ISPEZ_GF].
	 */
	public SigitTRappIspezGfMetadata() {
		columnNames = new String[]{"ID_ALLEGATO", "S1C_FLG_REE_INVIATO", "S1C_FLG_REE_BOLLINO", "S1C_SIGLA_BOLLINO",
				"S1C_NUM_BOLLINO", "S1E_DT_PRIMA_INSTALLAZIONE", "S1E_POT_TERMICA_MAX_KW", "S1L_DENOM_DELEGATO",
				"S1L_FLG_DELEGA", "S2E_FLG_TRATT_H2O_NON_RICH", "S3A_FLG_LOCALE_INT_IDONEO",
				"S3B_FLG_LINEE_ELETTR_IDONEE", "S3C_FLG_VENTILAZ_ADEGUATE", "S3D_FLG_COIBENTAZIONI_IDONEE",
				"S4A_FLG_LIB_IMP_PRESENTE", "S4B_FLG_LIB_COMPILATO", "S4C_FLG_CONFORMITA_PRESENTE",
				"S4D_FLG_LIB_USO_PRESENTE", "S5A_FLG_SOSTITUZ_MACCHINE_REG", "S5A_FLG_SOSTITUZ_SISTEMI_REG",
				"S5A_FLG_ISOLAM_RETE_DISTRIB", "S5A_FLG_ISOLAM_CANALI_DISTRIB", "S5B_FLG_NO_INTERV_CONV",
				"S5B_FLG_RELAZ_DETTAGLIO", "S5B_FLG_RELAZ_DETTAGLIO_SUCC", "S5B_FLG_VALUTAZ_NON_ESEGUITA",
				"S5B_MOTIVO_RELAZ_NON_ESEG", "S5C_FLG_DIMENS_CORRETTO", "S5C_FLG_DIMENS_NON_CONTROLL",
				"S5C_FLG_DIMENS_RELAZ_SUCCES", "DATA_ULT_MOD", "UTENTE_ULT_MOD", "S1C_DATA_REE",
				"S5C_FLG_DIMENS_NON_CORRETTO"};
		propertyNames = new String[]{"idAllegato", "s1cFlgReeInviato", "s1cFlgReeBollino", "s1cSiglaBollino",
				"s1cNumBollino", "s1eDtPrimaInstallazione", "s1ePotTermicaMaxKw", "s1lDenomDelegato", "s1lFlgDelega",
				"s2eFlgTrattH2oNonRich", "s3aFlgLocaleIntIdoneo", "s3bFlgLineeElettrIdonee", "s3cFlgVentilazAdeguate",
				"s3dFlgCoibentazioniIdonee", "s4aFlgLibImpPresente", "s4bFlgLibCompilato", "s4cFlgConformitaPresente",
				"s4dFlgLibUsoPresente", "s5aFlgSostituzMacchineReg", "s5aFlgSostituzSistemiReg",
				"s5aFlgIsolamReteDistrib", "s5aFlgIsolamCanaliDistrib", "s5bFlgNoIntervConv", "s5bFlgRelazDettaglio",
				"s5bFlgRelazDettaglioSucc", "s5bFlgValutazNonEseguita", "s5bMotivoRelazNonEseg", "s5cFlgDimensCorretto",
				"s5cFlgDimensNonControll", "s5cFlgDimensRelazSucces", "dataUltMod", "utenteUltMod", "s1cDataRee",
				"s5cFlgDimensNonCorretto"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTRappIspezGf] fa riferimento
	 * (SIGIT_T_RAPP_ISPEZ_GF).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_RAPP_ISPEZ_GF";
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
