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
public class SigitTTransazioneBollMetadata extends DAOMetadata {

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
	 * DAO: [sigitTTransazioneBoll]
	 * tabella: [SIGIT_T_TRANSAZIONE_BOLL].
	 */
	public SigitTTransazioneBollMetadata() {
		columnNames = new String[]{"ID_TRANSAZIONE_BOLL", "ID_STATO_TRANSAZIONE", "FK_TIPO_PAGAMENTO", "CF_UTENTE",
				"DATA_TRANSAZIONE", "SIGLA_BOLLINO", "BOLLINO_DA", "BOLLINO_A", "FK_PERSONA_GIURIDICA", "DATA_ULT_MOD",
				"UTENTE_ULT_MOD", "NUM_TRANSAZIONE", "NOTE"};
		propertyNames = new String[]{"idTransazioneBoll", "idStatoTransazione", "fkTipoPagamento", "cfUtente",
				"dataTransazione", "siglaBollino", "bollinoDa", "bollinoA", "fkPersonaGiuridica", "dataUltMod",
				"utenteUltMod", "numTransazione", "note"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTTransazioneBoll] fa riferimento
	 * (SIGIT_T_TRANSAZIONE_BOLL).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_TRANSAZIONE_BOLL";
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
