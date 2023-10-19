package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTAzioneContrattoMetadata extends DAOMetadata {

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
	 * DAO: [sigitTAzioneContratto]
	 * tabella: [SIGIT_T_AZIONE_CONTRATTO].
	 */
	public SigitTAzioneContrattoMetadata() {
		columnNames = new String[]{"ID_CONTRATTO", "DT_AZIONE", "CF_UTENTE_AZIONE", "DESCRIZIONE_AZIONE",
				"OLD_DATA_FINE"};
		propertyNames = new String[]{"idContratto", "dtAzione", "cfUtenteAzione", "descrizioneAzione", "oldDataFine"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTAzioneContratto] fa riferimento
	 * (SIGIT_T_AZIONE_CONTRATTO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_AZIONE_CONTRATTO";
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
