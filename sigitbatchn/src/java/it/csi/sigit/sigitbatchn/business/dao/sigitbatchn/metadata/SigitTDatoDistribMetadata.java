package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTDatoDistribMetadata extends DAOMetadata {

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
	 * DAO: [sigitTDatoDistrib]
	 * tabella: [SIGIT_T_DATO_DISTRIB].
	 */
	public SigitTDatoDistribMetadata() {
		columnNames = new String[]{"ID_DATO_DISTRIB", "FK_TIPO_CONTRATTO", "FK_IMPORT_DISTRIB", "FK_CATEGORIA_UTIL",
				"FK_COMBUSTIBILE", "CODICE_ASSENZA_CATAST", "FK_UNITA_MISURA", "FLG_PF_PG", "COGNOME_DENOM", "NOME",
				"CF_PIVA", "ANNO_RIF", "NR_MESI_FATTUR", "DUG", "INDIRIZZO", "CIVICO", "CAP", "ISTAT_COMUNE", "POD_PDR",
				"CONSUMO_ANNO", "CONSUMO_MENSILE", "MESE_RIFERIMENTO", "CONSUMO_GIORNALIERO", "GIORNO_RIFERIMENTO",
				"VOLUMETRIA", "FLG_PF_PG_FATT", "COGNOME_DENOM_FATT", "NOME_FATT", "CF_PIVA_FATT", "DUG_FATT",
				"INDIRIZZO_FATT", "CIVICO_FATT", "CAP_FATT", "ISTAT_COMUNE_FATT"};
		propertyNames = new String[]{"idDatoDistrib", "fkTipoContratto", "fkImportDistrib", "fkCategoriaUtil",
				"fkCombustibile", "codiceAssenzaCatast", "fkUnitaMisura", "flgPfPg", "cognomeDenom", "nome", "cfPiva",
				"annoRif", "nrMesiFattur", "dug", "indirizzo", "civico", "cap", "istatComune", "podPdr", "consumoAnno",
				"consumoMensile", "meseRiferimento", "consumoGiornaliero", "giornoRiferimento", "volumetria",
				"flgPfPgFatt", "cognomeDenomFatt", "nomeFatt", "cfPivaFatt", "dugFatt", "indirizzoFatt", "civicoFatt",
				"capFatt", "istatComuneFatt"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTDatoDistrib] fa riferimento
	 * (SIGIT_T_DATO_DISTRIB).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DATO_DISTRIB";
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
