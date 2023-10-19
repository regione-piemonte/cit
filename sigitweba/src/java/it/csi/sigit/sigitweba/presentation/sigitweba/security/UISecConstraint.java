package it.csi.sigit.sigitweba.presentation.sigitweba.security;
import java.util.Map;
import it.csi.sigit.sigitweba.business.*;
import it.csi.sigit.sigitweba.dto.*;

/**
 * Interfaccia dei security constraints
 * @generated
 */
public interface UISecConstraint {

	/**
	 * 1=il comportamento vincolato e' l'abilitazione
	 * @generated
	 */
	public static final int ONOFF_CONSTRAINED_BEHAVIOR = 1;

	/**
	 * 1=il comportamento vincolato e' la visibilita'
	 * @generated
	 */
	public static final int VISIB_CONSTRAINED_BEHAVIOR = 2;

	/**
	 * metodo che deve essere implementato dalle classi dei constraint specifici.
	 * @param session la sessione applicativa
	 * @param checkedBehavior il comportamento vincolato (visibilita'/abilitazione)
	 * @param sh il security helper a cui e' possibile delegare le richieste specifiche
	 * @generated
	 */
	public boolean verifyConstraint(BaseSessionAwareDTO model, Map session, int checkedBehavior, SecurityHelper sh)
			throws BEException;
}
