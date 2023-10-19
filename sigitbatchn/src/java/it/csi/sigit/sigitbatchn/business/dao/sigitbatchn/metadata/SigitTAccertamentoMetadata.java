package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTAccertamentoMetadata extends DAOMetadata {

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
	 * DAO: [sigitTAccertamento]
	 * tabella: [SIGIT_T_ACCERTAMENTO].
	 */
	public SigitTAccertamentoMetadata() {
		columnNames = new String[]{"ID_ACCERTAMENTO", "FK_VERIFICA", "FK_STATO_ACCERTAMENTO", "CODICE_IMPIANTO",
				"CF_UTENTE_ASSEGN", "DT_CREAZIONE", "DT_CONCLUSIONE", "FK_TIPO_CONCLUSIONE", "FK_TIPO_ANOMALIA",
				"DT_SVEGLIA", "NOTE_SVEGLIA", "NOTE", "SIGLA_PROV_COMPETENZA", "ISTAT_PROV_COMPETENZA",
				"DENOM_UTENTE_ASSEGN", "ISTAT_COMUNE_COMPETENZA"};
		propertyNames = new String[]{"idAccertamento", "fkVerifica", "fkStatoAccertamento", "codiceImpianto",
				"cfUtenteAssegn", "dtCreazione", "dtConclusione", "fkTipoConclusione", "fkTipoAnomalia", "dtSveglia",
				"noteSveglia", "note", "siglaProvCompetenza", "istatProvCompetenza", "denomUtenteAssegn",
				"istatComuneCompetenza"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTAccertamento] fa riferimento
	 * (SIGIT_T_ACCERTAMENTO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ACCERTAMENTO";
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
