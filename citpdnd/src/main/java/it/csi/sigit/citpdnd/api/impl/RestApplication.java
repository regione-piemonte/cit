package it.csi.sigit.citpdnd.api.impl;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.ext.Provider;

@ApplicationPath("/citpdnd/api/v1")
@Provider
public class RestApplication extends Application{
    
}