package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.acquisisci_codici_impianto.states;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ScreenStateCommand;

/**
 * Questa classe contiene le informazioni relative agli ScreenStates del ContentPanel cpAcquisisciCodici
 */
public final class CpAcquisisciCodiciScreenStates {

	/**
	 * Costruttore privato (questa e' una utility class)
	 */
	private CpAcquisisciCodiciScreenStates() {
		// costruttore intenzionalmente vuoto
	}

	/**
	 * Questa classe rappresenta lo ScreenState START_ABILITA.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class START_ABILITAScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"menu", "cbSiglaRea", "tfNumRea", "tfCF", "btnCercaInst",
				"tfQuantita", "btnAnnullaInsCod", "btnIndietro", "btnAcquisisci"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"btnNuovaRicercaInst", "tfDitta", "tfDataConsegna",
				"tfAcquisitiDa"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"menu", "cbSiglaRea", "tfNumRea", "tfCF", "btnCercaInst",
				"tfDitta", "tfDataConsegna", "tfAcquisitiDa", "tfQuantita", "btnAnnullaInsCod", "btnIndietro",
				"btnAcquisisci"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"btnNuovaRicercaInst"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("START_ABILITA", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private START_ABILITAScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

	/**
	 * Questa classe rappresenta lo ScreenState START_DISABILITA.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class START_DISABILITAScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"menu", "tfQuantita", "btnAnnullaInsCod", "btnIndietro",
				"btnAcquisisci"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"cbSiglaRea", "tfNumRea", "tfCF", "btnCercaInst",
				"btnNuovaRicercaInst", "tfDitta", "tfDataConsegna", "tfAcquisitiDa"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"menu", "cbSiglaRea", "tfNumRea", "tfCF", "tfDitta",
				"tfDataConsegna", "tfAcquisitiDa", "tfQuantita", "btnAnnullaInsCod", "btnIndietro", "btnAcquisisci"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"btnCercaInst", "btnNuovaRicercaInst"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("START_DISABILITA", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private START_DISABILITAScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

}
