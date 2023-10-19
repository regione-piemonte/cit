package it.csi.sigit.sigitweba.util;

/**
 * <p>Classe delle costanti applicative.</p>
 *
 * @author GuiGen
 */
public final class Constants {
	/**
	 * identificativo dell'applicativo.
	 */
	public static final String APPLICATION_CODE = "sigitweba";

	/**
	 * nome dell'attributo di sessione in cui viene memorizzato il valore corrente del
	 * captcha 
	 */
	public static final String CAPTCHA_SESSION_NAME = "current_captcha_value";

	/*PROTECTED REGION ID(R1581691183) ENABLED START*/
	// Add here your constants

	public static final String COD_STATO_VIA_VALIDA = "V";
	public static final String COD_STATO_VIA_QUALSIASI = "A";
	public static final String DESC_STATO_VIA_DEPRECATO = "deprecato";

//	public static final String COD_ISTAT_PIEMONTE = "01";
	public static final long COD_ID_PIEMONTE = 1l;
	public static final String COD_ISTAT_PIEMONTE = "001";

	public static final String FLAG_ACCREDITAMENTO = "A";
	public static final String FLAG_DELEGA = "D";
	public static final String DESC_FLAG_ACCREDITAMENTO = "ACCREDITAMENTO";
	public static final String DESC_FLAG_DELEGA = "DELEGA";

	public static final String DATE_FORMAT = "dd/MM/yyyy";

	public static final String FLG_SI = "S";
	public static final String FLG_NO = "N";

	public static final String SI = "SI";
	public static final String NO = "NO";

	public static int SI_1 = 1;
	public static int NO_0 = 0;

	public static String MAIL_HOST = "mail.host";

	/** The mail port. */
	public static String MAIL_PORT = "mail.port";
	public static String MAIL_USER = "mail.user";
	public static String MAIL_PWD = "mail.pwd";

	public static final String WEB_MAIL_IND_MITT = "WEB_MAIL_IND_MITT";
	public static final String CIT_SIGITWEBA_SERVIZIO_ATTIVO = "CIT_SIGITWEBA_SERVIZIO_ATTIVO";
	public static final String CIT_UTENTI_AUTORIZZATI = "CIT_UTENTI_AUTORIZZATI";

	public static final int PARTITA_IVA_LEN = 11;

	public static final int ID_STATO_IMPRESA_ATTIVA = 1;
	public static final int ID_STATO_IMPRESA_CESSATA = 2;
	public static final int ID_STATO_IMPRESA_SOSPESA = 3;
	public static final int ID_STATO_IMPRESA_RADIATA = 4;

	public static final String DESC_MOTIVO_ATTIVAZIONE = "Primo caricamento sul CIT";
	public static final String DESC_MOTIVO_CESSAZIONE = "Cessazione impresa";

	public final static String INDIRIZZO_CARICATO_PWA = "-1";

	//API MANAGER GWEECOSIS
	public final static String APIMAN_TOKEN_URL = "apimanager.gwecosis.token.url";
	public final static String APIMAN_TOKEN_CONSUMERKEY = "apimanager.gwecosis.token.consumerkey";
	public final static String APIMAN_TOKEN_CONSUMERSECRET = "apimanager.gwecosis.token.consumersecret";
	public final static int APIMAN_TIMEOUT = 10000;
	
	//SVISTA
	public final static String SVISTA_WSDL_URL = "svista.wsdl.url";

	/*PROTECTED REGION END*/
}
