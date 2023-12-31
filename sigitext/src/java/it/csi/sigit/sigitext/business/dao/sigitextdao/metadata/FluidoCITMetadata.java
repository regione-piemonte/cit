package it.csi.sigit.sigitext.business.dao.sigitextdao.metadata;

import it.csi.sigit.sigitext.business.dao.metadata.DAOMetadata;

/**
 * @generated
 */
public class FluidoCITMetadata extends DAOMetadata {

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
	 * DAO: [FluidoCIT]
	 * tabella: [SIGIT_D_FLUIDO].
	 */
	public FluidoCITMetadata() {
		columnNames = new String[]{"ID_FLUIDO", "DES_FLUIDO"};
		propertyNames = new String[]{"idFluido", "desFluido"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [FluidoCIT] fa riferimento
	 * (SIGIT_D_FLUIDO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_FLUIDO";
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
