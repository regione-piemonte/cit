/**
 * Comune.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.citpwa.business.ws.service.svista.client;

import javax.xml.namespace.QName;

import it.csi.citpwa.util.Constants;

public class Comune  implements java.io.Serializable {
    private it.csi.citpwa.business.ws.service.svista.client.Asl[] aslDiRiferimento;

    private java.lang.String cap;

    private java.lang.String codCatasto;

    private java.lang.String codIstat;

    private long id;

    private long idProvincia;

    private java.lang.String nome;

    public Comune() {
    }

    public Comune(
           it.csi.citpwa.business.ws.service.svista.client.Asl[] aslDiRiferimento,
           java.lang.String cap,
           java.lang.String codCatasto,
           java.lang.String codIstat,
           long id,
           long idProvincia,
           java.lang.String nome) {
           this.aslDiRiferimento = aslDiRiferimento;
           this.cap = cap;
           this.codCatasto = codCatasto;
           this.codIstat = codIstat;
           this.id = id;
           this.idProvincia = idProvincia;
           this.nome = nome;
    }


    /**
     * Gets the aslDiRiferimento value for this Comune.
     * 
     * @return aslDiRiferimento
     */
    public it.csi.citpwa.business.ws.service.svista.client.Asl[] getAslDiRiferimento() {
        return aslDiRiferimento;
    }


    /**
     * Sets the aslDiRiferimento value for this Comune.
     * 
     * @param aslDiRiferimento
     */
    public void setAslDiRiferimento(it.csi.citpwa.business.ws.service.svista.client.Asl[] aslDiRiferimento) {
        this.aslDiRiferimento = aslDiRiferimento;
    }


    /**
     * Gets the cap value for this Comune.
     * 
     * @return cap
     */
    public java.lang.String getCap() {
        return cap;
    }


    /**
     * Sets the cap value for this Comune.
     * 
     * @param cap
     */
    public void setCap(java.lang.String cap) {
        this.cap = cap;
    }


    /**
     * Gets the codCatasto value for this Comune.
     * 
     * @return codCatasto
     */
    public java.lang.String getCodCatasto() {
        return codCatasto;
    }


    /**
     * Sets the codCatasto value for this Comune.
     * 
     * @param codCatasto
     */
    public void setCodCatasto(java.lang.String codCatasto) {
        this.codCatasto = codCatasto;
    }


    /**
     * Gets the codIstat value for this Comune.
     * 
     * @return codIstat
     */
    public java.lang.String getCodIstat() {
        return codIstat;
    }


    /**
     * Sets the codIstat value for this Comune.
     * 
     * @param codIstat
     */
    public void setCodIstat(java.lang.String codIstat) {
        this.codIstat = codIstat;
    }


    /**
     * Gets the id value for this Comune.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this Comune.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the idProvincia value for this Comune.
     * 
     * @return idProvincia
     */
    public long getIdProvincia() {
        return idProvincia;
    }


    /**
     * Sets the idProvincia value for this Comune.
     * 
     * @param idProvincia
     */
    public void setIdProvincia(long idProvincia) {
        this.idProvincia = idProvincia;
    }


    /**
     * Gets the nome value for this Comune.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Comune.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    private java.lang.Object equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Comune)) return false;
        Comune other = (Comune) obj;
        if (this == obj) return true;
        if (equalsCalc != null) {
            return (equalsCalc == obj);
        }
        equalsCalc = obj;
        boolean equals;
        equals = ((this.aslDiRiferimento==null && other.getAslDiRiferimento()==null) || 
             (this.aslDiRiferimento!=null &&
              java.util.Arrays.equals(this.aslDiRiferimento, other.getAslDiRiferimento()))) &&
            ((this.cap==null && other.getCap()==null) || 
             (this.cap!=null &&
              this.cap.equals(other.getCap()))) &&
            ((this.codCatasto==null && other.getCodCatasto()==null) || 
             (this.codCatasto!=null &&
              this.codCatasto.equals(other.getCodCatasto()))) &&
            ((this.codIstat==null && other.getCodIstat()==null) || 
             (this.codIstat!=null &&
              this.codIstat.equals(other.getCodIstat()))) &&
            this.id == other.getId() &&
            this.idProvincia == other.getIdProvincia() &&
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
        if (getAslDiRiferimento() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAslDiRiferimento());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAslDiRiferimento(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    hashCode += obj.hashCode();
                }
            }
        }
        if (getCap() != null) {
            hashCode += getCap().hashCode();
        }
        if (getCodCatasto() != null) {
            hashCode += getCodCatasto().hashCode();
        }
        if (getCodIstat() != null) {
            hashCode += getCodIstat().hashCode();
        }
        hashCode += Long.valueOf(getId()).hashCode();
        hashCode += Long.valueOf(getIdProvincia()).hashCode();
        if (getNome() != null) {
            hashCode += getNome().hashCode();
        }
        hashCodeCalc = false;
        return hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Comune.class, true);

    static {
        typeDesc.setXmlType(new QName("ente", "Comune"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aslDiRiferimento");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "aslDiRiferimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("ente", "Asl"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("ente", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cap");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "cap"));
        elemField.setXmlType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codCatasto");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "codCatasto"));
        elemField.setXmlType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, Constants.TYPE_STRING));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("idProvincia");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "idProvincia"));
        elemField.setXmlType(new javax.xml.namespace.QName(Constants.XML_SCHEMA, "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("ente", "nome"));
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
