package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitWrkLogMemoTuMetadata extends DAOMetadata {

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
	 * DAO: [sigitWrkLogMemoTu]
	 * tabella: [SIGIT_WRK_LOG_MEMO_PTU].
	 */
	public SigitWrkLogMemoTuMetadata() {
		columnNames = new String[]{"ID_LOG_MEMO_PTU", "DT_LOG_MEMO_PTU", "NOTE_LOG_MEMO_PTU", "MESSAGGIO_LOG_MEMO_PTU",
				"ESITO_LOG_MEMO_PTU"};
		propertyNames = new String[]{"idLogMemoPtu", "dtLogMemoPtu", "noteLogMemoPtu", "messaggioLogMemoPtu",
				"esitoLogMemoPtu"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitWrkLogMemoTu] fa riferimento
	 * (SIGIT_WRK_LOG_MEMO_PTU).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_WRK_LOG_MEMO_PTU";
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
