package it.csi.sigit.sigitwebn.util;

/**
 * <p>Classe delle costanti applicative.</p>
 *
 * @author GuiGen
 */
public final class Constants {
	/**
	 * identificativo dell'applicativo.
	 */
	public static final String APPLICATION_CODE = "sigitwebn";

	/**
	 * nome dell'attributo di sessione in cui viene memorizzato il valore corrente del
	 * captcha 
	 */
	public static final String CAPTCHA_SESSION_NAME = "current_captcha_value";

	/*PROTECTED REGION ID(R1581691183) ENABLED START*/
	private static java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("/META-INF/sigitwebn");

	/** The siceews tenant username. */
	public static final String SIGITEXT_URL = rb.getString("sigitext.url");
	// Add here your constants

	public static String PORTALE_SISTEMAPIEMONTE = "sisp";
	public static String PORTALE_RAPARPIEMONTE = "rupar";

	public static final boolean LIBRETTO_WEB_ABILITATO = true;

	//	private static java.util.ResourceBundle rb = java.util.ResourceBundle
	//			.getBundle("/META-INF/sigitwebn");

	public static String SESSIONE_VAR_MESSAGGE = "messaggio";
	public static String SESSIONE_VAR_ID_IMPIANTO = "idImpianto";
	public static String SESSIONE_VAR_ID_ALLEGATO = "idAllegato";
	public static String SESSIONE_VAR_ID_DOCUMENTO = "idDocumento";
	public static String SESSIONE_VAR_DOCUMENTO_SELEZIONATO = "documentoSelezionato";
	public static String SESSIONE_VAR_ID_IMPORT_DISTRIB = "idImportDistrib";
	public static String SESSIONE_VAR_UTENTE_LOGGATO = "appDatautenteLoggato";
	public static String SESSIONE_VAR_ACTION_PAGE_BACK = "actionPageBack";
	public static String SESSIONE_VAR_ELENCO_COD_IMPIANTI = "appDataelencoCodImpianto";
	public static String SESSIONE_VAR_ID_IMPIANTO_SELEZ = "appDataidImpiantoSelez";

	public static String SESSIONE_VAR_LIBRETTO_SCHEDA = "appDataLibrettoScheda";

	public static String SESSIONE_VAR_ALLEGATO_SEZIONE = "appDataAllegatoSezione";
	public static String SESSIONE_VAR_TOKEN = "downloadToken";

	//public static String SESSIONE_VAR_DETTAGLIO_ALLEGATO = "appDataallegato";

	public final static String MODOL_ENCODING = "UTF-8";

	public static String ESTENSIONE_XML = "XML";
	public static String ESTENSIONE_PDF = "PDF";

	public static final String SIGITEXT_PWD = "sigit.sigitext.password";
	public static final String SIGITEXT_UTENTE = "SIGIT";

	public static String ACTION_PAGE_ELENCO_ALLEGATI_IMPIANTO = "cpElencoAllegatiImpianti.do";
	public static String ACTION_PAGE_ELENCO_ALLEGATI = "cpElencoAllegati.do";

	public static String RETURN_PAGE_ELENCO_ALLEGATI_IMPIANTO_DA_PDF = "./cpElencoAllegatiImpianti.do";
	public static String RETURN_PAGE_ELENCO_ALLEGATI_DA_PDF = "./cpRisultatoRicercaAllegati.do";
	public static String RETURN_PAGE_ELENCO_ALLEGATI_IMPIANTO_ISP_DA_PDF = "./cpElencoIspezioniImpianti.do";

	public static String SESSIONE_VAR_DETT_ALLEGATO = "dettaglioAllegatoSsn";

	public static String ARRIVO_DA_MENU = "MENU";
	public static String ARRIVO_DA_IMPIANTO = "IMPIANTO";
	public static String ARRIVO_DA_ALLEGATI = "ALLEGATI";
	public static String ARRIVO_DA_IMPIANTO_ISP = "IMPIANTO_ISP";
	public static String ARRIVO_DA_GESTIONE_3RESP = "GESTIONE_3RESP";

	public static String ALLEGATO2_DA_MODOL = "2";
	public static String ALLEGATO3_DA_MODOL = "3";
	public static String ALLEGATO4_DA_MODOL = "4";
	public static String ALLEGATO5_DA_MODOL = "5";

	public static final String COPERTINA_PLACEHOLDER_COMUNE = "{{comune}}";
	public static final String COPERTINA_PLACEHOLDER_APERTA_AL = "{{aperta_al}}";
	public static final String COPERTINA_PLACEHOLDER_CHIUSA_AL = "{{chiusa_al}}";
	public static final String COPERTINA_PLACEHOLDER_DESCRIZIONE = "{{descrizione}}";
	public static final String COPERTINA_PLACEHOLDER_ASSEGNATARIO = "{{assegnatario}}";
	public static final String COPERTINA_PLACEHOLDER_N_PRATICA = "{{n_pratica}}";

	public static final String LETTERA_AVVISO_PLACEHOLDER_DATI_TERZO_RESP = "{{dati_terzo_resp}}";
	public static final String LETTERA_AVVISO_PLACEHOLDER_VIA_TERZO_RESP = "{{via_terzo_resp}}";
	public static final String LETTERA_AVVISO_PLACEHOLDER_CAP_TERZO_RESP = "{{cap_terzo_resp}}";
	public static final String LETTERA_AVVISO_PLACEHOLDER_EMAIL_TERZO_RESP = "{{email_terzo_resp}}";

	public static final String LETTERA_AVVISO_PLACEHOLDER_DATI_RESP = "{{dati_responsabile}}";
	public static final String LETTERA_AVVISO_PLACEHOLDER_VIA_RESP = "{{via_responsabile}}";
	public static final String LETTERA_AVVISO_PLACEHOLDER_CAP_RESP = "{{cap_responsabile}}";
	public static final String LETTERA_AVVISO_PLACEHOLDER_EMAIL_RESP = "{{email_responsabile}}";

	public static final String LETTERA_AVVISO_PLACEHOLDER_DATI_PC = "{{dati_pc}}";
	public static final String LETTERA_AVVISO_PLACEHOLDER_VIA_PC = "{{via_pc}}";
	public static final String LETTERA_AVVISO_PLACEHOLDER_CAP_PC = "{{cap_pc}}";
	public static final String LETTERA_AVVISO_PLACEHOLDER_EMAIL_PC = "{{email_pc}}";

	public static final String LETTERA_AVVISO_PLACEHOLDER_ANNO_GAU = "{{anno_gau}}";
	public static final String LETTERA_AVVISO_PLACEHOLDER_CODICE_IMPIANTO = "{{codice_impianto}}";
	public static final String LETTERA_AVVISO_PLACEHOLDER_INDIRIZZO_IMPIANTO = "{{indirizzo_impianto}}";
	public static final String LETTERA_AVVISO_PLACEHOLDER_DATA_ISPEZIONE = "{{data_ispezione}}";
	public static final String LETTERA_AVVISO_PLACEHOLDER_ORA_ISPEZIONE = "{{ora_ispezione}}";

	/** The mail host. */
	public static String MAIL_HOST = "mail.host";

	/** The mail port. */
	public static String MAIL_PORT = "mail.port";
	public static String MAIL_USER = "mail.user";
	public static String MAIL_PWD = "mail.pwd";

