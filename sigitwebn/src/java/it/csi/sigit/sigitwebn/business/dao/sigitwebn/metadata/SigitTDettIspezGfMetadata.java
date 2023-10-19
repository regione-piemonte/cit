package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTDettIspezGfMetadata extends DAOMetadata {

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
	 * DAO: [sigitTDettIspezGf]
	 * tabella: [SIGIT_T_DETT_ISPEZ_GF].
	 */
	public SigitTDettIspezGfMetadata() {
		columnNames = new String[]{"ID_DETT_ISPEZ_GF", "FK_ALLEGATO", "FK_TIPO_COMPONENTE", "PROGRESSIVO",
				"CODICE_IMPIANTO", "DATA_INSTALL", "S6H_FLG_INVERTER", "S6N_FLG_FUGA_DIRETTA", "S6N_FLG_FUGA_INDIRETTA",
				"S7A_FK_FREQUENZA_MANUT", "S7A_FLG_MANUT_EFFETTUATA", "S7A_DATA_ULTIMA_MANUT",
				"S7B_FLG_REGISTRO_APPARECC", "S7C_FLG_REE_PRESENTE", "S7C_DATA_REE", "S7C_FLG_OSSERVAZIONI",
				"S7C_FLG_RACCOMAND", "S7C_FLG_PRESCR", "S8B_FLG_PROVE_RISCALDAMENTO", "S8B_FLG_PROVE_RAFFRESCAMENTO",
				"S8C_FLG_FILTRI_PULITI", "S8D_FLG_ASSENZA_PERDITE_GAS", "S8E_MARCA_STRUM_MISURA",
				"S8E_MODELLO_STRUM_MISURA", "S8E_MATRICOLA_STRUM_MISURA", "S8F_POT_ASSORBITA_KW",
				"S8G_FLG_STRUMENTAZIONE_FISSA", "S8H_OPERATORE_DENOMINAZIONE", "S8I_OPERATORE_NUM_ISCRIZ",
				"S8J_SURRISCALDAMENTO_K", "S8J_SOTTORAFFREDDAMENTO_K", "S8J_TEMP_CONDENSAZIONE_C",
				"S8J_TEMP_EVAPORAZIONE_C", "S8J_TEMP_SORG_INGRESSO_C", "S8J_TEMP_SORG_USCITA_C",
				"S8J_TEMP_INGRESSO_FLUIDO_C", "S8J_TEMP_USCITA_FLUIDO_C", "S9A_FLG_VERIFICA_SUPERATA",
				"S9B_FLG_RISPETTO_NORMATIVA", "S9C_FLG_NO_RISPETTO_7A", "S9C_FLG_NO_RISPETTO_7B",
				"S9C_FLG_NO_RISPETTO_8D", "S9C_FLG_NO_RISPETTO_9A", "S7A_FREQUENZA_MANUT_ALTRO", "S8A_N_CIRCUITO",
				"DATA_ULT_MOD", "UTENTE_ULT_MOD", "CONTROLLOWEB"};
		propertyNames = new String[]{"idDettIspezGf", "fkAllegato", "fkTipoComponente", "progressivo", "codiceImpianto",
				"dataInstall", "s6hFlgInverter", "s6nFlgFugaDiretta", "s6nFlgFugaIndiretta", "s7aFkFrequenzaManut",
				"s7aFlgManutEffettuata", "s7aDataUltimaManut", "s7bFlgRegistroApparecc", "s7cFlgReePresente",
				"s7cDataRee", "s7cFlgOsservazioni", "s7cFlgRaccomand", "s7cFlgPrescr", "s8bFlgProveRiscaldamento",
				"s8bFlgProveRaffrescamento", "s8cFlgFiltriPuliti", "s8dFlgAssenzaPerditeGas", "s8eMarcaStrumMisura",
				"s8eModelloStrumMisura", "s8eMatricolaStrumMisura", "s8fPotAssorbitaKw", "s8gFlgStrumentazioneFissa",
				"s8hOperatoreDenominazione", "s8iOperatoreNumIscriz", "s8jSurriscaldamentoK", "s8jSottoraffreddamentoK",
				"s8jTempCondensazioneC", "s8jTempEvaporazioneC", "s8jTempSorgIngressoC", "s8jTempSorgUscitaC",
				"s8jTempIngressoFluidoC", "s8jTempUscitaFluidoC", "s9aFlgVerificaSuperata", "s9bFlgRispettoNormativa",
				"s9cFlgNoRispetto7a", "s9cFlgNoRispetto7b", "s9cFlgNoRispetto8d", "s9cFlgNoRispetto9a",
				"s7aFrequenzaManutAltro", "s8aNCircuito", "dataUltMod", "utenteUltMod", "controlloweb"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTDettIspezGf] fa riferimento
	 * (SIGIT_T_DETT_ISPEZ_GF).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DETT_ISPEZ_GF";
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
