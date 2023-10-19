package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitVRicercaCompMetadata extends DAOMetadata {

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
	 * DAO: [sigitVRicercaComp]
	 * tabella: [VISTA_RICERCA_COMP].
	 */
	public SigitVRicercaCompMetadata() {
		columnNames = new String[]{"CODICE_IMPIANTO", "ID_TIPO_COMPONENTE", "PROGRESSIVO", "FK_MARCA",
				"FK_COMBUSTIBILE", "MODELLO", "POTENZA_TERMICA_KW", "DATA_INSTALL", "MATRICOLA", "DATA_DISMISS",
				"FLG_DISMISSIONE", "RENDIMENTO_PERC"};
		propertyNames = new String[]{"codiceImpianto", "idTipoComponente", "progressivo", "fkMarca", "fkCombustibile",
				"modello", "potenzaTermicaKw", "dataInstall", "matricola", "dataDismiss", "flgDismissione",
				"rendimentoPerc"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitVRicercaComp] fa riferimento
	 * (VISTA_RICERCA_COMP).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_RICERCA_COMP";
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
