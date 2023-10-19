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
public class SigitTCompBrBcMetadata extends DAOMetadata {

	private final String[] propertyNames;
	private final String[] columnNames;

	public SigitTCompBrBcMetadata() {
		columnNames = new String[]{"ID_COMP_BR_RC", "TIPOLOGIA_BR_RC",
				"PROGRESSIVO_BR_RC", "FK_TIPO_COMPONENTE", "FK_PROGRESSIVO",
				"FK_DATA_INSTALL", "TIPOLOGIA", "POT_TERM_MAX_KW",
				"POT_TERM_MIN_KW", "CODICE_IMPIANTO", "DATA_INSTALL",
				"DATA_DISMISS", "FK_MARCA", "MODELLO", "MATRICOLA",
				"FK_COMBUSTIBILE"};
		propertyNames = new String[]{"idCompBrRc", "tipologiaBrRc",
				"progressivoBrRc", "fkTipoComponente", "fkProgressivo",
				"fkDataInstall", "tipologia", "potTermMaxKw", "potTermMinKw",
				"codiceImpianto", "dataInstall", "dataDismiss", "fkMarca",
				"modello", "matricola", "fkCombustibile"};
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
		return "SIGIT_T_COMP_BR_RC";
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
