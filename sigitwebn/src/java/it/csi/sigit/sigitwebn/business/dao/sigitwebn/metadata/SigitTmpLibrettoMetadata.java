package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTmpLibrettoMetadata extends DAOMetadata {

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
	 * DAO: [sigitTmpLibretto]
	 * tabella: [SIGIT_TMP_LIBRETTO].
	 */
	public SigitTmpLibrettoMetadata() {
		columnNames = new String[]{"ID_LIBRETTO", "FLG_ELABORATO", "FLG_ESITO_ELAB", "DATA_ELAB"};
		propertyNames = new String[]{"idLibretto", "flgElaborato", "flgEsitoElab", "dataElab"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTmpLibretto] fa riferimento
	 * (SIGIT_TMP_LIBRETTO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_TMP_LIBRETTO";
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
