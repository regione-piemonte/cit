/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.util;

public class Constants {
	public static final String COMPONENT_NAME = "citpwaweb";

	public static final String AUTHENTICATION_LOG = "[AuthenticationServiceImp]";

	public static final String IMPIANTO_LOG = "[ImpiantoServiceImp]";
	public static final String COMPONENT_LOG = "[ComponentServiceImp]";
	public static final String SETLIBSCHEDA1IMPIANTO_LOG = "[SetLibSch1IdImpianto]";
	public static final String SETLIBSCHEDA2IMPIANTO_LOG = "[SetLibSch2IdImpianto]";

	public static final String CONTROLLI_LOG = "[ControlliServiceImp]";
	public static final String LIBRETTO_LOG = "[LibrettoServiceImp]";
	public static final String DOCUMENTO_LOG = "[DocumentoServiceImp]";
	public static final String NOMINA_TERZO_RESPONSABILE_LOG = "[NominaTerzoResponsabileServiceImp]";

	public static final String CITSERVICE_LOG = "[CitServiceImp]";
	
	public static final String ISPEZIONESERVICE_LOG = "[IspezioneServiceImp]";
	
	public static final String CITSERVICE_MEDIA_TYPE = "application";
	
	public static final String CITSERVICE_ERRORE_SETACCESSO = "Errore durante la chiamata a setAccesso";
	public static final String CITSERVICE_ERRORE_SALVATAGGIO_ACCESSO = "Errore durante il salvataggio dell'accesso";
	public static final String CITSERVICE_ERRORE_RECUPERO_IMPIANTI = "Errore durante il recupero degli impianti";
	public static final String CITSERVICE_ERRORE_RECUPERO_LIBRETTO = "Errore durante il recupero del libretto";
	public static final String CITSERVICE_ERRORE_DELETE_DOCUMENTO = "Errore durante la cancellazione del documento";
	public static final String CITSERVICE_ERRORE_RECUPERO_DOCUMENTO = "Errore durante il recupero del documento";
	public static final String CITSERVICE_ERRORE_SALVATAGGIO_DOCUMENTO = "Errore durante il salvataggio del documento";
	public static final String CITSERVICE_ERRORE_RECUPERO_DATI = "Errore durante il recupero dei dati";
	public static final String CITSERVICE_ERRORE_RECUPERO_XML_CONTROLLO = "Errore durante il recupero dell'xml del controllo";
	public static final String CITSERVICE_ERRORE_RECUPERO_RESP_PROP = "Errore durante il recupero del responsabile/proprietario";
	public static final String CITSERVICE_ERRORE_INVIO_COMP = "Errore durante l'invio del componente: ";
	public static final String CITSERVICE_ERRORE_RECUPERO_COMP_GT = "Errore durante il recupero dei componenti GT";
	public static final String CITSERVICE_ERRORE_RECUPERO_COMP_GF = "Errore durante il recupero dei componenti GF";
	public static final String CITSERVICE_ERRORE_RECUPERO_COMP_SC = "Errore durante il recupero dei componenti SC";
	public static final String CITSERVICE_ERRORE_RECUPERO_COMP_CG = "Errore durante il recupero dei componenti CG";
	public static final String CITSERVICE_ERRORE_AGGIORNAMENTO = "Errore durante l'aggiornamento";
	public static final String CITSERVICE_ERRORE_RECUPERO_RICEVUTA = "Errore recupero ricevuta";
	public static final String CITSERVICE_ERRORE_RECUPERO_CONTROLLO_DISP = "Errore recupero controllo disponibile";
	public static final String CITSERVICE_ERRORE_UPLOAD_REE = "Errore durante l'upload del ree";
	public static final String CITSERVICE_ERRORE_SETLIBSCHEDA1IMPIANTO = "Errore durante la chiamata a setLibSch1IdImpianto";
	public static final String CITSERVICE_ERRORE_SETLIBSCHEDA2IMPIANTO = "Errore durante la chiamata a setLibSch2IdImpianto";
	
	public static final String CITSERVICE_PARAM_ID_ALLEGATO = "id-allegato";
	public static final String CITSERVICE_PARAM_CODICE_IMPIANTO = "codice-impianto";
	public static final String CITSERVICE_PARAM_TOKEN_JWT = "tokenJWT";
	public static final String CITSERVICE_PARAM_PROGRESSIVO = "progressivo";
	public static final String CITSERVICE_PARAM_ID_PERSONA = "id-persona";
	public static final String CITSERVICE_PARAM_ID_IMPRESA = "id-impresa";
	public static final String CITSERVICE_PARAM_RUOLO = "ruolo";
	
