package it.csi.sigit.sigitweba.business.dao.sigitweba.metadata;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTFormazioneMetadata extends DAOMetadata {

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
	 * DAO: [sigitTFormazione]
	 * tabella: [SIGIT_T_FORMAZIONE].
	 */
	public SigitTFormazioneMetadata() {
		columnNames = new String[]{"DATA_CORSO", "ID_PERSONA_FISICA", "DES_CORSO"};
		propertyNames = new String[]{"dataCorso", "idPersonaFisica", "desCorso"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTFormazione] fa riferimento
	 * (SIGIT_T_FORMAZIONE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_FORMAZIONE";
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
