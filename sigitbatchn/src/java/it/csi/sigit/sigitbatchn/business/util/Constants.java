/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.util;

import java.math.BigDecimal;

/**
 * <p>Classe delle costanti applicative.</p>
 *
 * @author GuiGen
 */
public final class Constants {
	/**
	 * identificativo dell'applicativo.
	 */
	public static final String APPLICATION_CODE = "sigitbatchn";

	/**
	 * nome dell'attributo di sessione in cui viene memorizzato il valore corrente del
	 * captcha 
	 */
	public static final String CAPTCHA_SESSION_NAME = "current_captcha_value";

	/*PROTECTED REGION ID(R1581691183) ENABLED START*/
	// Add here your constants

	//	private static java.util.ResourceBundle rb = java.util.ResourceBundle
	//			.getBundle("/META-INF/sigitwebn");


	
	public static final String DES_INIZIO_ALLEGATO_II = "allegatoII_";
	public static final String DES_INIZIO_ALLEGATO_III = "allegatoIII_";
	public static final String DES_INIZIO_ALLEGATO_IV = "allegatoIV_";
	public static final String DES_INIZIO_ALLEGATO_V = "allegatoV_";

	public final static String VALUE_PLACEHOLDER = "##value##";
	public final static String VALUE_ENTER_HTML = "<BR>";
	public final static String VALUE_ENTER_TXT = "\n";

	public final static int MAX_1000 = 1000;
	public final static int MAX_100 = 100;
	

	// CHIAVI PRESENTI NELLA TABELLA SIGIT_WRK_CONFIG
	public static final String WEB_MAIL_IND_MITT = "WEB_MAIL_IND_MITT";
	public static final String BATCH_MAIL_IND_DEST = "BATCH_MAIL_IND_DEST";

	public static final String DATA_MAX_INST_VALVOLE = "DATA_MAX_INST_VALVOLE";

	public static final String DES_M3H = "m3/h";
	public static final String DES_KGH = "Kg/h";
	
	public static final String COD_NATURALE = "N";
	public static final String COD_FORZATA = "F";

	public static final String COD_RAFFRESCAMENTO = "RA";
	public static final String COD_RISCALDAMENTO = "RI";
	
	public static final String COD_TIPO_IMPIANTO_CENTRALIZZATO = "C";
	public static final String COD_TIPO_IMPIANTO_AUTONOMO = "A";
	
	public static final Integer ID_KO = 0;
	public static final Integer ID_OK = 1;

	// ID RUOLO MANUTENTORE
	public final static int ID_RUOLO_MANUTENTORE_ALL_1 = 6;
	public final static int ID_RUOLO_MANUTENTORE_ALL_2 = 7;
	public final static int ID_RUOLO_MANUTENTORE_ALL_3 = 8;
	public final static int ID_RUOLO_MANUTENTORE_ALL_4 = 9;

	public static final int ID_STATO_IMPRESA_ATTIVA = 1;
	public static final int ID_STATO_IMPRESA_CESSATA = 2;
	public static final int ID_STATO_IMPRESA_SOSPESA = 3;
	public static final int ID_STATO_IMPRESA_RADIATA = 4;
	
	public static final String ALLEGATO_TIPO_1 = "3";
	public static final String ALLEGATO_TIPO_2 = "4";
	public static final String ALLEGATO_TIPO_3 = "5";
	public static final String ALLEGATO_TIPO_4 = "6";
	public static final String ALLEGATO_TIPO_1B = "14";
	public static final String MANUTENZIONE_GRUPPI_TERMICI = "10";
	public static final String MANUTENZIONE_GRUPPI_FRIGO = "11";
	public static final String MANUTENZIONE_SCAMBIATORI = "12";
	public static final String MANUTENZIONE_COGENERATORI = "13";
	public static final String RAPPORTO_PROVA_GT = "8";
	public static final String RAPPORTO_PROVA_GF = "9";
	
	public static final String UTENTE_BATCH = "IMPORT MASSIVO";
	public static final String TAG_NOTIFY_ENERGIA = "r_piemon,ppm,energia";

	// LABEL SI
	public static String LABEL_SI = "SI";

	// LABEL NO
	public static String LABEL_NO = "NO";
		

	// FLAG NO
	public static int NO_0 = 0;

	// FLAG SI
	public static int SI_1 = 1;

	// FLAG NC
	public static int NC_2 = 2;

