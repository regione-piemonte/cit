package it.csi.sigit.sigitweba.presentation.multiportalutils;

import java.net.MalformedURLException;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

/**
 * Resolver di informazioni multiportale via URL di richiesta.
 *
 * @author CSIPiemonte
 */
public class RequestUrlInfoResolver implements InfoResolver {

	private static final String DOMAIN_L2 = "DOMAIN_L2";
	private static final String DOMAIN_L3 = "DOMAIN_L3";

	/**
	 * @param infoSourceName puo' valere solo: DOMAIN_L2 o DOMAIN_L3
	 * @param la request HTTP
	 */
	public String resolve(String infoSourceName, HttpServletRequest hreq) {
		String s_url = hreq.getRequestURL().toString();
		String ris = null;
		if (DOMAIN_L2.equalsIgnoreCase(infoSourceName)) {
			ris = getDomainNameToSpecifiedLevel(s_url, 2);
		} else if (DOMAIN_L3.equalsIgnoreCase(infoSourceName)) {
			ris = getDomainNameToSpecifiedLevel(s_url, 3);
		}
		return ris;
	}

	/**
	 * estrae dall'url il nome del dominio fino al livello specificato
	 * @param s_url l'url completo della richiesta
	 * @param l il livello fino a cui estrarre (es: 2=csi.it, 3=intranet.csi.it, ...)
	 * @return l'url fino al livello specificato o null in caso di errore
	 */
	private String getDomainNameToSpecifiedLevel(String s_url, int l) {
		// attualmente gestiti solo 
		if (l != 1 && l != 2) {
			return null;
		} else
			try {
				java.net.URL url = new java.net.URL(s_url);
				String host = url.getHost();
				// se la richiesta non arriva da un host ma da un ip,
				// getHost() restituisce [ip.ip.ip.ip]
				if (host != null && host.startsWith("[")) {
					return null;
				} else {
					StringTokenizer strtok = new StringTokenizer(host, ".");
					int ntoks = strtok.countTokens();
					for (int i = 0; i < ntoks - l; i++) {
						String currTok = (String) strtok.nextElement();
					}
					// da qui in poi vanno presi e ricostruiti
					StringBuffer ris = new StringBuffer("");
					for (int j = 0; j < l; j++) {
						String currTok = (String) strtok.nextElement();
						ris.append(currTok);
						if (j < l - 1) {
							ris.append(".");
						}
					}
					return ris.toString();
				}
			} catch (MalformedURLException e) {
				return null;
			}
	}
}
