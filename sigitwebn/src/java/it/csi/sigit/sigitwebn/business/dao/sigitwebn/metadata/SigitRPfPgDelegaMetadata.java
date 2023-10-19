package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitRPfPgDelegaMetadata extends DAOMetadata {

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
	 * DAO: [sigitRPfPgDelega]
	 * tabella: [SIGIT_R_PF_PG_DELEGA].
	 */
	public SigitRPfPgDelegaMetadata() {
		columnNames = new String[]{"ID_PERSONA_FISICA", "ID_PERSONA_GIURIDICA", "DATA_INIZIO", "FK_RUOLO_ACCRED",
				"FK_TIPO_DM", "FLG_DELEGA", "DATA_FINE", "DATA_ULT_MOD", "UTENTE_ULT_MOD"};
		propertyNames = new String[]{"idPersonaFisica", "idPersonaGiuridica", "dataInizio", "fkRuoloAccred", "fkTipoDm",
				"flgDelega", "dataFine", "dataUltMod", "utenteUltMod"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitRPfPgDelega] fa riferimento
	 * (SIGIT_R_PF_PG_DELEGA).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_PF_PG_DELEGA";
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
