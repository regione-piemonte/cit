/**
 * LimammEnteServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.citpwa.business.ws.service.svista.client;

import it.csi.citpwa.util.Constants;

public class LimammEnteServiceLocator extends org.apache.axis.client.Service implements it.csi.citpwa.business.ws.service.svista.client.LimammEnteService {

    public LimammEnteServiceLocator() {
    }


    public LimammEnteServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LimammEnteServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for limammEnte
    private java.lang.String limammEnteAddress = "http://tst-applogic.reteunitaria.piemonte.it/limammApplEnteWsfad/services/limammEnte";

    public java.lang.String getlimammEnteAddress() {
        return limammEnteAddress;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String limammEnteWSDDServiceName = Constants.LIMAMM_ENTE;

    public java.lang.String getlimammEnteWSDDServiceName() {
        return limammEnteWSDDServiceName;
    }

    public void setlimammEnteWSDDServiceName(java.lang.String name) {
        limammEnteWSDDServiceName = name;
    }

    public it.csi.citpwa.business.ws.service.svista.client.LimammEntePortType getlimammEnte() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(limammEnteAddress);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getlimammEnte(endpoint);
    }

    public it.csi.citpwa.business.ws.service.svista.client.LimammEntePortType getlimammEnte(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	it.csi.citpwa.business.ws.service.svista.client.LimammEnteSoapBindingStub stub = new it.csi.citpwa.business.ws.service.svista.client.LimammEnteSoapBindingStub(portAddress, this);
            stub.setPortName(getlimammEnteWSDDServiceName());
            return stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setlimammEnteEndpointAddress(java.lang.String address) {
        limammEnteAddress = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (it.csi.citpwa.business.ws.service.svista.client.LimammEntePortType.class.isAssignableFrom(serviceEndpointInterface)) {
            	it.csi.citpwa.business.ws.service.svista.client.LimammEnteSoapBindingStub stub = new it.csi.citpwa.business.ws.service.svista.client.LimammEnteSoapBindingStub(new java.net.URL(limammEnteAddress), this);
                stub.setPortName(getlimammEnteWSDDServiceName());
                return stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if (Constants.LIMAMM_ENTE.equals(inputPortName)) {
            return getlimammEnte();
        }
        else  {
            java.rmi.Remote stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) stub).setPortName(portName);
            return stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("ente", "limammEnteService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if (Constants.LIMAMM_ENTE.equals(portName)) {
            setlimammEnteEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