	public static final long COD_ID_PIEMONTE = 1l;
	public static final String COD_ISTAT_PIEMONTE = "001";

	//CODICE APPLICATIVO IRIDE
	public static final String CODICE_APPLICATIVO_IRIDE = "SIGITWEB";

	//CODICE APPLICATIVO MDP
	public static final String CODICE_APPLICATIVO_MDP = "SIGIT";

	// FLAG SI
	public static String SI = "S";

	// FLAG NO
	public static String NO = "N";

	// FLAG SI
	public static int SI_1 = 1;

	// FLAG NO
	public static int NO_0 = 0;

	// FLAG NC
	public static int NC_2 = 2;

	//public static BigDecimal BD_NO_0 = new BigDecimal(Constants.NO_0);

	// LABEL SI
	public static String LABEL_SI = "Si";

	// LABEL NO
	public static String LABEL_NO = "No";

	// LABEL OK
	public static String LABEL_OK = "OK";

	// LABEL KO
	public static String LABEL_KO = "KO";

	// LABEL NO
	public static String LABEL_NC = "Nc";

	// LABEL PG
	public static String LABEL_PG = "PG";

	// LABEL PF
	public static String LABEL_PF = "PF";

	// LABEL A
	public static String FLAG_ACCREDITATO_A = "A";

	// LABEL D
	public static String FLAG_ACCREDITATO_D = "D";

	// LABEL A
	public static String LABEL_ACCREDITATO_A = "Accreditato";

	// LABEL D
	public static String LABEL_ACCREDITATO_D = "Delegato";

	// FLAX X
	public static String FLAG_X = "X";

	public static String LABEL_ND = "ND";

	public static final Integer ID_INDIRIZZO_VUOTO = 0;

	public static final int COD_IMPIANTO_VUOTO = 0;

	public static final int ID_TIPO_CONFERMA_CONCLUDI = 1;
	public static final int ID_TIPO_CONFERMA_ASSOCIA = 2;
	public static final int ID_TIPO_CONFERMA_ASSOCIA_IMP = 3;

	// RUOLI APPLICATIVO
	// RUOLO TITOLARE CF
	public static String RUOLO_TITOLARE_CF = "TITOLARE_CF";

	// RUOLO RESPONSABILE
	public static final String RUOLO_RESPONSABILE = "RESPONSABILE";

	// RUOLO RESPONSABILE IMPRESA
	public static final String RUOLO_RESPONSABILE_IMPRESA = "RESPONSABILE IMPRESA/ENTE";

	// RUOLO RESPONSABILE IMPRESA
	public static final String RUOLO_PROPRIETARIO_IMPRESA = "PROPRIETARIO IMPRESA/ENTE";

	// RUOLO 3RESPONSABILE
	public static final String RUOLO_3RESPONSABILE = "3RESPONSABILE";

	// RUOLO INSTALLATORE
	//public static final String RUOLO_INSTALLATORE = "INSTALLATORE";

	//RUOLO CARICATORE (ex INSTALLATORE)
	public static final String RUOLO_CARICATORE = "CARICATORE";

	// RUOLO MANUTENTORE
	//public static String RUOLO_MANUTENTORE = "MANUTENTORE";

	// RUOLO IMPRESA (ex MANUTENTORE)
	public static final String RUOLO_IMPRESA = "IMPRESA";

	// RUOLO AMMINISTRATORE
	public static final String RUOLO_AMMINISTRATORE = "AMMINISTRATORE";

	// RUOLO PROPRIETARIO
	public static final String RUOLO_PROPRIETARIO = "PROPRIETARIO";

	// RUOLO OCCUPANTE
	public static final String RUOLO_OCCUPANTE = "OCCUPANTE";

	// RUOLO DISTRIBUTORE
	public static final String RUOLO_DISTRIBUTORE = "DISTRIBUTORE";

	// RUOLO CAT
	public static final String RUOLO_CAT = "SOGG. DELEGATO";

	// RUOLI CAT
	public static final String CAT_RUOLO_PREFISSO = "SOGG. DELEGATO per ";

	// RUOLO INSTALLATORE
	//	public static final String CAT_RUOLO_INSTALLATORE = CAT_RUOLO_PREFISSO + RUOLO_INSTALLATORE;

	// RUOLO MANUTENTORE
	//	public static String CAT_RUOLO_MANUTENTORE = CAT_RUOLO_PREFISSO + RUOLO_MANUTENTORE;

	// RUOLO IMPRESA (ex MANUTENTORE)
	public static final String CAT_RUOLO_IMPRESA = CAT_RUOLO_PREFISSO + RUOLO_IMPRESA;

	// RUOLO RESPONSABILE IMPRESA
	public static final String CAT_RUOLO_RESPONSABILE_IMPRESA = CAT_RUOLO_PREFISSO + RUOLO_RESPONSABILE_IMPRESA;

	// RUOLO 3RESPONSABILE
	public static final String CAT_RUOLO_3RESPONSABILE = CAT_RUOLO_PREFISSO + RUOLO_3RESPONSABILE;

	// RUOLO DISTRIBUTORE
	public static final String CAT_RUOLO_DISTRIBUTORE = CAT_RUOLO_PREFISSO + RUOLO_DISTRIBUTORE;

	// RUOLI IRIDE
	// RUOLO SUPER
	//	public static final String RUOLO_SUPER = "SUPER";
	public static final String RUOLO_SUPER = "SUPERUSER";

	// RUOLO VALIDATORE
	public static final String RUOLO_VALIDATORE = "VALIDATORE";

	// RUOLO ISPETTORE
	public static final String RUOLO_ISPETTORE = "ISPETTORE";

	// RUOLO CONSULTATORE
	public static final String RUOLO_CONSULTATORE = "CONSULTATORE";

	//FILTRO RUOLI VISUALIZZA TUTTO
	public static final String RIMUOVI_FILTRO_RUOLO = "Annulla / Nessun Filtro";

	// RUOLO CONSULTATORE ID ALLEGATO TIPO 1
	//	public static String RUOLO_MANUTENTORE_ALL_1 = "MANUTENTORE - ALLEGATO TIPO 1";
	//
	//	// RUOLO CONSULTATORE ALLEGATO TIPO 2
	//	public static String RUOLO_MANUTENTORE_ALL_2 = "MANUTENTORE - ALLEGATO TIPO 2";
	//
	//	// RUOLO CONSULTATORE ALLEGATO TIPO 3
	//	public static String RUOLO_MANUTENTORE_ALL_3 = "MANUTENTORE - ALLEGATO TIPO 3";
	//
	//	// RUOLO CONSULTATORE ALLEGATO TIPO 4
	//	public static String RUOLO_MANUTENTORE_ALL_4 = "MANUTENTORE - ALLEGATO TIPO 4";

	// ID RUOLO TITOLARE CF
	//public static int ID_RUOLO_TITOLARE_CF = "TITOLARE_CF";

	// ID RUOLO RESPONSABILE
	//public final static int ID_RUOLO_RESPONSABILE = 88;

	// ID RUOLO INSTALLATORE
	public final static int ID_RUOLO_CARICATORE = 3;

	// ID RUOLO MANUTENTORE
	//public final static int ID_RUOLO_MANUTENTORE = 3;

