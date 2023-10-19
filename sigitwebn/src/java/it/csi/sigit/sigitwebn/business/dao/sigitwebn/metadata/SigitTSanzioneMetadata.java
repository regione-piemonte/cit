package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTSanzioneMetadata extends DAOMetadata {

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
	 * DAO: [sigitTSanzione]
	 * tabella: [SIGIT_T_SANZIONE].
	 */
	public SigitTSanzioneMetadata() {
		columnNames = new String[]{"ID_SANZIONE", "FK_STATO_SANZIONE", "FK_ISPEZIONE_2018", "FK_ACCERTAMENTO",
				"FK_PF_SANZIONATA", "FK_PG_SANZIONATA", "MOTIVAZIONE_SANZIONE", "VALORE_SANZIONE", "DT_CREAZIONE",
				"DT_COMUNICAZIONE", "DT_PAGAMENTO", "NOTE", "MOTIVO_ANNULLAMENTO", "DT_ANNULLAMENTO", "CF_RESPONSABILE",
				"DENOM_UT_RESPONSABILE", "DT_SVEGLIA", "NOTE_SVEGLIA"};
		propertyNames = new String[]{"idSanzione", "fkStatoSanzione", "fkIspezione2018", "fkAccertamento",
				"fkPfSanzionata", "fkPgSanzionata", "motivazioneSanzione", "valoreSanzione", "dtCreazione",
				"dtComunicazione", "dtPagamento", "note", "motivoAnnullamento", "dtAnnullamento", "cfResponsabile",
				"denomUtResponsabile", "dtSveglia", "noteSveglia"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTSanzione] fa riferimento
	 * (SIGIT_T_SANZIONE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_SANZIONE";
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
