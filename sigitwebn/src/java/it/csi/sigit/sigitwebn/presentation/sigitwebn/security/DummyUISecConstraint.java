package it.csi.sigit.sigitwebn.presentation.sigitwebn.security;

import java.util.Map;
import it.csi.sigit.sigitwebn.business.*;
import it.csi.sigit.sigitwebn.dto.*;

/**
 * Security constraint fittizio ad effetto null (always on/off a seconda del valore di inizializzazione)
 * @generated
 */
public class DummyUISecConstraint extends AbstractUISecConstraint {

	/**
	 * @generated
	 */
	private boolean fixedValue;

	/**
	 * costrutto vuoto
	 */
	public DummyUISecConstraint() {
		// intenzionalment evuoto
	}

	/**
	 * costruttore
	 * @param nomeContainer nome del content panel che contiene il constraint
	 * @param nomeWidget nome del widget a cui e' associato il constraint
	 * @param constrainedBehavior il constraint riguarda la visibilita' o l'abilitazione
	 * @param stato di default del widget a cui e' asociato il constraint
	 * @param fixedValue il valore fisso restituito dal constraint (true/false)
	 * @generated
	 */
	public DummyUISecConstraint(String nomeContainer, String nomeWidget, int constrainedBehavior, boolean defaultState,
			boolean fixedValue) {
		super(nomeContainer, nomeWidget, constrainedBehavior, defaultState);
		this.fixedValue = fixedValue;
	}

	/**
	 * @param val il valore che indica se il constraint ritorna sempre true o false 
	 */
	public void setFixedValue(boolean val) {
		this.fixedValue = val;
	}

	/**
	 * restituisce il valore fisso fornito nel costruttore
	 * @generated
	 */
	@Override
	public boolean specificCheck(BaseSessionAwareDTO model, Map session, SecurityHelper sh) throws BEException {
		return this.fixedValue;
	}

}
