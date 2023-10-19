package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTDocAggiuntivaMetadata extends DAOMetadata {

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
	 * DAO: [sigitTDocAggiuntiva]
	 * tabella: [SIGIT_T_DOC_AGGIUNTIVA].
	 */
	public SigitTDocAggiuntivaMetadata() {
		columnNames = new String[]{"ID_DOC_AGGIUNTIVA", "CODICE_IMPIANTO", "FK_TIPO_DOCAGG", "NOME_DOC_ORIGINALE",
				"NOME_DOC", "UID_INDEX", "DES_ALTRO_TIPODOC", "DATA_ULT_MOD", "UTENTE_ULT_MOD", "DATA_UPLOAD",
				"DATA_DELETE"};
		propertyNames = new String[]{"idDocAggiuntiva", "codiceImpianto", "fkTipoDocagg", "nomeDocOriginale", "nomeDoc",
				"uidIndex", "desAltroTipodoc", "dataUltMod", "utenteUltMod", "dataUpload", "dataDelete"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTDocAggiuntiva] fa riferimento
	 * (SIGIT_T_DOC_AGGIUNTIVA).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DOC_AGGIUNTIVA";
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
