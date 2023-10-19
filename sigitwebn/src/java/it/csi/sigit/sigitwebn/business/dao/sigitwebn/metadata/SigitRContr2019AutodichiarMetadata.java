package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitRContr2019AutodichiarMetadata extends DAOMetadata {

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
	 * DAO: [sigitRContr2019Autodichiar]
	 * tabella: [SIGIT_R_CONTR2019_AUTODICHIAR].
	 */
	public SigitRContr2019AutodichiarMetadata() {
		columnNames = new String[]{"ID_CONTRATTO", "ID_AUTODICHIARAZIONE", "FLG_NOMINA_CESSA"};
		propertyNames = new String[]{"idContratto", "idAutodichiarazione", "flgNominaCessa"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitRContr2019Autodichiar] fa riferimento
	 * (SIGIT_R_CONTR2019_AUTODICHIAR).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_CONTR2019_AUTODICHIAR";
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