	public static final int ID_STATO_IMP_DISTRIBUTORE_DA_ELABORARE = 1;
	public static final int ID_STATO_IMP_DISTRIBUTORE_INVIATO = 2;
	public static final int ID_STATO_IMP_DISTRIBUTORE_RIFIUTATO = 3;
	public static final int ID_STATO_IMP_DISTRIBUTORE_SOSTITUITO = 4;
	public static final int ID_STATO_IMP_DISTRIBUTORE_ELIMINATO = 5;
	
	public final static String DESC_PG_RUOLO_ISPETTORE = "ENTE ISPETTORE";

	public final static String DESC_ISPEZIONE = "ISPEZIONE";

	public final static String TIPO_BATCH_IMPORT_ALLEGATI = "IMPORT ALLEGATI";
	public final static String TIPO_BATCH_IMPORT_DISTRIBUTORI = "IMPORT DISTRIBUTORI";
	
	
	public static final int ID_TIPO_DOC_ALTRO_DOC_ISPEZIONI = 3;
	public static final int ID_TIPO_DOC_ALTRO_DOC = 5;
	public static final int ID_TIPO_DOC_DEROGA = 4;
	
	
	
	
	
	
	
	
	// OLD
	public static String SESSIONE_VAR_MESSAGGE = "messaggio";
	public static String SESSIONE_VAR_ID_IMPIANTO = "idImpianto";
	public static String SESSIONE_VAR_ID_ALLEGATO = "idAllegato";
	public static String SESSIONE_VAR_UTENTE_LOGGATO = "appDatautenteLoggato";
	public static String SESSIONE_VAR_ACTION_PAGE_BACK = "actionPageBack";
	public final static String MODOL_ENCODING = "UTF-8";

	public static String ACTION_PAGE_ELENCO_ALLEGATI_IMPIANTO = "cpElencoAllegatiImpianti.do";
	public static String ACTION_PAGE_ELENCO_ALLEGATI = "cpElencoAllegati.do";

	public static String RETURN_PAGE_ELENCO_ALLEGATI_IMPIANTO_DA_PDF = "./cpElencoAllegatiImpianti.do";
	public static String RETURN_PAGE_ELENCO_ALLEGATI_DA_PDF = "./cpRisultatoRicercaAllegati.do";

	public static String SESSIONE_VAR_DETT_ALLEGATO = "dettaglioAllegatoSsn";

	public static String ARRIVO_DA_IMPIANTO = "IMPIANTO";
	public static String ARRIVO_DA_ALLEGATI = "ALLEGATI";

	public static String ALLEGATO2_DA_MODOL = "2";
	public static String ALLEGATO3_DA_MODOL = "3";
	public static String ALLEGATO4_DA_MODOL = "4";
	public static String ALLEGATO5_DA_MODOL = "5";

	/** The mail host. */
	public static String MAIL_HOST = "mail.host";

	/** The mail port. */
	public static String MAIL_PORT = "mail.port";
	public static String MAIL_USER = "mail.user";
	public static String MAIL_PWD = "mail.pwd";

	public static String NOTIFY_TOKEN = "notify.token";
	public static String NOTIFY_MB_URL = "notify.mb.url";
	//public static String NOTIFY_STATUS_URL = "notify.status.url";

	public static String CITPWA_URL = "citpwa.url";

	
	public static final String COD_ISTAT_PIEMONTE = "01";

	//CODICE APPLICATIVO IRIDE
	public static final String CODICE_APPLICATIVO_IRIDE = "SIGITWEB";

	//CODICE APPLICATIVO MDP
	public static final String CODICE_APPLICATIVO_MDP = "SIGIT";

	// FLAG SI
	public static String SI = "S";

	// FLAG NO
	public static String NO = "N";

	
	

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

	public static final Integer ID_INDIRIZZO_VUOTO = 0;

	// RUOLI APPLICATIVO
	// RUOLO TITOLARE CF
	public static String RUOLO_TITOLARE_CF = "TITOLARE_CF";

	// RUOLO RESPONSABILE
	public static String RUOLO_RESPONSABILE = "RESPONSABILE";

	public static String RUOLO_RESPONSABILE_IMPRESA = "RESPONSABILE IMPRESA";

	// RUOLO 3RESPONSABILE
	public static String RUOLO_3RESPONSABILE = "3RESPONSABILE";

	// RUOLO INSTALLATORE
	public static String RUOLO_INSTALLATORE = "INSTALLATORE";

	// RUOLO MANUTENTORE
	public static String RUOLO_MANUTENTORE = "MANUTENTORE";

