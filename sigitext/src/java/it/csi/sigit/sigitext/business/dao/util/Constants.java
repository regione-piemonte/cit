package it.csi.sigit.sigitext.business.dao.util;

/**
 * Costanti dell'applicativo
 *
 * @generated
 */
public final class Constants {
	/**
	 * identificativo dell'applicativo.
	 */
	public static final String APPLICATION_CODE = "sigitext";

	/*PROTECTED REGION ID(R-1074371075) ENABLED START*/

	public static final int ID_STATO_RAPPORTO_INVIATO = 1;

	// RUOLO RESPONSABILE
	public static final String RUOLO_RESPONSABILE = it.csi.sigit.sigitext.business.util.Constants.RUOLO_RESPONSABILE;

	// RUOLO RESPONSABILE IMPRESA
	public static final String RUOLO_RESPONSABILE_IMPRESA = it.csi.sigit.sigitext.business.util.Constants.RUOLO_RESPONSABILE_IMPRESA;

	// RUOLO PROPRIETARIO
	public static final String RUOLO_PROPRIETARIO = it.csi.sigit.sigitext.business.util.Constants.RUOLO_PROPRIETARIO;

	// RUOLO PROPRIETARIO IMPRESA
	public static final String RUOLO_PROPRIETARIO_IMPRESA = it.csi.sigit.sigitext.business.util.Constants.RUOLO_PROPRIETARIO_IMPRESA;

	//RUOLO CARICATORE (ex INSTALLATORE)
	public static final String RUOLO_CARICATORE = it.csi.sigit.sigitext.business.util.Constants.RUOLO_CARICATORE;

	// RUOLO IMPRESA (ex MANUTENTORE)
	public static final String RUOLO_IMPRESA = it.csi.sigit.sigitext.business.util.Constants.RUOLO_IMPRESA;

	// ID RUOLO PROPRIETARIO
	public final static int ID_RUOLO_PROPRIETARIO = it.csi.sigit.sigitext.business.util.Constants.ID_RUOLO_PROPRIETARIO;

	// ID RUOLO PROPRIETARIO
	public final static int ID_RUOLO_OCCUPANTE = it.csi.sigit.sigitext.business.util.Constants.ID_RUOLO_OCCUPANTE;

	// ID RUOLO RESPONSABILE IMPRESA PROPRIETARIO
	public final static int ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO = it.csi.sigit.sigitext.business.util.Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO;

	// ID RUOLO RESPONSABILE IMPRESA OCCUPANTE
	public final static int ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE = it.csi.sigit.sigitext.business.util.Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE;

	// ID RUOLO RESPONSABILE IMPRESA AMMINISTRATORE
	public final static int ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE = it.csi.sigit.sigitext.business.util.Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE;

	// ID RUOLO AMMINISTRATORE
	public final static int ID_RUOLO_AMMINISTRATORE = it.csi.sigit.sigitext.business.util.Constants.ID_RUOLO_AMMINISTRATORE;

	public final static String ALLEGATO_TIPO_1 = it.csi.sigit.sigitext.business.util.Constants.ALLEGATO_TIPO_1;
	public final static String ALLEGATO_TIPO_1B = it.csi.sigit.sigitext.business.util.Constants.ALLEGATO_TIPO_1B;
	public final static String ALLEGATO_TIPO_2 = it.csi.sigit.sigitext.business.util.Constants.ALLEGATO_TIPO_2;
	public final static String ALLEGATO_TIPO_3 = it.csi.sigit.sigitext.business.util.Constants.ALLEGATO_TIPO_3;
	public final static String ALLEGATO_TIPO_4 = it.csi.sigit.sigitext.business.util.Constants.ALLEGATO_TIPO_4;
	public final static String MANUTENZIONE_GT = it.csi.sigit.sigitext.business.util.Constants.MANUTENZIONE_GT;
	public final static String MANUTENZIONE_GF = it.csi.sigit.sigitext.business.util.Constants.MANUTENZIONE_GF;
	public final static String MANUTENZIONE_SC = it.csi.sigit.sigitext.business.util.Constants.MANUTENZIONE_SC;
	public final static String MANUTENZIONE_CG = it.csi.sigit.sigitext.business.util.Constants.MANUTENZIONE_CG;

	public static final String ID_DETT_GF_ASS_REC_CALORE = "1";
	public static final String ID_DETT_GF_ASS_FIAMM_COMB = "2";
	public static final String ID_DETT_GF_CICLO_COMPRESS = "3";

	public final static int ID_TIPO_CONSUMO_1B_ACQUA_REINTEGRO = 1;
	public final static int ID_TIPO_CONSUMO_1B_CONSUMO_BIOMASSA = 2;

