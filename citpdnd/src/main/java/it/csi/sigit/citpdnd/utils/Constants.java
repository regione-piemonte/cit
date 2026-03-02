package it.csi.sigit.citpdnd.utils;

public class Constants {

    public static final String APPLICATION_NAME = "citpdnd";

    public static final int MAX_MESSAGE_LENGHT = 100;

    public static final String ERROR_MESSAGE_CODE_01 = "Errore durante l'esecuzione del servizio.";
    public static final String ERROR_MESSAGE_CODE_02 = "Indirizzo non valido.";
    public static final String ERROR_MESSAGE_CODE_03 = "Libretto non trovato.";
    public static final String ERROR_MESSAGE_CODE_04 = "Configurazione non trovata.";
    public static final String ERROR_MESSAGE_CODE_05 = "Superato il numero massimo di risultati ammissibili.";
    public static final String ERROR_MESSAGE_CODE_06 = "Errore durante recupero file da Index.";

    private Constants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
