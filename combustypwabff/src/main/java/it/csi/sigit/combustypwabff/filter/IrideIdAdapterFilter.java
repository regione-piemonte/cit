package it.csi.sigit.combustypwabff.filter;

import it.csi.sigit.combustypwabff.bff.dto.UserInfo;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


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
@Provider
public class IrideIdAdapterFilter implements ContainerRequestFilter {

    public static final String COMPONENT_NAME = "combustypwabff";

    public static final String STATUS = "/status";

    public static final String IRIDE_ID_SESSIONATTR = "iride2_id";

    public static final String AUTH_ID_MARKER = "Shib-Iride-IdentitaDigitale";

    public static final String USERINFO_SESSIONATTR = "currentUser";

    protected static final Logger LOG = Logger.getLogger(COMPONENT_NAME + ".security");


    private boolean mustCheckPage(String requestURI) {
        return !STATUS.equals(requestURI);
    }

    
    public String getToken(ContainerRequestContext httpreq) {
        String marker = httpreq.getHeaderString(AUTH_ID_MARKER);
        try {
            // gestione dell'encoding
            return new String(marker.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        } catch (NullPointerException npe){
            return marker;
        } 
    }


    private String normalizeToken(String token) {
        return token;
    }

    @Override
    public void filter(ContainerRequestContext requestContext)
            throws IOException {
        LOG.debug("[IrideIdAdapterFilter::filter] START");
            String marker = getToken(requestContext);
            if (marker != null) {
                try {
                    it.csi.iride2.policy.entity.Identita identita = new it.csi.iride2.policy.entity.Identita(
                            normalizeToken(marker));
                    LOG.debug("[IrideIdAdapterFilter::doFilter] Inserito in sessione marcatore IRIDE:" + identita);
                    requestContext.setProperty(IRIDE_ID_SESSIONATTR, identita);
                    UserInfo userInfo = new UserInfo();
                    userInfo.setNome(identita.getNome());
                    userInfo.setCognome(identita.getCognome());
                    userInfo.setEnte("--");
                    userInfo.setRuolo("--");
                    userInfo.setCodFisc(identita.getCodFiscale());
                    userInfo.setLivAuth(identita.getLivelloAutenticazione());
                    userInfo.setCommunity(identita.getIdProvider());
                    requestContext.setProperty(USERINFO_SESSIONATTR, userInfo);
                    LOG.debug("[IrideIdAdapterFilter::filter] END");
                } catch (Exception e) {
                    LOG.error("[IrideIdAdapterFilter::doFilter] " + e.toString(), e);
                    throw new IOException("errore nella parsificazione dell'header di autenticazione", e);
                }
            } else {
                // il marcatore deve sempre essere presente altrimenti e' una
                // condizione di errore (escluse le pagine home e di servizio)
                if (mustCheckPage(requestContext.getUriInfo().getPath())) {
                    LOG.error(
                            "[IrideIdAdapterFilter::doFilter] Tentativo di accesso a pagina non home e non di servizio senza token di sicurezza");
                    throw new IOException(
                            "Tentativo di accesso a pagina non home e non di servizio senza token di sicurezza");
                }
            }
    }
}