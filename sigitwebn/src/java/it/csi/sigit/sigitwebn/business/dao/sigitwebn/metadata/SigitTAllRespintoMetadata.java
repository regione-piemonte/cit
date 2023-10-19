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
public class SigitTAllRespintoMetadata extends DAOMetadata {

	private final String[] propertyNames;
	private final String[] columnNames;

	public SigitTAllRespintoMetadata() {
		columnNames = new String[]{"DATA_CONTROLLO", "ID_IMP_RUOLO_PFPG",
				"FK_TIPO_DOCUMENTO", "SIGLA_BOLLINO", "NUMERO_BOLLINO",
				"NOME_ALLEGATO", "DATA_ULT_MOD", "UTENTE_ULT_MOD",
				"DATA_RESPINTA", "DATA_INVIO", "F_OSSERVAZIONI",
				"F_RACCOMANDAZIONI", "F_PRESCRIZIONI", "F_INTERVENTO_ENTRO",
				"ID_ALLEGATO", "UID_INDEX"};
		propertyNames = new String[]{"dataControllo", "idImpRuoloPfpg",
				"fkTipoDocumento", "siglaBollino", "numeroBollino",
				"nomeAllegato", "dataUltMod", "utenteUltMod", "dataRespinta",
				"dataInvio", "fOsservazioni", "fRaccomandazioni",
				"fPrescrizioni", "fInterventoEntro", "idAllegato", "uidIndex"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ALL_RESPINTO";
	}

	/**
	 * Method 'getColumnNames'
	 * 
	 * @return String[]
	 * @generated
	 */
	public String[] getColumnNames() {
		return this.columnNames;
	}

}
