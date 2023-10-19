package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitVPfPgMetadata extends DAOMetadata {

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
	 * DAO: [sigitVPfPg]
	 * tabella: [VISTA_PF_PG].
	 */
	public SigitVPfPgMetadata() {
		columnNames = new String[]{"ID_PERSONA", "PF_PG", "NOME", "DENOMINAZIONE", "SIGLA_REA", "NUMERO_REA",
				"CODICE_FISCALE", "FK_L2", "INDIRIZZO_SITAD", "INDIRIZZO_NON_TROVATO", "SIGLA_PROV", "ISTAT_COMUNE",
				"COMUNE", "PROVINCIA", "CIVICO", "CAP", "EMAIL", "DATA_INIZIO_ATTIVITA", "DATA_CESSAZIONE",
				"FLG_INDIRIZZO_ESTERO", "STATO_ESTERO", "CITTA_ESTERO", "INDIRIZZO_ESTERO", "CAP_ESTERO"};
		propertyNames = new String[]{"idPersona", "pfPg", "nome", "denominazione", "siglaRea", "numeroRea",
				"codiceFiscale", "fkL2", "indirizzoSitad", "indirizzoNonTrovato", "siglaProv", "istatComune", "comune",
				"provincia", "civico", "cap", "email", "dataInizioAttivita", "dataCessazione", "flgIndirizzoEstero",
				"statoEstero", "cittaEstero", "indirizzoEstero", "capEstero"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitVPfPg] fa riferimento
	 * (VISTA_PF_PG).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_PF_PG";
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
