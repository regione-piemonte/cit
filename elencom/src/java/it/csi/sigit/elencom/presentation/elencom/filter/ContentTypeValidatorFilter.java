/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.elencom.presentation.elencom.filter;
import java.io.IOException;
import java.util.regex.Matcher;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Verifica se il content type ricevuto nella request e' accettabile o presenta problemi di sicurezza  
 *
 * @author CSIPiemonte
 */
public class ContentTypeValidatorFilter implements Filter {

	final static private String CONTENT_TYPE_REJECT_REGEXP = "^\\s*.*form-data\\.*.*xwork2.*";

	final static private java.util.regex.Pattern REJECT_PATTERN = java.util.regex.Pattern
			.compile(CONTENT_TYPE_REJECT_REGEXP);

	private boolean acceptableContentType(String ct) {
		if (ct == null) {
			return true;
		} else {
			java.util.regex.Matcher m = REJECT_PATTERN.matcher(ct);
			return !m.matches();
		}
	}

	/**
	 * effettua la verifica
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fchn)
			throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) req;
		String ct = hreq.getContentType();
		if (acceptableContentType(ct)) {
			fchn.doFilter(req, resp);
			return;
		} else {
			throw new ServletException("ricevuto ContentType non ammissibile: [" + ct + "] - rigetto richiesta");
		}
	}

	/**
	 * non fa nulla alla distruzione del filter
	 */
	public void destroy() {

	}

	/**
	 * non fa nulla all'inizializzazione del filter
	 */
	public void init(FilterConfig arg0) throws ServletException {

	}

}
