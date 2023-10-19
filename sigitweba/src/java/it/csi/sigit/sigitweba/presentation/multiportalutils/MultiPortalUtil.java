package it.csi.sigit.sigitweba.presentation.multiportalutils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.commons.lang.StringUtils;

/**
 * <p>Classe di utilit&agrave; per la gestione del Multiportale.</p>
 *
 * @author CSIPiemonte
 */
public class MultiPortalUtil {

	public static final String PORTAL_REQUEST_ATTRIBUTE = "portal";

	public static final String MDD_PORTAL_COOKIE_NAME = "MDDPORTAL";

	public static final String MDD_PORTAL_SESSIONATTR = "MDD_PORTAL_CODE";
	public static final String MDD_CHANNEL_SESSIONATTR = "MDD_CHANNEL_CODE";
	public static final String MDD_PORTAL_HOME_SESSIONATTR = "MDD_PORTAL_HOME";

	public static final String NAMESPACE = "/sigitweba/base/";
	public static final String ERROR_ACTION = "unknownPortal.do";
	public static final String ERROR_PAGE = "unknownPortal.jsp";

	public static final String DEFAULT_CHANNEL_NAME = "general";

	@SuppressWarnings("serial")
	private static final Map<String, String> AVAILABLE_CHANNEL_NAMES = Collections
			.unmodifiableMap(new HashMap<String, String>() {
				{
					put("sisp", "sisp7");
					put("rupar", "sisp7");
				}
			});

	public static boolean isSetCookie(String cookieName, Cookie[] cookies) {
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					return true;
				}
			}
		}
		return false;
	}

	public static Cookie getCookie(String cookieName, Cookie[] cookies) {
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					return cookie;
				}
			}
		}
		return null;
	}

	public static boolean mustCheckPage(String requestURI) {
		if (requestURI.indexOf(ERROR_ACTION) > -1 || requestURI.indexOf(ERROR_PAGE) > -1
				|| requestURI.indexOf("/?") > -1 || requestURI.endsWith("/")) {
			return false;
		} else {
			return true;
		}
	}

	public static String getResourceProvider(Cookie[] cookies) {
		return getPortalName(getCookie(MDD_PORTAL_COOKIE_NAME, cookies));
	}

	public static String getChannelName(String portal) {
		String channelName = AVAILABLE_CHANNEL_NAMES.get(portal);
		if (StringUtils.isBlank(channelName)) {
			channelName = DEFAULT_CHANNEL_NAME;
		}
		return channelName;
	}

	public static String getStaticResource(String url, String portal) {
		return url.replace("{areaCode}", getChannelName(portal));
	}

	private static String getPortalName(Cookie cookie) {
		String res = "";
		if (cookie != null) {
			res = cookie.getValue();
		}
		return res;
	}

}
