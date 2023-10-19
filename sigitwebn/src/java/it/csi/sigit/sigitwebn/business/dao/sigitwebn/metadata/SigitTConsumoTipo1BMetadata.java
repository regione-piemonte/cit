package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTConsumoTipo1BMetadata extends DAOMetadata {

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
	 * DAO: [sigitTConsumoTipo1B]
	 * tabella: [SIGIT_T_CONSUMO_TIPO1B].
	 */
	public SigitTConsumoTipo1BMetadata() {
		columnNames = new String[]{"ID_CONSUMO_TIPO1B", "ESERCIZIO", "LETTURA_INIZIALE", "LETTURA_FINALE", "CONSUMO",
				"FK_ALLEGATO", "ID_TIPO_CONSUMO_1B", "ID_UNITA_MISURA"};
		propertyNames = new String[]{"idConsumoTipo1b", "esercizio", "letturaIniziale", "letturaFinale", "consumo",
				"fkAllegato", "idTipoConsumo1b", "idUnitaMisura"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTConsumoTipo1B] fa riferimento
	 * (SIGIT_T_CONSUMO_TIPO1B).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_CONSUMO_TIPO1B";
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
