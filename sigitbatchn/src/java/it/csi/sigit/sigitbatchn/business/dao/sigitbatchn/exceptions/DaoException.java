package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions;

/**
 * @generated
 */
public class DaoException extends Exception {
	/**
	 * @generated
	 */
	protected Throwable throwable;

	/**
	 * Method 'DaoException'
	 * 
	 * @param message
	 * @generated
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * Method 'DaoException'
	 * 
	 * @param message
	 * @param throwable
	 * @generated
	 */
	public DaoException(String message, Throwable throwable) {
		super(message);
		this.throwable = throwable;
	}

	/**
	 * Method 'getCause'
	 * 
	 * @return Throwable
	 * @generated
	 */
	public Throwable getCause() {
		return throwable;
	}

}
