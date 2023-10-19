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
public class SigitTAllRespTxtMetadata extends DAOMetadata {

	private final String[] propertyNames;
	private final String[] columnNames;

	public SigitTAllRespTxtMetadata() {
		columnNames = new String[]{"DATA_CONTROLLO", "ID_IMP_RUOLO_PFPG",
				"ID_ALLEGATO", "XML_ALLEGATO"};
		propertyNames = new String[]{"dataControllo", "idImpRuoloPfpg",
				"idAllegato", "xmlAllegato"};
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
		return "SIGIT_T_ALLRESP_TXT";
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