	public static final String COMPONENT_SERVICE_ERRORE_RECUPERO_DATI = "Errore recupero dati";
	
	public static final String IMPIANTO_SERVICE_ERRORE_SET_RESP_PROP = "setRespProp - error: ";
	public static final String IMPIANTO_SERVICE_ERRORE_SET_IMPIANTO = "setImpianto - error: ";
	
	public static final String LOCCSI_SERVICE_CHARSET = "charset";
	public static final String LOCCSI_SERVICE_UTF = "UTF-8";
	
	public static final String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	public static final String TYPE_STRING = "string";
	
	public static final String LIMAMM_ENTE = "limammEnte";
	public static final String LIMAMM_ENTE_PARAM_COMUNE = "Comune";
	public static final String LIMAMM_ENTE_PARAM_PROVINCIA = "Provincia";
	public static final String LIMAMM_ENTE_PARAM_REGIONE = "Regione";
	public static final String LIMAMM_ENTE_PARAM_LOCALITA = "Localita";
	public static final String FAULT = "fault";
	public static final String FAULT1 = "fault1";
	public static final String FAULT2 = "fault2";
	public static final String FAULT3 = "fault3";
	public static final String FAULT4 = "fault4";
	public static final String FAULT5 = "fault5";
	public static final String SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION = "it.csi.svista.ws.service.svista.client.UnrecoverableException";
	public static final String SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION = "UnrecoverableException";
	public static final String SVISTA_SERVICE_CSI_EXCEPTION = "it.csi.svista.ws.service.svista.client.CSIException";
	public static final String SVISTA_SERVICE_PARAM_CSI_EXCEPTION = "CSIException";
	public static final String SVISTA_SERVICE_SYSTEM_EXCEPTION = "it.csi.svista.ws.service.svista.client.SystemException";
	public static final String SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION = "SystemException";
	public static final String SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION = "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException";
	public static final String SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION = "ParInputValNonCorrettoException";
	public static final String SVISTA_SERVICE_OUTPUT_EXCEPTION = "it.csi.svista.ws.service.svista.client.OutputException";
	public static final String SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION = "OutputException";
	public static final String SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION = "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException";
	public static final String SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION = "ParInputObblMancantiException";
	
	public static final String IRIDE_ID_SESSIONATTR = "iride2_id";

	public static final String AUTH_ID_MARKER = "Shib-Iride-IdentitaDigitale";

	public static final String USERINFO_SESSIONATTR = "appDatacurrentUser";

	public static final String HEADER_PORTALE = "Shib-community";

	public static final String PORTALE_RUPAR_IDENTIFIER = "DIPENDENTE_PA";

	public static final String PORTALE_WEB_IDENTIFIER = "CITTADINO";

	public static final Long ID_RUOLO_SUPERUSER = 1L;

	public static final String CODICE_FRUITORE_SIGITEXT_SIGIT = "SIGIT";

	public static final String SUBJECT_JWT_FRUITORE = "INTERNO";

	// RUOLO RESPONSABILE
	public static final String RUOLO_RESPONSABILE = "RESPONSABILE";

	// RUOLO PROPRIETARIO
	public static final String RUOLO_PROPRIETARIO = "PROPRIETARIO";

	// RUOLO RESPONSABILE IMPRESA
	public static final String RUOLO_RESPONSABILE_IMPRESA = "RESPONSABILE IMPRESA/ENTE";

	// RUOLO PROPRIETARIO IMPRESA
	public static final String RUOLO_PROPRIETARIO_IMPRESA = "PROPRIETARIO IMPRESA/ENTE";

	// RUOLO ISPETTORE
	public static final String RUOLO_ISPETTORE = "ISPETTORE";

	//RUOLO CARICATORE (ex INSTALLATORE)
	public static final String RUOLO_CARICATORE = "CARICATORE";

	// RUOLO IMPRESA (ex MANUTENTORE)
	public static final String RUOLO_IMPRESA = "IMPRESA";

	public static final String RUOLO_3RESPONSABILE = "3RESPONSABILE";

	public static final String RUOLO_DISTRIBUTORE = "DISTRIBUTORE";

	public static final String RUOLO_CAT = "SOGG. DELEGATO";

	public static final String CAT_RUOLO_PREFISSO = "SOGG. DELEGATO per ";

	public static final String RUOLO_SUPER = "SUPERUSER";

	public static final String RUOLO_VALIDATORE = "VALIDATORE";

	public static final String RUOLO_CONSULTATORE = "CONSULTATORE";

