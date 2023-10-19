package it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor;

import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Marks an Action method to not be validated
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface FatClientOnly {
}
