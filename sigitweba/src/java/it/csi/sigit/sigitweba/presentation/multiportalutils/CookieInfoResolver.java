package it.csi.sigit.sigitweba.presentation.multiportalutils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Resolver di informazioni multiportale via Cookie.
 *
 * @author CSIPiemonte
 */
public class CookieInfoResolver implements InfoResolver {

	public String resolve(String infoSourceName, HttpServletRequest hreq) {
		Cookie c = MultiPortalUtil.getCookie(infoSourceName, hreq.getCookies());
		if (c != null) {
			return c.getValue();
		}
		return null;
	}

}
