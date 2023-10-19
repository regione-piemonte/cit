package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitTRappDettaglioMetadata extends DAOMetadata {

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
	 * DAO: [sigitTRappDettaglio]
	 * tabella: [SIGIT_T_RAPP_DETTAGLIO].
	 */
	public SigitTRappDettaglioMetadata() {
		columnNames = new String[]{"ID_RAPPORTO_DETTAGLIO", "FK_RAPPORTO_CONTROLLO", "FLG_PENDENZE", "FLG_SEZIONI",
				"FLG_CURVE", "FLG_LUNGHEZZA", "FLG_STATO_OK", "FLG_SINGOLO", "FLG_A_PARETE", "FLG_NO_RIFLUSSO",
				"FLG_COIBENTAZIONI", "FLG_NO_PERDITE", "FLG_CANNAFUMARIA_COLLETTIVA", "FLG_UGELLI_PULITI",
				"FLG_ROMPITIRAGGIO_OK", "FLG_SCAMBIATORE_PULITO", "FLG_FUNZIONAMENTO_OK", "FLG_DISPOSITIVI_OK",
				"FLG_ASSENZA_PERDITE_ACQUA", "FLG_VALVOLA_SICUR_LIBERA", "FLG_VASO_ESP_CARICO", "FLG_SICUREZZA_OK",
				"FLG_NO_USURE_DEFORMAZIONI", "FLG_CIRCUITO_ARIA_LIBERO", "FLG_ACCOPP_GEN_OK",
				"FLG_FUNZIONAMENTO_CORRETTO", "TEMP_FUMI", "TEMP_ARIA", "O2", "CO2", "BACHARACH", "CO", "REND_COMB",
				"FLG_LIBRETTO_BRUCIATORE", "NOX", "FLG_LIBRETTO_CALDAIA", "NOTE_DOCUMENTAZIONE",
				"FLG_EV_LINEE_ELETTRICHE", "FLG_EV_BRUCIATORE", "FLG_EV_GENERATORE_CALORE", "FLG_EV_CANALI_FUMO",
				"FLG_CONTROLLO_REND", "TIRAGGIO", "NOTE", "B_FLG_DICHIAR_CONFORM", "F_RACCOMANDAZIONI",
				"F_PRESCRIZIONI"};
		propertyNames = new String[]{"idRapportoDettaglio", "fkRapportoControllo", "flgPendenze", "flgSezioni",
				"flgCurve", "flgLunghezza", "flgStatoOk", "flgSingolo", "flgAParete", "flgNoRiflusso",
				"flgCoibentazioni", "flgNoPerdite", "flgCannafumariaCollettiva", "flgUgelliPuliti",
				"flgRompitiraggioOk", "flgScambiatorePulito", "flgFunzionamentoOk", "flgDispositiviOk",
				"flgAssenzaPerditeAcqua", "flgValvolaSicurLibera", "flgVasoEspCarico", "flgSicurezzaOk",
				"flgNoUsureDeformazioni", "flgCircuitoAriaLibero", "flgAccoppGenOk", "flgFunzionamentoCorretto",
				"tempFumi", "tempAria", "o2", "co2", "bacharach", "co", "rendComb", "flgLibrettoBruciatore", "nox",
				"flgLibrettoCaldaia", "noteDocumentazione", "flgEvLineeElettriche", "flgEvBruciatore",
				"flgEvGeneratoreCalore", "flgEvCanaliFumo", "flgControlloRend", "tiraggio", "note",
				"bFlgDichiarConform", "fRaccomandazioni", "fPrescrizioni"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitTRappDettaglio] fa riferimento
	 * (SIGIT_T_RAPP_DETTAGLIO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_RAPP_DETTAGLIO";
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
