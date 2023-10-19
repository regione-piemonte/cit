package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTIspezione2018Metadata extends DAOMetadata {

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
	 * DAO: [sigitTIspezione2018]
	 * tabella: [SIGIT_T_ISPEZIONE_2018].
	 */
	public SigitTIspezione2018Metadata() {
		columnNames = new String[]{"ID_ISPEZIONE_2018", "FK_STATO_ISPEZIONE", "FK_VERIFICA", "FK_ACCERTAMENTO",
				"CODICE_IMPIANTO", "CF_ISPETTORE_SECONDARIO", "ENTE_COMPETENTE", "FLG_ESITO", "DT_SVEGLIA",
				"NOTE_SVEGLIA", "NOTE", "ISTAT_PROV_COMPETENZA", "FLG_ACC_SOSTITUTIVO", "DT_CREAZIONE",
				"DT_CONCLUSIONE", "FLG_ISP_PAGAMENTO", "ISTAT_COMUNE_COMPETENZA"};
		propertyNames = new String[]{"idIspezione2018", "fkStatoIspezione", "fkVerifica", "fkAccertamento",
				"codiceImpianto", "cfIspettoreSecondario", "enteCompetente", "flgEsito", "dtSveglia", "noteSveglia",
				"note", "istatProvCompetenza", "flgAccSostitutivo", "dtCreazione", "dtConclusione", "flgIspPagamento",
				"istatComuneCompetenza"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTIspezione2018] fa riferimento
	 * (SIGIT_T_ISPEZIONE_2018).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ISPEZIONE_2018";
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