	// ID RUOLO AMMINISTRATORE
	public final static int ID_RUOLO_AMMINISTRATORE = 13;

	// ID RUOLO ISPETTORE
	public final static int ID_RUOLO_ISPETTORE = 2;

	// ID RUOLO PROPRIETARIO
	public final static int ID_RUOLO_PROPRIETARIO = 4;

	// ID RUOLO MANUTENTORE
	public final static int ID_RUOLO_MANUTENTORE_ALL_1 = 6;
	public final static int ID_RUOLO_MANUTENTORE_ALL_2 = 7;
	public final static int ID_RUOLO_MANUTENTORE_ALL_3 = 8;
	public final static int ID_RUOLO_MANUTENTORE_ALL_4 = 9;

	// ID RUOLO 3RESPONSABILE
	//	public final static int ID_RUOLO_3RESPONSABILE = 99;

	public final static int ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO = 10;
	public final static int ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE = 11;
	public final static int ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE = 12;

	// ID RUOLO ISPETTORE VALIDATORE
	public final static int ID_RUOLO_ISPETTORE_VALIDATORE = 14;

	// ID RUOLO PROPRIETARIO PROPRIETARIO
	public final static int ID_RUOLO_PROPRIETARIO_PROPRIETARIO = 15;

	// ID RUOLO PROPRIETARIO PROPRIETARIO
	public final static int ID_RUOLO_PROPRIETARIO_PROPRIETARIO_IMPRESA = 16;

	// ID RUOLO OCCUPANTE
	public final static int ID_RUOLO_OCCUPANTE = 5;

	// ID RUOLO PA
	public final static int ID_RUOLO_PA_CONSULTATORE = 1;
	public final static int ID_RUOLO_PA_ISPETTORE = 2;
	public final static int ID_RUOLO_PA_SUPERUSER = 3;
	public final static int ID_RUOLO_PA_VALIDATORE = 4;

	public final static String COD_REA_ISPETTORE = "RP-000000";

	// ID RUOLO VALIDATORE
	public final static int ID_PG_RUOLO_ISPETTORE = -3;
	public final static int NUM_COD_IMPIANTO_ISPETTORE = 1;
	public final static int NUM_BOLLINO_ISPETTORE = 1;

	public final static String ID_TUTTE = "-1";
	public final static String DESC_TUTTE = "TUTTE";
	public final static String DESC_TUTTI = "TUTTI";

	public final static String ID_ALTRO = "-1";
	public final static String DESC_ALTRO = "Altro";

	public final static String DESC_PG_RUOLO_ISPETTORE = "ENTE ISPETTORE";

	public final static String DESC_ISPEZIONE = "ISPEZIONE";

	public static final String INTERVAL_BLANK = " ";

	public static final String INTERVAL_SEP = "-";

	public static final String INTERVAL_SEP_HASH = "#";

	public static final String INTERVAL_SEP_CHIAVI = "_";

	public static final String INTERVAL_SEP_SLASH = "/";

	public static final String INTERVAL_SEP_VIRCOLA = ",";

	public final static String VALUE_ENTER_HTML = "<BR>";
	public final static String VALUE_ENTER_TXT = "\n";

	/** The Constant DIVIDE_IDS. */
	public static final String DIVIDE_IDS = "@";

	public static final String COD_STATO_VIA_VALIDA = "V";
	public static final String COD_STATO_VIA_QUALSIASI = "A";
	public static final String DESC_STATO_VIA_DEPRECATO = "deprecato";

	// ID RUOLO PROPRIETARIO
	public final static int ID_STATO_IMP_VALIDO = 1;
	public final static int ID_STATO_IMP_DISMESSO = 2;
	public final static int ID_STATO_IMP_SOSPESO = 3;
	public final static int ID_STATO_IMP_CHIUSO = 4;

	public static final String MOTIVAZIONE_STATO_IMPIANTO_DEFAULT = "primo caricamento";
	public static final String MOTIVAZIONE_ANNULLA_MANUTENZIONE = "manutenzione respinta dall'utente";

	public static final String CF_INSERTAUTOMATICO = "INSERTAUTOMATICO";

	// CHIAVI PRESENTI NELLA TABELLA SIGIT_WRK_CONFIG
	public static final String MAX_RIGHE = "MAX_RIGHE";
	public static final String MAX_RIGHE_ACQUISISCI_CODICE = "MAX_RIGHE_ACQUISISCI_CODICE";
	public static final String MAX_RIGHE_RIC_AVANZATA_IMPIANTI = "MAX_RIGHE_RIC_AVZ_IMP";
	public static final String MULTIPLO_QUANTITA_ACUISIZIONE_CODICI = "MCM_QTACOD_IMPIANTI_X_TRANSAZIONE";
	public static final String MAX_QUANTITA_ACUISIZIONE_CODICI = "MAX_COD_IMPIANTI_X_TRANSAZIONE";
	public static final String MAX_QTA_BOLLINO_X_TUTTE_FASCE = "MAX_QTA_BOLLINO_X_TUTTE_FASCE";
	public static final String MAX_MB_DOC = "MAX_MB_DOC";
	public static final String DATA_MAX_INST_VALVOLE = "DATA_MAX_INST_VALVOLE";
	public static final String FORMATI_DOCUMENTI_REE_AMMESSI = "FORMATI_DOCUMENTI_REE_AMMESSI";

	public static final String WEB_MAIL_IND_MITT = "WEB_MAIL_IND_MITT";
	public static final String CIT_SIGITWEBN_SERVIZIO_ATTIVO = "CIT_SIGITWEBN_SERVIZIO_ATTIVO";
	public static final String CIT_UTENTI_AUTORIZZATI = "CIT_UTENTI_AUTORIZZATI";
	public static final String CIT_ACCERTAMENTO_AUTOMATICO_IMP_NON_SICURO = "CIT_ACCERTAMENTO_AUTOMATICO_IMP_NON_SICURO";

	public static final String DESC_TABELLA_COMBUSTIBILE = "Combustibile";
	public static final String DESC_TABELLA_UNITA_MISURA = "Unita di Misura";
	public static final String DESC_TABELLA_MARCA = "Marca";
	public static final String DESC_TABELLA_FLUIDO = "Fluido";

	// FLAG Installato in U.T.A. o V.M.C.
	public static int ID_TIPO_INST_INSTALLATO = 1;

	// FLAG Indipendente
	public static int ID_TIPO_INST_INDIPENDENTE = 2;

	// LABEL SI
	public static String DESC_TIPO_INST_INSTALLATO = "Installato in U.T.A. o V.M.C.";

	// LABEL NO
	public static String DESC_TIPO_INST_INDIPENDENTE = "Indipendente";

	public static String DESC_TUTTE_COMP_VERIFICATE = "Le componenti risultano verificate";

	public static String DESC_CARICAMENTO_MANUALE = "caricamento manuale fornitura";

	public final static int DATO_NON_DISPONIBILE = 0;
	public final static String DATO_NON_DISPONIBILE_S = "0";

	public final static String INDIRIZZO_CARICATO_PWA = "-1";

	/**
	 * Codice Casistiche
	 */
	public final static int COD_CASO_A = 1;
	public final static int COD_CASO_B = 2;
	public final static int COD_CASO_C = 3;
	public final static int COD_CASO_D = 4;
	public final static int COD_CASO_E = 5;
	public final static int COD_CASO_F = 6;//da ricerca avanzata

