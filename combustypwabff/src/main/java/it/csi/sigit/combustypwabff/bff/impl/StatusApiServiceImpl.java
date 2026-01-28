package it.csi.sigit.combustypwabff.bff.impl;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.ext.Provider;

import it.csi.sigit.combustypwabff.bff.StatusApi;

@Provider
public class StatusApiServiceImpl implements StatusApi{

    @Override
    public Response getStatus(SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        return Response.ok("ok").build();
    }
    
}