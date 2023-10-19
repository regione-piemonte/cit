package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitVPotenzaPrezzoMetadata extends DAOMetadata {

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
	 * DAO: [sigitVPotenzaPrezzo]
	 * tabella: [VISTA_POTENZA_PREZZO].
	 */
	public SigitVPotenzaPrezzoMetadata() {
		columnNames = new String[]{"ID_POTENZA", "DES_POTENZA", "LIMITE_INFERIORE", "LIMITE_SUPERIORE", "ID_PREZZO",
				"PREZZO", "DT_INIZIO", "DT_FINE"};
		propertyNames = new String[]{"idPotenza", "desPotenza", "limiteInferiore", "limiteSuperiore", "idPrezzo",
				"prezzo", "dtInizio", "dtFine"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitVPotenzaPrezzo] fa riferimento
	 * (VISTA_POTENZA_PREZZO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_POTENZA_PREZZO";
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
