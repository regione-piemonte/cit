package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitDTipoDocAggMetadata extends DAOMetadata {

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
	 * DAO: [sigitDTipoDocAgg]
	 * tabella: [SIGIT_D_TIPO_DOC_AGG].
	 */
	public SigitDTipoDocAggMetadata() {
		columnNames = new String[]{"ID_TIPO_DOC_AGG", "FK_RAGG_DOC_AGG", "DES_TIPO_DOC_AGG"};
		propertyNames = new String[]{"idTipoDocAgg", "fkRaggDocAgg", "desTipoDocAgg"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitDTipoDocAgg] fa riferimento
	 * (SIGIT_D_TIPO_DOC_AGG).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_TIPO_DOC_AGG";
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