	public final static int COD_OP_INS_RESPONSABILE = 1;
	public final static int COD_OP_MOD_RESPONSABILE = 2;
	/**
	 * Lunghezza di un codice fiscale
	 */
	public final static int CODICE_FISCALE_LEN = 16;
	/**
	 * Lunghezza massima di un numero REA
	 */
	public final static int MAX_NUMERO_REA_LEN = 11;
	/**
	 * Lunghezza massima di un numero bollino
	 */
	public final static int MAX_NUMERO_BOLLINO_LEN = 11;
	/**
	 * Lunghezza massima di un codice impianto
	 */
	public final static int MAX_CODICE_IMPIANTO_LEN = 11;
	/**
	 * Lunghezza massima di un codice impianto
	 */
	public final static int MAX_MOTIVAZIONE_IMPIANTO_LEN = 500;

	/**
	 * Lunghezza massima
	 */
	public final static int MAX_2030_LEN = 2030;

	/**
	 * Lunghezza minima di un indirizzo
	 */
	public final static int MIN_INDIRIZZO_LEN = 3;

	/**
	 * Lunghezza minima di una denominazione
	 */
	public final static int MIN_DENOMINAZIONE_LEN = 3;

	/**
	 * Lunghezza minima di un comune
	 */
	public final static int MIN_DES_COMUNE_LEN = 2;

	/**
	 * Lunghezza minima di una matricola
	 */
	public final static int MIN_MATRICOLA_LEN = 3;

	/**
	 * Lunghezza massima di un nome file import
	 */
	public final static int MAX_NOME_FILE_LEN = 50;

	/**
	 * Lunghezza massima di un numero REA
	 */
	public final static int MAX_NUMERO_NON_PAGINATO = 4;

	public final static int MAX_1000_LEN = 1000;

	/**
	 * Espressione regolare per il codice fiscale (comprese le omocodie)
	 */
	public static final String CODICE_FISCALE = "[a-zA-Z]{6}[\\dlmnpqrstuvLMNPQRSTUV]{2}[abcdehlmprstABCDEHLMPRST][\\dlmnpqrstuvLMNPQRSTUV]{2}[a-zA-Z][\\dlmnpqrstuvLMNPQRSTUV]{3}[a-zA-Z]";

	/**
	 * Espressione regolare per la data
	 */
	public static final String DATA = "^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((1[6-9]|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$";

	/**
	 * Lunghezza di una partita IVA
	 */
	public static final int PARTITA_IVA_LEN = 11;
	/**
	 * Espressione regolare per la partita IVA
	 */
	public static final String PARTITA_IVA = "[0-9]{11}";

	/**
	 * Espressione regolare per il CAP
	 */
	public static final String CAP = "[0-9]{5}";
	/**
	 * Partita IVA farlocca
	 */
	public static final String PARTITA_IVA_DUMMY = "00000000000";

	//	public static final String POD = "IT[0-9]{3}[a-zA-Z]{1}[0-9]+";

	//	I primi due caratteri devono essere "IT"
	//	I successivi 3 devono essere cifre
	//	il successivo carattere deve essere "E"
	//	i successivi caratteri devono essere cifre (fino a raggiungere i 14/15 caratteri)
	public static final String POD = "IT[0-9]{3}[E]{1}[0-9a-zA-Z]+";

	//	public static final String PDR = "[0-9]+";
	//	Il campo deve essere composto di 14 cifre
	public static final String PDR = "[0-9]{14}";

	public static final String TIPO_OPERAZIONE_DB_DELETE = "DELETE";

	public static final String XML_IMPORT_SCHEMA_DIR = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
	public static final String FILE_IMPORT_ALLEGATO_II = "Import-AllegatoII-1.0.3.xsd";
	public static final String FILE_IMPORT_ALLEGATO_IIB = "Import-AllegatoIIB-1.0.2.xsd";
	public static final String FILE_IMPORT_ALLEGATO_III = "Import-AllegatoIII-1.0.3.xsd";
	public static final String FILE_IMPORT_ALLEGATO_IV = "Import-AllegatoIV-1.0.2.xsd";
	public static final String FILE_IMPORT_ALLEGATO_V = "Import-AllegatoV-1.0.2.xsd";
	public static final String FILE_IMPORT_MANUT_GT = "Import-ManutenzioneGT-1.0.0.xsd";
	public static final String FILE_IMPORT_MANUT_GF = "Import-ManutenzioneGF-1.0.0.xsd";
	public static final String FILE_IMPORT_MANUT_SC = "Import-ManutenzioneSC-1.0.0.xsd";
	public static final String FILE_IMPORT_MANUT_CG = "Import-ManutenzioneCG-1.0.0.xsd";
	public static final String XML_IMPORT_ALLEGATO_II_SCHEMA_DIR = XML_IMPORT_SCHEMA_DIR + FILE_IMPORT_ALLEGATO_II;
	public static final String XML_IMPORT_ALLEGATO_IIB_SCHEMA_DIR = XML_IMPORT_SCHEMA_DIR + FILE_IMPORT_ALLEGATO_IIB;
	public static final String XML_IMPORT_ALLEGATO_III_SCHEMA_DIR = XML_IMPORT_SCHEMA_DIR + FILE_IMPORT_ALLEGATO_III;
	public static final String XML_IMPORT_ALLEGATO_IV_SCHEMA_DIR = XML_IMPORT_SCHEMA_DIR + FILE_IMPORT_ALLEGATO_IV;
	public static final String XML_IMPORT_ALLEGATO_V_SCHEMA_DIR = XML_IMPORT_SCHEMA_DIR + FILE_IMPORT_ALLEGATO_V;
	public static final String XML_IMPORT_MANUT_GT_SCHEMA_DIR = XML_IMPORT_SCHEMA_DIR + FILE_IMPORT_MANUT_GT;
	public static final String XML_IMPORT_MANUT_GF_SCHEMA_DIR = XML_IMPORT_SCHEMA_DIR + FILE_IMPORT_MANUT_GF;
	public static final String XML_IMPORT_MANUT_SC_SCHEMA_DIR = XML_IMPORT_SCHEMA_DIR + FILE_IMPORT_MANUT_SC;
	public static final String XML_IMPORT_MANUT_CG_SCHEMA_DIR = XML_IMPORT_SCHEMA_DIR + FILE_IMPORT_MANUT_CG;

	public static final String CODICE_APPLICAZIONE_MODOL = "SIGIT";
	public static final String CODICE_MODULO_MODOL_LIBRETTO = "MODULOsigit-v2.1.0";
	//	public static final String CODICE_MODULO_MODOL_LIBRETTO = "MODULOsigit-TEST";
	public static final String CODICE_MODULO_MODOL_LIBRETTO_LIGHT = "MODULOsigitLight-v1.0.0";
	public static final String CODICE_MODULO_MODOL_ALLEGATO_II = "MODULOsigit-AllegatoII-v1.1.0";
	public static final String CODICE_MODULO_MODOL_ALLEGATO_III = "MODULOsigit-AllegatoIII-v1.1.0";
	public static final String CODICE_MODULO_MODOL_ALLEGATO_IV = "MODULOsigit-AllegatoIV-v1.0.0";
	public static final String CODICE_MODULO_MODOL_ALLEGATO_V = "MODULOsigit-AllegatoV-v1.1.0";
	public static final String CODICE_MODULO_MODOL_RICEVUTA_ALLEGATO = "MODULOsigit-RicevutaAllegato";
	public static final String CODICE_MODULO_MODOL_RICEVUTA_IMPORT_DISTRIB = "MODULOsigit-RicevutaImportDistrib";

