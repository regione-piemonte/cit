package it.csi.sigit.sigitweba.presentation.multiportalutils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * Resolver di informazioni multiportale via parametro di request.
 *
 * @author CSIPiemonte
 */
public class SessionAttributeInfoResolver implements InfoResolver {

	public String resolve(String infoSourceName, HttpServletRequest hreq) {

		HttpSession session = hreq.getSession();
		return session != null ? (String) hreq.getAttribute(infoSourceName) : null;
	}

}
