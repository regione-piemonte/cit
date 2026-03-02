package it.csi.sigit.citpdnd.api.impl;


import jakarta.annotation.security.RolesAllowed;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.ext.Provider;

import it.csi.sigit.citpdnd.api.StatusApi;

@Provider
public class StatusApiServiceImpl implements StatusApi{

    @Override
    @RolesAllowed({"reader"})
    public Response statusGet(SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        return Response.ok("Status OK").build();
    }
    
}