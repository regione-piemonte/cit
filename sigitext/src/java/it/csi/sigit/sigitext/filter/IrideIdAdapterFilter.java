package it.csi.sigit.sigitext.filter;

import it.csi.iride2.policy.entity.Identita;
import it.csi.iride2.policy.exceptions.MalformedIdTokenException;

import it.csi.sigit.sigitext.business.util.Constants;
import org.apache.log4j.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Inserisce in sessione:
 * <ul> 
 *  <li>l'identit&agrave; digitale relativa all'utente autenticato.
 *  <li>l'oggetto <code>currentUser</code>
 * </ul>
 * Funge da adapter tra il filter del metodo di autenticaizone previsto e la
 * logica applicativa.
 *
 * @author CSIPiemonte
 */
public class IrideIdAdapterFilter implements Filter {

	public static final String IRIDE_ID_SESSIONATTR = "iride2_id";

	public static final String AUTH_ID_MARKER = "Shib-Iride-IdentitaDigitale";

	public static final String USERINFO_SESSIONATTR = "appDatacurrentUser";

	/**  */
	protected static final Logger LOG = Logger.getLogger(Constants.COMPONENT_NAME + ".security");

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fchn)
			throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) req;
		if (hreq.getSession().getAttribute(IRIDE_ID_SESSIONATTR) == null) {
			String marker = getToken(hreq);
			if (marker != null) {
				try {
					Identita identita = new Identita(normalizeToken(marker));
					LOG.debug("[IrideIdAdapterFilter::doFilter] Inserito in sessione marcatore IRIDE:" + identita);
					hreq.getSession().setAttribute(IRIDE_ID_SESSIONATTR, identita);
					it.csi.sigit.sigitext.dto.test.UserInfo userInfo = new it.csi.sigit.sigitext.dto.test.UserInfo();
					userInfo.setNome(identita.getNome());
					userInfo.setCognome(identita.getCognome());
					userInfo.setEnte("--");
					userInfo.setRuolo("--");
					userInfo.setCodFisc(identita.getCodFiscale());
					userInfo.setLivAuth(identita.getLivelloAutenticazione());
					userInfo.setCommunity(identita.getIdProvider());
					hreq.getSession().setAttribute(USERINFO_SESSIONATTR, userInfo);
				} catch (MalformedIdTokenException e) {
					LOG.error("[IrideIdAdapterFilter::doFilter] " + e.toString(), e);
				}
			} else {
				// il marcatore deve sempre essere presente altrimenti e' una 
				// condizione di errore (escluse le pagine home e di servizio)
				if (mustCheckPage(hreq.getRequestURI())) {
					LOG.error(
							"[IrideIdAdapterFilter::doFilter] Tentativo di accesso a pagina non home e non di servizio senza token di sicurezza");
					throw new ServletException(
							"Tentativo di accesso a pagina non home e non di servizio senza token di sicurezza");
				}
			}
		}

		fchn.doFilter(req, resp);

	}

	private boolean mustCheckPage(String requestURI) {

		return true;
	}

	public void destroy() {
		// NOP
	}

	private static final String DEVMODE_INIT_PARAM = "devmode";

	private boolean devmode = false;

	public void init(FilterConfig fc) throws ServletException {
		String sDevmode = fc.getInitParameter(DEVMODE_INIT_PARAM);
		if ("true".equals(sDevmode)) {
			devmode = true;
		} else {
			devmode = false;
		}
	}

	public String getToken(HttpServletRequest httpreq) {
		String marker = (String) httpreq.getHeader(AUTH_ID_MARKER);
		if (marker == null && devmode) {
			return getTokenDevMode(httpreq);
		} else {
			try {
				// gestione dell'encoding
				String decodedMarker = new String(marker.getBytes("ISO-8859-1"), "UTF-8");
				return decodedMarker;
			} catch (java.io.UnsupportedEncodingException e) {
				// se la decodifica non funziona comunque sempre meglio restituire 
				// il marker originale non decodificato
				return marker;
			}
		}
	}

	private String getTokenDevMode(HttpServletRequest httpreq) {
		String marker = (String) httpreq.getParameter(AUTH_ID_MARKER);
		return marker;
	}

	private String normalizeToken(String token) {
		return token;
	}

}
