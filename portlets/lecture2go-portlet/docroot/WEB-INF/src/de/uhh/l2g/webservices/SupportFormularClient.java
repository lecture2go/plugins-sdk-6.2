package de.uhh.l2g.webservices;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import de.uhh.l2g.wsdl.ELSuFPortType;
import de.uhh.l2g.wsdl.ELSuFServiceLocator;

public class SupportFormularClient {

	private String hash; 
	private String url; 
	private String get; 
	private String post;
	
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getGet() {
		return get;
	}

	public void setGet(String get) {
		this.get = get;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public SupportFormularClient(){};
	
	public SupportFormularClient(String hash, String url, String post, String get){
		this.hash=hash;
		this.url=url;
		this.get=get;
		this.post=post;
	}
	
	public String getFormular() {
		String rsf = null;
		ELSuFServiceLocator sl = new ELSuFServiceLocator();
		try {
			ELSuFPortType sfsd = sl.geteLSuFPort();
			rsf = sfsd.mailFormularJson(hash, url, post, get, "nodebug", "number","#F17B0D");
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return rsf;
	}
}
