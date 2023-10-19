package it.csi.sigit.sigitweba.presentation.sigitweba.security;

import java.util.Map;
import it.csi.sigit.sigitweba.business.*;
import it.csi.sigit.sigitweba.dto.*;

/**
 * Superclasse di tutti i custom security Constraints.
 * @param
 */
public class CustomUISecConstraint extends AbstractUISecConstraint {

	/**
	 * costrutto vuoto
	 */
	public CustomUISecConstraint() {
		// intenzionalment evuoto
	}

	private String methodNameSuffix;

	/**
	 * @param val il suffisso del metodo da richiamare per l'implementazione del 
	 * custom constraint (il metodo si chiama customCheck{methodNameSuffix}() )
	 */
	public void setMethodNameSuffix(String val) {
		this.methodNameSuffix = val;
	}

	/**
	 * costruttore
	 * @param nomeContainer il nome del content panel che contiene il widget oggetto di constraint
	 * @param nomeWidget il nome del widget oggetto di constraint
	 * @param constraintedBehavior il comportamento vincolato (visibilita'/abilitazione)
	 * @param defaultState lo stato di default (relativamente al constrainedBehavior specificato) del widget oggetto di constraint
	 * @generated
	 */
	public CustomUISecConstraint(String nomeContainer, String nomeWidget, int constrainedBehavior,
			boolean defaultState) {
		super(nomeContainer, nomeWidget, constrainedBehavior, defaultState);
	}

	/**
	 * L'implementazione specifica del check e' delegata al SecurityHelper: viene invocato
	 * il metodo dal nome customCheck{methodNamesuffix}.
	 * @generated
	 */
	@Override
	public boolean specificCheck(BaseSessionAwareDTO model, Map session, SecurityHelper sh) throws BEException {
		// richiama dinamicamente il metodo customCheck{methodNamesuffix} nel security helper
		try {
			java.lang.reflect.Method checkMethod = sh.getClass().getDeclaredMethod("customCheck" + methodNameSuffix,
					Map.class);
			Object res = checkMethod.invoke(sh, session);
			return (Boolean) res;
		} catch (NoSuchMethodException nsme) {
			throw new BEException(
					"il metodo di check customCheck" + methodNameSuffix + "() non e' stato trovato nel SecurityHelper",
					nsme);
		} catch (java.lang.reflect.InvocationTargetException ite) {
			throw new BEException("errore nell'invocazione del check customCheck" + methodNameSuffix + "()", ite);
		} catch (IllegalAccessException iae) {
			throw new BEException("errore nell'invocazione del check customCheck" + methodNameSuffix + "()", iae);
		}
	}

}
