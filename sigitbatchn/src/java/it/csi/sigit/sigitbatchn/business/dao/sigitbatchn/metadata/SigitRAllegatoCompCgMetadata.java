package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitRAllegatoCompCgMetadata extends DAOMetadata {

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
	 * DAO: [sigitRAllegatoCompCg]
	 * tabella: [SIGIT_R_ALLEGATO_COMP_CG].
	 */
	public SigitRAllegatoCompCgMetadata() {
		columnNames = new String[]{"ID_ALLEGATO", "ID_TIPO_COMPONENTE", "PROGRESSIVO", "CODICE_IMPIANTO",
				"DATA_INSTALL", "BUTTA_FK_R_PG", "BUTTA_FK_3R_PG", "BUTTA_FK_R_PF", "BUTTA_FK_3RESP", "BUTTA_FK_RESP",
				"FK_IMP_RUOLO_PFPG", "FK_CONTRATTO"};
		propertyNames = new String[]{"idAllegato", "idTipoComponente", "progressivo", "codiceImpianto", "dataInstall",
				"buttaFkRPg", "buttaFk3rPg", "buttaFkRPf", "buttaFk3resp", "buttaFkResp", "fkImpRuoloPfpg",
				"fkContratto"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitRAllegatoCompCg] fa riferimento
	 * (SIGIT_R_ALLEGATO_COMP_CG).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_ALLEGATO_COMP_CG";
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
