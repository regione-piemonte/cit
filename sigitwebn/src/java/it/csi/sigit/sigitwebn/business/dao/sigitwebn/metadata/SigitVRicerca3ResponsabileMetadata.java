package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitVRicerca3ResponsabileMetadata extends DAOMetadata {

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
	 * DAO: [sigitVRicerca3Responsabile]
	 * tabella: [VISTA_RICERCA_3_RESPONSABILE].
	 */
	public SigitVRicerca3ResponsabileMetadata() {
		columnNames = new String[]{"ID_CONTRATTO", "CODICE_IMPIANTO", "FK_RUOLO", "DES_RUOLO", "DATA_CARICAMENTO",
				"DATA_CESSAZIONE", "DATA_INSERIMENTO_CESSAZIONE", "FK_PG_3_RESP", "FK_IMP_RUOLO_PFPG_RESP",
				"DATA_INIZIO_CONTRATTO", "DATA_FINE_CONTRATTO", "FLG_TACITO_RINNOVO", "RESP_CODICE_FISCALE",
				"RESP_DENOMINAZIONE", "RESP_NOME", "TERZO_RESP_DENOMINAZIONE", "TERZO_RESP_SIGLA_REA",
				"TERZO_RESP_NUMERO_REA", "CODICE_FISCALE_3_RESP", "DENOM_COMUNE_3_RESP", "SIGLA_PROV_3_RESP",
				"DENOM_PROVINCIA_3_RESP", "DENOM_COMUNE_IMPIANTO", "DENOM_PROV_IMPIANTO", "SIGLA_PROV_IMPIANTO"};
		propertyNames = new String[]{"idContratto", "codiceImpianto", "fkRuolo", "desRuolo", "dataCaricamento",
				"dataCessazione", "dataInserimentoCessazione", "fkPg3Resp", "fkImpRuoloPfpgResp", "dataInizioContratto",
				"dataFineContratto", "flgTacitoRinnovo", "respCodiceFiscale", "respDenominazione", "respNome",
				"terzoRespDenominazione", "terzoRespSiglaRea", "terzoRespNumeroRea", "codiceFiscale3Resp",
				"denomComune3Resp", "siglaProv3Resp", "denomProvincia3Resp", "denomComuneImpianto", "denomProvImpianto",
				"siglaProvImpianto"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitVRicerca3Responsabile] fa riferimento
	 * (VISTA_RICERCA_3_RESPONSABILE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_RICERCA_3_RESPONSABILE";
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
