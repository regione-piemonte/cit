package it.csi.sigit.combustypwabff.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.NewCookie;
import org.apache.log4j.Logger;

import java.util.UUID;


//@Provider
public class XSRFTokenIssuerFilter implements ContainerResponseFilter {

  public static final String COMPONENT_NAME = "combustypwabff";

  final static Logger LOG = Logger.getLogger(COMPONENT_NAME + ".security");

  /*
   * nome del cookie XSRF
   */
  private static final String XSRF_COOKIE_NAME = "XSRF-TOKEN";

  @Override
  public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
    LOG.debug("[XSRFTokenIssuerFilter::filter] START");

    // Check if cookie already exists
    if (requestContext.getCookies().containsKey(XSRF_COOKIE_NAME)) {
      LOG.debug("[XSRFTokenIssuerFilter::filter] no need to create a new token");
      LOG.debug("[XSRFTokenIssuerFilter::filter] END");
      return;
    }

    // Issue a new token
    LOG.debug("[XSRFTokenIssuerFilter::filter] creating a new random token");
    String randomToken = UUID.randomUUID().toString();
    var tokenCookie = new NewCookie(XSRF_COOKIE_NAME, randomToken, "/", null, null, -1, true, false);
    responseContext.getHeaders().add("Set-Cookie", tokenCookie);
    LOG.debug("[XSRFTokenIssuerFilter::filter] END");
  }
}