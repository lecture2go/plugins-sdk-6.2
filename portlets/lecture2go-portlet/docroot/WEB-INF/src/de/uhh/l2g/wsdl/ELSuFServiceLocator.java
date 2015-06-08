/**
 * ELSuFServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.uhh.l2g.wsdl;

public class ELSuFServiceLocator extends org.apache.axis.client.Service implements de.uhh.l2g.wsdl.ELSuFService {

    public ELSuFServiceLocator() {
    }


    public ELSuFServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ELSuFServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for eLSuFPort
    private java.lang.String eLSuFPort_address = "http://elearning-supportformular.rrz.uni-hamburg.de/soap.php";

    public java.lang.String geteLSuFPortAddress() {
        return eLSuFPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String eLSuFPortWSDDServiceName = "eLSuFPort";

    public java.lang.String geteLSuFPortWSDDServiceName() {
        return eLSuFPortWSDDServiceName;
    }

    public void seteLSuFPortWSDDServiceName(java.lang.String name) {
        eLSuFPortWSDDServiceName = name;
    }

    public de.uhh.l2g.wsdl.ELSuFPortType geteLSuFPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(eLSuFPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return geteLSuFPort(endpoint);
    }

    public de.uhh.l2g.wsdl.ELSuFPortType geteLSuFPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	de.uhh.l2g.wsdl.ELSuFBindingStub _stub = new de.uhh.l2g.wsdl.ELSuFBindingStub(portAddress, this);
            _stub.setPortName(geteLSuFPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void seteLSuFPortEndpointAddress(java.lang.String address) {
        eLSuFPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (de.uhh.l2g.wsdl.ELSuFPortType.class.isAssignableFrom(serviceEndpointInterface)) {
            	de.uhh.l2g.wsdl.ELSuFBindingStub _stub = new de.uhh.l2g.wsdl.ELSuFBindingStub(new java.net.URL(eLSuFPort_address), this);
                _stub.setPortName(geteLSuFPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("eLSuFPort".equals(inputPortName)) {
            return geteLSuFPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://elearning-supportformular.rrz.uni-hamburg.de/wsdl.php", "eLSuFService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://elearning-supportformular.rrz.uni-hamburg.de/wsdl.php", "eLSuFPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("eLSuFPort".equals(portName)) {
            seteLSuFPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
