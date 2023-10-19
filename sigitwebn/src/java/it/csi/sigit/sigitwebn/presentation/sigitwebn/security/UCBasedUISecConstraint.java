package it.csi.sigit.sigitwebn.presentation.sigitwebn.security;

import java.util.Map;
import it.csi.sigit.sigitwebn.business.*;
import it.csi.sigit.sigitwebn.dto.*;

/**
 * Security constraint basato sull'abilitazione dell'utente corrente 
 * ad uno specifico use-case
 * @generated
 */
public class UCBasedUISecConstraint extends AbstractUISecConstraint {

	/**
	 * il codice dello use case di cui verificare l'abilitazione
	 * @generated
	 */
	private String useCaseCode;

	/**
	 * @param il codice dello use case
	 */
	public void setUseCaseCode(String val) {
		this.useCaseCode = val;
	}

	/**
	 * costrutto vuoto
	 */
	public UCBasedUISecConstraint() {
		// intenzionalment evuoto
	}

	/**
	 * costruttore.
	 * @param nomeContainer nome del content panel che contiene il constraint
	 * @param nomeWidget nome del widget a cui e' associato il constraint
	 * @param constrainedBehavior il constraint riguarda la visibilita' o l'abilitazione
	 * @param stato di default del widget a cui e' asociato il constraint
	 * @param useCaseCode codice dello use case di cui deve essere verificata l'abilitazione
	 * @generated
	 */
	public UCBasedUISecConstraint(String nomeContainer, String nomeWidget, int constrainedBehavior,
			boolean defaultState, String useCaseCode) {
		super(nomeContainer, nomeWidget, constrainedBehavior, defaultState);
		this.useCaseCode = useCaseCode;
	}

	/**
	 * implementazione della verifica specifica (delegata al security helper)
	 * @param session la sessione applicativa
	 * @param sh il security helper
	 * @generated
	 */
	@Override
	public boolean specificCheck(BaseSessionAwareDTO model, Map session, SecurityHelper sh) throws BEException {
		return sh.verifyCurrentUserForUC(session, useCaseCode);
	}

}
