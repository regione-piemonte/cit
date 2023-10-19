package it.csi.sigit.sigitwebn.presentation.multiportalutils;

import javax.servlet.http.HttpServletRequest;

/**
 * Interfaccia che descrive un resolver di informazioni multiportale.
 *
 * @author CSIPiemonte
 */
public interface InfoResolver {
	public String resolve(String infoSourceName, HttpServletRequest hreq);
}
