package it.csi.sigit.combustypwabff.filter;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.inject.Instance;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Cookie;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.eclipse.microprofile.config.inject.ConfigProperty;


//@Provider
public class XSRFTokenValidationFilter implements ContainerRequestFilter {

    public static final String COMPONENT_NAME = "combustypwabff";

    final static Logger LOG = Logger.getLogger(COMPONENT_NAME + ".security");

    final static List<String> SECURE_HTTP_METHODS = new ArrayList<String>();

    /** disable validation (for use in development mode) */
    @ConfigProperty(name = "xsrf.validation.disabled", defaultValue = "false")
    Instance<Boolean> disabled;

    /**
     * nome dell'header XSRF che la componente client deve inserire ad ogni
     * richiesta rest
     */
    private static final String XSRF_HEADER_NAME = "X-XSRF-TOKEN";

    /*
     * nome del cookie XSRF
     */
    private static final String XSRF_COOKIE_NAME = "XSRF-TOKEN";

    private static final Response INVALID_CSRF_TOKEN_RESPONSE = Response.status(Response.Status.BAD_REQUEST)
            .entity("A valid CSRF token must be provided via the unambiguous header field: " + XSRF_HEADER_NAME
                    + " and cookie: " + XSRF_COOKIE_NAME)
            .build();

    static {
        SECURE_HTTP_METHODS.add("GET");
        SECURE_HTTP_METHODS.add("POST");
        SECURE_HTTP_METHODS.add("PUT");
    }


    @Override
    public void filter(ContainerRequestContext requestContext) {
        LOG.debug("[XSRFTokenValidationFilter::filter] START");

        if (!disabled.get()){
            // No check for "secure" HTTP methods
            if (SECURE_HTTP_METHODS.contains(requestContext.getMethod())) {
                return;
            }

            Cookie csrfTokenCookie = requestContext.getCookies().get(XSRF_COOKIE_NAME);
            List<String> csrfTokenHeader = requestContext.getHeaders().get(XSRF_HEADER_NAME);

            // Check if the CSRF token header and cookie is present,
            // the header has an unambiguous value and both values
            // must match.
            if (csrfTokenCookie == null || csrfTokenHeader == null
                    || csrfTokenHeader.size() != 1
                    || !csrfTokenHeader.get(0).equals(csrfTokenCookie.getValue())) {
                LOG.error("[XSRFTokenValidationFilter::filter] cookie/header not present/valid");
                requestContext.abortWith(INVALID_CSRF_TOKEN_RESPONSE);
                LOG.debug("[XSRFTokenValidationFilter::filter] END");
                return;
            }
            LOG.debug("[XSRFTokenValidationFilter::filter] XSRF validation: OK");
            LOG.debug("[XSRFTokenValidationFilter::filter] END");
        }
        else {
            LOG.debug("[XSRFTokenValidationFilter::filter] skipping validation (disabled)");
            LOG.debug("[XSRFTokenValidationFilter::filter] END");
            return;
        }
        
    }
}