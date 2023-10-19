/**
 * LimammEnteServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.citpwa.business.ws.service.svista.client;

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
    private java.lang.String limammEnte_address = "http://tst-applogic.reteunitaria.piemonte.it/limammApplEnteWsfad/services/limammEnte";

    public java.lang.String getlimammEnteAddress() {
        return limammEnte_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String limammEnteWSDDServiceName = "limammEnte";

    public java.lang.String getlimammEnteWSDDServiceName() {
        return limammEnteWSDDServiceName;
    }

    public void setlimammEnteWSDDServiceName(java.lang.String name) {
        limammEnteWSDDServiceName = name;
    }

    public it.csi.citpwa.business.ws.service.svista.client.LimammEnte_PortType getlimammEnte() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(limammEnte_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getlimammEnte(endpoint);
    }

    public it.csi.citpwa.business.ws.service.svista.client.LimammEnte_PortType getlimammEnte(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	it.csi.citpwa.business.ws.service.svista.client.LimammEnteSoapBindingStub _stub = new it.csi.citpwa.business.ws.service.svista.client.LimammEnteSoapBindingStub(portAddress, this);
            _stub.setPortName(getlimammEnteWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setlimammEnteEndpointAddress(java.lang.String address) {
        limammEnte_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (it.csi.citpwa.business.ws.service.svista.client.LimammEnte_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
            	it.csi.citpwa.business.ws.service.svista.client.LimammEnteSoapBindingStub _stub = new it.csi.citpwa.business.ws.service.svista.client.LimammEnteSoapBindingStub(new java.net.URL(limammEnte_address), this);
                _stub.setPortName(getlimammEnteWSDDServiceName());
                return _stub;
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
        if ("limammEnte".equals(inputPortName)) {
            return getlimammEnte();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("ente", "limammEnteService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("ente", "limammEnte"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("limammEnte".equals(portName)) {
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
