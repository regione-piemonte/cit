package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitRPfRuoloPaMetadata extends DAOMetadata {

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
	 * DAO: [sigitRPfRuoloPa]
	 * tabella: [SIGIT_R_PF_RUOLO_PA].
	 */
	public SigitRPfRuoloPaMetadata() {
		columnNames = new String[]{"ID_PERSONA_FISICA", "ID_RUOLO_PA", "ISTAT_ABILITAZIONE", "DATA_INIZIO", "DATA_FINE",
				"NOTE", "DESC_ABILITAZIONE"};
		propertyNames = new String[]{"idPersonaFisica", "idRuoloPa", "istatAbilitazione", "dataInizio", "dataFine",
				"note", "descAbilitazione"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitRPfRuoloPa] fa riferimento
	 * (SIGIT_R_PF_RUOLO_PA).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_PF_RUOLO_PA";
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
