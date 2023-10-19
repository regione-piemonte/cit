package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitVAllegatiComponentiMetadata extends DAOMetadata {

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
	 * DAO: [sigitVAllegatiComponenti]
	 * tabella: [VISTA_ALLEGATI_COMPONENTI].
	 */
	public SigitVAllegatiComponentiMetadata() {
		columnNames = new String[]{"ID_ALLEGATO", "ID_TIPO_COMPONENTE", "PROGRESSIVO", "CODICE_IMPIANTO",
				"DATA_INSTALL", "FK_IMP_RUOLO_PFPG", "FK_CONTRATTO", "FK_STATO_RAPP", "DES_STATO_RAPP",
				"DATA_CONTROLLO"};
		propertyNames = new String[]{"idAllegato", "idTipoComponente", "progressivo", "codiceImpianto", "dataInstall",
				"fkImpRuoloPfpg", "fkContratto", "fkStatoRapp", "desStatoRapp", "dataControllo"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitVAllegatiComponenti] fa riferimento
	 * (VISTA_ALLEGATI_COMPONENTI).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_ALLEGATI_COMPONENTI";
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
