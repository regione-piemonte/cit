package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTContratto2019Metadata extends DAOMetadata {

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
	 * DAO: [sigitTContratto2019]
	 * tabella: [SIGIT_T_CONTRATTO_2019].
	 */
	public SigitTContratto2019Metadata() {
		columnNames = new String[]{"ID_CONTRATTO", "FK_PG_3_RESP", "FK_IMP_RUOLO_PFPG_RESP", "CODICE_IMPIANTO",
				"DATA_INIZIO", "DATA_FINE", "FLG_TACITO_RINNOVO", "DATA_CARICAMENTO", "DATA_ULT_MOD", "UTENTE_ULT_MOD",
				"DATA_CESSAZIONE", "DATA_INSERIMENTO_CESSAZIONE", "MOTIVO_CESSAZIONE", "FK_TIPO_CESSAZIONE", "NOTE"};
		propertyNames = new String[]{"idContratto", "fkPg3Resp", "fkImpRuoloPfpgResp", "codiceImpianto", "dataInizio",
				"dataFine", "flgTacitoRinnovo", "dataCaricamento", "dataUltMod", "utenteUltMod", "dataCessazione",
				"dataInserimentoCessazione", "motivoCessazione", "fkTipoCessazione", "note"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTContratto2019] fa riferimento
	 * (SIGIT_T_CONTRATTO_2019).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_CONTRATTO_2019";
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