	// RUOLO AMMINISTRATORE
	public static String RUOLO_AMMINISTRATORE = "AMMINISTRATORE";

	// RUOLO PROPRIETARIO
	public static String RUOLO_PROPRIETARIO = "PROPRIETARIO";

	// RUOLO OCCUPANTE
	public static String RUOLO_OCCUPANTE = "OCCUPANTE";

	// RUOLI IRIDE
	// RUOLO SUPER
	public static String RUOLO_SUPER = "SUPER";

	// RUOLO VALIDATORE
	public static String RUOLO_VALIDATORE = "VALIDATORE";

	// RUOLO ISPETTORE
	public static String RUOLO_ISPETTORE = "ISPETTORE";

	// RUOLO CONSULTATORE
	public static String RUOLO_CONSULTATORE = "CONSULTATORE";

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
	public final static int ID_RUOLO_INSTALLATORE = 3;

	// ID RUOLO MANUTENTORE
	//public final static int ID_RUOLO_MANUTENTORE = 3;

	// ID RUOLO AMMINISTRATORE
	public final static int ID_RUOLO_AMMINISTRATORE = 13;

	// ID RUOLO ISPETTORE
	public final static int ID_RUOLO_ISPETTORE = 2;

	// ID RUOLO PROPRIETARIO
	public final static int ID_RUOLO_PROPRIETARIO = 4;

	
	// ID RUOLO 3RESPONSABILE
	//	public final static int ID_RUOLO_3RESPONSABILE = 99;

	public final static int ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO = 10;
	public final static int ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE = 11;
	public final static int ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE = 12;

	// ID RUOLO PROPRIETARIO
	public final static int ID_RUOLO_OCCUPANTE = 5;

	public static final String INTERVAL_SEP = "-";

	public static final String INTERVAL_SEP_CHIAVI = "_";

	public static final String INTERVAL_SEP_SLASH = "/";

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

	
	/**
	 * Codice Casistiche 
	 */
	public final static int COD_CASO_A = 1;
	public final static int COD_CASO_B = 2;
	public final static int COD_CASO_C = 3;
	public final static int COD_CASO_D = 4;
	public final static int COD_CASO_E = 5;

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
	 * Lunghezza minima di un indirizzo
	 */
	public final static int MIN_INDIRIZZO_LEN = 3;

	/**
	 * Lunghezza minima di una matricola
	 */
	public final static int MIN_MATRICOLA_LEN = 3;

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

	public static final String TIPO_OPERAZIONE_DB_DELETE = "DELETE";

	public static final String CODICE_APPLICAZIONE_MODOL = "SIGIT";
	public static final String CODICE_MODULO_MODOL_LIBRETTO = "MODULOsigit-v2.0.1";
	//	public static final String CODICE_MODULO_MODOL_LIBRETTO = "MODULOsigit-TEST";
	public static final String CODICE_MODULO_MODOL_LIBRETTO_LIGHT = "MODULOsigitLight-v1.0.0";
	public static final String CODICE_MODULO_MODOL_ALLEGATO_II = "MODULOsigit-AllegatoII-v1.0.0";
	public static final String CODICE_MODULO_MODOL_ALLEGATO_III = "MODULOsigit-AllegatoIII-v1.0.0";
	public static final String CODICE_MODULO_MODOL_ALLEGATO_IV = "MODULOsigit-AllegatoIV-v1.0.0";
	public static final String CODICE_MODULO_MODOL_ALLEGATO_V = "MODULOsigit-AllegatoV-v1.0.0";
	public static final String CODICE_MODULO_MODOL_RICEVUTA_ALLEGATO = "MODULOsigit-RicevutaAllegato";
	public static final String CODICE_MODULO_MODOL_RICEVUTA_IMPORT_DISTRIB = "MODULOsigit-RicevutaImportDistrib";

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

	//	public static final int ID_STATO_RAPPORTO_BOZZA = 1;
	//	public static final int ID_STATO_RAPPORTO_INVIATO = 2;
	//	public static final int ID_STATO_RAPPORTO_RESPINTO = 3;

	public static final java.math.BigDecimal ID_TIPO_INT_NON_VALORIZZATO = java.math.BigDecimal.ZERO;
	public static final int ID_TIPO_INT_NUOVA_INSTALZ = 1;
	public static final int ID_TIPO_INT_RISTRUTTURAZ = 2;
	public static final int ID_TIPO_INT_SOSTITUZIONE = 3;
	public static final int ID_TIPO_INT_COMPILAZIONE = 4;

	public static final int ID_TIPO_DOC_LIBRETTO = 7;

