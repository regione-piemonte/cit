package it.csi.sigit.sigitwebn.presentation.sigitwebn.security;
import java.util.Map;
import it.csi.sigit.sigitwebn.business.*;
import it.csi.sigit.sigitwebn.dto.*;

/**
 * Classe astratta superclasse di tutti i constraint di sicurezza
 * @generated
 */
public abstract class AbstractUISecConstraint implements UISecConstraint {

	/**
	 * il comportamento oggetto di constraint (default = abilitazione)
	 * @generated
	 */
	protected int constrainedBehavior = UISecConstraint.ONOFF_CONSTRAINED_BEHAVIOR;

	/**
	 * Imposta il comportamento oggetto di constraint (visibilita' / abilitazione)
	 * @param value 
	 */
	public void setConstrainedBehavior(int value) {
		constrainedBehavior = value;
	}

	/**
	 * @return il comportamento oggetto di constraint
	 */
	public int getConstrainedBehavior() {
		return constrainedBehavior;
	}

	/**
	 * lo stato di default (relativamente al constrainedBehavior specificato) del widget oggetto di constraint
	 * @generated
	 */
	protected boolean defaultState;

	/**
	 * imposta lo stato di default (relativamente al constrainedBehavior specificato) del widget oggetto di constraint
	 * @param value
	 */
	public void setDefaultState(boolean value) {
		defaultState = value;
	}

	/**
	 * @return lo stato di default (relativamente al constrainedBehavior specificato) del widget oggetto di constraint
	 */
	public boolean getDefaultState() {
		return defaultState;
	}

	/**
	 * nome del content panel che contiene il widget oggetto di constraint
	 * @param
	 */
	protected String nomeContainer;

	/**
	 * imposta il nome del content panel che contiene il widget oggetto di constraint
	 * @param value
	 */
	public void setNomeContainer(String value) {
		nomeContainer = value;
	}

	/**
	 * @return il nome del content panel che contiene il widget oggetto di constraint
	 */
	public String getNomeContainer() {
		return nomeContainer;
	}

	/**
	 * nome del widget oggetto di constraint
	 * @generated
	 */
	protected String nomeWidget;

	/**
	 * imposta il nome del widget oggetto di constraint
	 * @param value
	 */
	public void setNomeWidget(String value) {
		nomeWidget = value;
	}

	/**
	 * @return il nome del widget oggetto di constraint
	 */
	public String getNomeWidget() {
		return nomeWidget;
	}

	/**
	 * costruttore vuoto
	 */
	public AbstractUISecConstraint() {
	}

	/**
	 * costruttore
	 * @param nomeContainer il nome del content panel che contiene il widget oggetto di constraint
	 * @param nomeWidget il nome del widget oggetto di constraint
	 * @param constrainedBehavior il comportamento da vincolare (abilitazione/visibilita')
	 * @param default state lo stato di default (relativamente al constrainedBehavior specificato) del widget oggetto di constraint
	 * @generated
	 */
	public AbstractUISecConstraint(String nomeContainer, String nomeWidget, int constrainedBehavior,
			boolean defaultState) {
		if (nomeContainer == null || nomeWidget == null)
			throw new IllegalArgumentException(
					"Errore interno: nome container e nome widget obbligatori per constraint");
		if (constrainedBehavior != UISecConstraint.ONOFF_CONSTRAINED_BEHAVIOR
				&& constrainedBehavior != UISecConstraint.VISIB_CONSTRAINED_BEHAVIOR)
			throw new IllegalArgumentException(
					"Errore interno: comportamento oggetto di constraint non gestibile:" + constrainedBehavior);
		this.nomeContainer = nomeContainer;
		this.nomeWidget = nomeWidget;
		this.constrainedBehavior = constrainedBehavior;
		this.defaultState = defaultState;
	}
	/**
	 * Combina adeguatamente:
	 * <ul>
	 * <li>l'esito della verifica specifica
	 * <li>lo stato di default (relativo al comportamento oggetto di constraint - visibilit&agrave; o abilitazione)
	 * <li>lo stato corrente  (relativo al comportamento oggetto di constraint - visibilit&agrave; o abilitazione)
	 * </ul>
	 * In sintesi il comportamento oggetto di constraint sar&agrave; cos&igrave; valutato:
	 * <ul>
	 * <li>se lo stato corrente non &egrave; specificato (il widget non &egrave; stato impostato esplicitamente
	 *     ad invisibile o disabilitato) viene utilizzato come stato corrente lo stato di default
	 * <li>se lo stato corrente combinato (corrente effettivo + default) &egrave; OFF (invisibile o disabilitato)
	 *     lo stato finale o OFF
	 * <li>se lo stato corrente combinato (corrente effettivo + default) &egrave; ON, viene eseguito
	 *     il check specifico (che dipende dat tipo di constraint) e lo stato finale &egrave; 
	 *     ON (visibile o abilitato) se il check specifico &egrave; verificato, OFF altrimenti.
	 * </ul>
	 * @param session mantiene lo stato corrente del widget
	 * @param checkedBehavior il comportamento da vincolare (abilitazione/visibilita')
	 * @param sh il security constraint
	 * @return
	 */
	protected boolean combineAll(BaseSessionAwareDTO model, Map session, int checkedBehavior, SecurityHelper sh)
			throws BEException {
		if (checkedBehavior != this.constrainedBehavior)
			return false; // se il comportamento osservato e' un'altro passo oltre
		else {
			Boolean currentState = getCurrentState(session);
			if (currentState == null)
				currentState = Boolean.valueOf(defaultState);
			if (currentState.booleanValue() == false)
				return false;
			else
				return specificCheck(model, session, sh);
		}
	}

	/**
	 * Cerca in sessione lo stato corrente.
	 * @param session la sessione applicativa
	 * @return null se lo stato (per il comportamento in osservazione) non &egrave; impostato oppure
	 * il valore effettivo se questo &egrave; impostato.
	 */
	protected Boolean getCurrentState(Map session) {
		String behaviorSuffix = "";
		switch (constrainedBehavior) {
			case UISecConstraint.ONOFF_CONSTRAINED_BEHAVIOR :
				behaviorSuffix = "_enabled";
				break;
			case UISecConstraint.VISIB_CONSTRAINED_BEHAVIOR :
				behaviorSuffix = "_visible";
				break;
			default :
				break;
		}
		Map cpData = (Map) session.get(nomeContainer);
		if (cpData != null) {
			Boolean behaviorFlag = (Boolean) cpData.get(nomeWidget + behaviorSuffix);
			if (behaviorFlag != null) {
				return behaviorFlag.booleanValue();
			} else
				return null; // unspecified current state
		} else
			return null; // unspecified current state
	}

	/**
	 * implementazione specifica della verifica del constraint
	 * @param session la sessione applicativa
	 * @param checkedBehavior il comportamento da vincolare
	 * @param sh il security helper a cui delegare parte delle verifiche
	 * @generated
	 */
	public boolean verifyConstraint(BaseSessionAwareDTO model, Map session, int checkedBehavior, SecurityHelper sh)
			throws BEException {

		return combineAll(model, session, checkedBehavior, sh);
	}

	/**
	 * Questo metodo &egrave;ridefinito nelle varie tipologie di constraint e implementa
	 * i check specifici
	 * @param session
	 * @param sh il security helper
	 * @return
	 */
	public abstract boolean specificCheck(BaseSessionAwareDTO model, Map session, SecurityHelper sh) throws BEException;

}
