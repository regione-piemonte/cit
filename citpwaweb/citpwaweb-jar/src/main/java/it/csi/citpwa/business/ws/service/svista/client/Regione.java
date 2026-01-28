/**
 * Regione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.citpwa.business.ws.service.svista.client;

import it.csi.citpwa.util.Constants;

public class Regione  implements java.io.Serializable {
    private java.lang.String codIstat;

    private long id;

    private java.lang.String nome;

    private java.lang.String sigla;

    public Regione() {
    }

    public Regione(
           java.lang.String codIstat,
           long id,
           java.lang.String nome,
           java.lang.String sigla) {
           this.codIstat = codIstat;
           this.id = id;
           this.nome = nome;
           this.sigla = sigla;
    }


    /**
     * Gets the codIstat value for this Regione.
     * 
     * @return codIstat
     */
    public java.lang.String getCodIstat() {
        return codIstat;
    }


    /**
     * Sets the codIstat value for this Regione.
     * 
     * @param codIstat
     */
    public void setCodIstat(java.lang.String codIstat) {
        this.codIstat = codIstat;
    }


    /**
     * Gets the id value for this Regione.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this Regione.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the nome value for this Regione.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Regione.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the sigla value for this Regione.
     * 
     * @return sigla
     */
    public java.lang.String getSigla() {
        return sigla;
    }


    /**
     * Sets the sigla value for this Regione.
     * 
     * @param sigla
     */
    public void setSigla(java.lang.String sigla) {
        this.sigla = sigla;
    }

    private java.lang.Object equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Regione)) return false;
        Regione other = (Regione) obj;
        if (this == obj) return true;
        if (equalsCalc != null) {
            return (equalsCalc == obj);
        }
        equalsCalc = obj;
        boolean equals;
        equals = ((this.codIstat==null && other.getCodIstat()==null) || 
             (this.codIstat!=null &&
              this.codIstat.equals(other.getCodIstat()))) &&
            this.id == other.getId() &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.sigla==null && other.getSigla()==null) || 
             (this.sigla!=null &&
              this.sigla.equals(other.getSigla())));
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
        if (getCodIstat() != null) {
            hashCode += getCodIstat().hashCode();
        }
        hashCode += Long.valueOf(getId()).hashCode();
        if (getNome() != null) {
            hashCode += getNome().hashCode();
        }
        if (getSigla() != null) {
            hashCode += getSigla().hashCode();
        }
        hashCodeCalc = false;
        return hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Regione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("ente", "Regione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codIstat");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "codIstat"));
        elemField.setXmlType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sigla");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "sigla"));
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

}
