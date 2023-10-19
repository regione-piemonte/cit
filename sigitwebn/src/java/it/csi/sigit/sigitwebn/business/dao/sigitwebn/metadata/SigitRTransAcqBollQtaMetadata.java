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
public class SigitRTransAcqBollQtaMetadata extends DAOMetadata {

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
	 * DAO: [sigitRTransAcqBollQta]
	 * tabella: [SIGIT_R_TRANS_ACQ_BOLL_QTA].
	 */
	public SigitRTransAcqBollQtaMetadata() {
		columnNames = new String[]{"ID_TRANSAZIONE_BOLL", "ID_POTENZA", "ID_PREZZO", "DT_INIZIO_ACQUISTO", "QUANTITA",
				"DATA_ULT_MOD", "UTENTE_ULT_MOD"};
		propertyNames = new String[]{"idTransazioneBoll", "idPotenza", "idPrezzo", "dtInizioAcquisto", "quantita",
				"dataUltMod", "utenteUltMod"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitRTransAcqBollQta] fa riferimento
	 * (SIGIT_R_TRANS_ACQ_BOLL_QTA).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_TRANS_ACQ_BOLL_QTA";
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
