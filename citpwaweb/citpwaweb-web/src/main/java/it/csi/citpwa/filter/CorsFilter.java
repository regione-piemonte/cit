/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

	private static final String ENABLECORS_INIT_PARAM = "enablecors";
	private boolean enableCors = false;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		if (enableCors) {
			HttpServletResponse res = (HttpServletResponse) servletResponse;
			res.setHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
			res.setHeader("Access-Control-Allow-Headers", "Content-Type");
		}
		chain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String sEnableCors = filterConfig.getInitParameter(ENABLECORS_INIT_PARAM);
		enableCors = "true".equals(sEnableCors);
	}

	@Override
	public void destroy() {
	}

}