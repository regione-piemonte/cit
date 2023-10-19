package it.csi.sigit.elencom.presentation.elencom.security;
import java.util.Map;
import it.csi.sigit.elencom.business.*;
import it.csi.sigit.elencom.dto.*;

/**
 * Security constraint basato sull'abilitazione dell'utente corrente 
 * ad uno specifico ruolo (identificato dalla coppia codice ruolo / dominio)
 * @generated
 */
public class DeclarativeUIConstraint extends AbstractUISecConstraint {

	/**
	 * il codice del linguaggio in cui e' scritto il constraint.
	 * i valori validi sono:
	 * - beanshell
	 * @generated
	 */
	private String language;

	/**
	 * @param val il codice del linguaggio utilizzato
	 */
	public void setLanguage(String val) {
		this.language = val;
	}

	/**
	 * il constraint da verificare
	 * @generated
	 */
	private String script;

	/**
	 * @param val lo script da verificare
	 */
	public void setScript(String val) {
		this.script = val;
	}

	/**
	 * costrutto vuoto
	 */
	public DeclarativeUIConstraint() {
		// intenzionalmente vuoto
	}

	/**
	 * costruttore
	 * @param nomeContainer nome del content panel che contiene il constraint
	 * @param nomeWidget nome del widget a cui e' associato il constraint
	 * @param constrainedBehavior il constraint riguarda la visibilita' o l'abilitazione
	 * @param stato di default del widget a cui e' asociato il constraint
	 * @param language il codice del linguaggio in cui e' scritto il constraint
	 * @param script il constraint
	 * @generated
	 */
	public DeclarativeUIConstraint(String nomeContainer, String nomeWidget, int constrainedBehavior,
			boolean defaultState, String roleCode, String domainCode) {
		super(nomeContainer, nomeWidget, constrainedBehavior, defaultState);
		this.language = language;
		this.script = script;
	}

	/**
	 * realizza la verifica specifica
	 * @generated
	 */
	@Override
	public boolean specificCheck(BaseSessionAwareDTO model, Map session, SecurityHelper sh) throws BEException {
		return evalScript(model, session);
	}

	/**
	 * 
	 * @param session la sessione
	 * @return il valore dell'esecuzione dello script
	 * @throws IllegalArgumentException se accade qualcosa durante l'esecuzione dello script
	 */
	private boolean evalScript(BaseSessionAwareDTO model, Map session) throws BEException {
		bsh.Interpreter bsh = new bsh.Interpreter();
		try {
			bsh.set("session", session);
			bsh.set("model", model);
			bsh.eval("Boolean _retval = " + script + ";");
			return (Boolean) bsh.get("_retval");

		} catch (bsh.EvalError e) {
			throw new BEException("Errore in eval constraint " + script + ":" + e + ", " + e.getMessage(), e);
		}
	}

}
