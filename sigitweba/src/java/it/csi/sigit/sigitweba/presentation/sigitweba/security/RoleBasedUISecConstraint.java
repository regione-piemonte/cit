package it.csi.sigit.sigitweba.presentation.sigitweba.security;
import java.util.Map;
import it.csi.sigit.sigitweba.business.*;
import it.csi.sigit.sigitweba.dto.*;

/**
 * Security constraint basato sull'abilitazione dell'utente corrente 
 * ad uno specifico ruolo (identificato dalla coppia codice ruolo / dominio)
 * @generated
 */
public class RoleBasedUISecConstraint extends AbstractUISecConstraint {

	/**
	 * il codice del ruolo da verificare
	 * @generated
	 */
	private String roleCode;

	/**
	 * @param val il codice del ruolo
	 */
	public void setRoleCode(String val) {
		this.roleCode = val;
	}

	/**
	 * il codice del dominio a cui appartiene il ruolo da verificare
	 * @generated
	 */
	private String domainCode;

	/**
	 * @param val il codice del dominio
	 */
	public void setDomainCode(String val) {
		this.domainCode = val;
	}

	/**
	 * costrutto vuoto
	 */
	public RoleBasedUISecConstraint() {
		// intenzionalment evuoto
	}

	/**
	 * costruttore
	 * @param nomeContainer nome del content panel che contiene il constraint
	 * @param nomeWidget nome del widget a cui e' associato il constraint
	 * @param constrainedBehavior il constraint riguarda la visibilita' o l'abilitazione
	 * @param stato di default del widget a cui e' asociato il constraint
	 * @param roleCode il codice del ruolo da verificare
	 * @param domainCode il codice del dominio di appartenenza del ruolo da verificare
	 * @generated
	 */
	public RoleBasedUISecConstraint(String nomeContainer, String nomeWidget, int constrainedBehavior,
			boolean defaultState, String roleCode, String domainCode) {
		super(nomeContainer, nomeWidget, constrainedBehavior, defaultState);
		this.roleCode = roleCode;
		this.domainCode = domainCode;
	}

	/**
	 * realizza la verifica specifica
	 * @generated
	 */
	@Override
	public boolean specificCheck(BaseSessionAwareDTO model, Map session, SecurityHelper sh) throws BEException {
		return sh.verifyCurrentUserForRole(session, roleCode, domainCode);
	}

}
