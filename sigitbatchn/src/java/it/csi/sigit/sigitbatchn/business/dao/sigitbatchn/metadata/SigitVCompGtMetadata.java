package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitVCompGtMetadata extends DAOMetadata {

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
	 * DAO: [sigitVCompGt]
	 * tabella: [VISTA_COMP_GT].
	 */
	public SigitVCompGtMetadata() {
		columnNames = new String[]{"CODICE_IMPIANTO", "ID_TIPO_COMPONENTE", "PROGRESSIVO", "DATA_INSTALL",
				"DATA_DISMISS", "MATRICOLA", "FK_MARCA", "DES_MARCA", "ID_COMBUSTIBILE", "DES_COMBUSTIBILE",
				"FK_FLUIDO", "DES_FLUIDO", "FK_DETTAGLIO_GT", "DES_DETTAGLIO_GT", "MODELLO", "POTENZA_TERMICA_KW",
				"DATA_ULT_MOD", "UTENTE_ULT_MOD", "RENDIMENTO_PERC", "N_MODULI", "FLG_DISMISSIONE"};
		propertyNames = new String[]{"codiceImpianto", "idTipoComponente", "progressivo", "dataInstall", "dataDismiss",
				"matricola", "fkMarca", "desMarca", "idCombustibile", "desCombustibile", "fkFluido", "desFluido",
				"fkDettaglioGt", "desDettaglioGt", "modello", "potenzaTermicaKw", "dataUltMod", "utenteUltMod",
				"rendimentoPerc", "nModuli", "flgDismissione"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitVCompGt] fa riferimento
	 * (VISTA_COMP_GT).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_COMP_GT";
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
