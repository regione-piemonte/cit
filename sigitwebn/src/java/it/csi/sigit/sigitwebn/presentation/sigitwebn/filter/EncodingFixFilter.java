package it.csi.sigit.sigitwebn.presentation.sigitwebn.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Forza l'encoding di richiesta e risposta a UTF-8, per evitare problemi
 * di visualizzazione di caratteri speciali/accentati 
 *
 * @author CSIPiemonte
 */
public class EncodingFixFilter implements Filter {

	/**
	 * Imposta l'encoding della richiesta e della risposta a UTF-8
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fchn)
			throws IOException, ServletException {
		// imposta gli encoding
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// continua con gli altri filtri...
		fchn.doFilter(req, resp);
		return;
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
