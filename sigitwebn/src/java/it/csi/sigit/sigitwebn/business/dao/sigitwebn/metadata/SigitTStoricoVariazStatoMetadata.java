package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTStoricoVariazStatoMetadata extends DAOMetadata {

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
	 * DAO: [sigitTStoricoVariazStato]
	 * tabella: [SIGIT_T_STORICO_VARIAZ_STATO].
	 */
	public SigitTStoricoVariazStatoMetadata() {
		columnNames = new String[]{"CODICE_IMPIANTO", "DT_EVENTO", "DT_INIZIO_VARIAZIONE", "MOTIVO", "STATO_DA",
				"STATO_A", "DATA_ULT_MOD", "UTENTE_ULT_MOD"};
		propertyNames = new String[]{"codiceImpianto", "dtEvento", "dtInizioVariazione", "motivo", "statoDa", "statoA",
				"dataUltMod", "utenteUltMod"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTStoricoVariazStato] fa riferimento
	 * (SIGIT_T_STORICO_VARIAZ_STATO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_STORICO_VARIAZ_STATO";
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
