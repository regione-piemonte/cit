package it.csi.sigit.sigitweba.presentation.multiportalutils;

import javax.servlet.http.HttpServletRequest;

/**
 * Resolver di informazioni multiportale via parametro di request.
 *
 * @author CSIPiemonte
 */
public class RequestAttributeInfoResolver implements InfoResolver {

	public String resolve(String infoSourceName, HttpServletRequest hreq) {
		return (String) hreq.getAttribute(infoSourceName);
	}

}
