package it.csi.sigit.sigitweba.presentation.sigitweba.filter;

import it.csi.iride2.policy.entity.Identita;
import it.csi.iride2.policy.exceptions.MalformedIdTokenException;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.*;
import it.csi.sigit.sigitweba.util.*;

/**
 * Gestisce la validit&agrave; della sessione applicativa. 
 *
 * @author CSIPiemonte
 */
public class AppSessionGuardFilter implements Filter {

	public static final String VALID_APP_SESSION_SESSIONATTR = "valid_app_session";

	/**  */
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".security");

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fchn)
			throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) req;
		String sessMark = (String) hreq.getSession().getAttribute(VALID_APP_SESSION_SESSIONATTR);
		if (sessMark != null) {
			// sessione gia' valida: vai avanti
			LOG.debug("[AppSessionGuardFilter::doFilter] sessione applicativa valida. proseguo ");
			fchn.doFilter(req, resp);
			return;
		} else {
			// se la sessione non e' valida si discrimina in base alla pagina richiesta:
			// HomePage, error &co o altra pagina?
			if (isHomePage(hreq.getRequestURI())) {
				LOG.info(
						"[AppSessionGuardFilter::doFilter] richiesta home page a sessione applicativa non valida: proseguo e imposto la validita'");
				hreq.getSession().setAttribute(VALID_APP_SESSION_SESSIONATTR, VALID_APP_SESSION_SESSIONATTR);
				fchn.doFilter(req, resp);
				return;
			} else {
				// siamo gia' nella pagina di sessione scaduta?
				if (!mustCheckPage(hreq.getRequestURI())) {
					fchn.doFilter(req, resp);
					return;
				} else {
					LOG.info(
							"[AppSessionGuardFilter::doFilter] richiesta pagina differente dalla home a sessione applicativa non valida: redirezione alla pagina di sessione scaduta");
					/// REDIRECT....
					HttpServletResponse hresp = (HttpServletResponse) resp;
					hresp.sendRedirect(hreq.getContextPath() + "/base/sessionExpired.do");
					return;
				}
			}
		}

	}

	private boolean isHomePage(String requestURI) {
		if (requestURI.indexOf("HomePage.do") > -1 || requestURI.endsWith("/") || requestURI.indexOf("index.jsp") > -1)
			return true;
		else
			return false;
	}

	private boolean mustCheckPage(String requestURI) {
		if (requestURI.indexOf("HomePage.do") > -1 || requestURI.indexOf("sessionExpired.do") > -1
				|| requestURI.indexOf("fatalError") > -1 || requestURI.indexOf("notFoundError") > -1
				|| requestURI.indexOf("sessionExpired.jsp") > -1 || requestURI.indexOf("Logout") > -1
				|| requestURI.indexOf("unknownPortal") > -1)
			return false;
		else
			return true;
	}

	public void destroy() {
		// NOP
	}

	public void init(FilterConfig arg0) throws ServletException {
		// NOP
	}
}
