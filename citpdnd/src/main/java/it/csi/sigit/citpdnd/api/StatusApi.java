package it.csi.sigit.citpdnd.api;

import it.csi.sigit.citpdnd.api.dto.*;


import it.csi.sigit.citpdnd.api.dto.Error;

import java.util.List;
import java.util.Map;

import java.io.InputStream;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.validation.constraints.*;
@Path("/status")


public interface StatusApi  {
   
    /**
     * summary = 
     * description = ping
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = OK<br>
           schema implementation = { @see String }</p>
         </li>
         <li>    
           <p>responseCode = 401, description = Authentication information is missing or invalid<br>
           schema implementation = { @see Error }</p>
         </li>
       </ul>
    */
    @GET
    
    
    @Produces({ "application/json", "application/problem+json" })
    Response statusGet(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
