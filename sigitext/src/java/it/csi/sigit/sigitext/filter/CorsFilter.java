package it.csi.sigit.sigitext.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		if (enableCors) {
			HttpServletResponse res = (HttpServletResponse) servletResponse;
			res.setHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		}
		chain.doFilter(servletRequest, servletResponse);

	}

	private static final String ENABLECORS_INIT_PARAM = "enablecors";
	private boolean enableCors = false;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String sEnableCors = filterConfig.getInitParameter(ENABLECORS_INIT_PARAM);
		if ("true".equals(sEnableCors)) {
			enableCors = true;
		} else {
			enableCors = false;
		}
	}

	@Override
	public void destroy() {
	}

}