	public static final String CODICE_FONTE_AAEP = "INFOC";
	public static final String DESC_SEDE_LEGALE = "SEDE LEGALE";

	public static final String AAEP_COD_NESSUN_RISULTATO = "Nessun record trovato";

	//public static final String CODICE_MODULO_MODOL = "ALL_G";//"MODELLOsigit-v1.0.0";
	public static final String STATO_MODULO_BOZZA = "BOZZA";
	public static final String STATO_MODULO_DEFINITIVO = "DEFINITIVO";

	public static final int NUMERO_DECIMALI = 2;

	public static final int ID_POTENZA_MINORE_35 = 1;
	public static final int ID_POTENZA_35_116 = 2;
	public static final int ID_POTENZA_116_350 = 3;
	public static final int ID_POTENZA_MAGGIORE_350 = 4;

	public static final int ID_TIPO_PAGAMENTO_CC = 1;
	public static final int ID_TIPO_PAGAMENTO_GRATUITO = 3;

	public static final String DESC_TIPO_PAGAMENTO_CC = "Carta di credito";
	public static final String DESC_VALUTA_PAGAMENTO_EUR = "EUR";

	public static final String STATO_TRANSAZIONE_INIZIALIZED = "1";
	public static final String STATO_TRANSAZIONE_STARTED = "3";
	public static final int TRANSAZIONE_MDP_INIZIALIZED = 1;
	public static final int TRANSAZIONE_MDP_STARTED = 3;
	public static final int TRANSAZIONE_MDP_OK = 4;
	public static final int TRANSAZIONE_MDP_KO = 5;
	public static final int TRANSAZIONE_MDP_ABORT = 6;

	public static final String SIGLA_BOLLINO_RP = "RP";

	//	public static final String DESC_POTENZA_MINORE_35 = "Potenza minore di 35 KW kW";
	//	public static final String DESC_POTENZA_35_116 = 2;
	//	public static final String DESC_POTENZA_116_350 = 3;
	//	public static final String DESC_POTENZA_MAGGIORE_350 = 4;

	/**
	 * Valore assunto da una check spuntata
	 */
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	public static final int PUO_FUNZIONARE_TRUE = 1;
	public static final int PUO_FUNZIONARE_FALSE = 0;

	public static final Integer ID_STATO_LIBRETTO_BOZZA = 1;
	public static final Integer ID_STATO_LIBRETTO_CONSOLIDATO = 2;
	public static final Integer ID_STATO_LIBRETTO_STORICIZZATO = 3;

	public static final int ID_STATO_BOZZA = 1;
	public static final int ID_STATO_CONSOLIDATO = 2;
	public static final int ID_STATO_STORICIZZATO = 3;

	public static final java.math.BigDecimal ID_TIPO_INT_NON_VALORIZZATO = java.math.BigDecimal.ZERO;
	public static final int ID_TIPO_INT_NUOVA_INSTALZ = 1;
	public static final int ID_TIPO_INT_RISTRUTTURAZ = 2;
	public static final int ID_TIPO_INT_SOSTITUZIONE = 3;
	public static final int ID_TIPO_INT_COMPILAZIONE = 4;

	public static final int ID_TIPO_DOC_LIBRETTO = 7;

	public static final int ID_TIPO_MANUTENZIONE_ALTRO = 3;
	public static final int ID_TIPO_MANUTENZIONE_REE = 99;
	public static final int ID_TIPO_MANUTENZIONE_NESSUNA = 0;

	public static final int ID_MOTIVO_CONSOLIDAMENTO_ESP_UTENTE = 1;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO = 2;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_RESP_RAPP_CONTROLLO = 3;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_NOMINA_3_RESP = 4;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_REVOCA_3_RESP = 5;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_SUBENTRO_RESP = 6;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_ISP_SOST_ACCERT = 7;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_COMP_SCHEDA_1_14 = 8;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_CARICAMENTO_ISP = 9;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_ANNULLAMENTO_ISP = 10;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_CARICAMENTO_MANUT = 11;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_ANNULLAMENTO_MANUT = 12;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_PROROGA_3_RESP = 13;

	public static final String ID_UNITA_IMMOB_CATEGORIA_E1 = "E.1";
	public static final String ID_UNITA_IMMOB_CATEGORIA_E2 = "E.2";
	public static final String ID_UNITA_IMMOB_CATEGORIA_E3 = "E.3";
	public static final String ID_UNITA_IMMOB_CATEGORIA_E4 = "E.4";
	public static final String ID_UNITA_IMMOB_CATEGORIA_E5 = "E.5";
	public static final String ID_UNITA_IMMOB_CATEGORIA_E6 = "E.6";
	public static final String ID_UNITA_IMMOB_CATEGORIA_E7 = "E.7";
	public static final String ID_UNITA_IMMOB_CATEGORIA_E8 = "E.8";

	public static final String TIPO_COMPONENTE_GT = "GT";
	public static final String TIPO_COMPONENTE_GF = "GF";
	public static final String TIPO_COMPONENTE_SC = "SC";
	public static final String TIPO_COMPONENTE_CS = "CS";
	public static final String TIPO_COMPONENTE_CG = "CG";
	public static final String TIPO_COMPONENTE_AG = "AG";
	public static final String TIPO_COMPONENTE_BR = "BR";
	public static final String TIPO_COMPONENTE_RC = "RC";
	public static final String TIPO_COMPONENTE_SR = "SR";
	public static final String TIPO_COMPONENTE_VR = "VR";
	public static final String TIPO_COMPONENTE_PO = "PO";
	public static final String TIPO_COMPONENTE_AC = "AC";
	public static final String TIPO_COMPONENTE_TE = "TE";
	public static final String TIPO_COMPONENTE_RV = "RV";
	public static final String TIPO_COMPONENTE_SCX = "SCX";
	public static final String TIPO_COMPONENTE_CI = "CI";
	public static final String TIPO_COMPONENTE_UT = "UT";
	public static final String TIPO_COMPONENTE_RCX = "RCX";
	public static final String TIPO_COMPONENTE_VM = "VM";
	public static final String TIPO_COMPONENTE_VX = "VX";

	public static final String FLG_ACQUA = "ACQUA";
	public static final String FLG_ARIA = "ARIA";

	public static final String FLG_RISCALDAMENTO = "RIS";
	public static final String FLG_RAFFREDDAMENTO = "RAF";

	public static final String FLG_5_4_TIPOLOGIA_DIRETTO = "D";
	public static final String FLG_5_4_TIPOLOGIA_INDIRETTO = "I";

	public static final String ID_DETT_GF_ASS_REC_CALORE = "1";
	public static final String ID_DETT_GF_ASS_FIAMM_COMB = "2";
	public static final String ID_DETT_GF_CICLO_COMPRESS = "3";

