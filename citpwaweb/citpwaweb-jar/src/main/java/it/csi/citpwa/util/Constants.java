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
	public final static String COMPONENT_NAME = "citpwaweb";

	public final static String AUTHENTICATION_LOG = "[AuthenticationServiceImp]";

	public final static String IMPIANTO_LOG = "[ImpiantoServiceImp]";
	public final static String COMPONENT_LOG = "[ComponentServiceImp]";

	public final static String CONTROLLI_LOG = "[ControlliServiceImp]";
	public final static String LIBRETTO_LOG = "[LibrettoServiceImp]";

	public final static String CITSERVICE_LOG = "[CitServiceImp]";

	public static final String IRIDE_ID_SESSIONATTR = "iride2_id";

	public static final String AUTH_ID_MARKER = "Shib-Iride-IdentitaDigitale";

	public static final String USERINFO_SESSIONATTR = "appDatacurrentUser";

	public static final String HEADER_PORTALE = "Shib-community";

	public static final String PORTALE_RUPAR_IDENTIFIER = "DIPENDENTE_PA";

	public static final String PORTALE_WEB_IDENTIFIER = "CITTADINO";

	public static final Long ID_RUOLO_SUPERUSER = 1L;

	public final static String CODICE_FRUITORE_SIGITEXT_SIGIT = "SIGIT";

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

	public final static String STATO_DEL_CONTROLLO = "fk_stato_rapp";
	public final static String DATA_CONTROLLO_MENO_RECENTE = "da\ta_controllo";
	public final static String DATA_CONTROLLO_PIU_RECENTE = "data_controllo DESC";
	public final static String TIPOLOGIA_DI_CONTROLLO = "fk_tipo_documento";
	public static final int PARTITA_IVA_LEN = 11;

	public final static String TIPO_CONTROLLO_MANUT = "1";
	public final static String TIPO_CONTROLLO_REE = "2";

	public static final Integer BOZZA = 0;
	public static final String APPLICATION_CODE = "sigitext";
	public final static String UTF_8_ENCODING = "UTF-8";
	public static final String FORMAT = "MM/dd/yyyy";
	public static final String STATO_IMPIANTO_ATTIVO = "Attivo";
	public static final int FK_STATO_IMPIANTO_ATTIVO = 1;

	//API MANAGER GWEECOSIS
	public final static String APIMAN_TOKEN_URL = "apimanager.gwecosis.token.url";
	public final static String APIMAN_TOKEN_CONSUMERKEY = "apimanager.gwecosis.token.consumerkey";
	public final static String APIMAN_TOKEN_CONSUMERSECRET = "apimanager.gwecosis.token.consumersecret";
	public final static int APIMAN_TIMEOUT = 10000;
	
	//SVISTA
	public final static String SVISTA_WSDL_URL = "svista.wsdl.url";
}
