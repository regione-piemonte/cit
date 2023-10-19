package it.csi.sigit.elencom.presentation.elencom.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotazione utilizzata dal MethodProtectionInterceptor. Se impostata su un metodo permette di 
 * configurarne il comportamento relativamente alla contemporanea esecuzione di altri metodi
 * @generated
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodProtection {

	/**
	 * Permette l'esecuzione contemporanea di qualsiasi metodo
	 * @generated
	 */
	public static final String ALLOW_ALL = "ALLOW_ALL";

	/**
	 * Permette l'esecuzione contemporanea di qualsiasi metodo tranne lo stesso metodo
	 * @generated
	 */
	public static final String REJECT_SAME = "REJECT_SAME";

	/**
	 * Non permette l'esecuzione contemporanea di nessun metodo
	 * @generated
	 */
	public static final String REJECT_ALL = "REJECT_ALL";

	/**
	 * il livello di protezione
	 * @generated
	 */
	String level();
}
