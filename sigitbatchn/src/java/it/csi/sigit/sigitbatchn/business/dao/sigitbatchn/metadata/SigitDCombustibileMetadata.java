package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitDCombustibileMetadata extends DAOMetadata {

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
	 * DAO: [sigitDCombustibile]
	 * tabella: [SIGIT_D_COMBUSTIBILE].
	 */
	public SigitDCombustibileMetadata() {
		columnNames = new String[]{"ID_COMBUSTIBILE", "DES_COMBUSTIBILE"};
		propertyNames = new String[]{"idCombustibile", "desCombustibile"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitDCombustibile] fa riferimento
	 * (SIGIT_D_COMBUSTIBILE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_COMBUSTIBILE";
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