	public static final String ID_DETT_GT_GRUPPO_TERM_SING = "1";
	public static final String ID_DETT_GT_GRUPPO_TERM_MOD = "2";
	public static final String ID_DETT_GT_TUBO_RADIANTE = "3";
	public static final String ID_DETT_GT_GEN_ARIA_CALDA = "4";

	public static final int ID_STATO_RAPPORTO_BOZZA = 0;
	public static final int ID_STATO_RAPPORTO_INVIATO = 1;
	public static final int ID_STATO_RAPPORTO_RESPINTO = 2;

	public static final String DESC_STATO_RAPPORTO_BOZZA = "Bozza";
	public static final String DESC_STATO_RAPPORTO_INVIATO = "Inviato";
	public static final String DESC_STATO_RAPPORTO_RESPINTO = "Respinto";

	public static final int ID_STATO_ISPEZIONE_BOZZA = 1;
	public static final int ID_STATO_ISPEZIONE_CONSOLIDATO = 2;
	public static final int ID_STATO_ISPEZIONE_ANNULLATO = 3;

	public static final String DESC_STATO_ISPEZIONE_BOZZA = "Bozza";
	public static final String DESC_STATO_ISPEZIONE_CONSOLIDATO = "Consolidato";
	public static final String DESC_STATO_ISPEZIONE_ANNULLATO = "Annullato";

	public static final int ID_STATO_SANZIONE_BOZZA = 1;
	public static final int ID_STATO_SANZIONE_COMUNICATA = 2;
	public static final int ID_STATO_SANZIONE_PAGATA = 3;
	public static final int ID_STATO_SANZIONE_ANNULLATA = 4;

	public static final int ID_STATO_IMP_DISTRIBUTORE_DA_ELABORARE = 1;
	public static final int ID_STATO_IMP_DISTRIBUTORE_INVIATO = 2;
	public static final int ID_STATO_IMP_DISTRIBUTORE_RIFIUTATO = 3;
	public static final int ID_STATO_IMP_DISTRIBUTORE_SOSTITUITO = 4;
	public static final int ID_STATO_IMP_DISTRIBUTORE_ELIMINATO = 5;

	public static final int ID_STATO_IMPRESA_ATTIVA = 1;
	public static final int ID_STATO_IMPRESA_CESSATA = 2;
	public static final int ID_STATO_IMPRESA_SOSPESA = 3;
	public static final int ID_STATO_IMPRESA_RADIATA = 4;

	public static final String DESC_ESITO_POSITIVO = "POSITIVO";
	public static final String DESC_ESITO_NEGATIVO = "NEGATIVO";

	public static final int ID_ESITO_POSITIVO = 1;
	public static final int ID_ESITO_NEGATIVO = 2;

	// Parametri di configurazione di INDEX
	public static final String INDEX_USERNAME_ADMIN = "admin@sigit";
	public static final String INDEX_USERNAME_READ = "sigit@sigit";
	public static final String INDEX_PSW = "sigit";
	public static final String INDEX_UTENTE = "Utente Sigit";
	public static final String INDEX_FRUITORE = "sigit";
	public static final String INDEX_FRUITORE_DISTRIBUTORE = "distributori";
	public static final String INDEX_REPOSITORY = "primary";
	public static final String INDEX_DEFAULT_PREFIX = "cm:";
	public static final String INDEX_PREFIX = "sigit:";
	public static final String INDEX_PREFIX_NAME = "cm:content";
	public static final String INDEX_PREFIX_MODEL = "cm:contentmodel";
	public static final String INDEX_SIGIT_PREFIX_MODEL = "sigit:sigitContent";
	public static final String INDEX_DISTRIBUTORI_PREFIX_MODEL = "distributori:distributoriContent";
	public static final String INDEX_PREFIX_FOLDER = "cm:folder";
	public static final String INDEX_PREFIX_NAME_SHORT = "cm:name";
	public static final String INDEX_PREFIX_CONTAINS = "cm:contains";
	public static final String INDEX_ROOT = "/app:company_home";
	public static final String INDEX_ROOT_SIGIT = "/app:company_home/cm:sigit";
	public static final String INDEX_ROOT_DISTRIBUTORI = "/app:company_home/cm:distributori";
	public static final String INDEX_TYPE_TEXT = "d:text";
	public static final String INDEX_FOLDER_SUFFIX = "/cm:";
	public static final String INDEX_METADATO_SUFFIX = "@cm\\:";
	public static final String INDEX_NAME = "name:\"";
	public static final String INDEX_FOLDER_DOC = "doc";

	public static final String INDEX_FOLDER_ISPEZIONI = "ispezioni";
	public static final String INDEX_FOLDER_VERIFICHE = "verifiche";
	public static final String INDEX_FOLDER_ACCERTAMENTI = "accertamenti";
	public static final String INDEX_FOLDER_REE = "ree";
	public static final String INDEX_FOLDER_LIBRETTI = "libretti";

	public static final int INDEX_MAX_SIZE = 10048000;
	public static final String INDEX_ALLEGATO_NAME = "sigit:rapporto";
	public static final String INDEX_ENCODING = "UTF-8";

	public static final String INDEX_FILE_PREFIX_LIBRETTO = "Libretto";

	//TIPI ALLEGATI
	public static final String ALLEGATO_F = "1";
	public static final String ALLEGATO_G = "2";
	public static final String ALLEGATO_TIPO_1 = "3";
	public static final String ALLEGATO_TIPO_1B = "14";
	public static final String ALLEGATO_TIPO_2 = "4";
	public static final String ALLEGATO_TIPO_3 = "5";
	public static final String ALLEGATO_TIPO_4 = "6";
	public static final String RAPP_PROVA_ALLEGATO_TIPO_1 = "8";
	public static final String RAPP_PROVA_ALLEGATO_TIPO_2 = "9";
	public static final int MANUTENZIONE_GT = 10;
	public static final int MANUTENZIONE_GF = 11;
	public static final int MANUTENZIONE_SC = 12;
	public static final int MANUTENZIONE_CG = 13;

	public static final String DESC_ALLEGATO_TIPO_1 = "Tipo1";
	public static final String DESC_ALLEGATO_TIPO_2 = "Tipo2";
	public static final String DESC_ALLEGATO_TIPO_3 = "Tipo3";
	public static final String DESC_ALLEGATO_TIPO_4 = "Tipo4";
	public static final String DESC_ALLEGATO_RAPPROVA = "RAPPROVA";
	public static final String DESC_ALLEGATO_RAPPROVA_FIRMATO = "RAPFIRMA";

	public static final int FLAG_CONTROLLO_BOZZA_ALLEGATO_TRUE = 1;
	public static final int FLAG_CONTROLLO_BOZZA_ALLEGATO_FALSE = 0;

	public static final String TIPO_CONSUMO_CB = "14.1";
	public static final String TIPO_CONSUMO_EE = "14.2";
	public static final String TIPO_CONSUMO_H2O = "14.3";
	public static final String FLAG_VASO_APERTO = "A";
	public static final String FLAG_VASO_CHIUSO = "C";

	public static final String FLAG_ASSENTE = "A";
	public static final String FLAG_PRESENTE = "P";

	public static final String LABEL_ASSENTE = "Assente";
	public static final String LABEL_PRESENTE = "Presente";

	public static final String FLAG_EVACUAZIONE_FUMI_FORZATA = "F";
	public static final String FLAG_EVACUAZIONE_FUMI_NATURALE = "N";

