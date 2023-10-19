package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTRappControlloMetadata extends DAOMetadata {

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
	 * DAO: [sigitTRappControllo]
	 * tabella: [SIGIT_T_RAPP_CONTROLLO].
	 */
	public SigitTRappControlloMetadata() {
		columnNames = new String[]{"ID_RAPPORTO_CONTROLLO", "FK_ALLEGATO", "NOTE_UFFICIO", "FLG_LOCALE_OK",
				"FLG_AERAZIONE_OK", "FLG_AERAZIONE_LIBERA", "FLG_ASSENZA_FUGHE_GAS", "FLG_EVACUAZIONE_FUMI",
				"FLG_RAPPORTO_CONTROLLO", "FLG_CERTIFICAZIONE", "FLG_PRATICA_ISPESL", "FLG_CERT_PREV_INCENDI",
				"FLG_CENTRALETERMICA"};
		propertyNames = new String[]{"idRapportoControllo", "fkAllegato", "noteUfficio", "flgLocaleOk",
				"flgAerazioneOk", "flgAerazioneLibera", "flgAssenzaFugheGas", "flgEvacuazioneFumi",
				"flgRapportoControllo", "flgCertificazione", "flgPraticaIspesl", "flgCertPrevIncendi",
				"flgCentraletermica"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTRappControllo] fa riferimento
	 * (SIGIT_T_RAPP_CONTROLLO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_RAPP_CONTROLLO";
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
