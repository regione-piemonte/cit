package it.csi.sigit.sigitwebn.presentation.sigitwebn.filter;

import it.csi.sigit.sigitwebn.presentation.multiportalutils.*;
import it.csi.sigit.sigitwebn.util.*;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Gestisce la provenienza dell'utente (multiportale).
 *
 * @author CSIPiemonte
 */
public class WhereAreYouFromFilter implements Filter {

	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".presentation");

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fchn)
			throws IOException, ServletException {

		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hresp = (HttpServletResponse) resp;

		// la risorsa richiesta deve essere esclusa
		if (!MultiPortalUtil.mustCheckPage(hreq.getRequestURI())) {
			fchn.doFilter(req, resp);
			return;
		}

		// il cookie di portale MDD esiste?
		if (!MultiPortalUtil.isSetCookie(MultiPortalUtil.MDD_PORTAL_COOKIE_NAME, hreq.getCookies())) {
			LOG.info("[WhereAreYouFromFilter::doFilter] COOKIE DI PORTALE NON SETTATO => DEVO SETTARLO");

			if (hreq.getAttribute(MultiPortalUtil.PORTAL_REQUEST_ATTRIBUTE) != null) {
				String decodedPortal = (String) hreq.getAttribute(MultiPortalUtil.PORTAL_REQUEST_ATTRIBUTE);

				// setto il cookie MDD
				Cookie portalInfo = new Cookie(MultiPortalUtil.MDD_PORTAL_COOKIE_NAME, decodedPortal);
				portalInfo.setPath(hreq.getContextPath());
				portalInfo.setMaxAge(-1); // scadenza sessione browser

				// setto il cookie MDD
				hresp.addCookie(portalInfo);

				// i parametri di sessione sono settati?
				if (hreq.getSession().getAttribute(MultiPortalUtil.MDD_PORTAL_SESSIONATTR) == null) {
					LOG.info("[WhereAreYouFromFilter::doFilter] PARAMETRI DI SESSIONE NON SETTATI => DEVO SETTARLI");

					hreq.getSession().setAttribute(MultiPortalUtil.MDD_PORTAL_SESSIONATTR, decodedPortal);

					String channelName = MultiPortalUtil.getChannelName(decodedPortal);
					hreq.getSession().setAttribute(MultiPortalUtil.MDD_CHANNEL_SESSIONATTR, channelName);

					String portalHome = hreq.getSession().getServletContext()
							.getInitParameter("portal.home." + decodedPortal);
					hreq.getSession().setAttribute(MultiPortalUtil.MDD_PORTAL_HOME_SESSIONATTR,
							portalHome != null && portalHome.length() > 0 ? portalHome : "#");
				}

				fchn.doFilter(req, resp);
				return;
			} else {
				// NO parametro: ERRORE
				LOG.error("[WhereAreYouFromFilter::doFilter] ERRORE: REQUEST ATTRIBUTE "
						+ MultiPortalUtil.PORTAL_REQUEST_ATTRIBUTE + " MANCANTE");
				hresp.sendRedirect(MultiPortalUtil.NAMESPACE + MultiPortalUtil.ERROR_ACTION);
				return;
			}
		} else {
			// il cookie esiste: i parametri in sessione sono settati ?
			if (hreq.getSession().getAttribute(MultiPortalUtil.MDD_PORTAL_SESSIONATTR) == null) {
				LOG.info("[WhereAreYouFromFilter::doFilter] PARAMETRI DI SESSIONE NON SETTATI => DEVO SETTARLI");

				String portalName = MultiPortalUtil.getResourceProvider(hreq.getCookies());
				hreq.getSession().setAttribute(MultiPortalUtil.MDD_PORTAL_SESSIONATTR, portalName);

				String channelName = MultiPortalUtil.getChannelName(portalName);
				hreq.getSession().setAttribute(MultiPortalUtil.MDD_CHANNEL_SESSIONATTR, channelName);

				String portalHome = hreq.getSession().getServletContext().getInitParameter("portal.home." + portalName);
				hreq.getSession().setAttribute(MultiPortalUtil.MDD_PORTAL_HOME_SESSIONATTR,
						portalHome != null && portalHome.length() > 0 ? portalHome : "#");
			}
		}

		// se il cookie di portale MDD esiste ed e' valido, 
		// se i parametri in sessione esistono,
		// allora posso proseguire
		fchn.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {
		// NOTHING TO DO HERE
	}

	public void destroy() {
		// NOTHING TO DO HERE
	}

}