	public static final int ID_MOTIVO_CONSOLIDAMENTO_ESP_UTENTE = 1;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO = 2;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_RESP_RAPP_CONTROLLO = 3;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_NOMINA_3_RESP = 4;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_REVOCA_3_RESP = 5;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_SUBENTRO_RESP = 6;
	public static final int ID_MOTIVO_CONSOLIDAMENTO_CARICAMENTO_ISP = 7;

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



	
	// Parametri di configurazione di INDEX
	public static final String INDEX_USERNAME_ADMIN = "admin@sigit";
	public static final String INDEX_USERNAME_READ = "sigit@sigit";
	public static final String INDEX_PSW = "sigit";
	public static final String INDEX_UTENTE = "Utente Sigit";
	public static final String INDEX_FRUITORE = "sigit";
	public static final String INDEX_REPOSITORY = "primary";
	public static final String INDEX_DEFAULT_PREFIX = "cm:";
	public static final String INDEX_PREFIX = "sigit:";
	public static final String INDEX_PREFIX_NAME = "cm:content";
	public static final String INDEX_PREFIX_MODEL = "cm:contentmodel";
	public static final String INDEX_SIGIT_PREFIX_MODEL = "sigit:sigitContent";
	public static final String INDEX_PREFIX_FOLDER = "cm:folder";
	public static final String INDEX_PREFIX_NAME_SHORT = "cm:name";
	public static final String INDEX_PREFIX_CONTAINS = "cm:contains";
	public static final String INDEX_ROOT = "/app:company_home/cm:sigit";
	public static final String INDEX_TYPE_TEXT = "d:text";
	public static final String INDEX_FOLDER_SUFFIX = "/cm:";
	public static final String INDEX_METADATO_SUFFIX = "@cm\\:";
	public static final String INDEX_NAME = "name:\"";

	public static final int INDEX_MAX_SIZE = 10048000;
	public static final String INDEX_ALLEGATO_NAME = "sigit:rapporto";
	public static final String INDEX_ENCODING = "UTF-8";

	public static final String INDEX_FILE_PREFIX_LIBRETTO = "Libretto";

	//TIPI ALLEGATI
	public static final String ALLEGATO_F = "1";
	public static final String ALLEGATO_G = "2";


	public static final String DESC_ALLEGATO_TIPO_1 = "Tipo1";
	public static final String DESC_ALLEGATO_TIPO_2 = "Tipo2";
	public static final String DESC_ALLEGATO_TIPO_3 = "Tipo3";
	public static final String DESC_ALLEGATO_TIPO_4 = "Tipo4";

	public static final int FLAG_CONTROLLO_BOZZA_ALLEGATO_TRUE = 1;
	public static final int FLAG_CONTROLLO_BOZZA_ALLEGATO_FALSE = 0;

	public static final String TIPO_CONSUMO_CB = "14.1";
	public static final String TIPO_CONSUMO_EE = "14.2";
	public static final String TIPO_CONSUMO_H2O = "14.3";
	public static final String FLAG_VASO_APERTO = "A";
	public static final String FLAG_VASO_CHIUSO = "C";

	public static final String FLAG_ASSENTE = "A";
	public static final String FLAG_PRESENTE = "P";

	public static final String FLAG_EVACUAZIONE_FUMI_FORZATA = "F";
	public static final String FLAG_EVACUAZIONE_FUMI_NATURALE = "N";

	public static final String FLAG_MODALITA_RAFFRESCAMENTO = "RAF";
	public static final String FLAG_MODALITA_RISCALDAMENTO = "RIS";

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

	public static final String CONFIG_KEY_CIT_MEMO_SVEGLIA_PA_ATTIVO = "CIT_MEMO_SVEGLIA_PA_ATTIVO";

	public static final String CONFIG_KEY_CIT_MEMO_SCADENZA_RI_ATTIVO = "CIT_MEMO_SCADENZA_RI_ATTIVO";

	public static final String CONFIG_KEY_CIT_MEMO_SCADENZA_PT_ATTIVO = "CIT_MEMO_SCADENZA_PT_ATTIVO";

	public static final String CIT_MEMO_SCADENZA_PT_LIMITE = "CIT_MEMO_SCADENZA_PT_LIMITE";

	public static final String INTEGRAZIONE_APP_IO_ATTIVA = "BATCH_INTEGRAZIONE_APP_IO_ATTIVA";
	
	public static final Integer NUMBER_OF_DAY = 30;


	/*PROTECTED REGION END*/
}
