/**
 * CSIException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.citpwa.business.ws.service.svista.client;

import it.csi.citpwa.util.Constants;

public class CSIException  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    private final java.lang.String nestedExcClassName;

    private final java.lang.String nestedExcMsg;

    private final java.lang.String stackTraceMessage;

    public CSIException(
           java.lang.String nestedExcClassName,
           java.lang.String nestedExcMsg,
           java.lang.String stackTraceMessage) {
        this.nestedExcClassName = nestedExcClassName;
        this.nestedExcMsg = nestedExcMsg;
        this.stackTraceMessage = stackTraceMessage;
    }


    /**
     * Gets the nestedExcClassName value for this CSIException.
     * 
     * @return nestedExcClassName
     */
    public java.lang.String getNestedExcClassName() {
        return nestedExcClassName;
    }

    /**
     * Gets the nestedExcMsg value for this CSIException.
     * 
     * @return nestedExcMsg
     */
    public java.lang.String getNestedExcMsg() {
        return nestedExcMsg;
    }

    /**
     * Gets the stackTraceMessage value for this CSIException.
     * 
     * @return stackTraceMessage
     */
    public java.lang.String getStackTraceMessage() {
        return stackTraceMessage;
    }

    private java.lang.Object equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof CSIException)) return false;
        CSIException other = (CSIException) obj;
        if (this == obj) return true;
        if (equalsCalc != null) {
            return (equalsCalc == obj);
        }
        equalsCalc = obj;
        boolean equals;
        equals = ((this.nestedExcClassName==null && other.getNestedExcClassName()==null) || 
             (this.nestedExcClassName!=null &&
              this.nestedExcClassName.equals(other.getNestedExcClassName()))) &&
            ((this.nestedExcMsg==null && other.getNestedExcMsg()==null) || 
             (this.nestedExcMsg!=null &&
              this.nestedExcMsg.equals(other.getNestedExcMsg()))) &&
            ((this.stackTraceMessage==null && other.getStackTraceMessage()==null) || 
             (this.stackTraceMessage!=null &&
              this.stackTraceMessage.equals(other.getStackTraceMessage())));
        equalsCalc = null;
        return equals;
    }

    private boolean hashCodeCalc = false;
    public synchronized int hashCode() {
        if (hashCodeCalc) {
            return 0;
        }
        hashCodeCalc = true;
        int hashCode = 1;
        if (getNestedExcClassName() != null) {
            hashCode += getNestedExcClassName().hashCode();
        }
        if (getNestedExcMsg() != null) {
            hashCode += getNestedExcMsg().hashCode();
        }
        if (getStackTraceMessage() != null) {
            hashCode += getStackTraceMessage().hashCode();
        }
        hashCodeCalc = false;
        return hashCode;
    }

    // Type metadata
    private static final org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CSIException.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("ente", "CSIException"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nestedExcClassName");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "nestedExcClassName"));
        elemField.setXmlType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nestedExcMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "nestedExcMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stackTraceMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "stackTraceMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class javaType,  
           javax.xml.namespace.QName xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            javaType, xmlType, typeDesc);
    } 

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class javaType,  
           javax.xml.namespace.QName xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            javaType, xmlType, typeDesc);
    }


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
