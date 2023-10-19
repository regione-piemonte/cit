package it.csi.sigit.sigitwebn.presentation.multiportalutils;

import javax.servlet.http.HttpServletRequest;

/**
 * Resolver di informazioni multiportale via parametro di request.
 *
 * @author CSIPiemonte
 */
public class RequestParamInfoResolver implements InfoResolver {

	public String resolve(String infoSourceName, HttpServletRequest hreq) {
		return hreq.getParameter(infoSourceName);
	}

}
