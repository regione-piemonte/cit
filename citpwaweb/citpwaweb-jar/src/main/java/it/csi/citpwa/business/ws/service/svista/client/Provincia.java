/**
 * Provincia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.citpwa.business.ws.service.svista.client;

import it.csi.citpwa.util.Constants;

public class Provincia  implements java.io.Serializable {
    private java.lang.String codIstat;

    private long id;

    private java.lang.Long idRegione;

    private java.lang.String nome;

    private java.lang.String sigla;

    public Provincia() {
    }

    public Provincia(
           java.lang.String codIstat,
           long id,
           java.lang.Long idRegione,
           java.lang.String nome,
           java.lang.String sigla) {
           this.codIstat = codIstat;
           this.id = id;
           this.idRegione = idRegione;
           this.nome = nome;
           this.sigla = sigla;
    }


    /**
     * Gets the codIstat value for this Provincia.
     * 
     * @return codIstat
     */
    public java.lang.String getCodIstat() {
        return codIstat;
    }


    /**
     * Sets the codIstat value for this Provincia.
     * 
     * @param codIstat
     */
    public void setCodIstat(java.lang.String codIstat) {
        this.codIstat = codIstat;
    }


    /**
     * Gets the id value for this Provincia.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this Provincia.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the idRegione value for this Provincia.
     * 
     * @return idRegione
     */
    public java.lang.Long getIdRegione() {
        return idRegione;
    }


    /**
     * Sets the idRegione value for this Provincia.
     * 
     * @param idRegione
     */
    public void setIdRegione(java.lang.Long idRegione) {
        this.idRegione = idRegione;
    }


    /**
     * Gets the nome value for this Provincia.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Provincia.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the sigla value for this Provincia.
     * 
     * @return sigla
     */
    public java.lang.String getSigla() {
        return sigla;
    }


    /**
     * Sets the sigla value for this Provincia.
     * 
     * @param sigla
     */
    public void setSigla(java.lang.String sigla) {
        this.sigla = sigla;
    }

    private java.lang.Object equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Provincia)) return false;
        Provincia other = (Provincia) obj;
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
            ((this.idRegione==null && other.getIdRegione()==null) || 
             (this.idRegione!=null &&
              this.idRegione.equals(other.getIdRegione()))) &&
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
        if (getIdRegione() != null) {
            hashCode += getIdRegione().hashCode();
        }
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
        new org.apache.axis.description.TypeDesc(Provincia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("ente", "Provincia"));
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
        elemField.setFieldName("idRegione");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "idRegione"));
        elemField.setXmlType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"));
        elemField.setNillable(true);
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