	public static final String FLAG_MODALITA_RAFFRESCAMENTO = "RAF";
	public static final String FLAG_MODALITA_RISCALDAMENTO = "RIS";

	public static final String FLAG_REGOLARE = "R";
	public static final String FLAG_IRREGOLARE = "I";
	public static final String FLAG_NA = "N";

	public static final String RENDIMENTO_MINIMO_SI = "SI";
	public static final String RENDIMENTO_MINIMO_NO = "NO";

	public static final String FILTRI_PULITI_SI = "SI";
	public static final String FILTRI_PULITI_NO = "NO";

	public static final String VERIFICA_SUPERATA_SI = "SI";
	public static final String VERIFICA_SUPERATA_NO = "NO";

	public static final int ID_TIPO_CONTRATTO_3_RESP = 1;

	public static final String DES_DOC_TIPO_1 = "Tipo 1 (Allegato II, DM 10/02/2014)";
	public static final String DES_DOC_TIPO_2 = "Tipo 2 (Allegato III, DM 10/02/2014)";
	public static final String DES_DOC_TIPO_3 = "Tipo 3 (Allegato IV, DM 10/02/2014)";
	public static final String DES_DOC_TIPO_4 = "Tipo 4 (Allegato V, DM 10/02/2014)";

	public static final String PREFIX_NOME_XSD_IMPORT_ALL_II = "allegatoII_";
	public static final String PREFIX_NOME_XSD_IMPORT_ALL_IIB = "allegatoIIB_";
	public static final String PREFIX_NOME_XSD_IMPORT_ALL_III = "allegatoIII_";
	public static final String PREFIX_NOME_XSD_IMPORT_ALL_IV = "allegatoIV_";
	public static final String PREFIX_NOME_XSD_IMPORT_ALL_V = "allegatoV_";
	public static final String PREFIX_NOME_XSD_IMPORT_MANUT_GT = "manutGT_";
	public static final String PREFIX_NOME_XSD_IMPORT_MANUT_GF = "manutGF_";
	public static final String PREFIX_NOME_XSD_IMPORT_MANUT_SC = "manutSC_";
	public static final String PREFIX_NOME_XSD_IMPORT_MANUT_CG = "manutCG_";

	public static final String PREFIX_NOME_XSD_IMPORT_LIBRETTO = "libretto_";

	public static final String PAG_RIC_IMPIANTI = "RIC_IMP";
	public static final String PAG_RIS_RIC_IMPIANTI = "RIS_RIC_IMP";
	public static final String PAG_RIS_RIC_AVZ_IMPIANTI = "RIS_AVZ_IMP";
	public static final String PAG_ELEN_GRAFF = "ELEN_GRAF";
	public static final String PAG_GEST_IMPIANTI = "GEST_IMP";
	public static final String PAG_GEST_IMPIANTI_RESP = "GEST_IMP_RESP";
	public static final String PAG_GEST_ISPEZIONI = "GEST_ISP";

	public static final String PAG_ELENCO_ALL_IMPIANTI = "ELENCO_ALL_IMPIANTI";
	public static final String PAG_RIS_RIC_AVZ_ALLEGATI = "RIS_RIC_AVZ_ALLEGATI";

	public static final String PAG_ELENCO_VERIFICHE = "ELENCO_VERIFICHE";
	public static final String PAG_ELENCO_ISPEZIONI = "ELENCO_ISPEZIONI";
	public static final String PAG_SCHEDA_13 = "SCHEDA_13";
	public static final String PAG_ELENCO_ACCERTAMENTI = "ELENCO_ACCERTAMENTI";
	public static final String PAG_ELENCO_SVEGLIE = "ELENCO_SVEGLIE";

	public static final String DESC_MOTIVO_RESP_ALLEGATO_ISP = "Rapporto respinto per annullamento ispezione";

	public static final String COD_TIPO_IMPIANTO_CENTRALIZZATO = "C";
	public static final String COD_TIPO_IMPIANTO_AUTONOMO = "A";

	public static final String DESC_TIPO_IMPIANTO_CENTRALIZZATO = "Centralizzato";
	public static final String DESC_TIPO_IMPIANTO_AUTONOMO = "Autonomo";

	public static final String DESC_UNITA_UNICA = "Unica";
	public static final String DESC_UNITA_MULTIPLE = "Piu' unita";

	public static final int ID_TIPO_DOC_AGG_ISPEZIONI = 1;
	public static final int ID_TIPO_DOC_AGG_ALTRA_DOC = 2;

	public static final int ID_TIPO_DOC_ALTRO_DOC_ISPEZIONI = 3;
	public static final int ID_TIPO_DOC_ALTRO_DOC = 5;
	public static final int ID_TIPO_DOC_DEROGA = 4;

	public static final String DESC_STATO_DOC_ATTIVO = "ATTIVO";
	public static final String DESC_STATO_DOC_CANCELLATO = "CANCELLATO";

	public static final int MB_IN_BYTE = 1048576;

	public static final int ID_TIPO_INTERVENTO_ZERO = 0;

	public static final String LABEL_RIPRISTINA = "Riattiva";

	public static final String DESC_FLG_RAFFREDDAMENTO = "Raff";
	public static final String DESC_FLG_RISCALDAMENTO = "Risc";

	public static final String DESC_ASSENTE = "ASSENTE";
	public static final String DESC_FILTRAZIONE = "FILTRAZIONE";
	public static final String DESC_ADDOLCIMENTO = "ADDOLCIMENTO";
	public static final String DESC_CONDIZ_CHIMICO = "CONDIZ. CHIMICO";

	public static final String LABEL_SEZIONE_ABCDF = "Sezione A-B-C-D-F";
	public static final String LABEL_SEZIONE_E = "Sezione E";

	public static final String PREFIX_ID_NODO_TIPO_1_E = "F-tipo1E-";
	public static final String PREFIX_ID_NODO_TIPO_2_E = "F-tipo2E-";
	public static final String PREFIX_ID_NODO_TIPO_3_E = "F-tipo3E-";
	public static final String PREFIX_ID_NODO_TIPO_4_E = "F-tipo4E-";

	public static final String LABEL_SEZIONE_RP_DATI_GEN = "Dati generali";
	public static final String LABEL_SEZIONE_RP_GEN = "Sezione 1-2-3-4-5-10-11-12";
	public static final String LABEL_SEZIONE_RP_DET = "Sezione 6-7-8-9";

	public static final String PREFIX_ID_NODO_RP_DET = "F-DatiRPDett";

	public static final String LABEL_ANNULLATO = "Annullato";

	public static final int ID_TIPO_AZIONE_VERIFICA = 1;
	public static final int ID_TIPO_AZIONE_ACCERTAMENTO = 2;
	public static final int ID_TIPO_AZIONE_ISPEZIONE = 3;
	public static final int ID_TIPO_AZIONE_SANZIONE = 4;

	public final static int ID_STATO_ACCERTAMENTO_IN_CORSO = 1;
	public final static int ID_STATO_ACCERTAMENTO_CONCLUSO = 2;
	public final static int ID_STATO_ACCERTAMENTO_ANNULLATO = 3;

