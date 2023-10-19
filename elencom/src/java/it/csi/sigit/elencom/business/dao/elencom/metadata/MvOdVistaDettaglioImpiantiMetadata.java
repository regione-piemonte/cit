package it.csi.sigit.elencom.business.dao.elencom.metadata;

import it.csi.sigit.elencom.business.dao.elencom.dto.*;
import it.csi.sigit.elencom.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class MvOdVistaDettaglioImpiantiMetadata extends DAOMetadata {

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
	 * DAO: [mvOdVistaDettaglioImpianti]
	 * tabella: [MV_OD_VISTA_DETTAGLIO_IMPIANTI].
	 */
	public MvOdVistaDettaglioImpiantiMetadata() {
		columnNames = new String[]{"CODICE_IMPIANTO", "DENOMINAZIONE_COMUNE", "DENOMINAZIONE_PROVINCIA",
				"L1_2_FK_CATEGORIA", "L1_2_VOL_RISC_M3", "L1_2_VOL_RAFF_M3", "l1_3_pot_h2o_kw", "l1_3_pot_clima_inv_kw",
				"l1_3_pot_clima_est_kw", "tipo_componente", "progressivo", "data_install", "des_marca",
				"des_combustibile", "des_dettaglio", "potenza", "rendimento_perc", "data_controllo", "e_nox_ppm",
				"e_nox_mg_kwh", "e_n_modulo_termico", "flg_no_opendata", "indirizzo_unita_immob", "civico", "sezione",
				"foglio", "particella", "subalterno", "pod_elettrico", "pdr_gas", "e_nox_mg_nm3", "coord_x_long_dd",
				"coord_y_lat_dd", "flg_tipo_impianto"};
		propertyNames = new String[]{"codiceImpianto", "denominazioneComune", "denominazioneProvincia",
				"l12FkCategoria", "l12VolRiscM3", "l12VolRaffM3", "l13PotH2oKw", "l13PotClimaInvKw", "l13PotClimaEstKw",
				"tipoComponente", "progressivo", "dataInstall", "desMarca", "desCombustibile", "desDettaglio",
				"potenza", "rendimentoPerc", "dataControllo", "eNoxPpm", "eNoxMgKwh", "eNModuloTermico",
				"flgNoOpendata", "indirizzoUnitaImmob", "civico", "sezione", "foglio", "particella", "subalterno",
				"podElettrico", "pdrGas", "eNoxMgNm3", "coordXLongDd", "coordYLatDd", "flgTipoImpianto"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [mvOdVistaDettaglioImpianti] fa riferimento
	 * (MV_OD_VISTA_DETTAGLIO_IMPIANTI).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "MV_OD_VISTA_DETTAGLIO_IMPIANTI";
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
