package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitRIspezIspetMetadata extends DAOMetadata {

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
	 * DAO: [sigitRIspezIspet]
	 * tabella: [SIGIT_R_ISPEZ_ISPET].
	 */
	public SigitRIspezIspetMetadata() {
		columnNames = new String[]{"ID_ISPEZ_ISPET", "FK_RUOLO", "DATA_INIZIO", "DATA_FINE", "FK_PERSONA_FISICA",
				"FK_PERSONA_GIURIDICA", "DATA_ULT_MOD", "UTENTE_ULT_MOD", "FLG_PRIMO_CARICATORE", "ID_ISPEZIONE_2018"};
		propertyNames = new String[]{"idIspezIspet", "fkRuolo", "dataInizio", "dataFine", "fkPersonaFisica",
				"fkPersonaGiuridica", "dataUltMod", "utenteUltMod", "flgPrimoCaricatore", "idIspezione2018"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitRIspezIspet] fa riferimento
	 * (SIGIT_R_ISPEZ_ISPET).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_ISPEZ_ISPET";
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
