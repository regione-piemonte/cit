/**
 * Localita.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.citpwa.business.ws.service.svista.client;

import it.csi.citpwa.util.Constants;

public class Localita  implements java.io.Serializable {
    private long id;

    private java.lang.Long idComune;

    private java.lang.String nome;

    public Localita() {
    }

    public Localita(
           long id,
           java.lang.Long idComune,
           java.lang.String nome) {
           this.id = id;
           this.idComune = idComune;
           this.nome = nome;
    }


    /**
     * Gets the id value for this Localita.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this Localita.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the idComune value for this Localita.
     * 
     * @return idComune
     */
    public java.lang.Long getIdComune() {
        return idComune;
    }


    /**
     * Sets the idComune value for this Localita.
     * 
     * @param idComune
     */
    public void setIdComune(java.lang.Long idComune) {
        this.idComune = idComune;
    }


    /**
     * Gets the nome value for this Localita.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Localita.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    private java.lang.Object equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Localita)) return false;
        Localita other = (Localita) obj;
        if (this == obj) return true;
        if (equalsCalc != null) {
            return (equalsCalc == obj);
        }
        equalsCalc = obj;
        boolean equals;
        equals = this.id == other.getId() &&
            ((this.idComune==null && other.getIdComune()==null) || 
             (this.idComune!=null &&
              this.idComune.equals(other.getIdComune()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome())));
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
        hashCode += Long.valueOf(getId()).hashCode();
        if (getIdComune() != null) {
            hashCode += getIdComune().hashCode();
        }
        if (getNome() != null) {
            hashCode += getNome().hashCode();
        }
        hashCodeCalc = false;
        return hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Localita.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("ente", "Localita"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idComune");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "idComune"));
        elemField.setXmlType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, "string"));
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

}
