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
public class SigitVCompCsDettMetadata extends DAOMetadata {

	private final String[] propertyNames;
	private final String[] columnNames;

	public SigitVCompCsDettMetadata() {
		columnNames = new String[]{"CODICE_IMPIANTO", "ID_TIPO_COMPONENTE",
				"DATA_INSTALL", "PROGRESSIVO", "DATA_DISMISS", "MATRICOLA",
				"FK_COMBUSTIBILE", "FK_MARCA", "MODELLO", "POTENZA_TERMICA_KW",
				"ID_DETT_TIPO_3", "FK_ALLEGATO", "FK_FLUIDO",
				"FK_FLUIDO_ALIMENTAZ", "E_FLUIDO_ALTRO",
				"E_ALIMENTAZIONE_ALTRO", "E_FLG_CLIMA_INVERNO",
				"E_FLG_PRODUZ_ACS", "E_FLG_POTENZA_COMPATIBILE",
				"E_FLG_COIB_IDONEA", "E_FLG_DISP_FUNZIONANTI", "E_TEMP_EXT_C",
				"E_TEMP_MAND_PRIMARIO_C", "E_TEMP_RITOR_PRIMARIO_C",
				"E_TEMP_MAND_SECONDARIO_C", "E_TEMP_RIT_SECONDARIO_C",
				"E_POTENZA_TERM_KW", "E_PORT_FLUIDO_M3_H"};
		propertyNames = new String[]{"codiceImpianto", "idTipoComponente",
				"dataInstall", "progressivo", "dataDismiss", "matricola",
				"fkCombustibile", "fkMarca", "modello", "potenzaTermicaKw",
				"idDettTipo3", "fkAllegato", "fkFluido", "fkFluidoAlimentaz",
				"eFluidoAltro", "eAlimentazioneAltro", "eFlgClimaInverno",
				"eFlgProduzAcs", "eFlgPotenzaCompatibile", "eFlgCoibIdonea",
				"eFlgDispFunzionanti", "eTempExtC", "eTempMandPrimarioC",
				"eTempRitorPrimarioC", "eTempMandSecondarioC",
				"eTempRitSecondarioC", "ePotenzaTermKw", "ePortFluidoM3H"};
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
		return "VISTA_COMP_SC_DETT";
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
