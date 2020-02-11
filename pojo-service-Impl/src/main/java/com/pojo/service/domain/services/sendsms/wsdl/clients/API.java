/**
 * API.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pojo.service.domain.services.sendsms.wsdl.clients;

public interface API extends javax.xml.rpc.Service {
    public java.lang.String getAPISoapAddress();

    public com.pojo.service.domain.services.sendsms.wsdl.clients.APISoap_PortType getAPISoap() throws javax.xml.rpc.ServiceException;

    public com.pojo.service.domain.services.sendsms.wsdl.clients.APISoap_PortType getAPISoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
