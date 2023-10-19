package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTRifCatastMetadata extends DAOMetadata {

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
	 * DAO: [sigitTRifCatast]
	 * tabella: [SIGIT_T_RIF_CATAST].
	 */
	public SigitTRifCatastMetadata() {
		columnNames = new String[]{"ID_RIF_CATAST", "FK_DATO_DISTRIB", "SEZIONE", "FOGLIO", "PARTICELLA", "SUBALTERNO"};
		propertyNames = new String[]{"idRifCatast", "fkDatoDistrib", "sezione", "foglio", "particella", "subalterno"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTRifCatast] fa riferimento
	 * (SIGIT_T_RIF_CATAST).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_RIF_CATAST";
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
