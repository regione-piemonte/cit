package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitVCompCgMetadata extends DAOMetadata {

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
	 * DAO: [sigitVCompCg]
	 * tabella: [VISTA_COMP_CG].
	 */
	public SigitVCompCgMetadata() {
		columnNames = new String[]{"CODICE_IMPIANTO", "ID_TIPO_COMPONENTE", "PROGRESSIVO", "DATA_INSTALL", "TIPOLOGIA",
				"POTENZA_ELETTRICA_KW", "TEMP_H2O_OUT_MIN", "TEMP_H2O_OUT_MAX", "TEMP_H2O_IN_MIN", "TEMP_H2O_IN_MAX",
				"TEMP_H2O_MOTORE_MIN", "TEMP_H2O_MOTORE_MAX", "TEMP_FUMI_VALLE_MIN", "TEMP_FUMI_VALLE_MAX",
				"TEMP_FUMI_MONTE_MIN", "TEMP_FUMI_MONTE_MAX", "CO_MIN", "CO_MAX", "DATA_DISMISS", "FLG_DISMISSIONE",
				"DATA_ULT_MOD", "UTENTE_ULT_MOD", "FK_MARCA", "DES_MARCA", "ID_COMBUSTIBILE", "DES_COMBUSTIBILE",
				"MATRICOLA", "MODELLO", "POTENZA_TERMICA_KW", "NOTE", "TEMPO_MANUT_ANNI"};
		propertyNames = new String[]{"codiceImpianto", "idTipoComponente", "progressivo", "dataInstall", "tipologia",
				"potenzaElettricaKw", "tempH2oOutMin", "tempH2oOutMax", "tempH2oInMin", "tempH2oInMax",
				"tempH2oMotoreMin", "tempH2oMotoreMax", "tempFumiValleMin", "tempFumiValleMax", "tempFumiMonteMin",
				"tempFumiMonteMax", "coMin", "coMax", "dataDismiss", "flgDismissione", "dataUltMod", "utenteUltMod",
				"fkMarca", "desMarca", "idCombustibile", "desCombustibile", "matricola", "modello", "potenzaTermicaKw",
				"note", "tempoManutAnni"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitVCompCg] fa riferimento
	 * (VISTA_COMP_CG).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_COMP_CG";
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
