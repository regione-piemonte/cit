/**
 * LimammEnteSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.citpwa.business.ws.service.svista.client;

import it.csi.citpwa.util.Constants;

public class LimammEnteSoapBindingStub extends org.apache.axis.client.Stub implements it.csi.citpwa.business.ws.service.svista.client.LimammEntePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache. axis.description.OperationDesc [] operations;

    static {
        operations = new org.apache.axis.description.OperationDesc[27];
        initOperationDesc1();
        initOperationDesc2();
        initOperationDesc3();
    }

    private static void initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaEstensioneComune");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaEstensioneComuneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaTuttiIComuni");
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_COMUNE));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Comune[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaTuttiIComuniReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComunePerCodiceIstat");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_COMUNE));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Comune.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComunePerCodiceIstatReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComuniPerIdProvincia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_COMUNE));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Comune[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComuniPerIdProvinciaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComuniPerCap");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_COMUNE));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Comune[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComuniPerCapReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComunePerCodiceBelfiore");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_COMUNE));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Comune.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComunePerCodiceBelfioreReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComunePerIdComune");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_COMUNE));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Comune.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComunePerIdComuneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComuniPerNome");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_COMUNE));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Comune[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComuniPerNomeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComuniPerNomeECodIstatProvincia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_COMUNE));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Comune[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComuniPerNomeECodIstatProvinciaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaComuniPerNomeEIdProvincia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_COMUNE));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Comune[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaComuniPerNomeEIdProvinciaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[9] = oper;

    }

    private static void initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaTutteLeProvince");
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_PROVINCIA));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Provincia[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaTutteLeProvinceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaProvincePerIdRegione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_PROVINCIA));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Provincia[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaProvincePerIdRegioneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaProvinciaPerCodiceIstat");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_PROVINCIA));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Provincia.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaProvinciaPerCodiceIstatReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaProvinciaPerIdProvincia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_PROVINCIA));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Provincia.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaProvinciaPerIdProvinciaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaProvincePerNome");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_PROVINCIA));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Provincia[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaProvincePerNomeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaTutteLeRegioni");
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_REGIONE));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Regione[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaTutteLeRegioniReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaRegionePerIdRegione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_REGIONE));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Regione.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaRegionePerIdRegioneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaRegionePerCodIstat");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_REGIONE));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Regione.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaRegionePerCodIstatReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaRegioniPerNome");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_REGIONE));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Regione[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaRegioniPerNomeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaLocalitaPerIdComune");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_LOCALITA));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Localita[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaLocalitaPerIdComuneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[19] = oper;

    }

    private static void initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaLocalitaPerIdLocalita");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_LOCALITA));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Localita.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaLocalitaPerIdLocalitaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaLocalitaPerNome");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_LOCALITA));
        oper.setReturnClass(it.csi.citpwa.business.ws.service.svista.client.Localita[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaLocalitaPerNomeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaGeometriaComune");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaGeometriaComuneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaEstensioneRegione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaEstensioneRegioneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaGeometriaRegione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaGeometriaRegioneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaEstensioneProvincia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaEstensioneProvinciaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cercaGeometriaProvincia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("ente", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("ente", "cercaGeometriaProvinciaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT2),
                      Constants.SVISTA_SERVICE_UNRECOVERABLE_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT),
                      Constants.SVISTA_SERVICE_CSI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT1),
                      Constants.SVISTA_SERVICE_SYSTEM_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT5),
                      Constants.SVISTA_SERVICE_PAR_INPUT_NON_CORRETTO_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT3),
                      Constants.SVISTA_SERVICE_OUTPUT_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("ente", Constants.FAULT4),
                      Constants.SVISTA_SERVICE_PAR_INPUT_OBBL_MANCANTI_EXCEPTION,
                      new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION), 
                      true
                     ));
        operations[26] = oper;

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

            qName = new javax.xml.namespace.QName("ente", "ArrayOfAsl");
            cachedSerQNames.add(qName);
            cls = it.csi.citpwa.business.ws.service.svista.client.Asl[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("ente", "Asl");
            qName2 = new javax.xml.namespace.QName("ente", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("ente", "Asl");
            cachedSerQNames.add(qName);
            cls = it.csi.citpwa.business.ws.service.svista.client.Asl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_COMUNE);
            cachedSerQNames.add(qName);
            cls = it.csi.citpwa.business.ws.service.svista.client.Comune.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_CSI_EXCEPTION);
            cachedSerQNames.add(qName);
            cls = it.csi.citpwa.business.ws.service.svista.client.CSIException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_LOCALITA);
            cachedSerQNames.add(qName);
            cls = it.csi.citpwa.business.ws.service.svista.client.Localita.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_OUTPUT_EXCEPTION);
            cachedSerQNames.add(qName);
            cls = it.csi.citpwa.business.ws.service.svista.client.OutputException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_OBBL_MANCANTI_EXCEPTION);
            cachedSerQNames.add(qName);
            cls = it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_PAR_INPUT_NON_CORRETTO_EXCEPTION);
            cachedSerQNames.add(qName);
            cls = it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_PROVINCIA);
            cachedSerQNames.add(qName);
            cls = it.csi.citpwa.business.ws.service.svista.client.Provincia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", Constants.LIMAMM_ENTE_PARAM_REGIONE);
            cachedSerQNames.add(qName);
            cls = it.csi.citpwa.business.ws.service.svista.client.Regione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_SYSTEM_EXCEPTION);
            cachedSerQNames.add(qName);
            cls = it.csi.citpwa.business.ws.service.svista.client.SystemException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", Constants.SVISTA_SERVICE_PARAM_UNRECOVERABLE_EXCEPTION);
            cachedSerQNames.add(qName);
            cls = it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("ente", "UserException");
            cachedSerQNames.add(qName);
            cls = it.csi.citpwa.business.ws.service.svista.client.UserException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call call = super._createCall();
            if (super.maintainSessionSet) {
                call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    call.setEncodingStyle(null);
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
                            call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return call;
        }
        catch (java.lang.Throwable t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", t);
        }
    }

    public java.lang.String cercaEstensioneComune(long in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[0]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaEstensioneComune"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {Long.valueOf(in0)});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (java.lang.String) resp;
            } catch (java.lang.Exception exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Comune[] cercaTuttiIComuni() throws java.rmi.RemoteException{
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[1]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaTuttiIComuni"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune[]) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune[]) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Comune[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Comune cercaComunePerCodiceIstat(java.lang.String in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[2]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComunePerCodiceIstat"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Comune.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Comune[] cercaComuniPerIdProvincia(java.lang.Long in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[3]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComuniPerIdProvincia"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune[]) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune[]) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Comune[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Comune[] cercaComuniPerCap(java.lang.String in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[4]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComuniPerCap"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune[]) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune[]) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Comune[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Comune cercaComunePerCodiceBelfiore(java.lang.String in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[5]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComunePerCodiceBelfiore"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Comune.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Comune cercaComunePerIdComune(java.lang.Long in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[6]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComunePerIdComune"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Comune.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Comune[] cercaComuniPerNome(java.lang.String in0, int in1) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[7]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComuniPerNome"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0, Integer.valueOf(in1)});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune[]) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune[]) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Comune[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Comune[] cercaComuniPerNomeECodIstatProvincia(java.lang.String in0, int in1, java.lang.String in2) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[8]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComuniPerNomeECodIstatProvincia"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0, Integer.valueOf(in1), in2});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune[]) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune[]) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Comune[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Comune[] cercaComuniPerNomeEIdProvincia(java.lang.String in0, int in1, long in2) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[9]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaComuniPerNomeEIdProvincia"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0, Integer.valueOf(in1), Long.valueOf(in2)});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune[]) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Comune[]) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Comune[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Provincia[] cercaTutteLeProvince() throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[10]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaTutteLeProvince"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Provincia[]) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Provincia[]) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Provincia[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Provincia[] cercaProvincePerIdRegione(long in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[11]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaProvincePerIdRegione"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {Long.valueOf(in0)});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Provincia[]) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Provincia[]) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Provincia[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Provincia cercaProvinciaPerCodiceIstat(java.lang.String in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[12]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaProvinciaPerCodiceIstat"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Provincia) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Provincia) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Provincia.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Provincia cercaProvinciaPerIdProvincia(java.lang.Long in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[13]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaProvinciaPerIdProvincia"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Provincia) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Provincia) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Provincia.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Provincia[] cercaProvincePerNome(java.lang.String in0, java.lang.Integer in1) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[14]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaProvincePerNome"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0, in1});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Provincia[]) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Provincia[]) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Provincia[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Regione[] cercaTutteLeRegioni() throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[15]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaTutteLeRegioni"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Regione[]) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Regione[]) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Regione[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Regione cercaRegionePerIdRegione(java.lang.Long in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[16]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaRegionePerIdRegione"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Regione) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Regione) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Regione.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Regione cercaRegionePerCodIstat(java.lang.String in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[17]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaRegionePerCodIstat"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Regione) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Regione) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Regione.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Regione[] cercaRegioniPerNome(java.lang.String in0, int in1) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[18]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaRegioniPerNome"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0, Integer.valueOf(in1)});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Regione[]) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Regione[]) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Regione[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Localita[] cercaLocalitaPerIdComune(java.lang.Long in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[19]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaLocalitaPerIdComune"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Localita[]) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Localita[]) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Localita[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Localita cercaLocalitaPerIdLocalita(java.lang.Long in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[20]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaLocalitaPerIdLocalita"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Localita) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Localita) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Localita.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.citpwa.business.ws.service.svista.client.Localita[] cercaLocalitaPerNome(java.lang.String in0, int in1) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[21]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaLocalitaPerNome"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {in0, Integer.valueOf(in1)});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (it.csi.citpwa.business.ws.service.svista.client.Localita[]) resp;
            } catch (java.lang.Exception exception) {
                return (it.csi.citpwa.business.ws.service.svista.client.Localita[]) org.apache.axis.utils.JavaUtils.convert(resp, it.csi.citpwa.business.ws.service.svista.client.Localita[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String cercaGeometriaComune(long in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[22]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaGeometriaComune"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {Long.valueOf(in0)});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (java.lang.String) resp;
            } catch (java.lang.Exception exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String cercaEstensioneRegione(long in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[23]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaEstensioneRegione"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {Long.valueOf(in0)});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (java.lang.String) resp;
            } catch (java.lang.Exception exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String cercaGeometriaRegione(long in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[24]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaGeometriaRegione"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {Long.valueOf(in0)});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (java.lang.String) resp;
            } catch (java.lang.Exception exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String cercaEstensioneProvincia(long in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[25]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaEstensioneProvincia"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {Long.valueOf(in0)});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (java.lang.String) resp;
            } catch (java.lang.Exception exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String cercaGeometriaProvincia(long in0) throws java.rmi.RemoteException { 
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call call = createCall();
        call.setOperation(operations[26]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("ente", "cercaGeometriaProvincia"));
        call.setTimeout(30000);

        setRequestHeaders(call);
        setAttachments(call);
 try {        java.lang.Object resp = call.invoke(new java.lang.Object[] {Long.valueOf(in0)});

        if (resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)resp;
        }
        else {
            extractAttachments(call);
            try {
                return (java.lang.String) resp;
            } catch (java.lang.Exception exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.CSIException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.SystemException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.OutputException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) {
              throw (it.csi.citpwa.business.ws.service.svista.client.ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
