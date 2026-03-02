package it.csi.sigit.citpdnd.api;

import it.csi.sigit.citpdnd.api.dto.*;


import java.math.BigDecimal;
import it.csi.sigit.citpdnd.api.dto.Error;
import java.io.File;
import it.csi.sigit.citpdnd.api.dto.ListaImpianti;

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
@Path("/impianti")


public interface ImpiantiApi  {
   
    /**
     * summary = 
     * description = 
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = OK<br>
           schema implementation = { @see ListaImpianti }</p>
         </li>
         <li>    
           <p>responseCode = 400, description = Bad Request<br>
           schema implementation = { @see Error }</p>
         </li>
         <li>    
           <p>responseCode = 401, description = Authentication information is missing or invalid<br>
           schema implementation = { @see Error }</p>
         </li>
         <li>    
           <p>responseCode = 403, description = User is forbidden to access the resource<br>
           schema implementation = { @see Error }</p>
         </li>
         <li>    
           <p>responseCode = 500, description = Generic server-side error<br>
           schema implementation = { @see Error }</p>
         </li>
         <li>    
           <p>responseCode = 200, description = Unexpected error<br>
           schema implementation = { @see Error }</p>
         </li>
       </ul>
    */
    @GET
    @Path("/{codImpianto}")
    
    @Produces({ "application/json", "application/problem+json" })
    Response getImpiantoByCodiceImpianto( @PathParam("codImpianto") BigDecimal codImpianto,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = 
     * description = 
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = OK<br>
           schema implementation = { @see ListaImpianti }</p>
         </li>
         <li>    
           <p>responseCode = 400, description = Bad Request<br>
           schema implementation = { @see Error }</p>
         </li>
         <li>    
           <p>responseCode = 401, description = Authentication information is missing or invalid<br>
           schema implementation = { @see Error }</p>
         </li>
         <li>    
           <p>responseCode = 403, description = User is forbidden to access the resource<br>
           schema implementation = { @see Error }</p>
         </li>
         <li>    
           <p>responseCode = 500, description = Generic server-side error<br>
           schema implementation = { @see Error }</p>
         </li>
         <li>    
           <p>responseCode = 200, description = Unexpected error<br>
           schema implementation = { @see Error }</p>
         </li>
       </ul>
    */
    @GET
    
    
    @Produces({ "application/json", "application/problem+json" })
    Response getImpiantoByIndirizzoImpianto( @NotNull @QueryParam("indirizzo") String indirizzo, @NotNull @QueryParam("istatComune") String istatComune, @QueryParam("civico") String civico,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = 
     * description = 
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = OK<br>
           schema implementation = { @see File }</p>
         </li>
         <li>    
           <p>responseCode = 400, description = Bad Request<br>
           schema implementation = { @see Error }</p>
         </li>
         <li>    
           <p>responseCode = 401, description = Authentication information is missing or invalid<br>
           schema implementation = { @see Error }</p>
         </li>
         <li>    
           <p>responseCode = 403, description = User is forbidden to access the resource<br>
           schema implementation = { @see Error }</p>
         </li>
         <li>    
           <p>responseCode = 500, description = Generic server-side error<br>
           schema implementation = { @see Error }</p>
         </li>
         <li>    
           <p>responseCode = 200, description = Unexpected error<br>
           schema implementation = { @see Error }</p>
         </li>
       </ul>
    */
    @GET
    @Path("/{codImpianto}/libretti")
    
    @Produces({ "application/pdf", "application/problem+json", "application/problem+pdf" })
    Response getLibrettoByCodiceImpianto( @PathParam("codImpianto") BigDecimal codImpianto,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
