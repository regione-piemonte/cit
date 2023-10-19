package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitRPgPgNominaMetadata extends DAOMetadata {

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
	 * DAO: [sigitRPgPgNomina]
	 * tabella: [SIGIT_R_PG_PG_NOMINA].
	 */
	public SigitRPgPgNominaMetadata() {
		columnNames = new String[]{"ID_PERSONA_GIURIDICA_CAT", "ID_PERSONA_GIURIDICA_IMPRESA", "DATA_INIZIO",
				"DATA_FINE", "DATA_ULTIMA_MODIFICA", "UTENTE_ULTIMA_MODIFICA"};
		propertyNames = new String[]{"idPersonaGiuridicaCat", "idPersonaGiuridicaImpresa", "dataInizio", "dataFine",
				"dataUltimaModifica", "utenteUltimaModifica"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitRPgPgNomina] fa riferimento
	 * (SIGIT_R_PG_PG_NOMINA).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_PG_PG_NOMINA";
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
