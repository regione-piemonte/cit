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
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import it.csi.citpwa.filter.iride.entity.Identita;
import it.csi.citpwa.filter.iride.exception.MalformedIdTokenException;
import it.csi.citpwa.model.sigitext.PFLoggato;
import it.csi.citpwa.model.sigitext.RuoloLoggato;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import org.apache.log4j.Logger;

import it.csi.citpwa.util.Constants;

/**
 * Inserisce in sessione:
 * <ul>
 * <li>l'identit&agrave; digitale relativa all'utente autenticato.
 * <li>l'oggetto <code>currentUser</code>
 * </ul>
 * Funge da adapter tra il filter del metodo di autenticaizone previsto e la
 * logica applicativa.
 *
 * @author CSIPiemonte
 */
public class IrideIdAdapterFilter implements Filter {

	/**
	 *
	 */
	protected static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fchn) throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) req;

		log.debug("###############");
		log.debug("stampaParametriRequest getHeaderNames");
		Enumeration<String> names = hreq.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			Object value = hreq.getHeader(name);
			log.debug("Attributo: " + name + " --> " + value);
		}
		log.debug("###############");

		String header = hreq.getHeader(Constants.HEADER_PORTALE);

		log.debug("############HEADER##########: "+header);

		if (hreq.getSession().getAttribute(Constants.IRIDE_ID_SESSIONATTR) == null) {
			String marker = getToken(hreq);
			if (marker != null) {
				try {
					Identita identita = new Identita(normalizeToken(marker));
					log.debug("[IrideIdAdapterFilter::doFilter] Inserito in sessione marcatore IRIDE:" + identita);
					hreq.getSession().setAttribute(Constants.IRIDE_ID_SESSIONATTR, identita);
					UtenteLoggato userInfo = new UtenteLoggato();
					userInfo.setPfLoggato(new PFLoggato());
					userInfo.getPfLoggato().setNomePF(identita.getNome());
					userInfo.getPfLoggato().setCognomePF(identita.getCognome());
					userInfo.getPfLoggato().setCodiceFiscalePF(identita.getCodFiscale());
					userInfo.setRuoloLoggato(new RuoloLoggato());
					hreq.getSession().setAttribute(Constants.USERINFO_SESSIONATTR, userInfo);
				} catch (MalformedIdTokenException e) {
					log.error("[IrideIdAdapterFilter::doFilter] " + e.toString(), e);
				}
			} else {
				// il marcatore deve sempre essere presente altrimenti e' una
				// condizione di errore (escluse le pagine home e di servizio)
				if (mustCheckPage(hreq.getRequestURI())) {
					log.error("[IrideIdAdapterFilter::doFilter] Tentativo di accesso a pagina non home e non di servizio senza token di sicurezza");
					throw new ServletException("Tentativo di accesso a pagina non home e non di servizio senza token di sicurezza");
				}
			}
		}

		log.debug("[IrideIdAdapterFilter::doFilter] req: " + req);
		log.debug("[IrideIdAdapterFilter::doFilter] resp: " + resp);

		fchn.doFilter(req, resp);

	}

	private boolean mustCheckPage(String requestURI) {

		return true;
	}

	@Override
	public void destroy() {
		// NOP
	}

	private static final String DEVMODE_INIT_PARAM = "devmode";

	private boolean devmode = false;

	@Override
	public void init(FilterConfig fc) throws ServletException {
		String sDevmode = fc.getInitParameter(DEVMODE_INIT_PARAM);
		devmode = "true".equals(sDevmode);
	}

	public String getToken(HttpServletRequest httpreq) {
		String marker = httpreq.getHeader(Constants.AUTH_ID_MARKER);
		if (marker != null) {
			// gestione dell'encoding
			return new String(marker.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
		} else if (devmode) {
			return getTokenDevMode(httpreq);
		}

		return null;
	}

	private String getTokenDevMode(HttpServletRequest httpreq) {
		return httpreq.getParameter(Constants.AUTH_ID_MARKER);
	}

	private String normalizeToken(String token) {
		return token;
	}

}
