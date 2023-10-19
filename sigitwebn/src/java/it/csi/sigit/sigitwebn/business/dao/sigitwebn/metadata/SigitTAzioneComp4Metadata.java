package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTAzioneComp4Metadata extends DAOMetadata {

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
	 * DAO: [sigitTAzioneComp4]
	 * tabella: [SIGIT_T_AZIONE_COMP4].
	 */
	public SigitTAzioneComp4Metadata() {
		columnNames = new String[]{"CODICE_IMPIANTO", "ID_TIPO_COMPONENTE", "PROGRESSIVO", "DT_INSTALL", "DT_AZIONE",
				"CF_UTENTE_AZIONE", "DESCRIZIONE_AZIONE"};
		propertyNames = new String[]{"codiceImpianto", "idTipoComponente", "progressivo", "dtInstall", "dtAzione",
				"cfUtenteAzione", "descrizioneAzione"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTAzioneComp4] fa riferimento
	 * (SIGIT_T_AZIONE_COMP4).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_AZIONE_COMP4";
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
