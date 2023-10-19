package it.csi.sigit.sigitweba.business.dao.sigitweba.metadata;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTStoricoVarStatoPgMetadata extends DAOMetadata {

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
	 * DAO: [sigitTStoricoVarStatoPg]
	 * tabella: [SIGIT_T_STORICO_VAR_STATO_PG].
	 */
	public SigitTStoricoVarStatoPgMetadata() {
		columnNames = new String[]{"DT_EVENTO", "ID_PERSONA_GIURIDICA", "DT_INIZIO_VARIAZIONE", "MOTIVO", "STATO_PG_DA",
				"STATO_PG_A", "DATA_ULT_MOD", "UTENTE_ULT_MOD"};
		propertyNames = new String[]{"dtEvento", "idPersonaGiuridica", "dtInizioVariazione", "motivo", "statoPgDa",
				"statoPgA", "dataUltMod", "utenteUltMod"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTStoricoVarStatoPg] fa riferimento
	 * (SIGIT_T_STORICO_VAR_STATO_PG).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_STORICO_VAR_STATO_PG";
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