	//public static final String COD_FOGLIO_SCHEDA_1_0 = "F-scheda1_0";
	//public static final String COD_FOGLIO_SCHEDA_1 = "F-scheda1";

	// LABEL PRODUZIONE_ACS
	public static String LABEL_PRODUZIONE_ACS = "Produzione ACS";

	// LABEL RISCALDAMENTO_AMBIENTI
	public static String LABEL_RISCALDAMENTO_AMBIENTI = "Riscaldamento ambienti";

	public static final Integer ID_TIPO_CESSAZIONE_DECADENZA = 1;

	public final static int ID_FREQ_SEMESTRALE = 1;
	public final static int ID_FREQ_ANNUALE = 2;
	public final static int ID_FREQ_BIENNALE = 3;
	public final static int ID_FREQ_ALTRO = 4;

	public final static int ID_CLASS_DPR660_96_STANDARD = 1;
	public final static int ID_CLASS_DPR660_96_BASSA_TEMP = 2;
	public final static int ID_CLASS_DPR660_96_GAS_CONDENS = 3;

	// LABEL COMBOBOX PROVINCE E COMUNI
	public final static String LABEL_ABILITA_SU_TUTTE_PROVINCE = "Tutte le province";
	public final static String LABEL_ABILITA_SU_TUTTI_COMUNI = "Tutti i comuni";

	// DESCRIZIONI ABILITAZIONE
	public final static String ABILITAZIONE_REGIONE_PIEMONTE = "Regione Piemonte";
	public final static String ABILITAZIONE_PROVINCIA = "Provincia ";
	public final static String ABILITAZIONE_COMUNE = "Comune ";

	// LABEL ALTRA IMPRESA
	public final static String LABEL_ALTRA_IMPRESA = "ALTRA IMPRESA";

	public final static String CODICE_FRUITORE_SIGITEXT_SIGIT = "SIGIT";

	//STATI IMPIANTO
	public final static int ID_STATO_IMPIANTO_ATTIVO = 1;

	//ID TIPI VERIFICA
	public final static int ID_TIPO_VERIFICA_DATO_NON_PRESENTE = 0;
	public final static int ID_TIPO_VERIFICA_IMPIANTO = 1;
	public final static int ID_TIPO_VERIFICA_REE = 2;
	public final static int ID_TIPO_VERIFICA_RELAZIONE_ESIMENTE = 3;
	public final static int ID_TIPO_VERIFICA_DATO_DISTRIBUTORE = 4;
	public final static int ID_TIPO_VERIFICA_SEGNALAZIONE = 5;
	public final static int ID_TIPO_VERIFICA_DECADENZA_3_RESPONSABILE = 6;
	public final static int ID_TIPO_VERIFICA_ALTRO = 7;

	public final static String[] ESTENSIONI_PERMESSE_FILE_RAPP_PROVA_FIRMATO = {"pdf", "p7m"};

	//LOCCSI
	public final static String LOCCSI_API_URL = "loccsi.api.url";
	public final static String LOCCSI_TOKEN_URL = "loccsi.token.url";
	public final static String LOCCSI_TOKEN_CONSUMERKEY = "loccsi.token.consumerkey";
	public final static String LOCCSI_TOKEN_CONSUMERSECRET = "loccsi.token.consumersecret";
	public final static int LOCCSI_TIMEOUT = 10000;
	public final static String LOCCSI_SEZIONE_COORDINATE_JSON = "ind_loccsi_civici_bdtre";

	//API MANAGER GWEECOSIS
	public final static String APIMAN_TOKEN_URL = "apimanager.gwecosis.token.url";
	public final static String APIMAN_TOKEN_CONSUMERKEY = "apimanager.gwecosis.token.consumerkey";
	public final static String APIMAN_TOKEN_CONSUMERSECRET = "apimanager.gwecosis.token.consumersecret";
	public final static int APIMAN_TIMEOUT = 10000;
	
	//SVISTA
	public final static String SVISTA_WSDL_URL = "svista.wsdl.url";

	public final static String CHIAVE_CONFIG_DATA_AGGIORNAMENTO_COORDINATE = "DATA_AGGIORNA_COORD";
	public final static String CHIAVE_CONFIG_N_RECORD_AGGIORNA_COORD = "N_RECORD_AGGIORNA_COORD";

	//COMBUSTIBILE
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
	public final static Integer[] ID_TIPO_COMBUSIBILE_BIOMASSA_ARRAY = {ID_TIPO_COMBUSTIBILE_PELLET,
			ID_TIPO_COMBUSTIBILE_TRONCHETTI, ID_TIPO_COMBUSTIBILE_CIPPATO, ID_TIPO_COMBUSTIBILE_ALTRA_BIOMASSA_SOLIDA,
			ID_TIPO_COMBUSTIBILE_BIOMASSA_LIQUIDA, ID_TIPO_COMBUSTIBILE_BIOMASSA_GASSOSA, ID_TIPO_COMBUSTIBILE_LEGNA,
			ID_TIPO_COMBUSTIBILE_BRICCHETTE, ID_TIPO_COMBUSTIBILE_TRONCHETTI_PELLET,
			ID_TIPO_COMBUSTIBILE_CIPPATO_PELLET, ID_TIPO_COMBUSTIBILE_POLICOMBUSTIBILE_BIOMASSA_GAS_GASOLIO};

	public final static Integer[] ID_TIPO_COMBUSTIBILE_CHECKBOX_PDF = {ID_TIPO_COMBUSTIBILE_PELLET,
			ID_TIPO_COMBUSTIBILE_CIPPATO, ID_TIPO_COMBUSTIBILE_LEGNA, ID_TIPO_COMBUSTIBILE_BRICCHETTE};

	public final static int ID_TIPO_CONSUMO_1B_ACQUA_REINTEGRO = 1;
	public final static int ID_TIPO_CONSUMO_1B_CONSUMO_BIOMASSA = 2;

	public final static int ID_ARIA_COMBURENTE_DA_ESTERNO = 1;
	public final static int ID_ARIA_COMBURENTE_DA_LOCALE_INSTALLAZIONE = 2;

	public final static int ID_CONTROLLO_ARIA_COMBURENTE_AUTOMATICO = 1;
	public final static int ID_CONTROLLO_ARIA_COMBURENTE_SEMIAUTOMATICO = 2;
	public final static int ID_CONTROLLO_ARIA_COMBURENTE_MANUALE = 3;

	public final static int ID_CARICAMENTO_COMBUSTIBILE_AUTOMATICO = 1;
	public final static int ID_CARICAMENTO_COMBUSTIBILE_MANUALE = 2;
	public final static int ID_CARICAMENTO_COMBUSTIBILE_AUTOMATICO_MANUALE = 3;

	public final static String ID_UNITA_MISURA_LITRI = "1";

	public final static int ID_TIPO_1B_TRADIZIONALE = 1;
	public final static int ID_TIPO_1B_CONDENSAZIONE = 2;
	public final static int ID_TIPO_1B_ALTRO = 3;

	public final static int ID_STELLE_NON_APPLICABILE = 0;
	public final static int ID_STELLE_3 = 3;
	public final static int ID_STELLE_4 = 4;
	public final static int ID_STELLE_5 = 5;

	public final static String CHIAVE_CONFIG_MAPPA_WMS = "LINK_MAPPA_WMS";

	/*PROTECTED REGION END*/
}
