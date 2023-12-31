package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTDettTipo3Metadata extends DAOMetadata {

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
	 * DAO: [sigitTDettTipo3]
	 * tabella: [SIGIT_T_DETT_TIPO3].
	 */
	public SigitTDettTipo3Metadata() {
		columnNames = new String[]{"ID_DETT_TIPO3", "FK_ALLEGATO", "CODICE_IMPIANTO", "FK_TIPO_COMPONENTE",
				"PROGRESSIVO", "DATA_INSTALL", "FK_FLUIDO", "FK_FLUIDO_ALIMENTAZ", "E_FLUIDO_ALTRO",
				"E_ALIMENTAZIONE_ALTRO", "E_FLG_CLIMA_INVERNO", "E_FLG_PRODUZ_ACS", "E_FLG_POTENZA_COMPATIBILE",
				"E_FLG_COIB_IDONEA", "E_FLG_DISP_FUNZIONANTI", "E_TEMP_EXT_C", "E_TEMP_MAND_PRIMARIO_C",
				"E_TEMP_RITOR_PRIMARIO_C", "E_TEMP_MAND_SECONDARIO_C", "E_TEMP_RIT_SECONDARIO_C", "E_POTENZA_TERM_KW",
				"E_PORT_FLUIDO_M3_H", "DATA_ULT_MOD", "UTENTE_ULT_MOD", "E_CONTROLLOWEB"};
		propertyNames = new String[]{"idDettTipo3", "fkAllegato", "codiceImpianto", "fkTipoComponente", "progressivo",
				"dataInstall", "fkFluido", "fkFluidoAlimentaz", "eFluidoAltro", "eAlimentazioneAltro",
				"eFlgClimaInverno", "eFlgProduzAcs", "eFlgPotenzaCompatibile", "eFlgCoibIdonea", "eFlgDispFunzionanti",
				"eTempExtC", "eTempMandPrimarioC", "eTempRitorPrimarioC", "eTempMandSecondarioC", "eTempRitSecondarioC",
				"ePotenzaTermKw", "ePortFluidoM3H", "dataUltMod", "utenteUltMod", "eControlloweb"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTDettTipo3] fa riferimento
	 * (SIGIT_T_DETT_TIPO3).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DETT_TIPO3";
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
