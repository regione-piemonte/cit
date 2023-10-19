package it.csi.sigit.sigitwebn.presentation.sigitwebn.validator;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.RangeValidatorSupport;

/**
 * Controlla il valore del campo di tipo Long sia contenuto nel range atteso
 *
 * @author GuiGen
 */
public class CsiLongRangeValidator extends RangeValidatorSupport<Long> {

	protected CsiLongRangeValidator() {
		super(Long.class);
	}
}
