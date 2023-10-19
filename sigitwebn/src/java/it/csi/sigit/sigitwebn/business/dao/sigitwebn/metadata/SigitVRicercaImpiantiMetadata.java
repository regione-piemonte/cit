package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitVRicercaImpiantiMetadata extends DAOMetadata {

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
	 * DAO: [sigitVRicercaImpianti]
	 * tabella: [VISTA_RICERCA_IMPIANTI].
	 */
	public SigitVRicercaImpiantiMetadata() {
		columnNames = new String[]{"CODICE_IMPIANTO", "ISTAT_COMUNE", "DENOMINAZIONE_COMUNE", "SIGLA_PROVINCIA",
				"DENOMINAZIONE_PROVINCIA", "FK_STATO", "L1_3_POT_H2O_KW", "L1_3_POT_CLIMA_INV_KW",
				"L1_3_POT_CLIMA_EST_KW", "FLG_NOPDR", "INDIRIZZO_UNITA_IMMOB", "CIVICO", "SEZIONE", "FOGLIO",
				"PARTICELLA", "SUBALTERNO", "POD_ELETTRICO", "PDR_GAS", "DENOMINAZIONE_RESPONSABILE",
				"DENOMINAZIONE_3_RESPONSABILE", "SIGLA_REA_3R", "NUMERO_REA_3R", "CODICE_FISCALE_3R", "CODICE_FISCALE",
				"DATA_FINE_PFPG", "RUOLO_RESPONSABILE", "RUOLO_FUNZ", "FLG_TIPO_IMPIANTO", "FLG_APPARECC_UI_EXT",
				"FLG_CONTABILIZZAZIONE", "DES_STATO", "FLG_VISU_PROPRIETARIO"};
		propertyNames = new String[]{"codiceImpianto", "istatComune", "denominazioneComune", "siglaProvincia",
				"denominazioneProvincia", "fkStato", "l13PotH2oKw", "l13PotClimaInvKw", "l13PotClimaEstKw", "flgNopdr",
				"indirizzoUnitaImmob", "civico", "sezione", "foglio", "particella", "subalterno", "podElettrico",
				"pdrGas", "denominazioneResponsabile", "denominazione3Responsabile", "siglaRea3r", "numeroRea3r",
				"codiceFiscale3r", "codiceFiscale", "dataFinePfpg", "ruoloResponsabile", "ruoloFunz", "flgTipoImpianto",
				"flgAppareccUiExt", "flgContabilizzazione", "desStato", "flgVisuProprietario"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitVRicercaImpianti] fa riferimento
	 * (VISTA_RICERCA_IMPIANTI).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_RICERCA_IMPIANTI";
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