	public static final String CLIENT_CREDENTIALS = "client_credentials";

	public static final int ID_STATO_IMPRESA_ATTIVA = 1;
	public static final int ID_STATO_IMPRESA_CESSATA = 2;
	public static final int ID_STATO_IMPRESA_SOSPESA = 3;
	public static final int ID_STATO_IMPRESA_RADIATA = 4;

	// RUOLO IMPRESA (ex MANUTENTORE)
	public static final String CAT_RUOLO_IMPRESA = CAT_RUOLO_PREFISSO + RUOLO_IMPRESA;

	// RUOLO RESPONSABILE IMPRESA
	public static final String CAT_RUOLO_RESPONSABILE_IMPRESA = CAT_RUOLO_PREFISSO + RUOLO_RESPONSABILE_IMPRESA;

	// RUOLO 3RESPONSABILE
	public static final String CAT_RUOLO_3RESPONSABILE = CAT_RUOLO_PREFISSO + RUOLO_3RESPONSABILE;

	// RUOLO DISTRIBUTORE
	public static final String CAT_RUOLO_DISTRIBUTORE = CAT_RUOLO_PREFISSO + RUOLO_DISTRIBUTORE;

	public static final String OK = "OK";
	public static final String KO = "KO";
	public static final String WARN = "WARN";
	public static final String IND_LOCCSI_COMUNI = "ind_loccsi_comuni";

	public static final String IND_LOCCSI_CIVICI_FULL = "ind_loccsi_civici_bdtre";

	public static final String IND_LOCCSI_STRADE = "ind_loccsi_strade";
	public static final String LABEL_LOCCSI_FULL = "FULL";
	public static final String LABEL_LOCCSI_STRADE = "STRADE";
	public static final String LABEL_LOCCSI_COMUNI = "COMUNI";

	public static final String TIPO_COMPONENTE_GT = "GT";
	public static final String TIPO_COMPONENTE_GF = "GF";
	public static final String TIPO_COMPONENTE_SC = "SC";
	public static final String TIPO_COMPONENTE_CG = "CG";

	public static final String ALLEGATO_TIPO_1 = "3";
	public static final String ALLEGATO_TIPO_1B = "14";
	public static final String ALLEGATO_TIPO_2 = "4";
	public static final String ALLEGATO_TIPO_3 = "5";
	public static final String ALLEGATO_TIPO_4 = "6";
	public static final String MANUTENZIONE_GT = "10";
	public static final String MANUTENZIONE_GF = "11";
	public static final String MANUTENZIONE_SC = "12";
	public static final String MANUTENZIONE_CG = "13";
	public static final String KO_PG = "ko_pg";

	public static final String POD = "IT[0-9]{3}[E]{1}[0-9a-zA-Z]+";
	public static final String PDR = "[0-9]{14}";

	public static final String STATO_DEL_CONTROLLO = "fk_stato_rapp";
	public static final String DATA_CONTROLLO_MENO_RECENTE = "da\ta_controllo";
	public static final String DATA_CONTROLLO_PIU_RECENTE = "data_controllo DESC";
	public static final String TIPOLOGIA_DI_CONTROLLO = "fk_tipo_documento";
	public static final int PARTITA_IVA_LEN = 11;

	public static final String TIPO_CONTROLLO_MANUT = "1";
	public static final String TIPO_CONTROLLO_REE = "2";

	public static final Integer BOZZA = 0;
	public static final String APPLICATION_CODE = "sigitext";
	public static final String UTF_8_ENCODING = "UTF-8";
	public static final String FORMAT = "MM/dd/yyyy";
	public static final String STATO_IMPIANTO_ATTIVO = "Attivo";
	public static final int FK_STATO_IMPIANTO_ATTIVO = 1;

	//API MANAGER GWEECOSIS
	public static final String APIMAN_TOKEN_URL = "apimanager.gwecosis.token.url";
	public static final String APIMAN_TOKEN_CONSUMERKEY = "apimanager.gwecosis.token.consumerkey";
	public static final String APIMAN_TOKEN_CONSUMERSECRET = "apimanager.gwecosis.token.consumersecret";
	public static final int APIMAN_TIMEOUT = 10000;
	
	//API SERVICE IMP
	public static final String UTENTE_NON_AUTORIZZATO = "Utente non autorizzato";
	public static final String NESSUN_COMBUSTIBILE_TROVATO = "nessun combustibile trovato";
	public static final String NESSUN_ELEMENTO_TROVATO = "nessun elemento trovato";
	
	//SVISTA
	public static final String SVISTA_WSDL_URL = "svista.wsdl.url";
}
