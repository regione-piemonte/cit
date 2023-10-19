/**
 * Asl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.sigit.sigitweba.business.ws.service.svista.client;

public class Asl  implements java.io.Serializable {
    private java.lang.String codAsl;

    private java.lang.String nome;

    private java.lang.String nomeBreve;

    public Asl() {
    }

    public Asl(
           java.lang.String codAsl,
           java.lang.String nome,
           java.lang.String nomeBreve) {
           this.codAsl = codAsl;
           this.nome = nome;
           this.nomeBreve = nomeBreve;
    }


    /**
     * Gets the codAsl value for this Asl.
     * 
     * @return codAsl
     */
    public java.lang.String getCodAsl() {
        return codAsl;
    }


    /**
     * Sets the codAsl value for this Asl.
     * 
     * @param codAsl
     */
    public void setCodAsl(java.lang.String codAsl) {
        this.codAsl = codAsl;
    }


    /**
     * Gets the nome value for this Asl.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Asl.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the nomeBreve value for this Asl.
     * 
     * @return nomeBreve
     */
    public java.lang.String getNomeBreve() {
        return nomeBreve;
    }


    /**
     * Sets the nomeBreve value for this Asl.
     * 
     * @param nomeBreve
     */
    public void setNomeBreve(java.lang.String nomeBreve) {
        this.nomeBreve = nomeBreve;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Asl)) return false;
        Asl other = (Asl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codAsl==null && other.getCodAsl()==null) || 
             (this.codAsl!=null &&
              this.codAsl.equals(other.getCodAsl()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.nomeBreve==null && other.getNomeBreve()==null) || 
             (this.nomeBreve!=null &&
              this.nomeBreve.equals(other.getNomeBreve())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCodAsl() != null) {
            _hashCode += getCodAsl().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getNomeBreve() != null) {
            _hashCode += getNomeBreve().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Asl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("ente", "Asl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codAsl");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "codAsl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeBreve");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "nomeBreve"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
