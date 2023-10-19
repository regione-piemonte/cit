package it.csi.sigit.sigitweba.business.dao.sigitweba.metadata;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitWrkConfigMetadata extends DAOMetadata {

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
	 * DAO: [sigitWrkConfig]
	 * tabella: [SIGIT_WRK_CONFIG].
	 */
	public SigitWrkConfigMetadata() {
		columnNames = new String[]{"ID_CONFIG", "CHIAVE_CONFIG", "VALORE_CONFIG_NUM", "VALORE_CONFIG_CHAR",
				"VALORE_FLAG"};
		propertyNames = new String[]{"idConfig", "chiaveConfig", "valoreConfigNum", "valoreConfigChar", "valoreFlag"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitWrkConfig] fa riferimento
	 * (SIGIT_WRK_CONFIG).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_WRK_CONFIG";
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
