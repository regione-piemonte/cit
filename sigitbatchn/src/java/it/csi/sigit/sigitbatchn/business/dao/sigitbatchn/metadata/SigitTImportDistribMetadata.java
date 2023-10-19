package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTImportDistribMetadata extends DAOMetadata {

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
	 * DAO: [sigitTImportDistrib]
	 * tabella: [SIGIT_T_IMPORT_DISTRIB].
	 */
	public SigitTImportDistribMetadata() {
		columnNames = new String[]{"ID_IMPORT_DISTRIB", "FK_PERSONA_GIURIDICA", "FK_STATO_DISTRIB", "DATA_INIZIO_ELAB",
				"DATA_FINE_ELAB", "DATA_ANNULLAMENTO", "NOME_FILE_IMPORT", "UID_INDEX", "ANNO_RIFERIMENTO",
				"DATA_INVIO_MAIL_DISTRIB", "DATA_INVIO_MAIL_ASSISTENZA", "TOT_RECORD_ELABORATI", "TOT_RECORD_SCARTATI",
				"DATA_ULT_MOD", "UTENTE_ULT_MOD", "UTENTE_CARICAMENTO"};
		propertyNames = new String[]{"idImportDistrib", "fkPersonaGiuridica", "fkStatoDistrib", "dataInizioElab",
				"dataFineElab", "dataAnnullamento", "nomeFileImport", "uidIndex", "annoRiferimento",
				"dataInvioMailDistrib", "dataInvioMailAssistenza", "totRecordElaborati", "totRecordScartati",
				"dataUltMod", "utenteUltMod", "utenteCaricamento"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTImportDistrib] fa riferimento
	 * (SIGIT_T_IMPORT_DISTRIB).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_IMPORT_DISTRIB";
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
