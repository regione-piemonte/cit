package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTDocAzioneMetadata extends DAOMetadata {

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
	 * DAO: [sigitTDocAzione]
	 * tabella: [SIGIT_T_DOC_AZIONE].
	 */
	public SigitTDocAzioneMetadata() {
		columnNames = new String[]{"ID_DOC_AZIONE", "FK_AZIONE", "NOME_DOC_ORIGINALE", "NOME_DOC", "UID_INDEX",
				"DATA_ULT_MOD", "UTENTE_ULT_MOD"};
		propertyNames = new String[]{"idDocAzione", "fkAzione", "nomeDocOriginale", "nomeDoc", "uidIndex", "dataUltMod",
				"utenteUltMod"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTDocAzione] fa riferimento
	 * (SIGIT_T_DOC_AZIONE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DOC_AZIONE";
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
