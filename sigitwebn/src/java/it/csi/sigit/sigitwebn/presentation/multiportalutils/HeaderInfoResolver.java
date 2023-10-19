package it.csi.sigit.sigitwebn.presentation.multiportalutils;

import javax.servlet.http.HttpServletRequest;

/**
 * Resolver di informazioni multiportale via Header HTTP.
 *
 * @author CSIPiemonte
 */
public class HeaderInfoResolver implements InfoResolver {

	public String resolve(String infoSourceName, HttpServletRequest hreq) {
		return hreq.getHeader(infoSourceName);
	}

}
