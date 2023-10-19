package it.csi.sigit.sigitwebn.presentation.sigitwebn.validator;

import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

/**
 * Controlla che la data sia nel formato atteso.
 *
 * @author GuiGen
 */
public class CsiDateValidator extends FieldValidatorSupport {

	/** Formato atteso della data (obbligatorio) */
	private String format;

	/**
	 * formato
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * formato
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * effettua la validazione.
	 * @param object
	 */
	public void validate(Object object) throws ValidationException {
		// nome del campo
		String fieldName = getFieldName();

		// valore del campo
		String value = (String) this.getFieldValue(fieldName, object);

		if (!validateStringDate(value)) {
			addFieldError(fieldName, object);
		}
	}

	/**
	 * logica di validazione delle date sotto forma di stringa
	 * @param value
	 */
	public boolean validateStringDate(String value) throws ValidationException {
		if (format == null || format.trim().length() == 0 || "gg/mm/aaaa".equals(format)) {
			// caso: formato non specificato o di default
			// (gg/mm/aaa)
			if (value != null && value.trim().length() > 0) {
				if (!checkValideDate(value))
					return false;
			}
		} else {
			if (value != null && value.trim().length() > 0) {
				// e' stato specificato un formato
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				try {
					sdf.parse(value);
				} catch (Exception e) { //NOSONAR  Reason:dubbia classificazione severity
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * la verifica di validita' di default e' relaizzata tramite una regular expression 
	 * piuttosto complessa che tiene conto anche della correttezza sostanziale delle date
	 * (es. anni bisestili, ...).
	 * @param date
	 */
	public boolean checkValideDate(String date) {
		if (!isNullOrEmpty(date)) {
			if (date.matches(
					"^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((1[6-9]|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$"))
				return true;
			else
				return false;
		}

		return false;
	}

	protected boolean isNullOrEmpty(String s) {
		return s == null || s.length() == 0;
	}

}
