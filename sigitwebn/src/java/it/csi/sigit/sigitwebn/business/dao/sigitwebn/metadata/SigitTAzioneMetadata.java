package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTAzioneMetadata extends DAOMetadata {

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
	 * DAO: [sigitTAzione]
	 * tabella: [SIGIT_T_AZIONE].
	 */
	public SigitTAzioneMetadata() {
		columnNames = new String[]{"ID_AZIONE", "DT_AZIONE", "FK_TIPO_AZIONE", "FK_VERIFICA", "FK_ACCERTAMENTO",
				"FK_ISPEZIONE_2018", "FK_SANZIONE", "DESCRIZIONE_AZIONE", "CF_UTENTE_AZIONE", "DENOM_UTENTE_AZIONE"};
		propertyNames = new String[]{"idAzione", "dtAzione", "fkTipoAzione", "fkVerifica", "fkAccertamento",
				"fkIspezione2018", "fkSanzione", "descrizioneAzione", "cfUtenteAzione", "denomUtenteAzione"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTAzione] fa riferimento
	 * (SIGIT_T_AZIONE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_AZIONE";
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
