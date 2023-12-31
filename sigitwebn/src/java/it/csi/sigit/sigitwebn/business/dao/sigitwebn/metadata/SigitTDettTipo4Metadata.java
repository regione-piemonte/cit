package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTDettTipo4Metadata extends DAOMetadata {

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
	 * DAO: [sigitTDettTipo4]
	 * tabella: [SIGIT_T_DETT_TIPO4].
	 */
	public SigitTDettTipo4Metadata() {
		columnNames = new String[]{"ID_DETT_TIPO4", "FK_ALLEGATO", "CODICE_IMPIANTO", "FK_TIPO_COMPONENTE",
				"PROGRESSIVO", "DATA_INSTALL", "FK_FLUIDO", "E_POTENZA_ASSORB_COMB_KW", "E_POTENZA_TERM_BYPASS_KW",
				"E_TEMP_ARIA_C", "E_TEMP_H2O_OUT_C", "E_TEMP_H2O_IN_C", "E_POTENZA_MORSETTI_KW", "E_TEMP_H2O_MOTORE_C",
				"E_TEMP_FUMI_VALLE_C", "E_TEMP_FUMI_MONTE_C", "DATA_ULT_MOD", "UTENTE_ULT_MOD",
				"L11_4_SOVRAFREQ_SOGLIA_HZ_MIN", "L11_4_SOVRAFREQ_SOGLIA_HZ_MED", "L11_4_SOVRAFREQ_SOGLIA_HZ_MAX",
				"L11_4_SOVRAFREQ_TEMPO_S_MIN", "L11_4_SOVRAFREQ_TEMPO_S_MED", "L11_4_SOVRAFREQ_TEMPO_S_MAX",
				"L11_4_SOTTOFREQ_SOGLIA_HZ_MIN", "L11_4_SOTTOFREQ_SOGLIA_HZ_MED", "L11_4_SOTTOFREQ_SOGLIA_HZ_MAX",
				"L11_4_SOTTOFREQ_TEMPO_S_MIN", "L11_4_SOTTOFREQ_TEMPO_S_MED", "L11_4_SOTTOFREQ_TEMPO_S_MAX",
				"L11_4_SOVRATENS_SOGLIA_V_MIN", "L11_4_SOVRATENS_SOGLIA_V_MED", "L11_4_SOVRATENS_SOGLIA_V_MAX",
				"L11_4_SOVRATENS_TEMPO_S_MIN", "L11_4_SOVRATENS_TEMPO_S_MED", "L11_4_SOVRATENS_TEMPO_S_MAX",
				"L11_4_SOTTOTENS_SOGLIA_V_MIN", "L11_4_SOTTOTENS_SOGLIA_V_MED", "L11_4_SOTTOTENS_SOGLIA_V_MAX",
				"L11_4_SOTTOTENS_TEMPO_S_MIN", "L11_4_SOTTOTENS_TEMPO_S_MED", "L11_4_SOTTOTENS_TEMPO_S_MAX",
				"E_CONTROLLOWEB"};
		propertyNames = new String[]{"idDettTipo4", "fkAllegato", "codiceImpianto", "fkTipoComponente", "progressivo",
				"dataInstall", "fkFluido", "ePotenzaAssorbCombKw", "ePotenzaTermBypassKw", "eTempAriaC", "eTempH2oOutC",
				"eTempH2oInC", "ePotenzaMorsettiKw", "eTempH2oMotoreC", "eTempFumiValleC", "eTempFumiMonteC",
				"dataUltMod", "utenteUltMod", "l114SovrafreqSogliaHzMin", "l114SovrafreqSogliaHzMed",
				"l114SovrafreqSogliaHzMax", "l114SovrafreqTempoSMin", "l114SovrafreqTempoSMed",
				"l114SovrafreqTempoSMax", "l114SottofreqSogliaHzMin", "l114SottofreqSogliaHzMed",
				"l114SottofreqSogliaHzMax", "l114SottofreqTempoSMin", "l114SottofreqTempoSMed",
				"l114SottofreqTempoSMax", "l114SovratensSogliaVMin", "l114SovratensSogliaVMed",
				"l114SovratensSogliaVMax", "l114SovratensTempoSMin", "l114SovratensTempoSMed", "l114SovratensTempoSMax",
				"l114SottotensSogliaVMin", "l114SottotensSogliaVMed", "l114SottotensSogliaVMax",
				"l114SottotensTempoSMin", "l114SottotensTempoSMed", "l114SottotensTempoSMax", "eControlloweb"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTDettTipo4] fa riferimento
	 * (SIGIT_T_DETT_TIPO4).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DETT_TIPO4";
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
