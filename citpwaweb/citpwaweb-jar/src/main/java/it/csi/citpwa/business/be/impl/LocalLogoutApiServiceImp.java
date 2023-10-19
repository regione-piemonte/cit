/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.be.impl;

import it.csi.citpwa.business.be.ILocalLogoutApi;
import it.csi.citpwa.business.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Component
public class LocalLogoutApiServiceImp implements ILocalLogoutApi {
	
	@Autowired
    private IAuthenticationService authService;
	
	public Response localLogout(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {
		authService.localLogout(req);
		return Response.ok().build();
	}
}
