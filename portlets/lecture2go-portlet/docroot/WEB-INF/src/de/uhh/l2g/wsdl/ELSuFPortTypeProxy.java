package de.uhh.l2g.wsdl;

public class ELSuFPortTypeProxy implements de.uhh.l2g.wsdl.ELSuFPortType {
  private String _endpoint = null;
  private de.uhh.l2g.wsdl.ELSuFPortType eLSuFPortType = null;
  
  public ELSuFPortTypeProxy() {
    _initELSuFPortTypeProxy();
  }
  
  public ELSuFPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initELSuFPortTypeProxy();
  }
  
  private void _initELSuFPortTypeProxy() {
    try {
      eLSuFPortType = (new de.uhh.l2g.wsdl.ELSuFServiceLocator()).geteLSuFPort();
      if (eLSuFPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)eLSuFPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)eLSuFPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (eLSuFPortType != null)
      ((javax.xml.rpc.Stub)eLSuFPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public de.uhh.l2g.wsdl.ELSuFPortType getELSuFPortType() {
    if (eLSuFPortType == null)
      _initELSuFPortTypeProxy();
    return eLSuFPortType;
  }
  
  public java.lang.String mailFormularJson(java.lang.String hash, java.lang.String url, java.lang.String post, java.lang.String get, java.lang.String mode, java.lang.String captcha, java.lang.String captchacolor) throws java.rmi.RemoteException{
    if (eLSuFPortType == null)
      _initELSuFPortTypeProxy();
    return eLSuFPortType.mailFormularJson(hash, url, post, get, mode, captcha, captchacolor);
  }
  
  
}