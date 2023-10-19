package it.csi.sigit.sigitweba.business.dao.sigitweba.metadata;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitDDmMetadata extends DAOMetadata {

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
	 * DAO: [sigitDDm]
	 * tabella: [SIGIT_D_DM37_2008].
	 */
	public SigitDDmMetadata() {
		columnNames = new String[]{"TIPO_DM37_2008", "DES_TIPO_DM37_2008"};
		propertyNames = new String[]{"tipoDm372008", "desTipoDm372008"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitDDm] fa riferimento
	 * (SIGIT_D_DM37_2008).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_DM37_2008";
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
