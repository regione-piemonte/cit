/**
 * LimammEnteSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.sigit.sigitweba.business.ws.service.svista.client;

public class LimammEnteSoapBindingStub extends org.apache.axis.client.Stub implements it.csi.sigit.sigitweba.business.ws.service.svista.client.LimammEnte_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[27];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaEstensioneComune");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaEstensioneComuneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaTuttiIComuni");
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Comune"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaTuttiIComuniReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComunePerCodiceIstat");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Comune"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComunePerCodiceIstatReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComuniPerIdProvincia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Comune"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComuniPerIdProvinciaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComuniPerCap");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Comune"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComuniPerCapReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComunePerCodiceBelfiore");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Comune"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComunePerCodiceBelfioreReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComunePerIdComune");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Comune"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComunePerIdComuneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComuniPerNome");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Comune"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComuniPerNomeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComuniPerNomeECodIstatProvincia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Comune"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComuniPerNomeECodIstatProvinciaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComuniPerNomeEIdProvincia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Comune"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComuniPerNomeEIdProvinciaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaTutteLeProvince");
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Provincia"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaTutteLeProvinceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaProvincePerIdRegione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Provincia"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaProvincePerIdRegioneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaProvinciaPerCodiceIstat");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Provincia"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaProvinciaPerCodiceIstatReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaProvinciaPerIdProvincia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Provincia"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaProvinciaPerIdProvinciaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaProvincePerNome");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Provincia"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaProvincePerNomeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaTutteLeRegioni");
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Regione"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaTutteLeRegioniReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaRegionePerIdRegione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Regione"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaRegionePerIdRegioneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaRegionePerCodIstat");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Regione"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaRegionePerCodIstatReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaRegioniPerNome");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Regione"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaRegioniPerNomeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaLocalitaPerIdComune");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Localita"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaLocalitaPerIdComuneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaLocalitaPerIdLocalita");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Localita"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaLocalitaPerIdLocalitaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaLocalitaPerNome");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", "Localita"));
        oper.setReturnClass(it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaLocalitaPerNomeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaGeometriaComune");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaGeometriaComuneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaEstensioneRegione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaEstensioneRegioneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaGeometriaRegione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaGeometriaRegioneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaEstensioneProvincia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaEstensioneProvinciaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaGeometriaProvincia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaGeometriaProvinciaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault2"),
                      "it.csi.svista.ws.service.svista.client.UnrecoverableException",
                      new javax.xml.namespace.QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault"),
                      "it.csi.svista.ws.service.svista.client.CSIException",
                      new javax.xml.namespace.QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault1"),
                      "it.csi.svista.ws.service.svista.client.SystemException",
                      new javax.xml.namespace.QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault5"),
                      "it.csi.svista.ws.service.svista.client.ParInputValNonCorrettoException",
                      new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault3"),
                      "it.csi.svista.ws.service.svista.client.OutputException",
                      new javax.xml.namespace.QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", "fault4"),
                      "it.csi.svista.ws.service.svista.client.ParInputObblMancantiException",
                      new javax.xml.namespace.QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[26] = oper;

    }

    public LimammEnteSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public LimammEnteSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public LimammEnteSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("ente", "ArrayOfAsl");
            cachedSerQNames.add(qName);
            cls = it.csi.sigit.sigitweba.business.ws.service.svista.client.Asl[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("ente", "Asl");
            qName2 = new javax.xml.namespace.QName("ente", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("ente", "Asl");
            cachedSerQNames.add(qName);
            cls = it.csi.sigit.sigitweba.business.ws.service.svista.client.Asl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", "Comune");
            cachedSerQNames.add(qName);
            cls = it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", "CSIException");
            cachedSerQNames.add(qName);
            cls = it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", "Localita");
            cachedSerQNames.add(qName);
            cls = it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", "OutputException");
            cachedSerQNames.add(qName);
            cls = it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", "ParInputObblMancantiException");
            cachedSerQNames.add(qName);
            cls = it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", "ParInputValNonCorrettoException");
            cachedSerQNames.add(qName);
            cls = it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", "Provincia");
            cachedSerQNames.add(qName);
            cls = it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", "Regione");
            cachedSerQNames.add(qName);
            cls = it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", "SystemException");
            cachedSerQNames.add(qName);
            cls = it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", "UnrecoverableException");
            cachedSerQNames.add(qName);
            cls = it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", "UserException");
            cachedSerQNames.add(qName);
            cls = it.csi.sigit.sigitweba.business.ws.service.svista.client.UserException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public java.lang.String cercaEstensioneComune(long in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaEstensioneComune"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(in0)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[] cercaTuttiIComuni() throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaTuttiIComuni"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune cercaComunePerCodiceIstat(java.lang.String in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComunePerCodiceIstat"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[] cercaComuniPerIdProvincia(java.lang.Long in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComuniPerIdProvincia"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[] cercaComuniPerCap(java.lang.String in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComuniPerCap"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune cercaComunePerCodiceBelfiore(java.lang.String in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComunePerCodiceBelfiore"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune cercaComunePerIdComune(java.lang.Long in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComunePerIdComune"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[] cercaComuniPerNome(java.lang.String in0, int in1) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComuniPerNome"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, new java.lang.Integer(in1)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[] cercaComuniPerNomeECodIstatProvincia(java.lang.String in0, int in1, java.lang.String in2) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComuniPerNomeECodIstatProvincia"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, new java.lang.Integer(in1), in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[] cercaComuniPerNomeEIdProvincia(java.lang.String in0, int in1, long in2) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComuniPerNomeEIdProvincia"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, new java.lang.Integer(in1), new java.lang.Long(in2)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[] cercaTutteLeProvince() throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaTutteLeProvince"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[] cercaProvincePerIdRegione(long in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaProvincePerIdRegione"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(in0)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia cercaProvinciaPerCodiceIstat(java.lang.String in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaProvinciaPerCodiceIstat"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia cercaProvinciaPerIdProvincia(java.lang.Long in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaProvinciaPerIdProvincia"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[] cercaProvincePerNome(java.lang.String in0, java.lang.Integer in1) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaProvincePerNome"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione[] cercaTutteLeRegioni() throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaTutteLeRegioni"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione cercaRegionePerIdRegione(java.lang.Long in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaRegionePerIdRegione"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione cercaRegionePerCodIstat(java.lang.String in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaRegionePerCodIstat"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione[] cercaRegioniPerNome(java.lang.String in0, int in1) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaRegioniPerNome"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, new java.lang.Integer(in1)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Regione[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita[] cercaLocalitaPerIdComune(java.lang.Long in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaLocalitaPerIdComune"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita cercaLocalitaPerIdLocalita(java.lang.Long in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaLocalitaPerIdLocalita"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita[] cercaLocalitaPerNome(java.lang.String in0, int in1) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaLocalitaPerNome"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, new java.lang.Integer(in1)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.sigit.sigitweba.business.ws.service.svista.client.Localita[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String cercaGeometriaComune(long in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaGeometriaComune"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(in0)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String cercaEstensioneRegione(long in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaEstensioneRegione"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(in0)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String cercaGeometriaRegione(long in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaGeometriaRegione"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(in0)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String cercaEstensioneProvincia(long in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaEstensioneProvincia"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(in0)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String cercaGeometriaProvincia(long in0) throws java.rmi.RemoteException, it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException, it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException, it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException, it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException, it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("ente", "cercaGeometriaProvincia"));
        _call.setTimeout(30000);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(in0)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.sigit.sigitweba.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
