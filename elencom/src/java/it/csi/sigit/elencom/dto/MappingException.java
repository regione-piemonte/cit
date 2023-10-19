package it.csi.sigit.elencom.dto;

/**
 * Classe di eccezione sollevata in caso di problemi di mapping
 */
public class MappingException extends Exception {

	/**
	 * costruttore vuoto
	 */
	public MappingException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MappingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public MappingException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public MappingException(Throwable cause) {
		super(cause);
	}

}
