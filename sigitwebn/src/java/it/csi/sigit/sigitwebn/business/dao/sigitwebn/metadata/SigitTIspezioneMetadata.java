/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTIspezioneMetadata extends DAOMetadata {

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
	 * DAO: [sigitTIspezione]
	 * tabella: [SIGIT_T_ISPEZIONE].
	 */
	public SigitTIspezioneMetadata() {
		columnNames = new String[]{"ID_IMP_RUOLO_PFPG", "FK_STATO_ISPEZIONE", "ENTE_COMPETENTE", "DATA_ISPEZIONE",
				"FLG_ESITO", "DATA_ULT_MOD", "UTENTE_ULT_MOD", "NOTE"};
		propertyNames = new String[]{"idImpRuoloPfpg", "fkStatoIspezione", "enteCompetente", "dataIspezione",
				"flgEsito", "dataUltMod", "utenteUltMod", "note"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTIspezione] fa riferimento
	 * (SIGIT_T_ISPEZIONE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ISPEZIONE";
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
