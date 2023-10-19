package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTDocContrattoMetadata extends DAOMetadata {

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
	 * DAO: [sigitTDocContratto]
	 * tabella: [SIGIT_T_DOC_CONTRATTO].
	 */
	public SigitTDocContrattoMetadata() {
		columnNames = new String[]{"ID_DOC_CONTRATTO", "FK_CONTRATTO", "NOME_DOC_ORIGINALE", "NOME_DOC", "DESCRIZIONE",
				"DATA_UPLOAD", "DATA_DELETE", "UID_INDEX", "DATA_ULT_MOD", "UTENTE_ULT_MOD"};
		propertyNames = new String[]{"idDocContratto", "fkContratto", "nomeDocOriginale", "nomeDoc", "descrizione",
				"dataUpload", "dataDelete", "uidIndex", "dataUltMod", "utenteUltMod"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTDocContratto] fa riferimento
	 * (SIGIT_T_DOC_CONTRATTO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DOC_CONTRATTO";
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
