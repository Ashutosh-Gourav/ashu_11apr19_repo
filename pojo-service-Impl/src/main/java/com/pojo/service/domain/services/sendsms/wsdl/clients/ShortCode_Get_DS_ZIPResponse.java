/**
 * ShortCode_Get_DS_ZIPResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pojo.service.domain.services.sendsms.wsdl.clients;

public class ShortCode_Get_DS_ZIPResponse  implements java.io.Serializable {
    private byte[] shortCode_Get_DS_ZIPResult;

    public ShortCode_Get_DS_ZIPResponse() {
    }

    public ShortCode_Get_DS_ZIPResponse(
           byte[] shortCode_Get_DS_ZIPResult) {
           this.shortCode_Get_DS_ZIPResult = shortCode_Get_DS_ZIPResult;
    }


    /**
     * Gets the shortCode_Get_DS_ZIPResult value for this ShortCode_Get_DS_ZIPResponse.
     * 
     * @return shortCode_Get_DS_ZIPResult
     */
    public byte[] getShortCode_Get_DS_ZIPResult() {
        return shortCode_Get_DS_ZIPResult;
    }


    /**
     * Sets the shortCode_Get_DS_ZIPResult value for this ShortCode_Get_DS_ZIPResponse.
     * 
     * @param shortCode_Get_DS_ZIPResult
     */
    public void setShortCode_Get_DS_ZIPResult(byte[] shortCode_Get_DS_ZIPResult) {
        this.shortCode_Get_DS_ZIPResult = shortCode_Get_DS_ZIPResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ShortCode_Get_DS_ZIPResponse)) return false;
        ShortCode_Get_DS_ZIPResponse other = (ShortCode_Get_DS_ZIPResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.shortCode_Get_DS_ZIPResult==null && other.getShortCode_Get_DS_ZIPResult()==null) || 
             (this.shortCode_Get_DS_ZIPResult!=null &&
              java.util.Arrays.equals(this.shortCode_Get_DS_ZIPResult, other.getShortCode_Get_DS_ZIPResult())));
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
        if (getShortCode_Get_DS_ZIPResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getShortCode_Get_DS_ZIPResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getShortCode_Get_DS_ZIPResult(), i);
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
        new org.apache.axis.description.TypeDesc(ShortCode_Get_DS_ZIPResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.mymobileapi.com/api5", ">ShortCode_Get_DS_ZIPResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shortCode_Get_DS_ZIPResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.mymobileapi.com/api5", "ShortCode_Get_DS_ZIPResult"));
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
