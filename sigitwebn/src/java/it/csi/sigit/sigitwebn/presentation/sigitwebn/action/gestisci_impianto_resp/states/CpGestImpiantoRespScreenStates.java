package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_impianto_resp.states;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ScreenStateCommand;

/**
 * Questa classe contiene le informazioni relative agli ScreenStates del ContentPanel cpGestImpiantoResp
 */
public final class CpGestImpiantoRespScreenStates {

	/**
	 * Costruttore privato (questa e' una utility class)
	 */
	private CpGestImpiantoRespScreenStates() {
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
		static final String[] WIDGETS_ON = new String[]{"menu", "tfImpCodImp", "btnImpVerCodImp", "cbImpStatoImp",
				"rbImpTipo", "rbImpUiExt", "rbImpCont", "cbImpLocProvincia", "cbImpLocComune", "tfImpLocIndirizzo",
				"btnImpLocCercaIndirizzo", "cbImpLocIndirizzo", "btnImpLocNuovaRicercaIndirizzo", "tfImpLocNoStrad",
				"tfImpLocCivico", "tfImpLocCap", "tfImpLocInterno", "tfImpLocScala", "tfImpLocPalazzo",
				"tfImpLocFoglio", "tfImpLocSezione", "tfImpLocParticella", "tfImpLocSubalterno", "cbImpLocEdifNonAcc",
				"tfImpLocPod", "tfImpLocPdr", "cbImpLocPdrNonPres", "taImpLocNote", "btnImpiantoSalva",
				"btnImpIndietro", "cbRespTitolo", "cbRespIndirizzoEst", "tfRespIndirizzo", "btnRespCercaIndirizzo",
				"cbRespIndirizzo", "btnRespNuovaRicercaIndirizzo", "tfIRespNoStrad", "tfRespCivico", "tfRespCap",
				"tfRespEstStato", "tfRespEstCitta", "tfRespEstIndirizzo", "tfRespEstCivico", "tfRespEstCap",
				"cRespDataInizioResp", "tfRespEmail", "btnLibVisualizza", "btnLibRappControllo", "btnLibDocumentazione",
				"btnVisLibrettoWeb", "btnModificaProp", "cbVisuProprietario", "btnApprofondisciImpianto",
				"rbImpMedCiv"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"cImpDataDismiss", "taImpMotivivazione",
				"tfImpLocProprietario", "tfImpLocPropDataInizio", "tfImpLocPropIndirizzo", "cImpDataCessazione",
				"btnConfermaProp", "btnCessaProp", "cbRespSiglaRea", "tfRespNumRea", "tfRespCf", "tfRespCognome",
				"tfRespNome", "cbRespProvincia", "cbRespComune", "btnLibAggiornamenti"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"menu", "tfImpCodImp", "cbImpStatoImp", "cImpDataDismiss",
				"taImpMotivivazione", "rbImpTipo", "rbImpUiExt", "rbImpCont", "cbImpLocProvincia", "cbImpLocComune",
				"tfImpLocIndirizzo", "btnImpLocCercaIndirizzo", "cbImpLocIndirizzo", "btnImpLocNuovaRicercaIndirizzo",
				"tfImpLocNoStrad", "tfImpLocCivico", "tfImpLocCap", "tfImpLocInterno", "tfImpLocScala",
				"tfImpLocPalazzo", "tfImpLocFoglio", "tfImpLocSezione", "tfImpLocParticella", "tfImpLocSubalterno",
				"cbImpLocEdifNonAcc", "tfImpLocPod", "tfImpLocPdr", "cbImpLocPdrNonPres", "taImpLocNote",
				"btnImpiantoSalva", "btnImpIndietro", "cbRespTitolo", "tfRespCf", "tfRespCognome", "tfRespNome",
				"cbRespIndirizzoEst", "cbRespProvincia", "cbRespComune", "tfRespIndirizzo", "btnRespCercaIndirizzo",
				"cbRespIndirizzo", "btnRespNuovaRicercaIndirizzo", "tfIRespNoStrad", "tfRespCivico", "tfRespCap",
				"tfRespEstStato", "tfRespEstCitta", "tfRespEstIndirizzo", "tfRespEstCivico", "tfRespEstCap",
				"cRespDataInizioResp", "tfRespEmail", "btnLibVisualizza", "btnLibRappControllo", "btnLibDocumentazione",
				"btnVisLibrettoWeb", "tfImpLocProprietario", "tfImpLocPropDataInizio", "btnModificaProp",
				"cbVisuProprietario", "tfImpLocPropIndirizzo", "btnApprofondisciImpianto", "rbImpMedCiv"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"btnImpVerCodImp", "cImpDataCessazione", "btnConfermaProp",
				"btnCessaProp", "cbRespSiglaRea", "tfRespNumRea", "btnLibAggiornamenti"};

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
		static final String[] WIDGETS_OFF = new String[]{"tfImpCodImp", "btnApprofondisciImpianto", "btnImpVerCodImp",
				"cbImpStatoImp", "cImpDataDismiss", "taImpMotivivazione", "rbImpTipo", "rbImpUiExt", "rbImpCont",
				"rbImpMedCiv", "cbImpLocProvincia", "cbImpLocComune", "tfImpLocIndirizzo", "btnImpLocCercaIndirizzo",
				"cbImpLocIndirizzo", "btnImpLocNuovaRicercaIndirizzo", "tfImpLocNoStrad", "tfImpLocCivico",
				"tfImpLocCap", "tfImpLocInterno", "tfImpLocScala", "tfImpLocPalazzo", "tfImpLocSezione",
				"tfImpLocFoglio", "tfImpLocParticella", "tfImpLocSubalterno", "cbImpLocEdifNonAcc", "tfImpLocPod",
				"tfImpLocPdr", "cbImpLocPdrNonPres", "taImpLocNote", "cbVisuProprietario", "tfImpLocProprietario",
				"tfImpLocPropDataInizio", "tfImpLocPropIndirizzo", "cImpDataCessazione", "btnConfermaProp",
				"btnModificaProp", "btnCessaProp", "cbRespTitolo", "cbRespSiglaRea", "tfRespNumRea", "tfRespCf",
				"tfRespCognome", "tfRespNome", "cbRespIndirizzoEst", "cbRespProvincia", "cbRespComune",
				"tfRespIndirizzo", "btnRespCercaIndirizzo", "cbRespIndirizzo", "btnRespNuovaRicercaIndirizzo",
				"tfIRespNoStrad", "tfRespCivico", "tfRespCap", "tfRespEstStato", "tfRespEstCitta", "tfRespEstIndirizzo",
				"tfRespEstCivico", "tfRespEstCap", "cRespDataInizioResp", "tfRespEmail", "btnImpiantoSalva",
				"btnLibRappControllo", "btnLibDocumentazione", "btnVisLibrettoWeb", "btnLibAggiornamenti"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"menu", "tfImpCodImp", "cbImpStatoImp", "cImpDataDismiss",
				"taImpMotivivazione", "rbImpTipo", "rbImpUiExt", "rbImpCont", "cbImpLocProvincia", "cbImpLocComune",
				"tfImpLocIndirizzo", "cbImpLocIndirizzo", "tfImpLocNoStrad", "taImpLocNote", "tfImpLocCivico",
				"tfImpLocCap", "tfImpLocInterno", "tfImpLocScala", "tfImpLocPalazzo", "tfImpLocFoglio",
				"tfImpLocSezione", "tfImpLocParticella", "tfImpLocSubalterno", "cbImpLocEdifNonAcc", "tfImpLocPod",
				"tfImpLocPdr", "btnLibVisualizza", "btnImpIndietro", "tfImpLocProprietario", "tfImpLocPropDataInizio",
				"cbVisuProprietario", "tfImpLocPropIndirizzo", "rbImpMedCiv"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"btnApprofondisciImpianto", "btnImpVerCodImp",
				"btnImpLocCercaIndirizzo", "btnImpLocNuovaRicercaIndirizzo", "cbImpLocPdrNonPres", "cImpDataCessazione",
				"btnConfermaProp", "btnModificaProp", "btnCessaProp", "cbRespTitolo", "cbRespSiglaRea", "tfRespNumRea",
				"tfRespCf", "tfRespCognome", "tfRespNome", "cbRespIndirizzoEst", "cbRespProvincia", "cbRespComune",
				"tfRespIndirizzo", "btnRespCercaIndirizzo", "cbRespIndirizzo", "btnRespNuovaRicercaIndirizzo",
				"tfIRespNoStrad", "tfRespCivico", "tfRespCap", "tfRespEstStato", "tfRespEstCitta", "tfRespEstIndirizzo",
				"tfRespEstCivico", "tfRespEstCap", "cRespDataInizioResp", "tfRespEmail", "btnImpiantoSalva",
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
