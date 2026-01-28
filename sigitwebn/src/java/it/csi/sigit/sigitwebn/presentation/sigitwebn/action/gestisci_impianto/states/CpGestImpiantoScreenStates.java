package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_impianto.states;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ScreenStateCommand;

/**
 * Questa classe contiene le informazioni relative agli ScreenStates del ContentPanel cpGestImpianto
 */
public final class CpGestImpiantoScreenStates {

	/**
	 * Costruttore privato (questa e' una utility class)
	 */
	private CpGestImpiantoScreenStates() {
		// costruttore intenzionalmente vuoto
	}

	/**
	 * Questa classe rappresenta lo ScreenState REGISTRAZIONE.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class REGISTRAZIONEScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"menu", "cbInstSiglaRea", "tfInstNumRea", "tfInstCf",
				"btnInstCercaCF", "btnInstNuovaRicercaCF", "tbManutentori", "tfImpCodImp", "cbImpStatoImp", "rbImpTipo",
				"rbImpUiExt", "rbImpCont", "cbImpLocProvincia", "cbImpLocComune", "tfImpLocIndirizzo",
				"btnImpLocCercaIndirizzo", "cbImpLocIndirizzo", "btnImpLocNuovaRicercaIndirizzo", "tfImpLocNoStrad",
				"tfImpLocCivico", "tfImpLocCap", "tfImpLocInterno", "tfImpLocScala", "tfImpLocPalazzo",
				"tfImpLocFoglio", "tfImpLocSezione", "tfImpLocParticella", "tfImpLocSubalterno", "cbImpLocEdifNonAcc",
				"tfImpLocPod", "tfImpLocPdr", "cbImpLocPdrNonPres", "taImpLocNote", "btnImpiantoSalva",
				"tbResponsabili", "btnRespInserisci", "btnRespModifica", "btnImpIndietro", "btnLibVisualizza",
				"btnLibRappControllo", "fuImpLib", "btAvviaImport", "btnLibDocumentazione", "btnVisLibrettoWeb",
				"btnLibAggiornamenti", "btnModificaProp", "cbVisuProprietario", "btnApprofondisciImpianto",
				"rbImpMedCiv"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"tfInstImpresa", "cbInstPrimoCaricatore", "cImpDataDismiss",
				"taImpMotivazione", "tfImpLocProprietario", "tfImpLocPropDataInizio", "tfImpLocPropIndirizzo",
				"cImpDataCessazione", "btnConfermaProp", "btnCessaProp"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"menu", "cbInstSiglaRea", "tfInstNumRea", "tfInstCf",
				"btnInstCercaCF", "btnInstNuovaRicercaCF", "tfInstImpresa", "tbManutentori", "tfImpCodImp",
				"cbImpStatoImp", "cImpDataDismiss", "taImpMotivazione", "rbImpTipo", "rbImpUiExt", "rbImpCont",
				"cbImpLocProvincia", "cbImpLocComune", "tfImpLocIndirizzo", "btnImpLocCercaIndirizzo",
				"cbImpLocIndirizzo", "btnImpLocNuovaRicercaIndirizzo", "tfImpLocNoStrad", "tfImpLocCivico",
				"tfImpLocCap", "tfImpLocInterno", "tfImpLocScala", "tfImpLocPalazzo", "tfImpLocFoglio",
				"tfImpLocSezione", "tfImpLocParticella", "tfImpLocSubalterno", "cbImpLocEdifNonAcc", "tfImpLocPod",
				"tfImpLocPdr", "cbImpLocPdrNonPres", "tfImpLocProprietario", "taImpLocNote", "btnImpiantoSalva",
				"tbResponsabili", "btnRespInserisci", "btnRespModifica", "btnImpIndietro", "btnLibVisualizza",
				"btnLibRappControllo", "fuImpLib", "btAvviaImport", "btnLibDocumentazione", "btnVisLibrettoWeb",
				"btnLibAggiornamenti", "tfImpLocPropDataInizio", "btnModificaProp", "cbVisuProprietario",
				"tfImpLocPropIndirizzo", "btnApprofondisciImpianto", "rbImpMedCiv"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"cbInstPrimoCaricatore", "cImpDataCessazione",
				"btnConfermaProp", "btnCessaProp"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("REGISTRAZIONE", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private REGISTRAZIONEScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

	/**
	 * Questa classe rappresenta lo ScreenState VISUALIZZAZIONE.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class VISUALIZZAZIONEScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"menu", "btnLibVisualizza", "btnImpIndietro"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"cbInstSiglaRea", "tfInstNumRea", "tfInstCf", "btnInstCercaCF",
				"btnInstNuovaRicercaCF", "tfInstImpresa", "cbInstPrimoCaricatore", "tbManutentori", "tfImpCodImp",
				"btnApprofondisciImpianto", "cbImpStatoImp", "cImpDataDismiss", "taImpMotivazione", "rbImpTipo",
				"rbImpUiExt", "rbImpCont", "rbImpMedCiv", "cbImpLocProvincia", "cbImpLocComune", "tfImpLocIndirizzo",
				"btnImpLocCercaIndirizzo", "cbImpLocIndirizzo", "btnImpLocNuovaRicercaIndirizzo", "tfImpLocNoStrad",
				"tfImpLocCivico", "tfImpLocCap", "tfImpLocInterno", "tfImpLocScala", "tfImpLocPalazzo",
				"tfImpLocSezione", "tfImpLocFoglio", "tfImpLocParticella", "tfImpLocSubalterno", "cbImpLocEdifNonAcc",
				"tfImpLocPod", "tfImpLocPdr", "cbImpLocPdrNonPres", "cbVisuProprietario", "taImpLocNote",
				"btnImpiantoSalva", "tfImpLocProprietario", "tfImpLocPropDataInizio", "tfImpLocPropIndirizzo",
				"cImpDataCessazione", "btnConfermaProp", "btnModificaProp", "btnCessaProp", "tbResponsabili",
				"btnRespInserisci", "btnRespModifica", "fuImpLib", "btAvviaImport", "btnLibRappControllo",
				"btnLibDocumentazione", "btnVisLibrettoWeb", "btnLibAggiornamenti"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"menu", "cbInstSiglaRea", "tfInstNumRea", "tfInstCf",
				"tfInstImpresa", "tbManutentori", "tfImpCodImp", "cbImpStatoImp", "cImpDataDismiss", "taImpMotivazione",
				"rbImpTipo", "rbImpUiExt", "rbImpCont", "cbImpLocProvincia", "cbImpLocComune", "tfImpLocIndirizzo",
				"cbImpLocIndirizzo", "tfImpLocNoStrad", "tfImpLocCivico", "tfImpLocCap", "tfImpLocInterno",
				"tfImpLocScala", "tfImpLocPalazzo", "tfImpLocFoglio", "tfImpLocSezione", "tfImpLocParticella",
				"tfImpLocSubalterno", "cbImpLocEdifNonAcc", "tfImpLocPod", "tfImpLocPdr", "cbImpLocPdrNonPres",
				"tfImpLocProprietario", "taImpLocNote", "tbResponsabili", "btnLibVisualizza", "btnImpIndietro",
				"tfImpLocPropDataInizio", "cbVisuProprietario", "tfImpLocPropIndirizzo", "rbImpMedCiv"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"btnInstCercaCF", "btnInstNuovaRicercaCF",
				"cbInstPrimoCaricatore", "btnApprofondisciImpianto", "btnImpLocCercaIndirizzo",
				"btnImpLocNuovaRicercaIndirizzo", "btnImpiantoSalva", "cImpDataCessazione", "btnConfermaProp",
				"btnModificaProp", "btnCessaProp", "btnRespInserisci", "btnRespModifica", "fuImpLib", "btAvviaImport",
				"btnLibRappControllo", "btnLibDocumentazione", "btnVisLibrettoWeb", "btnLibAggiornamenti"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("VISUALIZZAZIONE", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private VISUALIZZAZIONEScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

}
