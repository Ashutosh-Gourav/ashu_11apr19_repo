/**
 * Sent_STR_ZIPResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pojo.service.domain.services.sendsms.wsdl.clients;

public class Sent_STR_ZIPResponse  implements java.io.Serializable {
    private byte[] sent_STR_ZIPResult;

    public Sent_STR_ZIPResponse() {
    }

    public Sent_STR_ZIPResponse(
           byte[] sent_STR_ZIPResult) {
           this.sent_STR_ZIPResult = sent_STR_ZIPResult;
    }


    /**
     * Gets the sent_STR_ZIPResult value for this Sent_STR_ZIPResponse.
     * 
     * @return sent_STR_ZIPResult
     */
    public byte[] getSent_STR_ZIPResult() {
        return sent_STR_ZIPResult;
    }


    /**
     * Sets the sent_STR_ZIPResult value for this Sent_STR_ZIPResponse.
     * 
     * @param sent_STR_ZIPResult
     */
    public void setSent_STR_ZIPResult(byte[] sent_STR_ZIPResult) {
        this.sent_STR_ZIPResult = sent_STR_ZIPResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sent_STR_ZIPResponse)) return false;
        Sent_STR_ZIPResponse other = (Sent_STR_ZIPResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sent_STR_ZIPResult==null && other.getSent_STR_ZIPResult()==null) || 
             (this.sent_STR_ZIPResult!=null &&
              java.util.Arrays.equals(this.sent_STR_ZIPResult, other.getSent_STR_ZIPResult())));
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
        if (getSent_STR_ZIPResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSent_STR_ZIPResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSent_STR_ZIPResult(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Sent_STR_ZIPResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.mymobileapi.com/api5", ">Sent_STR_ZIPResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sent_STR_ZIPResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.mymobileapi.com/api5", "Sent_STR_ZIPResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