	public static final String ID_DETT_GT_GRUPPO_TERM_SING = "1";
	public static final String ID_DETT_GT_GRUPPO_TERM_MOD = "2";
	public static final String ID_DETT_GT_TUBO_RADIANTE = "3";
	public static final String ID_DETT_GT_GEN_ARIA_CALDA = "4";

	public static final String FLAG_EVACUAZIONE_FUMI_FORZATA = "F";
	public static final String FLAG_EVACUAZIONE_FUMI_NATURALE = "N";

	public static final String FLAG_MODALITA_RAFFRESCAMENTO = "RAF";
	public static final String FLAG_MODALITA_RISCALDAMENTO = "RIS";
	public final static int ID_STELLE_NON_APPLICABILE = 0;
	public final static int ID_STELLE_3 = 3;
	public final static int ID_STELLE_4 = 4;
	public final static int ID_STELLE_5 = 5;

	public final static int ID_TIPO_1B_TRADIZIONALE = 1;
	public final static int ID_TIPO_1B_CONDENSAZIONE = 2;
	public final static int ID_TIPO_1B_ALTRO = 3;

	public final static int ID_TIPO_COMBUSTIBILE_PELLET = 5;
	public final static int ID_TIPO_COMBUSTIBILE_TRONCHETTI = 6;
	public final static int ID_TIPO_COMBUSTIBILE_CIPPATO = 7;
	public final static int ID_TIPO_COMBUSTIBILE_ALTRA_BIOMASSA_SOLIDA = 9;
	public final static int ID_TIPO_COMBUSTIBILE_BIOMASSA_LIQUIDA = 10;
	public final static int ID_TIPO_COMBUSTIBILE_BIOMASSA_GASSOSA = 11;
	public final static int ID_TIPO_COMBUSTIBILE_LEGNA = 13;
	public final static int ID_TIPO_COMBUSTIBILE_BRICCHETTE = 14;
	public final static int ID_TIPO_COMBUSTIBILE_TRONCHETTI_PELLET = 96;
	public final static int ID_TIPO_COMBUSTIBILE_CIPPATO_PELLET = 97;
	public final static int ID_TIPO_COMBUSTIBILE_POLICOMBUSTIBILE_BIOMASSA_GAS_GASOLIO = 98;
	public final static Integer[] ID_TIPO_COMBUSIBILE_BIOMASSA_ARRAY = { ID_TIPO_COMBUSTIBILE_PELLET, ID_TIPO_COMBUSTIBILE_TRONCHETTI, ID_TIPO_COMBUSTIBILE_CIPPATO,
			ID_TIPO_COMBUSTIBILE_ALTRA_BIOMASSA_SOLIDA, ID_TIPO_COMBUSTIBILE_BIOMASSA_LIQUIDA, ID_TIPO_COMBUSTIBILE_BIOMASSA_GASSOSA, ID_TIPO_COMBUSTIBILE_LEGNA, ID_TIPO_COMBUSTIBILE_BRICCHETTE,
			ID_TIPO_COMBUSTIBILE_TRONCHETTI_PELLET, ID_TIPO_COMBUSTIBILE_CIPPATO_PELLET, ID_TIPO_COMBUSTIBILE_POLICOMBUSTIBILE_BIOMASSA_GAS_GASOLIO };

	public final static Integer[] ID_TIPO_COMBUSTIBILE_CHECKBOX_PDF = { ID_TIPO_COMBUSTIBILE_PELLET, ID_TIPO_COMBUSTIBILE_CIPPATO, ID_TIPO_COMBUSTIBILE_LEGNA, ID_TIPO_COMBUSTIBILE_BRICCHETTE };


	public final static int ID_ARIA_COMBURENTE_DA_ESTERNO = 1;
	public final static int ID_ARIA_COMBURENTE_DA_LOCALE_INSTALLAZIONE = 2;

	public final static int ID_CONTROLLO_ARIA_COMBURENTE_AUTOMATICO = 1;
	public final static int ID_CONTROLLO_ARIA_COMBURENTE_SEMIAUTOMATICO = 2;
	public final static int ID_CONTROLLO_ARIA_COMBURENTE_MANUALE = 3;

	public final static int ID_CARICAMENTO_COMBUSTIBILE_AUTOMATICO = 1;
	public final static int ID_CARICAMENTO_COMBUSTIBILE_MANUALE = 2;
	public final static int ID_CARICAMENTO_COMBUSTIBILE_AUTOMATICO_MANUALE = 3;
	/*PROTECTED REGION END*/
}
