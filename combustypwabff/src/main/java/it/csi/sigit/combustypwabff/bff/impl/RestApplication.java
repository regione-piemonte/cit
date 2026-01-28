package it.csi.sigit.combustypwabff.bff.impl;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.ext.Provider;

@ApplicationPath("/combustypwabff/restfacade/be")
@Provider
public class RestApplication extends Application{
    
}