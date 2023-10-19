package it.csi.sigit.sigitwebn.presentation.sigitwebn.filter;

import it.csi.sigit.sigitwebn.presentation.multiportalutils.*;
import it.csi.sigit.sigitwebn.util.*;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * Gestisce la provenienza dell'utente (multiportale).
 *
 * @author CSIPiemonte
 */
public class WhereAreYouFromRequestAdapterFilter implements Filter {

	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".presentation");

	private String infoSourceType;

	private String infoSourceName;

	private Map<String, String> valueMap;

	private static final String DEVMODE_PARAM = "devmode";

	private boolean devmode;

	public void init(FilterConfig config) throws ServletException {
		infoSourceType = config.getInitParameter("infoSourceType");
		infoSourceName = config.getInitParameter("infoSourceName");
		LOG.debug("[WhereAreYouFromRequestAdapterFilter::init] - source type=" + infoSourceType + ", sourceName="
				+ infoSourceName);
		valueMap = setValueMap(config);
		String s_devmode = config.getServletContext().getInitParameter(DEVMODE_PARAM);
		if (!StringUtils.isBlank(s_devmode) && "true".equals(s_devmode)) {
			devmode = true;
			LOG.warn(
					"[WhereAreYouFromRequestAdapterFilter::init] - modalita' di sviluppo ATTIVA - non deve essere attivata in ambiente di esercizio!");
		} else {
			devmode = false;
		}
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fchn)
			throws IOException, ServletException {

		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hresp = (HttpServletResponse) resp;

		// la pagina di errore deve essere esclusa
		if (!MultiPortalUtil.mustCheckPage(hreq.getRequestURI())) {
			fchn.doFilter(req, resp);
			return;
		}

		// se e' gia' impostato il cookie di portale non serve piu' effettuare
		// la decodifica
		if (!MultiPortalUtil.isSetCookie(MultiPortalUtil.MDD_PORTAL_COOKIE_NAME, hreq.getCookies())) {
			String portal = null;

			try {
				// REPERISCO l'informazione secondo il metodo configurato
				portal = getResolver().resolve(infoSourceName, hreq);
				if (StringUtils.isBlank(portal)) {
					// informazione non trovata secondo il metodo indicato: se mod. sviluppo provo con il 'salvagente'
					// (per il momento provo solo a reperire la info non faccio ancora la decodifica) 
					if (devmode) {
						LOG.debug(
								"[WhereAreYouFromRequestAdapterFilter::doFilter] DEVMODE=true => provo con il resolver di salvataggio...");
						portal = getDevModeResolver().resolve(infoSourceName, hreq);
					}
					// se continua ad essere nulla => ERRORE
					if (StringUtils.isBlank(portal)) {
						LOG.error(
								"[WhereAreYouFromRequestAdapterFilter::doFilter] Informazione sul portale non reperibile. infoSourceType:"
										+ infoSourceType + " infoSourceName:" + infoSourceName);
						hresp.sendRedirect(MultiPortalUtil.NAMESPACE + MultiPortalUtil.ERROR_ACTION);
						return;
					}
				}
				// L'informazione ESISTE (ma potrebbe essere errata): la DECODIFICO
				String decodedPortal = decodePortalInfo(portal);
				if (StringUtils.isBlank(decodedPortal)) {
					// in caso di devmode=true riprovo con il parametro di salvataggio
					if (devmode) {
						LOG.debug(
								"[WhereAreYouFromRequestAdapterFilter::doFilter] DEVMODE=true => provo con il resolver di salvataggio...");
						portal = getDevModeResolver().resolve(infoSourceName, hreq);
						// riprovo la decodifica
						decodedPortal = decodePortalInfo(portal);
					}
					if (StringUtils.isBlank(decodedPortal)) {
						LOG.error("[WhereAreYouFromRequestAdapterFilter::doFilter] informazione non decodificabile "
								+ portal);
						hresp.sendRedirect(MultiPortalUtil.NAMESPACE + MultiPortalUtil.ERROR_ACTION);
						return;
					}
				}
				// se arrivo qui ho trovato il portale decodificato 
				// setto l'informazione in request in modo che il filtro WhereAreYouFromFilter possa leggerlo
				hreq.setAttribute(MultiPortalUtil.PORTAL_REQUEST_ATTRIBUTE, decodedPortal);
				LOG.info("[WhereAreYouFromRequestAdapterFilter::doFilter] Portale decodificato : " + decodedPortal);
				fchn.doFilter(req, resp);
				return;

			} catch (Exception e) {
				// resolver non trovato secondo la configurazione: ERRORE
				LOG.error("[WhereAreYouFromRequestAdapterFilter::doFilter] Type resolver sconosciuto. infoSourceType:"
						+ infoSourceType);
				hresp.sendRedirect(MultiPortalUtil.NAMESPACE + MultiPortalUtil.ERROR_ACTION);
				return;
			}

		}

		// se il cookie di portale MDD esiste ed e' valido, posso proseguire
		fchn.doFilter(req, resp);
	}

	public void destroy() {
		// NOTHING TO DO HERE
	}

	@SuppressWarnings("unchecked")
	private Map<String, String> setValueMap(FilterConfig config) {
		Map<String, String> map = new HashMap<String, String>();

		List<String> paramNames = Collections.list((Enumeration<String>) config.getInitParameterNames());
		for (String p : paramNames) {
			if (p.startsWith("key.")) {
				map.put(config.getInitParameter(p), p.substring(4));
			}
		}

		return map;
	}

	private String decodePortalInfo(String portalInfo) {
		String res = null;
		if (StringUtils.isNotBlank(portalInfo)) {
			res = valueMap.get(portalInfo);
		}
		return res;
	}

	/**
	 * restituisce il resolver effettivo
	 */
	private InfoResolver getResolver() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		return getResolver_internal(this.infoSourceType);
	}

	/**
	 * restituisce sempre il Param resolver
	 */
	private InfoResolver getDevModeResolver()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		return getResolver_internal("RequestParam");
	}

	/**
	 * metodo interno per instanziare il resolver
	 */
	private InfoResolver getResolver_internal(String resolverName)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String className = "it.csi.sigit.sigitwebn.presentation.multiportalutils." + resolverName + "InfoResolver";
		Class c = Class.forName(className);
		return (InfoResolver) c.newInstance();
	}

}
