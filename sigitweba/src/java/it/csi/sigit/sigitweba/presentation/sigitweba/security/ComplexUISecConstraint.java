package it.csi.sigit.sigitweba.presentation.sigitweba.security;

import java.util.Map;
import java.util.Arrays;
import it.csi.sigit.sigitweba.business.*;
import it.csi.sigit.sigitweba.dto.*;
import it.csi.sigit.sigitweba.dto.DTOUtils;

/**
 * Security constraint composito. La composizione avviene in OR. 
 * @generated
 */
public class ComplexUISecConstraint implements UISecConstraint {

	/**
	 * costrutto vuoto
	 */
	public ComplexUISecConstraint() {
		// intenzionalment evuoto
	}

	/**
	 * i constraint da verificare
	 * @generated
	 */
	protected UISecConstraint[] constraints = null;

	/**
	 * imposta l'elenco dei constraint da verificare
	 * @param value
	 */
	public void setConstraints(UISecConstraint[] value) {
		constraints = (UISecConstraint[]) DTOUtils.arrayCopyOf(value, UISecConstraint.class);
	}

	/**
	 * @return l'elenco dei constraint da verificare
	 */
	public UISecConstraint[] getConstraints() {
		return (UISecConstraint[]) DTOUtils.arrayCopyOf(constraints, UISecConstraint.class);
	}

	/**
	 * costruttore
	 * @param constraints i constraint da verificare
	 * @generated
	 */
	public ComplexUISecConstraint(UISecConstraint[] p_constraints) {
		this.constraints = (UISecConstraint[]) DTOUtils.arrayCopyOf(p_constraints, UISecConstraint.class);
	}

	/**
	 * Verifica se almeno uno dei constraints &egrave; soddisfatto.
	 * @param session la sessioen applicativa
	 * @param checkedBehavior il comportamento oggetto di vincolo (visibilita'/abilitazione)
	 * @param sh il security helper
	 * @generated
	 */
	public boolean verifyConstraint(BaseSessionAwareDTO model, Map session, int checkedBehavior, SecurityHelper sh)
			throws BEException {
		if (constraints != null && constraints.length > 0) {
			boolean verified = false;
			boolean declarativeConstraintResult = true;
			// prima valuto il Declarative constraint
			for (int i = 0; i < constraints.length && !verified; i++) {
				UISecConstraint currCtr = constraints[i];
				if (currCtr instanceof DeclarativeUIConstraint
						&& ((DeclarativeUIConstraint) currCtr).getConstrainedBehavior() == checkedBehavior) {
					declarativeConstraintResult &= currCtr.verifyConstraint(model, session, checkedBehavior, sh);
				}
			}
			// poi, se ancora necessario, valuto i security constraints
			if (declarativeConstraintResult) {
				boolean almostOneSecCtr = false;
				for (int i = 0; i < constraints.length && !verified; i++) {
					UISecConstraint currCtr = constraints[i];
					if (!(currCtr instanceof DeclarativeUIConstraint)) {
						almostOneSecCtr = true;
						verified |= currCtr.verifyConstraint(model, session, checkedBehavior, sh);
					}
				}
				if (!almostOneSecCtr) {
					// se nessun sec. constraint allora vale il risultato dei declarative, che in questo
					// punto e' sempre TRUE; in caso contrario vale il risultato combinato dei security
					// constraints
					verified = true;
				}
			} else {
				return false; // se il declarative dice off => non serve vedere i security
			}
			return verified;
		} else
			return true;
	}

}
